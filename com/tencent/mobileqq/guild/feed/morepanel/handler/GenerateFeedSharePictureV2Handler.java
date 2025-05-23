package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.config.GuildFeedShareConfigParser;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.share.views.ShareActionSheetWithScrollPreview;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.aw;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bd;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002*+B\u0007\u00a2\u0006\u0004\b(\u0010)J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J(\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GenerateFeedSharePictureV2Handler;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "o", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "platformType", "", "j", "Ljava/io/File;", "l", "curActivity", "preView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "feedDataReader", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shareActionSheet", "k", "i", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "pictureItem", "c", "", "id", "a", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "<init>", "()V", "Companion", "PictureShareSheet", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GenerateFeedSharePictureV2Handler implements x {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQPermission qqPermission;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012JU\u0010\u001a\u001a\u00020\f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u0002`\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJL\u0010(\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0002J%\u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u00020'2\u0006\u00100\u001a\u00020\u0018H\u0007JU\u00102\u001a\u00020\f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u0002`\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u001bJ\u001b\u00104\u001a\u00020'2\u0006\u00103\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u00105R\u0014\u00106\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010;\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GenerateFeedSharePictureV2Handler$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "", "shareUrl", "", "isXHS", "Landroid/graphics/Bitmap;", "g", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "feedDetail", tl.h.F, "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "feedDataReader", "k", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guildId", "channelId", "feedId", "", "bitmapHeight", "isSuccess", "", "timeCost", "isLongFeed", "", "exception", "", DomainData.DOMAIN_NAME, "feed", "needInviteContentId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchShareUrlRsp;", "e", "(Lvk1/b;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feedDetailDataReader", "l", "i", "error", "c", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GENERATE_FAILED", "Ljava/lang/String;", "MAX_WAIT_TIME", "J", "TAG", "TAG_PREFIX", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchShareUrlRsp;", "commonInfo", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchShareUrlRsp;)V"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a implements bd {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<IGProFetchShareUrlRsp> f220279a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f220280b;

            /* JADX WARN: Multi-variable type inference failed */
            a(CancellableContinuation<? super IGProFetchShareUrlRsp> cancellableContinuation, long j3) {
                this.f220279a = cancellableContinuation;
                this.f220280b = j3;
            }

            @Override // wh2.bd
            public final void a(int i3, String str, IGProFetchShareUrlRsp iGProFetchShareUrlRsp) {
                if (i3 == 0) {
                    if (this.f220279a.isActive()) {
                        this.f220279a.resumeWith(Result.m476constructorimpl(iGProFetchShareUrlRsp));
                        QLog.i("SPic.GenerateFeedSharePictureV2Handler", 2, "fetchShareUrl coast:" + (System.currentTimeMillis() - this.f220280b));
                        return;
                    }
                    QLog.e("SPic.GenerateFeedSharePictureV2Handler", 1, "continuation is canceled");
                    return;
                }
                if (this.f220279a.isActive()) {
                    CancellableContinuation<IGProFetchShareUrlRsp> cancellableContinuation = this.f220279a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable(str))));
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/GenerateFeedSharePictureV2Handler$Companion$b", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$a;", "Landroid/graphics/Bitmap;", "Lkotlin/Result;", "result", "", "onResult", "(Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class b implements IFeedSharePreviewApi.a<Bitmap> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<Bitmap> f220281a;

            /* JADX WARN: Multi-variable type inference failed */
            b(CancellableContinuation<? super Bitmap> cancellableContinuation) {
                this.f220281a = cancellableContinuation;
            }

            @Override // com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi.a
            public void onResult(@NotNull Object result) {
                if (!this.f220281a.isActive()) {
                    return;
                }
                this.f220281a.resumeWith(result);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Object f(Companion companion, vk1.b bVar, boolean z16, Continuation continuation, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return companion.e(bVar, z16, continuation);
        }

        private final Object g(Context context, IGProGuildInfo iGProGuildInfo, GProStFeed gProStFeed, String str, boolean z16, Continuation<? super Bitmap> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GuildLongFeedPictureGenerator.f220341a.q(context, new GuildLongFeedPictureGenerator.GeneratorParam(iGProGuildInfo, gProStFeed, str, z16, 5000L), new Function3<Boolean, View, Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$Companion$generateBitmapForLongFeed$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, View view, Bitmap bitmap) {
                    invoke(bool.booleanValue(), view, bitmap);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable View view, @Nullable Bitmap bitmap) {
                    Logger.f235387a.d().a("SPic.GenerateFeedSharePictureV2Handler", 1, "GuildLongFeedPictureGenerator result:" + z17);
                    if (cancellableContinuationImpl.isActive()) {
                        if (z17 && bitmap != null) {
                            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(bitmap));
                            return;
                        }
                        CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable("generate for long feed failed,isSucc?" + z17))));
                    }
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        private final Object h(Context context, IGProGuildInfo iGProGuildInfo, IFeedDetailDataParser iFeedDetailDataParser, String str, boolean z16, Continuation<? super Bitmap> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            ((IFeedSharePreviewApi) QRoute.api(IFeedSharePreviewApi.class)).requestBitmap(context, new IFeedSharePreviewApi.ReqParams(iGProGuildInfo, iFeedDetailDataParser, str, z16), new b(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ Object j(Companion companion, PanelContext panelContext, IGProGuildInfo iGProGuildInfo, GProStFeed gProStFeed, String str, FeedDetailMainDisplayableParser feedDetailMainDisplayableParser, boolean z16, Continuation continuation, int i3, Object obj) {
            boolean z17;
            if ((i3 & 32) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            return companion.i(panelContext, iGProGuildInfo, gProStFeed, str, feedDetailMainDisplayableParser, z17, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object k(PanelContext<Activity, vk1.b> panelContext, IGProGuildInfo iGProGuildInfo, GProStFeed gProStFeed, String str, FeedDetailMainDisplayableParser feedDetailMainDisplayableParser, boolean z16, Continuation<? super Bitmap> continuation) {
            GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1 generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1;
            Object coroutine_suspended;
            int i3;
            String str2;
            IGProGuildInfo iGProGuildInfo2;
            long j3;
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            T t16;
            GProStFeed gProStFeed2 = gProStFeed;
            String str3 = str;
            if (continuation instanceof GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1) {
                generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1 = (GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1) continuation;
                int i16 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1.label = i16 - Integer.MIN_VALUE;
                    GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1 generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1;
                    Object obj = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                j3 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.J$0;
                                objectRef = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$4;
                                objectRef2 = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$3;
                                String str4 = (String) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$2;
                                GProStFeed gProStFeed3 = (GProStFeed) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$1;
                                iGProGuildInfo2 = (IGProGuildInfo) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$0;
                                ResultKt.throwOnFailure(obj);
                                str3 = str4;
                                gProStFeed2 = gProStFeed3;
                                t16 = (Bitmap) obj;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j3 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.J$0;
                            objectRef = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$4;
                            objectRef2 = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$3;
                            String str5 = (String) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$2;
                            GProStFeed gProStFeed4 = (GProStFeed) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$1;
                            iGProGuildInfo2 = (IGProGuildInfo) generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            str3 = str5;
                            gProStFeed2 = gProStFeed4;
                            t16 = (Bitmap) obj;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        boolean k3 = com.tencent.mobileqq.guild.share.shorturl.a.k(str);
                        String a16 = com.tencent.mobileqq.guild.share.util.c.a(str3, "2");
                        if (k3) {
                            str2 = a16;
                        } else {
                            str2 = str3;
                        }
                        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType)) {
                            Companion companion = GenerateFeedSharePictureV2Handler.INSTANCE;
                            Activity h16 = panelContext.h();
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$0 = iGProGuildInfo;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$1 = gProStFeed2;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$2 = str3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$3 = objectRef3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$4 = objectRef3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.J$0 = currentTimeMillis;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.label = 1;
                            obj = companion.g(h16, iGProGuildInfo, gProStFeed, str2, z16, generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iGProGuildInfo2 = iGProGuildInfo;
                            j3 = currentTimeMillis;
                            objectRef = objectRef3;
                            objectRef2 = objectRef;
                            t16 = (Bitmap) obj;
                        } else {
                            Companion companion2 = GenerateFeedSharePictureV2Handler.INSTANCE;
                            Activity h17 = panelContext.h();
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$0 = iGProGuildInfo;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$1 = gProStFeed2;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$2 = str3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$3 = objectRef3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.L$4 = objectRef3;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.J$0 = currentTimeMillis;
                            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12.label = 2;
                            obj = companion2.h(h17, iGProGuildInfo, feedDetailMainDisplayableParser, str2, z16, generateFeedSharePictureV2Handler$Companion$innerGenerateImage$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iGProGuildInfo2 = iGProGuildInfo;
                            j3 = currentTimeMillis;
                            objectRef = objectRef3;
                            objectRef2 = objectRef;
                            t16 = (Bitmap) obj;
                        }
                    }
                    objectRef.element = t16;
                    long currentTimeMillis2 = System.currentTimeMillis() - j3;
                    QLog.d("SPic.GenerateFeedSharePictureV2Handler", 1, "generate type:" + com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType) + ", cost:" + currentTimeMillis2);
                    if (QLog.isColorLevel()) {
                        QLog.d("SPic.GenerateFeedSharePictureV2Handler", 2, "url:" + str3 + " ,\n" + iGProGuildInfo2);
                    }
                    return objectRef2.element;
                }
            }
            generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1 = new GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1(this, continuation);
            GenerateFeedSharePictureV2Handler$Companion$innerGenerateImage$1 generateFeedSharePictureV2Handler$Companion$innerGenerateImage$122 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$1;
            Object obj2 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$122.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = generateFeedSharePictureV2Handler$Companion$innerGenerateImage$122.label;
            if (i3 == 0) {
            }
            objectRef.element = t16;
            long currentTimeMillis22 = System.currentTimeMillis() - j3;
            QLog.d("SPic.GenerateFeedSharePictureV2Handler", 1, "generate type:" + com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType) + ", cost:" + currentTimeMillis22);
            if (QLog.isColorLevel()) {
            }
            return objectRef2.element;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(FeedDetailMainDisplayableParser feedDetailDataReader) {
            Intrinsics.checkNotNullParameter(feedDetailDataReader, "$feedDetailDataReader");
            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).doPreload(feedDetailDataReader, feedDetailDataReader.getGuildId());
        }

        private final void n(String guildId, String channelId, String feedId, int bitmapHeight, boolean isSuccess, long timeCost, boolean isLongFeed, Throwable exception) {
            Map mapOf;
            Pair[] pairArr = new Pair[9];
            pairArr[0] = TuplesKt.to("sgrp_channel_id", guildId);
            Pair pair = TuplesKt.to("sgrp_sub_channel_id", channelId);
            int i3 = 1;
            pairArr[1] = pair;
            pairArr[2] = TuplesKt.to("sgrp_feed_id", feedId);
            pairArr[3] = TuplesKt.to(VRReportDefine$ReportParam.IS_SUCCESS, Integer.valueOf(isSuccess ? 1 : 0));
            pairArr[4] = TuplesKt.to(VRReportDefine$ReportParam.FAIL_REASON, exception + " " + Log.getStackTraceString(exception));
            pairArr[5] = TuplesKt.to("share_img_height", Integer.valueOf(ViewUtils.pxToDp((float) bitmapHeight)));
            pairArr[6] = TuplesKt.to("max_img_height", Integer.valueOf(GuildFeedShareConfigParser.INSTANCE.getConfig().getFeedSharePicMaxHeight()));
            pairArr[7] = TuplesKt.to("cost_time", Long.valueOf(timeCost));
            if (isLongFeed) {
                i3 = 2;
            }
            pairArr[8] = TuplesKt.to("sgrp_forum_short_article", Integer.valueOf(i3));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.reportEvent("ev_sgrp_create_forum_share_img", mapOf);
        }

        @Nullable
        public final Object c(@NotNull Throwable th5, @NotNull Continuation<? super Unit> continuation) {
            return CorountineFunKt.i(i.e.f261783e, null, null, new GenerateFeedSharePictureV2Handler$Companion$failureToast$2(th5, null), continuation, 6, null);
        }

        @Nullable
        public final Object d(@NotNull String str, @NotNull Continuation<? super IGProGuildInfo> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GuildMainFrameUtils.k(str, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$Companion$fetchGuildInfo$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                    invoke2(iGProGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                    if (cancellableContinuationImpl.isActive()) {
                        QLog.i("SPic.GenerateFeedSharePictureV2Handler", 2, "fetchGuildInfo");
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(iGProGuildInfo));
                    } else {
                        QLog.e("SPic.GenerateFeedSharePictureV2Handler", 1, "fetchGuildInfo, continuation is canceled");
                    }
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @Nullable
        public final Object e(@NotNull vk1.b bVar, boolean z16, @NotNull Continuation<? super IGProFetchShareUrlRsp> continuation) {
            Continuation intercepted;
            ArrayList<ey> arrayListOf;
            AppInterface appInterface;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            long currentTimeMillis = System.currentTimeMillis();
            aw awVar = new aw();
            awVar.b(z16);
            ey eyVar = new ey();
            eyVar.c("mainSourceId");
            eyVar.d("feed_qr_code");
            Unit unit = Unit.INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(eyVar);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                iGPSService.fetchShareUrlReq(bVar.getGuildId(), bVar.getChannelId(), 0L, bVar.getFeedId(), awVar, arrayListOf, new a(cancellableContinuationImpl, currentTimeMillis));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x011d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Throwable, T] */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object i(@NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull IGProGuildInfo iGProGuildInfo, @NotNull GProStFeed gProStFeed, @NotNull String str, @NotNull FeedDetailMainDisplayableParser feedDetailMainDisplayableParser, boolean z16, @NotNull Continuation<? super Bitmap> continuation) {
            GenerateFeedSharePictureV2Handler$Companion$generateImage$1 generateFeedSharePictureV2Handler$Companion$generateImage$1;
            Object coroutine_suspended;
            int i3;
            Ref.ObjectRef objectRef;
            IGProGuildInfo iGProGuildInfo2;
            GProStFeed gProStFeed2;
            Companion companion;
            long j3;
            Ref.ObjectRef objectRef2;
            Ref.ObjectRef objectRef3;
            Companion companion2;
            boolean z17;
            Ref.ObjectRef objectRef4;
            Object m476constructorimpl;
            ?? m479exceptionOrNullimpl;
            Bitmap bitmap;
            int i16;
            boolean z18;
            Bitmap bitmap2;
            T t16;
            if (continuation instanceof GenerateFeedSharePictureV2Handler$Companion$generateImage$1) {
                generateFeedSharePictureV2Handler$Companion$generateImage$1 = (GenerateFeedSharePictureV2Handler$Companion$generateImage$1) continuation;
                int i17 = generateFeedSharePictureV2Handler$Companion$generateImage$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    generateFeedSharePictureV2Handler$Companion$generateImage$1.label = i17 - Integer.MIN_VALUE;
                    GenerateFeedSharePictureV2Handler$Companion$generateImage$1 generateFeedSharePictureV2Handler$Companion$generateImage$12 = generateFeedSharePictureV2Handler$Companion$generateImage$1;
                    Object obj = generateFeedSharePictureV2Handler$Companion$generateImage$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = generateFeedSharePictureV2Handler$Companion$generateImage$12.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            j3 = generateFeedSharePictureV2Handler$Companion$generateImage$12.J$0;
                            objectRef4 = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$5;
                            objectRef3 = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$4;
                            objectRef2 = (Ref.ObjectRef) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$3;
                            gProStFeed2 = (GProStFeed) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$2;
                            iGProGuildInfo2 = (IGProGuildInfo) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$1;
                            companion = (Companion) generateFeedSharePictureV2Handler$Companion$generateImage$12.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                t16 = obj;
                            } catch (Throwable th5) {
                                th = th5;
                                Result.Companion companion3 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                                Companion companion4 = companion;
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != 0) {
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                String guildID = iGProGuildInfo2.getGuildID();
                                Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
                                String valueOf = String.valueOf(gProStFeed2.channelInfo.sign.channelId);
                                String str2 = gProStFeed2.idd;
                                Intrinsics.checkNotNullExpressionValue(str2, "feedInfo.idd");
                                bitmap = (Bitmap) objectRef2.element;
                                if (bitmap == null) {
                                }
                                if (objectRef2.element == 0) {
                                }
                                companion4.n(guildID, valueOf, str2, i16, z18, currentTimeMillis - j3, com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType), (Throwable) objectRef3.element);
                                bitmap2 = (Bitmap) objectRef2.element;
                                if (bitmap2 == null) {
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
                        Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                        try {
                            Result.Companion companion5 = Result.INSTANCE;
                            companion2 = GenerateFeedSharePictureV2Handler.INSTANCE;
                            if (z16) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$0 = this;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$1 = iGProGuildInfo;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$2 = gProStFeed;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$3 = objectRef5;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$4 = objectRef6;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.L$5 = objectRef5;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.J$0 = currentTimeMillis2;
                            generateFeedSharePictureV2Handler$Companion$generateImage$12.label = 1;
                            objectRef = objectRef6;
                        } catch (Throwable th6) {
                            th = th6;
                            objectRef = objectRef6;
                        }
                        try {
                            Object k3 = companion2.k(panelContext, iGProGuildInfo, gProStFeed, str, feedDetailMainDisplayableParser, z17, generateFeedSharePictureV2Handler$Companion$generateImage$12);
                            if (k3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iGProGuildInfo2 = iGProGuildInfo;
                            gProStFeed2 = gProStFeed;
                            companion = this;
                            j3 = currentTimeMillis2;
                            objectRef4 = objectRef5;
                            objectRef2 = objectRef4;
                            objectRef3 = objectRef;
                            t16 = k3;
                        } catch (Throwable th7) {
                            th = th7;
                            iGProGuildInfo2 = iGProGuildInfo;
                            gProStFeed2 = gProStFeed;
                            companion = this;
                            j3 = currentTimeMillis2;
                            objectRef2 = objectRef5;
                            objectRef3 = objectRef;
                            Result.Companion companion32 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                            Companion companion42 = companion;
                            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != 0) {
                            }
                            long currentTimeMillis3 = System.currentTimeMillis();
                            String guildID2 = iGProGuildInfo2.getGuildID();
                            Intrinsics.checkNotNullExpressionValue(guildID2, "guildInfo.guildID");
                            String valueOf2 = String.valueOf(gProStFeed2.channelInfo.sign.channelId);
                            String str22 = gProStFeed2.idd;
                            Intrinsics.checkNotNullExpressionValue(str22, "feedInfo.idd");
                            bitmap = (Bitmap) objectRef2.element;
                            if (bitmap == null) {
                            }
                            if (objectRef2.element == 0) {
                            }
                            companion42.n(guildID2, valueOf2, str22, i16, z18, currentTimeMillis3 - j3, com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType), (Throwable) objectRef3.element);
                            bitmap2 = (Bitmap) objectRef2.element;
                            if (bitmap2 == null) {
                            }
                        }
                    }
                    objectRef4.element = t16;
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    Companion companion422 = companion;
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != 0) {
                        objectRef3.element = m479exceptionOrNullimpl;
                    }
                    long currentTimeMillis32 = System.currentTimeMillis();
                    String guildID22 = iGProGuildInfo2.getGuildID();
                    Intrinsics.checkNotNullExpressionValue(guildID22, "guildInfo.guildID");
                    String valueOf22 = String.valueOf(gProStFeed2.channelInfo.sign.channelId);
                    String str222 = gProStFeed2.idd;
                    Intrinsics.checkNotNullExpressionValue(str222, "feedInfo.idd");
                    bitmap = (Bitmap) objectRef2.element;
                    if (bitmap == null) {
                        i16 = bitmap.getHeight();
                    } else {
                        i16 = 0;
                    }
                    if (objectRef2.element == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    companion422.n(guildID22, valueOf22, str222, i16, z18, currentTimeMillis32 - j3, com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType), (Throwable) objectRef3.element);
                    bitmap2 = (Bitmap) objectRef2.element;
                    if (bitmap2 == null) {
                        return bitmap2;
                    }
                    Throwable th8 = (Throwable) objectRef3.element;
                    if (th8 == null) {
                        throw new Throwable();
                    }
                    throw th8;
                }
            }
            generateFeedSharePictureV2Handler$Companion$generateImage$1 = new GenerateFeedSharePictureV2Handler$Companion$generateImage$1(this, continuation);
            GenerateFeedSharePictureV2Handler$Companion$generateImage$1 generateFeedSharePictureV2Handler$Companion$generateImage$122 = generateFeedSharePictureV2Handler$Companion$generateImage$1;
            Object obj2 = generateFeedSharePictureV2Handler$Companion$generateImage$122.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = generateFeedSharePictureV2Handler$Companion$generateImage$122.label;
            if (i3 == 0) {
            }
            objectRef4.element = t16;
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            Companion companion4222 = companion;
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != 0) {
            }
            long currentTimeMillis322 = System.currentTimeMillis();
            String guildID222 = iGProGuildInfo2.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID222, "guildInfo.guildID");
            String valueOf222 = String.valueOf(gProStFeed2.channelInfo.sign.channelId);
            String str2222 = gProStFeed2.idd;
            Intrinsics.checkNotNullExpressionValue(str2222, "feedInfo.idd");
            bitmap = (Bitmap) objectRef2.element;
            if (bitmap == null) {
            }
            if (objectRef2.element == 0) {
            }
            companion4222.n(guildID222, valueOf222, str2222, i16, z18, currentTimeMillis322 - j3, com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(gProStFeed2.feedType), (Throwable) objectRef3.element);
            bitmap2 = (Bitmap) objectRef2.element;
            if (bitmap2 == null) {
            }
        }

        @Deprecated(message = "\u786e\u8ba4\u662f\u5426\u6709\u5fc5\u8981")
        public final void l(@NotNull final FeedDetailMainDisplayableParser feedDetailDataReader) {
            Intrinsics.checkNotNullParameter(feedDetailDataReader, "feedDetailDataReader");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.q
                @Override // java.lang.Runnable
                public final void run() {
                    GenerateFeedSharePictureV2Handler.Companion.m(FeedDetailMainDisplayableParser.this);
                }
            }, 16, null, false);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001BG\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b-\u0010.J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\f\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GenerateFeedSharePictureV2Handler$PictureShareSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "sheet", "", "onItemClick", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "d", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "f", "()Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "Landroid/graphics/Bitmap;", "e", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "", "i", "Ljava/lang/String;", "shareUrl", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "feedDataReader", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "c", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GenerateFeedSharePictureV2Handler;Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class PictureShareSheet implements ShareActionSheet.OnItemClickListener {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final Activity activity;
        final /* synthetic */ GenerateFeedSharePictureV2Handler D;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Bitmap bitmap;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IGProGuildInfo guildInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GProStFeed feedInfo;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String shareUrl;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedDetailMainDisplayableParser feedDataReader;

        public PictureShareSheet(@NotNull GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull Bitmap bitmap, @NotNull IGProGuildInfo guildInfo, @NotNull GProStFeed feedInfo, @NotNull String shareUrl, FeedDetailMainDisplayableParser feedDataReader) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            Intrinsics.checkNotNullParameter(feedDataReader, "feedDataReader");
            this.D = generateFeedSharePictureV2Handler;
            this.panelContext = panelContext;
            this.bitmap = bitmap;
            this.guildInfo = guildInfo;
            this.feedInfo = feedInfo;
            this.shareUrl = shareUrl;
            this.feedDataReader = feedDataReader;
            this.activity = panelContext.h();
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final GProStFeed getFeedInfo() {
            return this.feedInfo;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        @NotNull
        public final PanelContext<Activity, vk1.b> f() {
            return this.panelContext;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet sheet) {
            if (sheet != null && item != null) {
                sheet.dismiss();
                QLog.d("SPic.GenerateFeedSharePictureV2Handler", 2, " showMyQrCodeActionSheet() click item = " + item.action);
                int i3 = item.action;
                if (i3 == 2) {
                    this.D.j(this.bitmap, this.activity, 0);
                    return;
                }
                if (i3 == 3) {
                    this.D.j(this.bitmap, this.activity, 4);
                    return;
                }
                if (i3 == 9) {
                    this.D.j(this.bitmap, this.activity, 2);
                    return;
                }
                if (i3 == 10) {
                    this.D.j(this.bitmap, this.activity, 3);
                    return;
                }
                if (i3 == 39) {
                    this.D.i(this.activity, this.bitmap);
                    return;
                }
                if (i3 == 171) {
                    this.D.j(this.bitmap, this.activity, 1);
                    return;
                }
                if (i3 == 218) {
                    if (!m02.d.f415923a.d(this.panelContext.h())) {
                        QLog.w("SPic.GenerateFeedSharePictureV2Handler", 1, "isSupportShareToXhs false");
                        return;
                    }
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "SPic.GenerateFeedSharePictureV2Handler handle xhs regenerate", null, null, null, new GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1(this, this.D, null), 14, null);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("SPic.GenerateFeedSharePictureV2Handler", 1, "onItemClick null object: item = [" + item + "], sheet = [" + sheet + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Activity activity, Bitmap bitmap) {
        Unit unit;
        if (this.qqPermission == null) {
            this.qqPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_CONTENT_SHARE, QQPermissionConstants.Business.SCENE.QQCHANNEL_CONTENT_SHARE_SAVE_ALBUM));
        }
        QQPermission qQPermission = this.qqPermission;
        if (qQPermission != null) {
            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).saveToAlbum(activity, qQPermission, bitmap, new GenerateFeedSharePictureV2Handler$doSave$1$1(activity));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("SPic.GenerateFeedSharePictureV2Handler", 1, "qqpermission is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Bitmap bitmap, Activity activity, int platformType) {
        File l3 = l(bitmap);
        if (l3 != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                intent.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.FEED_SHOOT.ordinal());
            }
            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).doShare(activity, bitmap, l3, platformType, true);
        }
    }

    private final void k(ShareActionSheet shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(39);
        build.label = "\u4fdd\u5b58\u56fe\u7247";
        Intrinsics.checkNotNullExpressionValue(build, "build(ActionSheetItem.AC\u2026.apply { label = \"\u4fdd\u5b58\u56fe\u7247\" }");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ActionSheetItem.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build2);
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(171);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ActionSheetItem.ACTION_SEND_TO_CHANNEL)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ActionSheetItem.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build4);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ActionSheetItem.AC\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build5);
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ActionSheetItem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build6);
        ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(218);
        Intrinsics.checkNotNullExpressionValue(build7, "build(ActionSheetItem.ACTION_SEND_TO_XHS)");
        arrayList.add(build7);
        shareActionSheet.setActionSheetItems(arrayList, new ArrayList());
    }

    private final File l(Bitmap bitmap) {
        return ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShareActionSheet m(Activity curActivity, Bitmap preView, final FeedDetailMainDisplayableParser feedDataReader) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        curActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        final com.tencent.mobileqq.guild.share.q qVar = new com.tencent.mobileqq.guild.share.q();
        param.actionSheetRender = new ShareActionSheetV2.l() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.p
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
            public final void b(ActionSheet actionSheet) {
                GenerateFeedSharePictureV2Handler.n(com.tencent.mobileqq.guild.share.q.this, feedDataReader, actionSheet);
            }
        };
        ShareActionSheetWithScrollPreview shareActionSheetWithScrollPreview = new ShareActionSheetWithScrollPreview(param, curActivity);
        shareActionSheetWithScrollPreview.C0(preView);
        shareActionSheetWithScrollPreview.B0("\u5206\u4eab");
        shareActionSheetWithScrollPreview.setRowVisibility(8, 0, 8);
        shareActionSheetWithScrollPreview.setExtras(BundleKt.bundleOf(TuplesKt.to("no_need_report", Boolean.TRUE)));
        k(shareActionSheetWithScrollPreview);
        return shareActionSheetWithScrollPreview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.guild.share.q shareDtReportHelper, FeedDetailMainDisplayableParser feedDataReader, ActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(shareDtReportHelper, "$shareDtReportHelper");
        Intrinsics.checkNotNullParameter(feedDataReader, "$feedDataReader");
        shareDtReportHelper.c(actionSheet, GuildSharePageSource.FEED_SHOOT, feedDataReader.getGuildId(), feedDataReader.getChannelId(), feedDataReader.getFeedId());
    }

    private final boolean o(PanelContext<Activity, vk1.b> panelContext) {
        GuildFeedPublishInfo guildFeedPublishInfo;
        Job f16;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1511016s);
            return true;
        }
        INSTANCE.l(new FeedDetailMainDisplayableParser(panelContext.j()));
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("SPic.GenerateFeedSharePictureV2Handler,cancel for generate picture first"));
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(panelContext.h(), 2, true);
        showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.o
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GenerateFeedSharePictureV2Handler.p(GenerateFeedSharePictureV2Handler.this, dialogInterface);
            }
        });
        showOnlyLoadingImageDialog.show();
        com.tencent.mobileqq.guild.feed.morepanel.cooperate.l lVar = (com.tencent.mobileqq.guild.feed.morepanel.cooperate.l) panelContext.getApiRouter().b(com.tencent.mobileqq.guild.feed.morepanel.cooperate.l.class);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (lVar != null) {
            guildFeedPublishInfo = lVar.provide();
        } else {
            guildFeedPublishInfo = null;
        }
        boolean e16 = com.tencent.mobileqq.guild.feed.feedsquare.data.g.e(guildFeedPublishInfo);
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "SPic.GenerateFeedSharePictureV2Handler handle fetch url", null, null, Boolean.TRUE, new GenerateFeedSharePictureV2Handler$realHandle$1(showOnlyLoadingImageDialog, panelContext, e16, this, null), 6, null);
        }
        this.task = bVar2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GenerateFeedSharePictureV2Handler this$0, DialogInterface dialogInterface) {
        Job f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("SPic.GenerateFeedSharePictureV2Handler", 1, "cancel share");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this$0.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("SPic.GenerateFeedSharePictureV2Handler,cancel for generate picture by cancel dialog"));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return o(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.c(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem pictureItem, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(pictureItem, "pictureItem");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        shareActionSheet.dismiss();
        return o(panelContext);
    }
}
