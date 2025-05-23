package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_LabelInfo extends JceStruct {
    static ArrayList<String> cache_client_groupid;
    static ArrayList<String> cache_labels;
    public ArrayList<String> client_groupid;
    public ArrayList<String> labels;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_labels = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_client_groupid = arrayList2;
        arrayList2.add("");
    }

    public s_LabelInfo() {
        this.labels = null;
        this.client_groupid = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.labels = (ArrayList) jceInputStream.read((JceInputStream) cache_labels, 0, false);
        this.client_groupid = (ArrayList) jceInputStream.read((JceInputStream) cache_client_groupid, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.labels;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<String> arrayList2 = this.client_groupid;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
    }

    public s_LabelInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.labels = arrayList;
        this.client_groupid = arrayList2;
    }
}
