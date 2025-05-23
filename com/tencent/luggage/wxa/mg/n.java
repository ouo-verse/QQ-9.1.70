package com.tencent.luggage.wxa.mg;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.luggage.wxa.tn.w;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {
    public static boolean a(String str) {
        return com.tencent.luggage.wxa.tg.h.d(str);
    }

    public static boolean b(com.tencent.luggage.wxa.xg.g gVar) {
        return gVar != null && 2 == gVar.getPlayerType();
    }

    public static boolean c(com.tencent.luggage.wxa.xg.g gVar) {
        if (gVar != null && 1 == gVar.getPlayerType()) {
            return true;
        }
        return false;
    }

    public static boolean a(com.tencent.luggage.wxa.xg.g gVar) {
        return gVar != null && 4 == gVar.getPlayerType();
    }

    public static float b(Context context) {
        float f16 = 0.0f;
        try {
            f16 = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            return f16 / a();
        } catch (Settings.SettingNotFoundException e16) {
            w.a("MicroMsg.VideoPlayerUtils", e16, "", new Object[0]);
            return f16;
        }
    }

    public static int a() {
        try {
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
            r1 = identifier != 0 ? system.getInteger(identifier) : 255;
            w.a("MicroMsg.VideoPlayerUtils", "getMaxBrightness %d", Integer.valueOf(r1));
        } catch (Exception unused) {
            w.d("MicroMsg.VideoPlayerUtils", "get max brightness fail, fallback to 255");
        }
        return r1;
    }

    public static float a(Context context) {
        if (!(context instanceof Activity)) {
            return 1.0f;
        }
        float f16 = ((Activity) context).getWindow().getAttributes().screenBrightness;
        return f16 < 0.0f ? b(context) : f16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r3 > 1.0f) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, float f16) {
        if (context instanceof Activity) {
            float f17 = f16 >= 0.01f ? 1.0f : 0.01f;
            f16 = f17;
            Activity activity = (Activity) context;
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f16;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public static String a(long j3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(j3 < 3600000 ? "mm:ss" : "HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return simpleDateFormat.format(Long.valueOf(j3));
    }
}
