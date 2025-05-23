package com.tencent.mobileqq.wink.editor.effect;

import androidx.annotation.ColorInt;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003\u0014#8B\u0017\u0012\u0006\u00102\u001a\u00020\u0018\u0012\u0006\u00107\u001a\u000203\u00a2\u0006\u0004\bD\u0010EJ$\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\u0002`\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\nH\u0002J3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005H\u0002J,\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0002Jf\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\"2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b2\u0006\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u0018J6\u0010$\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\"2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ&\u0010)\u001a\"\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010(J\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\bR\"\u00102\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00107\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u00106R*\u0010:\u001a\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\u0002`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R \u0010;\u001a\f\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00109R*\u0010<\u001a\u0016\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002j\u0002`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00109R \u0010>\u001a\f\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0011\u0010B\u001a\u00020?8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010C\u001a\u00020?8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager;", "", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectTimeline;", "Lcom/tencent/mobileqq/wink/editor/effect/TimelineNode;", "timelineNode", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/effect/AppliedEffectNode;", "actionNode", "l", "T", "curNode", "t", "k", "(Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;Ljava/lang/Object;)Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "appliedEffect", "timeline", "a", DomainData.DOMAIN_NAME, "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "startOffsetUs", "duration", "", "path", "name", "", HippyQQPagViewController.PropertyName.SCALE_MODE, "color", "appliedEffectID", "Lkotlin/Pair;", "b", "e", "p", "o", "j", "Lkotlin/Triple;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "r", "d", "J", "i", "()J", "setTotalDuration", "(J)V", "totalDuration", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "getEffectType", "()Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", AIAbilityModel.AI_KEY, "c", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "savedTimelineNode", "savedActionNode", "currentTimelineNode", "f", "currentActionNode", "", "g", "()Z", "canUndo", "canRedo", "<init>", "(JLcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class EffectStatusManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long totalDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEffectCatType effectType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c<ArrayList<AppliedEffect>> savedTimelineNode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c<AppliedEffect> savedActionNode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c<ArrayList<AppliedEffect>> currentTimelineNode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c<AppliedEffect> currentActionNode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0011J\u0014\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\b\u0007J\u001f\u0010\f\u001a\u00020\u00042\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\u0002\b\u0007R\"\u0010\u0012\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "T", "", "node", "", "f", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "copy", "a", "", "toString", "g", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", tl.h.F, "(Ljava/lang/Object;)V", "data", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "e", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;", "setPrev", "(Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$c;)V", "prev", "c", "d", "setNext", "next", "headNode", "<init>", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private T data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c<T> prev;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c<T> next;

        public c(T t16) {
            this.data = t16;
        }

        @NotNull
        public final c<T> a(@NotNull Function1<? super T, ? extends T> copy) {
            Intrinsics.checkNotNullParameter(copy, "copy");
            c<T> c16 = c();
            c<T> cVar = new c<>(copy.invoke(c16.data));
            c<T> cVar2 = cVar;
            while (true) {
                c<T> cVar3 = c16.next;
                if (cVar3 != null) {
                    Intrinsics.checkNotNull(cVar3);
                    cVar2.f(new c<>(copy.invoke(cVar3.data)));
                    c16 = c16.next;
                    Intrinsics.checkNotNull(c16);
                    cVar2 = cVar2.next;
                    Intrinsics.checkNotNull(cVar2);
                    if (this == c16) {
                        cVar = cVar2;
                    }
                } else {
                    return cVar;
                }
            }
        }

        public final T b() {
            return this.data;
        }

        @NotNull
        public final c<T> c() {
            c<T> cVar = this;
            while (true) {
                c<T> cVar2 = cVar.prev;
                if (cVar2 != null) {
                    Intrinsics.checkNotNull(cVar2);
                    cVar = cVar2;
                } else {
                    return cVar;
                }
            }
        }

        @Nullable
        public final c<T> d() {
            return this.next;
        }

        @Nullable
        public final c<T> e() {
            return this.prev;
        }

        public final void f(@NotNull c<T> node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.next = node;
            node.prev = this;
        }

        public final void g(@NotNull Function1<? super T, String> toString) {
            Intrinsics.checkNotNullParameter(toString, "toString");
            for (c<T> c16 = c(); c16 != null; c16 = c16.next) {
                ms.a.a("effectTest", "printLinkNode: " + ((Object) toString.invoke(c16.data)));
            }
        }

        public final void h(T t16) {
            this.data = t16;
        }
    }

    public EffectStatusManager(long j3, @NotNull WinkEffectCatType effectType) {
        Intrinsics.checkNotNullParameter(effectType, "effectType");
        this.totalDuration = j3;
        this.effectType = effectType;
        this.savedTimelineNode = new c<>(new ArrayList());
        AppliedEffect.Companion companion = AppliedEffect.INSTANCE;
        this.savedActionNode = new c<>(companion.b());
        this.currentTimelineNode = new c<>(new ArrayList());
        this.currentActionNode = new c<>(companion.b());
    }

    private final ArrayList<AppliedEffect> a(AppliedEffect appliedEffect, ArrayList<AppliedEffect> timeline) {
        ArrayList<AppliedEffect> arrayList;
        if (timeline == null || (arrayList = EffectStatusManagerKt.a(timeline)) == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<AppliedEffect> n3 = n(appliedEffect, arrayList);
        this.currentTimelineNode = k(this.currentTimelineNode, EffectStatusManagerKt.a(n3));
        this.currentActionNode = k(this.currentActionNode, AppliedEffect.e(appliedEffect, 0L, null, 0L, 0L, null, null, 0, 0, false, null, 1023, null));
        return EffectStatusManagerKt.a(n3);
    }

    public static /* synthetic */ Pair c(EffectStatusManager effectStatusManager, String str, long j3, long j16, List list, String str2, int i3, int i16, long j17, int i17, Object obj) {
        int i18;
        long j18;
        if ((i17 & 32) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        if ((i17 & 128) != 0) {
            j18 = AppliedEffect.INSTANCE.a();
        } else {
            j18 = j17;
        }
        return effectStatusManager.b(str, j3, j16, list, str2, i18, i16, j18);
    }

    private final <T> c<T> k(c<T> curNode, T t16) {
        c<T> cVar = new c<>(t16);
        if (curNode != null) {
            curNode.f(cVar);
        }
        return cVar;
    }

    private final void l(c<AppliedEffect> actionNode) {
        if (actionNode.b().getStartOffsetUs() > this.totalDuration) {
            actionNode.h(new AppliedEffect(AppliedEffect.INSTANCE.a(), null, 0L, 0L, null, null, 0, 0, false, this.effectType, 510, null));
        } else if (actionNode.b().getStartOffsetUs() + actionNode.b().getDurationUs() > this.totalDuration) {
            actionNode.b().r(this.totalDuration - actionNode.b().getStartOffsetUs());
        }
    }

    private final void m(c<ArrayList<AppliedEffect>> timelineNode) {
        Iterator<AppliedEffect> it = timelineNode.b().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "timelineNode.data.iterator()");
        while (it.hasNext()) {
            AppliedEffect next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            AppliedEffect appliedEffect = next;
            if (appliedEffect.getStartOffsetUs() > this.totalDuration) {
                it.remove();
            } else {
                long startOffsetUs = appliedEffect.getStartOffsetUs() + appliedEffect.getDurationUs();
                long j3 = this.totalDuration;
                if (startOffsetUs > j3) {
                    appliedEffect.r(j3 - appliedEffect.getStartOffsetUs());
                }
            }
        }
    }

    private final ArrayList<AppliedEffect> n(AppliedEffect appliedEffect, ArrayList<AppliedEffect> timeline) {
        ArrayList<AppliedEffect> arrayList = new ArrayList<>();
        for (AppliedEffect appliedEffect2 : timeline) {
            if (appliedEffect2.getStartOffsetUs() < appliedEffect.getStartOffsetUs() || appliedEffect2.getStopOffsetUs() > appliedEffect.getStopOffsetUs()) {
                if (appliedEffect2.getStartOffsetUs() <= appliedEffect.getStartOffsetUs() && appliedEffect2.getStopOffsetUs() > appliedEffect.getStartOffsetUs() && appliedEffect2.getStopOffsetUs() <= appliedEffect.getStopOffsetUs()) {
                    arrayList.add(AppliedEffect.e(appliedEffect2, 0L, null, appliedEffect2.getStartOffsetUs(), appliedEffect.getStartOffsetUs() - appliedEffect2.getStartOffsetUs(), null, null, 0, 0, false, null, 1011, null));
                } else if (appliedEffect2.getStartOffsetUs() >= appliedEffect.getStartOffsetUs() && appliedEffect2.getStartOffsetUs() < appliedEffect.getStopOffsetUs() && appliedEffect2.getStopOffsetUs() >= appliedEffect.getStopOffsetUs()) {
                    arrayList.add(AppliedEffect.e(appliedEffect2, 0L, null, appliedEffect.getStopOffsetUs(), appliedEffect2.getStopOffsetUs() - appliedEffect.getStopOffsetUs(), null, null, 0, 0, false, null, 1011, null));
                } else if (appliedEffect2.getStartOffsetUs() < appliedEffect.getStartOffsetUs() && appliedEffect2.getStopOffsetUs() > appliedEffect.getStopOffsetUs()) {
                    arrayList.add(AppliedEffect.e(appliedEffect2, 0L, null, appliedEffect2.getStartOffsetUs(), appliedEffect.getStartOffsetUs() - appliedEffect2.getStartOffsetUs(), null, null, 0, 0, false, null, 1011, null));
                    arrayList.add(AppliedEffect.e(appliedEffect2, AppliedEffect.INSTANCE.a(), null, appliedEffect.getStopOffsetUs(), appliedEffect2.getStopOffsetUs() - appliedEffect.getStopOffsetUs(), null, null, 0, 0, false, null, 1010, null));
                } else {
                    arrayList.add(appliedEffect2);
                }
            }
        }
        arrayList.add(appliedEffect);
        return arrayList;
    }

    @NotNull
    public final Pair<AppliedEffect, ArrayList<AppliedEffect>> b(@NotNull String materialId, long startOffsetUs, long duration, @NotNull List<String> path, @NotNull String name, int scaleMode, int color, long appliedEffectID) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        AppliedEffect appliedEffect = new AppliedEffect(appliedEffectID, materialId, startOffsetUs, duration, path, name, scaleMode, color, false, this.effectType, 256, null);
        ms.a.a("effectTest", "applyEffect " + appliedEffect + ", " + this.totalDuration);
        return TuplesKt.to(appliedEffect, a(appliedEffect, this.currentTimelineNode.b()));
    }

    public final void d() {
        this.currentTimelineNode = new c<>(new ArrayList());
        this.currentActionNode = new c<>(AppliedEffect.INSTANCE.b());
    }

    @NotNull
    public final Pair<AppliedEffect, ArrayList<AppliedEffect>> e(long appliedEffectID, long startOffsetUs, long duration) {
        Object obj;
        boolean z16;
        ArrayList<AppliedEffect> a16 = EffectStatusManagerKt.a(this.currentTimelineNode.b());
        Iterator<T> it = a16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((AppliedEffect) obj).getId() == appliedEffectID) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        AppliedEffect appliedEffect = (AppliedEffect) obj;
        if (appliedEffect == null) {
            return TuplesKt.to(null, a16);
        }
        a16.remove(appliedEffect);
        AppliedEffect e16 = AppliedEffect.e(appliedEffect, 0L, null, startOffsetUs, duration, null, null, 0, 0, false, null, 1011, null);
        ArrayList<AppliedEffect> n3 = n(e16, a16);
        this.currentTimelineNode = k(this.currentTimelineNode, EffectStatusManagerKt.a(n3));
        this.currentActionNode = k(this.currentActionNode, AppliedEffect.e(e16, 0L, null, 0L, 0L, null, null, 0, 0, false, null, 1023, null));
        return TuplesKt.to(e16, EffectStatusManagerKt.a(n3));
    }

    public final boolean f() {
        if (this.currentTimelineNode.d() != null) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.currentTimelineNode.e() != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<AppliedEffect> h() {
        return EffectStatusManagerKt.a(this.currentTimelineNode.b());
    }

    /* renamed from: i, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final void j() {
        this.currentTimelineNode.g(new Function1<ArrayList<AppliedEffect>, String>() { // from class: com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$printCurrentStatusLinkList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull ArrayList<EffectStatusManager.AppliedEffect> print) {
                String joinToString$default;
                Intrinsics.checkNotNullParameter(print, "$this$print");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(print, null, null, null, 0, null, null, 63, null);
                return joinToString$default;
            }
        });
    }

    public final void o() {
        this.currentTimelineNode = this.savedTimelineNode;
        this.currentActionNode = this.savedActionNode;
    }

    public final void p() {
        this.savedTimelineNode = this.currentTimelineNode.a(EffectStatusManager$saveAndMarkStatusLinkList$1.INSTANCE);
        this.savedActionNode = this.currentActionNode.a(new Function1<AppliedEffect, AppliedEffect>() { // from class: com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$saveAndMarkStatusLinkList$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final EffectStatusManager.AppliedEffect invoke(@NotNull EffectStatusManager.AppliedEffect copy) {
                Intrinsics.checkNotNullParameter(copy, "$this$copy");
                return EffectStatusManager.AppliedEffect.e(copy, 0L, null, 0L, 0L, null, null, 0, 0, false, null, 1023, null);
            }
        });
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    @org.jetbrains.annotations.Nullable
    public final kotlin.Triple<java.util.ArrayList<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect>, com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect, com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect> q() {
        /*
            r21 = this;
            r0 = r21
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a> r1 = r0.currentActionNode
            java.lang.Object r1 = r1.b()
            r2 = r1
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a r2 = (com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect) r2
            r3 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1023(0x3ff, float:1.434E-42)
            r17 = 0
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a r1 = com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect.e(r2, r3, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<java.util.ArrayList<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a>> r2 = r0.currentTimelineNode
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c r2 = r2.e()
            r3 = 0
            if (r2 == 0) goto L86
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<java.util.ArrayList<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a>> r2 = r0.currentTimelineNode
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c r2 = r2.e()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.currentTimelineNode = r2
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a> r2 = r0.currentActionNode
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c r2 = r2.e()
            if (r2 == 0) goto L86
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a> r2 = r0.currentActionNode
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c r2 = r2.e()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.currentActionNode = r2
            java.lang.Object r2 = r2.b()
            r4 = r2
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a r4 = (com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect) r4
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$c<java.util.ArrayList<com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a>> r2 = r0.currentTimelineNode
            java.lang.Object r2 = r2.b()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.ArrayList r2 = com.tencent.mobileqq.wink.editor.effect.EffectStatusManagerKt.a(r2)
            kotlin.Triple r15 = new kotlin.Triple
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a$a r5 = com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect.INSTANCE
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a r5 = r5.b()
            if (r4 != r5) goto L66
            r4 = r15
            goto L82
        L66:
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r3 = 0
            r16 = 0
            r17 = 0
            r18 = 1023(0x3ff, float:1.434E-42)
            r19 = 0
            r20 = r15
            r15 = r3
            com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a r3 = com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.AppliedEffect.e(r4, r5, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19)
            r4 = r20
        L82:
            r4.<init>(r2, r1, r3)
            return r4
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.wink.editor.effect.EffectStatusManager.q():kotlin.Triple");
    }

    public final void r(long duration) {
        ms.a.a("effectTest", "updateTotalDuration " + duration);
        this.totalDuration = duration;
        for (c<ArrayList<AppliedEffect>> c16 = this.currentTimelineNode.c(); c16 != null; c16 = c16.d()) {
            m(c16);
        }
        for (c<AppliedEffect> c17 = this.currentActionNode.c(); c17 != null; c17 = c17.d()) {
            l(c17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\u0017Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0003\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b:\u0010;Js\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\"R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\"R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\r\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b)\u0010-R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b.\u00106R\u0017\u00108\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b7\u0010\u001aR\u0011\u00109\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u001a\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "", "", "id", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "startOffsetUs", "durationUs", "", "path", "name", "", HippyQQPagViewController.PropertyName.SCALE_MODE, "color", "", "temporary", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", AIAbilityModel.AI_KEY, "d", "toString", "hashCode", "other", "equals", "a", "J", "j", "()J", "b", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "c", "o", "setStartOffsetUs", "(J)V", "g", "r", "e", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", "f", "l", "I", DomainData.DOMAIN_NAME, "()I", tl.h.F, "i", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "()Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "p", "stopOffsetUs", "endTime", "<init>", "(JLjava/lang/String;JJLjava/util/List;Ljava/lang/String;IIZLcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AppliedEffect {

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: m, reason: collision with root package name */
        @NotNull
        private static final AppliedEffect f319977m = new AppliedEffect(0, null, 0, 0, null, null, 0, 0, false, null, 1022, null);

        /* renamed from: n, reason: collision with root package name */
        private static long f319978n = 1;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String materialId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private long startOffsetUs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long durationUs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> path;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int scaleMode;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean temporary;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkEffectCatType effectType;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final long stopOffsetUs;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a$a;", "", "", "a", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", PatternUtils.NO_MATCH, "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "b", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "appliedEffectIDRecord", "J", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.editor.effect.EffectStatusManager$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes21.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final long a() {
                long j3 = AppliedEffect.f319978n;
                AppliedEffect.f319978n++;
                return j3;
            }

            @NotNull
            public final AppliedEffect b() {
                return AppliedEffect.f319977m;
            }

            Companion() {
            }
        }

        public AppliedEffect(long j3, @NotNull String materialId, long j16, long j17, @NotNull List<String> path, @NotNull String name, int i3, @ColorInt int i16, boolean z16, @NotNull WinkEffectCatType effectType) {
            Intrinsics.checkNotNullParameter(materialId, "materialId");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(effectType, "effectType");
            this.id = j3;
            this.materialId = materialId;
            this.startOffsetUs = j16;
            this.durationUs = j17;
            this.path = path;
            this.name = name;
            this.scaleMode = i3;
            this.color = i16;
            this.temporary = z16;
            this.effectType = effectType;
            this.stopOffsetUs = j16 + j17;
        }

        public static /* synthetic */ AppliedEffect e(AppliedEffect appliedEffect, long j3, String str, long j16, long j17, List list, String str2, int i3, int i16, boolean z16, WinkEffectCatType winkEffectCatType, int i17, Object obj) {
            long j18;
            String str3;
            long j19;
            long j26;
            List list2;
            String str4;
            int i18;
            int i19;
            boolean z17;
            WinkEffectCatType winkEffectCatType2;
            if ((i17 & 1) != 0) {
                j18 = appliedEffect.id;
            } else {
                j18 = j3;
            }
            if ((i17 & 2) != 0) {
                str3 = appliedEffect.materialId;
            } else {
                str3 = str;
            }
            if ((i17 & 4) != 0) {
                j19 = appliedEffect.startOffsetUs;
            } else {
                j19 = j16;
            }
            if ((i17 & 8) != 0) {
                j26 = appliedEffect.durationUs;
            } else {
                j26 = j17;
            }
            if ((i17 & 16) != 0) {
                list2 = appliedEffect.path;
            } else {
                list2 = list;
            }
            if ((i17 & 32) != 0) {
                str4 = appliedEffect.name;
            } else {
                str4 = str2;
            }
            if ((i17 & 64) != 0) {
                i18 = appliedEffect.scaleMode;
            } else {
                i18 = i3;
            }
            if ((i17 & 128) != 0) {
                i19 = appliedEffect.color;
            } else {
                i19 = i16;
            }
            if ((i17 & 256) != 0) {
                z17 = appliedEffect.temporary;
            } else {
                z17 = z16;
            }
            if ((i17 & 512) != 0) {
                winkEffectCatType2 = appliedEffect.effectType;
            } else {
                winkEffectCatType2 = winkEffectCatType;
            }
            return appliedEffect.d(j18, str3, j19, j26, list2, str4, i18, i19, z17, winkEffectCatType2);
        }

        @NotNull
        public final AppliedEffect d(long id5, @NotNull String materialId, long startOffsetUs, long durationUs, @NotNull List<String> path, @NotNull String name, int scaleMode, @ColorInt int color, boolean temporary, @NotNull WinkEffectCatType effectType) {
            Intrinsics.checkNotNullParameter(materialId, "materialId");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(effectType, "effectType");
            return new AppliedEffect(id5, materialId, startOffsetUs, durationUs, path, name, scaleMode, color, temporary, effectType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppliedEffect)) {
                return false;
            }
            AppliedEffect appliedEffect = (AppliedEffect) other;
            if (this.id == appliedEffect.id && Intrinsics.areEqual(this.materialId, appliedEffect.materialId) && this.startOffsetUs == appliedEffect.startOffsetUs && this.durationUs == appliedEffect.durationUs && Intrinsics.areEqual(this.path, appliedEffect.path) && Intrinsics.areEqual(this.name, appliedEffect.name) && this.scaleMode == appliedEffect.scaleMode && this.color == appliedEffect.color && this.temporary == appliedEffect.temporary && this.effectType == appliedEffect.effectType) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: g, reason: from getter */
        public final long getDurationUs() {
            return this.durationUs;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final WinkEffectCatType getEffectType() {
            return this.effectType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((((((((((androidx.fragment.app.a.a(this.id) * 31) + this.materialId.hashCode()) * 31) + androidx.fragment.app.a.a(this.startOffsetUs)) * 31) + androidx.fragment.app.a.a(this.durationUs)) * 31) + this.path.hashCode()) * 31) + this.name.hashCode()) * 31) + this.scaleMode) * 31) + this.color) * 31;
            boolean z16 = this.temporary;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((a16 + i3) * 31) + this.effectType.hashCode();
        }

        public final long i() {
            return this.startOffsetUs + this.durationUs;
        }

        /* renamed from: j, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: k, reason: from getter */
        public final String getMaterialId() {
            return this.materialId;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final List<String> m() {
            return this.path;
        }

        /* renamed from: n, reason: from getter */
        public final int getScaleMode() {
            return this.scaleMode;
        }

        /* renamed from: o, reason: from getter */
        public final long getStartOffsetUs() {
            return this.startOffsetUs;
        }

        /* renamed from: p, reason: from getter */
        public final long getStopOffsetUs() {
            return this.stopOffsetUs;
        }

        /* renamed from: q, reason: from getter */
        public final boolean getTemporary() {
            return this.temporary;
        }

        public final void r(long j3) {
            this.durationUs = j3;
        }

        public final void s(boolean z16) {
            this.temporary = z16;
        }

        @NotNull
        public String toString() {
            return "AppliedEffect(id=" + this.id + ", materialId=" + this.materialId + ", startOffsetUs=" + this.startOffsetUs + ", durationUs=" + this.durationUs + ", path=" + this.path + ", name=" + this.name + ", scaleMode=" + this.scaleMode + ", color=" + this.color + ", temporary=" + this.temporary + ", effectType=" + this.effectType + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ AppliedEffect(long j3, String str, long j16, long j17, List list, String str2, int i3, int i16, boolean z16, WinkEffectCatType winkEffectCatType, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, r6, r7, r9, r11, (i17 & 32) != 0 ? "" : str2, (i17 & 64) != 0 ? 0 : i3, (i17 & 128) != 0 ? 0 : i16, (i17 & 256) != 0 ? false : z16, (i17 & 512) != 0 ? WinkEffectCatType.TypeScreen : winkEffectCatType);
            List list2;
            List emptyList;
            String str3 = (i17 & 2) != 0 ? "" : str;
            long j18 = (i17 & 4) != 0 ? 0L : j16;
            long j19 = (i17 & 8) != 0 ? 0L : j17;
            if ((i17 & 16) != 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list2 = emptyList;
            } else {
                list2 = list;
            }
        }
    }
}
