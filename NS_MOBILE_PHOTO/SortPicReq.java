package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SortPicReq extends JceStruct {
    static int cache_sort_type;
    public String albumid;
    public int sort_type;
    public long uin;

    public SortPicReq() {
        this.uin = 0L;
        this.albumid = "";
        this.sort_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.albumid = jceInputStream.readString(1, false);
        this.sort_type = jceInputStream.read(this.sort_type, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.sort_type, 2);
    }

    public SortPicReq(long j3, String str, int i3) {
        this.uin = j3;
        this.albumid = str;
        this.sort_type = i3;
    }
}
