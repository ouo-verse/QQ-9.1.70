package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AlbumInfo extends JceStruct {
    static ArrayList<PhotoInfo> cache_vPhotos;
    public ArrayList<PhotoInfo> vPhotos;

    public AlbumInfo() {
        this.vPhotos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vPhotos == null) {
            cache_vPhotos = new ArrayList<>();
            cache_vPhotos.add(new PhotoInfo());
        }
        this.vPhotos = (ArrayList) jceInputStream.read((JceInputStream) cache_vPhotos, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoInfo> arrayList = this.vPhotos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public AlbumInfo(ArrayList<PhotoInfo> arrayList) {
        this.vPhotos = arrayList;
    }
}
