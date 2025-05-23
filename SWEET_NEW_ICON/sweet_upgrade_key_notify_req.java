package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_upgrade_key_notify_req extends JceStruct {
    static sweet_req_comm cache_req_comm = new sweet_req_comm();
    public sweet_req_comm req_comm;

    public sweet_upgrade_key_notify_req() {
        this.req_comm = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.req_comm, 0);
    }

    public sweet_upgrade_key_notify_req(sweet_req_comm sweet_req_commVar) {
        this.req_comm = sweet_req_commVar;
    }
}
