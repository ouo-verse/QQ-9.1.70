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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J*\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecentViewHolder;", "()V", "mIsForceRefresh", "", "mMiniAppRecentDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mMiniAppRecentViewHolder", "mTitleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "getItemCount", "", "handleModuleExposure", "", "notifyDataSetChanged", "isForceRefresh", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "setData", "dataList", "titleInfo", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRecentAdapter extends RecyclerView.Adapter<MiniAppRecentViewHolder> {
    private static final int HIDE_RECENT_MINI_APP_COUNT = 0;
    private static final int SHOW_RECENT_MINI_APP_COUNT = 1;
    private static final String TAG = "MiniAppDesktopPart.MiniAppRecentAdapter";
    private boolean mIsForceRefresh;
    private MiniAppRecentViewHolder mMiniAppRecentViewHolder;
    private DesktopAppModuleInfo mTitleInfo = new DesktopAppModuleInfo(1, HardCodeUtil.qqStr(R.string.xxz));
    private List<DesktopItemInfo> mMiniAppRecentDataList = new ArrayList();

    private final void handleModuleExposure() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
        ((MiniAppExposureManager) manager).putReportDataToMap(EntryConstants.DropdownEntry.DROPDOWN_RECENT_PLAYING_ENTRY, new MiniAppExposureManager.StoreEntryExposureData(EntryConstants.DropdownEntry.DROPDOWN_RECENT_PLAYING_ENTRY));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return !this.mMiniAppRecentDataList.isEmpty() ? 1 : 0;
    }

    public final void notifyDataSetChanged(boolean isForceRefresh) {
        this.mIsForceRefresh = isForceRefresh;
        notifyDataSetChanged();
        QLog.i(TAG, 1, "notifyDataSetChanged isForceRefresh:" + isForceRefresh);
    }

    public final void setData(List<DesktopItemInfo> dataList, DesktopAppModuleInfo titleInfo, boolean isForceRefresh) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (titleInfo != null) {
            this.mTitleInfo = titleInfo;
        }
        this.mMiniAppRecentDataList.clear();
        this.mMiniAppRecentDataList.addAll(dataList);
        notifyDataSetChanged(isForceRefresh);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppRecentViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i(TAG, 1, "onBindViewHolder");
        MiniAppRecentViewHolder miniAppRecentViewHolder = this.mMiniAppRecentViewHolder;
        if (miniAppRecentViewHolder != null) {
            miniAppRecentViewHolder.bindView(this.mTitleInfo, this.mMiniAppRecentDataList, this.mIsForceRefresh);
        }
        handleModuleExposure();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppRecentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dij, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        MiniAppRecentViewHolder miniAppRecentViewHolder = new MiniAppRecentViewHolder(inflate);
        this.mMiniAppRecentViewHolder = miniAppRecentViewHolder;
        Intrinsics.checkNotNull(miniAppRecentViewHolder);
        return miniAppRecentViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(MiniAppRecentViewHolder holder) {
        MiniValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((MiniAppRecentAdapter) holder);
        MiniAppRecentViewHolder miniAppRecentViewHolder = this.mMiniAppRecentViewHolder;
        if (miniAppRecentViewHolder == null || (mExpoReportHelper = miniAppRecentViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }

    public static /* synthetic */ void notifyDataSetChanged$default(MiniAppRecentAdapter miniAppRecentAdapter, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        miniAppRecentAdapter.notifyDataSetChanged(z16);
    }

    public static /* synthetic */ void setData$default(MiniAppRecentAdapter miniAppRecentAdapter, List list, DesktopAppModuleInfo desktopAppModuleInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            desktopAppModuleInfo = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        miniAppRecentAdapter.setData(list, desktopAppModuleInfo, z16);
    }
}
