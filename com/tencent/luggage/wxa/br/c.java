package com.tencent.luggage.wxa.br;

import android.content.Context;
import android.speech.tts.TextToSpeech;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static TextToSpeech f123141a;

    public static void a(Context context) {
        if (f123141a == null) {
            f123141a = new TextToSpeech(context.getApplicationContext(), null);
        }
    }

    public static void a() {
        TextToSpeech textToSpeech = f123141a;
        if (textToSpeech != null) {
            textToSpeech.stop();
            f123141a.shutdown();
            f123141a = null;
        }
    }
}
