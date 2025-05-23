package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_kuolie_info extends JceStruct {
    static s_campus_info cache_vecCampusInfo = new s_campus_info();
    public int iDays;
    public int iFrdFlag;
    public int iFrdsCnt;
    public int iLastNuanTime;
    public int iState;
    public String strKuolieCampusAIOKey;
    public s_campus_info vecCampusInfo;

    public s_kuolie_info() {
        this.iFrdFlag = 0;
        this.iFrdsCnt = 0;
        this.iState = 0;
        this.iDays = 0;
        this.iLastNuanTime = 0;
        this.vecCampusInfo = null;
        this.strKuolieCampusAIOKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFrdFlag = jceInputStream.read(this.iFrdFlag, 0, false);
        this.iFrdsCnt = jceInputStream.read(this.iFrdsCnt, 1, false);
        this.iState = jceInputStream.read(this.iState, 2, false);
        this.iDays = jceInputStream.read(this.iDays, 3, false);
        this.iLastNuanTime = jceInputStream.read(this.iLastNuanTime, 4, false);
        this.vecCampusInfo = (s_campus_info) jceInputStream.read((JceStruct) cache_vecCampusInfo, 5, false);
        this.strKuolieCampusAIOKey = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFrdFlag, 0);
        jceOutputStream.write(this.iFrdsCnt, 1);
        jceOutputStream.write(this.iState, 2);
        jceOutputStream.write(this.iDays, 3);
        jceOutputStream.write(this.iLastNuanTime, 4);
        s_campus_info s_campus_infoVar = this.vecCampusInfo;
        if (s_campus_infoVar != null) {
            jceOutputStream.write((JceStruct) s_campus_infoVar, 5);
        }
        String str = this.strKuolieCampusAIOKey;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public s_kuolie_info(int i3, int i16, int i17, int i18, int i19, s_campus_info s_campus_infoVar, String str) {
        this.iFrdFlag = i3;
        this.iFrdsCnt = i16;
        this.iState = i17;
        this.iDays = i18;
        this.iLastNuanTime = i19;
        this.vecCampusInfo = s_campus_infoVar;
        this.strKuolieCampusAIOKey = str;
    }
}
