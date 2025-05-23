package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGetConfMsgNum extends JceStruct {
    static ArrayList<Long> cache_vConfUin;
    public byte cVerifyType;
    public ArrayList<Long> vConfUin;

    public SvcRequestGetConfMsgNum() {
        this.vConfUin = null;
        this.cVerifyType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vConfUin == null) {
            cache_vConfUin = new ArrayList<>();
            cache_vConfUin.add(0L);
        }
        this.vConfUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vConfUin, 0, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vConfUin, 0);
        jceOutputStream.write(this.cVerifyType, 1);
    }

    public SvcRequestGetConfMsgNum(ArrayList<Long> arrayList, byte b16) {
        this.vConfUin = arrayList;
        this.cVerifyType = b16;
    }
}
