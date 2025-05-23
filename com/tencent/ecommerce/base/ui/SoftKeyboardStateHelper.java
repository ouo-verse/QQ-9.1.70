package com.tencent.ecommerce.base.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0002\n\u001fB\u001b\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "keyboardHeightInPx", "", "d", "c", "onGlobalLayout", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "listener", "a", "e", "", "Ljava/util/Set;", "listeners", "I", "lastSoftKeyboardHeightInPx", "Landroid/view/View;", "f", "Landroid/view/View;", "activityRootView", "", tl.h.F, "Z", "isSoftKeyboardOpened", "b", "()Z", "isKeyboardOpened", "<init>", "(Landroid/view/View;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "SoftKeyboardStateListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Set<SoftKeyboardStateListener> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastSoftKeyboardHeightInPx;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View activityRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpened;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f101133i = ECDeviceUtils.f104857e.d() / 4;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "onSoftKeyboardClosed", "", "onSoftKeyboardOpened", "keyboardHeightInPx", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int keyboardHeightInPx);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$a;", "", "Landroid/content/Context;", "context", "", "e", "Landroid/view/Window;", "window", "c", "Landroid/view/View;", "viewWithFocus", "b", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a", "Landroid/widget/EditText;", "editText", "f", "", "KEYBOARD_DEFAULT_HEIGHT", "I", "", "KEYBOARD_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Activity activity) {
            Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public final void b(View viewWithFocus) {
            Object systemService = viewWithFocus.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(viewWithFocus.getWindowToken(), 1);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public final void c(Window window) {
            View currentFocus = window.getCurrentFocus();
            if (currentFocus == null) {
                View decorView = window.getDecorView();
                View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
                if (findViewWithTag == null) {
                    findViewWithTag = new EditText(window.getContext());
                    findViewWithTag.setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
                    findViewWithTag.requestFocus();
                }
                currentFocus = findViewWithTag;
            }
            b(currentFocus);
        }

        public final void d(View viewWithFocus) {
            Object systemService = viewWithFocus.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(viewWithFocus.getWindowToken(), 2);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public final void e(Context context) {
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                ((InputMethodManager) systemService).toggleSoftInput(1, 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public final void f(EditText editText) {
            Object systemService = editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                inputMethodManager.showSoftInput(editText, 0);
                inputMethodManager.restartInput(editText);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SoftKeyboardStateHelper(View view, boolean z16) {
        this.activityRootView = view;
        this.isSoftKeyboardOpened = z16;
        this.listeners = new LinkedHashSet();
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private final void c() {
        if (cg0.a.c()) {
            cg0.a.b(com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.TAG, "notifyOnSoftKeyboardClosed");
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoftKeyboardStateListener) it.next()).onSoftKeyboardClosed();
        }
    }

    private final void d(int keyboardHeightInPx) {
        if (cg0.a.c()) {
            cg0.a.b(com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.TAG, "notifyOnSoftKeyboardOpened height=" + keyboardHeightInPx);
        }
        this.lastSoftKeyboardHeightInPx = keyboardHeightInPx;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoftKeyboardStateListener) it.next()).onSoftKeyboardOpened(keyboardHeightInPx);
        }
    }

    public final void a(SoftKeyboardStateListener listener) {
        this.listeners.add(listener);
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    public final void e(SoftKeyboardStateListener listener) {
        this.listeners.remove(listener);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.activityRootView.getWindowVisibleDisplayFrame(rect);
        int height = this.activityRootView.getRootView().getHeight() - (rect.bottom - rect.top);
        if (cg0.a.c()) {
            cg0.a.b(com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.TAG, "onGlobalLayout,rootViewHeight=" + this.activityRootView.getRootView().getHeight() + ",windowVisibleHeight=" + (rect.bottom - rect.top) + ",heightDiff=" + height + ",keyboardDefaultHeight=" + f101133i + ",isOpen=" + this.isSoftKeyboardOpened);
        }
        boolean z16 = this.isSoftKeyboardOpened;
        if (!z16 && height >= f101133i) {
            this.isSoftKeyboardOpened = true;
            d(height);
        } else {
            if (!z16 || height >= f101133i) {
                return;
            }
            this.isSoftKeyboardOpened = false;
            c();
        }
    }

    public /* synthetic */ SoftKeyboardStateHelper(View view, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? false : z16);
    }
}
