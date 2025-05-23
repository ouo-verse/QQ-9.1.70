package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class label_show_info extends JceStruct {
    static ArrayList<String> cache_labelids;
    public String label;
    public ArrayList<String> labelids;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_labelids = arrayList;
        arrayList.add("");
    }

    public label_show_info() {
        this.label = "";
        this.labelids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.label = jceInputStream.readString(0, false);
        this.labelids = (ArrayList) jceInputStream.read((JceInputStream) cache_labelids, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.label;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<String> arrayList = this.labelids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public label_show_info(String str, ArrayList<String> arrayList) {
        this.label = str;
        this.labelids = arrayList;
    }
}
