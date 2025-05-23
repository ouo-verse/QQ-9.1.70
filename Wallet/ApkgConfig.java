package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ApkgConfig extends JceStruct {
    private static final int BIT_DEBUG_RUNTIME = 4;
    private static final int BIT_INNER_USER = 2;
    private static final int BIT_RISK_SWITCH = 1;
    static ArrayList<AllowDomainInfo> cache_allow_domains;
    static Map<String, String> cache_sub_apkg_urls;
    public ArrayList<AllowDomainInfo> allow_domains;
    public String apkg_url;
    public String app_name;
    public int bit_control;
    public String cos_sign;
    public String desc_info;
    public String icon_url;
    public String mini_appid;
    public int mini_version;
    public String qq_qr_code;
    public String share_pic_url;
    public Map<String, String> sub_apkg_urls;
    public String union_id;
    public String wx_qr_code;

    static {
        HashMap hashMap = new HashMap();
        cache_sub_apkg_urls = hashMap;
        hashMap.put("", "");
        cache_allow_domains = new ArrayList<>();
        cache_allow_domains.add(new AllowDomainInfo());
    }

    public ApkgConfig() {
        this.mini_appid = "";
        this.union_id = "";
        this.app_name = "";
        this.mini_version = 0;
        this.icon_url = "";
        this.apkg_url = "";
        this.sub_apkg_urls = null;
        this.desc_info = "";
        this.share_pic_url = "";
        this.bit_control = 0;
        this.allow_domains = null;
        this.wx_qr_code = "";
        this.qq_qr_code = "";
        this.cos_sign = "";
    }

    public boolean isInnerUser() {
        if ((this.bit_control & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isRiskOpen() {
        if ((this.bit_control & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.mini_appid) && !TextUtils.isEmpty(this.app_name) && !TextUtils.isEmpty(this.icon_url) && !TextUtils.isEmpty(this.apkg_url)) {
            return true;
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mini_appid = jceInputStream.readString(0, false);
        this.union_id = jceInputStream.readString(1, false);
        this.app_name = jceInputStream.readString(2, false);
        this.mini_version = jceInputStream.read(this.mini_version, 3, false);
        this.icon_url = jceInputStream.readString(4, false);
        this.apkg_url = jceInputStream.readString(5, false);
        this.sub_apkg_urls = (Map) jceInputStream.read((JceInputStream) cache_sub_apkg_urls, 6, false);
        this.desc_info = jceInputStream.readString(7, false);
        this.share_pic_url = jceInputStream.readString(8, false);
        this.bit_control = jceInputStream.read(this.bit_control, 9, false);
        this.allow_domains = (ArrayList) jceInputStream.read((JceInputStream) cache_allow_domains, 10, false);
        this.wx_qr_code = jceInputStream.readString(11, false);
        this.qq_qr_code = jceInputStream.readString(12, false);
        this.cos_sign = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "ApkgConfig{mini_appid='" + this.mini_appid + "', union_id='" + this.union_id + "', app_name='" + this.app_name + "', mini_version=" + this.mini_version + ", icon_url='" + this.icon_url + "', downloadUrl='" + this.apkg_url + "', sub_apkg_urls=" + this.sub_apkg_urls + ", desc_info='" + this.desc_info + "', share_pic_url='" + this.share_pic_url + "', bit_control=" + this.bit_control + ", allow_domains=" + this.allow_domains + ", wx_qr_code='" + this.wx_qr_code + "', qq_qr_code='" + this.qq_qr_code + "', cos_sign='" + this.cos_sign + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.mini_appid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.union_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.app_name;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.mini_version, 3);
        String str4 = this.icon_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.apkg_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        Map<String, String> map = this.sub_apkg_urls;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str6 = this.desc_info;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.share_pic_url;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.bit_control, 9);
        ArrayList<AllowDomainInfo> arrayList = this.allow_domains;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        String str8 = this.wx_qr_code;
        if (str8 != null) {
            jceOutputStream.write(str8, 11);
        }
        String str9 = this.qq_qr_code;
        if (str9 != null) {
            jceOutputStream.write(str9, 12);
        }
        String str10 = this.cos_sign;
        if (str10 != null) {
            jceOutputStream.write(str10, 13);
        }
    }

    public ApkgConfig(String str, String str2, String str3, int i3, String str4, String str5, Map<String, String> map, String str6, String str7, int i16, ArrayList<AllowDomainInfo> arrayList, String str8, String str9, String str10) {
        this.mini_appid = str;
        this.union_id = str2;
        this.app_name = str3;
        this.mini_version = i3;
        this.icon_url = str4;
        this.apkg_url = str5;
        this.sub_apkg_urls = map;
        this.desc_info = str6;
        this.share_pic_url = str7;
        this.bit_control = i16;
        this.allow_domains = arrayList;
        this.wx_qr_code = str8;
        this.qq_qr_code = str9;
        this.cos_sign = str10;
    }
}
