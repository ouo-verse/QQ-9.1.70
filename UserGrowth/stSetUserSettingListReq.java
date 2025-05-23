package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSetUserSettingListReq extends JceStruct {
    static ArrayList<stNewUserSettingItem> cache_params = new ArrayList<>();
    public ArrayList<stNewUserSettingItem> params;

    static {
        cache_params.add(new stNewUserSettingItem());
    }

    public stSetUserSettingListReq() {
        this.params = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.params = (ArrayList) jceInputStream.read((JceInputStream) cache_params, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stNewUserSettingItem> arrayList = this.params;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public stSetUserSettingListReq(ArrayList<stNewUserSettingItem> arrayList) {
        this.params = arrayList;
    }
}
