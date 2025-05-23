package com.tencent.mobileqq.wink.editor.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.template.event.WinkTemplateLoadingDialogDismissEvent;
import com.tencent.mobileqq.wink.event.FilterSelectedEvent;
import com.tencent.mobileqq.wink.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.wink.event.ResourcePreDownFinishEvent;
import com.tencent.mobileqq.wink.event.TemplateSelectEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AnimateUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0005H&J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0014J$\u0010!\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0014J\b\u0010\"\u001a\u00020\u0005H\u0014J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016J$\u0010&\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0014J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016J\u001a\u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020*H\u0014J\b\u0010.\u001a\u00020\u0005H\u0014J\b\u00100\u001a\u00020/H\u0014J\u0012\u00102\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00106\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030403j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000304`5H\u0016J\b\u00108\u001a\u000207H\u0016R\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R(\u0010E\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR(\u0010H\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\bF\u0010B\u001a\u0004\bG\u0010DR\u001a\u0010M\u001a\u00020#8\u0014X\u0094D\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010NR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010\\\u001a\u00020W8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/lifecycle/LifecycleOwner;", "", "ha", "ga", "ia", "Landroid/view/View$OnClickListener;", "Y9", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "pa", "ma", "la", "args", "Q9", "x9", "L9", "Lkotlin/Function0;", "onStartAction", "onEndAction", "ua", "onDismiss", "", "disableAnim", LocaleUtils.L_JAPANESE, "ta", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "", "bottomOffset", "topOffset", "ra", "qa", "Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "aa", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "D", "Landroid/view/View$OnClickListener;", "clickBlankSpaceListener", "E", "Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "materialViewModel", "Landroid/view/animation/Animation;", "<set-?>", UserInfo.SEX_FEMALE, "Landroid/view/animation/Animation;", "da", "()Landroid/view/animation/Animation;", "slideUpAnimation", "G", "ca", "slideDownAnimation", "H", "Z", "X9", "()Z", "autoAnimate", "I", "Landroid/view/View;", "playerContainerBottomSpace", "J", "bottomSpace", "Landroidx/lifecycle/LifecycleRegistry;", "K", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleOwner", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "L", "Lkotlin/Lazy;", "ea", "()Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkEditorMenuPart extends com.tencent.mobileqq.wink.editor.d implements SimpleEventReceiver<SimpleBaseEvent>, LifecycleOwner {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener clickBlankSpaceListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkMaterialViewModel materialViewModel;

    /* renamed from: F */
    @Nullable
    private Animation slideUpAnimation;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Animation slideDownAnimation;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean autoAnimate = true;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View playerContainerBottomSpace;

    /* renamed from: J, reason: from kotlin metadata */
    private int bottomSpace;

    /* renamed from: K, reason: from kotlin metadata */
    private LifecycleRegistry lifecycleOwner;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkEditPerformanceViewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart$a", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends AnimateUtils.AnimationAdapter {
        a() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            WinkEditorMenuPart.this.pa();
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            WinkEditorMenuPart.super.L9(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart$b", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends AnimateUtils.AnimationAdapter {
        b() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            WinkEditorMenuPart.super.onDismiss();
            WinkEditorMenuPart.this.la();
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            WinkEditorMenuPart.this.ma();
        }
    }

    public WinkEditorMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditPerformanceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart$winkEditPerformanceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditPerformanceViewModel invoke() {
                return (WinkEditPerformanceViewModel) WinkEditorMenuPart.this.getViewModel(WinkEditPerformanceViewModel.class);
            }
        });
        this.winkEditPerformanceViewModel = lazy;
    }

    private final View.OnClickListener Y9() {
        if (this.clickBlankSpaceListener == null) {
            this.clickBlankSpaceListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.menu.as
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorMenuPart.Z9(WinkEditorMenuPart.this, view);
                }
            };
        }
        return this.clickBlankSpaceListener;
    }

    public static final void Z9(WinkEditorMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9().l5();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void ga() {
        this.slideUpAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155067i2);
        this.slideDownAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155066i1);
    }

    private final void ha() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkEditorMenuPart$initAnimationAsync$1(this, null), 3, null);
    }

    public final void ia() {
        Animation animation = this.slideUpAnimation;
        if (animation != null) {
            animation.setAnimationListener(new a());
        }
        Animation animation2 = this.slideDownAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(new b());
        }
    }

    public static final void na(WinkEditorMenuPart this$0, MenuSwitchAction action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.getMenuType() == this$0.ba()) {
            super.Q9(action.getArgs());
            if (action.getMenuType() == MenuType.VIDEO_TEMPLATE && this$0.G9().getIsAutoTemplate() && action.getArgs() != null) {
                Bundle args = action.getArgs();
                Intrinsics.checkNotNull(args);
                if (args.getBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, false)) {
                    WinkEditorViewModel.v5(this$0.G9(), MenuType.BOTTOM_DASHBOARD, null, 2, null);
                    if (!NetworkUtil.isNetworkAvailable()) {
                        QQToast.makeText(this$0.getContext(), 1, this$0.getContext().getString(R.string.ynb), 0).show();
                        this$0.G9().R4(false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this$0.ba() != MenuType.SUBTITLE || action.getMenuType() != MenuType.SUBTITLE_TEXT) {
            super.x9();
        }
    }

    public static /* synthetic */ void sa(WinkEditorMenuPart winkEditorMenuPart, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i16 = 0;
            }
            winkEditorMenuPart.ra(i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideUpPlayer");
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        View partRootView;
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        if (getViewStubIsInflated() && (partRootView = getPartRootView()) != null) {
            if (editMode == WinkEditorViewModel.EditMode.Image) {
                partRootView.setOnClickListener(Y9());
                return;
            }
            partRootView.setOnClickListener(null);
            partRootView.setFocusable(false);
            partRootView.setClickable(false);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        View partRootView;
        LifecycleRegistry lifecycleRegistry = this.lifecycleOwner;
        if (lifecycleRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleRegistry = null;
        }
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (getAutoAnimate()) {
            if (this.slideUpAnimation != null && (partRootView = getPartRootView()) != null) {
                partRootView.startAnimation(this.slideUpAnimation);
            }
        } else {
            ua(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart$onShow$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    super/*com.tencent.mobileqq.wink.editor.d*/.L9(null);
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart$onShow$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    WinkEditorMenuPart.this.pa();
                }
            });
        }
        ea().a2();
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public final void Q9(@Nullable Bundle args) {
        G9().u5(ba(), args);
    }

    /* renamed from: X9, reason: from getter */
    protected boolean getAutoAnimate() {
        return this.autoAnimate;
    }

    @NotNull
    public WinkMaterialViewModel aa() {
        if (this.materialViewModel == null) {
            this.materialViewModel = (WinkMaterialViewModel) getViewModel(WinkMaterialViewModel.class);
        }
        WinkMaterialViewModel winkMaterialViewModel = this.materialViewModel;
        Intrinsics.checkNotNull(winkMaterialViewModel);
        return winkMaterialViewModel;
    }

    @NotNull
    public abstract MenuType ba();

    @Nullable
    /* renamed from: ca, reason: from getter */
    public final Animation getSlideDownAnimation() {
        return this.slideDownAnimation;
    }

    @Nullable
    /* renamed from: da, reason: from getter */
    public final Animation getSlideUpAnimation() {
        return this.slideUpAnimation;
    }

    @NotNull
    public final WinkEditPerformanceViewModel ea() {
        Object value = this.winkEditPerformanceViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkEditPerformanceViewModel>(...)");
        return (WinkEditPerformanceViewModel) value;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ResourcePreDownFinishEvent.class);
        arrayList.add(FilterSelectedEvent.class);
        arrayList.add(ReceiveSchemaEvent.class);
        arrayList.add(TemplateSelectEvent.class);
        arrayList.add(WinkTemplateLoadingDialogDismissEvent.class);
        return arrayList;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        LifecycleRegistry lifecycleRegistry = this.lifecycleOwner;
        if (lifecycleRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            return null;
        }
        return lifecycleRegistry;
    }

    public void ja(boolean z16) {
        View partRootView;
        ea().Q1();
        LifecycleRegistry lifecycleRegistry = this.lifecycleOwner;
        LifecycleRegistry lifecycleRegistry2 = null;
        if (lifecycleRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleRegistry = null;
        }
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        LifecycleRegistry lifecycleRegistry3 = this.lifecycleOwner;
        if (lifecycleRegistry3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        } else {
            lifecycleRegistry2 = lifecycleRegistry3;
        }
        lifecycleRegistry2.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        if (z16) {
            super.onDismiss();
            return;
        }
        if (getAutoAnimate()) {
            if (this.slideDownAnimation != null && (partRootView = getPartRootView()) != null) {
                partRootView.startAnimation(this.slideDownAnimation);
                return;
            }
            return;
        }
        ta(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart$onDismiss$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                WinkEditorMenuPart.this.ma();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart$onDismiss$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                super/*com.tencent.mobileqq.wink.editor.d*/.onDismiss();
            }
        });
    }

    public abstract void oa();

    @Override // com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        ja(false);
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View r36) {
        Intrinsics.checkNotNullParameter(r36, "rootView");
        super.onInitView(r36);
        LifecycleRegistry lifecycleRegistry = this.lifecycleOwner;
        if (lifecycleRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleRegistry = null;
        }
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.playerContainerBottomSpace = r36.findViewById(R.id.f25770bq);
        this.bottomSpace = getContext().getResources().getDimensionPixelSize(R.dimen.djf);
        G9().f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.menu.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMenuPart.na(WinkEditorMenuPart.this, (MenuSwitchAction) obj);
            }
        });
        ha();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity r26, @Nullable Bundle r36) {
        Intrinsics.checkNotNullParameter(r26, "activity");
        super.onPartCreate(r26, r36);
        SimpleEventBus.getInstance().registerReceiver(this);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.lifecycleOwner = lifecycleRegistry;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity r26) {
        Intrinsics.checkNotNullParameter(r26, "activity");
        super.onPartDestroy(r26);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        LifecycleRegistry lifecycleRegistry = this.lifecycleOwner;
        if (lifecycleRegistry != null) {
            if (lifecycleRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleRegistry = null;
            }
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
    }

    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ResourcePreDownFinishEvent) {
            oa();
        }
    }

    public void qa() {
        boolean z16;
        G9().T1(false);
        dr H9 = H9();
        if (H9 != null) {
            if (ba() != MenuType.STICKER_TIMELINE && ba() != MenuType.EFFECT && ba() != MenuType.SUBTITLE && ba() != MenuType.LYRIC_STICKER && ba() != MenuType.TEMPLATE_TEXT_LIST && ba() != MenuType.TEMPLATE_COLL_CLIP) {
                z16 = false;
            } else {
                z16 = true;
            }
            H9.Y(true, 0, 0, z16);
        }
    }

    public void ra(int bottomOffset, int topOffset) {
        if (bottomOffset <= this.bottomSpace) {
            return;
        }
        boolean z16 = true;
        G9().T1(true);
        dr H9 = H9();
        if (H9 != null) {
            if (ba() != MenuType.STICKER_TIMELINE && ba() != MenuType.EFFECT && ba() != MenuType.SUBTITLE && ba() != MenuType.LYRIC_STICKER && ba() != MenuType.TEMPLATE_TEXT_LIST && ba() != MenuType.TEMPLATE_COLL_CLIP) {
                z16 = false;
            }
            H9.Y(false, bottomOffset, topOffset, z16);
        }
    }

    public void ta(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
    }

    protected void ua(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void x9() {
        if (!G9().getIsDisableOther()) {
            G9().l5();
        }
    }

    public void la() {
    }

    public void ma() {
    }

    public void pa() {
    }
}
