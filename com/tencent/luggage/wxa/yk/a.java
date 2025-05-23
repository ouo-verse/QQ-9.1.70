package com.tencent.luggage.wxa.yk;

import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.xg.g;
import java.util.Vector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements com.tencent.luggage.wxa.xg.h {

    /* renamed from: i, reason: collision with root package name */
    public static final C6960a f145985i = new C6960a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f145986a;

    /* renamed from: b, reason: collision with root package name */
    public final Function0 f145987b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.h f145988c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.h f145989d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.h f145990e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.h f145991f;

    /* renamed from: g, reason: collision with root package name */
    public final Vector f145992g;

    /* renamed from: h, reason: collision with root package name */
    public final Vector f145993h;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yk.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6960a {
        public C6960a() {
        }

        public /* synthetic */ C6960a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f145994a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g.b bVar) {
            super(1);
            this.f145994a = bVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.b(this.f145994a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.f f145995a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g.f fVar) {
            super(1);
            this.f145995a = fVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.b(this.f145995a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC6908g f145996a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g.InterfaceC6908g interfaceC6908g) {
            super(1);
            this.f145996a = interfaceC6908g;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.b(this.f145996a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f145998b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145999c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g.c f146000d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.yk.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6961a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g.c f146001a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6961a(g.c cVar) {
                super(0);
                this.f146001a = cVar;
            }

            public final void a() {
                this.f146001a.a();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public e(String str, String str2, g.c cVar) {
            this.f145998b = str;
            this.f145999c = str2;
            this.f146000d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.a(this.f145998b, this.f145999c);
            g.c cVar = this.f146000d;
            if (cVar != null) {
                a.this.a(new C6961a(cVar));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f146002a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z16) {
            super(1);
            this.f146002a = z16;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146002a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f146003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z16) {
            super(1);
            this.f146003a = z16;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.setMute(this.f146003a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a f146004a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g.a aVar) {
            super(1);
            this.f146004a = aVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146004a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f146005a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(g.b bVar) {
            super(1);
            this.f146005a = bVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146005a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class j extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.d f146006a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(g.d dVar) {
            super(1);
            this.f146006a = dVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146006a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class k extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.e f146007a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(g.e eVar) {
            super(1);
            this.f146007a = eVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146007a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class l extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.f f146008a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(g.f fVar) {
            super(1);
            this.f146008a = fVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146008a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class m extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC6908g f146009a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(g.InterfaceC6908g interfaceC6908g) {
            super(1);
            this.f146009a = interfaceC6908g;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146009a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class n extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.i f146010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(g.i iVar) {
            super(1);
            this.f146010a = iVar;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146010a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class o extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f146011a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(double d16) {
            super(1);
            this.f146011a = d16;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146011a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class p extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f146012a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Surface surface) {
            super(1);
            this.f146012a = surface;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.setSurface(this.f146012a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class q extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f146013a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f146014b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(float f16, float f17) {
            super(1);
            this.f146013a = f16;
            this.f146014b = f17;
        }

        public final void a(com.tencent.luggage.wxa.xg.h doOrAddPendingAction) {
            Intrinsics.checkNotNullParameter(doOrAddPendingAction, "$this$doOrAddPendingAction");
            doOrAddPendingAction.a(this.f146013a, this.f146014b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.xg.h) obj);
            return Unit.INSTANCE;
        }
    }

    public a(Function0 generalPlayerCreator, Function0 drmPlayerCreator) {
        Intrinsics.checkNotNullParameter(generalPlayerCreator, "generalPlayerCreator");
        Intrinsics.checkNotNullParameter(drmPlayerCreator, "drmPlayerCreator");
        this.f145986a = generalPlayerCreator;
        this.f145987b = drmPlayerCreator;
        this.f145992g = new Vector();
        this.f145993h = new Vector();
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public /* synthetic */ void a(g.h hVar) {
        r41.a.a(this, hVar);
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a("addOnPreparedListener", new c(listener));
    }

    public final synchronized com.tencent.luggage.wxa.xg.h c() {
        return this.f145989d;
    }

    public final synchronized com.tencent.luggage.wxa.xg.h d() {
        return this.f145988c;
    }

    public final com.tencent.luggage.wxa.xg.h e() {
        Object obj;
        boolean z16;
        synchronized (this) {
            obj = this.f145989d;
            if (obj == null) {
                obj = this.f145987b.invoke();
                this.f145989d = (com.tencent.luggage.wxa.xg.h) obj;
                z16 = true;
            } else {
                z16 = false;
            }
            this.f145990e = (com.tencent.luggage.wxa.xg.h) obj;
            this.f145991f = this.f145988c;
            Unit unit = Unit.INSTANCE;
        }
        if (z16) {
            synchronized (this.f145993h) {
                for (Function1 function1 : this.f145993h) {
                    Intrinsics.checkNotNull(obj);
                    function1.invoke(obj);
                }
                this.f145993h.clear();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        Intrinsics.checkNotNull(obj);
        return (com.tencent.luggage.wxa.xg.h) obj;
    }

    public final com.tencent.luggage.wxa.xg.h f() {
        Object obj;
        boolean z16;
        synchronized (this) {
            obj = this.f145988c;
            if (obj == null) {
                obj = this.f145986a.invoke();
                this.f145988c = (com.tencent.luggage.wxa.xg.h) obj;
                z16 = true;
            } else {
                z16 = false;
            }
            this.f145990e = (com.tencent.luggage.wxa.xg.h) obj;
            this.f145991f = this.f145989d;
            Unit unit = Unit.INSTANCE;
        }
        if (z16) {
            synchronized (this.f145992g) {
                for (Function1 function1 : this.f145992g) {
                    Intrinsics.checkNotNull(obj);
                    function1.invoke(obj);
                }
                this.f145992g.clear();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        Intrinsics.checkNotNull(obj);
        return (com.tencent.luggage.wxa.xg.h) obj;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getCurrentPosition() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getDuration() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getPlayerType() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getPlayerType();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getState() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getState();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoHeight() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoWidth() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean isPlaying() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void pause() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            b16.pause();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void prepareAsync() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            b16.prepareAsync();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void release() {
        com.tencent.luggage.wxa.xg.h d16 = d();
        if (d16 != null) {
            d16.release();
        }
        com.tencent.luggage.wxa.xg.h c16 = c();
        if (c16 != null) {
            c16.release();
        }
        synchronized (this) {
            this.f145988c = null;
            this.f145989d = null;
            this.f145990e = null;
            this.f145991f = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void reset() {
        com.tencent.luggage.wxa.xg.h d16 = d();
        if (d16 != null) {
            d16.reset();
        }
        com.tencent.luggage.wxa.xg.h c16 = c();
        if (c16 != null) {
            c16.reset();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public /* synthetic */ void setMinBufferDuration(long j3) {
        r41.a.b(this, j3);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setMute(boolean z16) {
        a("setMute", new g(z16));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setSurface(Surface surface) {
        a(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, new p(surface));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void start() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            b16.start();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void stop() {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            b16.stop();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.InterfaceC6908g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a("addOnSeekCompleteListener", new d(listener));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String path, String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        f().a(path, str);
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a("addOnCompletionListener", new b(listener));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String path, String str, g.c cVar) {
        Intrinsics.checkNotNullParameter(path, "path");
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new e(path, str, cVar));
    }

    public final synchronized com.tencent.luggage.wxa.xg.h b() {
        return this.f145990e;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String sourceUrl, String str, String str2, boolean z16) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        e().a(sourceUrl, str, str2, z16);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(double d16) {
        a("setPreferredPeakBitrate", new o(d16));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(float f16, float f17) {
        a("setVolume", new q(f16, f17));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(boolean z16) {
        a("setLooping", new f(z16));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.e eVar) {
        a("setOnInfoListener", new k(eVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.d dVar) {
        a("setOnErrorListener", new j(dVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.f fVar) {
        a("setOnPreparedListener", new l(fVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.b bVar) {
        a("setOnCompletionListener", new i(bVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.InterfaceC6908g interfaceC6908g) {
        a("setOnSeekCompleteListener", new m(interfaceC6908g));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.a aVar) {
        a("setOnBufferingUpdateListener", new h(aVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.i iVar) {
        a("setOnVideoSizeChangedListener", new n(iVar));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public com.tencent.luggage.wxa.xg.g a(Class playerClass) {
        Intrinsics.checkNotNullParameter(playerClass, "playerClass");
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            return b16.a(playerClass);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(long j3) {
        com.tencent.luggage.wxa.xg.h b16 = b();
        if (b16 != null) {
            b16.a(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean a(float f16) {
        com.tencent.luggage.wxa.xg.h b16 = b();
        boolean a16 = b16 != null ? b16.a(f16) : false;
        com.tencent.luggage.wxa.xg.h a17 = a();
        if (a17 != null) {
            a17.a(f16);
        }
        return a16;
    }

    public final void a(String str, Function1 function1) {
        com.tencent.luggage.wxa.xg.h d16 = d();
        if (d16 != null) {
            function1.invoke(d16);
        } else {
            this.f145992g.add(function1);
        }
        com.tencent.luggage.wxa.xg.h c16 = c();
        if (c16 != null) {
            function1.invoke(c16);
        } else {
            this.f145993h.add(function1);
        }
    }

    public final synchronized com.tencent.luggage.wxa.xg.h a() {
        return this.f145991f;
    }

    public final void a(final Function0 function0) {
        if (c0.b()) {
            function0.invoke();
        } else {
            c0.a(new Runnable() { // from class: com.tencent.luggage.wxa.yk.b
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            });
        }
    }
}
