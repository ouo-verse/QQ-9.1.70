package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/SearchBarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mMiniAppDesktopSearchBar", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "mModuleType", "", "bindView", "", "moduleType", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SearchBarViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppExpDesktopPart.SearchBarViewHolder";
    private QUISearchBar mMiniAppDesktopSearchBar;
    private int mModuleType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mModuleType = -1;
        View findViewById = itemView.findViewById(R.id.rg7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ni_app_desktop_searchbar)");
        this.mMiniAppDesktopSearchBar = (QUISearchBar) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(SearchBarViewHolder this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra(MiniAppSearchFragment.IS_FROM_MINI_DESKTOP, false);
        PublicFragmentActivity.start(view != null ? view.getContext() : null, intent, ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_SOUSUOKUANG, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        int i3 = this$0.mModuleType;
        if (i3 == 1) {
            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2;
        } else if (i3 != 3) {
            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN;
        } else {
            str = MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_PERSONAL_LEVEL2;
        }
        MiniAppDesktopDtReportHelper.INSTANCE.getInstance().miniAppDesktopCommonReport("qq_clck", "em_applet_search_box", new LinkedHashMap(), str);
    }

    public final void bindView(int moduleType) {
        this.mModuleType = moduleType;
        ViewGroup.LayoutParams layoutParams = this.mMiniAppDesktopSearchBar.getInputBg().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).height = ViewUtils.dpToPx(40.0f);
        View inputBg = this.mMiniAppDesktopSearchBar.getInputBg();
        Intrinsics.checkNotNullExpressionValue(inputBg, "mMiniAppDesktopSearchBar.inputBg");
        com.tencent.mobileqq.qwallet.k.b(inputBg, ViewUtils.dpToPx(12.0f));
        this.mMiniAppDesktopSearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchBarViewHolder.bindView$lambda$0(SearchBarViewHolder.this, view);
            }
        });
    }
}
