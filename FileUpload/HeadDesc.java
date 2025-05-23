package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HeadDesc extends JceStruct {
    public long portrait_type;
    public long skip_auth;
    public long uc_platform_qzone_subid;
    public String uid;

    public HeadDesc() {
        this.portrait_type = 0L;
        this.uc_platform_qzone_subid = 0L;
        this.uid = "";
        this.skip_auth = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.portrait_type = jceInputStream.read(this.portrait_type, 0, true);
        this.uc_platform_qzone_subid = jceInputStream.read(this.uc_platform_qzone_subid, 1, true);
        this.uid = jceInputStream.readString(2, false);
        this.skip_auth = jceInputStream.read(this.skip_auth, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.portrait_type, 0);
        jceOutputStream.write(this.uc_platform_qzone_subid, 1);
        String str = this.uid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.skip_auth, 3);
    }

    public HeadDesc(long j3, long j16, String str, long j17) {
        this.portrait_type = j3;
        this.uc_platform_qzone_subid = j16;
        this.uid = str;
        this.skip_auth = j17;
    }
}
