package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setspecial_req extends JceStruct {
    static s_special cache_special = new s_special();
    public int action;
    public s_special special;

    public mobile_sub_setspecial_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.action = jceInputStream.read(this.action, 0, false);
        this.special = (s_special) jceInputStream.read((JceStruct) cache_special, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.action, 0);
        s_special s_specialVar = this.special;
        if (s_specialVar != null) {
            jceOutputStream.write((JceStruct) s_specialVar, 1);
        }
    }

    public mobile_sub_setspecial_req(int i3, s_special s_specialVar) {
        this.action = i3;
        this.special = s_specialVar;
    }
}
