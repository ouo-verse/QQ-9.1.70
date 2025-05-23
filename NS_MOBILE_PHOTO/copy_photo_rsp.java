package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class copy_photo_rsp extends JceStruct {
    static ArrayList<st_copy_photo> cache_fails = new ArrayList<>();
    public ArrayList<st_copy_photo> fails;

    static {
        cache_fails.add(new st_copy_photo());
    }

    public copy_photo_rsp() {
        this.fails = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fails = (ArrayList) jceInputStream.read((JceInputStream) cache_fails, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.fails, 0);
    }

    public copy_photo_rsp(ArrayList<st_copy_photo> arrayList) {
        this.fails = arrayList;
    }
}
