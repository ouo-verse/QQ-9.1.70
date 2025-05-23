package com.tencent.ecommerce.richtext.utils;

import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ecommerce.richtext.ui.component.image.VImage2;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kk0.a;
import lk0.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static float f105497a = 1.0f / B(1.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ik0.b {
        a() {
        }

        @Override // ik0.b
        public ik0.c a(fk0.c cVar, lk0.b bVar, ik0.d dVar) {
            return new jk0.c(cVar, bVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ik0.b {
        b() {
        }

        @Override // ik0.b
        public ik0.c a(fk0.c cVar, lk0.b bVar, ik0.d dVar) {
            return new jk0.a(cVar, bVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ik0.b {
        c() {
        }

        @Override // ik0.b
        public ik0.c a(fk0.c cVar, lk0.b bVar, ik0.d dVar) {
            return new VImage2(cVar, bVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements ik0.b {
        d() {
        }

        @Override // ik0.b
        public ik0.c a(fk0.c cVar, lk0.b bVar, ik0.d dVar) {
            return new jk0.b(cVar, bVar, dVar);
        }
    }

    public static void A(@NonNull SparseIntArray sparseIntArray, int i3, int i16) {
        if (i3 == 0) {
            sparseIntArray.put(0, i16);
            sparseIntArray.put(2, i16);
            sparseIntArray.put(1, i16);
            sparseIntArray.put(3, i16);
            sparseIntArray.put(4, i16);
            return;
        }
        sparseIntArray.put(i3, i16);
    }

    public static float B(float f16) {
        float exp;
        float f17 = f16 * 8.0f;
        if (f17 < 1.0f) {
            exp = f17 - (1.0f - ((float) Math.exp(-f17)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }
        return exp * f105497a;
    }

    private static void C(lk0.b bVar, float f16) {
        if (bVar != null) {
            float f17 = 0.0f;
            if (f16 > 0.0f) {
                float j3 = bVar.j();
                while (true) {
                    float f18 = j3;
                    float f19 = f17;
                    f17 = f18;
                    if (f17 > f16 && f19 != f17) {
                        int b06 = bVar.b0();
                        lk0.b bVar2 = null;
                        for (int i3 = 0; i3 < b06; i3++) {
                            lk0.b a06 = bVar.a0(i3);
                            if (i3 == 0 || bVar2.j() < a06.j()) {
                                bVar2 = a06;
                            }
                        }
                        if (bVar2 != null) {
                            z(bVar2, bVar2.j() - (f17 - f16));
                            bVar.v0(new a.c());
                            kk0.a.a(bVar, null);
                            j3 = bVar.j();
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private static Map<String, ik0.b> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("text", new a());
        hashMap.put("div", new b());
        hashMap.put("image", new c());
        hashMap.put("vlottie", new d());
        return hashMap;
    }

    public static ik0.c b(JSONObject jSONObject, fk0.c cVar, Map<String, ik0.c> map, float f16) {
        if (jSONObject == null) {
            return null;
        }
        try {
            lk0.b c16 = c(jSONObject, cVar);
            C(c16, f16);
            return hk0.a.a(cVar, c16, null, a(), map);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static lk0.b c(JSONObject jSONObject, fk0.c cVar) {
        lk0.b o06 = lk0.b.o0(jSONObject, cVar, null);
        if (o06 == null) {
            return null;
        }
        h g06 = o06.g0();
        if (g06 != null && !g06.containsKey(NodeProps.FLEX_DIRECTION)) {
            g06.put(NodeProps.FLEX_DIRECTION, "column");
        }
        o06.v0(new a.c());
        kk0.a.a(o06, null);
        return o06;
    }

    public static void d(Bitmap bitmap, int i3) {
        int i16;
        int i17 = i3;
        if (i17 < 1) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i18 = width * height;
        int[] iArr = new int[i18];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i19 = width - 1;
        int i26 = height - 1;
        int i27 = i17 + i17 + 1;
        int[] iArr2 = new int[i18];
        int[] iArr3 = new int[i18];
        int[] iArr4 = new int[i18];
        int[] iArr5 = new int[Math.max(width, height)];
        int i28 = (i27 + 1) >> 1;
        int i29 = i28 * i28;
        int i36 = i29 * 256;
        int[] iArr6 = new int[i36];
        for (int i37 = 0; i37 < i36; i37++) {
            iArr6[i37] = i37 / i29;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i27, 3);
        int i38 = i17 + 1;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        while (i39 < height) {
            int i48 = height;
            int i49 = -i17;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            while (i49 <= i17) {
                int i75 = i26;
                int[] iArr8 = iArr5;
                int i76 = iArr[i46 + Math.min(i19, Math.max(i49, 0))];
                int[] iArr9 = iArr7[i49 + i17];
                iArr9[0] = (i76 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr9[1] = (i76 & 65280) >> 8;
                iArr9[2] = i76 & 255;
                int abs = i38 - Math.abs(i49);
                int i77 = iArr9[0];
                i56 += i77 * abs;
                int i78 = iArr9[1];
                i57 += i78 * abs;
                int i79 = iArr9[2];
                i58 += abs * i79;
                if (i49 > 0) {
                    i67 += i77;
                    i68 += i78;
                    i69 += i79;
                } else {
                    i59 += i77;
                    i65 += i78;
                    i66 += i79;
                }
                i49++;
                i26 = i75;
                iArr5 = iArr8;
            }
            int i85 = i26;
            int[] iArr10 = iArr5;
            int i86 = i56;
            int i87 = i57;
            int i88 = 0;
            int i89 = i17;
            int i95 = i38;
            int i96 = i58;
            while (i88 < width) {
                if (i86 < i36 && i87 < i36 && i96 < i36) {
                    iArr2[i46] = iArr6[i86];
                    iArr3[i46] = iArr6[i87];
                    iArr4[i46] = iArr6[i96];
                    int i97 = i86 - i59;
                    int i98 = i87 - i65;
                    int i99 = i96 - i66;
                    int[] iArr11 = iArr7[((i89 - i17) + i27) % i27];
                    int i100 = i59 - iArr11[0];
                    int i101 = i65 - iArr11[1];
                    int i102 = i66 - iArr11[2];
                    if (i39 == 0) {
                        i16 = i36;
                        iArr10[i88] = Math.min(i88 + i17 + 1, i19);
                    } else {
                        i16 = i36;
                    }
                    int i103 = iArr[i47 + iArr10[i88]];
                    int i104 = (i103 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                    iArr11[0] = i104;
                    int i105 = (i103 & 65280) >> 8;
                    iArr11[1] = i105;
                    int i106 = i103 & 255;
                    iArr11[2] = i106;
                    int i107 = i67 + i104;
                    int i108 = i68 + i105;
                    int i109 = i69 + i106;
                    i86 = i97 + i107;
                    i87 = i98 + i108;
                    i96 = i99 + i109;
                    i89 = (i89 + 1) % i27;
                    int[] iArr12 = iArr7[i89 % i27];
                    int i110 = iArr12[0];
                    i59 = i100 + i110;
                    int i111 = iArr12[1];
                    i65 = i101 + i111;
                    int i112 = iArr12[2];
                    i66 = i102 + i112;
                    i67 = i107 - i110;
                    i68 = i108 - i111;
                    i69 = i109 - i112;
                    i46++;
                    i88++;
                    i36 = i16;
                } else {
                    return;
                }
            }
            i47 += width;
            i39++;
            height = i48;
            i38 = i95;
            i26 = i85;
            iArr5 = iArr10;
        }
        int i113 = i26;
        int[] iArr13 = iArr5;
        int i114 = height;
        int i115 = i38;
        int i116 = 0;
        while (i116 < width) {
            int i117 = -i17;
            int i118 = i117 * width;
            int i119 = 0;
            int i120 = 0;
            int i121 = 0;
            int i122 = 0;
            int i123 = 0;
            int i124 = 0;
            int i125 = 0;
            int i126 = 0;
            int i127 = 0;
            while (i117 <= i17) {
                int i128 = i27;
                int max = Math.max(0, i118) + i116;
                int[] iArr14 = iArr7[i117 + i17];
                iArr14[0] = iArr2[max];
                iArr14[1] = iArr3[max];
                iArr14[2] = iArr4[max];
                int abs2 = i115 - Math.abs(i117);
                i119 += iArr2[max] * abs2;
                i120 += iArr3[max] * abs2;
                i121 += iArr4[max] * abs2;
                if (i117 > 0) {
                    i125 += iArr14[0];
                    i126 += iArr14[1];
                    i127 += iArr14[2];
                } else {
                    i122 += iArr14[0];
                    i123 += iArr14[1];
                    i124 += iArr14[2];
                }
                int i129 = i113;
                if (i117 < i129) {
                    i118 += width;
                }
                i117++;
                i113 = i129;
                i27 = i128;
            }
            int i130 = i27;
            int i131 = i113;
            int i132 = i17;
            int i133 = i114;
            int i134 = 0;
            int i135 = i116;
            while (i134 < i133) {
                iArr[i135] = (iArr6[i119] << 16) | (-16777216) | (iArr6[i120] << 8) | iArr6[i121];
                int i136 = i119 - i122;
                int i137 = i120 - i123;
                int i138 = i121 - i124;
                int[] iArr15 = iArr7[((i132 - i17) + i130) % i130];
                int i139 = i122 - iArr15[0];
                int i140 = i123 - iArr15[1];
                int i141 = i124 - iArr15[2];
                if (i116 == 0) {
                    iArr13[i134] = Math.min(i134 + i115, i131) * width;
                }
                int i142 = iArr13[i134] + i116;
                int i143 = iArr2[i142];
                iArr15[0] = i143;
                int i144 = iArr3[i142];
                iArr15[1] = i144;
                int i145 = iArr4[i142];
                iArr15[2] = i145;
                int i146 = i125 + i143;
                int i147 = i126 + i144;
                int i148 = i127 + i145;
                i119 = i136 + i146;
                i120 = i137 + i147;
                i121 = i138 + i148;
                i132 = (i132 + 1) % i130;
                int[] iArr16 = iArr7[i132];
                int i149 = iArr16[0];
                i122 = i139 + i149;
                int i150 = iArr16[1];
                i123 = i140 + i150;
                int i151 = iArr16[2];
                i124 = i141 + i151;
                i125 = i146 - i149;
                i126 = i147 - i150;
                i127 = i148 - i151;
                i135 += width;
                i134++;
                i17 = i3;
            }
            i116++;
            i17 = i3;
            i114 = i133;
            i113 = i131;
            i27 = i130;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i114);
    }

    public static int e(@Nullable SparseIntArray sparseIntArray, int i3, int i16) {
        if (sparseIntArray != null) {
            return sparseIntArray.get(i3, sparseIntArray.get(0));
        }
        return i16;
    }

    public static boolean f(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            if ("0".equals(obj)) {
                return false;
            }
            if ("1".equals(obj) || "true".equals(obj)) {
                return true;
            }
            if ("false".equals(obj)) {
                return false;
            }
        }
        if (n(obj, 0) != 0) {
            return true;
        }
        return false;
    }

    public static int g(String str) {
        return com.tencent.ecommerce.richtext.utils.a.c(str);
    }

    public static DisplayMetrics h() {
        dk0.d a16 = fk0.d.c().a();
        if (a16 == null) {
            return null;
        }
        return a16.f();
    }

    public static float i(Object obj, float f16) {
        if (obj == null) {
            return f16;
        }
        String trim = obj.toString().trim();
        try {
            if (trim.endsWith("dp")) {
                trim = trim.substring(0, trim.indexOf("dp"));
            }
            return Float.parseFloat(trim);
        } catch (Exception unused) {
            return f16;
        }
    }

    public static float j(Object obj) {
        return k(obj, Float.valueOf(Float.NaN));
    }

    public static float k(Object obj, @NonNull Float f16) {
        if (obj == null) {
            return f16.floatValue();
        }
        String trim = obj.toString().trim();
        if (!"auto".equals(trim) && !"undefined".equals(trim) && !TextUtils.isEmpty(trim)) {
            try {
                if (trim.endsWith("px")) {
                    return Float.parseFloat(trim.substring(0, trim.indexOf("px")));
                }
                if (trim.endsWith("dp")) {
                    return g.h(Float.parseFloat(trim.substring(0, trim.indexOf("dp"))));
                }
                return Float.parseFloat(trim);
            } catch (NumberFormatException | Exception unused) {
                return f16.floatValue();
            }
        }
        return f16.floatValue();
    }

    public static float l(float f16) {
        if (Float.isNaN(f16)) {
            return 0.0f;
        }
        return f16;
    }

    public static int m(Object obj) {
        return n(obj, 0);
    }

    public static int n(Object obj, @Nullable int i3) {
        if (obj == null) {
            return i3;
        }
        String trim = obj.toString().trim();
        if (!"auto".equals(trim) && !"undefined".equals(trim) && !TextUtils.isEmpty(trim)) {
            try {
                if (trim.endsWith("px")) {
                    return Integer.parseInt(trim.substring(0, trim.indexOf("px")));
                }
                if (trim.endsWith("dp")) {
                    return g.i(Integer.parseInt(trim.substring(0, trim.indexOf("dp"))));
                }
                return Integer.parseInt(trim);
            } catch (NumberFormatException | Exception unused) {
            }
        }
        return i3;
    }

    public static int o(int i3) {
        int i16 = i3 >>> 24;
        if (i16 == 255) {
            return -1;
        }
        if (i16 == 0) {
            return -2;
        }
        return -3;
    }

    public static String p(@Nullable Object obj, @Nullable String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    public static boolean q() {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            return true;
        }
        return false;
    }

    public static void r(String str, int i3, String str2) {
        if (i3 != 4) {
            if (i3 != 6) {
                Log.d(str, str2);
                return;
            } else {
                Log.e(str, str2);
                return;
            }
        }
        Log.i(str, str2);
    }

    public static int s(int i3, int i16) {
        if (i16 == 255) {
            return i3;
        }
        if (i16 == 0) {
            return i3 & 16777215;
        }
        return (i3 & 16777215) | ((((i3 >>> 24) * (i16 + (i16 >> 7))) >> 8) << 24);
    }

    private static int t(String str, int i3) {
        return (int) ((Float.parseFloat(str) / 100.0f) * i3);
    }

    public static int u(String str, int i3) {
        int lastIndexOf = str.lastIndexOf(37);
        if (lastIndexOf != -1) {
            return t(str.substring(0, lastIndexOf), i3);
        }
        return Integer.parseInt(str);
    }

    public static String v(File file) {
        return w(file, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
    
        if (r3 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0092, code lost:
    
        if (r3 == null) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String w(File file, int i3) {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        InputStreamReader inputStreamReader2;
        String str = null;
        str = null;
        str = null;
        str = null;
        BufferedInputStream bufferedInputStream2 = null;
        str = null;
        if (file == null) {
            return null;
        }
        if (file.exists() && file.canRead()) {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Exception unused) {
                    bufferedInputStream = null;
                    inputStreamReader2 = null;
                } catch (OutOfMemoryError unused2) {
                    bufferedInputStream = null;
                    inputStreamReader2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    if (bufferedInputStream2 != null) {
                    }
                    if (inputStreamReader == null) {
                    }
                }
                try {
                    inputStreamReader2 = new InputStreamReader(bufferedInputStream, "UTF-8");
                } catch (Exception unused3) {
                    inputStreamReader2 = null;
                } catch (OutOfMemoryError unused4) {
                    inputStreamReader2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader = null;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (inputStreamReader == null) {
                        try {
                            inputStreamReader.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    int length = (int) file.length();
                    if (length > 12288) {
                        if (i3 == -1) {
                            i3 = length / 6144;
                            int i16 = 12;
                            if (i3 >= 12) {
                                i16 = 60;
                                if (i3 > 60) {
                                }
                            }
                            i3 = i16;
                        }
                        char[] cArr = new char[4096];
                        StringBuilder sb5 = new StringBuilder(i3 * 1024);
                        while (true) {
                            int read = inputStreamReader2.read(cArr);
                            if (-1 == read) {
                                break;
                            }
                            sb5.append(cArr, 0, read);
                        }
                        str = sb5.toString();
                    } else {
                        char[] cArr2 = new char[length];
                        str = new String(cArr2, 0, inputStreamReader2.read(cArr2));
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused7) {
                    }
                } catch (Exception unused8) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused9) {
                        }
                    }
                } catch (OutOfMemoryError unused10) {
                    if (i3 == -1) {
                        str = w(file, 6);
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused11) {
                        }
                    }
                }
                try {
                    inputStreamReader2.close();
                } catch (Exception unused12) {
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return str;
    }

    public static String x(JSONObject jSONObject) {
        StringBuffer stringBuffer = null;
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String str = (String) keys.next();
                    String string = jSONObject.getString(str);
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer();
                    } else {
                        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    stringBuffer.append(str);
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(string);
                } catch (JSONException e16) {
                    r("ViolaUtilss", 6, "splittBodyEncodeUrl error : " + e16.getMessage());
                }
            }
        }
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return "";
    }

    public static String y(JSONObject jSONObject, String str) {
        StringBuffer stringBuffer;
        JSONException e16;
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            StringBuffer stringBuffer2 = null;
            while (keys.hasNext()) {
                try {
                    String str2 = (String) keys.next();
                    String string = jSONObject.getString(str2);
                    if (stringBuffer2 == null) {
                        stringBuffer = new StringBuffer();
                        try {
                            if (!TextUtils.isEmpty(str) && !str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                stringBuffer.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                            } else {
                                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            stringBuffer2 = stringBuffer;
                        } catch (JSONException e17) {
                            e16 = e17;
                            r("ViolaUtilss", 6, "splittUrlForHttpGet error : " + e16.getMessage());
                            stringBuffer2 = stringBuffer;
                        }
                    } else {
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    stringBuffer2.append(str2);
                    stringBuffer2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer2.append(string);
                } catch (JSONException e18) {
                    stringBuffer = stringBuffer2;
                    e16 = e18;
                }
            }
            if (stringBuffer2 != null) {
                return str + stringBuffer2.toString();
            }
            return str;
        }
        return str;
    }

    private static void z(lk0.b bVar, float f16) {
        if (bVar == null) {
            return;
        }
        if (f16 < 5.0f) {
            lk0.b c06 = bVar.c0();
            if (c06 != null) {
                c06.r0(bVar);
                return;
            }
            return;
        }
        bVar.g0().put("width", g.p(f16) + "dp");
    }
}
