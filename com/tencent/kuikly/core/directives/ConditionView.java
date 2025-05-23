package com.tencent.kuikly.core.directives;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!\u0012\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020&\u00a2\u0006\u0002\b'\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J2\u0010\u000e\u001a\u0004\u0018\u00010\u00002&\u0010\r\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b0\nj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b`\fH\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J(\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b0\nj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b`\fH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R%\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020&\u00a2\u0006\u0002\b'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010/\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010/\u00a8\u0006>"}, d2 = {"Lcom/tencent/kuikly/core/directives/ConditionView;", "Lcom/tencent/kuikly/core/directives/a;", "", "w", "", "result", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "Ljava/util/ArrayList;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lkotlin/collections/ArrayList;", "conditionViews", "r", "lastView", "nextView", ReportConstant.COSTREPORT_PREFIX, "view", "u", "t", "p", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "didInit", "", "viewName", "didMoveToParentView", "didRemoveFromParentView", "Lcom/tencent/kuikly/core/directives/ConditionType;", "a", "Lcom/tencent/kuikly/core/directives/ConditionType;", "conditionType", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "condition", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "c", "Lkotlin/jvm/functions/Function1;", "creator", "d", "Ljava/lang/Boolean;", "conditionResult", "e", "Z", "didCreated", "f", "getNeedSyncConditionResult", "()Z", "setNeedSyncConditionResult", "(Z)V", "needSyncConditionResult", "", "g", "I", "rootConditionViewRef", h.F, "<init>", "(Lcom/tencent/kuikly/core/directives/ConditionType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ConditionView extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConditionType conditionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function0<Object> condition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1<ConditionView, Unit> creator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Boolean conditionResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean didCreated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needSyncConditionResult;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int rootConditionViewRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean didInit;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionView(ConditionType conditionType, Function0<? extends Object> condition, Function1<? super ConditionView, Unit> creator) {
        Intrinsics.checkNotNullParameter(conditionType, "conditionType");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.conditionType = conditionType;
        this.condition = condition;
        this.creator = creator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean result) {
        this.conditionResult = Boolean.valueOf(result);
        this.needSyncConditionResult = true;
        if (this.didInit) {
            x();
        } else if (result) {
            x();
        }
    }

    private final ArrayList<DeclarativeBaseView<?, ?>> p() {
        ArrayList<DeclarativeBaseView<?, ?>> arrayList = new ArrayList<>();
        AbstractBaseView<?, ?> viewWithNativeRef = getPager().getViewWithNativeRef(this.rootConditionViewRef);
        ConditionView conditionView = viewWithNativeRef instanceof ConditionView ? (ConditionView) viewWithNativeRef : null;
        if (conditionView == null) {
            return arrayList;
        }
        ConditionView conditionView2 = conditionView;
        while (s(conditionView, conditionView2)) {
            Intrinsics.checkNotNull(conditionView2);
            arrayList.add(conditionView2);
            a k3 = conditionView2.k();
            conditionView2 = k3 instanceof ConditionView ? (ConditionView) k3 : null;
        }
        return arrayList;
    }

    private final void q() {
        if (this.didCreated) {
            return;
        }
        this.creator.invoke(this);
        this.didCreated = true;
        if (this.didInit) {
            y();
        }
    }

    private final ConditionView r(ArrayList<DeclarativeBaseView<?, ?>> conditionViews) {
        Iterator<DeclarativeBaseView<?, ?>> it = conditionViews.iterator();
        while (it.hasNext()) {
            DeclarativeBaseView<?, ?> next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.kuikly.core.directives.ConditionView");
            ConditionView conditionView = (ConditionView) next;
            Boolean bool = conditionView.conditionResult;
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                return conditionView;
            }
        }
        return null;
    }

    private final void v() {
        if (this.didCreated) {
            if (this.didInit) {
                z();
            }
            removeChildren();
            this.didCreated = false;
        }
    }

    private final void w() {
        if (this.conditionType == ConditionType.VIF) {
            this.rootConditionViewRef = getNativeRef();
            return;
        }
        a l3 = l();
        if (!u(l3) && !t(l3)) {
            PagerNotFoundExceptionKt.a("\u6a21\u677f\u6761\u4ef6\u6307\u4ee4\u9519\u8bef\uff1aif else \u6761\u4ef6\u5339\u914d\u9519\u8bef");
            return;
        }
        ConditionView conditionView = l3 instanceof ConditionView ? (ConditionView) l3 : null;
        Intrinsics.checkNotNull(conditionView);
        this.rootConditionViewRef = conditionView.rootConditionViewRef;
    }

    private final void x() {
        ArrayList<DeclarativeBaseView<?, ?>> p16 = p();
        ConditionView r16 = r(p16);
        Iterator<DeclarativeBaseView<?, ?>> it = p16.iterator();
        while (it.hasNext()) {
            DeclarativeBaseView<?, ?> next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.kuikly.core.directives.ConditionView");
            ConditionView conditionView = (ConditionView) next;
            conditionView.needSyncConditionResult = false;
            if (!Intrinsics.areEqual(next, r16)) {
                conditionView.v();
            }
        }
        if (r16 != null) {
            r16.q();
        }
    }

    private final void y() {
        DeclarativeBaseView<?, ?> declarativeBaseView;
        int indexOf;
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(h16);
            Iterator<T> it = VirtualViewKt.a(this).iterator();
            while (it.hasNext() && (indexOf = a16.indexOf((declarativeBaseView = (DeclarativeBaseView) it.next()))) >= 0 && indexOf < a16.size()) {
                h16.insertDomSubView(declarativeBaseView, indexOf);
            }
        }
    }

    private final void z() {
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            Iterator<T> it = VirtualViewKt.a(this).iterator();
            while (it.hasNext()) {
                h16.removeDomSubView((DeclarativeBaseView) it.next());
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        this.didInit = true;
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        w();
        ReactiveObserver.INSTANCE.b(this, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.directives.ConditionView$didMoveToParentView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Function0 function0;
                Boolean bool;
                com.tencent.kuikly.core.utils.a aVar = com.tencent.kuikly.core.utils.a.f118267a;
                function0 = ConditionView.this.condition;
                final boolean c16 = aVar.c(function0.invoke());
                Boolean valueOf = Boolean.valueOf(c16);
                bool = ConditionView.this.conditionResult;
                if (Intrinsics.areEqual(valueOf, bool)) {
                    return;
                }
                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                final ConditionView conditionView = ConditionView.this;
                companion.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.directives.ConditionView$didMoveToParentView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ConditionView.this.A(c16);
                    }
                });
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
    }

    @Override // com.tencent.kuikly.core.base.ab, com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "ConditionView";
    }

    private final boolean t(DeclarativeBaseView<?, ?> view) {
        return view != null && (view instanceof ConditionView) && ((ConditionView) view).conditionType == ConditionType.VELSEIF;
    }

    private final boolean u(DeclarativeBaseView<?, ?> view) {
        return view != null && (view instanceof ConditionView) && ((ConditionView) view).conditionType == ConditionType.VIF;
    }

    private final boolean s(ConditionView lastView, ConditionView nextView) {
        return (lastView == null || nextView == null || lastView.rootConditionViewRef != nextView.rootConditionViewRef) ? false : true;
    }
}
