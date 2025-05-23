package com.tencent.mobileqq.ar;

import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f198366a = {-0.5f, 0.5f, 0.0f, 0.0f, 1.0f, -0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.5f, 0.5f, 0.0f, 1.0f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f198367b = {-0.5f, 0.5f, 0.0f, 0.0f, 0.0f, -0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 0.5f, 0.5f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final short[] f198368c = {0, 1, 2, 2, 3, 0};

    public static void a(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                QLog.d("ARVideoUtil", 1, str + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }

    public static boolean b() {
        String lowerCase = DeviceInfoMonitor.getModel().toLowerCase();
        if (Build.MANUFACTURER.toLowerCase().contains("meizu") && lowerCase.contains("m040")) {
            return true;
        }
        return false;
    }

    public static int c(f fVar) {
        ArCloudConfigInfo arCloudConfigInfo;
        if (fVar != null && (arCloudConfigInfo = fVar.f198365a) != null) {
            try {
                int i3 = arCloudConfigInfo.D.get(0).f198431m;
                if (i3 < 0) {
                    return 0;
                }
                return i3;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    th5.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static ArCloudConfigInfo.b d(String str) {
        String[] split;
        ArCloudConfigInfo.b bVar = new ArCloudConfigInfo.b();
        if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null) {
            if (split.length >= 1) {
                bVar.f197704a = Integer.valueOf(split[0]).intValue();
            }
            if (split.length >= 2) {
                bVar.f197705b = Integer.valueOf(split[1]).intValue();
            }
        }
        return bVar;
    }

    public static ArCloudConfigInfo.b e(String str, int i3, int i16) {
        int i17;
        ArCloudConfigInfo.b d16 = d(str);
        int i18 = d16.f197704a;
        if (i18 != 0 && (i17 = d16.f197705b) != 0) {
            float f16 = i16;
            float f17 = i3;
            if ((f16 * 1.0f) / i17 > (1.0f * f17) / i18) {
                d16.f197706c = 2.0f;
                d16.f197707d = ((((i17 * 1) * i3) / i18) * 2.0f) / f16;
            } else {
                d16.f197706c = ((((i18 * 1) * i16) / i17) * 2.0f) / f17;
                d16.f197707d = 2.0f;
            }
            d16.f197708e = 0.0f;
            d16.f197709f = 0.0f;
            d16.f197710g = 0.0f;
        }
        return d16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        if (r6 > r0) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArCloudConfigInfo.b f(String str, int i3, int i16, boolean z16) {
        float f16;
        float f17;
        boolean z17;
        float f18;
        float f19;
        float f26;
        float f27;
        String[] split;
        ArCloudConfigInfo.b d16 = d(str);
        if (d16.f197704a == 0 || d16.f197705b == 0) {
            d16.f197704a = i3;
            d16.f197705b = i16;
        }
        float f28 = 1.0f;
        float max = (i3 * 1.0f) / Math.max(1, i16);
        float f29 = d16.f197704a;
        float f36 = d16.f197705b;
        float f37 = (f29 * 1.0f) / f36;
        boolean z18 = false;
        if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null) {
            if (split.length >= 3) {
                f16 = Float.valueOf(split[2]).floatValue();
            } else {
                f16 = 1.0f;
            }
            if (split.length >= 4) {
                f17 = Float.valueOf(split[3]).floatValue();
            } else {
                f17 = 1.0f;
            }
            if (split.length >= 5) {
                f19 = Float.valueOf(split[4]).floatValue();
            } else {
                f19 = 0.0f;
            }
            if (split.length >= 6) {
                f18 = -Float.valueOf(split[5]).floatValue();
            } else {
                f18 = 0.0f;
            }
            z17 = true;
        } else {
            f16 = 1.0f;
            f17 = 1.0f;
            z17 = false;
            f18 = 0.0f;
            f19 = 0.0f;
        }
        if (z17) {
            if (f16 <= 0.05f || f17 <= 0.05f) {
                if (f16 <= 0.05f) {
                    if (f17 <= 0.05f) {
                        if (f37 > max) {
                            f16 = 1.0f;
                        }
                    }
                    f28 = f17;
                }
            }
            if (!z16) {
                float f38 = max * 10.0f;
                d16.f197706c = f38;
                d16.f197707d = 10.0f;
                d16.f197708e = 0.0f;
                d16.f197709f = 0.0f;
                d16.f197710g = -5.0f;
                if (z17) {
                    if (z18) {
                        float f39 = f16 * f38;
                        d16.f197706c = f39;
                        d16.f197707d = (f36 / f29) * f39;
                        f27 = f39 / 2.0f;
                    } else {
                        float f46 = f28 * 10.0f;
                        d16.f197707d = f46;
                        d16.f197706c = (f29 / f36) * f46;
                        f27 = f46 / 2.0f;
                    }
                    d16.f197708e = (f19 * max) / f27;
                    d16.f197709f = f18 / f27;
                }
            } else {
                d16.f197706c = 2.0f;
                d16.f197707d = 2.0f;
                d16.f197708e = 0.0f;
                d16.f197709f = 0.0f;
                d16.f197710g = 0.0f;
                if (z17) {
                    if (z18) {
                        float f47 = f16 * 2.0f;
                        d16.f197706c = f47;
                        d16.f197707d = max * f47 * (f36 / f29);
                        f26 = f47 / 2.0f;
                    } else {
                        float f48 = f28 * 2.0f;
                        d16.f197707d = f48;
                        d16.f197706c = (f48 / max) * (f29 / f36);
                        f26 = f48 / 2.0f;
                    }
                    d16.f197708e = f19 / f26;
                    d16.f197709f = f18 / f26;
                }
            }
            QLog.i("ARVideoUtil", 1, "parseVideoLayout layout = " + d16);
            return d16;
        }
        z18 = true;
        f28 = f17;
        if (!z16) {
        }
        QLog.i("ARVideoUtil", 1, "parseVideoLayout layout = " + d16);
        return d16;
    }

    public static Pair<Integer, x81.i> g(f fVar) {
        int i3;
        int i16 = 0;
        x81.i a16 = x81.h.a(0);
        ArCloudConfigInfo arCloudConfigInfo = fVar.f198365a;
        int i17 = arCloudConfigInfo.f197702i;
        if (i17 == 2) {
            try {
                i3 = Integer.parseInt(arCloudConfigInfo.D.get(0).f198428f);
            } catch (Throwable unused) {
                i3 = 0;
            }
            if (i3 >= 0 && (i3 == 0 || i3 == 1)) {
                i16 = i3;
            }
        } else if (i17 == 3 || i17 == 4) {
            if (i17 == 4 && WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE.equalsIgnoreCase(arCloudConfigInfo.D.get(0).f198428f)) {
                i16 = 1;
            } else {
                try {
                    String[] split = fVar.f198365a.D.get(0).f198428f.split("\\|");
                    if (split != null && split.length >= 5) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int parseInt4 = Integer.parseInt(split[3]);
                        int parseInt5 = Integer.parseInt(split[4]);
                        if (parseInt <= 255 && parseInt2 <= 255 && parseInt3 <= 255 && parseInt4 <= 255 && parseInt >= 0 && parseInt2 >= 0 && parseInt3 >= 0 && parseInt4 >= 0 && parseInt5 >= 0 && parseInt5 <= 100) {
                            a16.a(parseInt / 255.0f, parseInt2 / 255.0f, parseInt3 / 255.0f);
                            a16.f447451a = 1;
                            a16.f447455e = parseInt4 / 255.0f;
                            a16.f447456f = parseInt5 / 100.0f;
                            if (split.length >= 6 && Integer.parseInt(split[5]) == 1) {
                                a16.f447451a = 2;
                            }
                            if (split.length >= 8) {
                                int parseInt6 = Integer.parseInt(split[6]);
                                String str = split[7];
                                if (parseInt6 == 2 && !TextUtils.isEmpty(str)) {
                                    String[] split2 = str.split(";");
                                    if (split2 != null && split2.length == 3) {
                                        a16.f447457g = Float.valueOf(split2[0]).floatValue();
                                        a16.f447458h = Float.valueOf(split2[1]).floatValue();
                                        a16.f447459i = Float.valueOf(split2[2]).floatValue();
                                        a16.f447451a = 3;
                                    }
                                } else if (parseInt6 == 3 && !TextUtils.isEmpty(str)) {
                                    String[] split3 = str.split(";");
                                    if (split3 != null && split3.length == 3) {
                                        a16.f447457g = Float.valueOf(split3[0]).floatValue();
                                        a16.f447458h = Float.valueOf(split3[1]).floatValue();
                                        a16.f447459i = Float.valueOf(split3[2]).floatValue();
                                        a16.f447451a = 4;
                                    }
                                } else if (parseInt6 == 4 && !TextUtils.isEmpty(str)) {
                                    a16.f447461k = x81.b.l(str, "uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // \u9700\u8981\u6e32\u67d3\u6210\u5706\u5f62\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // \u5706\u5fc3(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n");
                                    a16.f447451a = 5;
                                }
                            }
                            i16 = 2;
                        }
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        th5.printStackTrace();
                    }
                }
            }
        }
        return new Pair<>(Integer.valueOf(i16), a16);
    }
}
