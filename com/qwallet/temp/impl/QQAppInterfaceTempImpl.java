package com.qwallet.temp.impl;

import com.qwallet.temp.IQQAppInterfaceTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QQAppInterfaceTempImpl implements IQQAppInterfaceTemp {
    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public int getALLGeneralSettingRing(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).getALLGeneralSettingRing();
        }
        return 1;
    }

    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public int getALLGeneralSettingVibrate(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).getALLGeneralSettingVibrate();
        }
        return 1;
    }

    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public boolean isPttRecordingOrPlaying(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).isPttRecordingOrPlaying();
        }
        return false;
    }

    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public boolean isRingerSilent(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).isRingerSilent();
        }
        return false;
    }

    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public boolean isVideoChatting(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).isVideoChatting();
        }
        return false;
    }

    @Override // com.qwallet.temp.IQQAppInterfaceTemp
    public void refreshAppBadge(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            ((IAppBadgeService) appRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }
}
