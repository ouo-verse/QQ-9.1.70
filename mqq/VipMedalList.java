package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VipMedalList extends JceStruct {
    static ArrayList<VipMedalInfo> cache_medalInfo = new ArrayList<>();
    public int bUpdate;
    public String jumpUrl;
    public int lhLogoLv;
    public int lhNumFlag;
    public String lvlJumpUrl;
    public ArrayList<VipMedalInfo> medalInfo;

    static {
        cache_medalInfo.add(new VipMedalInfo());
    }

    public VipMedalList() {
        this.medalInfo = null;
        this.bUpdate = 0;
        this.jumpUrl = "";
        this.lvlJumpUrl = "";
        this.lhNumFlag = 0;
        this.lhLogoLv = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.medalInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_medalInfo, 0, false);
        this.bUpdate = jceInputStream.read(this.bUpdate, 1, false);
        this.jumpUrl = jceInputStream.readString(2, false);
        this.lvlJumpUrl = jceInputStream.readString(3, false);
        this.lhNumFlag = jceInputStream.read(this.lhNumFlag, 4, false);
        this.lhLogoLv = jceInputStream.read(this.lhLogoLv, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<VipMedalInfo> arrayList = this.medalInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.bUpdate, 1);
        String str = this.jumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.lvlJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.lhNumFlag, 4);
        jceOutputStream.write(this.lhLogoLv, 5);
    }

    public VipMedalList(ArrayList<VipMedalInfo> arrayList, int i3, String str, String str2, int i16, int i17) {
        this.medalInfo = arrayList;
        this.bUpdate = i3;
        this.jumpUrl = str;
        this.lvlJumpUrl = str2;
        this.lhNumFlag = i16;
        this.lhLogoLv = i17;
    }
}
