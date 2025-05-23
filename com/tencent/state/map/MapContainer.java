package com.tencent.state.map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/map/MapContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backgroundViewList", "", "Landroid/view/View;", "addBackgroundView", "", "child", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "addView", "index", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "removeAllViews", "removeView", "view", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapContainer extends FrameLayout {
    private final List<View> backgroundViewList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.backgroundViewList = new ArrayList();
    }

    public final void addBackgroundView(View child) {
        super.addView(child, 0);
        if (child != null) {
            this.backgroundViewList.add(child);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        if (index == -1) {
            super.addView(child, index);
        } else {
            int size = index + this.backgroundViewList.size();
            super.addView(child, size < getChildCount() ? size : -1);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.backgroundViewList.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        List<View> list = this.backgroundViewList;
        if (list != null) {
            TypeIntrinsics.asMutableCollection(list).remove(view);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void addBackgroundView(View child, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        super.addView(child, 0, layoutParams);
        if (child != null) {
            this.backgroundViewList.add(child);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (index == -1) {
            super.addView(child, index, params);
        } else {
            int size = index + this.backgroundViewList.size();
            super.addView(child, size < getChildCount() ? size : -1, params);
        }
    }
}
