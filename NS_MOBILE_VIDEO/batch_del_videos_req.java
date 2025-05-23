package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class batch_del_videos_req extends JceStruct {
    static ArrayList<String> cache_vids;
    public long uin;
    public ArrayList<String> vids;

    public batch_del_videos_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        if (cache_vids == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vids = arrayList;
            arrayList.add("");
        }
        this.vids = (ArrayList) jceInputStream.read((JceInputStream) cache_vids, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        ArrayList<String> arrayList = this.vids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public batch_del_videos_req(long j3, ArrayList<String> arrayList) {
        this.uin = j3;
        this.vids = arrayList;
    }
}
