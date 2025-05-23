package com.tencent.guild.aio.article.input;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.guild.aio.input.GuildAioDefaultInputContainerViewModel;
import com.tencent.mvi.base.mvi.MviUIState;
import fo0.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00010\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/article/input/r;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "", "bindViewAndData", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class r extends com.tencent.aio.base.mvvm.a<fo0.c, InputUIState> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(r this$0, LinearLayout root, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(root, "$root");
        this$0.sendIntent(new c.InputBarHeightChangeIntent(root.getHeight()));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(c.a.f400132d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.c, InputUIState> getViewModel() {
        return new GuildAioDefaultInputContainerViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        int i3 = 3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new mp0.g(), new rp0.a(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new np0.a(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new pp0.a(0, 0, 0, null, 15, null), new com.tencent.guild.aio.article.input.slowmode.b(), new GuildArticleAIOInputViewBinder()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        linearLayout.setLayoutParams(a16);
        linearLayout.setOrientation(1);
        linearLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.guild.aio.article.input.q
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                r.d1(r.this, linearLayout, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        return linearLayout;
    }
}
