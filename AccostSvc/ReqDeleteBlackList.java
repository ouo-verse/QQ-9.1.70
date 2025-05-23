package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqDeleteBlackList extends JceStruct {
    static int cache_eType;
    static ReqHeader cache_stHeader;
    static ArrayList<Long> cache_vBlackList;
    public int eType;
    public ReqHeader stHeader;
    public ArrayList<Long> vBlackList;

    public ReqDeleteBlackList() {
        this.stHeader = null;
        this.vBlackList = null;
        this.eType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_vBlackList == null) {
            cache_vBlackList = new ArrayList<>();
            cache_vBlackList.add(0L);
        }
        this.vBlackList = (ArrayList) jceInputStream.read((JceInputStream) cache_vBlackList, 1, true);
        this.eType = jceInputStream.read(this.eType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((Collection) this.vBlackList, 1);
        jceOutputStream.write(this.eType, 2);
    }

    public ReqDeleteBlackList(ReqHeader reqHeader, ArrayList<Long> arrayList, int i3) {
        this.stHeader = reqHeader;
        this.vBlackList = arrayList;
        this.eType = i3;
    }
}
