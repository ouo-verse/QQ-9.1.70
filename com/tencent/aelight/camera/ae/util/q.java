package com.tencent.aelight.camera.ae.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {

    /* renamed from: i, reason: collision with root package name */
    private static q f65819i;

    /* renamed from: a, reason: collision with root package name */
    private String f65820a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, com.tencent.mobileqq.activity.richmedia.i> f65821b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, Float> f65822c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, Integer> f65823d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Boolean> f65824e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, com.tencent.mobileqq.activity.richmedia.i> f65825f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, Integer> f65826g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final String f65827h = "short_video.param_manager";

    q() {
        String str;
        this.f65821b.put(1, new com.tencent.mobileqq.activity.richmedia.i(960, 720));
        this.f65821b.put(2, new com.tencent.mobileqq.activity.richmedia.i(960, 720));
        Map<Integer, Float> map = this.f65822c;
        Float valueOf = Float.valueOf(1.0f);
        map.put(1, valueOf);
        this.f65822c.put(2, valueOf);
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null);
        this.f65820a = featureValue;
        if (TextUtils.isEmpty(featureValue)) {
            str = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
        } else {
            str = this.f65820a;
        }
        this.f65820a = str;
        f();
    }

    public static q c() {
        if (f65819i == null) {
            synchronized (q.class) {
                if (f65819i == null) {
                    f65819i = new q();
                }
            }
        }
        return f65819i;
    }

    private static String d(String str, String str2) {
        int indexOf = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
        return indexOf == -1 ? str2 : str.substring(indexOf + 1);
    }

    public int a(int i3) {
        if (this.f65823d.containsKey(Integer.valueOf(i3))) {
            return this.f65823d.get(Integer.valueOf(i3)).intValue();
        }
        QLog.e("short_video.param_manager", 1, "[getBitRate]:-1, which may cause error!");
        return -1;
    }

    public com.tencent.mobileqq.activity.richmedia.i b(int i3) {
        if (this.f65821b.containsKey(Integer.valueOf(i3))) {
            return this.f65821b.get(Integer.valueOf(i3));
        }
        return new com.tencent.mobileqq.activity.richmedia.i(960, 720);
    }

    public float e(int i3) {
        if (this.f65822c.containsKey(Integer.valueOf(i3))) {
            return this.f65822c.get(Integer.valueOf(i3)).floatValue();
        }
        return 1.0f;
    }

    private void f() {
        String str;
        String str2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        String[] strArr;
        String str3;
        String str4;
        String str5;
        try {
            String[] split = this.f65820a.split(",");
            if (split != null && split.length != 0) {
                int i3 = 0;
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
                        String d16 = d(split2[13], "");
                        String[] strArr2 = null;
                        if (TextUtils.isEmpty(d16)) {
                            str = ";";
                            str2 = "";
                            iArr = null;
                            iArr2 = null;
                            iArr3 = null;
                            iArr4 = null;
                        } else {
                            String[] split4 = d16.split(";");
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
                                while (i3 < split4.length) {
                                    String[] strArr3 = split4;
                                    String[] split5 = split4[i3].split("#");
                                    if (split5 != null) {
                                        str3 = str6;
                                        if (split5.length >= 3) {
                                            String[] split6 = split5[0].split("\\*");
                                            if (split6 != null) {
                                                str4 = str7;
                                                if (split6.length == 2) {
                                                    iArr5[i3] = Integer.valueOf(split6[0]).intValue();
                                                    iArr4[i3] = Integer.valueOf(split6[1]).intValue();
                                                    str5 = split5[1];
                                                    if (str5 != null && split5[2] != null) {
                                                        iArr3[i3] = Integer.valueOf(str5).intValue();
                                                        iArr2[i3] = Integer.valueOf(split5[2]).intValue();
                                                    }
                                                    i3++;
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
                                            iArr5[i3] = intValue;
                                            iArr4[i3] = intValue2;
                                            str5 = split5[1];
                                            if (str5 != null) {
                                                iArr3[i3] = Integer.valueOf(str5).intValue();
                                                iArr2[i3] = Integer.valueOf(split5[2]).intValue();
                                            }
                                            i3++;
                                            split4 = strArr3;
                                            str6 = str3;
                                            str7 = str4;
                                        }
                                    } else {
                                        str3 = str6;
                                    }
                                    str4 = str7;
                                    i3++;
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
                        int intValue3 = Integer.valueOf(d(split2[14], "0")).intValue();
                        if (strArr2 == null || intValue3 >= strArr2.length) {
                            intValue3 = 0;
                        }
                        int length = strArr2 != null ? strArr2.length - 1 : 0;
                        if (iArr != null && iArr4 != null) {
                            this.f65821b.put(2, new com.tencent.mobileqq.activity.richmedia.i(iArr[intValue3], iArr4[intValue3]));
                            this.f65821b.put(1, new com.tencent.mobileqq.activity.richmedia.i(iArr[intValue3], iArr4[intValue3]));
                            this.f65825f.put(2, new com.tencent.mobileqq.activity.richmedia.i(iArr[length], iArr4[length]));
                            this.f65825f.put(1, new com.tencent.mobileqq.activity.richmedia.i(iArr[length], iArr4[length]));
                        }
                        if (iArr2 != null) {
                            this.f65823d.put(2, Integer.valueOf(iArr2[intValue3]));
                            this.f65823d.put(1, Integer.valueOf(iArr2[intValue3]));
                        }
                        if (iArr3 != null) {
                            this.f65826g.put(2, Integer.valueOf(iArr3[length]));
                            this.f65826g.put(1, Integer.valueOf(iArr3[length]));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
                        return;
                    }
                    return;
                }
                if (split2.length > 25) {
                    String[] split7 = d(split2[24], str2).split(str);
                    int intValue4 = Integer.valueOf(split7[0]).intValue();
                    int intValue5 = Integer.valueOf(split7[1]).intValue();
                    if (intValue5 > 0 && intValue4 > 0) {
                        float f16 = intValue4 / intValue5;
                        this.f65822c.put(2, Float.valueOf(f16));
                        this.f65822c.put(2, Float.valueOf(f16));
                    }
                }
                if (split2.length > 27) {
                    boolean equals = d(split2[27], "0").equals("1");
                    this.f65824e.put(2, Boolean.valueOf(equals));
                    this.f65824e.put(1, Boolean.valueOf(equals));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("short_video.param_manager", 2, "cameraResolution : " + this.f65821b.toString());
                    QLog.d("short_video.param_manager", 2, "videoResolutionRatioMap : " + this.f65822c.toString());
                    QLog.d("short_video.param_manager", 2, "isDynamic : " + this.f65824e);
                    QLog.d("short_video.param_manager", 2, "bitRateMap : " + this.f65823d);
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
}
