package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FunnySpaceAction extends JceStruct {
    static ArrayList<Integer> cache_ComboIndexList;
    static Map<String, String> cache_ExtendInfo;
    public ArrayList<Integer> ComboIndexList;
    public Map<String, String> ExtendInfo;
    public String ID;
    public String LikeKey;
    public String Name;
    public int Type;
    public String Url;

    static {
        HashMap hashMap = new HashMap();
        cache_ExtendInfo = hashMap;
        hashMap.put("", "");
        cache_ComboIndexList = new ArrayList<>();
        cache_ComboIndexList.add(0);
    }

    public FunnySpaceAction() {
        this.ID = "";
        this.Type = 0;
        this.Name = "";
        this.LikeKey = "";
        this.Url = "";
        this.ExtendInfo = null;
        this.ComboIndexList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ID = jceInputStream.readString(0, false);
        this.Type = jceInputStream.read(this.Type, 1, false);
        this.Name = jceInputStream.readString(2, false);
        this.LikeKey = jceInputStream.readString(3, false);
        this.Url = jceInputStream.readString(4, false);
        this.ExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_ExtendInfo, 5, false);
        this.ComboIndexList = (ArrayList) jceInputStream.read((JceInputStream) cache_ComboIndexList, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.Type, 1);
        String str2 = this.Name;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.LikeKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.Url;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        Map<String, String> map = this.ExtendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        ArrayList<Integer> arrayList = this.ComboIndexList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
    }

    public FunnySpaceAction(String str, int i3, String str2, String str3, String str4, Map<String, String> map, ArrayList<Integer> arrayList) {
        this.ID = str;
        this.Type = i3;
        this.Name = str2;
        this.LikeKey = str3;
        this.Url = str4;
        this.ExtendInfo = map;
        this.ComboIndexList = arrayList;
    }
}
