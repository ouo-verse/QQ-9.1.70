package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020\u0007\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010!R(\u0010'\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/c;", "", "", "f", "j", "e", h.F, "", "a", "Ljava/lang/String;", "logTag", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "b", "Ljava/lang/ref/WeakReference;", "editTextRef", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "onWindowBeFocusedAction", "", "d", "Z", "isListenerAdded", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "windowFocusChangeListener", "getExternalWindowFocusChangeListener", "()Ljava/lang/ref/WeakReference;", "setExternalWindowFocusChangeListener", "(Ljava/lang/ref/WeakReference;)V", "externalWindowFocusChangeListener", "Landroid/view/inputmethod/InputMethodManager;", "()Landroid/view/inputmethod/InputMethodManager;", "imm", "value", "()Landroid/view/View;", "i", "(Landroid/view/View;)V", "editText", "prefix", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> editTextRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable onWindowBeFocusedAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isListenerAdded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnWindowFocusChangeListener windowFocusChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<ViewTreeObserver.OnWindowFocusChangeListener> externalWindowFocusChangeListener;

    public c(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.logTag = prefix + ".ImeHelper";
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.a
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z16) {
                c.k(c.this, z16);
            }
        };
    }

    private final InputMethodManager d() {
        Object obj;
        Context context;
        View c16 = c();
        if (c16 != null && (context = c16.getContext()) != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (!(obj instanceof InputMethodManager)) {
            return null;
        }
        return (InputMethodManager) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.logTag, 1, "[requestFocusAndShowKeyboard] onWindowBeFocusedAction");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c this$0, boolean z16) {
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.logTag, 1, "windowFocusChange: " + z16);
        if (z16) {
            Runnable runnable = this$0.onWindowBeFocusedAction;
            if (runnable != null) {
                runnable.run();
            }
            this$0.onWindowBeFocusedAction = null;
        }
        WeakReference<ViewTreeObserver.OnWindowFocusChangeListener> weakReference = this$0.externalWindowFocusChangeListener;
        if (weakReference != null && (onWindowFocusChangeListener = weakReference.get()) != null) {
            onWindowFocusChangeListener.onWindowFocusChanged(z16);
        }
    }

    @Nullable
    public final View c() {
        WeakReference<View> weakReference = this.editTextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void e() {
        IBinder iBinder;
        InputMethodManager d16 = d();
        if (d16 != null) {
            View c16 = c();
            if (c16 != null) {
                iBinder = c16.getWindowToken();
            } else {
                iBinder = null;
            }
            d16.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    public final void f() {
        View c16 = c();
        if (c16 != null) {
            if (!this.isListenerAdded) {
                ViewTreeObserver viewTreeObserver = c16.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnWindowFocusChangeListener(this.windowFocusChangeListener);
                }
                this.isListenerAdded = true;
            }
            c16.requestFocus();
            if (c16.hasWindowFocus()) {
                QLog.i(this.logTag, 1, "[requestFocusAndShowKeyboard] hasWindowFocus");
                j();
            } else {
                this.onWindowBeFocusedAction = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.g(c.this);
                    }
                };
            }
        }
    }

    public final void h() {
        ViewTreeObserver viewTreeObserver;
        QLog.i(this.logTag, 1, "[resetState]: removeOnWindowFocusChangeListener " + this.windowFocusChangeListener.hashCode());
        this.isListenerAdded = false;
        View c16 = c();
        if (c16 != null && (viewTreeObserver = c16.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.windowFocusChangeListener);
        }
        this.onWindowBeFocusedAction = null;
    }

    public final void i(@Nullable View view) {
        this.editTextRef = new WeakReference<>(view);
    }

    public final void j() {
        boolean z16;
        View c16;
        try {
            View c17 = c();
            if (c17 != null && c17.getContext() != null) {
                View c18 = c();
                boolean z17 = false;
                if (c18 != null && c18.isFocused()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && (c16 = c()) != null) {
                    c16.requestFocus();
                }
                InputMethodManager d16 = d();
                if (d16 != null) {
                    z17 = d16.showSoftInput(c(), 1);
                }
                if (!z17) {
                    QLog.e(this.logTag, 1, "showSoftInput fail");
                }
            }
        } catch (Throwable th5) {
            QLog.i(this.logTag, 1, "[showSoftInput], " + th5);
        }
    }
}
