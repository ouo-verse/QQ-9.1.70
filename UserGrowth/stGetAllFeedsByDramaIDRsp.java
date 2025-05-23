package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetAllFeedsByDramaIDRsp extends JceStruct {
    static ArrayList<String> cache_feedIDs;
    public ArrayList<String> feedIDs;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_feedIDs = arrayList;
        arrayList.add("");
    }

    public stGetAllFeedsByDramaIDRsp() {
        this.feedIDs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feedIDs = (ArrayList) jceInputStream.read((JceInputStream) cache_feedIDs, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.feedIDs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stGetAllFeedsByDramaIDRsp(ArrayList<String> arrayList) {
        this.feedIDs = arrayList;
    }
}
