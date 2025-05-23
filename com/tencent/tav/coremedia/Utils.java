package com.tencent.tav.coremedia;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Utils {
    public static void checkNotNull(Object obj) {
        if (obj != null) {
            return;
        }
        Logger.e("CoreMedia", "obj is null!", new NullPointerException());
    }
}
