package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DomainIpList extends JceStruct {
    static ArrayList<DomainIpInfo> cache_vIplist;
    public int uDomain_type;
    public ArrayList<DomainIpInfo> vIplist;

    public DomainIpList() {
        this.uDomain_type = 0;
        this.vIplist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uDomain_type = jceInputStream.read(this.uDomain_type, 0, true);
        if (cache_vIplist == null) {
            cache_vIplist = new ArrayList<>();
            cache_vIplist.add(new DomainIpInfo());
        }
        this.vIplist = (ArrayList) jceInputStream.read((JceInputStream) cache_vIplist, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uDomain_type, 0);
        jceOutputStream.write((Collection) this.vIplist, 1);
    }

    public DomainIpList(int i3, ArrayList<DomainIpInfo> arrayList) {
        this.uDomain_type = i3;
        this.vIplist = arrayList;
    }
}
