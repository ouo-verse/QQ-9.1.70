package com.tencent.zplan.record.model;

import android.webkit.URLUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import by4.ZPlanRecordResourceStatistic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.utils.LogUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

@Entity(primaryKeys = {"resourceKey"}, tableName = "RecordResource")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001\u001aBQ\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b7\u00108J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\bJU\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\t\u0010\u0015\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b%\u0010$\"\u0004\b&\u0010'R$\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010'R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u0010\u0012\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b5\u00102R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b6\u0010$\u00a8\u00069"}, d2 = {"Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "", "", "o", "p", "Lcom/tencent/zplan/record/model/ExpireConfig;", DownloadInfo.spKey_Config, "c", "Lyx4/c$e;", "d", "", "key", "localPath", "remoteUrl", "", "timestamp", "", "source", "actionId", "dressKey", "e", "toString", "hashCode", "other", "equals", "Lby4/a;", "a", "Lby4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lby4/a;", ReportConstant.COSTREPORT_PREFIX, "(Lby4/a;)V", "statistic", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "k", "r", "J", DomainData.DOMAIN_NAME, "()J", "setTimestamp", "(J)V", "f", "I", "l", "()I", "setSource", "(I)V", "g", h.F, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class ZPlanRecordResource {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy f386068i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy f386069j;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Ignore
    @Nullable
    private ZPlanRecordResourceStatistic statistic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @ColumnInfo(name = "resourceKey")
    @NotNull
    private final String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String localPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String remoteUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long timestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int source;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String dressKey;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0004R\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/record/model/ZPlanRecordResource$a;", "", "", "a", "()J", "currentServerTime", "forceExpireTimestamp$delegate", "Lkotlin/Lazy;", "c", "forceExpireTimestamp", "Lyx4/c$e;", "forceDeleteConfig$delegate", "b", "()Lyx4/c$e;", "forceDeleteConfig", "", "SOURCE_CLOUD", "I", "SOURCE_LOCAL", "SOURCE_UNKNOWN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.model.ZPlanRecordResource$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public final long a() {
            Object a16 = mx4.a.f417748a.a(lx4.a.class);
            Intrinsics.checkNotNull(a16);
            return ((lx4.a) a16).getServerTime();
        }

        @NotNull
        public final c.ForceDeleteResourceConfig b() {
            return (c.ForceDeleteResourceConfig) ZPlanRecordResource.f386069j.getValue();
        }

        public final long c() {
            return ((Number) ZPlanRecordResource.f386068i.getValue()).longValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.zplan.record.model.ZPlanRecordResource$Companion$forceExpireTimestamp$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                long t16 = ((yx4.c) a16).t();
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[ZPlanRRC][ZPlanRecordResource]", 1, "forceExpireTimestamp:" + t16, null, 8, null);
                }
                return t16;
            }
        });
        f386068i = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c.ForceDeleteResourceConfig>() { // from class: com.tencent.zplan.record.model.ZPlanRecordResource$Companion$forceDeleteConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c.ForceDeleteResourceConfig invoke() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                c.ForceDeleteResourceConfig d16 = ((yx4.c) a16).d();
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[ZPlanRRC][ZPlanRecordResource]", 1, "forceDeleteResourceConfig:" + d16, null, 8, null);
                }
                return d16;
            }
        });
        f386069j = lazy2;
    }

    public ZPlanRecordResource(@NotNull String key, @Nullable String str, @Nullable String str2, long j3, int i3, int i16, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.localPath = str;
        this.remoteUrl = str2;
        this.timestamp = j3;
        this.source = i3;
        this.actionId = i16;
        this.dressKey = str3;
    }

    public static /* synthetic */ ZPlanRecordResource f(ZPlanRecordResource zPlanRecordResource, String str, String str2, String str3, long j3, int i3, int i16, String str4, int i17, Object obj) {
        String str5;
        String str6;
        String str7;
        long j16;
        int i18;
        int i19;
        String str8;
        if ((i17 & 1) != 0) {
            str5 = zPlanRecordResource.key;
        } else {
            str5 = str;
        }
        if ((i17 & 2) != 0) {
            str6 = zPlanRecordResource.localPath;
        } else {
            str6 = str2;
        }
        if ((i17 & 4) != 0) {
            str7 = zPlanRecordResource.remoteUrl;
        } else {
            str7 = str3;
        }
        if ((i17 & 8) != 0) {
            j16 = zPlanRecordResource.timestamp;
        } else {
            j16 = j3;
        }
        if ((i17 & 16) != 0) {
            i18 = zPlanRecordResource.source;
        } else {
            i18 = i3;
        }
        if ((i17 & 32) != 0) {
            i19 = zPlanRecordResource.actionId;
        } else {
            i19 = i16;
        }
        if ((i17 & 64) != 0) {
            str8 = zPlanRecordResource.dressKey;
        } else {
            str8 = str4;
        }
        return zPlanRecordResource.e(str5, str6, str7, j16, i18, i19, str8);
    }

    public final boolean c(@Nullable ExpireConfig config) {
        long delayForLocal;
        if (config == null || !config.getCheck()) {
            return false;
        }
        if (this.source == 2) {
            delayForLocal = config.getDelayForCloud();
        } else {
            delayForLocal = config.getDelayForLocal();
        }
        if (delayForLocal <= 0) {
            return false;
        }
        long j3 = this.timestamp;
        if (j3 <= 0) {
            return false;
        }
        Companion companion = INSTANCE;
        if (companion.c() > 0 && j3 < companion.c()) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC][ZPlanRecordResource]", 1, "checkExpire, force expired, resourceTimestamp:" + j3 + ", forceExpireTimestamp:" + companion.c(), null, 8, null);
            }
            return true;
        }
        long a17 = companion.a();
        lx4.d a18 = LogUtil.f385285b.a();
        if (a18 != null) {
            d.a.a(a18, "[ZPlanRRC][ZPlanRecordResource]", 1, "checkExpire, resourceTimestamp:" + j3 + ", delay:" + delayForLocal + ", currentServerTime:" + a17, null, 8, null);
        }
        if (a17 <= j3 + delayForLocal) {
            return false;
        }
        return true;
    }

    public final boolean d(@Nullable c.ForceDeleteResourceConfig config) {
        boolean z16;
        if (config == null || config.getConfigTimestamp() <= 0 || config.b().isEmpty() || this.actionId <= 0) {
            return false;
        }
        String str = this.dressKey;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        long j3 = this.timestamp;
        if (j3 <= 0 || j3 > config.getConfigTimestamp()) {
            return false;
        }
        if (!config.b().contains(this.actionId + util.base64_pad_url + this.dressKey)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ZPlanRecordResource e(@NotNull String key, @Nullable String localPath, @Nullable String remoteUrl, long timestamp, int source, int actionId, @Nullable String dressKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new ZPlanRecordResource(key, localPath, remoteUrl, timestamp, source, actionId, dressKey);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanRecordResource) {
                ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) other;
                if (!Intrinsics.areEqual(this.key, zPlanRecordResource.key) || !Intrinsics.areEqual(this.localPath, zPlanRecordResource.localPath) || !Intrinsics.areEqual(this.remoteUrl, zPlanRecordResource.remoteUrl) || this.timestamp != zPlanRecordResource.timestamp || this.source != zPlanRecordResource.source || this.actionId != zPlanRecordResource.actionId || !Intrinsics.areEqual(this.dressKey, zPlanRecordResource.dressKey)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: g, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.key;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.localPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.remoteUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int a16 = (((((((i26 + i17) * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31) + this.source) * 31) + this.actionId) * 31;
        String str4 = this.dressKey;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return a16 + i18;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getRemoteUrl() {
        return this.remoteUrl;
    }

    /* renamed from: l, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final ZPlanRecordResourceStatistic getStatistic() {
        return this.statistic;
    }

    /* renamed from: n, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean o() {
        return com.tencent.zplan.common.utils.c.f385288a.h(this.localPath);
    }

    public final boolean p() {
        return URLUtil.isValidUrl(this.remoteUrl);
    }

    public final void q(@Nullable String str) {
        this.localPath = str;
    }

    public final void r(@Nullable String str) {
        this.remoteUrl = str;
    }

    public final void s(@Nullable ZPlanRecordResourceStatistic zPlanRecordResourceStatistic) {
        this.statistic = zPlanRecordResourceStatistic;
    }

    @NotNull
    public String toString() {
        return "ZPlanRecordResource(key=" + this.key + ", localPath=" + this.localPath + ", remoteUrl=" + this.remoteUrl + ", timestamp=" + this.timestamp + ", source=" + this.source + ", actionId=" + this.actionId + ", dressKey=" + this.dressKey + ")";
    }

    public /* synthetic */ ZPlanRecordResource(String str, String str2, String str3, long j3, int i3, int i16, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? null : str2, (i17 & 4) != 0 ? null : str3, (i17 & 8) != 0 ? 0L : j3, (i17 & 16) != 0 ? 0 : i3, (i17 & 32) == 0 ? i16 : 0, (i17 & 64) == 0 ? str4 : null);
    }
}
