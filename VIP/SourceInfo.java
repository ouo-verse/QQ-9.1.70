package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SourceInfo extends JceStruct {
    public int iSource;
    public String sVersion;

    public SourceInfo() {
        this.iSource = 0;
        this.sVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iSource = jceInputStream.read(this.iSource, 0, false);
        this.sVersion = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iSource, 0);
        String str = this.sVersion;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public SourceInfo(int i3, String str) {
        this.iSource = i3;
        this.sVersion = str;
    }
}
