package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAdsReq extends JceStruct {
    public ArrayList<AdPosItem> lstPos;
    public CommInfo stComminfo;
    static CommInfo cache_stComminfo = new CommInfo();
    static ArrayList<AdPosItem> cache_lstPos = new ArrayList<>();

    static {
        cache_lstPos.add(new AdPosItem());
    }

    public GetAdsReq() {
        this.stComminfo = null;
        this.lstPos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stComminfo = (CommInfo) jceInputStream.read((JceStruct) cache_stComminfo, 1, false);
        this.lstPos = (ArrayList) jceInputStream.read((JceInputStream) cache_lstPos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommInfo commInfo = this.stComminfo;
        if (commInfo != null) {
            jceOutputStream.write((JceStruct) commInfo, 1);
        }
        ArrayList<AdPosItem> arrayList = this.lstPos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetAdsReq(CommInfo commInfo, ArrayList<AdPosItem> arrayList) {
        this.stComminfo = commInfo;
        this.lstPos = arrayList;
    }
}
