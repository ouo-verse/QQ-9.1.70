package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetFeedIconOpReq extends JceStruct {
    static ArrayList<stFeedOpInfo> cache_postOpInfos;
    public stFeedOpInfo opInfo;
    public ArrayList<stFeedOpInfo> postOpInfos;
    public ArrayList<stFeedOpInfo> preOpInfos;
    static stFeedOpInfo cache_opInfo = new stFeedOpInfo();
    static ArrayList<stFeedOpInfo> cache_preOpInfos = new ArrayList<>();

    static {
        cache_preOpInfos.add(new stFeedOpInfo());
        cache_postOpInfos = new ArrayList<>();
        cache_postOpInfos.add(new stFeedOpInfo());
    }

    public stGetFeedIconOpReq() {
        this.opInfo = null;
        this.preOpInfos = null;
        this.postOpInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.opInfo = (stFeedOpInfo) jceInputStream.read((JceStruct) cache_opInfo, 0, false);
        this.preOpInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_preOpInfos, 1, false);
        this.postOpInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_postOpInfos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stFeedOpInfo stfeedopinfo = this.opInfo;
        if (stfeedopinfo != null) {
            jceOutputStream.write((JceStruct) stfeedopinfo, 0);
        }
        ArrayList<stFeedOpInfo> arrayList = this.preOpInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<stFeedOpInfo> arrayList2 = this.postOpInfos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public stGetFeedIconOpReq(stFeedOpInfo stfeedopinfo, ArrayList<stFeedOpInfo> arrayList, ArrayList<stFeedOpInfo> arrayList2) {
        this.opInfo = stfeedopinfo;
        this.preOpInfos = arrayList;
        this.postOpInfos = arrayList2;
    }
}
