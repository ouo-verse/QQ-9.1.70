package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView;
import com.tencent.kuikly.core.render.android.expand.component.list.a;
import com.tencent.kuikly.core.render.android.expand.component.list.b;
import com.tencent.kuikly.core.render.android.expand.component.list.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt__MathJVMKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u0001ZB\u000f\u0012\u0006\u0010W\u001a\u00020V\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016JI\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182+\u0010$\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fj\u0004\u0018\u0001`#H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J \u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016J(\u00104\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00103\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u00109\u001a\u00020\t2\u0006\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020+H\u0016J\u0018\u0010:\u001a\u00020\t2\u0006\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020+H\u0016J\u0018\u0010;\u001a\u00020\t2\u0006\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020+H\u0016R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010F\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010H\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010AR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR;\u0010M\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010LR;\u0010N\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010LR\u0016\u0010O\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010@R\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010QR\u0014\u0010U\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u00a8\u0006["}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRAdsorptionPullView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/a;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/b;", "Landroid/view/MotionEvent;", "event", "", "T", "immediately", "", "U", "N", "enable", "P", "Landroid/view/View;", "view", "", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "list", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "hrRecyclerView", "W", "", "propKey", "", "propValue", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "e", "target", "", "velocityX", "velocityY", "onNestedPreFling", "", "dx", "dy", "", "consumed", "onNestedPreScroll", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "offsetX", "offsetY", "l", "j", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "Ljava/lang/ref/WeakReference;", "H", "Ljava/lang/ref/WeakReference;", "hrRecyclerViewWeakRef", "I", UserInfo.SEX_FEMALE, "beginDragOffsetY", "J", "minTriggerDist", "K", "animateDurationMS", "L", "overHeight", "M", "Z", "isPulling", "Lkotlin/jvm/functions/Function1;", "expandCallback", "closeCallback", "currentState", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "originHitRect", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRAdsorptionPullView extends KRView implements com.tencent.kuikly.core.render.android.expand.component.list.a, com.tencent.kuikly.core.render.android.expand.component.list.b {

    /* renamed from: H, reason: from kotlin metadata */
    private WeakReference<KRRecyclerView> hrRecyclerViewWeakRef;

    /* renamed from: I, reason: from kotlin metadata */
    private float beginDragOffsetY;

    /* renamed from: J, reason: from kotlin metadata */
    private float minTriggerDist;

    /* renamed from: K, reason: from kotlin metadata */
    private float animateDurationMS;

    /* renamed from: L, reason: from kotlin metadata */
    private float overHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isPulling;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<Object, Unit> expandCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private Function1<Object, Unit> closeCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: R, reason: from kotlin metadata */
    private final Rect originHitRect;

    public HRAdsorptionPullView(Context context) {
        super(context);
        this.minTriggerDist = com.tencent.kuikly.core.render.android.css.ktx.b.I((com.tencent.kuikly.core.render.android.a) (context instanceof com.tencent.kuikly.core.render.android.a ? context : null), 50.0f);
        this.animateDurationMS = 250.0f;
        this.originHitRect = new Rect();
    }

    private final void N(final boolean immediately) {
        WeakReference<KRRecyclerView> weakReference;
        final KRRecyclerView kRRecyclerView;
        if (this.currentState == 2 || (weakReference = this.hrRecyclerViewWeakRef) == null || (kRRecyclerView = weakReference.get()) == null) {
            return;
        }
        this.currentState = 2;
        this.isPulling = true;
        e eVar = new e(get_kuiklyRenderContext(), null, null, 6, null);
        eVar.j(com.tencent.kuikly.core.render.android.css.ktx.b.g(this));
        eVar.g(true);
        eVar.h(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRAdsorptionPullView$dropDown$$inlined$also$lambda$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                KRRecyclerView.this.setForceOverScroll(true);
                KRRecyclerView.this.setTouchDelegate(this);
                this.P(true);
            }
        });
        Unit unit = Unit.INSTANCE;
        kRRecyclerView.setContentInsert(eVar, immediately);
        S();
        bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(boolean enable) {
        KRRecyclerView kRRecyclerView;
        WeakReference<KRRecyclerView> weakReference = this.hrRecyclerViewWeakRef;
        View childAt = (weakReference == null || (kRRecyclerView = weakReference.get()) == null) ? null : kRRecyclerView.getChildAt(0);
        ViewGroup viewGroup = (ViewGroup) (childAt instanceof ViewGroup ? childAt : null);
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = viewGroup.getChildAt(i3);
                if (!(childAt2 instanceof HRAdsorptionPullView)) {
                    Q(childAt2, arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((KRRecyclerView) it.next()).setEnableSmallTouchSlop(enable);
                    }
                    arrayList.clear();
                }
            }
        }
    }

    private final void Q(View view, List<KRRecyclerView> list) {
        RecyclerView.LayoutManager layoutManager;
        if ((view instanceof KRRecyclerView) && (layoutManager = ((KRRecyclerView) view).getLayoutManager()) != null && layoutManager.canScrollHorizontally()) {
            list.add(view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Q(viewGroup.getChildAt(i3), list);
            }
        }
    }

    private final void R() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.closeCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    private final void S() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.expandCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    private final boolean T(MotionEvent event) {
        int roundToInt;
        getHitRect(this.originHitRect);
        Rect rect = this.originHitRect;
        int i3 = -rect.top;
        roundToInt = MathKt__MathJVMKt.roundToInt(this.overHeight);
        rect.bottom = i3 + roundToInt;
        Rect rect2 = this.originHitRect;
        rect2.top = 0;
        return rect2.contains((int) event.getX(), (int) event.getY());
    }

    private final void U(final boolean immediately) {
        WeakReference<KRRecyclerView> weakReference;
        final KRRecyclerView kRRecyclerView;
        if (this.currentState == 1 || (weakReference = this.hrRecyclerViewWeakRef) == null || (kRRecyclerView = weakReference.get()) == null) {
            return;
        }
        this.currentState = 1;
        e eVar = new e(get_kuiklyRenderContext(), null, null, 6, null);
        eVar.j(0.0f);
        eVar.g(true);
        eVar.h(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRAdsorptionPullView$pullUp$$inlined$also$lambda$1
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                KRRecyclerView.this.setTouchDelegate((b) null);
                this.isPulling = false;
                KRRecyclerView.this.setForceOverScroll(false);
                this.P(false);
            }
        });
        Unit unit = Unit.INSTANCE;
        kRRecyclerView.setContentInsert(eVar, immediately);
        R();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        switch (propKey.hashCode()) {
            case -2008189492:
                if (propKey.equals("minTriggerDist")) {
                    this.minTriggerDist = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return true;
                }
                return super.b(propKey, propValue);
            case -1289167206:
                if (propKey.equals("expand")) {
                    if (propValue != null) {
                        this.expandCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                return super.b(propKey, propValue);
            case 94756344:
                if (propKey.equals("close")) {
                    if (propValue != null) {
                        this.closeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                return super.b(propKey, propValue);
            case 1314769691:
                if (propKey.equals("overHeight")) {
                    this.overHeight = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                    return true;
                }
                return super.b(propKey, propValue);
            case 1541305237:
                if (propKey.equals("animateDuration")) {
                    this.animateDurationMS = com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue);
                    return true;
                }
                return super.b(propKey, propValue);
            default:
                return super.b(propKey, propValue);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        int hashCode = method.hashCode();
        if (hashCode != -977126464) {
            if (hashCode == -433014735 && method.equals("dropDown")) {
                N(true);
                return Unit.INSTANCE;
            }
        } else if (method.equals("pullUp")) {
            U(true);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void e(ViewGroup parent) {
        super.e(parent);
        W(null);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.b
    public boolean i(MotionEvent event) {
        KRRecyclerView kRRecyclerView;
        ViewParent parent;
        boolean z16 = false;
        if (this.isPulling && T(event)) {
            onInterceptTouchEvent(event);
            WeakReference<KRRecyclerView> weakReference = this.hrRecyclerViewWeakRef;
            z16 = true;
            if (weakReference != null && (kRRecyclerView = weakReference.get()) != null && (parent = kRRecyclerView.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return z16;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void j(float offsetX, float offsetY) {
        a.C5873a.c(this, offsetX, offsetY);
        if (this.isPulling) {
            if (offsetY - this.beginDragOffsetY > this.minTriggerDist) {
                V(this, false, 1, null);
                return;
            } else {
                O(this, false, 1, null);
                return;
            }
        }
        if (offsetY >= 0.1f || offsetY >= (-this.minTriggerDist)) {
            return;
        }
        O(this, false, 1, null);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void l(float offsetX, float offsetY) {
        a.C5873a.a(this, offsetX, offsetY);
        this.beginDragOffsetY = offsetY;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.b
    public boolean m(MotionEvent e16) {
        if (this.isPulling && T(e16)) {
            return dispatchTouchEvent(e16);
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void n(ViewGroup parent) {
        super.n(parent);
        ViewParent parent2 = parent.getParent();
        if (!(parent2 instanceof KRRecyclerView)) {
            parent2 = null;
        }
        KRRecyclerView kRRecyclerView = (KRRecyclerView) parent2;
        Function1<KRRecyclerView, Unit> function1 = new Function1<KRRecyclerView, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRAdsorptionPullView$onAddToParent$setupTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KRRecyclerView kRRecyclerView2) {
                invoke2(kRRecyclerView2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KRRecyclerView kRRecyclerView2) {
                HRAdsorptionPullView.this.W(kRRecyclerView2);
                HRAdsorptionPullView.this.bringToFront();
            }
        };
        if (kRRecyclerView == null) {
            parent.addOnAttachStateChangeListener(new b(parent, function1));
        } else {
            function1.invoke(kRRecyclerView);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void o(KRRecyclerContentView kRRecyclerContentView, View view) {
        a.C5873a.b(this, kRRecyclerContentView, view);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed) {
        KRRecyclerView kRRecyclerView;
        WeakReference<KRRecyclerView> weakReference = this.hrRecyclerViewWeakRef;
        if (weakReference == null || (kRRecyclerView = weakReference.get()) == null || !kRRecyclerView.z0()) {
            return;
        }
        consumed[1] = dy5;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void onScroll(float offsetX, float offsetY) {
        WeakReference<KRRecyclerView> weakReference;
        KRRecyclerView kRRecyclerView;
        bringToFront();
        if (this.isPulling || offsetY >= 0.0f || (weakReference = this.hrRecyclerViewWeakRef) == null || (kRRecyclerView = weakReference.get()) == null) {
            return;
        }
        kRRecyclerView.setForceOverScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(KRRecyclerView hrRecyclerView) {
        KRRecyclerView kRRecyclerView;
        KRRecyclerView kRRecyclerView2;
        r1 = null;
        r1 = null;
        WeakReference<KRRecyclerView> weakReference = null;
        if (hrRecyclerView == null) {
            WeakReference<KRRecyclerView> weakReference2 = this.hrRecyclerViewWeakRef;
            if (weakReference2 != null && (kRRecyclerView2 = weakReference2.get()) != null) {
                kRRecyclerView2.V0(this);
                ViewParent parent = kRRecyclerView2.getParent();
                if (!(parent instanceof KRView)) {
                    parent = null;
                }
                KRView kRView = (KRView) parent;
                if (kRView != null) {
                    kRView.setNestedScrollDelegate(null);
                }
                kRRecyclerView2.setNestedScrollingEnabled(false);
                Unit unit = Unit.INSTANCE;
            }
        } else {
            WeakReference<KRRecyclerView> weakReference3 = this.hrRecyclerViewWeakRef;
            if (weakReference3 != null && (kRRecyclerView = weakReference3.get()) != null) {
                kRRecyclerView.V0(this);
                kRRecyclerView.setNestedScrollingEnabled(false);
                Unit unit2 = Unit.INSTANCE;
            }
            hrRecyclerView.Z(this);
            hrRecyclerView.setNestedScrollingEnabled(true);
            ViewParent parent2 = hrRecyclerView.getParent();
            KRView kRView2 = (KRView) (parent2 instanceof KRView ? parent2 : null);
            if (kRView2 != null) {
                kRView2.setNestedScrollDelegate(this);
            }
            weakReference = new WeakReference<>(hrRecyclerView);
        }
        this.hrRecyclerViewWeakRef = weakReference;
    }

    static /* synthetic */ void O(HRAdsorptionPullView hRAdsorptionPullView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        hRAdsorptionPullView.N(z16);
    }

    static /* synthetic */ void V(HRAdsorptionPullView hRAdsorptionPullView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        hRAdsorptionPullView.U(z16);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        WeakReference<KRRecyclerView> weakReference;
        KRRecyclerView kRRecyclerView;
        if (velocityX != 0.0f || (weakReference = this.hrRecyclerViewWeakRef) == null || (kRRecyclerView = weakReference.get()) == null) {
            return false;
        }
        return kRRecyclerView.z0();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRAdsorptionPullView$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f102543d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f102544e;

        b(ViewGroup viewGroup, Function1 function1) {
            this.f102543d = viewGroup;
            this.f102544e = function1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            this.f102543d.removeOnAttachStateChangeListener(this);
            Function1 function1 = this.f102544e;
            ViewParent parent = this.f102543d.getParent();
            if (!(parent instanceof KRRecyclerView)) {
                parent = null;
            }
            function1.invoke((KRRecyclerView) parent);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
        }
    }
}
