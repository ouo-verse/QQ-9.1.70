package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetSettings extends JceStruct {
    static ArrayList<Setting> cache_Settings;
    public ArrayList<Setting> Settings;

    public ReqSetSettings() {
        this.Settings = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_Settings == null) {
            cache_Settings = new ArrayList<>();
            cache_Settings.add(new Setting());
        }
        this.Settings = (ArrayList) jceInputStream.read((JceInputStream) cache_Settings, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.Settings, 0);
    }

    public ReqSetSettings(ArrayList<Setting> arrayList) {
        this.Settings = arrayList;
    }
}
