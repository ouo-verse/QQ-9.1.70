package com.tencent.luggage.wxa.v2;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.v2.a;
import com.tencent.luggage.wxa.v2.i;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 36;

    @Deprecated
    @NotNull
    public static final String NAME = "chooseVideo";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142985a = new a(null);

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
    /* renamed from: com.tencent.luggage.wxa.v2.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6817c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142999a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143000b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f143001c;

        public C6817c(com.tencent.luggage.wxa.xd.d dVar, int i3, c cVar) {
            this.f142999a = dVar;
            this.f143000b = i3;
            this.f143001c = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            boolean startsWith$default;
            if (obj instanceof Exception) {
                String message = ((Exception) obj).getMessage();
                if (message == null) {
                    message = "";
                }
                com.tencent.luggage.wxa.xd.d dVar = this.f142999a;
                int i3 = this.f143000b;
                c cVar = this.f143001c;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(message, "fail", false, 2, null);
                if (!startsWith$default) {
                    message = "fail " + message;
                }
                dVar.a(i3, cVar.makeReturnJson(message));
                return;
            }
            w.b("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + obj + ')');
            this.f142999a.a(this.f143000b, this.f143001c.makeReturnJson("fail:internal error"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNull(dVar);
        Intrinsics.checkNotNull(jSONObject);
        boolean optBoolean = jSONObject.optBoolean("compressed", true);
        int a16 = g.f143013b.a(jSONObject);
        int a17 = d.f143002b.a(jSONObject);
        int a18 = f.VIDEO.a();
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optInt <= 0) {
            dVar.a(i3, makeReturnJson("fail invalid maxDuration"));
        } else {
            new com.tencent.luggage.wxa.v2.b(dVar, a16, a17, a18, !optBoolean, optInt, 1).c().b(new b(dVar, i3, this, optBoolean)).a(new C6817c(dVar, i3, this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142986b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f142987c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f142988d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f142989e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.uo.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142990b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f142991c;

            public a(com.tencent.luggage.wxa.xd.d dVar, boolean z16) {
                this.f142990b = dVar;
                this.f142991c = z16;
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final v call(v vVar) {
                if (!this.f142990b.isRunning()) {
                    com.tencent.luggage.wxa.xo.h.a().a(new Exception("component not running"));
                    return null;
                }
                if (this.f142991c) {
                    try {
                        return new v(com.tencent.luggage.wxa.ym.a.d(vVar.g()));
                    } catch (Exception e16) {
                        if (!x0.a()) {
                            com.tencent.luggage.wxa.xo.h.a().a(e16);
                            return null;
                        }
                        throw e16;
                    }
                }
                return vVar;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v2.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6816c implements com.tencent.luggage.wxa.uo.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ml.i f142996b;

            public C6816c(com.tencent.luggage.wxa.ml.i iVar) {
                this.f142996b = iVar;
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Unit call(Unit unit) {
                com.tencent.luggage.wxa.ml.i iVar = this.f142996b;
                if (iVar != null) {
                    iVar.dismiss();
                    return Unit.INSTANCE;
                }
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ml.i f142997a;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ml.i f142998a;

                public a(com.tencent.luggage.wxa.ml.i iVar) {
                    this.f142998a = iVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f142998a.dismiss();
                }
            }

            public d(com.tencent.luggage.wxa.ml.i iVar) {
                this.f142997a = iVar;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object obj) {
                com.tencent.luggage.wxa.ml.i iVar = this.f142997a;
                if (iVar != null) {
                    c0.a(new a(iVar));
                }
            }
        }

        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, c cVar, boolean z16) {
            this.f142986b = dVar;
            this.f142987c = i3;
            this.f142988d = cVar;
            this.f142989e = z16;
        }

        public final void a(com.tencent.luggage.wxa.v2.a aVar) {
            com.tencent.luggage.wxa.ml.i iVar;
            if (aVar instanceof a.c) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142986b;
                int i3 = this.f142987c;
                c cVar = this.f142988d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fail ");
                String a16 = ((a.c) aVar).a();
                if (a16 == null) {
                    a16 = "";
                }
                sb5.append(a16);
                dVar.a(i3, cVar.makeReturnJson(sb5.toString()));
                return;
            }
            if (aVar instanceof a.d) {
                if (!this.f142986b.isRunning()) {
                    return;
                }
                if (this.f142989e) {
                    iVar = new com.tencent.luggage.wxa.ml.i(this.f142986b.getContext());
                    com.tencent.luggage.wxa.xd.d dVar2 = this.f142986b;
                    iVar.setMessage(dVar2.getContext().getString(R.string.yxg));
                    iVar.setCanceledOnTouchOutside(false);
                    r dialogContainer = dVar2.getDialogContainer();
                    if (dialogContainer != null) {
                        dialogContainer.a(iVar);
                    }
                } else {
                    iVar = null;
                }
                com.tencent.luggage.wxa.xo.h.a(((a.d) aVar).a().get(0)).d(new a(this.f142986b, this.f142989e)).b(new C6815b(this.f142986b, aVar, this.f142987c, this.f142988d)).a(new C6816c(iVar)).a(new d(iVar));
                return;
            }
            if (Intrinsics.areEqual(aVar, a.C6812a.f142952b)) {
                this.f142986b.a(this.f142987c, this.f142988d.makeReturnJson("fail user canceled"));
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((com.tencent.luggage.wxa.v2.a) obj);
            return Unit.INSTANCE;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v2.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6815b implements com.tencent.luggage.wxa.uo.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142992b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.v2.a f142993c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f142994d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f142995e;

            public C6815b(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.v2.a aVar, int i3, c cVar) {
                this.f142992b = dVar;
                this.f142993c = aVar;
                this.f142994d = i3;
                this.f142995e = cVar;
            }

            public final void a(v vVar) {
                String makeReturnJson;
                int roundToInt;
                if (vVar == null) {
                    a(this.f142992b, this.f142994d);
                    return;
                }
                com.tencent.luggage.wxa.rc.r fileSystem = this.f142992b.getFileSystem();
                Unit unit = null;
                if (fileSystem != null) {
                    c cVar = this.f142995e;
                    com.tencent.luggage.wxa.xd.d dVar = this.f142992b;
                    int i3 = this.f142994d;
                    com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                    fileSystem.createTempFileFrom(vVar, null, false, iVar);
                    CharSequence charSequence = (CharSequence) iVar.f141499a;
                    if (charSequence == null || charSequence.length() == 0) {
                        makeReturnJson = cVar.makeReturnJson("fail create temp file failed");
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempFilePath", iVar.f141499a);
                        i.a aVar = i.f143031e;
                        String g16 = vVar.g();
                        Intrinsics.checkNotNullExpressionValue(g16, "selected.absolutePath");
                        i a16 = aVar.a(g16);
                        if (a16 != null) {
                            roundToInt = MathKt__MathJVMKt.roundToInt(a16.a() / 1000.0d);
                            hashMap.put("duration", Integer.valueOf(roundToInt));
                            hashMap.put("size", Long.valueOf(a16.c()));
                            hashMap.put("height", Integer.valueOf(a16.b()));
                            hashMap.put("width", Integer.valueOf(a16.d()));
                        }
                        Unit unit2 = Unit.INSTANCE;
                        makeReturnJson = cVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                    }
                    dVar.a(i3, makeReturnJson);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    a(this.f142992b, this.f142994d, this.f142995e);
                }
                Object obj = ((a.d) this.f142993c).a().get(0);
                com.tencent.luggage.wxa.xd.d dVar2 = this.f142992b;
                v vVar2 = (v) obj;
                w.d("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected source[" + vVar2.g() + "], selected[" + vVar.g() + "], appId[" + dVar2.getAppId() + "], callbackId[" + this.f142994d + ']');
                if (Intrinsics.areEqual(vVar.g(), vVar2.g())) {
                    return;
                }
                x.c(vVar.g());
            }

            @Override // com.tencent.luggage.wxa.uo.b
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                a((v) obj);
                return Unit.INSTANCE;
            }

            public static final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
                w.b("MicroMsg.AppBrand.JsApiChooseVideoNew", "get NULL selected, appId[" + dVar.getAppId() + "], callbackId[" + i3 + ']');
                com.tencent.luggage.wxa.xo.h.a().a(new Exception("fail:internal error"));
            }

            public static final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, c cVar) {
                w.b("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected NULL fs appId[" + dVar.getAppId() + "], callbackId[" + i3 + ']');
                dVar.a(i3, cVar.makeReturnJson("fail:internal error"));
            }
        }
    }
}
