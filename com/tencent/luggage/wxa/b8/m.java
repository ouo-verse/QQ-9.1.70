package com.tencent.luggage.wxa.b8;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import android.view.KeyEvent;
import com.tencent.luggage.wxa.b8.g;
import com.tencent.luggage.wxa.b8.j;
import com.tencent.luggage.wxa.ic.z;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends com.tencent.luggage.wxa.wj.b implements com.tencent.luggage.wxa.b8.f, com.tencent.luggage.wxa.b8.i {
    public final j C;
    public final d D;

    /* renamed from: a, reason: collision with root package name */
    public final int f122012a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.z7.c f122013b;

    /* renamed from: c, reason: collision with root package name */
    public final o f122014c;

    /* renamed from: d, reason: collision with root package name */
    public final String f122015d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f122016e;

    /* renamed from: f, reason: collision with root package name */
    public String f122017f;

    /* renamed from: g, reason: collision with root package name */
    public final ReadWriteProperty f122018g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f122019h;

    /* renamed from: i, reason: collision with root package name */
    public final Lazy f122020i;

    /* renamed from: j, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.g f122021j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.j f122022k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f122023l;

    /* renamed from: m, reason: collision with root package name */
    public final i f122024m;
    public static final /* synthetic */ KProperty[] F = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(m.class, "_castState", "get_castState()Lcom/tencent/luggage/xweb_ext/extendplugin/component/cast/CastState;", 0))};
    public static final c E = new c(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements g.d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public final void onForeground() {
            m.this.f122023l = true;
            m.this.k().g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements g.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public final void onBackground() {
            m.this.f122023l = false;
            m.this.k().f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final AudioManager f122027a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, Handler handler) {
            super(handler);
            AudioManager audioManager;
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                audioManager = (AudioManager) systemService;
            } else {
                audioManager = null;
            }
            this.f122027a = audioManager;
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            Integer num;
            AudioManager audioManager = this.f122027a;
            if (audioManager != null) {
                num = Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 3));
            } else {
                num = null;
            }
            w.d("MicroMsg.MediaCastHandler", "Volume now " + num);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122028a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.b8.b.values().length];
            iArr[com.tencent.luggage.wxa.b8.b.CastStarted.ordinal()] = 1;
            f122028a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k invoke() {
            m mVar = m.this;
            return new k(mVar, mVar, mVar.f122022k);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {
        public g() {
            super(1);
        }

        public final void a(s resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            if (!resp.b() && com.tencent.luggage.wxa.b8.b.CastStarted == m.this.m()) {
                m.this.a(com.tencent.luggage.wxa.b8.b.CastDeviceSelected);
            }
            k.a(m.this.k(), 0, (com.tencent.luggage.wxa.b8.a) null, 3, (Object) null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((s) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f122031a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Object obj, m mVar) {
            super(obj);
            this.f122031a = mVar;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            if (e.f122028a[((com.tencent.luggage.wxa.b8.b) obj2).ordinal()] == 1) {
                if (this.f122031a.f122023l) {
                    this.f122031a.o();
                    this.f122031a.p();
                } else {
                    this.f122031a.q();
                    this.f122031a.r();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends z {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f122033a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(m mVar) {
                super(1);
                this.f122033a = mVar;
            }

            public final void a(s it) {
                Intrinsics.checkNotNullParameter(it, "it");
                w.d("MicroMsg.MediaCastHandler", "volume now:" + it.a());
                k k3 = this.f122033a.k();
                Intrinsics.checkNotNull(it.a());
                k3.a(((Number) r3).intValue() - 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((s) obj);
                return Unit.INSTANCE;
            }
        }

        public i() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            w.d("MicroMsg.MediaCastHandler", "volume down");
            m.this.k().a(new a(m.this));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends z {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f122035a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(m mVar) {
                super(1);
                this.f122035a = mVar;
            }

            public final void a(s it) {
                Intrinsics.checkNotNullParameter(it, "it");
                w.d("MicroMsg.MediaCastHandler", "volume now:" + it.a());
                k k3 = this.f122035a.k();
                Object a16 = it.a();
                Intrinsics.checkNotNull(a16);
                k3.a(((Number) a16).intValue() + 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((s) obj);
                return Unit.INSTANCE;
            }
        }

        public j() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            w.d("MicroMsg.MediaCastHandler", "volume up");
            m.this.k().a(new a(m.this));
            return true;
        }
    }

    public m(int i3, com.tencent.luggage.wxa.z7.c invokeContext, o mediaType, g.a eventHandlerFactory, j.a reportHandlerFactory) {
        com.tencent.luggage.wxa.ic.d dVar;
        com.tencent.luggage.wxa.ic.g gVar;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(eventHandlerFactory, "eventHandlerFactory");
        Intrinsics.checkNotNullParameter(reportHandlerFactory, "reportHandlerFactory");
        this.f122012a = i3;
        this.f122013b = invokeContext;
        this.f122014c = mediaType;
        String optString = g().a().optString("data");
        Intrinsics.checkNotNullExpressionValue(optString, "invokeContext.invokeData.optString(DATA_KEY_DATA)");
        this.f122015d = optString;
        com.tencent.luggage.wxa.xd.d e16 = g().e();
        if (e16 instanceof com.tencent.luggage.wxa.ic.d) {
            dVar = (com.tencent.luggage.wxa.ic.d) e16;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            gVar = dVar.getRuntime();
        } else {
            gVar = null;
        }
        this.f122016e = gVar;
        this.f122017f = "";
        Delegates delegates = Delegates.INSTANCE;
        this.f122018g = new h(com.tencent.luggage.wxa.b8.b.Idle, this);
        lazy = LazyKt__LazyJVMKt.lazy(new f());
        this.f122020i = lazy;
        this.f122021j = eventHandlerFactory.a(this);
        this.f122022k = reportHandlerFactory.a(this);
        this.f122024m = new i();
        this.C = new j();
        Context c16 = com.tencent.luggage.wxa.tn.z.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
        this.D = new d(c16, null);
        w.d("MicroMsg.MediaCastHandler", "<init>");
        com.tencent.luggage.wxa.xd.d e17 = g().e();
        com.tencent.luggage.wxa.xd.f fVar = e17 instanceof com.tencent.luggage.wxa.xd.f ? (com.tencent.luggage.wxa.xd.f) e17 : null;
        if (fVar != null) {
            fVar.b(new a());
            fVar.a(new b());
        }
    }

    @Override // com.tencent.luggage.wxa.b8.f
    public int getId() {
        return this.f122012a;
    }

    @Override // com.tencent.luggage.wxa.b8.f
    public o getMediaType() {
        return this.f122014c;
    }

    @Override // com.tencent.luggage.wxa.wj.b
    public void i() {
        w.d("MicroMsg.MediaCastHandler", "onEnterFullscreen");
        this.f122019h = true;
    }

    @Override // com.tencent.luggage.wxa.wj.b
    public void j() {
        w.d("MicroMsg.MediaCastHandler", "onExitFullscreen");
        this.f122019h = false;
    }

    public final k k() {
        return (k) this.f122020i.getValue();
    }

    public com.tencent.luggage.wxa.b8.b l() {
        return m();
    }

    public final com.tencent.luggage.wxa.b8.b m() {
        return (com.tencent.luggage.wxa.b8.b) this.f122018g.getValue(this, F[0]);
    }

    public void n() {
        w.d("MicroMsg.MediaCastHandler", "handleDestroy");
        k().g();
        k().a();
        a(com.tencent.luggage.wxa.b8.b.Idle);
    }

    public final void o() {
        com.tencent.luggage.wxa.ic.g d16 = d();
        if (d16 != null) {
            d16.a(25, -1, this.f122024m);
        }
        com.tencent.luggage.wxa.ic.g d17 = d();
        if (d17 != null) {
            d17.a(24, -1, this.C);
        }
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void onPause() {
        w.d("MicroMsg.MediaCastHandler", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.f122021j.onPause();
    }

    public final void p() {
        com.tencent.luggage.wxa.tn.z.c().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.D);
    }

    public final void q() {
        com.tencent.luggage.wxa.ic.g d16 = d();
        if (d16 != null) {
            d16.a((z) this.f122024m);
        }
        com.tencent.luggage.wxa.ic.g d17 = d();
        if (d17 != null) {
            d17.a((z) this.C);
        }
    }

    public final void r() {
        com.tencent.luggage.wxa.tn.z.c().getContentResolver().unregisterContentObserver(this.D);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b() {
        w.d("MicroMsg.MediaCastHandler", "onEnd");
        this.f122021j.b();
    }

    @Override // com.tencent.luggage.wxa.b8.f
    public String c() {
        return this.f122017f;
    }

    @Override // com.tencent.luggage.wxa.b8.f
    public com.tencent.luggage.wxa.ic.g d() {
        return this.f122016e;
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void e() {
        w.d("MicroMsg.MediaCastHandler", "onWaiting");
        this.f122021j.e();
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void f() {
        w.d("MicroMsg.MediaCastHandler", "onPlay");
        this.f122021j.f();
    }

    @Override // com.tencent.luggage.wxa.b8.f
    public com.tencent.luggage.wxa.z7.c g() {
        return this.f122013b;
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void h() {
        w.d("MicroMsg.MediaCastHandler", "onCastInterruptUnexpectedly");
        this.f122021j.h();
    }

    public void c(boolean z16) {
        w.d("MicroMsg.MediaCastHandler", "toggleCastEnableState, enable: " + z16);
        a(z16 ? com.tencent.luggage.wxa.b8.b.CastEnabled : com.tencent.luggage.wxa.b8.b.Idle);
    }

    public void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = this.f122017f;
        this.f122017f = value;
        a(str, value);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b(int i3) {
        w.a("MicroMsg.MediaCastHandler", "onBufferUpdate, percent: " + i3);
        this.f122021j.b(i3);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b(boolean z16) {
        w.d("MicroMsg.MediaCastHandler", "onCastDeviceSelectResult, success: " + z16);
        this.f122021j.b(z16);
        if (z16) {
            a(com.tencent.luggage.wxa.b8.b.CastDeviceSelected);
        }
    }

    public final void a(com.tencent.luggage.wxa.b8.b bVar) {
        this.f122018g.setValue(this, F[0], bVar);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a() {
        w.d("MicroMsg.MediaCastHandler", "onError");
        this.f122021j.a();
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a(int i3, int i16) {
        w.a("MicroMsg.MediaCastHandler", "onPositionUpdate, current: " + i3 + ", total: " + i16);
        this.f122021j.a(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a(boolean z16) {
        w.d("MicroMsg.MediaCastHandler", "onCastStartResult, success: " + z16);
        this.f122021j.a(z16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean a(com.tencent.luggage.wxa.z7.c invokeContext, JSONObject data) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        Intrinsics.checkNotNullParameter(data, "data");
        String optString = data.optString("type");
        w.d("MicroMsg.MediaCastHandler", "handleOperate, opType: " + optString);
        if (optString != null) {
            switch (optString.hashCode()) {
                case -1983381905:
                    if (optString.equals("switchCasting")) {
                        c21.a.a(this.f122022k, com.tencent.luggage.wxa.b8.a.ClickSwitchButton, 0, null, null, false, 30, null);
                        k().i();
                        break;
                    }
                    break;
                case -1491869371:
                    if (optString.equals("exitCasting")) {
                        c21.a.a(this.f122022k, com.tencent.luggage.wxa.b8.a.ClickExitButton, 0, null, null, false, 30, null);
                        k.b(k(), null, 1, null);
                        k().a();
                        a(com.tencent.luggage.wxa.b8.b.Idle);
                        break;
                    }
                    break;
                case -934426579:
                    if (optString.equals("resume")) {
                        k.a(k(), 0, (com.tencent.luggage.wxa.b8.a) null, 3, (Object) null);
                        break;
                    }
                    break;
                case 3443508:
                    if (optString.equals("play")) {
                        k.a(k(), 0, (com.tencent.luggage.wxa.b8.a) null, 3, (Object) null);
                        break;
                    }
                    break;
                case 3526264:
                    if (optString.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                        if (o.VOD == getMediaType()) {
                            long a16 = a(data);
                            if (a16 < 0) {
                                w.d("MicroMsg.MediaCastHandler", "handleOperate, seekPos is invalid");
                                return false;
                            }
                            k().a(com.tencent.luggage.wxa.b8.c.a((int) a16));
                            break;
                        } else {
                            return false;
                        }
                    }
                    break;
                case 3540994:
                    if (optString.equals("stop")) {
                        k.b(k(), null, 1, null);
                        if (com.tencent.luggage.wxa.b8.b.CastStarted == m()) {
                            a(com.tencent.luggage.wxa.b8.b.CastDeviceSelected);
                            break;
                        }
                    }
                    break;
                case 106440182:
                    if (optString.equals("pause")) {
                        k.a(k(), null, 1, null);
                        break;
                    }
                    break;
                case 420897153:
                    if (optString.equals("startCasting")) {
                        k.a(k(), true, false, 2, (Object) null);
                        break;
                    }
                    break;
                case 1082113260:
                    if (optString.equals("reconnectCasting")) {
                        c21.a.a(this.f122022k, com.tencent.luggage.wxa.b8.a.ClickReconnectButton, 0, null, null, false, 30, null);
                        k().e();
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    public final long a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            double optDouble = optJSONArray.optDouble(0, -1.0d);
            if (optDouble < 0.0d) {
                w.f("MicroMsg.MediaCastHandler", "parseSeekPosition, invalid position: " + optDouble);
                return -1L;
            }
            w.d("MicroMsg.MediaCastHandler", "parseSeekPosition, position: " + optDouble);
            return (long) (optDouble * 1000);
        }
        w.f("MicroMsg.MediaCastHandler", "parseSeekPosition, data array is empty");
        return -1L;
    }

    public final void a(String str, String str2) {
        boolean isBlank;
        w.d("MicroMsg.MediaCastHandler", "onVideoPathUpdate, old: " + str + ", new: " + str2);
        if (Intrinsics.areEqual(str2, str)) {
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
        if (!isBlank && com.tencent.luggage.wxa.b8.b.CastDeviceSelected == m()) {
            a(com.tencent.luggage.wxa.b8.b.CastStarted);
            k().c(new g());
            k().d();
        }
    }
}
