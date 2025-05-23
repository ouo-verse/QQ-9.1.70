package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class opera_infomation extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public Map<Integer, String> busi_param;
    public long feedUin;
    public String strFeedsKey;
    public String strOperaData;
    public String strSummary;

    static {
        cache_busi_param.put(0, "");
    }

    public opera_infomation() {
        this.busi_param = null;
        this.strFeedsKey = "";
        this.strOperaData = "";
        this.strSummary = "";
        this.feedUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 0, false);
        this.strFeedsKey = jceInputStream.readString(1, false);
        this.strOperaData = jceInputStream.readString(2, false);
        this.strSummary = jceInputStream.readString(3, false);
        this.feedUin = jceInputStream.read(this.feedUin, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.strFeedsKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strOperaData;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strSummary;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.feedUin, 4);
    }

    public opera_infomation(Map<Integer, String> map, String str, String str2, String str3, long j3) {
        this.busi_param = map;
        this.strFeedsKey = str;
        this.strOperaData = str2;
        this.strSummary = str3;
        this.feedUin = j3;
    }
}
