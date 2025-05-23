package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_adapt_result extends JceStruct {
    public String albumid;
    public byte blocked;
    public byte deleted;
    public long owner;
    public String photoid;

    public st_adapt_result() {
        this.owner = 0L;
        this.albumid = "";
        this.photoid = "";
        this.blocked = (byte) 0;
        this.deleted = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owner = jceInputStream.read(this.owner, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.photoid = jceInputStream.readString(2, true);
        this.blocked = jceInputStream.read(this.blocked, 3, true);
        this.deleted = jceInputStream.read(this.deleted, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owner, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.photoid, 2);
        jceOutputStream.write(this.blocked, 3);
        jceOutputStream.write(this.deleted, 4);
    }

    public st_adapt_result(long j3, String str, String str2, byte b16, byte b17) {
        this.owner = j3;
        this.albumid = str;
        this.photoid = str2;
        this.blocked = b16;
        this.deleted = b17;
    }
}
