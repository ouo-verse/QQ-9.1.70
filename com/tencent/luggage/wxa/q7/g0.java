package com.tencent.luggage.wxa.q7;

import com.tencent.xweb.XWebSdk;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g0 extends a0 {

    /* renamed from: e, reason: collision with root package name */
    public static final g0 f137975e = new g0();

    /* renamed from: f, reason: collision with root package name */
    public static final String f137976f = "Luggage.WxaXWebUpdater";

    /* renamed from: g, reason: collision with root package name */
    public static final long f137977g = TimeUnit.MINUTES.toMillis(30);

    @Override // com.tencent.luggage.wxa.q7.a0
    public void b() {
        boolean endsWith$default;
        try {
            String libDirPath = com.tencent.luggage.wxa.tn.z.c().getDir("libs", 0).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(libDirPath, "libDirPath");
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(libDirPath, separator, false, 2, null);
            if (!endsWith$default) {
                libDirPath = libDirPath + separator;
            }
            com.tencent.luggage.wxa.cp.x.c(new com.tencent.luggage.wxa.cp.v(libDirPath, "libbspatch_utils.so").g());
        } catch (Exception unused) {
        }
        try {
            XWebSdk.startCheck(com.tencent.luggage.wxa.tn.z.c(), null);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b(h(), "doCheck get exception " + e16);
        }
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public long c() {
        return f137977g;
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public String h() {
        return f137976f;
    }
}
