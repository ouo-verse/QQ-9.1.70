package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetHorseRaceMaterialsRsp extends JceStruct {
    static ArrayList<MaterialRaceInfo> cache_RaceMaterialList = new ArrayList<>();
    public int Code;
    public ArrayList<MaterialRaceInfo> RaceMaterialList;

    static {
        cache_RaceMaterialList.add(new MaterialRaceInfo());
    }

    public GetHorseRaceMaterialsRsp() {
        this.Code = 0;
        this.RaceMaterialList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.RaceMaterialList = (ArrayList) jceInputStream.read((JceInputStream) cache_RaceMaterialList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        ArrayList<MaterialRaceInfo> arrayList = this.RaceMaterialList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetHorseRaceMaterialsRsp(int i3, ArrayList<MaterialRaceInfo> arrayList) {
        this.Code = i3;
        this.RaceMaterialList = arrayList;
    }
}
