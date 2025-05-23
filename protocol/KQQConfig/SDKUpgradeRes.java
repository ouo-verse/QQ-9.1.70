package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SDKUpgradeRes extends JceStruct {
    static ArrayList<UpgradeInfo> cache_vUpgradeInfo;
    public int iActionType;
    public ArrayList<UpgradeInfo> vUpgradeInfo;

    public SDKUpgradeRes() {
        this.vUpgradeInfo = null;
        this.iActionType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vUpgradeInfo == null) {
            cache_vUpgradeInfo = new ArrayList<>();
            cache_vUpgradeInfo.add(new UpgradeInfo());
        }
        this.vUpgradeInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vUpgradeInfo, 1, true);
        this.iActionType = jceInputStream.read(this.iActionType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vUpgradeInfo, 1);
        jceOutputStream.write(this.iActionType, 2);
    }

    public SDKUpgradeRes(ArrayList<UpgradeInfo> arrayList, int i3) {
        this.vUpgradeInfo = arrayList;
        this.iActionType = i3;
    }
}
