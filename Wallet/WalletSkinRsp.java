package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WalletSkinRsp extends JceStruct {
    public static final int STATUS_CLOSE = 0;
    public static final int STATUS_OPEN = 1;
    public long uin = 0;
    public int skinID = 0;
    public String zipUrl = "";
    public String zipMd5 = "";
    public int status = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.skinID = jceInputStream.read(this.skinID, 1, false);
        this.zipUrl = jceInputStream.readString(2, false);
        this.zipMd5 = jceInputStream.readString(3, false);
        this.status = jceInputStream.read(this.status, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "WalletSkinRsp{uin=" + this.uin + ", skinID=" + this.skinID + ", zipUrl='" + this.zipUrl + "', zipMd5='" + this.zipMd5 + "', status=" + this.status + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.skinID, 1);
        String str = this.zipUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.zipMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.status, 4);
    }
}
