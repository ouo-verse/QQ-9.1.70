package com.tencent.mobileqq.guild.discover.recommend.miniapp;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.standalone.GuildStandaloneDialogAttachFragment;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/recommend/miniapp/GuildYoloJoinHelper;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildYoloJoinHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildYoloJoinHelper f216514a = new GuildYoloJoinHelper();

    GuildYoloJoinHelper() {
    }

    @JvmStatic
    public static final void a(@NotNull final JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Logger.f235387a.d().d("Guild.jump.JS.GuildYoloJoinHelper", 1, "openGuildDialog " + jumpGuildParam);
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        GuildMainFrameUtils.i(str, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.GuildYoloJoinHelper$openGuildDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                Intrinsics.checkNotNullParameter(guildAndChannelInfoRsp, "guildAndChannelInfoRsp");
                if (!guildAndChannelInfoRsp.l()) {
                    QQToastUtil.showQQToast(1, R.string.f15162187);
                } else {
                    GuildStandaloneDialogAttachFragment.qh(((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity(), JumpGuildParam.this);
                }
            }
        }, 30, null);
    }
}
