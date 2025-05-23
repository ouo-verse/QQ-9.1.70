package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork;

/* compiled from: P */
/* loaded from: classes24.dex */
public final /* synthetic */ class cj {
    public static long a(IQQNTWrapperNetwork iQQNTWrapperNetwork, IQQNTWrapperNetworkListener iQQNTWrapperNetworkListener) {
        return 0L;
    }

    public static NetStatusType b(IQQNTWrapperNetwork iQQNTWrapperNetwork) {
        return NetStatusType.KNOTREACHABLE;
    }

    public static boolean d(IQQNTWrapperNetwork iQQNTWrapperNetwork) {
        return false;
    }

    public static IQQNTWrapperNetwork f() {
        return IQQNTWrapperNetwork.CppProxy.openNetworkService();
    }

    public static void e(IQQNTWrapperNetwork iQQNTWrapperNetwork) {
    }

    public static void c(IQQNTWrapperNetwork iQQNTWrapperNetwork, long j3) {
    }
}
