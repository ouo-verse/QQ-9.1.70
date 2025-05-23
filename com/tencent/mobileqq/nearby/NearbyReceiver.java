package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendReceiver;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyReceiver extends QQBroadcastReceiver {
    @Override // mqq.app.QQBroadcastReceiver
    public String getModuleId() {
        return FaceConstant.NEARBY_MODULAR_MODULE_ID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        intent.setExtrasClassLoader(ScannerResultReceiver.class.getClassLoader());
        if (intent.getBooleanExtra(IMatchFriendReceiver.KEY_IS_FROM_MATCH_FRIEND, false)) {
            ((IMatchFriendReceiver) QRoute.api(IMatchFriendReceiver.class)).onReceive(appRuntime, context, intent);
            return;
        }
        if (appRuntime != 0 && (appRuntime instanceof INearbyAppInterface)) {
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("resultreceiver_nearbyfakeactivity");
            if (resultReceiver != null) {
                resultReceiver.send(0, new Bundle());
            }
            int intExtra = intent.getIntExtra("nearby_preload_from", 0);
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).preloadNearbyProcessSuc(appRuntime.getAccount());
            ((INearbyAppInterface) appRuntime).updatePerfState(1, intExtra);
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyReceiver", 2, "PRELOAD_NEARBY_PROCESS, " + appRuntime);
        }
    }
}
