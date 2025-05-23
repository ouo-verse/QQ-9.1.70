package com.tencent.mobileqq.qqlive.widget.util;

import android.R;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class KeyboardUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f274055a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Window f274056d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f274057e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f274058f;

        a(Window window, int[] iArr, b bVar) {
            this.f274056d = window;
            this.f274057e = iArr;
            this.f274058f = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, window, iArr, bVar);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int b16 = KeyboardUtils.b(this.f274056d);
                if (this.f274057e[0] != b16) {
                    this.f274058f.a(b16);
                    this.f274057e[0] = b16;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TroopApplicationListUtil.STATUS_CODE_HAS_ADDED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274055a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(@NonNull Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        QLog.d("KeyboardUtils", 4, "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= ScreenUtil.getNavigationBarHeight(BaseApplication.getContext()) + ViewUtils.getStatusBarHeight(BaseApplication.getContext())) {
            f274055a = abs;
            return 0;
        }
        return abs - f274055a;
    }

    public static void c(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void d(@NonNull View view, @NonNull Window window, @NonNull b bVar) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        a aVar = new a(window, new int[]{b(window)}, bVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        view.setTag(-8, aVar);
    }

    public static void e(@NonNull View view) {
        f(view, 0);
    }

    public static void f(@NonNull View view, int i3) {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i3, new ResultReceiver(new Handler()) { // from class: com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils.1
            static IPatchRedirector $redirector_;

            {
                super(r4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i16, (Object) bundle);
                } else if (i16 == 1 || i16 == 3) {
                    KeyboardUtils.g();
                }
            }
        });
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void g() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void h(@NonNull View view, @NonNull Window window) {
        View findViewById = window.findViewById(R.id.content);
        if (findViewById == null) {
            return;
        }
        Object tag = view.getTag(-8);
        if (tag instanceof ViewTreeObserver.OnGlobalLayoutListener) {
            findViewById.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
        }
    }
}
