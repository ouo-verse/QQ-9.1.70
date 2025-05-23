package com.tencent.luggage.wxa.b8;

import android.content.Context;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.md.e;
import com.tencent.luggage.wxa.tn.e0;
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
public final class k {

    /* renamed from: n, reason: collision with root package name */
    public static final a f121918n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.f f121919a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.i f121920b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.j f121921c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f121922d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.l f121923e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.b8.n f121924f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f121925g;

    /* renamed from: h, reason: collision with root package name */
    public final e0 f121926h;

    /* renamed from: i, reason: collision with root package name */
    public final e0 f121927i;

    /* renamed from: j, reason: collision with root package name */
    public final f f121928j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.b8.a f121929k;

    /* renamed from: l, reason: collision with root package name */
    public Function0 f121930l;

    /* renamed from: m, reason: collision with root package name */
    public int f121931m;

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
    public enum c {
        ACTION_EMPTY,
        ACTION_ADD_DEVICE,
        ACTION_REMOVE_DEVICE,
        ACTION_UPDATE_DEVICE,
        ACTION_SET_VOLUME,
        ACTION_PLAYING,
        ACTION_PAUSED,
        ACTION_STOPPED,
        ACTION_VOLUME,
        ACTION_MUTE,
        ACTION_PROGRESS,
        ACTION_ERROR
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121947a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f121948b;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.b8.a.values().length];
            iArr[com.tencent.luggage.wxa.b8.a.ClickDeviceButton.ordinal()] = 1;
            iArr[com.tencent.luggage.wxa.b8.a.ClickReconnectButton.ordinal()] = 2;
            iArr[com.tencent.luggage.wxa.b8.a.ChangeCastSource.ordinal()] = 3;
            f121947a = iArr;
            int[] iArr2 = new int[c.values().length];
            iArr2[c.ACTION_PLAYING.ordinal()] = 1;
            iArr2[c.ACTION_PAUSED.ordinal()] = 2;
            iArr2[c.ACTION_STOPPED.ordinal()] = 3;
            iArr2[c.ACTION_VOLUME.ordinal()] = 4;
            iArr2[c.ACTION_MUTE.ordinal()] = 5;
            iArr2[c.ACTION_ERROR.ordinal()] = 6;
            f121948b = iArr2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (k.this.f121924f != null) {
                com.tencent.luggage.wxa.b8.n nVar = k.this.f121924f;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    nVar = null;
                }
                nVar.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements com.tencent.luggage.wxa.od.a {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get position  fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
            k.this.c().f();
            k.this.b(new b(c.ACTION_ERROR));
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
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "getProgressTimeMs: relTime = " + a16 + ", duration =  " + a17);
                int a18 = (int) com.tencent.luggage.wxa.b8.c.a(a16);
                int a19 = (int) com.tencent.luggage.wxa.b8.c.a(a17);
                k.this.f121931m = a18;
                k.this.f121920b.a(a18, a19);
                k.this.f121920b.b((int) ((((double) a18) / ((double) a19)) * ((double) 100)));
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "get position success, relTime: " + ((int) com.tencent.luggage.wxa.b8.c.a(a16)) + " duration: " + ((int) com.tencent.luggage.wxa.b8.c.a(a17)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f121952a;

        public h(Function1 function1) {
            this.f121952a = function1;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar != null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", "get volume  fail" + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            String str;
            boolean z16;
            com.tencent.luggage.wxa.pd.a aVar;
            Intrinsics.checkNotNullParameter(response, "response");
            Map map = response.f137499b;
            if (map != null && (aVar = (com.tencent.luggage.wxa.pd.a) map.get("CurrentVolume")) != null) {
                str = aVar.a();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Function1 function1 = this.f121952a;
                com.tencent.luggage.wxa.b8.s sVar = new com.tencent.luggage.wxa.b8.s(true);
                sVar.a(Integer.valueOf(Integer.parseInt(str)));
                function1.invoke(sVar);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "get volume success : " + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements e0.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.od.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f121954a;

            public a(k kVar) {
                this.f121954a = kVar;
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void a(com.tencent.luggage.wxa.pd.e eVar) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "getMediaInfo fail");
                this.f121954a.f121925g = true;
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void b(com.tencent.luggage.wxa.pd.e eVar) {
                String str;
                CharSequence trim;
                boolean isBlank;
                Map map;
                com.tencent.luggage.wxa.pd.a aVar;
                if (this.f121954a.f121925g) {
                    return;
                }
                if (eVar != null && (map = eVar.f137499b) != null && (aVar = (com.tencent.luggage.wxa.pd.a) map.get("CurrentURI")) != null) {
                    str = aVar.a();
                } else {
                    str = null;
                }
                String valueOf = String.valueOf(str);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "getMediaInfo: currentUrl = " + valueOf);
                trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
                isBlank = StringsKt__StringsJVMKt.isBlank(trim.toString());
                if (!isBlank && !Intrinsics.areEqual(valueOf, "null") && !Intrinsics.areEqual(valueOf, this.f121954a.f121919a.c())) {
                    this.f121954a.f121920b.h();
                }
            }
        }

        public i() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            k.this.f121923e.c().a(new a(k.this));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final j f121955a = new j();

        public j() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.b8.s it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.b8.s) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b8.k$k, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6036k implements com.tencent.luggage.wxa.od.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f121957b;

