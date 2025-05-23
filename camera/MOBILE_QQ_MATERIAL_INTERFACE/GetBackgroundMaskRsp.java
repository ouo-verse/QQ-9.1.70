package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public class GetBackgroundMaskRsp extends JceStruct {
    static Rect[] cache_Rects;
    static ArrayList<byte[]> cache_images;
    public int Code;
    public ArrayList<byte[]> Images;
    public Rect[] Rects;

    static {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_images = arrayList;
        arrayList.add(new byte[]{0});
        cache_Rects = new Rect[1];
        cache_Rects[0] = new Rect();
    }

    public GetBackgroundMaskRsp() {
        this.Code = 0;
        this.Images = null;
        this.Rects = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 1, false);
        this.Rects = (Rect[]) jceInputStream.read((JceStruct[]) cache_Rects, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        ArrayList<byte[]> arrayList = this.Images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Rect[] rectArr = this.Rects;
        if (rectArr != null) {
            jceOutputStream.write((Object[]) rectArr, 2);
        }
    }

    public GetBackgroundMaskRsp(int i3, ArrayList<byte[]> arrayList, Rect[] rectArr) {
        this.Code = i3;
        this.Images = arrayList;
        this.Rects = rectArr;
    }
}
