package com.tencent.mobileqq.guild.feed.nativepublish.functionbar;

import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "OnPartSelect", "OpenAtPanel", "OpenHashTag", "OpenPartPanel", "OpenPlusTag", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedPublishFunctionBarMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent$OnPartSelect;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "", "isSticky", "Lbn1/c;", "d", "Lbn1/c;", "a", "()Lbn1/c;", "partInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnPartSelect extends GuildFeedPublishFunctionBarMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final bn1.c partInfo;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final bn1.c getPartInfo() {
            return this.partInfo;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMsgIntent, com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent$OpenAtPanel;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OpenAtPanel extends GuildFeedPublishFunctionBarMsgIntent {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent$OpenHashTag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OpenHashTag extends GuildFeedPublishFunctionBarMsgIntent {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent$OpenPartPanel;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OpenPartPanel extends GuildFeedPublishFunctionBarMsgIntent {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent$OpenPlusTag;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMsgIntent;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "d", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "a", "()Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "showListType", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OpenPlusTag extends GuildFeedPublishFunctionBarMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashTagPageType showListType;

        public OpenPlusTag() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final HashTagPageType getShowListType() {
            return this.showListType;
        }

        public OpenPlusTag(@NotNull HashTagPageType showListType) {
            Intrinsics.checkNotNullParameter(showListType, "showListType");
            this.showListType = showListType;
        }

        public /* synthetic */ OpenPlusTag(HashTagPageType hashTagPageType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? HashTagPageType.Troop_Page : hashTagPageType);
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
