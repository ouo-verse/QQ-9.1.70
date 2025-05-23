package com.tencent.qqnt.aio.menu.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/menu/ui/QQMenuDispatchTouchEventLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", "ev", "", "b", "a", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Landroid/view/View;", "d", "Landroid/view/View;", "anchorView", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "e", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "popupWindow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class QQMenuDispatchTouchEventLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View anchorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BubblePopupWindow popupWindow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQMenuDispatchTouchEventLinearLayout(@NotNull Context context, @NotNull View anchorView, @Nullable BubblePopupWindow bubblePopupWindow) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, anchorView, bubblePopupWindow);
        } else {
            this.anchorView = anchorView;
            this.popupWindow = bubblePopupWindow;
        }
    }

    private final boolean a(MotionEvent ev5) {
        BubblePopupWindow bubblePopupWindow;
        View rootView;
        BubblePopupWindow bubblePopupWindow2;
        int actionMasked = ev5.getActionMasked();
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3) && (bubblePopupWindow2 = this.popupWindow) != null) {
                bubblePopupWindow2.F(false);
            }
        } else if (b(ev5) && (bubblePopupWindow = this.popupWindow) != null) {
            bubblePopupWindow.F(true);
        }
        Context context = this.anchorView.getContext();
        if (context instanceof Activity) {
            rootView = ((Activity) context).getWindow().getDecorView();
        } else {
            rootView = this.anchorView.getRootView();
        }
        rootView.getLocationOnScreen(new int[2]);
        ev5.setLocation(ev5.getRawX() - r3[0], ev5.getRawY() - r3[1]);
        return rootView.dispatchTouchEvent(ev5);
    }

    private final boolean b(MotionEvent ev5) {
        boolean z16;
        boolean z17;
        int rawX = (int) ev5.getRawX();
        int rawY = (int) ev5.getRawY();
        int[] iArr = new int[2];
        this.anchorView.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int width = this.anchorView.getWidth() + i3;
        int height = this.anchorView.getHeight() + i16;
        if (i3 <= rawX && rawX <= width) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (i16 <= rawY && rawY <= height) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (getRootView().getAlpha() == 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (a(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}
