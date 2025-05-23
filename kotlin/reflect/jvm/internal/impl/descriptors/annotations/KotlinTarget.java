package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PROPERTY' uses external variables
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
public final class KotlinTarget {

    @NotNull
    private static final Set<KotlinTarget> ALL_TARGET_SET;

    @NotNull
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST;

    @NotNull
    private static final List<KotlinTarget> CLASS_LIST;

    @NotNull
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST;
    public static final KotlinTarget CONSTRUCTOR;

    @NotNull
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;

    @NotNull
    private static final List<KotlinTarget> ENUM_ENTRY_LIST;

    @NotNull
    private static final List<KotlinTarget> ENUM_LIST;
    public static final KotlinTarget FIELD;

    @NotNull
    private static final List<KotlinTarget> FILE_LIST;
    public static final KotlinTarget FUNCTION;

    @NotNull
    private static final List<KotlinTarget> FUNCTION_LIST;

    @NotNull
    private static final List<KotlinTarget> INTERFACE_LIST;

    @NotNull
    private static final List<KotlinTarget> LOCAL_CLASS_LIST;
    public static final KotlinTarget LOCAL_VARIABLE;

    @NotNull
    private static final List<KotlinTarget> OBJECT_LIST;
    public static final KotlinTarget PROPERTY;
    public static final KotlinTarget PROPERTY_GETTER;

    @NotNull
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST;
    public static final KotlinTarget PROPERTY_SETTER;

    @NotNull
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST;

    @NotNull
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    public static final KotlinTarget VALUE_PARAMETER;

