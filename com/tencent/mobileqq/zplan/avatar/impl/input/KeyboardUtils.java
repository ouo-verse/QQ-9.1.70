package com.tencent.mobileqq.zplan.avatar.impl.input;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class KeyboardUtils {
    public static void a(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void c(View view, int i3) {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i3, new ResultReceiver(new Handler()) { // from class: com.tencent.mobileqq.zplan.avatar.impl.input.KeyboardUtils.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                if (i16 == 1 || i16 == 3) {
                    KeyboardUtils.d();
                }
            }
        });
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void d() {
        InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void b(View view) {
        c(view, 0);
    }
}
