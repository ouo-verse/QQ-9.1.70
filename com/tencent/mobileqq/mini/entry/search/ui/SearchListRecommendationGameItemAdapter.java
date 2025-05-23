package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_SEARCH.MiniAppSearch$RankInfo;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchListRecommendationGameItemAdapter extends RecyclerView.Adapter<RecommendGameItemViewHolder> {
    private static final String TAG = "SearchListRecommendationGameItemAdapter";
    private String[] colorArray = {"#FFC75B", "#ADC3E2", "#D9B39C", "#E5E9EE"};
    private WeakReference<Activity> mActivityReference;
    private MiniAppSearch$RankInfo rankInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class RecommendGameItemViewHolder extends RecyclerView.ViewHolder {
        private TextView desc;
        private ImageView gameIcon;
        private ImageView gameRankImage;
        private TextView gameRankText;
        private TextView name;

        public RecommendGameItemViewHolder(View view) {
            super(view);
            this.gameIcon = (ImageView) view.findViewById(R.id.rdx);
            this.gameRankImage = (ImageView) view.findViewById(R.id.rdy);
            this.gameRankText = (TextView) view.findViewById(R.id.rc9);
            this.name = (TextView) view.findViewById(R.id.rle);
            this.desc = (TextView) view.findViewById(R.id.rld);
        }
    }

    public SearchListRecommendationGameItemAdapter(Activity activity) {
        this.mActivityReference = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickApp(MiniAppInfo miniAppInfo, MiniAppSearch$RankInfo miniAppSearch$RankInfo, int i3) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "pg_click", "puulldown_search_minigame_list", "", String.valueOf(i3 + 1));
        MiniAppSearchDtReportHelper.INSTANCE.getInstance().miniAppSearchCommonReport("dt_clck", MiniAppSearchDtReportHelper.MINI_APP_EM_APPLET, new HashMap<String, String>(miniAppInfo, miniAppSearch$RankInfo, i3, miniAppConfig) { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchListRecommendationGameItemAdapter.2
            final /* synthetic */ MiniAppConfig val$appConfig;
            final /* synthetic */ MiniAppInfo val$appInfo;
            final /* synthetic */ int val$position;
            final /* synthetic */ MiniAppSearch$RankInfo val$rankInfo;

            {
                this.val$appInfo = miniAppInfo;
                this.val$rankInfo = miniAppSearch$RankInfo;
                this.val$position = i3;
                this.val$appConfig = miniAppConfig;
                put(MiniAppSearchDtReportHelper.DT_MINI_APP_ID, miniAppInfo.appId);
                put("list_name", miniAppSearch$RankInfo.name.get());
                put("app_position", String.valueOf(i3));
                put("applet_type", String.valueOf(miniAppConfig.config.engineType));
            }
        });
    }

    private void reportShowApp(MiniAppInfo miniAppInfo, int i3) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "expo", "puulldown_search_minigame_list", "", String.valueOf(i3 + 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        MiniAppSearch$RankInfo miniAppSearch$RankInfo = this.rankInfo;
        if (miniAppSearch$RankInfo == null) {
            return 0;
        }
        return miniAppSearch$RankInfo.apps.size();
    }

    public void setData(MiniAppSearch$RankInfo miniAppSearch$RankInfo) {
        this.rankInfo = miniAppSearch$RankInfo;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecommendGameItemViewHolder recommendGameItemViewHolder, final int i3) {
        String str;
        final MiniAppSearch$RankInfo miniAppSearch$RankInfo = this.rankInfo;
        if (miniAppSearch$RankInfo == null || miniAppSearch$RankInfo.apps.size() < i3) {
            return;
        }
        SearchInfo searchInfo = new SearchInfo(miniAppSearch$RankInfo.apps.get(i3));
        searchInfo.setPosition(i3);
        final MiniAppInfo miniAppInfo = searchInfo.getMiniAppInfo();
        recommendGameItemViewHolder.name.setText(miniAppInfo.name);
        recommendGameItemViewHolder.desc.setText(searchInfo.getRecommendReason());
        recommendGameItemViewHolder.gameIcon.setImageDrawable(MiniAppUtils.getIcon(recommendGameItemViewHolder.itemView.getContext(), miniAppInfo.iconUrl, false, 0, 48));
        recommendGameItemViewHolder.gameRankText.setText(String.valueOf(i3 + 1));
        String[] strArr = this.colorArray;
        if (i3 < strArr.length) {
            str = strArr[i3 % strArr.length];
        } else {
            str = strArr[strArr.length - 1];
        }
        recommendGameItemViewHolder.gameRankImage.setColorFilter(Color.parseColor(str));
        reportShowApp(miniAppInfo, i3);
        recommendGameItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchListRecommendationGameItemAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    MiniAppLauncher.launchAppByAppInfo((Activity) SearchListRecommendationGameItemAdapter.this.mActivityReference.get(), miniAppInfo, 3024);
                    SearchListRecommendationGameItemAdapter.this.reportClickApp(miniAppInfo, miniAppSearch$RankInfo, i3);
                } catch (Exception e16) {
                    QLog.e(SearchListRecommendationGameItemAdapter.TAG, 1, "HotSearchAdapter, start miniApp exception: " + Log.getStackTraceString(e16));
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecommendGameItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new RecommendGameItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dke, viewGroup, false));
    }
}
