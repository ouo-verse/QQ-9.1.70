package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WalletSkinReq extends JceStruct {
    public static final int SKINID_DEFAULT = 1;
    public static final int TYPE_CLOSE = 2;
    public static final int TYPE_GET = 0;
    public static final int TYPE_OPEN = 1;
    public long uin = 0;
    public int type = 0;
    public int skinID = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.skinID = jceInputStream.read(this.skinID, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.skinID, 2);
    }
}
