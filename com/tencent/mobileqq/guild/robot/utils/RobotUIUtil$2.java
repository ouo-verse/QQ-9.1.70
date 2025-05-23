package com.tencent.mobileqq.guild.robot.utils;

import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes14.dex */
class RobotUIUtil$2 extends TimerTask {
    RobotUIUtil$2() {
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(0, 2);
        }
    }
}
