package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePushButtonResPackage;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleRocketResPackage;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class QCircleRefreshPushEffectAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_refresh_push_effect";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(ark.ARKMETADATA_JSON);
        QLog.d("QCircleRefreshPushEffectAction", 1, "QCircleRefreshPushEffect jsonConfig is " + stringExtra);
        try {
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(stringExtra);
            long parseLong = Long.parseLong("" + jSONObject.get("rocketEffectStartTime"));
            long parseLong2 = Long.parseLong("" + jSONObject.get("rocketEffectEndTime"));
            QCircleChangeResEngine qCircleChangeResEngine = QCircleChangeResEngine.INSTANCE;
            qCircleChangeResEngine.getResManager(QCirclePushButtonResPackage.class).s(parseLong, parseLong2);
            qCircleChangeResEngine.getResManager(QCircleRocketResPackage.class).s(parseLong, parseLong2);
            qCircleChangeResEngine.getResManager(QCirclePushButtonResPackage.class).n();
            qCircleChangeResEngine.getResManager(QCircleRocketResPackage.class).n();
        } catch (Exception e16) {
            QLog.e("QCircleRefreshPushEffectAction", 1, "QCircleRefreshPushEffect jsonConfig error " + e16);
        }
    }
}
