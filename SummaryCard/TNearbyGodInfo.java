package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TNearbyGodInfo extends JceStruct {
    public int iIsGodFlag;
    public String strJumpUrl;

    public TNearbyGodInfo() {
        this.iIsGodFlag = 0;
        this.strJumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIsGodFlag = jceInputStream.read(this.iIsGodFlag, 0, false);
        this.strJumpUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIsGodFlag, 0);
        String str = this.strJumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public TNearbyGodInfo(int i3, String str) {
        this.iIsGodFlag = i3;
        this.strJumpUrl = str;
    }
}
