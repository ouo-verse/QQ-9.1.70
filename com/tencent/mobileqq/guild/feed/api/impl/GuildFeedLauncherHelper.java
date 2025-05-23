package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.app.Dialog;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTransactionManageService;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.util.bh;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0007\u0018\u0000 22\u00020\u0001:\u0001\u0014B3\b\u0002\u0012\u0006\u0010.\u001a\u00020\u001e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\b\u0010/\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/core/util/Consumer;", "Lcom/tencent/mobileqq/guild/feed/api/a;", "fallbackCheckResultConsumer", "com/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper$makeCheckItemListener$1", "r", "(Landroidx/core/util/Consumer;)Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper$makeCheckItemListener$1;", ReportConstant.COSTREPORT_PREFIX, "o", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "guildId", "u", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "shareParam", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "b", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "c", "I", "sharePageSource", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "d", "Ljava/lang/ref/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/guild/feed/api/g;", "e", "shareResultListenerRef", "Landroid/app/Dialog;", "f", "Landroid/app/Dialog;", "loadingDialog", "g", "Lkotlinx/coroutines/Job;", tl.h.F, "Lkotlinx/coroutines/Job;", "launchJob", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "shareResultListener", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;ILcom/tencent/mobileqq/guild/feed/api/g;)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SharePublishGuildFeedParam shareParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int sharePageSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> activityRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<com.tencent.mobileqq.guild.feed.api.g> shareResultListenerRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int requestId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job launchJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "shareParam", "", "sharePageSource", "Lcom/tencent/mobileqq/guild/feed/api/g;", "shareResultListener", "", "a", "", "DELAY_LOADING_TIME_MS", "J", "NOT_SUPPORT_SHARE_TO_GUILD", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull String guildId, @NotNull SharePublishGuildFeedParam shareParam, int sharePageSource, @Nullable com.tencent.mobileqq.guild.feed.api.g shareResultListener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(shareParam, "shareParam");
            new GuildFeedLauncherHelper(activity, guildId, shareParam, sharePageSource, shareResultListener, null).m();
        }

        Companion() {
        }
    }

    public /* synthetic */ GuildFeedLauncherHelper(Activity activity, String str, SharePublishGuildFeedParam sharePublishGuildFeedParam, int i3, com.tencent.mobileqq.guild.feed.api.g gVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, sharePublishGuildFeedParam, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Activity activity = this.activityRef.get();
        if (activity == null) {
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) api;
        GuildFeedLauncherHelper$makeCheckItemListener$1 r16 = r(iGuildFeedLauncherApi.makeFallbackCheckItemResultConsumer(this.guildId, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.api.impl.n
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Activity n3;
                n3 = GuildFeedLauncherHelper.n(GuildFeedLauncherHelper.this);
                return n3;
            }
        }));
        GuildSimpleContact guildSimpleContact = new GuildSimpleContact(this.guildId, "");
        FeedEditorLaunchOptionModel editorLaunchOption = this.shareParam.getEditorLaunchOption();
        editorLaunchOption.setDisableDraft(true);
        Unit unit = Unit.INSTANCE;
        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel = new FeedEditorLaunchSourceModel(4, "pg_search_activation", "share_channel_outside");
        feedEditorLaunchSourceModel.g(this.requestId);
        feedEditorLaunchSourceModel.h(String.valueOf(this.sharePageSource));
        Job performCheckItemsToStartFeedEditorToPostNewOne = iGuildFeedLauncherApi.performCheckItemsToStartFeedEditorToPostNewOne(activity, guildSimpleContact, editorLaunchOption, feedEditorLaunchSourceModel, this.shareParam.transformRichContentJson(), r16, r16);
        performCheckItemsToStartFeedEditorToPostNewOne.invokeOnCompletion(new GuildFeedLauncherHelper$checkAndShareToFeedPost$3$1(this));
        this.launchJob = performCheckItemsToStartFeedEditorToPostNewOne;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity n(GuildFeedLauncherHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.activityRef.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        Dialog dialog;
        Activity activity = this.activityRef.get();
        if (activity != null && !activity.isFinishing()) {
            Dialog dialog2 = this.loadingDialog;
            boolean z16 = false;
            if (dialog2 != null && dialog2.isShowing()) {
                z16 = true;
            }
            if (z16 && (dialog = this.loadingDialog) != null) {
                dialog.dismiss();
            }
        }
        Dialog dialog3 = this.loadingDialog;
        if (dialog3 != null) {
            dialog3.setOnCancelListener(null);
        }
        this.loadingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(SharePublishGuildFeedParam shareParam) {
        NewFeedMorePanelBusiImpl.FeedNewPanelShareForwardArgs feedNewPanelShareForwardArgs;
        List listOf;
        Map mapOf;
        Serializable serializable = shareParam.getExtMap().get("feed_new_panel_share_forward_key");
        SharePublishGuildFeedParam.LinkTypeParam linkTypeParam = null;
        if (serializable instanceof NewFeedMorePanelBusiImpl.FeedNewPanelShareForwardArgs) {
            feedNewPanelShareForwardArgs = (NewFeedMorePanelBusiImpl.FeedNewPanelShareForwardArgs) serializable;
        } else {
            feedNewPanelShareForwardArgs = null;
        }
        if (feedNewPanelShareForwardArgs != null) {
            GuildFeedShareChannelEvent.Companion companion = GuildFeedShareChannelEvent.INSTANCE;
            String guildId = feedNewPanelShareForwardArgs.getGuildId();
            String channelId = feedNewPanelShareForwardArgs.getChannelId();
            String feedId = feedNewPanelShareForwardArgs.getFeedId();
            int destPlat = feedNewPanelShareForwardArgs.getDestPlat();
            GuildFeedShareChannelEvent.UinType uinType = GuildFeedShareChannelEvent.UinType.GUILD;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(bh.b(feedNewPanelShareForwardArgs.getGuildId(), 0L)));
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(uinType, listOf));
            companion.a("afterPublishFeed", new GuildFeedShareChannelEvent(guildId, channelId, feedId, destPlat, mapOf));
        }
        if (shareParam instanceof SharePublishGuildFeedParam.LinkTypeParam) {
            linkTypeParam = (SharePublishGuildFeedParam.LinkTypeParam) shareParam;
        }
        if (linkTypeParam != null) {
            GuildActionSheetAttaUtil.o(linkTypeParam.getUrl(), 171, this.sharePageSource, this.guildId);
        }
    }

    private final GuildFeedLauncherHelper$makeCheckItemListener$1 r(Consumer<FeedEditorCheckItemResult> fallbackCheckResultConsumer) {
        return new GuildFeedLauncherHelper$makeCheckItemListener$1(this, fallbackCheckResultConsumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        if (this.shareParam.getIsShowDefaultShareResultToast()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedLauncherHelper.t();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        yl1.n.B(true, R.string.f156691kw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int requestId, String guildId) {
        IGuildTransactionManageService iGuildTransactionManageService;
        GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 = new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1(requestId, guildId, this);
        AppRuntime Q0 = ch.Q0();
        if (Q0 != null && (iGuildTransactionManageService = (IGuildTransactionManageService) Q0.getRuntimeService(IGuildTransactionManageService.class, "")) != null) {
            iGuildTransactionManageService.addTransaction(guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1);
        }
        guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1.run();
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    GuildFeedLauncherHelper(Activity activity, String str, SharePublishGuildFeedParam sharePublishGuildFeedParam, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        this.guildId = str;
        this.shareParam = sharePublishGuildFeedParam;
        this.sharePageSource = i3;
        this.activityRef = new WeakReference<>(activity);
        this.shareResultListenerRef = new WeakReference<>(gVar);
        this.requestId = hashCode();
    }
}
