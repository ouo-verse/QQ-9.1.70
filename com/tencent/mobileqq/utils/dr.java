package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.vas.pay.VasH5PayConstants;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dr {
    public static String a(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            hd0.c.a("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json is null");
            return null;
        }
        try {
            optJSONArray = new JSONObject(str).optJSONArray(VasProfileTemplatePreloadHelper.BACKGROUND);
        } catch (JSONException e16) {
            hd0.c.a("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json is illegal:" + e16);
        }
        if (optJSONArray == null) {
            hd0.c.a("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array is null");
            return null;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                if ("image_view".equals(jSONObject.optString("type"))) {
                    return jSONObject.optString("content");
                }
                hd0.c.a("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array don't have image view");
            }
        }
        return null;
    }

    public static float b(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            return Math.round(((i3 * 1.0f) / i16) * 100.0f) / 100.0f;
        }
        return 0.0f;
    }

    public static void c(TroopInfo troopInfo, String str, Activity activity) {
        if (troopInfo == null) {
            QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage error,because troop info is null");
        } else if (troopInfo.checkFlagExt4(3)) {
            QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open mine page");
            g(QVIPPrettyTroopProcessor.get().getMineUrl("troop", troopInfo.troopuin), str, activity);
        } else {
            QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open home page");
            g(QVIPPrettyTroopProcessor.get().getHomeUrl("troop"), str, activity);
        }
    }

    public static void d(Card card, QQAppInterface qQAppInterface, Activity activity) {
        if (!QVipDiyTemplateProcessor.getConfig().enable) {
            QQToast.makeText(activity, 0, HardCodeUtil.qqStr(R.string.rja), 0).show();
            return;
        }
        String f16 = f(!TextUtils.equals(qQAppInterface.getCurrentAccountUin(), card.uin), card.cardId);
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_OTHER_PROFILE_CARD);
        intent.putExtra("url", f16);
        VasWebviewUtil.openQQBrowserWithoutAD(activity, f16, -1L, intent, true, 1036);
    }

    public static boolean e(QQAppInterface qQAppInterface) {
        if (QVipConfigManager.getBoolean(qQAppInterface, QVipConfigManager.KEY_BOOLEAN_HIDE_DIY_TEMPLATE_GUIDE, false)) {
            return false;
        }
        return QVipDiyTemplateProcessor.getConfig().enable;
    }

    private static String f(boolean z16, long j3) {
        StringBuilder sb5 = new StringBuilder("https://club.vip.qq.com/profile/custom?_wv=131072&_fv=0");
        if (z16) {
            sb5.append("&from=guest");
        }
        sb5.append("&templateId=");
        sb5.append(j3);
        return sb5.toString();
    }

    public static void g(String str, String str2, Context context) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", str2);
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_TROOP_SETTING);
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        intent.putExtra("url", str);
        VasWebviewUtil.openQQBrowserWithoutAD(context, str, -1L, intent, false, 0);
    }

    public static void h(Context context, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, VasH5PayConstants.ROUTE_NAME);
        activityURIRequest.extra().putString("url", str);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static Bitmap i(Bitmap bitmap, int i3, int i16) {
        int width;
        int i17;
        Bitmap bitmap2 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (b(bitmap.getWidth(), bitmap.getHeight()) == b(i3, i16)) {
            return bitmap;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        if (i3 < bitmap.getWidth() || i16 < bitmap.getHeight()) {
            if (b(bitmap.getWidth(), i3) >= b(bitmap.getHeight(), i16)) {
                i17 = (int) (((bitmap.getHeight() * 1.0f) / bitmap.getWidth()) * i3);
                width = i3;
            } else {
                width = (int) (((bitmap.getWidth() * 1.0f) / bitmap.getHeight()) * i16);
                i17 = i16;
            }
            bitmap2 = Bitmap.createBitmap(width, i17, Bitmap.Config.ARGB_8888);
            new Canvas(bitmap2).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), paint);
            bitmap = bitmap2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth() / 3, bitmap.getHeight() / 3), new Rect(0, 0, bitmap.getWidth() / 3, bitmap.getHeight() / 3), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() - (bitmap.getWidth() / 3), 0, bitmap.getWidth(), bitmap.getHeight() / 3), new Rect(createBitmap.getWidth() - (bitmap.getWidth() / 3), 0, createBitmap.getWidth(), bitmap.getHeight() / 3), paint);
        canvas.drawBitmap(bitmap, new Rect(0, bitmap.getHeight() - (bitmap.getHeight() / 3), bitmap.getWidth() / 3, bitmap.getHeight()), new Rect(0, createBitmap.getHeight() - (bitmap.getHeight() / 3), bitmap.getWidth() / 3, createBitmap.getHeight()), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() - (bitmap.getHeight() / 3), bitmap.getWidth(), bitmap.getHeight()), new Rect(createBitmap.getWidth() - (bitmap.getWidth() / 3), createBitmap.getHeight() - (bitmap.getHeight() / 3), createBitmap.getWidth(), createBitmap.getHeight()), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 3, 0, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() / 3), new Rect(bitmap.getWidth() / 3, 0, createBitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() / 3), paint);
        canvas.drawBitmap(bitmap, new Rect(0, bitmap.getHeight() / 3, bitmap.getWidth() / 3, bitmap.getHeight() - (bitmap.getHeight() / 3)), new Rect(0, bitmap.getHeight() / 3, bitmap.getWidth() / 3, createBitmap.getHeight() - (bitmap.getHeight() / 3)), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() / 3, bitmap.getWidth(), bitmap.getHeight() - (bitmap.getHeight() / 3)), new Rect(createBitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() / 3, createBitmap.getWidth(), createBitmap.getHeight() - (bitmap.getHeight() / 3)), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 3, bitmap.getHeight() - (bitmap.getHeight() / 3), bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight()), new Rect(bitmap.getWidth() / 3, createBitmap.getHeight() - (bitmap.getHeight() / 3), createBitmap.getWidth() - (bitmap.getWidth() / 3), createBitmap.getHeight()), paint);
        canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 3, bitmap.getHeight() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getHeight() - (bitmap.getHeight() / 3)), new Rect(bitmap.getWidth() / 3, bitmap.getHeight() / 3, createBitmap.getWidth() - (bitmap.getWidth() / 3), createBitmap.getHeight() - (bitmap.getHeight() / 3)), paint);
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        return createBitmap;
    }
}
