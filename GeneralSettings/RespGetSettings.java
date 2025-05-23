package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetSettings extends JceStruct {
    static ArrayList<Setting> cache_Settings;
    public int Revision;
    public ArrayList<Setting> Settings;
    public long Total;

    public RespGetSettings() {
        this.Revision = 0;
        this.Settings = null;
        this.Total = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Revision = jceInputStream.read(this.Revision, 0, true);
        if (cache_Settings == null) {
            cache_Settings = new ArrayList<>();
            cache_Settings.add(new Setting());
        }
        this.Settings = (ArrayList) jceInputStream.read((JceInputStream) cache_Settings, 1, false);
        this.Total = jceInputStream.read(this.Total, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Revision, 0);
        ArrayList<Setting> arrayList = this.Settings;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.Total, 2);
    }

    public RespGetSettings(int i3, ArrayList<Setting> arrayList, long j3) {
        this.Revision = i3;
        this.Settings = arrayList;
        this.Total = j3;
    }
}
