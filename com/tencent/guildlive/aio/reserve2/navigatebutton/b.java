package com.tencent.guildlive.aio.reserve2.navigatebutton;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAIoNavigateButtonUIState;
import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guildlive.aio.reserve2.navigatebar.GuildLiveNavigateBarUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qq0.b;
import tl.h;
import vn0.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/guildlive/aio/reserve2/navigatebutton/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "", "c1", "g1", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "state", "h1", "i1", "Lcom/tencent/aio/base/mvvm/b;", "e1", "Landroid/view/View;", "onCreateView", "bindViewAndData", "f1", "Lvn0/j;", "d", "Lvn0/j;", "mNavigationButtonBinding", "", "e", "Z", "mShowState", "f", "mIsLandScreen", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<qq0.b, GuildReserve2UIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private j mNavigationButtonBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShowState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandScreen;

    private final void c1(com.tencent.mvi.api.help.a createViewParams) {
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 8388693;
        j jVar = this.mNavigationButtonBinding;
        j jVar2 = null;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            jVar = null;
        }
        jVar.getRoot().setLayoutParams(a16);
        j jVar3 = this.mNavigationButtonBinding;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
        } else {
            jVar2 = jVar3;
        }
        jVar2.f441965c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.reserve2.navigatebutton.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.d1(b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1() {
        sendIntent(new b.C11093b());
    }

    private final void h1(GuildAIoNavigateButtonUIState.NavButtonUnreadCntText state) {
        String valueOf;
        boolean e16 = state.e();
        this.mShowState = e16;
        if (e16) {
            int mUnreadCount = state.getMUnreadCount();
            j jVar = null;
            if (mUnreadCount > 0) {
                j jVar2 = this.mNavigationButtonBinding;
                if (jVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                    jVar2 = null;
                }
                TextView textView = jVar2.f441965c;
                if (mUnreadCount > 99) {
                    valueOf = "99+";
                } else {
                    valueOf = String.valueOf(mUnreadCount);
                }
                textView.setText(valueOf);
                j jVar3 = this.mNavigationButtonBinding;
                if (jVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                } else {
                    jVar = jVar3;
                }
                jVar.f441965c.setBackgroundResource(R.drawable.guild_aio_unread_bg);
            } else {
                j jVar4 = this.mNavigationButtonBinding;
                if (jVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                    jVar4 = null;
                }
                jVar4.f441965c.setText("");
                j jVar5 = this.mNavigationButtonBinding;
                if (jVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                } else {
                    jVar = jVar5;
                }
                jVar.f441965c.setBackgroundResource(R.drawable.guild_aio_back_bottom);
            }
        }
        i1();
    }

    private final void i1() {
        boolean z16;
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioNavigateBut", "[updateNavigateButtonVisible] mShowState = " + this.mShowState + ", mIsLandScreen = " + this.mIsLandScreen);
        j jVar = this.mNavigationButtonBinding;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            jVar = null;
        }
        LinearLayout linearLayout = jVar.f441964b;
        if (this.mShowState && !this.mIsLandScreen) {
            z16 = true;
        } else {
            z16 = false;
        }
        yr0.a.s(linearLayout, z16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<qq0.b, GuildReserve2UIState> createVM() {
        return new GuildLiveAioNavigateButtonVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildReserve2UIState state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAIoNavigateButtonUIState.NavButtonUnreadCntText) {
            h1((GuildAIoNavigateButtonUIState.NavButtonUnreadCntText) state);
            return;
        }
        if (state instanceof GuildAIoNavigateButtonUIState.NavButtonPaddingBottom) {
            j jVar = this.mNavigationButtonBinding;
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                jVar = null;
            }
            LinearLayout root = jVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mNavigationButtonBinding.root");
            ViewExtKt.c(root, ((GuildAIoNavigateButtonUIState.NavButtonPaddingBottom) state).getCom.tencent.mtt.hippy.dom.node.NodeProps.PADDING_BOTTOM java.lang.String());
            return;
        }
        if (state instanceof GuildLiveNavigateBarUIState.VideoScreenChange) {
            if (((GuildLiveNavigateBarUIState.VideoScreenChange) state).getState() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsLandScreen = z16;
            i1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        j g16 = j.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.mNavigationButtonBinding = g16;
        c1(createViewParams);
        j jVar = this.mNavigationButtonBinding;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            jVar = null;
        }
        LinearLayout root = jVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mNavigationButtonBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
    }
}
