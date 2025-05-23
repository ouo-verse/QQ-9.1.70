package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanCameraImpl.class)
/* loaded from: classes34.dex */
public interface b {
    void onDestroyFaceCamera();

    void openFaceCamera();

    void openFilamentFaceCamera(int i3, ZootopiaSource zootopiaSource, String str);
}
