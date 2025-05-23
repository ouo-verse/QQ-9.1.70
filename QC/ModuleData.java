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
public final class ModuleData extends JceStruct {
    static Map<String, String> cache_extModParams;
    static ArrayList<ItemDisDetail> cache_vitem = new ArrayList<>();
    public String cname;
    public Map<String, String> extModParams;
    public ArrayList<ItemDisDetail> vitem;

    static {
        cache_vitem.add(new ItemDisDetail());
        HashMap hashMap = new HashMap();
        cache_extModParams = hashMap;
        hashMap.put("", "");
    }

    public ModuleData() {
        this.cname = "";
        this.vitem = null;
        this.extModParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cname = jceInputStream.readString(0, false);
        this.vitem = (ArrayList) jceInputStream.read((JceInputStream) cache_vitem, 1, false);
        this.extModParams = (Map) jceInputStream.read((JceInputStream) cache_extModParams, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<ItemDisDetail> arrayList = this.vitem;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Map<String, String> map = this.extModParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public ModuleData(String str, ArrayList<ItemDisDetail> arrayList, Map<String, String> map) {
        this.cname = str;
        this.vitem = arrayList;
        this.extModParams = map;
    }
}
