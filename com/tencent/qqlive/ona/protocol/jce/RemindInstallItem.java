package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RemindInstallItem extends JceStruct {
    public int remindInstallType;
    public int remindTime;
    public String remindTitle;

    public RemindInstallItem() {
        this.remindInstallType = 0;
        this.remindTime = 0;
        this.remindTitle = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.remindInstallType = jceInputStream.read(this.remindInstallType, 0, false);
        this.remindTime = jceInputStream.read(this.remindTime, 1, false);
        this.remindTitle = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.remindInstallType, 0);
        jceOutputStream.write(this.remindTime, 1);
        String str = this.remindTitle;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public RemindInstallItem(int i3, int i16, String str) {
        this.remindInstallType = i3;
        this.remindTime = i16;
        this.remindTitle = str;
    }
}
