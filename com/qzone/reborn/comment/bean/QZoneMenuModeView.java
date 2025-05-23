package com.qzone.reborn.comment.bean;

import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "Ljava/io/Serializable;", "clickToggleView", "Landroid/view/View;", "toggleViewContainer", "Landroid/view/ViewGroup;", "(Landroid/view/View;Landroid/view/ViewGroup;)V", "getClickToggleView", "()Landroid/view/View;", "setClickToggleView", "(Landroid/view/View;)V", "getToggleViewContainer", "()Landroid/view/ViewGroup;", "setToggleViewContainer", "(Landroid/view/ViewGroup;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZoneMenuModeView implements Serializable {
    private View clickToggleView;
    private ViewGroup toggleViewContainer;

    public QZoneMenuModeView() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final View getClickToggleView() {
        return this.clickToggleView;
    }

    /* renamed from: component2, reason: from getter */
    public final ViewGroup getToggleViewContainer() {
        return this.toggleViewContainer;
    }

    public final QZoneMenuModeView copy(View clickToggleView, ViewGroup toggleViewContainer) {
        return new QZoneMenuModeView(clickToggleView, toggleViewContainer);
    }

    public final View getClickToggleView() {
        return this.clickToggleView;
    }

    public final ViewGroup getToggleViewContainer() {
        return this.toggleViewContainer;
    }

    public int hashCode() {
        View view = this.clickToggleView;
        int hashCode = (view == null ? 0 : view.hashCode()) * 31;
        ViewGroup viewGroup = this.toggleViewContainer;
        return hashCode + (viewGroup != null ? viewGroup.hashCode() : 0);
    }

    public final void setClickToggleView(View view) {
        this.clickToggleView = view;
    }

    public final void setToggleViewContainer(ViewGroup viewGroup) {
        this.toggleViewContainer = viewGroup;
    }

    public String toString() {
        return "QZoneMenuModeView(clickToggleView=" + this.clickToggleView + ", toggleViewContainer=" + this.toggleViewContainer + ")";
    }

    public QZoneMenuModeView(View view, ViewGroup viewGroup) {
        this.clickToggleView = view;
        this.toggleViewContainer = viewGroup;
    }

    public /* synthetic */ QZoneMenuModeView(View view, ViewGroup viewGroup, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : view, (i3 & 2) != 0 ? null : viewGroup);
    }

    public static /* synthetic */ QZoneMenuModeView copy$default(QZoneMenuModeView qZoneMenuModeView, View view, ViewGroup viewGroup, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = qZoneMenuModeView.clickToggleView;
        }
        if ((i3 & 2) != 0) {
            viewGroup = qZoneMenuModeView.toggleViewContainer;
        }
        return qZoneMenuModeView.copy(view, viewGroup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneMenuModeView)) {
            return false;
        }
        QZoneMenuModeView qZoneMenuModeView = (QZoneMenuModeView) other;
        return Intrinsics.areEqual(this.clickToggleView, qZoneMenuModeView.clickToggleView) && Intrinsics.areEqual(this.toggleViewContainer, qZoneMenuModeView.toggleViewContainer);
    }
}
