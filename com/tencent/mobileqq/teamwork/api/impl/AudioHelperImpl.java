package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.teamwork.api.IAudioHelper;
import com.tencent.mobileqq.utils.QQAudioHelper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AudioHelperImpl implements IAudioHelper {
    @Override // com.tencent.mobileqq.teamwork.api.IAudioHelper
    public int getDebugValue(int i3) {
        return QQAudioHelper.c(i3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IAudioHelper
    public boolean isDev() {
        return QQAudioHelper.f();
    }

    @Override // com.tencent.mobileqq.teamwork.api.IAudioHelper
    public void writeTestLog(String str) {
        QQAudioHelper.w(str);
    }
}
