package com.qzone.util.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.util.l;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f59814a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static final String f59815b = l.a(R.string.nef);

    /* renamed from: c, reason: collision with root package name */
    private static final String f59816c = l.a(R.string.neg);

    /* renamed from: d, reason: collision with root package name */
    private static final String f59817d = l.a(R.string.neh);

    /* renamed from: e, reason: collision with root package name */
    private static final int f59818e = g.a(12.0f);

    /* renamed from: f, reason: collision with root package name */
    private static final int f59819f = g.a(10.0f);

    public static void b(Canvas canvas, int i3, int i16, String str, int i17) {
        canvas.save();
        double sqrt = Math.sqrt(((i3 * i3) / 4.0f) + ((i16 * i16) / 4.0f));
        float f16 = i3;
        double degrees = Math.toDegrees(Math.atan(i16 / f16));
        double sin = Math.sin(Math.toRadians(15.0d)) * 2.0d * sqrt;
        double radians = Math.toRadians((180.0d - degrees) - 75.0d);
        canvas.translate(-((float) (Math.cos(radians) * sin)), (float) (Math.sin(radians) * sin));
        canvas.rotate(-30.0f);
        Drawable drawable = FeedGlobalEnv.getContext().getResources().getDrawable(R.drawable.gj5);
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i18 = ((i3 - intrinsicWidth) / 2) + i17;
            int i19 = ((i16 - intrinsicHeight) / 2) - f59818e;
            drawable.setBounds(i18, i19, intrinsicWidth + i18, intrinsicHeight + i19);
            drawable.setAlpha(30);
            drawable.draw(canvas);
            Paint e16 = e(30);
            String i26 = i(str);
            if (!TextUtils.isEmpty(i26)) {
                canvas.drawText(i26, ((f16 - e16.measureText(i26)) / 2.0f) + i17, r2 + r4, e16);
            }
        }
        canvas.restore();
    }

    public static void c(Canvas canvas, String str, int i3) {
        Drawable drawable;
        canvas.save();
        float f16 = i3;
        canvas.translate((-i3) * 0.25f, 0.5f * f16);
        canvas.rotate(-45.0f);
        try {
            drawable = FeedGlobalEnv.getContext().getResources().getDrawable(R.drawable.gj5);
        } catch (Throwable th5) {
            w5.b.d(f59814a, 1, "drawWatermark error!!", th5);
            drawable = null;
        }
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i16 = (i3 - intrinsicWidth) / 2;
            int i17 = ((i3 - intrinsicHeight) / 2) - f59819f;
            drawable.setBounds(i16, i17, intrinsicWidth + i16, intrinsicHeight + i17);
            drawable.setAlpha(30);
            drawable.draw(canvas);
            Paint e16 = e(20);
            String i18 = i(str);
            if (!TextUtils.isEmpty(i18)) {
                canvas.drawText(i18, (f16 - e16.measureText(i18)) / 2.0f, r4 + r0, e16);
            }
        }
        canvas.restore();
    }

    public static int d(String str) {
        return h(str);
    }

    public static Paint e(int i3) {
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setAntiAlias(true);
        paint.setTextSize(24.0f);
        paint.setAlpha(i3);
        return paint;
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean g(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return !TextUtils.isEmpty(new JSONObject(str).optString(ImageTaskConst.NOCACHE_CODE));
            } catch (Exception e16) {
                w5.b.b(f59814a, 1, "isNocachePic exception!");
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String optString = new JSONObject(str).optString(ImageTaskConst.ERROR_TYPE);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            return Integer.valueOf(optString).intValue();
        } catch (Exception e16) {
            w5.b.b(f59814a, 1, "parseImageLoadErrorType exception!");
            e16.printStackTrace();
            return 0;
        }
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(ImageTaskConst.FAIL_CODE);
            String optString2 = jSONObject.optString(ImageTaskConst.EXCEPTION_CODE);
            String optString3 = jSONObject.optString(ImageTaskConst.SERVER_IP);
            String optString4 = jSONObject.optString(ImageTaskConst.CLIENT_IP);
            return optString + "-" + optString2 + "-" + k(optString3) + "-" + k(optString4);
        } catch (JSONException e16) {
            w5.b.b(f59814a, 1, "parseImageLoadInfo exception!");
            e16.printStackTrace();
            return null;
        }
    }

    public static String j(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(ImageTaskConst.NOCACHE_CODE);
                if ("-2005".equals(optString)) {
                    return f59815b;
                }
                if ("-899".equals(optString)) {
                    return f59816c;
                }
                if ("-5062".equals(optString)) {
                    return f59817d;
                }
                String optString2 = jSONObject.optString(ImageTaskConst.SERVER_IP);
                String optString3 = jSONObject.optString(ImageTaskConst.CLIENT_IP);
                return optString + "-" + k(optString2) + "-" + k(optString3);
            } catch (Exception e16) {
                w5.b.b(f59814a, 1, "parseImageNocachInfo exception!");
                e16.printStackTrace();
                return "";
            }
        }
        return "";
    }

    private static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return "-";
        }
        List asList = Arrays.asList(str.split("\\."));
        StringBuilder sb5 = new StringBuilder();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2 != null) {
                sb5.append(str2);
                if (it.hasNext() && str2.length() < 3) {
                    sb5.append("-");
                }
            }
        }
        return sb5.toString();
    }

    public static void a(Canvas canvas, String str, int i3, int i16, int i17) {
        Paint e16 = e(60);
        float measureText = e16.measureText(str);
        float f16 = i3;
        if (measureText > f16) {
            canvas.drawText(str, g.a(1.0f), i16 - f59819f, e16);
        } else {
            canvas.drawText(str, ((f16 - measureText) / 2.0f) + i17, i16 - f59819f, e16);
        }
    }
}
