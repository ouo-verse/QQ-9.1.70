package com.tencent.mobileqq.qqshop.report.dev;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 52\u00020\u0001:\u00016B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b3\u00104J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J!\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u0006R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040,j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020,j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData;", "Ljava/io/Serializable;", "", "actionName", "", "time", "", "b", "", "milestone", "c", "f", "fromAction", "toAction", "d", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "scene", "addScene", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchAction;", "action", "addNativeAction", "addKuiklyAction", "Lorg/json/JSONObject;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "addKuiklyData", "actions", "addActions", "", "isModuleVersionExists", "doReport", "clickTime", "J", "reportTimeOut", "getReportTimeOut", "()J", "launchOrigin", "Ljava/lang/String;", "getLaunchOrigin", "()Ljava/lang/String;", "setLaunchOrigin", "(Ljava/lang/String;)V", "launchMilestone", "I", "launchScene", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "reportData", "Ljava/util/LinkedHashMap;", "kuiklyReportData", "isReported", "Z", "<init>", "(JJ)V", "Companion", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class KuiklyLaunchData implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int IS_CACHE_MSG_TODAY = 16;
    public static final int IS_CLICK_AGAIN = 1;
    public static final int IS_FORCE_UPDATE_LOAD = 4;
    public static final int IS_LAST_MSG_TODAY = 8;
    public static final int MODULE_VERSION_EXISTS = 2;

    /* renamed from: d */
    @NotNull
    private static final LinkedHashMap<String, String> f274710d;

    /* renamed from: e */
    @NotNull
    private static final Set<KuiklyLaunchAction> f274711e;
    private final long clickTime;
    private boolean isReported;

    @NotNull
    private final LinkedHashMap<String, String> kuiklyReportData;
    private int launchMilestone;

    @Nullable
    private String launchOrigin;
    private int launchScene;

    @NotNull
    private final LinkedHashMap<String, Long> reportData;
    private final long reportTimeOut;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData$a;", "", "", "IS_CACHE_MSG_TODAY", "I", "IS_CLICK_AGAIN", "IS_FORCE_UPDATE_LOAD", "IS_LAST_MSG_TODAY", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "KUIKLY_ACTION_MAP", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchAction;", "MILESTONE_ACTION_SET", "Ljava/util/Set;", "MODULE_VERSION_EXISTS", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchData$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        LinkedHashMap<String, String> linkedMapOf;
        Set<KuiklyLaunchAction> of5;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        linkedMapOf = MapsKt__MapsKt.linkedMapOf(TuplesKt.to(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS, "kuikly_init_start"), TuplesKt.to("fetch_context_code_start", "kuikly_fetch_context_code_start"), TuplesKt.to("fetch_context_code_end", "kuikly_fetch_context_code_end"), TuplesKt.to("render_context_init_start", "kuikly_render_context_init_start"), TuplesKt.to("render_context_init_end", "kuikly_render_context_init_end"), TuplesKt.to("view_load_start", "kuikly_view_load_start"), TuplesKt.to("view_load_end", "kuikly_view_load_end"), TuplesKt.to("layout_start", "kuikly_layout_start"), TuplesKt.to("layout_end", "kuikly_layout_end"), TuplesKt.to("content_view_created", "kuikly_content_view_created"));
        f274710d = linkedMapOf;
        of5 = SetsKt__SetsKt.setOf((Object[]) new KuiklyLaunchAction[]{KuiklyLaunchAction.KUIKLY_INIT_START, KuiklyLaunchAction.KUIKLY_CONTENT_VIEW_CREATED, KuiklyLaunchAction.FIRST_SCREEN, KuiklyLaunchAction.MSG_CARD_SHOW});
        f274711e = of5;
    }

    public KuiklyLaunchData(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.clickTime = j3;
        this.reportTimeOut = j16;
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        this.reportData = linkedHashMap;
        this.kuiklyReportData = new LinkedHashMap<>();
        QLog.d("KuiklyLaunchData", 1, "init, clickTime = " + j3);
        linkedHashMap.put(KuiklyLaunchAction.USER_CLICK.getKey(), Long.valueOf(j3));
    }

    static /* synthetic */ void addAction$default(KuiklyLaunchData kuiklyLaunchData, String str, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j3 = System.currentTimeMillis();
            }
            kuiklyLaunchData.b(str, j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAction");
    }

    public static /* synthetic */ void addKuiklyAction$default(KuiklyLaunchData kuiklyLaunchData, String str, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j3 = System.currentTimeMillis();
            }
            kuiklyLaunchData.addKuiklyAction(str, j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addKuiklyAction");
    }

    public static /* synthetic */ void addNativeAction$default(KuiklyLaunchData kuiklyLaunchData, KuiklyLaunchAction kuiklyLaunchAction, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j3 = System.currentTimeMillis();
            }
            kuiklyLaunchData.addNativeAction(kuiklyLaunchAction, j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNativeAction");
    }

    private final void b(String actionName, long time) {
        if (!this.isReported && !this.reportData.containsKey(actionName)) {
            long j3 = time - this.clickTime;
            QLog.d("KuiklyLaunchData", 2, "action:" + actionName + ",elapsed:" + j3 + ")");
            this.reportData.put(actionName, Long.valueOf(j3));
        }
    }

    private final void c(int milestone) {
        this.launchMilestone = milestone | this.launchMilestone;
    }

    private final Long d(String fromAction, String toAction) {
        Long l3 = this.reportData.get(fromAction);
        if (l3 == null) {
            return null;
        }
        long longValue = l3.longValue();
        Long l16 = this.reportData.get(toAction);
        if (l16 == null) {
            return null;
        }
        return Long.valueOf(l16.longValue() - longValue);
    }

    public static final void e(KuiklyLaunchData this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    private final void f() {
        int checkRadix;
        int checkRadix2;
        int mapCapacity;
        int mapCapacity2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Long d16 = d(KuiklyLaunchAction.LOAD_VIEW_START.getKey(), KuiklyLaunchAction.LOAD_VIEW_END.getKey());
        if (d16 != null) {
            linkedHashMap.put("load_view_cost", Long.valueOf(d16.longValue()));
        }
        Long d17 = d("kuikly_fetch_context_code_start", "kuikly_fetch_context_code_end");
        if (d17 != null) {
            linkedHashMap.put("kuikly_fetch_context_code_cost", Long.valueOf(d17.longValue()));
        }
        Long d18 = d("kuikly_render_context_init_start", "kuikly_render_context_init_end");
        if (d18 != null) {
            linkedHashMap.put("kuikly_render_context_init_cost", Long.valueOf(d18.longValue()));
        }
        Long d19 = d("kuikly_view_load_start", "kuikly_view_load_end");
        if (d19 != null) {
            linkedHashMap.put("kuikly_view_load_cost", Long.valueOf(d19.longValue()));
        }
        Long d26 = d("kuikly_layout_start", "kuikly_layout_end");
        if (d26 != null) {
            linkedHashMap.put("kuikly_layout_cost", Long.valueOf(d26.longValue()));
        }
        Long d27 = d(KuiklyLaunchAction.FETCH_MSG_START.getKey(), KuiklyLaunchAction.FETCH_MSG_END.getKey());
        if (d27 != null) {
            linkedHashMap.put("fetch_msg_cost", Long.valueOf(d27.longValue()));
        }
        int i3 = this.launchMilestone;
        checkRadix = CharsKt__CharJVMKt.checkRadix(2);
        String num = Integer.toString(i3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        int i16 = this.launchScene;
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(2);
        String num2 = Integer.toString(i16, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
        QLog.d("KuiklyLaunchData", 2, "launchMilestone: " + num + ", launchScene:" + num2 + ", kuiklyReportData:" + this.kuiklyReportData + ", elapsed:" + linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap<String, Long> linkedHashMap3 = this.reportData;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap3.size());
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(mapCapacity);
        Iterator<T> it = linkedHashMap3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap4.put(entry.getKey(), String.valueOf(((Number) entry.getValue()).longValue()));
        }
        linkedHashMap2.putAll(linkedHashMap4);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(mapCapacity2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap5.put(entry2.getKey(), String.valueOf(((Number) entry2.getValue()).longValue()));
        }
        linkedHashMap2.putAll(linkedHashMap5);
        linkedHashMap2.putAll(this.kuiklyReportData);
        String str = this.launchOrigin;
        if (str == null) {
            str = "";
        }
        linkedHashMap2.put("launch_origin", str);
        linkedHashMap2.put("launch_milestone", String.valueOf(this.launchMilestone));
        linkedHashMap2.put("launch_scene", String.valueOf(this.launchScene));
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("qqshop_kuikly_launch_Android", (Map<String, String>) linkedHashMap2);
    }

    public final void addActions(@NotNull JSONObject actions) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) actions);
            return;
        }
        Intrinsics.checkNotNullParameter(actions, "actions");
        Iterator<Map.Entry<String, String>> it = f274710d.entrySet().iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            long optLong = actions.optLong(key, 0L);
            if (optLong > 0) {
                b(value, optLong);
                Iterator<T> it5 = f274711e.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((KuiklyLaunchAction) obj).getKey(), value)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                KuiklyLaunchAction kuiklyLaunchAction = (KuiklyLaunchAction) obj;
                if (kuiklyLaunchAction != null) {
                    i3 = kuiklyLaunchAction.getMilestone();
                }
                c(i3);
            }
        }
        if (actions.optInt("is_force_update_load", 0) == 1) {
            addScene(4);
        }
    }

    public final void addKuiklyAction(@NotNull String actionName, long time) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, actionName, Long.valueOf(time));
            return;
        }
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        b(actionName, time);
        Iterator<T> it = f274711e.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((KuiklyLaunchAction) obj).getKey(), actionName)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        KuiklyLaunchAction kuiklyLaunchAction = (KuiklyLaunchAction) obj;
        if (kuiklyLaunchAction != null) {
            i3 = kuiklyLaunchAction.getMilestone();
        }
        c(i3);
    }

    public final void addKuiklyData(@NotNull JSONObject r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) r65);
            return;
        }
        Intrinsics.checkNotNullParameter(r65, "reportParams");
        if (this.isReported) {
            return;
        }
        Iterator keys = r65.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "reportParams.keys()");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = r65.optString(key);
            LinkedHashMap<String, String> linkedHashMap = this.kuiklyReportData;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            linkedHashMap.put(key, value);
        }
    }

    public final void addNativeAction(@NotNull KuiklyLaunchAction action, long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, action, Long.valueOf(time));
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        b(action.getKey(), time);
        c(action.getMilestone());
    }

    public final void addScene(int scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, scene);
        } else {
            this.launchScene = scene | this.launchScene;
        }
    }

    public final void doReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.isReported = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.report.dev.a
                @Override // java.lang.Runnable
                public final void run() {
                    KuiklyLaunchData.e(KuiklyLaunchData.this);
                }
            }, 128, null, true);
        }
    }

    @Nullable
    public final String getLaunchOrigin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.launchOrigin;
    }

    public final long getReportTimeOut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.reportTimeOut;
    }

    public final boolean isModuleVersionExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo("qwallet_qqshop").getResVersion() > 0) {
            return true;
        }
        return false;
    }

    public final void setLaunchOrigin(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.launchOrigin = str;
        }
    }
}
