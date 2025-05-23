package com.tencent.robot.adelie.homepage.create;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/ak;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "g", "", "onGlobalLayout", "Lcom/tencent/robot/adelie/homepage/create/ak$b;", "listener", "f", tl.h.F, "", "i", "Landroid/view/View;", "d", "Landroid/view/View;", "activityRootView", "e", "I", "screenHeight", "activityRootViewInitHeight", "Z", "isSoftKeyboardOpened", "lastSoftKeyboardHeightInPx", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/adelie/homepage/create/ak$b;", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ak implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View activityRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int activityRootViewInitHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpened;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastSoftKeyboardHeightInPx;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/ak$b;", "", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "a", "height", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(int keyboardHeightInPx);

        void b(int height);

        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int keyboardHeightInPx);
    }

    public ak(@NotNull View activityRootView) {
        Intrinsics.checkNotNullParameter(activityRootView, "activityRootView");
        this.activityRootView = activityRootView;
        this.screenHeight = activityRootView.getHeight();
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final int g() {
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        if (this.activityRootViewInitHeight == 0) {
            this.activityRootViewInitHeight = rect.height();
        }
        return this.activityRootViewInitHeight - (rect.bottom - rect.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final ak this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.activityRootView.getHeight() > 0) {
            i3 = this$0.activityRootView.getHeight();
        } else {
            i3 = ScreenUtil.SCREEN_HIGHT;
        }
        int i16 = i3 / 4;
        final int g16 = this$0.g();
        boolean z16 = this$0.isSoftKeyboardOpened;
        if (!z16 && g16 >= i16) {
            this$0.isSoftKeyboardOpened = true;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ak.k(ak.this, g16);
                }
            });
        } else if (z16 && g16 < i16) {
            this$0.isSoftKeyboardOpened = false;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ak.l(ak.this);
                }
            });
        }
        if (g16 != this$0.lastSoftKeyboardHeightInPx) {
            this$0.lastSoftKeyboardHeightInPx = g16;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.ai
                @Override // java.lang.Runnable
                public final void run() {
                    ak.m(ak.this, g16);
                }
            });
        }
        if (this$0.screenHeight != this$0.activityRootView.getHeight() && this$0.activityRootView.getHeight() > 0) {
            this$0.activityRootView.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.aj
                @Override // java.lang.Runnable
                public final void run() {
                    ak.n(ak.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ak this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onSoftKeyboardOpened(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onSoftKeyboardClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ak this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.screenHeight = this$0.activityRootView.getHeight();
        Rect rect = new Rect();
        this$0.activityRootView.getWindowVisibleDisplayFrame(rect);
        this$0.activityRootViewInitHeight = this$0.activityRootView.getHeight() - rect.top;
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.b(this$0.screenHeight);
        }
    }

    public final void f(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* renamed from: h, reason: from getter */
    public final int getLastSoftKeyboardHeightInPx() {
        return this.lastSoftKeyboardHeightInPx;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.af
                @Override // java.lang.Runnable
                public final void run() {
                    ak.j(ak.this);
                }
            }, 16, null, true);
        } catch (Exception e16) {
            QLog.i("AdelieSoftKeyboardHelper", 1, "onGlobalLayout error = " + e16);
        }
    }
}
