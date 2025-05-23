package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_SEARCH.MiniAppSearch$RankInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsV2Rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchNewRecommendationAdapter extends PagerAdapter implements MiniAppSearchDataManager.HotSearchDataChangedListener {
    private static final String TAG = "SearchNewRecommendationAdapter";
    private Activity mActivity;
    private ArrayList<ListView> mPageList = new ArrayList<>();
    private MiniAppSearch$StGetHotSearchAppsV2Rsp mRecommendation;

    public SearchNewRecommendationAdapter(Activity activity) {
        this.mActivity = activity;
    }

    private View createFootView(Context context, final String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.djk, (ViewGroup) null);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchNewRecommendationAdapter.this.lambda$createFootView$0(str, view);
            }
        });
        return inflate;
    }

    private ListView createPage(MiniAppSearch$RankInfo miniAppSearch$RankInfo) {
        SearchNewRecommendationPageAdapter searchNewRecommendationPageAdapter = new SearchNewRecommendationPageAdapter(this.mActivity, miniAppSearch$RankInfo);
        ListView listView = new ListView(this.mActivity);
        listView.setDivider(new ColorDrawable(0));
        listView.setDividerHeight(0);
        listView.setAdapter((ListAdapter) searchNewRecommendationPageAdapter);
        listView.setSelector(new ColorDrawable(0));
        if (!TextUtils.isEmpty(miniAppSearch$RankInfo.jump_url.get())) {
            listView.addFooterView(createFootView(this.mActivity, miniAppSearch$RankInfo.jump_url.get()));
        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchNewRecommendationAdapter.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                ((InputMethodManager) SearchNewRecommendationAdapter.this.mActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(absListView.getWindowToken(), 0);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            }
        });
        return listView;
    }

    private void createPageList() {
        ArrayList<ListView> arrayList = new ArrayList<>();
        MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = this.mRecommendation;
        if (miniAppSearch$StGetHotSearchAppsV2Rsp != null && !miniAppSearch$StGetHotSearchAppsV2Rsp.ranks.isEmpty()) {
            for (int i3 = 0; i3 < this.mRecommendation.ranks.size(); i3++) {
                arrayList.add(createPage(this.mRecommendation.ranks.get(i3)));
            }
        }
        this.mPageList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFootView$0(String str, View view) {
        if (this.mActivity == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.putExtra("big_brother_source_key", "biz_src_zf_games");
            intent.setData(Uri.parse(str));
            this.mActivity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "openUrlScheme error:", e16);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = this.mRecommendation;
        if (miniAppSearch$StGetHotSearchAppsV2Rsp == null) {
            return 0;
        }
        return miniAppSearch$StGetHotSearchAppsV2Rsp.ranks.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (i3 >= this.mPageList.size()) {
            return null;
        }
        ListView listView = this.mPageList.get(i3);
        viewGroup.addView(listView);
        return listView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.HotSearchDataChangedListener
    public void onHotSearchDataChanged() {
        setData(((MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).getHotSearchV2Data());
        notifyDataSetChanged();
    }

    public void setData(MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp) {
        this.mRecommendation = miniAppSearch$StGetHotSearchAppsV2Rsp;
        createPageList();
    }
}
