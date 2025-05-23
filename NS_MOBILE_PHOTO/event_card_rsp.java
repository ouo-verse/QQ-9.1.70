package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_card_rsp extends JceStruct {
    static Map<String, String> cache_ext;
    static ArrayList<event_group> cache_groups = new ArrayList<>();
    public Map<String, String> ext;
    public boolean gray_status;
    public ArrayList<event_group> groups;
    public int reset;
    public String start_cardid;
    public long uin;

    static {
        cache_groups.add(new event_group());
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
    }

    public event_card_rsp() {
        this.uin = 0L;
        this.groups = null;
        this.start_cardid = "";
        this.ext = null;
        this.reset = 0;
        this.gray_status = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.groups = (ArrayList) jceInputStream.read((JceInputStream) cache_groups, 1, true);
        this.start_cardid = jceInputStream.readString(2, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 3, false);
        this.reset = jceInputStream.read(this.reset, 4, false);
        this.gray_status = jceInputStream.read(this.gray_status, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((Collection) this.groups, 1);
        String str = this.start_cardid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.reset, 4);
        jceOutputStream.write(this.gray_status, 5);
    }

    public event_card_rsp(long j3, ArrayList<event_group> arrayList, String str, Map<String, String> map, int i3, boolean z16) {
        this.uin = j3;
        this.groups = arrayList;
        this.start_cardid = str;
        this.ext = map;
        this.reset = i3;
        this.gray_status = z16;
    }
}
