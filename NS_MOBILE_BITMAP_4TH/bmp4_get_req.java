package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bmp4_get_req extends JceStruct {
    static ArrayList<String> cache_vec_keys;
    static ArrayList<Long> cache_vec_uins = new ArrayList<>();
    public int bitmap_id;
    public ArrayList<String> vec_keys;
    public ArrayList<Long> vec_uins;

    static {
        cache_vec_uins.add(0L);
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vec_keys = arrayList;
        arrayList.add("");
    }

    public bmp4_get_req() {
        this.vec_uins = null;
        this.vec_keys = null;
        this.bitmap_id = 4;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vec_uins = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_uins, 0, false);
        this.vec_keys = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_keys, 1, false);
        this.bitmap_id = jceInputStream.read(this.bitmap_id, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Long> arrayList = this.vec_uins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<String> arrayList2 = this.vec_keys;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
        jceOutputStream.write(this.bitmap_id, 2);
    }

    public bmp4_get_req(ArrayList<Long> arrayList, ArrayList<String> arrayList2, int i3) {
        this.vec_uins = arrayList;
        this.vec_keys = arrayList2;
        this.bitmap_id = i3;
    }
}
