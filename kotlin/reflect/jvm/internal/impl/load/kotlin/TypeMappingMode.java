package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.tencent.luggage.wxa.j2.c;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeMappingMode {

    @JvmField
    @NotNull
    public static final TypeMappingMode CLASS_DECLARATION;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT;

    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT_UAST;

    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT;

    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;

    @JvmField
    @NotNull
    public static final TypeMappingMode RETURN_TYPE_BOXED;

    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE;

    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;

    @JvmField
    @NotNull
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;

    @Nullable
    private final TypeMappingMode genericArgumentMode;

    @Nullable
    private final TypeMappingMode genericContravariantArgumentMode;

    @Nullable
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        TypeMappingMode typeMappingMode = null;
        boolean z26 = false;
        TypeMappingMode typeMappingMode2 = null;
        TypeMappingMode typeMappingMode3 = null;
        boolean z27 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(z16, false, z17, z18, z19, typeMappingMode, z26, typeMappingMode2, typeMappingMode3, z27, 1023, defaultConstructorMarker);
        GENERIC_ARGUMENT = typeMappingMode4;
        boolean z28 = false;
        boolean z29 = false;
        boolean z36 = false;
        boolean z37 = false;
        boolean z38 = false;
        boolean z39 = false;
        TypeMappingMode typeMappingMode5 = null;
        TypeMappingMode typeMappingMode6 = null;
        boolean z46 = true;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        TypeMappingMode typeMappingMode7 = new TypeMappingMode(z28, z29, z36, z37, z38, null, z39, typeMappingMode5, typeMappingMode6, z46, 511, defaultConstructorMarker2);
        GENERIC_ARGUMENT_UAST = typeMappingMode7;
        RETURN_TYPE_BOXED = new TypeMappingMode(z16, true, z17, z18, z19, typeMappingMode, z26, typeMappingMode2, typeMappingMode3, z27, 1021, defaultConstructorMarker);
        int i3 = 988;
        DEFAULT = new TypeMappingMode(z16, false, z17, z18, z19, typeMappingMode4, z26, typeMappingMode2, typeMappingMode3, z27, i3, defaultConstructorMarker);
        DEFAULT_UAST = new TypeMappingMode(z28, z29, z36, z37, z38, typeMappingMode7, z39, typeMappingMode5, typeMappingMode6, z46, c.CTRL_INDEX, defaultConstructorMarker2);
        CLASS_DECLARATION = new TypeMappingMode(z16, true, z17, z18, z19, typeMappingMode4, z26, typeMappingMode2, typeMappingMode3, z27, i3, defaultConstructorMarker);
        boolean z47 = false;
        boolean z48 = true;
        SUPER_TYPE = new TypeMappingMode(z16, z47, z17, z48, z19, typeMappingMode4, z26, typeMappingMode2, typeMappingMode3, z27, 983, defaultConstructorMarker);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(z16, z47, z17, z48, z19, typeMappingMode4, z26, typeMappingMode2, typeMappingMode3, z27, 919, defaultConstructorMarker);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(z16, z47, true, false, z19, typeMappingMode4, z26, typeMappingMode2, typeMappingMode3, z27, 984, defaultConstructorMarker);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance effectiveVariance, boolean z16) {
        Intrinsics.checkNotNullParameter(effectiveVariance, "effectiveVariance");
        if (!z16 || !this.isForAnnotationParameter) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    TypeMappingMode typeMappingMode = this.genericArgumentMode;
                    if (typeMappingMode != null) {
                        return typeMappingMode;
                    }
                } else {
                    TypeMappingMode typeMappingMode2 = this.genericInvariantArgumentMode;
                    if (typeMappingMode2 != null) {
                        return typeMappingMode2;
                    }
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.genericContravariantArgumentMode;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    public TypeMappingMode(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, @Nullable TypeMappingMode typeMappingMode, boolean z27, @Nullable TypeMappingMode typeMappingMode2, @Nullable TypeMappingMode typeMappingMode3, boolean z28) {
        this.needPrimitiveBoxing = z16;
        this.needInlineClassWrapping = z17;
        this.isForAnnotationParameter = z18;
        this.skipDeclarationSiteWildcards = z19;
        this.skipDeclarationSiteWildcardsIfPossible = z26;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z27;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z28;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeMappingMode(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, TypeMappingMode typeMappingMode, boolean z27, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z28, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, (i3 & 64) == 0 ? z27 : true, (i3 & 128) != 0 ? r8 : typeMappingMode2, (i3 & 256) != 0 ? r8 : typeMappingMode3, (i3 & 512) == 0 ? z28 : false);
        boolean z29 = (i3 & 1) != 0 ? true : z16;
        boolean z36 = (i3 & 2) != 0 ? true : z17;
        boolean z37 = (i3 & 4) != 0 ? false : z18;
        boolean z38 = (i3 & 8) != 0 ? false : z19;
        boolean z39 = (i3 & 16) != 0 ? false : z26;
        TypeMappingMode typeMappingMode4 = (i3 & 32) != 0 ? null : typeMappingMode;
    }
}
