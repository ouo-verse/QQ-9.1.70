package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDramaFall extends JceStruct {
    static stDrama cache_dramaInfo = new stDrama();
    static ArrayList<String> cache_images;
    public String bgCover;
    public stDrama dramaInfo;
    public ArrayList<String> images;
    public String titleCover;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_images = arrayList;
        arrayList.add("");
    }

    public stDramaFall() {
        this.dramaInfo = null;
        this.bgCover = "";
        this.titleCover = "";
        this.images = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaInfo = (stDrama) jceInputStream.read((JceStruct) cache_dramaInfo, 0, false);
        this.bgCover = jceInputStream.readString(1, false);
        this.titleCover = jceInputStream.readString(2, false);
        this.images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stDrama stdrama = this.dramaInfo;
        if (stdrama != null) {
            jceOutputStream.write((JceStruct) stdrama, 0);
        }
        String str = this.bgCover;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.titleCover;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<String> arrayList = this.images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public stDramaFall(stDrama stdrama, String str, String str2, ArrayList<String> arrayList) {
        this.dramaInfo = stdrama;
        this.bgCover = str;
        this.titleCover = str2;
        this.images = arrayList;
    }
}
