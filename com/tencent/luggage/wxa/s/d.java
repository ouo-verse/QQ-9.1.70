package com.tencent.luggage.wxa.s;

import android.util.Log;
import android.util.SparseArray;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.i;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.p.a;
import com.tencent.luggage.wxa.q.g;
import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.q.l;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements com.tencent.luggage.wxa.q.d {
    public static final g Z = new a();

    /* renamed from: a0, reason: collision with root package name */
    public static final byte[] f139921a0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, MultipartStream.DASH, MultipartStream.DASH, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: b0, reason: collision with root package name */
    public static final byte[] f139922b0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* renamed from: c0, reason: collision with root package name */
    public static long f139923c0 = 1000;

    /* renamed from: d0, reason: collision with root package name */
    public static final byte[] f139924d0 = v.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e0, reason: collision with root package name */
    public static final byte[] f139925e0 = {68, 105, 97, Constants.SDK_SEND_CHANNEL_DATA_TYPE, PublicAccountH5AbilityPluginImpl.OPENIMG, 103, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f0, reason: collision with root package name */
    public static long f139926f0 = 10000;

    /* renamed from: g0, reason: collision with root package name */
    public static final byte[] f139927g0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* renamed from: h0, reason: collision with root package name */
    public static final UUID f139928h0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public com.tencent.luggage.wxa.n0.g B;
    public com.tencent.luggage.wxa.n0.g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public com.tencent.luggage.wxa.q.f Y;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.s.b f139929a;

    /* renamed from: b, reason: collision with root package name */
    public final f f139930b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f139931c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f139932d;

    /* renamed from: e, reason: collision with root package name */
    public final l f139933e;

    /* renamed from: f, reason: collision with root package name */
    public final l f139934f;

    /* renamed from: g, reason: collision with root package name */
    public final l f139935g;

    /* renamed from: h, reason: collision with root package name */
    public final l f139936h;

    /* renamed from: i, reason: collision with root package name */
    public final l f139937i;

    /* renamed from: j, reason: collision with root package name */
    public final l f139938j;

    /* renamed from: k, reason: collision with root package name */
    public final l f139939k;

    /* renamed from: l, reason: collision with root package name */
    public final l f139940l;

    /* renamed from: m, reason: collision with root package name */
    public final l f139941m;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f139942n;

    /* renamed from: o, reason: collision with root package name */
    public long f139943o;

    /* renamed from: p, reason: collision with root package name */
    public long f139944p;

    /* renamed from: q, reason: collision with root package name */
    public long f139945q;

    /* renamed from: r, reason: collision with root package name */
    public long f139946r;

    /* renamed from: s, reason: collision with root package name */
    public long f139947s;

    /* renamed from: t, reason: collision with root package name */
    public c f139948t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f139949u;

    /* renamed from: v, reason: collision with root package name */
    public int f139950v;

    /* renamed from: w, reason: collision with root package name */
    public long f139951w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f139952x;

    /* renamed from: y, reason: collision with root package name */
    public long f139953y;

    /* renamed from: z, reason: collision with root package name */
    public long f139954z;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new d()};
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b implements com.tencent.luggage.wxa.s.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3, long j3, long j16) {
            d.this.a(i3, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public int b(int i3) {
            return d.this.b(i3);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public boolean c(int i3) {
            return d.this.c(i3);
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3) {
            d.this.a(i3);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3, long j3) {
            d.this.a(i3, j3);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3, double d16) {
            d.this.a(i3, d16);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3, String str) {
            d.this.a(i3, str);
        }

        @Override // com.tencent.luggage.wxa.s.c
        public void a(int i3, int i16, com.tencent.luggage.wxa.q.e eVar) {
            d.this.a(i3, i16, eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;
        public boolean L;
        public boolean M;
        public String N;
        public com.tencent.luggage.wxa.q.l O;
        public int P;

        /* renamed from: a, reason: collision with root package name */
        public String f139956a;

        /* renamed from: b, reason: collision with root package name */
        public int f139957b;

        /* renamed from: c, reason: collision with root package name */
        public int f139958c;

        /* renamed from: d, reason: collision with root package name */
        public int f139959d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f139960e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f139961f;

        /* renamed from: g, reason: collision with root package name */
        public l.a f139962g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f139963h;

        /* renamed from: i, reason: collision with root package name */
        public com.tencent.luggage.wxa.p.a f139964i;

        /* renamed from: j, reason: collision with root package name */
        public int f139965j;

        /* renamed from: k, reason: collision with root package name */
        public int f139966k;

        /* renamed from: l, reason: collision with root package name */
        public int f139967l;

        /* renamed from: m, reason: collision with root package name */
        public int f139968m;

        /* renamed from: n, reason: collision with root package name */
        public int f139969n;

        /* renamed from: o, reason: collision with root package name */
        public byte[] f139970o;

        /* renamed from: p, reason: collision with root package name */
        public int f139971p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f139972q;

        /* renamed from: r, reason: collision with root package name */
        public int f139973r;

        /* renamed from: s, reason: collision with root package name */
        public int f139974s;

        /* renamed from: t, reason: collision with root package name */
        public int f139975t;

        /* renamed from: u, reason: collision with root package name */
        public int f139976u;

        /* renamed from: v, reason: collision with root package name */
        public int f139977v;

        /* renamed from: w, reason: collision with root package name */
        public float f139978w;

        /* renamed from: x, reason: collision with root package name */
        public float f139979x;

        /* renamed from: y, reason: collision with root package name */
        public float f139980y;

        /* renamed from: z, reason: collision with root package name */
        public float f139981z;

        public c() {
            this.f139965j = -1;
            this.f139966k = -1;
            this.f139967l = -1;
            this.f139968m = -1;
            this.f139969n = 0;
            this.f139970o = null;
            this.f139971p = -1;
            this.f139972q = false;
            this.f139973r = -1;
            this.f139974s = -1;
            this.f139975t = -1;
            this.f139976u = 1000;
            this.f139977v = 200;
            this.f139978w = -1.0f;
            this.f139979x = -1.0f;
            this.f139980y = -1.0f;
            this.f139981z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = 8000;
            this.J = 0L;
            this.K = 0L;
            this.M = true;
            this.N = "eng";
        }

        public static boolean b(com.tencent.luggage.wxa.n0.l lVar) {
            try {
                int l3 = lVar.l();
                if (l3 == 1) {
                    return true;
                }
                if (l3 != 65534) {
                    return false;
                }
                lVar.e(24);
                if (lVar.m() == d.f139928h0.getMostSignificantBits()) {
                    if (lVar.m() == d.f139928h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing MS/ACM codec private");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x01d3. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:13:0x03e6  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x03ee  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0415  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(com.tencent.luggage.wxa.q.f fVar, int i3) {
            char c16;
            int i16;
            String str;
            int i17;
            List singletonList;
            int b16;
            List list;
            List a16;
            String str2;
            int i18;
            String str3;
            String str4;
            int i19;
            j a17;
            int i26;
            int i27;
            int i28;
            String str5 = this.f139956a;
            str5.hashCode();
            switch (str5.hashCode()) {
                case -2095576542:
                    if (str5.equals("V_MPEG4/ISO/AP")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -2095575984:
                    if (str5.equals("V_MPEG4/ISO/SP")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1985379776:
                    if (str5.equals("A_MS/ACM")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1784763192:
                    if (str5.equals("A_TRUEHD")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1730367663:
                    if (str5.equals("A_VORBIS")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1482641358:
                    if (str5.equals("A_MPEG/L2")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1482641357:
                    if (str5.equals("A_MPEG/L3")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1373388978:
                    if (str5.equals("V_MS/VFW/FOURCC")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -933872740:
                    if (str5.equals("S_DVBSUB")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -538363189:
                    if (str5.equals("V_MPEG4/ISO/ASP")) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -538363109:
                    if (str5.equals("V_MPEG4/ISO/AVC")) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -425012669:
                    if (str5.equals("S_VOBSUB")) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -356037306:
                    if (str5.equals("A_DTS/LOSSLESS")) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62923557:
                    if (str5.equals("A_AAC")) {
                        c16 = '\r';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62923603:
                    if (str5.equals("A_AC3")) {
                        c16 = 14;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62927045:
                    if (str5.equals("A_DTS")) {
                        c16 = 15;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 82338133:
                    if (str5.equals("V_VP8")) {
                        c16 = 16;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 82338134:
                    if (str5.equals("V_VP9")) {
                        c16 = 17;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 99146302:
                    if (str5.equals("S_HDMV/PGS")) {
                        c16 = 18;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 444813526:
                    if (str5.equals("V_THEORA")) {
                        c16 = 19;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 542569478:
                    if (str5.equals("A_DTS/EXPRESS")) {
                        c16 = 20;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 725957860:
                    if (str5.equals("A_PCM/INT/LIT")) {
                        c16 = 21;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 738597099:
                    if (str5.equals("S_TEXT/ASS")) {
                        c16 = 22;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 855502857:
                    if (str5.equals("V_MPEGH/ISO/HEVC")) {
                        c16 = 23;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1422270023:
                    if (str5.equals("S_TEXT/UTF8")) {
                        c16 = 24;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1809237540:
                    if (str5.equals("V_MPEG2")) {
                        c16 = 25;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1950749482:
                    if (str5.equals("A_EAC3")) {
                        c16 = 26;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1950789798:
                    if (str5.equals("A_FLAC")) {
                        c16 = 27;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1951062397:
                    if (str5.equals("A_OPUS")) {
                        c16 = 28;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            String str6 = "video/x-unknown";
            String str7 = "audio/raw";
            switch (c16) {
                case 0:
                case 1:
                case '\t':
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    byte[] bArr = this.f139963h;
                    singletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str7 = "video/mp4v-es";
                    list = singletonList;
                    b16 = -1;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                        a17 = j.a(Integer.toString(i3), str2, (String) null, -1, i18, this.G, this.I, i19, a16, this.f139964i, i29, this.N);
                        i26 = i17;
                    } else if (i.i(str2)) {
                        if (this.f139969n == 0) {
                            int i36 = this.f139967l;
                            i27 = -1;
                            if (i36 == -1) {
                                i36 = this.f139965j;
                            }
                            this.f139967l = i36;
                            int i37 = this.f139968m;
                            if (i37 == -1) {
                                i37 = this.f139966k;
                            }
                            this.f139968m = i37;
                        } else {
                            i27 = -1;
                        }
                        a17 = j.a(Integer.toString(i3), str2, (String) null, -1, i18, this.f139965j, this.f139966k, -1.0f, a16, -1, (this.f139967l == i27 || (i28 = this.f139968m) == i27) ? -1.0f : (this.f139966k * r3) / (this.f139965j * i28), this.f139970o, this.f139971p, this.f139972q ? new com.tencent.luggage.wxa.o0.b(this.f139973r, this.f139975t, this.f139974s, a()) : null, this.f139964i);
                        i26 = 2;
                    } else {
                        if ("application/x-subrip".equals(str2)) {
                            a17 = j.a(Integer.toString(i3), str2, i29, this.N, this.f139964i);
                        } else if ("text/x-ssa".equals(str2)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(d.f139924d0);
                            arrayList.add(this.f139963h);
                            a17 = j.a(Integer.toString(i3), str2, (String) null, -1, i29, this.N, -1, this.f139964i, Long.MAX_VALUE, arrayList);
                        } else {
                            if (!"application/vobsub".equals(str2) && !"application/pgs".equals(str2) && !str.equals(str2)) {
                                throw new o("Unexpected MIME type.");
                            }
                            a17 = j.a(Integer.toString(i3), str2, (String) null, -1, a16, this.N, this.f139964i);
                        }
                        i26 = i16;
                    }
                    com.tencent.luggage.wxa.q.l a18 = fVar.a(this.f139957b, i26);
                    this.O = a18;
                    a18.a(a17);
                    return;
                case 2:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    if (b(new com.tencent.luggage.wxa.n0.l(this.f139963h))) {
                        b16 = v.b(this.H);
                        if (b16 == 0) {
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                        } else {
                            str6 = "audio/raw";
                            list = null;
                            str7 = str6;
                            i19 = b16;
                            a16 = list;
                            str2 = str7;
                            i18 = -1;
                            int i292 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                            if (!i.g(str2)) {
                            }
                            com.tencent.luggage.wxa.q.l a182 = fVar.a(this.f139957b, i26);
                            this.O = a182;
                            a182.a(a17);
                            return;
                        }
                    } else {
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    }
                    str6 = "audio/x-unknown";
                    list = null;
                    b16 = -1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822 = fVar.a(this.f139957b, i26);
                    this.O = a1822;
                    a1822.a(a17);
                    return;
                case 3:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    str6 = "audio/true-hd";
                    list = null;
                    b16 = -1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222 = fVar.a(this.f139957b, i26);
                    this.O = a18222;
                    a18222.a(a17);
                    return;
                case 4:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    a16 = a(this.f139963h);
                    str2 = "audio/vorbis";
                    i18 = 8192;
                    i19 = -1;
                    int i292222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222 = fVar.a(this.f139957b, i26);
                    this.O = a182222;
                    a182222.a(a17);
                    return;
                case 5:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    str2 = "audio/mpeg-L2";
                    i18 = 4096;
                    a16 = null;
                    i19 = -1;
                    int i2922222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222;
                    a1822222.a(a17);
                    return;
                case 6:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    str2 = "audio/mpeg";
                    i18 = 4096;
                    a16 = null;
                    i19 = -1;
                    int i29222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222;
                    a18222222.a(a17);
                    return;
                case 7:
                    i16 = 3;
                    str = "application/dvbsubs";
                    i17 = 1;
                    List a19 = a(new com.tencent.luggage.wxa.n0.l(this.f139963h));
                    if (a19 != null) {
                        str6 = "video/wvc1";
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    }
                    list = a19;
                    b16 = -1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222;
                    a182222222.a(a17);
                    return;
                case '\b':
                    str = "application/dvbsubs";
                    byte[] bArr2 = this.f139963h;
                    i17 = 1;
                    i16 = 3;
                    list = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str7 = str;
                    b16 = -1;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222;
                    a1822222222.a(a17);
                    return;
                case '\n':
                    str = "application/dvbsubs";
                    com.tencent.luggage.wxa.o0.a b17 = com.tencent.luggage.wxa.o0.a.b(new com.tencent.luggage.wxa.n0.l(this.f139963h));
                    list = b17.f135959a;
                    this.P = b17.f135960b;
                    str3 = "video/avc";
                    str7 = str3;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222;
                    a18222222222.a(a17);
                    return;
                case 11:
                    str = "application/dvbsubs";
                    list = Collections.singletonList(this.f139963h);
                    str7 = "application/vobsub";
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222222;
                    a182222222222.a(a17);
                    return;
                case '\f':
                    str = "application/dvbsubs";
                    str6 = "audio/vnd.dts.hd";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222;
                    a1822222222222.a(a17);
                    return;
                case '\r':
                    str = "application/dvbsubs";
                    singletonList = Collections.singletonList(this.f139963h);
                    str4 = "audio/mp4a-latm";
                    str7 = str4;
                    i17 = 1;
                    i16 = 3;
                    list = singletonList;
                    b16 = -1;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222;
                    a18222222222222.a(a17);
                    return;
                case 14:
                    str = "application/dvbsubs";
                    str6 = "audio/ac3";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222222222;
                    a182222222222222.a(a17);
                    return;
                case 15:
                case 20:
                    str = "application/dvbsubs";
                    str6 = "audio/vnd.dts";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222222;
                    a1822222222222222.a(a17);
                    return;
                case 16:
                    str = "application/dvbsubs";
                    str6 = "video/x-vnd.on2.vp8";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222222;
                    a18222222222222222.a(a17);
                    return;
                case 17:
                    str = "application/dvbsubs";
                    str6 = "video/x-vnd.on2.vp9";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222222222222;
                    a182222222222222222.a(a17);
                    return;
                case 18:
                    str = "application/dvbsubs";
                    i16 = 3;
                    str6 = "application/pgs";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222222222;
                    a1822222222222222222.a(a17);
                    return;
                case 19:
                    str = "application/dvbsubs";
                    i16 = 3;
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222222222;
                    a18222222222222222222.a(a17);
                    return;
                case 21:
                    str = "application/dvbsubs";
                    b16 = v.b(this.H);
                    if (b16 == 0) {
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                        str6 = "audio/x-unknown";
                        list = null;
                        b16 = -1;
                        i17 = 1;
                        i16 = 3;
                        str7 = str6;
                        i19 = b16;
                        a16 = list;
                        str2 = str7;
                        i18 = -1;
                        int i292222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                        if (!i.g(str2)) {
                        }
                        com.tencent.luggage.wxa.q.l a182222222222222222222 = fVar.a(this.f139957b, i26);
                        this.O = a182222222222222222222;
                        a182222222222222222222.a(a17);
                        return;
                    }
                    list = null;
                    i17 = 1;
                    i16 = 3;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222222222222;
                    a1822222222222222222222.a(a17);
                    return;
                case 22:
                    str = "application/dvbsubs";
                    i16 = 3;
                    str6 = "text/x-ssa";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222222222222;
                    a18222222222222222222222.a(a17);
                    return;
                case 23:
                    str = "application/dvbsubs";
                    com.tencent.luggage.wxa.o0.d a26 = com.tencent.luggage.wxa.o0.d.a(new com.tencent.luggage.wxa.n0.l(this.f139963h));
                    list = a26.f135983a;
                    this.P = a26.f135984b;
                    str3 = "video/hevc";
                    str7 = str3;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222222222222222222;
                    a182222222222222222222222.a(a17);
                    return;
                case 24:
                    str = "application/dvbsubs";
                    i16 = 3;
                    str6 = "application/x-subrip";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222222222222222;
                    a1822222222222222222222222.a(a17);
                    return;
                case 25:
                    str = "application/dvbsubs";
                    str6 = "video/mpeg2";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i29222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222222222222222;
                    a18222222222222222222222222.a(a17);
                    return;
                case 26:
                    str = "application/dvbsubs";
                    str6 = "audio/eac3";
                    list = null;
                    b16 = -1;
                    i17 = 1;
                    i16 = 3;
                    str7 = str6;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i292222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a182222222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a182222222222222222222222222;
                    a182222222222222222222222222.a(a17);
                    return;
                case 27:
                    str = "application/dvbsubs";
                    singletonList = Collections.singletonList(this.f139963h);
                    str4 = "audio/flac";
                    str7 = str4;
                    i17 = 1;
                    i16 = 3;
                    list = singletonList;
                    b16 = -1;
                    i19 = b16;
                    a16 = list;
                    str2 = str7;
                    i18 = -1;
                    int i2922222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a1822222222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a1822222222222222222222222222;
                    a1822222222222222222222222222.a(a17);
                    return;
                case 28:
                    a16 = new ArrayList(3);
                    a16.add(this.f139963h);
                    str = "application/dvbsubs";
                    a16.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                    a16.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                    str2 = "audio/opus";
                    i18 = 5760;
                    i17 = 1;
                    i16 = 3;
                    i19 = -1;
                    int i29222222222222222222222222222 = (this.M ? 1 : 0) | 0 | (this.L ? 2 : 0);
                    if (!i.g(str2)) {
                    }
                    com.tencent.luggage.wxa.q.l a18222222222222222222222222222 = fVar.a(this.f139957b, i26);
                    this.O = a18222222222222222222222222222;
                    a18222222222222222222222222222.a(a17);
                    return;
                default:
                    throw new o("Unrecognized codec identifier.");
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public final byte[] a() {
            if (this.f139978w == -1.0f || this.f139979x == -1.0f || this.f139980y == -1.0f || this.f139981z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.f139978w * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.f139979x * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.f139980y * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.f139981z * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.E + 0.5f));
            wrap.putShort((short) (this.F + 0.5f));
            wrap.putShort((short) this.f139976u);
            wrap.putShort((short) this.f139977v);
            return bArr;
        }

        public static List a(com.tencent.luggage.wxa.n0.l lVar) {
            try {
                lVar.f(16);
                if (lVar.j() != 826496599) {
                    return null;
                }
                byte[] bArr = lVar.f135088a;
                for (int c16 = lVar.c() + 20; c16 < bArr.length - 4; c16++) {
                    if (bArr[c16] == 0 && bArr[c16 + 1] == 0 && bArr[c16 + 2] == 1 && bArr[c16 + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, c16, bArr.length));
                    }
                }
                throw new o("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing FourCC VC1 codec private");
            }
        }

        public static List a(byte[] bArr) {
            int i3;
            int i16;
            try {
                if (bArr[0] == 2) {
                    int i17 = 0;
                    int i18 = 1;
                    while (true) {
                        i3 = bArr[i18];
                        if (i3 != -1) {
                            break;
                        }
                        i17 += 255;
                        i18++;
                    }
                    int i19 = i18 + 1;
                    int i26 = i17 + i3;
                    int i27 = 0;
                    while (true) {
                        i16 = bArr[i19];
                        if (i16 != -1) {
                            break;
                        }
                        i27 += 255;
                        i19++;
                    }
                    int i28 = i19 + 1;
                    int i29 = i27 + i16;
                    if (bArr[i28] == 1) {
                        byte[] bArr2 = new byte[i26];
                        System.arraycopy(bArr, i28, bArr2, 0, i26);
                        int i36 = i28 + i26;
                        if (bArr[i36] == 3) {
                            int i37 = i36 + i29;
                            if (bArr[i37] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i37];
                                System.arraycopy(bArr, i37, bArr3, 0, bArr.length - i37);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new o("Error parsing vorbis codec private");
                        }
                        throw new o("Error parsing vorbis codec private");
                    }
                    throw new o("Error parsing vorbis codec private");
                }
                throw new o("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing vorbis codec private");
            }
        }
    }

    public d() {
        this(0);
    }

    public int b(int i3) {
        switch (i3) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    public boolean c(int i3) {
        return i3 == 357149030 || i3 == 524531317 || i3 == 475249515 || i3 == 374648427;
    }

    public final void d() {
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        this.f139938j.y();
    }

    public d(int i3) {
        this(new com.tencent.luggage.wxa.s.a(), i3);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        return new e().b(eVar);
    }

    public final k c() {
        com.tencent.luggage.wxa.n0.g gVar;
        com.tencent.luggage.wxa.n0.g gVar2;
        if (this.f139944p != -1 && this.f139947s != -9223372036854775807L && (gVar = this.B) != null && gVar.a() != 0 && (gVar2 = this.C) != null && gVar2.a() == this.B.a()) {
            int a16 = this.B.a();
            int[] iArr = new int[a16];
            long[] jArr = new long[a16];
            long[] jArr2 = new long[a16];
            long[] jArr3 = new long[a16];
            int i3 = 0;
            for (int i16 = 0; i16 < a16; i16++) {
                jArr3[i16] = this.B.a(i16);
                jArr[i16] = this.f139944p + this.C.a(i16);
            }
            while (true) {
                int i17 = a16 - 1;
                if (i3 < i17) {
                    int i18 = i3 + 1;
                    iArr[i3] = (int) (jArr[i18] - jArr[i3]);
                    jArr2[i3] = jArr3[i18] - jArr3[i3];
                    i3 = i18;
                } else {
                    iArr[i17] = (int) ((this.f139944p + this.f139943o) - jArr[i17]);
                    jArr2[i17] = this.f139947s - jArr3[i17];
                    this.B = null;
                    this.C = null;
                    return new com.tencent.luggage.wxa.q.a(iArr, jArr, jArr2, jArr3);
                }
            }
        } else {
            this.B = null;
            this.C = null;
            return new k.a(this.f139947s);
        }
    }

    public d(com.tencent.luggage.wxa.s.b bVar, int i3) {
        this.f139944p = -1L;
        this.f139945q = -9223372036854775807L;
        this.f139946r = -9223372036854775807L;
        this.f139947s = -9223372036854775807L;
        this.f139953y = -1L;
        this.f139954z = -1L;
        this.A = -9223372036854775807L;
        this.f139929a = bVar;
        bVar.a(new b(this, null));
        this.f139932d = (i3 & 1) == 0;
        this.f139930b = new f();
        this.f139931c = new SparseArray();
        this.f139935g = new com.tencent.luggage.wxa.n0.l(4);
        this.f139936h = new com.tencent.luggage.wxa.n0.l(ByteBuffer.allocate(4).putInt(-1).array());
        this.f139937i = new com.tencent.luggage.wxa.n0.l(4);
        this.f139933e = new com.tencent.luggage.wxa.n0.l(com.tencent.luggage.wxa.n0.j.f135067a);
        this.f139934f = new com.tencent.luggage.wxa.n0.l(4);
        this.f139938j = new com.tencent.luggage.wxa.n0.l();
        this.f139939k = new com.tencent.luggage.wxa.n0.l();
        this.f139940l = new com.tencent.luggage.wxa.n0.l(8);
        this.f139941m = new com.tencent.luggage.wxa.n0.l();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.Y = fVar;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.A = -9223372036854775807L;
        this.E = 0;
        this.f139929a.reset();
        this.f139930b.b();
        d();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        this.W = false;
        boolean z16 = true;
        while (z16 && !this.W) {
            z16 = this.f139929a.a(eVar);
            if (z16 && a(jVar, eVar.getPosition())) {
                return 1;
            }
        }
        return z16 ? 0 : -1;
    }

    public void a(int i3, long j3, long j16) {
        if (i3 == 160) {
            this.X = false;
            return;
        }
        if (i3 == 174) {
            this.f139948t = new c(null);
            return;
        }
        if (i3 == 187) {
            this.D = false;
            return;
        }
        if (i3 == 19899) {
            this.f139950v = -1;
            this.f139951w = -1L;
            return;
        }
        if (i3 == 20533) {
            this.f139948t.f139960e = true;
            return;
        }
        if (i3 == 21968) {
            this.f139948t.f139972q = true;
            return;
        }
        if (i3 == 408125543) {
            long j17 = this.f139944p;
            if (j17 != -1 && j17 != j3) {
                throw new o("Multiple Segment elements not supported");
            }
            this.f139944p = j3;
            this.f139943o = j16;
            return;
        }
        if (i3 != 475249515) {
            if (i3 == 524531317 && !this.f139949u) {
                if (this.f139932d && this.f139953y != -1) {
                    this.f139952x = true;
                    return;
                } else {
                    this.Y.a(new k.a(this.f139947s));
                    this.f139949u = true;
                    return;
                }
            }
            return;
        }
        this.B = new com.tencent.luggage.wxa.n0.g();
        this.C = new com.tencent.luggage.wxa.n0.g();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    public void a(int i3) {
        if (i3 == 160) {
            if (this.E != 2) {
                return;
            }
            if (!this.X) {
                this.M |= 1;
            }
            a((c) this.f139931c.get(this.K), this.F);
            this.E = 0;
            return;
        }
        if (i3 == 174) {
            if (a(this.f139948t.f139956a)) {
                c cVar = this.f139948t;
                cVar.a(this.Y, cVar.f139957b);
                SparseArray sparseArray = this.f139931c;
                c cVar2 = this.f139948t;
                sparseArray.put(cVar2.f139957b, cVar2);
            }
            this.f139948t = null;
            return;
        }
        if (i3 == 19899) {
            int i16 = this.f139950v;
            if (i16 != -1) {
                long j3 = this.f139951w;
                if (j3 != -1) {
                    if (i16 == 475249515) {
                        this.f139953y = j3;
                        return;
                    }
                    return;
                }
            }
            throw new o("Mandatory element SeekID or SeekPosition not found");
        }
        if (i3 == 25152) {
            c cVar3 = this.f139948t;
            if (cVar3.f139960e) {
                if (cVar3.f139962g != null) {
                    cVar3.f139964i = new com.tencent.luggage.wxa.p.a(new a.b(com.tencent.luggage.wxa.m.b.f133806b, null, "video/webm", this.f139948t.f139962g.f137772b));
                    return;
                }
                throw new o("Encrypted Track found but ContentEncKeyID was not found");
            }
            return;
        }
        if (i3 == 28032) {
            c cVar4 = this.f139948t;
            if (cVar4.f139960e && cVar4.f139961f != null) {
                throw new o("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i3 == 357149030) {
            if (this.f139945q == -9223372036854775807L) {
                this.f139945q = 1000000L;
            }
            long j16 = this.f139946r;
            if (j16 != -9223372036854775807L) {
                this.f139947s = a(j16);
                return;
            }
            return;
        }
        if (i3 != 374648427) {
            if (i3 == 475249515 && !this.f139949u) {
                this.Y.a(c());
                this.f139949u = true;
                return;
            }
            return;
        }
        if (this.f139931c.size() != 0) {
            this.Y.e();
            return;
        }
        throw new o("No valid tracks were found");
    }

    public void a(int i3, long j3) {
        if (i3 == 20529) {
            if (j3 == 0) {
                return;
            }
            throw new o("ContentEncodingOrder " + j3 + " not supported");
        }
        if (i3 == 20530) {
            if (j3 == 1) {
                return;
            }
            throw new o("ContentEncodingScope " + j3 + " not supported");
        }
        switch (i3) {
            case 131:
                this.f139948t.f139958c = (int) j3;
                return;
            case 136:
                this.f139948t.L = j3 == 1;
                return;
            case 155:
                this.G = a(j3);
                return;
            case 159:
                this.f139948t.G = (int) j3;
                return;
            case 176:
                this.f139948t.f139965j = (int) j3;
                return;
            case 179:
                this.B.a(a(j3));
                return;
            case 186:
                this.f139948t.f139966k = (int) j3;
                return;
            case 215:
                this.f139948t.f139957b = (int) j3;
                return;
            case 231:
                this.A = a(j3);
                return;
            case 241:
                if (this.D) {
                    return;
                }
                this.C.a(j3);
                this.D = true;
                return;
            case 251:
                this.X = true;
                return;
            case 16980:
                if (j3 == 3) {
                    return;
                }
                throw new o("ContentCompAlgo " + j3 + " not supported");
            case 17029:
                if (j3 < 1 || j3 > 2) {
                    throw new o("DocTypeReadVersion " + j3 + " not supported");
                }
                return;
            case 17143:
                if (j3 == 1) {
                    return;
                }
                throw new o("EBMLReadVersion " + j3 + " not supported");
            case 18401:
                if (j3 == 5) {
                    return;
                }
                throw new o("ContentEncAlgo " + j3 + " not supported");
            case 18408:
                if (j3 == 1) {
                    return;
                }
                throw new o("AESSettingsCipherMode " + j3 + " not supported");
            case 21420:
                this.f139951w = j3 + this.f139944p;
                return;
            case 21432:
                int i16 = (int) j3;
                if (i16 == 0) {
                    this.f139948t.f139971p = 0;
                    return;
                }
                if (i16 == 1) {
                    this.f139948t.f139971p = 2;
                    return;
                } else if (i16 == 3) {
                    this.f139948t.f139971p = 1;
                    return;
                } else {
                    if (i16 != 15) {
                        return;
                    }
                    this.f139948t.f139971p = 3;
                    return;
                }
            case 21680:
                this.f139948t.f139967l = (int) j3;
                return;
            case 21682:
                this.f139948t.f139969n = (int) j3;
                return;
            case 21690:
                this.f139948t.f139968m = (int) j3;
                return;
            case 21930:
                this.f139948t.M = j3 == 1;
                return;
            case 22186:
                this.f139948t.J = j3;
                return;
            case 22203:
                this.f139948t.K = j3;
                return;
            case 25188:
                this.f139948t.H = (int) j3;
                return;
            case 2352003:
                this.f139948t.f139959d = (int) j3;
                return;
            case 2807729:
                this.f139945q = j3;
                return;
            default:
                switch (i3) {
                    case 21945:
                        int i17 = (int) j3;
                        if (i17 == 1) {
                            this.f139948t.f139975t = 2;
                            return;
                        } else {
                            if (i17 != 2) {
                                return;
                            }
                            this.f139948t.f139975t = 1;
                            return;
                        }
                    case 21946:
                        int i18 = (int) j3;
                        if (i18 != 1) {
                            if (i18 == 16) {
                                this.f139948t.f139974s = 6;
                                return;
                            } else if (i18 == 18) {
                                this.f139948t.f139974s = 7;
                                return;
                            } else if (i18 != 6 && i18 != 7) {
                                return;
                            }
                        }
                        this.f139948t.f139974s = 3;
                        return;
                    case 21947:
                        c cVar = this.f139948t;
                        cVar.f139972q = true;
                        int i19 = (int) j3;
                        if (i19 == 1) {
                            cVar.f139973r = 1;
                            return;
                        }
                        if (i19 == 9) {
                            cVar.f139973r = 6;
                            return;
                        } else {
                            if (i19 == 4 || i19 == 5 || i19 == 6 || i19 == 7) {
                                cVar.f139973r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.f139948t.f139976u = (int) j3;
                        return;
                    case 21949:
                        this.f139948t.f139977v = (int) j3;
                        return;
                    default:
                        return;
                }
        }
    }

    public void a(int i3, double d16) {
        if (i3 == 181) {
            this.f139948t.I = (int) d16;
            return;
        }
        if (i3 != 17545) {
            switch (i3) {
                case 21969:
                    this.f139948t.f139978w = (float) d16;
                    return;
                case 21970:
                    this.f139948t.f139979x = (float) d16;
                    return;
                case 21971:
                    this.f139948t.f139980y = (float) d16;
                    return;
                case 21972:
                    this.f139948t.f139981z = (float) d16;
                    return;
                case 21973:
                    this.f139948t.A = (float) d16;
                    return;
                case 21974:
                    this.f139948t.B = (float) d16;
                    return;
                case 21975:
                    this.f139948t.C = (float) d16;
                    return;
                case 21976:
                    this.f139948t.D = (float) d16;
                    return;
                case 21977:
                    this.f139948t.E = (float) d16;
                    return;
                case 21978:
                    this.f139948t.F = (float) d16;
                    return;
                default:
                    return;
            }
        }
        this.f139946r = (long) d16;
    }

    public void a(int i3, String str) {
        if (i3 == 134) {
            this.f139948t.f139956a = str;
            return;
        }
        if (i3 != 17026) {
            if (i3 != 2274716) {
                return;
            }
            this.f139948t.N = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw new o("DocType " + str + " not supported");
        }
    }

    public void a(int i3, int i16, com.tencent.luggage.wxa.q.e eVar) {
        int i17;
        long j3;
        int i18;
        int i19;
        int i26;
        int i27 = 1;
        int i28 = 0;
        if (i3 != 161 && i3 != 163) {
            if (i3 == 16981) {
                byte[] bArr = new byte[i16];
                this.f139948t.f139961f = bArr;
                eVar.a(bArr, 0, i16);
                return;
            }
            if (i3 == 18402) {
                byte[] bArr2 = new byte[i16];
                eVar.a(bArr2, 0, i16);
                this.f139948t.f139962g = new l.a(1, bArr2, 0, 0);
                return;
            }
            if (i3 == 21419) {
                Arrays.fill(this.f139937i.f135088a, (byte) 0);
                eVar.a(this.f139937i.f135088a, 4 - i16, i16);
                this.f139937i.e(0);
                this.f139950v = (int) this.f139937i.s();
                return;
            }
            if (i3 == 25506) {
                byte[] bArr3 = new byte[i16];
                this.f139948t.f139963h = bArr3;
                eVar.a(bArr3, 0, i16);
                return;
            } else if (i3 == 30322) {
                byte[] bArr4 = new byte[i16];
                this.f139948t.f139970o = bArr4;
                eVar.a(bArr4, 0, i16);
                return;
            } else {
                throw new o("Unexpected id: " + i3);
            }
        }
        if (this.E == 0) {
            this.K = (int) this.f139930b.a(eVar, false, true, 8);
            this.L = this.f139930b.a();
            this.G = -9223372036854775807L;
            this.E = 1;
            this.f139935g.y();
        }
        c cVar = (c) this.f139931c.get(this.K);
        if (cVar == null) {
            eVar.c(i16 - this.L);
            this.E = 0;
            return;
        }
        if (this.E == 1) {
            a(eVar, 3);
            int i29 = (this.f139935g.f135088a[2] & 6) >> 1;
            byte b16 = 255;
            if (i29 == 0) {
                this.I = 1;
                int[] a16 = a(this.J, 1);
                this.J = a16;
                a16[0] = (i16 - this.L) - 3;
            } else if (i3 == 163) {
                int i36 = 4;
                a(eVar, 4);
                int i37 = (this.f139935g.f135088a[3] & 255) + 1;
                this.I = i37;
                int[] a17 = a(this.J, i37);
                this.J = a17;
                if (i29 == 2) {
                    int i38 = (i16 - this.L) - 4;
                    int i39 = this.I;
                    Arrays.fill(a17, 0, i39, i38 / i39);
                } else {
                    if (i29 != 1) {
                        if (i29 == 3) {
                            int i46 = 0;
                            int i47 = 0;
                            while (true) {
                                int i48 = this.I - i27;
                                if (i46 < i48) {
                                    this.J[i46] = i28;
                                    i36++;
                                    a(eVar, i36);
                                    int i49 = i36 - 1;
                                    if (this.f139935g.f135088a[i49] == 0) {
                                        throw new o("No valid varint length mask found");
                                    }
                                    int i56 = i28;
                                    while (true) {
                                        if (i56 >= 8) {
                                            j3 = 0;
                                            break;
                                        }
                                        int i57 = i27 << (7 - i56);
                                        if ((this.f139935g.f135088a[i49] & i57) != 0) {
                                            i36 += i56;
                                            a(eVar, i36);
                                            j3 = (~i57) & this.f139935g.f135088a[i49] & b16;
                                            int i58 = i49 + 1;
                                            while (i58 < i36) {
                                                j3 = (j3 << 8) | (this.f139935g.f135088a[i58] & b16);
                                                i58++;
                                                b16 = 255;
                                            }
                                            if (i46 > 0) {
                                                j3 -= (1 << ((i56 * 7) + 6)) - 1;
                                            }
                                        } else {
                                            i56++;
                                            i27 = 1;
                                            b16 = 255;
                                        }
                                    }
                                    if (j3 < WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || j3 > TTL.MAX_VALUE) {
                                        break;
                                    }
                                    int i59 = (int) j3;
                                    int[] iArr = this.J;
                                    if (i46 != 0) {
                                        i59 += iArr[i46 - 1];
                                    }
                                    iArr[i46] = i59;
                                    i47 += i59;
                                    i46++;
                                    i27 = 1;
                                    i28 = 0;
                                    b16 = 255;
                                } else {
                                    this.J[i48] = ((i16 - this.L) - i36) - i47;
                                    break;
                                }
                            }
                            throw new o("EBML lacing sample size out of range.");
                        }
                        throw new o("Unexpected lacing value: " + i29);
                    }
                    int i65 = 0;
                    int i66 = 0;
                    while (true) {
                        i18 = this.I - 1;
                        if (i65 >= i18) {
                            break;
                        }
                        this.J[i65] = 0;
                        do {
                            i36++;
                            a(eVar, i36);
                            i19 = this.f139935g.f135088a[i36 - 1] & 255;
                            int[] iArr2 = this.J;
                            i26 = iArr2[i65] + i19;
                            iArr2[i65] = i26;
                        } while (i19 == 255);
                        i66 += i26;
                        i65++;
                    }
                    this.J[i18] = ((i16 - this.L) - i36) - i66;
                }
            } else {
                throw new o("Lacing only supported in SimpleBlocks.");
            }
            byte[] bArr5 = this.f139935g.f135088a;
            this.F = this.A + a((bArr5[1] & 255) | (bArr5[0] << 8));
            byte b17 = this.f139935g.f135088a[2];
            this.M = ((cVar.f139958c == 2 || (i3 == 163 && (b17 & 128) == 128)) ? 1 : 0) | ((b17 & 8) == 8 ? Integer.MIN_VALUE : 0);
            this.E = 2;
            this.H = 0;
            i17 = 163;
        } else {
            i17 = 163;
        }
        if (i3 != i17) {
            a(eVar, cVar, this.J[0]);
            return;
        }
        while (true) {
            int i67 = this.H;
            if (i67 < this.I) {
                a(eVar, cVar, this.J[i67]);
                a(cVar, this.F + ((this.H * cVar.f139959d) / 1000));
                this.H++;
            } else {
                this.E = 0;
                return;
            }
        }
    }

    public final void a(c cVar, long j3) {
        if ("S_TEXT/UTF8".equals(cVar.f139956a)) {
            a(cVar, "%02d:%02d:%02d,%03d", 19, f139923c0, f139922b0);
        } else if ("S_TEXT/ASS".equals(cVar.f139956a)) {
            a(cVar, "%01d:%02d:%02d:%02d", 21, f139926f0, f139927g0);
        }
        cVar.O.a(j3, this.M, this.V, 0, cVar.f139962g);
        this.W = true;
        d();
    }

    public final void a(com.tencent.luggage.wxa.q.e eVar, int i3) {
        if (this.f139935g.d() >= i3) {
            return;
        }
        if (this.f139935g.b() < i3) {
            com.tencent.luggage.wxa.n0.l lVar = this.f139935g;
            byte[] bArr = lVar.f135088a;
            lVar.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i3)), this.f139935g.d());
        }
        com.tencent.luggage.wxa.n0.l lVar2 = this.f139935g;
        eVar.a(lVar2.f135088a, lVar2.d(), i3 - this.f139935g.d());
        this.f139935g.d(i3);
    }

    public final void a(com.tencent.luggage.wxa.q.e eVar, c cVar, int i3) {
        int i16;
        if ("S_TEXT/UTF8".equals(cVar.f139956a)) {
            a(eVar, f139921a0, i3);
            return;
        }
        if ("S_TEXT/ASS".equals(cVar.f139956a)) {
            a(eVar, f139925e0, i3);
            return;
        }
        com.tencent.luggage.wxa.q.l lVar = cVar.O;
        if (!this.O) {
            if (cVar.f139960e) {
                this.M &= -1073741825;
                if (!this.P) {
                    eVar.a(this.f139935g.f135088a, 0, 1);
                    this.N++;
                    byte b16 = this.f139935g.f135088a[0];
                    if ((b16 & 128) != 128) {
                        this.S = b16;
                        this.P = true;
                    } else {
                        throw new o("Extension bit is set in signal byte");
                    }
                }
                byte b17 = this.S;
                if ((b17 & 1) == 1) {
                    boolean z16 = (b17 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        eVar.a(this.f139940l.f135088a, 0, 8);
                        this.N += 8;
                        this.Q = true;
                        com.tencent.luggage.wxa.n0.l lVar2 = this.f139935g;
                        lVar2.f135088a[0] = (byte) ((z16 ? 128 : 0) | 8);
                        lVar2.e(0);
                        lVar.a(this.f139935g, 1);
                        this.V++;
                        this.f139940l.e(0);
                        lVar.a(this.f139940l, 8);
                        this.V += 8;
                    }
                    if (z16) {
                        if (!this.R) {
                            eVar.a(this.f139935g.f135088a, 0, 1);
                            this.N++;
                            this.f139935g.e(0);
                            this.T = this.f139935g.q();
                            this.R = true;
                        }
                        int i17 = this.T * 4;
                        this.f139935g.c(i17);
                        eVar.a(this.f139935g.f135088a, 0, i17);
                        this.N += i17;
                        short s16 = (short) ((this.T / 2) + 1);
                        int i18 = (s16 * 6) + 2;
                        ByteBuffer byteBuffer = this.f139942n;
                        if (byteBuffer == null || byteBuffer.capacity() < i18) {
                            this.f139942n = ByteBuffer.allocate(i18);
                        }
                        this.f139942n.position(0);
                        this.f139942n.putShort(s16);
                        int i19 = 0;
                        int i26 = 0;
                        while (true) {
                            i16 = this.T;
                            if (i19 >= i16) {
                                break;
                            }
                            int u16 = this.f139935g.u();
                            if (i19 % 2 == 0) {
                                this.f139942n.putShort((short) (u16 - i26));
                            } else {
                                this.f139942n.putInt(u16 - i26);
                            }
                            i19++;
                            i26 = u16;
                        }
                        int i27 = (i3 - this.N) - i26;
                        if (i16 % 2 == 1) {
                            this.f139942n.putInt(i27);
                        } else {
                            this.f139942n.putShort((short) i27);
                            this.f139942n.putInt(0);
                        }
                        this.f139941m.a(this.f139942n.array(), i18);
                        lVar.a(this.f139941m, i18);
                        this.V += i18;
                    }
                }
            } else {
                byte[] bArr = cVar.f139961f;
                if (bArr != null) {
                    this.f139938j.a(bArr, bArr.length);
                }
            }
            this.O = true;
        }
        int d16 = i3 + this.f139938j.d();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f139956a) && !"V_MPEGH/ISO/HEVC".equals(cVar.f139956a)) {
            while (true) {
                int i28 = this.N;
                if (i28 >= d16) {
                    break;
                } else {
                    a(eVar, lVar, d16 - i28);
                }
            }
        } else {
            byte[] bArr2 = this.f139934f.f135088a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i29 = cVar.P;
            int i36 = 4 - i29;
            while (this.N < d16) {
                int i37 = this.U;
                if (i37 == 0) {
                    a(eVar, bArr2, i36, i29);
                    this.f139934f.e(0);
                    this.U = this.f139934f.u();
                    this.f139933e.e(0);
                    lVar.a(this.f139933e, 4);
                    this.V += 4;
                } else {
                    this.U = i37 - a(eVar, lVar, i37);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f139956a)) {
            this.f139936h.e(0);
            lVar.a(this.f139936h, 4);
            this.V += 4;
        }
    }

    public final void a(com.tencent.luggage.wxa.q.e eVar, byte[] bArr, int i3) {
        int length = bArr.length + i3;
        if (this.f139939k.b() < length) {
            this.f139939k.f135088a = Arrays.copyOf(bArr, length + i3);
        } else {
            System.arraycopy(bArr, 0, this.f139939k.f135088a, 0, bArr.length);
        }
        eVar.a(this.f139939k.f135088a, bArr.length, i3);
        this.f139939k.c(length);
    }

    public final void a(c cVar, String str, int i3, long j3, byte[] bArr) {
        a(this.f139939k.f135088a, this.G, str, i3, j3, bArr);
        com.tencent.luggage.wxa.q.l lVar = cVar.O;
        com.tencent.luggage.wxa.n0.l lVar2 = this.f139939k;
        lVar.a(lVar2, lVar2.d());
        this.V += this.f139939k.d();
    }

    public static void a(byte[] bArr, long j3, String str, int i3, long j16, byte[] bArr2) {
        byte[] c16;
        if (j3 == -9223372036854775807L) {
            c16 = bArr2;
        } else {
            int i16 = (int) (j3 / 3600000000L);
            long j17 = j3 - ((i16 * 3600) * 1000000);
            int i17 = (int) (j17 / AEEditorConstants.MAX_CLIP_TIME_US);
            long j18 = j17 - ((i17 * 60) * 1000000);
            int i18 = (int) (j18 / 1000000);
            c16 = v.c(String.format(Locale.US, str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf((int) ((j18 - (i18 * 1000000)) / j16))));
        }
        System.arraycopy(c16, 0, bArr, i3, bArr2.length);
    }

    public final void a(com.tencent.luggage.wxa.q.e eVar, byte[] bArr, int i3, int i16) {
        int min = Math.min(i16, this.f139938j.a());
        eVar.a(bArr, i3 + min, i16 - min);
        if (min > 0) {
            this.f139938j.a(bArr, i3, min);
        }
        this.N += i16;
    }

    public final int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.l lVar, int i3) {
        int a16;
        int a17 = this.f139938j.a();
        if (a17 > 0) {
            a16 = Math.min(i3, a17);
            lVar.a(this.f139938j, a16);
        } else {
            a16 = lVar.a(eVar, i3, false);
        }
        this.N += a16;
        this.V += a16;
        return a16;
    }

    public final boolean a(com.tencent.luggage.wxa.q.j jVar, long j3) {
        if (this.f139952x) {
            this.f139954z = j3;
            jVar.f137769a = this.f139953y;
            this.f139952x = false;
            return true;
        }
        if (this.f139949u) {
            long j16 = this.f139954z;
            if (j16 != -1) {
                jVar.f137769a = j16;
                this.f139954z = -1L;
                return true;
            }
        }
        return false;
    }

    public final long a(long j3) {
        long j16 = this.f139945q;
        if (j16 != -9223372036854775807L) {
            return v.b(j3, j16, 1000L);
        }
        throw new o("Can't scale timecode prior to timecodeScale being set.");
    }

    public static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    public static int[] a(int[] iArr, int i3) {
        if (iArr == null) {
            return new int[i3];
        }
        return iArr.length >= i3 ? iArr : new int[Math.max(iArr.length * 2, i3)];
    }
}
