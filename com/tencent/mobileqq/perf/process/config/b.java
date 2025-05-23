package com.tencent.mobileqq.perf.process.config;

import com.tencent.avbiz.Constants;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0018j\b\u0012\u0004\u0012\u00020\u0006`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u001a\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b+\u0010\u000eR\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b\t\u00104\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/b;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "configObj", "", "k", "", "toString", "", "d", "Z", "i", "()Z", "setMainSwitch", "(Z)V", "mainSwitch", "", "e", "J", h.F, "()J", "setKillUnimportantProcessTimeMs", "(J)V", "killUnimportantProcessTimeMs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "j", "()Ljava/util/ArrayList;", "setProcessWhiteList", "(Ljava/util/ArrayList;)V", "processWhiteList", "", "Ljava/util/List;", "()Ljava/util/List;", "setFloatWrapperBlackList", "(Ljava/util/List;)V", "floatWrapperBlackList", "g", "setKillUnimportantProcessSwitch", "killUnimportantProcessSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setCeilingKillSwitch", "ceilingKillSwitch", BdhLogUtil.LogTag.Tag_Conn, "c", "setCeilingKillDelayTimeMs", "ceilingKillDelayTimeMs", "", "D", "I", "()I", "setCeilingKillMemMB", "(I)V", "ceilingKillMemMB", "<init>", "()V", "E", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static b F;

    /* renamed from: C, reason: from kotlin metadata */
    private long ceilingKillDelayTimeMs;

    /* renamed from: D, reason: from kotlin metadata */
    private int ceilingKillMemMB;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mainSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long killUnimportantProcessTimeMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> processWhiteList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> floatWrapperBlackList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean killUnimportantProcessSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean ceilingKillSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/b$a;", "", "Lcom/tencent/mobileqq/perf/process/config/b;", "c", "", "e", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/perf/process/config/b;", "b", "()Lcom/tencent/mobileqq/perf/process/config/b;", "d", "(Lcom/tencent/mobileqq/perf/process/config/b;)V", "getInstance$annotations", "()V", "", "GROUP", "Ljava/lang/String;", "", "KILL_CEILING_PROCESS_DELAY_TIME", "J", "", "KILL_CEILING_PROCESS_MEMORY", "I", "KILL_CEILING_PROCESS_MEMORY_DEBUG", "KILL_UNIMPORTANT_PROCESS_TIME_DEFAULT", "PROCESS_WHITE_LIST", "TAG", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.config.b$a, reason: from kotlin metadata */
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
        public final b c() {
            b bVar;
            try {
                f fVar = f.f257911a;
                if (fVar.e()) {
                    QLog.i("BackgroundConfig", 1, "loadConfig, use local config");
                    bVar = new b();
                    bVar.k(new JSONObject(fVar.a()));
                } else {
                    QLog.i("BackgroundConfig", 1, "loadConfig, use publish config");
                    bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100969");
                    if (bVar == null) {
                        bVar = new b();
                    }
                }
                return bVar;
            } catch (Throwable th5) {
                QLog.e("BackgroundConfig", 1, "loadConfig, error. use default config", th5);
                return new b();
            }
        }

        @NotNull
        public final b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.F;
            }
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void d(@NotNull b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            } else {
                Intrinsics.checkNotNullParameter(bVar, "<set-?>");
                b.F = bVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        F = companion.c();
    }

    public b() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.killUnimportantProcessTimeMs = MiniBoxNoticeInfo.MIN_5;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Constants.Process.VIDEO_PROCESS, "com.tencent.mobileqq", "com.tencent.mobileqq:MSF");
        this.processWhiteList = arrayListOf;
        this.floatWrapperBlackList = com.tencent.mobileqq.perf.process.state.floating.a.f257938a.b();
        this.ceilingKillDelayTimeMs = 2000L;
        this.ceilingKillMemMB = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.ceilingKillDelayTimeMs;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.ceilingKillMemMB;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.ceilingKillSwitch;
    }

    @NotNull
    public final List<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.floatWrapperBlackList;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.killUnimportantProcessSwitch;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.killUnimportantProcessTimeMs;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mainSwitch;
    }

    @NotNull
    public final ArrayList<String> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.processWhiteList;
    }

    public final void k(@NotNull JSONObject configObj) {
        int optInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) configObj);
            return;
        }
        Intrinsics.checkNotNullParameter(configObj, "configObj");
        this.mainSwitch = configObj.optBoolean("mainSwitch", false);
        this.killUnimportantProcessTimeMs = configObj.optLong("killUnimportantProcessTimeMs", MiniBoxNoticeInfo.MIN_5);
        this.processWhiteList = g.a(configObj, "processWhiteList");
        this.floatWrapperBlackList = g.a(configObj, "floatWrapperBlackList");
        JSONObject b16 = g.b(configObj);
        if (b16 != null) {
            this.killUnimportantProcessSwitch = b16.optBoolean("killUnimportantProcessSwitch", false);
            this.ceilingKillSwitch = b16.optBoolean("ceilingKillSwitch", false);
            this.ceilingKillDelayTimeMs = b16.optLong("ceilingKillDelayTimeMs", 2000L);
            if (AppSetting.isDebugVersion()) {
                optInt = 2500;
            } else {
                optInt = b16.optInt("ceilingKillThresholdMemMB", TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
            }
            this.ceilingKillMemMB = optInt;
        }
        QLog.i("BackgroundConfig", 1, "parseBackgroundConfig, " + this);
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List split$default;
        Object lastOrNull;
        String removePrefix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("backgroundConfig(mainSwitch=");
        sb5.append(this.mainSwitch);
        sb5.append(", unimportantDelayTimeMs=");
        sb5.append(this.killUnimportantProcessTimeMs);
        sb5.append(", processWhiteList=");
        ArrayList<String> arrayList = this.processWhiteList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            removePrefix = StringsKt__StringsKt.removePrefix((String) it.next(), (CharSequence) "com.tencent.mobileqq:");
            arrayList2.add(removePrefix);
        }
        sb5.append(arrayList2);
        sb5.append(", floatBlack=");
        List<String> list = this.floatWrapperBlackList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it5.next(), new String[]{"."}, false, 0, 6, (Object) null);
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
            arrayList3.add((String) lastOrNull);
        }
        sb5.append(arrayList3);
        sb5.append(", unimportantSwitch=");
        sb5.append(this.killUnimportantProcessSwitch);
        sb5.append(", ceilingSwitch=");
        sb5.append(this.ceilingKillSwitch);
        sb5.append(", ceilingDelayTimeMs=");
        sb5.append(this.ceilingKillDelayTimeMs);
        sb5.append(", ceilingThresholdMB=");
        sb5.append(this.ceilingKillMemMB);
        sb5.append(')');
        return sb5.toString();
    }
}
