package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResInfo extends JceStruct {
    public int iResId = 0;
    public int iSize = 0;
    public int iVersion = 0;
    public boolean bDownload = false;
    public String sResId = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iResId = jceInputStream.read(this.iResId, 0, false);
        this.iSize = jceInputStream.read(this.iSize, 1, false);
        this.iVersion = jceInputStream.read(this.iVersion, 2, false);
        this.bDownload = jceInputStream.read(this.bDownload, 3, false);
        this.sResId = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "ResInfo{iResId=" + this.iResId + ", iSize='" + this.iSize + ", sResId='" + this.sResId + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iResId, 0);
        jceOutputStream.write(this.iSize, 1);
        jceOutputStream.write(this.iVersion, 2);
        jceOutputStream.write(this.bDownload, 3);
        String str = this.sResId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
