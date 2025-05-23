package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stFirstPageSubjectInfo extends JceStruct {
    static stSchema cache_schema;
    static ArrayList<stNotifyMsg> cache_topContent = new ArrayList<>();
    public int ID;
    public String name;
    public int redCount;
    public stSchema schema;
    public ArrayList<stNotifyMsg> topContent;

    static {
        cache_topContent.add(new stNotifyMsg());
        cache_schema = new stSchema();
    }

    public stFirstPageSubjectInfo() {
        this.ID = 0;
        this.name = "";
        this.redCount = 0;
        this.topContent = null;
        this.schema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ID = jceInputStream.read(this.ID, 0, false);
        this.name = jceInputStream.readString(1, false);
        this.redCount = jceInputStream.read(this.redCount, 2, false);
        this.topContent = (ArrayList) jceInputStream.read((JceInputStream) cache_topContent, 3, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ID, 0);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.redCount, 2);
        ArrayList<stNotifyMsg> arrayList = this.topContent;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 4);
        }
    }

    public stFirstPageSubjectInfo(int i3, String str, int i16, ArrayList<stNotifyMsg> arrayList, stSchema stschema) {
        this.ID = i3;
        this.name = str;
        this.redCount = i16;
        this.topContent = arrayList;
        this.schema = stschema;
    }
}
