package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_urlinfo_rsp extends JceStruct {
    static ArrayList<String> cache_images;
    public ArrayList<String> images;
    public int ret;
    public String summary;
    public String title;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_images = arrayList;
        arrayList.add("");
    }

    public mobile_get_urlinfo_rsp() {
        this.title = "";
        this.summary = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.title = jceInputStream.readString(1, false);
        this.summary = jceInputStream.readString(2, false);
        this.images = (ArrayList) jceInputStream.read((JceInputStream) cache_images, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<String> arrayList = this.images;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public mobile_get_urlinfo_rsp(int i3, String str, String str2, ArrayList<String> arrayList) {
        this.ret = i3;
        this.title = str;
        this.summary = str2;
        this.images = arrayList;
    }
}
