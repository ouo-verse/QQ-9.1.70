package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ChangeFriendNameReq extends JceStruct {
    public String cstrName;
    public long uFriendUin;

    public ChangeFriendNameReq() {
        this.uFriendUin = 0L;
        this.cstrName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFriendUin = jceInputStream.read(this.uFriendUin, 0, true);
        this.cstrName = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFriendUin, 0);
        jceOutputStream.write(this.cstrName, 1);
    }

    public ChangeFriendNameReq(long j3, String str) {
        this.uFriendUin = j3;
        this.cstrName = str;
    }
}
