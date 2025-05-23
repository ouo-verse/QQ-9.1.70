package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class STRecommendInfo extends JceStruct {
    public long iRecomCard;
    public String strDesc;
    public String strRecomUrl;

    public STRecommendInfo() {
        this.iRecomCard = 0L;
        this.strRecomUrl = "";
        this.strDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRecomCard = jceInputStream.read(this.iRecomCard, 1, false);
        this.strRecomUrl = jceInputStream.readString(2, false);
        this.strDesc = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRecomCard, 1);
        String str = this.strRecomUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public STRecommendInfo(long j3, String str, String str2) {
        this.iRecomCard = j3;
        this.strRecomUrl = str;
        this.strDesc = str2;
    }
}
