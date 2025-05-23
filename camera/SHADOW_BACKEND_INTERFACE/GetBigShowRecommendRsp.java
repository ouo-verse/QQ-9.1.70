package camera.SHADOW_BACKEND_INTERFACE;

import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBigShowRecommendRsp extends JceStruct {
    static ArrayList<BigShowRecommendInfo> cache_Materials = new ArrayList<>();
    public int Code;
    public ArrayList<BigShowRecommendInfo> Materials;

    static {
        cache_Materials.add(new BigShowRecommendInfo());
    }

    public GetBigShowRecommendRsp() {
        this.Code = 0;
        this.Materials = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Materials = (ArrayList) jceInputStream.read((JceInputStream) cache_Materials, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        ArrayList<BigShowRecommendInfo> arrayList = this.Materials;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetBigShowRecommendRsp(int i3, ArrayList<BigShowRecommendInfo> arrayList) {
        this.Code = i3;
        this.Materials = arrayList;
    }
}
