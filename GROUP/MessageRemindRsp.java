package GROUP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MessageRemindRsp extends JceStruct {
    public int eNowLevel;
    public int eRemindLevel;
    public int iFreezedType;
    public long iGroupExpiredTime;
    public int iGroupType;
    public int iLhGroupExpiredTime;
    public long iNextReqTime;
    public long iSVIPExpiredTime;
    public int iUserRole;
    public boolean isFreezed;

    public MessageRemindRsp() {
        this.iGroupExpiredTime = 0L;
        this.iSVIPExpiredTime = 0L;
        this.iNextReqTime = 0L;
        this.eRemindLevel = 0;
        this.eNowLevel = 0;
        this.isFreezed = true;
        this.iUserRole = 0;
        this.iFreezedType = 0;
        this.iLhGroupExpiredTime = 0;
        this.iGroupType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iGroupExpiredTime = jceInputStream.read(this.iGroupExpiredTime, 0, true);
        this.iSVIPExpiredTime = jceInputStream.read(this.iSVIPExpiredTime, 1, false);
        this.iNextReqTime = jceInputStream.read(this.iNextReqTime, 2, false);
        this.eRemindLevel = jceInputStream.read(this.eRemindLevel, 3, false);
        this.eNowLevel = jceInputStream.read(this.eNowLevel, 4, false);
        this.isFreezed = jceInputStream.read(this.isFreezed, 5, false);
        this.iUserRole = jceInputStream.read(this.iUserRole, 6, false);
        this.iFreezedType = jceInputStream.read(this.iFreezedType, 7, false);
        this.iLhGroupExpiredTime = jceInputStream.read(this.iLhGroupExpiredTime, 8, false);
        this.iGroupType = jceInputStream.read(this.iGroupType, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iGroupExpiredTime, 0);
        jceOutputStream.write(this.iSVIPExpiredTime, 1);
        jceOutputStream.write(this.iNextReqTime, 2);
        jceOutputStream.write(this.eRemindLevel, 3);
        jceOutputStream.write(this.eNowLevel, 4);
        jceOutputStream.write(this.isFreezed, 5);
        jceOutputStream.write(this.iUserRole, 6);
        jceOutputStream.write(this.iFreezedType, 7);
        jceOutputStream.write(this.iLhGroupExpiredTime, 8);
        jceOutputStream.write(this.iGroupType, 9);
    }

    public MessageRemindRsp(long j3, long j16, long j17, int i3, int i16, boolean z16, int i17, int i18, int i19, int i26) {
        this.iGroupExpiredTime = j3;
        this.iSVIPExpiredTime = j16;
        this.iNextReqTime = j17;
        this.eRemindLevel = i3;
        this.eNowLevel = i16;
        this.isFreezed = z16;
        this.iUserRole = i17;
        this.iFreezedType = i18;
        this.iLhGroupExpiredTime = i19;
        this.iGroupType = i26;
    }
}
