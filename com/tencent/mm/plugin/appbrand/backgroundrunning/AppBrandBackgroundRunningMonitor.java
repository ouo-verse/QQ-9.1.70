package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.p6.h;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.th.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wd.b;
import com.tencent.luggage.wxa.xd.b0;
import com.tencent.mm.plugin.appbrand.backgroundrunning.a;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AppBrandBackgroundRunningMonitor {

    /* renamed from: a, reason: collision with root package name */
    public static b.e f151895a;

    /* renamed from: b, reason: collision with root package name */
    public static a.InterfaceC7054a f151896b;

    /* renamed from: c, reason: collision with root package name */
    public static IListener f151897c = new IListener<com.tencent.luggage.wxa.th.a>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.1
        @Override // com.tencent.mm.sdk.event.IListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean callback(com.tencent.luggage.wxa.th.a aVar) {
            a.C6755a c6755a;
            f b16;
            l h06;
            if (aVar != null && (c6755a = aVar.f141319d) != null && (b16 = h.b(c6755a.f141320a)) != null && (h06 = b16.h0()) != null) {
                a.C6755a c6755a2 = aVar.f141319d;
                boolean b17 = AppBrandBackgroundRunningMonitor.b(b16, c6755a2.f141322c, c6755a2.f141321b);
                a.C6755a c6755a3 = aVar.f141319d;
                AppBrandBackgroundRunningMonitor.b(h06, c6755a3.f141322c, c6755a3.f141321b, b17);
                return false;
            }
            return false;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static Set f151898d = new HashSet();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements c.InterfaceC6640c {
        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            f b16;
            if (bVar == com.tencent.luggage.wxa.qc.b.DESTROYED) {
                w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
                if (com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class) != null) {
                    com.tencent.luggage.wxa.uc.c cVar = new com.tencent.luggage.wxa.uc.c();
                    cVar.f142260a = str;
                    cVar.f142262c = com.tencent.luggage.wxa.uc.d.ALL.f142280a;
                    cVar.f142263d = 2;
                    if (h.b(str) != null && (b16 = h.b(str)) != null) {
                        cVar.f142261b = b16.l0();
                        if (b16.L() != null) {
                            cVar.f142264e = b16.L().getClass().getName();
                        }
                    }
                    com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class));
                    throw null;
                }
                if (!AppBrandBackgroundRunningMonitor.f151898d.remove(str)) {
                    w.f("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
                    return;
                }
                boolean isEmpty = AppBrandBackgroundRunningMonitor.f151898d.isEmpty();
                if (isEmpty) {
                    AppBrandBackgroundRunningMonitor.e();
                }
                AppBrandBackgroundRunningMonitor.d(str, isEmpty);
                if (isEmpty) {
                    w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
                    AppBrandBackgroundRunningMonitor.f151897c.dead();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements a.InterfaceC7054a {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements b.e {
        @Override // com.tencent.luggage.wxa.wd.b.e
        public void a(Object obj) {
            if (obj instanceof com.tencent.luggage.wxa.uc.f) {
                w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", (com.tencent.luggage.wxa.uc.f) obj);
                if (com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class) != null) {
                    com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class));
                    throw null;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d implements com.tencent.luggage.wxa.ka.f {
        d() {
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public void a(e eVar, i iVar) {
            if (eVar != null) {
                AppBrandBackgroundRunningMonitor.c(eVar.f151899a, eVar.f151900b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f151899a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f151900b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e(Parcel parcel) {
            boolean z16;
            this.f151899a = parcel.readString();
            if (parcel.readByte() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f151900b = z16;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f151899a);
            parcel.writeByte(this.f151900b ? (byte) 1 : (byte) 0);
        }
    }

    public static void d() {
        w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
        if (f151896b == null) {
            f151896b = new b();
            if (com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class) == null) {
                return;
            }
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class));
            throw null;
        }
    }

    public static void e() {
        w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "stopListeningOperationReceivedIfNeed");
        if (f151896b != null) {
            if (com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class) == null) {
                f151896b = null;
            } else {
                com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class));
                throw null;
            }
        }
    }

    public static void c(String str, boolean z16) {
        com.tencent.luggage.wxa.wd.c.a(str, new b0(z16));
    }

    public static boolean b(g gVar, int i3, int i16) {
        w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, operation: %d, usage: %d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i16 == com.tencent.luggage.wxa.uc.d.AUDIO_OF_VIDEO_BACKGROUND_PLAY.f142280a && i3 == 2) {
            com.tencent.luggage.wxa.ph.a aVar = (com.tencent.luggage.wxa.ph.a) gVar.c(com.tencent.luggage.wxa.ph.a.class);
            if (aVar != null) {
                if (aVar.i()) {
                    w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, audioOfVideoBackgroundPlayManager isBackgroundAudioPlayPaused");
                    return true;
                }
            } else {
                w.f("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, audioOfVideoBackgroundPlayManager is null");
            }
        }
        return false;
    }

    public static void a(g gVar) {
        if (gVar != null) {
            w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
            if (!f151898d.add(gVar.getAppId())) {
                w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
                return;
            }
            d();
            a(gVar.getAppId());
            if (1 == f151898d.size()) {
                w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
                f151897c.alive();
            }
            gVar.c0().a(new a());
        }
    }

    public static void d(String str, boolean z16) {
        w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "stopListeningOperationEvent, appId:%s, lastStop: %b", str, Boolean.valueOf(z16));
        b.e eVar = f151895a;
        if (eVar != null) {
            com.tencent.luggage.wxa.wd.b.b(str, eVar);
            if (z16) {
                f151895a = null;
            }
        }
    }

    public static void b(l lVar, int i3, int i16, boolean z16) {
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class) != null) {
            com.tencent.luggage.wxa.uc.c cVar = new com.tencent.luggage.wxa.uc.c();
            cVar.f142260a = lVar.getAppId();
            cVar.f142261b = lVar.getRuntime().l0();
            cVar.f142262c = i16;
            cVar.f142263d = i3;
            cVar.f142264e = lVar.getContext().getClass().getName();
            cVar.f142268i = z.i();
            cVar.f142271l = z16;
            cVar.f142269j = ((com.tencent.luggage.wxa.j4.d) lVar.getRuntime().S()).f130794f0;
            if (lVar.getRuntime() != null && (lVar.getRuntime().S() instanceof com.tencent.luggage.wxa.j4.d)) {
                com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) lVar.getRuntime().S();
                cVar.f142265f = dVar.f125809b;
                cVar.f142266g = dVar.f125810c;
                cVar.f142267h = dVar.G;
            }
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.mm.plugin.appbrand.backgroundrunning.a.class));
            throw null;
        }
    }

    public static void a(String str) {
        w.d("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", str);
        if (f151895a == null) {
            f151895a = new c();
        }
        com.tencent.luggage.wxa.wd.b.a(str, f151895a);
    }
}
