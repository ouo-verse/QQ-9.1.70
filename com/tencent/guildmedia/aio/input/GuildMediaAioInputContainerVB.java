package com.tencent.guildmedia.aio.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guildmedia.aio.input.GuildMediaAioInputContainerVB$globalLayoutListener$2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fo0.c;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001+B\u0017\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J&\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u00110\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "f1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Ljava/lang/ref/WeakReference;", "Let0/a;", "d", "Ljava/lang/ref/WeakReference;", "aioListenerRef", "e", "Landroid/view/View;", "mRootView", "", "f", "I", "lastViewH", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", tl.h.F, "Lkotlin/Lazy;", "g1", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "<init>", "(Ljava/lang/ref/WeakReference;)V", "i", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAioInputContainerVB extends com.tencent.aio.base.mvvm.a<fo0.c, InputUIState> implements View.OnAttachStateChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<et0.a> aioListenerRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastViewH;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy globalLayoutListener;

    public GuildMediaAioInputContainerVB(@NotNull WeakReference<et0.a> aioListenerRef) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioListenerRef, "aioListenerRef");
        this.aioListenerRef = aioListenerRef;
        this.lastViewH = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaAioInputContainerVB$globalLayoutListener$2.a>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputContainerVB$globalLayoutListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guildmedia/aio/input/GuildMediaAioInputContainerVB$globalLayoutListener$2$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes6.dex */
            public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildMediaAioInputContainerVB f113008d;

                a(GuildMediaAioInputContainerVB guildMediaAioInputContainerVB) {
                    this.f113008d = guildMediaAioInputContainerVB;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view;
                    View view2;
                    int i3;
                    int i16;
                    View view3;
                    view = this.f113008d.mRootView;
                    if (view != null) {
                        view2 = this.f113008d.mRootView;
                        View view4 = null;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                            view2 = null;
                        }
                        if (view2.getVisibility() == 0) {
                            view3 = this.f113008d.mRootView;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                            } else {
                                view4 = view3;
                            }
                            i3 = view4.getHeight();
                        } else {
                            i3 = 0;
                        }
                        i16 = this.f113008d.lastViewH;
                        if (i3 != i16) {
                            this.f113008d.lastViewH = i3;
                            this.f113008d.sendIntent(new c.InputBarHeightChangeIntent(i3));
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
                return new a(GuildMediaAioInputContainerVB.this);
            }
        });
        this.globalLayoutListener = lazy;
    }

    private final ViewTreeObserver.OnGlobalLayoutListener g1() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.globalLayoutListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        Logger.f235387a.d().i("GMAioInputContainer", 1, "[bindViewAndData] " + hashCode());
        sendIntent(c.a.f400132d);
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
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildMediaAioInputViewBinder(this.aioListenerRef));
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAioInputContainerVB.h1(view);
            }
        });
        a16.gravity = 80;
        linearLayout.setLayoutParams(a16);
        linearLayout.setOrientation(1);
        this.mRootView = linearLayout;
        return linearLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("GMAioInputContainer", 1, "[onDestroy] " + hashCode());
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@Nullable View v3) {
        Integer num;
        Integer num2;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ViewTreeObserver viewTreeObserver3;
        boolean z16 = false;
        if (v3 != null && (viewTreeObserver3 = v3.getViewTreeObserver()) != null && viewTreeObserver3.isAlive()) {
            z16 = true;
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
        if (v3 != null && (viewTreeObserver2 = v3.getViewTreeObserver()) != null) {
            num2 = Integer.valueOf(viewTreeObserver2.hashCode());
        } else {
            num2 = null;
        }
        if (v3 != null && (viewTreeObserver = v3.getViewTreeObserver()) != null) {
            bool = Boolean.valueOf(viewTreeObserver.isAlive());
        }
        d16.i("GMAioInputContainer", 1, "[onViewAttachedToWindow]  " + num + ", " + num2 + ", " + bool);
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
        d16.i("GMAioInputContainer", 1, "[onViewDetachedFromWindow] " + num + ", " + i3 + ", " + bool);
    }
}
