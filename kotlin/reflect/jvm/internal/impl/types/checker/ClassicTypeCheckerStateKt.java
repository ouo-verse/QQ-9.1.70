package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassicTypeCheckerStateKt {
    @NotNull
    public static final TypeCheckerState createClassicTypeCheckerState(boolean z16, boolean z17, @NotNull ClassicTypeSystemContext typeSystemContext, @NotNull KotlinTypePreparator kotlinTypePreparator, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "typeSystemContext");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeCheckerState(z16, z17, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ TypeCheckerState createClassicTypeCheckerState$default(boolean z16, boolean z17, ClassicTypeSystemContext classicTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        if ((i3 & 4) != 0) {
            classicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
        }
        if ((i3 & 8) != 0) {
            kotlinTypePreparator = KotlinTypePreparator.Default.INSTANCE;
        }
        if ((i3 & 16) != 0) {
            kotlinTypeRefiner = KotlinTypeRefiner.Default.INSTANCE;
        }
        return createClassicTypeCheckerState(z16, z17, classicTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }
}
