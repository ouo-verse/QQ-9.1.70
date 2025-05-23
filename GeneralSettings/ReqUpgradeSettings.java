package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqUpgradeSettings extends JceStruct {
    static ArrayList<Setting> cache_Settings;
    public ArrayList<Setting> Settings;
    public int Type;

    public ReqUpgradeSettings() {
        this.Type = 0;
        this.Settings = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Type = jceInputStream.read(this.Type, 0, true);
        if (cache_Settings == null) {
            cache_Settings = new ArrayList<>();
            cache_Settings.add(new Setting());
        }
        this.Settings = (ArrayList) jceInputStream.read((JceInputStream) cache_Settings, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Type, 0);
        ArrayList<Setting> arrayList = this.Settings;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public ReqUpgradeSettings(int i3, ArrayList<Setting> arrayList) {
        this.Type = i3;
        this.Settings = arrayList;
    }
}
