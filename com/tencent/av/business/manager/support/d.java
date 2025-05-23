package com.tencent.av.business.manager.support;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends b {
    public d(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
    }

    private static boolean f() {
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            return false;
        }
        return model.equals("MI 5");
    }

    private boolean g() {
        if (f()) {
            return true;
        }
        if (this.f73448a < 17) {
            AVCoreLog.printColorLog("SupportPendant", "isUserEffectFace error  OSversion:" + this.f73448a);
            return false;
        }
        if (this.f73450c < 4) {
            AVCoreLog.printColorLog("SupportPendant", "isUserEffectFace error cpucount:" + this.f73450c);
            return false;
        }
        long j3 = this.f73449b;
        if (j3 != 0 && j3 < 1400000) {
            AVCoreLog.printColorLog("SupportPendant", "isUserEffectFace error cpuFrequency:" + this.f73449b);
            return false;
        }
        if (this.f73451d >= 1073741824) {
            return true;
        }
        AVCoreLog.printColorLog("SupportPendant", "isUserEffectFace error  memory:" + this.f73451d);
        return false;
    }

    @Override // com.tencent.av.business.manager.support.b
    public boolean a(String str) {
        return g();
    }

    @Override // com.tencent.av.business.manager.support.b
    public boolean c(int i3, String str) {
        return false;
    }

    @Override // com.tencent.av.business.manager.support.b
    public void d() {
    }

    @Override // com.tencent.av.business.manager.support.b
    public void e() {
    }
}
