package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspWalletConfig extends JceStruct {
    public static final int ACTION_ALL_CHANGE = 0;
    public static final int ACTION_BATCH_CHANGE = 3;
    public static final int ACTION_INCRE_CHANGE = 2;
    public static final int ACTION_NOT_CHANGE = 1;
    public static int RET_SUCC;
    static Map<String, String> cache_mConfig;
    public int action;
    public String commonMsg;
    public Map<String, String> mConfig;
    public int refreshTime;
    public int refreshType;
    public long reqType;
    public int result;
    public long seriesNo;

    static {
        HashMap hashMap = new HashMap();
        cache_mConfig = hashMap;
        hashMap.put("", "");
    }

    public RspWalletConfig() {
        this.result = 0;
        this.reqType = 0L;
        this.seriesNo = 0L;
        this.refreshType = 0;
        this.refreshTime = 0;
        this.action = 0;
        this.commonMsg = "";
        this.mConfig = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.reqType = jceInputStream.read(this.reqType, 1, true);
        this.seriesNo = jceInputStream.read(this.seriesNo, 2, true);
        this.refreshType = jceInputStream.read(this.refreshType, 3, false);
        this.refreshTime = jceInputStream.read(this.refreshTime, 4, false);
        this.action = jceInputStream.read(this.action, 5, false);
        this.commonMsg = jceInputStream.readString(6, false);
        this.mConfig = (Map) jceInputStream.read((JceInputStream) cache_mConfig, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "RspWalletConfig{result=" + this.result + ", reqType=" + this.reqType + ", seriesNo=" + this.seriesNo + ", refreshType=" + this.refreshType + ", refreshTime=" + this.refreshTime + ", action=" + this.action + ", commonMsg='" + this.commonMsg + "', mConfig=" + this.mConfig + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.reqType, 1);
        jceOutputStream.write(this.seriesNo, 2);
        jceOutputStream.write(this.refreshType, 3);
        jceOutputStream.write(this.refreshTime, 4);
        jceOutputStream.write(this.action, 5);
        String str = this.commonMsg;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        Map<String, String> map = this.mConfig;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public RspWalletConfig(int i3, long j3, long j16, int i16, int i17, int i18, String str, Map<String, String> map) {
        this.result = i3;
        this.reqType = j3;
        this.seriesNo = j16;
        this.refreshType = i16;
        this.refreshTime = i17;
        this.action = i18;
        this.commonMsg = str;
        this.mConfig = map;
    }
}
