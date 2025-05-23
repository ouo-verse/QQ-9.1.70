package com.tencent.mobileqq.zplan.cc.util;

import com.tencent.mobileqq.zplan.cc.camera.CameraIndex;
import com.tencent.mobileqq.zplan.cc.camera.a;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d implements a.c {
    @Override // com.tencent.mobileqq.zplan.cc.camera.a.c
    public void a(float f16) {
        QLog.i("ZPlanCamera", 1, "onPreviewSizeChanged, camera ratio = " + f16);
    }

    @Override // com.tencent.mobileqq.zplan.cc.camera.a.c
    public void b(CameraIndex cameraIndex) {
        QLog.i("ZPlanCamera", 1, "camera " + cameraIndex + " init failed");
    }
}
