package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TNowBroadcastInfo extends JceStruct {
    static byte[] cache_vAnchorDataRsp;
    public int iFlag;
    public String strHrefURL;
    public String strIconURL;
    public byte[] vAnchorDataRsp;

    static {
        cache_vAnchorDataRsp = r0;
        byte[] bArr = {0};
    }

    public TNowBroadcastInfo() {
        this.iFlag = 0;
        this.strIconURL = "";
        this.strHrefURL = "";
        this.vAnchorDataRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFlag = jceInputStream.read(this.iFlag, 0, false);
        this.strIconURL = jceInputStream.readString(1, false);
        this.strHrefURL = jceInputStream.readString(2, false);
        this.vAnchorDataRsp = jceInputStream.read(cache_vAnchorDataRsp, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFlag, 0);
        String str = this.strIconURL;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strHrefURL;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        byte[] bArr = this.vAnchorDataRsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public TNowBroadcastInfo(int i3, String str, String str2, byte[] bArr) {
        this.iFlag = i3;
        this.strIconURL = str;
        this.strHrefURL = str2;
        this.vAnchorDataRsp = bArr;
    }
}
