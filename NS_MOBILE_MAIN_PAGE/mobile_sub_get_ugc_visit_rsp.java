package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_ugc_visit_rsp extends JceStruct {
    static s_visit cache_visit;
    public boolean end;
    public String page;
    public s_visit visit;

    public mobile_sub_get_ugc_visit_rsp() {
        this.page = "";
        this.end = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_visit == null) {
            cache_visit = new s_visit();
        }
        this.visit = (s_visit) jceInputStream.read((JceStruct) cache_visit, 0, false);
        this.page = jceInputStream.readString(1, false);
        this.end = jceInputStream.read(this.end, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_visit s_visitVar = this.visit;
        if (s_visitVar != null) {
            jceOutputStream.write((JceStruct) s_visitVar, 0);
        }
        String str = this.page;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.end, 2);
    }

    public mobile_sub_get_ugc_visit_rsp(s_visit s_visitVar, String str, boolean z16) {
        this.visit = s_visitVar;
        this.page = str;
        this.end = z16;
    }
}
