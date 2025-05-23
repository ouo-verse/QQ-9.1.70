package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_feeds_tab_info extends JceStruct {
    public int iTabSwitch;
    public String strTabActionUrl;
    public String strTabName;

    public mobile_feeds_tab_info() {
        this.strTabName = "";
        this.strTabActionUrl = "";
        this.iTabSwitch = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTabName = jceInputStream.readString(0, false);
        this.strTabActionUrl = jceInputStream.readString(1, false);
        this.iTabSwitch = jceInputStream.read(this.iTabSwitch, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strTabName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTabActionUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iTabSwitch, 2);
    }

    public mobile_feeds_tab_info(String str, String str2, int i3) {
        this.strTabName = str;
        this.strTabActionUrl = str2;
        this.iTabSwitch = i3;
    }
}
