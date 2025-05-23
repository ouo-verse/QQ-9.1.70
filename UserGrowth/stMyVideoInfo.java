package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMyVideoInfo extends JceStruct {
    public int flag;
    public String jumpurl;

    public stMyVideoInfo() {
        this.jumpurl = "";
        this.flag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.jumpurl = jceInputStream.readString(0, false);
        this.flag = jceInputStream.read(this.flag, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.jumpurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.flag, 1);
    }

    public stMyVideoInfo(String str, int i3) {
        this.jumpurl = str;
        this.flag = i3;
    }
}
