package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_comm_cfg_get_rsp extends JceStruct {
    public Map<Long, sweet_comm_cfg_item> m_cfg_res;
    public sweet_rsp_comm rsp_comm;
    static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
    static Map<Long, sweet_comm_cfg_item> cache_m_cfg_res = new HashMap();

    static {
        cache_m_cfg_res.put(0L, new sweet_comm_cfg_item());
    }

    public sweet_comm_cfg_get_rsp() {
        this.rsp_comm = null;
        this.m_cfg_res = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_comm = (sweet_rsp_comm) jceInputStream.read((JceStruct) cache_rsp_comm, 0, true);
        this.m_cfg_res = (Map) jceInputStream.read((JceInputStream) cache_m_cfg_res, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.rsp_comm, 0);
        jceOutputStream.write((Map) this.m_cfg_res, 1);
    }

    public sweet_comm_cfg_get_rsp(sweet_rsp_comm sweet_rsp_commVar, Map<Long, sweet_comm_cfg_item> map) {
        this.rsp_comm = sweet_rsp_commVar;
        this.m_cfg_res = map;
    }
}
