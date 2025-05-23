package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setuncare_req extends JceStruct {
    static s_uncare cache_uncare;
    public int action;
    public s_uncare uncare;

    public mobile_sub_setuncare_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.action = jceInputStream.read(this.action, 0, false);
        if (cache_uncare == null) {
            cache_uncare = new s_uncare();
        }
        this.uncare = (s_uncare) jceInputStream.read((JceStruct) cache_uncare, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.action, 0);
        s_uncare s_uncareVar = this.uncare;
        if (s_uncareVar != null) {
            jceOutputStream.write((JceStruct) s_uncareVar, 1);
        }
    }

    public mobile_sub_setuncare_req(int i3, s_uncare s_uncareVar) {
        this.action = i3;
        this.uncare = s_uncareVar;
    }
}
