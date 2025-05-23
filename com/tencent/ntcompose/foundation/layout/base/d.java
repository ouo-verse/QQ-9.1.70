package com.tencent.ntcompose.foundation.layout.base;

import com.tencent.kuikly.core.layout.FlexLayoutDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0016R\u0011\u0010\u0014\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010!\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010'\u001a\u0004\u0018\u00010\"2\b\u0010\u0016\u001a\u0004\u0018\u00010\"8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010-\u001a\u0004\u0018\u00010(2\b\u0010\u0016\u001a\u0004\u0018\u00010(8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u00103\u001a\u0004\u0018\u00010.2\b\u0010\u0016\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00109\u001a\u0004\u0018\u0001042\b\u0010\u0016\u001a\u0004\u0018\u0001048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u0010?\u001a\u0004\u0018\u00010:2\b\u0010\u0016\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010B\u001a\u0004\u0018\u00010:2\b\u0010\u0016\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/d;", "Lcom/tencent/kuikly/core/layout/FlexNode;", "Lcom/tencent/kuikly/core/layout/c;", "c", "node", "", "parentMaxWidth", "Lcom/tencent/kuikly/core/layout/b;", "layoutContext", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "parentDirection", "", "needLayoutAbsoluteChild", "", "dirtyList", "", "Y", "Lcom/tencent/ntcompose/foundation/layout/base/e;", "e1", "()Lcom/tencent/ntcompose/foundation/layout/base/e;", "flexStyleExt", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "value", "b1", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "k1", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment;)V", "boxAlignment", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "d1", "()Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "m1", "(Lcom/tencent/ntcompose/foundation/layout/base/a$k;)V", "columnVerticalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "c1", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "l1", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;)V", "columnHorizontalAlignment", "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "g1", "()Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "o1", "(Lcom/tencent/ntcompose/foundation/layout/base/a$d;)V", "rowHorizontalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "h1", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "p1", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;)V", "rowVerticalAlignment", "", "f1", "()Ljava/lang/Object;", ICustomDataEditor.NUMBER_PARAM_1, "(Ljava/lang/Object;)V", "layoutDataForParent", "Lcom/tencent/ntcompose/foundation/layout/base/f;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lcom/tencent/ntcompose/foundation/layout/base/f;", "j1", "(Lcom/tencent/ntcompose/foundation/layout/base/f;)V", "atMostWidth", "Z0", "i1", "atMostHeight", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends FlexNode {
    @Override // com.tencent.kuikly.core.layout.FlexNode
    public void Y(FlexNode node, float parentMaxWidth, com.tencent.kuikly.core.layout.b layoutContext, FlexLayoutDirection parentDirection, boolean needLayoutAbsoluteChild, Set<FlexNode> dirtyList) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(dirtyList, "dirtyList");
        g.f339269a.W((d) node, parentMaxWidth, (r16 & 4) != 0 ? null : layoutContext, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0, TypeIntrinsics.asMutableSet(dirtyList));
    }

    public final f Z0() {
        return e1().getAtMostHeight();
    }

    public final f a1() {
        return e1().getAtMostWidth();
    }

    public final Alignment b1() {
        return e1().getBoxAlignment();
    }

    @Override // com.tencent.kuikly.core.layout.FlexNode
    public com.tencent.kuikly.core.layout.c c() {
        return new e();
    }

    public final Alignment.Horizontal c1() {
        return e1().getHorizontalAlignment();
    }

    public final a.k d1() {
        return e1().getVerticalArrangement();
    }

    public final e e1() {
        com.tencent.kuikly.core.layout.c k3 = k();
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.base.FlexStyleComposeExt");
        return (e) k3;
    }

    public final Object f1() {
        return e1().getLayoutDataForParent();
    }

    public final a.d g1() {
        return e1().getHorizontalArrangement();
    }

    public final Alignment.Vertical h1() {
        return e1().getCom.tencent.mtt.hippy.dom.node.ImageNode.PROP_VERTICAL_ALIGNMENT java.lang.String();
    }

    public final void i1(f fVar) {
        f atMostHeight = e1().getAtMostHeight();
        if (Intrinsics.areEqual(atMostHeight != null ? Float.valueOf(atMostHeight.getValue()) : null, fVar != null ? Float.valueOf(fVar.getValue()) : null)) {
            return;
        }
        e1().M(fVar);
        a0();
    }

    public final void j1(f fVar) {
        f atMostWidth = e1().getAtMostWidth();
        if (Intrinsics.areEqual(atMostWidth != null ? Float.valueOf(atMostWidth.getValue()) : null, fVar != null ? Float.valueOf(fVar.getValue()) : null)) {
            return;
        }
        e1().N(fVar);
        a0();
    }

    public final void k1(Alignment alignment) {
        Alignment boxAlignment = e1().getBoxAlignment();
        if (Intrinsics.areEqual(boxAlignment != null ? Integer.valueOf(boxAlignment.ordinal()) : null, alignment != null ? Integer.valueOf(alignment.ordinal()) : null)) {
            return;
        }
        e1().O(alignment);
        a0();
    }

    public final void l1(Alignment.Horizontal horizontal) {
        if (e1().getHorizontalAlignment() != horizontal) {
            e1().P(horizontal);
            a0();
        }
    }

    public final void m1(a.k kVar) {
        if (Intrinsics.areEqual(e1().getVerticalArrangement(), kVar)) {
            return;
        }
        e1().T(kVar);
        a0();
    }

    public final void n1(Object obj) {
        if (Intrinsics.areEqual(e1().getLayoutDataForParent(), obj)) {
            return;
        }
        e1().R(obj);
        a0();
    }

    public final void o1(a.d dVar) {
        if (Intrinsics.areEqual(e1().getHorizontalArrangement(), dVar)) {
            return;
        }
        e1().Q(dVar);
        a0();
    }

    public final void p1(Alignment.Vertical vertical) {
        if (e1().getCom.tencent.mtt.hippy.dom.node.ImageNode.PROP_VERTICAL_ALIGNMENT java.lang.String() != vertical) {
            e1().S(vertical);
            a0();
        }
    }
}
