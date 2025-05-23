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
public final class MaterialCate extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static MaterialFile cache_stBanner;
    static MaterialFile cache_stThumb;
    static byte[] cache_strExtFields;
    static ArrayList<OperBanner> cache_vecBanner;
    static ArrayList<MaterialItem> cache_vecItem = new ArrayList<>();
    public int iCateId;
    public int iQZInitShowCount;
    public int iSQInitShowCount;
    public Map<String, String> mapExtInfo;
    public MaterialFile stBanner;
    public MaterialFile stThumb;
    public String strCateKey;
    public String strCateName;
    public String strDescription;
    public byte[] strExtFields;
    public String strTraceInfo;
    public long uiSettleTime;
    public long uiTotalItems;
    public ArrayList<OperBanner> vecBanner;
    public ArrayList<MaterialItem> vecItem;

    static {
        cache_vecItem.add(new MaterialItem());
        cache_vecBanner = new ArrayList<>();
        cache_vecBanner.add(new OperBanner());
        cache_stThumb = new MaterialFile();
        cache_stBanner = new MaterialFile();
        cache_strExtFields = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
    }

    public MaterialCate() {
        this.iCateId = 0;
        this.strCateKey = "";
        this.strCateName = "";
        this.vecItem = null;
        this.iSQInitShowCount = 0;
        this.iQZInitShowCount = 0;
        this.uiTotalItems = 0L;
        this.vecBanner = null;
        this.strDescription = "";
        this.stThumb = null;
        this.stBanner = null;
        this.uiSettleTime = 0L;
        this.strTraceInfo = "";
        this.strExtFields = null;
        this.mapExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCateId = jceInputStream.read(this.iCateId, 0, true);
        this.strCateKey = jceInputStream.readString(1, false);
        this.strCateName = jceInputStream.readString(2, false);
        this.vecItem = (ArrayList) jceInputStream.read((JceInputStream) cache_vecItem, 3, false);
        this.iSQInitShowCount = jceInputStream.read(this.iSQInitShowCount, 4, false);
        this.iQZInitShowCount = jceInputStream.read(this.iQZInitShowCount, 5, false);
        this.uiTotalItems = jceInputStream.read(this.uiTotalItems, 6, false);
        this.vecBanner = (ArrayList) jceInputStream.read((JceInputStream) cache_vecBanner, 7, false);
        this.strDescription = jceInputStream.readString(8, false);
        this.stThumb = (MaterialFile) jceInputStream.read((JceStruct) cache_stThumb, 9, false);
        this.stBanner = (MaterialFile) jceInputStream.read((JceStruct) cache_stBanner, 10, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 11, false);
        this.strTraceInfo = jceInputStream.readString(12, false);
        this.strExtFields = jceInputStream.read(cache_strExtFields, 13, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCateId, 0);
        String str = this.strCateKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strCateName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<MaterialItem> arrayList = this.vecItem;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.iSQInitShowCount, 4);
        jceOutputStream.write(this.iQZInitShowCount, 5);
        jceOutputStream.write(this.uiTotalItems, 6);
        ArrayList<OperBanner> arrayList2 = this.vecBanner;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        String str3 = this.strDescription;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        MaterialFile materialFile = this.stThumb;
        if (materialFile != null) {
            jceOutputStream.write((JceStruct) materialFile, 9);
        }
        MaterialFile materialFile2 = this.stBanner;
        if (materialFile2 != null) {
            jceOutputStream.write((JceStruct) materialFile2, 10);
        }
        jceOutputStream.write(this.uiSettleTime, 11);
        String str4 = this.strTraceInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        byte[] bArr = this.strExtFields;
        if (bArr != null) {
            jceOutputStream.write(bArr, 13);
        }
        Map<String, String> map = this.mapExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 14);
        }
    }

    public MaterialCate(int i3, String str, String str2, ArrayList<MaterialItem> arrayList, int i16, int i17, long j3, ArrayList<OperBanner> arrayList2, String str3, MaterialFile materialFile, MaterialFile materialFile2, long j16, String str4, byte[] bArr, Map<String, String> map) {
        this.iCateId = i3;
        this.strCateKey = str;
        this.strCateName = str2;
        this.vecItem = arrayList;
        this.iSQInitShowCount = i16;
        this.iQZInitShowCount = i17;
        this.uiTotalItems = j3;
        this.vecBanner = arrayList2;
        this.strDescription = str3;
        this.stThumb = materialFile;
        this.stBanner = materialFile2;
        this.uiSettleTime = j16;
        this.strTraceInfo = str4;
        this.strExtFields = bArr;
        this.mapExtInfo = map;
    }
}
