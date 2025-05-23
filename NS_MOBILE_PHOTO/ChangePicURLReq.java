package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ChangePicURLReq extends JceStruct {
    static int cache_req_from;
    static ArrayList<String> cache_urls;
    public int req_from;
    public ArrayList<String> urls;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_urls = arrayList;
        arrayList.add("");
    }

    public ChangePicURLReq() {
        this.req_from = 0;
        this.urls = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_from = jceInputStream.read(this.req_from, 0, false);
        this.urls = (ArrayList) jceInputStream.read((JceInputStream) cache_urls, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.req_from, 0);
        ArrayList<String> arrayList = this.urls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public ChangePicURLReq(int i3, ArrayList<String> arrayList) {
        this.req_from = i3;
        this.urls = arrayList;
    }
}
