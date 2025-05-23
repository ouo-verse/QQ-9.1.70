package PushAdMsg;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AdMsgInfo extends JceStruct {
    public String strMsgContent;
    public long uDstUin;
    public int uMsgType;
    public long uSrcUin;
    public long utime;

    public AdMsgInfo() {
        this.uSrcUin = 0L;
        this.uDstUin = 0L;
        this.utime = 0L;
        this.uMsgType = 0;
        this.strMsgContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uSrcUin = jceInputStream.read(this.uSrcUin, 1, true);
        this.uDstUin = jceInputStream.read(this.uDstUin, 2, true);
        this.utime = jceInputStream.read(this.utime, 3, true);
        this.uMsgType = jceInputStream.read(this.uMsgType, 4, true);
        this.strMsgContent = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uSrcUin, 1);
        jceOutputStream.write(this.uDstUin, 2);
        jceOutputStream.write(this.utime, 3);
        jceOutputStream.write(this.uMsgType, 4);
        jceOutputStream.write(this.strMsgContent, 5);
    }

    public AdMsgInfo(long j3, long j16, long j17, int i3, String str) {
        this.uSrcUin = j3;
        this.uDstUin = j16;
        this.utime = j17;
        this.uMsgType = i3;
        this.strMsgContent = str;
    }
}
