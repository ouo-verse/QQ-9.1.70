package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_nameplate extends JceStruct {
    public String icon;
    public String jumpurl;
    public int nameplateid;

    public s_nameplate() {
        this.nameplateid = 0;
        this.icon = "";
        this.jumpurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nameplateid = jceInputStream.read(this.nameplateid, 0, false);
        this.icon = jceInputStream.readString(1, false);
        this.jumpurl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nameplateid, 0);
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.jumpurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public s_nameplate(int i3, String str, String str2) {
        this.nameplateid = i3;
        this.icon = str;
        this.jumpurl = str2;
    }
}
