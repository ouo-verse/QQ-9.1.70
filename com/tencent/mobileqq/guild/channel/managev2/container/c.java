package com.tencent.mobileqq.guild.channel.managev2.container;

import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/c;", "Lcom/tencent/mobileqq/guild/channel/managev2/container/ChannelSettingBaseContainerVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "i", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mMediaChannelObserver", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class c extends ChannelSettingBaseContainerVM {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y mMediaChannelObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/channel/managev2/container/c$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "guildId", "channelId", "reason", "", "t", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends y {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(@NotNull String guildId, @NotNull String channelId, @NotNull String reason) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            super.t(guildId, channelId, reason);
            Logger.f235387a.d().d("Guild.mnr.ChannelAudioViewModel", 1, "mMediaChannelObserver onExit guildId:" + guildId + " channelId:" + channelId + " reason:" + reason);
            if (Intrinsics.areEqual(channelId, ((ChannelSettingMviContext) c.this.getMContext()).getParams().getChannelId()) && ((ChannelSettingMviContext) c.this.getMContext()).c().getActivity() != null && !((ChannelSettingMviContext) c.this.getMContext()).c().requireActivity().isFinishing() && !((ChannelSettingMviContext) c.this.getMContext()).c().requireActivity().isDestroyed() && (activity = ((ChannelSettingMviContext) c.this.getMContext()).c().getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.container.ChannelSettingBaseContainerVM, com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m */
    public void onCreate(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mMediaChannelObserver);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.container.ChannelSettingBaseContainerVM, com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mMediaChannelObserver);
    }
}
