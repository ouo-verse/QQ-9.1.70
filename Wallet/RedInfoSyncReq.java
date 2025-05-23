package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RedInfoSyncReq extends JceStruct {
    public static final int PLAT_ANDROID = 1;
    static ArrayList<RedInfo> cache_vecRedInfo = new ArrayList<>();
    public String OSVersion;
    public String deviceModel;
    public int platId;
    public String qVersion;
    public ArrayList<RedInfo> vecRedInfo;

    static {
        cache_vecRedInfo.add(new RedInfo());
    }

    public RedInfoSyncReq() {
        this.platId = 0;
        this.qVersion = "";
        this.OSVersion = "";
        this.deviceModel = "";
        this.vecRedInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.platId = jceInputStream.read(this.platId, 0, false);
        this.qVersion = jceInputStream.readString(1, false);
        this.OSVersion = jceInputStream.readString(2, false);
        this.deviceModel = jceInputStream.readString(3, false);
        this.vecRedInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRedInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.platId, 0);
        String str = this.qVersion;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.OSVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.deviceModel;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        ArrayList<RedInfo> arrayList = this.vecRedInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public RedInfoSyncReq(int i3, String str, String str2, String str3, ArrayList<RedInfo> arrayList) {
        this.platId = i3;
        this.qVersion = str;
        this.OSVersion = str2;
        this.deviceModel = str3;
        this.vecRedInfo = arrayList;
    }
}
