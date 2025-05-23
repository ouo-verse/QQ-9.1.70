package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FacadeDIY extends JceStruct {
    public int iEnable;
    public String strChecksum;

    public FacadeDIY() {
        this.iEnable = -1;
        this.strChecksum = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iEnable = jceInputStream.read(this.iEnable, 0, false);
        this.strChecksum = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iEnable, 0);
        String str = this.strChecksum;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public FacadeDIY(int i3, String str) {
        this.iEnable = i3;
        this.strChecksum = str;
    }
}
