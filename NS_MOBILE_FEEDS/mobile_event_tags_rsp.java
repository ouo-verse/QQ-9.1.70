package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_event_tags_rsp extends JceStruct {
    static ArrayList<s_event_tag> cache_event_tags = new ArrayList<>();
    public ArrayList<s_event_tag> event_tags;

    static {
        cache_event_tags.add(new s_event_tag());
    }

    public mobile_event_tags_rsp() {
        this.event_tags = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.event_tags = (ArrayList) jceInputStream.read((JceInputStream) cache_event_tags, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_event_tag> arrayList = this.event_tags;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public mobile_event_tags_rsp(ArrayList<s_event_tag> arrayList) {
        this.event_tags = arrayList;
    }
}
