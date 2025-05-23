package com.tencent.biz.qqcircle.launcher;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.activity.QCircleSingleTaskActivity;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.aioshare.QFSAIOFeedShareFragment;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.beans.QCircleAlbumListBean;
import com.tencent.biz.qqcircle.beans.QCircleAvatarLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.beans.QCircleHotEventRankInitBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.beans.QFSAIOFeedShareInitBean;
import com.tencent.biz.qqcircle.beans.QFSIdentityBean;
import com.tencent.biz.qqcircle.beans.QFSPersonalGuildInfoInitBean;
import com.tencent.biz.qqcircle.beans.QFSPrivateSubSettingBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.debug.QCircleDebugFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleDebugPublishTipsFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleDebugServerFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleDebugWinkExportFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleExChangeVideoUrlFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCirclePageScrollSettingFragment;
import com.tencent.biz.qqcircle.debug.mocklbs.QCircleSchemeTestFragment;
import com.tencent.biz.qqcircle.debug.recommend.QFSRecExptEnvFragment;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleAlbumSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleDraftFragment;
import com.tencent.biz.qqcircle.fragments.QCircleMoreSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleNoticeSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.QFSPrivacySettingFragment;
import com.tencent.biz.qqcircle.fragments.QFSPrivacySubSettingFragment;
import com.tencent.biz.qqcircle.fragments.QFSPrivateMessageSettingFragment;
import com.tencent.biz.qqcircle.fragments.QFSQRCodeFragment;
import com.tencent.biz.qqcircle.fragments.QFSSettingFragment;
import com.tencent.biz.qqcircle.half.kuikly.QFSHalfScreenKuiklyFragment;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.QFSAvatarLayerFragment;
import com.tencent.biz.qqcircle.immersive.QFSCommentImageFragment;
import com.tencent.biz.qqcircle.immersive.QFSCommentPicLayerFragment;
import com.tencent.biz.qqcircle.immersive.QFSFeedGalleryPageFragment;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.QFSFullScreenFragment;
import com.tencent.biz.qqcircle.immersive.QFSIdentityAuthenticationFragment;
import com.tencent.biz.qqcircle.immersive.QFSPlayerSettingFragment;
import com.tencent.biz.qqcircle.immersive.QFSShoppingGoodsLayerFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.f;
import com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedSelectFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountOfflineFragment;
import com.tencent.biz.qqcircle.immersive.part.publishprogress.q;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSNickCorporationIntroductionFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalCollectBoxDetailFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalEditFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedBindQQGroupFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalGuildInfoBindingFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalRecentlyWatchedFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalTroopFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.immersive.redpacket.fragment.QFSMakeRedPacketFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.fragment.QFSRedPacketClipFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.fragment.QFSRedPacketPreviewFragment;
import com.tencent.biz.qqcircle.immersive.search.QFSSearchFragment;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.QFSPicDetailFragment;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSHotEventRankListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondPushMoreListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSReportInfoBoardDetailBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QFSWatchLaterListBlock;
import com.tencent.biz.qqcircle.preload.task.i;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.qqcircle.share.bean.QFSShareSelectMemberInitBean;
import com.tencent.biz.qqcircle.share.fragment.QFSShareSelectMemberFragment;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cf;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.qqcircle.utils.t;
import com.tencent.biz.qqcircle.wink.g;
import com.tencent.biz.qqcircle.wink.h;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.HalfScreenBrowserActivity;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.ad.views.AdHalfScreenFragment;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.common.RFWLauncher;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import e40.j;
import java.util.ArrayList;
import java.util.List;
import o50.e;
import org.json.JSONObject;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f91394d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f91395e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f91396f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QCircleLayerBean f91397h;

        a(Activity activity, Intent intent, String str, QCircleLayerBean qCircleLayerBean) {
            this.f91394d = activity;
            this.f91395e = intent;
            this.f91396f = str;
            this.f91397h = qCircleLayerBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(LoadState loadState, Option option, Activity activity, Intent intent, String str, QCircleLayerBean qCircleLayerBean) {
            if (loadState.isFinishSuccess()) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                TransitionAnimUtil.saveCoverDrawable(bitmapDrawable);
                QCircleLauncherUtil.q(activity, intent, false);
                QLog.i("TM-QCircleLauncher", 1, "startTransitionAnimActivity  | path = " + str + " | drawable = " + bitmapDrawable);
                return;
            }
            if (loadState.isFinishError()) {
                QLog.i("TM-QCircleLauncher", 1, "startTransitionAnimActivity download url, fail");
                qCircleLayerBean.setTransitionAnimBean(null);
                QCircleLauncherUtil.q(activity, intent, true);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(final LoadState loadState, final Option option) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final Activity activity = this.f91394d;
            final Intent intent = this.f91395e;
            final String str = this.f91396f;
            final QCircleLayerBean qCircleLayerBean = this.f91397h;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.b(LoadState.this, option, activity, intent, str, qCircleLayerBean);
                }
            });
        }
    }

    public static void A(Context context) {
        if (fb0.a.b("QCircleLauncher_launchDebugWinkExportPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleDebugWinkExportFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void A0(Context context, @Nullable QFSSearchBean qFSSearchBean) {
        if (fb0.a.b("QCircleLauncher_launchSearchResultPage", 500L)) {
            return;
        }
        PreLoader.remove("2018");
        PreLoader.preLoad("2018", new i(qFSSearchBean));
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.a5o);
        intent.putExtra("public_fragment_class", QFSSearchFragment.class.getName());
        if (qFSSearchBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qFSSearchBean);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void B(Context context) {
        if (fb0.a.b("QCircleLauncher_launchDebugWinkNewAlbumPage", 500L)) {
            return;
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).launchWinkDebugNewAlbumActivity(context);
    }

    public static void B0(Context context, QCircleInitBean qCircleInitBean) {
        QLog.d("QCircleLauncher", 1, "launchSecondMessagePushMorePage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSMessageSecondPushMoreListBlock.class.getName());
        p0(context, arrayList, null, qCircleInitBean);
    }

    public static void C(Context context, QCircleInitBean qCircleInitBean, int i3) {
        if (fb0.a.b("QCircleLauncher_launchDraftPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QCircleDraftFragment.class.getName());
        intent.putExtra("key_bundle_draft_count", i3);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void C0(Context context, QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSSettingFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void D(Context context, QCircleInitBean qCircleInitBean, String str) {
        if (qCircleInitBean.getSchemeAttrs().get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE) == null) {
            qCircleInitBean.getSchemeAttrs().put(QCircleScheme.AttrQQPublish.FROM_ENTRANCE, "1");
        }
        Uri.Builder appendQueryParameter = Uri.parse("mqqapi://qcircle/openqqpublish").buildUpon().appendQueryParameter("target", "1001").appendQueryParameter("mediapath", str).appendQueryParameter(QCircleScheme.AttrQQPublish.WAIT_UNTIL_RES_READY, "1").appendQueryParameter("feedid", qCircleInitBean.getFeed().f398449id.get()).appendQueryParameter("uin", qCircleInitBean.getFeed().poster.f398463id.get()).appendQueryParameter("createtime", String.valueOf(qCircleInitBean.getFeed().createTime.get()));
        for (String str2 : qCircleInitBean.getSchemeAttrs().keySet()) {
            appendQueryParameter.appendQueryParameter(str2, qCircleInitBean.getSchemeAttrs().get(str2));
        }
        QCircleServiceImpl.getJumpApi().doJumpAction(context, appendQueryParameter.build().toString());
    }

    public static void D0(Context context, Intent intent, QFSShareSelectMemberInitBean qFSShareSelectMemberInitBean) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSShareSelectMemberFragment.class.getName());
        if (qFSShareSelectMemberInitBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qFSShareSelectMemberInitBean);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void E(Context context, Bundle bundle) {
        if (fb0.a.b("QCircleLauncherlaunchFeedBindQQQGroupPage", 500L)) {
            return;
        }
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(context, 6);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSPersonalFeedBindQQGroupFragment.class.getName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void E0(Context context, QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean) {
        if (qCircleShoppingGoodsInfoBean == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", QFSShoppingGoodsLayerFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleShoppingGoodsInfoBean);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void F(Context context, QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null) {
            return;
        }
        QFSFeedGalleryPageFragment.uh(context, qCircleInitBean);
    }

    public static void F0(Context context, Bundle bundle) {
        if (fb0.a.b("QCircleLauncher_launchTroopEditPage", 500L)) {
            return;
        }
        if (!QCircleBindPhoneNumberHelper.a()) {
            QCircleBindPhoneNumberHelper.b(context, 6);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSPersonalTroopFragment.class.getName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void G(Context context, QCirclePolymerizationBean qCirclePolymerizationBean) {
        String str;
        int polymerizationType;
        if (qCirclePolymerizationBean != null && qCirclePolymerizationBean.getTagInfo() != null && !TextUtils.isEmpty(qCirclePolymerizationBean.getTagInfo().tagName.get())) {
            str = qCirclePolymerizationBean.getTagInfo().tagName.get();
        } else {
            str = "";
        }
        if (qCirclePolymerizationBean == null) {
            polymerizationType = 0;
        } else {
            polymerizationType = qCirclePolymerizationBean.getPolymerizationType();
        }
        QLog.d("QCircleLauncher", 1, "[launchFeedTopicSearchResultPage] tagName = " + str + ", polymerizationType = " + polymerizationType);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (polymerizationType == 7) {
            z0(context, str);
        } else {
            j0(context, qCirclePolymerizationBean);
        }
    }

    public static void G0(Context context, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchSchemeTestPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleExChangeVideoUrlFragment.class.getName());
        if (qCircleInitBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void H(Context context, QFSFlowAggregationInitBean qFSFlowAggregationInitBean) {
        if (fb0.a.b("QCircleLauncherlaunchFlowAggregationPage", 500L)) {
            return;
        }
        PreLoader.remove("2013");
        PreLoader.preLoad("2013", new f(qFSFlowAggregationInitBean));
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qFSFlowAggregationInitBean);
        intent.putExtra("public_fragment_class", QFSFlowAggregationFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void H0(Context context, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchWatchLaterPage", 500L)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSWatchLaterListBlock.class.getName());
        p0(context, arrayList, null, qCircleInitBean);
    }

    public static void I(Context context, QCircleFolderBean qCircleFolderBean) {
        if (fb0.a.b("QCircleLauncher_launchFolderPage", 500L)) {
            return;
        }
        com.tencent.mobileqq.qcircle.api.global.a.c();
        context.startActivity(e(null, context, qCircleFolderBean));
        boolean z16 = context instanceof Activity;
        if (z16 && !TextUtils.isEmpty(qCircleFolderBean.getLastPageScheme())) {
            ((Activity) context).overridePendingTransition(R.anim.f154915tk, R.anim.f154917tm);
        }
        if (z16 && qCircleFolderBean.getBottomMarginPx() != 0.0f) {
            ((Activity) context).overridePendingTransition(R.anim.f155107wd, R.anim.f155108we);
        }
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_FOLDER_LAUNCH);
    }

    private static void I0(QCircleLayerBean qCircleLayerBean, Context context) {
        Activity activity;
        if (o.U0() && qCircleLayerBean != null && qCircleLayerBean.getFeed() != null && qCircleLayerBean.getFeed().video != null) {
            e30.b bVar = new e30.b(qCircleLayerBean.getFeed());
            RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
            RFWPlayerPreRenderBean multiLevel = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), qCircleLayerBean.getRenderType()).setIsJumpTrigger(o.U0()).setPreloadVideo(gb0.b.k(bVar.g().video)).setPreloadOriginData(gb0.b.m(bVar)).setMultiLevel(true);
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            rFWPlayerPreRenderHelper.playerRender(gb0.b.f(multiLevel.setActivity(activity)));
        }
    }

    public static void J(Context context, QCircleFollowUserBean qCircleFollowUserBean) {
        if (fb0.a.b("QCircleLauncher_launchSpecialFollowListPage", 500L)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(qCircleFollowUserBean.getAdapterClassName());
        p0(context, arrayList, null, qCircleFollowUserBean);
    }

    private static void J0(Activity activity, QCircleLayerBean qCircleLayerBean, Intent intent) {
        if (activity == null) {
            QLog.e("TM-QCircleLauncher", 1, "startTransitionAnimActivity  params error: activity = null");
            return;
        }
        if (qCircleLayerBean != null && qCircleLayerBean.getTransitionAnimBean() != null && !TextUtils.isEmpty(qCircleLayerBean.getTransitionAnimBean().getImageUrl()) && qCircleLayerBean.getTransitionAnimBean().getLayoutRect() != null && e.P9()) {
            String imageUrl = qCircleLayerBean.getTransitionAnimBean().getImageUrl();
            Option url = Option.obtain().setUrl(imageUrl);
            QLog.i("TM-QCircleLauncher", 1, "startTransitionAnimActivity, start loadImage,  | url = " + imageUrl + " | layoutRect = " + qCircleLayerBean.getTransitionAnimBean().getLayoutRect());
            if (qCircleLayerBean.getTransitionAnimBean().getCoverDrawable() != null) {
                TransitionAnimUtil.saveCoverDrawable(qCircleLayerBean.getTransitionAnimBean().getCoverDrawable());
                qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(null);
                QCircleLauncherUtil.q(activity, intent, false);
                QLog.d("TM-QCircleLauncher", 1, "use drawable");
                return;
            }
            QCircleFeedPicLoader.g().loadImage(url, new a(activity, intent, imageUrl, qCircleLayerBean));
            return;
        }
        QLog.i("TM-QCircleLauncher", 1, "startTransitionAnimActivity  params error: enableTransitionAnim=" + e.P9());
        if (qCircleLayerBean != null) {
            qCircleLayerBean.setTransitionAnimBean(null);
        }
        QCircleLauncherUtil.q(activity, intent, true);
    }

    private static void K(Context context, String str, @Nullable QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_" + str, 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.addFlags(268435456);
        if (qCircleInitBean != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.d(qCircleInitBean)) {
            intent.addFlags(603979776);
        }
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", str);
        QCircleLauncherUtil.o(context, intent);
        ((IChatApi) QRoute.api(IChatApi.class)).overrideActivityAnimation((Activity) context, true);
    }

    public static void L(Context context, QCircleInitBean qCircleInitBean, int i3) {
        if (fb0.a.b("QCircleLauncher_launchFullScreenPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", QFSFullScreenFragment.class.getName());
        intent.putExtra("orientation_type_flag", i3);
        QCircleLauncherUtil.o(context, intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f155107wd, R.anim.f155108we);
        }
    }

    public static void M(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QCircleLauncher", 1, "url is empty");
            return;
        }
        QLog.d("QCircleLauncher", 1, "launchH5DelegationOrSchema:" + str);
        int urlType = QCirclePluginUtil.getUrlType(str);
        if (urlType == 0) {
            r0(context, str, -1);
        } else if (urlType == 1) {
            QCircleSchemeLauncher.d(context, str);
        }
    }

    public static void N(Context context, QCircleHalfScreenInitBean qCircleHalfScreenInitBean) {
        if (context == null) {
            QLog.e("QCircleLauncher", 1, "[launchHalfScreenH5] context is null");
            return;
        }
        if (qCircleHalfScreenInitBean == null) {
            QLog.e("QCircleLauncher", 1, "[launchHalfScreenH5] initBean is null");
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(28, qCircleHalfScreenInitBean.getFeedId(), true));
        Intent c16 = r30.c.f430661a.c(context, qCircleHalfScreenInitBean);
        if (!(context instanceof Activity)) {
            c16.addFlags(268435456);
        }
        context.startActivity(c16);
    }

    public static void O(Context context, QCircleHalfScreenInitBean qCircleHalfScreenInitBean) {
        if (context == null) {
            QLog.e("QCircleLauncher", 1, "launchHalfScreenKuikly context == null");
            return;
        }
        if (qCircleHalfScreenInitBean == null) {
            QLog.e("QCircleLauncher", 1, "launchHalfScreenKuikly initBean == null");
            return;
        }
        QLog.d("QCircleLauncher", 1, "launchHalfScreenKuikly");
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(39, qCircleHalfScreenInitBean.getFeedId(), true));
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", QFSHalfScreenKuiklyFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleHalfScreenInitBean);
        r30.c.f430661a.b(qCircleHalfScreenInitBean, intent);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void P(Context context, QCircleHotEventRankInitBean qCircleHotEventRankInitBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSHotEventRankListBlock.class.getName());
        p0(context, arrayList, null, qCircleHotEventRankInitBean);
    }

    public static void Q(Context context, QFSIdentityBean qFSIdentityBean) {
        if (fb0.a.b("QCircleLauncher_launchIdentityAuthenticationPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, QCircleTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSIdentityAuthenticationFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qFSIdentityBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void R(Context context, QCircleLikeBean qCircleLikeBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleLikeListBlock.class.getName());
        p0(context, arrayList, null, qCircleLikeBean);
    }

    public static void S(Context context, QCircleInitBean qCircleInitBean, int i3) {
        if (fb0.a.b("QCircleLauncher_launchMakeRedPacketPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QFSMakeRedPacketFragment.class.getName());
        boolean z16 = context instanceof Activity;
        if (z16 && i3 != -1) {
            ((Activity) context).startActivityForResult(intent, i3);
            return;
        }
        if (!z16) {
            intent.setFlags(268435456);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void T(Context context, QCircleInitBean qCircleInitBean) {
        QLog.d("QCircleLauncher", 1, "launchMessageNoticePage");
        com.tencent.biz.qqcircle.immersive.report.a.c("message");
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSMessageListBlock.class.getName());
        p0(context, arrayList, null, qCircleInitBean);
        QCircleHostQzoneHelper.cleanQCirclePush();
    }

    public static void U(Context context) {
        if (fb0.a.b("QCircleLauncher_launchMockLbsPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleMockLbsFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void V(Context context, QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchMoreSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleMoreSettingFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void W(Context context, QCircleInitBean qCircleInitBean) {
        if (!fb0.a.b("QCircleLauncher_launchNewContentDetailPage", 500L) && qCircleInitBean != null) {
            QFSPicDetailFragment.sh(context, qCircleInitBean);
        }
    }

    public static void X(Context context, QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchNoticeSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleNoticeSettingFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void Y(Context context) {
        if (fb0.a.b("QCircleLauncher_launchPageScrollSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCirclePageScrollSettingFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void Z(Context context, QCircleAlbumDetailBean qCircleAlbumDetailBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalCollectionDetailPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleAlbumDetailBean);
        intent.putExtra("public_fragment_class", QCircleLauncherUtil.e());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void a0(Context context, QCircleAlbumListBean qCircleAlbumListBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalCollectionDetailPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleAlbumListBean);
        intent.putExtra("public_fragment_class", QCircleLauncherUtil.f());
        QCircleLauncherUtil.o(context, intent);
    }

    public static boolean b(Context context, String str) {
        boolean jumpKuiklyPageWithWebUrl = ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jumpKuiklyPageWithWebUrl(context, str);
        QLog.d("QCircleLauncher", 1, "[checkJumpKuiklyPage] ", Boolean.valueOf(jumpKuiklyPageWithWebUrl), ", url=", str);
        return jumpKuiklyPageWithWebUrl;
    }

    public static void b0(Context context, QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalCollectBoxDetailPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qFSPersonalCollectBoxDetailBean);
        intent.putExtra("public_fragment_class", QFSPersonalCollectBoxDetailFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static boolean c(Context context, String str, int i3) {
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (uq3.c.u5()) {
            QLog.w("QCircleLauncher", 1, "launchWink, enableSkipPublishNoService");
            if (qfsService == null) {
                QLog.w("QCircleLauncher", 1, "launchWink, invalid service");
                h hVar = h.f93953a;
                hVar.b(context, str, i3, "-100010", false);
                if (q.f88294a.a()) {
                    QCircleToast.i(QCircleToast.f91644d, R.string.f193944ak, 0);
                    hVar.b(context, str, i3, "-10002", true);
                    QLog.w("QCircleLauncher", 1, "launchWink, has running task");
                    return false;
                }
            } else if (uq3.c.g6() && qfsService.hasRunningTask()) {
                QLog.w("QCircleLauncher", 1, "launchWink, has running task");
                if (q.f88294a.a()) {
                    QCircleToast.i(QCircleToast.f91644d, R.string.f193944ak, 0);
                    h.f93953a.b(context, str, i3, "-10002", true);
                    QLog.w("QCircleLauncher", 1, "QFSBoxProgressManager is showing");
                    return false;
                }
                QLog.w("QCircleLauncher", 1, "QFSBoxProgressManager is not showing");
            }
        } else {
            if (qfsService == null) {
                QCircleToast.i(QCircleToast.f91644d, R.string.f196574ho, 0);
                h.f93953a.b(context, str, i3, "-100010", true);
                QLog.w("QCircleLauncher", 1, "launchWink, invalid service");
                return false;
            }
            if (uq3.c.g6() && qfsService.hasRunningTask()) {
                QCircleToast.i(QCircleToast.f91644d, R.string.f193944ak, 0);
                h.f93953a.b(context, str, i3, "-10002", true);
                QLog.w("QCircleLauncher", 1, "launchWink, has running task");
                return false;
            }
        }
        return true;
    }

    public static void c0(Context context, QCircleInitBean qCircleInitBean) {
        K(context, QFSPersonalCoverFeedSelectFragment.class.getName(), qCircleInitBean);
    }

    public static boolean d() {
        return false;
    }

    public static void d0(Context context, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalDetailPage", 500L) || qCircleInitBean == null) {
            return;
        }
        String uin = qCircleInitBean.getUin();
        if (TextUtils.isEmpty(uin) && qCircleInitBean.getFeed() != null) {
            uin = qCircleInitBean.getFeed().poster.get().f398463id.get();
        }
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        int hashCode = context.hashCode();
        if (d() && !qCircleInitBean.isStartNewIntent() && !r.v0(uin)) {
            MutableLiveData<j> l3 = w20.a.j().l(hashCode);
            if (l3.getValue() != null && l3.getValue().f395621b != null && TextUtils.equals(uin, l3.getValue().f395621b.f398463id.get())) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSSlideRightActionEvent(hashCode, qCircleInitBean.getClientFromType()));
                return;
            }
        }
        com.tencent.biz.qqcircle.immersive.report.a.c("mainpage_header");
        com.tencent.biz.qqcircle.immersive.report.a.c("mainpage_body");
        QCircleLauncherUtil.k(qCircleInitBean);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (qCircleInitBean.isMiniPage()) {
            intent.setClass(context, QCircleTransFragmentActivity.class);
            intent.putExtra("public_fragment_class", QCircleLauncherUtil.h());
        } else {
            intent.setClass(context, QCircleFragmentActivity.class);
            intent.putExtra("public_fragment_class", QCircleLauncherUtil.g());
            QFSHodorCollectManager.f84689a.a("qfs_personal_profile_create_cost");
        }
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        QCircleLauncherUtil.p(context, intent, ActivityOptions.makeCustomAnimation(context, R.anim.f154915tk, R.anim.f154917tm).toBundle());
    }

    public static Intent e(Intent intent, Context context, QCircleFolderBean qCircleFolderBean) {
        Intent intent2;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_enable_gps_fetch_default", false)) {
            com.tencent.biz.qqcircle.c.e().g(context, false);
        }
        com.tencent.biz.qqcircle.f.v().N();
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        if (context == null) {
            context = QCircleApplication.APP;
        }
        if (qCircleFolderBean.getAttrs() != null) {
            QCircleLauncherUtil.n(intent2, qCircleFolderBean.getAttrs());
        }
        intent2.addFlags(268435456);
        intent2.putExtra("key_bundle_common_init_bean", qCircleFolderBean);
        if (intent == null) {
            intent2.setClass(context, QCircleFolderActivity.class);
        }
        intent2.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
        return intent2;
    }

    public static void e0(Context context, Bundle bundle) {
        if (fb0.a.b("QCircleLauncher_launchPersonalEditItemPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleSingleTaskActivity.class);
        intent.putExtra("public_fragment_class", QFSNickCorporationIntroductionFragment.class.getName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    @Nullable
    private static String f(Context context, String str) {
        if (cy.n(str)) {
            String k3 = cy.k(str, PeakConstants.QCIRCLE_CLIENT_TRACEID);
            if (TextUtils.isEmpty(k3)) {
                k3 = QCirclePublishQualityReporter.getTraceId();
                str = cy.a(str, k3);
            }
            int i3 = 7;
            try {
                i3 = Integer.parseInt(cy.k(str, IProfileCardConst.KEY_FROM_TYPE));
                str = cy.c(str, i3);
            } catch (Exception unused) {
            }
            ((IQQWinkABTestReportAPI) QRoute.api(IQQWinkABTestReportAPI.class)).reportAllOfWinkPublishExperiment();
            h.f93953a.a(context, k3, i3, str);
            if (!g.f93952a.a(context, k3, i3)) {
                return null;
            }
        }
        return str;
    }

    public static void f0(Context context, QCircleInitBean qCircleInitBean) {
        K(context, QFSPersonalEditFragment.class.getName(), qCircleInitBean);
    }

    public static void g(Context context, String str) {
        j(context, str, false);
    }

    public static void g0(Context context, QFSPersonalGuildInfoInitBean qFSPersonalGuildInfoInitBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalCollectionDetailPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qFSPersonalGuildInfoInitBean);
        intent.putExtra("public_fragment_class", QFSPersonalGuildInfoBindingFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void h(Context context, String str, String str2) {
        i(context, str, str2, false);
    }

    public static void h0(Context context, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchPersonalRecentlyWatched", 500L)) {
            return;
        }
        QCircleLauncherUtil.m(qCircleInitBean);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QFSPersonalRecentlyWatchedFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void i(Context context, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QCircleLauncher", 1, "url is empty");
            return;
        }
        QLog.d("QCircleLauncher", 1, "handleUrl:" + str);
        int urlType = QCirclePluginUtil.getUrlType(str);
        if (urlType == 0) {
            o0(context, str, null, -1);
            return;
        }
        if (urlType == 1) {
            if (str.contains("miniapp")) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str, 2016, null);
                return;
            }
            String f16 = f(context, str);
            if (f16 != null) {
                k(context, f16, str2, z16);
            }
        }
    }

    public static void i0(Context context, QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchPlayerSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSPlayerSettingFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void j(Context context, String str, boolean z16) {
        i(context, str, "", z16);
    }

    public static void j0(Context context, QCirclePolymerizationBean qCirclePolymerizationBean) {
        QLog.d("QCircleLauncher", 4, "[launchPolymerizationPage]");
        if (fb0.a.b("QCircleLauncher_launchPolymerizationPage", 500L)) {
            return;
        }
        PreLoader.remove("2008");
        PreLoader.preLoad("2008", new com.tencent.biz.qqcircle.preload.task.f(qCirclePolymerizationBean));
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCirclePolymerizationBean);
        intent.putExtra("public_fragment_class", QCirclePolymerizationFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    private static void k(final Context context, final String str, String str2, final boolean z16) {
        final Uri parse = Uri.parse(str);
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.a
            @Override // java.lang.Runnable
            public final void run() {
                c.l(str, z16, context, parse);
            }
        };
        if (TextUtils.equals(parse.getQueryParameter("open_qcircle_operate"), "1")) {
            QLog.d("QCircleLauncher", 1, "jumpPage need OpenQcircle url = " + str);
            t.b(str2, runnable);
            return;
        }
        runnable.run();
    }

    public static void k0(Context context, @Nullable QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchPrivacySettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSPrivacySettingFragment.class.getName());
        if (qCircleSettingBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(String str, boolean z16, Context context, Uri uri) {
        QLog.d("QCircleLauncher", 1, "jumpPage OpenQcircle succeed url = " + str);
        if (z16) {
            QCircleSchemeLauncher.d(context, str);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QCircleHostClassHelper.getJumpActivityClass());
        if (Build.VERSION.SDK_INT <= 23) {
            intent.addFlags(268435456);
        }
        intent.setData(uri);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 0);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void l0(Context context, @Nullable QFSPrivateSubSettingBean qFSPrivateSubSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchPrivacySubSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSPrivacySubSettingFragment.class.getName());
        if (qFSPrivateSubSettingBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qFSPrivateSubSettingBean);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void m(Context context, QFSAIOFeedShareInitBean qFSAIOFeedShareInitBean) {
        if (qFSAIOFeedShareInitBean == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", QFSAIOFeedShareFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qFSAIOFeedShareInitBean);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void m0(Context context, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchPrivateMessageSettingPage", 500L)) {
            return;
        }
        if (context == null) {
            QLog.d("QCircleLauncher", 1, "[launchPrivateMessageSettingPage] context is null");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QFSPrivateMessageSettingFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void n(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("halfFragmentClass", AdHalfScreenFragment.class);
        bundle.putInt("webViewBgRes", R.drawable.jsk);
        bundle.putFloat("webViewHeightRatio", 0.5f);
        bundle.putInt("backgroundColorId", R.color.by);
        bundle.putBoolean("isTransparentTitle", true);
        Intent intent = new Intent(context, (Class<?>) HalfScreenBrowserActivity.class);
        String j3 = com.tencent.mobileqq.webview.util.f.f314875a.j(str, 0.5f);
        intent.putExtra("url", j3);
        intent.setData(Uri.parse(j3));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void n0(Context context, QCircleInitBean qCircleInitBean) {
        K(context, QFSPublicAccountOfflineFragment.class.getName(), qCircleInitBean);
    }

    public static void o(Context context, QCircleSettingBean qCircleSettingBean) {
        if (fb0.a.b("QCircleLauncher_launchAlbumSettingPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleAlbumSettingFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleSettingBean);
        QCircleLauncherUtil.o(context, intent);
    }

    public static void o0(Context context, String str, Intent intent, int i3) {
        String str2;
        if (context == null) {
            QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity context == null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty");
            return;
        }
        QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url:" + str);
        if (b(context, str)) {
            return;
        }
        if (!com.tencent.biz.qqcircle.d.b(str)) {
            QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url is Invalid");
            return;
        }
        if (fb0.a.b("launchQCircleHybirdActivity:" + str, 1500L)) {
            QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity is fast double click");
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else {
            str2 = str + ContainerUtils.FIELD_DELIMITER;
        }
        Intent handleQCircleHybirdActivityIntent = QCircleHostLauncher.handleQCircleHybirdActivityIntent(context, str2 + "plugin_version=9017000", intent, i3);
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).startActivityForResult(handleQCircleHybirdActivityIntent, i3);
        } else {
            context.startActivity(handleQCircleHybirdActivityIntent);
        }
    }

    public static void p(Context context, QCircleAvatarLayerBean qCircleAvatarLayerBean) {
        String str;
        if (context == null) {
            QLog.e("QCircleLauncher", 1, "launchAvatarLayerPage context == null");
            return;
        }
        if (qCircleAvatarLayerBean == null) {
            QLog.e("QCircleLauncher", 1, "launchAvatarLayerPage initBean == null");
            return;
        }
        QLog.d("QCircleLauncher", 1, "launchAvatarLayerPage");
        if (qCircleAvatarLayerBean.needPreload()) {
            if (qCircleAvatarLayerBean.getUser().iconDecorate != null) {
                str = qCircleAvatarLayerBean.getUser().iconDecorate.f398453id.get();
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                String a16 = com.tencent.biz.qqcircle.preload.task.d.a(str);
                PreLoader.remove(a16);
                PreLoader.preLoad(a16, new com.tencent.biz.qqcircle.preload.task.d(str));
            }
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", QFSAvatarLayerFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleAvatarLayerBean);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        QCircleLauncherUtil.o(context, intent);
    }

    private static void p0(Context context, ArrayList<String> arrayList, ArrayList arrayList2, QCircleInitBean qCircleInitBean) {
        q0(context, arrayList, null, arrayList2, null, qCircleInitBean);
    }

    public static void q(Context context, QCircleInitBean qCircleInitBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleBlackListBlock.class.getName());
        p0(context, arrayList, null, qCircleInitBean);
    }

    private static void q0(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList arrayList3, Bundle bundle, QCircleInitBean qCircleInitBean) {
        Intent intent = new Intent();
        intent.setClass(context, QCircleFragmentActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("public_fragment_class", PublicListFragment.class.getName());
        intent.putExtra("public_list_block_class_array", arrayList);
        intent.putExtra("public_list_init_data", arrayList3);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.addFlags(268435456);
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            intent.putExtra("base_list_end_block_class", arrayList2);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void r(Context context) {
        if (fb0.a.b("QCircleLauncher_launchChangeMsfServerPage", 500L)) {
            return;
        }
        RFWLauncher.launchChangeMsfServerPage(context);
    }

    public static void r0(Context context, String str, int i3) {
        String str2;
        if (context == null) {
            QLog.i("QCircleLauncher", 1, "launchQQBrowserDelegationActivity context == null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QCircleLauncher", 1, "launchQQBrowserDelegationActivity url isEmpty");
            return;
        }
        QLog.i("QCircleLauncher", 1, "launchQQBrowserDelegationActivity url:" + str);
        if (!com.tencent.biz.qqcircle.d.b(str)) {
            QLog.i("QCircleLauncher", 1, "launchQQBrowserDelegationActivity url is Invalid");
            return;
        }
        if (fb0.a.b("launchQQBrowserDelegationActivity:" + str, 1500L)) {
            QLog.i("QCircleLauncher", 1, "launchQQBrowserDelegationActivity is fast double click");
            return;
        }
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else {
            str2 = str + ContainerUtils.FIELD_DELIMITER;
        }
        Intent qQBrowserDelegationActivityIntent = HostRouteUtils.getQQBrowserDelegationActivityIntent(context, str2 + "plugin_version=9017000");
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).startActivityForResult(qQBrowserDelegationActivityIntent, i3);
        } else {
            context.startActivity(qQBrowserDelegationActivityIntent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (r2 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void s(Context context, QCircleCommentPicLayerBean qCircleCommentPicLayerBean) {
        boolean z16 = true;
        if (context == null) {
            QLog.e("QCircleLauncher", 1, "[launchCommentPicLayer2Page] invalid context");
            return;
        }
        if (qCircleCommentPicLayerBean == null) {
            QLog.e("QCircleLauncher", 1, "[launchCommentPicLayer2Page] invalid initBean");
            return;
        }
        QLog.d("QCircleLauncher", 1, "[launchCommentPicLayer2Page]");
        Intent intent = new Intent();
        boolean o16 = bz.o();
        if (o16) {
            intent.putExtra("orientation_type_flag", 0);
        }
        intent.putExtra("public_fragment_class", QFSCommentImageFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleCommentPicLayerBean);
        intent.addFlags(65536);
        intent.setClass(context, QCircleFragmentActivity.class);
        QFSTransitionAnimBean transitionAnimBean = qCircleCommentPicLayerBean.getTransitionAnimBean();
        if (transitionAnimBean != null && transitionAnimBean.getCoverDrawable() != null) {
            TransitionAnimUtil.saveCoverDrawable(transitionAnimBean.getCoverDrawable());
            transitionAnimBean.setCoverDrawable(null);
        }
        z16 = false;
        if (context instanceof Activity) {
            if (z16) {
                intent.setClass(context, QCircleTransFragmentActivity.class);
            }
            context.startActivity(intent);
            if (z16) {
                ((Activity) context).overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void s0(Context context, @Nullable QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchQRCodeSharePage", 500L)) {
            return;
        }
        if (context == null) {
            QLog.d("QCircleLauncher", 1, "[launchQRCodeSharePage] context is null");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QFSQRCodeFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void t(Context context, QCircleCommentPicLayerBean qCircleCommentPicLayerBean) {
        boolean z16 = true;
        if (context == null) {
            QLog.e("QCircleLauncher", 1, "launchCommentPicLayerPage context == null");
            return;
        }
        if (qCircleCommentPicLayerBean == null) {
            QLog.e("QCircleLauncher", 1, "launchCommentPicLayerPage initBean == null");
            return;
        }
        QLog.d("QCircleLauncher", 1, "launchCommentPicLayerPage");
        Intent intent = new Intent();
        boolean o16 = bz.o();
        boolean z17 = false;
        if (o16) {
            intent.putExtra("orientation_type_flag", 0);
        }
        intent.putExtra("public_fragment_class", QFSCommentPicLayerFragment.class.getName());
        intent.putExtra("key_bundle_common_init_bean", qCircleCommentPicLayerBean);
        intent.addFlags(268435456);
        intent.addFlags(65536);
        QFSTransitionAnimBean transitionAnimBean = qCircleCommentPicLayerBean.getTransitionAnimBean();
        if (transitionAnimBean != null && transitionAnimBean.getCoverDrawable() != null) {
            if (!o16) {
                TransitionAnimUtil.saveCoverDrawable(transitionAnimBean.getCoverDrawable());
            } else {
                z16 = false;
            }
            transitionAnimBean.setCoverDrawable(null);
            z17 = z16;
        }
        if (z17) {
            intent.setClass(context, QCircleTransFragmentActivity.class);
        } else {
            intent.setClass(context, QCircleFragmentActivity.class);
        }
        QCircleLauncherUtil.o(context, intent);
    }

    public static void t0(Context context) {
        if (fb0.a.b("QCircleLauncher_launchRecExptEnvPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSRecExptEnvFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void u(Context context, QCircleLayerBean qCircleLayerBean) {
        if (fb0.a.b("QCircleLauncher_launchContentDetailPage", 500L)) {
            return;
        }
        if (o.A() && qCircleLayerBean != null && qCircleLayerBean.needReleaseOtherPlayer()) {
            QLog.d("QCircleLauncher", 1, "[onTabSelected] release other player");
            SuperPlayerSDKMgr.releaseOtherScened(String.valueOf(126));
        }
        I0(qCircleLayerBean, context);
        Intent intent = new Intent();
        if (qCircleLayerBean != null && qCircleLayerBean.getTagInfo().has()) {
            PreLoader.remove("2005");
            PreLoader.preLoad("2005", new com.tencent.biz.qqcircle.preload.task.g(qCircleLayerBean, true));
        }
        intent.addFlags(268435456);
        intent.setClass(context, QCircleTransFragmentActivity.class);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", QCircleLauncherUtil.d());
        intent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
        intent.putExtra("key_bundle_common_init_bean", qCircleLayerBean);
        if (context instanceof Activity) {
            J0((Activity) context, qCircleLayerBean, intent);
        } else {
            QCircleLauncherUtil.o(context, intent);
        }
    }

    public static void u0(Activity activity, QCircleInitBean qCircleInitBean) {
        if (fb0.a.b("QCircleLauncher_launchRedPacketClipPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, QCircleFragmentActivity.class);
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
        intent.putExtra("public_fragment_class", QFSRedPacketClipFragment.class.getName());
        activity.startActivityForResult(intent, 111);
    }

    public static void v(List<JSONObject> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleBlockCheckListBlock.class.getName());
        p0(QCircleApplication.APP, arrayList, null, null);
    }

    public static void v0(Context context, QFSRedPacketPreviewBean qFSRedPacketPreviewBean) {
        K(context, QFSRedPacketPreviewFragment.class.getName(), qFSRedPacketPreviewBean);
    }

    public static void w(Context context) {
        if (fb0.a.b("QCircleLauncher_launchDebugNeonLightPage", 500L)) {
            return;
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).launchDebugNeonLightActivity(context);
    }

    public static void w0(Context context, ArrayList arrayList, QCircleInitBean qCircleInitBean) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(QFSReportInfoBoardDetailBlock.class.getName());
        p0(context, arrayList2, arrayList, qCircleInitBean);
    }

    public static void x(Context context) {
        if (com.tencent.qcircle.cooperation.config.debug.c.f()) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setClass(context, QCircleFragmentActivity.class);
            intent.putExtra("public_fragment_class", QCircleDebugFragment.class.getName());
            QCircleLauncherUtil.o(context, intent);
        }
    }

    public static void x0(Context context) {
        if (fb0.a.b("QCircleLauncher_launchSchemeTestPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleSchemeTestFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void y(Context context) {
        if (fb0.a.b("QCircleLauncher_launchDebugPublishTipsPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleDebugPublishTipsFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    public static void y0(Context context, @Nullable QFSSearchBean qFSSearchBean) {
        if (fb0.a.b("QCircleLauncher_launchSearchPage", 500L)) {
            return;
        }
        PreLoader.remove("2015");
        PreLoader.preLoad("2015", new com.tencent.biz.qqcircle.preload.task.h(qFSSearchBean));
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.a5o);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QFSSearchFragment.class.getName());
        if (qFSSearchBean != null) {
            intent.putExtra("key_bundle_common_init_bean", qFSSearchBean);
        }
        cf.b();
        QCircleLauncherUtil.o(context, intent);
    }

    public static void z(Context context) {
        if (fb0.a.b("QCircleLauncher_launchDebugUploadServerPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleDebugServerFragment.class.getName());
        QCircleLauncherUtil.o(context, intent);
    }

    private static void z0(Context context, String str) {
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setSearchKeyword("#" + str);
        qFSSearchBean.setQuerySource(24);
        qFSSearchBean.setUserSource(8);
        qFSSearchBean.setPageInteract(true);
        y0(context, qFSSearchBean);
    }
}
