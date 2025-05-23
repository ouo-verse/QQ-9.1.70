package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommonRsp extends JceStruct {
    public int err;

    /* renamed from: msg, reason: collision with root package name */
    public String f25084msg;
    public int ret;

    public CommonRsp() {
        this.ret = 0;
        this.err = 0;
        this.f25084msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.err = jceInputStream.read(this.err, 1, false);
        this.f25084msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.err, 1);
        String str = this.f25084msg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public CommonRsp(int i3, int i16, String str) {
        this.ret = i3;
        this.err = i16;
        this.f25084msg = str;
    }
}
