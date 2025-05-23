package com.tencent.mobileqq.guild.channellist.process;

import com.tencent.mobileqq.guild.channellist.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/channellist/c;", "a", "Lcom/tencent/mobileqq/guild/channellist/c;", "b", "()Lcom/tencent/mobileqq/guild/channellist/c;", "replacedItem", "<init>", "(Lcom/tencent/mobileqq/guild/channellist/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class ReplaceResult {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<ReplaceResult> f215324c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final c replacedItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult$a;", "", "Lcom/tencent/mobileqq/guild/channellist/c;", "replacedItem", "Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", "b", "None$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", "None", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.process.ReplaceResult$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReplaceResult a() {
            return (ReplaceResult) ReplaceResult.f215324c.getValue();
        }

        @NotNull
        public final ReplaceResult b(@NotNull c replacedItem) {
            Intrinsics.checkNotNullParameter(replacedItem, "replacedItem");
            return new ReplaceResult(replacedItem);
        }

        Companion() {
        }
    }

    static {
        Lazy<ReplaceResult> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ReplaceResult>() { // from class: com.tencent.mobileqq.guild.channellist.process.ReplaceResult$Companion$None$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReplaceResult invoke() {
                return new ReplaceResult(null, 1, 0 == true ? 1 : 0);
            }
        });
        f215324c = lazy;
    }

    public ReplaceResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final c getReplacedItem() {
        return this.replacedItem;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ReplaceResult) && Intrinsics.areEqual(this.replacedItem, ((ReplaceResult) other).replacedItem)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        c cVar = this.replacedItem;
        if (cVar == null) {
            return 0;
        }
        return cVar.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReplaceResult(replacedItem=" + this.replacedItem + ")";
    }

    public ReplaceResult(@Nullable c cVar) {
        this.replacedItem = cVar;
    }

    public /* synthetic */ ReplaceResult(c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : cVar);
    }
}
