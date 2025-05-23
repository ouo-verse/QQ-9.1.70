package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class summaryCardWzryInfo extends JceStruct {
    public int honorId;
    public String strRecord;

    public summaryCardWzryInfo() {
        this.honorId = 0;
        this.strRecord = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.honorId = jceInputStream.read(this.honorId, 0, false);
        this.strRecord = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.honorId, 0);
        String str = this.strRecord;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public summaryCardWzryInfo(int i3, String str) {
        this.honorId = i3;
        this.strRecord = str;
    }
}
