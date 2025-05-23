package oz4;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class m implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static final m f424787m = new m();

    /* renamed from: d, reason: collision with root package name */
    public String f424788d;

    /* renamed from: e, reason: collision with root package name */
    public String f424789e;

    /* renamed from: f, reason: collision with root package name */
    public int f424790f;

    /* renamed from: h, reason: collision with root package name */
    public String f424791h = Build.BRAND;

    /* renamed from: i, reason: collision with root package name */
    public String f424792i = DeviceInfoMonitor.getModel();

    public static m a() {
        return f424787m;
    }

    public final String toString() {
        return "TrackerEventDevice{deviceId='" + this.f424788d + "', platform='Android', osVersionName='" + this.f424789e + "', osVersionCode=" + this.f424790f + ", deviceAbi='null', deviceLevel=0, deviceBrand='" + this.f424791h + "', deviceModel='" + this.f424792i + "'}";
    }
}
