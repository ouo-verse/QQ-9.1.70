package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.face.FaceConstant;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class ReportTypeRsp extends JceStruct {
    public int retCode = 0;
    public String retMsg = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, false);
        this.retMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retCode, 0);
        String str = this.retMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }
}
