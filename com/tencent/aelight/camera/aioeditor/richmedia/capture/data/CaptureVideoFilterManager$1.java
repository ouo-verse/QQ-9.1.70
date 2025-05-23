package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
class CaptureVideoFilterManager$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.l(true);
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
        }
    }
}
