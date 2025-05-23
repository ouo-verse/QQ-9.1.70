package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGetGroupMsgNum extends JceStruct {
    static ArrayList<SvcRequestGroupInfo> cache_vGroupInfo;
    public byte cVerifyType;
    public long lUin;
    public ArrayList<SvcRequestGroupInfo> vGroupInfo;

    public SvcRequestGetGroupMsgNum() {
        this.lUin = 0L;
        this.vGroupInfo = null;
        this.cVerifyType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new SvcRequestGroupInfo());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 1, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write((Collection) this.vGroupInfo, 1);
        jceOutputStream.write(this.cVerifyType, 2);
    }

    public SvcRequestGetGroupMsgNum(long j3, ArrayList<SvcRequestGroupInfo> arrayList, byte b16) {
        this.lUin = j3;
        this.vGroupInfo = arrayList;
        this.cVerifyType = b16;
    }
}
