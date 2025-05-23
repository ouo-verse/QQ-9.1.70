package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetMultiTroopInfoResp extends JceStruct {
    static int cache_result;
    static ArrayList<stTroopInfoV2> cache_vecTroopInfo;
    public short errorCode;
    public int result;
    public String sGroupClassXMLPath;
    public long uin;
    public ArrayList<stTroopInfoV2> vecTroopInfo;

    public GetMultiTroopInfoResp() {
        this.uin = 0L;
        this.result = 0;
        this.errorCode = (short) 0;
        this.vecTroopInfo = null;
        this.sGroupClassXMLPath = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        this.errorCode = jceInputStream.read(this.errorCode, 2, true);
        if (cache_vecTroopInfo == null) {
            cache_vecTroopInfo = new ArrayList<>();
            cache_vecTroopInfo.add(new stTroopInfoV2());
        }
        this.vecTroopInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopInfo, 3, true);
        this.sGroupClassXMLPath = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write(this.errorCode, 2);
        jceOutputStream.write((Collection) this.vecTroopInfo, 3);
        String str = this.sGroupClassXMLPath;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public GetMultiTroopInfoResp(long j3, int i3, short s16, ArrayList<stTroopInfoV2> arrayList, String str) {
        this.uin = j3;
        this.result = i3;
        this.errorCode = s16;
        this.vecTroopInfo = arrayList;
        this.sGroupClassXMLPath = str;
    }
}
