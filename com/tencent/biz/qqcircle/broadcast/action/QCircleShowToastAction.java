package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleShowToastAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_show_qcircle_custom_toast";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("text");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("QCircleShowToastAction", 1, "onReceive empty text");
            return;
        }
        QLog.d("QCircleShowToastAction", 1, "onReceive text=" + stringExtra);
        QCircleToast.m(QCircleToast.f91644d, stringExtra, 1, true, true, 150L, 3);
    }
}
