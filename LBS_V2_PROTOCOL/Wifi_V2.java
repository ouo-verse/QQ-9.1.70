package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Wifi_V2 extends JceStruct {
    public int iRssi;
    public String strMac;

    public Wifi_V2() {
        this.strMac = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.strMac, "strMac");
        jceDisplayer.display(this.iRssi, "iRssi");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strMac = jceInputStream.readString(0, true);
        this.iRssi = jceInputStream.read(this.iRssi, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strMac, 0);
        jceOutputStream.write(this.iRssi, 1);
    }

    public Wifi_V2(String str, int i3) {
        this.strMac = str;
        this.iRssi = i3;
    }
}
