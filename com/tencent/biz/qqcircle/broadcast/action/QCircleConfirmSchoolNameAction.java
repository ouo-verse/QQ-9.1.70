package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleConfirmSchoolNameAction extends QCircleBaseBroadcastAction {
    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra("schoolName");
        QLog.d("QCircleConfirmSchoolNam", 1, "select schoolName school:" + stringExtra);
        new HashMap().put("school", stringExtra);
    }

    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_confirm_school_name";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b(intent);
    }
}
