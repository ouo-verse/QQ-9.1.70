package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stToOpenSpaceUins extends JceStruct {
    static ArrayList<String> cache_toOpenSpacesUins;
    public ArrayList<String> toOpenSpacesUins;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_toOpenSpacesUins = arrayList;
        arrayList.add("");
    }

    public stToOpenSpaceUins() {
        this.toOpenSpacesUins = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.toOpenSpacesUins = (ArrayList) jceInputStream.read((JceInputStream) cache_toOpenSpacesUins, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.toOpenSpacesUins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stToOpenSpaceUins(ArrayList<String> arrayList) {
        this.toOpenSpacesUins = arrayList;
    }
}
