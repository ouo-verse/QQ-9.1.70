package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMagicBrand extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String icon;
    public stSchema schema;
    public String text;
    public int type;

    public stMagicBrand() {
        this.type = 0;
        this.icon = "";
        this.text = "";
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.icon = jceInputStream.readString(1, false);
        this.text = jceInputStream.readString(2, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 3);
        }
    }

    public stMagicBrand(int i3, String str, String str2, stSchema stschema) {
        this.type = i3;
        this.icon = str;
        this.text = str2;
        this.schema = stschema;
    }
}
