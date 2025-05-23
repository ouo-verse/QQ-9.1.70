package com.tencent.aelight.camera.ae.flashshow.util;

import com.tencent.qphone.base.util.BaseApplication;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r {
    public static int a() {
        return 6 - OfflineConfig.getPhonePerfLevel(BaseApplication.context);
    }
}
