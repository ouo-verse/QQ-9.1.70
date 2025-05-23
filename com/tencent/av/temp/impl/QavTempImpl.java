package com.tencent.av.temp.impl;

import com.tencent.av.so.ResMgr;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavTempImpl implements IQavTemp {
    @Override // com.tencent.av.temp.IQavTemp
    public String getAudio3ALicenseFilename() {
        return ResMgr.n();
    }

    @Override // com.tencent.av.temp.IQavTemp
    public boolean isVideoChatting(AppRuntime appRuntime) {
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) appRuntime).isVideoChatting();
        }
        return false;
    }
}
