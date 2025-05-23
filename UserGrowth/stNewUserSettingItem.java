package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNewUserSettingItem extends JceStruct {
    static int cache_name;
    static stSchema cache_schema = new stSchema();
    public int name;
    public stSchema schema;
    public int status;

    public stNewUserSettingItem() {
        this.name = 0;
        this.status = 0;
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.read(this.name, 0, false);
        this.status = jceInputStream.read(this.status, 1, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.name, 0);
        jceOutputStream.write(this.status, 1);
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 2);
        }
    }

    public stNewUserSettingItem(int i3, int i16, stSchema stschema) {
        this.name = i3;
        this.status = i16;
        this.schema = stschema;
    }
}
