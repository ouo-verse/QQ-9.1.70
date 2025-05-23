package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class count_info extends JceStruct {
    static Map<String, String> cache_Ext;
    static byte[] cache_tianshuTrans;
    public String actPageAttach;
    public long cTime;
    public long expireTime;
    public Map<String, String> ext;
    public int iShowLevel;
    public int iSubCountID;
    public single_count stCount;
    public String strIconUrl;
    public String strReportValue;
    public String strShowMsg;
    public byte[] tianshuTrans;
    public String trace_info;
    public ArrayList<feed_host_info> vecUinList;
    static single_count cache_stCount = new single_count();
    static ArrayList<feed_host_info> cache_vecUinList = new ArrayList<>();

    static {
        cache_vecUinList.add(new feed_host_info());
        cache_tianshuTrans = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_Ext = hashMap;
        hashMap.put("", "");
    }

    public count_info() {
        this.stCount = null;
        this.vecUinList = null;
        this.trace_info = "";
        this.iSubCountID = 0;
        this.strIconUrl = "";
        this.strShowMsg = "";
        this.strReportValue = "";
        this.cTime = 0L;
        this.iShowLevel = 0;
        this.actPageAttach = "";
        this.tianshuTrans = null;
        this.expireTime = 0L;
        this.ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stCount = (single_count) jceInputStream.read((JceStruct) cache_stCount, 0, false);
        this.vecUinList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUinList, 1, false);
        this.trace_info = jceInputStream.readString(2, false);
        this.iSubCountID = jceInputStream.read(this.iSubCountID, 3, false);
        this.strIconUrl = jceInputStream.readString(4, false);
        this.strShowMsg = jceInputStream.readString(5, false);
        this.strReportValue = jceInputStream.readString(6, false);
        this.cTime = jceInputStream.read(this.cTime, 7, false);
        this.iShowLevel = jceInputStream.read(this.iShowLevel, 8, false);
        this.actPageAttach = jceInputStream.readString(9, false);
        this.tianshuTrans = jceInputStream.read(cache_tianshuTrans, 10, false);
        this.expireTime = jceInputStream.read(this.expireTime, 11, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_Ext, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        single_count single_countVar = this.stCount;
        if (single_countVar != null) {
            jceOutputStream.write((JceStruct) single_countVar, 0);
        }
        ArrayList<feed_host_info> arrayList = this.vecUinList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.trace_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iSubCountID, 3);
        String str2 = this.strIconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.strShowMsg;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.strReportValue;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.cTime, 7);
        jceOutputStream.write(this.iShowLevel, 8);
        String str5 = this.actPageAttach;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        byte[] bArr = this.tianshuTrans;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
        jceOutputStream.write(this.expireTime, 11);
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
    }

    public count_info(single_count single_countVar, ArrayList<feed_host_info> arrayList, String str, int i3, String str2, String str3, String str4, long j3, int i16, String str5, byte[] bArr, long j16, Map<String, String> map) {
        this.stCount = single_countVar;
        this.vecUinList = arrayList;
        this.trace_info = str;
        this.iSubCountID = i3;
        this.strIconUrl = str2;
        this.strShowMsg = str3;
        this.strReportValue = str4;
        this.cTime = j3;
        this.iShowLevel = i16;
        this.actPageAttach = str5;
        this.tianshuTrans = bArr;
        this.expireTime = j16;
        this.ext = map;
    }
}
