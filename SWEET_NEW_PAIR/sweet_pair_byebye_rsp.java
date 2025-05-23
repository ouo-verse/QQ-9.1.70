package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_pair_byebye_rsp extends JceStruct {
    static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
    public sweet_rsp_comm rsp_comm;

    public sweet_pair_byebye_rsp() {
        this.rsp_comm = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_comm = (sweet_rsp_comm) jceInputStream.read((JceStruct) cache_rsp_comm, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.rsp_comm, 0);
    }

    public sweet_pair_byebye_rsp(sweet_rsp_comm sweet_rsp_commVar) {
        this.rsp_comm = sweet_rsp_commVar;
    }
}
