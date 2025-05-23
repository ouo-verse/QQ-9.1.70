package com.tencent.mobileqq.guild.feed.nativepublish.guildselector;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import nk1.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/guildselector/GuildFeedPublishGuildSelectorMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "OnGuildSelect", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedPublishGuildSelectorMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/guildselector/GuildFeedPublishGuildSelectorMsgIntent$OnGuildSelect;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/guildselector/GuildFeedPublishGuildSelectorMsgIntent;", "Lnk1/a;", "guildInfo", "Lnk1/a;", "a", "()Lnk1/a;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnGuildSelect extends GuildFeedPublishGuildSelectorMsgIntent {
        @NotNull
        public final a a() {
            return null;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
