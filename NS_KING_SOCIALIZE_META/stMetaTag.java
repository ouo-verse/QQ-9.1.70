package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaTag extends JceStruct {
    public String iconUrl;
    public String jumpurl;
    public int tag_type;
    public String title;

    public stMetaTag() {
        this.title = "";
        this.jumpurl = "";
        this.tag_type = 0;
        this.iconUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.jumpurl = jceInputStream.readString(1, false);
        this.tag_type = jceInputStream.read(this.tag_type, 2, false);
        this.iconUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "{title='" + this.title + "', jumpurl='" + this.jumpurl + "', tag_type=" + this.tag_type + ", iconUrl='" + this.iconUrl + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.jumpurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.tag_type, 2);
        String str3 = this.iconUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stMetaTag(String str, String str2, int i3, String str3) {
        this.title = str;
        this.jumpurl = str2;
        this.tag_type = i3;
        this.iconUrl = str3;
    }
}
