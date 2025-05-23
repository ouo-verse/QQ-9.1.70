package com.tencent.luggage.wxa.bi;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ai.b;
import com.tencent.luggage.wxa.md.e;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.y0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import rx.Observable;
import rx.functions.Action0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: p */
    public static final a f122811p = new a(null);

    /* renamed from: a */
    public final com.tencent.luggage.wxa.z7.c f122812a;

    /* renamed from: b */
    public final com.tencent.luggage.wxa.j8.a f122813b;

    /* renamed from: c */
    public final com.tencent.luggage.wxa.ai.b f122814c;

    /* renamed from: d */
    public int f122815d;

    /* renamed from: e */
    public final com.tencent.luggage.wxa.bi.i f122816e;

    /* renamed from: f */
    public com.tencent.luggage.wxa.bi.g f122817f;

    /* renamed from: g */
    public Function0 f122818g;

    /* renamed from: h */
    public int f122819h;

    /* renamed from: i */
    public boolean f122820i;

    /* renamed from: j */
    public final e0 f122821j;

    /* renamed from: k */
    public Function0 f122822k;

    /* renamed from: l */
    public final y f122823l;

    /* renamed from: m */
    public final e0 f122824m;

    /* renamed from: n */
    public boolean f122825n;

    /* renamed from: o */
    public final e0 f122826o;

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
    public static final class b {

        /* renamed from: a */
        public com.tencent.luggage.wxa.bi.a f122827a;

        /* renamed from: b */
        public Object f122828b;

        public b(com.tencent.luggage.wxa.bi.a eventType) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            this.f122827a = eventType;
        }

        public final com.tencent.luggage.wxa.bi.a a() {
            return this.f122827a;
        }

        public final Object b() {
            return this.f122828b;
        }

        public final void a(Object obj) {
            this.f122828b = obj;
        }

        public b(com.tencent.luggage.wxa.bi.a eventType, Object obj) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(obj, "obj");
            this.f122827a = eventType;
            this.f122828b = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f122830a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.bi.a.values().length];
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_PROGRESS.ordinal()] = 1;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_PLAYING.ordinal()] = 2;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_PAUSED.ordinal()] = 3;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_STOPPED.ordinal()] = 4;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_VOLUME.ordinal()] = 5;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_MUTE.ordinal()] = 6;
            iArr[com.tencent.luggage.wxa.bi.a.ACTION_ERROR.ordinal()] = 7;
            f122830a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.f122817f != null) {
                com.tencent.luggage.wxa.bi.g gVar = h.this.f122817f;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    gVar = null;
                }
                gVar.l();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends c {
        public f() {
            super();
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            super.a(eVar);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get position  fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
            b bVar = new b(com.tencent.luggage.wxa.bi.a.ACTION_ERROR);
            h.this.e().f();
            h.this.b(bVar);
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Object value;
            Object value2;
            Intrinsics.checkNotNullParameter(response, "response");
            Map map = response.f137499b;
            if (map != null && !map.isEmpty() && map.containsKey("RelTime") && map.containsKey("TrackDuration")) {
                value = MapsKt__MapsKt.getValue(map, "RelTime");
                String a16 = ((com.tencent.luggage.wxa.pd.a) value).a();
                value2 = MapsKt__MapsKt.getValue(map, "TrackDuration");
                String a17 = ((com.tencent.luggage.wxa.pd.a) value2).a();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "getProgressTimeMs: relTime = " + a16 + ", duration =  " + a17);
                b.Companion companion = com.tencent.luggage.wxa.ai.b.INSTANCE;
                int a18 = (int) companion.a(a16);
                int a19 = (int) companion.a(a17);
                h.this.f122819h = a18;
                h.this.f122813b.a(a18, a19);
                h.this.f122813b.a((int) ((a18 / a19) * 100));
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "get position success, relTime: " + ((int) companion.a(a16)) + " duration: " + ((int) companion.a(a17)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends c {

        /* renamed from: b */
        public final /* synthetic */ Function1 f122833b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h hVar, Function1 function1) {
            super();
            this.f122833b = function1;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            super.a(eVar);
            if (eVar != null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", "get volume  fail" + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            String str;
            com.tencent.luggage.wxa.pd.a aVar;
            Intrinsics.checkNotNullParameter(response, "response");
            Map map = response.f137499b;
            if (map != null && (aVar = (com.tencent.luggage.wxa.pd.a) map.get("CurrentVolume")) != null) {
                str = aVar.a();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                com.tencent.luggage.wxa.bi.f fVar = new com.tencent.luggage.wxa.bi.f(true);
                Intrinsics.checkNotNull(str);
                fVar.a(Integer.valueOf(Integer.parseInt(str)));
                this.f122833b.invoke(fVar);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "get volume success : " + str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bi.h$h */
    /* loaded from: classes8.dex */
    public static final class C6071h implements e0.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bi.h$h$a */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.od.a {

            /* renamed from: a */
            public final /* synthetic */ h f122835a;

            public a(h hVar) {
                this.f122835a = hVar;
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void a(com.tencent.luggage.wxa.pd.e eVar) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "getMediaInfo fail");
                this.f122835a.f122825n = true;
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void b(com.tencent.luggage.wxa.pd.e eVar) {
                String str;
                CharSequence trim;
                boolean isBlank;
                Map map;
                com.tencent.luggage.wxa.pd.a aVar;
                if (this.f122835a.f122825n) {
                    return;
                }
                if (eVar != null && (map = eVar.f137499b) != null && (aVar = (com.tencent.luggage.wxa.pd.a) map.get("CurrentURI")) != null) {
                    str = aVar.a();
                } else {
                    str = null;
                }
                String valueOf = String.valueOf(str);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "getMediaInfo: currentUrl = " + valueOf);
                trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
                isBlank = StringsKt__StringsJVMKt.isBlank(trim.toString());
                if (!isBlank && !Intrinsics.areEqual(valueOf, "null") && !Intrinsics.areEqual(valueOf, this.f122835a.f122814c.getVideoPath())) {
                    this.f122835a.f122813b.a();
                }
            }
        }

        public C6071h() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            h.this.f122816e.b().a(new a(h.this));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends c {

        /* renamed from: c */
        public final /* synthetic */ Function1 f122838c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Function1 function1) {
            super();
            this.f122838c = function1;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            super.a(eVar);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pause fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
            this.f122838c.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "pause success");
            h.this.f122816e.b().a(e.a.Paused);
            this.f122838c.invoke(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends c {

        /* renamed from: c */
        public final /* synthetic */ int f122840c;

        /* renamed from: d */
        public final /* synthetic */ int f122841d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i3, int i16) {
            super();
            this.f122840c = i3;
            this.f122841d = i16;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            super.a(eVar);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", "play fail");
            b bVar = new b(com.tencent.luggage.wxa.bi.a.ACTION_ERROR);
            bVar.a(Integer.valueOf(this.f122841d));
            h.this.b(bVar);
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "play success, url = [%s]", h.this.f122814c.getVideoPath());
            h.b(this.f122840c, h.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends c {

        /* renamed from: c */
        public final /* synthetic */ int f122843c;

        /* renamed from: d */
        public final /* synthetic */ int f122844d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends c {

            /* renamed from: b */
            public final /* synthetic */ h f122845b;

            /* renamed from: c */
            public final /* synthetic */ int f122846c;

            /* renamed from: d */
            public final /* synthetic */ int f122847d;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.bi.h$l$a$a */
            /* loaded from: classes8.dex */
            public static final class C6072a extends c {

                /* renamed from: b */
                public final /* synthetic */ h f122848b;

                /* renamed from: c */
                public final /* synthetic */ int f122849c;

                /* renamed from: d */
                public final /* synthetic */ int f122850d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6072a(h hVar, int i3, int i16) {
                    super();
                    this.f122848b = hVar;
                    this.f122849c = i3;
                    this.f122850d = i16;
                }

                @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
                public void a(com.tencent.luggage.wxa.pd.e eVar) {
                    Object obj;
                    super.a(eVar);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("play new fail");
                    if (eVar != null) {
                        obj = Integer.valueOf(eVar.f137497c);
                    } else {
                        obj = "";
                    }
                    sb5.append(obj);
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
                    b bVar = new b(com.tencent.luggage.wxa.bi.a.ACTION_ERROR);
                    bVar.a(Integer.valueOf(this.f122850d));
                    this.f122848b.b(bVar);
                }

                @Override // com.tencent.luggage.wxa.od.a
                public void b(com.tencent.luggage.wxa.pd.e response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "play new success");
                    this.f122848b.f122816e.b().a(this.f122848b.f122823l);
                    this.f122848b.f122816e.b().a(e.a.Playing);
                    this.f122848b.f122816e.b().i();
                    this.f122848b.f122816e.b().j();
                    h.b(this.f122849c, this.f122848b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h hVar, int i3, int i16) {
                super();
                this.f122845b = hVar;
                this.f122846c = i3;
                this.f122847d = i16;
            }

            @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
            public void a(com.tencent.luggage.wxa.pd.e eVar) {
                Object obj;
                super.a(eVar);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("set AVTransportURI fail");
                if (eVar != null) {
                    obj = Integer.valueOf(eVar.f137497c);
                } else {
                    obj = "";
                }
                sb5.append(obj);
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
                b bVar = new b(com.tencent.luggage.wxa.bi.a.ACTION_ERROR);
                bVar.a(Integer.valueOf(this.f122847d));
                this.f122845b.b(bVar);
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void b(com.tencent.luggage.wxa.pd.e response) {
                Intrinsics.checkNotNullParameter(response, "response");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "playNew: setAvTransUrl success");
                this.f122845b.f122816e.b().a(e.a.Transitioning);
                this.f122845b.f122816e.b().e(new C6072a(this.f122845b, this.f122846c, this.f122847d));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i3, int i16) {
            super();
            this.f122843c = i3;
            this.f122844d = i16;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            super.a(eVar);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("stop fail before play new");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "playNew: stop success");
            h.this.f122816e.b().a(e.a.Stopped);
            h.this.f122816e.b().b(h.this.f122814c.getVideoPath(), new a(h.this, this.f122843c, this.f122844d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function0 {

        /* renamed from: b */
        public final /* synthetic */ int f122852b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(int i3) {
            super(0);
            this.f122852b = i3;
        }

        public final void a() {
            h.this.a(com.tencent.luggage.wxa.ai.b.INSTANCE.a(this.f122852b));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n implements e0.a {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            if (h.this.f122820i) {
                return false;
            }
            h.this.f122813b.b(false);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o implements e0.a {
        public o() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            h.this.d();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p extends Lambda implements Function1 {
        public p() {
            super(1);
        }

        public final void a(boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "reconnect: isSuccess = " + z16);
            if (z16) {
                h hVar = h.this;
                hVar.a(hVar.f122819h, 5);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ boolean f122857b;

        /* renamed from: c */
        public final /* synthetic */ boolean f122858c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a */
            public final /* synthetic */ h f122859a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h hVar) {
                super(0);
                this.f122859a = hVar;
            }

            public final void a() {
                h.h(this.f122859a);
                String str = "https://" + y0.a(R.string.f159091rd) + "/mp/readtemplate?t=weapp/airplay_intro_tmpl&appid=" + com.tencent.luggage.wxa.bi.d.a(this.f122859a.f122812a).getAppId();
                com.tencent.luggage.wxa.bi.b bVar = (com.tencent.luggage.wxa.bi.b) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bi.b.class);
                if (bVar != null) {
                    Context context = this.f122859a.f122812a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "invokeContext.context");
                    bVar.a(str, context);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a */
            public final /* synthetic */ boolean f122860a;

            /* renamed from: b */
            public final /* synthetic */ h f122861b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(boolean z16, h hVar) {
                super(1);
                this.f122860a = z16;
                this.f122861b = hVar;
            }

            public final void a(int i3) {
                h.h(this.f122861b);
                this.f122861b.f122816e.g().clear();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function2 {

            /* renamed from: a */
            public final /* synthetic */ h f122862a;

            /* renamed from: b */
            public final /* synthetic */ boolean f122863b;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ h f122864a;

                public a(h hVar) {
                    this.f122864a = hVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.bi.g gVar = this.f122864a.f122817f;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                        gVar = null;
                    }
                    gVar.l();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(h hVar, boolean z16) {
                super(2);
                this.f122862a = hVar;
                this.f122863b = z16;
            }

            public final void a(com.tencent.luggage.wxa.md.c cVar, int i3) {
                Function0 c16;
                if (cVar == null) {
                    this.f122862a.f122813b.a(false);
                    com.tencent.luggage.wxa.bi.g gVar = this.f122862a.f122817f;
                    com.tencent.luggage.wxa.bi.g gVar2 = null;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                        gVar = null;
                    }
                    gVar.a((Function2) null);
                    com.tencent.luggage.wxa.bi.g gVar3 = this.f122862a.f122817f;
                    if (gVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    } else {
                        gVar2 = gVar3;
                    }
                    gVar2.l();
                    return;
                }
                this.f122862a.f122813b.a(true);
                if (this.f122862a.c() != null && (c16 = this.f122862a.c()) != null) {
                    c16.invoke();
                }
                this.f122862a.f122816e.a(cVar);
                this.f122862a.a(3);
                if (this.f122863b) {
                    com.tencent.luggage.wxa.tk.l.a(new a(this.f122862a));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((com.tencent.luggage.wxa.md.c) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }
        }

        public q(boolean z16, boolean z17) {
            this.f122857b = z16;
            this.f122858c = z17;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.f122817f = new com.tencent.luggage.wxa.bi.g(h.this.b(), false, h.this.f122814c, h.this.f122816e, this.f122857b, 2, null);
            com.tencent.luggage.wxa.bi.g gVar = h.this.f122817f;
            com.tencent.luggage.wxa.bi.g gVar2 = null;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                gVar = null;
            }
            gVar.a(new a(h.this));
            com.tencent.luggage.wxa.bi.g gVar3 = h.this.f122817f;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                gVar3 = null;
            }
            gVar3.a(new b(this.f122857b, h.this));
            com.tencent.luggage.wxa.bi.g gVar4 = h.this.f122817f;
            if (gVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                gVar4 = null;
            }
            gVar4.a(new c(h.this, this.f122858c));
            com.tencent.luggage.wxa.bi.g gVar5 = h.this.f122817f;
            if (gVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
            } else {
                gVar2 = gVar5;
            }
            gVar2.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r extends Lambda implements Function0 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ h f122866a;

            public a(h hVar) {
                this.f122866a = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.bi.g gVar = this.f122866a.f122817f;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    gVar = null;
                }
                gVar.j();
            }
        }

        public r() {
            super(0);
        }

        public final void a() {
            c0.a(new a(h.this));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.y9.a.makeText(h.this.b(), com.tencent.luggage.wxa.kn.a.f(h.this.b(), R.string.z1y), 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t extends c {

        /* renamed from: b */
        public final /* synthetic */ String f122868b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(h hVar, String str) {
            super();
            this.f122868b = str;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            super.a(eVar);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "seek fail");
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "seek to " + this.f122868b + " success");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u implements Action0 {

        /* renamed from: b */
        public final /* synthetic */ b f122870b;

        public u(b bVar) {
            this.f122870b = bVar;
        }

        @Override // rx.functions.Action0
        public final void call() {
            h.this.a(this.f122870b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class v extends c {
        public v(h hVar) {
            super();
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            super.a(eVar);
            if (eVar != null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", "setVolume fail:" + eVar.f137497c);
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", "setVolume fail:" + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "setVolume success");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class x extends c {

        /* renamed from: c */
        public final /* synthetic */ Function1 f122873c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(Function1 function1) {
            super();
            this.f122873c = function1;
        }

        @Override // com.tencent.luggage.wxa.bi.h.c, com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            super.a(eVar);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("stop fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.VideoCast.VideoCastController", sb5.toString());
            this.f122873c.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "stop success");
            h.this.f122816e.b().a(e.a.Stopped);
            h.this.l();
            h.this.e().f();
            this.f122873c.invoke(Boolean.TRUE);
        }
    }

    public h(com.tencent.luggage.wxa.z7.c invokeContext, com.tencent.luggage.wxa.j8.a eventHandler, com.tencent.luggage.wxa.ai.b videoCastHandler) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(videoCastHandler, "videoCastHandler");
        this.f122812a = invokeContext;
        this.f122813b = eventHandler;
        this.f122814c = videoCastHandler;
        this.f122815d = -1;
        this.f122816e = new com.tencent.luggage.wxa.bi.i();
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.bi.c.class));
        this.f122821j = new e0(new n(), false);
        this.f122823l = new y();
        this.f122824m = new e0(new o(), true);
        this.f122826o = new e0(new C6071h(), true);
    }

    public static final /* synthetic */ com.tencent.luggage.wxa.bi.c h(h hVar) {
        hVar.getClass();
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class y implements com.tencent.luggage.wxa.md.d {
        public y() {
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_PAUSED));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void b(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_PLAYING));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void c(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_STOPPED));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device, boolean z16) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_MUTE, Boolean.valueOf(z16)));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void b(com.tencent.luggage.wxa.md.c device, int i3) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_VOLUME, Integer.valueOf(i3)));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device, int i3) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, h.this.f122816e.b())) {
                h.this.b(new b(com.tencent.luggage.wxa.bi.a.ACTION_PROGRESS, Integer.valueOf(i3)));
            }
        }
    }

    public final Function0 c() {
        return this.f122818g;
    }

    public final void d() {
        this.f122816e.b().b(new f());
    }

    public final e0 e() {
        return this.f122824m;
    }

    public final int f() {
        return this.f122815d;
    }

    public final void g() {
        if (this.f122816e.b().d() == e.a.Playing) {
            this.f122813b.b(true);
        } else {
            this.f122816e.a(new p());
        }
    }

    public final void h() {
        if (this.f122826o.g()) {
            this.f122825n = false;
            this.f122826o.a(5000L);
        }
    }

    public final void i() {
        if (this.f122826o.g()) {
            return;
        }
        this.f122826o.f();
        this.f122825n = true;
    }

    public final void j() {
        this.f122824m.f();
        this.f122826o.f();
        this.f122821j.f();
    }

    public final void k() {
        a(false, true);
    }

    public final void l() {
        this.f122816e.b().k();
        this.f122816e.b().l();
        this.f122816e.b().a((com.tencent.luggage.wxa.md.d) null);
    }

    public final Context b() {
        Context context = this.f122812a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "invokeContext.context");
        return context;
    }

    public final void c(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.f122816e.b().f(new x(action));
    }

    public static final void b(int i3, h hVar) {
        if (i3 <= 0) {
            return;
        }
        hVar.f122822k = new m(i3);
    }

    public static final void b(h hVar, int i3, int i16) {
        hVar.f122816e.b().f(new l(i3, i16));
    }

    public final void b(b bVar) {
        synchronized (h.class) {
            Observable.empty().observeOn(com.tencent.luggage.wxa.rd.a.a()).doOnCompleted(new u(bVar)).subscribe();
        }
    }

    public final void a(int i3) {
        this.f122815d = i3;
    }

    public final void a(Function0 function0) {
        this.f122818g = function0;
    }

    public static /* synthetic */ void a(h hVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        hVar.a(z16, z17);
    }

    public final void b(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.f122816e.b().d(new j(action));
    }

    public static /* synthetic */ void b(h hVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = w.f122871a;
        }
        hVar.c(function1);
    }

    public final void a(boolean z16, boolean z17) {
        c0.a(new q(z17, z16));
        if (!z17) {
            this.f122816e.a();
        }
        this.f122816e.b(new r());
        if (!com.tencent.luggage.wxa.h6.j.a(z.c())) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new s());
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.VideoCast.VideoCastController", "searchDevice: wifi is not connected");
        }
        this.f122816e.j();
    }

    public final void b(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "setVolume: " + i3);
        this.f122816e.b().a(i3, new v(this));
    }

    public static /* synthetic */ void a(h hVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = -1;
        }
        if ((i17 & 2) != 0) {
            i16 = -1;
        }
        hVar.a(i3, i16);
    }

    public final void a(int i3, int i16) {
        this.f122815d = i16;
        this.f122820i = false;
        if (this.f122816e.b().d() == e.a.Paused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "play: continue");
            a(this, i3, i16);
            this.f122813b.onVideoWaiting();
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "play: playNew");
            b(this, i3, i16);
            this.f122813b.onVideoWaiting();
        }
    }

    public static final void a(h hVar, int i3, int i16) {
        hVar.f122816e.b().e(new k(i3, i16));
    }

    public final void a(String moment) {
        Intrinsics.checkNotNullParameter(moment, "moment");
        this.f122816e.b().a(moment, new t(this, moment));
    }

    public static /* synthetic */ void a(h hVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = i.f122836a;
        }
        hVar.b(function1);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.od.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: a */
        public static final i f122836a = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }

        public final void a(boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class w extends Lambda implements Function1 {

        /* renamed from: a */
        public static final w f122871a = new w();

        public w() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }

        public final void a(boolean z16) {
        }
    }

    public final void a() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        c0.a(new e());
        l();
        this.f122824m.f();
        this.f122816e.a();
        i();
        this.f122821j.f();
    }

    public final void a(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.f122816e.b().c(new g(this, action));
    }

    public final void a(b bVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "handleBroadcast: " + bVar.a().name());
        switch (d.f122830a[bVar.a().ordinal()]) {
            case 2:
                com.tencent.luggage.wxa.md.c b16 = this.f122816e.b();
                e.a aVar = e.a.Playing;
                b16.a(aVar);
                h();
                a(this, aVar);
                this.f122821j.f();
                this.f122820i = true;
                this.f122813b.onVideoPlay();
                this.f122824m.a(1000L);
                this.f122814c.a(true);
                this.f122813b.b(true);
                this.f122816e.i();
                Function0 function0 = this.f122822k;
                if (function0 != null) {
                    function0.invoke();
                    this.f122822k = null;
                }
                if (this.f122815d != 3) {
                }
                this.f122815d = -1;
                return;
            case 3:
                com.tencent.luggage.wxa.md.c b17 = this.f122816e.b();
                e.a aVar2 = e.a.Paused;
                b17.a(aVar2);
                a(this, aVar2);
                this.f122813b.onVideoPause();
                this.f122814c.a(true);
                return;
            case 4:
                com.tencent.luggage.wxa.md.c b18 = this.f122816e.b();
                e.a aVar3 = e.a.Stopped;
                b18.a(aVar3);
                a(this, aVar3);
                this.f122813b.onVideoEnded();
                this.f122814c.a(false);
                return;
            case 5:
                if (bVar.b() == null || !(bVar.b() instanceof Integer)) {
                    return;
                }
                Object b19 = bVar.b();
                Intrinsics.checkNotNull(b19, "null cannot be cast to non-null type kotlin.Int");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "Receive Action : Volume = " + ((Integer) b19).intValue());
                return;
            case 6:
                if (bVar.b() == null || !(bVar.b() instanceof Boolean)) {
                    return;
                }
                Object b26 = bVar.b();
                Intrinsics.checkNotNull(b26, "null cannot be cast to non-null type kotlin.Boolean");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.VideoCast.VideoCastController", "Receive Action : Mute = " + ((Boolean) b26).booleanValue());
                return;
            case 7:
                e.a d16 = this.f122816e.b().d();
                e.a aVar4 = e.a.Stopped;
                if (d16 == aVar4) {
                    return;
                }
                this.f122813b.b(false);
                a(this, aVar4);
                this.f122816e.h();
                if (bVar.b() != null && (bVar.b() instanceof Integer)) {
                    Object b27 = bVar.b();
                    Intrinsics.checkNotNull(b27, "null cannot be cast to non-null type kotlin.Int");
                    ((Integer) b27).intValue();
                }
                this.f122816e.b().k();
                this.f122816e.b().l();
                this.f122816e.b().a((com.tencent.luggage.wxa.md.d) null);
                this.f122814c.a(false);
                j();
                return;
            default:
                return;
        }
    }

    public static final void a(h hVar, e.a aVar) {
        hVar.f122816e.b().a(aVar);
    }
}
