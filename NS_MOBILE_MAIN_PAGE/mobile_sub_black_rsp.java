package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_black_rsp extends JceStruct {
    static s_black cache_black;
    public s_black black;

    public mobile_sub_black_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_black == null) {
            cache_black = new s_black();
        }
        this.black = (s_black) jceInputStream.read((JceStruct) cache_black, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_black s_blackVar = this.black;
        if (s_blackVar != null) {
            jceOutputStream.write((JceStruct) s_blackVar, 0);
        }
    }

    public mobile_sub_black_rsp(s_black s_blackVar) {
        this.black = s_blackVar;
    }
}
