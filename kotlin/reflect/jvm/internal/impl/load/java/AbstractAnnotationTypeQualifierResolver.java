package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES;

    @NotNull
    private final JavaTypeEnhancementState javaTypeEnhancementState;

    @NotNull
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : AnnotationQualifierApplicabilityType.values()) {
            String javaTarget = annotationQualifierApplicabilityType.getJavaTarget();
            if (linkedHashMap.get(javaTarget) == null) {
                linkedHashMap.put(javaTarget, annotationQualifierApplicabilityType);
            }
        }
        JAVA_APPLICABILITY_TYPES = linkedHashMap;
    }

    public AbstractAnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.resolvedNicknames = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> set) {
        Set set2;
        Set minus;
        Set<AnnotationQualifierApplicabilityType> plus;
        if (set.contains(AnnotationQualifierApplicabilityType.TYPE_USE)) {
            set2 = ArraysKt___ArraysKt.toSet(AnnotationQualifierApplicabilityType.values());
            minus = SetsKt___SetsKt.minus((Set<? extends AnnotationQualifierApplicabilityType>) ((Set<? extends Object>) set2), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS);
            plus = SetsKt___SetsKt.plus(minus, (Iterable) set);
            return plus;
        }
        return set;
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation tannotation) {
        NullabilityQualifierWithMigrationStatus extractNullability;
        JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation = resolveQualifierBuiltInDefaultAnnotation(tannotation);
        if (resolveQualifierBuiltInDefaultAnnotation != null) {
            return resolveQualifierBuiltInDefaultAnnotation;
        }
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation = resolveTypeQualifierDefaultAnnotation(tannotation);
        if (resolveTypeQualifierDefaultAnnotation == null) {
            return null;
        }
        TAnnotation component1 = resolveTypeQualifierDefaultAnnotation.component1();
        Set<AnnotationQualifierApplicabilityType> component2 = resolveTypeQualifierDefaultAnnotation.component2();
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (resolveJsr305CustomState == null) {
            resolveJsr305CustomState = resolveJsr305AnnotationState(component1);
        }
        if (resolveJsr305CustomState.isIgnore() || (extractNullability = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) component1, (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) new Function1<TAnnotation, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull TAnnotation extractNullability2) {
                Intrinsics.checkNotNullParameter(extractNullability2, "$this$extractNullability");
                return Boolean.FALSE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1<TAnnotation>) obj);
            }
        })) == null) {
            return null;
        }
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(extractNullability, null, resolveJsr305CustomState.isWarning(), 1, null), component2, false, 4, null);
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        NullabilityQualifierWithMigrationStatus knownNullability;
        NullabilityQualifierWithMigrationStatus knownNullability2 = knownNullability(tannotation, function1.invoke(tannotation).booleanValue());
        if (knownNullability2 != null) {
            return knownNullability2;
        }
        TAnnotation resolveTypeQualifierAnnotation = resolveTypeQualifierAnnotation(tannotation);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = resolveJsr305AnnotationState(tannotation);
        if (resolveJsr305AnnotationState.isIgnore() || (knownNullability = knownNullability(resolveTypeQualifierAnnotation, function1.invoke(resolveTypeQualifierAnnotation).booleanValue())) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(knownNullability, null, resolveJsr305AnnotationState.isWarning(), 1, null);
    }

    private final TAnnotation findAnnotation(TAnnotation tannotation, FqName fqName) {
        for (TAnnotation tannotation2 : getMetaAnnotations(tannotation)) {
            if (Intrinsics.areEqual(getFqName(tannotation2), fqName)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean hasAnnotation(TAnnotation tannotation, FqName fqName) {
        Iterable<TAnnotation> metaAnnotations = getMetaAnnotations(tannotation);
        if ((metaAnnotations instanceof Collection) && ((Collection) metaAnnotations).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = metaAnnotations.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(getFqName(it.next()), fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
    
        if (r6.equals("NEVER") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
    
        r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009a, code lost:
    
        if (r6.equals("MAYBE") == false) goto L41;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x006e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation tannotation, boolean z16) {
        NullabilityQualifier nullabilityQualifier;
        Object firstOrNull;
        FqName fqName = getFqName(tannotation);
        if (fqName == null) {
            return null;
        }
        ReportLevel invoke = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
        if (invoke.isIgnore()) {
            return null;
        }
        boolean z17 = false;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        } else if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE())) {
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN())) {
            nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(enumArguments(tannotation, false));
            String str = (String) firstOrNull;
            if (str != null) {
                switch (str.hashCode()) {
                    case 73135176:
                        break;
                    case 74175084:
                        break;
                    case 433141802:
                        if (str.equals("UNKNOWN")) {
                            nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
                            break;
                        }
                        return null;
                    case 1933739535:
                        break;
                    default:
                        return null;
                }
            }
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION())) {
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION())) {
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        } else {
            if (!Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
                return null;
            }
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        }
        if (invoke.isWarning() || z16) {
            z17 = true;
        }
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z17);
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation tannotation) {
        FqName fqName = getFqName(tannotation);
        if (fqName != null && AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(fqName)) {
            return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(fqName);
        }
        return resolveJsr305AnnotationState(tannotation);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation tannotation) {
        ReportLevel resolveJsr305CustomState = resolveJsr305CustomState(tannotation);
        if (resolveJsr305CustomState != null) {
            return resolveJsr305CustomState;
        }
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation tannotation) {
        Iterable<String> enumArguments;
        Object firstOrNull;
        ReportLevel reportLevel = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(tannotation));
        if (reportLevel != null) {
            return reportLevel;
        }
        TAnnotation findAnnotation = findAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (findAnnotation != null && (enumArguments = enumArguments(findAnnotation, false)) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(enumArguments);
            String str = (String) firstOrNull;
            if (str == null) {
                return null;
            }
            ReportLevel migrationLevel = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
            if (migrationLevel == null) {
                int hashCode = str.hashCode();
                if (hashCode != -2137067054) {
                    if (hashCode != -1838656823) {
                        if (hashCode != 2656902 || !str.equals("WARN")) {
                            return null;
                        }
                        return ReportLevel.WARN;
                    }
                    if (!str.equals("STRICT")) {
                        return null;
                    }
                    return ReportLevel.STRICT;
                }
                if (!str.equals("IGNORE")) {
                    return null;
                }
                return ReportLevel.IGNORE;
            }
            return migrationLevel;
        }
        return null;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation tannotation) {
        JavaDefaultQualifiers javaDefaultQualifiers;
        boolean z16;
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() || (javaDefaultQualifiers = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(tannotation))) == null) {
            return null;
        }
        ReportLevel resolveDefaultAnnotationState = resolveDefaultAnnotationState(tannotation);
        if (resolveDefaultAnnotationState != ReportLevel.IGNORE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            resolveDefaultAnnotationState = null;
        }
        if (resolveDefaultAnnotationState == null) {
            return null;
        }
        return JavaDefaultQualifiers.copy$default(javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus.copy$default(javaDefaultQualifiers.getNullabilityQualifier(), null, resolveDefaultAnnotationState.isWarning(), 1, null), null, false, 6, null);
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation tannotation) {
        TAnnotation findAnnotation;
        TAnnotation tannotation2;
        boolean z16;
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() || (findAnnotation = findAnnotation(tannotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = getMetaAnnotations(tannotation).iterator();
        while (true) {
            if (it.hasNext()) {
                tannotation2 = it.next();
                if (resolveTypeQualifierAnnotation(tannotation2) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                tannotation2 = null;
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it5 = enumArguments.iterator();
        while (it5.hasNext()) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = JAVA_APPLICABILITY_TYPES.get(it5.next());
            if (annotationQualifierApplicabilityType != null) {
                linkedHashSet.add(annotationQualifierApplicabilityType);
            }
        }
        return new Pair<>(tannotation2, allIfTypeUse(linkedHashSet));
    }

    @NotNull
    protected abstract Iterable<String> enumArguments(@NotNull TAnnotation tannotation, boolean z16);

    @Nullable
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(@Nullable JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, @NotNull Iterable<? extends TAnnotation> annotations) {
        EnumMap enumMap;
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> defaultQualifiers;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations()) {
            return javaTypeQualifiersByElementType;
        }
        ArrayList<JavaDefaultQualifiers> arrayList = new ArrayList();
        Iterator<? extends TAnnotation> it = annotations.iterator();
        while (it.hasNext()) {
            JavaDefaultQualifiers extractDefaultQualifiers = extractDefaultQualifiers(it.next());
            if (extractDefaultQualifiers != null) {
                arrayList.add(extractDefaultQualifiers);
            }
        }
        if (arrayList.isEmpty()) {
            return javaTypeQualifiersByElementType;
        }
        if (javaTypeQualifiersByElementType != null && (defaultQualifiers = javaTypeQualifiersByElementType.getDefaultQualifiers()) != null) {
            enumMap = new EnumMap((EnumMap) defaultQualifiers);
        } else {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        boolean z16 = false;
        for (JavaDefaultQualifiers javaDefaultQualifiers : arrayList) {
            Iterator<AnnotationQualifierApplicabilityType> it5 = javaDefaultQualifiers.getQualifierApplicabilityTypes().iterator();
            while (it5.hasNext()) {
                enumMap.put((EnumMap) it5.next(), (AnnotationQualifierApplicabilityType) javaDefaultQualifiers);
                z16 = true;
            }
        }
        if (z16) {
            return new JavaTypeQualifiersByElementType(enumMap);
        }
        return javaTypeQualifiersByElementType;
    }

    @Nullable
    public final MutabilityQualifier extractMutability(@NotNull Iterable<? extends TAnnotation> annotations) {
        MutabilityQualifier mutabilityQualifier;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        MutabilityQualifier mutabilityQualifier2 = null;
        while (it.hasNext()) {
            FqName fqName = getFqName(it.next());
            if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(fqName)) {
                mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            } else if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(fqName)) {
                mutabilityQualifier = MutabilityQualifier.MUTABLE;
            } else {
                continue;
            }
            if (mutabilityQualifier2 != null && mutabilityQualifier2 != mutabilityQualifier) {
                return null;
            }
            mutabilityQualifier2 = mutabilityQualifier;
        }
        return mutabilityQualifier2;
    }

    @Nullable
    protected abstract FqName getFqName(@NotNull TAnnotation tannotation);

    @NotNull
    protected abstract Object getKey(@NotNull TAnnotation tannotation);

    @NotNull
    protected abstract Iterable<TAnnotation> getMetaAnnotations(@NotNull TAnnotation tannotation);

    public final boolean isTypeUseAnnotation(@NotNull TAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        TAnnotation findAnnotation = findAnnotation(annotation, StandardNames.FqNames.target);
        if (findAnnotation == null) {
            return false;
        }
        Iterable<String> enumArguments = enumArguments(findAnnotation, false);
        if ((enumArguments instanceof Collection) && ((Collection) enumArguments).isEmpty()) {
            return false;
        }
        Iterator<String> it = enumArguments.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), KotlinTarget.TYPE.name())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final TAnnotation resolveTypeQualifierAnnotation(@NotNull TAnnotation annotation) {
        boolean contains;
        TAnnotation tannotation;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (!this.javaTypeEnhancementState.getJsr305().isDisabled()) {
            contains = CollectionsKt___CollectionsKt.contains(AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES(), getFqName(annotation));
            if (!contains && !hasAnnotation(annotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_FQNAME())) {
                if (!hasAnnotation(annotation, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
                    return null;
                }
                ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.resolvedNicknames;
                Object key = getKey(annotation);
                TAnnotation tannotation2 = concurrentHashMap.get(key);
                if (tannotation2 == null) {
                    Iterator<TAnnotation> it = getMetaAnnotations(annotation).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            tannotation = resolveTypeQualifierAnnotation(it.next());
                            if (tannotation != null) {
                                break;
                            }
                        } else {
                            tannotation = null;
                            break;
                        }
                    }
                    if (tannotation == null) {
                        return null;
                    }
                    TAnnotation putIfAbsent = concurrentHashMap.putIfAbsent(key, tannotation);
                    if (putIfAbsent != null) {
                        return putIfAbsent;
                    }
                    return tannotation;
                }
                return tannotation2;
            }
            return annotation;
        }
        return null;
    }

    @Nullable
    public final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull Iterable<? extends TAnnotation> annotations, @NotNull Function1<? super TAnnotation, Boolean> forceWarning) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(forceWarning, "forceWarning");
        Iterator<? extends TAnnotation> it = annotations.iterator();
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        while (it.hasNext()) {
            NullabilityQualifierWithMigrationStatus extractNullability = extractNullability((AbstractAnnotationTypeQualifierResolver<TAnnotation>) it.next(), (Function1<? super AbstractAnnotationTypeQualifierResolver<TAnnotation>, Boolean>) forceWarning);
            if (nullabilityQualifierWithMigrationStatus != null) {
                if (extractNullability != null && !Intrinsics.areEqual(extractNullability, nullabilityQualifierWithMigrationStatus) && (!extractNullability.isForWarningOnly() || nullabilityQualifierWithMigrationStatus.isForWarningOnly())) {
                    if (extractNullability.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus.isForWarningOnly()) {
                        return null;
                    }
                }
            }
            nullabilityQualifierWithMigrationStatus = extractNullability;
        }
        return nullabilityQualifierWithMigrationStatus;
    }
}
