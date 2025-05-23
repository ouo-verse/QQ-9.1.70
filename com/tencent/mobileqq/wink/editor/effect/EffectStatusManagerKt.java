package com.tencent.mobileqq.wink.editor.effect;

import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002*\u0016\u0010\u0007\"\b\u0012\u0004\u0012\u00020\u00010\u00062\b\u0012\u0004\u0012\u00020\u00010\u0006*\u0016\u0010\t\"\b\u0012\u0004\u0012\u00020\u0001`\b2\b\u0012\u0004\u0012\u00020\u00010\u0000* \u0010\n\"\b\u0012\u0004\u0012\u0002`\u00020\u00062\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectTimeline;", "b", "", "c", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "AppliedEffectNode", "Lkotlin/collections/ArrayList;", "EffectTimeline", "TimelineNode", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class EffectStatusManagerKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((EffectStatusManager.AppliedEffect) t16).getStartOffsetUs()), Long.valueOf(((EffectStatusManager.AppliedEffect) t17).getStartOffsetUs()));
            return compareValues;
        }
    }

    public static final /* synthetic */ ArrayList a(ArrayList arrayList) {
        return b(arrayList);
    }

    public static final ArrayList<EffectStatusManager.AppliedEffect> b(ArrayList<EffectStatusManager.AppliedEffect> arrayList) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(EffectStatusManager.AppliedEffect.e((EffectStatusManager.AppliedEffect) it.next(), 0L, null, 0L, 0L, null, null, 0, 0, false, null, 1023, null));
        }
        return new ArrayList<>(arrayList2);
    }

    @NotNull
    public static final String c(@NotNull ArrayList<EffectStatusManager.AppliedEffect> arrayList) {
        List sortedWith;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "", null, null, 0, null, new Function1<EffectStatusManager.AppliedEffect, CharSequence>() { // from class: com.tencent.mobileqq.wink.editor.effect.EffectStatusManagerKt$toGraphString$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull EffectStatusManager.AppliedEffect it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "|->" + it.getStartOffsetUs() + " " + it.getName() + " " + it.i() + "<-|";
            }
        }, 30, null);
        return joinToString$default;
    }
}
