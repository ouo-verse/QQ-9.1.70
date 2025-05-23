package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBigShowRecommendReq extends JceStruct {
    static ArrayList<byte[]> cache_framePics;
    public int MediaType;
    public String SdkVersion;
    public ArrayList<byte[]> framePics;

    static {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_framePics = arrayList;
        arrayList.add(new byte[]{0});
    }

    public GetBigShowRecommendReq() {
        this.framePics = null;
        this.SdkVersion = "";
        this.MediaType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.framePics = (ArrayList) jceInputStream.read((JceInputStream) cache_framePics, 0, false);
        this.SdkVersion = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<byte[]> arrayList = this.framePics;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.SdkVersion;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.MediaType, 2);
    }

    public GetBigShowRecommendReq(ArrayList<byte[]> arrayList, String str, int i3) {
        this.framePics = arrayList;
        this.SdkVersion = str;
        this.MediaType = i3;
    }
}
