package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class famous_user extends JceStruct {
    static s_user cache_user = new s_user();
    public boolean is_follow;
    public s_user user;

    public famous_user() {
        this.user = null;
        this.is_follow = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.is_follow = jceInputStream.read(this.is_follow, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        jceOutputStream.write(this.is_follow, 1);
    }

    public famous_user(s_user s_userVar, boolean z16) {
        this.user = s_userVar;
        this.is_follow = z16;
    }
}
