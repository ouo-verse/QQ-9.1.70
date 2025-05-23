package com.tencent.guildlive.aio.input;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.guildlive.widget.GuildLiveInputContainerLinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import np0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J&\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\r0\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guildlive/aio/input/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "state", "", "c1", "Lts0/a;", "d", "Lts0/a;", "getLiveAIOListener", "()Lts0/a;", "liveAIOListener", "e", "Landroid/view/View;", "mRootView", "<init>", "(Lts0/a;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<fo0.c, InputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    public b(@Nullable ts0.a aVar) {
        this.liveAIOListener = aVar;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.c, InputUIState> getViewModel() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildLiveAioInputUIState.GuildMultiSelectState) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            yr0.a.s(view, !((GuildLiveAioInputUIState.GuildMultiSelectState) state).getShow());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        a.b bVar = new a.b(0, 0, 0, 7, null);
        bVar.d(R.drawable.guild_live_icon_mute);
        bVar.e(R.drawable.guild_live_aio_mute_bg);
        bVar.f(R.color.bpw);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new mp0.c(Integer.valueOf(R.drawable.guild_live_aio_mute_bg)), new js0.b(), new ls0.a(), new rp0.a(bVar, null, 2, null), new np0.a(bVar, null, 2, null), new pp0.a(R.string.f197344jr, 0, R.color.bqc, null, 10, null), new GuildLiveAioInputViewBinder(this.liveAIOListener)});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        GuildLiveInputContainerLinearLayout guildLiveInputContainerLinearLayout = new GuildLiveInputContainerLinearLayout(createViewParams.a(), null, 0, 6, null);
        guildLiveInputContainerLinearLayout.a(this.liveAIOListener);
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        guildLiveInputContainerLinearLayout.setLayoutParams(a16);
        guildLiveInputContainerLinearLayout.setOrientation(1);
        this.mRootView = guildLiveInputContainerLinearLayout;
        return guildLiveInputContainerLinearLayout;
    }
}
