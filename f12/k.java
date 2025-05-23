package f12;

import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010\u00a8\u0006$"}, d2 = {"Lf12/k;", "", "", "j", "", "i", "f", "a", "I", "grayRate", "b", "publicRate", "c", tl.h.F, "()I", "o", "(I)V", "maxListReportTimes", "d", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maxCPUReportTimes", "", "e", "J", "()J", "l", "(J)V", "delayFirst", "k", "delay", "getMaxFps", DomainData.DOMAIN_NAME, "maxFps", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int grayRate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int publicRate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxListReportTimes = 3;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int maxCPUReportTimes = 3;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long delayFirst = 6000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long delay = 180000;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxFps = 60;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0006\u0010\u0016\u001a\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019\u00a8\u0006$"}, d2 = {"Lf12/k$a;", "", "", "manageRatePull", "managePublicRatePull", "maxListReportTimesPull", "maxCPUReportTimesPull", "", "delayFirstPull", "delayPull", "", "b", "maxFpsPull", "a", "", "c", "Lorg/json/JSONObject;", "jsonObj", "e", "Lf12/k;", "bean", "f", "d", "", "DELAY", "Ljava/lang/String;", "DELAY_FIRST", "GRAY_RATE_KEY", "GUILD_PERF_TJG_CONFIG", "MAX_CPU_REPORT_TIMES_KEY", "MAX_FPS", "MAX_LIST_REPORT_TIMES_KEY", "PUBLIC_RATE_KEY", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f12.k$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean a(int maxFpsPull) {
            boolean z16;
            if (60 <= maxFpsPull && maxFpsPull < 121) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            return false;
        }

        private final boolean b(int manageRatePull, int managePublicRatePull, int maxListReportTimesPull, int maxCPUReportTimesPull, long delayFirstPull, long delayPull) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            if (manageRatePull >= 0 && manageRatePull < 101) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (managePublicRatePull >= 0 && managePublicRatePull < 10001) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (1 <= maxListReportTimesPull && maxListReportTimesPull < 11) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (1 <= maxCPUReportTimesPull && maxCPUReportTimesPull < 11) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            if (1 <= delayPull && delayPull < 300001) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                if (1 <= delayFirstPull && delayFirstPull < 300001) {
                                    z27 = true;
                                } else {
                                    z27 = false;
                                }
                                if (z27) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        private final void c() {
            if (QLog.isColorLevel()) {
                QLog.d("GuildTjgPerfConfigBean", 2, "closeReport");
            }
            o.f397685a.b();
        }

        @NotNull
        public final k d() {
            return bs.f235483a.h("100574").getGuildTjgPerfManageConfig();
        }

        @JvmStatic
        public final boolean e(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            return jsonObj.has("guildPerfTjgConfig");
        }

        @JvmStatic
        public final void f(@NotNull k bean, @NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            JSONObject optJSONObject = jsonObj.optJSONObject("guildPerfTjgConfig");
            if (QLog.isColorLevel()) {
                QLog.i("GuildTjgPerfConfigBean", 2, "guildPerfTjgConfig:" + optJSONObject);
            }
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("sampleRate", 0);
                int optInt2 = optJSONObject.optInt("publicSampleRate", 0);
                int optInt3 = optJSONObject.optInt("maxListReportTimes");
                int optInt4 = optJSONObject.optInt("maxCPUReportTimes");
                long optLong = optJSONObject.optLong("delayFirst");
                long optLong2 = optJSONObject.optLong("delay");
                int optInt5 = optJSONObject.optInt("max_fps");
                Companion companion = k.INSTANCE;
                if (companion.a(optInt5)) {
                    bean.n(optInt5);
                }
                if (companion.b(optInt, optInt2, optInt3, optInt4, optLong, optLong2)) {
                    bean.grayRate = optInt;
                    bean.publicRate = optInt2;
                    bean.o(optInt3);
                    bean.m(optInt4);
                    bean.l(optLong);
                    bean.k(optLong2);
                    bean.j();
                    return;
                }
                companion.c();
            }
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (QLog.isColorLevel()) {
            QLog.d("GuildTjgPerfConfigBean", 2, "openReport with param grayRate:" + this.grayRate + ", publicRate:" + this.publicRate + ", maxListReportTimes:" + this.maxListReportTimes + ", maxCPUReportTimes:" + this.maxCPUReportTimes + ", delayFirst:" + this.delayFirst + ", delay:" + this.delay);
        }
        o.f397685a.m();
    }

    /* renamed from: d, reason: from getter */
    public final long getDelay() {
        return this.delay;
    }

    /* renamed from: e, reason: from getter */
    public final long getDelayFirst() {
        return this.delayFirst;
    }

    /* renamed from: f, reason: from getter */
    public final int getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: g, reason: from getter */
    public final int getMaxCPUReportTimes() {
        return this.maxCPUReportTimes;
    }

    /* renamed from: h, reason: from getter */
    public final int getMaxListReportTimes() {
        return this.maxListReportTimes;
    }

    /* renamed from: i, reason: from getter */
    public final int getPublicRate() {
        return this.publicRate;
    }

    public final void k(long j3) {
        this.delay = j3;
    }

    public final void l(long j3) {
        this.delayFirst = j3;
    }

    public final void m(int i3) {
        this.maxCPUReportTimes = i3;
    }

    public final void n(int i3) {
        this.maxFps = i3;
    }

    public final void o(int i3) {
        this.maxListReportTimes = i3;
    }
}
