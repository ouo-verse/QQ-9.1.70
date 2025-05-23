package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u001e\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bJ&\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/RankModuleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/RankMiniAppViewHolder;", "()V", "mMiniAppRankDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "Lkotlin/collections/ArrayList;", "mMiniAppRankViewHolder", "mRankTabChangeListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/RankMiniAppViewHolder$OnRankTabChangeListener;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "setData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "miniAppRankInfo", "", "setRankSubTabMiniAppInfo", "moduleType", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "setRankTabChangeListener", "onRankTabChangeListener", "setRvDataClearOnThemeChanged", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RankModuleAdapter extends RecyclerView.Adapter<RankMiniAppViewHolder> {
    private static final int HIDE_RANK_MODULE = 0;
    private static final int SHOW_RANK_MODULE = 1;
    private static final String TAG = "RankModuleAdapter";
    private ArrayList<ExpDesktopRankSubTabAppInfo> mMiniAppRankDataList = new ArrayList<>();
    private RankMiniAppViewHolder mMiniAppRankViewHolder;
    private RankMiniAppViewHolder.OnRankTabChangeListener mRankTabChangeListener;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return !this.mMiniAppRankDataList.isEmpty() ? 1 : 0;
    }

    public final void setData(RecyclerView recyclerView, List<ExpDesktopRankSubTabAppInfo> miniAppRankInfo) {
        Intrinsics.checkNotNullParameter(miniAppRankInfo, "miniAppRankInfo");
        this.mMiniAppRankDataList.clear();
        this.mMiniAppRankDataList.addAll(miniAppRankInfo);
        RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
        if (rankMiniAppViewHolder != null) {
            rankMiniAppViewHolder.resetCurrentTabPosition();
        }
        MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
    }

    public final void setRankSubTabMiniAppInfo(RecyclerView recyclerView, int moduleType, List<DesktopAppInfo> miniAppRankInfo) {
        Intrinsics.checkNotNullParameter(miniAppRankInfo, "miniAppRankInfo");
        if (this.mMiniAppRankViewHolder == null) {
            QLog.i(TAG, 1, "refreshSpecialRankInfo mMiniAppRankViewHolder is null!");
            return;
        }
        QLog.i(TAG, 1, "moduleType:" + moduleType + " miniAppRankInfo size:" + miniAppRankInfo.size());
        int i3 = 0;
        for (Object obj : this.mMiniAppRankDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo = (ExpDesktopRankSubTabAppInfo) obj;
            if (expDesktopRankSubTabAppInfo.mModuleType == moduleType) {
                if (expDesktopRankSubTabAppInfo.getRankAppInfo().isEmpty()) {
                    expDesktopRankSubTabAppInfo.getRankAppInfo().addAll(miniAppRankInfo);
                }
                RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
                Intrinsics.checkNotNull(rankMiniAppViewHolder);
                if (rankMiniAppViewHolder.getMCurrentTabIndex() == i3) {
                    MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
                }
            }
            i3 = i16;
        }
    }

    public final void setRankTabChangeListener(RankMiniAppViewHolder.OnRankTabChangeListener onRankTabChangeListener) {
        Intrinsics.checkNotNullParameter(onRankTabChangeListener, "onRankTabChangeListener");
        this.mRankTabChangeListener = onRankTabChangeListener;
    }

    public final void setRvDataClearOnThemeChanged() {
        RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
        if (rankMiniAppViewHolder != null) {
            rankMiniAppViewHolder.setRvDataClearOnThemeChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RankMiniAppViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
        if (rankMiniAppViewHolder != null) {
            rankMiniAppViewHolder.bindView(this.mMiniAppRankDataList, this.mRankTabChangeListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RankMiniAppViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167478dj2, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        RankMiniAppViewHolder rankMiniAppViewHolder = new RankMiniAppViewHolder(inflate);
        this.mMiniAppRankViewHolder = rankMiniAppViewHolder;
        Intrinsics.checkNotNull(rankMiniAppViewHolder);
        return rankMiniAppViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RankMiniAppViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((RankModuleAdapter) holder);
        RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
        if (rankMiniAppViewHolder != null) {
            rankMiniAppViewHolder.reportViewExpo();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RankMiniAppViewHolder holder) {
        MiniExpValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((RankModuleAdapter) holder);
        RankMiniAppViewHolder rankMiniAppViewHolder = this.mMiniAppRankViewHolder;
        if (rankMiniAppViewHolder == null || (mExpoReportHelper = rankMiniAppViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }
}
