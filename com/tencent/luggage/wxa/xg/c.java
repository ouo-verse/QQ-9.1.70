package com.tencent.luggage.wxa.xg;

import com.tencent.luggage.wxa.tn.w;
import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f144916a;

    public c(Function1 srcStreamProvider) {
        Intrinsics.checkNotNullParameter(srcStreamProvider, "srcStreamProvider");
        this.f144916a = srcStreamProvider;
    }

    public boolean a(String src) {
        boolean a16;
        Intrinsics.checkNotNullParameter(src, "src");
        InputStream inputStream = (InputStream) this.f144916a.invoke(src);
        if (inputStream != null) {
            try {
                try {
                    a16 = b.f144915a.a(inputStream);
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.ContainerFormatInferer", e16, "judge isHls fail", new Object[0]);
                    a16 = b.f144915a.a(src);
                }
                CloseableKt.closeFinally(inputStream, null);
                return a16;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(inputStream, th5);
                    throw th6;
                }
            }
        }
        return b.f144915a.a(src);
    }
}
