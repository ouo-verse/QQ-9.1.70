package by4;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.provider.CloudCacheProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001\rB\u00c3\u0001\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\n\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00101\u001a\u00020\n\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010@\u001a\u00020;\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010J\u001a\u00020;\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\bU\u0010VJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\"R\u0017\u0010'\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010(\u001a\u0004\b,\u0010*\"\u0004\b-\u0010.R\"\u00101\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010(\u001a\u0004\b\u001a\u0010*\"\u0004\b0\u0010.R$\u00106\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b\r\u00103\"\u0004\b4\u00105R$\u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u00109R\"\u0010@\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010<\u001a\u0004\b\u0012\u0010=\"\u0004\b>\u0010?R$\u0010C\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00102\u001a\u0004\bA\u00103\"\u0004\bB\u00105R$\u0010F\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010$\u001a\u0004\bD\u0010&\"\u0004\bE\u00109R\"\u0010J\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010<\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R$\u0010N\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010$\u001a\u0004\bL\u0010&\"\u0004\bM\u00109R$\u0010P\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010$\u001a\u0004\bO\u0010&\"\u0004\bG\u00109R$\u0010T\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010Q\u001a\u0004\b \u0010R\"\u0004\bK\u0010S\u00a8\u0006W"}, d2 = {"Lby4/a;", "", "", "k", "()V", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/zplan/record/model/Source;", "a", "Lcom/tencent/zplan/record/model/Source;", h.F, "()Lcom/tencent/zplan/record/model/Source;", "source", "b", "I", "getScene", "()I", "scene", "c", "g", "resId", "d", "j", "width", "e", "height", "Lcom/tencent/zplan/meme/action/MODE;", "f", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "userId", "Z", "getPreRequest", "()Z", "preRequest", "getSuccess", "u", "(Z)V", "success", "o", "hitCache", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "cacheErrorCode", "getCacheErrorMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "cacheErrorMessage", "", "J", "()J", DomainData.DOMAIN_NAME, "(J)V", "cacheTimeCost", "getRecordErrorCode", "r", "recordErrorCode", "getRecordErrorMessage", "setRecordErrorMessage", "recordErrorMessage", "p", "getRecordTimeCost", "t", "recordTimeCost", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getRecordKey", ReportConstant.COSTREPORT_PREFIX, "recordKey", "getPath", "path", "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "raw", "<init>", "(Lcom/tencent/zplan/record/model/Source;IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: by4.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class ZPlanRecordResourceStatistic {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Source source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MODE mode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean preRequest;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean success;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hitCache;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Integer cacheErrorCode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String cacheErrorMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long cacheTimeCost;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Integer recordErrorCode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String recordErrorMessage;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private long recordTimeCost;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String recordKey;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String path;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object raw;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lby4/a$a;", "", "", "key", "Lkotlin/Pair;", "c", "Lcom/tencent/zplan/record/model/Source;", "source", "", "resId", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "Lby4/a;", "b", "REPORT_EVENT_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: by4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<String, String> c(Object obj, String str) {
            String str2;
            if (obj instanceof Boolean) {
                return new Pair<>(str, String.valueOf(d.INSTANCE.b(((Boolean) obj).booleanValue())));
            }
            if (obj == null || (str2 = obj.toString()) == null) {
                str2 = "";
            }
            return new Pair<>(str, str2);
        }

        @NotNull
        public final ZPlanRecordResourceStatistic b(@NotNull Source source, int resId, @NotNull AbsRecordRequestParams params) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(params, "params");
            return new ZPlanRecordResourceStatistic(source, params.getScene(), resId, params.getWidth(), params.getHeight(), params.getMode(), params.getSender(), params.getReportConfig().getPreRequest(), false, false, null, null, 0L, null, null, 0L, null, null, null, 524032, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ZPlanRecordResourceStatistic(@NotNull Source source, int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String userId, boolean z16, boolean z17, boolean z18, @Nullable Integer num, @Nullable String str, long j3, @Nullable Integer num2, @Nullable String str2, long j16, @Nullable String str3, @Nullable String str4, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.source = source;
        this.scene = i3;
        this.resId = i16;
        this.width = i17;
        this.height = i18;
        this.mode = mode;
        this.userId = userId;
        this.preRequest = z16;
        this.success = z17;
        this.hitCache = z18;
        this.cacheErrorCode = num;
        this.cacheErrorMessage = str;
        this.cacheTimeCost = j3;
        this.recordErrorCode = num2;
        this.recordErrorMessage = str2;
        this.recordTimeCost = j16;
        this.recordKey = str3;
        this.path = str4;
        this.raw = obj;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getCacheErrorCode() {
        return this.cacheErrorCode;
    }

    /* renamed from: b, reason: from getter */
    public final long getCacheTimeCost() {
        return this.cacheTimeCost;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHitCache() {
        return this.hitCache;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanRecordResourceStatistic) {
                ZPlanRecordResourceStatistic zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) other;
                if (!Intrinsics.areEqual(this.source, zPlanRecordResourceStatistic.source) || this.scene != zPlanRecordResourceStatistic.scene || this.resId != zPlanRecordResourceStatistic.resId || this.width != zPlanRecordResourceStatistic.width || this.height != zPlanRecordResourceStatistic.height || !Intrinsics.areEqual(this.mode, zPlanRecordResourceStatistic.mode) || !Intrinsics.areEqual(this.userId, zPlanRecordResourceStatistic.userId) || this.preRequest != zPlanRecordResourceStatistic.preRequest || this.success != zPlanRecordResourceStatistic.success || this.hitCache != zPlanRecordResourceStatistic.hitCache || !Intrinsics.areEqual(this.cacheErrorCode, zPlanRecordResourceStatistic.cacheErrorCode) || !Intrinsics.areEqual(this.cacheErrorMessage, zPlanRecordResourceStatistic.cacheErrorMessage) || this.cacheTimeCost != zPlanRecordResourceStatistic.cacheTimeCost || !Intrinsics.areEqual(this.recordErrorCode, zPlanRecordResourceStatistic.recordErrorCode) || !Intrinsics.areEqual(this.recordErrorMessage, zPlanRecordResourceStatistic.recordErrorMessage) || this.recordTimeCost != zPlanRecordResourceStatistic.recordTimeCost || !Intrinsics.areEqual(this.recordKey, zPlanRecordResourceStatistic.recordKey) || !Intrinsics.areEqual(this.path, zPlanRecordResourceStatistic.path) || !Intrinsics.areEqual(this.raw, zPlanRecordResourceStatistic.raw)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Object getRaw() {
        return this.raw;
    }

    /* renamed from: g, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        Source source = this.source;
        int i36 = 0;
        if (source != null) {
            i3 = source.hashCode();
        } else {
            i3 = 0;
        }
        int i37 = ((((((((i3 * 31) + this.scene) * 31) + this.resId) * 31) + this.width) * 31) + this.height) * 31;
        MODE mode = this.mode;
        if (mode != null) {
            i16 = mode.hashCode();
        } else {
            i16 = 0;
        }
        int i38 = (i37 + i16) * 31;
        String str = this.userId;
        if (str != null) {
            i17 = str.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        boolean z16 = this.preRequest;
        int i46 = 1;
        int i47 = z16;
        if (z16 != 0) {
            i47 = 1;
        }
        int i48 = (i39 + i47) * 31;
        boolean z17 = this.success;
        int i49 = z17;
        if (z17 != 0) {
            i49 = 1;
        }
        int i56 = (i48 + i49) * 31;
        boolean z18 = this.hitCache;
        if (!z18) {
            i46 = z18 ? 1 : 0;
        }
        int i57 = (i56 + i46) * 31;
        Integer num = this.cacheErrorCode;
        if (num != null) {
            i18 = num.hashCode();
        } else {
            i18 = 0;
        }
        int i58 = (i57 + i18) * 31;
        String str2 = this.cacheErrorMessage;
        if (str2 != null) {
            i19 = str2.hashCode();
        } else {
            i19 = 0;
        }
        int a16 = (((i58 + i19) * 31) + androidx.fragment.app.a.a(this.cacheTimeCost)) * 31;
        Integer num2 = this.recordErrorCode;
        if (num2 != null) {
            i26 = num2.hashCode();
        } else {
            i26 = 0;
        }
        int i59 = (a16 + i26) * 31;
        String str3 = this.recordErrorMessage;
        if (str3 != null) {
            i27 = str3.hashCode();
        } else {
            i27 = 0;
        }
        int a17 = (((i59 + i27) * 31) + androidx.fragment.app.a.a(this.recordTimeCost)) * 31;
        String str4 = this.recordKey;
        if (str4 != null) {
            i28 = str4.hashCode();
        } else {
            i28 = 0;
        }
        int i65 = (a17 + i28) * 31;
        String str5 = this.path;
        if (str5 != null) {
            i29 = str5.hashCode();
        } else {
            i29 = 0;
        }
        int i66 = (i65 + i29) * 31;
        Object obj = this.raw;
        if (obj != null) {
            i36 = obj.hashCode();
        }
        return i66 + i36;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: j, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void k() {
        Map mutableMapOf;
        Companion companion = INSTANCE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(companion.c(this.source, "sourceType"), companion.c(Integer.valueOf(this.scene), "scene"), companion.c(Integer.valueOf(this.resId), "resId"), companion.c(Integer.valueOf(this.width), "width"), companion.c(Integer.valueOf(this.height), "height"), companion.c(this.mode, "mode"), companion.c(this.userId, "userId"), companion.c(Boolean.valueOf(this.success), "success"), companion.c(Boolean.valueOf(this.hitCache), "hitCache"), companion.c(this.recordKey, "recordKey"), companion.c(this.path, "path"), companion.c(Boolean.valueOf(CloudCacheProvider.INSTANCE.c().getEnableSuperQQShowBackend()), "isSuperQQShowBackend"), companion.c(Boolean.valueOf(this.preRequest), "preRequest"));
        Integer num = this.cacheErrorCode;
        String str = "";
        if (num != null) {
            mutableMapOf.put("cacheErrorCode", String.valueOf(num.intValue()));
            String str2 = this.cacheErrorMessage;
            if (str2 == null) {
                str2 = "";
            }
            mutableMapOf.put("cacheErrorMessage", str2);
            mutableMapOf.put("cacheTimeCost", String.valueOf(this.cacheTimeCost));
        }
        Integer num2 = this.recordErrorCode;
        if (num2 != null) {
            mutableMapOf.put("recordErrorCode", String.valueOf(num2.intValue()));
            String str3 = this.recordErrorMessage;
            if (str3 != null) {
                str = str3;
            }
            mutableMapOf.put("recordErrorMessage", str);
            mutableMapOf.put("recordTimeCost", String.valueOf(this.recordTimeCost));
        }
        b bVar = (b) mx4.a.f417748a.a(b.class);
        if (bVar != null) {
            b.C10752b.a(bVar, null, "record_resource_center", mutableMapOf, 1, null);
        }
    }

    public final void l(@Nullable Integer num) {
        this.cacheErrorCode = num;
    }

    public final void m(@Nullable String str) {
        this.cacheErrorMessage = str;
    }

    public final void n(long j3) {
        this.cacheTimeCost = j3;
    }

    public final void o(boolean z16) {
        this.hitCache = z16;
    }

    public final void p(@Nullable String str) {
        this.path = str;
    }

    public final void q(@Nullable Object obj) {
        this.raw = obj;
    }

    public final void r(@Nullable Integer num) {
        this.recordErrorCode = num;
    }

    public final void s(@Nullable String str) {
        this.recordKey = str;
    }

    public final void t(long j3) {
        this.recordTimeCost = j3;
    }

    @NotNull
    public String toString() {
        return "ZPlanRecordResourceStatistic(source=" + this.source + ", scene=" + this.scene + ", resId=" + this.resId + ", width=" + this.width + ", height=" + this.height + ", mode=" + this.mode + ", userId=" + this.userId + ", preRequest=" + this.preRequest + ", success=" + this.success + ", hitCache=" + this.hitCache + ", cacheErrorCode=" + this.cacheErrorCode + ", cacheErrorMessage=" + this.cacheErrorMessage + ", cacheTimeCost=" + this.cacheTimeCost + ", recordErrorCode=" + this.recordErrorCode + ", recordErrorMessage=" + this.recordErrorMessage + ", recordTimeCost=" + this.recordTimeCost + ", recordKey=" + this.recordKey + ", path=" + this.path + ", raw=" + this.raw + ")";
    }

    public final void u(boolean z16) {
        this.success = z16;
    }

    public /* synthetic */ ZPlanRecordResourceStatistic(Source source, int i3, int i16, int i17, int i18, MODE mode, String str, boolean z16, boolean z17, boolean z18, Integer num, String str2, long j3, Integer num2, String str3, long j16, String str4, String str5, Object obj, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(source, i3, i16, i17, i18, mode, str, z16, (i19 & 256) != 0 ? false : z17, (i19 & 512) != 0 ? false : z18, (i19 & 1024) != 0 ? null : num, (i19 & 2048) != 0 ? null : str2, (i19 & 4096) != 0 ? 0L : j3, (i19 & 8192) != 0 ? null : num2, (i19 & 16384) != 0 ? null : str3, (32768 & i19) != 0 ? 0L : j16, (65536 & i19) != 0 ? null : str4, (131072 & i19) != 0 ? null : str5, (i19 & 262144) != 0 ? null : obj);
    }
}
