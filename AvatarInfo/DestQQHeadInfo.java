package AvatarInfo;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DestQQHeadInfo extends JceStruct implements Cloneable {
    public long dstUin;
    public long dwTimestamp;
    public String phoneNum;

    public DestQQHeadInfo() {
        this.dstUin = 0L;
        this.dwTimestamp = 0L;
        this.phoneNum = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.dstUin, "dstUin");
        jceDisplayer.display(this.dwTimestamp, "dwTimestamp");
        jceDisplayer.display(this.phoneNum, "phoneNum");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dstUin = jceInputStream.read(this.dstUin, 0, true);
        this.dwTimestamp = jceInputStream.read(this.dwTimestamp, 1, true);
        this.phoneNum = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dstUin, 0);
        jceOutputStream.write(this.dwTimestamp, 1);
        String str = this.phoneNum;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public DestQQHeadInfo(long j3, long j16, String str) {
        this.dstUin = j3;
        this.dwTimestamp = j16;
        this.phoneNum = str;
    }
}
