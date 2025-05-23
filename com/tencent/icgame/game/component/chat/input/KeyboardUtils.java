package com.tencent.icgame.game.component.chat.input;

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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class KeyboardUtils {

    /* renamed from: a, reason: collision with root package name */
    private static int f114895a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Window f114896d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f114897e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f114898f;

        a(Window window, int[] iArr, b bVar) {
            this.f114896d = window;
            this.f114897e = iArr;
            this.f114898f = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int b16 = KeyboardUtils.b(this.f114896d);
            if (this.f114897e[0] != b16) {
                this.f114898f.a(b16);
                this.f114897e[0] = b16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(@NonNull Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= ScreenUtil.getNavigationBarHeight(BaseApplication.getContext()) + ViewUtils.getStatusBarHeight(BaseApplication.getContext())) {
            f114895a = abs;
            return 0;
        }
        return abs - f114895a;
    }

    public static void c(@NonNull View view, @NonNull Window window, @NonNull b bVar) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        a aVar = new a(window, new int[]{b(window)}, bVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        view.setTag(-8, aVar);
    }

    public static void d(@NonNull View view) {
        e(view, 0);
    }

    public static void e(@NonNull View view, int i3) {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i3, new ResultReceiver(new Handler()) { // from class: com.tencent.icgame.game.component.chat.input.KeyboardUtils.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                if (i16 == 1 || i16 == 3) {
                    KeyboardUtils.f();
                }
            }
        });
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void f() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void g(@NonNull View view, @NonNull Window window) {
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
