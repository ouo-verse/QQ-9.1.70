package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BigDataIpList extends JceStruct {
    static ArrayList<NetSegConf> cache_netSegConfs;
    static ArrayList<BigDataIpInfo> cache_vIplist;
    public ArrayList<NetSegConf> netSegConfs;
    public long uService_type;
    public long ufragment_size;
    public ArrayList<BigDataIpInfo> vIplist;

    public BigDataIpList() {
        this.uService_type = 0L;
        this.vIplist = null;
        this.netSegConfs = null;
        this.ufragment_size = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uService_type = jceInputStream.read(this.uService_type, 0, true);
        if (cache_vIplist == null) {
            cache_vIplist = new ArrayList<>();
            cache_vIplist.add(new BigDataIpInfo());
        }
        this.vIplist = (ArrayList) jceInputStream.read((JceInputStream) cache_vIplist, 1, true);
        if (cache_netSegConfs == null) {
            cache_netSegConfs = new ArrayList<>();
            cache_netSegConfs.add(new NetSegConf());
        }
        this.netSegConfs = (ArrayList) jceInputStream.read((JceInputStream) cache_netSegConfs, 2, false);
        this.ufragment_size = jceInputStream.read(this.ufragment_size, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uService_type, 0);
        jceOutputStream.write((Collection) this.vIplist, 1);
        ArrayList<NetSegConf> arrayList = this.netSegConfs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.ufragment_size, 3);
    }

    public BigDataIpList(long j3, ArrayList<BigDataIpInfo> arrayList, ArrayList<NetSegConf> arrayList2, long j16) {
        this.uService_type = j3;
        this.vIplist = arrayList;
        this.netSegConfs = arrayList2;
        this.ufragment_size = j16;
    }
}
