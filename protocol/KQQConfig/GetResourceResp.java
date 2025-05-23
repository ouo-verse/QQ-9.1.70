package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceResp extends JceStruct {
    static ArrayList<GetResourceRespInfo> cache_vecResRespInfo;
    public ArrayList<GetResourceRespInfo> vecResRespInfo;

    public GetResourceResp() {
        this.vecResRespInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecResRespInfo == null) {
            cache_vecResRespInfo = new ArrayList<>();
            cache_vecResRespInfo.add(new GetResourceRespInfo());
        }
        this.vecResRespInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResRespInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecResRespInfo, 1);
    }

    public GetResourceResp(ArrayList<GetResourceRespInfo> arrayList) {
        this.vecResRespInfo = arrayList;
    }
}
