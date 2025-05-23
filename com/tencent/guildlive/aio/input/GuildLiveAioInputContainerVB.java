package com.tencent.guildlive.aio.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVB$globalLayoutListener$2;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import fo0.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00019B\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J&\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u001a\u0012\u0006\b\u0001\u0012\u00020\u001b0\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016R\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R#\u00100\u001a\n +*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Landroid/view/View$OnAttachStateChangeListener;", "", "k1", "", "videoScreenState", "", "j1", "show", "l1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "bindViewAndData", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/tencent/aio/base/mvvm/b;", "f1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "state", "i1", "Lts0/a;", "d", "Lts0/a;", "getLiveAIOListener", "()Lts0/a;", "liveAIOListener", "e", "Landroid/view/View;", "mRootView", "f", "I", "lastViewH", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "h1", "()Landroid/view/View;", "notInputIconLayoutShow", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "i", "g1", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "<init>", "(Lts0/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioInputContainerVB extends com.tencent.aio.base.mvvm.a<fo0.c, InputUIState> implements View.OnAttachStateChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastViewH = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy notInputIconLayoutShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy globalLayoutListener;

    public GuildLiveAioInputContainerVB(@Nullable ts0.a aVar) {
        Lazy lazy;
        Lazy lazy2;
        this.liveAIOListener = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVB$notInputIconLayoutShow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = GuildLiveAioInputContainerVB.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return view.findViewById(R.id.wsg);
            }
        });
        this.notInputIconLayoutShow = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveAioInputContainerVB$globalLayoutListener$2.a>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputContainerVB$globalLayoutListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guildlive/aio/input/GuildLiveAioInputContainerVB$globalLayoutListener$2$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes6.dex */
            public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildLiveAioInputContainerVB f112715d;

                a(GuildLiveAioInputContainerVB guildLiveAioInputContainerVB) {
                    this.f112715d = guildLiveAioInputContainerVB;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view;
                    View view2;
                    int i3;
                    int i16;
                    View view3;
                    boolean k16;
                    view = this.f112715d.mRootView;
                    if (view != null) {
                        view2 = this.f112715d.mRootView;
                        View view4 = null;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                            view2 = null;
                        }
                        if (view2.getVisibility() == 0) {
                            view3 = this.f112715d.mRootView;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                            } else {
                                view4 = view3;
                            }
                            i3 = view4.getHeight();
                            k16 = this.f112715d.k1();
                            if (k16) {
                                i3 += this.f112715d.getMContext().getResources().getDimensionPixelOffset(R.dimen.f158976cg1);
                            }
                        } else {
                            i3 = 0;
                        }
                        i16 = this.f112715d.lastViewH;
                        if (i3 != i16) {
                            this.f112715d.lastViewH = i3;
                            this.f112715d.sendIntent(new c.InputBarHeightChangeIntent(i3));
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildLiveAioInputContainerVB.this);
            }
        });
        this.globalLayoutListener = lazy2;
    }

    private final ViewTreeObserver.OnGlobalLayoutListener g1() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.globalLayoutListener.getValue();
    }

    private final View h1() {
        return (View) this.notInputIconLayoutShow.getValue();
    }

    private final void j1(int videoScreenState) {
        boolean z16;
        if (videoScreenState == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        l1(!z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k1() {
        boolean z16;
        if (h1().getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return !z16;
    }

    private final void l1(boolean show) {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        yr0.a.s(view, show);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        Logger.f235387a.d().i("GLAioInputContainer", 1, "[bindViewAndData] " + hashCode());
        sendIntent(c.a.f400132d);
        Integer liveVideoScreenState = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).getLiveVideoScreenState();
        Intrinsics.checkNotNullExpressionValue(liveVideoScreenState, "api(IGuildLiveChannelApi\u2026ava).liveVideoScreenState");
        j1(liveVideoScreenState.intValue());
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.removeOnAttachStateChangeListener(this);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        view2.addOnAttachStateChangeListener(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.c, InputUIState> getViewModel() {
        return new GuildLiveAioInputContainerVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildLiveAioInputUIState.VideoScreenChange) {
            j1(((GuildLiveAioInputUIState.VideoScreenChange) state).getVideoScreenState());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new b(this.liveAIOListener), new ks0.c()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        frameLayout.setLayoutParams(a16);
        this.mRootView = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("GLAioInputContainer", 1, "[onDestroy] " + hashCode());
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@Nullable View v3) {
        boolean z16;
        Integer num;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ViewTreeObserver viewTreeObserver3;
        int i3 = 0;
        if (v3 != null && (viewTreeObserver3 = v3.getViewTreeObserver()) != null && viewTreeObserver3.isAlive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            v3.getViewTreeObserver().addOnGlobalLayoutListener(g1());
        }
        Logger.a d16 = Logger.f235387a.d();
        Boolean bool = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.hashCode());
        } else {
            num = null;
        }
        if (v3 != null) {
            viewTreeObserver = v3.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            i3 = viewTreeObserver.hashCode();
        }
        if (v3 != null && (viewTreeObserver2 = v3.getViewTreeObserver()) != null) {
            bool = Boolean.valueOf(viewTreeObserver2.isAlive());
        }
        d16.i("GLAioInputContainer", 1, "[onViewAttachedToWindow] " + num + ", " + i3 + ", " + bool);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@Nullable View v3) {
        boolean z16;
        Integer num;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ViewTreeObserver viewTreeObserver3;
        int i3 = 0;
        if (v3 != null && (viewTreeObserver3 = v3.getViewTreeObserver()) != null && viewTreeObserver3.isAlive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            v3.getViewTreeObserver().removeOnGlobalLayoutListener(g1());
        }
        if (v3 != null) {
            v3.removeOnAttachStateChangeListener(this);
        }
        Logger.a d16 = Logger.f235387a.d();
        Boolean bool = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.hashCode());
        } else {
            num = null;
        }
        if (v3 != null) {
            viewTreeObserver = v3.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            i3 = viewTreeObserver.hashCode();
        }
        if (v3 != null && (viewTreeObserver2 = v3.getViewTreeObserver()) != null) {
            bool = Boolean.valueOf(viewTreeObserver2.isAlive());
        }
        d16.i("GLAioInputContainer", 1, "[onViewDetachedFromWindow] " + num + ", " + i3 + ", " + bool);
    }
}
