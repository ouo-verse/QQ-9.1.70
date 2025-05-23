package com.tencent.guild.aio.halfpop.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/l;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Landroid/content/Context;", "ctx", "", "guildId", "channelId", "", "msgSeq", "", "H", "Landroid/os/Bundle;", "extraBundle", "I", "Landroid/view/View;", "view", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class l extends t {
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void H(Context ctx, String guildId, String channelId, long msgSeq) {
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("navigate_msg_seq", Long.valueOf(msgSeq)), TuplesKt.to("no_need_new_msg_line", Boolean.TRUE));
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            I(channelId, guildId, bundleOf, ctx);
            return;
        }
        int channelPageSourceType = ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getChannelPageSourceType();
        if (channelPageSourceType != 0) {
            if (channelPageSourceType != 3) {
                Intent guildChatPieIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(ctx, new LaunchGuildChatPieParam().l(guildId).b(channelId).k(bundleOf).r(true).o(1).f(true).a());
                Intrinsics.checkNotNullExpressionValue(guildChatPieIntent, "api(ILaunchGuildChatPieA\u2026hatPieIntent(ctx, params)");
                ctx.startActivity(guildChatPieIntent);
                return;
            } else {
                com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().b(channelId).f(guildId).e(bundleOf).d(com.tencent.guild.aio.factory.a.class.getName()).a();
                if (AppSetting.t(ctx)) {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatFragment(ctx, a16);
                    return;
                } else {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatActivity(ctx, a16);
                    return;
                }
            }
        }
        I(channelId, guildId, bundleOf, ctx);
    }

    private final void I(String channelId, String guildId, Bundle extraBundle, Context ctx) {
        Activity activity;
        com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().b(channelId).f(guildId).e(extraBundle).d(com.tencent.guild.aio.factory.a.class.getName()).a();
        if (((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).shouldLaunchInSplitViewMode(ctx)) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(ctx, a16);
        } else {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(ctx, a16);
        }
        if (ctx instanceof Activity) {
            activity = (Activity) ctx;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154480ae);
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.i("GuildBackToSourceItem", 1, "onItemClick, context = " + view.getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_sticky_post_info");
        String str = data.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
        hashMap.put("sgrp_channel_id", str);
        String str2 = data.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
        hashMap.put("sgrp_sub_channel_id", str2);
        hashMap.put("eid", "em_original_text");
        VideoReport.reportEvent("dt_clck", hashMap);
        Context context = view.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            FragmentActivity requireActivity = h().c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "aioContext.fragment.requireActivity()");
            H(requireActivity, h().g().r().c().f(), h().g().r().c().j(), data.getMsgRecord().msgSeq);
        }
    }

    public /* synthetic */ l(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.guild_menu_icon_jump_source_msg, R.string.f1648226v) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
