package com.tencent.mobileqq.guild.feed.morepanel.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.EditFeedActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory;
import com.tencent.mobileqq.guild.feed.morepanel.handler.FeedShare2XHSActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ReportFeedHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.s;
import com.tencent.mobileqq.guild.feed.morepanel.handler.t;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.handler.y;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.share.v;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl;", "", "a", "b", "FeedNewPanelShareForwardArgs", "c", "FeedPrepareForwardCallback", "FeedPrepareForwardHandler", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NewFeedMorePanelBusiImpl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedNewPanelShareForwardArgs;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "guildId", "channelId", "feedId", "destPlat", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "getChannelId", "getFeedId", "I", "getDestPlat", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedNewPanelShareForwardArgs implements Serializable {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String channelId;
        private final int destPlat;

        @NotNull
        private final String feedId;

        @NotNull
        private final String guildId;

        public FeedNewPanelShareForwardArgs(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int i3) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.feedId = feedId;
            this.destPlat = i3;
        }

        public static /* synthetic */ FeedNewPanelShareForwardArgs copy$default(FeedNewPanelShareForwardArgs feedNewPanelShareForwardArgs, String str, String str2, String str3, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = feedNewPanelShareForwardArgs.guildId;
            }
            if ((i16 & 2) != 0) {
                str2 = feedNewPanelShareForwardArgs.channelId;
            }
            if ((i16 & 4) != 0) {
                str3 = feedNewPanelShareForwardArgs.feedId;
            }
            if ((i16 & 8) != 0) {
                i3 = feedNewPanelShareForwardArgs.destPlat;
            }
            return feedNewPanelShareForwardArgs.copy(str, str2, str3, i3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getDestPlat() {
            return this.destPlat;
        }

        @NotNull
        public final FeedNewPanelShareForwardArgs copy(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int destPlat) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            return new FeedNewPanelShareForwardArgs(guildId, channelId, feedId, destPlat);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedNewPanelShareForwardArgs)) {
                return false;
            }
            FeedNewPanelShareForwardArgs feedNewPanelShareForwardArgs = (FeedNewPanelShareForwardArgs) other;
            if (Intrinsics.areEqual(this.guildId, feedNewPanelShareForwardArgs.guildId) && Intrinsics.areEqual(this.channelId, feedNewPanelShareForwardArgs.channelId) && Intrinsics.areEqual(this.feedId, feedNewPanelShareForwardArgs.feedId) && this.destPlat == feedNewPanelShareForwardArgs.destPlat) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        public final int getDestPlat() {
            return this.destPlat;
        }

        @NotNull
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return (((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + this.destPlat;
        }

        @NotNull
        public String toString() {
            return "FeedNewPanelShareForwardArgs(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", destPlat=" + this.destPlat + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedPrepareForwardCallback;", "Lcom/tencent/mobileqq/sharepanel/b;", "", "success", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FeedPrepareForwardCallback implements com.tencent.mobileqq.sharepanel.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        public FeedPrepareForwardCallback(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
        }

        @Override // com.tencent.mobileqq.sharepanel.b
        public void a(final boolean success, @NotNull final List<? extends ResultRecord> targetList) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                GuildFeedArkShareInfo l3 = ShareFeedActionHandler.INSTANCE.l(this.panelContext);
                if (l3 == null) {
                    QLog.e("NewFeedMorePanelBusiImpl", 1, "FeedPrepareForwardCallback shareInfo is null");
                    return;
                }
                int i3 = this.panelContext.getExtra().getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal());
                String w3 = l3.w();
                Intrinsics.checkNotNullExpressionValue(w3, "shareArkInfo.shareLongUrl");
                String v3 = l3.v();
                Intrinsics.checkNotNullExpressionValue(v3, "shareArkInfo.shareAttaId");
                GuildActionSheetAttaUtil.q(targetList, w3, i3, v3);
                if ((!targetList.isEmpty()) && success) {
                    GuildFeedShareChannelEvent.Companion companion = GuildFeedShareChannelEvent.INSTANCE;
                    companion.a("forwardResultCallback", new GuildFeedShareChannelEvent(String.valueOf(((vk1.b) this.panelContext.j()).getGuildId()), String.valueOf(((vk1.b) this.panelContext.j()).getChannelId()), ((vk1.b) this.panelContext.j()).getFeedId(), 1, companion.b(targetList)));
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl$FeedPrepareForwardCallback$onForwardResult$$inlined$ensureUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedArkShareInfo l16 = ShareFeedActionHandler.INSTANCE.l(NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback.this.panelContext);
                    if (l16 == null) {
                        QLog.e("NewFeedMorePanelBusiImpl", 1, "FeedPrepareForwardCallback shareInfo is null");
                        return;
                    }
                    int i16 = NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback.this.panelContext.getExtra().getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal());
                    List list = targetList;
                    String w16 = l16.w();
                    Intrinsics.checkNotNullExpressionValue(w16, "shareArkInfo.shareLongUrl");
                    String v16 = l16.v();
                    Intrinsics.checkNotNullExpressionValue(v16, "shareArkInfo.shareAttaId");
                    GuildActionSheetAttaUtil.q(list, w16, i16, v16);
                    if ((!targetList.isEmpty()) && success) {
                        GuildFeedShareChannelEvent.Companion companion2 = GuildFeedShareChannelEvent.INSTANCE;
                        companion2.a("forwardResultCallback", new GuildFeedShareChannelEvent(String.valueOf(((vk1.b) NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback.this.panelContext.j()).getGuildId()), String.valueOf(((vk1.b) NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback.this.panelContext.j()).getChannelId()), ((vk1.b) NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback.this.panelContext.j()).getFeedId(), 1, companion2.b(targetList)));
                    }
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedPrepareForwardHandler;", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "feedShareTask", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FeedPrepareForwardHandler implements com.tencent.mobileqq.sharepanel.n {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.qcoroutine.api.coroutine.b feedShareTask;

        public FeedPrepareForwardHandler(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final com.tencent.mobileqq.sharepanel.m callback) {
            Job f16;
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ShareFeedActionHandler.Companion companion = ShareFeedActionHandler.INSTANCE;
            final GuildFeedArkShareInfo o16 = companion.o(this.panelContext, true);
            if (o16 == null) {
                QLog.e("NewFeedMorePanelBusiImpl", 1, "prepareForwardData shareInfo is null");
                callback.onFail();
                return;
            }
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.feedShareTask;
            if (bVar != null && (f16 = bVar.f()) != null) {
                f16.cancel(new CancellationException("NewFeedMorePanelBusiImpl,cancel for prepareForwardData first"));
            }
            this.feedShareTask = ShareFeedActionHandler.Companion.j(companion, this.panelContext, o16, "prepareForwardData", null, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl$FeedPrepareForwardHandler$prepareForwardData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (!z16) {
                        com.tencent.mobileqq.sharepanel.m.this.onFail();
                        return;
                    }
                    v vVar = new v();
                    GuildFeedArkShareInfo guildFeedArkShareInfo = o16;
                    final NewFeedMorePanelBusiImpl.FeedPrepareForwardHandler feedPrepareForwardHandler = this;
                    final com.tencent.mobileqq.sharepanel.m mVar = com.tencent.mobileqq.sharepanel.m.this;
                    vVar.m(guildFeedArkShareInfo, new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl$FeedPrepareForwardHandler$prepareForwardData$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                            invoke2(intent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Intent intent) {
                            PanelContext panelContext;
                            panelContext = NewFeedMorePanelBusiImpl.FeedPrepareForwardHandler.this.panelContext;
                            if (((Activity) panelContext.h()).isFinishing()) {
                                Logger.f235387a.d().i("NewFeedMorePanelBusiImpl", 1, "prepareForwardData isFinishing");
                            } else if (intent != null) {
                                mVar.a(intent);
                            } else {
                                mVar.onFail();
                            }
                        }
                    });
                }
            }, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$a;", "Lcom/tencent/mobileqq/sharepanel/j;", "", "d", "", "channelId", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/y;", "f", "actionId", "e", "", "a", "b", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Ljava/util/List;", "c", "()Ljava/util/List;", "delegateList", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mobileqq.sharepanel.j {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<x> delegateList;

        public a(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
            this.delegateList = new ArrayList();
        }

        private final boolean d() {
            if (FastClickUtils.isFastDoubleClick("NewFeedMorePanelBusiImpl", 500L)) {
                return true;
            }
            if (!yl1.n.d(false, 0, 3, null)) {
                return false;
            }
            this.panelContext.f();
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        
            if (r6.equals("pin_to_section") == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
        
            if (r6.equals("uppin_homepage") == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        
            return com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory.f220270a.j(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
        
            if (r6.equals("uppin_section") == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00f1, code lost:
        
            if (r6.equals("pin_to_homepage") == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
        
            return com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory.f220270a.j(2);
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0141 A[LOOP:0: B:64:0x013b->B:66:0x0141, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final y e(String actionId) {
            String str;
            Iterator<T> it;
            int i3 = 1;
            PartManager partManager = null;
            byte b16 = 0;
            switch (actionId.hashCode()) {
                case -2081315535:
                    if (actionId.equals("generate_share_image")) {
                        return new GenerateFeedSharePictureV2Handler();
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("NewFeedMorePanelBusiImpl", 1, (String) it.next(), null);
                    }
                    return null;
                case -1759550072:
                    break;
                case -1574041703:
                    if (actionId.equals("debug_admin_block_user")) {
                        return FeedManageActionHandlerFactory.f220270a.e();
                    }
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar2.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case -1335458389:
                    if (actionId.equals("delete")) {
                        return FeedManageActionHandlerFactory.f220270a.g();
                    }
                    Logger logger22 = Logger.f235387a;
                    Logger.b bVar22 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar22.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case -1052216532:
                    if (actionId.equals("save_to_phone")) {
                        return new t(partManager, i3, b16 == true ? 1 : 0);
                    }
                    Logger logger222 = Logger.f235387a;
                    Logger.b bVar222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case -482654861:
                    break;
                case -119796214:
                    if (actionId.equals("batch_manage")) {
                        return FeedManageActionHandlerFactory.f220270a.h();
                    }
                    Logger logger2222 = Logger.f235387a;
                    Logger.b bVar2222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar2222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 3108362:
                    if (actionId.equals("edit")) {
                        return new EditFeedActionHandler();
                    }
                    Logger logger22222 = Logger.f235387a;
                    Logger.b bVar22222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar22222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 156884553:
                    if (actionId.equals("floating_window")) {
                        return new s();
                    }
                    Logger logger222222 = Logger.f235387a;
                    Logger.b bVar222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 392724438:
                    if (actionId.equals("debug_admin_delete_feed")) {
                        return FeedManageActionHandlerFactory.f220270a.f();
                    }
                    Logger logger2222222 = Logger.f235387a;
                    Logger.b bVar2222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar2222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 820760075:
                    break;
                case 928922363:
                    if (actionId.equals("report_abuse")) {
                        return new ReportFeedHandler();
                    }
                    Logger logger22222222 = Logger.f235387a;
                    Logger.b bVar22222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar22222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 1068355662:
                    if (actionId.equals("move_post")) {
                        return FeedManageActionHandlerFactory.f220270a.i();
                    }
                    Logger logger222222222 = Logger.f235387a;
                    Logger.b bVar222222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar222222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 1505434244:
                    if (actionId.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK)) {
                        return new ShareFeedActionHandler();
                    }
                    Logger logger2222222222 = Logger.f235387a;
                    Logger.b bVar2222222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar2222222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                case 1831781568:
                    break;
                default:
                    Logger logger22222222222 = Logger.f235387a;
                    Logger.b bVar22222222222 = new Logger.b();
                    str = "no matchAppendActionHandler actionId:" + actionId;
                    if (str instanceof String) {
                    }
                    it = bVar22222222222.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            if (r6.equals("weixincircle") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        
            if (r6.equals("qzoneshuoshuo") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        
            if (r6.equals("qqfriend") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        
            if (r6.equals("weixin") == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
        
            if (r6.equals("qqchannel") != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
        
            return new com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler();
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[LOOP:0: B:24:0x0081->B:26:0x0088, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final y f(String channelId) {
            String str;
            Iterator<T> it;
            switch (channelId.hashCode()) {
                case -791575966:
                    break;
                case -393543490:
                    break;
                case -304161157:
                    break;
                case 154627506:
                    break;
                case 1083130618:
                    if (channelId.equals("redbook")) {
                        return new FeedShare2XHSActionHandler();
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    str = "no matchShareChannelHandler channelId:" + channelId;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("NewFeedMorePanelBusiImpl", 1, (String) it.next(), null);
                    }
                    return null;
                case 2024098531:
                    break;
                default:
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    str = "no matchShareChannelHandler channelId:" + channelId;
                    if (str instanceof String) {
                    }
                    it = bVar2.a().iterator();
                    while (it.hasNext()) {
                    }
                    return null;
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Logger.f235387a.d().i("NewFeedMorePanelBusiImpl", 1, "onShareChannelClick channelId:" + channelId);
            if (d()) {
                return;
            }
            Iterator<T> it = this.delegateList.iterator();
            while (it.hasNext()) {
                if (((x) it.next()).b(channelId, this.panelContext)) {
                    this.panelContext.f();
                    return;
                }
            }
            y f16 = f(channelId);
            if (f16 != null && f16.b(channelId, this.panelContext)) {
                this.panelContext.f();
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            Logger.f235387a.d().i("NewFeedMorePanelBusiImpl", 1, "onAppendActionClick actionId:" + actionId);
            if (d()) {
                return;
            }
            Iterator<T> it = this.delegateList.iterator();
            while (it.hasNext()) {
                if (((x) it.next()).a(actionId, this.panelContext)) {
                    this.panelContext.f();
                    return;
                }
            }
            y e16 = e(actionId);
            if (e16 != null && e16.a(actionId, this.panelContext)) {
                this.panelContext.f();
            }
        }

        @NotNull
        public final List<x> c() {
            return this.delegateList;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$b;", "", "Landroid/app/Activity;", "context", "Lvk1/b;", "feed", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "c", "", "FEED_NEW_PANEL_SHARE_FORWARD_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(PanelContext this_apply, Object obj) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            new FeedMorePanelUtils.ShareArkInfoInitTask(this_apply).run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Object obj) {
            FeedMorePanelUtils.f220193a.h();
        }

        @JvmOverloads
        @NotNull
        public final com.tencent.mobileqq.guild.feed.morepanel.k c(@NotNull Activity context, @NotNull vk1.b feed) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(feed, "feed");
            final PanelContext panelContext = new PanelContext(context, feed);
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.o
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    NewFeedMorePanelBusiImpl.Companion.d(PanelContext.this, obj);
                }
            });
            panelContext.getExtra().putString("big_brother_source_key", "biz_src_jc_qqstation");
            panelContext.a(new Consumer() { // from class: com.tencent.mobileqq.guild.feed.morepanel.impl.p
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    NewFeedMorePanelBusiImpl.Companion.e(obj);
                }
            });
            com.tencent.mobileqq.guild.feed.morepanel.k kVar = new com.tencent.mobileqq.guild.feed.morepanel.k(panelContext);
            kVar.g(new a(panelContext));
            return kVar;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$c;", "Lcom/tencent/mobileqq/guild/share/s;", "", QzoneIPCModule.RESULT_CODE, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "resultList", "", "onResult", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedNewPanelShareForwardArgs;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedNewPanelShareForwardArgs;", "args", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/impl/NewFeedMorePanelBusiImpl$FeedNewPanelShareForwardArgs;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.share.s {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedNewPanelShareForwardArgs args;

        public c(@NotNull FeedNewPanelShareForwardArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.args = args;
        }

        @Override // com.tencent.mobileqq.guild.share.s
        public void onResult(int resultCode, @NotNull ArrayList<ResultRecord> resultList) {
            Intrinsics.checkNotNullParameter(resultList, "resultList");
            if (resultCode == -1 && (!resultList.isEmpty())) {
                GuildFeedShareChannelEvent.Companion companion = GuildFeedShareChannelEvent.INSTANCE;
                companion.a("guildShareForwardCallBack", new GuildFeedShareChannelEvent(this.args.getGuildId(), this.args.getChannelId(), this.args.getFeedId(), this.args.getDestPlat(), companion.b(resultList)));
            }
        }
    }
}
