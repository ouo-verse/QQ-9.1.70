package com.tencent.biz.qcircleshadow.local;

import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;

/* loaded from: classes4.dex */
public class QCirclePluginShadowService extends PluginProcessService {
    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
        } catch (Exception e16) {
            QLog.d("ASDynamicEngine", 1, e16.getMessage());
        }
    }
}
