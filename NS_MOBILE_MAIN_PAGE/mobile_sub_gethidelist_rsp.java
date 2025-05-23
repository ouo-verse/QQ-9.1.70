package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_gethidelist_rsp extends JceStruct {
    static s_hidelist cache_hidelist;
    public s_hidelist hidelist;

    public mobile_sub_gethidelist_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_hidelist == null) {
            cache_hidelist = new s_hidelist();
        }
        this.hidelist = (s_hidelist) jceInputStream.read((JceStruct) cache_hidelist, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_hidelist s_hidelistVar = this.hidelist;
        if (s_hidelistVar != null) {
            jceOutputStream.write((JceStruct) s_hidelistVar, 0);
        }
    }

    public mobile_sub_gethidelist_rsp(s_hidelist s_hidelistVar) {
        this.hidelist = s_hidelistVar;
    }
}
