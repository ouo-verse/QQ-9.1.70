package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetMultiTroopInfoReq extends JceStruct {
    static ArrayList<Long> cache_vecGroupCode;
    public byte cRichInfo;
    public long uin;
    public ArrayList<Long> vecGroupCode;

    public GetMultiTroopInfoReq() {
        this.uin = 0L;
        this.vecGroupCode = null;
        this.cRichInfo = (byte) 0;
    }

    public String className() {
        return "friendlist.GetMultiTroopInfoReq";
    }

    public String fullClassName() {
        return "friendlist.GetMultiTroopInfoReq";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        if (cache_vecGroupCode == null) {
            cache_vecGroupCode = new ArrayList<>();
            cache_vecGroupCode.add(0L);
        }
        this.vecGroupCode = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGroupCode, 1, true);
        this.cRichInfo = jceInputStream.read(this.cRichInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((Collection) this.vecGroupCode, 1);
        jceOutputStream.write(this.cRichInfo, 2);
    }

    public GetMultiTroopInfoReq(long j3, ArrayList<Long> arrayList, byte b16) {
        this.uin = j3;
        this.vecGroupCode = arrayList;
        this.cRichInfo = b16;
    }
}
