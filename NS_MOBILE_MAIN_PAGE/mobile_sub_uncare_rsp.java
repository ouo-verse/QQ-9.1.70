package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_uncare_rsp extends JceStruct {
    static s_uncare cache_uncare;
    public s_uncare uncare;

    public mobile_sub_uncare_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_uncare == null) {
            cache_uncare = new s_uncare();
        }
        this.uncare = (s_uncare) jceInputStream.read((JceStruct) cache_uncare, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_uncare s_uncareVar = this.uncare;
        if (s_uncareVar != null) {
            jceOutputStream.write((JceStruct) s_uncareVar, 0);
        }
    }

    public mobile_sub_uncare_rsp(s_uncare s_uncareVar) {
        this.uncare = s_uncareVar;
    }
}
