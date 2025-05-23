package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupEffect extends JceStruct {
    static ArrayList<UserConfig> cache_vUserConfig = new ArrayList<>();
    public int global_effect_id;
    public ArrayList<UserConfig> vUserConfig;

    static {
        cache_vUserConfig.add(new UserConfig());
    }

    public GroupEffect() {
        this.vUserConfig = null;
        this.global_effect_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vUserConfig = (ArrayList) jceInputStream.read((JceInputStream) cache_vUserConfig, 0, false);
        this.global_effect_id = jceInputStream.read(this.global_effect_id, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<UserConfig> arrayList = this.vUserConfig;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.global_effect_id, 1);
    }

    public GroupEffect(ArrayList<UserConfig> arrayList, int i3) {
        this.vUserConfig = arrayList;
        this.global_effect_id = i3;
    }
}
