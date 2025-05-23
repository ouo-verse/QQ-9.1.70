package com.tencent.qqlive.superplayer.player.tools;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qqlive.superplayer.thirdparties.LocalCache;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.superplayer.tools.utils.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<String, Integer> f345380i;

    /* renamed from: a, reason: collision with root package name */
    protected static ArrayList<String> f345372a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected static ArrayList<String> f345373b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected static int f345374c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected static int f345375d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected static int f345376e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected static int f345377f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected static int f345378g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected static int f345379h = 0;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f345381j = false;

    /* renamed from: k, reason: collision with root package name */
    private static int f345382k = -1;

    /* renamed from: l, reason: collision with root package name */
    private static int f345383l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f345384m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f345385n = false;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f345386o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f345387p = false;

    /* renamed from: q, reason: collision with root package name */
    private static int f345388q = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f345389r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static String f345390s = "Config_HW_Capability_V4";

    /* renamed from: t, reason: collision with root package name */
    private static String f345391t = "Config_Soft_Capability_V4";

    /* renamed from: u, reason: collision with root package name */
    private static String f345392u = "Config_HW_Level_V4";

    /* renamed from: v, reason: collision with root package name */
    private static String f345393v = "Config_HDR_Codec_Level";

    static {
        f345380i = null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        f345380i = hashMap;
        hashMap.put("NX511J", 7);
        f345380i.put("Hi3798MV100", 7);
        f345380i.put("\u957f\u8679\u667a\u80fd\u7535\u89c6", 7);
        f345380i.put("Android TV on Tcl 901", 7);
        f345380i.put("xt880b", 7);
        a();
    }

    public static synchronized void a() {
        boolean z16;
        Method method;
        int i3;
        String str;
        Method method2;
        Method method3;
        ArrayList<String> f16;
        ArrayList<String> f17;
        synchronized (a.class) {
            if (f345381j) {
                d.d("MediaPlayerMgr[TVKCodecUtils.java]", "codec params already init , return directly !");
                return;
            }
            int i16 = 1;
            if (vt3.d.Z0.a().booleanValue()) {
                d.d("MediaPlayerMgr[TVKCodecUtils.java]", "acquire codec params from share preference");
                ArrayList<String> arrayList = f345372a;
                if ((arrayList == null || arrayList.size() == 0) && (f16 = f(f345390s)) != null) {
                    f345372a = f16;
                }
                ArrayList<String> arrayList2 = f345373b;
                if ((arrayList2 == null || arrayList2.size() == 0) && (f17 = f(f345391t)) != null) {
                    f345373b = f17;
                }
                ArrayList<String> arrayList3 = f345372a;
                if (arrayList3 != null && f345373b != null && arrayList3.size() > 0 && f345373b.size() > 0 && d()) {
                    f345381j = true;
                    return;
                }
            }
            try {
                try {
                    try {
                        d.d("MediaPlayerMgr[TVKCodecUtils.java]", "acquire codec params from settings");
                        Class<?> cls = Class.forName("android.media.MediaCodecList");
                        int i17 = 0;
                        Method declaredMethod = cls.getDeclaredMethod("getCodecCount", new Class[0]);
                        Method declaredMethod2 = cls.getDeclaredMethod("getCodecInfoAt", Integer.TYPE);
                        Class<?> cls2 = Class.forName("android.media.MediaCodecInfo");
                        Method declaredMethod3 = cls2.getDeclaredMethod("getSupportedTypes", new Class[0]);
                        Method declaredMethod4 = cls2.getDeclaredMethod("getName", new Class[0]);
                        Method declaredMethod5 = cls2.getDeclaredMethod("isEncoder", new Class[0]);
                        Method declaredMethod6 = cls2.getDeclaredMethod("getCapabilitiesForType", String.class);
                        Field declaredField = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
                        Class<?> cls3 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
                        Field declaredField2 = cls3.getDeclaredField("level");
                        Field declaredField3 = cls3.getDeclaredField("profile");
                        int intValue = ((Integer) declaredMethod.invoke(null, new Object[0])).intValue();
                        int i18 = 0;
                        boolean z17 = false;
                        boolean z18 = false;
                        while (i18 < intValue) {
                            Object[] objArr = new Object[i16];
                            objArr[i17] = Integer.valueOf(i18);
                            Object invoke = declaredMethod2.invoke(null, objArr);
                            if (((Boolean) declaredMethod5.invoke(invoke, new Object[i17])).booleanValue()) {
                                method = declaredMethod2;
                                i3 = intValue;
                            } else {
                                String lowerCase = ((String) declaredMethod4.invoke(invoke, new Object[i17])).toLowerCase();
                                method = declaredMethod2;
                                String[] strArr = (String[]) declaredMethod3.invoke(invoke, new Object[i17]);
                                int length = strArr.length;
                                i3 = intValue;
                                int i19 = 0;
                                while (i19 < length) {
                                    int i26 = length;
                                    String str2 = strArr[i19];
                                    String[] strArr2 = strArr;
                                    if (!lowerCase.contains(".google.") && !lowerCase.contains(".sw.") && !lowerCase.contains(".GOOGLE.") && !lowerCase.contains(".SW.")) {
                                        f345372a.add(str2);
                                        if (f345372a.contains("video/avc") && !z17) {
                                            Object[] objArr2 = (Object[]) declaredField.get(declaredMethod6.invoke(invoke, "video/avc"));
                                            int length2 = objArr2.length;
                                            int i27 = 0;
                                            while (i27 < length2) {
                                                String str3 = lowerCase;
                                                Object obj = objArr2[i27];
                                                Object[] objArr3 = objArr2;
                                                int intValue2 = ((Integer) declaredField2.get(obj)).intValue();
                                                int intValue3 = ((Integer) declaredField3.get(obj)).intValue();
                                                int i28 = length2;
                                                int k3 = k(intValue3, intValue2);
                                                Method method4 = declaredMethod3;
                                                if (k3 >= f345374c) {
                                                    f345374c = k3;
                                                    f345376e = intValue3;
                                                    f345375d = intValue2;
                                                }
                                                i27++;
                                                lowerCase = str3;
                                                length2 = i28;
                                                objArr2 = objArr3;
                                                declaredMethod3 = method4;
                                            }
                                            str = lowerCase;
                                            method3 = declaredMethod3;
                                            d.d("MediaPlayerMgr[TVKCodecUtils.java]", "profile:" + f345376e + ",level:" + f345375d + " mHWVideoMaxCap:" + f345374c);
                                            z17 = true;
                                        } else {
                                            str = lowerCase;
                                            method3 = declaredMethod3;
                                        }
                                        if (f345372a.contains("video/hevc") && !z18) {
                                            Object[] objArr4 = (Object[]) declaredField.get(declaredMethod6.invoke(invoke, "video/hevc"));
                                            int length3 = objArr4.length;
                                            int i29 = 0;
                                            while (i29 < length3) {
                                                Object obj2 = objArr4[i29];
                                                Object[] objArr5 = objArr4;
                                                int intValue4 = ((Integer) declaredField2.get(obj2)).intValue();
                                                int intValue5 = ((Integer) declaredField3.get(obj2)).intValue();
                                                int i36 = length3;
                                                int l3 = l(intValue5, intValue4);
                                                Method method5 = declaredMethod6;
                                                if (l3 >= f345377f) {
                                                    f345377f = l3;
                                                    f345379h = intValue5;
                                                    f345378g = intValue4;
                                                }
                                                i29++;
                                                length3 = i36;
                                                objArr4 = objArr5;
                                                declaredMethod6 = method5;
                                            }
                                            method2 = declaredMethod6;
                                            d.d("MediaPlayerMgr[TVKCodecUtils.java]", "profile:" + f345379h + ",level:" + f345378g + " mHWVideoMaxCap:" + f345377f);
                                            z18 = true;
                                        } else {
                                            method2 = declaredMethod6;
                                        }
                                        i19++;
                                        length = i26;
                                        strArr = strArr2;
                                        lowerCase = str;
                                        declaredMethod6 = method2;
                                        declaredMethod3 = method3;
                                    }
                                    str = lowerCase;
                                    method2 = declaredMethod6;
                                    method3 = declaredMethod3;
                                    f345373b.add(str2);
                                    i19++;
                                    length = i26;
                                    strArr = strArr2;
                                    lowerCase = str;
                                    declaredMethod6 = method2;
                                    declaredMethod3 = method3;
                                }
                            }
                            i18++;
                            declaredMethod2 = method;
                            intValue = i3;
                            declaredMethod6 = declaredMethod6;
                            declaredMethod3 = declaredMethod3;
                            i16 = 1;
                            i17 = 0;
                        }
                        if (vt3.d.Z0.a().booleanValue()) {
                            c(f345390s, f345372a);
                            c(f345391t, f345373b);
                            HashMap hashMap = new HashMap();
                            hashMap.put("mHWVideoAVCMaxCap", String.valueOf(f345374c));
                            hashMap.put("mHWVideoAVCMaxCap", String.valueOf(f345374c));
                            hashMap.put("mHWVideoAVCLevel", String.valueOf(f345375d));
                            hashMap.put("mHWVideoAVCProfile", String.valueOf(f345376e));
                            hashMap.put("mHWVideoHEVCMaxCap", String.valueOf(f345377f));
                            hashMap.put("mHWVideoHEVCLevel", String.valueOf(f345378g));
                            hashMap.put("mHWVideoHEVCProfile", String.valueOf(f345379h));
                            b(f345392u, hashMap);
                        }
                        z16 = true;
                    } catch (ClassNotFoundException e16) {
                        d.b("MediaPlayerMgr[TVKCodecUtils.java]", e16);
                        z16 = true;
                    } catch (NoSuchFieldException e17) {
                        d.b("MediaPlayerMgr[TVKCodecUtils.java]", e17);
                        z16 = true;
                    } catch (InvocationTargetException e18) {
                        d.b("MediaPlayerMgr[TVKCodecUtils.java]", e18);
                        z16 = true;
                    }
                } catch (IllegalAccessException e19) {
                    d.b("MediaPlayerMgr[TVKCodecUtils.java]", e19);
                    z16 = true;
                } catch (NoSuchMethodException e26) {
                    d.b("MediaPlayerMgr[TVKCodecUtils.java]", e26);
                    z16 = true;
                }
                f345381j = z16;
            } catch (Throwable th5) {
                f345381j = true;
                throw th5;
            }
        }
    }

    private static void b(String str, HashMap<String, String> hashMap) {
        if (tt3.a.c() != null) {
            try {
                LocalCache a16 = LocalCache.a(tt3.a.c());
                if (a16 != null) {
                    a16.g(str, hashMap);
                }
            } catch (Throwable unused) {
                d.a("MediaPlayerMgr[TVKCodecUtils.java]", "cache " + str + "failed");
            }
        }
    }

    private static void c(String str, ArrayList<String> arrayList) {
        if (tt3.a.c() != null) {
            try {
                LocalCache a16 = LocalCache.a(tt3.a.c());
                if (a16 != null) {
                    a16.g(str, arrayList);
                }
            } catch (Throwable unused) {
                d.a("MediaPlayerMgr[TVKCodecUtils.java]", "cache " + str + "failed");
            }
        }
    }

    private static boolean d() {
        HashMap<String, String> e16 = e(f345392u);
        if (e16 != null) {
            try {
                if (e16.size() > 0) {
                    f345374c = g.i(e16.get("mHWVideoAVCMaxCap"), 0);
                    f345375d = g.i(e16.get("mHWVideoAVCLevel"), 0);
                    f345376e = g.i(e16.get("mHWVideoAVCProfile"), 0);
                    f345377f = g.i(e16.get("mHWVideoHEVCMaxCap"), 0);
                    f345379h = g.i(e16.get("mHWVideoHEVCProfile"), 0);
                    f345378g = g.i(e16.get("mHWVideoHEVCLevel"), 0);
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        d.d("MediaPlayerMgr[TVKCodecUtils.java]", "mHWVideoAVCMaxCap=" + f345374c + "mHWVideoAVCLevel=" + f345375d + "mHWVideoAVCProfile=" + f345376e + "mHWVideoHEVCMaxCap=" + f345377f + "mHWVideoHEVCProfile=" + f345379h + "mHWVideoHEVCLevel=" + f345378g);
        return true;
    }

    private static HashMap<String, String> e(String str) {
        if (tt3.a.c() != null) {
            try {
                LocalCache a16 = LocalCache.a(tt3.a.c());
                if (a16 != null) {
                    return (HashMap) a16.e(str);
                }
                return null;
            } catch (Throwable unused) {
                d.a("MediaPlayerMgr[TVKCodecUtils.java]", "get " + str + "failed");
                return null;
            }
        }
        return null;
    }

    private static ArrayList<String> f(String str) {
        if (tt3.a.c() != null) {
            try {
                LocalCache a16 = LocalCache.a(tt3.a.c());
                if (a16 != null) {
                    return (ArrayList) a16.e(str);
                }
                return null;
            } catch (Throwable unused) {
                d.a("MediaPlayerMgr[TVKCodecUtils.java]", "get " + str + "failed");
                return null;
            }
        }
        return null;
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals("uhd")) {
            return 28;
        }
        if (str.equals("fhd")) {
            return 26;
        }
        if (str.equals("shd")) {
            return 21;
        }
        if (!str.equals("hd") && !str.equals("mp4")) {
            if (str.equals("sd")) {
                return 11;
            }
            if (str.equals("msd")) {
                return 6;
            }
            return 1;
        }
        return 16;
    }

    public static int h() {
        int i3;
        int i16 = f345377f;
        if (i16 < 129600) {
            i3 = 1;
        } else if (i16 < 407040) {
            i3 = 11;
        } else if (i16 < 921600) {
            i3 = 16;
        } else if (i16 < 2073600) {
            i3 = 21;
        } else if (i16 < 8294400) {
            i3 = 28;
        } else {
            i3 = 33;
        }
        if (vt3.d.A2.a().booleanValue()) {
            return 28;
        }
        return i3;
    }

    private static int i() {
        if (h.n() >= 8) {
            if (h.j() / 1000 >= 1200) {
                return 21;
            }
        } else if (h.n() >= 6) {
            if (h.j() / 1000 >= 1400) {
                return 21;
            }
        } else {
            if (h.n() < 4) {
                return 6;
            }
            if (h.j() / 1000 >= 1600) {
                return 21;
            }
        }
        return 16;
    }

    public static int j() {
        String f16 = h.f();
        int e16 = h.e(f16);
        int d16 = h.d(f16);
        d.d("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], numCores = " + h.n() + ", totalMem = " + h.p(tt3.a.c()));
        d.d("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], hd_hevc_least_cores = " + vt3.d.O0.a() + ", hd_hevc_least_mem = " + vt3.d.N0.a());
        d.d("MediaPlayerMgr[TVKCodecUtils.java]", "[getSoftCodecHevcLevel], mCpuHWProducter = " + e16 + ", getMaxCpuFreq() = " + h.j() + " mCpuHWProductIdx=" + d16);
        int i3 = f345382k;
        if (-1 != i3) {
            return i3;
        }
        f345382k = 0;
        if (-1 == e16) {
            f345382k = i();
        } else if (e16 != 0) {
            if (e16 != 1) {
                if (e16 != 2) {
                    if (e16 == 3) {
                        if (d16 >= vt3.d.V0.a().intValue()) {
                            f345382k = 21;
                        } else if (d16 >= vt3.d.W0.a().intValue()) {
                            f345382k = 16;
                        } else {
                            f345382k = i();
                        }
                    }
                } else if (d16 >= vt3.d.T0.a().intValue()) {
                    f345382k = 21;
                } else if (d16 >= vt3.d.U0.a().intValue()) {
                    f345382k = 16;
                } else {
                    f345382k = i();
                }
            } else if (d16 >= vt3.d.R0.a().intValue()) {
                f345382k = 21;
            } else if (d16 >= vt3.d.S0.a().intValue()) {
                f345382k = 16;
            } else {
                f345382k = i();
            }
        } else if (d16 >= vt3.d.P0.a().intValue()) {
            f345382k = 21;
        } else if (d16 >= vt3.d.Q0.a().intValue()) {
            f345382k = 16;
        } else {
            f345382k = i();
        }
        return f345382k;
    }

    private static int k(int i3, int i16) {
        String str;
        String str2;
        int i17;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        int intValue12;
        int intValue13;
        int intValue14;
        int intValue15;
        int intValue16;
        int i18;
        int i19;
        int i26;
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            intValue = ((Integer) cls.getField("AVCLevel1").get(null)).intValue();
            intValue2 = ((Integer) cls.getField("AVCLevel1b").get(null)).intValue();
            intValue3 = ((Integer) cls.getField("AVCLevel11").get(null)).intValue();
            intValue4 = ((Integer) cls.getField("AVCLevel12").get(null)).intValue();
            intValue5 = ((Integer) cls.getField("AVCLevel13").get(null)).intValue();
            intValue6 = ((Integer) cls.getField("AVCLevel2").get(null)).intValue();
            intValue7 = ((Integer) cls.getField("AVCLevel21").get(null)).intValue();
            intValue8 = ((Integer) cls.getField("AVCLevel22").get(null)).intValue();
            intValue9 = ((Integer) cls.getField("AVCLevel3").get(null)).intValue();
            intValue10 = ((Integer) cls.getField("AVCLevel31").get(null)).intValue();
            intValue11 = ((Integer) cls.getField("AVCLevel32").get(null)).intValue();
            intValue12 = ((Integer) cls.getField("AVCLevel4").get(null)).intValue();
            str = "MediaPlayerMgr[TVKCodecUtils.java]";
            try {
                intValue13 = ((Integer) cls.getField("AVCLevel41").get(null)).intValue();
                intValue14 = ((Integer) cls.getField("AVCLevel42").get(null)).intValue();
                intValue15 = ((Integer) cls.getField("AVCLevel5").get(null)).intValue();
                intValue16 = ((Integer) cls.getField("AVCLevel51").get(null)).intValue();
                i18 = 25344;
            } catch (Exception e16) {
                e = e16;
                str2 = str;
                d.d(str2, "failed to get maxLumaSamples");
                d.b(str2, e);
                i17 = 414720;
                d.d(str2, "MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                return i17;
            }
        } catch (Exception e17) {
            e = e17;
            str = "MediaPlayerMgr[TVKCodecUtils.java]";
        }
        if (i16 != intValue && i16 != intValue2) {
            i18 = 101376;
            if (i16 != intValue3 && i16 != intValue4 && i16 != intValue5 && i16 != intValue6) {
                if (i16 == intValue7) {
                    i19 = 202752;
                } else {
                    if (i16 != intValue8 && i16 != intValue9) {
                        if (i16 == intValue10) {
                            i19 = 921600;
                        } else if (i16 == intValue11) {
                            i19 = 1310720;
                        } else {
                            i18 = 2097152;
                            if (i16 != intValue12 && i16 != intValue13) {
                                if (i16 == intValue14) {
                                    i19 = 2228224;
                                } else if (i16 == intValue15) {
                                    i19 = 5652480;
                                } else if (i16 >= intValue16) {
                                    i19 = 9437184;
                                }
                            }
                        }
                    }
                    i26 = 414720;
                    i17 = i26;
                    str2 = str;
                    d.d(str2, "MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                    return i17;
                }
                i26 = i19;
                i17 = i26;
                str2 = str;
                d.d(str2, "MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                return i17;
            }
        }
        i26 = i18;
        i17 = i26;
        str2 = str;
        d.d(str2, "MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
        return i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x024f, code lost:
    
        if (r30 != r0) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int l(int i3, int i16) {
        String str;
        String str2;
        int i17;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        int intValue12;
        int intValue13;
        int intValue14;
        int intValue15;
        int intValue16;
        int intValue17;
        int intValue18;
        int intValue19;
        int intValue20;
        int intValue21;
        int intValue22;
        int intValue23;
        int intValue24;
        int intValue25;
        int i18;
        int i19;
        try {
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            intValue = ((Integer) cls.getField("HEVCHighTierLevel1").get(null)).intValue();
            intValue2 = ((Integer) cls.getField("HEVCHighTierLevel2").get(null)).intValue();
            intValue3 = ((Integer) cls.getField("HEVCHighTierLevel21").get(null)).intValue();
            intValue4 = ((Integer) cls.getField("HEVCHighTierLevel3").get(null)).intValue();
            intValue5 = ((Integer) cls.getField("HEVCHighTierLevel31").get(null)).intValue();
            intValue6 = ((Integer) cls.getField("HEVCHighTierLevel4").get(null)).intValue();
            intValue7 = ((Integer) cls.getField("HEVCHighTierLevel41").get(null)).intValue();
            intValue8 = ((Integer) cls.getField("HEVCHighTierLevel5").get(null)).intValue();
            intValue9 = ((Integer) cls.getField("HEVCHighTierLevel51").get(null)).intValue();
            intValue10 = ((Integer) cls.getField("HEVCHighTierLevel52").get(null)).intValue();
            intValue11 = ((Integer) cls.getField("HEVCHighTierLevel6").get(null)).intValue();
            intValue12 = ((Integer) cls.getField("HEVCHighTierLevel61").get(null)).intValue();
            str = "MediaPlayerMgr[TVKCodecUtils.java]";
            try {
                intValue13 = ((Integer) cls.getField("HEVCHighTierLevel62").get(null)).intValue();
                intValue14 = ((Integer) cls.getField("HEVCMainTierLevel1").get(null)).intValue();
                intValue15 = ((Integer) cls.getField("HEVCMainTierLevel2").get(null)).intValue();
                intValue16 = ((Integer) cls.getField("HEVCMainTierLevel21").get(null)).intValue();
                intValue17 = ((Integer) cls.getField("HEVCMainTierLevel3").get(null)).intValue();
                intValue18 = ((Integer) cls.getField("HEVCMainTierLevel31").get(null)).intValue();
                intValue19 = ((Integer) cls.getField("HEVCMainTierLevel4").get(null)).intValue();
                intValue20 = ((Integer) cls.getField("HEVCMainTierLevel41").get(null)).intValue();
                intValue21 = ((Integer) cls.getField("HEVCMainTierLevel5").get(null)).intValue();
                intValue22 = ((Integer) cls.getField("HEVCMainTierLevel51").get(null)).intValue();
                intValue23 = ((Integer) cls.getField("HEVCMainTierLevel52").get(null)).intValue();
                intValue24 = ((Integer) cls.getField("HEVCMainTierLevel6").get(null)).intValue();
                intValue25 = ((Integer) cls.getField("HEVCMainTierLevel61").get(null)).intValue();
                int intValue26 = ((Integer) cls.getField("HEVCMainTierLevel62").get(null)).intValue();
            } catch (Exception e16) {
                e = e16;
                str2 = str;
                d.d(str2, "failed to get maxLumaSamples");
                d.b(str2, e);
                i17 = 552960;
                d.d(str2, "HEVC MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                return i17;
            }
        } catch (Exception e17) {
            e = e17;
            str = "MediaPlayerMgr[TVKCodecUtils.java]";
        }
        if (i16 != intValue && i16 != intValue14) {
            if (i16 != intValue2 && i16 != intValue15) {
                if (i16 != intValue3 && i16 != intValue16) {
                    if (i16 != intValue4 && i16 != intValue17) {
                        if (i16 != intValue5 && i16 != intValue18) {
                            int i26 = 2228224;
                            if (i16 != intValue6 && i16 != intValue19 && i16 != intValue7 && i16 != intValue20) {
                                i26 = 8912896;
                                if (i16 != intValue8 && i16 != intValue21 && i16 != intValue9 && i16 != intValue22 && i16 != intValue10 && i16 != intValue23) {
                                    i26 = 35651584;
                                    if (i16 != intValue11) {
                                        if (i16 != intValue24) {
                                            if (i16 < intValue12) {
                                                if (i16 != intValue25) {
                                                    if (i16 < intValue13) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            i19 = i26;
                            i17 = i19;
                            str2 = str;
                            d.d(str2, "HEVC MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                            return i17;
                        }
                        i18 = RecentBaseData.MENU_FLAG_MASK_READSTATE;
                    }
                    i19 = 552960;
                    i17 = i19;
                    str2 = str;
                    d.d(str2, "HEVC MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
                    return i17;
                }
                i18 = 245760;
            } else {
                i18 = 122880;
            }
        } else {
            i18 = 36864;
        }
        i19 = i18;
        i17 = i19;
        str2 = str;
        d.d(str2, "HEVC MaxLumaSamples : profile :" + i3 + " , level :" + i16 + " , maxSample : " + i17);
        return i17;
    }
}
