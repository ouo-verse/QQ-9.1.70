package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetFiltPhotoListReq extends JceStruct {
    public String albumid;
    public String attach_info;
    public long batchid;
    public long filt_richflag;
    public long uin;

    public GetFiltPhotoListReq() {
        this.uin = 0L;
        this.albumid = "";
        this.batchid = 0L;
        this.filt_richflag = 0L;
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.albumid = jceInputStream.readString(1, false);
        this.batchid = jceInputStream.read(this.batchid, 2, false);
        this.filt_richflag = jceInputStream.read(this.filt_richflag, 3, false);
        this.attach_info = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.batchid, 2);
        jceOutputStream.write(this.filt_richflag, 3);
        String str2 = this.attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GetFiltPhotoListReq(long j3, String str, long j16, long j17, String str2) {
        this.uin = j3;
        this.albumid = str;
        this.batchid = j16;
        this.filt_richflag = j17;
        this.attach_info = str2;
    }
}
