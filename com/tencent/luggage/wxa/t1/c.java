package com.tencent.luggage.wxa.t1;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.luggage.wxa.t1.d;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f140834b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d.InterfaceC6731d f140835a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.InterfaceC6731d bufferConfig) {
        super(bufferConfig);
        Intrinsics.checkNotNullParameter(bufferConfig, "bufferConfig");
        this.f140835a = bufferConfig;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "NativeBuffer";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        boolean startsWith$default;
        if (!(obj instanceof String)) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj, "nativebuffer://", false, 2, null);
        return startsWith$default;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        String substring;
        Integer intOrNull;
        d.a aVar = new d.a();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        substring = StringsKt__StringsKt.substring((String) obj, new IntRange(15, r4.length() - 1));
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(substring);
        if (intOrNull != null) {
            ByteBuffer a16 = this.f140835a.c().a(intOrNull.intValue(), false);
            if (a16 == null) {
                f.d("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: can not found buffer in buffer addon", new Object[0]);
                aVar.f129190b = "Not found native buffer in buffer addon!";
            } else {
                a16.position(0);
                byte[] bArr = new byte[a16.remaining()];
                a16.get(bArr);
                aVar.f129189a = new ByteArrayInputStream(bArr);
            }
        } else {
            f.d("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: not providing int as native buffer key!", new Object[0]);
            aVar.f129190b = "Not invalid native buffer key!";
        }
        return aVar;
    }
}
