package com.tencent.robot.adelie.homepage.create.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieScrollView;", "Landroid/widget/ScrollView;", "", HippyTKDListViewAdapter.X, "y", "", "scrollTo", "computeScroll", "Landroid/view/View$OnTouchListener;", "listener", "setOnTouchListener", "", "scrollable", "setScrollable", "e", "d", "Z", "isScrollable", "Landroid/view/View$OnTouchListener;", "wrapperOnTouchListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes25.dex */
public final class AdelieScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnTouchListener wrapperOnTouchListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isScrollable = true;
        super.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.robot.adelie.homepage.create.view.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c16;
                c16 = AdelieScrollView.c(AdelieScrollView.this, view, motionEvent);
                return c16;
            }
        });
        setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.robot.adelie.homepage.create.view.l
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                AdelieScrollView.d(AdelieScrollView.this, view, i3, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(AdelieScrollView this$0, View view, MotionEvent motionEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnTouchListener onTouchListener = this$0.wrapperOnTouchListener;
        if (onTouchListener != null) {
            z16 = onTouchListener.onTouch(view, motionEvent);
        } else {
            z16 = false;
        }
        return (!this$0.isScrollable) | z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AdelieScrollView this$0, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isScrollable) {
            QLog.i("AdelieScrollView", 1, "oldScrollY=" + i18 + ", scrollY=" + i16);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        if (!this.isScrollable) {
            return;
        }
        super.computeScroll();
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsScrollable() {
        return this.isScrollable;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void scrollTo(int x16, int y16) {
        if (!this.isScrollable) {
            return;
        }
        super.scrollTo(x16, y16);
    }

    @Override // android.view.View
    public void setOnTouchListener(@NotNull View.OnTouchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.wrapperOnTouchListener = listener;
    }

    public final void setScrollable(boolean scrollable) {
        this.isScrollable = scrollable;
    }
}
