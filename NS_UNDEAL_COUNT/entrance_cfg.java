package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class entrance_cfg extends JceStruct {
    static st_report_info cache_stReportInfo = new st_report_info();
    public int iEntranceId;
    public int iShaishaiScene;
    public int isAnchor;
    public int isCanNotShowOnTeenagerMod;
    public int isDefualt;
    public String sEntranceAction;
    public String sEntranceIcon;
    public String sEntranceName;
    public String sQbossEntranceIcon;
    public String sQbossTraceInfo;
    public st_report_info stReportInfo;
    public int tabid;

    public entrance_cfg() {
        this.iEntranceId = 0;
        this.sEntranceName = "";
        this.sEntranceIcon = "";
        this.sEntranceAction = "";
        this.isDefualt = 0;
        this.tabid = 0;
        this.sQbossEntranceIcon = "";
        this.sQbossTraceInfo = "";
        this.isAnchor = 0;
        this.stReportInfo = null;
        this.isCanNotShowOnTeenagerMod = 0;
        this.iShaishaiScene = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iEntranceId = jceInputStream.read(this.iEntranceId, 0, false);
        this.sEntranceName = jceInputStream.readString(1, false);
        this.sEntranceIcon = jceInputStream.readString(2, false);
        this.sEntranceAction = jceInputStream.readString(3, false);
        this.isDefualt = jceInputStream.read(this.isDefualt, 4, false);
        this.tabid = jceInputStream.read(this.tabid, 5, false);
        this.sQbossEntranceIcon = jceInputStream.readString(6, false);
        this.sQbossTraceInfo = jceInputStream.readString(7, false);
        this.isAnchor = jceInputStream.read(this.isAnchor, 8, false);
        this.stReportInfo = (st_report_info) jceInputStream.read((JceStruct) cache_stReportInfo, 9, false);
        this.isCanNotShowOnTeenagerMod = jceInputStream.read(this.isCanNotShowOnTeenagerMod, 10, false);
        this.iShaishaiScene = jceInputStream.read(this.iShaishaiScene, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iEntranceId, 0);
        String str = this.sEntranceName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sEntranceIcon;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.sEntranceAction;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.isDefualt, 4);
        jceOutputStream.write(this.tabid, 5);
        String str4 = this.sQbossEntranceIcon;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.sQbossTraceInfo;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.isAnchor, 8);
        st_report_info st_report_infoVar = this.stReportInfo;
        if (st_report_infoVar != null) {
            jceOutputStream.write((JceStruct) st_report_infoVar, 9);
        }
        jceOutputStream.write(this.isCanNotShowOnTeenagerMod, 10);
        jceOutputStream.write(this.iShaishaiScene, 11);
    }

    public entrance_cfg(int i3, String str, String str2, String str3, int i16, int i17, String str4, String str5, int i18, st_report_info st_report_infoVar, int i19, int i26) {
        this.iEntranceId = i3;
        this.sEntranceName = str;
        this.sEntranceIcon = str2;
        this.sEntranceAction = str3;
        this.isDefualt = i16;
        this.tabid = i17;
        this.sQbossEntranceIcon = str4;
        this.sQbossTraceInfo = str5;
        this.isAnchor = i18;
        this.stReportInfo = st_report_infoVar;
        this.isCanNotShowOnTeenagerMod = i19;
        this.iShaishaiScene = i26;
    }
}
