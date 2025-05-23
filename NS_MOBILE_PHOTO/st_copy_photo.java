package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_copy_photo extends JceStruct {
    public String albumid;
    public long owneruin;
    public String photoid;

    public st_copy_photo() {
        this.owneruin = 0L;
        this.albumid = "";
        this.photoid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owneruin = jceInputStream.read(this.owneruin, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.photoid = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owneruin, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.photoid, 2);
    }

    public st_copy_photo(long j3, String str, String str2) {
        this.owneruin = j3;
        this.albumid = str;
        this.photoid = str2;
    }
}
