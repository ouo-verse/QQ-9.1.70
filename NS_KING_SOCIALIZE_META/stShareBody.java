package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stShareBody extends JceStruct {
    public String desc;
    public String image_url;
    public String title;

    public stShareBody() {
        this.title = "";
        this.desc = "";
        this.image_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.desc = jceInputStream.readString(1, false);
        this.image_url = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.image_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public stShareBody(String str, String str2, String str3) {
        this.title = str;
        this.desc = str2;
        this.image_url = str3;
    }
}
