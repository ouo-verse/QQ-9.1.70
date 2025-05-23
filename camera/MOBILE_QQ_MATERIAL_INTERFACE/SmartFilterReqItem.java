package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SmartFilterReqItem extends JceStruct {
    static ArrayList<FaceRects> cache_Faces = new ArrayList<>();
    static byte[] cache_Rawdata;
    public ArrayList<FaceRects> Faces;
    public byte[] Rawdata;

    static {
        cache_Rawdata = r0;
        byte[] bArr = {0};
        cache_Faces.add(new FaceRects());
    }

    public SmartFilterReqItem() {
        this.Rawdata = null;
        this.Faces = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Rawdata = jceInputStream.read(cache_Rawdata, 0, false);
        this.Faces = (ArrayList) jceInputStream.read((JceInputStream) cache_Faces, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.Rawdata;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        ArrayList<FaceRects> arrayList = this.Faces;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public SmartFilterReqItem(byte[] bArr, ArrayList<FaceRects> arrayList) {
        this.Rawdata = bArr;
        this.Faces = arrayList;
    }
}
