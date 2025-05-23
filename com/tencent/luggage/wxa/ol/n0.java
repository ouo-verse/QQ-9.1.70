package com.tencent.luggage.wxa.ol;

import com.tencent.luggage.wxa.cr.b;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f136895a = new n0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements b.a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f136896b = new a();

        @Override // com.tencent.luggage.wxa.cr.b.a
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FitRelativeLogic", "loadLibrary, libName: " + str);
            com.tencent.luggage.wxa.aa.h.g(str);
        }
    }

    static {
        com.tencent.luggage.wxa.cr.b.a(a.f136896b);
    }

    public final void a() {
    }

    public final String a(com.tencent.luggage.wxa.xd.d env, String certPath) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(certPath, "certPath");
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.rc.r fileSystem = env.getFileSystem();
        com.tencent.luggage.wxa.rc.l readFile = fileSystem != null ? fileSystem.readFile(certPath, iVar) : null;
        if (readFile != null) {
            if (com.tencent.luggage.wxa.rc.l.OK == readFile) {
                Object obj = iVar.f141499a;
                Intrinsics.checkNotNullExpressionValue(obj, "byteBufRef.value");
                return new String(f1.a((ByteBuffer) obj), Charsets.UTF_8);
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FitRelativeLogic", "getEncryptedData, opResult: " + readFile);
            throw new o0("certPath is illegal");
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FitRelativeLogic", "readCertPem, opResult is null");
        throw new o0("env error");
    }
}
