package com.tencent.av;

import com.tencent.avcore.jni.codec.AndroidCodecAdapterProxy;
import com.tencent.avcore.util.AVCoreLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m {
    public static void a() {
        if (!AVCoreLog.isInit()) {
            AVCoreLog.init(new a());
        }
        if (!AndroidCodecAdapterProxy.getInstance().isInit()) {
            AndroidCodecAdapterProxy.getInstance().init(new tu.a());
        }
        com.tencent.avcore.camera.thread.b.b(new com.tencent.av.camera.d());
    }
}
