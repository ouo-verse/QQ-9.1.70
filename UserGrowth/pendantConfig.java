package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class pendantConfig extends JceStruct {
    static Map<String, String> cache_ext;
    public int cid;
    public boolean enable;
    public Map<String, String> ext;
    public pendantStageConfig medium_stage;
    public pendantStageConfig strong_stage;
    public String trace_id;
    public pendantStageConfig weak_stage;
    static pendantStageConfig cache_weak_stage = new pendantStageConfig();
    static pendantStageConfig cache_medium_stage = new pendantStageConfig();
    static pendantStageConfig cache_strong_stage = new pendantStageConfig();

    static {
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
    }

    public pendantConfig() {
        this.enable = false;
        this.weak_stage = null;
        this.medium_stage = null;
        this.strong_stage = null;
        this.cid = 0;
        this.ext = null;
        this.trace_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enable = jceInputStream.read(this.enable, 0, false);
        this.weak_stage = (pendantStageConfig) jceInputStream.read((JceStruct) cache_weak_stage, 1, false);
        this.medium_stage = (pendantStageConfig) jceInputStream.read((JceStruct) cache_medium_stage, 2, false);
        this.strong_stage = (pendantStageConfig) jceInputStream.read((JceStruct) cache_strong_stage, 3, false);
        this.cid = jceInputStream.read(this.cid, 4, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 5, false);
        this.trace_id = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enable, 0);
        pendantStageConfig pendantstageconfig = this.weak_stage;
        if (pendantstageconfig != null) {
            jceOutputStream.write((JceStruct) pendantstageconfig, 1);
        }
        pendantStageConfig pendantstageconfig2 = this.medium_stage;
        if (pendantstageconfig2 != null) {
            jceOutputStream.write((JceStruct) pendantstageconfig2, 2);
        }
        pendantStageConfig pendantstageconfig3 = this.strong_stage;
        if (pendantstageconfig3 != null) {
            jceOutputStream.write((JceStruct) pendantstageconfig3, 3);
        }
        jceOutputStream.write(this.cid, 4);
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        String str = this.trace_id;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public pendantConfig(boolean z16, pendantStageConfig pendantstageconfig, pendantStageConfig pendantstageconfig2, pendantStageConfig pendantstageconfig3, int i3, Map<String, String> map, String str) {
        this.enable = z16;
        this.weak_stage = pendantstageconfig;
        this.medium_stage = pendantstageconfig2;
        this.strong_stage = pendantstageconfig3;
        this.cid = i3;
        this.ext = map;
        this.trace_id = str;
    }
}
