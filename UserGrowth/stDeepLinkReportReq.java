package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDeepLinkReportReq extends JceStruct {
    public static final String WNS_COMMAND = "DeepLinkReport";
    private static final long serialVersionUID = 0;
    public String schema;

    public stDeepLinkReportReq(String str) {
        this.schema = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.schema = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.schema;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }
}
