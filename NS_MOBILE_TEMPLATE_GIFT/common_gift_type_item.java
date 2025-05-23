package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class common_gift_type_item extends JceStruct {
    static ArrayList<s_gift_item> cache_common_gift_list;
    public ArrayList<s_gift_item> common_gift_list;
    public int item_type_id;
    public String name;
    public int total;

    public common_gift_type_item() {
        this.name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item_type_id = jceInputStream.read(this.item_type_id, 0, true);
        this.name = jceInputStream.readString(1, true);
        if (cache_common_gift_list == null) {
            cache_common_gift_list = new ArrayList<>();
            cache_common_gift_list.add(new s_gift_item());
        }
        this.common_gift_list = (ArrayList) jceInputStream.read((JceInputStream) cache_common_gift_list, 2, false);
        this.total = jceInputStream.read(this.total, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.item_type_id, 0);
        jceOutputStream.write(this.name, 1);
        ArrayList<s_gift_item> arrayList = this.common_gift_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.total, 3);
    }

    public common_gift_type_item(int i3, String str, ArrayList<s_gift_item> arrayList, int i16) {
        this.item_type_id = i3;
        this.name = str;
        this.common_gift_list = arrayList;
        this.total = i16;
    }
}
