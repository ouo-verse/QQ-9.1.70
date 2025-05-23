package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class change_vkey_req extends JceStruct {
    static ArrayList<String> cache_video_urls;
    public ArrayList<String> video_urls;

    public change_vkey_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_video_urls == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_video_urls = arrayList;
            arrayList.add("");
        }
        this.video_urls = (ArrayList) jceInputStream.read((JceInputStream) cache_video_urls, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.video_urls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public change_vkey_req(ArrayList<String> arrayList) {
        this.video_urls = arrayList;
    }
}
