package com.tencent.luggage.wxa.u;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f141918a = v.b("nam");

    /* renamed from: b, reason: collision with root package name */
    public static final int f141919b = v.b("trk");

    /* renamed from: c, reason: collision with root package name */
    public static final int f141920c = v.b("cmt");

    /* renamed from: d, reason: collision with root package name */
    public static final int f141921d = v.b("day");

    /* renamed from: e, reason: collision with root package name */
    public static final int f141922e = v.b("ART");

    /* renamed from: f, reason: collision with root package name */
    public static final int f141923f = v.b("too");

    /* renamed from: g, reason: collision with root package name */
    public static final int f141924g = v.b("alb");

    /* renamed from: h, reason: collision with root package name */
    public static final int f141925h = v.b("com");

    /* renamed from: i, reason: collision with root package name */
    public static final int f141926i = v.b("wrt");

    /* renamed from: j, reason: collision with root package name */
    public static final int f141927j = v.b("lyr");

    /* renamed from: k, reason: collision with root package name */
    public static final int f141928k = v.b("gen");

    /* renamed from: l, reason: collision with root package name */
    public static final int f141929l = v.b("covr");

    /* renamed from: m, reason: collision with root package name */
    public static final int f141930m = v.b("gnre");

    /* renamed from: n, reason: collision with root package name */
    public static final int f141931n = v.b("grp");

    /* renamed from: o, reason: collision with root package name */
    public static final int f141932o = v.b("disk");

    /* renamed from: p, reason: collision with root package name */
    public static final int f141933p = v.b("trkn");

    /* renamed from: q, reason: collision with root package name */
    public static final int f141934q = v.b("tmpo");

    /* renamed from: r, reason: collision with root package name */
    public static final int f141935r = v.b("cpil");

    /* renamed from: s, reason: collision with root package name */
    public static final int f141936s = v.b("aART");

    /* renamed from: t, reason: collision with root package name */
    public static final int f141937t = v.b("sonm");

    /* renamed from: u, reason: collision with root package name */
    public static final int f141938u = v.b("soal");

    /* renamed from: v, reason: collision with root package name */
    public static final int f141939v = v.b("soar");

    /* renamed from: w, reason: collision with root package name */
    public static final int f141940w = v.b("soaa");

    /* renamed from: x, reason: collision with root package name */
    public static final int f141941x = v.b("soco");

    /* renamed from: y, reason: collision with root package name */
    public static final int f141942y = v.b("rtng");

    /* renamed from: z, reason: collision with root package name */
    public static final int f141943z = v.b("pgap");
    public static final int A = v.b("sosn");
    public static final int B = v.b("tvsh");
    public static final int C = v.b(ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static com.tencent.luggage.wxa.c0.e a(int i3, com.tencent.luggage.wxa.n0.l lVar) {
        int f16 = lVar.f();
        if (lVar.f() == a.G0) {
            lVar.f(8);
            String a16 = lVar.a(f16 - 16);
            return new com.tencent.luggage.wxa.c0.e(C.LANGUAGE_UNDETERMINED, a16, a16);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.a(i3));
        return null;
    }

    public static a.b b(com.tencent.luggage.wxa.n0.l lVar) {
        int c16 = lVar.c() + lVar.f();
        int f16 = lVar.f();
        int i3 = (f16 >> 24) & 255;
        try {
            if (i3 != 169 && i3 != 65533) {
                if (f16 == f141930m) {
                    return c(lVar);
                }
                if (f16 == f141932o) {
                    return a(f16, "TPOS", lVar);
                }
                if (f16 == f141933p) {
                    return a(f16, "TRCK", lVar);
                }
                if (f16 == f141934q) {
                    return a(f16, "TBPM", lVar, true, false);
                }
                if (f16 == f141935r) {
                    return a(f16, "TCMP", lVar, true, true);
                }
                if (f16 == f141929l) {
                    return a(lVar);
                }
                if (f16 == f141936s) {
                    return b(f16, "TPE2", lVar);
                }
                if (f16 == f141937t) {
                    return b(f16, "TSOT", lVar);
                }
                if (f16 == f141938u) {
                    return b(f16, "TSO2", lVar);
                }
                if (f16 == f141939v) {
                    return b(f16, "TSOA", lVar);
                }
                if (f16 == f141940w) {
                    return b(f16, "TSOP", lVar);
                }
                if (f16 == f141941x) {
                    return b(f16, "TSOC", lVar);
                }
                if (f16 == f141942y) {
                    return a(f16, "ITUNESADVISORY", lVar, false, false);
                }
                if (f16 == f141943z) {
                    return a(f16, "ITUNESGAPLESS", lVar, false, true);
                }
                if (f16 == A) {
                    return b(f16, "TVSHOWSORT", lVar);
                }
                if (f16 == B) {
                    return b(f16, "TVSHOW", lVar);
                }
                if (f16 == C) {
                    return a(lVar, c16);
                }
            } else {
                int i16 = 16777215 & f16;
                if (i16 == f141920c) {
                    return a(f16, lVar);
                }
                if (i16 != f141918a && i16 != f141919b) {
                    if (i16 != f141925h && i16 != f141926i) {
                        if (i16 == f141921d) {
                            return b(f16, "TDRC", lVar);
                        }
                        if (i16 == f141922e) {
                            return b(f16, "TPE1", lVar);
                        }
                        if (i16 == f141923f) {
                            return b(f16, "TSSE", lVar);
                        }
                        if (i16 == f141924g) {
                            return b(f16, "TALB", lVar);
                        }
                        if (i16 == f141927j) {
                            return b(f16, "USLT", lVar);
                        }
                        if (i16 == f141928k) {
                            return b(f16, "TCON", lVar);
                        }
                        if (i16 == f141931n) {
                            return b(f16, "TIT1", lVar);
                        }
                    }
                    return b(f16, "TCOM", lVar);
                }
                return b(f16, "TIT2", lVar);
            }
            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + a.a(f16));
            lVar.e(c16);
            return null;
        } finally {
            lVar.e(c16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.luggage.wxa.c0.j c(com.tencent.luggage.wxa.n0.l lVar) {
        String str;
        int d16 = d(lVar);
        if (d16 > 0) {
            String[] strArr = D;
            if (d16 <= strArr.length) {
                str = strArr[d16 - 1];
                if (str == null) {
                    return new com.tencent.luggage.wxa.c0.j("TCON", null, str);
                }
                Log.w("MetadataUtil", "Failed to parse standard genre code");
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    public static int d(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.f(4);
        if (lVar.f() == a.G0) {
            lVar.f(8);
            return lVar.q();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static com.tencent.luggage.wxa.c0.h a(int i3, String str, com.tencent.luggage.wxa.n0.l lVar, boolean z16, boolean z17) {
        int d16 = d(lVar);
        if (z17) {
            d16 = Math.min(1, d16);
        }
        if (d16 >= 0) {
            if (z16) {
                return new com.tencent.luggage.wxa.c0.j(str, null, Integer.toString(d16));
            }
            return new com.tencent.luggage.wxa.c0.e(C.LANGUAGE_UNDETERMINED, str, Integer.toString(d16));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i3));
        return null;
    }

    public static com.tencent.luggage.wxa.c0.j a(int i3, String str, com.tencent.luggage.wxa.n0.l lVar) {
        int f16 = lVar.f();
        if (lVar.f() == a.G0 && f16 >= 22) {
            lVar.f(10);
            int w3 = lVar.w();
            if (w3 > 0) {
                String str2 = "" + w3;
                int w16 = lVar.w();
                if (w16 > 0) {
                    str2 = str2 + "/" + w16;
                }
                return new com.tencent.luggage.wxa.c0.j(str, null, str2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i3));
        return null;
    }

    public static com.tencent.luggage.wxa.c0.a a(com.tencent.luggage.wxa.n0.l lVar) {
        int f16 = lVar.f();
        if (lVar.f() == a.G0) {
            int b16 = a.b(lVar.f());
            String str = b16 == 13 ? "image/jpeg" : b16 == 14 ? "image/png" : null;
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + b16);
                return null;
            }
            lVar.f(4);
            int i3 = f16 - 16;
            byte[] bArr = new byte[i3];
            lVar.a(bArr, 0, i3);
            return new com.tencent.luggage.wxa.c0.a(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    public static com.tencent.luggage.wxa.c0.h a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        String str = null;
        String str2 = null;
        int i16 = -1;
        int i17 = -1;
        while (lVar.c() < i3) {
            int c16 = lVar.c();
            int f16 = lVar.f();
            int f17 = lVar.f();
            lVar.f(4);
            if (f17 == a.E0) {
                str = lVar.a(f16 - 12);
            } else if (f17 == a.F0) {
                str2 = lVar.a(f16 - 12);
            } else {
                if (f17 == a.G0) {
                    i16 = c16;
                    i17 = f16;
                }
                lVar.f(f16 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i16 == -1) {
            return null;
        }
        lVar.e(i16);
        lVar.f(16);
        return new com.tencent.luggage.wxa.c0.e(C.LANGUAGE_UNDETERMINED, str2, lVar.a(i17 - 16));
    }

    public static com.tencent.luggage.wxa.c0.j b(int i3, String str, com.tencent.luggage.wxa.n0.l lVar) {
        int f16 = lVar.f();
        if (lVar.f() == a.G0) {
            lVar.f(8);
            return new com.tencent.luggage.wxa.c0.j(str, null, lVar.a(f16 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.a(i3));
        return null;
    }
}
