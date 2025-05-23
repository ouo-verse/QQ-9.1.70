package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ac;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public class ScanQQAppInterfaceProcessor implements com.tencent.mobileqq.qrscan.d {
    @Override // com.tencent.mobileqq.qrscan.d
    public void a(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            ((QQAppInterface) appRuntime).setTalkbackSwitch();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public String getFriendDisplayNameJustCache(AppRuntime appRuntime, String str) {
        if (appRuntime instanceof QQAppInterface) {
            return ac.A((QQAppInterface) appRuntime, appRuntime.getCurrentAccountUin());
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public boolean isRingEqualsZero(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isRingEqualsZero();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public boolean isRingerSilent(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isRingerSilent();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public boolean isRingerVibrate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isRingerVibrate();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public boolean isVideoChatting(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isVideoChatting();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.d
    public void speak(String str) {
        QQAppInterface.speak(str);
    }
}
