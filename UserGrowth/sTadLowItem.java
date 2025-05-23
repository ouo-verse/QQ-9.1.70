package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sTadLowItem extends JceStruct {
    public String name;
    public String text;
    public String url;

    public sTadLowItem() {
        this.name = "";
        this.url = "";
        this.text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.url = jceInputStream.readString(1, false);
        this.text = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public sTadLowItem(String str, String str2, String str3) {
        this.name = str;
        this.url = str2;
        this.text = str3;
    }
}
