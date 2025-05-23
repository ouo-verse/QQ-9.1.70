package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.manager.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleUpdateTagFollowAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_update_native_tag_follow_state";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("tagId");
        int intExtra = intent.getIntExtra("type", -1);
        if (!TextUtils.isEmpty(stringExtra) && intExtra != -1) {
            boolean z16 = true;
            QLog.d("QCircleUpdateTagFollowAction", 1, "updateTagFollowManager tagId:" + stringExtra + " type:" + intExtra);
            if (intExtra != 1) {
                z16 = false;
            }
            e.b().c(stringExtra, z16);
        }
    }
}
