package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.ContractsDsl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\b\u0005H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0006"}, d2 = {"contract", "", "builder", "Lkotlin/Function1;", "Lkotlin/contracts/ContractBuilder;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ContractBuilderKt {
    @SinceKotlin(version = "1.3")
    @ContractsDsl
    @InlineOnly
    @ExperimentalContracts
    private static final void contract(Function1<? super ContractBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}
