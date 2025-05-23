package cr2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aelight.camera.ae.util.n;
import com.tencent.av.opengl.effects.k;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f391692a = {"snpe", "opencl_mali", "opencl_ocl", "opengl"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f391693b = {"NX609J", "NX531J", "vivo X7Plus", "ARS-TL00", "MI 8 Lite", "1807-A01", "ARE-AL00", "MI 4S"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f391694c = {"Redmi Note 3"};

    /* renamed from: d, reason: collision with root package name */
    public static String f391695d = "";

    /* renamed from: e, reason: collision with root package name */
    private static int f391696e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f391697f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static int f391698g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static int f391699h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static int f391700i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static String f391701j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f391702k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f391703l = -1;

    private static String a() {
        String string = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
        if (TextUtils.isEmpty(string)) {
            return FileUtils.readStringFromAsset("qmcf_rule_config.xml");
        }
        return string;
    }

    public static synchronized int b() {
        synchronized (a.class) {
            int i3 = f391697f;
            if (i3 > -1) {
                return i3;
            }
            return c(a());
        }
    }

    public static int c(String str) {
        int i3 = f391697f;
        if (i3 > -1) {
            return i3;
        }
        int h16 = n.h();
        if (h16 != -1) {
            f391697f = h16;
            QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + h16);
            return f391697f;
        }
        f391697f = 0;
        if (DeviceInfoMonitor.getModel().contains("Pixel")) {
            f391697f = 4;
            return 4;
        }
        if (DeviceInfoMonitor.getModel().contains("Nexus")) {
            f391697f = 0;
            QLog.d("QmcfDevicesStrategy", 1, "not support because of nexus");
            return f391697f;
        }
        for (String str2 : f391693b) {
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str2)) {
                f391697f = 4;
                QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
                return f391697f;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            boolean exists = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
            boolean exists2 = new File("/system/lib/egl/libGLES_mali.so").exists();
            if (exists || exists2) {
                f391697f = 4;
                QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
                return f391697f;
            }
        }
        if (TextUtils.isEmpty(f391695d)) {
            f391695d = new OpenclInfoManager().a();
            QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + f391695d);
        }
        if (TextUtils.isEmpty(f391695d) || f391695d.startsWith(NotificationCompat.CATEGORY_ERROR)) {
            f391695d = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
            QLog.i("QmcfDevicesStrategy", 1, "getGLRendererInfo:" + f391695d);
            if (TextUtils.isEmpty(f391695d)) {
                f391697f = -2;
                return -2;
            }
        }
        int g16 = g(str);
        f391697f = g16;
        if (g16 == 0) {
            QLog.d("QmcfDevicesStrategy", 1, String.format("not support gpu[%s] type[%s]", f391695d, Integer.valueOf(g16)));
        }
        return f391697f;
    }

    public static int d() {
        int i3 = f391698g;
        if (i3 > -1) {
            return i3;
        }
        if (!f()) {
            f391698g = 0;
            QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of low-end devices", new Object[0]));
            return f391698g;
        }
        int h16 = n.h();
        if (h16 != -1) {
            f391698g = h16;
            QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + h16);
            return f391698g;
        }
        f391698g = 0;
        if (!DeviceInfoMonitor.getModel().contains("Pixel") && !DeviceInfoMonitor.getModel().contains("Nexus")) {
            for (String str : f391693b) {
                if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                    f391698g = 4;
                    QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
                    return f391698g;
                }
            }
            for (String str2 : f391694c) {
                if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str2)) {
                    f391698g = 4;
                    QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule loose");
                    return f391698g;
                }
            }
            boolean exists = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
            boolean exists2 = new File("/system/lib/egl/libGLES_mali.so").exists();
            if (!exists && !exists2) {
                f391698g = 3;
                return 3;
            }
            f391698g = 4;
            QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
            return f391698g;
        }
        f391698g = 4;
        return 4;
    }

    public static int e(Context context) {
        return context.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
    }

    public static boolean f() {
        return k.a(4, ShortVideoConstants.VIDEO_MAX_DURATION, 2147483648L);
    }

    private static int g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = 0;
            for (String str2 : f391692a) {
                i3++;
                if (!f391702k.contains(str2) && jSONObject.has(str2)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                    f391700i = i3;
                    j(jSONObject2);
                    if (f391696e > 0) {
                        QLog.d("QmcfDevicesStrategy", 1, "support because of config: " + f391696e);
                        return f391696e;
                    }
                }
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 4;
        }
    }

    private static void h(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString(TransferConfig.ExtendParamFloats.KEY_RULE).split(";")) {
                k(str, jSONObject.getString(str));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void i(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY).split(";")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                f391701j = str;
                h(jSONObject2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void j(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString("verdor").split(";")) {
                if (f391695d.contains(str)) {
                    i(jSONObject.getJSONObject(str));
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void k(String str, String str2) {
        if (NtFaceConstant.LARGE.equals(str)) {
            n(str2, true);
            return;
        }
        if ("less".equals(str)) {
            n(str2, false);
        } else if ("between".equals(str)) {
            l(str2);
        } else if ("enum".equals(str)) {
            m(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        if (r8 >= r9) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d4, code lost:
    
        if (r8 >= r9) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(";");
        try {
            boolean z16 = false;
            if (f391695d.contains("Mali")) {
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String[] split2 = split[i3].split("#");
                    if (split2.length != 4) {
                        break;
                    }
                    if (f391695d.contains(split2[0] + split2[1])) {
                        Matcher matcher = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(f391695d);
                        if (matcher.find()) {
                            try {
                                int parseInt = Integer.parseInt(matcher.group(4));
                                int parseInt2 = Integer.parseInt(split2[2]);
                                if (parseInt <= Integer.parseInt(split2[3])) {
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        } else {
                            continue;
                        }
                    }
                    i3++;
                }
                q(z16);
            }
            if (f391695d.contains("Adreno")) {
                int length2 = split.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length2) {
                        break;
                    }
                    String[] split3 = split[i16].split("#");
                    String str2 = "0";
                    Matcher matcher2 = Pattern.compile("Adreno.*(\\d{3,4})").matcher(f391695d);
                    if (matcher2.find()) {
                        str2 = matcher2.group(1);
                    }
                    if ((split3.length == 3 && str2.substring(0, 1).equals(split3[0])) || split3.length == 2) {
                        try {
                            int parseInt3 = Integer.parseInt(str2);
                            int parseInt4 = Integer.parseInt(split3[split3.length - 2]);
                            if (parseInt3 <= Integer.parseInt(split3[split3.length - 1])) {
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                    i16++;
                }
            }
            q(z16);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    private static void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(";");
        try {
            int length = split.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (f391695d.contains(split[i3])) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            q(z16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        if (r7 >= r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r7 <= r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d4, code lost:
    
        if (r7 >= r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        if (r7 <= r10) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void n(String str, boolean z16) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(";");
        try {
            boolean z17 = false;
            if (f391695d.contains("Mali")) {
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String[] split2 = split[i3].split("#");
                    if (split2.length == 2) {
                        str2 = split2[0];
                    } else {
                        if (split2.length != 3) {
                            break;
                        }
                        str2 = split2[0] + split2[1];
                    }
                    if (f391695d.contains(str2)) {
                        Matcher matcher = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(f391695d);
                        int length2 = (split2.length - 1) * 2;
                        if (matcher.find()) {
                            try {
                                int parseInt = Integer.parseInt(matcher.group(length2));
                                int parseInt2 = Integer.parseInt(split2[split2.length - 1]);
                                if (z16) {
                                }
                                if (!z16) {
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        } else {
                            continue;
                        }
                    }
                    i3++;
                }
                q(z17);
            }
            if (f391695d.contains("Adreno")) {
                int length3 = split.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length3) {
                        break;
                    }
                    String[] split3 = split[i16].split("#");
                    String str3 = "0";
                    Matcher matcher2 = Pattern.compile("Adreno.*(\\d{3,4})").matcher(f391695d);
                    if (matcher2.find()) {
                        str3 = matcher2.group(1);
                    }
                    if ((split3.length == 2 && str3.substring(0, 1).equals(split3[0])) || split3.length == 1) {
                        try {
                            int parseInt3 = Integer.parseInt(str3);
                            int parseInt4 = Integer.parseInt(split3[split3.length - 1]);
                            if (z16) {
                            }
                            if (!z16) {
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                    i16++;
                }
            }
            q(z17);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public static void o(String str) {
        if (f391703l == -1) {
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4);
            int i3 = sharedPreferences.getInt("gl_renderer_flag", 0);
            f391703l = i3;
            if (i3 == 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("gl_renderer", str);
                edit.putInt("gl_renderer_flag", 1);
                edit.commit();
                f391703l = 1;
                QLog.i("QmcfDevicesStrategy", 1, "saveGLRendererInfo:" + str);
            }
        }
    }

    public static boolean p(String str, int i3, Context context) {
        try {
            r(context);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QmcfDevicesStrategy", 2, "setQmcfMobileSupport err!", e16);
            }
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("qmcf_gpu_config", 0).edit();
        edit.putString("cfg_content", str);
        edit.putInt("cfg_version", i3);
        return edit.commit();
    }

    private static void q(boolean z16) {
        if ("white".equals(f391701j)) {
            if (z16) {
                f391696e = f391700i;
            }
        } else if ("black".equals(f391701j) && !z16) {
            f391696e = f391700i;
        }
    }

    public static void r(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(QmcfSwitchStrategy.SP_TAG, 4).edit();
        edit.putInt(QmcfSwitchStrategy.QMCF_MOBILEQ_SUPPORT, 1);
        edit.commit();
    }
}
