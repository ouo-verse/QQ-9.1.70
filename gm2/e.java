package gm2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {

    /* renamed from: i, reason: collision with root package name */
    private static e f402418i;

    /* renamed from: a, reason: collision with root package name */
    private String f402419a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, i> f402420b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, Float> f402421c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, Integer> f402422d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Boolean> f402423e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, i> f402424f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, Integer> f402425g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final String f402426h = "short_video.param_manager";

    e() {
        String str;
        this.f402420b.put(1, new i(960, 720));
        this.f402420b.put(2, new i(960, 720));
        Map<Integer, Float> map = this.f402421c;
        Float valueOf = Float.valueOf(1.0f);
        map.put(1, valueOf);
        this.f402421c.put(2, valueOf);
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null);
        this.f402419a = featureValue;
        if (TextUtils.isEmpty(featureValue)) {
            str = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
        } else {
            str = this.f402419a;
        }
        this.f402419a = str;
        d();
    }

    public static e b() {
        if (f402418i == null) {
            synchronized (e.class) {
                if (f402418i == null) {
                    f402418i = new e();
                }
            }
        }
        return f402418i;
    }

    private static String c(String str, String str2) {
        int indexOf = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return str2;
        }
        return str.substring(indexOf + 1);
    }

    private void d() {
        String str;
        String str2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i3;
        String[] strArr;
        String str3;
        String str4;
        String str5;
        try {
            String[] split = this.f402419a.split(",");
            if (split != null && split.length != 0) {
                int i16 = 0;
                String[] split2 = split[0].split("\\|");
                String str6 = ";";
                String str7 = "";
                if (split2.length < 17) {
                    str = ";";
                    str2 = "";
                } else {
                    String[] split3 = split2[3].split("\\*");
                    if (split3 != null && split3.length == 2) {
                        int intValue = Integer.valueOf(split3[0]).intValue();
                        int intValue2 = Integer.valueOf(split3[1]).intValue();
                        String c16 = c(split2[13], "");
                        String[] strArr2 = null;
                        if (TextUtils.isEmpty(c16)) {
                            str = ";";
                            str2 = "";
                            iArr = null;
                            iArr2 = null;
                            iArr3 = null;
                            iArr4 = null;
                        } else {
                            String[] split4 = c16.split(";");
                            if (split4 == null || split4.length == 0) {
                                str = ";";
                                str2 = "";
                                strArr = split4;
                                iArr = null;
                                iArr2 = null;
                                iArr3 = null;
                                iArr4 = null;
                            } else {
                                int[] iArr5 = new int[split4.length];
                                iArr4 = new int[split4.length];
                                iArr3 = new int[split4.length];
                                iArr2 = new int[split4.length];
                                while (i16 < split4.length) {
                                    String[] strArr3 = split4;
                                    String[] split5 = split4[i16].split("#");
                                    if (split5 != null) {
                                        str3 = str6;
                                        if (split5.length >= 3) {
                                            String[] split6 = split5[0].split("\\*");
                                            if (split6 != null) {
                                                str4 = str7;
                                                if (split6.length == 2) {
                                                    iArr5[i16] = Integer.valueOf(split6[0]).intValue();
                                                    iArr4[i16] = Integer.valueOf(split6[1]).intValue();
                                                    str5 = split5[1];
                                                    if (str5 != null && split5[2] != null) {
                                                        iArr3[i16] = Integer.valueOf(str5).intValue();
                                                        iArr2[i16] = Integer.valueOf(split5[2]).intValue();
                                                    }
                                                    i16++;
                                                    split4 = strArr3;
                                                    str6 = str3;
                                                    str7 = str4;
                                                }
                                            } else {
                                                str4 = str7;
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d("short_video.param_manager", 2, "initConfig(): res is null or length is not 2");
                                            }
                                            iArr5[i16] = intValue;
                                            iArr4[i16] = intValue2;
                                            str5 = split5[1];
                                            if (str5 != null) {
                                                iArr3[i16] = Integer.valueOf(str5).intValue();
                                                iArr2[i16] = Integer.valueOf(split5[2]).intValue();
                                            }
                                            i16++;
                                            split4 = strArr3;
                                            str6 = str3;
                                            str7 = str4;
                                        }
                                    } else {
                                        str3 = str6;
                                    }
                                    str4 = str7;
                                    i16++;
                                    split4 = strArr3;
                                    str6 = str3;
                                    str7 = str4;
                                }
                                str = str6;
                                str2 = str7;
                                strArr = split4;
                                iArr = iArr5;
                            }
                            strArr2 = strArr;
                        }
                        int intValue3 = Integer.valueOf(c(split2[14], "0")).intValue();
                        if (strArr2 == null || intValue3 >= strArr2.length) {
                            intValue3 = 0;
                        }
                        if (strArr2 != null) {
                            i3 = strArr2.length - 1;
                        } else {
                            i3 = 0;
                        }
                        if (iArr != null && iArr4 != null) {
                            this.f402420b.put(2, new i(iArr[intValue3], iArr4[intValue3]));
                            this.f402420b.put(1, new i(iArr[intValue3], iArr4[intValue3]));
                            this.f402424f.put(2, new i(iArr[i3], iArr4[i3]));
                            this.f402424f.put(1, new i(iArr[i3], iArr4[i3]));
                        }
                        if (iArr2 != null) {
                            this.f402422d.put(2, Integer.valueOf(iArr2[intValue3]));
                            this.f402422d.put(1, Integer.valueOf(iArr2[intValue3]));
                        }
                        if (iArr3 != null) {
                            this.f402425g.put(2, Integer.valueOf(iArr3[i3]));
                            this.f402425g.put(1, Integer.valueOf(iArr3[i3]));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
                        return;
                    }
                    return;
                }
                if (split2.length > 25) {
                    String[] split7 = c(split2[24], str2).split(str);
                    int intValue4 = Integer.valueOf(split7[0]).intValue();
                    int intValue5 = Integer.valueOf(split7[1]).intValue();
                    if (intValue5 > 0 && intValue4 > 0) {
                        float f16 = intValue4 / intValue5;
                        this.f402421c.put(2, Float.valueOf(f16));
                        this.f402421c.put(2, Float.valueOf(f16));
                    }
                }
                if (split2.length > 27) {
                    boolean equals = c(split2[27], "0").equals("1");
                    this.f402423e.put(2, Boolean.valueOf(equals));
                    this.f402423e.put(1, Boolean.valueOf(equals));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("short_video.param_manager", 2, "cameraResolution : " + this.f402420b.toString());
                    QLog.d("short_video.param_manager", 2, "videoResolutionRatioMap : " + this.f402421c.toString());
                    QLog.d("short_video.param_manager", 2, "isDynamic : " + this.f402423e);
                    QLog.d("short_video.param_manager", 2, "bitRateMap : " + this.f402422d);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("short_video.param_manager", 2, "initConfig(): configs is null or its length is 0");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("short_video.param_manager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(e16));
            }
        }
    }

    public int a(int i3) {
        if (this.f402422d.containsKey(Integer.valueOf(i3))) {
            return this.f402422d.get(Integer.valueOf(i3)).intValue();
        }
        QLog.e("short_video.param_manager", 1, "[getBitRate]:-1, which may cause error!");
        return -1;
    }
}
