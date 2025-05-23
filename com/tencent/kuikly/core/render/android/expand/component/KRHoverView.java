package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView;
import com.tencent.kuikly.core.render.android.expand.component.list.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001?B\u000f\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00107\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRHoverView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/a;", "", "propValue", "", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "krRecyclerView", "", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "M", "N", "", "propKey", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "e", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerContentView;", "contentView", "Landroid/view/View;", "contentViewChild", "o", "", "offsetX", "offsetY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "j", "Ljava/lang/ref/WeakReference;", "H", "Ljava/lang/ref/WeakReference;", "krRecyclerViewWeakRef", "Landroid/graphics/Rect;", "I", "Landroid/graphics/Rect;", "cssFrame", "J", UserInfo.SEX_FEMALE, "hoverViewMarginTop", "K", "Ljava/lang/Float;", "hoverViewMaxMarginTop", "", "L", "Ljava/util/List;", "hoverViewSortList", "", "O", "()I", "setBringIndex", "(I)V", "bringIndex", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRHoverView extends KRView implements com.tencent.kuikly.core.render.android.expand.component.list.a {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private WeakReference<KRRecyclerView> krRecyclerViewWeakRef;

    /* renamed from: I, reason: from kotlin metadata */
    private Rect cssFrame;

    /* renamed from: J, reason: from kotlin metadata */
    private float hoverViewMarginTop;

    /* renamed from: K, reason: from kotlin metadata */
    private Float hoverViewMaxMarginTop;

    /* renamed from: L, reason: from kotlin metadata */
    private List<KRHoverView> hoverViewSortList;

    /* renamed from: M, reason: from kotlin metadata */
    private int bringIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRHoverView$a;", "", "", "BRING_INDEX", "Ljava/lang/String;", "MARGIN_TOP", "MAX_MARGIN_TOP", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRHoverView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRHoverView;", "kotlin.jvm.PlatformType", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "a", "(Lcom/tencent/kuikly/core/render/android/expand/component/KRHoverView;Lcom/tencent/kuikly/core/render/android/expand/component/KRHoverView;)I"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b<T> implements Comparator<KRHoverView> {

        /* renamed from: d, reason: collision with root package name */
        public static final b f117745d = new b();

        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(KRHoverView first, KRHoverView second) {
            int bringIndex = first.getBringIndex();
            Intrinsics.checkNotNullExpressionValue(first, "first");
            int max = Math.max(bringIndex, (int) first.getZ());
            int bringIndex2 = second.getBringIndex();
            Intrinsics.checkNotNullExpressionValue(second, "second");
            return max - Math.max(bringIndex2, (int) second.getZ());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRHoverView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hoverViewSortList = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof KRHoverView) {
                    this.hoverViewSortList.add(childAt);
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.hoverViewSortList, b.f117745d);
            Iterator<KRHoverView> it = this.hoverViewSortList.iterator();
            while (it.hasNext()) {
                viewGroup.bringChildToFront(it.next());
            }
            this.hoverViewSortList.clear();
        }
    }

    private final boolean N(Object propValue) {
        if (propValue != null) {
            this.bringIndex = ((Integer) propValue).intValue();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean P(Object propValue) {
        this.hoverViewMarginTop = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
        S();
        return true;
    }

    private final boolean Q(Object propValue) {
        this.hoverViewMaxMarginTop = Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue)));
        S();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(KRRecyclerView krRecyclerView) {
        WeakReference<KRRecyclerView> weakReference;
        KRRecyclerView kRRecyclerView;
        KRRecyclerView kRRecyclerView2;
        if (krRecyclerView == null) {
            WeakReference<KRRecyclerView> weakReference2 = this.krRecyclerViewWeakRef;
            if (weakReference2 != null && (kRRecyclerView2 = weakReference2.get()) != null) {
                kRRecyclerView2.V0(this);
            }
            weakReference = null;
        } else {
            WeakReference<KRRecyclerView> weakReference3 = this.krRecyclerViewWeakRef;
            if (weakReference3 != null && (kRRecyclerView = weakReference3.get()) != null) {
                kRRecyclerView.V0(this);
            }
            krRecyclerView.Z(this);
            weakReference = new WeakReference<>(krRecyclerView);
        }
        this.krRecyclerViewWeakRef = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        KRRecyclerView kRRecyclerView;
        WeakReference<KRRecyclerView> weakReference = this.krRecyclerViewWeakRef;
        if (weakReference != null && (kRRecyclerView = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(kRRecyclerView, "krRecyclerViewWeakRef?.get() ?: return");
            Rect rect = this.cssFrame;
            if (rect != null) {
                if (kRRecyclerView.getDirectionRow()) {
                    float contentOffsetX = kRRecyclerView.getContentOffsetX();
                    int i3 = rect.left;
                    float f16 = this.hoverViewMarginTop;
                    if (contentOffsetX > i3 - f16) {
                        setTranslationX((((int) contentOffsetX) + f16) - i3);
                    } else {
                        Float f17 = this.hoverViewMaxMarginTop;
                        if (f17 != null) {
                            float f18 = i3 - contentOffsetX;
                            Intrinsics.checkNotNull(f17);
                            if (f18 > f17.floatValue()) {
                                Float f19 = this.hoverViewMaxMarginTop;
                                Intrinsics.checkNotNull(f19);
                                setTranslationX((((int) contentOffsetX) + f19.floatValue()) - rect.left);
                            }
                        }
                        com.tencent.kuikly.core.render.android.css.animation.d.a(this);
                        setTranslationX(0.0f);
                        com.tencent.kuikly.core.render.android.css.ktx.b.p(this, rect);
                    }
                } else {
                    float contentOffsetY = kRRecyclerView.getContentOffsetY();
                    int i16 = rect.top;
                    ViewGroup.LayoutParams layoutParams = null;
                    if (contentOffsetY > i16 - this.hoverViewMarginTop) {
                        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            layoutParams = layoutParams2;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (marginLayoutParams != null) {
                            marginLayoutParams.topMargin = ((int) contentOffsetY) + ((int) this.hoverViewMarginTop);
                            setLayoutParams(marginLayoutParams);
                        }
                    } else {
                        Float f26 = this.hoverViewMaxMarginTop;
                        if (f26 != null) {
                            float f27 = i16 - contentOffsetY;
                            Intrinsics.checkNotNull(f26);
                            if (f27 > f26.floatValue()) {
                                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                    layoutParams = layoutParams3;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                                if (marginLayoutParams2 != null) {
                                    Float f28 = this.hoverViewMaxMarginTop;
                                    Intrinsics.checkNotNull(f28);
                                    marginLayoutParams2.topMargin = ((int) contentOffsetY) + ((int) f28.floatValue());
                                    setLayoutParams(marginLayoutParams2);
                                }
                            }
                        }
                        com.tencent.kuikly.core.render.android.css.ktx.b.p(this, rect);
                    }
                }
                M();
            }
        }
    }

    /* renamed from: O, reason: from getter */
    public final int getBringIndex() {
        return this.bringIndex;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        boolean N;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        int hashCode = propKey.hashCode();
        if (hashCode != -1797588384) {
            if (hashCode != -940758241) {
                if (hashCode == 2028386027 && propKey.equals("hoverMarginTop")) {
                    N = P(propValue);
                }
                N = super.b(propKey, propValue);
            } else {
                if (propKey.equals("hoverMaxMarginTop")) {
                    N = Q(propValue);
                }
                N = super.b(propKey, propValue);
            }
        } else {
            if (propKey.equals("bringIndex")) {
                N = N(propValue);
            }
            N = super.b(propKey, propValue);
        }
        if (Intrinsics.areEqual(propKey, AIInput.KEY_FRAME)) {
            this.cssFrame = (Rect) propValue;
            S();
        }
        return N;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.e(parent);
        R(null);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void j(float offsetX, float offsetY) {
        a.C5873a.c(this, offsetX, offsetY);
        S();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void l(float f16, float f17) {
        a.C5873a.a(this, f16, f17);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.n(parent);
        ViewParent parent2 = parent.getParent();
        if (!(parent2 instanceof KRRecyclerView)) {
            parent2 = null;
        }
        KRRecyclerView kRRecyclerView = (KRRecyclerView) parent2;
        Function1<KRRecyclerView, Unit> function1 = new Function1<KRRecyclerView, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRHoverView$onAddToParent$setupTask$1
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
            public final void invoke2(@Nullable KRRecyclerView kRRecyclerView2) {
                KRHoverView.this.R(kRRecyclerView2);
                KRHoverView.this.S();
            }
        };
        if (kRRecyclerView == null) {
            parent.addOnAttachStateChangeListener(new c(parent, function1));
        } else {
            function1.invoke(kRRecyclerView);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void o(@NotNull KRRecyclerContentView contentView, @NotNull View contentViewChild) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(contentViewChild, "contentViewChild");
        a.C5873a.b(this, contentView, contentViewChild);
        S();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.a
    public void onScroll(float offsetX, float offsetY) {
        S();
    }

    public final void setBringIndex(int i3) {
        this.bringIndex = i3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRHoverView$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f117746d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f117747e;

        c(ViewGroup viewGroup, Function1 function1) {
            this.f117746d = viewGroup;
            this.f117747e = function1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            this.f117746d.removeOnAttachStateChangeListener(this);
            Function1 function1 = this.f117747e;
            ViewParent parent = this.f117746d.getParent();
            if (!(parent instanceof KRRecyclerView)) {
                parent = null;
            }
            function1.invoke((KRRecyclerView) parent);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
        }
    }
}
