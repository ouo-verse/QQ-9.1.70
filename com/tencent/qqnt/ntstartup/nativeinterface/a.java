package com.tencent.qqnt.ntstartup.nativeinterface;

import com.tencent.qqnt.ntstartup.nativeinterface.IQQNTStartupSessionWrapper;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static HashMap a(IQQNTStartupSessionWrapper iQQNTStartupSessionWrapper) {
        return new HashMap();
    }

    public static int b(IQQNTStartupSessionWrapper iQQNTStartupSessionWrapper) {
        return 0;
    }

    public static int c(IQQNTStartupSessionWrapper iQQNTStartupSessionWrapper) {
        return 0;
    }

    public static IQQNTStartupSessionWrapper d() {
        return IQQNTStartupSessionWrapper.CppProxy.create();
    }

    public static IQQNTStartupSessionWrapper e(HashSet<String> hashSet) {
        return IQQNTStartupSessionWrapper.CppProxy.createWithModuleList(hashSet);
    }
}
