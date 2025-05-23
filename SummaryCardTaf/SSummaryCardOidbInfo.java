package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardOidbInfo extends JceStruct {
    public String bgurl;
    public long styleid;
    public String version;

    public SSummaryCardOidbInfo() {
        this.styleid = 0L;
        this.bgurl = "";
        this.version = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.styleid = jceInputStream.read(this.styleid, 1, false);
        this.bgurl = jceInputStream.readString(2, false);
        this.version = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.styleid, 1);
        String str = this.bgurl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.version;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public SSummaryCardOidbInfo(long j3, String str, String str2) {
        this.styleid = j3;
        this.bgurl = str;
        this.version = str2;
    }
}
