package com.tencent.luggage.wxa.z;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: d, reason: collision with root package name */
    public static final SparseIntArray f146166d;

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f146167e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map f146168f;

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.z.a f146163a = com.tencent.luggage.wxa.z.a.d("OMX.google.raw.decoder");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f146164b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f146165c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static int f146169g = -1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f146170a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f146171b;

        public b(String str, boolean z16) {
            this.f146170a = str;
            this.f146171b = z16;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            if (TextUtils.equals(this.f146170a, bVar.f146170a) && this.f146171b == bVar.f146171b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3;
            String str = this.f146170a;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode + 31) * 31;
            if (this.f146171b) {
                i3 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
            } else {
                i3 = 1237;
            }
            return i16 + i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c extends Exception {
        public c(Throwable th5) {
            super("Failed to query underlying media codecs", th5);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z.d$d, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC6964d {
        int a();

        MediaCodecInfo a(int i3);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e implements InterfaceC6964d {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public boolean b() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public MediaCodecInfo a(int i3) {
            return MediaCodecList.getCodecInfoAt(i3);
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f146166d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f146167e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        f146168f = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    public static int a(int i3) {
        if (i3 == 1 || i3 == 2) {
            return 25344;
        }
        switch (i3) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static synchronized List b(String str, boolean z16) {
        synchronized (d.class) {
            b bVar = new b(str, z16);
            HashMap hashMap = f146165c;
            List list = (List) hashMap.get(bVar);
            if (list != null) {
                return list;
            }
            int i3 = v.f135103a;
            List a16 = a(bVar, i3 >= 21 ? new f(z16) : new e());
            if (z16 && a16.isEmpty() && 21 <= i3 && i3 <= 23) {
                a16 = a(bVar, new e());
                if (!a16.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((com.tencent.luggage.wxa.z.a) a16.get(0)).f146140a);
                }
            }
            a(a16);
            List unmodifiableList = Collections.unmodifiableList(a16);
            hashMap.put(bVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f implements InterfaceC6964d {

        /* renamed from: a, reason: collision with root package name */
        public final int f146172a;

        /* renamed from: b, reason: collision with root package name */
        public MediaCodecInfo[] f146173b;

        public f(boolean z16) {
            this.f146172a = z16 ? 1 : 0;
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public int a() {
            c();
            return this.f146173b.length;
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public boolean b() {
            return true;
        }

        public final void c() {
            if (this.f146173b == null) {
                this.f146173b = new MediaCodecList(this.f146172a).getCodecInfos();
            }
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public MediaCodecInfo a(int i3) {
            c();
            return this.f146173b[i3];
        }

        @Override // com.tencent.luggage.wxa.z.d.InterfaceC6964d
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }
    }

    public static com.tencent.luggage.wxa.z.a a() {
        return f146163a;
    }

    public static com.tencent.luggage.wxa.z.a a(String str, boolean z16) {
        List b16 = b(str, z16);
        if (b16.isEmpty()) {
            return null;
        }
        return (com.tencent.luggage.wxa.z.a) b16.get(0);
    }

    public static List a(b bVar, InterfaceC6964d interfaceC6964d) {
        InterfaceC6964d interfaceC6964d2 = interfaceC6964d;
        try {
            ArrayList arrayList = new ArrayList();
            String str = bVar.f146170a;
            int a16 = interfaceC6964d.a();
            boolean b16 = interfaceC6964d.b();
            int i3 = 0;
            while (i3 < a16) {
                MediaCodecInfo a17 = interfaceC6964d2.a(i3);
                String name = a17.getName();
                if (a(a17, name, b16)) {
                    String[] supportedTypes = a17.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i16 = 0;
                    while (i16 < length) {
                        String str2 = supportedTypes[i16];
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a17.getCapabilitiesForType(str2);
                                boolean a18 = interfaceC6964d2.a(str, capabilitiesForType);
                                boolean a19 = a(name);
                                if (b16) {
                                    if (bVar.f146171b != a18) {
                                    }
                                    arrayList.add(com.tencent.luggage.wxa.z.a.a(name, str, capabilitiesForType, a19, false));
                                }
                                if (!b16 && !bVar.f146171b) {
                                    arrayList.add(com.tencent.luggage.wxa.z.a.a(name, str, capabilitiesForType, a19, false));
                                } else if (!b16 && a18) {
                                    arrayList.add(com.tencent.luggage.wxa.z.a.a(name + ".secure", str, capabilitiesForType, a19, true));
                                    return arrayList;
                                }
                            } catch (Exception e16) {
                                if (v.f135103a <= 23 && !arrayList.isEmpty()) {
                                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                } else {
                                    Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                                    throw e16;
                                }
                            }
                        }
                        i16++;
                        interfaceC6964d2 = interfaceC6964d;
                    }
                }
                i3++;
                interfaceC6964d2 = interfaceC6964d;
            }
            return arrayList;
        } catch (Exception e17) {
            throw new c(e17);
        }
    }

    public static int b() {
        if (f146169g == -1) {
            int i3 = 0;
            com.tencent.luggage.wxa.z.a a16 = a("video/avc", false);
            if (a16 != null) {
                MediaCodecInfo.CodecProfileLevel[] a17 = a16.a();
                int length = a17.length;
                int i16 = 0;
                while (i3 < length) {
                    i16 = Math.max(a(a17[i3].level), i16);
                    i3++;
                }
                i3 = Math.max(i16, v.f135103a >= 21 ? 345600 : 172800);
            }
            f146169g = i3;
        }
        return f146169g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (r3.equals("avc1") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair b(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        char c16 = 0;
        String str2 = split[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3006243:
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3199032:
                if (str2.equals("hev1")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return a(str, split);
            case 2:
            case 3:
                return b(str, split);
            default:
                return null;
        }
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z16) {
        if (mediaCodecInfo.isEncoder() || (!z16 && str.endsWith(".secure"))) {
            return false;
        }
        int i3 = v.f135103a;
        if (i3 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i3 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i3 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str2 = v.f135104b;
            if ("a70".equals(str2) || (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equals(v.f135105c) && str2.startsWith("HM"))) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str3 = v.f135104b;
            if ("dlxu".equals(str3) || "protou".equals(str3) || "ville".equals(str3) || "villeplus".equals(str3) || "villec2".equals(str3) || str3.startsWith("gee") || "C6602".equals(str3) || "C6603".equals(str3) || "C6606".equals(str3) || "C6616".equals(str3) || "L36h".equals(str3) || "SO-02E".equals(str3)) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str4 = v.f135104b;
            if ("C1504".equals(str4) || "C1505".equals(str4) || "C1604".equals(str4) || "C1605".equals(str4)) {
                return false;
            }
        }
        if (i3 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && v.f135105c.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING))) {
            String str5 = v.f135104b;
            if (str5.startsWith("zeroflte") || str5.startsWith("zerolte") || str5.startsWith("zenlte") || str5.equals("SC-05G") || str5.equals("marinelteatt") || str5.equals("404SC") || str5.equals("SC-04G") || str5.equals("SCV31")) {
                return false;
            }
        }
        if (i3 <= 19 && "OMX.SEC.vp8.dec".equals(str) && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(v.f135105c)) {
            String str6 = v.f135104b;
            if (str6.startsWith("d2") || str6.startsWith("serrano") || str6.startsWith("jflte") || str6.startsWith("santos") || str6.startsWith("t0")) {
                return false;
            }
        }
        return (i3 <= 19 && v.f135104b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
    }

    public static Pair b(String str, String[] strArr) {
        int i3;
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f146164b.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i3 = 1;
        } else {
            if (!"2".equals(group)) {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
            i3 = 2;
        }
        Integer num = (Integer) f146168f.get(strArr[3]);
        if (num == null) {
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        return new Pair(Integer.valueOf(i3), num);
    }

    public static void a(List list) {
        if (v.f135103a < 26) {
            if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(((com.tencent.luggage.wxa.z.a) list.get(0)).f146140a)) {
                return;
            }
            for (int i3 = 1; i3 < list.size(); i3++) {
                com.tencent.luggage.wxa.z.a aVar = (com.tencent.luggage.wxa.z.a) list.get(i3);
                if ("OMX.google.raw.decoder".equals(aVar.f146140a)) {
                    list.remove(i3);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    public static boolean a(String str) {
        if (v.f135103a <= 22) {
            String str2 = v.f135106d;
            if ((str2.equals("ODROID-XU3") || str2.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static Pair a(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf2;
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(f146166d.get(num.intValue()));
            if (valueOf3 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + num);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(f146167e.get(valueOf.intValue()));
            if (valueOf4 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC level: " + valueOf);
                return null;
            }
            return new Pair(valueOf3, valueOf4);
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }
}
