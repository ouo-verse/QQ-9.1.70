package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.cp.x;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class FileStat {
    static {
        h.b("appbrandcommon", FileStat.class.getClassLoader());
    }

    public static native int stat(String str, @NonNull FileStructStat fileStructStat);

    public static int vfsStat(String str, @NonNull FileStructStat fileStructStat) {
        return stat(x.b(str, false), fileStructStat);
    }
}
