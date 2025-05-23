package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_gift_combin extends JceStruct {
    static ArrayList<s_gift_item> cache_gifts = new ArrayList<>();
    public ArrayList<s_gift_item> gifts;

    static {
        cache_gifts.add(new s_gift_item());
    }

    public cell_gift_combin() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.gifts = (ArrayList) jceInputStream.read((JceInputStream) cache_gifts, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_gift_item> arrayList = this.gifts;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public cell_gift_combin(ArrayList<s_gift_item> arrayList) {
        this.gifts = arrayList;
    }
}
