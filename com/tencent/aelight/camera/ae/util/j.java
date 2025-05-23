package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* renamed from: n, reason: collision with root package name */
    private static j f65772n;

    /* renamed from: a, reason: collision with root package name */
    public String f65773a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f65774b = "";

    /* renamed from: c, reason: collision with root package name */
    public boolean f65775c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f65776d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f65777e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f65778f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f65779g = false;

    /* renamed from: h, reason: collision with root package name */
    public float f65780h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public Map<Integer, Float> f65781i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private Map<Integer, com.tencent.mobileqq.activity.richmedia.i> f65782j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private Map<Integer, com.tencent.mobileqq.activity.richmedia.i> f65783k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private int f65784l = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f65785m = 1;

    j() {
        o();
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
    private void A(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(";");
        try {
            boolean z16 = false;
            if (this.f65773a.contains("Mali")) {
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
                    if (this.f65773a.contains(split2[0] + split2[1])) {
                        Matcher matcher = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.f65773a);
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
                D(z16);
            }
            if (this.f65773a.contains("Adreno")) {
                int length2 = split.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length2) {
                        break;
                    }
                    String[] split3 = split[i16].split("#");
                    String str2 = "0";
                    Matcher matcher2 = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.f65773a);
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
            D(z16);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    private void B(String str) {
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
                if (this.f65773a.contains(split[i3])) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            D(z16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        if (r7 >= r11) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r7 <= r11) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d4, code lost:
    
        if (r7 >= r11) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        if (r7 <= r11) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C(String str, boolean z16) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(";");
        try {
            boolean z17 = false;
            if (this.f65773a.contains("Mali")) {
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
                    if (this.f65773a.contains(str2)) {
                        Matcher matcher = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.f65773a);
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
                D(z17);
            }
            if (this.f65773a.contains("Adreno")) {
                int length3 = split.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length3) {
                        break;
                    }
                    String[] split3 = split[i16].split("#");
                    String str3 = "0";
                    Matcher matcher2 = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.f65773a);
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
            D(z17);
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    private void D(boolean z16) {
        if ("white".equals(this.f65774b)) {
            if (z16) {
                this.f65776d = true;
                this.f65775c = false;
                return;
            } else {
                this.f65776d = false;
                return;
            }
        }
        if ("black".equals(this.f65774b)) {
            if (!z16) {
                this.f65775c = false;
            } else {
                this.f65775c = true;
                this.f65776d = false;
            }
        }
    }

    private String f() {
        String string = MobileQQ.sMobileQQ.getSharedPreferences("short_video_gpu_config", 0).getString("cfg_content", "");
        if (TextUtils.isEmpty(string)) {
            string = FileUtils.readStringFromAsset("short_video_device_rule_config.xml");
            if (QLog.isColorLevel()) {
                QLog.d("DovSVParamManager", 2, "take local config");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "take server config");
        }
        return string;
    }

    public static j h() {
        if (f65772n == null) {
            synchronized (j.class) {
                if (f65772n == null) {
                    f65772n = new j();
                }
            }
        }
        return f65772n;
    }

    private void q(JSONObject jSONObject) {
        try {
            String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel();
            JSONArray jSONArray = jSONObject.getJSONArray("blackList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (string.trim().equals(str.trim())) {
                    this.f65778f = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("DovSVParamManager", 2, "parseJSONBlackList true =" + string);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void r(JSONObject jSONObject) {
        try {
            this.f65784l = jSONObject.optInt("faceDetectSwitch", 1);
            if (QLog.isColorLevel()) {
                QLog.d("DovSVParamManager", 2, "parseJSONFaceDetectSwitch mFaceDetectType:" + this.f65784l);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void s(JSONObject jSONObject) {
        try {
            String deviceName = DeviceInstance.getInstance().getDeviceName();
            JSONArray jSONArray = jSONObject.getJSONArray("qijianList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (string.trim().equals(deviceName.trim())) {
                    this.f65777e = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("DovSVParamManager", 2, "parseJSONQijianList true =" + string);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void t(JSONObject jSONObject) {
        try {
            String[] split = jSONObject.getString("resolutionList").split(";");
            String[] split2 = jSONObject.getString("cpResolutionList").split(";");
            if (split.length == split2.length) {
                for (int i3 = 0; i3 < split.length; i3++) {
                    String[] split3 = split[i3].split("\\*");
                    String[] split4 = split2[i3].split("\\*");
                    if (split3.length == 2 && split4.length == 2) {
                        this.f65782j.put(Integer.valueOf(i3), new com.tencent.mobileqq.activity.richmedia.i(Integer.valueOf(split3[0]).intValue(), Integer.valueOf(split3[1]).intValue()));
                        this.f65783k.put(Integer.valueOf(i3), new com.tencent.mobileqq.activity.richmedia.i(Integer.valueOf(split4[0]).intValue(), Integer.valueOf(split4[1]).intValue()));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void u(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString(TransferConfig.ExtendParamFloats.KEY_RULE).split(";")) {
                z(str, jSONObject.getString(str));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void v(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY).split(";")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                this.f65774b = str;
                u(jSONObject2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void w(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.getString("verdor").split(";")) {
                if (this.f65773a.contains(str)) {
                    v(jSONObject.getJSONObject(str));
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void x(JSONObject jSONObject) {
        try {
            this.f65780h = Float.valueOf(jSONObject.getString("maxWeight")).floatValue();
            JSONObject jSONObject2 = jSONObject.getJSONObject("renderListWeight");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.f65781i.put(Integer.valueOf(str), Float.valueOf(jSONObject2.getString(str)));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void z(String str, String str2) {
        if (NtFaceConstant.LARGE.equals(str)) {
            C(str2, true);
            return;
        }
        if ("less".equals(str)) {
            C(str2, false);
        } else if ("between".equals(str)) {
            A(str2);
        } else if ("enum".equals(str)) {
            B(str2);
        }
    }

    public boolean a() {
        return this.f65778f;
    }

    public xp.a b(com.tencent.aelight.camera.ae.a aVar) {
        xp.a aVar2 = new xp.a();
        aVar2.v(aVar.o().b());
        aVar2.u(aVar.o().a());
        aVar2.r(aVar.s().floatValue());
        aVar2.p(aVar.b().intValue());
        CodecParam.mMaxrate = aVar.b().intValue();
        aVar2.q(1);
        aVar2.o(aVar.g());
        return aVar2;
    }

    public xp.a c(Context context, int i3) {
        xp.a aVar = new xp.a();
        com.tencent.mobileqq.activity.richmedia.i e16 = e(i3);
        com.tencent.mobileqq.activity.richmedia.i g16 = g(i3);
        if (e16 != null) {
            aVar.v(e16.b());
            aVar.u(e16.a());
        }
        if (g16 != null) {
            aVar.t(g16.b());
            aVar.s(g16.a());
        }
        aVar.r(k(i3));
        int d16 = d(i3) * 1000;
        aVar.p(d16);
        CodecParam.mMaxrate = d16;
        aVar.q(1);
        aVar.o(i3);
        if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen() && Build.VERSION.SDK_INT < 27) {
            aVar.k(0);
        }
        return aVar;
    }

    public int d(int i3) {
        return 7000;
    }

    public com.tencent.mobileqq.activity.richmedia.i e(int i3) {
        Map<Integer, com.tencent.mobileqq.activity.richmedia.i> map;
        int i16;
        if (this.f65778f) {
            map = this.f65782j;
            i16 = 1;
        } else {
            map = this.f65782j;
            i16 = 0;
        }
        com.tencent.mobileqq.activity.richmedia.i iVar = map.get(Integer.valueOf(i16));
        if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "getCameraResolution inBlackPhone = " + this.f65778f + " dpcSize=" + iVar);
        }
        return iVar;
    }

    public com.tencent.mobileqq.activity.richmedia.i g(int i3) {
        Map<Integer, com.tencent.mobileqq.activity.richmedia.i> map;
        int i16;
        if (this.f65778f) {
            map = this.f65783k;
            i16 = 1;
        } else {
            map = this.f65783k;
            i16 = 0;
        }
        com.tencent.mobileqq.activity.richmedia.i iVar = map.get(Integer.valueOf(i16));
        if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "getDpcCompressResolution inBlackPhone = " + this.f65778f + " dpcCompressSize=" + iVar);
        }
        return iVar;
    }

    public CameraCaptureView.h i(Context context) {
        CameraCaptureView.h hVar = new CameraCaptureView.h();
        int a16 = com.tencent.aelight.camera.ae.flashshow.util.a.a();
        com.tencent.mobileqq.activity.richmedia.i e16 = e(a16);
        com.tencent.mobileqq.activity.richmedia.i g16 = g(a16);
        com.tencent.mobileqq.activity.richmedia.i j3 = j(context);
        if (e16 != null) {
            hVar.q(e16.b());
            hVar.p(e16.a());
        }
        if (g16 != null) {
            hVar.o(g16.b());
            hVar.n(g16.a());
        }
        if (j3 != null) {
            hVar.j(j3.b());
            hVar.i(j3.a());
        }
        hVar.m(k(a16));
        int d16 = d(a16) * 1000;
        hVar.k(d16);
        CodecParam.mMaxrate = d16;
        hVar.l(1);
        hVar.h(a16);
        if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen() && Build.VERSION.SDK_INT < 27) {
            hVar.g(0);
        }
        return hVar;
    }

    public com.tencent.mobileqq.activity.richmedia.i j(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new com.tencent.mobileqq.activity.richmedia.i(displayMetrics.heightPixels, displayMetrics.widthPixels);
    }

    public float k(int i3) {
        return 1.0f;
    }

    public boolean l() {
        return this.f65777e;
    }

    public boolean m() {
        return this.f65785m == 1;
    }

    public boolean n(int i3, long j3, long j16, int i16) {
        int K = ah.K();
        if (K < i16) {
            AVCoreLog.printColorLog("DovSVParamManager", "isSupportOfDevice error OSversion: " + K);
            return false;
        }
        int numCores = AVCoreSystemInfo.getNumCores();
        if (numCores < i3) {
            AVCoreLog.printColorLog("DovSVParamManager", "isSupportOfDevice error cpucount: " + numCores);
            return false;
        }
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        if (maxCpuFreq < j3) {
            AVCoreLog.printColorLog("DovSVParamManager", "isSupportOfDevice error cpuFrequency: " + maxCpuFreq);
            return false;
        }
        long c16 = com.tencent.mobileqq.utils.m.c();
        if (c16 >= j16) {
            return true;
        }
        AVCoreLog.printColorLog("DovSVParamManager", "isSupportOfDevice error memory: " + c16);
        return false;
    }

    public void o() {
        try {
            JSONObject jSONObject = new JSONObject(f());
            t(jSONObject);
            x(jSONObject);
            p(jSONObject);
            q(jSONObject);
            s(jSONObject);
            r(jSONObject);
            y(jSONObject);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DovSVParamManager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(e16));
            }
        }
    }

    public void p(JSONObject jSONObject) {
        if (!DeviceInfoMonitor.getModel().contains("Pixel") && !DeviceInfoMonitor.getModel().contains("Nexus") && Build.VERSION.SDK_INT < 24) {
            if (TextUtils.isEmpty(this.f65773a)) {
                this.f65773a = new OpenclInfoManager().a();
                QLog.d("DovSVParamManager", 1, "GPUInfo:" + this.f65773a);
            }
            if (TextUtils.isEmpty(this.f65773a)) {
                this.f65775c = !n(4, ShortVideoConstants.VIDEO_MAX_DURATION, 2573741824L, 17);
            }
        } else {
            this.f65775c = !n(4, ShortVideoConstants.VIDEO_MAX_DURATION, 2573741824L, 17);
        }
        w(jSONObject);
    }

    public void y(JSONObject jSONObject) {
        try {
            this.f65785m = jSONObject.optInt("samSungCameraSwitch", 1);
            if (QLog.isColorLevel()) {
                QLog.d("DovSVParamManager", 2, "parseJsonSamSungSwitch parseJsonSamSungSwitch:" + this.f65785m);
            }
        } catch (Exception unused) {
        }
    }
}
