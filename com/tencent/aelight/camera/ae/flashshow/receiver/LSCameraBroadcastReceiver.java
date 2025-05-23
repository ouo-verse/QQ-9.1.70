package com.tencent.aelight.camera.ae.flashshow.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import ms.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSCameraBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private LSBaseCameraUnit f64362a;

    public LSCameraBroadcastReceiver(LSBaseCameraUnit lSBaseCameraUnit) {
        this.f64362a = lSBaseCameraUnit;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity A = this.f64362a.A();
        if (A == null || A.isFinishing()) {
            return;
        }
        String action = intent.getAction();
        a.a("LSCameraBroadcastReceiver", "LSCameraBroadcastReceiver onReceive: action = " + action);
        if (AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION.equals(action)) {
            if (this.f64362a instanceof LSMiddleCameraUnit) {
                String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH);
                String stringExtra2 = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
                a.a("LSCameraBroadcastReceiver", "\u6536\u5230\u5e7f\u64ad: path = " + stringExtra + " agent = " + stringExtra2);
                ((LSMiddleCameraUnit) this.f64362a).j1(stringExtra, stringExtra2);
                if (!AEResInfo.LIGHT_RES_QNN_HTP_BUNDLE.agentType.equals(stringExtra2)) {
                    ((LSMiddleCameraUnit) this.f64362a).k1();
                }
                if (AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType.equals(stringExtra2)) {
                    ((LSMiddleCameraUnit) this.f64362a).i2();
                    return;
                }
                return;
            }
            return;
        }
        ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action);
    }
}
