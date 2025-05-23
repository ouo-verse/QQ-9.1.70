package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetSwitches extends JceStruct {
    static RespHeader cache_stHeader;
    static ArrayList<Switch> cache_switches;
    public RespHeader stHeader;
    public ArrayList<Switch> switches;

    public RespGetSwitches() {
        this.stHeader = null;
        this.switches = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHeader();
        }
        this.stHeader = (RespHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_switches == null) {
            cache_switches = new ArrayList<>();
            cache_switches.add(new Switch());
        }
        this.switches = (ArrayList) jceInputStream.read((JceInputStream) cache_switches, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((Collection) this.switches, 1);
    }

    public RespGetSwitches(RespHeader respHeader, ArrayList<Switch> arrayList) {
        this.stHeader = respHeader;
        this.switches = arrayList;
    }
}
