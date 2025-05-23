package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FocusMpIdReq extends JceStruct {
    public String mp_id;
    public String uin;

    public FocusMpIdReq() {
        this.uin = "";
        this.mp_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, false);
        this.mp_id = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.mp_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public FocusMpIdReq(String str, String str2) {
        this.uin = str;
        this.mp_id = str2;
    }
}
