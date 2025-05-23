package protocol.GrayVersion;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ApplyResp extends JceStruct {
    public long appid;
    public String error_msg;
    public int ret;
    public long total_gray_uin;
    public long uin;

    public ApplyResp() {
        this.appid = 0L;
        this.uin = 0L;
        this.total_gray_uin = 0L;
        this.ret = 0;
        this.error_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.total_gray_uin = jceInputStream.read(this.total_gray_uin, 2, true);
        this.ret = jceInputStream.read(this.ret, 3, true);
        this.error_msg = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.total_gray_uin, 2);
        jceOutputStream.write(this.ret, 3);
        String str = this.error_msg;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public ApplyResp(long j3, long j16, long j17, int i3, String str) {
        this.appid = j3;
        this.uin = j16;
        this.total_gray_uin = j17;
        this.ret = i3;
        this.error_msg = str;
    }
}
