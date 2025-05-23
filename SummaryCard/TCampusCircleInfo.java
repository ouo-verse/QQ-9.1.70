package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TCampusCircleInfo extends JceStruct {
    static int cache_eStatus;
    static TCampusSchoolInfo cache_stSchoolInfo = new TCampusSchoolInfo();
    public int eStatus;
    public int iIsSigned;
    public TCampusSchoolInfo stSchoolInfo;
    public String strAcademy;
    public String strName;

    public TCampusCircleInfo() {
        this.iIsSigned = 0;
        this.strName = "";
        this.strAcademy = "";
        this.eStatus = 0;
        this.stSchoolInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIsSigned = jceInputStream.read(this.iIsSigned, 0, false);
        this.strName = jceInputStream.readString(1, false);
        this.strAcademy = jceInputStream.readString(2, false);
        this.eStatus = jceInputStream.read(this.eStatus, 3, false);
        this.stSchoolInfo = (TCampusSchoolInfo) jceInputStream.read((JceStruct) cache_stSchoolInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIsSigned, 0);
        String str = this.strName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strAcademy;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.eStatus, 3);
        TCampusSchoolInfo tCampusSchoolInfo = this.stSchoolInfo;
        if (tCampusSchoolInfo != null) {
            jceOutputStream.write((JceStruct) tCampusSchoolInfo, 4);
        }
    }

    public TCampusCircleInfo(int i3, String str, String str2, int i16, TCampusSchoolInfo tCampusSchoolInfo) {
        this.iIsSigned = i3;
        this.strName = str;
        this.strAcademy = str2;
        this.eStatus = i16;
        this.stSchoolInfo = tCampusSchoolInfo;
    }
}
