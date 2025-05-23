package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class RMFileEventNotify$1 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (QLog.isColorLevel()) {
            QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
        }
        QQToast.makeText(VideoEnvironment.getContext(), HardCodeUtil.qqStr(R.string.t1x), 1).show();
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        u16.k("RMFileEventNotify");
        g gVar = u16.Q;
        if (gVar != null) {
            gVar.Y();
        }
    }
}
