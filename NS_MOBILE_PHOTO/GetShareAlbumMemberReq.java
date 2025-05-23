package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class GetShareAlbumMemberReq extends JceStruct {
    public String albumid;
    public long uin;

    public GetShareAlbumMemberReq() {
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.albumid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetShareAlbumMemberReq(long j3, String str) {
        this.uin = j3;
        this.albumid = str;
    }
}
