package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aw1.MedalItem;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.qqguildsdk.data.em;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "kotlin.jvm.PlatformType", ITVKPlayerEventListener.KEY_USER_INFO, "", "invoke", "(Lcom/tencent/mobileqq/qqguildsdk/data/ev;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileBannerLayout$setupLiveDataInfo$2$1 extends Lambda implements Function1<ev, Unit> {
    final /* synthetic */ GuildProfileBannerLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileBannerLayout$setupLiveDataInfo$2$1(GuildProfileBannerLayout guildProfileBannerLayout) {
        super(1);
        this.this$0 = guildProfileBannerLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(em signGuildInfo, GuildProfileBannerLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(signGuildInfo, "$signGuildInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = signGuildInfo.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "signGuildInfo.url");
        String desc = signGuildInfo.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc, "signGuildInfo.desc");
        MedalItem medalItem = new MedalItem(url, desc);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        r12.e eVar = new r12.e(context, medalItem);
        View rootView = this$0.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        eVar.b(rootView);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ev evVar) {
        invoke2(evVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ev evVar) {
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant;
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (evVar != null) {
            guildUserAvatarViewWithPendant = this.this$0.mIvAvatar;
            String tinyId = evVar.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "userInfo.tinyId");
            String avatarMeta = evVar.getAvatarMeta();
            Intrinsics.checkNotNullExpressionValue(avatarMeta, "userInfo.avatarMeta");
            GuildUserAvatarViewWithPendant.setAvatarMeta$default(guildUserAvatarViewWithPendant, "0", tinyId, avatarMeta, null, 8, null);
            guildUserAvatarViewWithPendant2 = this.this$0.mIvAvatar;
            String tinyId2 = evVar.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId2, "userInfo.tinyId");
            guildUserAvatarViewWithPendant2.setAvatarTinyId("0", tinyId2);
            textView = this.this$0.mTvName;
            textView.setText(evVar.getNickName());
            textView2 = this.this$0.mTvTopName;
            if (textView2 != null) {
                textView2.setText(evVar.getNickName());
            }
            final em s16 = evVar.s();
            if (s16 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            boolean z16 = true;
            boolean z17 = s16.getStartTime() > 0 && s16.getEndTime() > 0 && currentTimeMillis > s16.getStartTime() && currentTimeMillis < s16.getEndTime();
            QLog.d("Guild.profile.GuildProfileBannerLayout", 1, "updateSignInfo endTime: " + s16.getEndTime() + ";startTime:" + s16.getStartTime() + ";desc:" + s16.getDesc() + ";guildId:" + s16.getGuildId());
            String guildId = s16.getGuildId();
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            }
            if (z16 || !z17) {
                imageView = this.this$0.mSignIcon;
                imageView.setVisibility(8);
                return;
            }
            String url = s16.getUrl();
            imageView2 = this.this$0.mSignIcon;
            com.tencent.mobileqq.guild.u.r(url, imageView2, false, null);
            imageView3 = this.this$0.mSignIcon;
            imageView3.setVisibility(0);
            imageView4 = this.this$0.mSignIcon;
            final GuildProfileBannerLayout guildProfileBannerLayout = this.this$0;
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileBannerLayout$setupLiveDataInfo$2$1.b(em.this, guildProfileBannerLayout, view);
                }
            });
        }
    }
}
