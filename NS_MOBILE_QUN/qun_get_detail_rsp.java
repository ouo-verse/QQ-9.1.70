package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_detail;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_detail_rsp extends JceStruct {
    static single_detail cache_detail_data;
    public String attach_info;
    public single_detail detail_data;
    public int hasmore;

    public qun_get_detail_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_detail_data == null) {
            cache_detail_data = new single_detail();
        }
        this.detail_data = (single_detail) jceInputStream.read((JceStruct) cache_detail_data, 0, false);
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        single_detail single_detailVar = this.detail_data;
        if (single_detailVar != null) {
            jceOutputStream.write((JceStruct) single_detailVar, 0);
        }
        jceOutputStream.write(this.hasmore, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public qun_get_detail_rsp(single_detail single_detailVar, int i3, String str) {
        this.detail_data = single_detailVar;
        this.hasmore = i3;
        this.attach_info = str;
    }
}
