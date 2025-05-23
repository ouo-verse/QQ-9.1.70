package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/views/WaterfallContentView;", "Lcom/tencent/kuikly/core/views/ListContentView;", "", UserInfo.SEX_FEMALE, "H", "", "G", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "child", "", "index", "didInsertDomChild", "createFlexNode", "onPagerCalculateLayoutFinish", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "<init>", "()V", "k", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class WaterfallContentView extends ListContentView {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR(\u0010\t\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00038B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/views/WaterfallContentView$a;", "", "Lcom/tencent/kuikly/core/base/Attr;", "", "value", "c", "(Lcom/tencent/kuikly/core/base/Attr;)Z", "d", "(Lcom/tencent/kuikly/core/base/Attr;Z)V", "isStaticWidth", "", "KEY_STATIC_WIDTH_NODE", "Ljava/lang/String;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.WaterfallContentView$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(Attr attr) {
            return Intrinsics.areEqual(attr.getExtProps().get("waterfall_static_width"), Boolean.TRUE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Attr attr, boolean z16) {
            attr.getExtProps().put("waterfall_static_width", Boolean.valueOf(z16));
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float F() {
        float U;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.WaterfallListView");
        ck ckVar = (ck) ((cm) parent).getViewAttr();
        if (ckVar.getListWidth() > 0.0f) {
            U = ckVar.getListWidth();
        } else {
            FlexNode flexNode = ckVar.getFlexNode();
            Intrinsics.checkNotNull(flexNode);
            U = flexNode.U();
        }
        if (!(U == 0.0f) && !Float.isNaN(U)) {
            return (((U - ckVar.getContentPaddingLeft()) - ckVar.getContentPaddingRight()) - ((ckVar.getColumnCount() - 1) * ckVar.getItemSpacing())) / ckVar.getColumnCount();
        }
        throw new RuntimeException("listWidth == 0f || listWidth.isNaN(), must set WaterfallList width");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        float f16;
        float contentPaddingTop;
        float f17;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.WaterfallListView");
        cm cmVar = (cm) parent;
        ck ckVar = (ck) cmVar.getViewAttr();
        ArrayList arrayList = new ArrayList();
        boolean isPlainLayoutMode = ckVar.getIsPlainLayoutMode();
        int columnCount = ckVar.getColumnCount();
        int i3 = 0;
        for (int i16 = 0; i16 < columnCount; i16++) {
            arrayList.add(Float.valueOf(ckVar.getContentPaddingLeft() - ckVar.getItemSpacing()));
        }
        Iterator<T> it = x().iterator();
        int i17 = 0;
        float f18 = 0.0f;
        while (true) {
            f16 = -3.4028235E38f;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) next;
            if (declarativeBaseView.getAbsoluteFlexNode()) {
                f18 = Math.max(declarativeBaseView.getFlexNode().getLayoutFrame().g(), f18);
            } else {
                if (declarativeBaseView.getFlexNode().getLayoutFrame().getHeight() > H() + 1) {
                    contentPaddingTop = ckVar.getContentPaddingTop();
                    float height = (declarativeBaseView.getFlexNode().getLayoutFrame().getHeight() + contentPaddingTop) - cmVar.getFlexNode().getLayoutFrame().getHeight();
                    if (height > 0.0f) {
                        contentPaddingTop -= height;
                    }
                    int i19 = 0;
                    for (Object obj : arrayList) {
                        int i26 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        float floatValue = ((Number) obj).floatValue();
                        if (f16 < floatValue) {
                            f16 = floatValue;
                        }
                        i19 = i26;
                    }
                    f17 = f16 + ckVar.getItemSpacing();
                    int size = arrayList.size();
                    for (int i27 = 0; i27 < size; i27++) {
                        arrayList.set(i27, Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getWidth() + f17));
                    }
                } else {
                    float f19 = Float.MAX_VALUE;
                    int i28 = 0;
                    int i29 = 0;
                    for (Object obj2 : arrayList) {
                        int i36 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        float floatValue2 = ((Number) obj2).floatValue();
                        if (f19 > floatValue2) {
                            i28 = i29;
                            f19 = floatValue2;
                        }
                        i29 = i36;
                    }
                    contentPaddingTop = ckVar.getContentPaddingTop() + (i28 * (H() + ckVar.getLineSpacing()));
                    float itemSpacing = f19 + ckVar.getItemSpacing();
                    arrayList.set(i28, Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getWidth() + itemSpacing));
                    if (isPlainLayoutMode && arrayList.size() > 1 && i28 == arrayList.size() - 1) {
                        int i37 = 0;
                        for (Object obj3 : arrayList) {
                            int i38 = i37 + 1;
                            if (i37 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            float floatValue3 = ((Number) obj3).floatValue();
                            if (f16 < floatValue3) {
                                f16 = floatValue3;
                            }
                            i37 = i38;
                        }
                        int size2 = arrayList.size();
                        for (int i39 = 0; i39 < size2; i39++) {
                            arrayList.set(i39, Float.valueOf(f16));
                        }
                    }
                    f17 = itemSpacing;
                }
                com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                FlexNode.X0(declarativeBaseView.getFlexNode(), new com.tencent.kuikly.core.layout.d(f17, contentPaddingTop, layoutFrame.getWidth(), layoutFrame.getHeight()), false, false, 6, null);
            }
            i17 = i18;
        }
        for (Object obj4 : arrayList) {
            int i46 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            float floatValue4 = ((Number) obj4).floatValue();
            if (f16 < floatValue4) {
                f16 = floatValue4;
            }
            i3 = i46;
        }
        float f26 = f16 >= 0.0f ? f16 : 0.0f;
        com.tencent.kuikly.core.layout.h k3 = getFlexNode().getLayoutFrame().k();
        k3.f(Math.max(Math.max(f26 + ckVar.getContentPaddingRight(), f18), u()));
        FlexNode.X0(getFlexNode(), k3.i(), false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float H() {
        float K;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.WaterfallListView");
        ck ckVar = (ck) ((cm) parent).getViewAttr();
        if (ckVar.getListWidth() > 0.0f) {
            K = ckVar.getListWidth();
        } else {
            FlexNode flexNode = ckVar.getFlexNode();
            Intrinsics.checkNotNull(flexNode);
            K = flexNode.K();
        }
        if (!(K == 0.0f) && !Float.isNaN(K)) {
            return (((K - ckVar.getContentPaddingTop()) - ckVar.getContentPaddingBottom()) - ((ckVar.getColumnCount() - 1) * ckVar.getItemSpacing())) / ckVar.getColumnCount();
        }
        throw new RuntimeException("listWidth == 0f || listWidth.isNaN(), must set WaterfallList width");
    }

    @Override // com.tencent.kuikly.core.views.ListContentView
    public void A() {
        getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.WaterfallContentView$updateChildLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.kuikly.core.base.Attr] */
            /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.kuikly.core.base.Attr] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean c16;
                float F;
                List<DeclarativeBaseView<?, ?>> x16 = WaterfallContentView.this.x();
                WaterfallContentView waterfallContentView = this;
                Iterator<T> it = x16.iterator();
                while (it.hasNext()) {
                    DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
                    c16 = WaterfallContentView.INSTANCE.c(declarativeBaseView.getViewAttr());
                    if (!c16) {
                        ?? viewAttr = declarativeBaseView.getViewAttr();
                        F = waterfallContentView.F();
                        viewAttr.mo153width(F);
                    }
                }
                WaterfallContentView.this.t();
            }
        });
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.AbstractBaseView
    public void createFlexNode() {
        super.createFlexNode();
    }

    @Override // com.tencent.kuikly.core.views.ListContentView, com.tencent.kuikly.core.base.ViewContainer
    public void didInsertDomChild(final DeclarativeBaseView<?, ?> child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.didInsertDomChild(child, index);
        if (child.getAbsoluteFlexNode()) {
            return;
        }
        final boolean isRowFlexDirection = isRowFlexDirection();
        child.attr(new Function1<Attr, Unit>() { // from class: com.tencent.kuikly.core.views.WaterfallContentView$didInsertDomChild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Attr attr) {
                invoke2(attr);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.tencent.kuikly.core.base.Attr] */
            /* JADX WARN: Type inference failed for: r0v26, types: [com.tencent.kuikly.core.base.Attr] */
            /* JADX WARN: Type inference failed for: r0v31, types: [com.tencent.kuikly.core.base.Attr] */
            /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.kuikly.core.base.Attr] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Attr attr) {
                float F;
                cm cmVar;
                ck ckVar;
                float H;
                ck ckVar2;
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                attr.positionAbsolute();
                attr.m150top(0.0f);
                attr.m142left(0.0f);
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                attr.m149right(Float.NaN);
                attr.m138bottom(Float.NaN);
                if (isRowFlexDirection) {
                    FlexNode flexNode = child.getViewAttr().getFlexNode();
                    Intrinsics.checkNotNull(flexNode);
                    if (!Float.isNaN(flexNode.K())) {
                        WaterfallContentView.INSTANCE.d(child.getViewAttr(), true);
                        return;
                    }
                    if (!(child instanceof ab)) {
                        H = this.H();
                        attr.mo141height(H);
                        return;
                    } else {
                        ViewContainer<?, ?> parent = this.getParent();
                        cmVar = parent instanceof cm ? (cm) parent : null;
                        attr.mo141height((cmVar == null || (ckVar2 = (ck) cmVar.getViewAttr()) == null) ? attr.getPager().getPageData().l() : ckVar2.getListWidth());
                        return;
                    }
                }
                FlexNode flexNode2 = child.getViewAttr().getFlexNode();
                Intrinsics.checkNotNull(flexNode2);
                if (!Float.isNaN(flexNode2.U())) {
                    WaterfallContentView.INSTANCE.d(child.getViewAttr(), true);
                    return;
                }
                if (!(child instanceof ab)) {
                    F = this.F();
                    attr.mo153width(F);
                } else {
                    ViewContainer<?, ?> parent2 = this.getParent();
                    cmVar = parent2 instanceof cm ? (cm) parent2 : null;
                    attr.mo153width((cmVar == null || (ckVar = (ck) cmVar.getViewAttr()) == null) ? attr.getPager().getPageData().m() : ckVar.getListWidth());
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.ListContentView, com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.pager.e
    public void onPagerCalculateLayoutFinish() {
        float f16;
        float contentPaddingLeft;
        float f17;
        if (isRowFlexDirection()) {
            G();
            return;
        }
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.WaterfallListView");
        cm cmVar = (cm) parent;
        ck ckVar = (ck) cmVar.getViewAttr();
        ArrayList arrayList = new ArrayList();
        boolean isPlainLayoutMode = ckVar.getIsPlainLayoutMode();
        int columnCount = ckVar.getColumnCount();
        int i3 = 0;
        for (int i16 = 0; i16 < columnCount; i16++) {
            arrayList.add(Float.valueOf(ckVar.getContentPaddingTop() - ckVar.getLineSpacing()));
        }
        Iterator<T> it = x().iterator();
        int i17 = 0;
        float f18 = 0.0f;
        while (true) {
            f16 = -3.4028235E38f;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) next;
            if (declarativeBaseView.getAbsoluteFlexNode()) {
                f18 = Math.max(declarativeBaseView.getFlexNode().getLayoutFrame().h(), f18);
            } else {
                if (declarativeBaseView.getFlexNode().getLayoutFrame().getWidth() > F() + 1) {
                    contentPaddingLeft = ckVar.getContentPaddingLeft();
                    float width = (declarativeBaseView.getFlexNode().getLayoutFrame().getWidth() + contentPaddingLeft) - cmVar.getFlexNode().getLayoutFrame().getWidth();
                    if (width > 0.0f) {
                        contentPaddingLeft -= width;
                    }
                    int i19 = 0;
                    for (Object obj : arrayList) {
                        int i26 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        float floatValue = ((Number) obj).floatValue();
                        if (f16 < floatValue) {
                            f16 = floatValue;
                        }
                        i19 = i26;
                    }
                    f17 = f16 + ckVar.getLineSpacing();
                    int size = arrayList.size();
                    for (int i27 = 0; i27 < size; i27++) {
                        arrayList.set(i27, Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getHeight() + f17));
                    }
                } else {
                    float f19 = Float.MAX_VALUE;
                    int i28 = 0;
                    int i29 = 0;
                    for (Object obj2 : arrayList) {
                        int i36 = i29 + 1;
                        if (i29 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        float floatValue2 = ((Number) obj2).floatValue();
                        if (f19 > floatValue2) {
                            i28 = i29;
                            f19 = floatValue2;
                        }
                        i29 = i36;
                    }
                    contentPaddingLeft = ckVar.getContentPaddingLeft() + (i28 * (F() + ckVar.getItemSpacing()));
                    float lineSpacing = f19 + ckVar.getLineSpacing();
                    arrayList.set(i28, Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getHeight() + lineSpacing));
                    if (isPlainLayoutMode && arrayList.size() > 1 && i28 == arrayList.size() - 1) {
                        int i37 = 0;
                        for (Object obj3 : arrayList) {
                            int i38 = i37 + 1;
                            if (i37 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            float floatValue3 = ((Number) obj3).floatValue();
                            if (f16 < floatValue3) {
                                f16 = floatValue3;
                            }
                            i37 = i38;
                        }
                        int size2 = arrayList.size();
                        for (int i39 = 0; i39 < size2; i39++) {
                            arrayList.set(i39, Float.valueOf(f16));
                        }
                    }
                    f17 = lineSpacing;
                }
                com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                FlexNode.X0(declarativeBaseView.getFlexNode(), new com.tencent.kuikly.core.layout.d(contentPaddingLeft, f17, layoutFrame.getWidth(), layoutFrame.getHeight()), false, false, 6, null);
            }
            i17 = i18;
        }
        for (Object obj4 : arrayList) {
            int i46 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            float floatValue4 = ((Number) obj4).floatValue();
            if (f16 < floatValue4) {
                f16 = floatValue4;
            }
            i3 = i46;
        }
        float f26 = f16 >= 0.0f ? f16 : 0.0f;
        com.tencent.kuikly.core.layout.h k3 = getFlexNode().getLayoutFrame().k();
        k3.e(Math.max(Math.max(f26 + ckVar.getContentPaddingBottom(), f18), u()));
        FlexNode.X0(getFlexNode(), k3.i(), false, false, 6, null);
    }
}
