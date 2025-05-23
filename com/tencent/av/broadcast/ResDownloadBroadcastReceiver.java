package com.tencent.av.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.opengl.effects.q;
import com.tencent.av.r;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResDownloadBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        q qVar;
        String action = intent.getAction();
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadBroadcastReceiver", 2, "ResDownloadBroadcastReceiver onReceive: action = " + action);
        }
        if (AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION.equals(action) && r.h0() != null) {
            String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH);
            String stringExtra2 = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
            QLog.d("ResDownloadBroadcastReceiver", 2, "\u6536\u5230\u5e7f\u64ad: path = " + stringExtra + " agent = " + stringExtra2);
            m R = r.h0().R(false);
            if (R != null && (qVar = R.F) != null) {
                qVar.j(stringExtra, stringExtra2);
            }
        }
    }
}
