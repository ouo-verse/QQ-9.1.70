package com.tencent.mobileqq.perf.process.config;

import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.process.broadcast.MainProcessBroadcastReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 !2\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R2\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010(\u001a\u0004\b \u0010)\"\u0004\b*\u0010+R\"\u0010.\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010!\u001a\u0004\b\u0013\u0010#\"\u0004\b-\u0010%R\"\u00101\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010(\u001a\u0004\b\f\u0010)\"\u0004\b0\u0010+\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/e;", "Lcom/tencent/freesia/IConfigData;", "", "configStr", "", "l", "Lorg/json/JSONObject;", "foreConfigObj", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "processName", "", "k", "d", "Z", "i", "()Z", "setForePreloadSwitch", "(Z)V", "forePreloadSwitch", "e", "f", "setForeKillSwitch", "foreKillSwitch", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "j", "()Ljava/util/ArrayList;", "setForeProcessWhiteList", "(Ljava/util/ArrayList;)V", "foreProcessWhiteList", "", h.F, "D", "g", "()D", "setForePreloadMemFreeRatio", "(D)V", "forePreloadMemFreeRatio", "", "I", "()I", "setForePreloadMemFreeThreshold", "(I)V", "forePreloadMemFreeThreshold", "setForeKillMemFreeRatio", "foreKillMemFreeRatio", BdhLogUtil.LogTag.Tag_Conn, "setForeKillCheckInterval", "foreKillCheckInterval", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static e E;

    /* renamed from: C, reason: from kotlin metadata */
    private int foreKillCheckInterval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean forePreloadSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean foreKillSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> foreProcessWhiteList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private double forePreloadMemFreeRatio;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int forePreloadMemFreeThreshold;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private double foreKillMemFreeRatio;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/e$a;", "", "Lcom/tencent/mobileqq/perf/process/config/e;", "c", "", "e", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/perf/process/config/e;", "b", "()Lcom/tencent/mobileqq/perf/process/config/e;", "d", "(Lcom/tencent/mobileqq/perf/process/config/e;)V", "getInstance$annotations", "()V", "", "GROUP", "Ljava/lang/String;", "PROCESS_WHITE_LIST", "TAG", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.config.e$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final e c() {
            e eVar;
            try {
                f fVar = f.f257911a;
                if (fVar.e()) {
                    QLog.i("ForegroundConfig", 1, "loadConfig, use local config");
                    eVar = new e();
                    eVar.l(fVar.c());
                } else {
                    QLog.i("ForegroundConfig", 1, "loadConfig, use publish config");
                    eVar = (e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100970");
                    if (eVar == null) {
                        eVar = new e();
                    }
                }
                return eVar;
            } catch (Throwable th5) {
                QLog.e("ForegroundConfig", 1, "loadConfig, error. use default config", th5);
                return new e();
            }
        }

        @NotNull
        public final e b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return e.E;
            }
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void d(@NotNull e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
            } else {
                Intrinsics.checkNotNullParameter(eVar, "<set-?>");
                e.E = eVar;
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                d(c());
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        E = companion.c();
    }

    public e() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("com.tencent.mobileqq:qzone", GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:zplan", "com.tencent.mobileqq:gameservice");
            this.foreProcessWhiteList = arrayListOf;
            this.forePreloadMemFreeRatio = 0.2d;
            this.forePreloadMemFreeThreshold = 600;
            this.foreKillMemFreeRatio = 0.1d;
            this.foreKillCheckInterval = 5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        MainProcessBroadcastReceiver.f257874a.e();
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.foreKillCheckInterval;
    }

    public final double e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Double) iPatchRedirector.redirect((short) 12, (Object) this)).doubleValue();
        }
        return this.foreKillMemFreeRatio;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.foreKillSwitch;
    }

    public final double g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Double) iPatchRedirector.redirect((short) 8, (Object) this)).doubleValue();
        }
        return this.forePreloadMemFreeRatio;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.forePreloadMemFreeThreshold;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.forePreloadSwitch;
    }

    @NotNull
    public final ArrayList<String> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.foreProcessWhiteList;
    }

    public final boolean k(@NotNull String processName) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) processName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(processName, "processName");
        ArrayList<String> arrayList = this.foreProcessWhiteList;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(processName, (String) it.next(), false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    public final void l(@NotNull String configStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) configStr);
        } else {
            Intrinsics.checkNotNullParameter(configStr, "configStr");
            m(new JSONObject(configStr));
        }
    }

    public final void m(@NotNull JSONObject foreConfigObj) {
        int collectionSizeOrDefault;
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) foreConfigObj);
            return;
        }
        Intrinsics.checkNotNullParameter(foreConfigObj, "foreConfigObj");
        this.forePreloadSwitch = foreConfigObj.optBoolean("preloadSwitch", false);
        this.forePreloadMemFreeRatio = foreConfigObj.optDouble("preloadMemFreeRation", 0.2d);
        this.forePreloadMemFreeThreshold = foreConfigObj.optInt("preloadMemFreeThreshold", 600);
        this.foreKillSwitch = foreConfigObj.optBoolean("killSwitch", false);
        this.foreKillMemFreeRatio = foreConfigObj.optDouble("killFreeMemRatio", 0.1d);
        this.foreKillCheckInterval = foreConfigObj.optInt("killCheckInterval", 5);
        this.foreProcessWhiteList = g.a(foreConfigObj, "processWhiteList");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("foregroundConfig, preloadSwitch=");
        sb5.append(this.forePreloadSwitch);
        sb5.append(", preloadMemFreeRatio=");
        sb5.append(this.forePreloadMemFreeRatio);
        sb5.append(", preloadMemFreeThreshold=");
        sb5.append(this.forePreloadMemFreeThreshold);
        sb5.append(", killSwitch=");
        sb5.append(this.foreKillSwitch);
        sb5.append(", killMemFreeRatio=");
        sb5.append(this.foreKillMemFreeRatio);
        sb5.append(", killCheckInterval=");
        sb5.append(this.foreKillCheckInterval);
        sb5.append(", processWhiteList=");
        ArrayList<String> arrayList = this.foreProcessWhiteList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            removePrefix = StringsKt__StringsKt.removePrefix((String) it.next(), (CharSequence) "com.tencent.mobileqq:");
            arrayList2.add(removePrefix);
        }
        sb5.append(arrayList2);
        QLog.i("ForegroundConfig", 1, sb5.toString());
        if (MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName) && !MainProcessBroadcastReceiver.f257874a.d()) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.perf.process.config.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.n();
                }
            }, 16, null, false, 1000L);
        }
    }
}
