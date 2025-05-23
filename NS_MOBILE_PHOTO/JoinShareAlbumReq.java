package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class JoinShareAlbumReq extends JceStruct {
    static int cache_mode;
    public AllowJoinShareAlbum allow_data;
    public ApplyJoinShareAlbum apply_data;
    public int mode;
    public long op_uin;
    static ApplyJoinShareAlbum cache_apply_data = new ApplyJoinShareAlbum();
    static AllowJoinShareAlbum cache_allow_data = new AllowJoinShareAlbum();

    public JoinShareAlbumReq() {
        this.op_uin = 0L;
        this.mode = 0;
        this.apply_data = null;
        this.allow_data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.mode = jceInputStream.read(this.mode, 1, false);
        this.apply_data = (ApplyJoinShareAlbum) jceInputStream.read((JceStruct) cache_apply_data, 2, false);
        this.allow_data = (AllowJoinShareAlbum) jceInputStream.read((JceStruct) cache_allow_data, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_uin, 0);
        jceOutputStream.write(this.mode, 1);
        ApplyJoinShareAlbum applyJoinShareAlbum = this.apply_data;
        if (applyJoinShareAlbum != null) {
            jceOutputStream.write((JceStruct) applyJoinShareAlbum, 2);
        }
        AllowJoinShareAlbum allowJoinShareAlbum = this.allow_data;
        if (allowJoinShareAlbum != null) {
            jceOutputStream.write((JceStruct) allowJoinShareAlbum, 3);
        }
    }

    public JoinShareAlbumReq(long j3, int i3, ApplyJoinShareAlbum applyJoinShareAlbum, AllowJoinShareAlbum allowJoinShareAlbum) {
        this.op_uin = j3;
        this.mode = i3;
        this.apply_data = applyJoinShareAlbum;
        this.allow_data = allowJoinShareAlbum;
    }
}
