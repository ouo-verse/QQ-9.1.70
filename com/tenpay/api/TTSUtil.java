package com.tenpay.api;

import android.annotation.TargetApi;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TTSUtil {
    private static TextToSpeech sTts;

    public static void destroy() {
        TextToSpeech textToSpeech = sTts;
        if (textToSpeech != null) {
            textToSpeech.stop();
            sTts = null;
        }
    }

    public static boolean setTalkbackSwitch(Context context) {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (!isEnabled || !isTouchExplorationEnabled) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setViewContentDescription(View view, String str) {
        if (view != null && str != null) {
            try {
                view.setContentDescription(str);
            } catch (Exception unused) {
            }
        }
    }

    public static void speak(Context context, String str) {
        if (setTalkbackSwitch(context)) {
            try {
                if (sTts == null) {
                    sTts = new TextToSpeech(context.getApplicationContext(), null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                sTts.speak(str, 1, null);
            } catch (Exception unused) {
            }
        }
    }

    public static void stop() {
        try {
            TextToSpeech textToSpeech = sTts;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
        } catch (Exception unused) {
        }
    }

    @TargetApi(16)
    public static boolean speak(View view, String str) {
        if (!setTalkbackSwitch(view.getContext())) {
            return false;
        }
        try {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.setPackageName(view.getContext().getPackageName());
            obtain.setClassName(view.getClass().getName());
            obtain.setSource(view);
            obtain.getText().add(str);
            view.getParent().requestSendAccessibilityEvent(view, obtain);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
