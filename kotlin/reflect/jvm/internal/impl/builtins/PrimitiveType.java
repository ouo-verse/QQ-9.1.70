package kotlin.reflect.jvm.internal.impl.builtins;

import com.tencent.mobileqq.mini.cache.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType, still in use, count: 1, list:
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType) from 0x007e: FILLED_NEW_ARRAY 
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r1v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r2v3 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r5v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r7v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r9v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r11v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
 A[WRAPPED] (LINE:127) elemType: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes28.dex */
public final class PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;

    @NotNull
    private final Lazy arrayTypeFqName$delegate;

    @NotNull
    private final Name arrayTypeName;

    @NotNull
    private final Lazy typeFqName$delegate;

    @NotNull
    private final Name typeName;

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    static {
        Set<PrimitiveType> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new PrimitiveType[]{new PrimitiveType("Char"), new PrimitiveType("Byte"), new PrimitiveType("Short"), new PrimitiveType("Int"), new PrimitiveType("Float"), new PrimitiveType("Long"), new PrimitiveType("Double")});
        NUMBER_TYPES = of5;
    }

    PrimitiveType(String str) {
        Lazy lazy;
        Lazy lazy2;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeName)");
        this.typeName = identifier;
        Name identifier2 = Name.identifier(str + Entry.DATA_TYPE_Array);
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = identifier2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FqName>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$typeFqName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FqName invoke() {
                FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(PrimitiveType.this.getTypeName());
                Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
                return child;
            }
        });
        this.typeFqName$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FqName>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$arrayTypeFqName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FqName invoke() {
                FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(PrimitiveType.this.getArrayTypeName());
                Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
                return child;
            }
        });
        this.arrayTypeFqName$delegate = lazy2;
    }

    public static PrimitiveType valueOf(String str) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, str);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    @NotNull
    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    @NotNull
    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }
}
