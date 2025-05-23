package com.tencent.mobileqq.guild.api.impl;

import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0017J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildChannelIconTypeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildChannelIconTypeApi;", "()V", "setChannelIcon", "", "iv", "Landroid/widget/ImageView;", "channelType", "", "textSubId", "channelId", "", "setSameChannelIcon", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildChannelIconTypeApiImpl implements IGuildChannelIconTypeApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi
    @MainThread
    public void setChannelIcon(@NotNull ImageView iv5, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        GuildChannelIconUtil.s(iv5, channelId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi
    public void setSameChannelIcon(@NotNull ImageView iv5, int channelType, int textSubId) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        GuildChannelIconUtil.q(iv5, channelType, textSubId, com.tencent.mobileqq.guild.theme.g.f235303a);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi
    @MainThread
    public void setChannelIcon(@NotNull ImageView iv5, int channelType, int textSubId) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        GuildChannelIconUtil.q(iv5, channelType, textSubId, com.tencent.mobileqq.guild.theme.h.f235304a);
    }
}
