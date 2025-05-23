package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnnotationQualifiersFqNamesKt {

    @NotNull
    private static final Map<FqName, JavaDefaultQualifiers> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;

    @NotNull
    private static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_FQ_NAMES;

    @NotNull
    private static final List<AnnotationQualifierApplicabilityType> DEFAULT_JSPECIFY_APPLICABILITY;

    @NotNull
    private static final Map<FqName, JavaDefaultQualifiers> JSPECIFY_DEFAULT_ANNOTATIONS;

    @NotNull
    private static final FqName TYPE_QUALIFIER_NICKNAME_FQNAME = new FqName("javax.annotation.meta.TypeQualifierNickname");

    @NotNull
    private static final FqName TYPE_QUALIFIER_FQNAME = new FqName("javax.annotation.meta.TypeQualifier");

    @NotNull
    private static final FqName TYPE_QUALIFIER_DEFAULT_FQNAME = new FqName("javax.annotation.meta.TypeQualifierDefault");

    @NotNull
    private static final FqName MIGRATION_ANNOTATION_FQNAME = new FqName("kotlin.annotations.jvm.UnderMigration");

    static {
        List<AnnotationQualifierApplicabilityType> listOf;
        Map<FqName, JavaDefaultQualifiers> mapOf;
        List listOf2;
        List listOf3;
        Map mapOf2;
        Map<FqName, JavaDefaultQualifiers> plus;
        Set<FqName> of5;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
        DEFAULT_JSPECIFY_APPLICABILITY = listOf;
        FqName jspecify_null_marked = JvmAnnotationNamesKt.getJSPECIFY_NULL_MARKED();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(jspecify_null_marked, new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), listOf, false)));
        JSPECIFY_DEFAULT_ANNOTATIONS = mapOf;
        FqName fqName = new FqName("javax.annotation.ParametersAreNullableByDefault");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(annotationQualifierApplicabilityType);
        FqName fqName2 = new FqName("javax.annotation.ParametersAreNonnullByDefault");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null);
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(annotationQualifierApplicabilityType);
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(fqName, new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, listOf2, false, 4, null)), TuplesKt.to(fqName2, new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus2, listOf3, false, 4, null)));
        plus = MapsKt__MapsKt.plus(mapOf2, mapOf);
        BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = plus;
        of5 = SetsKt__SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION()});
        BUILT_IN_TYPE_QUALIFIER_FQ_NAMES = of5;
    }

    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return BUILT_IN_TYPE_QUALIFIER_FQ_NAMES;
    }

    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return JSPECIFY_DEFAULT_ANNOTATIONS;
    }

    @NotNull
    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return MIGRATION_ANNOTATION_FQNAME;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return TYPE_QUALIFIER_DEFAULT_FQNAME;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return TYPE_QUALIFIER_FQNAME;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return TYPE_QUALIFIER_NICKNAME_FQNAME;
    }
}
