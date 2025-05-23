package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_comm_cfg_get_req extends JceStruct {
    static sweet_req_comm cache_req_comm = new sweet_req_comm();
    static ArrayList<Integer> cache_vec_cfg = new ArrayList<>();
    public sweet_req_comm req_comm;
    public ArrayList<Integer> vec_cfg;

    static {
        cache_vec_cfg.add(0);
    }

    public sweet_comm_cfg_get_req() {
        this.req_comm = null;
        this.vec_cfg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 0, true);
        this.vec_cfg = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_cfg, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.req_comm, 0);
        jceOutputStream.write((Collection) this.vec_cfg, 1);
    }

    public sweet_comm_cfg_get_req(sweet_req_comm sweet_req_commVar, ArrayList<Integer> arrayList) {
        this.req_comm = sweet_req_commVar;
        this.vec_cfg = arrayList;
    }
}
