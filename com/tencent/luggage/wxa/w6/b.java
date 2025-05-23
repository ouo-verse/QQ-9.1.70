package com.tencent.luggage.wxa.w6;

import com.tencent.luggage.wxa.ae.g;
import com.tencent.luggage.wxa.ae.o;
import com.tencent.luggage.wxa.e7.a;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.n3.i;
import com.tencent.luggage.wxa.tj.e;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends o {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f144100a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f144101b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f144102c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f144103d;

        public a(d dVar, int i3, g gVar, b bVar) {
            this.f144100a = dVar;
            this.f144101b = i3;
            this.f144102c = gVar;
            this.f144103d = bVar;
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f144100a.a(this.f144101b, message);
            g gVar = this.f144102c;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                str = "fail " + ((Throwable) obj).getMessage();
            } else {
                str = "fail " + obj;
            }
            this.f144100a.a(this.f144101b, this.f144103d.makeReturnJson(str));
            g gVar = this.f144102c;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void b() {
        }
    }

    @Override // com.tencent.luggage.wxa.ae.o
    public boolean a(d dVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, g gVar, Object obj) {
        String str;
        String str2;
        if (dVar == null || !(obj instanceof i)) {
            return false;
        }
        com.tencent.luggage.wxa.e7.a aVar = com.tencent.luggage.wxa.e7.a.f124576a;
        String name = getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.name");
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = null;
        }
        if (jSONObject2 != null) {
            str2 = jSONObject2.toString();
        } else {
            str2 = null;
        }
        aVar.a(new e(dVar, name, str, str2, i3), new a(dVar, i3, gVar, this), obj);
        return true;
    }
}
