package com.tencent.relation.common.business.cross;

import ab1.a;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QQRabbitYearCrossHandler {
    private static final String KEY_TITLE = "title";
    private static final String TAG = "QQRabbitYearCrossHandler";

    private JSONObject buildJsCallback(int i3, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            if (obj instanceof JSONObject) {
                jSONObject.put("data", (JSONObject) obj);
            } else if (obj instanceof MessageMicro) {
                jSONObject.put("data", Proto2JsonUtil.proto2JsonObj((MessageMicro) obj));
            } else {
                jSONObject.put("data", obj);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "JsCallback constructor error", e16);
        }
        return jSONObject;
    }

    private void onFail(a aVar, int i3, Object obj) {
        aVar.f(buildJsCallback(i3, obj));
    }

    private void sendRabbitYearSuperShowEmoticon(JSONObject jSONObject, a aVar) {
        Activity a16 = b.a();
        if (a16 == null) {
            onFail(aVar, 1, "null == activity");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(a16, ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1062);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 10020);
        intent.putExtra(AppConstants.Key.FORWARD_ANIMATION_TYPE, 1);
        intent.putExtra(ForwardRecentActivity.KEY_FORWARD_TITLE, jSONObject.optString("title"));
        intent.putExtra("forward_source_business_type", 100700);
        a16.startActivity(intent);
        onSuccess(aVar, 0);
    }

    private void onSuccess(a aVar, Object obj) {
        aVar.f(buildJsCallback(0, obj));
    }
}
