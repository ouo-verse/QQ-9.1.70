package com.tencent.luggage.wxa.v6;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.e5.l;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.t0;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.m0;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ok.j;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v3.c;
import com.tencent.luggage.wxa.v3.m;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "sdk_navigateToMiniProgram";

    /* renamed from: a, reason: collision with root package name */
    public static final g f143260a = new g(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.s6.f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, com.tencent.luggage.wxa.g7.d rt5) {
            super(context, rt5);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rt5, "rt");
        }

        @Override // com.tencent.luggage.wxa.p5.d, com.tencent.luggage.wxa.kj.p.e0
        public v a(p container, String str) {
            Intrinsics.checkNotNullParameter(container, "container");
            return new com.tencent.luggage.wxa.s6.h(b.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.kj.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.xd.d t16 = b.this.t();
                Intrinsics.checkNotNull(t16);
                ((com.tencent.luggage.wxa.s6.h) t16).e("onLoadURL");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull com.tencent.luggage.wxa.s6.h p16) {
            super(p16);
            Intrinsics.checkNotNullParameter(p16, "p");
        }

        @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.kj.x
        public boolean a(String str, k1 type) {
            Intrinsics.checkNotNullParameter(type, "type");
            com.tencent.luggage.wxa.xd.d t16 = t();
            Intrinsics.checkNotNull(t16);
            ((com.tencent.luggage.wxa.s6.h) t16).a(new a());
            return true;
        }

        @Override // com.tencent.luggage.wxa.kj.a
        public o0 b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new m0();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v6.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6830c {

        /* renamed from: a, reason: collision with root package name */
        public static final C6830c f143262a = new C6830c();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v6.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a implements t0.a {

            /* renamed from: a, reason: collision with root package name */
            public static final a f143263a = new a();

            @Override // com.tencent.luggage.wxa.ic.t0.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.j4.g newInstance() {
                return new com.tencent.luggage.wxa.j4.g();
            }
        }

        public final com.tencent.luggage.wxa.j4.g a(f rt5) {
            com.tencent.luggage.wxa.j4.g a16;
            Intrinsics.checkNotNullParameter(rt5, "rt");
            n0 a17 = com.tencent.luggage.wxa.fd.o0.a().a(rt5.getAppId(), new String[0]);
            if (a17 == null) {
                a16 = new com.tencent.luggage.wxa.j4.g();
            } else {
                a16 = t0.a(a.f143263a, a17);
            }
            Intrinsics.checkNotNullExpressionValue(a16, "if (null == attrs) {\n   \u2026()}, attrs)\n            }");
            if (a16.f130831g0 == null) {
                a16.f130831g0 = com.tencent.luggage.wxa.fd.h.f125726o0;
            }
            a16.f125966l = new com.tencent.mm.plugin.appbrand.appcache.a();
            a16.f125966l.f151861a = rt5.l0();
            a16.f125966l.pkgVersion = rt5.C1();
            a16.f125966l.f151863c = true;
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends com.tencent.luggage.wxa.r5.a {
        public static final b Y0 = new b(null);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new d(source);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b {
            public b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final d a(com.tencent.luggage.wxa.r5.a that) {
                Intrinsics.checkNotNullParameter(that, "that");
                Parcel parcel = that.b();
                Intrinsics.checkNotNullExpressionValue(parcel, "parcel");
                d dVar = new d(parcel);
                OaidMonitor.parcelRecycle(parcel);
                return dVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {
        public g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k7.e f143265a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143266b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143267c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143268d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f143269e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c f143270f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.v3.c f143271a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.v6.c$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6831a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.v3.c f143272a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6831a(com.tencent.luggage.wxa.v3.c cVar) {
                    super(0);
                    this.f143272a = cVar;
                }

                public final void a() {
                    this.f143272a.c();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.v3.c cVar) {
                super(1);
                this.f143271a = cVar;
            }

            public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
                Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
                lifecycle.c(new C6831a(this.f143271a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((com.tencent.luggage.wxa.e5.h) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143273a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f143274b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f143275c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f143276d;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f143277a;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.v6.c$h$b$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6832a extends Lambda implements Function0 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ f f143278a;

                    /* compiled from: P */
                    /* renamed from: com.tencent.luggage.wxa.v6.c$h$b$a$a$a, reason: collision with other inner class name */
                    /* loaded from: classes8.dex */
                    public static final class RunnableC6833a implements Runnable {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ f f143279a;

                        public RunnableC6833a(f fVar) {
                            this.f143279a = fVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f143279a.D();
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6832a(f fVar) {
                        super(0);
                        this.f143278a = fVar;
                    }

                    public final void a() {
                        c0.a(new RunnableC6833a(this.f143278a));
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(f fVar) {
                    super(1);
                    this.f143277a = fVar;
                }

                public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
                    Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
                    lifecycle.a(new C6832a(this.f143277a));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((com.tencent.luggage.wxa.e5.h) obj);
                    return Unit.INSTANCE;
                }
            }

            public b(com.tencent.luggage.wxa.ic.d dVar, int i3, c cVar, f fVar) {
                this.f143273a = dVar;
                this.f143274b = i3;
                this.f143275c = cVar;
                this.f143276d = fVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
            
                if (r3 != false) goto L25;
             */
            @Override // com.tencent.luggage.wxa.xo.e.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(String str) {
                boolean contains$default;
                JSONObject jSONObject;
                boolean z16 = false;
                com.tencent.luggage.wxa.ic.c0 c0Var = null;
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) (str == null ? "" : str), (CharSequence) "sdk_navigateToMiniProgram:ok", false, 2, (Object) null);
                if (!contains$default) {
                    h.b(this.f143276d, this.f143273a, this.f143274b, this.f143275c, str);
                    return;
                }
                this.f143273a.a(this.f143274b, this.f143275c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e16) {
                    w.b("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", "on wechat invoke back, parse json failed, exception:" + e16 + ", json:" + str);
                    jSONObject = null;
                }
                if (!(jSONObject != null && jSONObject.has(WadlProxyConsts.EXTRA_DATA))) {
                    if (jSONObject != null && jSONObject.has("privateExtraData")) {
                        z16 = true;
                    }
                }
                c0Var = new com.tencent.luggage.wxa.ic.c0();
                c0Var.f129715b = jSONObject.optJSONObject(WadlProxyConsts.EXTRA_DATA);
                c0Var.f129716c = jSONObject.optJSONObject("privateExtraData");
                l lVar = l.f124555a;
                f fVar = this.f143276d;
                lVar.a(fVar, new a(fVar));
                this.f143276d.a(c0Var);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v6.c$h$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6834c implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f143280a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143281b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f143282c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ c f143283d;

            public C6834c(f fVar, com.tencent.luggage.wxa.ic.d dVar, int i3, c cVar) {
                this.f143280a = fVar;
                this.f143281b = dVar;
                this.f143282c = i3;
                this.f143283d = cVar;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object obj) {
                String str;
                f fVar = this.f143280a;
                com.tencent.luggage.wxa.ic.d dVar = this.f143281b;
                int i3 = this.f143282c;
                c cVar = this.f143283d;
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                h.b(fVar, dVar, i3, cVar, str);
            }
        }

        public h(com.tencent.luggage.wxa.k7.e eVar, com.tencent.luggage.wxa.ic.d dVar, String str, JSONObject jSONObject, int i3, c cVar) {
            this.f143265a = eVar;
            this.f143266b = dVar;
            this.f143267c = str;
            this.f143268d = jSONObject;
            this.f143269e = i3;
            this.f143270f = cVar;
        }

        public static final void b(f fVar, com.tencent.luggage.wxa.ic.d dVar, int i3, c cVar, String str) {
            boolean startsWith$default;
            w.b("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", "invoke appId:" + dVar.getAppId() + " callbackId:" + i3 + " navigateBackOnTransferFailure");
            fVar.D();
            if (str == null) {
                str = "";
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "fail", false, 2, null);
            if (!startsWith$default) {
                str = "fail " + str;
            }
            dVar.a(i3, cVar.makeReturnJson(str));
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.k7.e eVar = this.f143265a;
            com.tencent.luggage.wxa.ic.g runtime = this.f143266b.getRuntime();
            d.b bVar = d.Y0;
            i S = this.f143266b.getRuntime().S();
            Intrinsics.checkNotNull(S, "null cannot be cast to non-null type com.tencent.luggage.standalone_ext.config.RuntimeSDKInitConfigBase");
            d a16 = bVar.a((com.tencent.luggage.wxa.r5.a) S);
            String str = this.f143267c;
            com.tencent.luggage.wxa.ic.d dVar = this.f143266b;
            a16.f125808a = str;
            com.tencent.luggage.wxa.bk.e eVar2 = new com.tencent.luggage.wxa.bk.e();
            eVar2.f122984c = 1037;
            a16.a(eVar2);
            n nVar = a16.N;
            nVar.f125848b = dVar.getAppId();
            nVar.f125847a = 1;
            nVar.f125852f = dVar.getRuntime().Y().getCurrentUrl();
            Unit unit = Unit.INSTANCE;
            eVar.a(runtime, a16);
            com.tencent.luggage.wxa.ic.g f16 = this.f143265a.f();
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.jsapi.JsApiNavigateToMiniProgramBridged.BridgedWxaRuntime");
            f fVar = (f) f16;
            com.tencent.luggage.wxa.v3.c a17 = c.C6818c.a(this.f143266b);
            l.f124555a.a(fVar, new a(a17));
            m mVar = m.f143124a;
            com.tencent.luggage.wxa.v3.d dVar2 = new com.tencent.luggage.wxa.v3.d();
            JSONObject jSONObject = this.f143268d;
            int i3 = this.f143269e;
            dVar2.f143055a = a17;
            dVar2.f143056b = c.NAME;
            dVar2.f143057c = jSONObject.toString();
            dVar2.f143058d = i3;
            dVar2.f143059e = 1;
            mVar.a(dVar2).a(new b(this.f143266b, this.f143269e, this.f143270f, fVar)).a(new C6834c(fVar, this.f143266b, this.f143269e, this.f143270f));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d env, JSONObject data, int i3) {
        com.tencent.luggage.wxa.ic.v vVar;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        boolean a16 = m.f143124a.a(NAME);
        w.d("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", "invoke appId:" + env.getAppId() + ", callbackId:" + i3 + ", isWechatSupported:" + a16 + ", data:" + data);
        if (!a16) {
            env.a(i3, makeReturnJson("fail wechat not support"));
            com.tencent.luggage.wxa.d7.a.f124128a.a(env, R.string.zvt);
            return;
        }
        com.tencent.luggage.wxa.ic.g runtime = env.getRuntime();
        com.tencent.luggage.wxa.k7.e eVar = null;
        if (runtime != null) {
            vVar = runtime.e0();
        } else {
            vVar = null;
        }
        if (vVar instanceof com.tencent.luggage.wxa.k7.e) {
            eVar = (com.tencent.luggage.wxa.k7.e) vVar;
        }
        com.tencent.luggage.wxa.k7.e eVar2 = eVar;
        if (eVar2 == null) {
            return;
        }
        env.a(new h(eVar2, env, data.optString("appId"), data, i3, this));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends com.tencent.luggage.wxa.r4.f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull com.tencent.luggage.wxa.h7.b service) {
            super(service);
            Intrinsics.checkNotNullParameter(service, "service");
        }

        @Override // com.tencent.luggage.wxa.r4.f
        public boolean L() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.xi.e
        public boolean b(String str) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.r4.f
        public void P() {
        }

        @Override // com.tencent.luggage.wxa.r4.f
        public void Q() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/luggage/wxa/v6/c$f;", "Lcom/tencent/luggage/wxa/g7/d;", "", "l2", "Lcom/tencent/luggage/wxa/ok/j;", "r", "p0", "Lcom/tencent/luggage/wxa/kj/p;", "t", "Lcom/tencent/luggage/wxa/h7/b;", "m2", "p2", "Lcom/tencent/luggage/wxa/ic/v;", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/luggage/wxa/ic/v;)V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class f extends com.tencent.luggage.wxa.g7.d {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/luggage/wxa/v6/c$f$a", "Lcom/tencent/luggage/wxa/h7/b;", "", ExifInterface.LATITUDE_SOUTH, "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes8.dex */
        public static final class a extends com.tencent.luggage.wxa.h7.b {
            public a(Class<e> cls) {
                super(cls);
            }

            @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l
            public boolean S() {
                return false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends g.x {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.ic.g.x
            public void c() {
                f.this.p2();
                d();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull com.tencent.luggage.wxa.ic.v container) {
            super(container);
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public static final void b(f fVar) {
            fVar.D();
        }

        @Override // com.tencent.luggage.wxa.g7.d, com.tencent.luggage.wxa.p5.f
        public void l2() {
            b((g.x) new b());
        }

        @Override // com.tencent.luggage.wxa.g7.d, com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
        /* renamed from: m2 */
        public com.tencent.luggage.wxa.h7.b u() {
            return new a(e.class);
        }

        public final void p2() {
            com.tencent.luggage.wxa.j4.g a16 = C6830c.f143262a.a(this);
            if (a16 == null) {
                b(this);
                return;
            }
            J().add(a16);
            com.tencent.luggage.wxa.fd.b a17 = com.tencent.luggage.wxa.fd.b.a(getAppId(), "{}", "{}", false, false);
            a17.S = S().f125813f;
            a(a17);
            a(new com.tencent.luggage.wxa.rj.c((com.tencent.luggage.wxa.ic.g) this, -1, true));
            b(true);
            j2();
        }

        @Override // com.tencent.luggage.wxa.g7.d, com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
        public j r() {
            Context L = L();
            if (L == null) {
                L = F();
            }
            return new com.tencent.luggage.wxa.k7.a(L, this, null);
        }

        @Override // com.tencent.luggage.wxa.g7.d, com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
        public p t() {
            Context appContext = F();
            Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
            return new a(appContext, this);
        }

        @Override // com.tencent.luggage.wxa.ic.g
        public void p0() {
        }
    }
}
