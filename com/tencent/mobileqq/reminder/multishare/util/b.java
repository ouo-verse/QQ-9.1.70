package com.tencent.mobileqq.reminder.multishare.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\u0004H\u0016R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/util/b;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "host", "", "a", "c", "Lcom/tencent/mobileqq/reminder/multishare/util/a;", "listener", "b", "onGlobalLayout", "Lmqq/util/WeakReference;", "Landroid/view/View;", "d", "Lmqq/util/WeakReference;", "mRootViewRef", "e", "mKeyboardEventListener", "", "f", "I", "mWindowHeight", "<init>", "()V", h.F, "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mRootViewRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<a> mKeyboardEventListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mWindowHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/util/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.multishare.util.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30707);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull IPartHost host) {
        ViewTreeObserver viewTreeObserver;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
            return;
        }
        Intrinsics.checkNotNullParameter(host, "host");
        View view = null;
        this.mRootViewRef = null;
        this.mWindowHeight = 0;
        Activity hostActivity = host.getHostActivity();
        if (hostActivity != null && (window = hostActivity.getWindow()) != null) {
            view = window.getDecorView();
        }
        if (view != null) {
            this.mRootViewRef = new WeakReference<>(view);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            this.mWindowHeight = height;
            QLog.d("SoftKeyboardHelper", 1, "register observer windowHeight: " + height);
        }
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    public final void b(@Nullable a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        this.mKeyboardEventListener = null;
        if (listener != null) {
            this.mKeyboardEventListener = new WeakReference<>(listener);
        }
    }

    public final void c() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("SoftKeyboardHelper", 1, "unregister observer");
        WeakReference<View> weakReference = this.mRootViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.mRootViewRef = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        WeakReference<View> weakReference = this.mRootViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            QLog.d("SoftKeyboardHelper", 1, "onGlobalLayout current: " + height + " windowHeight: " + this.mWindowHeight);
            int i3 = this.mWindowHeight;
            if (i3 != 0 && i3 >= height) {
                WeakReference<a> weakReference2 = this.mKeyboardEventListener;
                if (weakReference2 != null && (aVar = weakReference2.get()) != null) {
                    int i16 = this.mWindowHeight;
                    int i17 = i16 - height;
                    if (i17 > i16 / 4) {
                        aVar.M(i17);
                        return;
                    } else {
                        aVar.onKeyboardHide();
                        return;
                    }
                }
                return;
            }
            this.mWindowHeight = rect.height();
        }
    }
}
