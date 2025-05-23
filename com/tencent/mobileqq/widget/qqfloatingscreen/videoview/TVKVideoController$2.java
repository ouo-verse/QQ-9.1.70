package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes20.dex */
class TVKVideoController$2 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    }
}
