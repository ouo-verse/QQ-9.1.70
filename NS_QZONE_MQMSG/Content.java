package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Content extends JceStruct {
    static ArrayList<PhotoCell> cache_vecPhotoCell = new ArrayList<>();
    public String contentMainTitle;
    public String contentSmallTitle;
    public int mediaType;
    public ArrayList<PhotoCell> vecPhotoCell;

    static {
        cache_vecPhotoCell.add(new PhotoCell());
    }

    public Content() {
        this.mediaType = 0;
        this.contentMainTitle = "";
        this.contentSmallTitle = "";
        this.vecPhotoCell = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mediaType = jceInputStream.read(this.mediaType, 0, false);
        this.contentMainTitle = jceInputStream.readString(1, false);
        this.contentSmallTitle = jceInputStream.readString(2, false);
        this.vecPhotoCell = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPhotoCell, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mediaType, 0);
        String str = this.contentMainTitle;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.contentSmallTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<PhotoCell> arrayList = this.vecPhotoCell;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public Content(int i3, String str, String str2, ArrayList<PhotoCell> arrayList) {
        this.mediaType = i3;
        this.contentMainTitle = str;
        this.contentSmallTitle = str2;
        this.vecPhotoCell = arrayList;
    }
}
