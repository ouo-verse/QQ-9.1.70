package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_rc_tab_rsp extends JceStruct {
    static s_rc_tab_list cache_rc_data;
    public s_rc_tab_list rc_data;

    public mobile_get_rc_tab_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_rc_data == null) {
            cache_rc_data = new s_rc_tab_list();
        }
        this.rc_data = (s_rc_tab_list) jceInputStream.read((JceStruct) cache_rc_data, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_rc_tab_list s_rc_tab_listVar = this.rc_data;
        if (s_rc_tab_listVar != null) {
            jceOutputStream.write((JceStruct) s_rc_tab_listVar, 0);
        }
    }

    public mobile_get_rc_tab_rsp(s_rc_tab_list s_rc_tab_listVar) {
        this.rc_data = s_rc_tab_listVar;
    }
}
