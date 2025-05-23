package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_pair_check_rsp extends JceStruct {
    public int host_state;
    public boolean is_qqfriend;
    public ArrayList<invite_item> lst_invite;
    public sweet_req_comm req_comm;
    public int right;
    public sweet_rsp_comm rsp_comm;
    static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
    static sweet_req_comm cache_req_comm = new sweet_req_comm();
    static int cache_host_state = 0;
    static int cache_right = 0;
    static ArrayList<invite_item> cache_lst_invite = new ArrayList<>();

    static {
        cache_lst_invite.add(new invite_item());
    }

    public sweet_pair_check_rsp() {
        this.rsp_comm = null;
        this.req_comm = null;
        this.host_state = 0;
        this.right = 0;
        this.lst_invite = null;
        this.is_qqfriend = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rsp_comm = (sweet_rsp_comm) jceInputStream.read((JceStruct) cache_rsp_comm, 0, true);
        this.req_comm = (sweet_req_comm) jceInputStream.read((JceStruct) cache_req_comm, 1, false);
        this.host_state = jceInputStream.read(this.host_state, 2, false);
        this.right = jceInputStream.read(this.right, 3, false);
        this.lst_invite = (ArrayList) jceInputStream.read((JceInputStream) cache_lst_invite, 4, false);
        this.is_qqfriend = jceInputStream.read(this.is_qqfriend, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.rsp_comm, 0);
        sweet_req_comm sweet_req_commVar = this.req_comm;
        if (sweet_req_commVar != null) {
            jceOutputStream.write((JceStruct) sweet_req_commVar, 1);
        }
        jceOutputStream.write(this.host_state, 2);
        jceOutputStream.write(this.right, 3);
        ArrayList<invite_item> arrayList = this.lst_invite;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.is_qqfriend, 5);
    }

    public sweet_pair_check_rsp(sweet_rsp_comm sweet_rsp_commVar, sweet_req_comm sweet_req_commVar, int i3, int i16, ArrayList<invite_item> arrayList, boolean z16) {
        this.rsp_comm = sweet_rsp_commVar;
        this.req_comm = sweet_req_commVar;
        this.host_state = i3;
        this.right = i16;
        this.lst_invite = arrayList;
        this.is_qqfriend = z16;
    }
}
