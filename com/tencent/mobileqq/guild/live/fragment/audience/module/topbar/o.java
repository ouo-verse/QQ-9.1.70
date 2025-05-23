package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.graphics.drawable.BitmapDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "a", "", "imageUrl", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/topbar/o$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAIOTitleBar f226654e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GuildAIOTitleBar guildAIOTitleBar) {
            super(true);
            this.f226654e = guildAIOTitleBar;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS && option.getResultBitMap() != null) {
                this.f226654e.setGuildAvatarDrawable(new BitmapDrawable(this.f226654e.getResources(), option.getResultBitMap()));
                return;
            }
            Logger.f235387a.d().i("GuildAIOTitleBar", 1, "setGuildAvatarDrawable | load image fail " + state);
        }
    }

    public static final void a(@NotNull GuildAIOTitleBar guildAIOTitleBar, @NotNull IGProGuildInfo guildInfo) {
        Intrinsics.checkNotNullParameter(guildAIOTitleBar, "<this>");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        String avatarUrl = guildInfo.getAvatarUrl(100);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_100)");
        b(guildAIOTitleBar, avatarUrl);
    }

    public static final void b(@NotNull GuildAIOTitleBar guildAIOTitleBar, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(guildAIOTitleBar, "<this>");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        Option option = new Option();
        option.setUrl(imageUrl);
        option.setNeedFilterUrl(false);
        a16.f(option, new a(guildAIOTitleBar));
    }
}
