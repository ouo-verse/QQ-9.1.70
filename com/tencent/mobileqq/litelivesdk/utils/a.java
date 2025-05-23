package com.tencent.mobileqq.litelivesdk.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, EditText editText) {
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void b(Context context, EditText editText) {
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInputFromWindow(editText.getWindowToken(), 0, 0);
    }
}
