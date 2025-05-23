package SWEET_NEW_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_rsp_comm extends JceStruct {
    public String errmsg;
    public int retcode;

    public sweet_rsp_comm() {
        this.retcode = 0;
        this.errmsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retcode = jceInputStream.read(this.retcode, 0, true);
        this.errmsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retcode, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public sweet_rsp_comm(int i3, String str) {
        this.retcode = i3;
        this.errmsg = str;
    }
}
