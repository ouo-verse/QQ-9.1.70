package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class C2CMsgReadedNotify extends JceStruct {
    public long lBindedUin;
    public long lFlag;
    public long lLastReadTime;
    public long lLastReadTime_qms;
    public long lPeerUin;
    public String strPhoneNum;
    public long uAioType;
    public long uint64_to_tiny_id;

    public C2CMsgReadedNotify() {
        this.lPeerUin = 0L;
        this.lLastReadTime = 0L;
        this.lFlag = 0L;
        this.strPhoneNum = "";
        this.lBindedUin = 0L;
        this.lLastReadTime_qms = 0L;
        this.uAioType = 0L;
        this.uint64_to_tiny_id = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lPeerUin = jceInputStream.read(this.lPeerUin, 0, false);
        this.lLastReadTime = jceInputStream.read(this.lLastReadTime, 1, false);
        this.lFlag = jceInputStream.read(this.lFlag, 2, false);
        this.strPhoneNum = jceInputStream.readString(3, false);
        this.lBindedUin = jceInputStream.read(this.lBindedUin, 4, false);
        this.lLastReadTime_qms = jceInputStream.read(this.lLastReadTime_qms, 5, false);
        this.uAioType = jceInputStream.read(this.uAioType, 6, false);
        this.uint64_to_tiny_id = jceInputStream.read(this.uint64_to_tiny_id, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lPeerUin, 0);
        jceOutputStream.write(this.lLastReadTime, 1);
        jceOutputStream.write(this.lFlag, 2);
        String str = this.strPhoneNum;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.lBindedUin, 4);
        jceOutputStream.write(this.lLastReadTime_qms, 5);
        jceOutputStream.write(this.uAioType, 6);
        jceOutputStream.write(this.uint64_to_tiny_id, 7);
    }

    public C2CMsgReadedNotify(long j3, long j16, long j17, String str, long j18, long j19, long j26, long j27) {
        this.lPeerUin = j3;
        this.lLastReadTime = j16;
        this.lFlag = j17;
        this.strPhoneNum = str;
        this.lBindedUin = j18;
        this.lLastReadTime_qms = j19;
        this.uAioType = j26;
        this.uint64_to_tiny_id = j27;
    }
}
