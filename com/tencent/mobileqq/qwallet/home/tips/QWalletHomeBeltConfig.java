package com.tencent.mobileqq.qwallet.home.tips;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/QWalletHomeBeltConfig;", "", "", "toString", "", "hashCode", "other", "", "equals", "isNewStyle", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "", "startStayMS", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "stopStayMs", "d", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class QWalletHomeBeltConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final QWalletHomeBeltConfig f278138b = new QWalletHomeBeltConfig(1, 1000L, 1000L);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f278139c;

    @SerializedName("is_new_style")
    @Nullable
    private final Integer isNewStyle;

    @SerializedName("start_stay_ms")
    @Nullable
    private final Long startStayMS;

    @SerializedName("stop_stay_ms")
    @Nullable
    private final Long stopStayMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/QWalletHomeBeltConfig$a;", "", "Lcom/tencent/mobileqq/qwallet/home/tips/QWalletHomeBeltConfig;", "DEFAULT", "Lcom/tencent/mobileqq/qwallet/home/tips/QWalletHomeBeltConfig;", "a", "()Lcom/tencent/mobileqq/qwallet/home/tips/QWalletHomeBeltConfig;", "", "isNewStyle$delegate", "Lkotlin/Lazy;", "b", "()Z", "isNewStyle", "", "DEFAULT_IS_NEW_STYLE", "I", "", "DEFAULT_START_STAY_MS", "J", "DEFAULT_STOP_STAY_MS", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.tips.QWalletHomeBeltConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QWalletHomeBeltConfig a() {
            return QWalletHomeBeltConfig.f278138b;
        }

        public final boolean b() {
            return ((Boolean) QWalletHomeBeltConfig.f278139c.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.home.tips.QWalletHomeBeltConfig$Companion$isNewStyle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Integer isNewStyle = ((QWalletHomeBeltConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HOME_9170_BELT_CONFIG, QWalletHomeBeltConfig.INSTANCE.a())).getIsNewStyle();
                Boolean valueOf = Boolean.valueOf((isNewStyle != null ? isNewStyle.intValue() : 1) == 1);
                QLog.i("QWalletHomeBeltConfig", 1, "isNewStyle=" + valueOf.booleanValue());
                return valueOf;
            }
        });
        f278139c = lazy;
    }

    public QWalletHomeBeltConfig() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Long getStartStayMS() {
        return this.startStayMS;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Long getStopStayMs() {
        return this.stopStayMs;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Integer getIsNewStyle() {
        return this.isNewStyle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletHomeBeltConfig)) {
            return false;
        }
        QWalletHomeBeltConfig qWalletHomeBeltConfig = (QWalletHomeBeltConfig) other;
        if (Intrinsics.areEqual(this.isNewStyle, qWalletHomeBeltConfig.isNewStyle) && Intrinsics.areEqual(this.startStayMS, qWalletHomeBeltConfig.startStayMS) && Intrinsics.areEqual(this.stopStayMs, qWalletHomeBeltConfig.stopStayMs)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Integer num = this.isNewStyle;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        Long l3 = this.startStayMS;
        if (l3 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = l3.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Long l16 = this.stopStayMs;
        if (l16 != null) {
            i3 = l16.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "QWalletHomeBeltConfig(isNewStyle=" + this.isNewStyle + ", startStayMS=" + this.startStayMS + ", stopStayMs=" + this.stopStayMs + ")";
    }

    public QWalletHomeBeltConfig(@Nullable Integer num, @Nullable Long l3, @Nullable Long l16) {
        this.isNewStyle = num;
        this.startStayMS = l3;
        this.stopStayMs = l16;
    }

    public /* synthetic */ QWalletHomeBeltConfig(Integer num, Long l3, Long l16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? null : l16);
    }
}
