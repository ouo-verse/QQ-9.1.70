package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_user extends JceStruct {
    public boolean isSuperLike;
    public String nickname;
    public long uin;

    public s_user() {
        this.uin = 0L;
        this.nickname = "";
        this.isSuperLike = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.isSuperLike = jceInputStream.read(this.isSuperLike, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.isSuperLike, 2);
    }

    public s_user(long j3, String str, boolean z16) {
        this.uin = j3;
        this.nickname = str;
        this.isSuperLike = z16;
    }
}
