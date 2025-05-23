package com.tencent.sqshow.zootopia.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes34.dex */
public class PagSoLoaderBroadcastReceiver extends BroadcastReceiver {
    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        QLog.d("PagSoLoaderBroadcastReceiver", 1, "onReceive: action = " + action);
        if (AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION.equals(action)) {
            String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH);
            String stringExtra2 = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
            QLog.d("PagSoLoaderBroadcastReceiver", 1, "\u6536\u5230\u5e7f\u64ad: path = " + stringExtra + " agent = " + stringExtra2);
            if (AEResInfo.LIGHT_RES_PAG.agentType.equals(stringExtra2)) {
                PagLoader.c().h(IVasTempApi.INSTANCE.get().initPagSo());
                PagLoader.c().j();
            }
        }
    }
}
