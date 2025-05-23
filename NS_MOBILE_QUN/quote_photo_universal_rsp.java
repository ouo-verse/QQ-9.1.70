package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class quote_photo_universal_rsp extends JceStruct {
    static ArrayList<String> cache_url;

    /* renamed from: msg, reason: collision with root package name */
    public String f25045msg;
    public int ret;
    public ArrayList<String> url;

    public quote_photo_universal_rsp() {
        this.f25045msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25045msg = jceInputStream.readString(1, false);
        if (cache_url == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_url = arrayList;
            arrayList.add("");
        }
        this.url = (ArrayList) jceInputStream.read((JceInputStream) cache_url, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25045msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<String> arrayList = this.url;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public quote_photo_universal_rsp(int i3, String str, ArrayList<String> arrayList) {
        this.ret = i3;
        this.f25045msg = str;
        this.url = arrayList;
    }
}
