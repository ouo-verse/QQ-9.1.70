package com.tencent.guild.aio.background;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.guild.aio.background.GuildFullBackgroundUIState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u001c\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/background/GuildFullBackgroundVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundMviIntent;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "", "stop", "", "i1", "Landroid/view/View;", "view", "toRemove", "m1", "f1", ICustomDataEditor.NUMBER_PARAM_1, "k1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "l1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "d", "Z", "needMask", "Landroid/widget/FrameLayout;", "e", "Lkotlin/Lazy;", "g1", "()Landroid/widget/FrameLayout;", "bgViewContainer", "f", "h1", "()Landroid/view/View;", "mask", h.F, "Landroid/view/View;", "bgView", "<init>", "(Z)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildFullBackgroundVB extends com.tencent.aio.base.mvvm.a<GuildFullBackgroundMviIntent, GuildFullBackgroundUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean needMask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bgViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bgView;

    public /* synthetic */ GuildFullBackgroundVB(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    private final void f1(View view, boolean toRemove) {
        boolean z16;
        boolean z17 = true;
        if (toRemove) {
            if (g1().indexOfChild(view) == -1) {
                z17 = false;
            }
            if (z17) {
                g1().setBackgroundColor(getMContext().getResources().getColor(R.color.qui_common_bg_aio_01));
                g1().removeView(view);
                return;
            }
            return;
        }
        if (g1().indexOfChild(view) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (view.getParent() != null) {
                QLog.i("GuildFullBackgroundVB", 1, "view parent is not null: " + view.getParent() + ", forbid to add view: " + view);
                return;
            }
            g1().removeAllViews();
            if (this.needMask) {
                n1();
            }
            g1().addView(view, 0);
            g1().setBackgroundResource(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout g1() {
        return (FrameLayout) this.bgViewContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View h1() {
        return (View) this.mask.getValue();
    }

    private final void i1(final boolean stop) {
        View view = this.bgView;
        if (!(view instanceof d)) {
            QLog.i("GuildFullBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> the view: " + view + " is not aio backgroundView, return");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.background.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildFullBackgroundVB.j1(GuildFullBackgroundVB.this, stop);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(GuildFullBackgroundVB this$0, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KeyEvent.Callback callback = this$0.bgView;
        Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.guild.aio.background.IGuildBackgroundView");
        d dVar = (d) callback;
        boolean isFeatureSwitchOn = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("pause_bg_anim_when_scroll");
        View view = this$0.bgView;
        if (view != null) {
            i3 = view.hashCode();
        } else {
            i3 = 0;
        }
        QLog.i("GuildFullBackgroundVB", 1, "handleAIOBackgroundPlayEvent --> stop: " + z16 + ", scrollPauseAnim: " + isFeatureSwitchOn + ", bgView: " + i3);
        if (isFeatureSwitchOn) {
            if (z16) {
                dVar.backgroundPause();
            } else {
                dVar.backgroundResume();
            }
        }
    }

    private final void k1() {
        QLog.i("GuildFullBackgroundVB", 1, "[handleRemoveAIOBackground]: bgView is " + this.bgView);
        View view = this.bgView;
        if (view != null) {
            f1(view, true);
        }
    }

    private final void m1(View view, boolean toRemove) {
        if (!(view instanceof d)) {
            QLog.i("GuildFullBackgroundVB", 1, "the view: " + view + " is not aio backgroundView, forbid to add");
            return;
        }
        this.bgView = view;
        f1(view, toRemove);
    }

    private final void n1() {
        if (UIUtil.f112434a.A()) {
            IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
            Context context = g1().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "bgViewContainer.context");
            LiveData<Integer> obtainDrawableColor = iQQGuildUIUtilApi.obtainDrawableColor(context, R.drawable.qui_common_bg_primary_bg);
            Object context2 = g1().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.guild.aio.background.GuildFullBackgroundVB$observeMask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num) {
                    View h16;
                    View h17;
                    FrameLayout g16;
                    View h18;
                    View h19;
                    if (num != null) {
                        h16 = GuildFullBackgroundVB.this.h1();
                        h16.setBackgroundColor(g.a(num.intValue(), 80));
                        h17 = GuildFullBackgroundVB.this.h1();
                        ViewParent parent = h17.getParent();
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            h19 = GuildFullBackgroundVB.this.h1();
                            viewGroup.removeView(h19);
                        }
                        g16 = GuildFullBackgroundVB.this.g1();
                        h18 = GuildFullBackgroundVB.this.h1();
                        g16.addView(h18);
                    }
                }
            };
            obtainDrawableColor.observe((LifecycleOwner) context2, new Observer() { // from class: com.tencent.guild.aio.background.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFullBackgroundVB.o1(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        g1().removeAllViews();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: createVM */
    public BaseVM<GuildFullBackgroundMviIntent, GuildFullBackgroundUIState, com.tencent.aio.api.runtime.a> getViewModel() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildFullBackgroundUIState>> getObserverStates() {
        List<Class<? extends GuildFullBackgroundUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildFullBackgroundUIState.GuildUpdateAIOBackgroundView.class, GuildFullBackgroundUIState.GuildUpdateAIOBackgroundPlayEvent.class, GuildFullBackgroundUIState.GuildRemoveAIOBackgroundView.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildFullBackgroundUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildFullBackgroundUIState.GuildUpdateAIOBackgroundView) {
            GuildFullBackgroundUIState.GuildUpdateAIOBackgroundView guildUpdateAIOBackgroundView = (GuildFullBackgroundUIState.GuildUpdateAIOBackgroundView) state;
            m1(guildUpdateAIOBackgroundView.getView(), guildUpdateAIOBackgroundView.getToRemove());
        } else if (state instanceof GuildFullBackgroundUIState.GuildUpdateAIOBackgroundPlayEvent) {
            i1(((GuildFullBackgroundUIState.GuildUpdateAIOBackgroundPlayEvent) state).getStop());
        } else if (state instanceof GuildFullBackgroundUIState.GuildRemoveAIOBackgroundView) {
            k1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return g1();
    }

    public GuildFullBackgroundVB(boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        this.needMask = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guild.aio.background.GuildFullBackgroundVB$bgViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                FrameLayout frameLayout = new FrameLayout(GuildFullBackgroundVB.this.getMContext());
                GuildFullBackgroundVB guildFullBackgroundVB = GuildFullBackgroundVB.this;
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setId(R.id.wg_);
                frameLayout.setBackgroundColor(guildFullBackgroundVB.getMContext().getResources().getColor(R.color.qui_common_bg_aio_01));
                return frameLayout;
            }
        });
        this.bgViewContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.background.GuildFullBackgroundVB$mask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(GuildFullBackgroundVB.this.getMContext());
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                return view;
            }
        });
        this.mask = lazy2;
    }
}
