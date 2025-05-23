package com.qzone.publish.business.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadAudioFileResponse extends JceStruct {
    public int audioLength;
    public String path;
    public String voice_id;

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.path, "path");
        jceDisplayer.display(this.voice_id, QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID);
        jceDisplayer.display(this.audioLength, "audioLength");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.path = jceInputStream.read(this.path, 0, false);
        this.voice_id = jceInputStream.read(this.voice_id, 1, false);
        this.audioLength = jceInputStream.read(this.audioLength, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.path, 0);
        jceOutputStream.write(this.voice_id, 1);
        jceOutputStream.write(this.audioLength, 2);
    }
}
