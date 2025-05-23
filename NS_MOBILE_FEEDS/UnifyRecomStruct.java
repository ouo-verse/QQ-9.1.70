package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UnifyRecomStruct extends JceStruct {
    static Map<String, String> cache_compassInfoList;
    static Map<Integer, String> cache_newReportInfoList;
    static ExposStuctInfo cache_stuExposInfo = new ExposStuctInfo();
    static byte[] cache_vctBusiData;
    public Map<String, String> compassInfoList;
    public int iPos;
    public Map<Integer, String> newReportInfoList;
    public ExposStuctInfo stuExposInfo;
    public String ugckey;
    public byte[] vctBusiData;

    static {
        cache_vctBusiData = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_compassInfoList = hashMap;
        hashMap.put("", "");
        cache_newReportInfoList = new HashMap();
        cache_newReportInfoList.put(0, "");
    }

    public UnifyRecomStruct() {
        this.iPos = 0;
        this.vctBusiData = null;
        this.stuExposInfo = null;
        this.compassInfoList = null;
        this.ugckey = "";
        this.newReportInfoList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iPos = jceInputStream.read(this.iPos, 0, false);
        this.vctBusiData = jceInputStream.read(cache_vctBusiData, 1, false);
        this.stuExposInfo = (ExposStuctInfo) jceInputStream.read((JceStruct) cache_stuExposInfo, 2, false);
        this.compassInfoList = (Map) jceInputStream.read((JceInputStream) cache_compassInfoList, 3, false);
        this.ugckey = jceInputStream.readString(4, false);
        this.newReportInfoList = (Map) jceInputStream.read((JceInputStream) cache_newReportInfoList, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iPos, 0);
        byte[] bArr = this.vctBusiData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        ExposStuctInfo exposStuctInfo = this.stuExposInfo;
        if (exposStuctInfo != null) {
            jceOutputStream.write((JceStruct) exposStuctInfo, 2);
        }
        Map<String, String> map = this.compassInfoList;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str = this.ugckey;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        Map<Integer, String> map2 = this.newReportInfoList;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
    }

    public UnifyRecomStruct(int i3, byte[] bArr, ExposStuctInfo exposStuctInfo, Map<String, String> map, String str, Map<Integer, String> map2) {
        this.iPos = i3;
        this.vctBusiData = bArr;
        this.stuExposInfo = exposStuctInfo;
        this.compassInfoList = map;
        this.ugckey = str;
        this.newReportInfoList = map2;
    }
}
