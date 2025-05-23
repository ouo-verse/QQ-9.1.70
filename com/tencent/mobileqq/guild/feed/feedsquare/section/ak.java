package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/ak;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", "e", "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", "scheduleCardView", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ak extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildScheduleCardView scheduleCardView;

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GuildScheduleInfo guildScheduleInfo;
        if (data != null && (blockData = data.getBlockData()) != null) {
            Object d16 = blockData.d(blockData.m());
            GuildScheduleCardView guildScheduleCardView = null;
            if (d16 instanceof GuildScheduleInfo) {
                guildScheduleInfo = (GuildScheduleInfo) d16;
            } else {
                guildScheduleInfo = null;
            }
            GProStChannelSign gProStChannelSign = data.getBlockData().b().channelInfo.sign;
            JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(gProStChannelSign.guildId), String.valueOf(gProStChannelSign.channelId), gProStChannelSign.joinGuildSig, "pindao_box", "recommend_join");
            JumpGuildParam.JoinInfoParam r16 = r();
            if (r16 != null && r16.isValid()) {
                jumpGuildParam.setJoinInfoParam(r16);
            }
            if (guildScheduleInfo != null) {
                GuildScheduleCardView guildScheduleCardView2 = this.scheduleCardView;
                if (guildScheduleCardView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleCardView");
                    guildScheduleCardView2 = null;
                }
                GuildScheduleCardView.j(guildScheduleCardView2, 1, jumpGuildParam, guildScheduleInfo, null, 8, null);
            }
            GuildScheduleCardView guildScheduleCardView3 = this.scheduleCardView;
            if (guildScheduleCardView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleCardView");
            } else {
                guildScheduleCardView = guildScheduleCardView3;
            }
            A(guildScheduleCardView, "em_sgrp_single_event_card");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.sch.GuildFeedSquareScheduleContentSection", "onBindData " + guildScheduleInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f165498wb3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f79834_u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.schedule_card)");
        this.scheduleCardView = (GuildScheduleCardView) findViewById;
    }
}
