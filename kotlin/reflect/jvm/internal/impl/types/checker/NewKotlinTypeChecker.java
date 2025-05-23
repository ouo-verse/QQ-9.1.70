package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final NewKotlinTypeCheckerImpl Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, null, 2, 0 == true ? 1 : 0);

        Companion() {
        }

        @NotNull
        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }

    @NotNull
    KotlinTypeRefiner getKotlinTypeRefiner();

    @NotNull
    OverridingUtil getOverridingUtil();
}
