package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedKeyboardUtils {
    public static void a(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    public static Runnable b(EditText editText) {
        return c(editText, 500);
    }

    public static Runnable c(final EditText editText, int i3) {
        if (editText == null) {
            return null;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedKeyboardUtils.1
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
            }
        };
        editText.postDelayed(runnable, i3);
        return runnable;
    }

    public static void d(Context context) {
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(2, 0);
    }
}
