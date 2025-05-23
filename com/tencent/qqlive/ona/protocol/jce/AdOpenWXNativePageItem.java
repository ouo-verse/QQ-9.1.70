package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdOpenWXNativePageItem extends JceStruct {
    public String businessType;
    public boolean disableDialog;
    public String extraInfo;

    public AdOpenWXNativePageItem() {
        this.businessType = "";
        this.extraInfo = "";
        this.disableDialog = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.businessType = jceInputStream.readString(0, false);
        this.extraInfo = jceInputStream.readString(1, false);
        this.disableDialog = jceInputStream.read(this.disableDialog, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.businessType;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.extraInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.disableDialog, 2);
    }

    public AdOpenWXNativePageItem(String str, String str2, boolean z16) {
        this.businessType = str;
        this.extraInfo = str2;
        this.disableDialog = z16;
    }
}
