package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPopWindowsButton extends JceStruct {
    public String iconUrl;
    public String jumpurl;
    public String title;

    public stPopWindowsButton() {
        this.title = "";
        this.jumpurl = "";
        this.iconUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.jumpurl = jceInputStream.readString(1, false);
        this.iconUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stPopWindowsButton{\n   title=" + this.title + "\n   jumpurl=" + this.jumpurl + "\n   iconUrl='" + this.iconUrl + '}';
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
        String str3 = this.iconUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public stPopWindowsButton(String str, String str2, String str3) {
        this.title = str;
        this.jumpurl = str2;
        this.iconUrl = str3;
    }
}
