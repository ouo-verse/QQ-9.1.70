package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OfficialComment extends JceStruct {
    public String strContent;
    public String strTagBgColor;
    public String strTagName;

    public OfficialComment() {
        this.strTagName = "";
        this.strTagBgColor = "";
        this.strContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTagName = jceInputStream.readString(0, false);
        this.strTagBgColor = jceInputStream.readString(1, false);
        this.strContent = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strTagName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTagBgColor;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strContent;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public OfficialComment(String str, String str2, String str3) {
        this.strTagName = str;
        this.strTagBgColor = str2;
        this.strContent = str3;
    }
}
