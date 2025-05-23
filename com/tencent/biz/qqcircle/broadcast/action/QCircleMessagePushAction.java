package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public class QCircleMessagePushAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_receive_message_push";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
