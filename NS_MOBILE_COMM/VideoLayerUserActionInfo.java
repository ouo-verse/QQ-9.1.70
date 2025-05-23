package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoLayerUserActionInfo extends JceStruct {
    static Map<String, VideoLayerUserAction> cache_actions = new HashMap();
    public Map<String, VideoLayerUserAction> actions;

    static {
        cache_actions.put("", new VideoLayerUserAction());
    }

    public VideoLayerUserActionInfo() {
        this.actions = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.actions = (Map) jceInputStream.read((JceInputStream) cache_actions, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, VideoLayerUserAction> map = this.actions;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public VideoLayerUserActionInfo(Map<String, VideoLayerUserAction> map) {
        this.actions = map;
    }
}
