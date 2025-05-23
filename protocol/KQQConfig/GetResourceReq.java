package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceReq extends JceStruct {
    static ArrayList<GetResourceReqInfo> cache_vecResReqInfo;
    public short sLanCodeType;
    public ArrayList<GetResourceReqInfo> vecResReqInfo;

    public GetResourceReq() {
        this.vecResReqInfo = null;
        this.sLanCodeType = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecResReqInfo == null) {
            cache_vecResReqInfo = new ArrayList<>();
            cache_vecResReqInfo.add(new GetResourceReqInfo());
        }
        this.vecResReqInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResReqInfo, 1, true);
        this.sLanCodeType = jceInputStream.read(this.sLanCodeType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecResReqInfo, 1);
        jceOutputStream.write(this.sLanCodeType, 2);
    }

    public GetResourceReq(ArrayList<GetResourceReqInfo> arrayList, short s16) {
        this.vecResReqInfo = arrayList;
        this.sLanCodeType = s16;
    }
}
