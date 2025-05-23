package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFunctionalIconInfo extends JceStruct {
    static stSchema cache_jump = new stSchema();
    public String imgUrl;
    public stSchema jump;
    public String text;

    public stFunctionalIconInfo() {
        this.jump = null;
        this.text = "";
        this.imgUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.jump = (stSchema) jceInputStream.read((JceStruct) cache_jump, 0, false);
        this.text = jceInputStream.readString(1, false);
        this.imgUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSchema stschema = this.jump;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 0);
        }
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.imgUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stFunctionalIconInfo(stSchema stschema, String str, String str2) {
        this.jump = stschema;
        this.text = str;
        this.imgUrl = str2;
    }
}
