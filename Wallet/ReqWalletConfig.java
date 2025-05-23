package Wallet;

import LBS.LBSInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqWalletConfig extends JceStruct {
    static LBSInfo cache_lbsInfo = new LBSInfo();
    static Map<String, String> cache_mParameter;
    public long reqType = 0;
    public long uin = 0;
    public String platform = "";
    public String version = "";
    public int iNetType = 0;
    public LBSInfo lbsInfo = null;
    public long seriesNo = 0;
    public String commonMsg = "";
    public Map<String, String> mParameter = null;
    public String adcode = "";

    static {
        HashMap hashMap = new HashMap();
        cache_mParameter = hashMap;
        hashMap.put("", "");
    }

    public static ReqWalletConfig createReq(long j3, long j16, long j17, String str, Map<String, String> map, String str2, String str3, int i3) {
        ReqWalletConfig reqWalletConfig = new ReqWalletConfig();
        reqWalletConfig.reqType = j3;
        reqWalletConfig.uin = j16;
        reqWalletConfig.platform = str2;
        reqWalletConfig.version = str3;
        reqWalletConfig.iNetType = i3;
        reqWalletConfig.seriesNo = j17;
        if (!TextUtils.isEmpty(str)) {
            reqWalletConfig.commonMsg = str;
        }
        if (map != null) {
            reqWalletConfig.mParameter = map;
        }
        return reqWalletConfig;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqType = jceInputStream.read(this.reqType, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.platform = jceInputStream.readString(2, false);
        this.version = jceInputStream.readString(3, false);
        this.iNetType = jceInputStream.read(this.iNetType, 4, false);
        this.lbsInfo = (LBSInfo) jceInputStream.read((JceStruct) cache_lbsInfo, 5, false);
        this.seriesNo = jceInputStream.read(this.seriesNo, 6, false);
        this.commonMsg = jceInputStream.readString(7, false);
        this.mParameter = (Map) jceInputStream.read((JceInputStream) cache_mParameter, 8, false);
        this.adcode = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "ReqWalletConfig{reqType=" + this.reqType + ", platform='" + this.platform + "', version='" + this.version + "', iNetType=" + this.iNetType + ", seriesNo=" + this.seriesNo + ", commonMsg='" + this.commonMsg + "', mParameter=" + this.mParameter + ", adcode='" + this.adcode + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqType, 0);
        jceOutputStream.write(this.uin, 1);
        String str = this.platform;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.version;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.iNetType, 4);
        LBSInfo lBSInfo = this.lbsInfo;
        if (lBSInfo != null) {
            jceOutputStream.write((JceStruct) lBSInfo, 5);
        }
        jceOutputStream.write(this.seriesNo, 6);
        String str3 = this.commonMsg;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        Map<String, String> map = this.mParameter;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        String str4 = this.adcode;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }
}
