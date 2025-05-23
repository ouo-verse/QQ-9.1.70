package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class active_photo extends JceStruct {
    public String albumid;
    public String desc;
    public String photoid;
    public String title;

    public active_photo() {
        this.albumid = "";
        this.photoid = "";
        this.title = "";
        this.desc = "";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof active_photo)) {
            return false;
        }
        active_photo active_photoVar = (active_photo) obj;
        if (!active_photoVar.albumid.equals(this.albumid) || !active_photoVar.photoid.equals(this.photoid) || !active_photoVar.title.equals(this.title) || !active_photoVar.desc.equals(this.desc)) {
            return false;
        }
        return true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, true);
        this.photoid = jceInputStream.readString(1, true);
        this.title = jceInputStream.readString(2, true);
        this.desc = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.albumid, 0);
        jceOutputStream.write(this.photoid, 1);
        jceOutputStream.write(this.title, 2);
        jceOutputStream.write(this.desc, 3);
    }

    public active_photo(String str, String str2, String str3, String str4) {
        this.albumid = str;
        this.photoid = str2;
        this.title = str3;
        this.desc = str4;
    }
}
