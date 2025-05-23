package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.cp.x;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class FileUnlink {
    static {
        h.b("appbrandcommon", FileUnlink.class.getClassLoader());
    }

    public static native int unlink(String str);

    public static int vfsUnlink(String str) {
        return unlink(x.b(str, true));
    }
}
