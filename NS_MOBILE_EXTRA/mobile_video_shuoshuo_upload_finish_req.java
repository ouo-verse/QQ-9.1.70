package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_shuoshuo_upload_finish_req extends JceStruct {
    public long iSize;
    public long iTimeLength;

    public mobile_video_shuoshuo_upload_finish_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iSize = jceInputStream.read(this.iSize, 0, false);
        this.iTimeLength = jceInputStream.read(this.iTimeLength, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iSize, 0);
        jceOutputStream.write(this.iTimeLength, 1);
    }

    public mobile_video_shuoshuo_upload_finish_req(long j3, long j16) {
        this.iSize = j3;
        this.iTimeLength = j16;
    }
}
