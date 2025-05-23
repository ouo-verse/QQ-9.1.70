package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMsgContent extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String btnWording;
    public String content;
    public String icon;
    public String picURL;
    public stSchema schema;
    public int templateID;
    public String title;

    public stMsgContent() {
        this.templateID = 0;
        this.title = "";
        this.icon = "";
        this.content = "";
        this.picURL = "";
        this.schema = null;
        this.btnWording = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.templateID = jceInputStream.read(this.templateID, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.icon = jceInputStream.readString(2, false);
        this.content = jceInputStream.readString(3, false);
        this.picURL = jceInputStream.readString(4, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 5, false);
        this.btnWording = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.templateID, 0);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.icon;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.picURL;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 5);
        }
        String str5 = this.btnWording;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
    }

    public stMsgContent(int i3, String str, String str2, String str3, String str4, stSchema stschema, String str5) {
        this.templateID = i3;
        this.title = str;
        this.icon = str2;
        this.content = str3;
        this.picURL = str4;
        this.schema = stschema;
        this.btnWording = str5;
    }
}
