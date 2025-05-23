package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LastLoginInfo extends JceStruct {
    public static final long TYPE_LONG_OFFLINE = 20;
    public static final long TYPE_OFFLINE = 10;
    public static final long TYPE_OFFLINE_TO_LEAVE_MSG = 1;
    public long dwClient;
    public long dwFriendUin;
    public long dwLastLoginType;

    public LastLoginInfo() {
        this.dwFriendUin = 0L;
        this.dwLastLoginType = 0L;
        this.dwClient = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwFriendUin = jceInputStream.read(this.dwFriendUin, 0, false);
        this.dwLastLoginType = jceInputStream.read(this.dwLastLoginType, 1, false);
        this.dwClient = jceInputStream.read(this.dwClient, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwFriendUin, 0);
        jceOutputStream.write(this.dwLastLoginType, 1);
        jceOutputStream.write(this.dwClient, 2);
    }

    public LastLoginInfo(long j3, long j16, long j17) {
        this.dwFriendUin = j3;
        this.dwLastLoginType = j16;
        this.dwClient = j17;
    }
}
