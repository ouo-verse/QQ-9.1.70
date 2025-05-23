package gm2;

import android.os.Build;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f402405a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f402406b = false;

    public static boolean a() {
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (QLog.isColorLevel()) {
            QLog.d("CaptureUtil", 2, "isX86Platform: Build.CPU_ABI=" + str + " Build.CPU_ABI2=" + str2);
        }
        if (str != null && !"".equals(str) && ResourceAttributes.HostArchValues.X86.equalsIgnoreCase(str)) {
            return true;
        }
        if (AVCoreSystemInfo.getCpuArchitecture() == 7) {
            if (QLog.isColorLevel()) {
                QLog.d("CaptureUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
            }
            return true;
        }
        return false;
    }

    public static synchronized boolean b() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i3;
        synchronized (b.class) {
            if (!f402406b) {
                if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                ms.a.c("CaptureUtil", "PtvFilterSoLoad.getFilterSoState result = " + z17);
                ms.a.c("CaptureUtil", "[loadEffectSo] base so load start ");
                if (z17) {
                    z18 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
                    z19 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isFilterFaceSoVersionOK();
                    if (z18 && z19) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    f402405a = i3;
                } else {
                    f402405a = 2;
                    z18 = false;
                    z19 = false;
                }
                if (z18 && z19) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                f402406b = z26;
                ms.a.c("CaptureUtil", "[loadEffectSo] base so load end ");
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureUtil", 2, "loadEffectSo, ", Boolean.valueOf(f402406b), "  ptuSo:", Boolean.valueOf(z18), "  ptuSoVersion:", Boolean.valueOf(z19), " result:", Boolean.valueOf(z17), "  PTV_FILTER_SO_LOADED:", Integer.valueOf(f402405a));
                }
            }
            z16 = f402406b;
        }
        return z16;
    }

    public static boolean c() {
        return !a();
    }

    public static boolean d() {
        int i3;
        boolean isSwitchOpen = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSwitchOpen();
        if (!isSwitchOpen) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        DeviceInfoMonitor.getModel().equals("GT-I9500");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", Integer.toString(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMediaCodecSupport", isSwitchOpen, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.i("CaptureUtil", 2, "mediacodec isMediaCodecSupport:" + isSwitchOpen + ", code:" + i3);
        }
        return isSwitchOpen;
    }
}
