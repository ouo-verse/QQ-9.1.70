package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdEpisodeVideoInfo extends JceStruct {
    static int cache_videoOrientation;
    public int videoOrientation;

    public AdEpisodeVideoInfo() {
        this.videoOrientation = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.videoOrientation = jceInputStream.read(this.videoOrientation, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.videoOrientation, 0);
    }

    public AdEpisodeVideoInfo(int i3) {
        this.videoOrientation = i3;
    }
}
