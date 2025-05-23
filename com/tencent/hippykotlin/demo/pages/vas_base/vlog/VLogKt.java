package com.tencent.hippykotlin.demo.pages.vas_base.vlog;

import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VLogKt {
    public static final VLog getClog(Object obj) {
        String simpleName = Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = "DEV";
        }
        return new VLog(simpleName);
    }
}
