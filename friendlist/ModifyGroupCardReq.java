package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModifyGroupCardReq extends JceStruct {
    static ArrayList<stUinInfo> cache_vecUinInfo;
    public long dwGroupCode;
    public long dwNewSeq;
    public long dwZero;
    public ArrayList<stUinInfo> vecUinInfo;

    public ModifyGroupCardReq() {
        this.dwZero = 0L;
        this.dwGroupCode = 0L;
        this.dwNewSeq = 0L;
        this.vecUinInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwZero = jceInputStream.read(this.dwZero, 0, true);
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 1, true);
        this.dwNewSeq = jceInputStream.read(this.dwNewSeq, 2, true);
        if (cache_vecUinInfo == null) {
            cache_vecUinInfo = new ArrayList<>();
            cache_vecUinInfo.add(new stUinInfo());
        }
        this.vecUinInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUinInfo, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwZero, 0);
        jceOutputStream.write(this.dwGroupCode, 1);
        jceOutputStream.write(this.dwNewSeq, 2);
        jceOutputStream.write((Collection) this.vecUinInfo, 3);
    }

    public ModifyGroupCardReq(long j3, long j16, long j17, ArrayList<stUinInfo> arrayList) {
        this.dwZero = j3;
        this.dwGroupCode = j16;
        this.dwNewSeq = j17;
        this.vecUinInfo = arrayList;
    }
}
