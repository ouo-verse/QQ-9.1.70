package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_campus_info extends JceStruct {
    static int cache_eVerfyStatus;
    public int eVerfyStatus;
    public long iSchoolIdx;
    public String strSchoolID;
    public String strSchoolName;

    public s_campus_info() {
        this.strSchoolName = "";
        this.eVerfyStatus = 0;
        this.iSchoolIdx = 0L;
        this.strSchoolID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strSchoolName = jceInputStream.readString(0, false);
        this.eVerfyStatus = jceInputStream.read(this.eVerfyStatus, 1, false);
        this.iSchoolIdx = jceInputStream.read(this.iSchoolIdx, 2, false);
        this.strSchoolID = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strSchoolName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.eVerfyStatus, 1);
        jceOutputStream.write(this.iSchoolIdx, 2);
        String str2 = this.strSchoolID;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public s_campus_info(String str, int i3, long j3, String str2) {
        this.strSchoolName = str;
        this.eVerfyStatus = i3;
        this.iSchoolIdx = j3;
        this.strSchoolID = str2;
    }
}
