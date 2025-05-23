package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNotificationRedDot extends JceStruct {
    static int cache_type;
    public String text;
    public int type;

    public stNotificationRedDot() {
        this.type = 0;
        this.text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.text = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stNotificationRedDot(int i3, String str) {
        this.type = i3;
        this.text = str;
    }
}
