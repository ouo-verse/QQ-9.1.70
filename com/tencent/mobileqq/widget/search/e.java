package com.tencent.mobileqq.widget.search;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0019\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/widget/search/e;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/os/Handler$Callback;", "", "keyboardHeightInPx", "", "j", "i", "d", "heightDiff", h.F, "g", "k", "Lcom/tencent/mobileqq/widget/search/f;", "listener", "c", "onGlobalLayout", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/view/View;", "Landroid/view/View;", "getActivityRootView", "()Landroid/view/View;", "activityRootView", "e", "Z", "isSoftKeyboardOpened", "()Z", "setSoftKeyboardOpened", "(Z)V", "", "f", "Ljava/util/List;", "listeners", "I", "lastSoftKeyboardHeightInPx", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/view/View;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener, Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View activityRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpened;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> listeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastSoftKeyboardHeightInPx;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    public e(@NotNull View activityRootView, boolean z16) {
        Intrinsics.checkNotNullParameter(activityRootView, "activityRootView");
        this.activityRootView = activityRootView;
        this.isSoftKeyboardOpened = z16;
        this.listeners = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper(), this);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final void d() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.widget.search.c
            @Override // java.lang.Runnable
            public final void run() {
                e.e(e.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            final int g16 = this$0.g();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.widget.search.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(e.this, g16);
                }
            });
        } catch (Exception e16) {
            QLog.e(SoftKeyboardStateHelper.TAG, 2, "onGlobalLayout", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(e this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(i3);
    }

    private final int g() {
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        int height = (this.activityRootView.getRootView().getHeight() - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(this.activityRootView.getContext());
        if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
            QLog.d(SoftKeyboardStateHelper.TAG, 2, "onGlobalLayout , activityRootView.Height = " + this.activityRootView.getRootView().getHeight() + " heightDiff = " + height + " (r.bottom - r.top) = " + (rect.bottom - rect.top));
        }
        return height;
    }

    private final void h(int heightDiff) {
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && heightDiff > 200) {
            this.isSoftKeyboardOpened = true;
            j(heightDiff);
        } else if (z16 && heightDiff < 200) {
            this.isSoftKeyboardOpened = false;
            i();
        }
    }

    private final void i() {
        Iterator<f> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardClosed();
        }
    }

    private final void j(int keyboardHeightInPx) {
        this.lastSoftKeyboardHeightInPx = keyboardHeightInPx;
        Iterator<f> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSoftKeyboardOpened(keyboardHeightInPx);
        }
    }

    public final void c(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            d();
            return true;
        }
        return false;
    }

    public final void k() {
        this.listeners.clear();
        this.activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.handler.hasMessages(1)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.handler.sendMessageDelayed(obtain, 200L);
    }
}
