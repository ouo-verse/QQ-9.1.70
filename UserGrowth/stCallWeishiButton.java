package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCallWeishiButton extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public boolean isShow;
    public stSchema schema;

    public stCallWeishiButton() {
        this.isShow = true;
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isShow = jceInputStream.read(this.isShow, 0, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isShow, 0);
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 1);
        }
    }

    public stCallWeishiButton(boolean z16, stSchema stschema) {
        this.isShow = z16;
        this.schema = stschema;
    }
}
