package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$RankInfo;
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
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.UseUserInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.adapter.RecommendItemAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class SearchNewRecommendationPageAdapter extends BaseAdapter {
    private static final int APP_ICON_SIZE_IN_DP = 48;
    private static final int MAX_LIST_SIZE = 10;
    private static final String TAG = "SearchNewRecommendationPageAdapter";
    private Activity mActivity;
    private ArrayList<SearchInfo> mAppList;
    private ArrayList<Integer> mRankDrawableIds;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class Holder {
        public ImageView imageApp;
        public ImageView imageNumber;
        public ImageView imageUser1;
        public ImageView imageUser2;
        public View layoutUsers;
        public TextView textAppDesc;
        public TextView textAppName;
        public QUIButton textGoto;

        Holder() {
        }
    }

    public SearchNewRecommendationPageAdapter(Activity activity, MiniAppSearch$RankInfo miniAppSearch$RankInfo) {
        this.mAppList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.mRankDrawableIds = arrayList;
        this.mActivity = activity;
        if (miniAppSearch$RankInfo == null) {
            return;
        }
        arrayList.add(Integer.valueOf(R.drawable.ipo));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipq));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipr));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ips));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipt));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipu));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipv));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipw));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipx));
        this.mRankDrawableIds.add(Integer.valueOf(R.drawable.ipp));
        ArrayList<SearchInfo> arrayList2 = new ArrayList<>();
        int i3 = 0;
        for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo : miniAppSearch$RankInfo.apps.get()) {
            if (sTORE_APP_CLIENT$StoreAppInfo != null && sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get() != null) {
                SearchInfo searchInfo = new SearchInfo(sTORE_APP_CLIENT$StoreAppInfo);
                searchInfo.setPosition(i3);
                arrayList2.add(searchInfo);
                i3++;
            }
        }
        this.mAppList = arrayList2;
    }

    private View createItemView(int i3, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.djl, (ViewGroup) null);
        Holder holder = new Holder();
        holder.imageNumber = (ImageView) inflate.findViewById(R.id.rdy);
        holder.imageApp = (ImageView) inflate.findViewById(R.id.rdx);
        holder.textAppName = (TextView) inflate.findViewById(R.id.rle);
        holder.textAppDesc = (TextView) inflate.findViewById(R.id.rld);
        holder.textGoto = (QUIButton) inflate.findViewById(R.id.rlf);
        holder.layoutUsers = inflate.findViewById(R.id.rdz);
        holder.imageUser1 = (ImageView) inflate.findViewById(R.id.f163673re0);
        holder.imageUser2 = (ImageView) inflate.findViewById(R.id.f163674re1);
        inflate.setTag(holder);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$0(MiniAppInfo miniAppInfo, int i3, View view) {
        try {
            ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            MiniAppLauncher.launchAppByAppInfo(this.mActivity, miniAppInfo, 3024);
            reportClickApp(miniAppInfo, i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "HotSearchAdapter, start miniApp exception: " + Log.getStackTraceString(e16));
        }
    }

    private void reportClickApp(MiniAppInfo miniAppInfo, int i3) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "pg_click", "puulldown_search_minigame_list", "", String.valueOf(i3));
    }

    private void reportShowApp(MiniAppInfo miniAppInfo, int i3) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "expo", "puulldown_search_minigame_list", "", String.valueOf(i3));
    }

    private void updateUserAvatars(Holder holder, MiniAppInfo miniAppInfo) {
        int i3 = miniAppInfo.friendNum;
        List<UseUserInfo> list = miniAppInfo.users;
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null && i3 > 0 && list != null && list.size() > 0) {
            holder.layoutUsers.setVisibility(0);
            UseUserInfo useUserInfo = list.get(0);
            if (!TextUtils.isEmpty(useUserInfo.uin)) {
                holder.imageUser1.setImageDrawable(FaceDrawable.getUserFaceDrawable(appInterface, useUserInfo.uin, (byte) 4));
            }
            holder.imageUser2.setVisibility(8);
            if (list.size() > 1) {
                UseUserInfo useUserInfo2 = list.get(1);
                if (TextUtils.isEmpty(useUserInfo2.uin)) {
                    return;
                }
                holder.imageUser2.setVisibility(0);
                holder.imageUser2.setImageDrawable(FaceDrawable.getUserFaceDrawable(appInterface, useUserInfo2.uin, (byte) 4));
                return;
            }
            return;
        }
        holder.layoutUsers.setVisibility(8);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mAppList.size() > 10) {
            return 10;
        }
        return this.mAppList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    private void bindView(final int i3, View view, ViewGroup viewGroup) {
        if (i3 < 0 || i3 >= this.mAppList.size()) {
            return;
        }
        final MiniAppInfo miniAppInfo = this.mAppList.get(i3).getMiniAppInfo();
        Holder holder = (Holder) view.getTag();
        holder.imageApp.setImageDrawable(MiniAppUtils.getIcon(view.getContext(), miniAppInfo.iconUrl, false, 0, 48));
        holder.textAppName.setText(miniAppInfo.name);
        holder.textAppDesc.setText(RecommendItemAdapter.getGameDesc(miniAppInfo));
        setNumberImage(i3, holder.imageNumber);
        updateUserAvatars(holder, miniAppInfo);
        reportShowApp(miniAppInfo, i3);
        holder.textGoto.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchNewRecommendationPageAdapter.this.lambda$bindView$0(miniAppInfo, i3, view2);
            }
        });
    }

    private void setNumberImage(int i3, ImageView imageView) {
        if (i3 >= 0 && i3 < this.mRankDrawableIds.size()) {
            imageView.setVisibility(0);
            imageView.setImageResource(this.mRankDrawableIds.get(i3).intValue());
        } else {
            imageView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createItemView(i3, viewGroup);
        }
        bindView(i3, view, viewGroup);
        return view;
    }
}
