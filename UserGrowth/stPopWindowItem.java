package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPopWindowItem extends JceStruct {
    static int cache_style;
    public int interval;
    public int style;
    public String text;

    public stPopWindowItem() {
        this.interval = 0;
        this.text = "";
        this.style = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.interval = jceInputStream.read(this.interval, 0, false);
        this.text = jceInputStream.readString(1, false);
        this.style = jceInputStream.read(this.style, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.interval, 0);
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.style, 2);
    }

    public stPopWindowItem(int i3, String str, int i16) {
        this.interval = i3;
        this.text = str;
        this.style = i16;
    }
}
