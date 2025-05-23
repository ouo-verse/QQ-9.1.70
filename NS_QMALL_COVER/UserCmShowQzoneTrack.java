package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserCmShowQzoneTrack extends JceStruct {
    static ArrayList<CmShowQzoneTrack> cache_vecQzoneTrack = new ArrayList<>();
    static ArrayList<CmShowQzoneTrack> cache_vecQzoneTrack3D;
    public ArrayList<CmShowQzoneTrack> vecQzoneTrack;
    public ArrayList<CmShowQzoneTrack> vecQzoneTrack3D;

    static {
        cache_vecQzoneTrack.add(new CmShowQzoneTrack());
        cache_vecQzoneTrack3D = new ArrayList<>();
        cache_vecQzoneTrack3D.add(new CmShowQzoneTrack());
    }

    public UserCmShowQzoneTrack() {
        this.vecQzoneTrack = null;
        this.vecQzoneTrack3D = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecQzoneTrack = (ArrayList) jceInputStream.read((JceInputStream) cache_vecQzoneTrack, 0, false);
        this.vecQzoneTrack3D = (ArrayList) jceInputStream.read((JceInputStream) cache_vecQzoneTrack3D, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<CmShowQzoneTrack> arrayList = this.vecQzoneTrack;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<CmShowQzoneTrack> arrayList2 = this.vecQzoneTrack3D;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
    }

    public UserCmShowQzoneTrack(ArrayList<CmShowQzoneTrack> arrayList, ArrayList<CmShowQzoneTrack> arrayList2) {
        this.vecQzoneTrack = arrayList;
        this.vecQzoneTrack3D = arrayList2;
    }
}
