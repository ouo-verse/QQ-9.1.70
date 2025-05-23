package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_LikeUserInfo extends JceStruct {
    public long iLstQueryTime;
    public long iUin;
    public boolean isFriend;
    public String sNickName;

    public CKV_LikeUserInfo() {
        this.iUin = 0L;
        this.sNickName = "";
        this.isFriend = true;
        this.iLstQueryTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sNickName = jceInputStream.readString(1, false);
        this.isFriend = jceInputStream.read(this.isFriend, 2, false);
        this.iLstQueryTime = jceInputStream.read(this.iLstQueryTime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        String str = this.sNickName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.isFriend, 2);
        jceOutputStream.write(this.iLstQueryTime, 3);
    }

    public CKV_LikeUserInfo(long j3, String str, boolean z16, long j16) {
        this.iUin = j3;
        this.sNickName = str;
        this.isFriend = z16;
        this.iLstQueryTime = j16;
    }
}
