package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RspGetPoiListApi extends JceStruct {
    static GPS cache_stUsrLoc;
    static ArrayList<PoiInfo> cache_vPoiList;
    public int iTotalNum;
    public GPS stUsrLoc;
    public ArrayList<PoiInfo> vPoiList;

    public RspGetPoiListApi() {
        this.stUsrLoc = null;
        this.iTotalNum = 0;
        this.vPoiList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stUsrLoc == null) {
            cache_stUsrLoc = new GPS();
        }
        this.stUsrLoc = (GPS) jceInputStream.read((JceStruct) cache_stUsrLoc, 0, true);
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 1, true);
        if (cache_vPoiList == null) {
            cache_vPoiList = new ArrayList<>();
            cache_vPoiList.add(new PoiInfo());
        }
        this.vPoiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPoiList, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stUsrLoc, 0);
        jceOutputStream.write(this.iTotalNum, 1);
        jceOutputStream.write((Collection) this.vPoiList, 2);
    }

    public RspGetPoiListApi(GPS gps, int i3, ArrayList<PoiInfo> arrayList) {
        this.stUsrLoc = gps;
        this.iTotalNum = i3;
        this.vPoiList = arrayList;
    }
}
