package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stAlbumAbiInfo extends JceStruct {
    public long dwFriendUin;

    public stAlbumAbiInfo() {
        this.dwFriendUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwFriendUin = jceInputStream.read(this.dwFriendUin, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwFriendUin, 0);
    }

    public stAlbumAbiInfo(long j3) {
        this.dwFriendUin = j3;
    }
}
