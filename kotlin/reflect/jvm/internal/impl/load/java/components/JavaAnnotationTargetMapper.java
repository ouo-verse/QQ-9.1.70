package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaAnnotationTargetMapper {

    @NotNull
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();

    @NotNull
    private static final Map<String, KotlinRetention> retentionNameList;

    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists;

    static {
        Map<String, EnumSet<KotlinTarget>> mapOf;
        Map<String, KotlinRetention> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
        targetNameLists = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE));
        retentionNameList = mapOf2;
    }

    JavaAnnotationTargetMapper() {
    }

    @Nullable
    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(@Nullable JavaAnnotationArgument javaAnnotationArgument) {
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument;
        String str;
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
        } else {
            javaEnumValueAnnotationArgument = null;
        }
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = retentionNameList;
        Name entryName = javaEnumValueAnnotationArgument.getEntryName();
        if (entryName != null) {
            str = entryName.asString();
        } else {
            str = null;
        }
        KotlinRetention kotlinRetention = map.get(str);
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationRetention);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.F\u2026ames.annotationRetention)");
        Name identifier = Name.identifier(kotlinRetention.name());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(retention.name)");
        return new EnumValue(classId, identifier);
    }

    @NotNull
    public final Set<KotlinTarget> mapJavaTargetArgumentByName(@Nullable String str) {
        Set<KotlinTarget> emptySet;
        EnumSet<KotlinTarget> enumSet = targetNameLists.get(str);
        if (enumSet == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        return enumSet;
    }

    @NotNull
    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(@NotNull List<? extends JavaAnnotationArgument> arguments) {
        int collectionSizeOrDefault;
        String str;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument : arrayList) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = INSTANCE;
            Name entryName = javaEnumValueAnnotationArgument.getEntryName();
            if (entryName != null) {
                str = entryName.asString();
            } else {
                str = null;
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, javaAnnotationTargetMapper.mapJavaTargetArgumentByName(str));
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (KotlinTarget kotlinTarget : arrayList2) {
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.annotationTarget);
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationTarget)");
            Name identifier = Name.identifier(kotlinTarget.name());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new EnumValue(classId, identifier));
        }
        return new ArrayValue(arrayList3, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper$mapJavaTargetArguments$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KotlinType invoke(@NotNull ModuleDescriptor module) {
                Intrinsics.checkNotNullParameter(module, "module");
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), module.getBuiltIns().getBuiltInClassByFqName(StandardNames.FqNames.target));
                KotlinType type = annotationParameterByName != null ? annotationParameterByName.getType() : null;
                return type == null ? ErrorUtils.createErrorType(ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]) : type;
            }
        });
    }
}
