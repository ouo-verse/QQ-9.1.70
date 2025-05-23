package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetLastLoginInfoReq extends JceStruct {
    static LastLoginPageInfo cache_stPageInfo;
    public LastLoginPageInfo stPageInfo;
    public long uin;

    public GetLastLoginInfoReq() {
        this.uin = 0L;
        this.stPageInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        if (cache_stPageInfo == null) {
            cache_stPageInfo = new LastLoginPageInfo();
        }
        this.stPageInfo = (LastLoginPageInfo) jceInputStream.read((JceStruct) cache_stPageInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        LastLoginPageInfo lastLoginPageInfo = this.stPageInfo;
        if (lastLoginPageInfo != null) {
            jceOutputStream.write((JceStruct) lastLoginPageInfo, 1);
        }
    }

    public GetLastLoginInfoReq(long j3, LastLoginPageInfo lastLoginPageInfo) {
        this.uin = j3;
        this.stPageInfo = lastLoginPageInfo;
    }
}
