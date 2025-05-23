package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestQueryNewUserRecommendedList extends JceStruct {
    public String MobileUniqueNo;
    public long WantNum;

    public RequestQueryNewUserRecommendedList() {
        this.MobileUniqueNo = "";
        this.WantNum = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MobileUniqueNo = jceInputStream.readString(1, false);
        this.WantNum = jceInputStream.read(this.WantNum, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.MobileUniqueNo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.WantNum, 2);
    }

    public RequestQueryNewUserRecommendedList(String str, long j3) {
        this.MobileUniqueNo = str;
        this.WantNum = j3;
    }
}
