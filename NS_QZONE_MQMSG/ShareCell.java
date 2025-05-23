package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShareCell extends JceStruct {
    public String content;
    public String imgUrl;
    public String jumpUrl;
    public String title;

    public ShareCell() {
        this.title = "";
        this.content = "";
        this.imgUrl = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.content = jceInputStream.readString(1, false);
        this.imgUrl = jceInputStream.readString(2, false);
        this.jumpUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.imgUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.jumpUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public ShareCell(String str, String str2, String str3, String str4) {
        this.title = str;
        this.content = str2;
        this.imgUrl = str3;
        this.jumpUrl = str4;
    }
}
