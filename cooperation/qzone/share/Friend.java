package cooperation.qzone.share;

/* compiled from: P */
/* loaded from: classes38.dex */
public class Friend {
    public String mName;
    public String mNickName;
    public String mRemark;
    public long mUin;
    public String uinKey;
    public int vipLevel;
    public int who;

    public Friend(long j3, String str, String str2, String str3, int i3, String str4) {
        this.vipLevel = -1;
        this.mUin = j3;
        this.mName = str;
        this.mNickName = str2;
        this.mRemark = str3;
        this.who = i3;
        this.uinKey = str4;
    }

    public Friend() {
        this.mUin = -1L;
        this.mName = "";
        this.mNickName = "";
        this.mRemark = "";
        this.vipLevel = -1;
        this.who = 0;
        this.uinKey = "";
    }
}
