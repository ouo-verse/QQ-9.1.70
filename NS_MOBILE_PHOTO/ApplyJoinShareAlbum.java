package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class ApplyJoinShareAlbum extends JceStruct {
    public String albumid;
    public long owner;

    public ApplyJoinShareAlbum() {
        this.owner = 0L;
        this.albumid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owner = jceInputStream.read(this.owner, 0, false);
        this.albumid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owner, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ApplyJoinShareAlbum(long j3, String str) {
        this.owner = j3;
        this.albumid = str;
    }
}
