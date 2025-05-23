package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCollectionCardInfo extends JceStruct {
    static ArrayList<stCollection> cache_collectionList = new ArrayList<>();
    public ArrayList<stCollection> collectionList;
    public String title;

    static {
        cache_collectionList.add(new stCollection());
    }

    public stCollectionCardInfo() {
        this.collectionList = null;
        this.title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.collectionList = (ArrayList) jceInputStream.read((JceInputStream) cache_collectionList, 0, false);
        this.title = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stCollection> arrayList = this.collectionList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stCollectionCardInfo(ArrayList<stCollection> arrayList, String str) {
        this.collectionList = arrayList;
        this.title = str;
    }
}
