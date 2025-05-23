package kotlin.collections;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b\u001a\u001f\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b\u00a2\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b\u00a2\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b\u00a2\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b\u00a2\u0006\u0002\u0010\u0017\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u000bH\u0007\u00a2\u0006\u0002\u0010\u001c\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u000b0\u0010\"\u0004\u0018\u0001H\u000bH\u0007\u00a2\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0000\u001a!\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001f"}, d2 = {"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "setOfNotNull", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes28.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> buildSet(@BuilderInference Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        builderAction.invoke(createSetBuilder);
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return build;
    }

    @NotNull
    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Set<T> optimizeReadOnlySet(@NotNull Set<? extends T> set) {
        Set<T> emptySet;
        Set<T> of5;
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size == 0) {
            emptySet = emptySet();
            return emptySet;
        }
        if (size == 1) {
            of5 = SetsKt__SetsJVMKt.setOf(set.iterator().next());
            return of5;
        }
        return set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        Set<T> emptySet;
        if (set == 0) {
            emptySet = emptySet();
            return emptySet;
        }
        return set;
    }

    @NotNull
    public static <T> Set<T> setOf(@NotNull T... elements) {
        Set<T> emptySet;
        Set<T> set;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length <= 0) {
            emptySet = emptySet();
            return emptySet;
        }
        set = ArraysKt___ArraysKt.toSet(elements);
        return set;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@Nullable T t16) {
        Set<T> emptySet;
        Set<T> of5;
        if (t16 != null) {
            of5 = SetsKt__SetsJVMKt.setOf(t16);
            return of5;
        }
        emptySet = emptySet();
        return emptySet;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> Set<E> buildSet(int i3, @BuilderInference Function1<? super Set<E>, Unit> builderAction) {
        Set createSetBuilder;
        Set<E> build;
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder(i3);
        builderAction.invoke(createSetBuilder);
        build = SetsKt__SetsJVMKt.build(createSetBuilder);
        return build;
    }

    @NotNull
    public static <T> HashSet<T> hashSetOf(@NotNull T... elements) {
        int mapCapacity;
        Collection collection;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        collection = ArraysKt___ArraysKt.toCollection(elements, new HashSet(mapCapacity));
        return (HashSet) collection;
    }

    @NotNull
    public static <T> LinkedHashSet<T> linkedSetOf(@NotNull T... elements) {
        int mapCapacity;
        Collection collection;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        collection = ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
        return (LinkedHashSet) collection;
    }

    @NotNull
    public static <T> Set<T> mutableSetOf(@NotNull T... elements) {
        int mapCapacity;
        Collection collection;
        Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(elements.length);
        collection = ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(mapCapacity));
        return (Set) collection;
    }

    @InlineOnly
    private static final <T> Set<T> setOf() {
        Set<T> emptySet;
        emptySet = emptySet();
        return emptySet;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet());
    }
}
