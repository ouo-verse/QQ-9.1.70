package com.tencent.av.video.effect;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavVideoEffect {
    public static boolean DEBUG_MODE = false;
    private static volatile QavVideoEffect mInstance;

    QavVideoEffect(Context context) {
    }

    public static QavVideoEffect getInstance(Context context) {
        if (mInstance == null) {
            synchronized (QavVideoEffect.class) {
                if (mInstance == null) {
                    mInstance = new QavVideoEffect(context);
                }
            }
        }
        return mInstance;
    }
}
