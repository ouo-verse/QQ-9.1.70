package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_pair_check_req extends JceStruct {
    static sweet_req_comm cache_req_comm = new sweet_req_comm();
    public boolean check_qqfriend;
    public boolean need_check_visit_right;
    public boolean need_get_invite_lst;
    public sweet_req_comm req_comm;

    public sweet_pair_check_req() {
        this.req_comm = null;
        this.need_check_visit_right = false;
        this.need_get_invite_lst = false;
        this.check_qqfriend = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 0, true);
        this.need_check_visit_right = jceInputStream.read(this.need_check_visit_right, 1, false);
        this.need_get_invite_lst = jceInputStream.read(this.need_get_invite_lst, 2, false);
        this.check_qqfriend = jceInputStream.read(this.check_qqfriend, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.req_comm, 0);
        jceOutputStream.write(this.need_check_visit_right, 1);
        jceOutputStream.write(this.need_get_invite_lst, 2);
        jceOutputStream.write(this.check_qqfriend, 3);
    }

    public sweet_pair_check_req(sweet_req_comm sweet_req_commVar, boolean z16, boolean z17, boolean z18) {
        this.req_comm = sweet_req_commVar;
        this.need_check_visit_right = z16;
        this.need_get_invite_lst = z17;
        this.check_qqfriend = z18;
    }
}
