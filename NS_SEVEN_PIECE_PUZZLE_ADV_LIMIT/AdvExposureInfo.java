package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AdvExposureInfo extends JceStruct {
    static int cache_iAuditResult;
    public int iAuditResult;
    public String strAdvId;
    public String strName;

    public AdvExposureInfo() {
        this.strAdvId = "";
        this.strName = "";
        this.iAuditResult = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAdvId = jceInputStream.readString(0, false);
        this.strName = jceInputStream.readString(1, false);
        this.iAuditResult = jceInputStream.read(this.iAuditResult, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strAdvId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iAuditResult, 2);
    }

    public AdvExposureInfo(String str, String str2, int i3) {
        this.strAdvId = str;
        this.strName = str2;
        this.iAuditResult = i3;
    }
}
