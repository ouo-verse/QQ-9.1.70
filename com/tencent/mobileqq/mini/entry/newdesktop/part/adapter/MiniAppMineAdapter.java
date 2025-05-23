package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J*\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppMineViewHolder;", "()V", "mIsForceRefresh", "", "mMiniAppMineDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mMiniAppMineViewHolder", "mTitleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "getItemCount", "", "notifyDataSetChanged", "", "isForceRefresh", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "setData", "dataList", "titleInfo", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMineAdapter extends RecyclerView.Adapter<MiniAppMineViewHolder> {
    private static final int SHOW_MY_MINI_APP_COUNT = 1;
    private static final String TAG = "MiniAppDesktopPart.MiniAppMineAdapter";
    private boolean mIsForceRefresh;
    private MiniAppMineViewHolder mMiniAppMineViewHolder;
    private DesktopAppModuleInfo mTitleInfo = new DesktopAppModuleInfo(3, HardCodeUtil.qqStr(R.string.f213445q8));
    private List<DesktopItemInfo> mMiniAppMineDataList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
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
        this.mMiniAppMineDataList.clear();
        this.mMiniAppMineDataList.addAll(dataList);
        notifyDataSetChanged(isForceRefresh);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppMineViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniAppMineViewHolder miniAppMineViewHolder = this.mMiniAppMineViewHolder;
        if (miniAppMineViewHolder != null) {
            miniAppMineViewHolder.bindView(this.mTitleInfo, this.mMiniAppMineDataList, this.mIsForceRefresh);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppMineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.did, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        MiniAppMineViewHolder miniAppMineViewHolder = new MiniAppMineViewHolder(inflate);
        this.mMiniAppMineViewHolder = miniAppMineViewHolder;
        Intrinsics.checkNotNull(miniAppMineViewHolder);
        return miniAppMineViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(MiniAppMineViewHolder holder) {
        MiniValidExpoReportHelper mExpoReportHelper;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((MiniAppMineAdapter) holder);
        MiniAppMineViewHolder miniAppMineViewHolder = this.mMiniAppMineViewHolder;
        if (miniAppMineViewHolder == null || (mExpoReportHelper = miniAppMineViewHolder.getMExpoReportHelper()) == null) {
            return;
        }
        mExpoReportHelper.stopValidExpoReport(false);
    }

    public static /* synthetic */ void notifyDataSetChanged$default(MiniAppMineAdapter miniAppMineAdapter, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        miniAppMineAdapter.notifyDataSetChanged(z16);
    }

    public static /* synthetic */ void setData$default(MiniAppMineAdapter miniAppMineAdapter, List list, DesktopAppModuleInfo desktopAppModuleInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            desktopAppModuleInfo = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        miniAppMineAdapter.setData(list, desktopAppModuleInfo, z16);
    }
}
