package mb4;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.f;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J,\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lmb4/a;", "", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "", "d", "c", "eventCode", "", "params", "", "realTime", "e", "Ljava/lang/String;", "uid", "qqVersion", "Z", "paramInit", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uid = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String qqVersion = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean paramInit;

    public a() {
        QQBeaconReport.start();
    }

    private final String a() {
        return "0DOU0MSV4Q4W25E8";
    }

    private final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!this.paramInit) {
            d();
        }
        hashMap.put("k_uid", this.uid);
        hashMap.put("k_qq_version", this.qqVersion);
        hashMap.put("k_is_publish_version", "1");
        hashMap.put("k_net_state", String.valueOf(NetworkUtil.isNetworkAvailable()));
        hashMap.put("k_server_env", ((IZPlanApi) QRoute.api(IZPlanApi.class)).getSSOServerEnvName());
        return hashMap;
    }

    private final String c() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            String uin = firstSimpleAccount.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "{\n            simpleAccount.uin\n        }");
            return uin;
        }
        return "";
    }

    private final void d() {
        this.uid = c();
        String b16 = f.b(BaseApplication.context);
        Intrinsics.checkNotNullExpressionValue(b16, "getVersionName(BaseApplication.context)");
        this.qqVersion = b16;
        this.paramInit = true;
    }

    public final void e(String eventCode, Map<String, String> params, boolean realTime) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        HashMap<String, String> b16 = b();
        if (params != null) {
            b16.putAll(params);
        }
        QQBeaconReport.reportWithAppKey(a(), this.uid, eventCode, true, b16, realTime);
    }
}
