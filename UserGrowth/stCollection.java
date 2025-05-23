package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCollection extends JceStruct {
    static stSchema cache_schema = new stSchema();
    public String barText;
    public String cid;
    public int click_action;
    public int collectionType;
    public String cover;
    public String desc;
    public int feed_count;
    public String name;
    public stSchema schema;
    public String subTitle;

    public stCollection() {
        this.cid = "";
        this.name = "";
        this.desc = "";
        this.click_action = 0;
        this.schema = null;
        this.feed_count = 0;
        this.cover = "";
        this.subTitle = "";
        this.barText = "";
        this.collectionType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cid = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.click_action = jceInputStream.read(this.click_action, 3, false);
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 4, false);
        this.feed_count = jceInputStream.read(this.feed_count, 5, false);
        this.cover = jceInputStream.readString(6, false);
        this.subTitle = jceInputStream.readString(7, false);
        this.barText = jceInputStream.readString(8, false);
        this.collectionType = jceInputStream.read(this.collectionType, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.click_action, 3);
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 4);
        }
        jceOutputStream.write(this.feed_count, 5);
        String str4 = this.cover;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.subTitle;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.barText;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        jceOutputStream.write(this.collectionType, 9);
    }

    public stCollection(String str, String str2, String str3, int i3, stSchema stschema, int i16, String str4, String str5, String str6, int i17) {
        this.cid = str;
        this.name = str2;
        this.desc = str3;
        this.click_action = i3;
        this.schema = stschema;
        this.feed_count = i16;
        this.cover = str4;
        this.subTitle = str5;
        this.barText = str6;
        this.collectionType = i17;
    }
}
