package com.xiaomi.push;

import android.system.Os;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class av {
    public static long a(String str) {
        try {
            if (!new File(str).exists()) {
                return 0L;
            }
            return Os.stat(str).st_size;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return 0L;
        }
    }
}
