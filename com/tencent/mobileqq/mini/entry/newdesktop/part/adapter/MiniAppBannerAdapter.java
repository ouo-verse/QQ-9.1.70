package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppBannerViewHolder;", "()V", "mMiniAppBannerDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mMiniAppBannerViewHolder", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "dataList", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppBannerAdapter extends RecyclerView.Adapter<MiniAppBannerViewHolder> {
    private static final int HIDE_BANNER_COUNT = 0;
    private static final int SHOW_BANNER_COUNT = 1;
    private static final String TAG = "MiniAppDesktopPart.MiniAppBannerAdapter";
    private List<DesktopItemInfo> mMiniAppBannerDataList = new ArrayList();
    private MiniAppBannerViewHolder mMiniAppBannerViewHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return !this.mMiniAppBannerDataList.isEmpty() ? 1 : 0;
    }

    public final void setData(List<DesktopItemInfo> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "setData, dataList=" + dataList, new RuntimeException("setData"));
        }
        this.mMiniAppBannerDataList.clear();
        this.mMiniAppBannerDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppBannerViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.mMiniAppBannerDataList.isEmpty()) {
            MiniAppBannerViewHolder miniAppBannerViewHolder = this.mMiniAppBannerViewHolder;
            if (miniAppBannerViewHolder != null) {
                miniAppBannerViewHolder.bindView(null);
                return;
            }
            return;
        }
        MiniAppBannerViewHolder miniAppBannerViewHolder2 = this.mMiniAppBannerViewHolder;
        if (miniAppBannerViewHolder2 != null) {
            DesktopItemInfo desktopItemInfo = this.mMiniAppBannerDataList.get(position);
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo");
            miniAppBannerViewHolder2.bindView((DesktopBannerModuleInfo) desktopItemInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppBannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dib, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        MiniAppBannerViewHolder miniAppBannerViewHolder = new MiniAppBannerViewHolder(inflate);
        this.mMiniAppBannerViewHolder = miniAppBannerViewHolder;
        Intrinsics.checkNotNull(miniAppBannerViewHolder);
        return miniAppBannerViewHolder;
    }
}
