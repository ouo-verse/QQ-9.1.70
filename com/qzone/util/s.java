package com.qzone.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import cooperation.qzone.QZoneShareManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class s {
    public static void d(Activity activity, int i3, String str, String str2, boolean z16, int i16, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, i16);
        bundle.putInt(MiniChatConstants.KEY_MINI_FROM, 2);
        bundle.putInt("public_fragment_window_feature", 1);
        com.tencent.mobileqq.activity.aio.l.Z(activity, str, i3, str2, bundle, 0);
    }

    public static void a(Activity activity, int i3, String str, String str2) {
        b(activity, i3, str, str2, true);
    }

    public static void f(Activity activity, int i3, String str, String str2, boolean z16, int i16, Intent intent, BusinessFeedData businessFeedData) {
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = intent;
        g(activity, businessFeedData, intent2);
        intent2.putExtra("KEY_IS_AUTO_SEND_ARK_MESSAGE_WHEN_OPEN", true);
        d(activity, i3, str, str2, z16, i16, intent2);
    }

    public static void b(Activity activity, int i3, String str, String str2, boolean z16) {
        c(activity, i3, str, str2, z16, 0);
    }

    private static void g(Activity activity, BusinessFeedData businessFeedData, Intent intent) {
        DetailDataOutShare detailDataOutShare;
        if (businessFeedData == null || intent == null || (detailDataOutShare = businessFeedData.getOperationInfo().shareData) == null) {
            return;
        }
        intent.putExtra("forward_type", 39);
        intent.putExtra("req_share_id", Long.parseLong(QZoneShareManager.QQ_SHARE_APPID));
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        if (!TextUtils.isEmpty(detailDataOutShare.ark_content)) {
            intent.putExtras(QQCustomArkDialog.b.a(detailDataOutShare.ark_id, detailDataOutShare.view_id, "", Constants.DEFAULT_MIN_APP_VERSION, detailDataOutShare.ark_content, activity.getResources().getDisplayMetrics().scaledDensity, null, null));
            try {
                JSONObject jSONObject = new JSONObject(detailDataOutShare.ark_content);
                String optString = jSONObject.optString("prompt");
                if (!TextUtils.isEmpty(optString)) {
                    intent.putExtra("forward_ark_app_prompt", optString);
                }
                String optString2 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                if (!TextUtils.isEmpty(optString2)) {
                    intent.putExtra("forward_ark_app_meta", optString2);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            intent.putExtra("is_ark_display_share", true);
        }
        if (!TextUtils.isEmpty(detailDataOutShare.view_id)) {
            intent.putExtra("forward_ark_app_view", detailDataOutShare.view_id);
        }
        if (!TextUtils.isEmpty(detailDataOutShare.ark_id)) {
            intent.putExtra("forward_ark_app_name", detailDataOutShare.ark_id);
        }
        intent.putExtra("title", detailDataOutShare.sTitle);
        intent.putExtra("desc", detailDataOutShare.sSummary);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, 154);
    }

    public static void c(Activity activity, int i3, String str, String str2, boolean z16, int i16) {
        d(activity, i3, str, str2, z16, i16, null);
    }

    public static void e(Activity activity, int i3, String str, String str2, BusinessFeedData businessFeedData) {
        f(activity, i3, str, str2, false, 0, null, businessFeedData);
    }
}
