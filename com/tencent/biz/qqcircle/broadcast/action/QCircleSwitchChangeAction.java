package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSRecSwitchChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSwitchChangeAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_switch_change_event";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("params");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("QCircleSwitchChangeAction", 1, "onReceive empty params!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (jSONObject.has("openRecSwitch")) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSRecSwitchChangeEvent(jSONObject.getBoolean("openRecSwitch")));
            }
            if (jSONObject.has("visitorSwitch")) {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleShowSettingEvent(28, jSONObject.getBoolean("visitorSwitch")));
            }
        } catch (JSONException e16) {
            QLog.e("QCircleSwitchChangeAction", 1, "handleSwitchChange parse json error:", e16);
        }
    }
}
