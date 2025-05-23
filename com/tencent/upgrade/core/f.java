package com.tencent.upgrade.core;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.dependency.AbsLog;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.rdelivery.net.BaseProto$BizSystemID;
import com.tencent.rdelivery.net.BaseProto$PullTarget;
import com.tencent.rdelivery.net.BaseProto$ServerType;
import com.tencent.upgrade.bean.UpgradeConfig;
import com.tencent.upgrade.core.IBasePkgFile;
import iz3.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001eR\u0016\u0010\"\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/upgrade/core/f;", "", "Landroid/content/Context;", "context", "Lcom/tencent/raft/standard/net/IRNetwork;", "irNetwork", "Lcom/tencent/raft/standard/task/IRTask;", "irTask", "Lcom/tencent/rdelivery/a;", "c", "Lcom/tencent/upgrade/bean/UpgradeConfig;", DownloadInfo.spKey_Config, "Liz3/e;", "listener", "Lcom/tencent/rdelivery/RDeliverySetting;", "d", "Lorg/json/JSONArray;", "apkBasicInfos", "Lorg/json/JSONObject;", "g", "", "targetABi", "f", "diffPkgs", tl.h.F, "Lcom/tencent/rdelivery/RDelivery;", "e", "", "configValue", "b", "", "i", "a", "Z", "isCDNBusy", "<init>", "()V", "upgrade_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isCDNBusy;

    /* renamed from: b, reason: collision with root package name */
    public static final f f383826b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/upgrade/core/f$a", "Lcom/tencent/rdelivery/dependency/AbsLog;", "", "tag", "Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "logLevel", "msg", "", "b", "", "throwable", "c", "upgrade_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class a extends AbsLog {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.rdelivery.dependency.AbsLog
        public void b(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, tag, logLevel, msg2);
                return;
            }
            Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
            int i3 = e.f383823a[logLevel.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                com.tencent.upgrade.util.d.c(tag, msg2);
                                return;
                            }
                            return;
                        }
                        com.tencent.upgrade.util.d.l(tag, msg2);
                        return;
                    }
                    com.tencent.upgrade.util.d.g(tag, msg2);
                    return;
                }
                com.tencent.upgrade.util.d.a(tag, msg2);
                return;
            }
            com.tencent.upgrade.util.d.j(tag, msg2);
        }

        @Override // com.tencent.rdelivery.dependency.AbsLog
        public void c(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, tag, logLevel, msg2, throwable);
                return;
            }
            Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
            int i3 = e.f383824b[logLevel.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                com.tencent.upgrade.util.d.d(tag, msg2, throwable);
                                return;
                            }
                            return;
                        }
                        com.tencent.upgrade.util.d.m(tag, msg2, throwable);
                        return;
                    }
                    com.tencent.upgrade.util.d.h(tag, msg2, throwable);
                    return;
                }
                com.tencent.upgrade.util.d.b(tag, msg2, throwable);
                return;
            }
            com.tencent.upgrade.util.d.k(tag, msg2, throwable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "data", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class b implements q {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f383827a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11196);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f383827a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // iz3.q
        public final void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
                return;
            }
            com.tencent.upgrade.util.d.a("RDeliveryHelper", "RDelivery SubSystemRespListener data = " + jSONObject);
            Boolean bool = null;
            if (jSONObject != null) {
                jSONObject2 = jSONObject.optJSONObject("grayBizData");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                bool = Boolean.valueOf(jSONObject2.optBoolean("cdnBusy"));
            }
            f fVar = f.f383826b;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            f.isCDNBusy = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/upgrade/core/f$c", "Liz3/h;", "", "onInitFinish", "upgrade_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class c implements iz3.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // iz3.h
        public void onInitFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                com.tencent.upgrade.util.d.g("RDeliveryHelper", "RDelivery Configs Loaded.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f383826b = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final com.tencent.rdelivery.a c(Context context, IRNetwork irNetwork, IRTask irTask) {
        if (irNetwork == null) {
            irNetwork = new com.tencent.rdelivery.dependencyimpl.c(context, 0, 0, 6, null);
        }
        MmkvStorage.b bVar = new MmkvStorage.b();
        if (irTask == null) {
            irTask = new com.tencent.rdelivery.dependencyimpl.a();
        }
        return new com.tencent.rdelivery.a(irNetwork, bVar, irTask, new a());
    }

    private final RDeliverySetting d(Context context, UpgradeConfig config, iz3.e listener) {
        BaseProto$ServerType baseProto$ServerType;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.upgrade.util.a.f());
        sb5.append('#');
        j l3 = j.l();
        Intrinsics.checkExpressionValueIsNotNull(l3, "UpgradeManager.getInstance()");
        sb5.append(l3.k());
        sb5.append('#');
        j l16 = j.l();
        Intrinsics.checkExpressionValueIsNotNull(l16, "UpgradeManager.getInstance()");
        sb5.append(l16.j());
        String sb6 = sb5.toString();
        RDeliverySetting.a aVar = new RDeliverySetting.a();
        String appId = config.getAppId();
        String str = "";
        if (appId == null) {
            appId = "";
        }
        aVar.N(appId);
        String appKey = config.getAppKey();
        if (appKey == null) {
            appKey = "";
        }
        aVar.O(appKey);
        String userId = config.getUserId();
        if (userId == null) {
            userId = "";
        }
        aVar.n0(userId);
        Boolean isDebugPackage = config.isDebugPackage();
        if (isDebugPackage == null) {
            isDebugPackage = Boolean.FALSE;
        }
        aVar.f0(isDebugPackage);
        aVar.k0(BaseProto$BizSystemID.GRAY_PKG.getValue());
        aVar.h0(BaseProto$PullTarget.APP);
        String packageName = context.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "context.packageName");
        aVar.P(packageName);
        aVar.d0(sb6);
        aVar.e0(Boolean.valueOf(com.tencent.upgrade.util.b.a()));
        String devModel = config.getDevModel();
        if (devModel == null) {
            devModel = "";
        }
        aVar.X(devModel);
        String devManufacturer = config.getDevManufacturer();
        if (devManufacturer == null) {
            devManufacturer = "";
        }
        aVar.W(devManufacturer);
        String systemVersion = config.getSystemVersion();
        if (systemVersion != null) {
            str = systemVersion;
        }
        aVar.M(str);
        Map<String, String> customParams = config.getCustomParams();
        if (customParams == null) {
            customParams = null;
        }
        aVar.S(customParams);
        if (config.isDebugMode()) {
            baseProto$ServerType = BaseProto$ServerType.TEST;
        } else {
            baseProto$ServerType = BaseProto$ServerType.RELEASE;
        }
        aVar.T(baseProto$ServerType);
        aVar.Z(config.isPrintInternalLog());
        aVar.c0(listener);
        aVar.j0(b.f383827a);
        return aVar.a();
    }

    private final JSONObject f(JSONArray apkBasicInfos, int targetABi) {
        if (apkBasicInfos == null) {
            return null;
        }
        int length = apkBasicInfos.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = apkBasicInfos.optJSONObject(i3);
            if (optJSONObject != null && optJSONObject.optInt("bit") == targetABi) {
                optJSONObject.remove("bit");
                return optJSONObject;
            }
        }
        return null;
    }

    private final JSONObject g(JSONArray apkBasicInfos) {
        int i3;
        if (com.tencent.upgrade.util.b.a()) {
            i3 = 64;
        } else {
            i3 = 32;
        }
        JSONObject f16 = f(apkBasicInfos, i3);
        if (f16 == null && com.tencent.upgrade.util.b.a()) {
            j l3 = j.l();
            Intrinsics.checkExpressionValueIsNotNull(l3, "UpgradeManager.getInstance()");
            if (l3.t()) {
                JSONObject f17 = f(apkBasicInfos, 32);
                com.tencent.upgrade.util.d.a("RDeliveryHelper", "findTargetApkBasicInfo allow32BitApkOn64BitDevice, targetApkBasicInfo = " + f17);
                return f17;
            }
            return f16;
        }
        return f16;
    }

    private final JSONObject h(JSONArray diffPkgs) {
        String str;
        Integer num;
        if (diffPkgs == null) {
            return null;
        }
        String f16 = com.tencent.upgrade.util.a.f();
        j l3 = j.l();
        Intrinsics.checkExpressionValueIsNotNull(l3, "UpgradeManager.getInstance()");
        int k3 = l3.k();
        int length = diffPkgs.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = diffPkgs.optJSONObject(i3);
            if (optJSONObject != null) {
                str = optJSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION);
            } else {
                str = null;
            }
            if (optJSONObject != null) {
                num = Integer.valueOf(optJSONObject.optInt("baseVersionCode"));
            } else {
                num = null;
            }
            if (Intrinsics.areEqual(f16, str) && num != null && k3 == num.intValue()) {
                if (optJSONObject != null && optJSONObject.optInt("diffType") == IBasePkgFile.DiffType.DIFF_FROM_ORIGIN.getValue()) {
                    j l16 = j.l();
                    Intrinsics.checkExpressionValueIsNotNull(l16, "UpgradeManager.getInstance()");
                    Context i16 = l16.i();
                    j l17 = j.l();
                    Intrinsics.checkExpressionValueIsNotNull(l17, "UpgradeManager.getInstance()");
                    int k16 = l17.k();
                    j l18 = j.l();
                    Intrinsics.checkExpressionValueIsNotNull(l18, "UpgradeManager.getInstance()");
                    if (Intrinsics.areEqual(optJSONObject.optString("baseMd5"), com.tencent.upgrade.util.a.d(i16, k16, l18.j(), com.tencent.upgrade.util.a.f()))) {
                    }
                }
                return optJSONObject;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String b(@NotNull String configValue) {
        Object m476constructorimpl;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configValue);
        }
        Intrinsics.checkParameterIsNotNull(configValue, "configValue");
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject2 = new JSONObject(configValue);
            JSONArray optJSONArray = jSONObject2.optJSONArray("apkBasicInfos");
            f fVar = f383826b;
            JSONObject g16 = fVar.g(optJSONArray);
            if (g16 != null) {
                JSONObject h16 = fVar.h(g16.optJSONArray("diffPkgs"));
                g16.remove("diffPkgs");
                g16.put("diffPkg", h16);
                jSONObject2.remove("apkBasicInfos");
                jSONObject2.putOpt("apkBasicInfo", g16);
                jSONObject.putOpt("code", 0);
                jSONObject.putOpt("message", "");
                jSONObject.putOpt("data", jSONObject2);
                unit = jSONObject;
            } else {
                com.tencent.upgrade.util.d.a("RDeliveryHelper", "convertRDConfigToUpgradeResponse find no targetApkBasicInfo\uff0cis64BitDevice = " + com.tencent.upgrade.util.b.a());
                unit = Unit.INSTANCE;
            }
            m476constructorimpl = Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            com.tencent.upgrade.util.d.d("RDeliveryHelper", "convertRDConfigToUpgradeResponse failed", m479exceptionOrNullimpl);
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "resultJson.toString()");
        return jSONObject3;
    }

    @NotNull
    public final RDelivery e(@NotNull Context context, @NotNull UpgradeConfig config, @Nullable iz3.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RDelivery) iPatchRedirector.redirect((short) 1, this, context, config, listener);
        }
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(config, "config");
        RDelivery a16 = RDelivery.INSTANCE.a(context, d(context, config, listener), c(context, config.getIrNetwork(), config.getIrTask()), new c());
        com.tencent.upgrade.util.d.a("RDeliveryHelper", "createRDeliveryInstance rDelivery = " + a16);
        return a16;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return isCDNBusy;
    }
}
