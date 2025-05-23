package com.qzone.common.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBaseBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            QLog.d("QzoneBaseBroadcastReceiver", 1, this + ":onReceive, action: " + intent.getAction());
        }
    }
}
