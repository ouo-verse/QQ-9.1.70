package com.tencent.mobileqq.nearbypro.api.router.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.nearbypro.NearbyProMainFragment;
import com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor;
import com.tencent.mobileqq.nearbypro.aio.utils.NearbyProAIOUtils;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.nearbypro.api.router.NearbyFeedPosterData;
import com.tencent.mobileqq.nearbypro.api.router.a;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.NearbyProChatsListFragment;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016J8\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J=\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b\u0018\u00010\u001aH\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0016J \u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J \u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\rH\u0016J[\u00101\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010!2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\r2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b1\u00102J \u00106\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010)\u001a\u0002032\u0006\u00105\u001a\u000204H\u0016J,\u0010;\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\n\u00108\u001a\u00060\u0015j\u0002`72\u0006\u0010)\u001a\u00020\u00152\u0006\u0010:\u001a\u000209H\u0016\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/impl/NearbyProPageRouterImpl;", "Lcom/tencent/mobileqq/nearbypro/api/router/INearbyProPageRouter;", "", "forceNBPMainNative", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "intent", "", "launchProfileEditPage", "launchNearbyMainFragment", "Landroidx/fragment/app/Fragment;", "fragment", "", "poiId", "routeToLocationPage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "tinyID", "nickname", PhotoCategorySummaryInfo.AVATAR_URL, "", "sourceType", "tacitInvite", "launchNearbyAIOFragment", QQFriendJsPlugin.API_ADD_FRIEND, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", GuildMsgItem.NICK_FRIEND, "callback", IProfileProtocolConst.PARAM_IS_FRIEND, "launchNearbyChatsListFragment", "", "tinyId", "isMode", "sourceId", "launchNearbyPersonalFragment", "context", AdMetricTag.Report.TYPE, "launchNearbyPersonalFragmentFromAIO", "source", "topicIds", "launchNearbyFeedPublishFragment", "feedID", "avatarDressBorderUrl", "Lop4/i;", "feed", "from", "launchNearbyFeedDetailFragment", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lop4/i;I)V", "Lcom/tencent/mobileqq/nearbypro/api/router/NBPArticleFeedDetailPageSource;", "Lcom/tencent/mobileqq/nearbypro/api/router/a;", "launchData", "launchArticleFeedDetailPage", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "appId", "Lcom/tencent/mobileqq/nearbypro/api/router/b;", "data", "launchFeedSharePage", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProPageRouterImpl implements INearbyProPageRouter {
    private final boolean forceNBPMainNative() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("NBP_MAIN_NATIVE", false);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void addFriend(@NotNull Context ctx, @NotNull String tinyID, @NotNull String nickname) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(tinyID, "tinyID");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        NearbyProAIOUtils.f253151a.a(ctx, tinyID, nickname, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void isFriend(@NotNull Context ctx, @NotNull String tinyID, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(tinyID, "tinyID");
        NearbyProAIOUtils.f253151a.c(tinyID, callback);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchArticleFeedDetailPage(@NotNull Context context, @NotNull NBPArticleFeedDetailPageSource source, @NotNull a launchData) {
        Object[] objArr;
        byte[] encodeToByteArray;
        byte[] encodeToByteArray2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(launchData, "launchData");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("feed_id", launchData.getFeedId());
        jSONObject.put("poster_user_id", launchData.getPosterUserId());
        jSONObject.put("poster_gender", launchData.getPosterGender());
        jSONObject.put("app_id", launchData.getAppId());
        if (launchData.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String() != null) {
            jSONObject.put("comment_id", launchData.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String());
        }
        if (launchData.getCommentReplyId() != null) {
            jSONObject.put("comment_reply_id", launchData.getCommentReplyId());
        }
        if (launchData.getExt() != null) {
            jSONObject.put("ext", launchData.getExt());
        }
        byte[] feedPbByteArray = launchData.getFeedPbByteArray();
        QQNearbyModule.Companion companion = QQNearbyModule.INSTANCE;
        if (feedPbByteArray != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.toString()");
            encodeToByteArray2 = StringsKt__StringsJVMKt.encodeToByteArray(jSONObject2);
            objArr = new Object[]{encodeToByteArray2, feedPbByteArray};
        } else {
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "data.toString()");
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(jSONObject3);
            objArr = new Object[]{encodeToByteArray};
        }
        companion.i(objArr);
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_article_feed_detail&nbp_source=" + source.getValue() + "&custom_back_pressed=1");
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchFeedSharePage(@NotNull Context context, int appId, int source, @NotNull NearbyFeedPosterData data) {
        String b16;
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        String str = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=" + appId + "&custom_back_pressed=1&modal_mode=1&nbp_source=" + source;
        QQNearbyModule.Companion companion = QQNearbyModule.INSTANCE;
        b16 = ea2.a.b(data);
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(b16);
        companion.i(new Object[]{encodeToByteArray});
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyAIOFragment(@NotNull Context ctx, @NotNull String tinyID, @NotNull String nickname, @NotNull String avatarUrl, int sourceType, int tacitInvite) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(tinyID, "tinyID");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Bundle bundle = new Bundle();
        bundle.putInt("key_from", sourceType);
        boolean z16 = true;
        if (tacitInvite != 1) {
            z16 = false;
        }
        bundle.putBoolean("key_from_invite", z16);
        NearByProTempProcessor.f253128d.d(ctx, tinyID, bundle, nickname);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyChatsListFragment(@NotNull Context ctx, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(intent, "intent");
        j.c().e("NBP.PageRouter", "openNearbyProChatsListFragment");
        QPublicFragmentActivity.start(ctx, intent, NearbyProChatsListFragment.class);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyFeedDetailFragment(@NotNull Context ctx, @Nullable String feedID, @Nullable Long tinyID, @Nullable String name, @Nullable String avatarUrl, @Nullable String avatarDressBorderUrl, @Nullable i feed, int from) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        j.c().e("NBP.PageRouter", "launchNearbyFeedDetailFragment");
        pa2.a.b(pa2.a.f425847a, feedID, tinyID, name, avatarUrl, avatarDressBorderUrl, feed, from, null, 128, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyFeedPublishFragment(@NotNull Context ctx, int source, @NotNull String topicIds) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(topicIds, "topicIds");
        j.c().e("NBP.PageRouter", "launchNearbyFeedPublishFragment");
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_publish&source=" + source + "&topicIds=" + topicIds);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyMainFragment(@NotNull Context ctx, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(intent, "intent");
        j.c().e("NBP.PageRouter", "launchNearbyMainFragment " + ctx + ", " + intent);
        if (((INearbyProToolApi) QRoute.api(INearbyProToolApi.class)).getLocationMode(ctx) <= 0) {
            QQToastUtil.showQQToastInUiThread(1, ctx.getString(R.string.f170392kx));
            return;
        }
        if (!j.a().mo208public() && forceNBPMainNative()) {
            QPublicFragmentActivity.start(ctx, intent, NearbyProMainFragment.class);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("page_name", "nearbypro_main");
        extras.putString("source", "1");
        extras.putString(KuiklyLaunchParams.PARAM_CUSTOM_BACK_PRESSED, "1");
        QRoute.api(IVasSquareApi.class);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(ctx, extras);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyPersonalFragment(@NotNull Context ctx, long tinyId, boolean isMode, int sourceId) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        j.c().e("NBP.PageRouter", "launchNearbyPersonalFragment");
        int i3 = tinyId == s.a() ? 1 : 0;
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=" + (isMode ? "nearby_modal_homepage&modal_mode=1" : "nearby_new_homepage") + "&bu_type=2&self=" + i3 + "&tinyid=" + tinyId + "&source_id=" + sourceId);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyPersonalFragmentFromAIO(@NotNull Context ctx, long tinyId) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        launchNearbyPersonalFragment(ctx, tinyId, 8);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchProfileEditPage(@NotNull Context ctx, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(intent, "intent");
        j.c().c("NBP.PageRouter", "launchProfileEditPage " + ctx + ", " + intent);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void routeToLocationPage(@Nullable Fragment fragment, @NotNull String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        j.c().c("NBP.PageRouter", "routeToLocationPage " + fragment + ", " + poiId);
        if (fragment == null) {
            j.c().d("NBP.PageRouter", "routeToLocationPage fragment is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.qzone.common.activities.base.QZoneFragmentHolderActivity");
        intent.putExtra("KEY_FRAGMENT_NAME", QZoneHelper.MOOD_SELECT_LOCATION);
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = poiId;
        intent.putExtra("key_current_poi", poiInfo);
        intent.putExtra("key_show_first_line", 0);
        intent.putExtra("key_lbs_state", 1);
        fragment.startActivityForResult(intent, 1208);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void launchNearbyPersonalFragment(@NotNull Context context, long tinyId, int reportType) {
        Intrinsics.checkNotNullParameter(context, "context");
        j.c().e("NBP.PageRouter", "launchNearbyPersonalFragment, " + reportType);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter
    public void routeToLocationPage(@Nullable Activity activity, @NotNull String poiId) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        j.c().c("NBP.PageRouter", "routeToLocationPage " + activity + ", " + poiId);
        if (activity == null) {
            j.c().d("NBP.PageRouter", "routeToLocationPage activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.qzone.common.activities.base.QZoneFragmentHolderActivity");
        intent.putExtra("KEY_FRAGMENT_NAME", QZoneHelper.MOOD_SELECT_LOCATION);
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = poiId;
        intent.putExtra("key_current_poi", poiInfo);
        intent.putExtra("key_show_first_line", 0);
        intent.putExtra("key_lbs_state", 1);
        activity.startActivityForResult(intent, 1208);
    }
}
