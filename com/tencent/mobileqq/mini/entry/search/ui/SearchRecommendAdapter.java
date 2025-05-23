package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_SEARCH.MiniAppSearch$RankInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsV2Rsp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final int ITEM_TYPE_FOOTER_MORE = 2;
    private static final int ITEM_TYPE_LIST = 1;
    private static final int ITEM_TYPE_UNKNOW = 0;
    private static final String TAG = "SearchRecommendAdapter";
    private String[] colorArray = {"#FF7935", "#01C8B8", "#2BB9F7", "#FF6972", "#FFBF1A"};
    private WeakReference<Activity> mActivityReference;
    private MiniAppSearch$StGetHotSearchAppsV2Rsp mRecommendation;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class FooterMoreViewHolder extends RecyclerView.ViewHolder {
        public FooterMoreViewHolder(View view) {
            super(view);
            view.setId(R.id.ri7);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class RecommendItemViewHolder extends RecyclerView.ViewHolder {
        private SearchListRecommendationGameItemAdapter adapter;
        private RecyclerView list;
        private TextView title;
        private ImageView titleLeftIcon;
        private ImageView titleRightIcon;

        public RecommendItemViewHolder(Activity activity, View view) {
            super(view);
            this.titleLeftIcon = (ImageView) view.findViewById(R.id.rca);
            this.titleRightIcon = (ImageView) view.findViewById(R.id.rcb);
            this.title = (TextView) view.findViewById(R.id.rc_);
            this.list = (RecyclerView) view.findViewById(R.id.rc8);
            this.list.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
            SearchListRecommendationGameItemAdapter searchListRecommendationGameItemAdapter = new SearchListRecommendationGameItemAdapter(activity);
            this.adapter = searchListRecommendationGameItemAdapter;
            this.list.setAdapter(searchListRecommendationGameItemAdapter);
            this.list.addItemDecoration(new SearchListRecommendationItemDecoration());
        }
    }

    public SearchRecommendAdapter(Activity activity) {
        this.mActivityReference = new WeakReference<>(activity);
    }

    private void reportMoreClick() {
        MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", "em_click", "puulldown_search_minigame_list", "3042", "3042_view_all");
    }

    private void reportMoreShow() {
        MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", "em_expo", "puulldown_search_minigame_list", "3042", "3042_view_all");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = this.mRecommendation;
        if (miniAppSearch$StGetHotSearchAppsV2Rsp == null) {
            return 0;
        }
        return miniAppSearch$StGetHotSearchAppsV2Rsp.ranks.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 < this.mRecommendation.ranks.size()) {
            return 1;
        }
        return i3 == this.mRecommendation.ranks.size() ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = this.mRecommendation;
        if (miniAppSearch$StGetHotSearchAppsV2Rsp == null || miniAppSearch$StGetHotSearchAppsV2Rsp.ranks.size() < i3 || viewHolder == null) {
            return;
        }
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            viewHolder.itemView.setOnClickListener(this);
            reportMoreShow();
            return;
        }
        RecommendItemViewHolder recommendItemViewHolder = (RecommendItemViewHolder) viewHolder;
        MiniAppSearch$RankInfo miniAppSearch$RankInfo = this.mRecommendation.ranks.get(i3);
        String[] strArr = this.colorArray;
        int parseColor = Color.parseColor(strArr[i3 % strArr.length]);
        recommendItemViewHolder.title.setText(miniAppSearch$RankInfo.name.get());
        recommendItemViewHolder.title.setTextColor(parseColor);
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
        recommendItemViewHolder.titleLeftIcon.setColorFilter(porterDuffColorFilter);
        recommendItemViewHolder.titleRightIcon.setColorFilter(porterDuffColorFilter);
        recommendItemViewHolder.adapter.setData(miniAppSearch$RankInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        if (view.getId() != R.id.ri7 || (activity = this.mActivityReference.get()) == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.putExtra("big_brother_source_key", "biz_src_zf_games");
            intent.setData(Uri.parse(this.mRecommendation.jumpUrl.get()));
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "list recommendation more launch error:", e16);
        }
        reportMoreClick();
    }

    public void setData(MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp) {
        this.mRecommendation = miniAppSearch$StGetHotSearchAppsV2Rsp;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new RecommendItemViewHolder(this.mActivityReference.get(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dkd, viewGroup, false));
        }
        if (i3 == 2) {
            return new FooterMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dkf, viewGroup, false));
        }
        return null;
    }
}
