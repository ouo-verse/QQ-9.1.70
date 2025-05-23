package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

/* loaded from: classes20.dex */
public class VasIPCModule extends QIPCModule {
    public static final String NAME = "VasIPCModule";
    private static final String TAG = "VasIPCModule";
    private static VasIPCModule sInstance;

    VasIPCModule(String str) {
        super(str);
    }

    public static synchronized VasIPCModule getInstance() {
        VasIPCModule vasIPCModule;
        synchronized (VasIPCModule.class) {
            if (sInstance == null) {
                sInstance = new VasIPCModule("VasIPCModule");
            }
            vasIPCModule = sInstance;
        }
        return vasIPCModule;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("VasIPCModule", 2, "onCall action = " + str);
        }
        bundle.setClassLoader(BinderWarpper.class.getClassLoader());
        QLog.e("VasIPCModule", 1, "onCall missing action = " + str);
        return RemoteProxy.onCall(this, str, bundle, i3);
    }
}
