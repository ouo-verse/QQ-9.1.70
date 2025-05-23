package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecommendViewHolder;", "()V", "mMiniAppRecommendDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mMiniAppRecommendViewHolder", "mTitleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "getItemCount", "", "handleModuleExposure", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "setData", "dataList", "titleInfo", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRecommendAdapter extends RecyclerView.Adapter<MiniAppRecommendViewHolder> {
    private static final int HIDE_RECOMMEND_MINI_APP_COUNT = 0;
    private static final int SHOW_RECOMMEND_MINI_APP_COUNT = 1;
    private static final String TAG = "MiniAppDesktopPart.MiniAppRecommendAdapter";
    private MiniAppRecommendViewHolder mMiniAppRecommendViewHolder;
    private List<DesktopItemInfo> mMiniAppRecommendDataList = new ArrayList();
    private DesktopAppModuleInfo mTitleInfo = new DesktopAppModuleInfo(2, HardCodeUtil.qqStr(R.string.o85));

    private final void handleModuleExposure() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
        ((MiniAppExposureManager) manager).putReportDataToMap(EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY, new MiniAppExposureManager.StoreEntryExposureData(EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return !this.mMiniAppRecommendDataList.isEmpty() ? 1 : 0;
    }

    public final void setData(List<DesktopItemInfo> dataList, DesktopAppModuleInfo titleInfo) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (titleInfo != null) {
            this.mTitleInfo = titleInfo;
        }
        this.mMiniAppRecommendDataList.clear();
        this.mMiniAppRecommendDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppRecommendViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniAppRecommendViewHolder miniAppRecommendViewHolder = this.mMiniAppRecommendViewHolder;
        if (miniAppRecommendViewHolder != null) {
            miniAppRecommendViewHolder.bindView(this.mTitleInfo, this.mMiniAppRecommendDataList);
        }
        handleModuleExposure();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppRecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dih, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        MiniAppRecommendViewHolder miniAppRecommendViewHolder = new MiniAppRecommendViewHolder(inflate);
        this.mMiniAppRecommendViewHolder = miniAppRecommendViewHolder;
        Intrinsics.checkNotNull(miniAppRecommendViewHolder);
        return miniAppRecommendViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(MiniAppRecommendViewHolder holder) {
        MiniValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((MiniAppRecommendAdapter) holder);
        MiniAppRecommendViewHolder miniAppRecommendViewHolder = this.mMiniAppRecommendViewHolder;
        if (miniAppRecommendViewHolder == null || (mExpoReportHelper = miniAppRecommendViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }

    public static /* synthetic */ void setData$default(MiniAppRecommendAdapter miniAppRecommendAdapter, List list, DesktopAppModuleInfo desktopAppModuleInfo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            desktopAppModuleInfo = null;
        }
        miniAppRecommendAdapter.setData(list, desktopAppModuleInfo);
    }
}
