package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialTab extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static byte[] cache_strExtFields;
    static ArrayList<OperBanner> cache_vecBanner = new ArrayList<>();
    static ArrayList<MaterialCate> cache_vecCate;
    public int iTabId;
    public Map<String, String> mapExtInfo;
    public byte[] strExtFields;
    public String strTabKey;
    public String strTabName;
    public String strTraceInfo;
    public long uiSettleTime;
    public ArrayList<OperBanner> vecBanner;
    public ArrayList<MaterialCate> vecCate;

    static {
        cache_vecBanner.add(new OperBanner());
        cache_vecCate = new ArrayList<>();
        cache_vecCate.add(new MaterialCate());
        cache_strExtFields = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public MaterialTab() {
        this.iTabId = 0;
        this.strTabKey = "";
        this.strTabName = "";
        this.vecBanner = null;
        this.vecCate = null;
        this.uiSettleTime = 0L;
        this.strTraceInfo = "";
        this.strExtFields = null;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTabId = jceInputStream.read(this.iTabId, 0, true);
        this.strTabKey = jceInputStream.readString(1, false);
        this.strTabName = jceInputStream.readString(2, false);
        this.vecBanner = (ArrayList) jceInputStream.read((JceInputStream) cache_vecBanner, 3, false);
        this.vecCate = (ArrayList) jceInputStream.read((JceInputStream) cache_vecCate, 4, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 5, false);
        this.strTraceInfo = jceInputStream.readString(6, false);
        this.strExtFields = jceInputStream.read(cache_strExtFields, 7, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTabId, 0);
        String str = this.strTabKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strTabName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<OperBanner> arrayList = this.vecBanner;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<MaterialCate> arrayList2 = this.vecCate;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        jceOutputStream.write(this.uiSettleTime, 5);
        String str3 = this.strTraceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        byte[] bArr = this.strExtFields;
        if (bArr != null) {
            jceOutputStream.write(bArr, 7);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public MaterialTab(int i3, String str, String str2, ArrayList<OperBanner> arrayList, ArrayList<MaterialCate> arrayList2, long j3, String str3, byte[] bArr, Map<String, String> map) {
        this.iTabId = i3;
        this.strTabKey = str;
        this.strTabName = str2;
        this.vecBanner = arrayList;
        this.vecCate = arrayList2;
        this.uiSettleTime = j3;
        this.strTraceInfo = str3;
        this.strExtFields = bArr;
        this.mapExtInfo = map;
    }
}
