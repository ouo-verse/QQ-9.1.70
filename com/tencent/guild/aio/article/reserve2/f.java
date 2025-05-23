package com.tencent.guild.aio.article.reserve2;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAIoNavigateButtonUIState;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qq0.b;
import vn0.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\n0\tH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/article/reserve2/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "", "e1", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "state", "g1", "", "Ljava/lang/Class;", "getObserverStates", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "c1", "Lvn0/j;", "d", "Lvn0/j;", "mNavigationButtonBinding", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends com.tencent.aio.base.mvvm.a<qq0.b, GuildAIoNavigateButtonUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private j mNavigationButtonBinding;

    private final void e1() {
        sendIntent(new b.C11093b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1(GuildAIoNavigateButtonUIState.NavButtonUnreadCntText state) {
        int mUnreadCount = state.getMUnreadCount();
        j jVar = null;
        if (mUnreadCount > 0) {
            j jVar2 = this.mNavigationButtonBinding;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                jVar2 = null;
            }
            jVar2.f441965c.setText(String.valueOf(mUnreadCount));
            j jVar3 = this.mNavigationButtonBinding;
            if (jVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
                jVar3 = null;
            }
            jVar3.f441965c.setBackgroundResource(R.drawable.guild_aio_unread_bg);
            j jVar4 = this.mNavigationButtonBinding;
            if (jVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            } else {
                jVar = jVar4;
            }
            jVar.f441964b.setVisibility(0);
            return;
        }
        j jVar5 = this.mNavigationButtonBinding;
        if (jVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            jVar5 = null;
        }
        jVar5.f441965c.setText("");
        j jVar6 = this.mNavigationButtonBinding;
        if (jVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
            jVar6 = null;
        }
        jVar6.f441965c.setBackgroundResource(R.drawable.guild_aio_back_bottom);
        j jVar7 = this.mNavigationButtonBinding;
        if (jVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
        } else {
            jVar = jVar7;
        }
        jVar.f441964b.setVisibility(8);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<qq0.b, GuildAIoNavigateButtonUIState> createVM() {
        return new GuildArticleAIONavigateButtonVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAIoNavigateButtonUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAIoNavigateButtonUIState.NavButtonUnreadCntText) {
            g1((GuildAIoNavigateButtonUIState.NavButtonUnreadCntText) state);
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
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAIoNavigateButtonUIState>> getObserverStates() {
        List<Class<? extends GuildAIoNavigateButtonUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAIoNavigateButtonUIState.NavButtonUnreadCntText.class, GuildAIoNavigateButtonUIState.NavButtonPaddingBottom.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        j g16 = j.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        this.mNavigationButtonBinding = g16;
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 85;
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
            jVar3 = null;
        }
        jVar3.f441965c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.reserve2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.f1(f.this, view);
            }
        });
        j jVar4 = this.mNavigationButtonBinding;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationButtonBinding");
        } else {
            jVar2 = jVar4;
        }
        LinearLayout root = jVar2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mNavigationButtonBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
    }
}
