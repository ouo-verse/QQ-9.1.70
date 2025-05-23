package com.tencent.upload.uinterface.data;

import NS_COMM_UPLOAD_PROTOCOL.CUploadDownstream;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioStreamUploadResult extends JceStruct {
    static CUploadDownstream cache_rsp = new CUploadDownstream();
    public String filePath;
    public CUploadDownstream rsp;

    public AudioStreamUploadResult() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp = (CUploadDownstream) jceInputStream.read((JceStruct) cache_rsp, 0, false);
        this.filePath = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CUploadDownstream cUploadDownstream = this.rsp;
        if (cUploadDownstream != null) {
            jceOutputStream.write((JceStruct) cUploadDownstream, 0);
        }
        String str = this.filePath;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public AudioStreamUploadResult(CUploadDownstream cUploadDownstream, String str) {
        this.rsp = cUploadDownstream;
        this.filePath = str;
    }
}
