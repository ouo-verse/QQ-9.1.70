package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stIconButton extends JceStruct {
    public String buttonBgColor;
    public String buttonIcon;
    public String buttonText;
    public String buttonTextColor;

    public stIconButton() {
        this.buttonText = "";
        this.buttonIcon = "";
        this.buttonBgColor = "";
        this.buttonTextColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.buttonText = jceInputStream.readString(0, false);
        this.buttonIcon = jceInputStream.readString(1, false);
        this.buttonBgColor = jceInputStream.readString(2, false);
        this.buttonTextColor = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.buttonText;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.buttonIcon;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.buttonBgColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.buttonTextColor;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public stIconButton(String str, String str2, String str3, String str4) {
        this.buttonText = str;
        this.buttonIcon = str2;
        this.buttonBgColor = str3;
        this.buttonTextColor = str4;
    }
}
