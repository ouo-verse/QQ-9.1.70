package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stBusinessAdCard extends JceStruct {
    public String cardButtonTxt;
    public String cardDesc;
    public String cardImage;
    public String cardTitle;

    public stBusinessAdCard() {
        this.cardImage = "";
        this.cardTitle = "";
        this.cardButtonTxt = "";
        this.cardDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cardImage = jceInputStream.readString(0, false);
        this.cardTitle = jceInputStream.readString(1, false);
        this.cardButtonTxt = jceInputStream.readString(2, false);
        this.cardDesc = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cardImage;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.cardTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.cardButtonTxt;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.cardDesc;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public stBusinessAdCard(String str, String str2, String str3, String str4) {
        this.cardImage = str;
        this.cardTitle = str2;
        this.cardButtonTxt = str3;
        this.cardDesc = str4;
    }
}
