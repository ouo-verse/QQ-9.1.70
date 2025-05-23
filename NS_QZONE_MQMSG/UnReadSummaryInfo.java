package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UnReadSummaryInfo extends JceStruct {
    public String attach_info;
    public int hasmore;
    public int need_more_unread_msg;
    public int req_num;

    public UnReadSummaryInfo() {
        this.hasmore = 0;
        this.attach_info = "";
        this.req_num = 0;
        this.need_more_unread_msg = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
        this.req_num = jceInputStream.read(this.req_num, 3, false);
        this.need_more_unread_msg = jceInputStream.read(this.need_more_unread_msg, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.req_num, 3);
        jceOutputStream.write(this.need_more_unread_msg, 4);
    }

    public UnReadSummaryInfo(int i3, String str, int i16, int i17) {
        this.hasmore = i3;
        this.attach_info = str;
        this.req_num = i16;
        this.need_more_unread_msg = i17;
    }
}
