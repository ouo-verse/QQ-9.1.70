package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_arkshare extends JceStruct {
    public String ark_content;
    public String ark_id;
    public String view_id;

    public s_arkshare() {
        this.ark_id = "";
        this.view_id = "";
        this.ark_content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ark_id = jceInputStream.readString(0, false);
        this.view_id = jceInputStream.readString(1, false);
        this.ark_content = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ark_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.view_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.ark_content;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public s_arkshare(String str, String str2, String str3) {
        this.ark_id = str;
        this.view_id = str2;
        this.ark_content = str3;
    }
}
