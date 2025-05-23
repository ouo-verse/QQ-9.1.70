package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.mobileqq.shortvideo.api.IVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoTrimmerImpl implements IVideoTrimmer {
    @Override // com.tencent.mobileqq.shortvideo.api.IVideoTrimmer
    public VideoConverterConfig getCompressConfig(String str) {
        return ShortVideoTrimmer.getCompressConfig(str);
    }
}
