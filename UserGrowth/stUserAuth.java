package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUserAuth extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public stSchema schema;
    public boolean show_confirm;

    public stUserAuth() {
        this.show_confirm = true;
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.show_confirm = jceInputStream.read(this.show_confirm, 0, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stUserAuth{show_confirm=" + this.show_confirm + ", schema=" + this.schema + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.show_confirm, 0);
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 1);
        }
    }

    public stUserAuth(boolean z16, stSchema stschema) {
        this.show_confirm = z16;
        this.schema = stschema;
    }
}
