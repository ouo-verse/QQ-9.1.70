package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J6\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J2\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007J\u0014\u0010 \u001a\n \u001f*\u0004\u0018\u00010\f0\f*\u00020\fH\u0002J6\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/l;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/matchfriend/data/a;", "params", "", "c", "", "sourceType", "subSourceType", "d", "", "openId", "b", "matchFriendSource", "fromSource", "feedId", "e", "Landroid/content/Intent;", "intent", "f", "Lcom/tencent/mobileqq/nearbypro/api/router/NBPArticleFeedDetailPageSource;", "source", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "data", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$MiniInfo;", "selfInfo", "", "isButton", tl.h.F, "kotlin.jvm.PlatformType", "a", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "placeHolder", "j", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class l {

    /* renamed from: a */
    public static final l f245486a = new l();

    l() {
    }

    private final String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @JvmStatic
    public static final void b(Context context, String openId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(openId, "openId");
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_new_profile_edit&appid=1&tinyid=" + openId);
    }

    @JvmStatic
    public static final void c(Context context, com.tencent.mobileqq.matchfriend.data.a params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        IQQStrangerEntryApi iQQStrangerEntryApi = (IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class);
        int c16 = params.c();
        int d16 = params.d();
        String b16 = params.b();
        Intrinsics.checkNotNullExpressionValue(b16, "params.forwardUri");
        iQQStrangerEntryApi.enterHomePage(context, c16, d16, b16);
    }

    @JvmStatic
    public static final void d(Context context, int sourceType, int subSourceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class)).enterHomePage(context, sourceType, subSourceType, 0);
    }

    @JvmStatic
    public static final void e(Context context, String openId, int matchFriendSource, int fromSource, String feedId) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        if (context != null) {
            e82.a.f395872a.c(context, openId, matchFriendSource, fromSource, new Bundle(), null, feedId);
        }
    }

    @JvmStatic
    public static final void f(Context context, String openId, Intent intent) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (context != null) {
            e82.a aVar = e82.a.f395872a;
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Bundle bundle = extras;
            Intrinsics.checkNotNullExpressionValue(bundle, "intent.extras ?: Bundle()");
            aVar.c(context, openId, 0, 0, bundle, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        }
    }

    public final void j(Context context, String r46, String feedId, String r65, String r75, String placeHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(r46, "requestId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(r65, "commentId");
        Intrinsics.checkNotNullParameter(r75, "replyId");
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        String str = "mqqapi://kuikly/open?version=1&src_type=app&modal_mode=1&page_name=nearby_feed_comment_input&custom_back_pressed=1&request_id=" + a(r46) + "&app_id=1&feed_id=" + a(feedId) + "&target_comment_id=" + a(r65) + "&target_reply_id=" + a(r75) + "&placeholder=" + a(placeHolder);
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_JUMP);
    }

    @JvmStatic
    public static final void h(NBPArticleFeedDetailPageSource source, QQStrangerLiteActionModel data, userInfo$MiniInfo selfInfo, Context context, boolean z16) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(selfInfo, "selfInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
        String feedOwnerUid = data.getMsgInfo().getFeedOwnerUid();
        String feedId = data.getMsgInfo().getFeedId();
        if (!z16) {
            str = "";
        } else {
            str = data.getMsgInfo().getCommentId();
        }
        if (!z16) {
            str2 = "";
        } else {
            str2 = data.getMsgInfo().getReplyId();
        }
        iNearbyProPageRouter.launchArticleFeedDetailPage(context, source, new com.tencent.mobileqq.nearbypro.api.router.a(1, feedOwnerUid, 1, feedId, null, str, str2, null, 144, null));
    }

    public static /* synthetic */ void g(Context context, String str, int i3, int i16, String str2, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            str2 = null;
        }
        e(context, str, i3, i16, str2);
    }

    public static /* synthetic */ void i(NBPArticleFeedDetailPageSource nBPArticleFeedDetailPageSource, QQStrangerLiteActionModel qQStrangerLiteActionModel, userInfo$MiniInfo userinfo_miniinfo, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        h(nBPArticleFeedDetailPageSource, qQStrangerLiteActionModel, userinfo_miniinfo, context, z16);
    }
}
