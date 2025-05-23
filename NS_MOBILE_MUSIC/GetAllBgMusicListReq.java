package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAllBgMusicListReq extends JceStruct {
    public long host_uin;

    public GetAllBgMusicListReq() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.host_uin = jceInputStream.read(this.host_uin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.host_uin, 0);
    }

    public GetAllBgMusicListReq(long j3) {
        this.host_uin = j3;
    }
}
