package com.tencent.luggage.wxa.zg;

import android.net.Uri;
import android.os.Handler;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.m.e;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zg.m;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends j {

    /* renamed from: c0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.so.c f146692c0 = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: z41.a
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return m.u();
        }
    });
    public final int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public volatile c f146693a0;

    /* renamed from: b0, reason: collision with root package name */
    public volatile d f146694b0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements e {
        @Override // com.tencent.luggage.wxa.zg.m.e
        public /* synthetic */ int P() {
            return z41.b.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: e, reason: collision with root package name */
        public static final c f146698e = new c(-1, false, false, false);

        /* renamed from: a, reason: collision with root package name */
        public final int f146699a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f146700b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f146701c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f146702d;

        public c(int i3, boolean z16, boolean z17, boolean z18) {
            this.f146699a = i3;
            this.f146700b = z16;
            this.f146701c = z17;
            this.f146702d = z18;
        }

        public String toString() {
            return "ExtraInfo{fixNotifyErrorChannel=" + this.f146699a + ", lockCache=" + this.f146700b + ", useCronet=" + this.f146701c + ", interruptCache=" + this.f146702d + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e extends com.tencent.luggage.wxa.eo.c {
        int P();
    }

    public m(Handler handler) {
        super(handler);
        this.Y = ((e) f146692c0.b()).P();
        this.Z = 0;
        this.f146693a0 = null;
        this.f146694b0 = null;
    }

    public static /* synthetic */ e u() {
        e eVar = (e) com.tencent.luggage.wxa.eo.g.a(e.class);
        if (eVar == null) {
            return new a();
        }
        return eVar;
    }

    public final void A() {
        x();
    }

    public final void B() {
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnErrorIfNeed, channel: " + this.Y);
        int i3 = this.Y;
        if (i3 != 1) {
            if (i3 == 2) {
                x();
                return;
            }
            return;
        }
        v();
    }

    public final void C() {
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError1IfNeed, channel: " + this.Y);
        int i3 = this.Y;
        if (i3 != 1) {
            if (i3 == 2) {
                z();
                return;
            }
            return;
        }
        w();
    }

    public final void D() {
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError2IfNeed, channel: " + this.Y);
        if (this.Y == 2) {
            A();
        }
    }

    @Override // com.tencent.luggage.wxa.zg.j
    public int a(Uri uri) {
        return h.f146649a.a(l(), uri);
    }

    @Override // com.tencent.luggage.wxa.zg.j
    public com.tencent.luggage.wxa.mg.i l() {
        return com.tencent.luggage.wxa.ah.a.f121405b;
    }

    @Override // com.tencent.luggage.wxa.zg.j
    public void p() {
        super.p();
        C();
    }

    @Override // com.tencent.luggage.wxa.zg.j
    public void q() {
        super.q();
        D();
    }

    public c t() {
        c cVar = this.f146693a0;
        if (cVar == null) {
            c cVar2 = new c(this.Y, com.tencent.luggage.wxa.ah.b.a(), false, com.tencent.luggage.wxa.zg.e.f146632a.a());
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "getExtraInfo, extraInfo: " + cVar2);
            this.f146693a0 = cVar2;
            return cVar2;
        }
        return cVar;
    }

    public final void v() {
        this.Z = 0;
    }

    public final void w() {
        int i3 = this.Z + 1;
        this.Z = i3;
        if (3 <= i3) {
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround1OnLoadError1");
            a(TXLiteAVCode.ERR_BGM_INVALID_URL, -2);
        }
    }

    public final void x() {
        this.Z = 0;
    }

    public final void y() {
        com.tencent.luggage.wxa.m.e eVar = this.f146658o;
        if (eVar == null) {
            return;
        }
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError, send DUMMY message to do some work");
        eVar.a(b.f146696b);
    }

    public final void z() {
        y();
        int i3 = this.Z + 1;
        this.Z = i3;
        if (4 <= i3) {
            w.f("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError1, loadErrorCount: " + this.Z);
            d dVar = this.f146694b0;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.zg.j
    public g.a a(Map map) {
        return com.tencent.luggage.wxa.zg.e.f146632a.a(this.f146657n, l(), map);
    }

    @Override // com.tencent.luggage.wxa.zg.j, com.tencent.luggage.wxa.xg.a
    public boolean a(int i3, int i16) {
        boolean a16 = super.a(i3, i16);
        B();
        return a16;
    }

    public void a(d dVar) {
        this.f146694b0 = dVar;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.tencent.luggage.wxa.zg.m$b, still in use, count: 1, list:
  (r0v0 com.tencent.luggage.wxa.zg.m$b) from 0x0014: CONSTRUCTOR (r0v0 com.tencent.luggage.wxa.zg.m$b), (0 int), (null java.lang.Object) A[MD:(com.tencent.luggage.wxa.m.e$b, int, java.lang.Object):void (m), WRAPPED] (LINE:21) call: com.tencent.luggage.wxa.m.e.c.<init>(com.tencent.luggage.wxa.m.e$b, int, java.lang.Object):void type: CONSTRUCTOR
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements e.b {
        INSTANCE;


        /* renamed from: b, reason: collision with root package name */
        public static final e.c f146696b = new e.c(new b(), 0, null);

        static {
        }

        public b() {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f146697c.clone();
        }

        @Override // com.tencent.luggage.wxa.m.e.b
        public void a(int i3, Object obj) {
        }
    }
}
