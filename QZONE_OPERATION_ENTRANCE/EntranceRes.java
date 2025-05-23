package QZONE_OPERATION_ENTRANCE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EntranceRes extends JceStruct {
    private static final long serialVersionUID = 0;
    public long expireTime;
    public int limitCount;
    public int loopCount;
    public int oper;
    public String resUrl;

    public EntranceRes() {
        this.resUrl = "";
        this.expireTime = 0L;
        this.oper = 0;
        this.limitCount = 0;
        this.loopCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.resUrl = jceInputStream.readString(0, false);
        this.expireTime = jceInputStream.read(this.expireTime, 1, false);
        this.oper = jceInputStream.read(this.oper, 2, false);
        this.limitCount = jceInputStream.read(this.limitCount, 3, false);
        this.loopCount = jceInputStream.read(this.loopCount, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.resUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.expireTime, 1);
        jceOutputStream.write(this.oper, 2);
        jceOutputStream.write(this.limitCount, 3);
        jceOutputStream.write(this.loopCount, 4);
    }

    public EntranceRes(String str, long j3, int i3, int i16, int i17) {
        this.resUrl = str;
        this.expireTime = j3;
        this.oper = i3;
        this.limitCount = i16;
        this.loopCount = i17;
    }
}
