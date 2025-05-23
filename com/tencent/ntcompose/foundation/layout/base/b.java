package com.tencent.ntcompose.foundation.layout.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.base.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0005*\u00020\u0000\u001a\u0012\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\f\u001a\u0014\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a\u0012\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0012\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u0012\u0010\u001a\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f\u001a\u001e\u0010\u001e\u001a\u00020\u0018*\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u001a\u001e\u0010 \u001a\u00020\u0018*\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/ntcompose/foundation/layout/base/d;", "g", "", "fraction", "Lcom/tencent/kuikly/core/base/attr/c;", "f", "d", "e", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "alignment", "a", "", "isMatch", h.F, "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", ImageNode.PROP_VERTICAL_ALIGNMENT, "c", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "horizontalAlignment", "b", "Lcom/tencent/kuikly/core/base/m;", "contentAlignment", "j", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "vertical", "horizontal", "k", "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "l", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {
    public static final Attr a(Attr attr, Alignment alignment) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            Object f16 = dVar.f1();
            c cVar = f16 instanceof c ? (c) f16 : null;
            if (cVar == null) {
                cVar = new c(null, false, null, 7, null);
            }
            cVar.d(alignment);
            dVar.n1(cVar);
        }
        return attr;
    }

    public static final Attr b(Attr attr, Alignment.Horizontal horizontalAlignment) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            dVar.n1(horizontalAlignment);
        }
        return attr;
    }

    public static final Attr c(Attr attr, Alignment.Vertical verticalAlignment) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            dVar.n1(verticalAlignment);
        }
        return attr;
    }

    public static final com.tencent.kuikly.core.base.attr.c d(Attr attr, float f16) {
        f a16;
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            f.Companion companion = f.INSTANCE;
            if (f16 == companion.b().getValue()) {
                a16 = companion.b();
            } else {
                a16 = companion.a(f16);
            }
            dVar.i1(a16);
        }
        return attr;
    }

    public static final com.tencent.kuikly.core.base.attr.c e(Attr attr, float f16) {
        f a16;
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            f.Companion companion = f.INSTANCE;
            if (f16 == companion.b().getValue()) {
                a16 = companion.b();
            } else {
                a16 = companion.a(f16);
            }
            dVar.j1(a16);
            dVar.i1(a16);
        }
        return attr;
    }

    public static final com.tencent.kuikly.core.base.attr.c f(Attr attr, float f16) {
        f a16;
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            f.Companion companion = f.INSTANCE;
            if (f16 == companion.b().getValue()) {
                a16 = companion.b();
            } else {
                a16 = companion.a(f16);
            }
            dVar.j1(a16);
        }
        return attr;
    }

    public static final d g(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        if (flexNode instanceof d) {
            return (d) flexNode;
        }
        return null;
    }

    public static final Attr h(Attr attr, boolean z16) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            Object f16 = dVar.f1();
            c cVar = f16 instanceof c ? (c) f16 : null;
            if (cVar == null) {
                cVar = new c(null, false, null, 7, null);
            }
            cVar.f(z16);
            dVar.n1(cVar);
        }
        return attr;
    }

    public static final m j(m mVar, Alignment contentAlignment) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        Intrinsics.checkNotNullParameter(contentAlignment, "contentAlignment");
        mVar.m148positionType(FlexPositionType.BOX);
        d g16 = g(mVar);
        if (g16 != null) {
            g16.k1(contentAlignment);
        }
        return mVar;
    }

    public static final m k(m mVar, a.k vertical, Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        Intrinsics.checkNotNullParameter(vertical, "vertical");
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        mVar.positionRelative();
        mVar.flexDirectionColumn();
        d g16 = g(mVar);
        if (g16 != null) {
            g16.m1(vertical);
        }
        d g17 = g(mVar);
        if (g17 != null) {
            g17.l1(horizontal);
        }
        return mVar;
    }

    public static final m l(m mVar, a.d horizontal, Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        Intrinsics.checkNotNullParameter(vertical, "vertical");
        mVar.positionRelative();
        mVar.flexDirectionRow();
        d g16 = g(mVar);
        if (g16 != null) {
            g16.o1(horizontal);
        }
        d g17 = g(mVar);
        if (g17 != null) {
            g17.p1(vertical);
        }
        return mVar;
    }

    public static final com.tencent.kuikly.core.base.attr.c m(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            dVar.i1(f.INSTANCE.c());
            ScrollerAttr scrollerAttr = attr instanceof ScrollerAttr ? (ScrollerAttr) attr : null;
            if (scrollerAttr != null) {
                scrollerAttr.wrapContentSize();
            }
        }
        return attr;
    }

    public static final com.tencent.kuikly.core.base.attr.c n(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            f.Companion companion = f.INSTANCE;
            dVar.j1(companion.c());
            dVar.i1(companion.c());
        }
        return attr;
    }

    public static final com.tencent.kuikly.core.base.attr.c o(Attr attr) {
        Intrinsics.checkNotNullParameter(attr, "<this>");
        FlexNode flexNode = attr.getFlexNode();
        d dVar = flexNode instanceof d ? (d) flexNode : null;
        if (dVar != null) {
            dVar.j1(f.INSTANCE.c());
            ScrollerAttr scrollerAttr = attr instanceof ScrollerAttr ? (ScrollerAttr) attr : null;
            if (scrollerAttr != null) {
                scrollerAttr.wrapContentSize();
            }
        }
        return attr;
    }

    public static /* synthetic */ Attr i(Attr attr, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return h(attr, z16);
    }
}
