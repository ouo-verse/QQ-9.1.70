package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_videoflow_user extends JceStruct {
    static s_user cache_user = new s_user();
    public long follower_count;
    public long following_count;
    public boolean is_followed;
    public boolean is_following;
    public s_user user;

    public s_videoflow_user() {
        this.user = null;
        this.is_followed = false;
        this.is_following = false;
        this.follower_count = 0L;
        this.following_count = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, true);
        this.is_followed = jceInputStream.read(this.is_followed, 1, true);
        this.is_following = jceInputStream.read(this.is_following, 2, false);
        this.follower_count = jceInputStream.read(this.follower_count, 3, false);
        this.following_count = jceInputStream.read(this.following_count, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.user, 0);
        jceOutputStream.write(this.is_followed, 1);
        jceOutputStream.write(this.is_following, 2);
        jceOutputStream.write(this.follower_count, 3);
        jceOutputStream.write(this.following_count, 4);
    }

    public s_videoflow_user(s_user s_userVar, boolean z16, boolean z17, long j3, long j16) {
        this.user = s_userVar;
        this.is_followed = z16;
        this.is_following = z17;
        this.follower_count = j3;
        this.following_count = j16;
    }
}
