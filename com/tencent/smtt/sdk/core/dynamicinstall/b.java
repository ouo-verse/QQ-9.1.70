package com.tencent.smtt.sdk.core.dynamicinstall;

import com.tencent.smtt.utils.TbsLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f369314a = "DynamicInstall";

    public static c a(byte[] bArr) {
        int i3 = 0;
        try {
            c cVar = new c();
            int i16 = 216;
            cVar.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, 0, 216));
            try {
                cVar.b(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, 216, 32));
                int a16 = com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, 248, 4));
                cVar.a(a16);
                cVar.c(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, 252, a16));
                int i17 = 252 + a16;
                int a17 = com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, i17, 4));
                cVar.b(a17);
                i16 = i17 + 4;
                cVar.d(com.tencent.smtt.sdk.core.dynamicinstall.b.e.a(bArr, i16, a17));
                i3 = a17 + i16;
                cVar.c(i3);
                return cVar;
            } catch (Exception unused) {
                i3 = i16;
                TbsLog.w(f369314a, "Config File broken (" + i3 + ")");
                return null;
            }
        } catch (Exception unused2) {
        }
    }

    public static String b(c cVar) throws Exception {
        return com.tencent.smtt.sdk.core.dynamicinstall.b.a.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.b(cVar.c()), com.tencent.smtt.sdk.core.dynamicinstall.b.e.b(cVar.b()));
    }

    public static boolean a(c cVar) throws Exception {
        return com.tencent.smtt.sdk.core.dynamicinstall.b.d.a(cVar.c(), com.tencent.smtt.sdk.core.dynamicinstall.b.b.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.b(cVar.d())), com.tencent.smtt.sdk.core.dynamicinstall.b.b.a(com.tencent.smtt.sdk.core.dynamicinstall.b.e.b(cVar.a())));
    }
}
