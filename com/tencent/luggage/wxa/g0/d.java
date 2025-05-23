package com.tencent.luggage.wxa.g0;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.d0.p;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.g0.b;
import com.tencent.luggage.wxa.l0.s;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.v;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements s.a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f126343a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f126344b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f126345c = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f126346d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f126347e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f126348f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f126349g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f126350h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f126351i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f126352j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f126353k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f126354l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f126355m = Pattern.compile("METHOD=(NONE|AES-128)");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f126356n = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f126357o = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f126358p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f126359q = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f126360r = Pattern.compile("NAME=\"(.+?)\"");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f126361s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f126362t = a("AUTOSELECT");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f126363u = a("DEFAULT");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f126364v = a("FORCED");

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedReader f126365a;

        /* renamed from: b, reason: collision with root package name */
        public final Queue f126366b;

        /* renamed from: c, reason: collision with root package name */
        public String f126367c;

        public a(Queue queue, BufferedReader bufferedReader) {
            this.f126366b = queue;
            this.f126365a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.f126367c != null) {
                return true;
            }
            if (!this.f126366b.isEmpty()) {
                this.f126367c = (String) this.f126366b.poll();
                return true;
            }
            do {
                String readLine = this.f126365a.readLine();
                this.f126367c = readLine;
                if (readLine != null) {
                    trim = readLine.trim();
                    this.f126367c = trim;
                } else {
                    return false;
                }
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                return null;
            }
            String str = this.f126367c;
            this.f126367c = null;
            return str;
        }
    }

    public static String c(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String d(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new o("Couldn't match " + pattern.pattern() + " in " + str);
    }

    @Override // com.tencent.luggage.wxa.l0.s.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        try {
            if (a(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                linkedList.add(trim);
                                return a(new a(linkedList, bufferedReader), uri.toString());
                            }
                            if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                break;
                            }
                            linkedList.add(trim);
                        }
                    } else {
                        v.a(bufferedReader);
                        throw new o("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                linkedList.add(trim);
                return b(new a(linkedList, bufferedReader), uri.toString());
            }
            com.tencent.luggage.wxa.y.a.a(ExoPlayerLibraryInfo.TAG, "parse, not the #EXTM3U header, uri:%s, reader:%s", uri.toString(), bufferedReader.readLine());
            throw new p("Input does not start with the #EXTM3U header.", uri);
        } finally {
            v.a(bufferedReader);
        }
    }

    public static boolean a(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int a16 = a(bufferedReader, true, read);
        for (int i3 = 0; i3 < 7; i3++) {
            if (a16 != "#EXTM3U".charAt(i3)) {
                return false;
            }
            a16 = bufferedReader.read();
        }
        return v.d(a(bufferedReader, false, a16));
    }

    public static int a(BufferedReader bufferedReader, boolean z16, int i3) {
        while (i3 != -1 && Character.isWhitespace(i3) && (z16 || !v.d(i3))) {
            i3 = bufferedReader.read();
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x001d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.luggage.wxa.g0.a a(a aVar, String str) {
        char c16;
        int parseInt;
        String str2;
        int i3;
        int i16;
        String b16;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = null;
        j jVar = null;
        boolean z16 = false;
        while (aVar.a()) {
            String b17 = aVar.b();
            com.tencent.luggage.wxa.y.a.b("master ExoPlayer", b17, new Object[0]);
            if (b17.startsWith("#EXT")) {
                arrayList4.add(b17);
            }
            if (b17.startsWith("#EXT-X-MEDIA")) {
                int b18 = b(b17);
                String c17 = c(b17, f126356n);
                String d16 = d(b17, f126360r);
                String c18 = c(b17, f126359q);
                String d17 = d(b17, f126358p);
                d17.hashCode();
                switch (d17.hashCode()) {
                    case -959297733:
                        if (d17.equals("SUBTITLES")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -333210994:
                        if (d17.equals("CLOSED-CAPTIONS")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 62628790:
                        if (d17.equals("AUDIO")) {
                            c16 = 2;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        arrayList3.add(new a.C6226a(c17, j.b(d16, "application/x-mpegURL", "text/vtt", null, -1, b18, c18)));
                        break;
                    case 1:
                        String d18 = d(b17, f126361s);
                        if (d18.startsWith("CC")) {
                            parseInt = Integer.parseInt(d18.substring(2));
                            str2 = "application/cea-608";
                        } else {
                            parseInt = Integer.parseInt(d18.substring(7));
                            str2 = "application/cea-708";
                        }
                        int i17 = parseInt;
                        String str3 = str2;
                        if (arrayList5 == null) {
                            arrayList5 = new ArrayList();
                        }
                        arrayList5.add(j.a(d16, (String) null, str3, (String) null, -1, b18, c18, i17));
                        break;
                    case 2:
                        j a16 = j.a(d16, "application/x-mpegURL", (String) null, (String) null, -1, -1, -1, (List) null, b18, c18);
                        if (c17 != null) {
                            arrayList2.add(new a.C6226a(c17, a16));
                            break;
                        } else {
                            jVar = a16;
                            break;
                        }
                }
            } else if (b17.startsWith("#EXT-X-STREAM-INF")) {
                int b19 = b(b17, f126344b);
                String c19 = c(b17, f126343a);
                if (c19 != null) {
                    b19 = Integer.parseInt(c19);
                }
                int i18 = b19;
                String c26 = c(b17, f126345c);
                String c27 = c(b17, f126346d);
                z16 |= b17.contains("CLOSED-CAPTIONS=NONE");
                if (c27 != null) {
                    String[] split = c27.split(HippyTKDListViewAdapter.X);
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 > 0 && parseInt3 > 0) {
                        i16 = parseInt3;
                        i3 = parseInt2;
                        b16 = aVar.b();
                        if (!hashSet.add(b16)) {
                            arrayList.add(new a.C6226a(b16, j.a(Integer.toString(arrayList.size()), "application/x-mpegURL", (String) null, c26, i18, i3, i16, -1.0f, (List) null, 0)));
                        }
                    }
                }
                i3 = -1;
                i16 = -1;
                b16 = aVar.b();
                if (!hashSet.add(b16)) {
                }
            }
        }
        return new com.tencent.luggage.wxa.g0.a(str, arrayList4, arrayList, arrayList2, arrayList3, jVar, z16 ? Collections.emptyList() : arrayList5);
    }

    public static int b(String str) {
        return (a(str, f126363u, false) ? 1 : 0) | (a(str, f126364v, false) ? 2 : 0) | (a(str, f126362t, false) ? 4 : 0);
    }

    public static b b(a aVar, String str) {
        String hexString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        boolean z16 = false;
        int i16 = 0;
        int i17 = 0;
        boolean z17 = false;
        boolean z18 = false;
        int i18 = 0;
        boolean z19 = false;
        long j3 = -9223372036854775807L;
        long j16 = -9223372036854775807L;
        int i19 = 1;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j26 = 0;
        b.a aVar2 = null;
        long j27 = -1;
        String str2 = null;
        String str3 = null;
        int i26 = 0;
        int i27 = 0;
        while (aVar.a()) {
            String b16 = aVar.b();
            com.tencent.luggage.wxa.y.a.b(ExoPlayerLibraryInfo.TAG, b16, new Object[i3]);
            if (b16.startsWith("#EXT")) {
                arrayList2.add(b16);
            }
            if (b16.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String d16 = d(b16, f126349g);
                if ("VOD".equals(d16)) {
                    i26 = 1;
                } else if ("EVENT".equals(d16)) {
                    i26 = 2;
                }
            } else if (b16.startsWith("#EXT-X-START")) {
                j3 = (long) (a(b16, f126352j) * 1000000.0d);
            } else if (b16.startsWith("#EXT-X-MAP")) {
                String d17 = d(b16, f126356n);
                String c16 = c(b16, f126354l);
                if (c16 != null) {
                    String[] split = c16.split("@");
                    j27 = Long.parseLong(split[i3]);
                    if (split.length > 1) {
                        j18 = Long.parseLong(split[1]);
                    }
                }
                aVar2 = new b.a(d17, j18, j27);
                j18 = 0;
                j27 = -1;
            } else if (b16.startsWith("#EXT-X-TARGETDURATION")) {
                j16 = 1000000 * b(b16, f126347e);
            } else if (b16.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                i18 = b(b16, f126350h);
                i17 = i18;
            } else if (b16.startsWith("#EXT-X-VERSION")) {
                i19 = b(b16, f126348f);
            } else if (b16.startsWith("#EXTINF")) {
                j26 = (long) (a(b16, f126351i) * 1000000.0d);
            } else if (b16.startsWith("#EXT-X-KEY")) {
                z19 = "AES-128".equals(d(b16, f126355m));
                if (z19) {
                    str3 = d(b16, f126356n);
                    str2 = c(b16, f126357o);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (b16.startsWith("#EXT-X-BYTERANGE")) {
                String[] split2 = d(b16, f126353k).split("@");
                j27 = Long.parseLong(split2[i3]);
                if (split2.length > 1) {
                    j18 = Long.parseLong(split2[1]);
                }
            } else if (b16.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i16 = Integer.parseInt(b16.substring(b16.indexOf(58) + 1));
                z16 = true;
            } else if (b16.equals("#EXT-X-DISCONTINUITY")) {
                i27++;
            } else if (b16.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j17 == 0) {
                    j17 = com.tencent.luggage.wxa.m.b.a(v.f(b16.substring(b16.indexOf(58) + 1))) - j19;
                }
            } else if (!b16.startsWith("#")) {
                if (z19) {
                    hexString = str2 != null ? str2 : Integer.toHexString(i18);
                } else {
                    hexString = null;
                }
                int i28 = i18 + 1;
                if (j27 == -1) {
                    j18 = 0;
                }
                arrayList.add(new b.a(b16, j26, i27, j19, z19, str3, hexString, j18, j27));
                j19 += j26;
                if (j27 != -1) {
                    j18 += j27;
                }
                j26 = 0;
                i18 = i28;
                j27 = -1;
            } else if (b16.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z17 = true;
            } else if (b16.equals("#EXT-X-ENDLIST")) {
                z18 = true;
            }
            i3 = 0;
        }
        return new b(i26, str, arrayList2, j3, j17, z16, i16, i17, i19, j16, z17, z18, j17 != 0, aVar2, arrayList);
    }

    public static double a(String str, Pattern pattern) {
        return Double.parseDouble(d(str, pattern));
    }

    public static boolean a(String str, Pattern pattern, boolean z16) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z16;
    }

    public static Pattern a(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    public static int b(String str, Pattern pattern) {
        return Integer.parseInt(d(str, pattern));
    }
}
