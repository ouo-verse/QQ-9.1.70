package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ReqGetPluginSettings extends JceStruct {
    static ArrayList<Long> cache_PluginList;
    public ArrayList<Long> PluginList;

    public ReqGetPluginSettings() {
        this.PluginList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_PluginList == null) {
            cache_PluginList = new ArrayList<>();
            cache_PluginList.add(0L);
        }
        this.PluginList = (ArrayList) jceInputStream.read((JceInputStream) cache_PluginList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.PluginList, 0);
    }

    public ReqGetPluginSettings(ArrayList<Long> arrayList) {
        this.PluginList = arrayList;
    }
}
