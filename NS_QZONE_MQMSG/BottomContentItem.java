package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BottomContentItem extends JceStruct {
    public String content;
    public String url;

    public BottomContentItem() {
        this.content = "";
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content = jceInputStream.readString(0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public BottomContentItem(String str, String str2) {
        this.content = str;
        this.url = str2;
    }
}
