package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setblack_req extends JceStruct {
    static s_black cache_black;
    public int action;
    public s_black black;

    public mobile_sub_setblack_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.action = jceInputStream.read(this.action, 0, false);
        if (cache_black == null) {
            cache_black = new s_black();
        }
        this.black = (s_black) jceInputStream.read((JceStruct) cache_black, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.action, 0);
        s_black s_blackVar = this.black;
        if (s_blackVar != null) {
            jceOutputStream.write((JceStruct) s_blackVar, 1);
        }
    }

    public mobile_sub_setblack_req(int i3, s_black s_blackVar) {
        this.action = i3;
        this.black = s_blackVar;
    }
}
