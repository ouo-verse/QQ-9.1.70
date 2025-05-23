package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class lighting_sweet_key_req extends JceStruct {
    static sweet_req_comm cache_req_comm = new sweet_req_comm();
    public boolean is_reset_data;
    public sweet_req_comm req_comm;

    public lighting_sweet_key_req() {
        this.req_comm = null;
        this.is_reset_data = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 0, true);
        this.is_reset_data = jceInputStream.read(this.is_reset_data, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.req_comm, 0);
        jceOutputStream.write(this.is_reset_data, 1);
    }

    public lighting_sweet_key_req(sweet_req_comm sweet_req_commVar, boolean z16) {
        this.req_comm = sweet_req_commVar;
        this.is_reset_data = z16;
    }
}
