package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetDiscussInteRemark extends JceStruct {
    static ArrayList<Long> cache_UinList;
    public long DiscussUin;
    public ArrayList<Long> UinList;

    public ReqGetDiscussInteRemark() {
        this.DiscussUin = 0L;
        this.UinList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        if (cache_UinList == null) {
            cache_UinList = new ArrayList<>();
            cache_UinList.add(0L);
        }
        this.UinList = (ArrayList) jceInputStream.read((JceInputStream) cache_UinList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write((Collection) this.UinList, 1);
    }

    public ReqGetDiscussInteRemark(long j3, ArrayList<Long> arrayList) {
        this.DiscussUin = j3;
        this.UinList = arrayList;
    }
}
