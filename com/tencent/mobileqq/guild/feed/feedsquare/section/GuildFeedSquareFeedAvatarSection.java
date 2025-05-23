package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedAvatarSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroid/view/View;", "view", "", "U", ExifInterface.LATITUDE_SOUTH, "", "T", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "components", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedAvatarSection extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedAvatarComponents components = new GuildFeedAvatarComponents(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedAvatarSection$components$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildFeedSquareFeedAvatarSection.this.U(view);
        }
    });

    private final void S(View view) {
        Map map;
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        GuildFeedDetailInitBean F = F(D);
        com.tencent.mobileqq.guild.feed.report.e.c(D, "avatar_click", F.getPageId(), F.getPageForumType(F.getPageId()), F.getPrePageId(), F.getPrePageForumType(F.getPrePageId()));
        String T = T();
        map = MapsKt__MapsKt.toMap(C());
        com.tencent.mobileqq.guild.feed.report.d.a("clck", view, T, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String T() {
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                return "em_sgrp_nowplay_avatar";
            case 14:
                return "em_sgrp_voice_avatar";
            case 15:
                return "em_sgrp_single_event_avatar";
            default:
                return "em_sgrp_forum_avatar";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View view) {
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        String str = D.idd;
        String valueOf = String.valueOf(D.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(D.channelInfo.sign.channelId);
        QLog.d(v(), 1, "open profileCard guildId:" + valueOf + ", feedId:" + str + ", tinyId:" + valueOf2);
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ax.I((Activity) context, valueOf, valueOf2, D.poster.idd, str, p(), r());
        S(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GProStFeed b16;
        GProStUser gProStUser;
        if (data != null && (blockData = data.getBlockData()) != null && (b16 = blockData.b()) != null && (gProStUser = b16.poster) != null) {
            GuildFeedAvatarComponents guildFeedAvatarComponents = this.components;
            String str = gProStUser.icon.iconUrl;
            Intrinsics.checkNotNullExpressionValue(str, "user.icon.iconUrl");
            String str2 = gProStUser.avatarPendant;
            Intrinsics.checkNotNullExpressionValue(str2, "user.avatarPendant");
            guildFeedAvatarComponents.d(str, str2, position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            this.components.e(containerView);
        }
    }
}
