package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_addfriend_type_rsp extends JceStruct {
    public String errorstring;
    public int ret;

    public mobile_sub_addfriend_type_rsp() {
        this.ret = 0;
        this.errorstring = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errorstring = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errorstring;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_sub_addfriend_type_rsp(int i3, String str) {
        this.ret = i3;
        this.errorstring = str;
    }
}
