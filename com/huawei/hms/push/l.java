package com.huawei.hms.push;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l {
    public static int a(Context context) {
        int i3 = context.getApplicationInfo().icon;
        if (i3 != 0) {
            return i3;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    }

    public static int b(Context context, k kVar) {
        int i3 = 0;
        if (context != null && kVar != null) {
            if (!TextUtils.isEmpty(kVar.m())) {
                String[] split = kVar.m().split("/");
                if (split.length == 3) {
                    i3 = r.a(context, split[1], split[2]);
                }
            }
            if (i3 == 0) {
                i3 = r.a(context, "com.huawei.messaging.default_notification_icon");
            }
            if (i3 == 0) {
                return a(context);
            }
            return i3;
        }
        HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }

    public static Bitmap a(Context context, k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(kVar.k())) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get left bitmap from ");
            sb5.append(kVar.k());
            HMSLog.i("PushSelfShowLog", sb5.toString());
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.k())).getBitmap();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, k kVar) {
        if (context != null && builder != null && kVar != null) {
            builder.setSmallIcon(b(context, kVar));
        } else {
            HMSLog.e("PushSelfShowLog", "msg is null");
        }
    }
}
