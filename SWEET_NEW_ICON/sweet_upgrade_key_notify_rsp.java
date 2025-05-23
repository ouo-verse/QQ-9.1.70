package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_upgrade_key_notify_rsp extends JceStruct {
    public long host_state;
    public sweet_req_comm req_comm;
    public sweet_rsp_comm rsp_comm;
    static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
    static sweet_req_comm cache_req_comm = new sweet_req_comm();

    public sweet_upgrade_key_notify_rsp() {
        this.rsp_comm = null;
        this.req_comm = null;
        this.host_state = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_comm = (sweet_rsp_comm) jceInputStream.read((JceStruct) cache_rsp_comm, 0, true);
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 1, false);
        this.host_state = jceInputStream.read(this.host_state, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.rsp_comm, 0);
        sweet_req_comm sweet_req_commVar = this.req_comm;
        if (sweet_req_commVar != null) {
            jceOutputStream.write((JceStruct) sweet_req_commVar, 1);
        }
        jceOutputStream.write(this.host_state, 2);
    }

    public sweet_upgrade_key_notify_rsp(sweet_rsp_comm sweet_rsp_commVar, sweet_req_comm sweet_req_commVar, long j3) {
        this.rsp_comm = sweet_rsp_commVar;
        this.req_comm = sweet_req_commVar;
        this.host_state = j3;
    }
}
