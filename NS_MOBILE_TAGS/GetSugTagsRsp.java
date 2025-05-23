package NS_MOBILE_TAGS;

import NS_MOBILE_FEEDS.s_event_tag;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSugTagsRsp extends JceStruct {
    static ArrayList<s_event_tag> cache_sugTags = new ArrayList<>();
    public ArrayList<s_event_tag> sugTags;

    static {
        cache_sugTags.add(new s_event_tag());
    }

    public GetSugTagsRsp() {
        this.sugTags = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sugTags = (ArrayList) jceInputStream.read((JceInputStream) cache_sugTags, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_event_tag> arrayList = this.sugTags;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetSugTagsRsp(ArrayList<s_event_tag> arrayList) {
        this.sugTags = arrayList;
    }
}
