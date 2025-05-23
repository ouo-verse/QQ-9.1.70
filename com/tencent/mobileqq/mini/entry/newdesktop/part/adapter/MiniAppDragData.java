package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppDragData;", "", "startRv", "Landroidx/recyclerview/widget/RecyclerView;", "startViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromPosition", "", "fromDesktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromDesktopAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "setFromDesktopAppInfo", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromPosition", "()I", "setFromPosition", "(I)V", "getStartRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setStartRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getStartViewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setStartViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDragData {
    private DesktopAppInfo fromDesktopAppInfo;
    private int fromPosition;
    private RecyclerView startRv;
    private RecyclerView.ViewHolder startViewHolder;

    public MiniAppDragData(RecyclerView startRv, RecyclerView.ViewHolder startViewHolder, int i3, DesktopAppInfo fromDesktopAppInfo) {
        Intrinsics.checkNotNullParameter(startRv, "startRv");
        Intrinsics.checkNotNullParameter(startViewHolder, "startViewHolder");
        Intrinsics.checkNotNullParameter(fromDesktopAppInfo, "fromDesktopAppInfo");
        this.startRv = startRv;
        this.startViewHolder = startViewHolder;
        this.fromPosition = i3;
        this.fromDesktopAppInfo = fromDesktopAppInfo;
    }

    public final DesktopAppInfo getFromDesktopAppInfo() {
        return this.fromDesktopAppInfo;
    }

    public final int getFromPosition() {
        return this.fromPosition;
    }

    public final RecyclerView getStartRv() {
        return this.startRv;
    }

    public final RecyclerView.ViewHolder getStartViewHolder() {
        return this.startViewHolder;
    }

    public final void setFromDesktopAppInfo(DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "<set-?>");
        this.fromDesktopAppInfo = desktopAppInfo;
    }

    public final void setFromPosition(int i3) {
        this.fromPosition = i3;
    }

    public final void setStartRv(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.startRv = recyclerView;
    }

    public final void setStartViewHolder(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "<set-?>");
        this.startViewHolder = viewHolder;
    }
}
