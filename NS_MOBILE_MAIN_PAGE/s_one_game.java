package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_one_game extends JceStruct {
    public String strDesc;
    public String strGameUrl;
    public String strIconUrl;
    public long uCount;

    public s_one_game() {
        this.strIconUrl = "";
        this.strDesc = "";
        this.strGameUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uCount = jceInputStream.read(this.uCount, 0, false);
        this.strIconUrl = jceInputStream.readString(1, false);
        this.strDesc = jceInputStream.readString(2, false);
        this.strGameUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uCount, 0);
        String str = this.strIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strGameUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public s_one_game(long j3, String str, String str2, String str3) {
        this.uCount = j3;
        this.strIconUrl = str;
        this.strDesc = str2;
        this.strGameUrl = str3;
    }
}
