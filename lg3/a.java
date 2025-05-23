package lg3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.download.HalleyDownloader;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\f\u00a8\u0006\u0019"}, d2 = {"Llg3/a;", "", "", "d", "Llg3/b;", "cloudNetworkData", "e", "b", "a", "", "c", "", "I", "getCurrentLimitSpeed", "()I", "setCurrentLimitSpeed", "(I)V", "currentLimitSpeed", "currentDelay", "DELAY_MAX", "DELAY_MIN", "f", "INCREMENT", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414537a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int currentLimitSpeed = 1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentDelay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int DELAY_MAX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int DELAY_MIN;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int INCREMENT;

    static {
        DELAY_MAX = 100;
        DELAY_MIN = 50;
        INCREMENT = 100;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100341", new byte[0]), Charsets.UTF_8);
        if (str.length() > 0) {
            JSONObject jSONObject = new JSONObject(str);
            DELAY_MAX = jSONObject.optInt("delayMax", 100);
            DELAY_MIN = jSONObject.optInt("delayMin", 50);
            INCREMENT = jSONObject.optInt("increment", 100);
        }
    }

    a() {
    }

    private final void d() {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("key_launched_cloud_mod", true);
    }

    public final void b() {
        d();
        ModSilentDownloadHelper.H(ModSilentDownloadHelper.f334775a, false, true, 0, true, 4, null);
        QLog.i("CloudDownloadManager_", 1, "markLaunchedCloudMod");
    }

    public final boolean c() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("key_launched_cloud_mod", false);
    }

    public final void e(CloudNetworkData cloudNetworkData) {
        Intrinsics.checkNotNullParameter(cloudNetworkData, "cloudNetworkData");
        QLog.i("CloudDownloadManager_", 1, "updateDownloadLimit start , delay == " + cloudNetworkData.getDelay());
        if (com.tencent.halley.b.f().g().isEmpty()) {
            QLog.i("CloudDownloadManager_", 1, "Has no download task , do nothing");
            return;
        }
        if (cloudNetworkData.getDelay() > DELAY_MAX) {
            currentLimitSpeed /= 2;
            QLog.i("CloudDownloadManager_", 1, "The delay is higher than 100 , speed down now");
        } else if (cloudNetworkData.getDelay() < DELAY_MIN) {
            currentLimitSpeed += INCREMENT;
            QLog.i("CloudDownloadManager_", 1, "The delay is lower than 50 , speed up now");
        } else {
            QLog.i("CloudDownloadManager_", 1, "The delay is normal , do nothing");
        }
        currentDelay = cloudNetworkData.getDelay();
        if (currentLimitSpeed <= 1) {
            currentLimitSpeed = 1;
        }
        QLog.i("CloudDownloadManager_", 1, "Finally , limit speed == " + currentLimitSpeed);
        long currentTimeMillis = System.currentTimeMillis();
        HalleyDownloader.f327980a.n(currentLimitSpeed);
        QLog.i("CloudDownloadManager_", 1, "cost == " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a() {
        currentLimitSpeed = 1;
        HalleyDownloader.f327980a.a();
        ModSilentDownloadHelper.H(ModSilentDownloadHelper.f334775a, false, true, 0, true, 4, null);
        QLog.i("CloudDownloadManager_", 1, "cancelDownloadSpeedLimit");
    }
}
