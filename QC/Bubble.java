package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Bubble extends JceStruct {
    public int deltype;
    public String strDiyJson;

    public Bubble() {
        this.strDiyJson = "";
        this.deltype = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strDiyJson = jceInputStream.readString(0, false);
        this.deltype = jceInputStream.read(this.deltype, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strDiyJson;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.deltype, 1);
    }

    public Bubble(String str, int i3) {
        this.strDiyJson = str;
        this.deltype = i3;
    }
}
