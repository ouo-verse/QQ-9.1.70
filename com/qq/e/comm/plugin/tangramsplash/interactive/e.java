package com.qq.e.comm.plugin.tangramsplash.interactive;

import android.gesture.Gesture;
import android.gesture.GestureStroke;
import android.graphics.PointF;
import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    public static boolean a(Gesture gesture, InteractiveInfo interactiveInfo) {
        if (gesture == null) {
            return false;
        }
        ArrayList<GestureStroke> strokes = gesture.getStrokes();
        if (strokes != null && strokes.size() != 0) {
            ArrayList arrayList = new ArrayList();
            GestureStroke gestureStroke = strokes.get(0);
            if (gestureStroke == null || gestureStroke.points == null) {
                return false;
            }
            for (int i3 = 0; i3 < gestureStroke.points.length - 1; i3 += 2) {
                float[] fArr = gestureStroke.points;
                arrayList.add(new PointF(fArr[i3], fArr[i3 + 1]));
            }
            return a(arrayList, interactiveInfo);
        }
        GDTLogger.w("onGesturePerformed: empty strokes");
        return false;
    }

    public static String b(r rVar) {
        InteractiveInfo.a f16;
        if (rVar.bJ() == null || (f16 = rVar.bJ().f()) == null || !f16.a()) {
            return null;
        }
        return f16.f38888i;
    }

    public static String c(r rVar) {
        InteractiveInfo.a f16;
        if (rVar == null || rVar.bJ() == null || (f16 = rVar.bJ().f()) == null || !f16.a()) {
            return null;
        }
        return f16.f38880a;
    }

    public static String d(r rVar) {
        InteractiveInfo.a f16;
        if (rVar.bJ() == null || (f16 = rVar.bJ().f()) == null) {
            return null;
        }
        return f16.f38892m;
    }

    public static File e(r rVar) {
        String a16 = a(rVar);
        if (!TextUtils.isEmpty(a16)) {
            File a17 = at.a(2, rVar.s(), a16);
            if (a17.exists()) {
                return a17;
            }
            return null;
        }
        return null;
    }

    public static File f(r rVar) {
        String b16 = b(rVar);
        if (!TextUtils.isEmpty(b16)) {
            File a16 = at.a(1, rVar.s(), b16);
            if (a16.exists()) {
                return a16;
            }
            return null;
        }
        return null;
    }

    private static boolean a(List<PointF> list, InteractiveInfo interactiveInfo) {
        GDTLogger.d("checkGestureHit: " + list);
        if (interactiveInfo == null) {
            return false;
        }
        String c16 = interactiveInfo.c();
        double e16 = interactiveInfo.e();
        GDTLogger.d("checkGestureHit - data\uff1a" + c16 + "\uff0c precision\uff1a" + e16);
        List<PointF> a16 = a(c16);
        if (a16.size() > 0 && list.size() > 0) {
            try {
                float a17 = com.qq.e.comm.plugin.tangramsplash.interactive.gesture.b.a(a16, list);
                Collections.reverse(a16);
                float acos = (float) Math.acos(Math.max(a17, com.qq.e.comm.plugin.tangramsplash.interactive.gesture.b.a(a16, list)));
                if (acos <= e16) {
                    GDTLogger.d("interactive ad, onGestureEnd: \u8bc6\u522b\u6210\u529f\uff0c actualPrecision\uff1a" + acos + "\uff0cprecision\uff1a" + e16);
                    return true;
                }
                GDTLogger.d("interactive ad, onGestureEnd: \u8bc6\u522b\u5931\u8d25\uff0c actualPrecision\uff1a" + acos + "\uff0cprecision\uff1a" + e16);
                return false;
            } catch (Throwable th5) {
                GDTLogger.w("checkGestureHit failed", th5);
            }
        }
        return false;
    }

    private static List<PointF> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("[|]");
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String[] split2 = split[i3].split("[_]");
                if (split2.length == 2) {
                    float a16 = a(split2[0], 1);
                    float a17 = a(split2[1], 1);
                    if (a16 == -1.0f || a17 == -1.0f) {
                        break;
                    }
                    arrayList.add(new PointF(a16, a17));
                    i3++;
                } else {
                    GDTLogger.e(String.format("invalid gesture str! %s", str));
                    arrayList.clear();
                    break;
                }
            }
            GDTLogger.e(String.format("invalid gesture str! %s", str));
            arrayList.clear();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static float a(String str, int i3) {
        float parseFloat = Float.parseFloat(str);
        BigDecimal bigDecimal = new BigDecimal(parseFloat);
        try {
            if (i3 <= 0) {
                str = bigDecimal.setScale(0, 1).floatValue();
            } else {
                str = bigDecimal.setScale(i3, 1).floatValue();
            }
            parseFloat = str;
            return parseFloat;
        } catch (ArithmeticException e16) {
            GDTLogger.w("getFloat fail str:" + str + ", decimalCount:" + i3, e16);
            return parseFloat;
        }
    }

    public static String a(r rVar) {
        InteractiveInfo.a f16;
        if (rVar.bJ() == null || (f16 = rVar.bJ().f()) == null || !f16.a()) {
            return null;
        }
        return f16.f38887h;
    }
}
