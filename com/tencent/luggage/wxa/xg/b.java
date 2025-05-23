package com.tencent.luggage.wxa.xg;

import com.tencent.luggage.wxa.mg.n;
import com.tencent.luggage.wxa.tn.w;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f144915a = new b();

    public final boolean a(InputStream inputStream) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        int coerceAtMost;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        byte[] bArr = new byte[32768];
        int read = inputStream.read(bArr, 0, 1024);
        boolean z16 = false;
        int i3 = 0;
        while (-1 != read) {
            i3 += read;
            String str = new String(bArr, 0, i3, Charsets.UTF_8);
            if (!z16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "#EXTM3U", false, 2, null);
                if (!startsWith$default) {
                    w.d("MicroMsg.AppBrand.ContainerFormatInferCommons", "isHls, magicChecked fail");
                    return false;
                }
                z16 = true;
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "#EXT-X-STREAM-INF:", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "#EXT-X-TARGETDURATION:", false, 2, (Object) null);
                if (!contains$default2) {
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "#EXT-X-MEDIA-SEQUENCE:", false, 2, (Object) null);
                    if (!contains$default3) {
                        coerceAtMost = RangesKt___RangesKt.coerceAtMost(32768 - i3, 1024);
                        if (coerceAtMost <= 0) {
                            break;
                        }
                        read = inputStream.read(bArr, i3, coerceAtMost);
                    }
                }
            }
            w.d("MicroMsg.AppBrand.ContainerFormatInferCommons", "isHls, infer done, hadReadLen: " + i3);
            return true;
        }
        w.d("MicroMsg.AppBrand.ContainerFormatInferCommons", "isHls, infer done, hadReadLen: " + i3 + ", curReadLen: " + read);
        return false;
    }

    public final boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return n.a(url);
    }
}
