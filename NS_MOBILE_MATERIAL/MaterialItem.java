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
public final class MaterialItem extends JceStruct {
    static Map<String, String> cache_mapExtInfo;
    static MaterialFile cache_stBanner;
    static MaterialFile cache_stExtFile1;
    static MaterialFile cache_stExtFile2;
    static MaterialFile cache_stThumb;
    static byte[] cache_strExtFields;
    static ArrayList<MaterialFile> cache_vecFile = new ArrayList<>();
    public int iItemId;
    public int iItemType;
    public int iPrice;
    public int iTypeId;
    public Map<String, String> mapExtInfo;
    public MaterialFile stBanner;
    public MaterialFile stExtFile1;
    public MaterialFile stExtFile2;
    public MaterialFile stThumb;
    public String strDescription;
    public byte[] strExtFields;
    public String strItemName;
    public String strItemSummary;
    public String strJumpUrl;
    public String strTraceInfo;
    public long uiSettleTime;
    public ArrayList<MaterialFile> vecFile;

    static {
        cache_vecFile.add(new MaterialFile());
        cache_stThumb = new MaterialFile();
        cache_stBanner = new MaterialFile();
        cache_strExtFields = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapExtInfo = hashMap;
        hashMap.put("", "");
        cache_stExtFile1 = new MaterialFile();
        cache_stExtFile2 = new MaterialFile();
    }

    public MaterialItem() {
        this.iItemId = 0;
        this.iTypeId = 0;
        this.iItemType = 0;
        this.strItemName = "";
        this.iPrice = 0;
        this.vecFile = null;
        this.strItemSummary = "";
        this.strDescription = "";
        this.stThumb = null;
        this.stBanner = null;
        this.uiSettleTime = 0L;
        this.strTraceInfo = "";
        this.strJumpUrl = "";
        this.strExtFields = null;
        this.mapExtInfo = null;
        this.stExtFile1 = null;
        this.stExtFile2 = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.iTypeId = jceInputStream.read(this.iTypeId, 1, true);
        this.iItemType = jceInputStream.read(this.iItemType, 2, true);
        this.strItemName = jceInputStream.readString(3, true);
        this.iPrice = jceInputStream.read(this.iPrice, 4, false);
        this.vecFile = (ArrayList) jceInputStream.read((JceInputStream) cache_vecFile, 5, false);
        this.strItemSummary = jceInputStream.readString(6, false);
        this.strDescription = jceInputStream.readString(7, false);
        this.stThumb = (MaterialFile) jceInputStream.read((JceStruct) cache_stThumb, 8, false);
        this.stBanner = (MaterialFile) jceInputStream.read((JceStruct) cache_stBanner, 9, false);
        this.uiSettleTime = jceInputStream.read(this.uiSettleTime, 10, false);
        this.strTraceInfo = jceInputStream.readString(11, false);
        this.strJumpUrl = jceInputStream.readString(12, false);
        this.strExtFields = jceInputStream.read(cache_strExtFields, 13, false);
        this.mapExtInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtInfo, 14, false);
        this.stExtFile1 = (MaterialFile) jceInputStream.read((JceStruct) cache_stExtFile1, 15, false);
        this.stExtFile2 = (MaterialFile) jceInputStream.read((JceStruct) cache_stExtFile2, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        jceOutputStream.write(this.iTypeId, 1);
        jceOutputStream.write(this.iItemType, 2);
        jceOutputStream.write(this.strItemName, 3);
        jceOutputStream.write(this.iPrice, 4);
        ArrayList<MaterialFile> arrayList = this.vecFile;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        String str = this.strItemSummary;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        String str2 = this.strDescription;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        MaterialFile materialFile = this.stThumb;
        if (materialFile != null) {
            jceOutputStream.write((JceStruct) materialFile, 8);
        }
        MaterialFile materialFile2 = this.stBanner;
        if (materialFile2 != null) {
            jceOutputStream.write((JceStruct) materialFile2, 9);
        }
        jceOutputStream.write(this.uiSettleTime, 10);
        String str3 = this.strTraceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.strJumpUrl;
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
        MaterialFile materialFile3 = this.stExtFile1;
        if (materialFile3 != null) {
            jceOutputStream.write((JceStruct) materialFile3, 15);
        }
        MaterialFile materialFile4 = this.stExtFile2;
        if (materialFile4 != null) {
            jceOutputStream.write((JceStruct) materialFile4, 16);
        }
    }

    public MaterialItem(int i3, int i16, int i17, String str, int i18, ArrayList<MaterialFile> arrayList, String str2, String str3, MaterialFile materialFile, MaterialFile materialFile2, long j3, String str4, String str5, byte[] bArr, Map<String, String> map, MaterialFile materialFile3, MaterialFile materialFile4) {
        this.iItemId = i3;
        this.iTypeId = i16;
        this.iItemType = i17;
        this.strItemName = str;
        this.iPrice = i18;
        this.vecFile = arrayList;
        this.strItemSummary = str2;
        this.strDescription = str3;
        this.stThumb = materialFile;
        this.stBanner = materialFile2;
        this.uiSettleTime = j3;
        this.strTraceInfo = str4;
        this.strJumpUrl = str5;
        this.strExtFields = bArr;
        this.mapExtInfo = map;
        this.stExtFile1 = materialFile3;
        this.stExtFile2 = materialFile4;
    }
}
