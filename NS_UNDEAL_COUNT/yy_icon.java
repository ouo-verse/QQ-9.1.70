package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class yy_icon extends JceStruct {
    public int iEntranceId;
    public String sIconName;
    public String sIconTraceInfo;
    public String sIconUrl;

    public yy_icon() {
        this.sIconUrl = "";
        this.sIconName = "";
        this.sIconTraceInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iEntranceId = jceInputStream.read(this.iEntranceId, 0, false);
        this.sIconUrl = jceInputStream.readString(1, false);
        this.sIconName = jceInputStream.readString(2, false);
        this.sIconTraceInfo = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iEntranceId, 0);
        String str = this.sIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sIconName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.sIconTraceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public yy_icon(int i3, String str, String str2, String str3) {
        this.iEntranceId = i3;
        this.sIconUrl = str;
        this.sIconName = str2;
        this.sIconTraceInfo = str3;
    }
}
