package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HotSearchAdapter extends BaseAdapter implements MiniAppSearchDataManager.HotSearchDataChangedListener {
    private static final String TAG = "HotSearchAdapter";
    private List<ItemInfo> appList = new ArrayList();
    private WeakReference<Activity> mActivityReference;
    private TextView mHotTitleView;
    private int mRefer;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class HotSearchViewHolder {
        TextView category;
        ImageView icon;
        TextView name;
        ImageView ranking;

        HotSearchViewHolder() {
        }

        public void update(View view, SearchInfo searchInfo, final Activity activity, int i3, final int i16) {
            final MiniAppInfo miniAppInfo = searchInfo.getMiniAppInfo();
            this.icon.setImageDrawable(MiniAppUtils.getIcon(view.getContext(), miniAppInfo.iconUrl, false, 0, 32));
            this.name.setText(miniAppInfo.name);
            this.category.setText(searchInfo.getCategoryDesc());
            if (i3 > 2) {
                this.ranking.setVisibility(8);
            } else {
                this.ranking.setVisibility(0);
                if (i3 == 0) {
                    this.ranking.setImageResource(R.drawable.n0g);
                } else if (i3 == 1) {
                    this.ranking.setImageResource(R.drawable.n0h);
                } else if (i3 == 2) {
                    this.ranking.setImageResource(R.drawable.n0i);
                }
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter.HotSearchViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        ((InputMethodManager) view2.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view2.getWindowToken(), 0);
                        MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, i16);
                    } catch (Exception e16) {
                        QLog.e(HotSearchAdapter.TAG, 1, "HotSearchAdapter, start miniApp exception: " + Log.getStackTraceString(e16));
                    }
                }
            });
        }
    }

    public HotSearchAdapter(Activity activity, TextView textView, int i3) {
        this.mActivityReference = new WeakReference<>(activity);
        this.mHotTitleView = textView;
        this.mRefer = i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.appList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.appList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener
    public void onHotSearchDataChanged() {
        MiniAppSearchDataManager miniAppSearchDataManager = (MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
        setData(miniAppSearchDataManager.getHotSearchData());
        notifyDataSetChanged();
        if (!TextUtils.isEmpty(miniAppSearchDataManager.getHotSearchTitle())) {
            this.mHotTitleView.setText(miniAppSearchDataManager.getHotSearchTitle());
        }
        MiniAppExposureManager miniAppExposureManager = (MiniAppExposureManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Iterator<ItemInfo> it = this.appList.iterator();
        while (it.hasNext()) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(((SearchInfo) it.next()).miniAppInfo);
            miniAppConfig.launchParam.scene = this.mRefer;
            miniAppExposureManager.addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo"));
        }
    }

    public void setData(List<ItemInfo> list) {
        this.appList.clear();
        this.appList.addAll(list);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        HotSearchViewHolder hotSearchViewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R.layout.fht, viewGroup, false);
            hotSearchViewHolder = new HotSearchViewHolder();
            hotSearchViewHolder.icon = (ImageView) view.findViewById(R.id.z96);
            hotSearchViewHolder.ranking = (ImageView) view.findViewById(R.id.z97);
            hotSearchViewHolder.name = (TextView) view.findViewById(R.id.z98);
            hotSearchViewHolder.category = (TextView) view.findViewById(R.id.z99);
            view.setTag(hotSearchViewHolder);
        } else {
            hotSearchViewHolder = (HotSearchViewHolder) view.getTag();
        }
        try {
            hotSearchViewHolder.update(view, (SearchInfo) this.appList.get(i3), this.mActivityReference.get(), i3, this.mRefer);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getView exception: " + Log.getStackTraceString(e16));
        }
        return view;
    }
}
