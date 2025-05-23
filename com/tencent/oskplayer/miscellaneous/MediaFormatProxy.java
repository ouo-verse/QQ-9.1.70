package com.tencent.oskplayer.miscellaneous;

import android.media.MediaFormat;

/* loaded from: classes22.dex */
public class MediaFormatProxy {
    public MediaFormat videoFormat;
    public int videoTrack;

    public MediaFormatProxy(MediaFormat mediaFormat, int i3) {
        this.videoFormat = mediaFormat;
        this.videoTrack = i3;
    }

    public static MediaFormatProxy create(MediaFormat mediaFormat, int i3) {
        return new MediaFormatProxy(mediaFormat, i3);
    }
}
