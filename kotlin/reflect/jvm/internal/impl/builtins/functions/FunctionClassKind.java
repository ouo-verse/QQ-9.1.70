package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'KFunction' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ FunctionClassKind[] $VALUES;

    @NotNull
    public static final Companion Companion;
    public static final FunctionClassKind KFunction;
    public static final FunctionClassKind KSuspendFunction;

    @NotNull
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;

    @NotNull
    private final FqName packageFqName;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0, StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1, StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class KindWithArity {
            private final int arity;

            @NotNull
            private final FunctionClassKind kind;

            public KindWithArity(@NotNull FunctionClassKind kind, int i3) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                this.kind = kind;
                this.arity = i3;
            }

            @NotNull
            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof KindWithArity)) {
                    return false;
                }
                KindWithArity kindWithArity = (KindWithArity) obj;
                if (this.kind == kindWithArity.kind && this.arity == kindWithArity.arity) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final FunctionClassKind getKind() {
                return this.kind;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            @NotNull
            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer toInt(String str) {
            boolean z16;
            boolean z17;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            int length = str.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int charAt = str.charAt(i16) - '0';
                if (charAt >= 0 && charAt < 10) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    return null;
                }
                i3 = (i3 * 10) + charAt;
            }
            return Integer.valueOf(i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:2:0x0013->B:10:0x0034, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[SYNTHETIC] */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FunctionClassKind byClassNamePrefix(@NotNull FqName packageFqName, @NotNull String className) {
            boolean z16;
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            Intrinsics.checkNotNullParameter(className, "className");
            for (FunctionClassKind functionClassKind : FunctionClassKind.values()) {
                if (Intrinsics.areEqual(functionClassKind.getPackageFqName(), packageFqName)) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(className, functionClassKind.getClassNamePrefix(), false, 2, null);
                    if (startsWith$default) {
                        z16 = true;
                        if (!z16) {
                            return functionClassKind;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind getFunctionalClassKind(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(className, packageFqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }

        @Nullable
        public final KindWithArity parseClassName(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(packageFqName, className);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = className.substring(byClassNamePrefix.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Integer num = toInt(substring);
            if (num == null) {
                return null;
            }
            return new KindWithArity(byClassNamePrefix, num.intValue());
        }

        Companion() {
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    static {
        FqName fqName = StandardNames.KOTLIN_REFLECT_FQ_NAME;
        KFunction = new FunctionClassKind("KFunction", 2, fqName, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, fqName, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    FunctionClassKind(String str, int i3, FqName fqName, String str2, boolean z16, boolean z17) {
        this.packageFqName = fqName;
        this.classNamePrefix = str2;
        this.isSuspendType = z16;
        this.isReflectType = z17;
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final Name numberedClassName(int i3) {
        Name identifier = Name.identifier(this.classNamePrefix + i3);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }
}
