package com.tencent.guild.aio.component.avatar;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarUIState;
import com.tencent.guild.aio.component.avatar.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/avatar/a;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", "guildId", "", "c1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", "state", "f1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mAvatarLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "e", "Lkotlin/Lazy;", "e1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatarView", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioUserAvatarViewBinder extends com.tencent.aio.base.mvvm.a<a, GuildAioUserAvatarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAvatarLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAvatarView;

    public GuildAioUserAvatarViewBinder() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.component.avatar.GuildAioUserAvatarViewBinder$mAvatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildUserAvatarView invoke() {
                LinearLayout linearLayout;
                linearLayout = GuildAioUserAvatarViewBinder.this.mAvatarLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
                    linearLayout = null;
                }
                return (GuildUserAvatarView) linearLayout.findViewById(R.id.vx5);
            }
        });
        this.mAvatarView = lazy;
    }

    private final void c1(String guildId) {
        e1().setAvatarTinyId(guildId, ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId());
    }

    private final GuildUserAvatarView e1() {
        Object value = this.mAvatarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mAvatarView>(...)");
        return (GuildUserAvatarView) value;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        sendIntent(a.C1180a.f110160d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioUserAvatarUIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioUserAvatarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioUserAvatarUIState.UpdateAvatarState) {
            c1(((GuildAioUserAvatarUIState.UpdateAvatarState) state).getGuildId());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        View findViewById = params.b().findViewById(R.id.vyo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "params.parent.findViewBy\u2026d_aio_user_avatar_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mAvatarLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
            return null;
        }
        return linearLayout;
    }
}
