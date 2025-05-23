package com.tencent.gdtad.config.data;

import com.google.gson.GsonBuilder;
import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l {
    public static String a(Object obj, String str) {
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
        } catch (Throwable th5) {
            GdtLog.e("GdtConfigUtil", "[toString]", th5);
            return str;
        }
    }
}
