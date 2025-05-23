package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceRespV2 extends JceStruct {
    static ArrayList<GetResourceRespInfoV2> cache_vecAddedResInfo;
    static ArrayList<GetResourceRespInfoV2> cache_vecDeletedResInfo;
    static ArrayList<GetResourceRespInfoV2> cache_vecUpdatedResInfo;
    public byte result;
    public long uin;
    public ArrayList<GetResourceRespInfoV2> vecAddedResInfo;
    public ArrayList<GetResourceRespInfoV2> vecDeletedResInfo;
    public ArrayList<GetResourceRespInfoV2> vecUpdatedResInfo;

    public GetResourceRespV2() {
        this.uin = 0L;
        this.result = (byte) 0;
        this.vecAddedResInfo = null;
        this.vecDeletedResInfo = null;
        this.vecUpdatedResInfo = null;
    }

    public String className() {
        return "KQQConfig.GetResourceRespV2";
    }

    public String fullClassName() {
        return "protocol.KQQConfig.GetResourceRespV2";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        if (cache_vecAddedResInfo == null) {
            cache_vecAddedResInfo = new ArrayList<>();
            cache_vecAddedResInfo.add(new GetResourceRespInfoV2());
        }
        this.vecAddedResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAddedResInfo, 2, true);
        if (cache_vecDeletedResInfo == null) {
            cache_vecDeletedResInfo = new ArrayList<>();
            cache_vecDeletedResInfo.add(new GetResourceRespInfoV2());
        }
        this.vecDeletedResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecDeletedResInfo, 3, true);
        if (cache_vecUpdatedResInfo == null) {
            cache_vecUpdatedResInfo = new ArrayList<>();
            cache_vecUpdatedResInfo.add(new GetResourceRespInfoV2());
        }
        this.vecUpdatedResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUpdatedResInfo, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write((Collection) this.vecAddedResInfo, 2);
        jceOutputStream.write((Collection) this.vecDeletedResInfo, 3);
        jceOutputStream.write((Collection) this.vecUpdatedResInfo, 4);
    }

    public GetResourceRespV2(long j3, byte b16, ArrayList<GetResourceRespInfoV2> arrayList, ArrayList<GetResourceRespInfoV2> arrayList2, ArrayList<GetResourceRespInfoV2> arrayList3) {
        this.uin = j3;
        this.result = b16;
        this.vecAddedResInfo = arrayList;
        this.vecDeletedResInfo = arrayList2;
        this.vecUpdatedResInfo = arrayList3;
    }
}
