package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PhotoSearchBoxItem extends JceStruct {
    static ArrayList<PhotoSearchBoxItemElem> cache_elems = new ArrayList<>();
    public String desc;
    public ArrayList<PhotoSearchBoxItemElem> elems;

    static {
        cache_elems.add(new PhotoSearchBoxItemElem());
    }

    public PhotoSearchBoxItem() {
        this.elems = null;
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.elems = (ArrayList) jceInputStream.read((JceInputStream) cache_elems, 0, false);
        this.desc = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoSearchBoxItemElem> arrayList = this.elems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public PhotoSearchBoxItem(ArrayList<PhotoSearchBoxItemElem> arrayList, String str) {
        this.elems = arrayList;
        this.desc = str;
    }
}
