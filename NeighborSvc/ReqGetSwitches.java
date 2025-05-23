package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetSwitches extends JceStruct {
    static ReqHeader cache_stHeader;
    static ArrayList<Integer> cache_types;
    public ReqHeader stHeader;
    public ArrayList<Integer> types;

    public ReqGetSwitches() {
        this.stHeader = null;
        this.types = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_types == null) {
            cache_types = new ArrayList<>();
            cache_types.add(0);
        }
        this.types = (ArrayList) jceInputStream.read((JceInputStream) cache_types, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((Collection) this.types, 1);
    }

    public ReqGetSwitches(ReqHeader reqHeader, ArrayList<Integer> arrayList) {
        this.stHeader = reqHeader;
        this.types = arrayList;
    }
}
