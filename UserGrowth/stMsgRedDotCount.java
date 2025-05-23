package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMsgRedDotCount extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public int count;
    public stSchema schema;
    public int subjectID;

    public stMsgRedDotCount() {
        this.subjectID = 0;
        this.count = 0;
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.subjectID = jceInputStream.read(this.subjectID, 0, false);
        this.count = jceInputStream.read(this.count, 1, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.subjectID, 0);
        jceOutputStream.write(this.count, 1);
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 2);
        }
    }

    public stMsgRedDotCount(int i3, int i16, stSchema stschema) {
        this.subjectID = i3;
        this.count = i16;
        this.schema = stschema;
    }
}
