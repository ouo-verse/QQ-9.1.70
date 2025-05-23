package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetHotState extends JceStruct {
    static BusiRespHead cache_oHead;
    static ArrayList<HotRishState> cache_vHostRichSateList;
    public BusiRespHead oHead;
    public ArrayList<HotRishState> vHostRichSateList;

    public RespGetHotState() {
        this.oHead = null;
        this.vHostRichSateList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_oHead == null) {
            cache_oHead = new BusiRespHead();
        }
        this.oHead = (BusiRespHead) jceInputStream.read((JceStruct) cache_oHead, 0, true);
        if (cache_vHostRichSateList == null) {
            cache_vHostRichSateList = new ArrayList<>();
            cache_vHostRichSateList.add(new HotRishState());
        }
        this.vHostRichSateList = (ArrayList) jceInputStream.read((JceInputStream) cache_vHostRichSateList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.oHead, 0);
        jceOutputStream.write((Collection) this.vHostRichSateList, 1);
    }

    public RespGetHotState(BusiRespHead busiRespHead, ArrayList<HotRishState> arrayList) {
        this.oHead = busiRespHead;
        this.vHostRichSateList = arrayList;
    }
}
