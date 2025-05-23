package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class photo_adapt_req extends JceStruct {
    static ArrayList<String> cache_photoUrls;
    static int cache_reqSource;
    public ArrayList<String> photoUrls;
    public int reqSource;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_photoUrls = arrayList;
        arrayList.add("");
    }

    public photo_adapt_req() {
        this.reqSource = 0;
        this.photoUrls = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqSource = jceInputStream.read(this.reqSource, 0, true);
        this.photoUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_photoUrls, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqSource, 0);
        jceOutputStream.write((Collection) this.photoUrls, 1);
    }

    public photo_adapt_req(int i3, ArrayList<String> arrayList) {
        this.reqSource = i3;
        this.photoUrls = arrayList;
    }
}
