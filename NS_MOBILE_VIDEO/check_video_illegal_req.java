package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class check_video_illegal_req extends JceStruct {
    static ArrayList<UrlInput> cache_video_urls = new ArrayList<>();
    public ArrayList<UrlInput> video_urls;

    static {
        cache_video_urls.add(new UrlInput());
    }

    public check_video_illegal_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.video_urls = (ArrayList) jceInputStream.read((JceInputStream) cache_video_urls, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<UrlInput> arrayList = this.video_urls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public check_video_illegal_req(ArrayList<UrlInput> arrayList) {
        this.video_urls = arrayList;
    }
}
