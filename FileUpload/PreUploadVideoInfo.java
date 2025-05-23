package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PreUploadVideoInfo extends JceStruct {
    static UploadVideoInfoReq cache_videoInfoReq = new UploadVideoInfoReq();
    public String seq;
    public String session;
    public UploadVideoInfoReq videoInfoReq;

    public PreUploadVideoInfo() {
        this.seq = "";
        this.session = "";
        this.videoInfoReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.seq = jceInputStream.readString(0, true);
        this.session = jceInputStream.readString(1, true);
        this.videoInfoReq = (UploadVideoInfoReq) jceInputStream.read((JceStruct) cache_videoInfoReq, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.seq, 0);
        jceOutputStream.write(this.session, 1);
        jceOutputStream.write((JceStruct) this.videoInfoReq, 2);
    }

    public PreUploadVideoInfo(String str, String str2, UploadVideoInfoReq uploadVideoInfoReq) {
        this.seq = str;
        this.session = str2;
        this.videoInfoReq = uploadVideoInfoReq;
    }
}
