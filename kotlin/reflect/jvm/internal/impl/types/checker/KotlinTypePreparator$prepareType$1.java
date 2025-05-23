package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes28.dex */
public /* synthetic */ class KotlinTypePreparator$prepareType$1 extends FunctionReference implements Function1<KotlinTypeMarker, UnwrappedType> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KotlinTypePreparator$prepareType$1(Object obj) {
        super(1, obj);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public final String getName() {
        return "prepareType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(KotlinTypePreparator.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final UnwrappedType invoke(@NotNull KotlinTypeMarker p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return ((KotlinTypePreparator) this.receiver).prepareType(p06);
    }
}
