package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stLabelInfo extends JceStruct {
    static ArrayList<String> cache_labels;
    public ArrayList<String> labels;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_labels = arrayList;
        arrayList.add("");
    }

    public stLabelInfo() {
        this.labels = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.labels = (ArrayList) jceInputStream.read((JceInputStream) cache_labels, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.labels;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stLabelInfo(ArrayList<String> arrayList) {
        this.labels = arrayList;
    }
}
