package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRedDotMenu extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String imageUrl;
    public String menuKey;
    public stSchema schema;
    public String text;

    public stRedDotMenu() {
        this.menuKey = "";
        this.schema = null;
        this.text = "";
        this.imageUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.menuKey = jceInputStream.readString(0, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 1, false);
        this.text = jceInputStream.readString(2, false);
        this.imageUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.menuKey;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 1);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.imageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stRedDotMenu(String str, stSchema stschema, String str2, String str3) {
        this.menuKey = str;
        this.schema = stschema;
        this.text = str2;
        this.imageUrl = str3;
    }
}
