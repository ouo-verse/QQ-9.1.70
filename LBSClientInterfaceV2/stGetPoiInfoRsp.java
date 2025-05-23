package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stGetPoiInfoRsp extends JceStruct {
    static ArrayList<stPoiInfo> cache_vPoiList;
    public int iTotalNum;
    public ArrayList<stPoiInfo> vPoiList;

    public stGetPoiInfoRsp() {
        this.vPoiList = null;
        this.iTotalNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vPoiList == null) {
            cache_vPoiList = new ArrayList<>();
            cache_vPoiList.add(new stPoiInfo());
        }
        this.vPoiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPoiList, 0, true);
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vPoiList, 0);
        jceOutputStream.write(this.iTotalNum, 1);
    }

    public stGetPoiInfoRsp(ArrayList<stPoiInfo> arrayList, int i3) {
        this.vPoiList = arrayList;
        this.iTotalNum = i3;
    }
}
