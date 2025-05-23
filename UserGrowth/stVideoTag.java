package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVideoTag extends JceStruct {
    public String bgColor;
    public String imgUrl;
    public int tagId;
    public String text;
    public String textColor;

    public stVideoTag() {
        this.tagId = 0;
        this.imgUrl = "";
        this.text = "";
        this.textColor = "";
        this.bgColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tagId = jceInputStream.read(this.tagId, 0, false);
        this.imgUrl = jceInputStream.readString(1, false);
        this.text = jceInputStream.readString(2, false);
        this.textColor = jceInputStream.readString(3, false);
        this.bgColor = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tagId, 0);
        String str = this.imgUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.textColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.bgColor;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public stVideoTag(int i3, String str, String str2, String str3, String str4) {
        this.tagId = i3;
        this.imgUrl = str;
        this.text = str2;
        this.textColor = str3;
        this.bgColor = str4;
    }
}
