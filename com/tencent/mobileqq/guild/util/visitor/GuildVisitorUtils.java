package com.tencent.mobileqq.guild.util.visitor;

import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/util/visitor/GuildVisitorUtils;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "dialogTip", "", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "b", "guildId", "", "source", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildVisitorUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildVisitorUtils f235701a = new GuildVisitorUtils();

    GuildVisitorUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String guildId, int i3, String dialogTip, int i16, String errMsg, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(dialogTip, "$dialogTip");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (i16 == 0) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, null, str3, str, str2);
            jumpGuildParam.setExtraJoinGuildSource(i3);
            f235701a.e(jumpGuildParam, dialogTip);
            return;
        }
        QQToastUtil.showQQToast(1, errMsg);
    }

    private final void e(final JumpGuildParam param, final String dialogTip) {
        String str = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        GuildMainFrameUtils.i(str, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.util.visitor.GuildVisitorUtils$openInviteDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.l()) {
                    SecurityTipHelperKt.F(ch.i(), it.k(), it.e(), null, null, null, 56, null);
                } else {
                    ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(ch.i(), JumpGuildParam.this, dialogTip, false, true);
                }
            }
        }, 30, null);
    }

    public final boolean b(@Nullable IGProGuildInfo guildInfo) {
        if (guildInfo == null || (guildInfo.getVisitorInteractionAllSwitch() & 32) == 0) {
            return false;
        }
        return true;
    }

    public final void c(@NotNull final String guildId, @NotNull final String dialogTip, final int source) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(dialogTip, "dialogTip");
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService != null) {
            iGPSService.fetchAddGuildInfo(2, az.d(guildId, 0L), new wh2.a() { // from class: com.tencent.mobileqq.guild.util.visitor.a
                @Override // wh2.a
                public final void onResult(int i3, String str, String str2, String str3, String str4) {
                    GuildVisitorUtils.d(guildId, source, dialogTip, i3, str, str2, str3, str4);
                }
            });
        }
    }
}
