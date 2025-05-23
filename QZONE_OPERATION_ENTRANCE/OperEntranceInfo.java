package QZONE_OPERATION_ENTRANCE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OperEntranceInfo extends JceStruct {
    static Map<Integer, EntranceRes> cache_resTable = new HashMap();
    private static final long serialVersionUID = 0;
    public Map<Integer, EntranceRes> resTable;

    static {
        cache_resTable.put(0, new EntranceRes());
    }

    public OperEntranceInfo() {
        this.resTable = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.resTable = (Map) jceInputStream.read((JceInputStream) cache_resTable, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, EntranceRes> map = this.resTable;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public OperEntranceInfo(Map<Integer, EntranceRes> map) {
        this.resTable = map;
    }
}
