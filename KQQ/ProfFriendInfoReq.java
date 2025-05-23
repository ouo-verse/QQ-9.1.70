package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfFriendInfoReq extends JceStruct {
    static ArrayList<Short> cache_vFieldIdList;
    public byte cDataCode;
    public long uFriendUin;
    public ArrayList<Short> vFieldIdList;

    public ProfFriendInfoReq() {
        this.uFriendUin = 0L;
        this.cDataCode = (byte) 0;
        this.vFieldIdList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFriendUin = jceInputStream.read(this.uFriendUin, 0, true);
        this.cDataCode = jceInputStream.read(this.cDataCode, 1, true);
        if (cache_vFieldIdList == null) {
            cache_vFieldIdList = new ArrayList<>();
            cache_vFieldIdList.add((short) 0);
        }
        this.vFieldIdList = (ArrayList) jceInputStream.read((JceInputStream) cache_vFieldIdList, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFriendUin, 0);
        jceOutputStream.write(this.cDataCode, 1);
        jceOutputStream.write((Collection) this.vFieldIdList, 2);
    }

    public ProfFriendInfoReq(long j3, byte b16, ArrayList<Short> arrayList) {
        this.uFriendUin = j3;
        this.cDataCode = b16;
        this.vFieldIdList = arrayList;
    }
}
