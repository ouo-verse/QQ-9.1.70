package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stTabInfo extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String displayIcon;
    public int displayType;

    /* renamed from: id, reason: collision with root package name */
    public int f25132id;
    public String name;
    public stSchema schema;

    public stTabInfo() {
        this.name = "";
        this.f25132id = 0;
        this.displayType = 0;
        this.displayIcon = "";
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.f25132id = jceInputStream.read(this.f25132id, 1, false);
        this.displayType = jceInputStream.read(this.displayType, 2, false);
        this.displayIcon = jceInputStream.readString(3, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.f25132id, 1);
        jceOutputStream.write(this.displayType, 2);
        String str2 = this.displayIcon;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 4);
        }
    }

    public stTabInfo(String str, int i3, int i16, String str2, stSchema stschema) {
        this.name = str;
        this.f25132id = i3;
        this.displayType = i16;
        this.displayIcon = str2;
        this.schema = stschema;
    }
}
