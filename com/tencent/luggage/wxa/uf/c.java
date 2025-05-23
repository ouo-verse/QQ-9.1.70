package com.tencent.luggage.wxa.uf;

import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends k0 {
    public static final int CTRL_INDEX = 790;

    @NotNull
    public static final String NAME = "onNFCDiscovered";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142320a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(c cVar, byte[] bArr, List list, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        cVar.a(bArr, list, hashMap);
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c setContext(com.tencent.luggage.wxa.xd.d dVar) {
        k0 context = super.setContext(dVar);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
        return (c) context;
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    public void dispatch() {
        w.a("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", "dispatch, data: " + getData());
        super.dispatch();
    }

    public final void a(byte[] bArr, List techs, HashMap hashMap) {
        Map<String, Object> mapOf;
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(techs, "techs");
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] encode = Base64.encode(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(id ?: ByteArray(0), Base64.NO_WRAP)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(encode, UTF_8);
        if (hashMap == null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("id", str), TuplesKt.to("techs", techs));
            map = mapOf;
        } else {
            hashMap.put("id", str);
            hashMap.put("techs", techs);
            map = hashMap;
        }
        setData(map).dispatch();
    }
}
