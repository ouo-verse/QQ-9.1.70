package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_gamebar_pk_banner extends JceStruct {
    public int banner_state;
    public String jump_url;
    public String pic_url;
    public String trace_info;

    public s_gamebar_pk_banner() {
        this.banner_state = 0;
        this.pic_url = "";
        this.jump_url = "";
        this.trace_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.banner_state = jceInputStream.read(this.banner_state, 0, true);
        this.pic_url = jceInputStream.readString(1, true);
        this.jump_url = jceInputStream.readString(2, true);
        this.trace_info = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.banner_state, 0);
        jceOutputStream.write(this.pic_url, 1);
        jceOutputStream.write(this.jump_url, 2);
        jceOutputStream.write(this.trace_info, 3);
    }

    public s_gamebar_pk_banner(int i3, String str, String str2, String str3) {
        this.banner_state = i3;
        this.pic_url = str;
        this.jump_url = str2;
        this.trace_info = str3;
    }
}
