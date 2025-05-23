package com.tencent.luggage.wxa.lf;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.lf.b;
import com.tencent.luggage.wxa.lf.d;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.ml.o;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 640;

    @NotNull
    public static final String NAME = "requestSubscribeMessage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133380a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(a aVar, com.tencent.luggage.wxa.r4.d dVar, c cVar, int i3, String str, Map map, int i16, int i17, Object obj) {
            if ((i17 & 16) != 0) {
                map = null;
            }
            Map map2 = map;
            if ((i17 & 32) != 0) {
                i16 = -1;
            }
            aVar.a(dVar, cVar, i3, str, map2, i16);
        }

        public final void a(com.tencent.luggage.wxa.r4.d service, c jsapi, int i3, String status, Map map, int i16) {
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(jsapi, "jsapi");
            Intrinsics.checkNotNullParameter(status, "status");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i16 != -1 && i16 != 0) {
                linkedHashMap.put("errCode", Integer.valueOf(i16));
            }
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            String makeReturnJson = jsapi.makeReturnJson(status, linkedHashMap);
            w.d("JsApiRequestSubscribeMessage", "[callbackJsApi] return json:" + makeReturnJson);
            Unit unit = Unit.INSTANCE;
            service.a(i3, makeReturnJson);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.wb.b implements a.c {

        /* renamed from: b, reason: collision with root package name */
        public String f133382b;

        /* renamed from: c, reason: collision with root package name */
        public int f133383c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.sb.c f133384d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.r4.d f133385e;

        /* renamed from: f, reason: collision with root package name */
        public Integer f133386f;

        /* renamed from: g, reason: collision with root package name */
        public c f133387g;

        /* renamed from: h, reason: collision with root package name */
        public com.tencent.luggage.wxa.lf.b f133388h;

        /* renamed from: i, reason: collision with root package name */
        public com.tencent.luggage.wxa.lf.d f133389i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f133390j;

        /* renamed from: k, reason: collision with root package name */
        public static final C6437b f133381k = new C6437b(null);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lf.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6437b {
            public C6437b() {
            }

            public /* synthetic */ C6437b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String username, int i3) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.f133382b = username;
            this.f133383c = i3;
            this.f133390j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.wb.b
        public void f() {
            com.tencent.luggage.wxa.sb.c cVar;
            try {
                if (this.f133390j && (cVar = this.f133384d) != null) {
                    if (this.f133383c == 0) {
                        Intrinsics.checkNotNull(cVar);
                        if (cVar.k() != 0) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("fail:");
                            com.tencent.luggage.wxa.sb.c cVar2 = this.f133384d;
                            Intrinsics.checkNotNull(cVar2);
                            sb5.append(cVar2.l());
                            String sb6 = sb5.toString();
                            com.tencent.luggage.wxa.sb.c cVar3 = this.f133384d;
                            Intrinsics.checkNotNull(cVar3);
                            a(this, sb6, null, cVar3.k(), 2, null);
                            return;
                        }
                    }
                    if (this.f133383c == 0) {
                        com.tencent.luggage.wxa.lf.b bVar = this.f133388h;
                        if (bVar != null) {
                            com.tencent.luggage.wxa.r4.d dVar = this.f133385e;
                            Intrinsics.checkNotNull(dVar);
                            Context context = dVar.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "service!!.context");
                            com.tencent.luggage.wxa.sb.c cVar4 = this.f133384d;
                            Intrinsics.checkNotNull(cVar4);
                            bVar.a(context, cVar4);
                        }
                    } else {
                        com.tencent.luggage.wxa.lf.d dVar2 = this.f133389i;
                        if (dVar2 != null) {
                            com.tencent.luggage.wxa.r4.d dVar3 = this.f133385e;
                            Intrinsics.checkNotNull(dVar3);
                            Context context2 = dVar3.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "service!!.context");
                            com.tencent.luggage.wxa.sb.c cVar5 = this.f133384d;
                            Intrinsics.checkNotNull(cVar5);
                            dVar2.a(context2, cVar5);
                        }
                    }
                    return;
                }
                if (this.f133383c == 0) {
                    a(this, "fail:Request list fail", null, 10002, 2, null);
                } else {
                    a(this, "fail:Request subscribe fail", null, 10003, 2, null);
                }
            } finally {
                e();
            }
        }

        @Override // com.tencent.luggage.wxa.wb.b
        public void g() {
            if (this.f133383c == 0) {
                com.tencent.luggage.wxa.lf.b bVar = this.f133388h;
                if (bVar != null) {
                    bVar.g();
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.lf.d dVar = this.f133389i;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final d.c h() {
            return new d();
        }

        public final com.tencent.luggage.wxa.sb.c i() {
            return this.f133384d;
        }

        public final com.tencent.luggage.wxa.lf.d j() {
            return this.f133389i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f133382b);
            parcel.writeInt(this.f133383c);
            parcel.writeParcelable(this.f133384d, i3);
            parcel.writeParcelable(this.f133388h, i3);
            parcel.writeParcelable(this.f133389i, i3);
            parcel.writeInt(this.f133390j ? 1 : 0);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lf.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6438c implements b.c {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.lf.c$b$c$a */
            /* loaded from: classes8.dex */
            public static final class a implements o {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f133392a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ o f133393b;

                public a(b bVar, o oVar) {
                    this.f133392a = bVar;
                    this.f133393b = oVar;
                }

                @Override // com.tencent.luggage.wxa.ml.o
                public void a(m mVar) {
                    e runtime;
                    r H;
                    com.tencent.luggage.wxa.r4.d dVar = this.f133392a.f133385e;
                    if (dVar != null && (runtime = dVar.getRuntime()) != null && (H = runtime.H()) != null) {
                        H.a(this);
                    }
                    this.f133393b.a(mVar);
                }
            }

            public C6438c() {
            }

            @Override // com.tencent.luggage.wxa.lf.b.c
            public void a(m dialog) {
                e runtime;
                r H;
                com.tencent.luggage.wxa.wj.c D;
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                com.tencent.luggage.wxa.r4.d dVar = b.this.f133385e;
                if ((dVar == null || (D = dVar.D()) == null || !D.isLargeScreenWindow()) ? false : true) {
                    com.tencent.luggage.wxa.ub.d dVar2 = dialog instanceof com.tencent.luggage.wxa.ub.d ? (com.tencent.luggage.wxa.ub.d) dialog : null;
                    if (dVar2 != null) {
                        dVar2.f(1);
                    }
                }
                com.tencent.luggage.wxa.r4.d dVar3 = b.this.f133385e;
                if (dVar3 == null || (runtime = dVar3.getRuntime()) == null || (H = runtime.H()) == null) {
                    return;
                }
                H.a(dialog);
            }

            @Override // com.tencent.luggage.wxa.lf.b.c
            public void a(m dialog, o listener) {
                e runtime;
                r H;
                e runtime2;
                r H2;
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(listener, "listener");
                com.tencent.luggage.wxa.r4.d dVar = b.this.f133385e;
                if (dVar != null && (runtime2 = dVar.getRuntime()) != null && (H2 = runtime2.H()) != null) {
                    H2.b(new a(b.this, listener));
                }
                com.tencent.luggage.wxa.r4.d dVar2 = b.this.f133385e;
                if (dVar2 == null || (runtime = dVar2.getRuntime()) == null || (H = runtime.H()) == null) {
                    return;
                }
                H.b(dialog);
            }

            @Override // com.tencent.luggage.wxa.lf.b.c
            public void a(String username, List items, com.tencent.luggage.wxa.sb.b bVar) {
                List mutableList;
                Intrinsics.checkNotNullParameter(username, "username");
                Intrinsics.checkNotNullParameter(items, "items");
                com.tencent.luggage.wxa.lf.d j3 = b.this.j();
                if (j3 != null) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) items);
                    j3.a(mutableList);
                }
                com.tencent.luggage.wxa.lf.d j16 = b.this.j();
                if (j16 != null) {
                    com.tencent.luggage.wxa.sb.c i3 = b.this.i();
                    j16.a(i3 != null ? i3.d() : null);
                }
                com.tencent.luggage.wxa.lf.d j17 = b.this.j();
                if (j17 != null) {
                    j17.a(bVar);
                }
                b.this.f133383c = 1;
                b.this.b();
            }

            @Override // com.tencent.luggage.wxa.lf.b.c
            public void a(int i3, int i16, String errMsg, com.tencent.luggage.wxa.sb.c cVar) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                b.this.a(i3, i16, errMsg, cVar);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(String username, String appid, int i3, List tmplIds, int i16, c jsapi, com.tencent.luggage.wxa.r4.d service, int i17) {
            this(username, i16);
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(appid, "appid");
            Intrinsics.checkNotNullParameter(tmplIds, "tmplIds");
            Intrinsics.checkNotNullParameter(jsapi, "jsapi");
            Intrinsics.checkNotNullParameter(service, "service");
            this.f133387g = jsapi;
            this.f133385e = service;
            this.f133386f = Integer.valueOf(i17);
            com.tencent.luggage.wxa.lf.a aVar = com.tencent.luggage.wxa.lf.a.f133339a;
            aVar.a(username, appid);
            com.tencent.luggage.wxa.lf.b bVar = new com.tencent.luggage.wxa.lf.b(username, tmplIds, a(tmplIds), appid, i3);
            bVar.a(aVar);
            this.f133388h = bVar;
            com.tencent.luggage.wxa.lf.d dVar = new com.tencent.luggage.wxa.lf.d(username, h());
            dVar.a(aVar);
            this.f133389i = dVar;
        }

        public final b.c a(List list) {
            return new C6438c();
        }

        public static /* synthetic */ void a(b bVar, String str, Map map, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                map = null;
            }
            if ((i16 & 4) != 0) {
                i3 = -1;
            }
            bVar.a(str, map, i3);
        }

        public final void a(String str, Map map, int i3) {
            a aVar = c.f133380a;
            com.tencent.luggage.wxa.r4.d dVar = this.f133385e;
            Intrinsics.checkNotNull(dVar);
            c cVar = this.f133387g;
            Intrinsics.checkNotNull(cVar);
            Integer num = this.f133386f;
            Intrinsics.checkNotNull(num);
            aVar.a(dVar, cVar, num.intValue(), str, map, i3);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements d.c {
            public d() {
            }

            @Override // com.tencent.luggage.wxa.lf.d.c
            public void a(com.tencent.luggage.wxa.sb.c result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.m()) {
                    b.a(b.this, "cancel", null, 0, 6, null);
                    return;
                }
                HashMap hashMap = new HashMap();
                for (com.tencent.luggage.wxa.sb.d dVar : result.i()) {
                    hashMap.put(dVar.f(), dVar.j());
                }
                b.this.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap, 0);
            }

            @Override // com.tencent.luggage.wxa.lf.d.c
            public void a(int i3, int i16, String errMsg, com.tencent.luggage.wxa.sb.c cVar) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                b.this.a(i3, i16, errMsg, cVar);
            }
        }

        @Override // com.tencent.luggage.wxa.tb.a.c
        public void a(int i3, int i16, String errMsg, com.tencent.luggage.wxa.sb.c cVar) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            w.d("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + i3 + " errCode:" + i16 + " errMsg:" + errMsg + " result" + cVar);
            this.f133390j = i3 == 0 && i16 == 0;
            this.f133384d = cVar;
            a();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(Parcel parcel) {
            this(r0 == null ? "" : r0, parcel.readInt());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            this.f133384d = (com.tencent.luggage.wxa.sb.c) parcel.readParcelable(com.tencent.luggage.wxa.sb.c.class.getClassLoader());
            this.f133388h = (com.tencent.luggage.wxa.lf.b) parcel.readParcelable(com.tencent.luggage.wxa.lf.b.class.getClassLoader());
            this.f133389i = (com.tencent.luggage.wxa.lf.d) parcel.readParcelable(com.tencent.luggage.wxa.lf.d.class.getClassLoader());
            com.tencent.luggage.wxa.lf.b bVar = this.f133388h;
            Intrinsics.checkNotNull(bVar);
            com.tencent.luggage.wxa.lf.b bVar2 = this.f133388h;
            Intrinsics.checkNotNull(bVar2);
            bVar.a(a(bVar2.e()));
            com.tencent.luggage.wxa.lf.d dVar = this.f133389i;
            Intrinsics.checkNotNull(dVar);
            dVar.a(h());
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        w.d("JsApiRequestSubscribeMessage", "JsApiRequestSubscribeMessage invoked");
        if (jSONObject == null) {
            Intrinsics.checkNotNull(dVar);
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("tmplIds");
        ArrayList arrayList = new ArrayList();
        if (jSONArray.length() == 0) {
            a aVar = f133380a;
            Intrinsics.checkNotNull(dVar);
            a.a(aVar, dVar, this, i3, "fail:TmplIds can't be empty", null, 10001, 16, null);
            return;
        }
        try {
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                Object obj = jSONArray.get(i16);
                if (!(obj instanceof String)) {
                    a aVar2 = f133380a;
                    Intrinsics.checkNotNull(dVar);
                    a.a(aVar2, dVar, this, i3, "fail:Invalid template id", null, 10004, 16, null);
                    return;
                }
                arrayList.add(obj);
            }
            Intrinsics.checkNotNull(dVar);
            String str = dVar.getRuntime().S().G;
            Intrinsics.checkNotNullExpressionValue(str, "env!!.runtime.initConfig.username");
            String str2 = dVar.getRuntime().S().f125808a;
            Intrinsics.checkNotNullExpressionValue(str2, "env!!.runtime.initConfig.appId");
            b bVar = new b(str, str2, dVar.getRuntime().S().I, arrayList, 0, this, dVar, i3);
            bVar.b();
            bVar.d();
        } catch (JSONException unused) {
            Intrinsics.checkNotNull(dVar);
            dVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }
}
