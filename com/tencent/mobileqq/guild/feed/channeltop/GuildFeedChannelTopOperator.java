package com.tencent.mobileqq.guild.feed.channeltop;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator;
import com.tencent.mobileqq.guild.feed.event.GuildFeedChannelTopEvent;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator;", "", "Landroid/content/Context;", "context", "", "errorMsg", "", "g", "Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$b;", "param", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopChannelFeedReq;", "f", "Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$a;", "callback", "c", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedChannelTopOperator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedChannelTopOperator f218329a = new GuildFeedChannelTopOperator();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$a;", "", "", "result", "", "errMsg", "", "onResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void onResult(int result, @NotNull String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedId", "", "J", "()J", "channelId", "c", "guildId", "d", "e", "sectionName", "Z", "f", "()Z", "isSetTop", "I", "()I", "pageSource", "<init>", "(Ljava/lang/String;JJLjava/lang/String;ZI)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedChannelTopParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long guildId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sectionName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSetTop;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pageSource;

        public FeedChannelTopParam(@NotNull String feedId, long j3, long j16, @NotNull String sectionName, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.feedId = feedId;
            this.channelId = j3;
            this.guildId = j16;
            this.sectionName = sectionName;
            this.isSetTop = z16;
            this.pageSource = i3;
        }

        /* renamed from: a, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: c, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: d, reason: from getter */
        public final int getPageSource() {
            return this.pageSource;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getSectionName() {
            return this.sectionName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedChannelTopParam)) {
                return false;
            }
            FeedChannelTopParam feedChannelTopParam = (FeedChannelTopParam) other;
            if (Intrinsics.areEqual(this.feedId, feedChannelTopParam.feedId) && this.channelId == feedChannelTopParam.channelId && this.guildId == feedChannelTopParam.guildId && Intrinsics.areEqual(this.sectionName, feedChannelTopParam.sectionName) && this.isSetTop == feedChannelTopParam.isSetTop && this.pageSource == feedChannelTopParam.pageSource) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsSetTop() {
            return this.isSetTop;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.feedId.hashCode() * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + this.sectionName.hashCode()) * 31;
            boolean z16 = this.isSetTop;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.pageSource;
        }

        @NotNull
        public String toString() {
            return "FeedChannelTopParam(feedId=" + this.feedId + ", channelId=" + this.channelId + ", guildId=" + this.guildId + ", sectionName=" + this.sectionName + ", isSetTop=" + this.isSetTop + ", pageSource=" + this.pageSource + ")";
        }
    }

    GuildFeedChannelTopOperator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedChannelTopParam param, final Context context, a aVar, int i3, String errMsg, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("GuildFeedChannelTopOperator", 1, "topChannelFeed, result=" + i3 + ", errMsg=" + errMsg + ", rsp=" + gProTopChannelFeedRsp);
        if (i3 == 0) {
            Function0.d(new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator$doTop$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToast.makeText(context, 2, "\u53d6\u6d88\u7f6e\u9876\u6210\u529f", 0).show();
                }
            });
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedChannelTopEvent(param.getFeedId(), param.getChannelId(), param.getGuildId(), false));
        } else {
            GuildFeedChannelTopOperator guildFeedChannelTopOperator = f218329a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            guildFeedChannelTopOperator.g(context, errMsg);
        }
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            aVar.onResult(i3, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FeedChannelTopParam param, Context context, a aVar, int i3, String errMsg, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("GuildFeedChannelTopOperator", 1, "topChannelFeed, result=" + i3 + ", errMsg=" + errMsg + ", rsp=" + gProTopChannelFeedRsp);
        if (i3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedChannelTopEvent(param.getFeedId(), param.getChannelId(), param.getGuildId(), true));
            GuildFeedChannelTopFragment.INSTANCE.a(param);
        } else {
            GuildFeedChannelTopOperator guildFeedChannelTopOperator = f218329a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            guildFeedChannelTopOperator.g(context, errMsg);
        }
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            aVar.onResult(i3, errMsg);
        }
    }

    private final GProTopChannelFeedReq f(FeedChannelTopParam param) {
        int i3;
        GProTopChannelFeedReq gProTopChannelFeedReq = new GProTopChannelFeedReq();
        gProTopChannelFeedReq.guildId = param.getGuildId();
        gProTopChannelFeedReq.channelId = param.getChannelId();
        gProTopChannelFeedReq.feedId = param.getFeedId();
        if (param.getIsSetTop()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        gProTopChannelFeedReq.sceneType = i3;
        gProTopChannelFeedReq.visitFrom = com.tencent.mobileqq.guild.report.b.f();
        gProTopChannelFeedReq.pginSourceName = com.tencent.mobileqq.guild.report.b.c();
        return gProTopChannelFeedReq;
    }

    private final void g(final Context context, final String errorMsg) {
        Function0.d(new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator$showErrorToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(context, 0, errorMsg, 0).show();
            }
        });
    }

    public final void c(@NotNull final FeedChannelTopParam param, @NotNull final Context context, @Nullable final a callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(context, "context");
        o c16 = l.c();
        if (c16 == null) {
            if (callback != null) {
                callback.onResult(-1, "doTop fail for feedService is null !");
            }
        } else {
            GProTopChannelFeedReq f16 = f(param);
            if (!param.getIsSetTop()) {
                c16.topChannelFeed(f16, new IGProTopChannelFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.channeltop.d
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback
                    public final void onResult(int i3, String str, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
                        GuildFeedChannelTopOperator.d(GuildFeedChannelTopOperator.FeedChannelTopParam.this, context, callback, i3, str, gProTopChannelFeedRsp);
                    }
                });
            } else {
                c16.topChannelFeed(f16, new IGProTopChannelFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.channeltop.e
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback
                    public final void onResult(int i3, String str, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
                        GuildFeedChannelTopOperator.e(GuildFeedChannelTopOperator.FeedChannelTopParam.this, context, callback, i3, str, gProTopChannelFeedRsp);
                    }
                });
            }
        }
    }
}
