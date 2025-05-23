package com.qq.e.comm.plugin.i.c;

import com.qq.e.comm.plugin.i.core.TimeLimitLRUCleanTask;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static com.qq.e.comm.plugin.i.core.b a(com.qq.e.comm.plugin.i.b bVar) {
        if (bVar == null) {
            GDTLogger.d("CleanTaskFactorytaskInfo is null");
            return null;
        }
        if (bVar.d() != 1) {
            return null;
        }
        return new TimeLimitLRUCleanTask(bVar);
    }
}
