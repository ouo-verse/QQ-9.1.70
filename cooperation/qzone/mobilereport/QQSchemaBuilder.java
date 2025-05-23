package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.QQSchemaInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QQSchemaBuilder {
    private ArrayList<QQSchemaInfo> qqSchemaInfos = new ArrayList<>();
    private ReportKey reportKey;

    public QQSchemaBuilder addItemInfo(QQSchemaInfo qQSchemaInfo) {
        this.qqSchemaInfos.add(qQSchemaInfo);
        return this;
    }

    public QQSchemaInfo build() {
        QQSchemaInfo qQSchemaInfo = new QQSchemaInfo();
        ReportKey reportKey = this.reportKey;
        qQSchemaInfo.appid = reportKey.pageAppId;
        qQSchemaInfo.schema_url = reportKey.schemaUrl;
        return qQSchemaInfo;
    }

    public QQSchemaBuilder setReportKey(ReportKey reportKey) {
        this.reportKey = reportKey;
        return this;
    }
}
