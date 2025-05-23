package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_flower extends JceStruct {
    public long count;
    public String flowericonurl;
    public String update_desc;

    public s_flower() {
        this.flowericonurl = "";
        this.update_desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.count = jceInputStream.read(this.count, 0, false);
        this.flowericonurl = jceInputStream.readString(1, false);
        this.update_desc = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.count, 0);
        String str = this.flowericonurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.update_desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public s_flower(long j3, String str, String str2) {
        this.count = j3;
        this.flowericonurl = str;
        this.update_desc = str2;
    }
}
