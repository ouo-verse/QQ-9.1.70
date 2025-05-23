package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PageInfo extends JceStruct {
    static ArrayList<ItemInfo> cache_item_infos = new ArrayList<>();
    public String appid;
    public ArrayList<ItemInfo> item_infos;
    public String page_id;

    static {
        cache_item_infos.add(new ItemInfo());
    }

    public PageInfo() {
        this.appid = "";
        this.page_id = "";
        this.item_infos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.readString(0, true);
        this.page_id = jceInputStream.readString(1, true);
        this.item_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_item_infos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.page_id, 1);
        ArrayList<ItemInfo> arrayList = this.item_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public PageInfo(String str, String str2, ArrayList<ItemInfo> arrayList) {
        this.appid = str;
        this.page_id = str2;
        this.item_infos = arrayList;
    }
}
