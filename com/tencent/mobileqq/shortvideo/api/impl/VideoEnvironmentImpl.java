package com.tencent.mobileqq.shortvideo.api.impl;

import android.content.Context;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.api.IVideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoEnvironmentImpl implements IVideoEnvironment {
    @Override // com.tencent.mobileqq.shortvideo.api.IVideoEnvironment
    public boolean checkAndLoadAVCodec() {
        return VideoEnvironment.checkAndLoadAVCodec();
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IVideoEnvironment
    public int getAVCodecVersion() {
        return VideoEnvironment.getAVCodecVersion();
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IVideoEnvironment
    public String getShortVideoSoLibName() {
        return VideoEnvironment.getShortVideoSoLibName();
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IVideoEnvironment
    public String getShortVideoSoPath(Context context) {
        return ShortVideoSoLoad.getShortVideoSoPath(context);
    }
}
