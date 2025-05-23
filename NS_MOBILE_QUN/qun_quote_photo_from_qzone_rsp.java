package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_quote_photo_from_qzone_rsp extends JceStruct {
    static ArrayList<String> cache_url;
    public ArrayList<String> url;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_url = arrayList;
        arrayList.add("");
    }

    public qun_quote_photo_from_qzone_rsp() {
        this.url = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = (ArrayList) jceInputStream.read((JceInputStream) cache_url, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.url;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public qun_quote_photo_from_qzone_rsp(ArrayList<String> arrayList) {
        this.url = arrayList;
    }
}
