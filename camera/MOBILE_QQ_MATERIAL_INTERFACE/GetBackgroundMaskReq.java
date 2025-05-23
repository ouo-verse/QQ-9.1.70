package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public class GetBackgroundMaskReq extends JceStruct {
    static ArrayList<byte[]> cache_images;
    public ArrayList<byte[]> Images;

    static {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_images = arrayList;
        arrayList.add(new byte[]{0});
    }

    public GetBackgroundMaskReq() {
        this.Images = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<byte[]> arrayList = this.Images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetBackgroundMaskReq(ArrayList<byte[]> arrayList) {
        this.Images = arrayList;
    }
}
