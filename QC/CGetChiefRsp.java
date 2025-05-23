package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CGetChiefRsp extends JceStruct {
    static Map<String, String> cache_extParams;
    static ArrayList<ModuleData> cache_modData = new ArrayList<>();
    public String errmsg;
    public Map<String, String> extParams;
    public ArrayList<ModuleData> modData;
    public int ret;

    static {
        cache_modData.add(new ModuleData());
        HashMap hashMap = new HashMap();
        cache_extParams = hashMap;
        hashMap.put("", "");
    }

    public CGetChiefRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.modData = null;
        this.extParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.modData = (ArrayList) jceInputStream.read((JceInputStream) cache_modData, 2, false);
        this.extParams = (Map) jceInputStream.read((JceInputStream) cache_extParams, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<ModuleData> arrayList = this.modData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        Map<String, String> map = this.extParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public CGetChiefRsp(int i3, String str, ArrayList<ModuleData> arrayList, Map<String, String> map) {
        this.ret = i3;
        this.errmsg = str;
        this.modData = arrayList;
        this.extParams = map;
    }
}
