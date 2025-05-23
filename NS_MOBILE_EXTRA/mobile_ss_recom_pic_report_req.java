package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_ss_recom_pic_report_req extends JceStruct {

    /* renamed from: op, reason: collision with root package name */
    public byte f24977op;
    public long uin;

    public mobile_ss_recom_pic_report_req() {
        this.uin = 0L;
        this.f24977op = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.f24977op = jceInputStream.read(this.f24977op, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.f24977op, 1);
    }

    public mobile_ss_recom_pic_report_req(long j3, byte b16) {
        this.uin = j3;
        this.f24977op = b16;
    }
}
