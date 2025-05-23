package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSchema extends JceStruct {
    public String H5Url;
    public String miniAppSchema;
    public String qqSchema;
    public String schema;
    public int type;

    public stSchema() {
        this.type = 0;
        this.schema = "";
        this.miniAppSchema = "";
        this.H5Url = "";
        this.qqSchema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.schema = jceInputStream.readString(1, false);
        this.miniAppSchema = jceInputStream.readString(2, false);
        this.H5Url = jceInputStream.readString(3, false);
        this.qqSchema = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.schema;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.miniAppSchema;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.H5Url;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.qqSchema;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public stSchema(int i3, String str, String str2, String str3, String str4) {
        this.type = i3;
        this.schema = str;
        this.miniAppSchema = str2;
        this.H5Url = str3;
        this.qqSchema = str4;
    }
}
