package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRichSigReq extends JceStruct {
    static ArrayList<ReqRichInfo> cache_vstReqRichInfo;
    public boolean checkupdate;
    public boolean get_large_tlv;
    public boolean showdatesig;
    public ArrayList<ReqRichInfo> vstReqRichInfo;

    public GetRichSigReq() {
        this.vstReqRichInfo = null;
        this.checkupdate = false;
        this.showdatesig = false;
        this.get_large_tlv = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vstReqRichInfo == null) {
            cache_vstReqRichInfo = new ArrayList<>();
            cache_vstReqRichInfo.add(new ReqRichInfo());
        }
        this.vstReqRichInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vstReqRichInfo, 1, true);
        this.checkupdate = jceInputStream.read(this.checkupdate, 2, false);
        this.showdatesig = jceInputStream.read(this.showdatesig, 3, false);
        this.get_large_tlv = jceInputStream.read(this.get_large_tlv, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vstReqRichInfo, 1);
        jceOutputStream.write(this.checkupdate, 2);
        jceOutputStream.write(this.showdatesig, 3);
        jceOutputStream.write(this.get_large_tlv, 4);
    }

    public GetRichSigReq(ArrayList<ReqRichInfo> arrayList, boolean z16, boolean z17, boolean z18) {
        this.vstReqRichInfo = arrayList;
        this.checkupdate = z16;
        this.showdatesig = z17;
        this.get_large_tlv = z18;
    }
}
