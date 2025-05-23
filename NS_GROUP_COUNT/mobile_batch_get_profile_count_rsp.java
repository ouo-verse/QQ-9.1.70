package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_batch_get_profile_count_rsp extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static ArrayList<profile_count_item> cache_profileCountItems = new ArrayList<>();
    public Map<String, String> extendinfo;
    public int iNextTimeout;
    public int iNextUinsBufCount;
    public String iconURL;
    public ArrayList<profile_count_item> profileCountItems;

    static {
        cache_profileCountItems.add(new profile_count_item());
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_batch_get_profile_count_rsp() {
        this.profileCountItems = null;
        this.iNextTimeout = 0;
        this.iNextUinsBufCount = 0;
        this.iconURL = "";
        this.extendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.profileCountItems = (ArrayList) jceInputStream.read((JceInputStream) cache_profileCountItems, 0, false);
        this.iNextTimeout = jceInputStream.read(this.iNextTimeout, 1, false);
        this.iNextUinsBufCount = jceInputStream.read(this.iNextUinsBufCount, 2, false);
        this.iconURL = jceInputStream.readString(3, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<profile_count_item> arrayList = this.profileCountItems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.iNextTimeout, 1);
        jceOutputStream.write(this.iNextUinsBufCount, 2);
        String str = this.iconURL;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public mobile_batch_get_profile_count_rsp(ArrayList<profile_count_item> arrayList, int i3, int i16, String str, Map<String, String> map) {
        this.profileCountItems = arrayList;
        this.iNextTimeout = i3;
        this.iNextUinsBufCount = i16;
        this.iconURL = str;
        this.extendinfo = map;
    }
}
