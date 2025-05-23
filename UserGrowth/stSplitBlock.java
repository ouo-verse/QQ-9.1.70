package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSplitBlock extends JceStruct {
    public int style;
    public String text;
    public String tips;

    public stSplitBlock() {
        this.text = "";
        this.tips = "";
        this.style = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.text = jceInputStream.readString(0, false);
        this.tips = jceInputStream.readString(1, false);
        this.style = jceInputStream.read(this.style, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.tips;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.style, 2);
    }

    public stSplitBlock(String str, String str2, int i3) {
        this.text = str;
        this.tips = str2;
        this.style = i3;
    }
}
