package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_UserInfo_dc02148 implements LpReportInfo {
    public static final String AGE = "age";
    public static final String CITY = "city";
    public static final String CONSTELLATION = "constellation";
    public static final String COUNTRY = "country";
    public static final String GENDER = "gender";
    public static final String PROVINCE = "province";
    public long age;
    public String city;
    public long city_code;
    public String client_ip;
    String client_time;
    public long constellation;
    public String country;
    public long country_code;
    public long gender;
    public String latitude;
    public String longitude;
    public String province;
    public long province_code;
    public long uin;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        String str;
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 <= 1000) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        if (TextUtils.isEmpty(this.client_time)) {
            str = String.valueOf(System.currentTimeMillis());
        } else {
            str = this.client_time;
        }
        hashMap.put("client_time", str);
        LpReportUtils.safePut(hashMap, "client_ip", this.client_ip);
        hashMap.put("age", String.valueOf(this.age));
        hashMap.put("gender", String.valueOf(this.gender));
        hashMap.put(CONSTELLATION, String.valueOf(this.constellation));
        LpReportUtils.safePut(hashMap, "latitude", this.latitude);
        LpReportUtils.safePut(hashMap, "longitude", this.longitude);
        LpReportUtils.safePut(hashMap, "country", this.country);
        hashMap.put("country_code", String.valueOf(this.country_code));
        LpReportUtils.safePut(hashMap, "province", this.province);
        hashMap.put("province_code", String.valueOf(this.province_code));
        LpReportUtils.safePut(hashMap, "city", this.city);
        hashMap.put("city_code", String.valueOf(this.city_code));
        return hashMap;
    }
}
