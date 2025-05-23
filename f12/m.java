package f12;

import android.net.TrafficStats;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import f12.f;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0018R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010)\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001fR\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001dR\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001d\u00a8\u00068"}, d2 = {"Lf12/m;", "Lf12/n;", "", "l", "f", "k", "", "g", "", "scene", tl.h.F, "j", "", "trafficInByte", "e", "Lf12/f$a;", ISchemeApi.KEY_SCENE_DATA, "a", "destroy", "", "byteSize", "d", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryTask;", "task", "", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryAttributes;", "params", "c", "b", "Z", "isInGuild", "J", "msfTraffic", "picTraffic", "oldTotalTraffic", "pushTraffic", "roamTraffic", "roamCount", "i", "offlineTraffic", "offlineCount", "videoTraffic", "fileTraffic", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTimeMills", DomainData.DOMAIN_NAME, "Ljava/lang/String;", "curScene", "o", "newScene", "p", "curIsBackground", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "newIsBackground", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m implements n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f397667a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInGuild;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long msfTraffic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long picTraffic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long oldTotalTraffic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long pushTraffic;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long roamTraffic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long roamCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long offlineTraffic;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static long offlineCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static long videoTraffic;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static long fileTraffic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long startTimeMills;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String curScene;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String newScene;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static boolean curIsBackground;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static boolean newIsBackground;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f397684a;

        static {
            int[] iArr = new int[GuildTelemetryTask.values().length];
            try {
                iArr[GuildTelemetryTask.DOWNLOAD_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildTelemetryTask.DOWNLOAD_PIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildTelemetryTask.DOWNLOAD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f397684a = iArr;
        }
    }

    m() {
    }

    private final void f() {
        msfTraffic = 0L;
        picTraffic = 0L;
        pushTraffic = 0L;
        roamTraffic = 0L;
        roamCount = 0L;
        videoTraffic = 0L;
        fileTraffic = 0L;
    }

    private final boolean g() {
        if (!isInGuild) {
            return false;
        }
        return true;
    }

    private final void h(final String scene) {
        ThreadManagerV2.excute(new Runnable() { // from class: f12.l
            @Override // java.lang.Runnable
            public final void run() {
                m.i(scene);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String scene) {
        Intrinsics.checkNotNullParameter(scene, "$scene");
        m mVar = f397667a;
        mVar.j(scene);
        mVar.l();
    }

    private final void j(String scene) {
        long totalRxBytes = (TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes()) - oldTotalTraffic;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = startTimeMills;
        long j16 = currentTimeMillis - j3;
        if (j3 > 0 && j16 > 15000 && oldTotalTraffic > 0) {
            double d16 = totalRxBytes;
            long j17 = msfTraffic;
            long j18 = picTraffic;
            double d17 = pushTraffic / 1024.0d;
            long j19 = roamCount;
            long j26 = roamTraffic;
            QLog.d("GuildTrafficCollector", 2, "diffTotalTraffic: " + (d16 / 1024.0d) + " KB, MSFTraffic:" + (j17 / 1024.0d) + " KB, imageTraffic:" + (j18 / 1024.0d) + " KB, pushTraffic: " + d17 + " KB, roamCount: " + j19 + ", roamTraffic: " + (j26 / 1024.0d) + " KB, videoTraffic: " + (videoTraffic / 1024.0d) + " KB, ratio:" + (((((((j17 + j18) + r2) + j26) + r0) + fileTraffic) * 1.0d) / d16) + ", scene:" + curScene + ", timeDuration:" + j16);
            EnumMap enumMap = new EnumMap(GuildTelemetryAttributes.class);
            float f16 = (float) j16;
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_MSF, (GuildTelemetryAttributes) String.valueOf(((float) msfTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_IMG, (GuildTelemetryAttributes) String.valueOf(((float) picTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_VIDEO, (GuildTelemetryAttributes) String.valueOf(((float) videoTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_FILE, (GuildTelemetryAttributes) String.valueOf(((float) fileTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_PUSH, (GuildTelemetryAttributes) String.valueOf(((float) pushTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_ROAM_COUNT, (GuildTelemetryAttributes) String.valueOf(((float) roamCount) / (f16 / 1000.0f)));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_ROAM, (GuildTelemetryAttributes) String.valueOf(((float) roamTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_OFFLINE_COUNT, (GuildTelemetryAttributes) String.valueOf(((float) offlineCount) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_OFFLINE, (GuildTelemetryAttributes) String.valueOf(((float) offlineTraffic) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.TRAFFIC_TOTAL, (GuildTelemetryAttributes) String.valueOf(((float) totalRxBytes) / f16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.GUILD_SCENE, (GuildTelemetryAttributes) scene);
            enumMap.put((EnumMap) GuildTelemetryAttributes.IS_BACKGROUND, (GuildTelemetryAttributes) f.f397616a.a(curIsBackground));
            q.o(GuildTelemetryTask.PERF_MONITOR_TRAFFIC, enumMap, true);
        }
    }

    private final void k() {
        curScene = newScene;
        curIsBackground = newIsBackground;
    }

    private final void l() {
        k();
        oldTotalTraffic = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        startTimeMills = System.currentTimeMillis();
        f();
    }

    @Override // f12.n
    public void a(@NotNull f.a sceneData) {
        String str;
        Intrinsics.checkNotNullParameter(sceneData, "sceneData");
        isInGuild = sceneData.getInGuildTab();
        newScene = sceneData.getScene();
        newIsBackground = sceneData.getBackGround();
        if (curScene == null) {
            l();
        } else if ((!Intrinsics.areEqual(sceneData.getScene(), curScene) || curIsBackground != sceneData.getBackGround()) && (str = curScene) != null) {
            f397667a.h(str);
        }
    }

    public final void c(@NotNull GuildTelemetryTask task, @NotNull Map<GuildTelemetryAttributes, String> params) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.get(GuildTelemetryAttributes.SIZE);
        if (str == null) {
            return;
        }
        long parseLong = Long.parseLong(str);
        int i3 = a.f397684a[task.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.i("GuildTrafficCollector", 1, "addDownloadTraffic:GuildTelemetryAttributes not found.");
                    return;
                } else {
                    fileTraffic += parseLong;
                    return;
                }
            }
            picTraffic += parseLong;
            return;
        }
        videoTraffic += parseLong;
    }

    public final void d(long byteSize) {
        if (!g()) {
            return;
        }
        msfTraffic += byteSize;
    }

    @Override // f12.n
    public void destroy() {
        isInGuild = false;
        curScene = null;
    }

    public final void e(int trafficInByte) {
        pushTraffic += trafficInByte;
    }
}
