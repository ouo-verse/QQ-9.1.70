package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MetaMaterial extends JceStruct {
    static Map<String, String> cache_additionalFields = null;
    static MetaAdditionalPackage cache_additionalPackage = null;
    static MetaSdkInfo cache_sdkInfo = new MetaSdkInfo();
    private static final long serialVersionUID = -859283469520919475L;
    public Map<String, String> additionalFields;
    public Map<String, Serializable> additionalObjectFields;
    public MetaAdditionalPackage additionalPackage;
    public String authorName;
    public boolean hasRedDot;

    /* renamed from: id, reason: collision with root package name */
    public String f30533id;
    public String packageMd5;
    public String packageUrl;
    public MetaSdkInfo sdkInfo;
    public String showName;
    public int thumbHeight;
    public String thumbUrl;
    public int thumbWidth;
    public int usageCnt;

    static {
        HashMap hashMap = new HashMap();
        cache_additionalFields = hashMap;
        hashMap.put("", "");
        cache_additionalPackage = new MetaAdditionalPackage();
    }

    public MetaMaterial() {
        this.f30533id = "";
        this.sdkInfo = null;
        this.thumbUrl = "";
        this.thumbWidth = 0;
        this.thumbHeight = 0;
        this.packageUrl = "";
        this.showName = "";
        this.additionalFields = null;
        this.additionalObjectFields = null;
        this.packageMd5 = "";
        this.additionalPackage = null;
        this.hasRedDot = false;
        this.authorName = "";
        this.usageCnt = 0;
    }

    public MetaMaterial copy() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.additionalFields.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        HashMap hashMap2 = new HashMap();
        Map<String, Serializable> map = this.additionalObjectFields;
        if (map != null) {
            for (Map.Entry<String, Serializable> entry2 : map.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return new MetaMaterial(this.f30533id, this.sdkInfo, this.thumbUrl, this.thumbWidth, this.thumbHeight, this.packageUrl, hashMap2, hashMap, this.packageMd5, this.additionalPackage, this.showName, this.authorName, this.hasRedDot, this.usageCnt);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f30533id = jceInputStream.readString(0, false);
        this.sdkInfo = (MetaSdkInfo) jceInputStream.read((JceStruct) cache_sdkInfo, 1, false);
        this.thumbUrl = jceInputStream.readString(2, false);
        this.thumbWidth = jceInputStream.read(this.thumbWidth, 3, false);
        this.thumbHeight = jceInputStream.read(this.thumbHeight, 4, false);
        this.packageUrl = jceInputStream.readString(5, false);
        this.additionalFields = (Map) jceInputStream.read((JceInputStream) cache_additionalFields, 6, false);
        this.packageMd5 = jceInputStream.readString(7, false);
        this.additionalPackage = (MetaAdditionalPackage) jceInputStream.read((JceStruct) cache_additionalPackage, 8, false);
        this.showName = jceInputStream.readString(9, false);
        this.authorName = jceInputStream.readString(10, false);
        this.usageCnt = jceInputStream.read(this.usageCnt, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f30533id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        MetaSdkInfo metaSdkInfo = this.sdkInfo;
        if (metaSdkInfo != null) {
            jceOutputStream.write((JceStruct) metaSdkInfo, 1);
        }
        String str2 = this.thumbUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.thumbWidth, 3);
        jceOutputStream.write(this.thumbHeight, 4);
        String str3 = this.packageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        Map<String, String> map = this.additionalFields;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str4 = this.packageMd5;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        MetaAdditionalPackage metaAdditionalPackage = this.additionalPackage;
        if (metaAdditionalPackage != null) {
            jceOutputStream.write((JceStruct) metaAdditionalPackage, 8);
        }
        String str5 = this.showName;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.authorName;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this.usageCnt, 11);
    }

    public MetaMaterial(String str, MetaSdkInfo metaSdkInfo, String str2, int i3, int i16, String str3, Map<String, Serializable> map, Map<String, String> map2, String str4, MetaAdditionalPackage metaAdditionalPackage, String str5, String str6, boolean z16, int i17) {
        this.f30533id = str;
        this.sdkInfo = metaSdkInfo;
        this.thumbUrl = str2;
        this.thumbWidth = i3;
        this.thumbHeight = i16;
        this.packageUrl = str3;
        this.additionalFields = map2;
        this.packageMd5 = str4;
        this.additionalPackage = metaAdditionalPackage;
        this.additionalObjectFields = map;
        this.showName = str5;
        this.authorName = str6;
        this.hasRedDot = z16;
        this.usageCnt = i17;
    }
}
