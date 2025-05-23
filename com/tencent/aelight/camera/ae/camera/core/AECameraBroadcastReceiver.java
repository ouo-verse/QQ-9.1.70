package com.tencent.aelight.camera.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.troop.api.ITroopHWApi;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AECameraReceiver";
    private AEBaseCameraUnit captureUnit;

    public AECameraBroadcastReceiver(AEBaseCameraUnit aEBaseCameraUnit) {
        this.captureUnit = aEBaseCameraUnit;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity z16 = this.captureUnit.z();
        if (z16 == null || z16.isFinishing()) {
            return;
        }
        String action = intent.getAction();
        ms.a.a(TAG, "AECameraBroadcastReceiver onReceive: action = " + action);
        if (AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION.equals(action)) {
            if (this.captureUnit instanceof AEPituCameraUnit) {
                String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH);
                String stringExtra2 = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
                ms.a.a(TAG, "\u6536\u5230\u5e7f\u64ad: path = " + stringExtra + " agent = " + stringExtra2);
                ((AEPituCameraUnit) this.captureUnit).s1(stringExtra, stringExtra2);
                ((AEPituCameraUnit) this.captureUnit).t1();
                return;
            }
            return;
        }
        ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action);
    }
}
