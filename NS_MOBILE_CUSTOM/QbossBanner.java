package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QbossBanner extends JceStruct {
    static int cache_eJumpType;
    public int eJumpType;
    public String strH5JumpInfo;
    public String strPicUrl;
    public String strQbossTrace;
    public String strSchema;

    public QbossBanner() {
        this.eJumpType = 1;
        this.strPicUrl = "";
        this.strSchema = "";
        this.strH5JumpInfo = "";
        this.strQbossTrace = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eJumpType = jceInputStream.read(this.eJumpType, 0, false);
        this.strPicUrl = jceInputStream.readString(1, false);
        this.strSchema = jceInputStream.readString(2, false);
        this.strH5JumpInfo = jceInputStream.readString(3, false);
        this.strQbossTrace = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eJumpType, 0);
        String str = this.strPicUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strSchema;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strH5JumpInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strQbossTrace;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public QbossBanner(int i3, String str, String str2, String str3, String str4) {
        this.eJumpType = i3;
        this.strPicUrl = str;
        this.strSchema = str2;
        this.strH5JumpInfo = str3;
        this.strQbossTrace = str4;
    }
}
