package com.tencent.mobileqq.qqlive.api.av;

import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UserVolumeInfo {
    public final String userId;
    public final int volume;

    public UserVolumeInfo(String str, int i3) {
        this.userId = str;
        this.volume = i3;
    }

    public static UserVolumeInfo parse(RemoteUserAudioInfo remoteUserAudioInfo) {
        return new UserVolumeInfo(remoteUserAudioInfo.userId, remoteUserAudioInfo.volume);
    }
}
