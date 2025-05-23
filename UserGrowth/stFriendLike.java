package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFriendLike extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String nick;
    public stSchema schema;

    public stFriendLike() {
        this.nick = "";
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nick = jceInputStream.readString(0, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 1);
        }
    }

    public stFriendLike(String str, stSchema stschema) {
        this.nick = str;
        this.schema = stschema;
    }
}
