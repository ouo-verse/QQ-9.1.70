package com.tencent.mobileqq.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bq {

    /* renamed from: a, reason: collision with root package name */
    private static TextToSpeech f306637a;

    public static void a() {
        TextToSpeech textToSpeech = f306637a;
        if (textToSpeech != null) {
            textToSpeech.stop();
            f306637a = null;
        }
    }

    public static void b(Context context) {
        if (f306637a == null) {
            f306637a = new TextToSpeech(context, null);
        }
    }

    public static void c(String str) {
        if (f306637a != null && !TextUtils.isEmpty(str)) {
            f306637a.speak(str, 1, null);
        }
    }
}
