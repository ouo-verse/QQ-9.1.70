package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQSchemaInfo extends JceStruct {
    public String appid;
    public String schema_desc;
    public String schema_url;

    public QQSchemaInfo() {
        this.appid = "";
        this.schema_desc = "";
        this.schema_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.readString(0, true);
        this.schema_desc = jceInputStream.readString(1, true);
        this.schema_url = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.schema_desc, 1);
        jceOutputStream.write(this.schema_url, 2);
    }

    public QQSchemaInfo(String str, String str2, String str3) {
        this.appid = str;
        this.schema_desc = str2;
        this.schema_url = str3;
    }
}
