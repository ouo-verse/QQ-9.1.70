package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J&\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$b;", "reqParams", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "Landroid/graphics/Bitmap;", "callback", "", "requestBitmap", "Landroid/view/View;", "requestView", "Landroid/os/Bundle;", "arguments", "showDemoFragment", "a", "FeedShareException", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IFeedSharePreviewApi extends QRouteApi {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "T", "", "Lkotlin/Result;", "result", "", "onResult", "(Ljava/lang/Object;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a<T> {
        void onResult(@NotNull Object result);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "b", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "()Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "feedDetail", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "shareUrl", "Z", "()Z", "fromXhs", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;Ljava/lang/String;Z)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReqParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGProGuildInfo guildInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IFeedDetailDataParser feedDetail;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String shareUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean fromXhs;

        public ReqParams(@NotNull IGProGuildInfo guildInfo, @NotNull IFeedDetailDataParser feedDetail, @NotNull String shareUrl, boolean z16) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(feedDetail, "feedDetail");
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            this.guildInfo = guildInfo;
            this.feedDetail = feedDetail;
            this.shareUrl = shareUrl;
            this.fromXhs = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final IFeedDetailDataParser getFeedDetail() {
            return this.feedDetail;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFromXhs() {
            return this.fromXhs;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getShareUrl() {
            return this.shareUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReqParams)) {
                return false;
            }
            ReqParams reqParams = (ReqParams) other;
            if (Intrinsics.areEqual(this.guildInfo, reqParams.guildInfo) && Intrinsics.areEqual(this.feedDetail, reqParams.feedDetail) && Intrinsics.areEqual(this.shareUrl, reqParams.shareUrl) && this.fromXhs == reqParams.fromXhs) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.guildInfo.hashCode() * 31) + this.feedDetail.hashCode()) * 31) + this.shareUrl.hashCode()) * 31;
            boolean z16 = this.fromXhs;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "ReqParams(guildInfo=" + this.guildInfo + ", feedDetail=" + this.feedDetail + ", shareUrl=" + this.shareUrl + ", fromXhs=" + this.fromXhs + ')';
        }
    }

    void requestBitmap(@NotNull Context context, @NotNull ReqParams reqParams, @NotNull a<Bitmap> callback);

    void requestView(@NotNull Context context, @NotNull ReqParams reqParams, @NotNull a<View> callback);

    void showDemoFragment(@NotNull Context context, @NotNull Bundle arguments);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$FeedShareException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class FeedShareException extends CancellationException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedShareException(@NotNull String message, @Nullable Throwable th5) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            initCause(th5);
        }

        public /* synthetic */ FeedShareException(String str, Throwable th5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : th5);
        }
    }
}
