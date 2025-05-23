package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AllowJoinShareAlbumData extends JceStruct {
    public String albumid;
    public long joiner;
    public long owner;

    public AllowJoinShareAlbumData() {
        this.joiner = 0L;
        this.owner = 0L;
        this.albumid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.joiner = jceInputStream.read(this.joiner, 0, false);
        this.owner = jceInputStream.read(this.owner, 1, false);
        this.albumid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.joiner, 0);
        jceOutputStream.write(this.owner, 1);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public AllowJoinShareAlbumData(long j3, long j16, String str) {
        this.joiner = j3;
        this.owner = j16;
        this.albumid = str;
    }
}
