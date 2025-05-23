package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.cp.x;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class ZipJNI {
    static {
        h.b("appbrandcommon", ZipJNI.class.getClassLoader());
    }

    public static native int unzip(String str, String str2, String str3);

    public static int vfsUnzip(String str, String str2, String str3) {
        return unzip(x.b(str, false), x.b(str2, true), str3);
    }
}
