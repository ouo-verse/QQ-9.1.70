package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Visibilities {

    @NotNull
    private static final Public DEFAULT_VISIBILITY;

    @NotNull
    public static final Visibilities INSTANCE = new Visibilities();

    @NotNull
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Inherited extends Visibility {

        @NotNull
        public static final Inherited INSTANCE = new Inherited();

        Inherited() {
            super("inherited", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Internal extends Visibility {

        @NotNull
        public static final Internal INSTANCE = new Internal();

        Internal() {
            super("internal", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class InvisibleFake extends Visibility {

        @NotNull
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Local extends Visibility {

        @NotNull
        public static final Local INSTANCE = new Local();

        Local() {
            super("local", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Private extends Visibility {

        @NotNull
        public static final Private INSTANCE = new Private();

        Private() {
            super("private", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class PrivateToThis extends Visibility {

        @NotNull
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        PrivateToThis() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Protected extends Visibility {

        @NotNull
        public static final Protected INSTANCE = new Protected();

        Protected() {
            super("protected", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Public extends Visibility {

        @NotNull
        public static final Public INSTANCE = new Public();

        Public() {
            super("public", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Unknown extends Visibility {

        @NotNull
        public static final Unknown INSTANCE = new Unknown();

        Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(PrivateToThis.INSTANCE, 0);
        createMapBuilder.put(Private.INSTANCE, 0);
        createMapBuilder.put(Internal.INSTANCE, 1);
        createMapBuilder.put(Protected.INSTANCE, 1);
        Public r16 = Public.INSTANCE;
        createMapBuilder.put(r16, 2);
        ORDERED_VISIBILITIES = MapsKt.build(createMapBuilder);
        DEFAULT_VISIBILITY = r16;
    }

    Visibilities() {
    }

    @Nullable
    public final Integer compareLocal$compiler_common(@NotNull Visibility first, @NotNull Visibility second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (first == second) {
            return 0;
        }
        Map<Visibility, Integer> map = ORDERED_VISIBILITIES;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num != null && num2 != null && !Intrinsics.areEqual(num, num2)) {
            return Integer.valueOf(num.intValue() - num2.intValue());
        }
        return null;
    }

    public final boolean isPrivate(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        if (visibility != Private.INSTANCE && visibility != PrivateToThis.INSTANCE) {
            return false;
        }
        return true;
    }
}
