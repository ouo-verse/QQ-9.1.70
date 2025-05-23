package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class send_common_gift_rsp extends JceStruct {
    static ArrayList<send_gift_fail_item> cache_failList;
    public ArrayList<send_gift_fail_item> failList;
    public String giftUrl;

    public send_common_gift_rsp() {
        this.giftUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_failList == null) {
            cache_failList = new ArrayList<>();
            cache_failList.add(new send_gift_fail_item());
        }
        this.failList = (ArrayList) jceInputStream.read((JceInputStream) cache_failList, 0, false);
        this.giftUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<send_gift_fail_item> arrayList = this.failList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.giftUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public send_common_gift_rsp(ArrayList<send_gift_fail_item> arrayList, String str) {
        this.failList = arrayList;
        this.giftUrl = str;
    }
}
