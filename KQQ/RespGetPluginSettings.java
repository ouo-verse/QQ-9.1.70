package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RespGetPluginSettings extends JceStruct {
    static ArrayList<PluginInfo> cache_PluginInfoList;
    public ArrayList<PluginInfo> PluginInfoList;

    public RespGetPluginSettings() {
        this.PluginInfoList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_PluginInfoList == null) {
            cache_PluginInfoList = new ArrayList<>();
            cache_PluginInfoList.add(new PluginInfo());
        }
        this.PluginInfoList = (ArrayList) jceInputStream.read((JceInputStream) cache_PluginInfoList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.PluginInfoList, 0);
    }

    public RespGetPluginSettings(ArrayList<PluginInfo> arrayList) {
        this.PluginInfoList = arrayList;
    }
}
