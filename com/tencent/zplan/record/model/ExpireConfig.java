package com.tencent.zplan.record.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B%\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/zplan/record/model/ExpireConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "f", "()Z", "check", "", "e", "J", "g", "()J", "delayForCloud", "j", "delayForLocal", "<init>", "(ZJJ)V", BdhLogUtil.LogTag.Tag_Conn, "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class ExpireConfig implements Parcelable {

    @NotNull
    private static final a C = new a(null);
    public static final Parcelable.Creator<ExpireConfig> CREATOR;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy f386030h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy f386031i;

    /* renamed from: m, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy f386032m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean check;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long delayForCloud;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long delayForLocal;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/record/model/ExpireConfig$a;", "", "Lyx4/c;", "proxy$delegate", "Lkotlin/Lazy;", "c", "()Lyx4/c;", "proxy", "", "COMMON_CLOUD_EXPIRE_DELAY_TIME$delegate", "a", "()J", "COMMON_CLOUD_EXPIRE_DELAY_TIME", "COMMON_LOCAL_EXPIRE_DELAY_TIME$delegate", "b", "COMMON_LOCAL_EXPIRE_DELAY_TIME", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        a() {
        }

        public final long a() {
            Lazy lazy = ExpireConfig.f386031i;
            a unused = ExpireConfig.C;
            return ((Number) lazy.getValue()).longValue();
        }

        public final long b() {
            Lazy lazy = ExpireConfig.f386032m;
            a unused = ExpireConfig.C;
            return ((Number) lazy.getValue()).longValue();
        }

        @NotNull
        public final yx4.c c() {
            Lazy lazy = ExpireConfig.f386030h;
            a unused = ExpireConfig.C;
            return (yx4.c) lazy.getValue();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class b implements Parcelable.Creator<ExpireConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExpireConfig createFromParcel(@NotNull Parcel in5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(in5, "in");
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new ExpireConfig(z16, in5.readLong(), in5.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ExpireConfig[] newArray(int i3) {
            return new ExpireConfig[i3];
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yx4.c>() { // from class: com.tencent.zplan.record.model.ExpireConfig$Companion$proxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yx4.c invoke() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                return (yx4.c) a16;
            }
        });
        f386030h = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.zplan.record.model.ExpireConfig$Companion$COMMON_CLOUD_EXPIRE_DELAY_TIME$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return ExpireConfig.C.c().i();
            }
        });
        f386031i = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.zplan.record.model.ExpireConfig$Companion$COMMON_LOCAL_EXPIRE_DELAY_TIME$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return ExpireConfig.C.c().p();
            }
        });
        f386032m = lazy3;
        CREATOR = new b();
    }

    public ExpireConfig() {
        this(false, 0L, 0L, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExpireConfig) {
                ExpireConfig expireConfig = (ExpireConfig) other;
                if (this.check != expireConfig.check || this.delayForCloud != expireConfig.delayForCloud || this.delayForLocal != expireConfig.delayForLocal) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getCheck() {
        return this.check;
    }

    /* renamed from: g, reason: from getter */
    public final long getDelayForCloud() {
        return this.delayForCloud;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.check;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + androidx.fragment.app.a.a(this.delayForCloud)) * 31) + androidx.fragment.app.a.a(this.delayForLocal);
    }

    /* renamed from: j, reason: from getter */
    public final long getDelayForLocal() {
        return this.delayForLocal;
    }

    @NotNull
    public String toString() {
        return "ExpireConfig(check=" + this.check + ", delayForCloud=" + this.delayForCloud + ", delayForLocal=" + this.delayForLocal + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.check ? 1 : 0);
        parcel.writeLong(this.delayForCloud);
        parcel.writeLong(this.delayForLocal);
    }

    public ExpireConfig(boolean z16, long j3, long j16) {
        this.check = z16;
        this.delayForCloud = j3;
        this.delayForLocal = j16;
    }

    public /* synthetic */ ExpireConfig(boolean z16, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? C.a() : j3, (i3 & 4) != 0 ? C.b() : j16);
    }
}
