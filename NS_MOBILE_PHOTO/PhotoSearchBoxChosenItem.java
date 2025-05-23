package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PhotoSearchBoxChosenItem extends JceStruct {
    static ArrayList<PhotoSearchBoxChosenItemElem> cache_elems = new ArrayList<>();
    public ArrayList<PhotoSearchBoxChosenItemElem> elems;

    static {
        cache_elems.add(new PhotoSearchBoxChosenItemElem());
    }

    public PhotoSearchBoxChosenItem() {
        this.elems = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.elems = (ArrayList) jceInputStream.read((JceInputStream) cache_elems, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoSearchBoxChosenItemElem> arrayList = this.elems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public PhotoSearchBoxChosenItem(ArrayList<PhotoSearchBoxChosenItemElem> arrayList) {
        this.elems = arrayList;
    }
}
