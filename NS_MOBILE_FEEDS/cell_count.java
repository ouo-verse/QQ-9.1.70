package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_count extends JceStruct {
    static ArrayList<multiple_count> cache_mulcount = new ArrayList<>();
    public String desc;
    public String icon;
    public int icon_height;
    public int icon_width;
    public ArrayList<multiple_count> mulcount;
    public int num;
    public int type;

    static {
        cache_mulcount.add(new multiple_count());
    }

    public cell_count() {
        this.type = 0;
        this.num = 0;
        this.icon = "";
        this.desc = "";
        this.icon_width = 0;
        this.icon_height = 0;
        this.mulcount = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.num = jceInputStream.read(this.num, 1, false);
        this.icon = jceInputStream.readString(2, false);
        this.desc = jceInputStream.readString(3, false);
        this.icon_width = jceInputStream.read(this.icon_width, 4, false);
        this.icon_height = jceInputStream.read(this.icon_height, 5, false);
        this.mulcount = (ArrayList) jceInputStream.read((JceInputStream) cache_mulcount, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.num, 1);
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.icon_width, 4);
        jceOutputStream.write(this.icon_height, 5);
        ArrayList<multiple_count> arrayList = this.mulcount;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
    }

    public cell_count(int i3, int i16, String str, String str2, int i17, int i18, ArrayList<multiple_count> arrayList) {
        this.type = i3;
        this.num = i16;
        this.icon = str;
        this.desc = str2;
        this.icon_width = i17;
        this.icon_height = i18;
        this.mulcount = arrayList;
    }
}
