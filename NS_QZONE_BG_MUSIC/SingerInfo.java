package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SingerInfo extends JceStruct {
    public String strSingerId;
    public String strSingerName;

    public SingerInfo() {
        this.strSingerId = "";
        this.strSingerName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strSingerId = jceInputStream.readString(0, false);
        this.strSingerName = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strSingerId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strSingerName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public SingerInfo(String str, String str2) {
        this.strSingerId = str;
        this.strSingerName = str2;
    }
}
