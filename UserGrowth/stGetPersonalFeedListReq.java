package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stGetPersonalFeedListReq extends JceStruct {
    static ArrayList<String> cache_context_feedids;
    public String attach_info;
    public ArrayList<String> context_feedids;
    public boolean isFirst;
    public String personId;
    public int reqType;
    public int scene;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_context_feedids = arrayList;
        arrayList.add("");
    }

    public stGetPersonalFeedListReq() {
        this.personId = "";
        this.context_feedids = null;
        this.attach_info = "";
        this.isFirst = true;
        this.scene = 0;
        this.reqType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.personId = jceInputStream.readString(0, false);
        this.context_feedids = (ArrayList) jceInputStream.read((JceInputStream) cache_context_feedids, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
        this.isFirst = jceInputStream.read(this.isFirst, 3, false);
        this.scene = jceInputStream.read(this.scene, 4, false);
        this.reqType = jceInputStream.read(this.reqType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.personId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<String> arrayList = this.context_feedids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str2 = this.attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.isFirst, 3);
        jceOutputStream.write(this.scene, 4);
        jceOutputStream.write(this.reqType, 5);
    }

    public stGetPersonalFeedListReq(String str, ArrayList<String> arrayList, String str2, boolean z16, int i3, int i16) {
        this.personId = str;
        this.context_feedids = arrayList;
        this.attach_info = str2;
        this.isFirst = z16;
        this.scene = i3;
        this.reqType = i16;
    }
}
