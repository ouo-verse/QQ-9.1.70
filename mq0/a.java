package mq0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lmq0/a;", "Lmq0/e;", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "", "j", "", "channelId", "guildId", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "i", "Landroid/view/View;", "v", "k", "", tl.h.F, "g", "f", "uinType", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends e {
    public a(int i3) {
        super(i3);
    }

    private final Intent i(String channelId, String guildId, com.tencent.aio.part.root.panel.mvx.config.c panelParam, FragmentActivity activity) {
        return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(activity, new com.tencent.mobileqq.guild.api.i().b(channelId).f(guildId).e(new Bundle()).d(panelParam.b().n()).a());
    }

    private final void j(com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intent i3;
        FragmentActivity activity = panelParam.a().c().getActivity();
        if (activity == null) {
            return;
        }
        String b16 = com.tencent.guild.aio.util.a.b(panelParam.b());
        String g16 = com.tencent.guild.aio.util.a.g(panelParam.b());
        boolean isInSplitViewMode = ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).isInSplitViewMode(activity);
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            Intent i16 = i(b16, g16, panelParam, activity);
            if (isInSplitViewMode && i16 != null) {
                i16.putExtra("isSplitViewMode", true);
            }
            ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).openCameraSendMsg(b16, g16, activity, i16, false);
            return;
        }
        int channelPageSourceType = ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getChannelPageSourceType();
        if (channelPageSourceType != 0) {
            if (channelPageSourceType != 3) {
                i3 = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(activity, new LaunchGuildChatPieParam().b(b16).l(g16).k(new Bundle()).r(true).o(1).g(4).f(true).a());
            } else {
                i3 = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getSplashGuildChatActivityIntent(activity, new com.tencent.mobileqq.guild.api.i().b(b16).e(new Bundle()).f(g16).d(panelParam.b().n()).a());
            }
        } else {
            i3 = i(b16, g16, panelParam, activity);
        }
        if (isInSplitViewMode && i3 != null) {
            i3.putExtra("isSplitViewMode", true);
        }
        ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).openCameraSendMsg(b16, g16, activity, i3, false);
    }

    private final void k(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_aio_plus_shoot");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        super.f(v3, panelParam);
        if (fo0.b.c(panelParam.a())) {
            QLog.i("GuildFileAppInfo", 1, "checkIsGuestInputModeAndPopTip");
        } else {
            k(v3);
            j(panelParam);
        }
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_feed_publish_camera_icon_selector;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139390b5;
    }
}
