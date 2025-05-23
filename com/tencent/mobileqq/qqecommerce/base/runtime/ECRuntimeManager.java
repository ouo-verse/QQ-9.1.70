package com.tencent.mobileqq.qqecommerce.base.runtime;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.bd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.ecommerce.base.runtime.api.IECRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guid.c;
import com.tencent.mobileqq.qqecommerce.base.msf.ECNetworkConnectionManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.av;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bR\u001b\u0010\u0011\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/runtime/ECRuntimeManager;", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "Landroid/app/Application;", "getExternalApplicationContext", "", "isDebug", "isMainProcess", "isPublicVersion", "isTestEnv", "", "appVersion", "", "getDeviceInfo", "a", "Lkotlin/Lazy;", "b", "()Z", "mUseAsyncDeviceInfo", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECRuntimeManager implements IECRuntime {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy mUseAsyncDeviceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/runtime/ECRuntimeManager$a;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "b", "", "e", "", "a", "Lmqq/app/AppRuntime;", "c", "d", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String account;
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            AppRuntime runtime = application != null ? application.getRuntime() : null;
            return (runtime == null || (account = runtime.getAccount()) == null) ? "0" : account;
        }

        public final QQAppInterface b() {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
            return null;
        }

        public final AppRuntime c() {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            if (application != null) {
                return application.getRuntime();
            }
            return null;
        }

        public final String d() {
            byte[] c16 = c.f213821a.c();
            if (c16 != null) {
                if (!(c16.length == 0)) {
                    String bytes2HexStr = HexUtil.bytes2HexStr(c16);
                    Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(guidBs)");
                    return bytes2HexStr;
                }
            }
            return "";
        }

        public final long e() {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            AppRuntime runtime = application != null ? application.getRuntime() : null;
            if (runtime != null) {
                return runtime.getLongAccountUin();
            }
            return 0L;
        }

        Companion() {
        }
    }

    public ECRuntimeManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager$mUseAsyncDeviceInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_ec_sync_ip_address", true));
            }
        });
        this.mUseAsyncDeviceInfo = lazy;
    }

    private final boolean b() {
        return ((Boolean) this.mUseAsyncDeviceInfo.getValue()).booleanValue();
    }

    public final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", String.valueOf(INSTANCE.e()));
        linkedHashMap.put("app_env", "2");
        linkedHashMap.put("os", "Android");
        linkedHashMap.put("network_type", ECNetworkConnectionManager.f262432a.a().getValue());
        return linkedHashMap;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public String appVersion() {
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        return subVersion;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public Map<String, String> getDeviceInfo() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String deviceModel = ah.s();
        String t16 = ah.t();
        Intrinsics.checkNotNullExpressionValue(t16, "getDeviceOSVersion()");
        linkedHashMap.put("os_ver", t16);
        String model = b() ? deviceModel : DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(model, "if (mUseAsyncDeviceInfo)\u2026se android.os.Build.MODEL");
        linkedHashMap.put("brand", model);
        if (b()) {
            str = bd.f92680a.g();
        } else {
            try {
                str = ah.G(BaseApplicationImpl.getApplication()).f307419c;
                Intrinsics.checkNotNullExpressionValue(str, "getNetInfo(BaseApplicati\u2026plication()).operatorName");
            } catch (Exception unused) {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "\u672a\u77e5";
        }
        linkedHashMap.put(JsonRuleKey.OPERATOR, str);
        String reportVersionName = AppSetting.f99554n;
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "reportVersionName");
        linkedHashMap.put("app_version", reportVersionName);
        String A = ah.A();
        if (A == null) {
            A = "";
        }
        linkedHashMap.put("device_id", A);
        String b16 = o.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getQimei16()");
        linkedHashMap.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, b16);
        String c16 = o.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
        linkedHashMap.put("qimei36", c16);
        linkedHashMap.put("network", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication())));
        if (b()) {
            linkedHashMap.put("ip", bd.f92680a.f());
        } else {
            String a16 = av.a(BaseApplicationImpl.getApplication());
            linkedHashMap.put("ip", a16 != null ? a16 : "");
        }
        String D = ah.D();
        Intrinsics.checkNotNullExpressionValue(D, "getManufacturer()");
        linkedHashMap.put("manufacturer", D);
        Intrinsics.checkNotNullExpressionValue(deviceModel, "deviceModel");
        linkedHashMap.put("device_brand_and_model", deviceModel);
        linkedHashMap.put("guid", INSTANCE.d());
        return linkedHashMap;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public Application getExternalApplicationContext() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        return application;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isDebug() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isMainProcess() {
        return MobileQQ.sProcessId == 1;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isPublicVersion() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.runtime.api.IECRuntime
    public boolean isTestEnv() {
        return SSODebugUtil.isTestEnv();
    }
}
