package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class master_info extends JceStruct {
    public long host_unimbitmap;
    public int iLevel;
    public String strMessage;

    public master_info() {
        this.strMessage = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLevel = jceInputStream.read(this.iLevel, 0, false);
        this.strMessage = jceInputStream.readString(1, false);
        this.host_unimbitmap = jceInputStream.read(this.host_unimbitmap, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLevel, 0);
        String str = this.strMessage;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.host_unimbitmap, 2);
    }

    public master_info(int i3, String str, long j3) {
        this.iLevel = i3;
        this.strMessage = str;
        this.host_unimbitmap = j3;
    }
}
