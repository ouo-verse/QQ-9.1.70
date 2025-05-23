package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetPoiInfoRsp_V2 extends JceStruct {
    static ArrayList<PoiInfo_V2> cache_vPoiList = new ArrayList<>();
    public int iHasMore;
    public int iTotalNum;
    public String request_id;
    public String strAttachInfo;
    public ArrayList<PoiInfo_V2> vPoiList;

    static {
        cache_vPoiList.add(new PoiInfo_V2());
    }

    public GetPoiInfoRsp_V2() {
        this.vPoiList = null;
        this.iTotalNum = 0;
        this.strAttachInfo = "";
        this.iHasMore = 1;
        this.request_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vPoiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPoiList, 0, true);
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 1, false);
        this.strAttachInfo = jceInputStream.readString(2, false);
        this.iHasMore = jceInputStream.read(this.iHasMore, 3, false);
        this.request_id = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vPoiList, 0);
        jceOutputStream.write(this.iTotalNum, 1);
        String str = this.strAttachInfo;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iHasMore, 3);
        String str2 = this.request_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GetPoiInfoRsp_V2(ArrayList<PoiInfo_V2> arrayList, int i3, String str, int i16, String str2) {
        this.vPoiList = arrayList;
        this.iTotalNum = i3;
        this.strAttachInfo = str;
        this.iHasMore = i16;
        this.request_id = str2;
    }
}
