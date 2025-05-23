package com.tencent.mobileqq.mini.entry.search.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchHistoryGridAdapter extends BaseAdapter {
    private static final int MAX_ITEM_SIZE = 6;
    private View.OnClickListener mSearchHistoryClickListener;
    private final List<String> mSearchHistory = new ArrayList();
    private final List<String> mReportShowHistory = new ArrayList();
    private boolean mIsEditMode = false;

    private View getEditModeItemView(final int i3, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.djh, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.rhl)).setText(this.mSearchHistory.get(i3));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchHistoryGridAdapter.this.lambda$getEditModeItemView$0(i3, view);
            }
        });
        return inflate;
    }

    private View getNormalModeItemView(int i3, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dji, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.rhl)).setText(this.mSearchHistory.get(i3));
        reportShowSearchHistory(this.mSearchHistory.get(i3));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchHistoryGridAdapter.this.lambda$getNormalModeItemView$1(view);
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getEditModeItemView$0(int i3, View view) {
        MiniAppSearchDataManager miniAppSearchDataManager = (MiniAppSearchDataManager) MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
        String str = this.mSearchHistory.get(i3);
        miniAppSearchDataManager.removeSearchHistory(str);
        setData(miniAppSearchDataManager.getHistorySearchList());
        notifyDataSetChanged();
        reportDeleteSearchHistory(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNormalModeItemView$1(View view) {
        if (this.mSearchHistoryClickListener != null) {
            TextView textView = (TextView) view.findViewById(R.id.rhl);
            this.mSearchHistoryClickListener.onClick(textView);
            if (textView.getText() != null) {
                reportClickSearchHistory(textView.getText().toString());
            }
        }
    }

    private void reportClickSearchHistory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "em_click", "pulldown_search_history_keywords", "", str);
    }

    private void reportDeleteSearchHistory(String str) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "em_click", "pulldown_search_history_keywords_drop", "", str);
    }

    private void reportShowSearchHistory(String str) {
        if (TextUtils.isEmpty(str) || this.mReportShowHistory.contains(str)) {
            return;
        }
        this.mReportShowHistory.add(str);
        MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig.launchParam.scene = 3042;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "em_expo", "pulldown_search_history_keywords", "", str);
        MiniAppSearchDtReportHelper.INSTANCE.getInstance().miniAppSearchCommonReport("dt_imp", MiniAppSearchDtReportHelper.MINI_APP_EM_APPLET_HISTORICAL_TERMS, new HashMap<String, String>(str) { // from class: com.tencent.mobileqq.mini.entry.search.ui.SearchHistoryGridAdapter.1
            final /* synthetic */ String val$searchWord;

            {
                this.val$searchWord = str;
                put("search_query_text", str);
            }
        });
    }

    public void enableEditMode(boolean z16) {
        this.mIsEditMode = z16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return Math.min(this.mSearchHistory.size(), 6);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.mSearchHistory.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (this.mIsEditMode) {
            return getEditModeItemView(i3, viewGroup);
        }
        return getNormalModeItemView(i3, viewGroup);
    }

    public boolean isEditMode() {
        return this.mIsEditMode;
    }

    public void setData(List<String> list) {
        this.mSearchHistory.clear();
        this.mSearchHistory.addAll(list);
    }

    public void setOnSearchHistoryClickListener(View.OnClickListener onClickListener) {
        this.mSearchHistoryClickListener = onClickListener;
    }
}
