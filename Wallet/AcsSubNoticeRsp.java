package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsSubNoticeRsp extends JceStruct {
    static AcsMsg cache_msg = new AcsMsg();
    public String err_str;

    /* renamed from: msg, reason: collision with root package name */
    public AcsMsg f25141msg;
    public int ret_code;

    public AcsSubNoticeRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.f25141msg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.f25141msg = (AcsMsg) jceInputStream.read((JceStruct) cache_msg, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        AcsMsg acsMsg = this.f25141msg;
        if (acsMsg != null) {
            jceOutputStream.write((JceStruct) acsMsg, 2);
        }
    }

    public AcsSubNoticeRsp(int i3, String str, AcsMsg acsMsg) {
        this.ret_code = i3;
        this.err_str = str;
        this.f25141msg = acsMsg;
    }
}
