package com.tencent.luggage.wxa.l6;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 249;

    @NotNull
    public static final String NAME = "getLocalImgData";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133065a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f133066a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f133067b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f133068c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133069d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f133070e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f133071f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f133072g;

        public b(String str, Ref.ObjectRef objectRef, float f16, com.tencent.luggage.wxa.k6.b bVar, int i3, f fVar, long j3) {
            this.f133066a = str;
            this.f133067b = objectRef;
            this.f133068c = f16;
            this.f133069d = bVar;
            this.f133070e = i3;
            this.f133071f = fVar;
            this.f133072g = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v4, types: [T, android.graphics.Bitmap] */
        @Override // java.lang.Runnable
        public final void run() {
            int coerceAtLeast;
            int coerceAtMost;
            try {
                int a16 = com.tencent.luggage.wxa.tn.b.a(this.f133066a);
                Ref.ObjectRef objectRef = this.f133067b;
                objectRef.element = com.tencent.luggage.wxa.tn.d.a((Bitmap) objectRef.element, a16);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (this.f133068c * 100), 10);
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 99);
                ((Bitmap) this.f133067b.element).compress(Bitmap.CompressFormat.JPEG, coerceAtMost, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String base64Content = Base64.encodeToString(byteArray, 2);
                HashMap hashMap = new HashMap();
                Intrinsics.checkNotNullExpressionValue(base64Content, "base64Content");
                hashMap.put(LocalDataJsPlugin.NAME_SPACE, base64Content);
                this.f133069d.a(this.f133070e, this.f133071f.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
                ((Bitmap) this.f133067b.element).recycle();
                w.d("MicroMsg.JsApiGetLocalImgData", "getLocalImgData rawData size = " + byteArray.length + ", base64 size = " + base64Content.length() + ", compressionRatio=" + this.f133068c + ", quality=" + coerceAtMost + ", degree=" + a16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getLocalImgData cost ");
                sb5.append(System.currentTimeMillis() - this.f133072g);
                w.a("MicroMsg.JsApiGetLocalImgData", sb5.toString());
            } catch (Exception e16) {
                this.f133069d.a(this.f133070e, this.f133071f.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
                w.b("MicroMsg.JsApiGetLocalImgData", "getLocalImgData fail %s", e16.getMessage());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, android.graphics.Bitmap] */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject data, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        String localId = data.optString("localId");
        Intrinsics.checkNotNullExpressionValue(localId, "localId");
        if (localId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            env.a(i3, makeReturnJson("fail_invaild_localid"));
            return;
        }
        float a16 = w0.a(data.optString("compressionRatio", "0.9"), 0.9f);
        String b16 = env.k().b(localId);
        if (b16 == null) {
            env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? a17 = com.tencent.luggage.wxa.tn.d.a(b16);
            objectRef.element = a17;
            if (a17 != 0 && !a17.isRecycled()) {
                com.tencent.luggage.wxa.zp.h.f146825d.b(new b(b16, objectRef, a16, env, i3, this, currentTimeMillis), "GetLocalImgDataThread");
            }
        } catch (Exception e16) {
            w.b("MicroMsg.JsApiGetLocalImgData", "getLocalImgData fail %s", e16.getMessage());
            env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }
}