        public C6036k(Function1 function1) {
            this.f121957b = function1;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pause fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
            this.f121957b.invoke(new com.tencent.luggage.wxa.b8.s(false));
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "pause success");
            k.this.f121923e.c().a(e.a.Paused);
            this.f121957b.invoke(new com.tencent.luggage.wxa.b8.s(true));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements com.tencent.luggage.wxa.od.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f121959b;

        public l(int i3) {
            this.f121959b = i3;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", "play fail");
            k kVar = k.this;
            kVar.b(new b(c.ACTION_ERROR, kVar.f121929k));
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "play success, url = [%s]", k.this.f121919a.c());
            k.b(this.f121959b, k.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements com.tencent.luggage.wxa.od.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f121961b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.od.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f121962a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f121963b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.b8.k$m$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6037a implements com.tencent.luggage.wxa.od.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k f121964a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ int f121965b;

                public C6037a(k kVar, int i3) {
                    this.f121964a = kVar;
                    this.f121965b = i3;
                }

                @Override // com.tencent.luggage.wxa.od.a
                public void a(com.tencent.luggage.wxa.pd.e eVar) {
                    Object obj;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("play new fail");
                    if (eVar != null) {
                        obj = Integer.valueOf(eVar.f137497c);
                    } else {
                        obj = "";
                    }
                    sb5.append(obj);
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
                    k kVar = this.f121964a;
                    kVar.b(new b(c.ACTION_ERROR, kVar.f121929k));
                }

                @Override // com.tencent.luggage.wxa.od.a
                public void b(com.tencent.luggage.wxa.pd.e response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "play new success");
                    this.f121964a.f121923e.c().a(this.f121964a.f121928j);
                    this.f121964a.f121923e.c().a(e.a.Playing);
                    this.f121964a.f121923e.c().i();
                    this.f121964a.f121923e.c().j();
                    k.b(this.f121965b, this.f121964a);
                }
            }

            public a(k kVar, int i3) {
                this.f121962a = kVar;
                this.f121963b = i3;
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void a(com.tencent.luggage.wxa.pd.e eVar) {
                Object obj;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("set AVTransportURI fail");
                if (eVar != null) {
                    obj = Integer.valueOf(eVar.f137497c);
                } else {
                    obj = "";
                }
                sb5.append(obj);
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
                k kVar = this.f121962a;
                kVar.b(new b(c.ACTION_ERROR, kVar.f121929k));
            }

            @Override // com.tencent.luggage.wxa.od.a
            public void b(com.tencent.luggage.wxa.pd.e response) {
                Intrinsics.checkNotNullParameter(response, "response");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "playNew: setAvTransUrl success");
                this.f121962a.f121923e.c().a(e.a.Transitioning);
                this.f121962a.f121923e.c().e(new C6037a(this.f121962a, this.f121963b));
            }
        }

        public m(int i3) {
            this.f121961b = i3;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("stop fail before play new");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "playNew: stop success");
            k.this.f121923e.c().a(e.a.Stopped);
            k.this.f121923e.c().b(k.this.f121919a.c(), new a(k.this, this.f121961b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f121967b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(int i3) {
            super(0);
            this.f121967b = i3;
        }

        public final void a() {
            k.this.a(com.tencent.luggage.wxa.b8.c.a(this.f121967b));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o implements e0.a {
        public o() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            k.this.b();
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
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "reconnect: isSuccess = " + z16);
            if (z16) {
                k kVar = k.this;
                kVar.a(kVar.f121931m, com.tencent.luggage.wxa.b8.a.ClickReconnectButton);
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

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f121970a;

        public q(Context context) {
            this.f121970a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = this.f121970a;
            com.tencent.luggage.wxa.y9.a.makeText(context, com.tencent.luggage.wxa.kn.a.f(context, R.string.z1y), 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f121972b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f121973c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f121974a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k kVar) {
                super(0);
                this.f121974a = kVar;
            }

            public final void a() {
                c21.a.a(this.f121974a.f121921c, com.tencent.luggage.wxa.b8.a.ClickHelpButton, 0, null, null, false, 30, null);
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

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f121975a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f121976b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(k kVar, boolean z16) {
                super(1);
                this.f121975a = kVar;
                this.f121976b = z16;
            }

            public final void a(int i3) {
                com.tencent.luggage.wxa.b8.a aVar;
                com.tencent.luggage.wxa.b8.j jVar = this.f121975a.f121921c;
                if (this.f121976b) {
                    aVar = com.tencent.luggage.wxa.b8.a.ClickSwitchButton;
                } else {
                    aVar = com.tencent.luggage.wxa.b8.a.ClickCastButton;
                }
                c21.a.a(jVar, aVar, i3, null, null, false, 28, null);
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

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f121977a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f121978b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(k kVar, boolean z16) {
                super(2);
                this.f121977a = kVar;
                this.f121978b = z16;
            }

            public final void a(com.tencent.luggage.wxa.md.c cVar, int i3) {
                com.tencent.luggage.wxa.b8.n nVar = null;
                if (cVar == null) {
                    this.f121977a.f121920b.b(false);
                    com.tencent.luggage.wxa.b8.n nVar2 = this.f121977a.f121924f;
                    if (nVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                        nVar2 = null;
                    }
                    nVar2.a((Function2) null);
                    com.tencent.luggage.wxa.b8.n nVar3 = this.f121977a.f121924f;
                    if (nVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    } else {
                        nVar = nVar3;
                    }
                    nVar.j();
                    return;
                }
                this.f121977a.f121929k = com.tencent.luggage.wxa.b8.a.ClickDeviceButton;
                this.f121977a.f121920b.b(true);
                if (this.f121978b) {
                    com.tencent.luggage.wxa.b8.n nVar4 = this.f121977a.f121924f;
                    if (nVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                    } else {
                        nVar = nVar4;
                    }
                    nVar.j();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((com.tencent.luggage.wxa.md.c) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }
        }

        public r(boolean z16, boolean z17) {
            this.f121972b = z16;
            this.f121973c = z17;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.f121924f = new com.tencent.luggage.wxa.b8.n(k.this.f121922d, k.this.f121919a.d(), false, this.f121972b, k.this.f121923e, 4, null);
            com.tencent.luggage.wxa.b8.n nVar = k.this.f121924f;
            com.tencent.luggage.wxa.b8.n nVar2 = null;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                nVar = null;
            }
            nVar.a(new a(k.this));
            com.tencent.luggage.wxa.b8.n nVar3 = k.this.f121924f;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                nVar3 = null;
            }
            nVar3.a(new b(k.this, this.f121972b));
            com.tencent.luggage.wxa.b8.n nVar4 = k.this.f121924f;
            if (nVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
                nVar4 = null;
            }
            nVar4.a(new c(k.this, this.f121973c));
            com.tencent.luggage.wxa.b8.n nVar5 = k.this.f121924f;
            if (nVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectDeviceBottomSheet");
            } else {
                nVar2 = nVar5;
            }
            nVar2.k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class s implements com.tencent.luggage.wxa.od.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f121979a;

        public s(String str) {
            this.f121979a = str;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "seek fail");
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "seek to " + this.f121979a + " success");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t implements Action0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f121981b;

        public t(b bVar) {
            this.f121981b = bVar;
        }

        @Override // rx.functions.Action0
        public final void call() {
            k.this.a(this.f121981b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u implements com.tencent.luggage.wxa.od.a {
        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar != null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", "setVolume fail:" + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "setVolume success");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class v extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final v f121982a = new v();

        public v() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.b8.s it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.b8.s) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class w implements com.tencent.luggage.wxa.od.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f121984b;

        public w(Function1 function1) {
            this.f121984b = function1;
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            Object obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("stop fail");
            if (eVar != null) {
                obj = Integer.valueOf(eVar.f137497c);
            } else {
                obj = "";
            }
            sb5.append(obj);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCastController", sb5.toString());
            this.f121984b.invoke(new com.tencent.luggage.wxa.b8.s(false));
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e response) {
            Intrinsics.checkNotNullParameter(response, "response");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "stop success");
            k.this.f121923e.c().a(e.a.Stopped);
            k.this.j();
            k.this.c().f();
            this.f121984b.invoke(new com.tencent.luggage.wxa.b8.s(true));
        }
    }

    public k(com.tencent.luggage.wxa.b8.f castContext, com.tencent.luggage.wxa.b8.i castListener, com.tencent.luggage.wxa.b8.j castReportHandler) {
        Intrinsics.checkNotNullParameter(castContext, "castContext");
        Intrinsics.checkNotNullParameter(castListener, "castListener");
        Intrinsics.checkNotNullParameter(castReportHandler, "castReportHandler");
        this.f121919a = castContext;
        this.f121920b = castListener;
        this.f121921c = castReportHandler;
        this.f121922d = castContext.g().getContext();
        this.f121923e = new com.tencent.luggage.wxa.b8.l(null, 1, 0 == true ? 1 : 0);
        this.f121926h = new e0(Looper.getMainLooper(), (e0.a) new i(), true);
        this.f121927i = new e0(Looper.getMainLooper(), (e0.a) new o(), true);
        this.f121928j = new f();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public c f121932a;

        /* renamed from: b, reason: collision with root package name */
        public Object f121933b;

        public b(c eventType) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            this.f121932a = eventType;
        }

        public final c a() {
            return this.f121932a;
        }

        public final Object b() {
            return this.f121933b;
        }

        public b(c eventType, Object obj) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            this.f121932a = eventType;
            this.f121933b = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.md.d {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_PAUSED));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void b(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_PLAYING));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void c(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_STOPPED));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device, boolean z16) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_MUTE, Boolean.valueOf(z16)));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void b(com.tencent.luggage.wxa.md.c device, int i3) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_VOLUME, Integer.valueOf(i3)));
            }
        }

        @Override // com.tencent.luggage.wxa.md.d
        public void a(com.tencent.luggage.wxa.md.c device, int i3) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (Intrinsics.areEqual(device, k.this.f121923e.c())) {
                k.this.b(new b(c.ACTION_PROGRESS, Integer.valueOf(i3)));
            }
        }
    }

    public final e0 c() {
        return this.f121927i;
    }

    public final void d() {
        if (this.f121929k != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "onCastSrcChange, curAction not null");
        } else {
            this.f121929k = com.tencent.luggage.wxa.b8.a.ChangeCastSource;
        }
    }

    public final void e() {
        if (this.f121923e.c().d() == e.a.Playing) {
            this.f121920b.a(true);
        } else {
            this.f121923e.a(new p());
        }
    }

    public final void f() {
        if (this.f121926h.g()) {
            this.f121925g = false;
            this.f121926h.a(5000L);
        }
    }

    public final void g() {
        if (this.f121926h.g()) {
            return;
        }
        this.f121926h.f();
        this.f121925g = true;
    }

    public final void h() {
        this.f121927i.f();
        this.f121926h.f();
    }

    public final void i() {
        a(false, true);
    }

    public final void j() {
        this.f121923e.c().k();
        this.f121923e.c().l();
        this.f121923e.c().a((com.tencent.luggage.wxa.md.d) null);
    }

    public static final void b(int i3, k kVar) {
        if (i3 <= 0) {
            return;
        }
        kVar.f121930l = new n(i3);
    }

    public static final void c(k kVar, int i3) {
        kVar.f121923e.c().f(new m(i3));
    }

    public static final void b(k kVar, int i3) {
        kVar.f121923e.c().e(new l(i3));
    }

    public final void c(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f121923e.c().f(new w(callback));
    }

    public final void b(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f121923e.c().d(new C6036k(callback));
    }

    public static /* synthetic */ void b(k kVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = v.f121982a;
        }
        kVar.c(function1);
    }

    public final void b(b bVar) {
        synchronized (k.class) {
            Observable.empty().observeOn(com.tencent.luggage.wxa.rd.a.a()).doOnCompleted(new t(bVar)).subscribe();
        }
    }

    public static /* synthetic */ void a(k kVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        kVar.a(z16, z17);
    }

    public final void a(boolean z16, boolean z17) {
        Context c16 = z.c();
        if (!com.tencent.luggage.wxa.h6.j.a(c16)) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new q(c16));
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.MediaCastController", "searchDevice: wifi is not connected");
        }
        if (!z17) {
            this.f121923e.a();
        }
        this.f121923e.m();
        com.tencent.luggage.wxa.zp.h.f146825d.a(new r(z17, z16));
    }

    public final void b() {
        this.f121923e.c().b(new g());
    }

    public final void a() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new e());
        j();
        h();
        this.f121923e.a();
    }

    public static /* synthetic */ void a(k kVar, int i3, com.tencent.luggage.wxa.b8.a aVar, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -1;
        }
        if ((i16 & 2) != 0) {
            aVar = null;
        }
        kVar.a(i3, aVar);
    }

    public final void a(int i3, com.tencent.luggage.wxa.b8.a aVar) {
        this.f121929k = aVar;
        if (this.f121923e.c().d() == e.a.Paused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "play: continue");
            b(this, i3);
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "play: playNew");
            c(this, i3);
        }
        this.f121920b.e();
    }

    public static /* synthetic */ void a(k kVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = j.f121955a;
        }
        kVar.b(function1);
    }

    public final void a(String moment) {
        Intrinsics.checkNotNullParameter(moment, "moment");
        this.f121923e.c().a(moment, new s(moment));
    }

    public final void a(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "setVolume: " + i3);
        this.f121923e.c().a(i3, new u());
    }

    public final void a(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f121923e.c().c(new h(callback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(b bVar) {
        int i3;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", "handleBroadcast: " + bVar.a().name());
        switch (d.f121948b[bVar.a().ordinal()]) {
            case 1:
                this.f121923e.c().a(e.a.Playing);
                this.f121923e.l();
                f();
                if (com.tencent.luggage.wxa.b8.o.VOD == this.f121919a.getMediaType()) {
                    this.f121927i.a(1000L);
                }
                this.f121920b.f();
                this.f121920b.a(true);
                Function0 function0 = this.f121930l;
                if (function0 != null) {
                    function0.invoke();
                }
                this.f121930l = null;
                com.tencent.luggage.wxa.b8.a aVar = this.f121929k;
                i3 = aVar != null ? d.f121947a[aVar.ordinal()] : -1;
                if (i3 == 1) {
                    com.tencent.luggage.wxa.b8.j jVar = this.f121921c;
                    com.tencent.luggage.wxa.md.b c16 = this.f121923e.c().c();
                    String str = c16 != null ? c16.f134428h : null;
                    String str2 = str == null ? "" : str;
                    com.tencent.luggage.wxa.md.b c17 = this.f121923e.c().c();
                    String str3 = c17 != null ? c17.f134429i : null;
                    c21.a.a(jVar, aVar, 0, str2, str3 == null ? "" : str3, true, 2, null);
                } else if (i3 == 2 || i3 == 3) {
                    c21.a.a(this.f121921c, aVar, 0, null, null, true, 14, null);
                }
                this.f121929k = null;
                return;
            case 2:
                this.f121923e.c().a(e.a.Paused);
                this.f121920b.onPause();
                return;
            case 3:
                this.f121923e.c().a(e.a.Stopped);
                this.f121920b.b();
                return;
            case 4:
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Receive Action : Volume = ");
                Object b16 = bVar.b();
                sb5.append(b16 instanceof Integer ? (Integer) b16 : null);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", sb5.toString());
                return;
            case 5:
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Receive Action : Mute = ");
                Object b17 = bVar.b();
                sb6.append(b17 instanceof Boolean ? (Boolean) b17 : null);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCastController", sb6.toString());
                return;
            case 6:
                e.a d16 = this.f121923e.c().d();
                e.a aVar2 = e.a.Stopped;
                if (d16 == aVar2) {
                    return;
                }
                Object b18 = bVar.b();
                com.tencent.luggage.wxa.b8.a aVar3 = b18 instanceof com.tencent.luggage.wxa.b8.a ? (com.tencent.luggage.wxa.b8.a) b18 : null;
                i3 = aVar3 != null ? d.f121947a[aVar3.ordinal()] : -1;
                if (i3 == 1) {
                    com.tencent.luggage.wxa.b8.j jVar2 = this.f121921c;
                    com.tencent.luggage.wxa.md.b c18 = this.f121923e.c().c();
                    String str4 = c18 != null ? c18.f134428h : null;
                    String str5 = str4 == null ? "" : str4;
                    com.tencent.luggage.wxa.md.b c19 = this.f121923e.c().c();
                    Object obj = c19 != null ? c19.f134429i : null;
                    c21.a.a(jVar2, aVar3, 0, str5, obj == null ? "" : obj, false, 2, null);
                } else if (i3 == 2 || i3 == 3) {
                    c21.a.a(this.f121921c, aVar3, 0, null, null, false, 14, null);
                }
                this.f121920b.a(false);
                this.f121920b.a();
                j();
                h();
                this.f121923e.k();
                this.f121923e.c().a(aVar2);
                return;
            default:
                return;
        }
    }
}
