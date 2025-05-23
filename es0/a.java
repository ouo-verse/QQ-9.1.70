package es0;

import android.view.View;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarUIState;
import com.tencent.guild.aio.component.avatar.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Les0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/avatar/a;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", "guildId", "", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "state", "d1", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatarView", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.component.avatar.a, GuildAioUserAvatarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView mAvatarView;

    private final void b1(String guildId) {
        String selfTinyId = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        GuildUserAvatarView guildUserAvatarView = this.mAvatarView;
        if (guildUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            guildUserAvatarView = null;
        }
        guildUserAvatarView.setAvatarTinyId(guildId, selfTinyId);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        sendIntent(a.C1180a.f110160d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.component.avatar.a, GuildAioUserAvatarUIState> createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioUserAvatarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioUserAvatarUIState.UpdateAvatarState) {
            b1(((GuildAioUserAvatarUIState.UpdateAvatarState) state).getGuildId());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.vx5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026d.guild_aio_avatar_image)");
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) findViewById;
        this.mAvatarView = guildUserAvatarView;
        if (guildUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            return null;
        }
        return guildUserAvatarView;
    }
}
