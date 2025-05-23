package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetBlackList extends JceStruct {
    static RespHeader cache_stHeader;
    static ArrayList<BlackSimpleInfo> cache_vBlackList;
    static ArrayList<Long> cache_vBlackListUin;
    static ArrayList<Long> cache_vMobileBlackListUin;
    public long lNextMid;
    public RespHeader stHeader;
    public ArrayList<BlackSimpleInfo> vBlackList;
    public ArrayList<Long> vBlackListUin;
    public ArrayList<Long> vMobileBlackListUin;

    public RespGetBlackList() {
        this.stHeader = null;
        this.lNextMid = -1L;
        this.vBlackList = null;
        this.vBlackListUin = null;
        this.vMobileBlackListUin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHeader();
        }
        this.stHeader = (RespHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lNextMid = jceInputStream.read(this.lNextMid, 1, true);
        if (cache_vBlackList == null) {
            cache_vBlackList = new ArrayList<>();
            cache_vBlackList.add(new BlackSimpleInfo());
        }
        this.vBlackList = (ArrayList) jceInputStream.read((JceInputStream) cache_vBlackList, 2, false);
        if (cache_vBlackListUin == null) {
            cache_vBlackListUin = new ArrayList<>();
            cache_vBlackListUin.add(0L);
        }
        this.vBlackListUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vBlackListUin, 3, false);
        if (cache_vMobileBlackListUin == null) {
            cache_vMobileBlackListUin = new ArrayList<>();
            cache_vMobileBlackListUin.add(0L);
        }
        this.vMobileBlackListUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vMobileBlackListUin, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lNextMid, 1);
        ArrayList<BlackSimpleInfo> arrayList = this.vBlackList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<Long> arrayList2 = this.vBlackListUin;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<Long> arrayList3 = this.vMobileBlackListUin;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
    }

    public RespGetBlackList(RespHeader respHeader, long j3, ArrayList<BlackSimpleInfo> arrayList, ArrayList<Long> arrayList2, ArrayList<Long> arrayList3) {
        this.stHeader = respHeader;
        this.lNextMid = j3;
        this.vBlackList = arrayList;
        this.vBlackListUin = arrayList2;
        this.vMobileBlackListUin = arrayList3;
    }
}
