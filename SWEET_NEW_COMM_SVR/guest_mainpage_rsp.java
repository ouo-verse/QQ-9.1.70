package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class guest_mainpage_rsp extends JceStruct {
    static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
    public String jump_url;
    public sweet_rsp_comm rsp_comm;

    public guest_mainpage_rsp() {
        this.rsp_comm = null;
        this.jump_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_comm = (sweet_rsp_comm) jceInputStream.read((JceStruct) cache_rsp_comm, 0, true);
        this.jump_url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.rsp_comm, 0);
        String str = this.jump_url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public guest_mainpage_rsp(sweet_rsp_comm sweet_rsp_commVar, String str) {
        this.rsp_comm = sweet_rsp_commVar;
        this.jump_url = str;
    }
}
