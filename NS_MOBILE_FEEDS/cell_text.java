package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_text extends JceStruct {
    public String data;
    public int type;

    public cell_text() {
        this.data = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.data;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.type, 1);
    }

    public cell_text(String str, int i3) {
        this.data = str;
        this.type = i3;
    }
}
