package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DefaultInfo extends JceStruct {
    static Map<String, ArrayList<String>> cache_topicAndRoomName = new HashMap();
    public Map<String, ArrayList<String>> topicAndRoomName;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_topicAndRoomName.put("", arrayList);
    }

    public DefaultInfo() {
        this.topicAndRoomName = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.topicAndRoomName = (Map) jceInputStream.read((JceInputStream) cache_topicAndRoomName, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, ArrayList<String>> map = this.topicAndRoomName;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public DefaultInfo(Map<String, ArrayList<String>> map) {
        this.topicAndRoomName = map;
    }
}
