package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.g;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b6\u00107J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u000f\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00160\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"RH\u0010-\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/input/base/mvicompat/b;", "", "o1", "l1", "q1", "com/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVB$a", "i1", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVB$a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "intent", "f1", "state", "k1", "", "Ljava/lang/Class;", "getObserverStates", "bindViewAndData", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVM;", "j1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "globalScope", "Lcom/tencent/input/base/mvicompat/g;", "Landroidx/viewbinding/ViewBinding;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVBDelegateMediator;", "e", "Lcom/tencent/input/base/mvicompat/g;", "getDelegateMediator", "()Lcom/tencent/input/base/mvicompat/g;", "setDelegateMediator", "(Lcom/tencent/input/base/mvicompat/g;)V", "delegateMediator", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "binding", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "globalController", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorGlobalVB extends BaseVB<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.mvi.api.runtime.b> implements com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f globalScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> delegateMediator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimplifiedFeedEditorViewBinding binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SimplifiedFeedEditorGlobalController globalController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVB$a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements SimplifiedFeedEditorGlobalController.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController.b
        public void a() {
            FeedEditorGlobalVB feedEditorGlobalVB = FeedEditorGlobalVB.this;
            FeedEditorGlobalIntent.b a16 = FeedEditorGlobalIntent.INSTANCE.a();
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = FeedEditorGlobalVB.this.globalController;
            if (simplifiedFeedEditorGlobalController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("globalController");
                simplifiedFeedEditorGlobalController = null;
            }
            a16.d(new FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent(simplifiedFeedEditorGlobalController.getCloseIntent(), false, 2, null));
            feedEditorGlobalVB.sendIntent(a16);
        }
    }

    public FeedEditorGlobalVB(@NotNull f globalScope) {
        Intrinsics.checkNotNullParameter(globalScope, "globalScope");
        this.globalScope = globalScope;
    }

    private final a i1() {
        return new a();
    }

    private final void l1() {
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this.binding;
        Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding);
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = null;
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = new SimplifiedFeedEditorGlobalController(simplifiedFeedEditorViewBinding, null, 2, null);
        simplifiedFeedEditorGlobalController2.A();
        this.globalController = simplifiedFeedEditorGlobalController2;
        simplifiedFeedEditorGlobalController2.M(i1());
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding2 = this.binding;
        Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding2);
        View mContainer = simplifiedFeedEditorViewBinding2.getMContainer();
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController3 = this.globalController;
        if (simplifiedFeedEditorGlobalController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalController");
            simplifiedFeedEditorGlobalController3 = null;
        }
        n.y(mContainer, SimplifiedFeedEditorGlobalController.class, simplifiedFeedEditorGlobalController3);
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding3 = this.binding;
        Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding3);
        View mContainer2 = simplifiedFeedEditorViewBinding3.getMContainer();
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController4 = this.globalController;
        if (simplifiedFeedEditorGlobalController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalController");
            simplifiedFeedEditorGlobalController4 = null;
        }
        n.y(mContainer2, am1.a.class, simplifiedFeedEditorGlobalController4);
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController5 = this.globalController;
        if (simplifiedFeedEditorGlobalController5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalController");
            simplifiedFeedEditorGlobalController5 = null;
        }
        simplifiedFeedEditorGlobalController5.O(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalVB$initializeGlobalController$2
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
                SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding4;
                SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding5;
                SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding6;
                com.tencent.mvi.api.runtime.b safetyContext;
                Fragment c16;
                FragmentActivity activity;
                FrameworkVM mUIModel = FeedEditorGlobalVB.this.getMUIModel();
                Window window = (mUIModel == null || (safetyContext = mUIModel.getSafetyContext()) == null || (c16 = safetyContext.c()) == null || (activity = c16.getActivity()) == null) ? null : activity.getWindow();
                if (window == null) {
                    return;
                }
                simplifiedFeedEditorViewBinding4 = FeedEditorGlobalVB.this.binding;
                if (simplifiedFeedEditorViewBinding4 == null) {
                    return;
                }
                if (z16) {
                    simplifiedFeedEditorViewBinding6 = FeedEditorGlobalVB.this.binding;
                    Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding6);
                    QUIImmersiveHelper.t(window, true, simplifiedFeedEditorViewBinding6.v(), false, null);
                } else {
                    simplifiedFeedEditorViewBinding5 = FeedEditorGlobalVB.this.binding;
                    Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding5);
                    QUIImmersiveHelper.t(window, true, simplifiedFeedEditorViewBinding5.getWhiteSheetBackground(), false, null);
                }
            }
        });
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController6 = this.globalController;
        if (simplifiedFeedEditorGlobalController6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalController");
        } else {
            simplifiedFeedEditorGlobalController = simplifiedFeedEditorGlobalController6;
        }
        simplifiedFeedEditorGlobalController.L(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Activity m16;
                m16 = FeedEditorGlobalVB.m1(FeedEditorGlobalVB.this);
                return m16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity m1(FeedEditorGlobalVB this$0) {
        com.tencent.mvi.api.runtime.b safetyContext;
        Fragment c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        if (mUIModel != null && (safetyContext = mUIModel.getSafetyContext()) != null && (c16 = safetyContext.c()) != null) {
            return c16.getActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View n1(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "$createViewParams");
        return createViewParams.b();
    }

    private final void o1() {
        View whiteSheetBackground;
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this.binding;
        if (simplifiedFeedEditorViewBinding != null && (whiteSheetBackground = simplifiedFeedEditorViewBinding.getWhiteSheetBackground()) != null) {
            whiteSheetBackground.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedEditorGlobalVB.p1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q1() {
        View mContainer;
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this.binding;
        if (simplifiedFeedEditorViewBinding != null && (mContainer = simplifiedFeedEditorViewBinding.getMContainer()) != null) {
            mContainer.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.b
                @Override // java.lang.Runnable
                public final void run() {
                    FeedEditorGlobalVB.r1(FeedEditorGlobalVB.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(FeedEditorGlobalVB this$0) {
        Window window;
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding;
        View whiteSheetBackground;
        com.tencent.mvi.api.runtime.b safetyContext;
        Fragment c16;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        if (mUIModel != null && (safetyContext = mUIModel.getSafetyContext()) != null && (c16 = safetyContext.c()) != null && (activity = c16.getActivity()) != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window != null && (simplifiedFeedEditorViewBinding = this$0.binding) != null && (whiteSheetBackground = simplifiedFeedEditorViewBinding.getWhiteSheetBackground()) != null) {
            QUIImmersiveHelper.t(window, false, null, true, whiteSheetBackground);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        if (gVar != null) {
            gVar.a();
        }
        q1();
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull FeedEditorGlobalIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        sendIntent(intent);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        if (gVar != null) {
            return gVar.generateVBState(stateCmd);
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends FeedEditorGlobalUIState>> getObserverStates() {
        List<Class<? extends FeedEditorGlobalUIState>> emptyList;
        List<Class<? extends FeedEditorGlobalUIState>> l3;
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        if (gVar == null || (l3 = gVar.l()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return l3;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public FeedEditorGlobalVM createVM() {
        return new FeedEditorGlobalVM(this.globalScope);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull FeedEditorGlobalUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof FeedEditorGlobalUIState.WhiteSheetGuideLineAlignState) {
            SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this.binding;
            if (simplifiedFeedEditorViewBinding != null) {
                simplifiedFeedEditorViewBinding.A(((FeedEditorGlobalUIState.WhiteSheetGuideLineAlignState) state).getIsAlignFirstLayerTop());
                return;
            }
            return;
        }
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        if (gVar != null) {
            gVar.f(state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.mobileqq.guild.feed.nativepublish.feature.a] */
    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull final com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Object s16 = n.s(createViewParams.b(), ViewBinding.class);
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = null;
        if (!(s16 instanceof SimplifiedFeedEditorViewBinding)) {
            s16 = null;
        }
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = (SimplifiedFeedEditorViewBinding) s16;
        this.binding = simplifiedFeedEditorViewBinding;
        if (simplifiedFeedEditorViewBinding == null) {
            return createViewParams.b();
        }
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding2 = simplifiedFeedEditorViewBinding;
        if (gVar != null) {
            if (simplifiedFeedEditorViewBinding == null) {
                simplifiedFeedEditorViewBinding2 = new ViewBinding() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.a
                    @Override // androidx.viewbinding.ViewBinding
                    /* renamed from: getRoot */
                    public final View getMContainer() {
                        View n16;
                        n16 = FeedEditorGlobalVB.n1(com.tencent.mvi.api.help.a.this);
                        return n16;
                    }
                };
            }
            gVar.c(simplifiedFeedEditorViewBinding2);
        }
        l1();
        o1();
        f fVar = this.globalScope;
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
        if (simplifiedFeedEditorGlobalController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalController");
        } else {
            simplifiedFeedEditorGlobalController = simplifiedFeedEditorGlobalController2;
        }
        fVar.d(simplifiedFeedEditorGlobalController);
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding3 = this.binding;
        Intrinsics.checkNotNull(simplifiedFeedEditorViewBinding3);
        fVar.c(simplifiedFeedEditorViewBinding3.getAnchorView());
        return createViewParams.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        View mContainer;
        g<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.input.base.mvicompat.b<FeedEditorGlobalIntent>, ViewBinding> gVar = this.delegateMediator;
        if (gVar != null) {
            gVar.onDestroy();
        }
        SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding = this.binding;
        if (simplifiedFeedEditorViewBinding != null && (mContainer = simplifiedFeedEditorViewBinding.getMContainer()) != null) {
            n.D(mContainer, km1.b.class);
            n.D(mContainer, SimplifiedFeedEditorGlobalController.class);
        }
        super.onDestroy();
    }
}
