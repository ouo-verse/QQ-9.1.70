package com.tencent.ecommerce.richtext.ui.dom.style;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static int f105379a;

    /* renamed from: b, reason: collision with root package name */
    private static int f105380b;

    public static FlexPositionType a(String str) {
        FlexPositionType flexPositionType = FlexPositionType.RELATIVE;
        if (!TextUtils.isEmpty(str) && !str.equals(ParseCommon.LAYOUT_PARAMS_RELATIVE) && !str.equals("sticky")) {
            if (str.equals("absolute") || str.equals(QCircleDaTongConstant.ElementParamValue.FIXED)) {
                return FlexPositionType.ABSOLUTE;
            }
            return flexPositionType;
        }
        return flexPositionType;
    }

    public static float b(Object obj, int i3) {
        return j(obj, i3);
    }

    public static FlexAlign c(String str) {
        FlexAlign flexAlign = FlexAlign.STRETCH;
        if (!TextUtils.isEmpty(str) && !str.equals("stretch")) {
            if (str.equals("flex-start")) {
                return FlexAlign.FLEX_START;
            }
            if (str.equals("flex-end")) {
                return FlexAlign.FLEX_END;
            }
            if (str.equals("center")) {
                return FlexAlign.CENTER;
            }
            return flexAlign;
        }
        return flexAlign;
    }

    public static FlexAlign d(String str) {
        FlexAlign flexAlign = FlexAlign.AUTO;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("flex-start")) {
                return FlexAlign.FLEX_START;
            }
            if (str.equals("flex-end")) {
                return FlexAlign.FLEX_END;
            }
            if (str.equals("stretch")) {
                return FlexAlign.STRETCH;
            }
            if (str.equals("center")) {
                return FlexAlign.CENTER;
            }
            return flexAlign;
        }
        return flexAlign;
    }

    public static FlexDirection e(String str) {
        FlexDirection flexDirection = FlexDirection.COLUMN;
        if (!TextUtils.isEmpty(str) && !str.equals("column")) {
            if (str.equals("column-reverse")) {
                return FlexDirection.COLUMN_REVERSE;
            }
            if (str.equals("row")) {
                return FlexDirection.ROW;
            }
            if (str.equals("row-reverse")) {
                return FlexDirection.ROW_REVERSE;
            }
            return flexDirection;
        }
        return flexDirection;
    }

    public static FlexJustifyContent f(String str) {
        FlexJustifyContent flexJustifyContent = FlexJustifyContent.FLEX_START;
        if (!TextUtils.isEmpty(str) && !str.equals("flex-start")) {
            if (str.equals("flex-end")) {
                return FlexJustifyContent.FLEX_END;
            }
            if (str.equals("center")) {
                return FlexJustifyContent.CENTER;
            }
            if (str.equals("space-between")) {
                return FlexJustifyContent.SPACE_BETWEEN;
            }
            if (str.equals("space-around")) {
                return FlexJustifyContent.SPACE_AROUND;
            }
            return flexJustifyContent;
        }
        return flexJustifyContent;
    }

    public static FlexWrap g(String str) {
        FlexWrap flexWrap = FlexWrap.NOWRAP;
        if (!TextUtils.isEmpty(str) && !str.equals("nowrap") && str.equals("wrap")) {
            return FlexWrap.WRAP;
        }
        return flexWrap;
    }

    public static int h(float f16) {
        float f17;
        try {
            f17 = fk0.b.b().density;
        } catch (Exception unused) {
            f17 = 2.0f;
        }
        float f18 = (f17 * f16) + 0.5f;
        if (f16 == 0.0f) {
            f18 = 0.0f;
        }
        if (f18 > 0.0f && f18 < 1.0f) {
            return 1;
        }
        return (int) f18;
    }

    public static int i(int i3) {
        float f16;
        try {
            f16 = fk0.b.b().density;
        } catch (Exception unused) {
            f16 = 2.0f;
        }
        float f17 = i3 * f16;
        if (f17 > 0.0f && f17 < 1.0f) {
            return 1;
        }
        return (int) f17;
    }

    public static float j(Object obj, int i3) {
        if (obj == null) {
            return Float.NaN;
        }
        String trim = obj.toString().trim();
        if (!"auto".equals(trim) && !"undefined".equals(trim) && !TextUtils.isEmpty(trim)) {
            try {
                if (trim.endsWith("vx")) {
                    return q(trim, i3);
                }
                if (trim.endsWith("px")) {
                    return Float.parseFloat(trim.substring(0, trim.indexOf("px")));
                }
                if (trim.endsWith("dp")) {
                    return h(Float.parseFloat(trim.substring(0, trim.indexOf("dp"))));
                }
                if (trim.endsWith("vw")) {
                    return k((i3 * Float.parseFloat(trim.substring(0, trim.indexOf("vw")))) / 100.0f, i3);
                }
                if (trim.endsWith("rt")) {
                    return k(Float.parseFloat(trim.substring(0, trim.indexOf("rt"))), i3);
                }
                return k(Float.parseFloat(trim), i3);
            } catch (NumberFormatException | Exception unused) {
            }
        }
        return Float.NaN;
    }

    public static float k(float f16, int i3) {
        if (Float.isNaN(f16)) {
            return f16;
        }
        float m3 = (f16 * m()) / i3;
        double d16 = m3;
        if (d16 > 0.005d && m3 < 1.0f) {
            return 1.0f;
        }
        return (float) Math.rint(d16);
    }

    public static int l(Context context) {
        if (context != null && f105380b == 0) {
            if (fk0.b.b() == null) {
                return f105380b;
            }
            f105380b = fk0.b.b().heightPixels;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            f105380b = displayMetrics.heightPixels;
        }
        return f105380b;
    }

    public static int m() {
        if (fk0.b.c()) {
            return o();
        }
        return Math.min(n(fk0.b.a()), l(fk0.b.a()));
    }

    public static int n(Context context) {
        if (context != null && f105379a == 0) {
            if (fk0.b.b() == null) {
                return f105379a;
            }
            f105379a = fk0.b.b().widthPixels;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            f105379a = displayMetrics.widthPixels;
        }
        return f105379a;
    }

    public static int o() {
        if (fk0.b.b() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) fk0.b.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float p(float f16) {
        float f17;
        float f18 = 2.0f;
        try {
            f17 = fk0.b.b().density;
        } catch (Exception unused) {
            f17 = 2.0f;
        }
        if (f17 != 0.0f) {
            f18 = f17;
        }
        try {
            return Float.valueOf(com.tencent.ecommerce.richtext.utils.b.b().a(f16 / f18)).floatValue();
        } catch (Exception unused2) {
            return f16;
        }
    }

    public static float q(String str, int i3) {
        if (str.isEmpty()) {
            return 0.0f;
        }
        if (str.endsWith("vx")) {
            str = str.substring(0, str.indexOf("vx"));
        }
        return (Float.valueOf(Float.parseFloat(str)).floatValue() * i3) / m();
    }
}
