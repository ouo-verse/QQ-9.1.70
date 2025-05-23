package i33;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    public static int a(int i3, int i16) {
        int alphaComponent;
        if (g(i3)) {
            alphaComponent = ColorUtils.setAlphaComponent(-1, i16);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(-16777216, i16);
        }
        return ColorUtils.blendARGB(i3, alphaComponent, 0.5f);
    }

    public static int b(int i3, float f16, boolean z16) {
        int alphaComponent;
        int intValue = Float.valueOf(f16 * 255.0f).intValue();
        if (z16) {
            alphaComponent = ColorUtils.setAlphaComponent(-1, intValue);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(-16777216, intValue);
        }
        return e(i3, alphaComponent);
    }

    public static int c(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        int i16 = (int) (fArr[1] * 100.0f);
        int i17 = (int) (fArr[2] * 100.0f);
        if (i16 < 40 && i17 > 60) {
            return -16777216;
        }
        return -1;
    }

    public static String d(String str, String str2) {
        String str3 = str + "drawable-xxhdpi/" + str2;
        if (!new File(str3).exists()) {
            String str4 = str + "drawable-xhdpi/" + str2;
            if (!new File(str4).exists()) {
                String str5 = str + "drawable-hdpi/" + str2;
                if (!new File(str5).exists()) {
                    return str + "drawable-mdpi/" + str2;
                }
                return str5;
            }
            return str4;
        }
        return str3;
    }

    private static int e(int i3, int i16) {
        float alpha = Color.alpha(i3) / 255.0f;
        float alpha2 = Color.alpha(i16) / 255.0f;
        if (alpha == 0.0f && alpha2 == 0.0f) {
            return i3;
        }
        if (alpha == 0.0f) {
            return i16;
        }
        if (alpha2 == 0.0f) {
            return i3;
        }
        float red = Color.red(i3) * 1.0f;
        float green = Color.green(i3) * 1.0f;
        float f16 = 1.0f - alpha2;
        float f17 = 1.0f - ((1.0f - alpha) * f16);
        return ((int) ((((alpha2 * (Color.blue(i16) * 1.0f)) + ((f16 * (Color.blue(i3) * 1.0f)) * alpha)) / f17) + 0.5f)) | (((int) ((f17 * 255.0f) + 0.5f)) << 24) | (((int) (((((Color.red(i16) * 1.0f) * alpha2) + ((red * f16) * alpha)) / f17) + 0.5f)) << 16) | (((int) (((((Color.green(i16) * 1.0f) * alpha2) + ((green * f16) * alpha)) / f17) + 0.5f)) << 8);
    }

    public static int f(String str, String str2) {
        if (BaseApplication.getContext() == null) {
            return 0;
        }
        return BaseApplication.getContext().getResources().getIdentifier(str, str2, BaseApplication.getContext().getPackageName());
    }

    public static boolean g(int i3) {
        if (Math.max(Color.red(i3), Math.max(Color.green(i3), Color.blue(i3))) < 127) {
            return true;
        }
        return false;
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2, boolean z16) {
        if (jSONObject2 == null) {
            return;
        }
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String optString = jSONObject2.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                if (z16) {
                    String optString2 = jSONObject.optString(str);
                    if (!TextUtils.isEmpty(optString2)) {
                        optString = optString + "," + optString2;
                    }
                    try {
                        jSONObject.putOpt(str, optString);
                    } catch (JSONException e16) {
                        QLog.e("TintUtil", 1, e16, new Object[0]);
                    }
                } else {
                    try {
                        jSONObject.putOpt(str, optString);
                    } catch (JSONException e17) {
                        QLog.e("TintUtil", 1, e17, new Object[0]);
                    }
                }
            }
        }
    }

    public static String i(int i3) {
        StringBuilder sb5 = new StringBuilder();
        String hexString = Integer.toHexString(Color.alpha(i3));
        String hexString2 = Integer.toHexString(Color.red(i3));
        String hexString3 = Integer.toHexString(Color.green(i3));
        String hexString4 = Integer.toHexString(Color.blue(i3));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        sb5.append("#");
        if (!hexString.equals("FF")) {
            sb5.append(hexString);
        }
        sb5.append(hexString2);
        sb5.append(hexString3);
        sb5.append(hexString4);
        return sb5.toString();
    }
}
