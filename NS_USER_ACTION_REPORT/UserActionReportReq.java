package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserActionReportReq extends JceStruct {
    static ArrayList<QQSchemaInfo> cache_schema_infos;
    static ArrayList<QQStayTimeInfo> cache_stay_time_infos;
    public ArrayList<UserActionReport> report_infos;
    public ArrayList<QQSchemaInfo> schema_infos;
    public ArrayList<QQStayTimeInfo> stay_time_infos;
    public int type;
    public UserCommReport user_comm_report;
    static UserCommReport cache_user_comm_report = new UserCommReport();
    static ArrayList<UserActionReport> cache_report_infos = new ArrayList<>();

    static {
        cache_report_infos.add(new UserActionReport());
        cache_stay_time_infos = new ArrayList<>();
        cache_stay_time_infos.add(new QQStayTimeInfo());
        cache_schema_infos = new ArrayList<>();
        cache_schema_infos.add(new QQSchemaInfo());
    }

    public UserActionReportReq() {
        this.type = 0;
        this.user_comm_report = null;
        this.report_infos = null;
        this.stay_time_infos = null;
        this.schema_infos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.user_comm_report = (UserCommReport) jceInputStream.read((JceStruct) cache_user_comm_report, 1, true);
        this.report_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_report_infos, 2, false);
        this.stay_time_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_stay_time_infos, 3, false);
        this.schema_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_schema_infos, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((JceStruct) this.user_comm_report, 1);
        ArrayList<UserActionReport> arrayList = this.report_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<QQStayTimeInfo> arrayList2 = this.stay_time_infos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<QQSchemaInfo> arrayList3 = this.schema_infos;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
    }

    public UserActionReportReq(int i3, UserCommReport userCommReport, ArrayList<UserActionReport> arrayList, ArrayList<QQStayTimeInfo> arrayList2, ArrayList<QQSchemaInfo> arrayList3) {
        this.type = i3;
        this.user_comm_report = userCommReport;
        this.report_infos = arrayList;
        this.stay_time_infos = arrayList2;
        this.schema_infos = arrayList3;
    }
}
