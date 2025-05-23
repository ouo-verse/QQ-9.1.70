package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNews extends JceStruct {
    public String title = "";
    public String desc = "";
    public String jumpUrl = "";
    public String preview = "";
    public String tag = "";
    public String tagIcon = "";

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.desc = jceInputStream.readString(1, false);
        this.jumpUrl = jceInputStream.readString(2, false);
        this.preview = jceInputStream.readString(3, false);
        this.tag = jceInputStream.readString(4, false);
        this.tagIcon = jceInputStream.readString(5, false);
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
        String str3 = this.jumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.preview;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.tag;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.tagIcon;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }
}
