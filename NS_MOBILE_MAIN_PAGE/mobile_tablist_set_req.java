package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_tablist_set_req extends JceStruct {
    static s_tab_list cache_tab_lst = new s_tab_list();
    public boolean is_mq;
    public s_tab_list tab_lst;
    public long uin;

    public mobile_tablist_set_req() {
        this.uin = 0L;
        this.tab_lst = null;
        this.is_mq = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.tab_lst = (s_tab_list) jceInputStream.read((JceStruct) cache_tab_lst, 1, true);
        this.is_mq = jceInputStream.read(this.is_mq, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((JceStruct) this.tab_lst, 1);
        jceOutputStream.write(this.is_mq, 2);
    }

    public mobile_tablist_set_req(long j3, s_tab_list s_tab_listVar, boolean z16) {
        this.uin = j3;
        this.tab_lst = s_tab_listVar;
        this.is_mq = z16;
    }
}
