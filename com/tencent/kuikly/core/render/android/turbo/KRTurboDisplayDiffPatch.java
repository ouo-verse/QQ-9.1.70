package com.tencent.kuikly.core.render.android.turbo;

import android.graphics.RectF;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u00104\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b8\u00109J$\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0013\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0002J6\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u001e0!2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002J\"\u0010+\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0002J\u0016\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00103R\u0016\u00107\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayDiffPatch;", "", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "oldNode", "newNode", "", "fromUpdateNode", "a", "oldValue", "newValue", "e", "", "propKey", "d", "node", "Lcom/tencent/kuikly/core/render/android/layer/a;", "renderLayerHandler", "", "b", h.F, "curNode", "hasParent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "shadow", "i", "", "list", "j", "fromChildren", "", "fromIndex", "targetNode", "Lkotlin/Pair;", "f", "fromNode", "k", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "prop", "fromProp", "l", "oldNodeTree", "newNodeTree", "c", "targetNodeTree", "fromNodeTree", "g", "", "Ljava/util/Set;", "baseAttrKeySet", "Lcom/tencent/kuikly/core/render/android/b;", "Lcom/tencent/kuikly/core/render/android/b;", AssetExtension.SCENE_EXPORT, "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "renderViewContext", "<init>", "(Lcom/tencent/kuikly/core/render/android/b;Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayDiffPatch {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<String> baseAttrKeySet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.b export;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a renderViewContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayDiffPatch$a;", "", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayDiffPatch$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRTurboDisplayDiffPatch(@NotNull com.tencent.kuikly.core.render.android.b export, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        Intrinsics.checkNotNullParameter(export, "export");
        this.export = export;
        this.renderViewContext = aVar;
        this.baseAttrKeySet = KRCSSViewExtensionKt.e();
    }

    private final boolean a(KRTurboDisplayNode oldNode, KRTurboDisplayNode newNode, boolean fromUpdateNode) {
        if (oldNode == null || newNode == null || (!Intrinsics.areEqual(oldNode.getViewName(), newNode.getViewName())) || oldNode.m().size() != newNode.m().size()) {
            return false;
        }
        int size = newNode.m().size();
        for (int i3 = 0; i3 < size; i3++) {
            KRTurboDisplayProp kRTurboDisplayProp = oldNode.m().get(i3);
            KRTurboDisplayProp kRTurboDisplayProp2 = newNode.m().get(i3);
            if ((!Intrinsics.areEqual(kRTurboDisplayProp.getPropKey(), kRTurboDisplayProp2.getPropKey())) || kRTurboDisplayProp.getPropType() != kRTurboDisplayProp2.getPropType()) {
                return false;
            }
            if (kRTurboDisplayProp.getPropType() == 0) {
                if (fromUpdateNode && Intrinsics.areEqual(kRTurboDisplayProp.getPropKey(), "turboDisplayAutoUpdateEnable") && kRTurboDisplayProp2.getPropValue() != null) {
                    Object propValue = kRTurboDisplayProp2.getPropValue();
                    if (propValue != null) {
                        if (((Integer) propValue).intValue() != 1) {
                            return false;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                if (!fromUpdateNode && !d(kRTurboDisplayProp.getPropKey()) && !e(kRTurboDisplayProp.getPropValue(), kRTurboDisplayProp2.getPropValue())) {
                    return false;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int size2 = newNode.g().size();
        for (int i16 = 0; i16 < size2; i16++) {
            KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod = newNode.g().get(i16);
            if (kRTurboDisplayNodeMethod.getType() == 0) {
                arrayList.add(kRTurboDisplayNodeMethod);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size3 = oldNode.g().size();
        for (int i17 = 0; i17 < size3; i17++) {
            KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod2 = oldNode.g().get(i17);
            if (kRTurboDisplayNodeMethod2.getType() == 0) {
                arrayList2.add(kRTurboDisplayNodeMethod2);
            }
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        int size4 = arrayList.size();
        for (int i18 = 0; i18 < size4; i18++) {
            KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod3 = (KRTurboDisplayNodeMethod) arrayList2.get(i18);
            KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod4 = (KRTurboDisplayNodeMethod) arrayList.get(i18);
            if ((!Intrinsics.areEqual(kRTurboDisplayNodeMethod3.getMethod(), kRTurboDisplayNodeMethod4.getMethod())) || !e(kRTurboDisplayNodeMethod3.getParams(), kRTurboDisplayNodeMethod4.getParams())) {
                return false;
            }
        }
        return true;
    }

    private final void b(KRTurboDisplayNode node, com.tencent.kuikly.core.render.android.layer.a renderLayerHandler) {
        if (node == null) {
            return;
        }
        if (node.getTag() == -1) {
            for (KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod : node.g()) {
                if (kRTurboDisplayNodeMethod.getType() == 1) {
                    renderLayerHandler.f(kRTurboDisplayNodeMethod.getName(), kRTurboDisplayNodeMethod.getMethod(), kRTurboDisplayNodeMethod.getParams(), kRTurboDisplayNodeMethod.b());
                }
            }
        } else {
            renderLayerHandler.s(node.getTag(), node.getViewName());
        }
        m(null, node, renderLayerHandler, false);
        if (node.s()) {
            Iterator<KRTurboDisplayNode> it = node.j().iterator();
            while (it.hasNext()) {
                b(it.next(), renderLayerHandler);
            }
        }
    }

    private final boolean d(String propKey) {
        return this.baseAttrKeySet.contains(propKey);
    }

    private final boolean e(Object oldValue, Object newValue) {
        if (Intrinsics.areEqual(oldValue, newValue)) {
            return true;
        }
        if (oldValue instanceof String) {
            if (newValue == null) {
                return false;
            }
            return Intrinsics.areEqual(oldValue, newValue);
        }
        if (!(oldValue instanceof Integer) && !(oldValue instanceof Float) && !(oldValue instanceof Long) && !(oldValue instanceof Double)) {
            return Intrinsics.areEqual(oldValue, newValue);
        }
        if (newValue == null) {
            return false;
        }
        return Intrinsics.areEqual(oldValue, newValue);
    }

    private final Pair<KRTurboDisplayNode, Integer> f(List<KRTurboDisplayNode> fromChildren, int fromIndex, KRTurboDisplayNode targetNode) {
        if (fromChildren == null) {
            return new Pair<>(null, Integer.valueOf(fromIndex));
        }
        for (int i3 = fromIndex; i3 < fromChildren.size(); i3++) {
            KRTurboDisplayNode kRTurboDisplayNode = fromChildren.get(i3);
            if (kRTurboDisplayNode.getTag() == targetNode.getTag()) {
                return new Pair<>(kRTurboDisplayNode, Integer.valueOf(i3));
            }
        }
        if (fromChildren.size() > fromIndex) {
            return new Pair<>(fromChildren.get(fromIndex), Integer.valueOf(fromIndex));
        }
        return new Pair<>(null, Integer.valueOf(fromIndex));
    }

    private final void h(KRTurboDisplayNode node, com.tencent.kuikly.core.render.android.layer.a renderLayerHandler) {
        if (node == null) {
            return;
        }
        renderLayerHandler.u(node.getTag());
        if (node.s()) {
            Iterator<KRTurboDisplayNode> it = node.j().iterator();
            while (it.hasNext()) {
                h(it.next(), renderLayerHandler);
            }
        }
    }

    private final void i(KRTurboDisplayShadow shadow, KRTurboDisplayNode node, com.tencent.kuikly.core.render.android.layer.a renderLayerHandler) {
        i01.b h16 = this.export.h(shadow.getViewName());
        h16.setKuiklyRenderContext(this.renderViewContext);
        for (KRTurboDisplayProp kRTurboDisplayProp : shadow.g()) {
            Object propValue = kRTurboDisplayProp.getPropValue();
            if (propValue != null) {
                h16.b(kRTurboDisplayProp.getPropKey(), propValue);
            }
        }
        h16.c(shadow.getConstraintSize());
        renderLayerHandler.i(node.getTag(), h16);
    }

    private final List<KRTurboDisplayNode> j(List<KRTurboDisplayNode> list) {
        Comparator compareBy;
        List<KRTurboDisplayNode> sortedWith;
        if (list != null) {
            compareBy = ComparisonsKt__ComparisonsKt.compareBy(new Function1<KRTurboDisplayNode, Comparable<?>>() { // from class: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayDiffPatch$sortScrollIndexWithList$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Comparable<?> invoke(@NotNull KRTurboDisplayNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.p());
                }
            }, new Function1<KRTurboDisplayNode, Comparable<?>>() { // from class: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayDiffPatch$sortScrollIndexWithList$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Comparable<?> invoke(@NotNull KRTurboDisplayNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(it.n().left + it.n().top);
                }
            });
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, compareBy);
            return sortedWith;
        }
        return null;
    }

    private final boolean k(KRTurboDisplayNode node, KRTurboDisplayNode fromNode) {
        boolean z16;
        if (!Intrinsics.areEqual(node.getViewName(), fromNode.getViewName())) {
            node.D(fromNode.getViewName());
            z16 = true;
        } else {
            z16 = false;
        }
        if (node.m().size() == fromNode.m().size()) {
            int size = node.m().size();
            for (int i3 = 0; i3 < size; i3++) {
                if (l(node.m().get(i3), fromNode.m().get(i3))) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    private final boolean l(KRTurboDisplayProp prop, KRTurboDisplayProp fromProp) {
        boolean z16;
        if (prop.getPropType() != fromProp.getPropType()) {
            prop.l(fromProp.getPropType());
            z16 = true;
        } else {
            z16 = false;
        }
        if (!e(prop.getPropValue(), fromProp.getPropValue())) {
            prop.m(fromProp.getPropValue());
            return true;
        }
        return z16;
    }

    private final void m(KRTurboDisplayNode curNode, KRTurboDisplayNode newNode, com.tencent.kuikly.core.render.android.layer.a renderLayerHandler, boolean hasParent) {
        int i3;
        int i16;
        int i17;
        int i18;
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod;
        List<KRTurboDisplayNodeMethod> g16;
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod2;
        List<KRTurboDisplayNodeMethod> g17;
        List<KRTurboDisplayNodeMethod> g18;
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod3;
        List<KRTurboDisplayNodeMethod> g19;
        KRTurboDisplayProp kRTurboDisplayProp;
        KRTurboDisplayProp kRTurboDisplayProp2;
        Integer parentTag;
        List<KRTurboDisplayProp> m3;
        List<KRTurboDisplayProp> m16;
        List<KRTurboDisplayProp> m17;
        List<KRTurboDisplayProp> m18;
        if (curNode != null && newNode != null && curNode.getTag() != newNode.getTag()) {
            renderLayerHandler.g(curNode.getTag(), newNode.getTag());
            curNode.C(newNode.getTag());
        }
        if (curNode != null && (m18 = curNode.m()) != null) {
            i3 = m18.size();
        } else {
            i3 = 0;
        }
        if (newNode != null && (m17 = newNode.m()) != null) {
            i16 = m17.size();
        } else {
            i16 = 0;
        }
        int max = Math.max(i3, i16);
        int i19 = 0;
        while (true) {
            Object obj = null;
            if (i19 < max) {
                if (i3 > i19 && curNode != null && (m16 = curNode.m()) != null) {
                    kRTurboDisplayProp = m16.get(i19);
                } else {
                    kRTurboDisplayProp = null;
                }
                if (i16 > i19 && newNode != null && (m3 = newNode.m()) != null) {
                    kRTurboDisplayProp2 = m3.get(i19);
                } else {
                    kRTurboDisplayProp2 = null;
                }
                if (kRTurboDisplayProp2 != null && kRTurboDisplayProp2.getPropType() == 0) {
                    if (kRTurboDisplayProp != null) {
                        obj = kRTurboDisplayProp.getPropValue();
                    }
                    if (!e(obj, kRTurboDisplayProp2.getPropValue())) {
                        Object propValue = kRTurboDisplayProp2.getPropValue();
                        if (newNode != null && propValue != null) {
                            renderLayerHandler.p(newNode.getTag(), kRTurboDisplayProp2.getPropKey(), propValue);
                        }
                    }
                } else if (kRTurboDisplayProp2 != null && kRTurboDisplayProp2.getPropType() == 1) {
                    if (kRTurboDisplayProp != null) {
                        Object propValue2 = kRTurboDisplayProp2.getPropValue();
                        if (propValue2 != null) {
                            kRTurboDisplayProp.k((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue2, 1));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                        }
                    } else {
                        kRTurboDisplayProp2.j();
                    }
                    Object propValue3 = kRTurboDisplayProp2.getPropValue();
                    if (propValue3 != null && newNode != null) {
                        renderLayerHandler.p(newNode.getTag(), kRTurboDisplayProp2.getPropKey(), propValue3);
                    }
                } else if (kRTurboDisplayProp2 != null && kRTurboDisplayProp2.getPropType() == 2) {
                    if (kRTurboDisplayProp != null) {
                        obj = kRTurboDisplayProp.getPropValue();
                    }
                    if ((obj == null || !Intrinsics.areEqual(kRTurboDisplayProp.getPropValue(), kRTurboDisplayProp2.getPropValue())) && newNode != null) {
                        int tag = newNode.getTag();
                        Object propValue4 = kRTurboDisplayProp2.getPropValue();
                        if (propValue4 != null) {
                            renderLayerHandler.h(tag, (RectF) propValue4);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.graphics.RectF");
                        }
                    }
                } else if (kRTurboDisplayProp2 != null && kRTurboDisplayProp2.getPropType() == 3) {
                    if (newNode != null) {
                        obj = newNode.getRenderShadow();
                    }
                    if (obj != null) {
                        int tag2 = newNode.getTag();
                        Object renderShadow = newNode.getRenderShadow();
                        if (renderShadow != null) {
                            renderLayerHandler.i(tag2, (i01.b) renderShadow);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.IKuiklyRenderShadowExport");
                        }
                    } else if (newNode == null) {
                        continue;
                    } else {
                        Object propValue5 = kRTurboDisplayProp2.getPropValue();
                        if (propValue5 != null) {
                            i((KRTurboDisplayShadow) propValue5, newNode, renderLayerHandler);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayShadow");
                        }
                    }
                } else if (kRTurboDisplayProp2 != null && kRTurboDisplayProp2.getPropType() == 4 && !hasParent && newNode != null && (parentTag = newNode.getParentTag()) != null) {
                    int intValue = parentTag.intValue();
                    int tag3 = newNode.getTag();
                    Object propValue6 = kRTurboDisplayProp2.getPropValue();
                    if (propValue6 != null) {
                        renderLayerHandler.l(intValue, tag3, ((Integer) propValue6).intValue());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                i19++;
            } else {
                ArrayList arrayList = new ArrayList();
                if (newNode != null && (g19 = newNode.g()) != null) {
                    i17 = g19.size();
                } else {
                    i17 = 0;
                }
                for (int i26 = 0; i26 < i17; i26++) {
                    if (newNode != null && (g18 = newNode.g()) != null && (kRTurboDisplayNodeMethod3 = g18.get(i26)) != null && kRTurboDisplayNodeMethod3.getType() == 0) {
                        arrayList.add(kRTurboDisplayNodeMethod3);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                if (curNode != null && (g17 = curNode.g()) != null) {
                    i18 = g17.size();
                } else {
                    i18 = 0;
                }
                for (int i27 = 0; i27 < i18; i27++) {
                    if (curNode != null && (g16 = curNode.g()) != null && (kRTurboDisplayNodeMethod2 = g16.get(i27)) != null && kRTurboDisplayNodeMethod2.getType() == 0) {
                        arrayList2.add(kRTurboDisplayNodeMethod2);
                    }
                }
                int size = arrayList.size();
                int i28 = 0;
                for (int i29 = 0; i29 < size; i29++) {
                    KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod4 = (KRTurboDisplayNodeMethod) arrayList.get(i29);
                    if (arrayList2.size() > i28) {
                        kRTurboDisplayNodeMethod = (KRTurboDisplayNodeMethod) arrayList2.get(i28);
                    } else {
                        kRTurboDisplayNodeMethod = null;
                    }
                    if (kRTurboDisplayNodeMethod == null || (!Intrinsics.areEqual(kRTurboDisplayNodeMethod.getMethod(), kRTurboDisplayNodeMethod4.getMethod())) || !e(kRTurboDisplayNodeMethod.getParams(), kRTurboDisplayNodeMethod4.getParams())) {
                        break;
                    }
                    i28++;
                }
                while (i28 < arrayList.size()) {
                    KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod5 = (KRTurboDisplayNodeMethod) arrayList.get(i28);
                    if (newNode != null) {
                        renderLayerHandler.r(Integer.valueOf(newNode.getTag()).intValue(), kRTurboDisplayNodeMethod5.getMethod(), kRTurboDisplayNodeMethod5.getParams(), kRTurboDisplayNodeMethod5.b());
                    }
                    i28++;
                }
                return;
            }
        }
    }

    public final void c(@NotNull com.tencent.kuikly.core.render.android.layer.a renderLayerHandler, @Nullable KRTurboDisplayNode oldNodeTree, @Nullable KRTurboDisplayNode newNodeTree) {
        List<KRTurboDisplayNode> list;
        List<KRTurboDisplayNode> list2;
        String str;
        int i3;
        int i16;
        KRTurboDisplayNode kRTurboDisplayNode;
        KRTurboDisplayNode kRTurboDisplayNode2;
        List<KRTurboDisplayNode> j3;
        List<KRTurboDisplayNode> j16;
        Intrinsics.checkNotNullParameter(renderLayerHandler, "renderLayerHandler");
        if (a(oldNodeTree, newNodeTree, false)) {
            m(oldNodeTree, newNodeTree, renderLayerHandler, true);
            if (oldNodeTree != null && (j16 = oldNodeTree.j()) != null) {
                list = CollectionsKt___CollectionsKt.toList(j16);
            } else {
                list = null;
            }
            if (newNodeTree != null && (j3 = newNodeTree.j()) != null) {
                list2 = CollectionsKt___CollectionsKt.toList(j3);
            } else {
                list2 = null;
            }
            if (oldNodeTree != null) {
                str = oldNodeTree.getViewName();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "KRScrollContentView")) {
                list = j(list);
                list2 = j(list2);
            }
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (list2 != null) {
                i16 = list2.size();
            } else {
                i16 = 0;
            }
            int max = Math.max(i3, i16);
            for (int i17 = 0; i17 < max; i17++) {
                if (i3 > i17 && list != null) {
                    kRTurboDisplayNode = list.get(i17);
                } else {
                    kRTurboDisplayNode = null;
                }
                if (i16 > i17 && list2 != null) {
                    kRTurboDisplayNode2 = list2.get(i17);
                } else {
                    kRTurboDisplayNode2 = null;
                }
                c(renderLayerHandler, kRTurboDisplayNode, kRTurboDisplayNode2);
            }
            return;
        }
        h(oldNodeTree, renderLayerHandler);
        b(newNodeTree, renderLayerHandler);
    }

    public final boolean g(@NotNull KRTurboDisplayNode targetNodeTree, @NotNull KRTurboDisplayNode fromNodeTree) {
        List<KRTurboDisplayNode> list;
        List<KRTurboDisplayNode> list2;
        Intrinsics.checkNotNullParameter(targetNodeTree, "targetNodeTree");
        Intrinsics.checkNotNullParameter(fromNodeTree, "fromNodeTree");
        if (!a(targetNodeTree, fromNodeTree, true)) {
            return false;
        }
        boolean k3 = k(targetNodeTree, fromNodeTree);
        if (targetNodeTree.s() && fromNodeTree.s()) {
            list = CollectionsKt___CollectionsKt.toList(targetNodeTree.j());
            list2 = CollectionsKt___CollectionsKt.toList(fromNodeTree.j());
            if (Intrinsics.areEqual(targetNodeTree.getViewName(), "KRScrollContentView")) {
                list = j(list);
                list2 = j(list2);
            }
            if (list != null) {
                int size = list.size();
                int i3 = 0;
                for (int i16 = 0; i16 < size; i16++) {
                    KRTurboDisplayNode kRTurboDisplayNode = list.get(i16);
                    Pair<KRTurboDisplayNode, Integer> f16 = f(list2, i3, kRTurboDisplayNode);
                    KRTurboDisplayNode first = f16.getFirst();
                    int intValue = f16.getSecond().intValue();
                    if (first != null && g(kRTurboDisplayNode, first)) {
                        k3 = true;
                    }
                    i3 = intValue + 1;
                }
            }
        }
        return k3;
    }
}
