package com.tencent.mobileqq.guild.feed.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.debug.GuildDebugFragment;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.detail.event.GuildFeedDetailCacheRespEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedFullScreenFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedGalleryPageFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildTroopFeedNoticeFragment;
import com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.performance.report.l;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheData;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.preload.detail.g;
import com.tencent.mobileqq.guild.feed.publish.GuildFeedPublishWebViewFragment;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.ay;
import com.tencent.mobileqq.guild.feed.util.v;
import com.tencent.mobileqq.guild.feed.util.w;
import com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailWebBundleFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.nt.misc.api.IActivityClassesApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ab;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.util.URLUtil;
import cooperation.peak.PeakConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import vh1.k;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedLauncher {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f220058a;

        a(c cVar) {
            this.f220058a = cVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f220058a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
        void a();
    }

    public static void A(Context context, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        E(context, guildFeedPublishInitBean);
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), guildFeedPublishInitBean.getGuildId(), "clickPublishPost");
    }

    public static void B(Context context, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        E(context, guildFeedPublishInitBean);
    }

    public static void C(Context context, GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean) {
        E(context, guildFeedPublishEditPostInitBean);
    }

    public static void D(Context context, GuildFeedPublishThirdContentInitBean guildFeedPublishThirdContentInitBean) {
        E(context, guildFeedPublishThirdContentInitBean);
    }

    private static void E(Context context, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        if (v.a().c(WebViewFragment.TAG, 3000L)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedPublishInitBean);
        String t16 = GuildFeedPublishUtils.f222315a.t();
        String guildId = guildFeedPublishInitBean.getGuildId();
        if (guildFeedPublishInitBean.isEditPublish()) {
            GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean = (GuildFeedPublishEditPostInitBean) guildFeedPublishInitBean;
            String feedId = guildFeedPublishEditPostInitBean.getFeedId();
            t16 = URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(t16, "guildId", guildId), "channelId", guildFeedPublishInitBean.getChannelId()), "feedId", feedId), "posterTinyId", guildFeedPublishEditPostInitBean.getPosterTinyId()), WadlProxyConsts.CREATE_TIME, String.valueOf(guildFeedPublishEditPostInitBean.getCreateTime()));
        }
        if (guildFeedPublishInitBean.getBusinessType() == 7) {
            t16 = URLUtil.addParameter(t16, "feedBusiness", String.valueOf(1));
        }
        String h16 = h(GuildFeedHtmlOfflineUtil.b(t16), context);
        intent.putExtra("url", h16);
        intent.putExtra("fragment_class", GuildFeedPublishWebViewFragment.class.getCanonicalName());
        intent.putExtra("titleBarStyle", 9);
        intent.putExtra("hide_title_left_arrow", true);
        intent.putExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE, nn1.a.b().a(context));
        intent.putExtra("guildfeed", true);
        cx.f(context, h16, guildId, guildFeedPublishInitBean.getTinyId(), intent.getExtras());
        l.r(guildFeedPublishInitBean);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
        }
    }

    public static void F(final Activity activity, final Bundle bundle, final int i3, final int i16, final int i17, final boolean z16, final boolean z17, final boolean z18) {
        f(activity, new c() { // from class: com.tencent.mobileqq.guild.feed.launcher.d
            @Override // com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher.c
            public final void a() {
                GuildFeedLauncher.j(activity, bundle, i3, i16, i17, z16, z17, z18);
            }
        });
    }

    public static void G(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedLauncher_GalleryActivity")) {
            return;
        }
        QLog.i("GuildFeedLauncher", 1, "[launchOldGuildFeedGalleryActivity]==1");
        Intent K = K(context, guildFeedGalleryInitBean, null);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(K, 10000);
        } else {
            K.setFlags(268435456);
            context.startActivity(K);
        }
    }

    public static void H(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean, Intent intent) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedLauncher_GalleryActivity")) {
            return;
        }
        QLog.i("GuildFeedLauncher", 1, "[launchOldGuildFeedGalleryActivity]==2");
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedGalleryInitBean);
        intent.setClass(context, QPublicTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", GuildFeedGalleryPageFragment.class.getCanonicalName());
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.D, guildFeedGalleryInitBean.isShowCloseIcon());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 10000);
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void I(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean, LocalMediaInfo localMediaInfo, View view) {
        G(context, am.g(guildFeedGalleryInitBean, localMediaInfo, view));
    }

    public static void J(Context context, String str, String str2, String str3, int i3) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("key_guild_id", str);
        intent.putExtra("key_channel_id", str2);
        intent.putExtra("key_troop_id", str3);
        intent.putExtra("key_source_from", i3);
        intent.addFlags(268435456);
        GuildSplitViewUtils.f235370a.o(context, intent, GuildTroopFeedNoticeFragment.class, LaunchMode.standard);
    }

    public static Intent K(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedGalleryInitBean);
        intent.setClass(context, QPublicTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", GuildFeedGalleryPageFragment.class.getCanonicalName());
        intent.putExtra("public_fragment_window_feature", 1);
        if (guildFeedGalleryInitBean.getBusinessType() == 7 && (context instanceof Activity)) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("FEED_TROOP_UIN");
            if (!TextUtils.isEmpty(stringExtra)) {
                guildFeedGalleryInitBean.setTroopUin(stringExtra);
            }
        }
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.D, guildFeedGalleryInitBean.isShowCloseIcon());
        return intent;
    }

    private static boolean L(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        boolean z16;
        if (guildFeedDetailInitBean.getShareSource() == 11) {
            return false;
        }
        if (guildFeedDetailInitBean.getShareSource() == 15 && guildFeedDetailInitBean.getBusinessType() != 7) {
            return !TextUtils.isEmpty(guildFeedDetailInitBean.getJoinInfoParam().getJoinSignature());
        }
        if (guildFeedDetailInitBean.getAttrs().containsKey(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE)) {
            z16 = ((Boolean) guildFeedDetailInitBean.getAttrs().get(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE)).booleanValue();
        } else {
            z16 = false;
        }
        if (z16 || !((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).showNavigateTitle(guildFeedDetailInitBean.getGuildId())) {
            return false;
        }
        return true;
    }

    private static void M(String str) {
        if (1 != MobileQQ.sProcessId) {
            QLog.e("GuildFeedLauncher", 1, "can't tryFetchGuestGuildInfo out of MAIN Process!!!");
        } else {
            GuildMainFrameUtils.k(str, new Function1() { // from class: com.tencent.mobileqq.guild.feed.launcher.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s16;
                    s16 = GuildFeedLauncher.s((IGProGuildInfo) obj);
                    return s16;
                }
            });
        }
    }

    private static void N(final GuildFeedDetailInitBean guildFeedDetailInitBean) {
        final GuildFeedDetailDataCacheManager y16 = GuildFeedDetailDataCacheManager.y();
        final String feedId = guildFeedDetailInitBean.getFeedId();
        if (y16.x(feedId) > 0) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher$1$a */
            /* loaded from: classes13.dex */
            class a implements g {
                a() {
                }

                @Override // com.tencent.mobileqq.guild.feed.preload.detail.g
                public void a(boolean z16, GuildFeedDetailCacheResponse guildFeedDetailCacheResponse) {
                    if (z16 && guildFeedDetailCacheResponse != null) {
                        for (GuildFeedDetailCacheData guildFeedDetailCacheData : guildFeedDetailCacheResponse.getCacheList()) {
                            if (guildFeedDetailCacheData.getFeedId().equals(feedId)) {
                                QLog.d("GuildFeedLauncher", 1, "send GuildFeedDetailCacheRespEvent " + feedId);
                                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailCacheRespEvent(feedId, guildFeedDetailCacheData.getLastModifyTime()), true);
                                return;
                            }
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GuildFeedDetailDataCacheManager.this.E(feedId, guildFeedDetailInitBean.getLastModifiedTime())) {
                    return;
                }
                GuildFeedDetailPreloadParams covertToPreloadParams = guildFeedDetailInitBean.covertToPreloadParams();
                if (!covertToPreloadParams.isValid()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(covertToPreloadParams);
                GuildFeedDetailDataCacheManager.this.t(arrayList, new a());
            }
        }, 128, null, false);
    }

    private static void O(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        long lastModifiedTime = guildFeedDetailInitBean.getLastModifiedTime();
        long x16 = GuildFeedDetailDataCacheManager.y().x(guildFeedDetailInitBean.getFeedId());
        if (x16 > lastModifiedTime) {
            guildFeedDetailInitBean.setLastModifiedTime(x16);
        }
    }

    private static void P(Context context, GuildFeedDetailInitBean guildFeedDetailInitBean) {
        GuildAppReportSourceInfo fromActivity;
        O(guildFeedDetailInitBean);
        if ((context instanceof Activity) && (fromActivity = GuildAppReportSourceInfo.fromActivity((Activity) context)) != null) {
            guildFeedDetailInitBean.setJumpExtraInfo(fromActivity);
        }
    }

    private static String e(String str) {
        for (Map.Entry<String, String> entry : com.tencent.mobileqq.guild.report.b.d().entrySet()) {
            str = ch.n(str, entry.getKey(), entry.getValue());
        }
        return str;
    }

    public static void f(Activity activity, c cVar) {
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            cVar.a();
        } else {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new a(cVar));
        }
    }

    public static void g(final Activity activity, final Bundle bundle, final int i3, final int i16, final int i17, final boolean z16, final boolean z17, final boolean z18, final b bVar) {
        f(activity, new c() { // from class: com.tencent.mobileqq.guild.feed.launcher.e
            @Override // com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher.c
            public final void a() {
                GuildFeedLauncher.p(activity, bundle, i3, i16, i17, z16, z17, z18, bVar);
            }
        });
    }

    private static String h(String str, Context context) {
        if (context == null) {
            return str;
        }
        if (!AppSetting.o(context)) {
            return str;
        }
        String str2 = URLUtil.getArgumentsFromURL(str).get("_wwv");
        if (str2 != null && TextUtils.isDigitsOnly(str2)) {
            return URLUtil.addParameter(URLUtil.deleteParameter(str, "_wwv"), "_wwv", String.valueOf(Integer.parseInt(str2) | 2));
        }
        return str;
    }

    private static Intent i(Activity activity, Bundle bundle, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        if (i3 == 0 && i16 == 0) {
            QQToast.makeText(activity, 1, ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getString(R.string.f144050nq), 0).show();
            return null;
        }
        String string = bundle.getString("key_for_album_guild_id", "");
        String string2 = bundle.getString("key_for_album_channel_id", "");
        Intent n3 = n(activity, i3, i16, z17);
        l(n3, string, string2, i3, i16, z16, i17, z18);
        return n3;
    }

    public static void j(Activity activity, Bundle bundle, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        Intent i18 = i(activity, bundle, i3, i16, i17, z16, z17, z18);
        if (i18 == null) {
            return;
        }
        activity.startActivityForResult(i18, 10014);
    }

    private static void k() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            com.tencent.mobileqq.guild.feed.detail.task.e.h().n();
            return;
        }
        hj1.b.a("GuildFeedLauncher", "launchGuildFeedDetailActivity | " + new Exception());
    }

    public static Intent l(Intent intent, String str, String str2, int i3, int i16, boolean z16, int i17, boolean z17) {
        intent.putExtra("key_guild_feed_publish_max_photo", i3);
        intent.putExtra("key_guild_feed_need_mutex_media", z16);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", i16);
        intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, i17 * 1000);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", i3 + i16);
        if (z17 && ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(str, str2)) {
            intent.putExtra("key_guild_check_qrcode_image", true);
        }
        return intent;
    }

    public static Intent m(GuildFeedDetailInitBean guildFeedDetailInitBean, long j3, Context context) {
        String str;
        Class cls;
        Intent intent = new Intent();
        String c16 = w.c("qqguild", "guild_feed_detail_web_url", ay.f223860b);
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedDetailInitBean);
        if (guildFeedDetailInitBean.getAttrs().get(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_URL) != null) {
            str = (String) guildFeedDetailInitBean.getAttrs().get(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_URL);
        } else {
            str = "";
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2) || !str2.startsWith("http")) {
            str2 = o(guildFeedDetailInitBean, c16, j3, context, str2);
        }
        String e16 = e(str2);
        intent.putExtra("url", e16);
        intent.putExtra(GuildFeedBaseWebViewFragment.KEY_GESTURE_EXIT_FORM_LEFT_TO_RIGHT, true);
        boolean enableWebBundlePreload = ((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).enableWebBundlePreload();
        QLog.d("GuildFeedLauncher", 1, "FeedWebBundle== useWebBundle:" + enableWebBundlePreload + " targetDetailUrl:" + e16);
        if (enableWebBundlePreload) {
            cls = GuildFeedDetailWebBundleFragment.class;
        } else {
            cls = GuildFeedDetailWebViewFragment.class;
        }
        intent.putExtra("fragment_class", cls.getCanonicalName());
        intent.putExtra("titleBarStyle", 10);
        if (guildFeedDetailInitBean.getAnimationParams() != null) {
            intent.putExtra("fragmentClass", cls);
            intent.putExtra("browserType", ((IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class)).getTranslucentBrowserType());
        }
        return intent;
    }

    public static Intent n(Activity activity, int i3, int i16, boolean z16) {
        boolean z17;
        if (z16) {
            return ((IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class)).getOpenCommentAlbumIntent(activity, i3);
        }
        IGuildFeedMediaApi iGuildFeedMediaApi = (IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class);
        int i17 = i3 + i16;
        if (i16 <= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        return iGuildFeedMediaApi.getOpenNativePublishAlbumIntent(activity, i17, z17);
    }

    public static String o(GuildFeedDetailInitBean guildFeedDetailInitBean, String str, long j3, Context context, String str2) {
        StringBuilder sb5 = new StringBuilder(str + "&feedId=" + guildFeedDetailInitBean.getFeedId() + "&createTime=" + guildFeedDetailInitBean.getCreateTime() + "&posterTinyId=" + guildFeedDetailInitBean.getPosterTinyId() + "&visitorTinyId=" + guildFeedDetailInitBean.getVisitorTinyId() + "&position=" + guildFeedDetailInitBean.getPosition() + "&guild_id=" + guildFeedDetailInitBean.getGuildId() + "&channel_id=" + guildFeedDetailInitBean.getChannelId() + "&pageid=" + guildFeedDetailInitBean.getPageid() + "&tabid=" + guildFeedDetailInitBean.getTabid() + "&commentId=" + guildFeedDetailInitBean.getCommentId() + "&replyId=" + guildFeedDetailInitBean.getReplyId() + "&comment_req_transfer=" + guildFeedDetailInitBean.getCommentTransfer() + "&inviteCode=" + guildFeedDetailInitBean.getInviteCode() + "&clickTime=" + j3 + "&isAdmin=" + (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(40001, guildFeedDetailInitBean.getGuildId(), guildFeedDetailInitBean.getChannelId()).booleanValue() ? 1 : 0) + "&bannerId=" + guildFeedDetailInitBean.getBannerId() + "&appChannel=" + guildFeedDetailInitBean.getJumpExtraInfo().getReportInfoMap().get("sgrp_stream_pgin_source_name"));
        if (guildFeedDetailInitBean.getJoinInfoParam() != null && !TextUtils.isEmpty(guildFeedDetailInitBean.getJoinInfoParam().getMainSource())) {
            sb5.append("&joinGuildSig=");
            sb5.append(guildFeedDetailInitBean.getJoinInfoParam().getJoinSignature());
            sb5.append("&sourceId=");
            sb5.append(guildFeedDetailInitBean.getJoinInfoParam().getMainSource());
            sb5.append("&subSourceId=");
            sb5.append(guildFeedDetailInitBean.getJoinInfoParam().getSubSource());
        }
        if (guildFeedDetailInitBean.getBusinessType() == 7) {
            sb5.append("&feedBusiness=1");
        }
        if (L(guildFeedDetailInitBean)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("titleBarStyle");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(1);
        }
        String prePageId = guildFeedDetailInitBean.getPrePageId();
        if (!TextUtils.isEmpty(prePageId)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("re_page_id");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(prePageId);
        }
        String prePageForumType = guildFeedDetailInitBean.getPrePageForumType(prePageId);
        if (!TextUtils.isEmpty(prePageId)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("re_sgrp_pg_forum_type");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(prePageForumType);
        }
        HashMap<String, String> discoverSearchDtParams = guildFeedDetailInitBean.getDiscoverSearchDtParams();
        if (discoverSearchDtParams != null) {
            try {
                for (Map.Entry<String, String> entry : discoverSearchDtParams.entrySet()) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(entry.getKey());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return h(cq1.a.a(cq1.a.a(GuildFeedHtmlOfflineUtil.a(sb5.toString()), "businessType", "2"), com.tencent.mobileqq.guild.feed.b.f218131q, guildFeedDetailInitBean.getShareSource() != 0 ? guildFeedDetailInitBean.getShareSource() + "" : cq1.a.b(str2)), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(Activity activity, Bundle bundle, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, b bVar) {
        Intent i18 = i(activity, bundle, i3, i16, i17, z16, z17, z18);
        if (bVar != null) {
            bVar.a(i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(GuildFeedDetailInitBean guildFeedDetailInitBean, long j3) {
        GuildFeedReportHelper.i().m(guildFeedDetailInitBean, j3);
        GuildFeedGuestBusinessHandler.d().g();
        o02.a.f(11);
        N(guildFeedDetailInitBean);
        if (!guildFeedDetailInitBean.isMember()) {
            M(guildFeedDetailInitBean.getGuildId());
        }
        ab.b("GuildFeedLauncher#launchGuildFeedDetailActivity#End");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit s(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.e("GuildFeedLauncher", 1, "tryFetchGuestGuildInfo is null!");
        }
        return Unit.INSTANCE;
    }

    public static void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(BaseApplication.getContext(), ((IActivityClassesApi) QRoute.api(IActivityClassesApi.class)).getJumpActivityClass());
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        BaseApplication.getContext().startActivity(intent);
    }

    public static void u(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.start(context, intent, GuildDebugFragment.class);
    }

    public static void v(Context context, GuildFeedFullScreenBean guildFeedFullScreenBean) {
        if (FastClickUtils.isFastDoubleClick("GuildFeedLauncher_launchFullScreenPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QPublicFragmentActivity.class);
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedFullScreenBean);
        intent.putExtra("public_fragment_class", GuildFeedFullScreenFragment.class.getName());
        context.startActivity(intent);
    }

    public static void w(Context context, GuildFeedDetailInitBean guildFeedDetailInitBean) {
        x(context, guildFeedDetailInitBean, Boolean.FALSE);
    }

    public static void x(Context context, final GuildFeedDetailInitBean guildFeedDetailInitBean, Boolean bool) {
        if (((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).isLongFeedNativeSwitchOpen()) {
            bool = Boolean.TRUE;
        }
        ab.b("GuildFeedLauncher#launchGuildFeedDetailActivity#Start needOpenNative\uff1a" + bool);
        final long currentTimeMillis = System.currentTimeMillis();
        if (bool.booleanValue()) {
            GProStFeed stFeed = guildFeedDetailInitBean.getStFeed();
            Intent intent = new Intent();
            intent.putExtra("start_intent_interact_action", guildFeedDetailInitBean.getPosition());
            intent.putExtra("feed_immersive_source", guildFeedDetailInitBean.getImmersiveSource());
            intent.putExtra("join_info_param", (Parcelable) guildFeedDetailInitBean.getJoinInfoParam());
            if (guildFeedDetailInitBean.getBusinessType() == 7 && !TextUtils.isEmpty(guildFeedDetailInitBean.getTroopUin())) {
                intent.putExtra("FEED_TROOP_UIN", guildFeedDetailInitBean.getTroopUin());
            }
            if (guildFeedDetailInitBean.getAttrs().containsKey("sgrp_channel_extension_info") && (guildFeedDetailInitBean.getAttrs().get("sgrp_channel_extension_info") instanceof String)) {
                intent.putExtra("sgrp_channel_extension_info", (String) guildFeedDetailInitBean.getAttrs().get("sgrp_channel_extension_info"));
            }
            if (guildFeedDetailInitBean.getAttrs().containsKey("param_key_search_extension_info") && (guildFeedDetailInitBean.getAttrs().get("param_key_search_extension_info") instanceof String)) {
                intent.putExtra("param_key_search_extension_info", (String) guildFeedDetailInitBean.getAttrs().get("param_key_search_extension_info"));
            }
            if (guildFeedDetailInitBean.getGuildFeedPublishInfo() != null) {
                intent.putExtra("guild_feed_publish_info", guildFeedDetailInitBean.getGuildFeedPublishInfo());
            }
            if (guildFeedDetailInitBean.getTopicId() != 0) {
                intent.putExtra("feed_topic_id", guildFeedDetailInitBean.getTopicId());
            }
            if (stFeed != null) {
                intent.putStringArrayListExtra("comment_ids", GuildFeedCommentUtil.h(stFeed));
                ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).openFeedNativeDetailPage(context, stFeed, guildFeedDetailInitBean, intent);
                return;
            } else {
                intent.putExtra("join_info_param", (Parcelable) guildFeedDetailInitBean.getJoinInfoParam());
                ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).openFeedNativeDetailPage(context, guildFeedDetailInitBean.getGuildId(), guildFeedDetailInitBean.getChannelId(), guildFeedDetailInitBean.getFeedId(), guildFeedDetailInitBean.getBusinessType(), intent, true);
                return;
            }
        }
        k();
        P(context, guildFeedDetailInitBean);
        QLog.d("GuildFeedLauncher", 1, "[launchGuildFeedDetailActivity] detailInitBean=" + guildFeedDetailInitBean);
        Intent m3 = m(guildFeedDetailInitBean, currentTimeMillis, context);
        cx.f(context, m3.getStringExtra("url"), guildFeedDetailInitBean.getGuildId(), guildFeedDetailInitBean.getPosterTinyId(), m3.getExtras());
        QLog.d("GuildFeedLauncher", 1, context + "[launchGuildFeedDetailActivity] finish feedId=" + guildFeedDetailInitBean.getFeedId());
        k.INSTANCE.b(guildFeedDetailInitBean.getGuildId(), "GuildFeedLauncherForWeb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.launcher.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedLauncher.q(GuildFeedDetailInitBean.this, currentTimeMillis);
            }
        }, 16, null, true);
    }

    public static void y(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedLauncher_GalleryActivity")) {
            return;
        }
        QLog.i("GuildFeedLauncher", 1, "[launchGuildFeedGalleryActivity] ");
        GuildFeedGalleryFragment.INSTANCE.c(context, guildFeedGalleryInitBean, null);
    }

    public static void z(Context context, GuildFeedGalleryInitBean guildFeedGalleryInitBean, View view) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedLauncher_GalleryActivity")) {
            return;
        }
        QLog.i("GuildFeedLauncher", 1, "[launchGuildFeedGalleryActivity] ");
        GuildFeedGalleryFragment.INSTANCE.c(context, guildFeedGalleryInitBean, view);
    }
}
