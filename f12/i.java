package f12;

import android.net.TrafficStats;
import android.os.Process;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import f12.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\u0010B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001f\u00a8\u0006$"}, d2 = {"Lf12/i;", "Lf12/n;", "", WidgetCacheConstellationData.INTERVAL, "", tl.h.F, "lastEnterSceneTime", "Lf12/f$a;", ISchemeApi.KEY_SCENE_DATA, "j", "g", "a", "destroy", "e", "d", "", "b", "I", "UID", "Lf12/i$a;", "c", "Lf12/i$a;", "reportData", "Lf12/i$b;", "Lf12/i$b;", "sceneRecord", "", "Z", "canReport", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "runnable", "updateRunnable", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i implements n {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean canReport;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f397630a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int UID = Process.myUid();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static a reportData = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static b sceneRecord = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable runnable = new Runnable() { // from class: f12.g
        @Override // java.lang.Runnable
        public final void run() {
            i.f();
        }
    };

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable updateRunnable = new Runnable() { // from class: f12.h
        @Override // java.lang.Runnable
        public final void run() {
            i.i();
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010#\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b\"\u0010\u001dR\"\u0010%\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b$\u0010\u001d\u00a8\u0006("}, d2 = {"Lf12/i$a;", "", "", "a", "Z", "b", "()Z", "j", "(Z)V", "inGuildTab", "i", "backGround", "", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "scene", "d", tl.h.F, "p", "sideScene", "", "e", "J", "()J", "l", "(J)V", "mLastCpuJiffies", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mLastRxBytes", DomainData.DOMAIN_NAME, "mLastTxBytes", "k", WidgetCacheConstellationData.INTERVAL, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean inGuildTab;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean backGround;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String scene = "default";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String sideScene = "default";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long mLastCpuJiffies;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long mLastRxBytes;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long mLastTxBytes;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long interval;

        /* renamed from: a, reason: from getter */
        public final boolean getBackGround() {
            return this.backGround;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getInGuildTab() {
            return this.inGuildTab;
        }

        /* renamed from: c, reason: from getter */
        public final long getInterval() {
            return this.interval;
        }

        /* renamed from: d, reason: from getter */
        public final long getMLastCpuJiffies() {
            return this.mLastCpuJiffies;
        }

        /* renamed from: e, reason: from getter */
        public final long getMLastRxBytes() {
            return this.mLastRxBytes;
        }

        /* renamed from: f, reason: from getter */
        public final long getMLastTxBytes() {
            return this.mLastTxBytes;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getSideScene() {
            return this.sideScene;
        }

        public final void i(boolean z16) {
            this.backGround = z16;
        }

        public final void j(boolean z16) {
            this.inGuildTab = z16;
        }

        public final void k(long j3) {
            this.interval = j3;
        }

        public final void l(long j3) {
            this.mLastCpuJiffies = j3;
        }

        public final void m(long j3) {
            this.mLastRxBytes = j3;
        }

        public final void n(long j3) {
            this.mLastTxBytes = j3;
        }

        public final void o(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.scene = str;
        }

        public final void p(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sideScene = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\r\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lf12/i$b;", "", "", "a", "Z", "b", "()Z", "g", "(Z)V", "inGuildTab", "f", "backGround", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "scene", "e", "j", "sideScene", "", "J", "()J", tl.h.F, "(J)V", "lastEnterSceneTime", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean inGuildTab;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean backGround;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String scene = "default";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String sideScene = "default";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastEnterSceneTime;

        /* renamed from: a, reason: from getter */
        public final boolean getBackGround() {
            return this.backGround;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getInGuildTab() {
            return this.inGuildTab;
        }

        /* renamed from: c, reason: from getter */
        public final long getLastEnterSceneTime() {
            return this.lastEnterSceneTime;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getSideScene() {
            return this.sideScene;
        }

        public final void f(boolean z16) {
            this.backGround = z16;
        }

        public final void g(boolean z16) {
            this.inGuildTab = z16;
        }

        public final void h(long j3) {
            this.lastEnterSceneTime = j3;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.scene = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sideScene = str;
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f397630a.e();
    }

    private final void g() {
        long j3;
        a aVar = reportData;
        Long a16 = com.tencent.mobileqq.guild.util.performance.d.a();
        if (a16 != null) {
            j3 = a16.longValue();
        } else {
            j3 = 0;
        }
        aVar.l(j3);
        a aVar2 = reportData;
        int i3 = UID;
        long j16 = 1024;
        aVar2.m(TrafficStats.getUidRxBytes(i3) / j16);
        reportData.n(TrafficStats.getUidTxBytes(i3) / j16);
        com.tencent.mobileqq.guild.util.performance.f.f235588a.a(1);
    }

    private final void h(long interval) {
        reportData.k(interval / 1000);
        reportData.o(sceneRecord.getScene());
        reportData.p(sceneRecord.getSideScene());
        reportData.i(sceneRecord.getBackGround());
        reportData.j(sceneRecord.getInGuildTab());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f397630a.g();
    }

    private final void j(long lastEnterSceneTime, f.a sceneData) {
        if (!Intrinsics.areEqual(sceneData.getMediaScene(), "null")) {
            sceneRecord.i(sceneData.getMediaScene());
            sceneRecord.j(sceneData.getBaseScene() + "-" + sceneData.getScene());
        } else if (!Intrinsics.areEqual(sceneData.getScene(), "null")) {
            sceneRecord.i(sceneData.getScene());
            sceneRecord.j(sceneData.getBaseScene());
        } else {
            sceneRecord.i(sceneData.getBaseScene());
            sceneRecord.j("null");
        }
        sceneRecord.f(sceneData.getBackGround());
        sceneRecord.g(sceneData.getInGuildTab());
        sceneRecord.h(lastEnterSceneTime);
    }

    @Override // f12.n
    public void a(@NotNull f.a sceneData) {
        Intrinsics.checkNotNullParameter(sceneData, "sceneData");
        if (!q.h()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long lastEnterSceneTime = currentTimeMillis - sceneRecord.getLastEnterSceneTime();
        if (canReport) {
            boolean z16 = false;
            if (15000 <= lastEnterSceneTime && lastEnterSceneTime < 43200001) {
                z16 = true;
            }
            if (z16) {
                h(lastEnterSceneTime);
                j(currentTimeMillis, sceneData);
                ThreadManagerV2.executeDelay(runnable, 16, null, true, 0L);
                return;
            }
        }
        j(currentTimeMillis, sceneData);
        d(lastEnterSceneTime);
    }

    public final void d(long interval) {
        if (interval > 5000) {
            canReport = true;
            ThreadManagerV2.executeDelay(updateRunnable, 16, null, true, 0L);
        } else {
            canReport = false;
        }
    }

    public final void e() {
        long j3;
        Long a16 = com.tencent.mobileqq.guild.util.performance.d.a();
        if (a16 != null) {
            j3 = a16.longValue();
        } else {
            j3 = 0;
        }
        int i3 = UID;
        long j16 = 1024;
        long uidRxBytes = TrafficStats.getUidRxBytes(i3) / j16;
        long uidTxBytes = TrafficStats.getUidTxBytes(i3) / j16;
        GuildPowerConsumptionData guildPowerConsumptionData = new GuildPowerConsumptionData(reportData.getScene(), (j3 - reportData.getMLastCpuJiffies()) / reportData.getInterval(), (uidRxBytes - reportData.getMLastRxBytes()) / reportData.getInterval(), (uidTxBytes - reportData.getMLastTxBytes()) / reportData.getInterval(), com.tencent.mobileqq.guild.util.performance.f.f235588a.a(1) / reportData.getInterval(), reportData.getBackGround(), reportData.getInGuildTab(), reportData.getSideScene());
        if (guildPowerConsumptionData.i()) {
            o.f397685a.n(guildPowerConsumptionData);
        }
        reportData.n(uidTxBytes);
        reportData.m(uidRxBytes);
        reportData.l(j3);
    }

    @Override // f12.n
    public void destroy() {
    }
}
