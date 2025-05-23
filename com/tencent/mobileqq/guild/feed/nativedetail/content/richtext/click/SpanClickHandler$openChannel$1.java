package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$a;", "rsp", "", "invoke", "(Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class SpanClickHandler$openChannel$1 extends Lambda implements Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $forceOpenGuildHome;
    final /* synthetic */ String $guildId;
    final /* synthetic */ Boolean $isSquare;
    final /* synthetic */ JumpGuildParam.JoinInfoParam $joinInfoParam;
    final /* synthetic */ String $traceID;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpanClickHandler$openChannel$1(Boolean bool, Context context, String str, String str2, JumpGuildParam.JoinInfoParam joinInfoParam, String str3, boolean z16) {
        super(1);
        this.$isSquare = bool;
        this.$context = context;
        this.$guildId = str;
        this.$channelId = str2;
        this.$joinInfoParam = joinInfoParam;
        this.$traceID = str3;
        this.$forceOpenGuildHome = z16;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
        invoke2(guildAndChannelInfoRsp);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp rsp) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (rsp.getChannelInfo() == null && !Intrinsics.areEqual(this.$isSquare, Boolean.TRUE)) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 0, null, HardCodeUtil.qqStr(R.string.f143530mb), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SpanClickHandler$openChannel$1.b(dialogInterface, i3);
                }
            }, null);
            createCustomDialog.setTitleMutiLine();
            createCustomDialog.adjustTitle();
            createCustomDialog.show();
            return;
        }
        String str = this.$guildId;
        String str2 = this.$channelId;
        JumpGuildParam.JoinInfoParam joinInfoParam = this.$joinInfoParam;
        String joinSignature = joinInfoParam != null ? joinInfoParam.getJoinSignature() : null;
        String str3 = joinSignature == null ? "" : joinSignature;
        JumpGuildParam.JoinInfoParam joinInfoParam2 = this.$joinInfoParam;
        String mainSource = joinInfoParam2 != null ? joinInfoParam2.getMainSource() : null;
        String str4 = mainSource == null ? "" : mainSource;
        JumpGuildParam.JoinInfoParam joinInfoParam3 = this.$joinInfoParam;
        String subSource = joinInfoParam3 != null ? joinInfoParam3.getSubSource() : null;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, str3, str4, subSource == null ? "" : subSource);
        Bundle bundle2 = jumpGuildParam.extras;
        if (bundle2 != null) {
            bundle2.putBoolean("guild_is_need_jump_main_tab", true);
        }
        Bundle bundle3 = jumpGuildParam.extras;
        if (bundle3 != null) {
            bundle3.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, this.$traceID);
        }
        Bundle bundle4 = jumpGuildParam.extras;
        if (bundle4 != null) {
            bundle4.putBoolean(JumpGuildParam.EXTRA_FORCE_OPEN_GUILD_HOME, this.$forceOpenGuildHome);
        }
        if (GuildMainFrameUtils.q(this.$channelId) && (bundle = jumpGuildParam.extras) != null) {
            bundle.putBoolean(JumpGuildParam.EXTRA_FEED_HOME_SELECTED_HOT_TAB, true);
        }
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
    }
}
