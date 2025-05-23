package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleJSRequestAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_receive_js_request";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
