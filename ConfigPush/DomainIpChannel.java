package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DomainIpChannel extends JceStruct {
    static ArrayList<DomainIpList> cache_vDomain_iplists;
    public ArrayList<DomainIpList> vDomain_iplists;

    public DomainIpChannel() {
        this.vDomain_iplists = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vDomain_iplists == null) {
            cache_vDomain_iplists = new ArrayList<>();
            cache_vDomain_iplists.add(new DomainIpList());
        }
        this.vDomain_iplists = (ArrayList) jceInputStream.read((JceInputStream) cache_vDomain_iplists, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vDomain_iplists, 0);
    }

    public DomainIpChannel(ArrayList<DomainIpList> arrayList) {
        this.vDomain_iplists = arrayList;
    }
}
