package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J(\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/LimitedTimeRecommendModuleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/LimitedTimeRecommendMiniAppViewHolder;", "()V", "mLimitedTimeRecommendMiniAppViewHolder", "mRecommendGroupAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "onViewDetachedFromWindow", "holder", "refreshMiniAppInfo", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "miniAppInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "setData", "recommendGroupAppInfo", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LimitedTimeRecommendModuleAdapter extends RecyclerView.Adapter<LimitedTimeRecommendMiniAppViewHolder> {
    private static final int HIDE_PERSONAL_MODULE = 0;
    private static final int SHOW_PERSONAL_MODULE = 1;
    private static final String TAG = "LimitedTimeRecommendModuleAdapter";
    private LimitedTimeRecommendMiniAppViewHolder mLimitedTimeRecommendMiniAppViewHolder;
    private ExpDesktopGroupAppInfo mRecommendGroupAppInfo;

    public LimitedTimeRecommendModuleAdapter() {
        ArrayList arrayListOf;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mRecommendGroupAppInfo = new ExpDesktopGroupAppInfo("", 2, arrayList, arrayListOf, null, false, 48, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mRecommendGroupAppInfo.getGroupAppInfo().isEmpty() ^ true ? 1 : 0;
    }

    public final void refreshMiniAppInfo(RecyclerView recyclerView, ArrayList<DesktopAppInfo> miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.mRecommendGroupAppInfo.setGroupAppInfo(miniAppInfo);
        MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LimitedTimeRecommendMiniAppViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        LimitedTimeRecommendMiniAppViewHolder limitedTimeRecommendMiniAppViewHolder = this.mLimitedTimeRecommendMiniAppViewHolder;
        if (limitedTimeRecommendMiniAppViewHolder != null) {
            limitedTimeRecommendMiniAppViewHolder.bindView(this.mRecommendGroupAppInfo);
        }
        MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper = MiniAppExpDesktop04239ReportHelper.INSTANCE;
        miniAppExpDesktop04239ReportHelper.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : miniAppExpDesktop04239ReportHelper.getPageReserveAction(2, false), (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LimitedTimeRecommendMiniAppViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dir, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026lder_item, parent, false)");
        LimitedTimeRecommendMiniAppViewHolder limitedTimeRecommendMiniAppViewHolder = new LimitedTimeRecommendMiniAppViewHolder(inflate);
        this.mLimitedTimeRecommendMiniAppViewHolder = limitedTimeRecommendMiniAppViewHolder;
        Intrinsics.checkNotNull(limitedTimeRecommendMiniAppViewHolder);
        return limitedTimeRecommendMiniAppViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(LimitedTimeRecommendMiniAppViewHolder holder) {
        MiniExpValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((LimitedTimeRecommendModuleAdapter) holder);
        LimitedTimeRecommendMiniAppViewHolder limitedTimeRecommendMiniAppViewHolder = this.mLimitedTimeRecommendMiniAppViewHolder;
        if (limitedTimeRecommendMiniAppViewHolder == null || (mExpoReportHelper = limitedTimeRecommendMiniAppViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }

    public final void setData(RecyclerView recyclerView, ExpDesktopGroupAppInfo recommendGroupAppInfo) {
        if (recommendGroupAppInfo == null) {
            QLog.i(TAG, 1, "setData recentUsedGroupAppInfo is null!");
            return;
        }
        MiniAppExpDesktopNotifyUtil.Companion companion = MiniAppExpDesktopNotifyUtil.INSTANCE;
        companion.removeNullMiniAppForFixError(recommendGroupAppInfo);
        this.mRecommendGroupAppInfo = recommendGroupAppInfo;
        companion.safeNotifyDataSetChanged(recyclerView, this);
    }
}
