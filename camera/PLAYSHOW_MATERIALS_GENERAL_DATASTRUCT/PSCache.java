package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PSCache extends JceStruct {
    static ArrayList<PSMetaCategory> cache_categories = new ArrayList<>();
    public ArrayList<PSMetaCategory> categories;
    public int createTime;

    static {
        cache_categories.add(new PSMetaCategory());
    }

    public PSCache() {
        this.createTime = 0;
        this.categories = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.createTime = jceInputStream.read(this.createTime, 0, false);
        this.categories = (ArrayList) jceInputStream.read((JceInputStream) cache_categories, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.createTime, 0);
        ArrayList<PSMetaCategory> arrayList = this.categories;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public PSCache(int i3, ArrayList<PSMetaCategory> arrayList) {
        this.createTime = i3;
        this.categories = arrayList;
    }
}
