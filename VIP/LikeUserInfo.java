package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LikeUserInfo extends JceStruct {
    public long iLikeNum;
    public long iUin;
    public boolean isFriend;
    public String sNickName;

    public LikeUserInfo() {
        this.iUin = 0L;
        this.sNickName = "";
        this.iLikeNum = 0L;
        this.isFriend = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 0, false);
        this.sNickName = jceInputStream.readString(1, false);
        this.iLikeNum = jceInputStream.read(this.iLikeNum, 2, false);
        this.isFriend = jceInputStream.read(this.isFriend, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 0);
        String str = this.sNickName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iLikeNum, 2);
        jceOutputStream.write(this.isFriend, 3);
    }

    public LikeUserInfo(long j3, String str, long j16, boolean z16) {
        this.iUin = j3;
        this.sNickName = str;
        this.iLikeNum = j16;
        this.isFriend = z16;
    }
}
