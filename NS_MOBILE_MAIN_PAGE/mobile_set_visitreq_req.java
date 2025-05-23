package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_set_visitreq_req extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25001msg;
    public int op_type;
    public long visit_uin;

    public mobile_set_visitreq_req() {
        this.f25001msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_type = jceInputStream.read(this.op_type, 0, true);
        this.visit_uin = jceInputStream.read(this.visit_uin, 1, false);
        this.f25001msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_type, 0);
        jceOutputStream.write(this.visit_uin, 1);
        String str = this.f25001msg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public mobile_set_visitreq_req(int i3, long j3, String str) {
        this.op_type = i3;
        this.visit_uin = j3;
        this.f25001msg = str;
    }
}
