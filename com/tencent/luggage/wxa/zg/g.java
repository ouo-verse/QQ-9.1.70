package com.tencent.luggage.wxa.zg;

import android.os.SystemClock;
import android.view.Surface;
import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.d0.f;
import com.tencent.luggage.wxa.k0.e;
import com.tencent.luggage.wxa.m.p;
import com.tencent.luggage.wxa.m.q;
import com.tencent.luggage.wxa.m.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.WiFiDash;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g implements q.a, com.tencent.luggage.wxa.n.e, com.tencent.luggage.wxa.o0.g, com.tencent.luggage.wxa.d0.a, f.a, com.tencent.luggage.wxa.a0.b {

    /* renamed from: e, reason: collision with root package name */
    public static final NumberFormat f146644e;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k0.e f146645a;

    /* renamed from: b, reason: collision with root package name */
    public final u.c f146646b = new u.c();

    /* renamed from: c, reason: collision with root package name */
    public final u.b f146647c = new u.b();

    /* renamed from: d, reason: collision with root package name */
    public final long f146648d = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f146644e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public g(com.tencent.luggage.wxa.k0.e eVar) {
        this.f146645a = eVar;
    }

    public static String a(int i3, int i16) {
        return i3 < 2 ? WiFiDash.NOT_AVALIBLE : i16 != 0 ? i16 != 8 ? i16 != 16 ? QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    public static String b(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    public static String c(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER : "E" : BdhLogUtil.LogTag.Tag_Req : "B" : "I";
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void d(com.tencent.luggage.wxa.o.c cVar) {
        w.a("MicroMsg.Video.Exo.EventLogger", "videoDisabled [" + c() + ", " + k.a(cVar) + "]");
    }

    @Override // com.tencent.luggage.wxa.d0.f.a
    public void onLoadError(IOException iOException) {
        a("loadError", iOException);
    }

    public static String b(boolean z16) {
        return z16 ? "[X]" : "[ ]";
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void a(int i3, com.tencent.luggage.wxa.m.j jVar, int i16, Object obj, long j3) {
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void c(com.tencent.luggage.wxa.o.c cVar) {
        w.d("MicroMsg.Video.Exo.EventLogger", "audioDisabled [" + c() + ", " + k.a(cVar) + "]");
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17) {
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void b(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void b(String str, long j3, long j16) {
        w.d("MicroMsg.Video.Exo.EventLogger", "audioDecoderInitialized [" + c() + ", " + str + ", " + j16 + "]");
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(boolean z16) {
        w.a("MicroMsg.Video.Exo.EventLogger", "loading [" + z16 + "]");
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void b(com.tencent.luggage.wxa.m.j jVar) {
        w.d("MicroMsg.Video.Exo.EventLogger", "audioFormatChanged [" + c() + ", " + com.tencent.luggage.wxa.m.j.a(jVar) + "]");
    }

    public final String c() {
        return a(SystemClock.elapsedRealtime() - this.f146648d);
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(boolean z16, int i3) {
        w.d("MicroMsg.Video.Exo.EventLogger", "state [" + c() + ", " + z16 + ", " + c(i3) + "]");
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void b(com.tencent.luggage.wxa.o.c cVar) {
        w.a("MicroMsg.Video.Exo.EventLogger", "videoEnabled [" + c() + "]");
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a() {
        w.a("MicroMsg.Video.Exo.EventLogger", "positionDiscontinuity");
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void b() {
        w.a("MicroMsg.Video.Exo.EventLogger", "onHasEndTag");
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(p pVar) {
        w.a("MicroMsg.Video.Exo.EventLogger", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(pVar.f133920a), Float.valueOf(pVar.f133921b)));
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(u uVar, Object obj) {
        int a16 = uVar.a();
        int b16 = uVar.b();
        w.a("MicroMsg.Video.Exo.EventLogger", "sourceInfo [periodCount=" + a16 + ", windowCount=" + b16);
        for (int i3 = 0; i3 < Math.min(a16, 3); i3++) {
            uVar.a(i3, this.f146647c);
            w.a("MicroMsg.Video.Exo.EventLogger", "  period [" + a(this.f146647c.c()) + "]");
        }
        if (a16 > 3) {
            w.a("MicroMsg.Video.Exo.EventLogger", "  ...");
        }
        for (int i16 = 0; i16 < Math.min(b16, 3); i16++) {
            uVar.a(i16, this.f146646b);
            w.a("MicroMsg.Video.Exo.EventLogger", "  window [" + a(this.f146646b.b()) + ", " + this.f146646b.f133940d + ", " + this.f146646b.f133941e + "]");
        }
        if (b16 > 3) {
            w.a("MicroMsg.Video.Exo.EventLogger", "  ...");
        }
        w.a("MicroMsg.Video.Exo.EventLogger", "]");
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(com.tencent.luggage.wxa.m.d dVar) {
        w.a("MicroMsg.Video.Exo.EventLogger", dVar, "playerFailed [" + c() + "]", new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.m.q.a
    public void a(com.tencent.luggage.wxa.d0.o oVar, com.tencent.luggage.wxa.k0.g gVar) {
        g gVar2;
        g gVar3 = this;
        e.a a16 = gVar3.f146645a.a();
        if (a16 == null) {
            w.a("MicroMsg.Video.Exo.EventLogger", "Tracks []");
            return;
        }
        w.a("MicroMsg.Video.Exo.EventLogger", "Tracks [");
        int i3 = 0;
        while (true) {
            String str = "  ]";
            String str2 = " [";
            if (i3 >= a16.f131399a) {
                break;
            }
            com.tencent.luggage.wxa.d0.o a17 = a16.a(i3);
            com.tencent.luggage.wxa.k0.f a18 = gVar.a(i3);
            if (a17.f124052a > 0) {
                w.a("MicroMsg.Video.Exo.EventLogger", "  Renderer:" + i3 + " [");
                int i16 = 0;
                while (i16 < a17.f124052a) {
                    com.tencent.luggage.wxa.d0.n a19 = a17.a(i16);
                    com.tencent.luggage.wxa.d0.o oVar2 = a17;
                    String str3 = str;
                    w.a("MicroMsg.Video.Exo.EventLogger", "    Group:" + i16 + ", adaptive_supported=" + a(a19.f124048a, a16.a(i3, i16, false)) + str2);
                    int i17 = 0;
                    while (i17 < a19.f124048a) {
                        w.a("MicroMsg.Video.Exo.EventLogger", "      " + a(a18, a19, i17) + " Track:" + i17 + ", " + com.tencent.luggage.wxa.m.j.a(a19.a(i17)) + ", supported=" + b(a16.a(i3, i16, i17)));
                        i17++;
                        str2 = str2;
                    }
                    w.a("MicroMsg.Video.Exo.EventLogger", "    ]");
                    i16++;
                    a17 = oVar2;
                    str = str3;
                }
                String str4 = str;
                if (a18 != null) {
                    for (int i18 = 0; i18 < a18.length(); i18++) {
                        com.tencent.luggage.wxa.a0.a aVar = a18.a(i18).f133894d;
                        if (aVar != null) {
                            w.a("MicroMsg.Video.Exo.EventLogger", "    Metadata [");
                            gVar2 = this;
                            gVar2.a(aVar, "      ");
                            w.a("MicroMsg.Video.Exo.EventLogger", "    ]");
                            break;
                        }
                    }
                }
                gVar2 = this;
                w.a("MicroMsg.Video.Exo.EventLogger", str4);
            } else {
                gVar2 = gVar3;
            }
            i3++;
            gVar3 = gVar2;
        }
        String str5 = " [";
        com.tencent.luggage.wxa.d0.o a26 = a16.a();
        if (a26.f124052a > 0) {
            w.a("MicroMsg.Video.Exo.EventLogger", "  Renderer:None [");
            int i19 = 0;
            while (i19 < a26.f124052a) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("    Group:");
                sb5.append(i19);
                String str6 = str5;
                sb5.append(str6);
                w.a("MicroMsg.Video.Exo.EventLogger", sb5.toString());
                com.tencent.luggage.wxa.d0.n a27 = a26.a(i19);
                int i26 = 0;
                while (i26 < a27.f124048a) {
                    com.tencent.luggage.wxa.d0.o oVar3 = a26;
                    w.a("MicroMsg.Video.Exo.EventLogger", "      " + b(false) + " Track:" + i26 + ", " + com.tencent.luggage.wxa.m.j.a(a27.a(i26)) + ", supported=" + b(0));
                    i26++;
                    a26 = oVar3;
                }
                w.a("MicroMsg.Video.Exo.EventLogger", "    ]");
                i19++;
                str5 = str6;
            }
            w.a("MicroMsg.Video.Exo.EventLogger", "  ]");
        }
        w.a("MicroMsg.Video.Exo.EventLogger", "]");
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void a(com.tencent.luggage.wxa.o.c cVar) {
        w.a("MicroMsg.Video.Exo.EventLogger", "audioEnabled [" + c() + "]");
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void a(int i3) {
        w.a("MicroMsg.Video.Exo.EventLogger", "audioSessionId [" + i3 + "]");
    }

    @Override // com.tencent.luggage.wxa.n.e
    public void a(int i3, long j3, long j16) {
        a("audioTrackUnderrun [" + i3 + ", " + j3 + ", " + j16 + "]", (Exception) null);
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void a(String str, long j3, long j16) {
        w.a("MicroMsg.Video.Exo.EventLogger", "videoDecoderInitialized [" + c() + ", " + str + ", " + j16 + "]");
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void a(com.tencent.luggage.wxa.m.j jVar) {
        w.d("MicroMsg.Video.Exo.EventLogger", "videoFormatChanged [" + c() + ", " + com.tencent.luggage.wxa.m.j.a(jVar) + "]");
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void a(int i3, long j3) {
        w.a("MicroMsg.Video.Exo.EventLogger", "droppedFrames [" + c() + ", " + i3 + "]");
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void a(int i3, int i16, int i17, float f16) {
        w.d("MicroMsg.Video.Exo.EventLogger", "videoSizeChanged [" + i3 + ", " + i16 + ", " + i17 + ", " + f16 + "]");
    }

    @Override // com.tencent.luggage.wxa.o0.g
    public void a(Surface surface) {
        w.d("MicroMsg.Video.Exo.EventLogger", "renderedFirstFrame [" + surface + "]");
    }

    @Override // com.tencent.luggage.wxa.d0.a
    public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
        a("loadError", iOException);
    }

    public final void a(String str, Exception exc) {
        w.a("MicroMsg.Video.Exo.EventLogger", exc, "internalError [" + c() + ", " + str + "]", new Object[0]);
    }

    public final void a(com.tencent.luggage.wxa.a0.a aVar, String str) {
        for (int i3 = 0; i3 < aVar.a(); i3++) {
            a.b a16 = aVar.a(i3);
            if (a16 instanceof com.tencent.luggage.wxa.c0.j) {
                com.tencent.luggage.wxa.c0.j jVar = (com.tencent.luggage.wxa.c0.j) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: value=%s", jVar.f123190a, jVar.f123194c));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.k) {
                com.tencent.luggage.wxa.c0.k kVar = (com.tencent.luggage.wxa.c0.k) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: url=%s", kVar.f123190a, kVar.f123196c));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.i) {
                com.tencent.luggage.wxa.c0.i iVar = (com.tencent.luggage.wxa.c0.i) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: owner=%s", iVar.f123190a, iVar.f123191b));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.f) {
                com.tencent.luggage.wxa.c0.f fVar = (com.tencent.luggage.wxa.c0.f) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: mimeType=%s, filename=%s, description=%s", fVar.f123190a, fVar.f123181b, fVar.f123182c, fVar.f123183d));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.a) {
                com.tencent.luggage.wxa.c0.a aVar2 = (com.tencent.luggage.wxa.c0.a) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: mimeType=%s, description=%s", aVar2.f123190a, aVar2.f123162b, aVar2.f123163c));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.e) {
                com.tencent.luggage.wxa.c0.e eVar = (com.tencent.luggage.wxa.c0.e) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s: language=%s, description=%s", eVar.f123190a, eVar.f123178b, eVar.f123179c));
            } else if (a16 instanceof com.tencent.luggage.wxa.c0.h) {
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("%s", ((com.tencent.luggage.wxa.c0.h) a16).f123190a));
            } else if (a16 instanceof com.tencent.luggage.wxa.b0.a) {
                com.tencent.luggage.wxa.b0.a aVar3 = (com.tencent.luggage.wxa.b0.a) a16;
                w.a("MicroMsg.Video.Exo.EventLogger", str + String.format("EMSG: scheme=%s, id=%d, value=%s", aVar3.f121814a, Long.valueOf(aVar3.f121817d), aVar3.f121815b));
            }
        }
    }

    public static String a(long j3) {
        return j3 == -9223372036854775807L ? QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER : f146644e.format(((float) j3) / 1000.0f);
    }

    public static String a(com.tencent.luggage.wxa.k0.f fVar, com.tencent.luggage.wxa.d0.n nVar, int i3) {
        return b((fVar == null || fVar.c() != nVar || fVar.c(i3) == -1) ? false : true);
    }
}
