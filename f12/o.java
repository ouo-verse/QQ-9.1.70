package f12;

import com.tencent.mobileqq.guild.performance.report.data.GuildPerformanceInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b \u0010$\u001a\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b%\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010/\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+R3\u00107\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3008\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b-\u00106R\"\u0010;\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\"\u0010=\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0014\u001a\u0004\b4\u0010\u0016\"\u0004\b<\u0010\u0018R.\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020(008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u00105\u001a\u0004\b8\u00106\"\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lf12/o;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "", "methodName", "startTime", "r", "a", "Lf12/j;", "powerData", DomainData.DOMAIN_NAME, "", "tempDiff", "o", "", "Z", "l", "()Z", "setAutomatedTestMode", "(Z)V", "isAutomatedTestMode", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setAutoTestMethodName", "(Ljava/lang/String;)V", "autoTestMethodName", "e", "setAutoTestStartTime", "autoTestStartTime", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "f", "()Lcom/tencent/mobileqq/guild/performance/report/data/a;", "callback", "", "I", "getRandomGray", "()I", "randomGray", "g", "k", "randomPublic", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/performance/report/data/b;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/Map;", "()Ljava/util/Map;", "dropFrameReportMap", "i", "j", "setManageSwitch", "manageSwitch", "p", "dropFrameReportTimesExceed", "setDropFrameTimeMap", "(Ljava/util/Map;)V", "dropFrameTimeMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isAutomatedTestMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean manageSwitch;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean dropFrameReportTimesExceed;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f397685a = new o();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String autoTestMethodName = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String autoTestStartTime = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.performance.report.data.a callback = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int randomGray = new Random(System.currentTimeMillis()).nextInt(100);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int randomPublic = new Random(System.currentTimeMillis()).nextInt(1000);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, ArrayList<GuildPerformanceInfo>> dropFrameReportMap = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Integer> dropFrameTimeMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"f12/o$a", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "Lcom/tencent/mobileqq/guild/performance/report/data/b;", "info", "", "isReportInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.performance.report.data.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.performance.report.data.a
        public void a(@NotNull GuildPerformanceInfo info, boolean isReportInfo) {
            Intrinsics.checkNotNullParameter(info, "info");
            q.j(info, isReportInfo);
        }
    }

    o() {
    }

    public final void a() {
        autoTestMethodName = "";
        autoTestStartTime = "";
        isAutomatedTestMode = false;
    }

    public final void b() {
        manageSwitch = false;
    }

    public final void c() {
        q.i();
        f.f397616a.b();
    }

    @NotNull
    public final String d() {
        return autoTestMethodName;
    }

    @NotNull
    public final String e() {
        return autoTestStartTime;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.performance.report.data.a f() {
        return callback;
    }

    @NotNull
    public final Map<String, ArrayList<GuildPerformanceInfo>> g() {
        return dropFrameReportMap;
    }

    public final boolean h() {
        return dropFrameReportTimesExceed;
    }

    @NotNull
    public final Map<String, Integer> i() {
        return dropFrameTimeMap;
    }

    public final boolean j() {
        return manageSwitch;
    }

    public final int k() {
        return randomPublic;
    }

    public final boolean l() {
        return isAutomatedTestMode;
    }

    public final void m() {
        manageSwitch = true;
    }

    public final void n(@NotNull GuildPowerConsumptionData powerData) {
        Intrinsics.checkNotNullParameter(powerData, "powerData");
        q.k(powerData);
    }

    public final void o(double tempDiff) {
        q.l(tempDiff);
    }

    public final void p(boolean z16) {
        dropFrameReportTimesExceed = z16;
    }

    public final void q() {
        q.b();
    }

    public final void r(@NotNull String methodName, @NotNull String startTime) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        autoTestMethodName = methodName;
        autoTestStartTime = startTime;
        isAutomatedTestMode = true;
    }

    public final void s() {
        f.f397616a.j();
    }
}
