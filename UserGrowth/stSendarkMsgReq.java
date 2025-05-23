package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSendarkMsgReq extends JceStruct {
    public static final String WNS_COMMAND = "SendarkMsg";
    static stArkInfo cache_ark = new stArkInfo();
    public int msgType = 0;
    public long groupCode = 0;
    public long receiveUin = 0;
    public stArkInfo ark = null;
    public String sharePid = "";
    public String shareFeedid = "";
    public int shareType = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.msgType = jceInputStream.read(this.msgType, 0, false);
        this.groupCode = jceInputStream.read(this.groupCode, 1, false);
        this.receiveUin = jceInputStream.read(this.receiveUin, 2, false);
        this.ark = (stArkInfo) jceInputStream.read((JceStruct) cache_ark, 3, false);
        this.sharePid = jceInputStream.readString(4, false);
        this.shareFeedid = jceInputStream.readString(5, false);
        this.shareType = jceInputStream.read(this.shareType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.msgType, 0);
        jceOutputStream.write(this.groupCode, 1);
        jceOutputStream.write(this.receiveUin, 2);
        stArkInfo starkinfo = this.ark;
        if (starkinfo != null) {
            jceOutputStream.write((JceStruct) starkinfo, 3);
        }
        String str = this.sharePid;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.shareFeedid;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.shareType, 6);
    }
}