    @NotNull
    private final String description;
    private final boolean isDefault;
    public static final KotlinTarget CLASS = new KotlinTarget("CLASS", 0, Constants.Service.CLASS, false, 2, null);
    public static final KotlinTarget ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
    public static final KotlinTarget TYPE_PARAMETER = new KotlinTarget("TYPE_PARAMETER", 2, "type parameter", false);
    public static final KotlinTarget TYPE = new KotlinTarget("TYPE", 11, "type usage", false);
    public static final KotlinTarget EXPRESSION = new KotlinTarget("EXPRESSION", 12, "expression", false);
    public static final KotlinTarget FILE = new KotlinTarget("FILE", 13, "file", false);
    public static final KotlinTarget TYPEALIAS = new KotlinTarget("TYPEALIAS", 14, "typealias", false);
    public static final KotlinTarget TYPE_PROJECTION = new KotlinTarget("TYPE_PROJECTION", 15, "type projection", false);
    public static final KotlinTarget STAR_PROJECTION = new KotlinTarget("STAR_PROJECTION", 16, "star projection", false);
    public static final KotlinTarget PROPERTY_PARAMETER = new KotlinTarget("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    public static final KotlinTarget CLASS_ONLY = new KotlinTarget("CLASS_ONLY", 18, Constants.Service.CLASS, false);
    public static final KotlinTarget OBJECT = new KotlinTarget("OBJECT", 19, "object", false);
    public static final KotlinTarget STANDALONE_OBJECT = new KotlinTarget("STANDALONE_OBJECT", 20, "standalone object", false);
    public static final KotlinTarget COMPANION_OBJECT = new KotlinTarget("COMPANION_OBJECT", 21, "companion object", false);
    public static final KotlinTarget INTERFACE = new KotlinTarget("INTERFACE", 22, Constants.Service.INTERFACE, false);
    public static final KotlinTarget ENUM_CLASS = new KotlinTarget("ENUM_CLASS", 23, "enum class", false);
    public static final KotlinTarget ENUM_ENTRY = new KotlinTarget("ENUM_ENTRY", 24, "enum entry", false);
    public static final KotlinTarget LOCAL_CLASS = new KotlinTarget("LOCAL_CLASS", 25, "local class", false);
    public static final KotlinTarget LOCAL_FUNCTION = new KotlinTarget("LOCAL_FUNCTION", 26, "local function", false);
    public static final KotlinTarget MEMBER_FUNCTION = new KotlinTarget("MEMBER_FUNCTION", 27, "member function", false);
    public static final KotlinTarget TOP_LEVEL_FUNCTION = new KotlinTarget("TOP_LEVEL_FUNCTION", 28, "top level function", false);
    public static final KotlinTarget MEMBER_PROPERTY = new KotlinTarget("MEMBER_PROPERTY", 29, "member property", false);
    public static final KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);
    public static final KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);
    public static final KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);
    public static final KotlinTarget TOP_LEVEL_PROPERTY = new KotlinTarget("TOP_LEVEL_PROPERTY", 33, "top level property", false);
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);
    public static final KotlinTarget BACKING_FIELD = new KotlinTarget("BACKING_FIELD", 37, "backing field", false, 2, null);
    public static final KotlinTarget INITIALIZER = new KotlinTarget("INITIALIZER", 38, "initializer", false);
    public static final KotlinTarget DESTRUCTURING_DECLARATION = new KotlinTarget("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);
    public static final KotlinTarget LAMBDA_EXPRESSION = new KotlinTarget("LAMBDA_EXPRESSION", 40, "lambda expression", false);
    public static final KotlinTarget ANONYMOUS_FUNCTION = new KotlinTarget("ANONYMOUS_FUNCTION", 41, "anonymous function", false);
    public static final KotlinTarget OBJECT_LITERAL = new KotlinTarget("OBJECT_LITERAL", 42, "object literal", false);
    private static final /* synthetic */ KotlinTarget[] $VALUES = $values();

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final HashMap<String, KotlinTarget> map = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    private static final /* synthetic */ KotlinTarget[] $values() {
        return new KotlinTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS, TYPE_PROJECTION, STAR_PROJECTION, PROPERTY_PARAMETER, CLASS_ONLY, OBJECT, STANDALONE_OBJECT, COMPANION_OBJECT, INTERFACE, ENUM_CLASS, ENUM_ENTRY, LOCAL_CLASS, LOCAL_FUNCTION, MEMBER_FUNCTION, TOP_LEVEL_FUNCTION, MEMBER_PROPERTY, MEMBER_PROPERTY_WITH_BACKING_FIELD, MEMBER_PROPERTY_WITH_DELEGATE, MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, TOP_LEVEL_PROPERTY, TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, TOP_LEVEL_PROPERTY_WITH_DELEGATE, TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, BACKING_FIELD, INITIALIZER, DESTRUCTURING_DECLARATION, LAMBDA_EXPRESSION, ANONYMOUS_FUNCTION, OBJECT_LITERAL};
    }

    static {
        Set<KotlinTarget> set;
        Set<KotlinTarget> set2;
        List<KotlinTarget> listOf;
        List<KotlinTarget> listOf2;
        List<KotlinTarget> listOf3;
        List<KotlinTarget> listOf4;
        List<KotlinTarget> listOf5;
        List<KotlinTarget> listOf6;
        List<KotlinTarget> listOf7;
        List<KotlinTarget> listOf8;
        List<KotlinTarget> listOf9;
        List<KotlinTarget> listOf10;
        List<KotlinTarget> listOf11;
        List<KotlinTarget> listOf12;
        Map<AnnotationUseSiteTarget, KotlinTarget> mapOf;
        boolean z16 = false;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        PROPERTY = new KotlinTarget("PROPERTY", 3, "property", z16, i3, defaultConstructorMarker);
        boolean z17 = false;
        int i16 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        FIELD = new KotlinTarget("FIELD", 4, "field", z17, i16, defaultConstructorMarker2);
        LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", z16, i3, defaultConstructorMarker);
        VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", z17, i16, defaultConstructorMarker2);
        CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", z16, i3, defaultConstructorMarker);
        FUNCTION = new KotlinTarget("FUNCTION", 8, "function", z17, i16, defaultConstructorMarker2);
        PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", z16, i3, defaultConstructorMarker);
        PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", z17, i16, defaultConstructorMarker2);
        for (KotlinTarget kotlinTarget : values()) {
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values = values();
        ArrayList arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values) {
            if (kotlinTarget2.isDefault) {
                arrayList.add(kotlinTarget2);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        DEFAULT_TARGET_SET = set;
        set2 = ArraysKt___ArraysKt.toSet(values());
        ALL_TARGET_SET = set2;
        KotlinTarget kotlinTarget3 = CLASS;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{ANNOTATION_CLASS, kotlinTarget3});
        ANNOTATION_CLASS_LIST = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{LOCAL_CLASS, kotlinTarget3});
        LOCAL_CLASS_LIST = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{CLASS_ONLY, kotlinTarget3});
        CLASS_LIST = listOf3;
        KotlinTarget kotlinTarget4 = OBJECT;
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{COMPANION_OBJECT, kotlinTarget4, kotlinTarget3});
        COMPANION_OBJECT_LIST = listOf4;
        listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{STANDALONE_OBJECT, kotlinTarget4, kotlinTarget3});
        OBJECT_LIST = listOf5;
        listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{INTERFACE, kotlinTarget3});
        INTERFACE_LIST = listOf6;
        listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{ENUM_CLASS, kotlinTarget3});
        ENUM_LIST = listOf7;
        KotlinTarget kotlinTarget5 = PROPERTY;
        KotlinTarget kotlinTarget6 = FIELD;
        listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinTarget[]{ENUM_ENTRY, kotlinTarget5, kotlinTarget6});
        ENUM_ENTRY_LIST = listOf8;
        KotlinTarget kotlinTarget7 = PROPERTY_SETTER;
        listOf9 = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget7);
        PROPERTY_SETTER_LIST = listOf9;
        KotlinTarget kotlinTarget8 = PROPERTY_GETTER;
        listOf10 = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget8);
        PROPERTY_GETTER_LIST = listOf10;
        listOf11 = CollectionsKt__CollectionsJVMKt.listOf(FUNCTION);
        FUNCTION_LIST = listOf11;
        KotlinTarget kotlinTarget9 = FILE;
        listOf12 = CollectionsKt__CollectionsJVMKt.listOf(kotlinTarget9);
        FILE_LIST = listOf12;
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget10 = VALUE_PARAMETER;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(annotationUseSiteTarget, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.FIELD, kotlinTarget6), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, kotlinTarget5), TuplesKt.to(AnnotationUseSiteTarget.FILE, kotlinTarget9), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, kotlinTarget8), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, kotlinTarget7), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget10), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget6));
        USE_SITE_MAPPING = mapOf;
    }

    KotlinTarget(String str, int i3, String str2, boolean z16) {
        this.description = str2;
        this.isDefault = z16;
    }

    public static KotlinTarget valueOf(String str) {
        return (KotlinTarget) Enum.valueOf(KotlinTarget.class, str);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[]) $VALUES.clone();
    }

    /* synthetic */ KotlinTarget(String str, int i3, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i16 & 2) != 0 ? true : z16);
    }
}
