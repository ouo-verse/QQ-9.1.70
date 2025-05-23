package com.tencent.mobileqq.guild.home.viewmodels.header.processors;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "a", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "b", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "replacedItem", "<init>", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class ProcessResult {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<ProcessResult> f225425c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b replacedItem;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult$a;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "None$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "None", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.processors.ProcessResult$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProcessResult a() {
            return (ProcessResult) ProcessResult.f225425c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ProcessResult> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ProcessResult>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.processors.ProcessResult$Companion$None$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ProcessResult invoke() {
                return new ProcessResult(null, 1, 0 == true ? 1 : 0);
            }
        });
        f225425c = lazy;
    }

    public ProcessResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b getReplacedItem() {
        return this.replacedItem;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ProcessResult) && Intrinsics.areEqual(this.replacedItem, ((ProcessResult) other).replacedItem)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar = this.replacedItem;
        if (bVar == null) {
            return 0;
        }
        return bVar.hashCode();
    }

    @NotNull
    public String toString() {
        return "ProcessResult(replacedItem=" + this.replacedItem + ")";
    }

    public ProcessResult(@Nullable com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar) {
        this.replacedItem = bVar;
    }

    public /* synthetic */ ProcessResult(com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
