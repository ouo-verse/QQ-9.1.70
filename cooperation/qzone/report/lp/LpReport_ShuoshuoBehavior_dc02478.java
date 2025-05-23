package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_ShuoshuoBehavior_dc02478 implements LpReportInfo {
    public static final int BEHAVIOR_TYPE_FONT = 1;
    public static final int BEHAVIOR_TYPE_LOC = 4;
    public static final int BEHAVIOR_TYPE_PIC = 2;
    public static final int BEHAVIOR_TYPE_TAG = 3;
    public static final int SHUOSHUO_CANCEL = 16;
    public static final int SHUOSHUO_RECOMMEND_SHOW = 32;
    public static final int SHUOSHUO_TYPE_FONT = 8;
    public static final int SHUOSHUO_TYPE_LOC = 1;
    public static final int SHUOSHUO_TYPE_ORIGINAL = 0;
    public static final int SHUOSHUO_TYPE_PIC = 4;
    public static final int SHUOSHUO_TYPE_TAG = 2;
    private static String TAG = "LpReport_ShuoshuoBehavior_dc02478";
    public String behavior_type;
    public String client_time;
    public int exif_pic_size;
    public int font_length;
    public String guess_expose_time;
    public String left_time;
    public int pic_size;
    public String qua;
    public int shuoshuo_type;
    public String stay_time;
    public long uin;
    public String version;
    public int video_size;

    public LpReport_ShuoshuoBehavior_dc02478(String str, int i3, int i16, int i17, int i18, int i19, String str2, String str3, String str4) {
        this.behavior_type = str;
        this.shuoshuo_type = i3;
        this.font_length = i16;
        this.pic_size = i17;
        this.exif_pic_size = i18;
        this.video_size = i19;
        this.stay_time = str2;
        this.left_time = str3;
        this.guess_expose_time = str4;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return TAG;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 <= 1000) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        if (TextUtils.isEmpty(this.version)) {
            str = AppSetting.f99551k;
        } else {
            str = this.version;
        }
        LpReportUtils.safePut(hashMap, "version", str);
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        if (TextUtils.isEmpty(this.client_time)) {
            str2 = String.valueOf(System.currentTimeMillis());
        } else {
            str2 = this.client_time;
        }
        hashMap.put("client_time", str2);
        LpReportUtils.safePut(hashMap, "behavior_type", this.behavior_type);
        LpReportUtils.safePut(hashMap, "shuoshuo_type", this.shuoshuo_type);
        LpReportUtils.safePut(hashMap, "font_length", this.font_length);
        LpReportUtils.safePut(hashMap, "pic_size", this.pic_size);
        LpReportUtils.safePut(hashMap, "exif_pic_size", this.exif_pic_size);
        LpReportUtils.safePut(hashMap, "video_size", this.video_size);
        LpReportUtils.safePut(hashMap, "stay_time", this.stay_time);
        LpReportUtils.safePut(hashMap, "left_time", this.left_time);
        LpReportUtils.safePut(hashMap, "guess_expose_time", this.guess_expose_time);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        try {
            Field[] declaredFields = getClass().getDeclaredFields();
            for (int i3 = 0; i3 < declaredFields.length; i3++) {
                sb5.append(declaredFields[i3].getName());
                Object obj = declaredFields[i3].get(this);
                if (obj != null) {
                    sb5.append(":");
                    sb5.append(obj);
                    sb5.append("\n");
                } else {
                    sb5.append(":null \n");
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }
}
