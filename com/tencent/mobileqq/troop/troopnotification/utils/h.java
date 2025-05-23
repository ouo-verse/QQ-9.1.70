package com.tencent.mobileqq.troop.troopnotification.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static HashMap<String, structmsg$StructMsg> f300933a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f300933a = null;
        }
    }

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationUtils", 2, "clearAccountLoginInfoSp");
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().commit();
    }

    public static Drawable b(IFaceDecoder iFaceDecoder, String str, int i3) {
        if (iFaceDecoder != null && str != null && i3 != -1) {
            if (iFaceDecoder.isPausing()) {
                iFaceDecoder.resume();
            }
            Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(i3, str);
            if (bitmapFromCache == null) {
                iFaceDecoder.requestDecodeFace(str, i3, true);
                if (i3 == 4) {
                    bitmapFromCache = BaseImageUtil.getDefaultTroopFaceBitmap();
                } else {
                    bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
                }
            }
            return new BitmapDrawable(bitmapFromCache);
        }
        return null;
    }

    public static boolean c(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0)) == null) {
            return false;
        }
        boolean z16 = sharedPreferences.getBoolean("isFirstLogin" + str, true);
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationUtils", 2, "isAccountFirstLogin uin=" + str + " result=" + z16);
        }
        return z16;
    }

    public static final void d(Context context, String str, String str2) {
        String format = String.format("https://qun.qq.com/qunpay/qunfee/pay.html?gc=%s&source=joingroup&_wv=1031", str);
        if (!TextUtils.isEmpty(str2)) {
            format = format + "&source_id=" + str2;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", format);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_location_share");
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void e(String str, boolean z16) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0)) == null) {
            return;
        }
        sharedPreferences.edit().putBoolean("isFirstLogin" + str, z16).commit();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationUtils", 2, "setIsAccountFirstLogin uin=" + str + " firstLogin=" + z16);
        }
    }
}
