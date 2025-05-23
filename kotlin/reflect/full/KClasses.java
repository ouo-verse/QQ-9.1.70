package kotlin.reflect.full;

import com.qq.e.comm.managers.plugin.PM;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007\u00a2\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007\u00a2\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R\u00a8\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", PM.BASE, "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KClasses")
/* loaded from: classes28.dex */
public final class KClasses {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T cast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (kClass.isInstance(obj)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
            return obj;
        }
        throw new TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> T createInstance(@NotNull KClass<T> kClass) {
        Map<KParameter, ? extends Object> emptyMap;
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator<T> it = kClass.getConstructors().iterator();
        T t16 = null;
        T t17 = null;
        boolean z17 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((KFunction) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it5 = parameters.iterator();
                    while (it5.hasNext()) {
                        if (!((KParameter) it5.next()).isOptional()) {
                            z16 = false;
                            break;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    if (z17) {
                        break;
                    }
                    t17 = next;
                    z17 = true;
                }
            } else if (z17) {
                t16 = t17;
            }
        }
        KFunction kFunction = (KFunction) t16;
        if (kFunction != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return (T) kFunction.callBy(emptyMap);
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + kClass);
    }

    @NotNull
    public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> kClass) {
        int collectionSizeOrDefault;
        KClass kClass2;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KType> allSupertypes = getAllSupertypes(kClass);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(allSupertypes, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (KType kType : allSupertypes) {
            KClassifier classifier = kType.getClassifier();
            if (classifier instanceof KClass) {
                kClass2 = (KClass) classifier;
            } else {
                kClass2 = null;
            }
            if (kClass2 != null) {
                arrayList.add(kClass2);
            } else {
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Object dfs = DFS.dfs(kClass.getSupertypes(), new DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$allSupertypes$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            @NotNull
            public final Iterable<KType> getNeighbors(KType kType) {
                int collectionSizeOrDefault;
                KClassifier classifier = kType.getClassifier();
                KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
                if (kClass2 != null) {
                    List<KType> supertypes = kClass2.getSupertypes();
                    if (kType.getArguments().isEmpty()) {
                        return supertypes;
                    }
                    Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType).getType());
                    List<KType> list = supertypes;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (KType kType2 : list) {
                        Intrinsics.checkNotNull(kType2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                        KotlinType substitute = create.substitute(((KTypeImpl) kType2).getType(), Variance.INVARIANT);
                        if (substitute != null) {
                            Intrinsics.checkNotNullExpressionValue(substitute, "substitutor.substitute((\u2026: $supertype ($current)\")");
                            arrayList.add(new KTypeImpl(substitute, null, 2, null));
                        } else {
                            throw new KotlinReflectionInternalError("Type substitution failed: " + kType2 + " (" + kType + ')');
                        }
                    }
                    return arrayList;
                }
                throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
        }, new DFS.VisitedWithSet(), new DFS.NodeHandlerWithListResult<KType, KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(@NotNull KType current) {
                Intrinsics.checkNotNullParameter(current, "current");
                ((LinkedList) this.result).add(current);
                return true;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(\n        supertypes,\u2026        }\n        }\n    )");
        return (Collection) dfs;
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> kClass) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator<T> it = kClass.getNestedClasses().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                KClass kClass2 = (KClass) obj;
                Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (KClass) obj;
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t16 : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t16;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t16 : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t16;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getDeclaredMembers();
    }

    @NotNull
    public static final KType getDefaultType(@NotNull final KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        SimpleType defaultType = ((KClassImpl) kClass).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(defaultType, new Function0<Type>() { // from class: kotlin.reflect.full.KClasses$defaultType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Type invoke() {
                return ((KClassImpl) kClass).getJClass();
            }
        });
    }

    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallable<?>> members = kClass.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t16 : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t16;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof KProperty2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KFunction)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().invoke().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t16 : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t16;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> kClass) {
        T t16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator<T> it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                KFunction kFunction = (KFunction) t16;
                Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
                FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
                Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
                if (((ConstructorDescriptor) descriptor).isPrimary()) {
                    break;
                }
            } else {
                t16 = null;
                break;
            }
        }
        return (KFunction) t16;
    }

    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> kClass) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().invoke()).getAllStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty0)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> kClass) {
        KClass kClass2;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            KClassifier classifier = ((KType) it.next()).getClassifier();
            if (classifier instanceof KClass) {
                kClass2 = (KClass) classifier;
            } else {
                kClass2 = null;
            }
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        if (kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null) {
            return true;
        }
        return false;
    }

    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSubclassOf(@NotNull KClass<?> kClass, @NotNull final KClass<?> base) {
        List listOf;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        if (!Intrinsics.areEqual(kClass, base)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(kClass);
            final KClasses$isSubclassOf$1 kClasses$isSubclassOf$1 = new PropertyReference1() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$1
                @Override // kotlin.reflect.KProperty1
                @Nullable
                public Object get(@Nullable Object obj) {
                    return KClasses.getSuperclasses((KClass) obj);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                @NotNull
                public String getName() {
                    return "superclasses";
                }

                @Override // kotlin.jvm.internal.CallableReference
                @NotNull
                public KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
                }

                @Override // kotlin.jvm.internal.CallableReference
                @NotNull
                public String getSignature() {
                    return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
                }
            };
            Boolean ifAny = DFS.ifAny(listOf, new DFS.Neighbors(kClasses$isSubclassOf$1) { // from class: kotlin.reflect.full.KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0
                private final /* synthetic */ Function1 function;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Intrinsics.checkNotNullParameter(kClasses$isSubclassOf$1, "function");
                    this.function = kClasses$isSubclassOf$1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                public final /* synthetic */ Iterable getNeighbors(Object obj) {
                    return (Iterable) this.function.invoke(obj);
                }
            }, new Function1<KClass<?>, Boolean>() { // from class: kotlin.reflect.full.KClasses$isSubclassOf$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(KClass<?> kClass2) {
                    return Boolean.valueOf(Intrinsics.areEqual(kClass2, base));
                }
            });
            Intrinsics.checkNotNullExpressionValue(ifAny, "base: KClass<*>): Boolea\u2026erclasses) { it == base }");
            if (!ifAny.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(@NotNull KClass<?> kClass, @NotNull KClass<?> derived) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(derived, "derived");
        return isSubclassOf(derived, kClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final <T> T safeCast(@NotNull KClass<T> kClass, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (kClass.isInstance(obj)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
            return obj;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass kClass) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass kClass) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass kClass) {
    }
}
