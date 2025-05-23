package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXInfo;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedShareSuccessEvent;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusiData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wh2.eh;
import zn1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'JL\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J0\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH\u0002J8\u0010\u0019\u001a\u00020\u000f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0002J0\u0010 \u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J(\u0010!\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH\u0016J(\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "", "actionTag", "Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;", AppConstants.Key.SHARE_REQ_ARK_INFO, "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$b;", "reqArgs", "Lkotlin/Function1;", "", "", "block", "k", "id", "appendAction", "p", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "l", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "destPlat", "fromTag", "j", "c", "a", "b", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "feedShareTask", "<init>", "()V", "Companion", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ShareFeedActionHandler implements x {

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b feedShareTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fH\u0002J(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u0016j\u0002`\u0018H\u0002J(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u0016j\u0002`\u0018H\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u0016j\u0002`\u00182\u0006\u0010\u001d\u001a\u00020\u001cJ \u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u0016j\u0002`\u0018JR\u0010'\u001a\u0004\u0018\u00010&2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u0016j\u0002`\u00182\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fR\u0014\u0010(\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion;", "", "Lvk1/b;", "feed", "Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;", "shareInfo", "", tl.h.F, "(Lvk1/b;Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$a;", "k", "(Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "onFetchUrl", "Lzn1/a$d;", "f", "Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isNewSharePanel", "o", "l", AppConstants.Key.SHARE_REQ_ARK_INFO, "", "fromTag", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$b;", "reqArgs", "block", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i", "JSON_KEY_VERIFY_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "Lri1/a;", "Lri1/a;", "()Lri1/a;", "error", "<init>", "(ZLri1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$a, reason: from toString */
        /* loaded from: classes13.dex */
        public static final /* data */ class FetchShareUrlResult {

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final boolean isSuccess;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            @NotNull
            private final ri1.a error;

            public FetchShareUrlResult(boolean z16, @NotNull ri1.a error) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.isSuccess = z16;
                this.error = error;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final ri1.a getError() {
                return this.error;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getIsSuccess() {
                return this.isSuccess;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchShareUrlResult)) {
                    return false;
                }
                FetchShareUrlResult fetchShareUrlResult = (FetchShareUrlResult) other;
                if (this.isSuccess == fetchShareUrlResult.isSuccess && Intrinsics.areEqual(this.error, fetchShareUrlResult.error)) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z16 = this.isSuccess;
                ?? r06 = z16;
                if (z16) {
                    r06 = 1;
                }
                return (r06 * 31) + this.error.hashCode();
            }

            @NotNull
            public String toString() {
                return "FetchShareUrlResult(isSuccess=" + this.isSuccess + ", error=" + this.error + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "needShareUrl", "b", "needCreateShare", "needHandleError", "<init>", "(ZZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$b, reason: from toString */
        /* loaded from: classes13.dex */
        public static final /* data */ class ReqHandleArgs {

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final boolean needShareUrl;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final boolean needCreateShare;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final boolean needHandleError;

            public ReqHandleArgs() {
                this(false, false, false, 7, null);
            }

            /* renamed from: a, reason: from getter */
            public final boolean getNeedCreateShare() {
                return this.needCreateShare;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getNeedHandleError() {
                return this.needHandleError;
            }

            /* renamed from: c, reason: from getter */
            public final boolean getNeedShareUrl() {
                return this.needShareUrl;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReqHandleArgs)) {
                    return false;
                }
                ReqHandleArgs reqHandleArgs = (ReqHandleArgs) other;
                if (this.needShareUrl == reqHandleArgs.needShareUrl && this.needCreateShare == reqHandleArgs.needCreateShare && this.needHandleError == reqHandleArgs.needHandleError) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
            public int hashCode() {
                boolean z16 = this.needShareUrl;
                int i3 = 1;
                ?? r06 = z16;
                if (z16) {
                    r06 = 1;
                }
                int i16 = r06 * 31;
                ?? r26 = this.needCreateShare;
                int i17 = r26;
                if (r26 != 0) {
                    i17 = 1;
                }
                int i18 = (i16 + i17) * 31;
                boolean z17 = this.needHandleError;
                if (!z17) {
                    i3 = z17 ? 1 : 0;
                }
                return i18 + i3;
            }

            @NotNull
            public String toString() {
                return "ReqHandleArgs(needShareUrl=" + this.needShareUrl + ", needCreateShare=" + this.needCreateShare + ", needHandleError=" + this.needHandleError + ")";
            }

            public ReqHandleArgs(boolean z16, boolean z17, boolean z18) {
                this.needShareUrl = z16;
                this.needCreateShare = z17;
                this.needHandleError = z18;
            }

            public /* synthetic */ ReqHandleArgs(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? true : z18);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class c implements IGProCreateShareCallback {

            /* renamed from: a */
            final /* synthetic */ CancellableContinuation f220303a;

            /* renamed from: b */
            final /* synthetic */ GuildFeedArkShareInfo f220304b;

            c(CancellableContinuation cancellableContinuation, GuildFeedArkShareInfo guildFeedArkShareInfo) {
                this.f220303a = cancellableContinuation;
                this.f220304b = guildFeedArkShareInfo;
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback
            public final void onResult(int i3, String str, GProCreateShareRsp gProCreateShareRsp) {
                if (i3 == 0 && gProCreateShareRsp != null) {
                    if (this.f220303a.isActive()) {
                        Logger.f235387a.d().i("guild.share.ShareFeedActionHandler", 1, "fetchCreateShare rsp templateDataLength:" + gProCreateShareRsp.templateData.length());
                        com.tencent.mobileqq.guild.feed.share.v.l(this.f220304b, gProCreateShareRsp.templateData);
                        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
                        if (c16 != null) {
                            byte[] bArr = gProCreateShareRsp.info.busiData;
                            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.info.busiData");
                            GProBusiData decodeBusiData = c16.decodeBusiData(bArr);
                            if (decodeBusiData != null) {
                                this.f220304b.l0(decodeBusiData.getShareAttaData().attaContentId);
                            }
                        }
                        this.f220303a.resumeWith(Result.m476constructorimpl(null));
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("fetchCreateShare, continuation is canceled");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it.next(), null);
                    }
                    return;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str2 = "fetchCreateShare, result: " + i3 + ", errMsg: " + str;
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it5.next(), null);
                }
                if (this.f220303a.isActive()) {
                    this.f220303a.resumeWith(Result.m476constructorimpl(null));
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a.d f(final GuildFeedArkShareInfo shareInfo, final Function1<? super FetchShareUrlResult, Unit> onFetchUrl) {
            return new a.d() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ad
                @Override // zn1.a.d
                public final void a(ri1.a aVar, a.e eVar) {
                    ShareFeedActionHandler.Companion.g(GuildFeedArkShareInfo.this, onFetchUrl, aVar, eVar);
                }
            };
        }

        public static final void g(GuildFeedArkShareInfo shareInfo, Function1 onFetchUrl, ri1.a error, a.e eVar) {
            Integer num;
            Intrinsics.checkNotNullParameter(shareInfo, "$shareInfo");
            Intrinsics.checkNotNullParameter(onFetchUrl, "$onFetchUrl");
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.f431477a == 0 && eVar != null) {
                Logger.a d16 = Logger.f235387a.d();
                String str = eVar.f452794a;
                Integer num2 = null;
                if (str != null) {
                    num = Integer.valueOf(str.length());
                } else {
                    num = null;
                }
                String str2 = eVar.f452796c;
                if (str2 != null) {
                    num2 = Integer.valueOf(str2.length());
                }
                d16.i("guild.share.ShareFeedActionHandler", 1, "fetchShareUrl rsp shareUrlLength:" + num + " shareLongUrlLength:" + num2);
                shareInfo.q0(eVar.f452794a);
                shareInfo.m0(eVar.f452796c);
                onFetchUrl.invoke(new FetchShareUrlResult(true, error));
                return;
            }
            onFetchUrl.invoke(new FetchShareUrlResult(false, error));
        }

        public final Object h(vk1.b bVar, GuildFeedArkShareInfo guildFeedArkShareInfo, Continuation continuation) {
            Continuation intercepted;
            String str;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GProCreateShareReq gProCreateShareReq = new GProCreateShareReq();
            GProShareInfo gProShareInfo = gProCreateShareReq.info;
            gProShareInfo.busiId = "pd_forum";
            gProShareInfo.resourceId = bVar.getFeedId();
            GProShareInfo gProShareInfo2 = gProCreateShareReq.info;
            gProShareInfo2.plat = 1;
            gProShareInfo2.target = 5;
            int E = bVar.E();
            if (E != 2 && E != 3) {
                str = "ark_feed_text";
            } else {
                str = "ark_feed_pic";
            }
            gProShareInfo2.stringTemplate = str;
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("guild.share.ShareFeedActionHandler", 2, "fetchCreateShare req:" + gProCreateShareReq);
            }
            com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 != null) {
                c16.createShare(gProCreateShareReq, ShareServiceType.FEED.getType(), new c(cancellableContinuationImpl, guildFeedArkShareInfo));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public static /* synthetic */ com.tencent.mobileqq.qcoroutine.api.coroutine.b j(Companion companion, PanelContext panelContext, GuildFeedArkShareInfo guildFeedArkShareInfo, String str, ReqHandleArgs reqHandleArgs, Function1 function1, int i3, Object obj) {
            ReqHandleArgs reqHandleArgs2;
            Function1 function12;
            if ((i3 & 8) != 0) {
                reqHandleArgs2 = new ReqHandleArgs(false, false, false, 7, null);
            } else {
                reqHandleArgs2 = reqHandleArgs;
            }
            if ((i3 & 16) != 0) {
                function12 = null;
            } else {
                function12 = function1;
            }
            return companion.i(panelContext, guildFeedArkShareInfo, str, reqHandleArgs2, function12);
        }

        public final Object k(GuildFeedArkShareInfo guildFeedArkShareInfo, Continuation<? super FetchShareUrlResult> continuation) {
            Continuation intercepted;
            boolean z16;
            GuildFeedArkShareInfo guildFeedArkShareInfo2;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            String p16 = guildFeedArkShareInfo.p();
            Intrinsics.checkNotNullExpressionValue(p16, "it.guildId");
            if (p16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = null;
            if (z16) {
                guildFeedArkShareInfo2 = guildFeedArkShareInfo;
            } else {
                guildFeedArkShareInfo2 = null;
            }
            if (guildFeedArkShareInfo2 != null) {
                zn1.a.e(guildFeedArkShareInfo2, ShareFeedActionHandler.INSTANCE.f(guildFeedArkShareInfo, new Function1<FetchShareUrlResult, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareUrl$2$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ShareFeedActionHandler.Companion.FetchShareUrlResult fetchShareUrlResult) {
                        invoke2(fetchShareUrlResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ShareFeedActionHandler.Companion.FetchShareUrlResult result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (cancellableContinuationImpl.isActive()) {
                            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(result));
                            return;
                        }
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        bVar.a().add("fetchShareUrl, continuation is canceled");
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it.next(), null);
                        }
                    }
                }));
                unit = Unit.INSTANCE;
            }
            if (unit == null && cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                ri1.a f16 = ri1.a.f();
                Intrinsics.checkNotNullExpressionValue(f16, "ok()");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new FetchShareUrlResult(true, f16)));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        private final void m(ri1.a aVar, PanelContext<Activity, vk1.b> panelContext) {
            IGProSecurityResult iGProSecurityResult;
            Object m476constructorimpl;
            Object obj = aVar.f431479c;
            if (obj instanceof IGProSecurityResult) {
                iGProSecurityResult = (IGProSecurityResult) obj;
            } else {
                iGProSecurityResult = null;
            }
            boolean z16 = false;
            if (iGProSecurityResult != null && ((int) iGProSecurityResult.get$actionCode()) == 102) {
                z16 = true;
            }
            if (z16) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String optString = new JSONObject(iGProSecurityResult.getStrDetail()).optString("verify_url");
                    vk1.b j3 = panelContext.j();
                    cx.e(panelContext.h(), optString, String.valueOf(j3.getGuildId()), j3.r());
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "handleSecurityResult: " + m479exceptionOrNullimpl;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it.next(), null);
                    }
                    return;
                }
                return;
            }
            if (iGProSecurityResult != null) {
                QQToast.makeText(panelContext.h(), 1, iGProSecurityResult.getStrPrompt(), 1).show();
            }
        }

        public final void n(ri1.a aVar, PanelContext<Activity, vk1.b> panelContext) {
            if (aVar.f431477a == -200) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "fetchShareUrl handleSecurityResult errCode:" + aVar.f431477a;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it.next(), null);
                }
                m(aVar, panelContext);
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "fetchShareUrl otherError errCode:" + aVar.f431477a;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("guild.share.ShareFeedActionHandler", 1, (String) it5.next(), null);
            }
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).toastError(panelContext.h(), aVar.f431477a, aVar.f431478b);
        }

        @Nullable
        public final com.tencent.mobileqq.qcoroutine.api.coroutine.b i(@NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull GuildFeedArkShareInfo r16, @NotNull String fromTag, @NotNull ReqHandleArgs reqArgs, @Nullable Function1<? super Boolean, Unit> block) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(r16, "shareArkInfo");
            Intrinsics.checkNotNullParameter(fromTag, "fromTag");
            Intrinsics.checkNotNullParameter(reqArgs, "reqArgs");
            CoroutineScope d16 = GuildFeedMorePanelHandlerUtils.f220288a.d(panelContext);
            if (d16 != null) {
                return CorountineFunKt.e(d16, "guild.share.ShareFeedActionHandler feedShare", null, null, Boolean.TRUE, new ShareFeedActionHandler$Companion$fetchShareFeedInfo$1(r16, reqArgs, panelContext, block, fromTag, null), 6, null);
            }
            return null;
        }

        @Nullable
        public final GuildFeedArkShareInfo l(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            return (GuildFeedArkShareInfo) panelContext.getExtra().getParcelable("guild_feed_ark_share_info");
        }

        @Nullable
        public final GuildFeedArkShareInfo o(@NotNull PanelContext<Activity, vk1.b> panelContext, boolean isNewSharePanel) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            GuildFeedArkShareInfo guildFeedArkShareInfo = (GuildFeedArkShareInfo) panelContext.getExtra().getParcelable("guild_feed_ark_share_info_preload");
            if (guildFeedArkShareInfo == null) {
                guildFeedArkShareInfo = new FeedMorePanelUtils.ShareArkInfoInitTask(panelContext).e();
            }
            if (isNewSharePanel && guildFeedArkShareInfo != null) {
                guildFeedArkShareInfo.n0(2);
            }
            panelContext.getExtra().putParcelable("guild_feed_ark_share_info", guildFeedArkShareInfo);
            return guildFeedArkShareInfo;
        }

        Companion() {
        }
    }

    public final void j(int destPlat, PanelContext<Activity, vk1.b> panelContext, String fromTag) {
        GuildFeedShareChannelEvent.INSTANCE.a(fromTag, new GuildFeedShareChannelEvent(String.valueOf(panelContext.j().getGuildId()), String.valueOf(panelContext.j().getChannelId()), panelContext.j().getFeedId(), destPlat, null, 16, null));
    }

    private final boolean k(String actionTag, GuildFeedArkShareInfo r112, PanelContext<Activity, vk1.b> panelContext, Companion.ReqHandleArgs reqArgs, final Function1<? super Boolean, Unit> block) {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.feedShareTask;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("guild.share.ShareFeedActionHandler,cancel for handle first"));
        }
        this.feedShareTask = INSTANCE.i(panelContext, r112, "handle item:" + actionTag, reqArgs, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$fetchShareFeedInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                block.invoke(Boolean.valueOf(z16));
            }
        });
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
    
        if (r5 != 73) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(PanelContext<Activity, vk1.b> panelContext, final GuildFeedArkShareInfo r18, ShareActionSheetBuilder.ActionSheetItem r19, final ShareActionSheet shareActionSheet) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Unit unit;
        Logger.f235387a.d().i("guild.share.ShareFeedActionHandler", 1, "handle handleActionInternal item:" + r19.action);
        com.tencent.mobileqq.guild.feed.share.r rVar = new com.tencent.mobileqq.guild.feed.share.r(panelContext.h(), r18);
        Bundle extra = panelContext.getExtra();
        GuildSharePageSource guildSharePageSource = GuildSharePageSource.UNKNOWN;
        rVar.a(extra.getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal()));
        int i3 = r19.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 != 171) {
                                    if (i3 == 72) {
                                        rVar.e(r19.uin, r19.uinType);
                                    }
                                } else {
                                    rVar.b();
                                }
                            } else {
                                rVar.e(AppConstants.DATALINE_PC_UIN, 6000);
                            }
                        } else {
                            rVar.g(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ab
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ShareFeedActionHandler.n(ShareActionSheet.this);
                                }
                            });
                        }
                    } else {
                        GuildFeedShareToWXInfo.Companion companion = GuildFeedShareToWXInfo.INSTANCE;
                        String y16 = r18.y();
                        Intrinsics.checkNotNullExpressionValue(y16, "shareArkInfo.shareTitle");
                        String s16 = r18.s();
                        Intrinsics.checkNotNullExpressionValue(s16, "shareArkInfo.outShareContent");
                        GuildFeedShareToWXInfo a16 = companion.a(panelContext, y16, s16);
                        if (a16 != null) {
                            GuildFeedShareToWXHelper.f220290a.q(panelContext.h(), a16);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            rVar.h(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.aa
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ShareFeedActionHandler.m();
                                }
                            });
                        }
                    }
                } else {
                    rVar.f();
                }
            }
            rVar.d();
        } else {
            rVar.c();
        }
        int i16 = r19.action;
        if (i16 != 1) {
            j(GuildFeedShareChannelEvent.INSTANCE.d(i16), panelContext, "handleActionInternal");
        }
        q(panelContext.h(), r18);
        int i17 = r19.action;
        if (i17 == 9 || i17 == 10 || i17 == 3 || i17 == 1) {
            String w3 = r18.w();
            Intrinsics.checkNotNullExpressionValue(w3, "shareArkInfo.shareLongUrl");
            GuildActionSheetAttaUtil.o(w3, r19.action, panelContext.getExtra().getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal()), "");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.setGuildListTop(r18.p(), 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ac
                @Override // wh2.eh
                public final void a(int i18, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                    ShareFeedActionHandler.o(GuildFeedArkShareInfo.this, i18, str, iGProGuildListSortInfo);
                }
            });
        }
        shareActionSheet.dismiss();
    }

    public static final void n(ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(shareActionSheet, "$shareActionSheet");
        shareActionSheet.dismiss();
    }

    public static final void o(GuildFeedArkShareInfo shareArkInfo, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(shareArkInfo, "$shareArkInfo");
        Logger.f235387a.d().i("guild.share.ShareFeedActionHandler", 1, "setGuildListTop end. with guildId=" + shareArkInfo.p() + " code=" + i3 + " errMsg=" + str);
    }

    private final boolean p(String id5, boolean appendAction, PanelContext<Activity, vk1.b> panelContext) {
        boolean z16 = true;
        GuildFeedArkShareInfo o16 = INSTANCE.o(panelContext, true);
        if (o16 == null) {
            QLog.e("guild.share.ShareFeedActionHandler", 1, "handle: " + id5 + ", shareInfo is null");
            return true;
        }
        if (appendAction || !FeedMorePanelUtils.f220193a.l(id5)) {
            z16 = false;
        }
        return k(id5, o16, panelContext, new Companion.ReqHandleArgs(false, z16, false, 5, null), new ShareFeedActionHandler$handleAppendActionOrShareChannel$1(panelContext, o16, appendAction, id5, this));
    }

    public final void q(Activity activity, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedShareSuccessEvent(), true);
        GuildFeedBaseInitBean q16 = ax.q(activity);
        if (q16 != null) {
            str = q16.getPageId();
            Intrinsics.checkNotNullExpressionValue(str, "bean.pageId");
            str3 = q16.getPageForumType(str);
            Intrinsics.checkNotNullExpressionValue(str3, "bean.getPageForumType(pageId)");
            str4 = q16.getPrePageId();
            Intrinsics.checkNotNullExpressionValue(str4, "bean.prePageId");
            str2 = q16.getPrePageForumType(str4);
            Intrinsics.checkNotNullExpressionValue(str2, "bean.getPrePageForumType(prePageId)");
        } else {
            QLog.w("guild.share.ShareFeedActionHandler", 2, "shareReport bean == null");
            str = "";
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        GuildFeedReportTable12003.a i06 = com.tencent.mobileqq.guild.feed.report.f.g(guildFeedArkShareInfo.p(), guildFeedArkShareInfo.k(), str3).U(guildFeedArkShareInfo.n()).n0(String.valueOf(guildFeedArkShareInfo.t())).L(String.valueOf(guildFeedArkShareInfo.t())).K("share").J("success").Y(str).V(str3).g0(str4).f0(str2).a0(com.tencent.mobileqq.guild.report.b.c()).q0(com.tencent.mobileqq.guild.report.b.f()).i0(com.tencent.mobileqq.guild.report.b.e());
        Intrinsics.checkNotNullExpressionValue(i06, "convertPageDataBuilderTa\u2026 .setSessionId(sessionId)");
        GuildFeedReportTable12003.c(i06, 12000);
        QLog.d("guild.share.ShareFeedActionHandler", 2, "shareReport ", i06.I());
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return p(id5, true, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return p(id5, false, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull final ShareActionSheetBuilder.ActionSheetItem r17, @NotNull final PanelContext<Activity, vk1.b> panelContext, @NotNull final ShareActionSheet shareActionSheet) {
        boolean z16;
        Intrinsics.checkNotNullParameter(r17, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        final GuildFeedArkShareInfo o16 = INSTANCE.o(panelContext, false);
        if (o16 == null) {
            QLog.e("guild.share.ShareFeedActionHandler", 1, "handle: " + r17 + ", shareInfo is null");
            shareActionSheet.dismiss();
            return true;
        }
        String valueOf = String.valueOf(r17.action);
        FeedMorePanelUtils feedMorePanelUtils = FeedMorePanelUtils.f220193a;
        if (feedMorePanelUtils.k(r17.action) && feedMorePanelUtils.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return k(valueOf, o16, panelContext, new Companion.ReqHandleArgs(false, z16, false, 5, null), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$handle$1
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

            public final void invoke(boolean z17) {
                if (z17) {
                    ShareFeedActionHandler.this.l(panelContext, o16, r17, shareActionSheet);
                }
            }
        });
    }

    public static final void m() {
    }
}
