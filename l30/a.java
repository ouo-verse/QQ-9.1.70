package l30;

import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.immersive.utils.at;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f413771c;

    /* renamed from: a, reason: collision with root package name */
    private RFWLayoutLoaderStrategy f413772a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f413773b;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_aysnc_inflate", false) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    a() {
        boolean z16 = QCircleDeviceInfoUtils.isLowDevice() ? false : true;
        this.f413773b = z16;
    }

    public static a a() {
        if (f413771c == null) {
            synchronized (a.class) {
                if (f413771c == null) {
                    f413771c = new a();
                }
            }
        }
        return f413771c;
    }

    private boolean e() {
        if (HostAppSettingUtil.isPublicVersion() || !HostAppSettingUtil.isGrayVersion()) {
            return true;
        }
        return at.a(2);
    }

    public boolean b() {
        if (this.f413773b && uq3.c.X0("qqcircle", "qqcircle_folder_fragment_pre_inflate", 1).intValue() == 1 && e()) {
            return true;
        }
        return false;
    }

    public RFWLayoutLoaderStrategy c() {
        if (this.f413772a == null) {
            this.f413772a = new b();
        }
        return this.f413772a;
    }

    public int d() {
        try {
            return Integer.parseInt(o.z0("qqcircle_pre_inflate_layer_item_view_count", "inflate_count", "2"));
        } catch (NumberFormatException e16) {
            QLog.e("QFSAsyncInflateConfig", 1, "[getPreInflateItemViewCount] get inflate count error: ", e16);
            return 0;
        }
    }
}
