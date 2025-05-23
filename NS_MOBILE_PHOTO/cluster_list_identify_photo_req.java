package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cluster_list_identify_photo_req extends JceStruct {
    static comm_page_info cache_page_info = new comm_page_info();
    public String categoryid;
    public long op_uin;
    public comm_page_info page_info;

    public cluster_list_identify_photo_req() {
        this.op_uin = 0L;
        this.categoryid = "";
        this.page_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.categoryid = jceInputStream.readString(1, false);
        this.page_info = (comm_page_info) jceInputStream.read((JceStruct) cache_page_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_uin, 0);
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        comm_page_info comm_page_infoVar = this.page_info;
        if (comm_page_infoVar != null) {
            jceOutputStream.write((JceStruct) comm_page_infoVar, 2);
        }
    }

    public cluster_list_identify_photo_req(long j3, String str, comm_page_info comm_page_infoVar) {
        this.op_uin = j3;
        this.categoryid = str;
        this.page_info = comm_page_infoVar;
    }
}
