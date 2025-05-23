package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ExtraImageInfo extends JceStruct {
    static ArrayList<String> cache_images;
    public ArrayList<String> images;
    public int isdynamic;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_images = arrayList;
        arrayList.add("");
    }

    public ExtraImageInfo() {
        this.isdynamic = 0;
        this.images = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isdynamic = jceInputStream.read(this.isdynamic, 0, false);
        this.images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isdynamic, 0);
        ArrayList<String> arrayList = this.images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public ExtraImageInfo(int i3, ArrayList<String> arrayList) {
        this.isdynamic = i3;
        this.images = arrayList;
    }
}
