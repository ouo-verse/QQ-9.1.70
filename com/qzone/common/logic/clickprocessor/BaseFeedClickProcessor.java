package com.qzone.common.logic.clickprocessor;

import NS_MOBILE_DROPLIST.nagative_fb_info;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_droplist_option;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.business.plusunion.business.model.AppInfo;
import com.qzone.business.plusunion.ui.QZoneAppIntroActivity;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.FontCacheManager;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.activities.base.ak;
import com.qzone.common.activities.base.al;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.config.service.QZoneConfigService;
import com.qzone.common.event.EventCenter;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.gdt.GdtPreLoadOfflineHelper;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.component.PokeLikeWizard;
import com.qzone.component.PolymorphicLikeWindow;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.ui.component.PokeMsgAnimDirector;
import com.qzone.feed.business.model.ViewFeedPhotoData;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.feed.ui.activity.QZoneMyFeedFragment;
import com.qzone.feed.utils.AdsFeedbackReporter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.homepage.ui.component.b;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.manage.PublicAccountFollowManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedOperation;
import com.qzone.module.feedcomponent.ui.FeedVideoView;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.GuideCommentBar;
import com.qzone.module.feedcomponent.ui.PraiseListView;
import com.qzone.module.feedcomponent.ui.TitleAttachArea;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAd;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.module.feedcomponent.util.CommentSpanData;
import com.qzone.module.vipcomponent.ui.VipBusinessManager;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.personalize.business.QzoneZipDownloadService;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAdvContainerAttach;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellFunnyTreadSpace;
import com.qzone.proxy.feedcomponent.model.CellGoods;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.CellHighFiveInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLive;
import com.qzone.proxy.feedcomponent.model.CellNegativeFeedback;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.CellRecommendList;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.CellViewMore;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.FriendBirthdayGift;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.text.NetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.CustomPraiseView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.widget.ToastUtils;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.widget.BubbleUpFrameAnimView;
import com.qzone.widget.EditPositionBag;
import com.qzone.widget.EmoEditPanel;
import com.qzone.widget.MultiAnimationLayout;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.util.QZoneQQCircleFollowProxy;
import com.qzone.widget.util.b;
import com.qzone.widget.util.c;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.gdt.tangram.statistics.qzone.embedded.AdReporter;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.NewPublicAccountServlet;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandHorizontalTagsView;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlaybackReportInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.OnAnimationListener;
import g6.a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import r6.a;

/* loaded from: classes39.dex */
public class BaseFeedClickProcessor implements com.qzone.proxy.feedcomponent.ui.g, QZoneBaseFeedFragment.g {
    private int C;
    protected CustomPraiseHandler D;
    protected StickerBubbleAnimationView F;
    private IQzoneGiftFullScreenViewController L;
    private PolymorphicLikeWindow M;
    private PolymorphicPraiseEmotionData P;
    private int Q;
    private boolean R;
    private AdFeedbackDialogFragment.Listener T;

    @Deprecated
    QZoneBaseFeedFragment U;
    protected BaseFeedPresenter V;
    b6.b W;
    private String X;
    protected final d5.u Z;

    /* renamed from: a0, reason: collision with root package name */
    private FeedElement f45946a0;

    /* renamed from: d, reason: collision with root package name */
    protected EditPositionBag f45949d;

    /* renamed from: e, reason: collision with root package name */
    protected CustomPraiseView f45951e;

    /* renamed from: f, reason: collision with root package name */
    protected BubbleUpFrameAnimView f45952f;

    /* renamed from: h, reason: collision with root package name */
    protected BubbleUpFrameAnimView f45953h;

    /* renamed from: i, reason: collision with root package name */
    protected BubbleUpFrameAnimView f45954i;

    /* renamed from: m, reason: collision with root package name */
    protected BubbleUpFrameAnimView f45955m;
    String E = "";
    private int G = 0;
    private int[] H = new int[2];
    private int I = 0;
    private BusinessFeedData J = null;
    private ActionSheet K = null;
    private int N = -1;
    private boolean S = false;
    private int Y = -1;

    /* renamed from: b0, reason: collision with root package name */
    private al f45947b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private long f45948c0 = System.currentTimeMillis() - 1000;

    /* renamed from: d0, reason: collision with root package name */
    private long f45950d0 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class CustomPraiseHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<View> f45975a;

        /* renamed from: b, reason: collision with root package name */
        private BusinessFeedData f45976b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<SuperLikeView> f45977c;

        /* renamed from: d, reason: collision with root package name */
        private b.c f45978d;

        /* renamed from: e, reason: collision with root package name */
        private RedPocketHideLoadingRunnable f45979e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes39.dex */
        public class RedPocketHideLoadingRunnable implements Runnable {
            RedPocketHideLoadingRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CustomPraiseHandler.this.b();
            }
        }

        public CustomPraiseHandler(Looper looper) {
            super(looper);
            this.f45979e = new RedPocketHideLoadingRunnable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            try {
                BaseFeedClickProcessor.this.V.E().removeCallbacks(this.f45979e);
                b.c cVar = this.f45978d;
                if (cVar == null || !cVar.isShowing()) {
                    return;
                }
                this.f45978d.dismiss();
            } catch (Exception unused) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c() {
            CustomPraiseData g16;
            boolean z16;
            this.f45976b.getLikeInfo().stateChanged = true;
            View view = this.f45975a.get();
            SuperLikeView superLikeView = this.f45977c.get();
            if (this.f45976b.getUser().customPraiseData != null && BaseFeedClickProcessor.this.N == -1 && this.f45976b.getUser().customPraiseData.itemId != -1) {
                QzoneCustomPraiseService.i().b(BaseFeedClickProcessor.this.T(), superLikeView, this.f45976b.getUser().customPraiseData);
            } else {
                if (this.f45976b.isGDTAdvFeed() && this.f45976b.getCellDecorateInfo() != null && this.f45976b.getCellDecorateInfo().cellCustomPraise != null) {
                    g16 = com.qzone.proxy.feedcomponent.service.a.b().c(this.f45976b.getCellDecorateInfo().cellCustomPraise);
                } else {
                    g16 = QzoneCustomPraiseService.i().g();
                }
                if (view != null && this.f45976b.feedType == 12290) {
                    try {
                        z16 = TextUtils.equals((String) view.getTag(view.getId()), this.f45976b.getFeedCommInfo().feedskey);
                    } catch (Throwable th5) {
                        QZLog.e("FeedClickProcessor", QLog.getStackTraceString(th5));
                    }
                    if (z16) {
                        if (BaseFeedClickProcessor.this.N != -1 && BaseFeedClickProcessor.this.P != null) {
                            superLikeView.setAsyncImage(BaseFeedClickProcessor.this.P.strPraisePic);
                            superLikeView.setSelected(true);
                        } else if (superLikeView != null && g16 != null && !TextUtils.isEmpty(g16.praiseIconUrl)) {
                            superLikeView.setAsyncImage(g16.praiseIconUrl);
                            superLikeView.setSelected(true);
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            if (view != null) {
                BaseFeedClickProcessor baseFeedClickProcessor = BaseFeedClickProcessor.this;
                baseFeedClickProcessor.a1(view, this.f45976b, baseFeedClickProcessor.G, true);
            }
            BaseFeedClickProcessor.this.G = 0;
            BaseFeedClickProcessor.this.N = -1;
            BaseFeedClickProcessor.this.P = null;
            BaseFeedClickProcessor.this.J = null;
        }

        public void d(View view, BusinessFeedData businessFeedData, SuperLikeView superLikeView) {
            this.f45975a = new WeakReference<>(view);
            this.f45976b = businessFeedData;
            this.f45977c = new WeakReference<>(superLikeView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements OnAnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f45982d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MultiAnimationLayout f45983e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CanvasTitleView f45984f;

        a(FrameLayout frameLayout, MultiAnimationLayout multiAnimationLayout, CanvasTitleView canvasTitleView) {
            this.f45982d = frameLayout;
            this.f45983e = multiAnimationLayout;
            this.f45984f = canvasTitleView;
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onAnimationFinished() {
            MultiAnimationLayout multiAnimationLayout;
            w5.b.i("FeedClickProcessor", 2, "MultiAnimationLayout [highFive].showHighFiveAnimation, onAnimationFinished");
            FrameLayout frameLayout = this.f45982d;
            if (frameLayout != null && (multiAnimationLayout = this.f45983e) != null) {
                frameLayout.removeView(multiAnimationLayout);
            } else {
                w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, layout = " + this.f45982d + ", highView = " + this.f45983e);
            }
            MultiAnimationLayout multiAnimationLayout2 = this.f45983e;
            if (multiAnimationLayout2 != null) {
                multiAnimationLayout2.d();
            }
            this.f45984f.startHighFiveCountAnimation();
            QZoneBaseFeedFragment qZoneBaseFeedFragment = BaseFeedClickProcessor.this.U;
            if (qZoneBaseFeedFragment != null) {
                qZoneBaseFeedFragment.tj(null);
            }
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onDrawableLoaded() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ab implements PolymorphicLikeWindow.OnItemSelectListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f45990a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f45991b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f45992c;

        ab(boolean z16, BusinessFeedData businessFeedData, View view) {
            this.f45990a = z16;
            this.f45991b = businessFeedData;
            this.f45992c = view;
        }

        @Override // com.qzone.component.PolymorphicLikeWindow.OnItemSelectListener
        public void onSelect(int i3, int i16, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
            if (this.f45990a) {
                BaseFeedClickProcessor.this.R = true;
            }
            BaseFeedClickProcessor.this.N = i3;
            BaseFeedClickProcessor.this.P = polymorphicPraiseEmotionData;
            BaseFeedClickProcessor.this.Q = i16;
            BaseFeedClickProcessor.this.r0(this.f45991b, this.f45992c);
            if (this.f45990a) {
                LpReportInfo_pf00064.allReport(89, 4);
            } else {
                LpReportInfo_pf00064.allReport(89, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class ad {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f45995a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f45995a = iArr;
            try {
                iArr[FeedElement.FEED_COMMENT_COUNT_AREA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45995a[FeedElement.QZONE_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45995a[FeedElement.SHAREDCARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMM_BOTTOM_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45995a[FeedElement.FRIEND_PLAY_MUSIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45995a[FeedElement.FEED_FOLLOW_GUIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45995a[FeedElement.FEED_BOTTOM_GUIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45995a[FeedElement.FEED_MEMORY_SETTING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f45995a[FeedElement.FEED_MEMORY_CLOSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45995a[FeedElement.FEED_DATE_HEADER_ICON_CLICK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f45995a[FeedElement.FEED_FRIEND_ANNIVERSARY_PIC_AREA_CLICKED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f45995a[FeedElement.FEED_FRIEND_ANNIVERSARY_LEFT_BUTTON_CLICKED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f45995a[FeedElement.FEED_FRIEND_ANNIVERSARY_RIGHT_BUTTON_CLICKED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f45995a[FeedElement.FEED_FUNCTION_GUIDE_BUTTON_CLICKED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f45995a[FeedElement.QZOEN_SECRET_FEED_CONTENT_CLICK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f45995a[FeedElement.QZOEN_SECRET_FEED_BODY_CLICK.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f45995a[FeedElement.QZOEN_SECRET_FEED_MORE_CLICK.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f45995a[FeedElement.LOGO_ATTACH.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_EXPOSE_REPORT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_CARD_CLOSE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f45995a[FeedElement.FEED_SPECIAL_CARE_CARD_CLOSE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f45995a[FeedElement.FEED_FRIEND_BIRTHDAY_CARD_CLOSE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_MORE_FRIEND.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f45995a[FeedElement.FEED_LIMIT_CHAT.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f45995a[FeedElement.FEED_ADD_FRIEND.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_ADD_FRIEND.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_FOLLOW.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_SPECIAL_FOLLOW.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f45995a[FeedElement.BLOG_NEW_STYLE.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f45995a[FeedElement.FEED_RECOMMEND_FRIENDS_GOTO_MAYKNOW_PERSONS_PAGE.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f45995a[FeedElement.ADV_CONTAINER.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f45995a[FeedElement.VIDEO_REMARK.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f45995a[FeedElement.REMARK.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f45995a[FeedElement.LEFT_THUMB_PIC.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f45995a[FeedElement.LEFT_THUMB.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f45995a[FeedElement.MORE_COMMENT.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f45995a[FeedElement.FEED_SIGN_GOTO_DETAIL.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f45995a[FeedElement.SIGN_PACK_OR_UNPACK.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f45995a[FeedElement.PLAYBAR.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f45995a[FeedElement.MUSIC_URL.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f45995a[FeedElement.GIFT_BUTTON.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f45995a[FeedElement.LOOKUP_BUTTON.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f45995a[FeedElement.JOINALBUM_BUTTON.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f45995a[FeedElement.MYCOMM_APP_DOWNLOAD.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f45995a[FeedElement.MYCOMM_APP_OPEN.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f45995a[FeedElement.VIP_ICON.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f45995a[FeedElement.FEED_VIP_SIGNATURE.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f45995a[FeedElement.DOWNLOAD_APP.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f45995a[FeedElement.COMMENT_PIC.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f45995a[FeedElement.PHOTO.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f45995a[FeedElement.PRAISE_AVATAR.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f45995a[FeedElement.PRAISE_BUTTON.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f45995a[FeedElement.CUSTOM_PRAISE_ICON.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f45995a[FeedElement.CONTENT_EXTERNAL_URL_CLICK.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f45995a[FeedElement.URL.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f45995a[FeedElement.COMMENT_GUIDE_ITEM.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f45995a[FeedElement.COMMENT_BUTTON.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f45995a[FeedElement.RAPID_COMMENT_IMMEDIATELY.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f45995a[FeedElement.COMMENT_ITEM.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f45995a[FeedElement.ADV_MICRO_VIDEO.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f45995a[FeedElement.CONTENT.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f45995a[FeedElement.RECOMM_ACTION_LEFT_TEXT.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f45995a[FeedElement.VISIT.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f45995a[FeedElement.INTERACT_TAG.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f45995a[FeedElement.COMMENT_LONG_CLICK.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f45995a[FeedElement.REPLY_LONG_CLICK.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f45995a[FeedElement.COMMENT_PIC_LONG_CLICK.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f45995a[FeedElement.VIDEO.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f45995a[FeedElement.CONTAINER_USER_NICKNAME.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f45995a[FeedElement.CONTAINER_USER_AVATAR.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f45995a[FeedElement.USER_AVATAR.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f45995a[FeedElement.HOT_STAR.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f45995a[FeedElement.FEEDBACK_LEFT_TITLE.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f45995a[FeedElement.USER_DECORATION.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f45995a[FeedElement.PRAISE_LIST.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f45995a[FeedElement.PHONE.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f45995a[FeedElement.FEED_OWNER_NICKNAME.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f45995a[FeedElement.LEFT_THUMB_VIEW_NICKNAME.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f45995a[FeedElement.FRIEND_NICKNAME.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f45995a[FeedElement.ORIGINAL_NICKNAME.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f45995a[FeedElement.USER_NICKNAME.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f45995a[FeedElement.LEFT_FRIEND_NICKNAME.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f45995a[FeedElement.TITLE.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f45995a[FeedElement.ORIGINAL_SUMMARY.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f45995a[FeedElement.SUMMARY.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f45995a[FeedElement.NOTHING.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f45995a[FeedElement.COMMENT_SHOW_ALL.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f45995a[FeedElement.DELFEED.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f45995a[FeedElement.DELETE_BUTTON.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                f45995a[FeedElement.FEED_QCIRCLE_RECOMMEND_CLOSE.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f45995a[FeedElement.DROPDOWN_BUTTON.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f45995a[FeedElement.QZOEN_SECRET_FEED_DROP_MENU_CLICK.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f45995a[FeedElement.SECRET_FEED_DROPDOWN.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f45995a[FeedElement.TAIL.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f45995a[FeedElement.REFER.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f45995a[FeedElement.RECOMM_HEADER.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f45995a[FeedElement.RECOMM_HEADER_BUTTON.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f45995a[FeedElement.RECOMM_CLOSE.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f45995a[FeedElement.ACTION_BUTTON.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f45995a[FeedElement.FORWARD_FOLLOW.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f45995a[FeedElement.LIKE_FOLLOW.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f45995a[FeedElement.RECOMM_FOLLOW_USERS.ordinal()] = 102;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f45995a[FeedElement.RECOMM_FOLLOW.ordinal()] = 103;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f45995a[FeedElement.FOLLOW_CONTAINER_USER.ordinal()] = 104;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f45995a[FeedElement.QZONE_DESCRIPTION.ordinal()] = 105;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f45995a[FeedElement.REPLY_ITEM.ordinal()] = 106;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f45995a[FeedElement.REPLY_BUTTON.ordinal()] = 107;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f45995a[FeedElement.BUY_ACTION.ordinal()] = 108;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f45995a[FeedElement.FEED_REGISTER_ANNIVERSARY_PIC_AREA_CLICKED.ordinal()] = 109;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f45995a[FeedElement.FEED_REGISTER_ANNIVERSARY_OPERATION_AREA_CLICKED.ordinal()] = 110;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f45995a[FeedElement.SHARE.ordinal()] = 111;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f45995a[FeedElement.FORWARD_BUTTON.ordinal()] = 112;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f45995a[FeedElement.FEEDBACK.ordinal()] = 113;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f45995a[FeedElement.HABITED_AREA.ordinal()] = 114;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f45995a[FeedElement.HABITED_AREA_RIGHT.ordinal()] = 115;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f45995a[FeedElement.SEPARATOR.ordinal()] = 116;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f45995a[FeedElement.PERMISSION.ordinal()] = 117;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f45995a[FeedElement.STAR_VIP_ICON.ordinal()] = 118;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f45995a[FeedElement.YELLOW_VIP_ICON.ordinal()] = 119;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                f45995a[FeedElement.FAMOUS_SPACE_ICON.ordinal()] = 120;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                f45995a[FeedElement.CANFOLLOW_ICON.ordinal()] = 121;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                f45995a[FeedElement.LOVER_ZONE_ICON.ordinal()] = 122;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                f45995a[FeedElement.NAME_PLATE.ordinal()] = 123;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO_GESTURE_ACTION.ordinal()] = 124;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                f45995a[FeedElement.GESTURE_AD_VIEW.ordinal()] = 125;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                f45995a[FeedElement.GESTURE_AD_CLICK_VIEW.ordinal()] = 126;
            } catch (NoSuchFieldError unused126) {
            }
            try {
                f45995a[FeedElement.GDT_DANMAKU_AD_COMPONENT.ordinal()] = 127;
            } catch (NoSuchFieldError unused127) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO.ordinal()] = 128;
            } catch (NoSuchFieldError unused128) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO_REPLAY.ordinal()] = 129;
            } catch (NoSuchFieldError unused129) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO_CLICK.ordinal()] = 130;
            } catch (NoSuchFieldError unused130) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO_FLOW.ordinal()] = 131;
            } catch (NoSuchFieldError unused131) {
            }
            try {
                f45995a[FeedElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 132;
            } catch (NoSuchFieldError unused132) {
            }
            try {
                f45995a[FeedElement.FEEDVIDEO_GOTO_VIDEO_TAB.ordinal()] = 133;
            } catch (NoSuchFieldError unused133) {
            }
            try {
                f45995a[FeedElement.SPECIAL_CARE_IN_CONTAINER.ordinal()] = 134;
            } catch (NoSuchFieldError unused134) {
            }
            try {
                f45995a[FeedElement.JUMP_TO_SPECIAL_CARE.ordinal()] = 135;
            } catch (NoSuchFieldError unused135) {
            }
            try {
                f45995a[FeedElement.SPECIAL_CARE_IN_CONTAINER_EXPOSURE.ordinal()] = 136;
            } catch (NoSuchFieldError unused136) {
            }
            try {
                f45995a[FeedElement.FRIEND_BIRTHDAY_GIFT.ordinal()] = 137;
            } catch (NoSuchFieldError unused137) {
            }
            try {
                f45995a[FeedElement.FRIEND_BITTHDAY_GIFT_MORE.ordinal()] = 138;
            } catch (NoSuchFieldError unused138) {
            }
            try {
                f45995a[FeedElement.FRIEND_BIRTHDAY_MORE_FRIENDS.ordinal()] = 139;
            } catch (NoSuchFieldError unused139) {
            }
            try {
                f45995a[FeedElement.FEED_SUGGEST_MORE.ordinal()] = 140;
            } catch (NoSuchFieldError unused140) {
            }
            try {
                f45995a[FeedElement.RECOMMEND_OPEN_CANVAS_CLICK.ordinal()] = 141;
            } catch (NoSuchFieldError unused141) {
            }
            try {
                f45995a[FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR.ordinal()] = 142;
            } catch (NoSuchFieldError unused142) {
            }
            try {
                f45995a[FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR_ACTION_BUTTON.ordinal()] = 143;
            } catch (NoSuchFieldError unused143) {
            }
            try {
                f45995a[FeedElement.FEED_QCIRCLE_RECOMMEND_CONTENT.ordinal()] = 144;
            } catch (NoSuchFieldError unused144) {
            }
            try {
                f45995a[FeedElement.FEED_QCIRCLE_RECOMMEND_TITLE.ordinal()] = 145;
            } catch (NoSuchFieldError unused145) {
            }
            try {
                f45995a[FeedElement.FEED_QCIRCLE_RECOMMEND_AVATAR.ordinal()] = 146;
            } catch (NoSuchFieldError unused146) {
            }
            try {
                f45995a[FeedElement.FEED_QCIRCLE_TAIL_VIEW_CLICK_EVENT_TAG.ordinal()] = 147;
            } catch (NoSuchFieldError unused147) {
            }
            try {
                f45995a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV.ordinal()] = 148;
            } catch (NoSuchFieldError unused148) {
            }
            try {
                f45995a[FeedElement.LBS_INFO.ordinal()] = 149;
            } catch (NoSuchFieldError unused149) {
            }
            try {
                f45995a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO.ordinal()] = 150;
            } catch (NoSuchFieldError unused150) {
            }
            try {
                f45995a[FeedElement.RECOMMAD_ACTION_STAR.ordinal()] = 151;
            } catch (NoSuchFieldError unused151) {
            }
            try {
                f45995a[FeedElement.FEED_QBOSS_PSV_ADV_AREA.ordinal()] = 152;
            } catch (NoSuchFieldError unused152) {
            }
            try {
                f45995a[FeedElement.FEED_QBOSS_PSV_ADV_AREA_ARK.ordinal()] = 153;
            } catch (NoSuchFieldError unused153) {
            }
            try {
                f45995a[FeedElement.FEED_QBOSS_PSV_ADV_DELETE.ordinal()] = 154;
            } catch (NoSuchFieldError unused154) {
            }
            try {
                f45995a[FeedElement.ITEM_LONG_CLICKED.ordinal()] = 155;
            } catch (NoSuchFieldError unused155) {
            }
            try {
                f45995a[FeedElement.FEED_FORWARD_LIST.ordinal()] = 156;
            } catch (NoSuchFieldError unused156) {
            }
            try {
                f45995a[FeedElement.FEED_GALLERY_EVENT_TAG_CLICKED.ordinal()] = 157;
            } catch (NoSuchFieldError unused157) {
            }
            try {
                f45995a[FeedElement.FEED_MYMEDIA_CARD_CLOSE.ordinal()] = 158;
            } catch (NoSuchFieldError unused158) {
            }
            try {
                f45995a[FeedElement.RAPID_FORWARD_BUTTON.ordinal()] = 159;
            } catch (NoSuchFieldError unused159) {
            }
            try {
                f45995a[FeedElement.FEED_QZONE_CARD_ADD_FRIEND.ordinal()] = 160;
            } catch (NoSuchFieldError unused160) {
            }
            try {
                f45995a[FeedElement.FEED_QZONE_CARD_ADDFRIEND_BTN_EXPOSE.ordinal()] = 161;
            } catch (NoSuchFieldError unused161) {
            }
            try {
                f45995a[FeedElement.FEED_QZONE_CARD_FOLLOW_BTN_EXPOSE.ordinal()] = 162;
            } catch (NoSuchFieldError unused162) {
            }
            try {
                f45995a[FeedElement.MY_EVENT_TAG_LIST.ordinal()] = 163;
            } catch (NoSuchFieldError unused163) {
            }
            try {
                f45995a[FeedElement.FEED_NEGATIVE_FEEDBACK_DEL_BUTTON_CLICK.ordinal()] = 164;
            } catch (NoSuchFieldError unused164) {
            }
            try {
                f45995a[FeedElement.FEED_NEGATIVE_FEEDBACK_SUBMIT_BUTTON_CLICK.ordinal()] = 165;
            } catch (NoSuchFieldError unused165) {
            }
            try {
                f45995a[FeedElement.HIGH_FIVE_BUTTON.ordinal()] = 166;
            } catch (NoSuchFieldError unused166) {
            }
            try {
                f45995a[FeedElement.RECOMMEND_BUTTON.ordinal()] = 167;
            } catch (NoSuchFieldError unused167) {
            }
            try {
                f45995a[FeedElement.COMMENT_PRAISE_BUTTON.ordinal()] = 168;
            } catch (NoSuchFieldError unused168) {
            }
            try {
                f45995a[FeedElement.REPLY_PRAISE_BUTTON.ordinal()] = 169;
            } catch (NoSuchFieldError unused169) {
            }
            try {
                f45995a[FeedElement.POLYMORPHIC_LIKE.ordinal()] = 170;
            } catch (NoSuchFieldError unused170) {
            }
            try {
                f45995a[FeedElement.AUTO_SHOW_POLYMORPHIC_LIKE.ordinal()] = 171;
            } catch (NoSuchFieldError unused171) {
            }
            try {
                f45995a[FeedElement.MAKE_DYNAMIC.ordinal()] = 172;
            } catch (NoSuchFieldError unused172) {
            }
            try {
                f45995a[FeedElement.PUBLISH_QCIRCLE.ordinal()] = 173;
            } catch (NoSuchFieldError unused173) {
            }
            try {
                f45995a[FeedElement.FEED_GIFT.ordinal()] = 174;
            } catch (NoSuchFieldError unused174) {
            }
            try {
                f45995a[FeedElement.FEED_DRAWER.ordinal()] = 175;
            } catch (NoSuchFieldError unused175) {
            }
            try {
                f45995a[FeedElement.OPEN_MORE_COMMENT.ordinal()] = 176;
            } catch (NoSuchFieldError unused176) {
            }
            try {
                f45995a[FeedElement.SECRET_LIKE.ordinal()] = 177;
            } catch (NoSuchFieldError unused177) {
            }
            try {
                f45995a[FeedElement.SECRET_DISS.ordinal()] = 178;
            } catch (NoSuchFieldError unused178) {
            }
            try {
                f45995a[FeedElement.TITLE_UPPER_BANNER_CLOSE_BUTTON.ordinal()] = 179;
            } catch (NoSuchFieldError unused179) {
            }
            try {
                f45995a[FeedElement.VISIT_RETURN.ordinal()] = 180;
            } catch (NoSuchFieldError unused180) {
            }
            try {
                f45995a[FeedElement.BOOK.ordinal()] = 181;
            } catch (NoSuchFieldError unused181) {
            }
            try {
                f45995a[FeedElement.GAME_SHARE_HOT_AREA.ordinal()] = 182;
            } catch (NoSuchFieldError unused182) {
            }
            try {
                f45995a[FeedElement.TO_NUAN_PROFILE.ordinal()] = 183;
            } catch (NoSuchFieldError unused183) {
            }
            try {
                f45995a[FeedElement.CANVAS_UI_REPORT_TTT_CLICK.ordinal()] = 184;
            } catch (NoSuchFieldError unused184) {
            }
            try {
                f45995a[FeedElement.FEEDVIDEO_PLAY_ADV_TIME_EXPOSE.ordinal()] = 185;
            } catch (NoSuchFieldError unused185) {
            }
            try {
                f45995a[FeedElement.MESSAGE_ITEM.ordinal()] = 186;
            } catch (NoSuchFieldError unused186) {
            }
            try {
                f45995a[FeedElement.PUBLIC_ACCOUNT_FOLLOW.ordinal()] = 187;
            } catch (NoSuchFieldError unused187) {
            }
            try {
                f45995a[FeedElement.PUBLIC_ACCOUNT_UNFOLLOW.ordinal()] = 188;
            } catch (NoSuchFieldError unused188) {
            }
            try {
                f45995a[FeedElement.PUBLIC_ACCOUNT_NAVIGATE_HOME.ordinal()] = 189;
            } catch (NoSuchFieldError unused189) {
            }
            try {
                f45995a[FeedElement.PUBLIC_ACCOUNT_NAVIGATE_DETAIL.ordinal()] = 190;
            } catch (NoSuchFieldError unused190) {
            }
            try {
                f45995a[FeedElement.COMMENT_POKE_COMBO.ordinal()] = 191;
            } catch (NoSuchFieldError unused191) {
            }
            try {
                f45995a[FeedElement.REFRESH_PAGE.ordinal()] = 192;
            } catch (NoSuchFieldError unused192) {
            }
            try {
                f45995a[FeedElement.OPEN_MINI_AIO.ordinal()] = 193;
            } catch (NoSuchFieldError unused193) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ae implements BubbleUpFrameAnimView.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f45996a;

        ae(View view) {
            this.f45996a = view;
        }

        @Override // com.qzone.widget.BubbleUpFrameAnimView.e
        public void a(BubbleUpFrameAnimView bubbleUpFrameAnimView) {
            this.f45996a.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class af implements c.InterfaceC0506c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f45998d;

        af(View view) {
            this.f45998d = view;
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            this.f45998d.setVisibility(0);
            this.f45998d.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ag implements al.a {
        ag() {
        }

        @Override // com.qzone.common.activities.base.al.a
        public void a(int i3, int i16) {
            Log.i("FeedClickProcessor", "onScrollDistanceChanged: " + i3 + " / " + i16);
            CustomPraiseView customPraiseView = BaseFeedClickProcessor.this.f45951e;
            if (customPraiseView != null) {
                customPraiseView.setScrollBy(0, i3);
            }
            BubbleUpFrameAnimView bubbleUpFrameAnimView = BaseFeedClickProcessor.this.f45953h;
            if (bubbleUpFrameAnimView != null) {
                bubbleUpFrameAnimView.scroll(0, i3);
            }
            BubbleUpFrameAnimView bubbleUpFrameAnimView2 = BaseFeedClickProcessor.this.f45954i;
            if (bubbleUpFrameAnimView2 != null) {
                bubbleUpFrameAnimView2.scroll(0, i3);
            }
            BubbleUpFrameAnimView bubbleUpFrameAnimView3 = BaseFeedClickProcessor.this.f45955m;
            if (bubbleUpFrameAnimView3 != null) {
                bubbleUpFrameAnimView3.scroll(0, i3);
            }
            BubbleUpFrameAnimView bubbleUpFrameAnimView4 = BaseFeedClickProcessor.this.f45952f;
            if (bubbleUpFrameAnimView4 != null) {
                bubbleUpFrameAnimView4.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ah implements al.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MultiAnimationLayout f46001a;

        ah(MultiAnimationLayout multiAnimationLayout) {
            this.f46001a = multiAnimationLayout;
        }

        @Override // com.qzone.common.activities.base.al.a
        public void a(int i3, int i16) {
            MultiAnimationLayout multiAnimationLayout = this.f46001a;
            if (multiAnimationLayout != null && multiAnimationLayout.getLayoutParams() != null) {
                if (i3 == 0 && i16 == 0) {
                    this.f46001a.setAlpha(0.0f);
                    w5.b.a("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, delta = " + i3 + ", total = " + i16);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f46001a.getLayoutParams();
                layoutParams.topMargin += i3;
                this.f46001a.setLayoutParams(layoutParams);
                this.f46001a.requestLayout();
                return;
            }
            w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, highFiveView = " + this.f46001a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements BubbleUpFrameAnimView.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f46008a;

        c(View view) {
            this.f46008a = view;
        }

        @Override // com.qzone.widget.BubbleUpFrameAnimView.e
        public void a(BubbleUpFrameAnimView bubbleUpFrameAnimView) {
            this.f46008a.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements c.InterfaceC0506c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f46010d;

        d(View view) {
            this.f46010d = view;
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            this.f46010d.setVisibility(0);
            BaseFeedClickProcessor.this.f45954i.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements BubbleUpFrameAnimView.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f46012a;

        e(View view) {
            this.f46012a = view;
        }

        @Override // com.qzone.widget.BubbleUpFrameAnimView.e
        public void a(BubbleUpFrameAnimView bubbleUpFrameAnimView) {
            this.f46012a.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements c.InterfaceC0506c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f46014d;

        f(View view) {
            this.f46014d = view;
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            this.f46014d.setVisibility(0);
            BaseFeedClickProcessor.this.f45955m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46016d;

        g(CellTextView.OnTextOperater onTextOperater) {
            this.f46016d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46016d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46016d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements b.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46021a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46022b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ClickedComment f46023c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Reply f46024d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f46025e;

        i(BusinessFeedData businessFeedData, Comment comment, ClickedComment clickedComment, Reply reply, int i3) {
            this.f46021a = businessFeedData;
            this.f46022b = comment;
            this.f46023c = clickedComment;
            this.f46024d = reply;
            this.f46025e = i3;
        }

        @Override // com.qzone.widget.util.b.g
        public void a() {
            ClickReport.q("431", "10", "1", true);
            if (BaseFeedClickProcessor.this.V != null) {
                String str = this.f46021a.getFeedCommInfo().ugckey;
                if (!TextUtils.isEmpty(this.f46022b.commentid)) {
                    str = str + "_" + this.f46022b.commentid;
                }
                String str2 = str;
                this.f46023c.setReply(null);
                Map<String, String> X = BaseFeedClickProcessor.this.X(this.f46021a, this.f46024d.content);
                Comment comment = this.f46022b;
                if (comment.pokeLikeCount > 0 && !TextUtils.isEmpty(comment.pokeLikeEmotion) && BaseFeedClickProcessor.this.J != null) {
                    X.put("cur_likekey", BaseFeedClickProcessor.this.J.getFeedCommInfo().curlikekey);
                    X.put("cmt_poke_emoji", this.f46022b.pokeLikeEmotion);
                    X.put("cmt_poke_count", String.valueOf(this.f46022b.pokeLikeCount));
                }
                BaseFeedClickProcessor.this.V.v(this.f46024d.content, this.f46025e, this.f46023c, "", str2, false, false, null, null, this.f46021a.getFeedCommInfo().feedskey, X);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements b.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comment f46027a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46028b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f46029c;

        j(Comment comment, BusinessFeedData businessFeedData, int i3) {
            this.f46027a = comment;
            this.f46028b = businessFeedData;
            this.f46029c = i3;
        }

        @Override // com.qzone.widget.util.b.g
        public void a() {
            ClickReport.q("431", "10", "1", true);
            if (BaseFeedClickProcessor.this.V != null) {
                if (this.f46027a.comment.endsWith("[em]e10011[/em]")) {
                    Comment comment = this.f46027a;
                    String str = comment.comment;
                    comment.comment = str.substring(0, str.lastIndexOf("[em]e10011[/em]"));
                }
                Map<String, String> X = BaseFeedClickProcessor.this.X(this.f46028b, this.f46027a.comment);
                if (this.f46028b != null) {
                    Comment comment2 = this.f46027a;
                    if (comment2.pokeLikeCount > 0 && !TextUtils.isEmpty(comment2.pokeLikeEmotion)) {
                        X.put("cur_likekey", this.f46028b.getFeedCommInfo().curlikekey);
                        X.put("cmt_poke_emoji", this.f46027a.pokeLikeEmotion);
                        X.put("cmt_poke_count", String.valueOf(this.f46027a.pokeLikeCount));
                    }
                }
                BusinessFeedData businessFeedData = this.f46028b;
                if (businessFeedData != null) {
                    BaseFeedClickProcessor.this.V.v(this.f46027a.comment, this.f46029c, null, "", businessFeedData.getFeedCommInfo().ugckey, false, false, null, null, this.f46028b.getFeedCommInfo().feedskey, X);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements PokeMsgAnimDirector.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f46031a;

        k(long j3) {
            this.f46031a = j3;
        }

        @Override // com.qzone.detail.ui.component.PokeMsgAnimDirector.d
        public void a() {
            ho.i.z().r(BaseFeedClickProcessor.this.T(), this.f46031a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class l implements b.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46033a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46034b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f46035c;

        l(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f46033a = businessFeedData;
            this.f46034b = comment;
            this.f46035c = reply;
        }

        @Override // com.qzone.widget.util.b.f
        public void a() {
            QZoneFeedUtil.v(BaseFeedClickProcessor.this.T(), this.f46033a, this.f46034b, this.f46035c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements b.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46038b;

        m(BusinessFeedData businessFeedData, Comment comment) {
            this.f46037a = businessFeedData;
            this.f46038b = comment;
        }

        @Override // com.qzone.widget.util.b.f
        public void a() {
            QZoneFeedUtil.v(BaseFeedClickProcessor.this.T(), this.f46037a, this.f46038b, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements b.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46041b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f46042c;

        n(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f46040a = businessFeedData;
            this.f46041b = comment;
            this.f46042c = reply;
        }

        @Override // com.qzone.widget.util.b.f
        public void a() {
            QZoneFeedUtil.v(BaseFeedClickProcessor.this.T(), this.f46040a, this.f46041b, this.f46042c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class o implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClickedComment f46044a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f46045b;

        o(ClickedComment clickedComment, int i3) {
            this.f46044a = clickedComment;
            this.f46045b = i3;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            BaseFeedClickProcessor baseFeedClickProcessor = BaseFeedClickProcessor.this;
            baseFeedClickProcessor.Y1(this.f46044a, this.f46045b, baseFeedClickProcessor.U instanceof QZoneMyFeedFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClickedComment f46047a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f46048b;

        p(ClickedComment clickedComment, int i3) {
            this.f46047a = clickedComment;
            this.f46048b = i3;
        }

        @Override // com.qzone.widget.util.b.e
        public void a() {
            BaseFeedClickProcessor baseFeedClickProcessor = BaseFeedClickProcessor.this;
            baseFeedClickProcessor.Y1(this.f46047a, this.f46048b, baseFeedClickProcessor.U instanceof QZoneMyFeedFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements b.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46050a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f46052c;

        q(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f46050a = businessFeedData;
            this.f46051b = comment;
            this.f46052c = reply;
        }

        @Override // com.qzone.widget.util.b.f
        public void a() {
            QZoneFeedUtil.v(BaseFeedClickProcessor.this.T(), this.f46050a, this.f46051b, this.f46052c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class t implements PokeMsgAnimDirector.OnStopListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f46059a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f46060b;

        t(FrameLayout frameLayout, View view) {
            this.f46059a = frameLayout;
            this.f46060b = view;
        }

        @Override // com.qzone.detail.ui.component.PokeMsgAnimDirector.OnStopListener
        public void onStop() {
            this.f46059a.removeView(this.f46060b);
            BaseFeedClickProcessor.this.S = false;
        }
    }

    /* loaded from: classes39.dex */
    class w implements XListView.MotionEventInterceptor {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZonePullToRefreshListView f46068d;

        w(QZonePullToRefreshListView qZonePullToRefreshListView) {
            this.f46068d = qZonePullToRefreshListView;
        }

        @Override // com.tencent.widget.XListView.MotionEventInterceptor
        public boolean intercept(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action != 1) {
                return action == 2;
            }
            this.f46068d.setMotionEventInterceptor(null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class y implements b.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46071a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46072b;

        y(BusinessFeedData businessFeedData, Comment comment) {
            this.f46071a = businessFeedData;
            this.f46072b = comment;
        }

        @Override // com.qzone.widget.util.b.h
        public void a() {
            BaseFeedClickProcessor.this.M0(this.f46071a, this.f46072b);
            Comment comment = this.f46072b;
            if (comment != null) {
                if (!comment.isliked) {
                    LpReportInfo_pf00064.allReport(720, 2, 2);
                } else {
                    LpReportInfo_pf00064.allReport(720, 2, 1);
                }
            }
        }

        @Override // com.qzone.widget.util.b.h
        public boolean b() {
            return this.f46072b.isliked;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class z implements b.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46074a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comment f46075b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Reply f46076c;

        z(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
            this.f46074a = businessFeedData;
            this.f46075b = comment;
            this.f46076c = reply;
        }

        @Override // com.qzone.widget.util.b.h
        public void a() {
            BaseFeedClickProcessor.this.v1(this.f46074a, this.f46075b, this.f46076c);
            Reply reply = this.f46076c;
            if (reply != null) {
                LpReportInfo_pf00064.allReport(210, 2, reply.isliked ? 2 : 1);
            }
        }

        @Override // com.qzone.widget.util.b.h
        public boolean b() {
            return this.f46076c.isliked;
        }
    }

    public BaseFeedClickProcessor(BaseFeedPresenter baseFeedPresenter, b6.b bVar) {
        ViewGroup viewGroup = null;
        this.V = baseFeedPresenter;
        this.W = bVar;
        QZoneBaseFeedFragment K = baseFeedPresenter.K();
        this.U = K;
        this.Z = K.getContainerInf();
        this.U.li(this);
        if (this.U instanceof Fragment) {
            Activity T = T();
            if (T != null) {
                viewGroup = (FrameLayout) T.findViewById(R.id.content);
            }
        } else {
            viewGroup = (ViewGroup) Q(R.id.content);
        }
        if (viewGroup != null) {
            if (QZoneApiProxy.isInQZoneEnvironment()) {
                if (QQTheme.isNowThemeIsNightForQzone()) {
                    this.f45953h = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.f169023c13, viewGroup, false);
                    this.f45954i = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.bwz, viewGroup, false);
                    this.f45955m = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.f169011bx0, viewGroup, false);
                    return;
                } else {
                    this.f45953h = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.bnt, viewGroup, false);
                    this.f45954i = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.blj, viewGroup, false);
                    this.f45955m = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.bll, viewGroup, false);
                    return;
                }
            }
            this.f45953h = new BubbleUpFrameAnimView(Z());
            this.f45954i = new BubbleUpFrameAnimView(Z());
            this.f45955m = new BubbleUpFrameAnimView(Z());
        }
    }

    @Deprecated
    private boolean A() {
        return NetworkState.isNetSupport();
    }

    private void D() {
        if (this.f45947b0 != null) {
            return;
        }
        this.f45947b0 = new al(new ag());
    }

    private boolean E(FeedElement feedElement, BusinessFeedData businessFeedData, View view) {
        User user;
        if (feedElement == FeedElement.AUTO_VIDEO_CLICK) {
            return true;
        }
        if (feedElement == FeedElement.USER_DECORATION || feedElement == FeedElement.ORIGINAL_NICKNAME || feedElement == FeedElement.USER_NICKNAME || feedElement == FeedElement.USER_AVATAR || feedElement == FeedElement.YELLOW_VIP_ICON || feedElement == FeedElement.STAR_VIP_ICON) {
            if (businessFeedData != null) {
                CellUserInfo cellUserInfo = businessFeedData.getCellUserInfo();
                if (cellUserInfo != null && (user = cellUserInfo.user) != null && !TextUtils.isEmpty(user.actionurl)) {
                    yo.d.d(cellUserInfo.user.actionurl, Z(), null);
                    N1(true);
                } else {
                    QZLog.w("FeedClickProcessor", 1, "dealWithQCircleFollowFamousEvent cellUserInfo.user.actionurl is null");
                }
            } else {
                QZLog.w("FeedClickProcessor", 1, "dealWithQCircleFollowFamousEvent businessFeedData is null");
            }
            return true;
        }
        if (feedElement == FeedElement.DROPDOWN_BUTTON) {
            return false;
        }
        o0(feedElement);
        if (businessFeedData != null) {
            VideoInfo videoInfo = businessFeedData.getVideoInfo();
            if (videoInfo != null && videoInfo.actionUrl != null) {
                String W1 = W1(view, videoInfo);
                videoInfo.actionUrl = W1;
                yo.d.d(W1, Z(), null);
                L1(true);
            } else {
                QZLog.w("FeedClickProcessor", 1, "dealWithQCircleFollowFamousEvent videoInfo is null");
            }
        } else {
            QZLog.w("FeedClickProcessor", 1, "dealWithQCircleFollowFamousEvent businessFeedData is null");
        }
        return true;
    }

    private void E1(long j3, String str, String str2, int i3) {
        Activity T;
        FrameLayout frameLayout;
        if (this.S || (T = T()) == null) {
            return;
        }
        try {
            frameLayout = (FrameLayout) T.findViewById(R.id.content);
        } catch (Throwable th5) {
            QZLog.w("FeedClickProcessor", "initPolyLikeAnimView: ", th5);
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        View inflate = View.inflate(T, com.tencent.mobileqq.R.layout.akz, null);
        frameLayout.addView(inflate);
        PokeMsgAnimDirector pokeMsgAnimDirector = new PokeMsgAnimDirector(inflate);
        pokeMsgAnimDirector.showAnim(j3, str, str2, i3);
        pokeMsgAnimDirector.setOnJumpMainPageListener(new k(j3));
        pokeMsgAnimDirector.setOnStopListener(new t(frameLayout, inflate));
    }

    public static boolean F1() {
        return ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_POLY_PRAISE, QzoneConfig.SECONDARY_POLY_MEM_LEVEL, 1), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_POLY_PRAISE, QzoneConfig.SECONDARY_POLY_MEM_LEVEL, 0));
    }

    private void H0(View view, BusinessFeedData businessFeedData, Object obj, int i3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064("305", "5");
        lpReportInfo_pf00064.reserves = 1;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
        j1(view, businessFeedData, obj, i3);
    }

    private void I0(View view, int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getGoods() != null) {
            if (!businessFeedData.getLikeInfo().isLiked && businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds()) {
                b1(view, businessFeedData, 0);
            }
            String str = businessFeedData.getGoods().btnUrl;
            if (businessFeedData.getGoods().btnActionType == 2) {
                this.W.la(str, null, null);
                return;
            }
            if (businessFeedData.getGoods().btnActionType != 25 && businessFeedData.getGoods().btnActionType != 26) {
                if (businessFeedData.getGoods().btnActionType == 2) {
                    if (TextUtils.isEmpty(businessFeedData.getGoods().btnUrl)) {
                        return;
                    }
                    this.W.la(businessFeedData.getGoods().btnUrl, null, null);
                    return;
                } else {
                    if (businessFeedData.getGoods().btnActionType == 5) {
                        this.W.mh(businessFeedData.getUser().uin, 0, R(businessFeedData, i3));
                        return;
                    }
                    if (businessFeedData.getGoods().btnActionType == 22) {
                        if (TextUtils.isEmpty(businessFeedData.getGoods().btnUrl)) {
                            return;
                        }
                        this.W.xb(businessFeedData.getGoods().btnUrl);
                        return;
                    } else if (businessFeedData.getGoods().btnActionType == 21) {
                        this.V.q(null, businessFeedData, i3, false, false, false);
                        return;
                    } else {
                        if (businessFeedData.getGoods().btnActionType == 23) {
                            this.W.la(businessFeedData.getGoods().btnUrl, null, null);
                            return;
                        }
                        return;
                    }
                }
            }
            CellGoods goods = businessFeedData.getGoods();
            if (goods != null) {
                if (goods.isVipType()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (goods.getVipType() == 1) {
                            jSONObject.put("serviceCode", VipBusinessManager.COMM_VIP_SERVICE_CODE);
                            jSONObject.put("serviceName", com.qzone.util.l.a(com.tencent.mobileqq.R.string.jy5));
                        } else if (goods.getVipType() == 2) {
                            jSONObject.put("serviceCode", "XXZXYY");
                            jSONObject.put("serviceName", com.qzone.util.l.a(com.tencent.mobileqq.R.string.f171638jy2));
                        } else {
                            jSONObject.put("serviceCode", "");
                            jSONObject.put("serviceName", "");
                        }
                        int i16 = goods.openMonth;
                        if (i16 > 0) {
                            jSONObject.put("openMonth", i16);
                            jSONObject.put("isCanChange", goods.canChange == 1);
                        }
                        if (TextUtils.isEmpty(goods.payOfferId)) {
                            ToastUtil.r("payOfferId is null");
                            return;
                        }
                        if (goods.getVipType() == 1) {
                            jSONObject.put("aid", "feeds");
                            jSONObject.put(AdParam.PF, goods.f50230pf);
                        } else {
                            jSONObject.put("aid", goods.f50230pf);
                        }
                        jSONObject.put("offerId", goods.payOfferId);
                        jSONObject.put("userId", LoginData.getInstance().getUinString());
                        jSONObject.put("remark", goods.payRemark);
                        this.W.Wb(jSONObject.toString(), 4, "\u8d2d\u4e70feed");
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        QZLog.e("FeedClickProcessor", "buygoods fail: " + e16);
                        return;
                    }
                }
                if (goods.goodsType == 4) {
                    final String str2 = goods.goodId;
                    final int i17 = goods.buyCount;
                    final String str3 = goods.payOfferId;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String encode = URLEncoder.encode(LoginData.getInstance().getSid(), "UTF-8");
                                HttpResponse d16 = to.e.d(BaseApplication.getContext(), yo.f.j(yo.f.j(yo.f.j(yo.f.j(yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BUY_FEED_URL, "https://playzone2.qzone.qq.com/fcg-bin/fcg_get_orders_midas?t=0.032533612567931414&g_tk=5381&callback=order_Callback&userid={userid}&userkey={sid}&type=uin&appid=1450001342&zoneid=1&iteminfo={iteminfo}&pfkey=pfkey&login_type=2&login_key={login_key}&_=1411374419460&true=order_Callback"), "{userid}", LoginData.getInstance().getUinString()), "{login_key}", encode), "{sid}", encode), "{userkey}", encode), "{iteminfo}", str2 + "*" + i17));
                                if (d16.getStatusLine().getStatusCode() == 200) {
                                    String entityUtils = EntityUtils.toString(d16.getEntity());
                                    String string = new JSONObject(entityUtils.substring(entityUtils.indexOf("{"), entityUtils.lastIndexOf(")"))).getJSONObject("data").getString("url_params");
                                    final JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("offerId", str3);
                                    jSONObject2.put("userId", LoginData.getInstance().getUinString());
                                    jSONObject2.put("tokenUrl", string);
                                    jSONObject2.put("zoneId", 1);
                                    BaseFeedClickProcessor.this.V.E().post(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.7.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Bundle bundle = new Bundle();
                                            bundle.putString(ark.ARKMETADATA_JSON, jSONObject2.toString());
                                            bundle.putInt("pay_requestcode", 7);
                                            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(BaseApplication.getContext());
                                            payBridgeIntent.putExtras(bundle);
                                            BaseFeedClickProcessor.this.i2(payBridgeIntent);
                                        }
                                    });
                                } else {
                                    QZLog.e("buygood", "faliure");
                                }
                            } catch (Exception e17) {
                                QZLog.e("buygood", "faliure: " + e17);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        QZLog.w("FeedClickProcessor", "buyButton click , data is null");
    }

    private void J1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 8), false, false);
    }

    private void K1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 6), false, false);
    }

    private void L1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 4), false, false);
        QLog.d("FeedClickProcessor", 1, "reportFriendLikeEnterVideo: isQCircleVideo: " + z16);
    }

    private void M1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 7), false, false);
    }

    private void N1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 3), false, false);
    }

    private void O(String str, BusinessFeedData businessFeedData) {
        this.W.Q7(str, businessFeedData);
    }

    private void O1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 5), false, false);
    }

    private void P1(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 4), false, false);
        QLog.d("FeedClickProcessor", 1, "praiseList click isQCircleVideo: " + z16);
    }

    private String R(BusinessFeedData businessFeedData, int i3) {
        return null;
    }

    @Deprecated
    private Context U() {
        return T().getApplicationContext();
    }

    private static String W(PhotoParam photoParam, BusinessFeedData businessFeedData) {
        if (!TextUtils.isEmpty(photoParam.albumid)) {
            return photoParam.albumid;
        }
        if (businessFeedData != null && businessFeedData.getIdInfo() != null) {
            return businessFeedData.getIdInfo().cellId;
        }
        if (businessFeedData != null && businessFeedData.getIdInfo() != null) {
            return businessFeedData.getIdInfo().cellId;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> X(BusinessFeedData businessFeedData, String str) {
        FontCacheManager.CommentFontInfo b16;
        HashMap hashMap = new HashMap();
        if ((businessFeedData == null || businessFeedData.getFeedCommInfo().appid != 2) && (b16 = FontCacheManager.a().b()) != null) {
            if (!TextUtils.isEmpty(b16.fontUrl)) {
                hashMap.put("diy_font_id", b16.f44975id + "");
                hashMap.put("diy_font_type", b16.fontFormatType + "");
                hashMap.put("diy_font_url", b16.fontUrl);
            }
            if (!TextUtils.isEmpty(b16.superFontJson)) {
                hashMap.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, b16.superFontId + "");
                hashMap.put("sparkle_json", b16.superFontJson);
            }
            if (str != null && str.length() <= 40 && !TextUtils.isEmpty(b16.barrageEffectJson)) {
                hashMap.put(UNIVERSAL_MALL_QUAL.value, b16.barrageEffectId + "");
                hashMap.put("private_barrage_data", b16.barrageEffectJson);
            }
        }
        return hashMap;
    }

    private void X0(BusinessFeedData businessFeedData, View view) {
        w5.b.i("FeedClickProcessor", 1, "onHighFiveClicked");
        if (y(businessFeedData)) {
            j2(view, businessFeedData);
            Z0(view, businessFeedData, 0);
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(694, 1, 1), false, true);
            return;
        }
        w5.b.b("FeedClickProcessor", 1, "onHighFiveClicked, can't high five");
    }

    private CellPictureInfo e0(BusinessFeedData businessFeedData) {
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        if (!TextUtils.isEmpty(businessFeedData.getGiftInfo().smallGiftUrl)) {
            PictureItem pictureItem = new PictureItem();
            PictureUrl pictureUrl = new PictureUrl();
            pictureItem.bigUrl = pictureUrl;
            pictureUrl.url = businessFeedData.getGiftInfo().bigGitUrl;
            if (TextUtils.isEmpty(pictureItem.bigUrl.url)) {
                pictureItem.bigUrl.url = businessFeedData.getGiftInfo().smallGiftUrl;
            }
            PictureUrl pictureUrl2 = new PictureUrl();
            pictureItem.currentUrl = pictureUrl2;
            pictureUrl2.url = businessFeedData.getGiftInfo().smallGiftUrl;
            ArrayList<PictureItem> arrayList = new ArrayList<>();
            cellPictureInfo.pics = arrayList;
            arrayList.add(pictureItem);
        }
        return cellPictureInfo;
    }

    private StickerBubbleAnimationView f0() {
        if (this.F == null) {
            this.F = new StickerBubbleAnimationView(Z());
            FrameLayout frameLayout = null;
            try {
                Activity T = T();
                if (T != null) {
                    frameLayout = (FrameLayout) T.findViewById(R.id.content);
                }
            } catch (Throwable th5) {
                QZLog.w("FeedClickProcessor", "getPokeAnimView: ", th5);
            }
            if (frameLayout == null) {
                frameLayout = (FrameLayout) Q(R.id.content);
            }
            if (frameLayout != null) {
                frameLayout.addView(this.F, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        return this.F;
    }

    private void f2(BusinessFeedData businessFeedData, CanvasTitleView canvasTitleView) {
        FrameLayout frameLayout;
        String[] strArr;
        MultiAnimationLayout multiAnimationLayout = new MultiAnimationLayout(BaseApplication.getContext());
        QZoneBaseFeedFragment qZoneBaseFeedFragment = this.U;
        if (qZoneBaseFeedFragment instanceof Fragment) {
            Activity T = T();
            if (T == null) {
                w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, activity = null");
                return;
            }
            frameLayout = (FrameLayout) T.findViewById(R.id.content);
        } else {
            frameLayout = qZoneBaseFeedFragment != null ? (FrameLayout) Q(R.id.content) : null;
        }
        if (frameLayout == null) {
            w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, layout = null");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw);
        layoutParams.gravity = 48;
        frameLayout.addView(multiAnimationLayout, layoutParams);
        CellHighFiveInfo cellHighFiveInfo = businessFeedData.getCellHighFiveInfo();
        if (cellHighFiveInfo != null) {
            CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
            canvasTitleView.getLocationOnScreen(this.H);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(85.0f), ViewUtils.dpToPx(85.0f));
            layoutParams2.gravity = 5;
            layoutParams2.topMargin = this.H[1] + ViewUtils.dpToPx(5.0f);
            layoutParams2.rightMargin = -ViewUtils.dpToPx(5.0f);
            if (QZoneFeedUtil.S()) {
                layoutParams2.rightMargin = -ViewUtils.dpToPx(10.0f);
                layoutParams2.topMargin += ViewUtils.dpToPx(2.0f);
            }
            multiAnimationLayout.setLayoutParams(layoutParams2);
            al alVar = new al(new ah(multiAnimationLayout));
            QZoneBaseFeedFragment qZoneBaseFeedFragment2 = this.U;
            if (qZoneBaseFeedFragment2 != null) {
                qZoneBaseFeedFragment2.tj(alVar);
            } else {
                w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, baseFeedActivity = " + this.U);
            }
            if (e16 != null && !TextUtils.isEmpty(e16.strHighFiveResUrl)) {
                cellHighFiveInfo.rightHighFiveResUrl = e16.strHighFiveResUrl;
            } else {
                cellHighFiveInfo.rightHighFiveResUrl = com.qzone.personalize.business.b.n().j();
            }
            if (TextUtils.isEmpty(cellHighFiveInfo.easterEggResUrl)) {
                strArr = new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl};
            } else {
                strArr = new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl, cellHighFiveInfo.easterEggResUrl};
            }
            QZLog.i("FeedClickProcessor", 4, "rightHighFiveResUrl = " + cellHighFiveInfo.rightHighFiveResUrl + " leftHighFiveResUrl = " + cellHighFiveInfo.leftHighFiveResUrl);
            multiAnimationLayout.setZipAnimation(new MultiAnimationLayout.a(strArr).g(30).h(false).i(false).j(new a(frameLayout, multiAnimationLayout, canvasTitleView)));
            return;
        }
        canvasTitleView.startHighFiveCountAnimation();
        frameLayout.removeView(multiAnimationLayout);
        w5.b.b("FeedClickProcessor", 1, "[highFive].showHighFiveAnimation, data = null, no zipUrl");
    }

    private void g1(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        this.V.B0(view, businessFeedData, i3, obj);
    }

    private void g2(BusinessFeedData businessFeedData, String str) {
        if (businessFeedData != null) {
            try {
                if (businessFeedData.getUser() != null && !TextUtils.isEmpty(businessFeedData.getUser().personalizedPassivePraiseUrl)) {
                    QZLog.d("FeedClickProcessor", 2, "@cmpraise  showPassiveAnimal play");
                    String replace = businessFeedData.getUser().personalizedPassivePraiseUrl.replace("sbig", com.tencent.mobileqq.magicface.model.f.d());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(CacheManager.getPraiseDir());
                    String str2 = File.separator;
                    sb5.append(str2);
                    sb5.append(MD5Utils.toMD5(replace));
                    sb5.append(str2);
                    String sb6 = sb5.toString();
                    File file = new File(sb6);
                    if (file.exists() && file.isDirectory() && ((IQzoneGiftFullScreenViewControllerProxy) QRoute.api(IQzoneGiftFullScreenViewControllerProxy.class)).isSupportMagicface()) {
                        if (this.L == null) {
                            this.L = ((IQzoneGiftFullScreenViewControllerProxy) QRoute.api(IQzoneGiftFullScreenViewControllerProxy.class)).getQzoneGiftFullScreenViewController(T());
                        }
                        ClickReport.m("633", "1", str);
                        this.L.playMaigcface(businessFeedData.getUser().personalizedPassivePraiseUrl + "", sb6, true, new ac());
                    }
                }
            } catch (Exception e16) {
                QZLog.e("FeedClickProcessor", 2, e16.toString());
            }
        }
    }

    private static int h0(BusinessFeedData businessFeedData) {
        if (businessFeedData.getCommentInfo().realCount > 0) {
            return businessFeedData.getCommentInfo().realCount;
        }
        int i3 = 0;
        if (businessFeedData.getCommentInfo().commments != null && businessFeedData.getCommentInfo().commments.size() > 0) {
            Iterator<Comment> it = businessFeedData.getCommentInfo().commments.iterator();
            while (it.hasNext()) {
                i3 += it.next().replyNum;
            }
        }
        return businessFeedData.getCommentInfo().commentNum + i3;
    }

    private void h2(BusinessFeedData businessFeedData, CustomPraiseData customPraiseData, boolean z16, boolean z17) {
        String str;
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return;
        }
        try {
            if (this.U.si() != null && this.U.si().f47216d == 0) {
                str = "1";
            } else {
                str = "3";
            }
            if (TextUtils.isEmpty(businessFeedData.getUser().personalizedPassivePraiseUrl) && businessFeedData.getUser().cmPraiseActionid == 0) {
                return;
            }
            if (customPraiseData == null || customPraiseData.itemId < 0 || customPraiseData.cmShowActionId == 0) {
                QZLog.d("FeedClickProcessor", 2, "@cmpraise  solvePassivePraise positive ");
                b.C0393b.a(T(), z16, z17, str, this.N, businessFeedData);
                g2(businessFeedData, str);
            }
        } catch (Exception e16) {
            QZLog.e("FeedClickProcessor", 2, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void i2(Intent intent) {
        this.Z.startActivity(intent);
    }

    private long k0(View view) {
        if (((FeedView) c6.a.b(view)).getAutoVideoView().getBaseVideoManager().h() != null) {
            return ((Integer) r3).intValue();
        }
        return 0L;
    }

    private void m1(CellPictureInfo cellPictureInfo) {
        Map<Integer, String> map = cellPictureInfo.busiParam;
        if (map == null || !"1".equals(map.get(61))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(cellPictureInfo.exActionUrl);
            Bundle bundle = new Bundle();
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, jSONObject.getString("appid"));
            bundle.putString(com.tencent.open.downloadnew.e.f341501j, jSONObject.getString("url"));
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, jSONObject.getString("packageName"));
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, jSONObject.getString("via"));
            bundle.putString(com.tencent.open.downloadnew.e.f341503l, jSONObject.getString("appname"));
            bundle.putString(com.tencent.open.downloadnew.e.f341494c, jSONObject.getString("myAppId"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.getInt("versionCode"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 2);
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, false);
            bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.getInt("toPageType"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, jSONObject.getBoolean("isAutoDownload"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, jSONObject.getBoolean("isAutoInstall"));
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.f341184e = jSONObject.getString("appid");
            downloadInfo.M = "biz_src_jc_qzone";
            ArrayList arrayList = new ArrayList();
            arrayList.add(downloadInfo);
            DownloadApi.g(arrayList, null);
            this.W.H4(bundle, "biz_src_jc_qzone", null, jSONObject.getInt("myAppConfig"));
        } catch (JSONException e16) {
            e16.printStackTrace();
            QZLog.e("FeedClickProcessor", "\u9ec4\u94bb\u8fd0\u8425App\u4e0b\u8f7dfeed\u53c2\u6570\u9519\u8bef\uff1a" + e16);
        }
    }

    private void n0() {
        Intent intent = new Intent(this.V.y(), (Class<?>) RecommendFriendActivity.class);
        intent.putExtra("EntranceId", 5);
        i2(intent);
    }

    private void o0(FeedElement feedElement) {
        int i3 = ad.f45995a[feedElement.ordinal()];
        if (i3 != 1) {
            if (i3 == 52) {
                O1(true);
                return;
            }
            if (i3 != 75) {
                if (i3 == 112) {
                    M1(true);
                    return;
                }
                if (i3 != 156) {
                    if (i3 == 56) {
                        J1(true);
                        return;
                    } else {
                        if (i3 != 57) {
                            return;
                        }
                        K1(true);
                        return;
                    }
                }
            }
        }
        P1(true);
    }

    private void o1(View view, String str, boolean z16) {
        AppRuntime b16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z16) {
            Bundle bundle = new Bundle();
            bundle.putString("uin", str);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_PUBLIC_ACCOUNT_UNFOLLOW, bundle);
            return;
        }
        com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new aa(str, view, z16));
        PublicAccountIntent publicAccountIntent = new PublicAccountIntent(U(), NewPublicAccountServlet.class);
        publicAccountIntent.b(cVar);
        publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
        publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", str);
        publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", z16);
        publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0);
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 == null || (b16 = e16.b()) == null) {
            return;
        }
        b16.startServlet(publicAccountIntent);
    }

    private void p0(BusinessFeedData businessFeedData) {
        if (A()) {
            QZoneWriteOperationService.v0().N(this.V.E(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.cellAlbumEntrance.busi_param);
        } else {
            ToastUtil.o(com.tencent.mobileqq.R.string.ghi, 4);
        }
    }

    private void q0(View view, int i3, Object obj) {
        if (obj instanceof BusinessFeedData) {
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            if (businessFeedData.getCellViewMore() == null) {
                return;
            }
            if (2 == businessFeedData.getCellViewMore().actiontype) {
                this.W.la(businessFeedData.getCellViewMore().jump_url, null, null);
            }
            QZLog.w("FeedClickProcessor", "handleClickSuggestMoreView");
        }
    }

    private void t1(BusinessFeedData businessFeedData, View view) {
        String str = LoginData.getInstance().getUin() + "show_recommend_button_new_user_guide";
        SharedPreferences M = u5.b.M(str);
        if (M.getBoolean(str, true)) {
            Resources i06 = i0();
            DialogUtil.createCustomDialog(Z(), 230, (String) null, i06.getString(com.tencent.mobileqq.R.string.f173010gg3), (String) null, i06.getString(com.tencent.mobileqq.R.string.f173009gg2), new x(), (DialogInterface.OnClickListener) null).show();
            M.edit().putBoolean(str, false).commit();
            return;
        }
        e1(view, businessFeedData, 0, false, null, true);
    }

    private void v0() {
        FrameLayout frameLayout;
        View Q;
        int bottom;
        if (this.D == null) {
            this.D = new CustomPraiseHandler(Looper.getMainLooper());
        }
        if (this.f45951e == null || this.f45952f == null || this.f45953h == null || this.f45954i == null || this.f45955m == null) {
            this.f45951e = new CustomPraiseView(BaseApplication.getContext());
            if (this.U instanceof Fragment) {
                Activity T = T();
                if (T == null) {
                    return;
                }
                frameLayout = (FrameLayout) T.findViewById(R.id.content);
                Q = T.findViewById(com.tencent.mobileqq.R.id.f166673ha1);
            } else {
                frameLayout = (FrameLayout) Q(R.id.content);
                Q = Q(com.tencent.mobileqq.R.id.f166673ha1);
            }
            if (frameLayout == null) {
                return;
            }
            if (Q == null) {
                bottom = AreaConst.dp50;
            } else {
                bottom = Q.getBottom();
            }
            this.C = bottom;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw);
            layoutParams.gravity = 48;
            frameLayout.addView(this.f45951e, layoutParams);
            if (QZoneApiProxy.isInQZoneEnvironment()) {
                this.f45952f = (BubbleUpFrameAnimView) LayoutInflater.from(Z()).inflate(com.tencent.mobileqq.R.layout.br5, (ViewGroup) frameLayout, false);
            } else {
                this.f45952f = new BubbleUpFrameAnimView(Z());
            }
            frameLayout.addView(this.f45952f);
            frameLayout.addView(this.f45953h);
            frameLayout.addView(this.f45954i);
            frameLayout.addView(this.f45955m);
        }
    }

    private boolean x0(VideoInfo videoInfo) {
        return videoInfo != null && videoInfo.isFakeFeed && (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FAKE_FEED_INTERCEPT, 1) == 1);
    }

    public static boolean y(BusinessFeedData businessFeedData) {
        return TitleAttachArea.showHigh5Button(businessFeedData) || (TitleAttachArea.canMultipleHighFive(businessFeedData) && TitleAttachArea.showMultipleHighFiveIcon(businessFeedData));
    }

    private void z(View view, BusinessFeedData businessFeedData) {
        CellFeedCommInfo cellFeedCommInfo;
        Map<String, String> map;
        if (!na.c.f419539a.e() || businessFeedData == null || (cellFeedCommInfo = businessFeedData.cellFeedCommInfo) == null || (map = cellFeedCommInfo.extendInfo) == null) {
            return;
        }
        String str = map.get(QQHealthReportApiImpl.MSG_TYPE_KEY);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RFWLog.d("FeedClickProcessor", RFWLog.USR, "checkMsgReport click: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("trigger_reason", str);
        fo.b l3 = new fo.b().l(hashMap);
        l3.k(ExposurePolicy.REPORT_FIRST);
        l3.i(ef.b.a(businessFeedData));
        fo.c.b("dt_clck", view, "em_qz_msg", l3);
    }

    public static void z1(Activity activity, BusinessFeedData businessFeedData, View view, int i3, int i16) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        if (businessFeedData == null) {
            QZLog.e("onSingleAlbumVideoClick", "bfd == null");
            return;
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        if (videoInfo == null) {
            QZLog.e("onSingleAlbumVideoClick", "videoInfo == null");
            return;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.pics = new ArrayList<>();
        PictureItem pictureItem = new PictureItem();
        pictureItem.sloc = videoInfo.sloc;
        pictureItem.lloc = videoInfo.lloc;
        pictureItem.videodata = videoInfo;
        pictureItem.videoflag = 1;
        pictureItem.likeCount = businessFeedData.getLikeInfo().likeNum;
        pictureItem.isLike = businessFeedData.getLikeInfo().isLiked;
        pictureItem.commentCount = businessFeedData.getCommentInfo().commentNum;
        pictureItem.albumId = videoInfo.albumid;
        pictureItem.busi_param = businessFeedData.getOperationInfo().busiParam;
        pictureItem.currentUrl = videoInfo.currentUrl;
        PictureUrl pictureUrl3 = videoInfo.bigUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            pictureItem.bigUrl = videoInfo.bigUrl;
        }
        PictureUrl pictureUrl4 = videoInfo.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            pictureItem.originUrl = videoInfo.originUrl;
        }
        PictureUrl pictureUrl5 = pictureItem.bigUrl;
        if ((pictureUrl5 == null || TextUtils.isEmpty(pictureUrl5.url)) && (pictureUrl = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            pictureItem.bigUrl = videoInfo.coverUrl;
        }
        PictureUrl pictureUrl6 = pictureItem.currentUrl;
        if ((pictureUrl6 == null || TextUtils.isEmpty(pictureUrl6.url)) && (pictureUrl2 = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            pictureItem.currentUrl = videoInfo.coverUrl;
        }
        cellPictureInfo.pics.add(pictureItem);
        cellPictureInfo.uin = businessFeedData.getUser().uin;
        cellPictureInfo.albumid = videoInfo.albumid;
        cellPictureInfo.anonymity = videoInfo.anonymity;
        cellPictureInfo.uniKey = businessFeedData.getFeedCommInfo().orglikekey;
        cellPictureInfo.actionurl = videoInfo.actionUrl;
        PhotoParam photoParam = new PhotoParam();
        photoParam.canAddFavor = (businessFeedData.getFeedCommInfo().operatemask & 131072) != 0;
        photoParam.appid = businessFeedData.getFeedCommInfo().appid;
        photoParam.ownerUin = businessFeedData.getUser().uin;
        photoParam.subid = businessFeedData.getFeedCommInfo().subid;
        photoParam.isLike = businessFeedData.getLikeInfo().isLiked;
        photoParam.likeNum = businessFeedData.getLikeInfo().likeNum;
        photoParam.commentNum = h0(businessFeedData);
        photoParam.feedId = businessFeedData.getFeedCommInfo().ugckey;
        photoParam.ugcKey = businessFeedData.getFeedCommInfo().ugckey;
        photoParam.qzoneUserType = businessFeedData.getUser().famousSpaceMedal.userTypeReport;
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getUser() != null && businessFeedData.getOriginalInfo().getUser().uin != 0) {
            photoParam.isSharedFeeds = true;
        } else {
            photoParam.isSharedFeeds = false;
        }
        photoParam.feedUin = businessFeedData.getUser().uin;
        photoParam.albumid = cellPictureInfo.albumid;
        photoParam.uploadnum = cellPictureInfo.uploadnum;
        photoParam.businessPhotoFeedIndex = i16;
        photoParam.albumPriv = cellPictureInfo.albumrights;
        ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
        photoParam.isOnePictureFeed = arrayList != null && arrayList.size() == 1;
        photoParam.isTihFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        if (map != null) {
            photoParam.orgKey = c6.a.g(map.get(5), photoParam.orgKey);
            photoParam.curKey = c6.a.g(map.get(6), photoParam.curKey);
        }
        photoParam.cell_id = W(photoParam, businessFeedData);
        photoParam.busi_param = map;
        PictureViewerFactory.L(activity, cellPictureInfo, businessFeedData.getFeedCommInfo(), new com.qzone.proxy.feedcomponent.model.f(i3, 0, false, true).a(), photoParam, 1204, businessFeedData.getUser().isSafeModeUser != 0);
    }

    public void A0(BusinessFeedData businessFeedData) {
        String str;
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_LIKELIST_PAGE, QzoneConfig.DefaultValue.DEFAULT_LIKELIST_PAGE_URL);
        if (TextUtils.isEmpty(config) || businessFeedData == null) {
            return;
        }
        if (config.contains("{unikey}") && (str = businessFeedData.getFeedCommInfo().curlikekey) != null) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                str = URLEncoder.encode(str);
            }
            config = config.replace("{unikey}", str);
        }
        if (config.contains("{uin}")) {
            config = config.replace("{uin}", String.valueOf(LoginData.getInstance().getUin()));
        }
        if (config.contains("{hostuin}")) {
            User user = businessFeedData.getUser();
            if (user != null) {
                config = config.replace("{hostuin}", String.valueOf(user.uin));
            } else {
                config = config.replace("{hostuin}", "0");
            }
        }
        if (config.contains("{appid}")) {
            BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
            if (originalInfo != null) {
                config = config.replace("{appid}", String.valueOf(originalInfo.getFeedCommInfo().appid));
            } else {
                config = config.replace("{appid}", "");
            }
        }
        this.W.la(config, null, null);
    }

    public void B1(View view, BusinessFeedData businessFeedData) {
        Activity T;
        if (this.U == null || (T = T()) == null || businessFeedData == null) {
            return;
        }
        String str = null;
        if (com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().isOriginal(view) && businessFeedData.getOriginalInfo() != null) {
            if (businessFeedData.getOriginalInfo().getCellSummaryV2() != null) {
                str = businessFeedData.getOriginalInfo().getCellSummaryV2().summary;
            }
        } else if (businessFeedData.getCellSummaryV2() != null) {
            str = businessFeedData.getCellSummaryV2().summary;
        }
        u uVar = new u(T, str);
        long j3 = businessFeedData.owner_uin;
        if (j3 == 0) {
            j3 = businessFeedData.getUser().uin;
        }
        if (businessFeedData.isAdFeeds()) {
            return;
        }
        com.qzone.widget.util.b.j(T, uVar, null, new v(j3, businessFeedData), null, Boolean.TRUE);
    }

    void F0(View view, BusinessFeedData businessFeedData, int i3, int i16) {
        G0(view, businessFeedData, i3, i16);
        new QZoneClickReport.ReportInfo();
        try {
            MiscReportUtils.f(businessFeedData, 15);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    protected void G(ClickedComment clickedComment, int i3, boolean z16) {
        BusinessFeedData businessFeedData;
        if (y0(i3)) {
            if (!A()) {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"));
                return;
            }
            QZonePullToRefreshListView Q = this.V.Q();
            if (Q == null || (businessFeedData = (BusinessFeedData) Q.j0().getItemAtPosition(i3)) == null) {
                return;
            }
            I(businessFeedData, clickedComment, i3, z16);
        }
    }

    protected void L(BusinessFeedData businessFeedData, int i3) {
        new a.C11115a();
        yo.d.d("mqzone://arouse/album?albumid=" + businessFeedData.getPictureInfo().albumid + "&version=1&source=tafrefer&uin=" + businessFeedData.getPictureInfo().uin + "&albumtype=" + QZoneAlbumUtil.t(businessFeedData.getPictureInfo().anonymity) + "&syncuin=" + LoginData.getInstance().getUin() + "&individualalbum=" + (businessFeedData.getPictureInfo().individualAlbum ? 1 : 0), Z(), null);
    }

    @Deprecated
    protected <T extends View> T Q(int i3) {
        return (T) this.Z.findViewById(i3);
    }

    public void Q0() {
        BubbleUpFrameAnimView bubbleUpFrameAnimView = this.f45953h;
        if (bubbleUpFrameAnimView != null) {
            bubbleUpFrameAnimView.stop();
        }
        BubbleUpFrameAnimView bubbleUpFrameAnimView2 = this.f45954i;
        if (bubbleUpFrameAnimView2 != null) {
            bubbleUpFrameAnimView2.stop();
        }
        BubbleUpFrameAnimView bubbleUpFrameAnimView3 = this.f45955m;
        if (bubbleUpFrameAnimView3 != null) {
            bubbleUpFrameAnimView3.stop();
        }
    }

    public void R0(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        this.V.u0(view, businessFeedData, i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity T() {
        return this.Z.getActivity();
    }

    protected void T0(final View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        if (!(obj instanceof FriendBirthdayGift) || businessFeedData == null) {
            return;
        }
        final FriendBirthdayGift friendBirthdayGift = (FriendBirthdayGift) obj;
        final int i16 = friendBirthdayGift.magic;
        if (!NetworkState.isNetSupport()) {
            x1(view, friendBirthdayGift, i16, null);
            return;
        }
        h5.a aVar = new h5.a();
        aVar.f404323e = false;
        aVar.f404327i = friendBirthdayGift.istiming;
        aVar.f404328j = friendBirthdayGift.sendtime;
        aVar.f404324f = false;
        aVar.f404330l = friendBirthdayGift.giftbackid;
        aVar.f404321c.add(Long.valueOf(businessFeedData.getUser().uin));
        QZLog.i("BirthdayGif", String.valueOf(businessFeedData.getUser().uin));
        aVar.f404320b = Long.parseLong(friendBirthdayGift.giftid);
        aVar.f404319a = Integer.parseInt(friendBirthdayGift.gifttype);
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onBirthdayGiftSending(view, i16);
        com.qzone.business.gift.business.service.a.b().c(aVar, new Handler() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.26
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                final QZoneResult unpack = QZoneResult.unpack(message);
                if (unpack.what != 1000004) {
                    return;
                }
                post(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass26 anonymousClass26 = AnonymousClass26.this;
                        BaseFeedClickProcessor.this.x1(view, friendBirthdayGift, i16, unpack);
                    }
                });
            }
        });
        ClickReport.q("594", "5", "", true);
    }

    protected void U0(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        if (!(obj instanceof FriendBirthdayGift) || businessFeedData == null) {
            return;
        }
        FriendBirthdayGift friendBirthdayGift = (FriendBirthdayGift) obj;
        if (!TextUtils.isEmpty(friendBirthdayGift.actionurl)) {
            this.W.la(friendBirthdayGift.actionurl, null, null);
        }
        ClickReport.q("594", "2", "", true);
    }

    protected BaseVideo V(View view, int i3) {
        AbsFeedView b16 = c6.a.b(view);
        if (b16 != null) {
            return ((FeedView) b16).getAutoVideoView();
        }
        return null;
    }

    protected void V0(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        String G0 = QZoneConfigHelper.G0();
        if (TextUtils.isEmpty(G0)) {
            return;
        }
        this.W.la(G0, null, null);
        ClickReport.q("594", "3", "", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce A[Catch: Exception -> 0x011d, TryCatch #0 {Exception -> 0x011d, blocks: (B:5:0x0007, B:7:0x000b, B:12:0x0013, B:14:0x001b, B:16:0x002d, B:18:0x003f, B:20:0x0051, B:21:0x0087, B:23:0x008d, B:25:0x0094, B:26:0x009b, B:28:0x00a1, B:30:0x00aa, B:32:0x00b9, B:34:0x00bf, B:39:0x00ce, B:41:0x010d, B:42:0x0110, B:44:0x0116), top: B:4:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V1(BusinessFeedData businessFeedData, int i3, View view) {
        String str;
        String str2;
        String str3;
        boolean z16;
        if (businessFeedData == null || view == null) {
            return;
        }
        try {
            if (!(view instanceof CanvasRecommAction) || !businessFeedData.isAdFeeds() || businessFeedData.getRecommAction().extendInfo == null) {
                return;
            }
            if (businessFeedData.getRecommAction().extendInfo.containsKey(15) && businessFeedData.getRecommAction().extendInfo.containsKey(14) && businessFeedData.getRecommAction().extendInfo.containsKey(13)) {
                str = businessFeedData.getRecommAction().extendInfo.get(13);
                str3 = businessFeedData.getRecommAction().extendInfo.get(14);
                str2 = businessFeedData.getRecommAction().extendInfo.get(15);
            } else {
                str = "";
                str2 = "";
                str3 = str2;
            }
            if (!TextUtils.isEmpty(str) && ((CanvasRecommAction) view).right_button_area != null) {
                ((CanvasRecommAction) view).right_button_area.setText(str);
            }
            if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                return;
            }
            IVasQZoneApi iVasQZoneApi = (IVasQZoneApi) QRoute.api(IVasQZoneApi.class);
            if (!iVasQZoneApi.containsReportId(str2) && (TextUtils.isEmpty(str3) || !"true".equals(str3))) {
                z16 = true;
                if (z16) {
                    return;
                }
                VasAdMetaReportParam.Builder builder = new VasAdMetaReportParam.Builder();
                builder.setAdvPos(8);
                builder.setUin(Long.valueOf(LoginData.getInstance().getUin()));
                builder.setActionType(5);
                builder.setFeedIndex(Integer.valueOf(i3));
                builder.setActionType(1);
                builder.setSubscribeId(str2);
                iVasQZoneApi.reportAdvAsync(builder.build());
                if (str2 != null) {
                    iVasQZoneApi.addReportId(str2);
                }
                if (QZLog.isColorLevel()) {
                    QZLog.i("FeedClickProcessor", "@orderAdv sendReq");
                    return;
                }
                return;
            }
            z16 = false;
            if (z16) {
            }
        } catch (Exception e16) {
            QZLog.e("FeedClickProcessor", "@orderAdv sendReq erro" + e16.toString());
        }
    }

    protected void W0(int i3) {
        QZonePullToRefreshListView Q = this.V.Q();
        if (Q == null) {
            return;
        }
        l0((BusinessFeedData) Q.j0().getItemAtPosition(i3));
    }

    public void X1(int i3, BusinessFeedData businessFeedData, View view, View view2) {
        QZonePullToRefreshListView Q = this.V.Q();
        if (Q != null) {
            EditPositionBag h16 = EditPositionBag.h(hashCode());
            this.f45949d = h16;
            if (h16 != null) {
                h16.f60222e = new WeakReference<>(Q.j0());
                this.f45949d.f60223f = new WeakReference<>(Q);
                if (!Q.k0()) {
                    this.f45949d.f60230m = j0();
                }
                this.f45949d.f60228k = Q.h0();
                this.f45949d.e(i3, view, 2, 0);
            }
        }
        if (view2 != null) {
            v0();
            D();
            this.U.tj(this.f45947b0);
            this.f45955m.setVisibility(0);
            this.f45955m.setOnStartListener(new e(view2));
            this.f45955m.setOnEndListener(new f(view2));
        }
        QZoneFeedUtil.W(businessFeedData, 1, this.V);
    }

    protected Context Z() {
        return this.Z.getActivity();
    }

    public void Z1(ClickedComment clickedComment, int i3, boolean z16, BusinessFeedData businessFeedData) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f45948c0 < 1000) {
            return;
        }
        this.f45948c0 = currentTimeMillis;
        b bVar = new b(businessFeedData, clickedComment, i3, z16);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(Z(), com.tencent.mobileqq.R.string.gda), 0, 0, 2));
        com.qzone.widget.o a16 = com.qzone.widget.p.a(T(), arrayList, bVar);
        this.K = a16;
        a16.addCancelButton(com.tencent.mobileqq.R.string.cancel);
        ActionSheetHelper.showActionSheet(T(), this.K);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public boolean a(FeedElement feedElement, Object obj, View view, CellTextView.OnTextOperater onTextOperater) {
        BusinessFeedData businessFeedData;
        ArrayList<PictureItem> arrayList;
        PictureItem pictureItem;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Actvity] ");
        sb5.append(this.E);
        sb5.append("  OnFeedElementClick long click ");
        if (view != null) {
            sb5.append(" view  id:");
            sb5.append(Integer.toHexString(view.getId()));
        }
        sb5.append(" element:");
        sb5.append(feedElement);
        RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
        int i3 = ad.f45995a[feedElement.ordinal()];
        if (i3 == 50) {
            com.qzone.proxy.feedcomponent.model.f fVar = (com.qzone.proxy.feedcomponent.model.f) obj;
            int b16 = fVar.b();
            int a16 = fVar.a();
            QZonePullToRefreshListView Q = this.V.Q();
            if (Q != null && Q.j0() != null && b16 < Q.j0().getCount() && (businessFeedData = (BusinessFeedData) Q.j0().getItemAtPosition(b16)) != null) {
                CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
                if (pictureInfo == null && businessFeedData.getOriginalInfo() != null) {
                    pictureInfo = businessFeedData.getOriginalInfo().getPictureInfo();
                }
                if (pictureInfo != null && (arrayList = pictureInfo.pics) != null && arrayList.size() > a16 && a16 >= 0) {
                    if (QZoneFeedUtil.i0(businessFeedData) && (pictureItem = pictureInfo.pics.get(a16)) != null && pictureItem.videoflag != 1) {
                        QZoneFeedUtil.g0(Z(), pictureItem);
                    }
                    return true;
                }
            }
            return false;
        }
        if (i3 == 85) {
            QZonePullToRefreshListView Q2 = this.V.Q();
            int count = Q2 == null ? 0 : Q2.getCount();
            if (Q2 != null && obj != null) {
                Integer num = (Integer) obj;
                if (num.intValue() >= 0 && num.intValue() < count && (businessFeedData2 = (BusinessFeedData) Q2.j0().getItemAtPosition(num.intValue())) != null && businessFeedData2.getCellSummaryV2() != null) {
                    B1(view, businessFeedData2);
                }
            }
            return false;
        }
        if (i3 != 112) {
            if (i3 == 65) {
                return true;
            }
            if (i3 != 66 || onTextOperater == null) {
                return false;
            }
            L0(((Integer) obj).intValue(), onTextOperater, onTextOperater);
            return true;
        }
        final BaseFeedPresenter baseFeedPresenter = this.V;
        if ((obj instanceof Integer) && baseFeedPresenter != null) {
            int intValue = ((Integer) obj).intValue();
            QZonePullToRefreshListView Q3 = baseFeedPresenter.Q();
            if (Q3 == null || (businessFeedData3 = (BusinessFeedData) Q3.j0().getItemAtPosition(intValue)) == null) {
                return false;
            }
            if (QZoneFeedUtil.m(businessFeedData3)) {
                Q3.setMotionEventInterceptor(new w(Q3));
                final Intent intent = new Intent();
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, true);
                int i16 = businessFeedData3.getFeedCommInfo().appid;
                if (i16 != 311 && i16 != 6100) {
                    QZoneFeedUtil.f47421a.put("activity_result_ahare_to_qzone_key", businessFeedData3);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.34
                        @Override // java.lang.Runnable
                        public void run() {
                            baseFeedPresenter.F0(intent);
                        }
                    });
                } else {
                    QZoneFeedUtil.f47421a.put("current_forward_key", businessFeedData3);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.33
                        @Override // java.lang.Runnable
                        public void run() {
                            baseFeedPresenter.z0(intent);
                        }
                    });
                }
                return true;
            }
            LpReportInfo_pf00064.allReport(85, 6, 2);
        }
        return false;
    }

    public com.qzone.feed.business.service.a a0() {
        return this.U.si();
    }

    void a1(View view, BusinessFeedData businessFeedData, int i3, boolean z16) {
        c1(view, businessFeedData, i3, z16);
        new QZoneClickReport.ReportInfo();
        try {
            MiscReportUtils.f(businessFeedData, 15);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    void a2(BusinessFeedData businessFeedData, CustomPraiseData customPraiseData, boolean z16, boolean z17, int i3) {
        String str;
        QZLog.w("FeedClickProcessor", "@cmpraise  ,showCmPraiseAnimation ");
        if (customPraiseData == null || customPraiseData.cmShowActionId == 0) {
            return;
        }
        QLog.d("FeedClickProcessor", 2, "@cmpraise customPraiseData actionid = " + customPraiseData.cmShowActionId);
        if (this.U.si() != null && this.U.si().f47216d == 0) {
            str = "1";
        } else {
            str = "3";
        }
        b.C0393b.a(T(), z17, z16, str, i3, businessFeedData);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment.g
    public void b(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        BubbleUpFrameAnimView bubbleUpFrameAnimView = this.f45954i;
        if (bubbleUpFrameAnimView != null) {
            bubbleUpFrameAnimView.stop();
        }
        BubbleUpFrameAnimView bubbleUpFrameAnimView2 = this.f45955m;
        if (bubbleUpFrameAnimView2 != null) {
            bubbleUpFrameAnimView2.stop();
        }
    }

    public EditPositionBag b0() {
        return this.f45949d;
    }

    void b2(CustomPraiseData customPraiseData, long j3) {
        com.qzone.homepage.ui.component.a aVar;
        QLog.d("FeedClickProcessor", 2, "@cmpraise showCmPraiseAnimation just play");
        if (customPraiseData == null || customPraiseData.cmShowActionId == 0) {
            return;
        }
        QLog.d("FeedClickProcessor", 2, "@cmpraise customPraiseData actionid = " + customPraiseData.cmShowActionId);
        QZoneBaseFeedFragment qZoneBaseFeedFragment = this.U;
        if (!(qZoneBaseFeedFragment instanceof QZoneMyFeedFragment) || (aVar = ((QZoneMyFeedFragment) qZoneBaseFeedFragment).f47306v1) == null || customPraiseData.cmShowActionId == 0) {
            return;
        }
        aVar.f(null);
    }

    CustomPraiseData c2(boolean z16, BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        CustomPraiseData createFrom;
        QZLog.w("FeedClickProcessor", "@compraise  ,showCustomPraiseAnimation comboCount" + i17);
        v0();
        D();
        this.U.tj(this.f45947b0);
        if (z16) {
            if (businessFeedData.isGDTAdvFeed()) {
                createFrom = (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null) ? null : com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            } else {
                createFrom = QzoneCustomPraiseService.i().g();
            }
            if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                createFrom = businessFeedData.getUser().customPraiseData;
            }
            if (createFrom == null) {
                if (this.Y == 1) {
                    this.f45951e.setShowPos(i3, i16);
                    if (this.X == null) {
                        this.X = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SELF_PRAISE_ANIMATION, QzoneConfig.SECONDARY_KEY_SELF_PRAISE_ANIMATION_RES_URL, QzoneConfig.DEFAULT_SELF_PRAISE_ANIMATION_RES_URL);
                    }
                    this.f45951e.setAnimationRes(this.X, 30, 0, businessFeedData.hashCode());
                }
                return null;
            }
            this.f45951e.setShowPos(i3, i16);
        } else {
            if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                createFrom = businessFeedData.getUser().customPraiseData;
            } else {
                if (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null) {
                    return null;
                }
                createFrom = CustomPraiseData.createFrom(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            }
            this.f45951e.setShowPos(i3, i16 + (-ViewUtils.dip2px(20.0f)));
        }
        this.f45951e.setAnimationRes(createFrom.praiseZipUrl, createFrom.frameRate, createFrom.praiseType, businessFeedData.hashCode());
        return createFrom;
    }

    protected BusinessFeedData d0(int i3) {
        QZonePullToRefreshListView Q = this.V.Q();
        if (Q == null) {
            return null;
        }
        return (BusinessFeedData) Q.j0().getItemAtPosition(i3);
    }

    void d2(boolean z16, CustomPraiseData customPraiseData, int i3, int i16, int i17) {
        v0();
        D();
        this.U.tj(this.f45947b0);
        if (!z16) {
            this.f45951e.setShowPos(i3, i16 + (-ViewUtils.dip2px(20.0f)));
        } else if (customPraiseData == null) {
            return;
        } else {
            this.f45951e.setShowPos(i3, i16);
        }
        this.f45951e.setAnimationRes(customPraiseData.praiseZipUrl, customPraiseData.frameRate, customPraiseData.praiseType, customPraiseData.itemId);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0481 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0468  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e1(View view, BusinessFeedData businessFeedData, int i3, boolean z16, Boolean bool, boolean z17) {
        boolean booleanValue;
        int i16;
        int i17;
        String str;
        String str2;
        boolean z18;
        CustomPraiseData g16;
        boolean z19;
        String str3;
        String str4;
        String str5;
        String str6;
        int i18;
        boolean z26;
        boolean z27;
        boolean z28;
        SuperLikeView superLikeView;
        int i19;
        int i26;
        ArrayList<CellLikeInfo.LikeMan> arrayList;
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        int i27;
        if (businessFeedData == null || businessFeedData.getLocalInfo().isFake()) {
            return;
        }
        boolean y16 = y(businessFeedData);
        if (businessFeedData.getLocalInfo().canLike || y16) {
            CellLikeInfo likeInfo = businessFeedData.getLikeInfo();
            boolean z29 = this.N == -1 ? likeInfo.isLiked : false;
            if (bool == null) {
                booleanValue = !z29;
            } else {
                booleanValue = bool.booleanValue();
            }
            if (z17) {
                booleanValue = !businessFeedData.getCellRecommendListSafe().isRecommended;
            }
            boolean z36 = booleanValue;
            boolean z37 = businessFeedData.getLikeInfo().isLiked && this.N != -1;
            if (!z36 && (arrayList = likeInfo.likeMans) != null) {
                for (CellLikeInfo.LikeMan likeMan : arrayList) {
                    if (likeMan.user.uin == LoginData.getInstance().getUin() && (polymorphicPraiseEmotionData = likeMan.polymorphicPraiseData) != null && (i27 = polymorphicPraiseEmotionData.iItemId) > 0) {
                        i16 = polymorphicPraiseEmotionData.pokeCombo;
                        i17 = i27;
                        break;
                    }
                }
            }
            i16 = 0;
            i17 = -1;
            if (z17) {
                if (view instanceof AbsFeedView) {
                    u1((AbsFeedView) view, businessFeedData, z36);
                }
            } else {
                f1(view, businessFeedData, z36);
            }
            QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
            mVar.f45734a = businessFeedData.getFeedCommInfo().ugckey;
            mVar.f45735b = businessFeedData.getFeedCommInfo().curlikekey;
            mVar.f45736c = businessFeedData.getFeedCommInfo().orglikekey;
            mVar.f45738e = z36;
            mVar.f45747n = User.getLikeType(0, z36);
            mVar.f45739f = businessFeedData.getFeedCommInfo().appid;
            Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
            if (map != null) {
                mVar.f45740g = new HashMap(map);
            }
            mVar.f45742i = -1;
            mVar.f45744k = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
            if (this.U.si() == null) {
                mVar.f45745l = 0;
            } else {
                mVar.f45745l = this.U.si().f47216d;
            }
            mVar.f45746m = 0;
            mVar.f45749p = i3;
            mVar.f45754u = businessFeedData;
            mVar.f45755v = businessFeedData.feedType;
            mVar.f45757x = z37;
            mVar.f45759z = z17;
            boolean z38 = y16 && (view instanceof CanvasTitleView) && businessFeedData.getUser() != null;
            if (z38) {
                mVar.f45737d = businessFeedData.getFeedCommInfo().feedskey;
                if (TitleAttachArea.showHigh5Button(businessFeedData)) {
                    mVar.f45750q = true;
                } else if (TitleAttachArea.canMultipleHighFive(businessFeedData) && TitleAttachArea.showMultipleHighFiveIcon(businessFeedData)) {
                    mVar.f45751r = true;
                }
                z18 = z36;
                mVar.f45752s = businessFeedData.getUser().uin;
                if (mVar.f45753t == null) {
                    mVar.f45753t = new HashMap();
                }
                mVar.f45753t.put("praise_ctime", String.valueOf(businessFeedData.getFeedCommInfo().getTime() / 1000));
                if (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null || businessFeedData.getCellDecorateInfo().cellCustomPraise.uiComboCount <= 0) {
                    g16 = null;
                } else {
                    g16 = CustomPraiseData.createFrom(businessFeedData.getCellDecorateInfo().cellCustomPraise);
                    mVar.f45749p = (int) g16.comboCount;
                    if (businessFeedData.getFeedCommInfo().extendInfo != null) {
                        g16.praiseSummery = businessFeedData.getFeedCommInfo().extendInfo.get("custom_praise_document");
                    }
                }
                if (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellPolymorphicPraise == null) {
                    z19 = true;
                } else {
                    CellDecorateInfo.CellPolymorphicPraise cellPolymorphicPraise = businessFeedData.getCellDecorateInfo().cellPolymorphicPraise;
                    int i28 = cellPolymorphicPraise.iItemId;
                    if (i28 > 0) {
                        mVar.f45753t.put("poly_itemid", String.valueOf(i28));
                        mVar.f45753t.put("poly_text", cellPolymorphicPraise.strText);
                        mVar.f45753t.put("poly_itype", String.valueOf(cellPolymorphicPraise.itype));
                        mVar.f45753t.put("poly_groupid", String.valueOf(cellPolymorphicPraise.resourceId));
                        mVar.f45753t.put("poke_combo_num", String.valueOf(cellPolymorphicPraise.combo));
                    }
                    z19 = false;
                }
                if (businessFeedData.getCellHighFiveInfo() != null) {
                    str = "poly_itemid";
                    str2 = "poly_text";
                    mVar.f45753t.put("high_five_combo_counts", String.valueOf(businessFeedData.getCellHighFiveInfo().highFiveCount));
                    CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
                    if (e16 != null && (i26 = e16.itemId) != -1) {
                        mVar.f45753t.put("personal_like_id", String.valueOf(i26));
                    }
                } else {
                    str = "poly_itemid";
                    str2 = "poly_text";
                    w5.b.i("FeedClickProcessor", 1, "[highFive].onLikeClick, combo_counts was not delivered to server");
                }
                mVar.f45753t.put("high_five_from", "1");
                mVar.f45753t.put("high_five_to", "1");
            } else {
                str = "poly_itemid";
                str2 = "poly_text";
                z18 = z36;
                g16 = businessFeedData.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
                if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                    g16 = businessFeedData.getUser().customPraiseData;
                }
                z19 = true;
            }
            if ((view instanceof AbsFeedView) && g16 == null && z19 && z18 && (superLikeView = (SuperLikeView) view.findViewWithTag("praise_click_tag")) != null && !z16) {
                if (this.Y == -1) {
                    i19 = 1;
                    this.Y = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SELF_PRAISE_ANIMATION, QzoneConfig.SECONDARY_KEY_SELF_PRAISE_ANIMATION_SWITCH, 1);
                } else {
                    i19 = 1;
                }
                if (this.Y == i19 && businessFeedData.getUser().uin == LoginData.getInstance().getUin()) {
                    if (this.N == -1) {
                        superLikeView.getLocationInWindow(this.H);
                        QZLog.d("FeedClickProcessor", 2, "@cmPraise onLickClick");
                        str4 = "FeedClickProcessor";
                        str6 = str;
                        str3 = str2;
                        str5 = "poly_itype";
                        a2(businessFeedData, c2(true, businessFeedData, (this.H[0] + (superLikeView.getWidth() / 2)) - AreaConst.dp72, ((this.H[1] - this.I) - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (superLikeView.getHeight() / 2) + AreaConst.dp1_3, i3), z38, z18, this.N);
                        this.f45951e.l();
                        LpReportInfo_pf00064.allReport(92, 1, 1);
                    }
                } else {
                    str3 = str2;
                    str4 = "FeedClickProcessor";
                    str5 = "poly_itype";
                    str6 = str;
                    v0();
                    D();
                    this.U.tj(this.f45947b0);
                    View findViewById = view.findViewById(com.tencent.mobileqq.R.id.ff6);
                    this.f45953h.setOnStartListener(new ae(findViewById));
                    this.f45953h.setOnEndListener(new af(findViewById));
                }
                i18 = this.N;
                if (i18 != -1) {
                    mVar.f45756w = i18;
                    PolymorphicPraiseData polyPraiseData = QzonePolymorphicPraiseService.getInstance().getPolyPraiseData();
                    if (polyPraiseData == null || this.P == null) {
                        w5.b.b(str4, 1, "[polyPraise].onLikeClick, polymorphicPraiseData = " + polyPraiseData + ", mPolyEmotionData = " + this.P);
                    } else {
                        if (mVar.f45753t == null) {
                            mVar.f45753t = new HashMap();
                        }
                        int i29 = this.P.iItemId;
                        if (i29 > 0) {
                            mVar.f45753t.put(str6, String.valueOf(i29));
                            mVar.f45753t.put(str3, this.P.strItemSummary);
                            mVar.f45753t.put(str5, String.valueOf(polyPraiseData.polyPraiseType));
                            mVar.f45753t.put("poly_groupid", String.valueOf(polyPraiseData.itemId));
                            mVar.f45753t.put("poke_combo_num", String.valueOf(this.Q));
                            mVar.f45753t.put("poke_name", this.P.strName);
                            if (this.R) {
                                mVar.f45753t.put("poly_entry", String.valueOf(2));
                            } else {
                                mVar.f45753t.put("poly_entry", String.valueOf(1));
                            }
                        }
                        mVar.f45758y = this.P;
                    }
                }
                if (i17 > 0) {
                    if (mVar.f45753t == null) {
                        mVar.f45753t = new HashMap();
                    }
                    mVar.f45753t.put(str6, String.valueOf(i17));
                    if (!mVar.f45738e) {
                        z26 = z38;
                        PokeLikeWizard.INSTANCE.report(true, 5, i17, i16, businessFeedData.getUser().uin);
                        if (this.N != -1) {
                            mVar.f45748o = null;
                        } else {
                            mVar.f45748o = g16;
                        }
                        QZoneWriteOperationService.v0().u1(this.V.E(), mVar);
                        if (LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true) || z26 || businessFeedData.getFeedCommInfo().isBizRecomFeeds() || this.N != -1 || !z18 || businessFeedData.getUser().personalizedPassivePraiseId == -1 || QZoneFeedUtil.R(businessFeedData)) {
                            z27 = z18;
                        } else {
                            z27 = z18;
                            h2(businessFeedData, g16, z27, z26);
                        }
                        if (z27 && businessFeedData.getFeedCommInfo().recomtype == 7) {
                            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                            int S = this.V.S();
                            com.qzone.adapter.feedcomponent.i.H();
                            H.U1(S, "3");
                        }
                        if (businessFeedData.getFeedCommInfo() == null && businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
                            z28 = true;
                            ClickReport.c(580, 7, "", true, new String[0]);
                        } else {
                            z28 = true;
                        }
                        MiscReportUtils.l(businessFeedData, z28);
                    }
                }
                z26 = z38;
                if (this.N != -1) {
                }
                QZoneWriteOperationService.v0().u1(this.V.E(), mVar);
                if (LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true)) {
                }
                z27 = z18;
                if (z27) {
                    com.qzone.adapter.feedcomponent.i H2 = com.qzone.adapter.feedcomponent.i.H();
                    int S2 = this.V.S();
                    com.qzone.adapter.feedcomponent.i.H();
                    H2.U1(S2, "3");
                }
                if (businessFeedData.getFeedCommInfo() == null) {
                }
                z28 = true;
                MiscReportUtils.l(businessFeedData, z28);
            }
            str3 = str2;
            str4 = "FeedClickProcessor";
            str5 = "poly_itype";
            str6 = str;
            i18 = this.N;
            if (i18 != -1) {
            }
            if (i17 > 0) {
            }
            z26 = z38;
            if (this.N != -1) {
            }
            QZoneWriteOperationService.v0().u1(this.V.E(), mVar);
            if (LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true)) {
            }
            z27 = z18;
            if (z27) {
            }
            if (businessFeedData.getFeedCommInfo() == null) {
            }
            z28 = true;
            MiscReportUtils.l(businessFeedData, z28);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public Resources i0() {
        return this.Z.getResources();
    }

    public void i1(View view, int i3, BusinessFeedData businessFeedData) {
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        int i16 = cellBottomRecomm.actiontype;
        if (i16 == 20) {
            this.V.n(businessFeedData, i3, BaseFeedPresenter.Y, R(businessFeedData, i3), view);
        } else {
            if (i16 != 22) {
                return;
            }
            this.W.xb(cellBottomRecomm.actionurl);
        }
    }

    public int j0() {
        return i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.title_bar_height);
    }

    public void k1() {
        CustomPraiseView customPraiseView = this.f45951e;
        if (customPraiseView != null) {
            customPraiseView.n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0322, code lost:
    
        if (r3 != 50) goto L177;
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0548  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void l1(com.qzone.proxy.feedcomponent.model.f fVar, BusinessFeedData businessFeedData, View view, boolean z16, String str, int i3) {
        CellPictureInfo pictureInfo;
        Map<Integer, String> map;
        ArrayList<PictureItem> arrayList;
        ArrayList arrayList2;
        PictureItem pictureItem;
        VideoInfo videoInfo;
        int i16;
        HashMap<String, Long> D0;
        Long l3;
        long longValue;
        int i17;
        String C0;
        String str2;
        PictureUrl pictureUrl;
        if (businessFeedData == null) {
            return;
        }
        if (!businessFeedData.isPublicAccountContent() && !businessFeedData.isPublicAccountShare()) {
            int a16 = fVar.a();
            BusinessFeedData originalInfoSafe = businessFeedData.getOriginalInfoSafe();
            int i18 = 0;
            if (businessFeedData.getPictureInfo() == null && originalInfoSafe.getPictureInfo() == null) {
                String str3 = null;
                if (businessFeedData.getVideoInfo() == null && originalInfoSafe.getVideoInfo() == null) {
                    if (originalInfoSafe.getMusicInfo() == null && businessFeedData.getMusicInfo() == null) {
                        if (originalInfoSafe.getLeftThumb() == null || originalInfoSafe.getLeftThumb().getPictureItem() == null || (pictureUrl = originalInfoSafe.getLeftThumb().getPictureItem().currentUrl) == null || TextUtils.isEmpty(pictureUrl.url)) {
                            return;
                        }
                        PictureViewerFactory.d0(T(), originalInfoSafe.getLeftThumb().getPictureItem());
                        return;
                    }
                    if (fVar.c()) {
                        if (originalInfoSafe.getMusicInfo() != null) {
                            str2 = originalInfoSafe.getMusicInfo().musicUrl;
                        }
                        str2 = null;
                    } else {
                        if (businessFeedData.getMusicInfo() != null) {
                            str2 = businessFeedData.getMusicInfo().musicUrl;
                        }
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.W.la(str2, null, null);
                    return;
                }
                if (fVar.c()) {
                    if (originalInfoSafe.getVideoInfo() != null && originalInfoSafe.getVideoInfo().videoUrl != null && !TextUtils.isEmpty(originalInfoSafe.getVideoInfo().videoUrl.url)) {
                        str3 = originalInfoSafe.getVideoInfo().videoUrl.url;
                        i18 = originalInfoSafe.getVideoInfo().actionType;
                    }
                } else if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoUrl != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().videoUrl.url)) {
                    str3 = businessFeedData.getVideoInfo().videoUrl.url;
                    i18 = businessFeedData.getVideoInfo().actionType;
                }
                if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(businessFeedData.getFeedCommInfo().orglikekey)) {
                    str3 = businessFeedData.getFeedCommInfo().orglikekey;
                }
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                u0(str3, businessFeedData, i18);
                return;
            }
            Q1(businessFeedData, a16);
            if (businessFeedData.isFakeFeedSafe() && businessFeedData.isLongPicsBrowsingModeFeed()) {
                pictureInfo = businessFeedData.getLongPicsCellPictureInfo() != null ? businessFeedData.getLongPicsCellPictureInfo() : businessFeedData.getOriginalInfoSafe().getLongPicsCellPictureInfo();
            } else {
                pictureInfo = businessFeedData.getPictureInfo() != null ? businessFeedData.getPictureInfo() : businessFeedData.getOriginalInfoSafe().getPictureInfo();
            }
            CellPictureInfo cellPictureInfo = pictureInfo;
            if (cellPictureInfo == null) {
                return;
            }
            R1(cellPictureInfo.pics, a16);
            ArrayList<PictureItem> arrayList3 = cellPictureInfo.pics;
            if (arrayList3 != null && arrayList3.size() > a16 && cellPictureInfo.pics.get(a16).videoflag == 1) {
                PictureItem pictureItem2 = cellPictureInfo.pics.get(a16);
                VideoInfo videoInfo2 = pictureItem2.videodata;
                if (videoInfo2 != null && videoInfo2.videoStatus == 1 && (C0 = QZoneWriteOperationService.v0().C0(videoInfo2.videoId)) != null) {
                    QLog.d("QZoneBaseFeedActivity", 2, "#\u540e\u53f0\u8f6c\u7801\u4e2d,onPhotoClick,cachPah=" + C0);
                    VideoInfo videoInfo3 = pictureItem2.videodata;
                    videoInfo3.isAutoPlay = true;
                    videoInfo3.videoStatus = 9;
                    pictureItem2.localFileUrl = C0;
                    videoInfo2.videoUrl = new VideoUrl(C0);
                }
                if (videoInfo2 != null && !TextUtils.isEmpty(videoInfo2.toast) && (((i17 = videoInfo2.videoStatus) != 3 || i17 != 6) && (TextUtils.isEmpty(pictureItem2.localFileUrl) || !new File(pictureItem2.localFileUrl).exists()))) {
                    ToastUtil.r(videoInfo2.toast);
                    return;
                }
            }
            ArrayList<PictureItem> arrayList4 = cellPictureInfo.pics;
            int min = Math.min(arrayList4 != null ? arrayList4.size() : 0, 9);
            if (!z16 && a16 == min - 1 && cellPictureInfo.uploadnum > min && !businessFeedData.getLocalInfo().isFake() && !businessFeedData.isLongPicsBrowsingModeFeed()) {
                z0(businessFeedData, cellPictureInfo);
                return;
            }
            if (businessFeedData.getLocalInfo().isFakeSafe()) {
                PictureViewerFactory.R(T(), cellPictureInfo, businessFeedData.getFeedCommInfo(), a16, 1204, true);
                return;
            }
            PhotoParam photoParam = new PhotoParam();
            photoParam.canAddFavor = (businessFeedData.getFeedCommInfo().operatemask & 131072) != 0;
            photoParam.appid = businessFeedData.getFeedCommInfo().appid;
            photoParam.ownerUin = businessFeedData.getUser().uin;
            photoParam.subid = businessFeedData.getFeedCommInfo().subid;
            photoParam.isLike = businessFeedData.getLikeInfo().isLiked;
            photoParam.likeNum = businessFeedData.getLikeInfo().likeNum;
            photoParam.commentNum = h0(businessFeedData);
            photoParam.feedId = businessFeedData.getFeedCommInfo().ugckey;
            photoParam.ugcKey = businessFeedData.getFeedCommInfo().ugckey;
            if (businessFeedData.getUser() != null && businessFeedData.getUser().famousSpaceMedal != null) {
                photoParam.qzoneUserType = businessFeedData.getUser().famousSpaceMedal.userTypeReport;
            }
            if (businessFeedData.getOriginalInfo().getUser().uin != 0) {
                photoParam.isSharedFeeds = true;
            } else {
                photoParam.isSharedFeeds = false;
            }
            photoParam.feedUin = businessFeedData.getUser().uin;
            photoParam.albumid = cellPictureInfo.albumid;
            photoParam.uploadnum = cellPictureInfo.uploadnum;
            photoParam.businessPhotoFeedIndex = this.V.S();
            photoParam.albumPriv = cellPictureInfo.albumrights;
            ArrayList<PictureItem> arrayList5 = cellPictureInfo.pics;
            photoParam.isOnePictureFeed = arrayList5 != null && arrayList5.size() == 1;
            photoParam.isTihFeed = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
            if (businessFeedData.getFeedCommInfo().recomtype == 7) {
                photoParam.isFriendPhotoBizFeed = true;
            }
            int i19 = businessFeedData.getFeedCommInfo().actiontype;
            if (i19 != 0) {
                if (i19 == 1) {
                    if (businessFeedData.getOriginalInfoSafe().getUser() != null) {
                        photoParam.ownerUin = businessFeedData.getOriginalInfoSafe().getUser().uin;
                    }
                    photoParam.appid = businessFeedData.getOriginalInfoSafe().getFeedCommInfo().appid;
                    photoParam.cell_id = businessFeedData.getOriginalInfoSafe().getIdInfo().cellId;
                    photoParam.cell_subId = businessFeedData.getOriginalInfoSafe().getIdInfo().subId;
                    photoParam.curKey = businessFeedData.getOriginalInfoSafe().getFeedCommInfo().curlikekey;
                    photoParam.orgKey = businessFeedData.getOriginalInfoSafe().getFeedCommInfo().orglikekey;
                } else {
                    if (i19 == 7) {
                        PictureViewerFactory.P(T(), cellPictureInfo, a16, 1204);
                        return;
                    }
                    if (i19 == 8 || i19 == 9) {
                        return;
                    }
                    if (i19 == 11) {
                        PictureViewerFactory.P(T(), cellPictureInfo, a16, 1204);
                        return;
                    } else if (i19 == 12) {
                        this.V.j0(businessFeedData, 1, false);
                        return;
                    }
                }
                map = businessFeedData.getOperationInfo().busiParam;
                if (map != null) {
                    photoParam.orgKey = c6.a.g(map.get(5), photoParam.orgKey);
                    photoParam.curKey = c6.a.g(map.get(6), photoParam.curKey);
                }
                photoParam.busi_param = map;
                if (this.U instanceof QZoneMyFeedFragment) {
                    User user = new User();
                    if (originalInfoSafe.getUser() != null) {
                        user.set(originalInfoSafe.getUser().uin, originalInfoSafe.getUser().nickName);
                    }
                    if (businessFeedData.getPictureInfo() != null) {
                        businessFeedData.getPictureInfo();
                    } else if (originalInfoSafe.getPictureInfo() != null) {
                        CellPictureInfo pictureInfo2 = originalInfoSafe.getPictureInfo();
                        if (pictureInfo2 != null) {
                            long j3 = pictureInfo2.uin;
                            if (j3 >= 10001 && j3 != user.uin) {
                                String str4 = (businessFeedData.getUser() == null || businessFeedData.getUser().uin != pictureInfo2.uin) ? "" : businessFeedData.getUser().nickName;
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = pictureInfo2.uin + "";
                                }
                                user.set(pictureInfo2.uin, str4);
                            }
                        }
                    } else {
                        e0(businessFeedData);
                    }
                }
                cellPictureInfo.allow_share = 1;
                photoParam.isVideoPicMix = businessFeedData.isMixVideoPic();
                arrayList = cellPictureInfo.pics;
                if (arrayList != null && arrayList.size() > a16 && cellPictureInfo.pics.get(a16).videoflag == 1) {
                    arrayList2 = new ArrayList(cellPictureInfo.pics);
                    pictureItem = (PictureItem) arrayList2.get(a16);
                    videoInfo = pictureItem.videodata;
                    if (videoInfo != null && !TextUtils.isEmpty(videoInfo.toast) && (((i16 = videoInfo.videoStatus) != 3 || i16 != 6) && !TextUtils.isEmpty(pictureItem.localFileUrl))) {
                        videoInfo.isAutoPlay = true;
                        videoInfo.videoStatus = 9;
                        if (videoInfo.videoUrl == null) {
                            videoInfo.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                        }
                        D0 = QZoneWriteOperationService.v0().D0(videoInfo.videoId);
                        if (D0 != null && D0.get("videoPlayStartTime") != null && D0.get("videoPlayEndTime") != null) {
                            l3 = D0.get("videoPlayStartTime");
                            longValue = D0.get("videoPlayEndTime").longValue() - l3.longValue();
                            if (l3.longValue() >= 0 && longValue > 0) {
                                pictureItem.videodata.videoId = "local_" + videoInfo.videoId + "#" + l3 + "#" + longValue;
                            }
                        }
                        PictureViewerFactory.S(T(), arrayList2, a16);
                        return;
                    }
                }
                PictureViewerFactory.L(T(), cellPictureInfo, businessFeedData.getFeedCommInfo(), a16, photoParam, 1204, businessFeedData.getUser().isSafeModeUser == 0);
                return;
            }
            photoParam.ownerUin = businessFeedData.getUser().uin;
            photoParam.appid = businessFeedData.getFeedCommInfo().appid;
            photoParam.cell_id = businessFeedData.getIdInfo().cellId;
            photoParam.cell_subId = businessFeedData.getIdInfo().subId;
            photoParam.curKey = businessFeedData.getFeedCommInfo().curlikekey;
            photoParam.orgKey = businessFeedData.getFeedCommInfo().orglikekey;
            map = businessFeedData.getOperationInfo().busiParam;
            if (map != null) {
            }
            photoParam.busi_param = map;
            if (this.U instanceof QZoneMyFeedFragment) {
            }
            cellPictureInfo.allow_share = 1;
            photoParam.isVideoPicMix = businessFeedData.isMixVideoPic();
            arrayList = cellPictureInfo.pics;
            if (arrayList != null) {
                arrayList2 = new ArrayList(cellPictureInfo.pics);
                pictureItem = (PictureItem) arrayList2.get(a16);
                videoInfo = pictureItem.videodata;
                if (videoInfo != null) {
                    videoInfo.isAutoPlay = true;
                    videoInfo.videoStatus = 9;
                    if (videoInfo.videoUrl == null) {
                    }
                    D0 = QZoneWriteOperationService.v0().D0(videoInfo.videoId);
                    if (D0 != null) {
                        l3 = D0.get("videoPlayStartTime");
                        longValue = D0.get("videoPlayEndTime").longValue() - l3.longValue();
                        if (l3.longValue() >= 0) {
                            pictureItem.videodata.videoId = "local_" + videoInfo.videoId + "#" + l3 + "#" + longValue;
                        }
                    }
                    PictureViewerFactory.S(T(), arrayList2, a16);
                    return;
                }
            }
            PictureViewerFactory.L(T(), cellPictureInfo, businessFeedData.getFeedCommInfo(), a16, photoParam, 1204, businessFeedData.getUser().isSafeModeUser == 0);
            return;
        }
        p1(businessFeedData);
    }

    public void m0(User user, CellFunnyTreadSpace cellFunnyTreadSpace) {
        long nanoTime = System.nanoTime();
        long j3 = this.f45950d0;
        if (j3 == -1 || nanoTime - j3 >= 1000000000) {
            this.f45950d0 = nanoTime;
            if (user != null) {
                ho.i.z().s(T(), user);
            } else {
                ho.i.z().r(T(), LoginData.getInstance().getUin());
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:56:0x01a7. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1233:0x1a3e  */
    /* JADX WARN: Removed duplicated region for block: B:1238:0x1a55  */
    /* JADX WARN: Removed duplicated region for block: B:1861:0x27a9  */
    /* JADX WARN: Removed duplicated region for block: B:1866:0x27b9  */
    /* JADX WARN: Removed duplicated region for block: B:1881:0x27fe  */
    /* JADX WARN: Removed duplicated region for block: B:1886:0x2815  */
    /* JADX WARN: Removed duplicated region for block: B:1961:0x2c71  */
    /* JADX WARN: Removed duplicated region for block: B:1962:0x2c78  */
    /* JADX WARN: Removed duplicated region for block: B:2279:0x312f  */
    /* JADX WARN: Removed duplicated region for block: B:2570:0x36dd  */
    /* JADX WARN: Removed duplicated region for block: B:2573:0x36f0  */
    /* JADX WARN: Removed duplicated region for block: B:2575:0x36f9  */
    /* JADX WARN: Type inference failed for: r15v50 */
    /* JADX WARN: Type inference failed for: r15v51, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v52 */
    @Override // com.qzone.proxy.feedcomponent.ui.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view, FeedElement feedElement, int i3, Object obj) {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        boolean z16;
        boolean z17;
        String str;
        int i16;
        ArrayList<Comment> arrayList;
        Comment comment;
        LpReportInfo_pf00064 lpReportInfo_pf00064;
        CellFollowGuide cellFollowGuide;
        int i17;
        Map<String, String> map;
        int i18;
        GuideButton guideButton;
        BusinessFeedData businessFeedData3;
        CellGuiding cellGuiding;
        GuideButton guideButton2;
        LpReportInfo_pf00064 lpReportInfo_pf000642;
        String str2;
        Activity T;
        String str3;
        boolean z18;
        LpReportInfo_pf00064 lpReportInfo_pf000643;
        CellRemarkInfo remarkInfoV2;
        String str4;
        int i19;
        String str5;
        com.qzone.proxy.feedcomponent.model.f fVar;
        CellPictureInfo cellPictureInfo;
        String str6;
        BusinessFeedData businessFeedData4;
        String str7;
        int i26;
        CellPictureInfo cellPictureInfo2;
        String str8;
        CellPictureInfo cellPictureInfo3;
        String str9;
        BusinessFeedData businessFeedData5;
        CellDecorateInfo.CellPolymorphicPraise cellPolymorphicPraise;
        NetImageCell netImageCell;
        int i27;
        long j3;
        Rect cellPosition;
        String str10;
        String str11;
        HashMap hashMap;
        String str12;
        String str13;
        int i28;
        boolean z19;
        int n3;
        String str14;
        int i29;
        BusinessFeedData businessFeedData6;
        int i36;
        int i37;
        ?? r152;
        boolean z26;
        int i38;
        View view2;
        int i39;
        int i46;
        int i47;
        int i48;
        BusinessFeedData businessFeedData7;
        int i49;
        int i56;
        List<String> list;
        View findViewById;
        boolean z27;
        int i57;
        BaseFeedPresenter baseFeedPresenter;
        BaseFeedPresenter baseFeedPresenter2;
        Map<String, String> map2;
        BusinessFeedData businessFeedData8;
        boolean z28;
        String str15;
        boolean z29;
        int i58;
        boolean z36;
        int i59;
        int i65;
        View findViewById2;
        int i66;
        BusinessFeedData businessFeedData9;
        BusinessFeedData businessFeedData10;
        int i67;
        int i68;
        int i69;
        Map<String, String> map3;
        int i75;
        int i76;
        int i77;
        FeedSkinData cellFeedSkinInfo;
        FeedSkinData cellFeedSkinInfo2;
        User user;
        UserMedal userMedal;
        User user2;
        UserMedal userMedal2;
        int i78;
        String str16;
        BusinessFeedData businessFeedData11;
        long j16;
        int i79;
        int i85;
        boolean z37;
        long m3;
        CellLive cellLive;
        Object obj2;
        int i86;
        String str17;
        HashMap hashMap2;
        BusinessFeedData businessFeedData12;
        d5.h wi5;
        d5.h wi6;
        CellUserInfo cellUserInfo;
        User user3;
        CellUserInfo cellUserInfo2;
        User user4;
        String str18;
        BusinessFeedData businessFeedData13;
        if (com.qzone.util.h.b(feedElement)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Activity] ");
        sb5.append(this.E);
        sb5.append("  OnFeedElementClick ");
        sb5.append("view  id:");
        sb5.append(Integer.toHexString(view != null ? view.getId() : 0));
        sb5.append(" element:");
        sb5.append(feedElement);
        RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
        BaseFeedPresenter baseFeedPresenter3 = this.V;
        if (baseFeedPresenter3 == null) {
            QLog.e("FeedClickProcessor", 4, "[onClick] baseFeedPresenter is null, return");
            return;
        }
        BusinessFeedData businessFeedData14 = (BusinessFeedData) baseFeedPresenter3.F(i3, true);
        BusinessFeedData g06 = g0(view, businessFeedData14, feedElement, obj);
        z(view, g06);
        if (this.U instanceof QZoneMyFeedFragment) {
            businessFeedData = g06;
            businessFeedData2 = businessFeedData14;
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onUserActionReportCickListener(view, feedElement, g06, i3, obj, ap.a());
        } else {
            businessFeedData = g06;
            businessFeedData2 = businessFeedData14;
        }
        BusinessFeedData f16 = c6.a.f(businessFeedData, feedElement);
        if (f16 == null) {
            return;
        }
        if (FeedElement.ACTION_BUTTON.equals(feedElement)) {
            V1(f16, i3, view);
        }
        this.T = new r(f16);
        if (!f5.a.b(this.W, f16, feedElement)) {
            if (f16.isGDTAdvFeed()) {
                QLog.i("FeedClickProcessor", 4, "[GdtClickHandlerForQzone] use new click handler for tangram ad");
                d5.u uVar = this.Z;
                Activity activity = uVar != null ? uVar.getActivity() : null;
                if (activity instanceof BasePluginActivity) {
                    activity = ((BasePluginActivity) activity).getOutActivity();
                }
                a.b bVar = new a.b();
                bVar.f401410c = 0;
                bVar.f401408a = new WeakReference<>(activity);
                bVar.f401413f = new WeakReference<>(this.T);
                bVar.f401412e = feedElement;
                bVar.f401414g = new WeakReference<>(view);
                bVar.f401409b = f16;
                g6.a.g(bVar);
                if (f16.isGDTAdvFeed()) {
                    GdtPreLoadOfflineHelper.f46190c.d();
                    return;
                }
                return;
            }
            QLog.i("FeedClickProcessor", 4, "[GdtClickHandlerForQzone] use old click handler for tangram ad");
            GdtFeedUtilForQZone.A(new AdClickData.Builder().setContext(this.Z.getActivity()).setFeedData(f16).setSceneId(0).setView(view).setFeedElement(feedElement).setFeedIndex(i3).setArgs(obj).create());
            if (f16.isGDTAdvFeed()) {
                GdtPreLoadOfflineHelper.f46190c.d();
            }
        }
        f16.getAdData();
        if (f16.isGDTAdvFeed()) {
            QZoneAdFeedDataExtKt.setIsGdtVideoClickedForPlayReport(f16, true);
        }
        if ((!QZoneAdFeedDataExtKt.isMiniAppGdtAdv(f16) && !QZoneAdFeedDataExtKt.isGdt585AdVideo(f16)) || (feedElement != FeedElement.AUTO_VIDEO && feedElement != FeedElement.AUTO_VIDEO_CLICK)) {
            if (f16.getFeedCommInfo() != null) {
                z16 = f16.getFeedCommInfo().isLikeRecommFamousFeed();
                z17 = f16.isCircleFriendLikeVideoRecomm();
            } else {
                z16 = false;
                z17 = false;
            }
            if (z16 && z17 && E(feedElement, f16, view)) {
                return;
            }
            this.f45946a0 = feedElement;
            str = "";
            switch (ad.f45995a[feedElement.ordinal()]) {
                case 1:
                    int i87 = 3;
                    int i88 = f16.feedType;
                    if (i88 == 3) {
                        i16 = 308;
                        i87 = 81;
                    } else if (i88 == 4099) {
                        i16 = LpReportInfoConfig.ACTION_TYPE_MOOD_LIST;
                    } else {
                        i87 = 87;
                        i16 = 302;
                    }
                    LpReportInfo_pf00064.allReport(i16, i87, 2);
                    CellCommentInfo commentInfoV2 = f16.getCommentInfoV2();
                    if (commentInfoV2 != null && (arrayList = commentInfoV2.commments) != null && arrayList.size() > 0 && (comment = arrayList.get(0)) != null && !TextUtils.isEmpty(comment.commentid)) {
                        TextCellLayout.setJumpCmtId(comment.commentid);
                    }
                    if (this.V.D() != null) {
                        this.V.D().Wa(f16, 13, 0L, i3);
                    }
                    U1(f16, 16);
                    S1(f16, 2);
                    return;
                case 2:
                    ClickReport.p("644", "2", "", null, true);
                    this.W.mh(((User) obj).uin, 0, R(f16, i3));
                    return;
                case 3:
                    CellShareCard cellShareCard = f16.cellShareCard;
                    if (cellShareCard != null) {
                        int i89 = cellShareCard.action_type;
                        if (i89 == 2 || i89 == 20) {
                            this.W.Vc(cellShareCard.action_url);
                        }
                        ClickReport.p("690", "2", (f16.getFeedCommInfo().extendInfo == null || !f16.getFeedCommInfo().extendInfo.containsKey("campus_share_type")) ? "0" : f16.getFeedCommInfo().extendInfo.get("campus_share_type"), null, true);
                        return;
                    }
                    return;
                case 4:
                    if (obj instanceof CellViewMore) {
                        CellViewMore cellViewMore = (CellViewMore) obj;
                        if (TextUtils.isEmpty(cellViewMore.jump_url)) {
                            return;
                        }
                        this.W.Vc(cellViewMore.jump_url);
                        if (f16.isCardSchoolRecommendContainerFeed()) {
                            lpReportInfo_pf00064 = new LpReportInfo_pf00064("650", "5");
                        } else {
                            lpReportInfo_pf00064 = f16.isCardFollowMoreRecommendContainerFeed() ? new LpReportInfo_pf00064("645", "5") : null;
                        }
                        if (lpReportInfo_pf00064 != null) {
                            lpReportInfo_pf00064.reserves3 = cellViewMore.jump_url;
                            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    Object[] objArr = (Object[]) obj;
                    this.V.i0((com.qzone.proxy.feedcomponent.widget.d) objArr[1]);
                    PicText picText = (PicText) objArr[2];
                    e8.f.a().b().c((String) objArr[0], null, picText.title, null, null, picText.actionUrl);
                    LpReportInfo_pf00064.report(442, 19);
                    return;
                case 6:
                    if (f16.cellFollowGuide != null) {
                        AbsFeedView absFeedView = (AbsFeedView) view.getParent();
                        if (f16.cellFollowGuide.getStatus() == 0) {
                            if (f16.cellFollowGuide.getUnreadFollowFeeds() != null) {
                                f16.cellFollowGuide.setStatus(2);
                                absFeedView.updateFollowGuide();
                                com.qzone.feed.business.service.a a06 = a0();
                                if (a06 != null) {
                                    a06.K();
                                }
                            } else if (NetworkState.isNetSupport()) {
                                f16.cellFollowGuide.setStatus(1);
                                absFeedView.updateFollowGuide();
                                com.qzone.feed.business.service.a a07 = a0();
                                if (a07 != null) {
                                    a07.G(f16);
                                }
                            } else {
                                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 4);
                            }
                            TTTReportManager.s().h(12, 66, 32, System.currentTimeMillis(), f16, i3, true);
                            return;
                        }
                        if (f16.cellFollowGuide.getStatus() == 2) {
                            f16.cellFollowGuide.setStatus(0);
                            absFeedView.updateFollowGuide();
                            com.qzone.feed.business.service.a a08 = a0();
                            if (a08 != null) {
                                a08.K();
                            }
                            TTTReportManager.s().h(12, 66, 33, System.currentTimeMillis(), f16, i3, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    D0(f16);
                    return;
                case 8:
                    CellFollowGuide cellFollowGuide2 = f16.cellFollowGuide;
                    if (cellFollowGuide2 != null) {
                        int i95 = cellFollowGuide2.action_type;
                        if (i95 == 2 || i95 == 20) {
                            this.W.la(cellFollowGuide2.action_url, null, null);
                            LpReportInfo_pf00064.allReport(f16.cellFollowGuide.feed_type == 1 ? 114 : 113, 2, f16.feedType == 3 ? 1 : 2);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    if (view == null || (cellFollowGuide = f16.cellFollowGuide) == null) {
                        return;
                    }
                    if (cellFollowGuide.feed_type == 1) {
                        QZoneFeedUtil.j0(System.currentTimeMillis());
                        i17 = 114;
                    } else {
                        QZoneFeedUtil.k0(System.currentTimeMillis());
                        i17 = 113;
                    }
                    LpReportInfo_pf00064.allReport(i17, 3, f16.feedType == 3 ? 1 : 2);
                    view.setVisibility(8);
                    return;
                case 10:
                case 149:
                case 155:
                    return;
                case 11:
                    if (!(obj instanceof CellGuiding) || (map = ((CellGuiding) obj).extendInfo) == null) {
                        return;
                    }
                    this.W.Vc(map.get("pic_action_url"));
                    return;
                case 12:
                    if (obj instanceof CellGuiding) {
                        CellGuiding cellGuiding2 = (CellGuiding) obj;
                        ArrayList<GuideButton> arrayList2 = cellGuiding2.vecButton;
                        if (arrayList2 != null && arrayList2.size() > 0 && (guideButton = cellGuiding2.vecButton.get(0)) != null) {
                            this.W.Vc(guideButton.actionUrl);
                        }
                        if (cellGuiding2.guiding_type == 5) {
                            Map<String, String> map4 = cellGuiding2.extendInfo;
                            if (map4 != null) {
                                String str19 = map4.get("sub_guide_type");
                                if (!TextUtils.isEmpty(str19)) {
                                    try {
                                        i18 = Integer.valueOf(str19).intValue() == 1 ? 5 : 3;
                                    } catch (Exception unused) {
                                    }
                                    LpReportInfo_pf00064.allReport(619, 15, i18);
                                    return;
                                }
                            }
                            i18 = 3;
                            LpReportInfo_pf00064.allReport(619, 15, i18);
                            return;
                        }
                        ArrayList<User> arrayList3 = cellGuiding2.vecUsers;
                        if (arrayList3 != null) {
                            if (arrayList3.size() > 2) {
                                LpReportInfo_pf00064.allReport(619, 13, 3, "");
                                return;
                            }
                            Iterator<User> it = cellGuiding2.vecUsers.iterator();
                            while (it.hasNext()) {
                                User next = it.next();
                                if (next != null) {
                                    long uin = LoginData.getInstance().getUin();
                                    long j17 = next.uin;
                                    if (uin != j17) {
                                        LpReportInfo_pf00064.allReport(619, 7, 3, String.valueOf(j17));
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    if (!(obj instanceof BusinessFeedData) || (cellGuiding = (businessFeedData3 = (BusinessFeedData) obj).getCellGuiding()) == null) {
                        return;
                    }
                    ArrayList<GuideButton> arrayList4 = cellGuiding.vecButton;
                    if (arrayList4 != null && arrayList4.size() > 1 && (guideButton2 = cellGuiding.vecButton.get(1)) != null) {
                        gh.b.a(T(), guideButton2.actionUrl, businessFeedData3);
                    }
                    if (cellGuiding.guiding_type == 5) {
                        LpReportInfo_pf00064.allReport(619, 15, 4);
                        return;
                    }
                    ArrayList<User> arrayList5 = cellGuiding.vecUsers;
                    if (arrayList5 != null) {
                        Iterator<User> it5 = arrayList5.iterator();
                        while (it5.hasNext()) {
                            User next2 = it5.next();
                            if (next2 != null) {
                                long uin2 = LoginData.getInstance().getUin();
                                long j18 = next2.uin;
                                if (uin2 != j18) {
                                    LpReportInfo_pf00064.allReport(619, 7, 2, String.valueOf(j18));
                                }
                            }
                        }
                        return;
                    }
                    return;
                case 14:
                    if (obj instanceof CellGuiding) {
                        CellGuiding cellGuiding3 = (CellGuiding) obj;
                        String str20 = cellGuiding3.action_url;
                        if (URLUtil.isNetworkUrl(str20)) {
                            str20 = yo.f.b(str20, "from", "2");
                        }
                        this.W.Vc(str20);
                        MiscReportUtils.k(cellGuiding3, "report_click_button");
                        MiscReportUtils.b(cellGuiding3);
                        return;
                    }
                    return;
                case 15:
                case 16:
                    if (obj instanceof BusinessFeedData) {
                        BusinessFeedData businessFeedData15 = (BusinessFeedData) obj;
                        String str21 = businessFeedData15.getFeedCommInfo().actionurl;
                        if (TextUtils.isEmpty(str21)) {
                            str21 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SECRET_SHUOSHUO, QzoneConfig.SECONDARY_SECRET_FEED_DETAIL_H5_URL, QzoneConfig.DefaultValue.DEFAULT_SECRET_FEED_DETAIL_H5_URL);
                        }
                        if (businessFeedData15.getLocalInfoV2() != null && businessFeedData15.getLocalInfoV2().fakeType == 0) {
                            return;
                        }
                        this.W.Vc(str21);
                        LpReportInfo_pf00064.allReport(302, 71, 1);
                        Iterator<Integer> it6 = businessFeedData15.getSecretFeedLpReserves().iterator();
                        while (it6.hasNext()) {
                            LpReportInfo_pf00064.allReport(302, 71, it6.next().intValue());
                        }
                        return;
                    }
                    return;
                case 17:
                    this.W.Vc(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SECRET_SHUOSHUO, QzoneConfig.SECONDARY_SECRET_FEED_LIST_H5_URL, QzoneConfig.DefaultValue.DEFAULT_SECRET_FEED_LIST_H5_URL));
                    LpReportInfo_pf00064.allReport(302, 70);
                    return;
                case 18:
                    if (f16.getCellAdvContainerAttach() != null) {
                        F(f16, i3, view);
                        return;
                    }
                    return;
                case 19:
                    if (obj == null || !(obj instanceof Object[])) {
                        return;
                    }
                    Object[] objArr2 = (Object[]) obj;
                    ArrayList<String> arrayList6 = (ArrayList) objArr2[0];
                    User user5 = (User) objArr2[1];
                    if (f16.getOperationInfoV2() != null && f16.getOperationInfoV2().busiParam != null) {
                        com.qzone.feed.business.model.c.d().f(3, f16.getOperationInfoV2().busiParam.get(92), arrayList6, 9);
                    }
                    if (f16.isCardSchoolRecommendContainerFeed()) {
                        LpReportInfo_pf00064 lpReportInfo_pf000644 = new LpReportInfo_pf00064("650", "7");
                        if (user5 != null) {
                            lpReportInfo_pf000644.reserves4 = Integer.toString(user5.curUserType);
                        }
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000644, false, false);
                        return;
                    }
                    if (f16.isCardSpecialFollowMoreRecommendContainerFeed()) {
                        LpReportInfo_pf00064 lpReportInfo_pf000645 = new LpReportInfo_pf00064("721", "6");
                        if (user5 != null) {
                            lpReportInfo_pf000645.reserves4 = Integer.toString(user5.curUserType);
                        }
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000645, false, false);
                        return;
                    }
                    return;
                case 20:
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().busiParam == null || obj == null || !(obj instanceof Object[])) {
                        return;
                    }
                    String str22 = f16.getOperationInfoV2().busiParam.get(92);
                    Object[] objArr3 = (Object[]) obj;
                    BusinessFeedData businessFeedData16 = (BusinessFeedData) objArr3[0];
                    int intValue = ((Integer) objArr3[1]).intValue();
                    int intValue2 = ((Integer) objArr3[2]).intValue();
                    if (businessFeedData16 != null && businessFeedData16.getOperationInfoV2() != null && businessFeedData16.getOperationInfoV2().busiParam != null) {
                        ArrayList<String> arrayList7 = new ArrayList<>();
                        arrayList7.add(businessFeedData16.getOperationInfoV2().busiParam.get(52));
                        com.qzone.feed.business.model.c.d().f(4, str22, arrayList7, 9);
                    }
                    if (f16.isCardSchoolRecommendContainerFeed()) {
                        lpReportInfo_pf000642 = new LpReportInfo_pf00064("650", "4");
                    } else if (f16.isCardFollowMoreRecommendContainerFeed()) {
                        lpReportInfo_pf000642 = new LpReportInfo_pf00064("645", "4");
                    } else {
                        lpReportInfo_pf000642 = f16.isCardSpecialFollowMoreRecommendContainerFeed() ? new LpReportInfo_pf00064("721", "4") : null;
                    }
                    G1(businessFeedData16, intValue, intValue2);
                    if (lpReportInfo_pf000642 != null) {
                        if (businessFeedData16 != null && businessFeedData16.getRecommItem() != null && businessFeedData16.getRecommItem().userInfo != null) {
                            lpReportInfo_pf000642.reserves4 = Integer.toString(businessFeedData16.getRecommItem().userInfo.curUserType);
                        }
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000642, false, false);
                        return;
                    }
                    return;
                case 21:
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().busiParam == null || obj == null || !(obj instanceof Object[])) {
                        return;
                    }
                    String str23 = f16.getOperationInfoV2().busiParam.get(92);
                    Object[] objArr4 = (Object[]) obj;
                    BusinessFeedData businessFeedData17 = (BusinessFeedData) objArr4[0];
                    int intValue3 = ((Integer) objArr4[1]).intValue();
                    int intValue4 = ((Integer) objArr4[2]).intValue();
                    if (businessFeedData17 != null && businessFeedData17.getOperationInfoV2() != null && businessFeedData17.getOperationInfoV2().busiParam != null) {
                        ArrayList<String> arrayList8 = new ArrayList<>();
                        arrayList8.add(businessFeedData17.getOperationInfoV2().busiParam.get(52));
                        com.qzone.feed.business.model.c.d().f(4, str23, arrayList8, 6);
                    }
                    G1(businessFeedData17, intValue3, intValue4);
                    return;
                case 22:
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().busiParam == null || !(obj instanceof BusinessFeedData)) {
                        return;
                    }
                    String str24 = f16.getOperationInfoV2().busiParam.get(92);
                    BusinessFeedData businessFeedData18 = (BusinessFeedData) obj;
                    if (businessFeedData18 == null || businessFeedData18.getOperationInfoV2() == null || businessFeedData18.getOperationInfoV2().busiParam == null) {
                        return;
                    }
                    ArrayList<String> arrayList9 = new ArrayList<>();
                    arrayList9.add(businessFeedData18.getOperationInfoV2().busiParam.get(52));
                    com.qzone.feed.business.model.c.d().f(4, str24, arrayList9, 11);
                    return;
                case 23:
                    this.V.n(f16, i3, 0, R(f16, i3), view);
                    return;
                case 24:
                    User user6 = f16.getUser();
                    if (user6 == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, 1);
                    intent.putExtra("uin", user6.uin);
                    intent.putExtra("nickname", user6.nickName);
                    Map<Integer, String> map5 = f16.getOperationInfo().feedReportCookie;
                    if (map5 != null) {
                        intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_EXTEND_FRIEND_CAMPUS_ALGORITHM_ID, map5.get(43));
                    }
                    View findViewById3 = T().findViewById(com.tencent.mobileqq.R.id.ikd);
                    if (findViewById3 instanceof ExpandHorizontalTagsView) {
                        ExpandHorizontalTagsView expandHorizontalTagsView = (ExpandHorizontalTagsView) findViewById3;
                        int childCount = expandHorizontalTagsView.getChildCount();
                        int i96 = expandHorizontalTagsView.f264255d;
                        if (childCount > i96) {
                            View childAt = expandHorizontalTagsView.getChildAt(i96);
                            if (childAt instanceof TextView) {
                                CharSequence text = ((TextView) childAt).getText();
                                if (!TextUtils.isEmpty(text)) {
                                    str2 = text.toString();
                                    intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_EXTEND_FRIEND_CAMPUS_CURRENT_TAB, str2);
                                    T = T();
                                    if (T instanceof BasePluginActivity) {
                                        T = ((BasePluginActivity) T).getOutActivity();
                                    }
                                    PublicFragmentActivity.b.d(T, intent, PublicTransFragmentActivity.class, QZoneNavigateToQQTransparentFragment.class, 0);
                                    if (!f16.isEnableLimitChat()) {
                                        ap.f59791b.e(218, 1, i3, f16);
                                        return;
                                    } else {
                                        ap.f59791b.e(219, 1, i3, f16);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    str2 = "\u63a8\u8350";
                    intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_EXTEND_FRIEND_CAMPUS_CURRENT_TAB, str2);
                    T = T();
                    if (T instanceof BasePluginActivity) {
                    }
                    PublicFragmentActivity.b.d(T, intent, PublicTransFragmentActivity.class, QZoneNavigateToQQTransparentFragment.class, 0);
                    if (!f16.isEnableLimitChat()) {
                    }
                case 25:
                    if (!com.qzone.feed.business.model.c.d().a() || f16.getFeedCommInfo().isFriendAdded) {
                        str3 = "2";
                        z18 = true;
                    } else {
                        com.qzone.feed.business.model.c.d().e(f16, f16.getUser().uin, i3);
                        str3 = "2";
                        z18 = true;
                        w(T(), f16.getUser().uin, 3069, 21);
                    }
                    ClickReport.q("22", str3, "", z18);
                    return;
                case 26:
                    if (obj == null || !(obj instanceof Object[])) {
                        return;
                    }
                    Object[] objArr5 = (Object[]) obj;
                    long longValue = ((Long) objArr5[0]).longValue();
                    BusinessFeedData businessFeedData19 = (BusinessFeedData) objArr5[1];
                    int intValue5 = ((Integer) objArr5[2]).intValue();
                    if (com.qzone.feed.business.model.c.d().a()) {
                        com.qzone.feed.business.model.c.d().e(businessFeedData19, longValue, intValue5);
                        w(T(), longValue, 3070, 21);
                        LpReportInfo_pf00064.allReport(619, 10, 2, String.valueOf(longValue));
                        return;
                    }
                    return;
                case 27:
                    if (obj == null || !(obj instanceof Object[])) {
                        return;
                    }
                    Object[] objArr6 = (Object[]) obj;
                    long longValue2 = ((Long) objArr6[0]).longValue();
                    BusinessFeedData businessFeedData20 = (BusinessFeedData) objArr6[1];
                    int intValue6 = ((Integer) objArr6[2]).intValue();
                    int intValue7 = ((Integer) objArr6[3]).intValue();
                    if (businessFeedData20 != null) {
                        QZoneWriteOperationService.v0().p0(longValue2, !businessFeedData20.getFeedCommInfo().isFollowed, f16.isCardFollowMoreRecommendContainerFeed() ? 20 : 22, this.V.E(), businessFeedData20.getFeedCommInfo().feedskey, i3, businessFeedData20.getFeedCommInfo().needAdvReport(), businessFeedData20.getOperationInfo().cookie, businessFeedData20.getFeedCommInfo().isInstalled, businessFeedData20, false, 0);
                        if (businessFeedData20.getFeedCommInfo() != null) {
                            boolean z38 = !businessFeedData20.getFeedCommInfo().isFollowed;
                            if (f16.isCardSchoolRecommendContainerFeed()) {
                                lpReportInfo_pf000643 = new LpReportInfo_pf00064("650", z38 ? "2" : "3");
                                H1(businessFeedData20, z38, intValue6, intValue7);
                            } else if (f16.isCardFollowMoreRecommendContainerFeed()) {
                                lpReportInfo_pf000643 = new LpReportInfo_pf00064("645", z38 ? "2" : "3");
                                H1(businessFeedData20, z38, intValue6, intValue7);
                            } else {
                                H1(businessFeedData20, z38, intValue6, intValue7);
                                lpReportInfo_pf000643 = null;
                            }
                            if (lpReportInfo_pf000643 != null) {
                                lpReportInfo_pf000643.reserves2 = Integer.toString(intValue7 + 1);
                                if (businessFeedData20.getRecommItem() != null && businessFeedData20.getRecommItem().userInfo != null) {
                                    lpReportInfo_pf000643.reserves4 = Integer.toString(businessFeedData20.getRecommItem().userInfo.curUserType);
                                }
                                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000643, false, false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 28:
                    A1(f16, obj, i3);
                    return;
                case 29:
                    H0(view, f16, obj, i3);
                    return;
                case 30:
                    n0();
                    if (f16.isCardFriendsRecommendContainerFeed()) {
                        LpReportInfo_pf00064.allReport(619, 10, 4);
                        return;
                    }
                    return;
                case 31:
                    if (f16.isSubFeed && !f16.isSubOfSingleAdvContainerFeed() && !f16.disPlayed) {
                        this.V.v0(view, f16, i3, 0, f16.getOperationInfo().actionType, 0);
                        f16.disPlayed = true;
                    }
                    this.V.y0(view, f16, i3, f16.isAttach() ? 30 : 25, f16.getOperationInfo().actionType, 0, null, 1, 8);
                    return;
                case 32:
                    if (f16.getVideoInfo() == null || f16.getVideoInfo().videoRemark == null) {
                        return;
                    }
                    VideoInfo.VideoRemark videoRemark = f16.getVideoInfo().videoRemark;
                    if (2 == videoRemark.actiontype) {
                        this.W.la(videoRemark.actionurl, null, null);
                        return;
                    }
                    return;
                case 33:
                    if (f16.getRemarkInfoV2() != null) {
                        remarkInfoV2 = f16.getRemarkInfoV2();
                    } else {
                        remarkInfoV2 = (f16.getOriginalInfo() == null || f16.getOriginalInfo().getRemarkInfoV2() == null) ? null : f16.getOriginalInfoSafe().getRemarkInfoV2();
                    }
                    if (remarkInfoV2 == null || remarkInfoV2.action_type != 2) {
                        return;
                    }
                    this.W.la(remarkInfoV2.action_url, null, null);
                    if (f16.getCellLuckyMoney() == null && (f16.getOriginalInfo() == null || f16.getOriginalInfo().getCellLuckyMoney() == null)) {
                        return;
                    }
                    ClickReport.q("566", "11", "", true);
                    return;
                case 34:
                    CellLeftThumb cellLeftThumb = (CellLeftThumb) obj;
                    if (cellLeftThumb != null) {
                        Y0(view, f16, cellLeftThumb, i3, true);
                        return;
                    }
                    return;
                case 35:
                    CellLeftThumb cellLeftThumb2 = (CellLeftThumb) obj;
                    if (cellLeftThumb2 != null) {
                        Y0(view, f16, cellLeftThumb2, i3, false);
                        if (f16.getUser().uin != 88882222 || f16.getLeftThumb() == null || TextUtils.isEmpty(f16.getLeftThumb().getActionUrl())) {
                            return;
                        }
                        LpReportInfo_pf00064.allReport(701, 2, 0, (String) null, f16.getLeftThumb().getActionUrl());
                        return;
                    }
                    return;
                case 36:
                    h1((Integer) obj, Integer.valueOf(i3), f16);
                    U1(f16, 16);
                    return;
                case 37:
                    this.V.o0(f16, i3, false, view);
                    return;
                case 38:
                    if (view != null) {
                        view.requestLayout();
                        return;
                    }
                    return;
                case 39:
                    if (obj != null) {
                        Integer num = (Integer) obj;
                        String str25 = f16.getPicTextInfo().picTexts.get(num.intValue()).actionUrl;
                        if (!TextUtils.isEmpty(str25)) {
                            vo.c.a(Z(), str25);
                        }
                        if (num.intValue() != 1 || f16.getOperationInfo() == null) {
                            return;
                        }
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(f16.getOperationInfo().qbossTrace, null);
                        return;
                    }
                    return;
                case 40:
                    this.V.h0();
                    String str26 = (String) obj;
                    if (TextUtils.isEmpty(str26)) {
                        return;
                    }
                    this.V.y().startActivity(e8.f.a().c().i(Long.valueOf(str26).longValue()));
                    return;
                case 41:
                    W0(i3);
                    return;
                case 42:
                    if (f16.getFeedCommInfo() == null || f16.getFeedCommInfo().actiontype != 2 || TextUtils.isEmpty(f16.getFeedCommInfo().actionurl)) {
                        return;
                    }
                    yo.d.d(f16.getFeedCommInfo().actionurl, U(), null);
                    if (com.qzone.proxy.feedcomponent.util.d.j(f16.getFeedCommInfo().operatemask2, 11) && (this.U instanceof QZoneMyFeedFragment)) {
                        LpReportInfo_pf00064.allReport(303, 12, 3);
                        return;
                    }
                    return;
                case 43:
                    QZoneBaseFeedFragment qZoneBaseFeedFragment = this.U;
                    if (qZoneBaseFeedFragment instanceof QZoneMyFeedFragment) {
                        ((QZoneMyFeedFragment) qZoneBaseFeedFragment).ak(f16);
                        return;
                    }
                    return;
                case 44:
                    if (f16.getOperationInfo() != null) {
                        StringBuilder sb6 = new StringBuilder();
                        CellOperationInfo operationInfo = f16.getOperationInfo();
                        sb6.append(operationInfo.actionUrl);
                        sb6.append("&auto_download=1");
                        operationInfo.actionUrl = sb6.toString();
                    }
                    this.V.n(f16, i3, BaseFeedPresenter.U, R(f16, i3), view);
                    return;
                case 45:
                    this.V.n(f16, i3, BaseFeedPresenter.U, R(f16, i3), view);
                    return;
                case 46:
                    vo.c.m(T());
                    return;
                case 47:
                    CellFeedSignature cellFeedSignature = f16.cellFeedSignature;
                    if (cellFeedSignature == null || TextUtils.isEmpty(cellFeedSignature.strJumpUrl)) {
                        return;
                    }
                    yo.d.d(f16.cellFeedSignature.strJumpUrl, T(), null);
                    return;
                case 48:
                    if (obj == null || !(obj instanceof com.qzone.proxy.feedcomponent.model.f)) {
                        return;
                    }
                    CellPictureInfo pictureInfo = f16.getPictureInfo();
                    if (pictureInfo == null) {
                        pictureInfo = f16.getOriginalInfoSafe().getPictureInfo();
                    }
                    m1(pictureInfo);
                    return;
                case 49:
                    if (!(obj instanceof ViewFeedPhotoData)) {
                        QLog.e("FeedClickProcessor", 1, "data type is wrong");
                        return;
                    }
                    ViewFeedPhotoData viewFeedPhotoData = (ViewFeedPhotoData) obj;
                    rk.d dVar = new rk.d();
                    dVar.v(viewFeedPhotoData.pictureInfo);
                    dVar.g(viewFeedPhotoData.curIndex);
                    dVar.i(1204);
                    ((rk.e) ho.i.t(rk.e.class)).A(T(), dVar);
                    return;
                case 50:
                    boolean z39 = true;
                    if (obj == null) {
                        return;
                    }
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    if (f16.isFriendPlayingRecomm()) {
                        ap.f59791b.e(26, 1, i3, f16);
                    } else {
                        ap.f59791b.e(21, 1, i3, f16);
                    }
                    com.qzone.proxy.feedcomponent.model.f fVar2 = (com.qzone.proxy.feedcomponent.model.f) obj;
                    int b16 = fVar2.b();
                    if (f16.isFakeFeedSafe() && f16.isDynamicAlbumFeed()) {
                        ToastUtil.n(com.tencent.mobileqq.R.string.gg6);
                        return;
                    }
                    if (f16.isFakeFeedSafe()) {
                        int a16 = fVar2.a();
                        if (f16.isMixFakeFeed() && f16.isVideoInVideoPicMix(a16)) {
                            if (f16.isMixFake1()) {
                                ToastUtil.n(com.tencent.mobileqq.R.string.gpx);
                                return;
                            } else {
                                if (f16.isMixFake2()) {
                                    ToastUtil.n(com.tencent.mobileqq.R.string.gps);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (f16.isFakeRedPocketFeed()) {
                        return;
                    }
                    if (f16.isFakeFeed() && f16.isDynamicAlbumFeed()) {
                        ToastUtil.n(com.tencent.mobileqq.R.string.gg6);
                        return;
                    }
                    CellPictureInfo pictureInfo2 = f16.getPictureInfo();
                    if (pictureInfo2 == null && f16.getOriginalInfoSafe() != null) {
                        pictureInfo2 = f16.getOriginalInfoSafe().getPictureInfo();
                    }
                    CellPictureInfo cellPictureInfo4 = pictureInfo2;
                    if (cellPictureInfo4 != null) {
                        int i97 = cellPictureInfo4.actiontype;
                        if (i97 == 2) {
                            str4 = null;
                            i19 = b16;
                            str5 = "";
                            fVar = fVar2;
                            cellPictureInfo = cellPictureInfo4;
                            str6 = "2";
                            businessFeedData4 = f16;
                            String str27 = cellPictureInfo.actionurl;
                            if (businessFeedData4.getFeedCommInfo().recomtype == 5) {
                                str27 = str27 + "&from_kandian=1";
                            }
                            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str27) && businessFeedData4.isAppShareCardFeed()) {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(T(), str27, 2003, null);
                                return;
                            }
                            this.W.la(str27, null, null);
                        } else if (i97 == 6) {
                            str4 = null;
                            i19 = b16;
                            str5 = "";
                            fVar = fVar2;
                            cellPictureInfo = cellPictureInfo4;
                            str6 = "2";
                            businessFeedData4 = f16;
                            if (businessFeedData4.getGoods() != null) {
                                I0(view, i19, businessFeedData4);
                            }
                            this.V.v0(view, businessFeedData4, i19, 4, cellPictureInfo.actiontype, 0);
                        } else if (i97 == 18) {
                            str5 = "";
                            fVar = fVar2;
                            i19 = b16;
                            str4 = null;
                            str6 = "2";
                            businessFeedData4 = f16;
                            l1(fVar, f16, view, false, null, i19);
                            cellPictureInfo = cellPictureInfo4;
                            this.V.v0(view, businessFeedData4, i19, 4, cellPictureInfo.actiontype, 0);
                        } else if (i97 != 20) {
                            if (i97 == 22) {
                                cellPictureInfo3 = cellPictureInfo4;
                                str9 = null;
                                businessFeedData5 = f16;
                                if (!businessFeedData5.isQCircleShareCardFeed() && !businessFeedData5.isQCircleRecommFeed()) {
                                    this.W.xb(cellPictureInfo3.actionurl);
                                } else {
                                    this.W.la(cellPictureInfo3.actionurl, null, null);
                                }
                            } else if (i97 == 32) {
                                cellPictureInfo3 = cellPictureInfo4;
                                str9 = null;
                                businessFeedData5 = f16;
                                if (S0(fVar2, businessFeedData5, view)) {
                                    ClickReport.m("565", "2", "");
                                }
                            } else if (i97 == 54 || i97 == 62) {
                                str4 = null;
                                i19 = b16;
                                str5 = "";
                                fVar = fVar2;
                                z39 = true;
                            } else {
                                cellPictureInfo3 = cellPictureInfo4;
                                str9 = null;
                                businessFeedData5 = f16;
                                l1(fVar2, f16, view, false, null, b16);
                            }
                            str5 = "";
                            fVar = fVar2;
                            str6 = "2";
                            businessFeedData4 = businessFeedData5;
                            i19 = b16;
                            cellPictureInfo = cellPictureInfo3;
                            str4 = str9;
                            z39 = true;
                        } else {
                            int n16 = this.V.n(f16, b16, BaseFeedPresenter.f46081a0, R(f16, b16), view);
                            if (f16.isCanvasAd()) {
                                str7 = "2";
                                i26 = b16;
                                str5 = "";
                                cellPictureInfo2 = cellPictureInfo4;
                                fVar = fVar2;
                                str8 = null;
                                this.V.w0(view, f16, i26, 5001, n16, 0, MiscReportUtils.e(0, 5, 0));
                            } else {
                                str7 = "2";
                                i26 = b16;
                                str5 = "";
                                cellPictureInfo2 = cellPictureInfo4;
                                fVar = fVar2;
                                str8 = null;
                                this.V.y0(view, f16, i26, 4, n16, 0, null, 5, 3);
                            }
                            z39 = true;
                            i19 = i26;
                            str4 = str8;
                            str6 = str7;
                            businessFeedData4 = f16;
                            cellPictureInfo = cellPictureInfo2;
                        }
                        if (cellPictureInfo == null) {
                            l1(fVar, businessFeedData4, view, false, null, i19);
                            if (businessFeedData4.getVideoInfo() != null) {
                                this.V.v0(view, businessFeedData4, i19, 17, 0, 0);
                            } else if (businessFeedData4.getMusicInfo() != null) {
                                this.V.v0(view, businessFeedData4, i19, 19, 0, 0);
                            } else if (businessFeedData4.getAudioInfo() != null) {
                                this.V.v0(view, businessFeedData4, i19, 18, 0, 0);
                            }
                        }
                        MiscReportUtils.f(businessFeedData4, 3);
                        com.qzone.misc.network.report.d.g(businessFeedData4);
                        if (businessFeedData4.getFeedCommInfo() != null && businessFeedData4.getFeedCommInfo().needQBossReport()) {
                            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(businessFeedData4.getOperationInfo().qbossTrace, str4);
                        }
                        if (businessFeedData4.getFeedCommInfo() == null && businessFeedData4.getFeedCommInfo().appid == 7002) {
                            String str28 = str5;
                            ClickReport.r(str28, str28, str28, z39, "31", str6);
                            return;
                        }
                        return;
                    }
                    str4 = null;
                    i19 = b16;
                    str5 = "";
                    fVar = fVar2;
                    cellPictureInfo = cellPictureInfo4;
                    str6 = "2";
                    businessFeedData4 = f16;
                    if (cellPictureInfo == null) {
                    }
                    MiscReportUtils.f(businessFeedData4, 3);
                    com.qzone.misc.network.report.d.g(businessFeedData4);
                    if (businessFeedData4.getFeedCommInfo() != null) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(businessFeedData4.getOperationInfo().qbossTrace, str4);
                    }
                    if (businessFeedData4.getFeedCommInfo() == null) {
                        return;
                    } else {
                        return;
                    }
                case 51:
                    if (obj instanceof com.qzone.proxy.feedcomponent.model.g) {
                        com.qzone.proxy.feedcomponent.model.g gVar = (com.qzone.proxy.feedcomponent.model.g) obj;
                        if (com.qzone.proxy.feedcomponent.model.p.f50413b) {
                            return;
                        }
                        this.W.mh(gVar.f50316a.likeMans.get(com.qzone.proxy.feedcomponent.model.p.f50412a).user.uin, 0, R(f16, i3));
                        return;
                    }
                    if (obj instanceof com.qzone.proxy.feedcomponent.model.p) {
                        if (com.qzone.proxy.feedcomponent.model.p.f50412a >= 0 && com.qzone.proxy.feedcomponent.model.p.f50414c != null && com.qzone.proxy.feedcomponent.model.p.f50412a < com.qzone.proxy.feedcomponent.model.p.f50414c.size()) {
                            this.W.mh(com.qzone.proxy.feedcomponent.model.p.f50414c.get(com.qzone.proxy.feedcomponent.model.p.f50412a).user.uin, 0, R(f16, i3));
                            return;
                        }
                        CellFollowGuide cellFollowGuide3 = f16.cellFollowGuide;
                        if (cellFollowGuide3 != null) {
                            int i98 = cellFollowGuide3.action_type;
                            if (i98 == 2 || i98 == 20) {
                                this.W.la(cellFollowGuide3.action_url, null, null);
                                int i99 = f16.cellFollowGuide.feed_type;
                                if (i99 == 0) {
                                    LpReportInfo_pf00064.allReport(302, 86, 2);
                                    return;
                                } else {
                                    if (i99 == 3) {
                                        TTTReportManager.s().f(12, 66, 1, System.currentTimeMillis());
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 52:
                    if (f16.getLikeInfo().isLiked) {
                        CellDecorateInfo cellDecorateInfo = f16.getCellDecorateInfo();
                        if (cellDecorateInfo != null && (cellPolymorphicPraise = cellDecorateInfo.cellPolymorphicPraise) != null && cellPolymorphicPraise.iItemId > -1) {
                            ap.f59791b.e(216, 1, i3, f16);
                        } else {
                            ap.f59791b.e(3, 1, i3, f16);
                        }
                    } else {
                        ap.f59791b.e(1, 1, i3, f16);
                    }
                    if (f16.getUser() != null && f16.getUser().personalizedPassivePraiseId != -1) {
                        QzoneZipDownloadService.k().g(f16.getUser().personalizedPassivePraiseUrl);
                    }
                    if (!f16.getLocalInfo().isFake() && f16.getLocalInfo().canLike && !f16.getLikeInfo().isLiked && f16.getFeedCommInfo().canCustomPraise() && P0(view, f16)) {
                        c0(f16, i3);
                        return;
                    }
                    if (f16.isEventTagFeed) {
                        if (f16.getLikeInfo().isLiked) {
                            LpReportInfo_pf00064.allReport(Integer.valueOf("629").intValue(), 11, 2);
                        } else {
                            LpReportInfo_pf00064.allReport(Integer.valueOf("629").intValue(), 11, 1);
                        }
                    }
                    if (f16.isGDTAdvFeed() && f16.getLocalInfo() != null && f16.getLocalInfo().canLike) {
                        F0(view, f16, 0, i3);
                    } else {
                        Z0(view, f16, 0);
                    }
                    U1(f16, 1);
                    if (f16.getCellLuckyMoney() != null) {
                        ClickReport.q("481", "4", "", true);
                        return;
                    }
                    return;
                case 53:
                    if (obj instanceof NetImageCell) {
                        netImageCell = (NetImageCell) obj;
                        long customUin = netImageCell.getCustomUin();
                        i27 = netImageCell.getCustomId();
                        j3 = customUin;
                    } else {
                        netImageCell = null;
                        i27 = 0;
                        j3 = 0;
                    }
                    CustomPraiseData h16 = QzoneCustomPraiseService.i().h(i27 + "");
                    PraiseListView praiseListView = view instanceof PraiseListView ? (PraiseListView) view : null;
                    if (h16 == null || praiseListView == null || netImageCell == null || (cellPosition = praiseListView.getTouchingFeedTextArea().getTextLayout().getCellPosition(netImageCell)) == null) {
                        return;
                    }
                    view.getLocationInWindow(this.H);
                    if (h16.praiseType == 1) {
                        d2(true, h16, ((this.H[0] + cellPosition.left) + cellPosition.width()) - ViewUtils.dip2px(3.0f), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + cellPosition.top + (cellPosition.height() / 2), 0);
                        if (h16.cmShowActionId == 0) {
                            this.f45951e.l();
                        }
                        if (j3 != 0) {
                            b2(h16, j3);
                            return;
                        }
                        return;
                    }
                    d2(true, h16, ((this.H[0] + cellPosition.left) + cellPosition.width()) - ViewUtils.dip2px(3.0f), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + cellPosition.top + (cellPosition.height() / 2), 0);
                    if (j3 != 0) {
                        b2(h16, j3);
                    }
                    if (h16.cmShowActionId == 0) {
                        this.f45951e.l();
                        return;
                    }
                    return;
                case 54:
                case 55:
                    if (f16.getFeedCommInfo().isOperationFeed()) {
                        MiscReportUtils.o(f16.getOperationInfo().getOprationFeedTraceInfo());
                    }
                    com.qzone.proxy.feedcomponent.model.e eVar = (com.qzone.proxy.feedcomponent.model.e) obj;
                    if (eVar != null) {
                        String c16 = eVar.c();
                        String b17 = eVar.b();
                        int i100 = eVar.f50310d;
                        if (i100 == 13) {
                            if (this.U instanceof QZoneMyFeedFragment) {
                                LpReportInfo_pf00064.report(303, 11, 0);
                            } else {
                                LpReportInfo_pf00064.report(302, 83, 0);
                            }
                        } else if (i100 == 12) {
                            ap.f59791b.e(218, 1, i3, f16);
                            I1(f16);
                        }
                        str10 = c16;
                        str11 = b17;
                    } else {
                        str10 = null;
                        str11 = null;
                    }
                    if (!TextUtils.isEmpty(str10) && str10.startsWith("mqzone:%2F%2Farouse%2Fupdateqzonedesc")) {
                        str10 = URLDecoder.decode(str10);
                    }
                    if (!TextUtils.isEmpty(str10) && str10.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP) && str10.contains("qzone_feeds_lover_tail")) {
                        long j19 = f16.owner_uin;
                        if (j19 == 0) {
                            j19 = f16.getUser().uin;
                        }
                        hashMap = new HashMap();
                        hashMap.put("uin", Long.valueOf(j19));
                    } else {
                        hashMap = null;
                    }
                    if (f16.isFriendPlayingFeedV2()) {
                        ap.f59791b.e(26, 1, i3, f16);
                    }
                    if (str10 != null && str10.startsWith("mqzone://arouse/album") && (f16.isBabyAlbumFeed() || f16.isTravelAlbumFeed() || f16.isIndividualAlbumData() || f16.isLoverAlbumData() || f16.isMultiAlbumData())) {
                        L(f16, i3);
                        if (f16.isTravelAlbumFeed()) {
                            str14 = null;
                            i29 = 0;
                            ClickReport.c(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 7, "", false, null);
                        } else {
                            str14 = null;
                            i29 = 0;
                            if (f16.isLoverAlbumData()) {
                                ClickReport.c(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 8, "", false, null);
                            } else if (f16.isBabyAlbumFeed()) {
                                ClickReport.c(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 9, "", false, null);
                            } else if (f16.isMultiAlbumData()) {
                                ClickReport.c(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 12, "", true, null);
                            } else {
                                ClickReport.c(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 10, "", false, null);
                            }
                        }
                        str13 = str14;
                        i28 = i29;
                    } else {
                        if (str10 != null && WeishiHelper.isWeishiScheme(str10)) {
                            if (WeishiHelper.isWeishiInstall(str10)) {
                                ClickReport.c(693, 3, "2", false, PlatformInfor.g().getIMEI());
                            } else {
                                ClickReport.c(693, 3, "3", false, PlatformInfor.g().getIMEI());
                            }
                            this.W.la(str10, null, null);
                            str13 = null;
                        } else {
                            if (str10 != null && str10.contains("mqzone://arouse/readschema")) {
                                n3 = this.V.n(f16, i3, BaseFeedPresenter.U, R(f16, i3), view);
                                str13 = null;
                                i28 = 0;
                            } else {
                                if (str10 != null && str10.contains("mqzone://arouse/eventtagpage")) {
                                    str12 = null;
                                    yo.d.d(str10, Z(), null);
                                } else {
                                    str12 = null;
                                    if (str10 != null && str10.startsWith("mqzone://arouse/album") && f16.getVideoInfo() != null) {
                                        yo.c.w(Z(), str10, f16);
                                    } else if (str10 != null && str10.startsWith("mqzone://arouse/album") && f16.getFeedCommInfo().appid == 202) {
                                        yo.c.v(Z(), str10);
                                    } else if (str10 != null && str10.startsWith(QZoneHelper.SCHEME_OPEN_HOME_PAGE)) {
                                        m0(f16.getUser(), f16.cellFunnyTreadSpace);
                                    } else if (f16.isCanvasAd()) {
                                        str13 = null;
                                        n3 = this.V.n(f16, i3, -1, R(f16, i3), view);
                                        this.V.w0(view, f16, i3, 5001, n3, 0, MiscReportUtils.e(0, 27, 0));
                                        i28 = 0;
                                    } else {
                                        str13 = null;
                                        i28 = 0;
                                        if (str10 != null && str10.startsWith("mqqapi://qcircle")) {
                                            yo.d.d(str10, Z(), null);
                                        } else {
                                            if (!TextUtils.isEmpty(str10) && str10.startsWith("mqqapi://dating/")) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("QZoneBaseFeedActivity", 2, "handle dating jump .url = " + str10);
                                                }
                                                Intent intent2 = new Intent(Z(), (Class<?>) QQBrowserActivity.class);
                                                QZoneHelper.openWebSecurityVerify(intent2);
                                                intent2.putExtra("url", str10);
                                                intent2.putExtra("fromQZone", true);
                                                yo.b.a(intent2);
                                                this.Z.startActivity(intent2);
                                                z19 = true;
                                            } else {
                                                if (!TextUtils.isEmpty(str10) && str10.startsWith("https") && str10.contains("is_famous_space=1")) {
                                                    yo.d.d(str10, Z(), null);
                                                }
                                                z19 = false;
                                            }
                                            if (!z19) {
                                                if (f16.getFeedCommInfo().needAdvReport()) {
                                                    str = c6.a.d(view);
                                                    if (!TextUtils.isEmpty(str)) {
                                                        str = "&acttype=33&s=" + str;
                                                        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + str10 + str);
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(str10) && !TextUtils.isEmpty(str) && !str10.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                                    str10 = str10 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                                                }
                                                if (!TextUtils.isEmpty(str10) && str10.startsWith("mqzone://arouse/app") && !str10.contains("from") && f16.getReferInfoV2() != null) {
                                                    str10 = str10 + "&from=feeds&appname=" + f16.getReferInfoV2().appName;
                                                }
                                                if (f16.isHasHighFive()) {
                                                    LpReportInfo_pf00064.allReport(302, 74, 4);
                                                }
                                                if (!f16.isGDTAdvFeed()) {
                                                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str10)) {
                                                        QZLog.i("FeedClickProcessor", " Miniapp: feedPos " + i3 + "  url:" + str10);
                                                        if (f16.isFriendPlayingFeed() || f16.isFriendPlayingFeedV2() || f16.isFriendPlayingRecomm()) {
                                                            if (i3 == 3) {
                                                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(Z(), str10, 2090, null);
                                                                return;
                                                            } else if (i3 == 9 || i3 == 10) {
                                                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(Z(), str10, 2092, null);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    if (hashMap == null) {
                                                        hashMap = new HashMap();
                                                    }
                                                    hashMap.put("expandFrom", "3");
                                                    if (!TextUtils.isEmpty(str10)) {
                                                        yo.d.e(str10, Z(), str11, hashMap);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                str13 = str12;
                            }
                            if (f16.getFeedCommInfo().needAdvReport() && !f16.isCanvasAd()) {
                                if (!f16.isBrandUgcAdvFeeds()) {
                                    com.qzone.misc.network.report.f.b(f16, i28, 27);
                                } else {
                                    this.V.y0(view, f16, 0, 3, n3, 0, null, 27, 5);
                                }
                            }
                            if (f16.getFeedCommInfo() == null && f16.getFeedCommInfo().isFamousSpaceRecommFeed()) {
                                CellOperationInfo operationInfo2 = f16.getOperationInfo();
                                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportUrlClick(operationInfo2 == null ? str13 : operationInfo2.qbossTrace, str13);
                                return;
                            }
                            return;
                        }
                        i28 = 0;
                    }
                    n3 = i28;
                    if (f16.getFeedCommInfo().needAdvReport()) {
                        if (!f16.isBrandUgcAdvFeeds()) {
                        }
                    }
                    if (f16.getFeedCommInfo() == null) {
                        return;
                    } else {
                        return;
                    }
                case 56:
                    businessFeedData6 = f16;
                    i36 = i3;
                    i37 = 6;
                    r152 = 1;
                    z26 = true;
                    if (!businessFeedData6.isFakeFeedSafe()) {
                        if (businessFeedData6.isSoftFakeFeed()) {
                            ToastUtils.b(BaseApplication.getContext(), FeedOperation.SOFT_TIME_FAKE_FEED_COMMENT_CLICK_TIP);
                            return;
                        }
                        return;
                    }
                    if (z26) {
                        i38 = ap.c() ? 75 : 5;
                    } else {
                        i38 = ap.c() ? 74 : 4;
                    }
                    EmoEditPanel.D1 = new EmoEditPanel.al(i38, businessFeedData6, i36);
                    ap.f59791b.e(i38, r152, i36, businessFeedData6);
                    Object tag = view != null ? view.getTag() : null;
                    if (tag != null && (tag instanceof View)) {
                        View view3 = (View) tag;
                        if (view3.getVisibility() == 0) {
                            view2 = view3;
                            if (!businessFeedData6.isSecretFeed()) {
                                if (businessFeedData6.getFeedCommInfo().actionurl != null) {
                                    yo.d.d(businessFeedData6.getFeedCommInfo().actionurl, U(), null);
                                    return;
                                }
                                return;
                            }
                            int i101 = i37;
                            J0(i3, view2, obj, false, false, feedElement == FeedElement.COMMENT_GUIDE_ITEM ? 75 : 74);
                            new QZoneClickReport.ReportInfo();
                            MiscReportUtils.f(businessFeedData6, 18);
                            if (businessFeedData6.getFeedCommInfo() != null && businessFeedData6.getFeedCommInfo().isLikeRecommFamousFeed()) {
                                ClickReport.c(580, i101, "", r152, new String[0]);
                            }
                            MiscReportUtils.i(businessFeedData6);
                            if (businessFeedData6.getCellLuckyMoney() != null) {
                                ClickReport.q("481", "6", "", r152);
                                return;
                            }
                            return;
                        }
                    }
                    view2 = view;
                    if (!businessFeedData6.isSecretFeed()) {
                    }
                    break;
                case 57:
                    businessFeedData6 = f16;
                    i36 = i3;
                    i37 = 6;
                    r152 = 1;
                    z26 = false;
                    if (!businessFeedData6.isFakeFeedSafe()) {
                    }
                    break;
                case 58:
                    J0(i3, view, obj, true, false, 75);
                    return;
                case 59:
                    if (obj instanceof ClickedComment) {
                        ClickedComment clickedComment = (ClickedComment) obj;
                        if (clickedComment.getComment().user != null && clickedComment.getComment().user.uin != LoginData.getInstance().getUin()) {
                            EmoEditPanel.D1 = new EmoEditPanel.al(38, f16, i3);
                            ap.f59791b.e(38, 1, i3, f16);
                        }
                    }
                    J0(i3, view, obj, false, false, 38);
                    new QZoneClickReport.ReportInfo();
                    MiscReportUtils.f(f16, 18);
                    MiscReportUtils.i(f16);
                    return;
                case 60:
                case 61:
                    if (f16.getCellDecorateInfo() != null && f16.getCellDecorateInfo().cellCustomPraise != null && f16.getCellDecorateInfo().cellCustomPraise.iItemId > 0 && view != null && (this.U instanceof QZoneMyFeedFragment)) {
                        View view4 = view;
                        while (!(view4 instanceof AbsFeedView) && (view4 = (View) view4.getParent()) != null) {
                        }
                        if (view4 != null && (findViewById = view4.findViewById(com.tencent.mobileqq.R.id.c58)) != null) {
                            view4 = findViewById;
                        }
                        if (view4 != null) {
                            view4.getLocationInWindow(this.H);
                            if (f16.getCellDecorateInfo().cellCustomPraise.type == 1) {
                                v0();
                                CustomPraiseData c26 = c2(false, f16, this.H[0] + (view4.getWidth() / 2), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (view4.getHeight() / 2), (int) f16.getCellDecorateInfo().cellCustomPraise.uiComboCount);
                                b2(c26, f16.getUser().uin);
                                QZLog.d("FeedClickProcessor", 2, "@cmPraise onclick CONTENT,ANIMATION_TYPE_PARTICLE");
                                this.f45951e.f();
                                this.f45951e.setParticleCenterDrawable(f16.getCellDecorateInfo().cellCustomPraise.strPraiseButton);
                                if (c26 == null || c26.cmShowActionId != 0) {
                                    return;
                                }
                                this.f45951e.l();
                                return;
                            }
                            CustomPraiseData c27 = c2(false, f16, this.H[0] + (view4.getWidth() / 2), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (view4.getHeight() / 2), 1);
                            QZLog.d("FeedClickProcessor", 2, "@cmPraise onclick CONTENT");
                            b2(c27, f16.getUser().uin);
                            if (c27.cmShowActionId == 0) {
                                this.f45951e.l();
                                return;
                            }
                            return;
                        }
                    }
                    CellFunnyTreadSpace cellFunnyTreadSpace = f16.cellFunnyTreadSpace;
                    if (cellFunnyTreadSpace != null && (list = cellFunnyTreadSpace.actions) != null && list.size() > 0) {
                        m0(f16.getUser(), f16.cellFunnyTreadSpace);
                        return;
                    }
                    if (f16.getFeedCommInfo().actiontype != 20 && (f16.getCellSummaryV2() == null || f16.getCellSummaryV2().actionType != 20)) {
                        this.V.o0(f16, i3, f16.feedType == 4098 && QZoneFeedUtil.S(), view);
                        i46 = 11;
                        i39 = 6;
                    } else {
                        i39 = 6;
                        i46 = 11;
                        this.V.n(f16, i3, BaseFeedPresenter.X, R(f16, i3), view);
                    }
                    if (f16.feedType != 4097 && (!f16.isSubFeed || f16.parentFeedData.feedType != 4097)) {
                        i47 = 2;
                        i48 = i46;
                        businessFeedData7 = f16;
                        this.V.y0(view, f16, i3, 5001, S(f16), 0, MiscReportUtils.e(3, 25, 0), 25, 5);
                    } else {
                        i47 = 2;
                        i48 = i46;
                        businessFeedData7 = f16;
                        if (feedElement == FeedElement.ADV_MICRO_VIDEO) {
                            i56 = 7;
                            i49 = i39;
                        } else {
                            i49 = 1000;
                            i56 = 5;
                        }
                        this.V.y0(view, businessFeedData7, i3, 9, S(businessFeedData7), 0, null, i49, i56);
                    }
                    if (businessFeedData7.getFeedCommInfo() != null && com.qzone.proxy.feedcomponent.util.d.j(businessFeedData7.getFeedCommInfo().operatemask2, i48) && (this.U instanceof QZoneMyFeedFragment)) {
                        LpReportInfo_pf00064.allReport(303, 12, i47);
                        return;
                    }
                    return;
                case 62:
                    int i102 = 9;
                    int n17 = this.V.n(f16, i3, BaseFeedPresenter.Z, R(f16, i3), view);
                    boolean z46 = f16.getRecommAction() != null && f16.getRecommAction().btnType == 2;
                    if (f16.getFeedCommInfo().isVideoAdv() && !z46) {
                        i102 = 36;
                    }
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    this.V.y0(view, f16, i3, i102, n17, 0, null, 7, 4);
                    return;
                case 63:
                    T1(f16);
                    if (!f16.isAdFeeds() && (!f16.isBrandUgcAdvFeeds() || f16.getCellBottomRecomm() == null)) {
                        vo.c.S(Z(), f16, false);
                        return;
                    }
                    if (f16.getLocalInfo() == null || !f16.getLocalInfo().canComment || !f16.getLocalInfo().canLike || ((f16.getVideoInfo() != null && (f16.getRecommAction() == null || f16.getRecommAction().isHideActionArea != 0)) || (baseFeedPresenter2 = this.V) == null)) {
                        z27 = false;
                        i57 = 0;
                    } else {
                        i57 = baseFeedPresenter2.n(f16, i3, BaseFeedPresenter.W, R(f16, i3), view);
                        z27 = true;
                    }
                    if (f16.isBrandUgcAdvFeeds() && f16.getCellBottomRecomm() != null && f16.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_ADV) {
                        i1(view, i3, f16);
                        return;
                    }
                    int n18 = (z27 || (baseFeedPresenter = this.V) == null) ? i57 : baseFeedPresenter.n(f16, i3, BaseFeedPresenter.W, R(f16, i3), view);
                    int i103 = f16.isBrandUgcAdvFeeds() ? 29 : (!f16.getFeedCommInfo().isVideoAdv() || (f16.getRecommAction() != null && f16.getRecommAction().btnType == 2)) ? 9 : 36;
                    BaseFeedPresenter baseFeedPresenter4 = this.V;
                    if (baseFeedPresenter4 != null) {
                        baseFeedPresenter4.y0(view, f16, i3, i103, n18, 0, null, 29, 4);
                        return;
                    }
                    return;
                case 64:
                    if (f16.getFeedCommInfo() == null || (map2 = f16.getFeedCommInfo().extendInfo) == null) {
                        return;
                    }
                    String str29 = map2.get("kuolie_feed_report_url");
                    if (TextUtils.isEmpty(str29)) {
                        return;
                    }
                    this.W.la(str29, null, null);
                    return;
                case 65:
                case 66:
                case 67:
                    if (obj != null) {
                        L0(i3, obj, (CellTextView.OnTextOperater) obj);
                        return;
                    }
                    return;
                case 68:
                    t0((String) obj);
                    return;
                case 69:
                case 70:
                    BusinessFeedData businessFeedData21 = businessFeedData2;
                    if (businessFeedData21 == null || view == null || !(obj instanceof Integer)) {
                        return;
                    }
                    int intValue8 = ((Integer) obj).intValue();
                    ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData21.getRecBusinessFeedDatas();
                    if (recBusinessFeedDatas == null || recBusinessFeedDatas.size() <= intValue8 || (businessFeedData8 = recBusinessFeedDatas.get(intValue8)) == null || businessFeedData8.getCellUserInfo().getUser() == null) {
                        return;
                    }
                    this.W.mh(businessFeedData8.getCellUserInfo().getUser().uin, 0, R(f16, i3));
                    return;
                case 71:
                    if (z16 && !z17) {
                        N1(false);
                    }
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    ap.f59791b.e(17, 1, i3, f16);
                    U1(f16, 64);
                    if (view == null) {
                        if (obj != null) {
                            this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                            return;
                        }
                        return;
                    }
                    if (f16.isSecretFeed()) {
                        if (f16.getFeedCommInfo().actionurl != null) {
                            this.W.la(f16.getFeedCommInfo().actionurl, null, null);
                            return;
                        }
                        return;
                    }
                    if ((f16.isSpecialCareInContainerFeed() || f16.isFriendAnniversaryFeed()) && obj != null && (obj instanceof Long)) {
                        this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                        return;
                    }
                    if (obj instanceof com.qzone.proxy.feedcomponent.model.e) {
                        z28 = true;
                        str15 = "2";
                        J(f16, i3, BaseFeedPresenter.R, view, Long.valueOf(((com.qzone.proxy.feedcomponent.model.e) obj).c()).longValue());
                    } else {
                        z28 = true;
                        str15 = "2";
                        J(f16, i3, BaseFeedPresenter.R, view, 0L);
                        com.qzone.misc.network.report.a.g(f16);
                    }
                    if (f16.getCellLuckyMoney() != null) {
                        ClickReport.q("481", "8", str15, z28);
                    }
                    com.qzone.misc.network.report.d.d(f16);
                    if (f16.isThirdLiveVideoFeed()) {
                        MiscReportUtils.g(view, f16, null);
                        return;
                    }
                    return;
                case 72:
                    onClick(view, FeedElement.USER_AVATAR, i3, null);
                    return;
                case 73:
                    onClick(view, FeedElement.USER_NICKNAME, i3, null);
                    return;
                case 74:
                    if (z16 && !z17) {
                        N1(false);
                    }
                    U1(f16, 64);
                    ap.f59791b.e(17, 1, i3, f16);
                    if (view == null) {
                        if (obj != null) {
                            this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                            return;
                        }
                        return;
                    } else if (f16.isSpecialCareInContainerFeed() && obj != null && (obj instanceof Long)) {
                        this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                        return;
                    } else {
                        this.V.v0(view, f16, i3, 1, J(f16, i3, BaseFeedPresenter.R, view, 0L), 0);
                        com.qzone.misc.network.report.d.d(f16);
                        return;
                    }
                case 75:
                    A0(f16);
                    U1(f16, 8);
                    S1(f16, 1);
                    return;
                case 76:
                    vo.b.a(T());
                    return;
                case 77:
                    this.V.v0(view, f16, i3, 2, M(f16, i3, BaseFeedPresenter.Q, view, 0L), 0);
                    return;
                case 78:
                    boolean z47 = true;
                    if ((!f16.isAdFeeds() || obj == null || ((Long) obj).longValue() != 0) && !f16.isBrandUgcAdvFeeds()) {
                        z47 = false;
                    }
                    if (z47 || GdtFeedUtilForQZone.h(f16) == 3) {
                        if (z47) {
                            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "BaseFeedClickProcessor::LEFT_THUMB_VIEW_NICKNAME", "");
                            this.V.o0(f16, i3, false, new Object[0]);
                        } else if (obj != null) {
                            this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                        }
                        String i104 = com.qzone.misc.network.report.f.i(3, 24);
                        if (f16.isBrandUgcAdvFeeds()) {
                            return;
                        }
                        this.V.y0(view, f16, i3, 5001, f16.cellOperationInfo.actionType, 0, i104, 24, 5);
                        return;
                    }
                    return;
                case 79:
                    if (obj != null) {
                        this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                    }
                    ap.f59791b.e(18, 1, i3, f16);
                    return;
                case 80:
                case 81:
                    if (z16 && !z17) {
                        N1(false);
                    }
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    ap.f59791b.e(18, 1, i3, f16);
                    U1(f16, 128);
                    if (f16.isSecretFeed()) {
                        if (f16.getFeedCommInfo().actionurl != null) {
                            this.W.la(f16.getFeedCommInfo().actionurl, null, null);
                            return;
                        }
                        return;
                    }
                    if (f16.getCellUserInfo() != null) {
                        int i105 = f16.getCellUserInfo().actionType;
                        z29 = f16.getFeedCommInfo().isBizRecomFeeds();
                    } else {
                        z29 = false;
                    }
                    if (f16.getFeedCommInfo() != null) {
                        f16.getFeedCommInfo().isLikeRecommFamousFeed();
                    }
                    if ((view instanceof CanvasTitleView) && ((CanvasTitleView) view).isForward()) {
                        J(f16.getOriginalInfo(), i3, BaseFeedPresenter.Q, view, 0L);
                        return;
                    }
                    if (obj != null) {
                        Long l3 = (Long) obj;
                        if (l3.longValue() != 0 && !z29) {
                            J(f16, i3, BaseFeedPresenter.Q, view, l3.longValue());
                            return;
                        }
                    }
                    if (view != null) {
                        if (w0(f16, view, obj)) {
                            J(f16.getOriginalInfo(), i3, BaseFeedPresenter.Q, view, 0L);
                        } else {
                            J(f16, i3, BaseFeedPresenter.Q, view, 0L);
                        }
                        if (f16.isThirdLiveVideoFeed()) {
                            MiscReportUtils.g(view, f16, null);
                            return;
                        }
                        return;
                    }
                    return;
                case 82:
                    if (f16.getCellUserInfo() != null) {
                        i58 = f16.getCellUserInfo().actionType;
                        z36 = f16.getFeedCommInfo().isBizRecomFeeds();
                    } else {
                        i58 = 0;
                        z36 = false;
                    }
                    if ((this.U instanceof QZoneMyFeedFragment) && view != null && (obj == null || ((Long) obj).longValue() == 0)) {
                        i58 = N(f16, i3, BaseFeedPresenter.Q, view);
                    } else {
                        if (obj != null) {
                            Long l16 = (Long) obj;
                            if (l16.longValue() != 0 && !z36) {
                                if (f16.isAdFeeds() && (this.U instanceof QZoneMyFeedFragment)) {
                                    this.V.o0(f16, 3, false, new Object[0]);
                                } else {
                                    this.W.mh(l16.longValue(), 0, R(f16, i3));
                                }
                            }
                        }
                        if (view != null) {
                            i58 = M(f16, i3, BaseFeedPresenter.Q, view, 0L);
                        }
                    }
                    int i106 = i58;
                    if (f16.isAdFeeds()) {
                        this.V.y0(view, f16, i3, 5001, i106, 0, com.qzone.misc.network.report.f.i(3, 24), 24, 1);
                        return;
                    } else {
                        this.V.y0(view, f16, i3, 23, i106, 0, null, 24, 1);
                        return;
                    }
                case 83:
                    int i107 = f16.getTitleInfo().actionType;
                    if (f16.getTitleInfo().actionType == 20) {
                        i107 = this.V.n(f16, i3, BaseFeedPresenter.U, R(f16, i3), view);
                    } else if (f16.getTitleInfo().actionType != 6) {
                        if (f16.getTitleInfo().actionType == 2) {
                            String str30 = f16.getTitleInfoV2().titleUrl;
                            if (f16.getFeedCommInfo().recomtype == 5) {
                                str30 = str30 + "&from_kandian=1";
                            }
                            this.W.la(str30, null, null);
                        } else {
                            this.V.o0(f16, i3, true, view);
                        }
                    }
                    this.V.y0(view, f16, i3, 3, i107, 0, null, 17, 5);
                    return;
                case 84:
                    if (w0(f16, view, obj)) {
                        BusinessFeedData originalInfo = f16.getOriginalInfo();
                        if (originalInfo.getCellSummary().actionType == 2) {
                            yo.d.d(originalInfo.getCellSummary().actionUrl, Z(), null);
                            return;
                        }
                        return;
                    }
                    return;
                case 85:
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    ap.f59791b.e(19, 1, i3, f16);
                    if (f16.isQCircleRecommFeed() && f16.getCellBottomRecomm() != null) {
                        this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                        return;
                    }
                    if (f16.getCellDecorateInfo() != null && f16.getCellDecorateInfo().cellCustomPraise != null && f16.getCellDecorateInfo().cellCustomPraise.iItemId > 0 && view != null && (this.U instanceof QZoneMyFeedFragment)) {
                        View view5 = view;
                        while (!(view5 instanceof AbsFeedView) && (view5 = (View) view5.getParent()) != null) {
                        }
                        if (view5 != null && (findViewById2 = view5.findViewById(com.tencent.mobileqq.R.id.c58)) != null) {
                            view5 = findViewById2;
                        }
                        if (view5 != null) {
                            view5.getLocationInWindow(this.H);
                            if (f16.getCellDecorateInfo().cellCustomPraise.type == 1) {
                                v0();
                                CustomPraiseData c28 = c2(false, f16, this.H[0] + (view5.getWidth() / 2), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (view5.getHeight() / 2), (int) f16.getCellDecorateInfo().cellCustomPraise.uiComboCount);
                                QZLog.d("FeedClickProcessor", 2, "@cmPraise onclick SUMMARY,ANIMATION_TYPE_PARTICLE");
                                b2(c28, f16.getUser().uin);
                                this.f45951e.f();
                                this.f45951e.setParticleCenterDrawable(f16.getCellDecorateInfo().cellCustomPraise.strPraiseButton);
                                this.f45951e.l();
                                return;
                            }
                            QZLog.d("FeedClickProcessor", 2, "@cmPraise onclick SUMMARY");
                            b2(c2(false, f16, this.H[0] + (view5.getWidth() / 2), (this.H[1] - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (view5.getHeight() / 2), 1), f16.getUser().uin);
                            this.f45951e.l();
                            return;
                        }
                    }
                    if (f16.getCellSummaryV2() != null && !TextUtils.isEmpty(f16.getCellSummaryV2().more_info) && f16.getFeedCommInfo().isBizRecomFeeds() && !f16.getFeedCommInfo().isPicUpLayout()) {
                        try {
                            String str31 = f16.getCellSummaryV2().more_info;
                            this.W.Ib(str31.substring(str31.indexOf("url:") + 4, str31.indexOf(",text")), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_BIZ, QzoneConfig.SECONDARY_DOWNLOAD_QZONE_APP_URL, QzoneConfig.DefaultValue.BIZ_DOWNLOAD_QZONE_APP_URL));
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    int i108 = f16.getCellSummary().actionType;
                    if (i108 == 20) {
                        i65 = this.V.n(f16, i3, BaseFeedPresenter.f46082b0, R(f16, i3), view);
                        i59 = 0;
                    } else {
                        if (i108 == 6) {
                            i59 = 0;
                        } else {
                            if (w0(f16, view, obj)) {
                                this.V.O0(true);
                            }
                            i59 = 0;
                            this.V.o0(f16, i3, false, view);
                        }
                        i65 = i108;
                    }
                    if (f16.isBrandUgcAdvFeeds()) {
                        return;
                    }
                    if (f16.isAdFeeds()) {
                        this.V.y0(view, f16, i3, 5001, i65, 0, com.qzone.misc.network.report.f.i(3, i59), 25, 5);
                        return;
                    } else if (f16.isCanvasAd()) {
                        this.V.y0(view, f16, i3, 5001, i65, 0, MiscReportUtils.e(0, 4, 0), 4, 2);
                        return;
                    } else {
                        this.V.y0(view, f16, i3, 3, i65, 0, "", 4, 2);
                        return;
                    }
                case 86:
                    i66 = i3;
                    businessFeedData9 = f16;
                    if (businessFeedData9.isGDTAdvFeed()) {
                        vo.b.m(true, businessFeedData9);
                    }
                    if (!ap.c()) {
                        ap.f59791b.e(19, 1, i66, businessFeedData9);
                    }
                    if (businessFeedData9.isQCircleRecommFeed() && businessFeedData9.getCellBottomRecomm() != null) {
                        this.W.la(businessFeedData9.getCellBottomRecomm().actionurl, null, null);
                        return;
                    }
                    j1(view, businessFeedData9, obj, i66);
                    return;
                case 87:
                    i66 = i3;
                    businessFeedData9 = f16;
                    j1(view, businessFeedData9, obj, i66);
                    return;
                case 88:
                case 89:
                    if (!A()) {
                        c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"));
                        return;
                    } else {
                        this.V.r0(f16);
                        return;
                    }
                case 90:
                    this.V.s0(f16);
                    return;
                case 91:
                    BusinessFeedData businessFeedData22 = businessFeedData2;
                    if (f16.isFunctionGuideFeed()) {
                        MiscReportUtils.k(f16.getCellGuiding(), "report_drop_down_menu");
                    }
                    E0(f16, i3);
                    if (businessFeedData22 != null && (businessFeedData22.isFriendPlayingFeedV2() || businessFeedData22.isFriendPlayingRecomm() || businessFeedData22.isFrdLikeMiniAppContainer())) {
                        ap.f59791b.e(85, 1, i3, f16);
                    }
                    if (businessFeedData22 != null && (businessFeedData22.isFrdLikeVideoContainer() || businessFeedData22.isFriendLikeVerticalSlideContainer())) {
                        R0(view, businessFeedData22, i3, obj);
                        return;
                    }
                    BusinessFeedData businessFeedData23 = (f16.getRecBusinessFeedDatas() == null || f16.currShowIndex >= f16.getRecBusinessFeedDatas().size() || GdtFeedUtilForQZone.s(f16)) ? f16 : f16.getRecBusinessFeedDatas().get(f16.currShowIndex);
                    if (businessFeedData23.isGDTAdvFeed()) {
                        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
                        adFeedbackParams.activity = new WeakReference<>(T());
                        adFeedbackParams.f61346ad = new GdtAd(GdtFeedUtilForQZone.f(businessFeedData23));
                        adFeedbackParams.styleId = 0;
                        adFeedbackParams.isDarkMode = QQTheme.isNowThemeIsNightForQzone();
                        adFeedbackParams.listener = new WeakReference<>(this.T);
                        try {
                            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                            return;
                        } catch (Throwable th5) {
                            QLog.e("FeedClickProcessor", 1, NodeProps.ON_CLICK, th5);
                            return;
                        }
                    }
                    R0(view, businessFeedData23, i3, obj);
                    return;
                case 92:
                case 93:
                    if (f16.isFunctionGuideFeed()) {
                        MiscReportUtils.k(f16.getCellGuiding(), "report_drop_down_menu");
                    }
                    E0(f16, i3);
                    R0(view, this.V.O(true), i3, obj);
                    return;
                case 94:
                case 95:
                    B0((CellReferInfo) obj, f16);
                    return;
                case 96:
                    s1(i3, false);
                    return;
                case 97:
                    s1(i3, true);
                    return;
                case 98:
                    EventCenter.getInstance().post("WriteOperation", 8, f16.getFeedCommInfo().ugckey);
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    this.V.y0(view, f16, i3, 12, 0, 0, null, 8, 5);
                    return;
                case 99:
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    K(f16, i3, BaseFeedPresenter.S, view);
                    return;
                case 100:
                    this.V.r(view, f16, i3, false, true, false, view instanceof CanvasQzoneCardView);
                    return;
                case 101:
                    if (f16.getFeedCommInfo() != null) {
                        boolean z48 = !f16.getFeedCommInfo().isFollowed;
                        if (f16.getFeedCommInfo().isLikeRecommFamousFeed()) {
                            if (z48) {
                                ClickReport.c(580, 3, "", true, new String[0]);
                            } else {
                                ClickReport.c(580, 4, "", true, new String[0]);
                            }
                        }
                        this.V.q(view, f16, i3, false, false, false);
                        if (f16.isRecommendFeed()) {
                            com.qzone.misc.network.ttt.a.c().a(f16.getRecommendReportUUID(), 12, z48 ? 201 : 202, 1, f16, i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 102:
                    if (view != null && obj != null && (obj instanceof Long)) {
                        this.W.mh(((Long) obj).longValue(), 0, R(f16, i3));
                    }
                    this.V.y0(view, f16, i3, 16, 0, 0, null, 24, 5);
                    return;
                case 103:
                    this.V.q(view, f16, i3, false, false, false);
                    return;
                case 104:
                    BusinessFeedData businessFeedData24 = businessFeedData2;
                    if (businessFeedData24 == null || view == null || !(obj instanceof Integer)) {
                        return;
                    }
                    int intValue9 = ((Integer) obj).intValue();
                    ArrayList<BusinessFeedData> recBusinessFeedDatas2 = businessFeedData24.getRecBusinessFeedDatas();
                    if (recBusinessFeedDatas2 == null || recBusinessFeedDatas2.size() <= intValue9) {
                        return;
                    }
                    this.V.q(view, recBusinessFeedDatas2.get(intValue9), i3, false, false, false);
                    return;
                case 105:
                    yo.c.P(Z(), f16.getUser().uin);
                    return;
                case 106:
                    businessFeedData10 = f16;
                    i67 = i3;
                    i68 = 1;
                    if (obj instanceof ClickedComment) {
                        ClickedComment clickedComment2 = (ClickedComment) obj;
                        if (clickedComment2.getReply().user != null && clickedComment2.getReply().user.uin != LoginData.getInstance().getUin()) {
                            EmoEditPanel.D1 = new EmoEditPanel.al(38, businessFeedData10, i67);
                            ap.f59791b.e(38, 1, i67, businessFeedData10);
                        }
                    }
                    if (businessFeedData10.getFeedCommInfo().isVideoAdv() || QZoneFeedUtil.g(businessFeedData10)) {
                        if (!businessFeedData10.isSecretFeed()) {
                            if (businessFeedData10.getFeedCommInfo().actionurl != null) {
                                yo.d.d(businessFeedData10.getFeedCommInfo().actionurl, U(), null);
                                return;
                            }
                            return;
                        }
                        if (EmoEditPanel.D1 == null) {
                            i69 = 74;
                            EmoEditPanel.D1 = new EmoEditPanel.al(74, businessFeedData10, i67);
                        } else {
                            i69 = 74;
                        }
                        ap.f59791b.e(i69, i68, i67, businessFeedData10);
                        J0(i3, view, obj, false, false, feedElement == FeedElement.REPLY_BUTTON ? 74 : 38);
                        MiscReportUtils.j(businessFeedData10);
                        return;
                    }
                    return;
                case 107:
                    businessFeedData10 = f16;
                    i67 = i3;
                    i68 = 1;
                    if (businessFeedData10.getFeedCommInfo().isVideoAdv()) {
                        break;
                    }
                    if (!businessFeedData10.isSecretFeed()) {
                    }
                    break;
                case 108:
                    I0(view, i3, f16);
                    com.qzone.misc.network.report.d.e(f16);
                    if (f16.getFeedCommInfo() == null || !f16.getFeedCommInfo().needQBossReport()) {
                        return;
                    }
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(f16.getOperationInfo().qbossTrace, null);
                    return;
                case 109:
                    if (!(obj instanceof CellGuiding) || (map3 = ((CellGuiding) obj).extendInfo) == null) {
                        return;
                    }
                    String str32 = map3.get("feed_share_url");
                    if (TextUtils.isEmpty(str32)) {
                        return;
                    }
                    this.W.Vc(str32);
                    return;
                case 110:
                case 111:
                case 112:
                    y1(i3, f16, view, obj instanceof FeedOperation.CommentObj ? ((FeedOperation.CommentObj) obj).commentView : null);
                    if (f16.getCellLuckyMoney() != null) {
                        ClickReport.q("481", "5", "", true);
                    }
                    if (f16.isEventTagFeed) {
                        LpReportInfo_pf00064.allReport(Integer.valueOf("629").intValue(), 8);
                    }
                    ap.f59791b.e(35, 1, i3, f16);
                    return;
                case 113:
                    if (f16.isSpecialCareInContainerFeed()) {
                        LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 2, 2);
                    } else if (f16.isCardFriendsRecommendContainerFeed() || f16.isCardSchoolRecommendContainerFeed() || f16.isCardFollowMoreRecommendContainerFeed() || f16.isCardSpecialFollowMoreRecommendContainerFeed()) {
                        LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON, 2, 2);
                    }
                    if (f16.isCardFollowMoreRecommendContainerFeed()) {
                        EventCenter.getInstance().post("WriteOperation", 38, f16.getFeedCommInfo().feedskey);
                    }
                    if (!f16.isFriendPlayingFeedV2() && !f16.isAlbumRecFeed() && !f16.isFrdLikeMiniAppContainer()) {
                        if (f16.isFriendPlayingRecomm()) {
                            ap.f59791b.e(45, 1, i3, f16);
                        }
                    } else {
                        ap.f59791b.e(64, 1, i3, f16);
                    }
                    if (!f16.isFriendBirthdayContainerFeed() && !f16.isCardFriendsRecommendContainerFeed() && !f16.isCardSchoolRecommendContainerFeed() && !f16.isCardFollowMoreRecommendContainerFeed() && !f16.isSpecialCareInContainerFeed() && !f16.isCardSpecialFollowMoreRecommendContainerFeed() && !f16.isFriendAnniversaryFeed() && !f16.isRegisterAnniversaryFeed() && !f16.isFunctionGuideFeed() && !f16.isQCircleRecommFeed()) {
                        if (f16.isRecomEventTagFeed()) {
                            com.qzone.adapter.feedcomponent.i.z2(Boolean.FALSE);
                            EventCenter.getInstance().post("WriteOperation", 38, f16.getFeedCommInfo().feedskey);
                            com.qzone.adapter.feedcomponent.i.H().z(12, 24, 1, System.currentTimeMillis(), f16, i3, 0);
                            ClickReport.q("302", "557", "5", true);
                            return;
                        }
                        i75 = i3;
                        i76 = 1;
                        if (f16.isNewGuideFeed()) {
                            LpReportInfo_pf00064 lpReportInfo_pf000646 = new LpReportInfo_pf00064(302, 102, 4);
                            lpReportInfo_pf000646.reserves3 = f16.getCellGuiding().guiding_type + "";
                            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000646, false, false);
                        }
                    } else {
                        i75 = i3;
                        i76 = 1;
                        EventCenter.getInstance().post("Feed", 27);
                        com.qzone.adapter.feedcomponent.i.z2(Boolean.FALSE);
                        x(f16);
                        QZoneWriteOperationService.v0().I(i75, f16);
                        if (f16.isCardSchoolRecommendContainerFeed()) {
                            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("650", "8"), false, false);
                        } else if (f16.isCardSpecialFollowMoreRecommendContainerFeed()) {
                            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("721", "7"), false, false);
                        }
                    }
                    BusinessFeedData businessFeedData25 = (f16.getRecBusinessFeedDatas() == null || (i77 = f16.currShowIndex) < 0 || i77 >= f16.getRecBusinessFeedDatas().size() || f16.isSpecialCareInContainerFeed() || f16.isFriendVideoFeed()) ? f16 : f16.getRecBusinessFeedDatas().get(f16.currShowIndex);
                    if (businessFeedData25.getRecommAction() != null && businessFeedData25.getRecommAction().reportUrl != null) {
                        str = businessFeedData25.getRecommAction().reportUrl;
                    }
                    if (businessFeedData25.getActiveAdv() != null && businessFeedData25.getActiveAdv().reportUrl != null) {
                        str = businessFeedData25.getActiveAdv().reportUrl;
                    }
                    if (businessFeedData25.isAttach() && businessFeedData25.getCellAdvContainerAttach().isReport == i76 && !StringUtil.isEmpty(businessFeedData25.getCellAdvContainerAttach().reportUrl)) {
                        str = businessFeedData25.getCellAdvContainerAttach().reportUrl;
                    }
                    if (!f16.isQQCircleRecomm && !f16.isRecommendQQCircleFeed()) {
                        if (!businessFeedData25.isCardFriendsRecommendContainerFeed() && !businessFeedData25.isCardSchoolRecommendContainerFeed()) {
                            if (businessFeedData25.isCardSpecialFollowMoreRecommendContainerFeed()) {
                                EventCenter eventCenter = EventCenter.getInstance();
                                Object[] objArr7 = new Object[i76];
                                objArr7[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter.post("WriteOperation", 38, objArr7);
                                return;
                            }
                            if (businessFeedData25.isSpecialCareInContainerFeed()) {
                                EventCenter eventCenter2 = EventCenter.getInstance();
                                Object[] objArr8 = new Object[i76];
                                objArr8[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter2.post("WriteOperation", 38, objArr8);
                                MiscReportUtils.p();
                                return;
                            }
                            if (businessFeedData25.isFriendBirthdayContainerFeed()) {
                                EventCenter eventCenter3 = EventCenter.getInstance();
                                Object[] objArr9 = new Object[i76];
                                objArr9[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter3.post("WriteOperation", 38, objArr9);
                                return;
                            }
                            if (businessFeedData25.isFunctionGuideFeed()) {
                                EventCenter eventCenter4 = EventCenter.getInstance();
                                Object[] objArr10 = new Object[i76];
                                objArr10[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter4.post("WriteOperation", 38, objArr10);
                                return;
                            }
                            if (businessFeedData25.isFriendAnniversaryFeed()) {
                                EventCenter eventCenter5 = EventCenter.getInstance();
                                Object[] objArr11 = new Object[i76];
                                objArr11[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter5.post("WriteOperation", 38, objArr11);
                                return;
                            }
                            if (businessFeedData25.isRegisterAnniversaryFeed()) {
                                EventCenter eventCenter6 = EventCenter.getInstance();
                                Object[] objArr12 = new Object[i76];
                                objArr12[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter6.post("WriteOperation", 38, objArr12);
                                return;
                            }
                            if (businessFeedData25.getFeedCommInfo().isRecomLiveShowFeed()) {
                                QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                                BusinessFeedData businessFeedData26 = businessFeedData25.parentFeedData;
                                if (businessFeedData26 == null) {
                                    businessFeedData26 = businessFeedData25;
                                }
                                v06.I(i75, businessFeedData26);
                                EventCenter eventCenter7 = EventCenter.getInstance();
                                Object[] objArr13 = new Object[i76];
                                objArr13[0] = businessFeedData25.getFeedCommInfo().feedskey;
                                eventCenter7.post("WriteOperation", 38, objArr13);
                                return;
                            }
                            if (businessFeedData25.getFeedCommInfo().isYunYingFeeds()) {
                                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(businessFeedData25.getOperationInfo().qbossTrace, null);
                                EventCenter eventCenter8 = EventCenter.getInstance();
                                Object[] objArr14 = new Object[i76];
                                objArr14[0] = f16.getFeedCommInfo().feedskey;
                                eventCenter8.post("WriteOperation", 38, objArr14);
                                return;
                            }
                            if (businessFeedData25.isNewGuideFeed()) {
                                EventCenter eventCenter9 = EventCenter.getInstance();
                                Object[] objArr15 = new Object[i76];
                                objArr15[0] = f16.getFeedCommInfo().feedskey;
                                eventCenter9.post("WriteOperation", 38, objArr15);
                                return;
                            }
                            if (businessFeedData25.isAlbumRecFeed()) {
                                EventCenter eventCenter10 = EventCenter.getInstance();
                                Object[] objArr16 = new Object[i76];
                                objArr16[0] = f16.getFeedCommInfo().feedskey;
                                eventCenter10.post("WriteOperation", 38, objArr16);
                                return;
                            }
                            if ((obj instanceof String) && "issuedTemplate".equals(obj)) {
                                EventCenter eventCenter11 = EventCenter.getInstance();
                                Object[] objArr17 = new Object[i76];
                                objArr17[0] = f16.getFeedCommInfo().feedskey;
                                eventCenter11.post("WriteOperation", 38, objArr17);
                                return;
                            }
                            if (businessFeedData25.isQCircleRecommFeed()) {
                                EventCenter eventCenter12 = EventCenter.getInstance();
                                Object[] objArr18 = new Object[i76];
                                objArr18[0] = f16.getFeedCommInfo().feedskey;
                                eventCenter12.post("WriteOperation", 38, objArr18);
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                        }
                        int intValue10 = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
                        AdsFeedbackReporter.report(str + "2001");
                        if (intValue10 >= 0) {
                            ToastUtil.r(i0().getString(com.tencent.mobileqq.R.string.f170930b53));
                        }
                        EventCenter eventCenter13 = EventCenter.getInstance();
                        Object[] objArr19 = new Object[i76];
                        objArr19[0] = f16.getFeedCommInfo().feedskey;
                        eventCenter13.post("WriteOperation", 38, objArr19);
                        return;
                    }
                    EventCenter eventCenter14 = EventCenter.getInstance();
                    Object[] objArr20 = new Object[i76];
                    objArr20[0] = businessFeedData25.getFeedCommInfo().feedskey;
                    eventCenter14.post("WriteOperation", 38, objArr20);
                    return;
                case 114:
                    if ((f16.getFeedCommInfo() != null && f16.getFeedCommInfo().appid == 422) || f16.getCellLuckyMoney() != null || (cellFeedSkinInfo = f16.getCellFeedSkinInfo()) == null || TextUtils.isEmpty(cellFeedSkinInfo.sSkinId) || cellFeedSkinInfo.sSkinId.equals("-1")) {
                        return;
                    }
                    if (cellFeedSkinInfo.iNewFeedSkin == 1) {
                        vo.c.p(Z(), cellFeedSkinInfo.sSkinId, "feedsdetails", f16.getUser().uin);
                        return;
                    } else {
                        vo.c.f(Z(), cellFeedSkinInfo.sSkinId, "normalfeeds", f16.getUser().uin);
                        return;
                    }
                case 115:
                    if ((f16.getFeedCommInfo() == null || f16.getFeedCommInfo().appid != 422) && (cellFeedSkinInfo2 = f16.getCellFeedSkinInfo()) != null) {
                        this.W.la(cellFeedSkinInfo2.strMusicH5Url, "", null);
                        return;
                    }
                    return;
                case 116:
                    if (f16.getSeparatorInfo() == null || f16.getSeparatorInfo().actionUrl == null) {
                        return;
                    }
                    this.W.la(f16.getSeparatorInfo().actionUrl, null, null);
                    return;
                case 117:
                    if (f16.getFeedCommInfo() == null || TextUtils.isEmpty(f16.getFeedCommInfo().ugcRightKey) || f16.getPermissionInfoV2() == null) {
                        return;
                    }
                    String str33 = f16.getFeedCommInfo().ugcRightKey;
                    int g16 = com.qzone.feed.utils.h.g(f16.getPermissionInfoV2().permission_visit);
                    if (com.qzone.feed.utils.h.h(g16)) {
                        QZoneFeedUtil.b0(Z(), str33, g16, f16.getFeedCommInfo().appid);
                        return;
                    }
                    return;
                case 118:
                    com.qzone.adapter.feedcomponent.i.H().p(T());
                    return;
                case 119:
                    com.qzone.adapter.feedcomponent.i.H().q(Z(), f16);
                    return;
                case 120:
                    if (!(obj instanceof User) || (userMedal = (user = (User) obj).famousSpaceMedal) == null) {
                        return;
                    }
                    String str34 = userMedal.jumpUrl;
                    if (!TextUtils.isEmpty(str34)) {
                        String j26 = yo.f.j(str34, "{uin}", LoginData.getInstance().getUinString());
                        yo.d.d(j26, Z(), null);
                        C(f16, user, true);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("FeedClickProcessor", 1, "jumpUrl = " + j26);
                            return;
                        }
                        return;
                    }
                    QZLog.d("FeedClickProcessor", 1, "click famous_space_icon meeting a null url");
                    return;
                case 121:
                    if (!(obj instanceof User) || (userMedal2 = (user2 = (User) obj).famousSpaceMedal) == null) {
                        return;
                    }
                    String str35 = userMedal2.jumpUrl;
                    if (!TextUtils.isEmpty(str35)) {
                        yo.d.d(str35, Z(), null);
                        C(f16, user2, true);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("FeedClickProcessor", 1, "jumpUrl = " + str35);
                            return;
                        }
                        return;
                    }
                    QZLog.d("FeedClickProcessor", 1, "click can_follow_icon meeting a null url");
                    return;
                case 122:
                    com.qzone.adapter.feedcomponent.i.H().o(Z(), f16);
                    return;
                case 123:
                    yo.d.c(obj instanceof String ? (String) obj : "", Z());
                    return;
                case 124:
                    QZLog.d("FeedClickProcessor", 1, "video clicked: gesture action");
                    onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e((String) obj, "", i3));
                    return;
                case 125:
                case 126:
                case 127:
                case 128:
                    VideoPlayInfo videoPlayInfo = (VideoPlayInfo) obj;
                    if (z16 && !z17) {
                        L1(false);
                    }
                    if (f16.isGDTAdvFeed()) {
                        vo.b.m(true, f16);
                    }
                    if (f16.isQCircleRecommFeed() && f16.getCellBottomRecomm() != null) {
                        this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                        return;
                    }
                    if (f16.isQCircleShareCardFeed() && f16.getVideoInfo() != null && !TextUtils.isEmpty(f16.getVideoInfo().actionUrl)) {
                        this.W.la(f16.getVideoInfo().actionUrl, null, null);
                        return;
                    }
                    if (f16.isFriendPlayingRecomm()) {
                        if (f16.getOperationInfoV2() != null && f16.getOperationInfoV2().schemaPageUrl != null) {
                            K(f16, i3, BaseFeedPresenter.X, view);
                            return;
                        }
                    } else if (f16.isPublicAccountContent()) {
                        p1(f16);
                        return;
                    }
                    if (videoPlayInfo != null) {
                        i78 = 3;
                        if (videoPlayInfo.videoStatus == 3) {
                            QZLog.w("FeedClickProcessor", "video clicked: videoStatus == 3");
                            return;
                        }
                    } else {
                        i78 = 3;
                    }
                    VideoInfo videoInfo = f16.getVideoInfo();
                    if (videoInfo == null && f16.getOriginalInfo() != null) {
                        videoInfo = f16.getOriginalInfo().getVideoInfo();
                    }
                    VideoInfo videoInfo2 = videoInfo;
                    if (videoInfo2 != null && x0(videoInfo2)) {
                        if (f16.getLocalInfo().isHalfReal()) {
                            ToastUtil.n(com.tencent.mobileqq.R.string.gps);
                            return;
                        } else {
                            ToastUtil.n(com.tencent.mobileqq.R.string.gpy);
                            return;
                        }
                    }
                    String C0 = videoInfo2 != null ? QZoneWriteOperationService.v0().C0(videoInfo2.videoId) : null;
                    if (videoInfo2 != null && videoInfo2.videoStatus == 1 && TextUtils.isEmpty(C0)) {
                        ToastUtil.r(videoInfo2.toast);
                        return;
                    }
                    if (videoInfo2 == null || !videoInfo2.isAdvMicroVideo()) {
                        if (f16.isLiveVideoFeed() && videoInfo2 != null) {
                            CellLive cellLive2 = f16.getCellLive();
                            f16.getCellUserInfo();
                            if (cellLive2 != null && cellLive2.roomid != null) {
                                QZLog.i("FeedClickProcessor", "\u76f4\u64ad\u70b9\u51fblog room id = " + cellLive2.roomid);
                            }
                            if (f16.getOriginalInfo() != null && f16.getOriginalInfo().getCellUserInfo() != null && f16.getOriginalInfo().getCellUserInfo().getUser() != null) {
                                QZLog.i("FeedClickProcessor", "\u76f4\u64ad\u70b9\u51fblog origin user uin = " + f16.getOriginalInfo().getCellUserInfo().getUser().uin);
                            }
                            if (videoInfo2.actionUrl != null) {
                                QZLog.i("FeedClickProcessor", "\u76f4\u64ad\u70b9\u51fblog feed\u4e0b\u53d1\u8df3\u8f6caction url = " + videoInfo2.actionUrl);
                            } else {
                                QZLog.i("FeedClickProcessor", "\u76f4\u64ad\u70b9\u51fblog feed\u4e0b\u53d1\u8df3\u8f6caction url = null");
                            }
                        }
                        if (f16.isLiveVideoFeed() && (cellLive = f16.getCellLive()) != null && !TextUtils.isEmpty(cellLive.roomid) && videoInfo2 != null && 2 == videoInfo2.actionType && !TextUtils.isEmpty(videoInfo2.actionUrl)) {
                            this.W.la(videoInfo2.actionUrl, null, null);
                            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 5);
                            LpReportInfo_pf00064.allReport(236, 1, 2);
                            return;
                        }
                        if (videoInfo2 == null && f16.isMixVideoPic()) {
                            int mixVideoIndex = f16.getMixVideoIndex();
                            if (x0(videoInfo2) && f16.isMixFakeFeed() && f16.isVideoInVideoPicMix(mixVideoIndex)) {
                                if (f16.isMixFake1()) {
                                    ToastUtil.n(com.tencent.mobileqq.R.string.gpy);
                                    return;
                                } else {
                                    if (f16.isMixFake2()) {
                                        ToastUtil.n(com.tencent.mobileqq.R.string.gps);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (f16.getPictureInfo() == null) {
                                QZLog.i("FeedClickProcessor", 1, "mixVideoClick forward feed");
                                str16 = C0;
                                j16 = 0;
                                int i109 = i78;
                                i79 = 9;
                                i85 = i109;
                                businessFeedData11 = f16;
                                l1(new com.qzone.proxy.feedcomponent.model.f(i3, mixVideoIndex, false, true), f16, view, false, null, i3);
                            } else {
                                str16 = C0;
                                businessFeedData11 = f16;
                                j16 = 0;
                                int i110 = i78;
                                i79 = 9;
                                i85 = i110;
                                QZLog.i("FeedClickProcessor", 1, "mixVideoClick normal feed");
                                l1(new com.qzone.proxy.feedcomponent.model.f(i3, mixVideoIndex, false, false), businessFeedData11, view, false, null, i3);
                            }
                        } else {
                            str16 = C0;
                            businessFeedData11 = f16;
                            j16 = 0;
                            int i111 = i78;
                            i79 = 9;
                            i85 = i111;
                        }
                        if (videoInfo2 != null && videoInfo2.actionType == 23 && !TextUtils.isEmpty(videoInfo2.actionUrl)) {
                            if (!WeishiHelper.isWeishiVideoLayerScheme(videoInfo2.actionUrl) && !WeishiHelper.isWeishiScheme(videoInfo2.actionUrl) && !WeishiHelper.isVerticalNormalVideoLayerSchema(videoInfo2.actionUrl) && !WeishiHelper.isLandscapevideolayerSchema(videoInfo2.actionUrl)) {
                                yo.d.d(videoInfo2.actionUrl, Z(), null);
                            } else {
                                QZLog.i("FeedClickProcessor", 1, "VerticalVideo schema=" + videoInfo2.actionUrl);
                                if (videoInfo2.videoStatus == 1) {
                                    videoInfo2.videoStatus = 0;
                                    String C02 = QZoneWriteOperationService.v0().C0(videoInfo2.videoId);
                                    if (C02 != null) {
                                        QZLog.d("FeedClickProcessor", 1, "#\u540e\u53f0\u8f6c\u7801\u4e2d:BaseFeedClickProcessor,cachePath=" + C02);
                                        videoInfo2.videoUrl = new VideoUrl(C02);
                                    }
                                }
                                boolean z49 = view instanceof FeedAutoVideo;
                                if (z49) {
                                    FeedAutoVideo feedAutoVideo = (FeedAutoVideo) view;
                                    Object h17 = feedAutoVideo.getBaseVideoManager().h();
                                    if (h17 != null) {
                                        m3 = ((Integer) h17).intValue();
                                    } else {
                                        m3 = videoPlayInfo != null ? feedAutoVideo.getBaseVideoManager().m(videoPlayInfo.videoId) : -1L;
                                    }
                                    HashMap hashMap3 = new HashMap();
                                    VideoPlayInfo videoPlayInfo2 = new VideoPlayInfo();
                                    if (videoPlayInfo != null) {
                                        videoPlayInfo2.videoId = videoPlayInfo.videoId;
                                    }
                                    videoPlayInfo2.feedTime = m3;
                                    if (z49) {
                                        videoPlayInfo2.width = feedAutoVideo.getRealVideoWidth();
                                        videoPlayInfo2.height = feedAutoVideo.getRealVideoHeight();
                                    }
                                    if (videoPlayInfo != null) {
                                        hashMap3.put(videoPlayInfo.videoId, videoPlayInfo2);
                                    }
                                }
                                z1(T(), businessFeedData11, view, i3, this.V.S());
                            }
                        } else {
                            BusinessFeedData businessFeedData27 = businessFeedData11;
                            if (videoInfo2 != null && videoInfo2.actionType == 49) {
                                if (QZoneAdFeedDataExtKt.isDeepLink(businessFeedData27) && !QZoneAdFeedDataExtKt.isAppAd(businessFeedData27) && dm0.a.d(BaseApplication.getContext(), businessFeedData27.getOperationInfoV2().appid, businessFeedData27.getOperationInfoV2().schemaPageUrl)) {
                                    if (QZoneAdFeedDataExtKt.isGdt185AdVideo(businessFeedData27) && QZoneAdFeedDataExtKt.isGestureAd(businessFeedData27) && (feedElement == FeedElement.GESTURE_AD_VIEW || feedElement == FeedElement.GESTURE_AD_CLICK_VIEW)) {
                                        com.qzone.proxy.feedcomponent.ui.c.n(Z(), videoInfo2, i3, businessFeedData27, feedElement);
                                    } else {
                                        AdReporter.d(QZoneAdFeedDataExtKt.getGdtEffectCGIUrl(businessFeedData27), businessFeedData27.getOperationInfoV2().cookie.get(Integer.valueOf(i85)), bm0.a.f28647a);
                                        AdReporter.d(QZoneAdFeedDataExtKt.getGdtEffectCGIUrl(businessFeedData27), businessFeedData27.getOperationInfoV2().cookie.get(Integer.valueOf(i85)), bm0.a.f28649c);
                                    }
                                    z37 = dm0.a.f(GdtFeedUtilForQZone.l(), businessFeedData27.getOperationInfoV2().appid, businessFeedData27.getOperationInfoV2().schemaPageUrl, "biz_src_jc_qzone");
                                    if (z37 && (!QZoneAdFeedDataExtKt.isGdt185AdVideo(businessFeedData27) || !QZoneAdFeedDataExtKt.isGestureAd(businessFeedData27) || (feedElement != FeedElement.GESTURE_AD_VIEW && feedElement != FeedElement.GESTURE_AD_CLICK_VIEW))) {
                                        AdReporter.d(QZoneAdFeedDataExtKt.getGdtEffectCGIUrl(businessFeedData27), businessFeedData27.getOperationInfoV2().cookie.get(Integer.valueOf(i85)), bm0.a.f28648b);
                                    }
                                } else {
                                    z37 = false;
                                }
                                if (!z37) {
                                    com.qzone.proxy.feedcomponent.ui.c.n(Z(), videoInfo2, i3, businessFeedData27, feedElement);
                                }
                            } else if (videoInfo2 != null && videoInfo2.actionType == 46) {
                                BaseVideo V = V(view, i3);
                                if (V != null && V.getState() != i85) {
                                    V.doPlayVideo();
                                } else {
                                    this.V.n(businessFeedData27, i3, BaseFeedPresenter.U, R(businessFeedData27, i3), view);
                                }
                            } else {
                                if (videoInfo2 != null && videoInfo2.videoStatus == 1 && !TextUtils.isEmpty(str16)) {
                                    String str36 = str16;
                                    if (new File(str36).exists()) {
                                        ArrayList arrayList10 = new ArrayList();
                                        PictureItem pictureItem = new PictureItem();
                                        pictureItem.localFileUrl = str36;
                                        pictureItem.isSelected = true;
                                        pictureItem.videoflag = 1;
                                        VideoInfo videoInfo3 = new VideoInfo();
                                        pictureItem.videodata = videoInfo3;
                                        videoInfo3.videoId = videoInfo2.videoId;
                                        videoInfo3.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                                        VideoInfo videoInfo4 = pictureItem.videodata;
                                        videoInfo4.isAutoPlay = true;
                                        videoInfo4.videoStatus = i79;
                                        videoInfo4.height = videoInfo2.height;
                                        videoInfo4.width = videoInfo2.width;
                                        long c17 = com.qzone.util.ag.c(pictureItem.localFileUrl);
                                        VideoInfo videoInfo5 = pictureItem.videodata;
                                        if (c17 == -1) {
                                            c17 = videoInfo2.videoTime;
                                        }
                                        videoInfo5.videoTime = c17;
                                        videoInfo5.validVideoTime = videoInfo2.validVideoTime;
                                        videoInfo5.showVideoTime = videoInfo2.showVideoTime;
                                        videoInfo5.coverUrl = videoInfo2.coverUrl;
                                        HashMap<String, Long> D0 = QZoneWriteOperationService.v0().D0(videoInfo2.videoId);
                                        if (D0 != null && D0.get("videoPlayStartTime") != null && D0.get("videoPlayEndTime") != null) {
                                            Long l17 = D0.get("videoPlayStartTime");
                                            long longValue3 = D0.get("videoPlayEndTime").longValue() - l17.longValue();
                                            if (l17.longValue() >= j16 && longValue3 > j16) {
                                                pictureItem.videodata.videoId = "local_" + videoInfo2.videoId + "#" + l17 + "#" + longValue3;
                                            }
                                        }
                                        arrayList10.add(pictureItem);
                                        PictureViewerFactory.S(T(), arrayList10, 0);
                                    }
                                }
                                if ((businessFeedData27.getFeedCommInfo().isVideoAdv() && !GdtFeedUtilForQZone.p(businessFeedData27.getFeedCommInfo())) || ((videoInfo2 == null || !videoInfo2.isOpenWithFloat()) && (businessFeedData27.getOriginalInfo() == null || businessFeedData27.getOriginalInfo().getVideoInfo() == null || !businessFeedData27.getOriginalInfo().getVideoInfo().isOpenWithFloat()))) {
                                    new VideoPlaybackReportInfo();
                                    BaseVideoManager.getFeedVideoManager().D(new ArrayList());
                                    if (businessFeedData27.getFeedCommInfo().isVideoAdv()) {
                                        com.tencent.gdt.tangram.ad.qzone.d.h("FeedClickProcessor", 1, "play with advertise video float");
                                        if ((!businessFeedData27.isSupportSoundPlayOut() || businessFeedData27.getVideoInfo() == null || !businessFeedData27.getVideoInfo().isGdtAdVideoPlaying || !businessFeedData27.getVideoInfo().isGdtVideoVolumeOpened) && !QZoneAdFeedDataExtKt.isGdt585AdVideo(businessFeedData27) && businessFeedData27.isGDTAdvFeed() && videoInfo2 != null && videoInfo2.isOpenWithFloat()) {
                                            com.qzone.proxy.feedcomponent.ui.c.j(Z(), videoInfo2, null, i3, businessFeedData27.getOperationInfo().downloadUrl, businessFeedData27);
                                            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
                                            com.qzone.adapter.feedcomponent.i.H();
                                            uiInterface.feedVideoReport(businessFeedData27, i3, 3, true, 20);
                                        }
                                    } else {
                                        QZLog.i("FeedClickProcessor", 1, "play with old style video float");
                                        com.qzone.proxy.feedcomponent.ui.c.j(Z(), videoInfo2, null, i3, null, businessFeedData27);
                                        com.qzone.proxy.feedcomponent.i uiInterface2 = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
                                        com.qzone.adapter.feedcomponent.i.H();
                                        uiInterface2.feedVideoReport(businessFeedData27, i3, 3, false, 20);
                                    }
                                }
                            }
                        }
                        QZLog.i("FeedClickProcessor", 1, "end of auto video click.");
                        return;
                    }
                    return;
                case 129:
                case 130:
                    int i112 = feedElement == FeedElement.AUTO_VIDEO_REPLAY ? 21 : 6;
                    if (f16.isBrandUgcAdvFeeds()) {
                        obj2 = obj;
                    } else {
                        obj2 = obj;
                        this.V.y0(view, f16, i3, 5001, 0, 0, com.qzone.misc.network.report.f.i(0, i112), i112, 7);
                    }
                    VideoPlayInfo videoPlayInfo3 = (VideoPlayInfo) obj2;
                    if (f16.isLiveVideoFeed()) {
                        MiscReportUtils.g(view, f16, videoPlayInfo3);
                        return;
                    }
                    return;
                case 131:
                    if (obj == null || !(obj instanceof com.qzone.proxy.feedcomponent.ui.l)) {
                        return;
                    }
                    com.qzone.adapter.feedcomponent.i.H().E2(Z(), obj);
                    return;
                case 132:
                    if (f16.getVideoInfo() != null && f16.getVideoInfo().videoRemark != null && !TextUtils.isEmpty(f16.getVideoInfo().videoRemark.actionurl)) {
                        VideoInfo.VideoRemark videoRemark2 = f16.getVideoInfo().videoRemark;
                        if (2 == videoRemark2.actiontype) {
                            this.W.la(videoRemark2.actionurl, null, null);
                            return;
                        }
                        return;
                    }
                    if (this.V.n(f16, i3, BaseFeedPresenter.V, R(f16, i3), view) != 0) {
                        BaseFeedPresenter.J(f16, 5);
                        if (BaseFeedPresenter.J(f16, 5) != -1) {
                            i86 = BaseFeedPresenter.M(f16, 29, 5);
                            str17 = com.qzone.misc.network.report.f.i(0, 9);
                        } else {
                            i86 = 29;
                            str17 = null;
                        }
                        QZoneWriteOperationService.v0().L(f16.getOperationInfo().cookie, i86, 0, 0, 0, 0, true, false, null, null, 0L, false, false, str17, false, f16);
                        return;
                    }
                    return;
                case 133:
                    String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_KEY_JUMP_TO_MORE_VIDEO, QzoneConfig.DEFAULT_KEY_JUMP_TO_MORE_VIDEO_URL);
                    if (!TextUtils.isEmpty(config)) {
                        Intent intent3 = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                        QZoneHelper.openWebSecurityVerify(intent3);
                        intent3.putExtra("url", config);
                        intent3.putExtra("fromQZone", true);
                        yo.b.a(intent3);
                        i2(intent3);
                    }
                    com.qzone.adapter.feedcomponent.i.H().Z1("5", "");
                    return;
                case 134:
                    if (obj != null && (obj instanceof BusinessFeedData)) {
                        BusinessFeedData businessFeedData28 = (BusinessFeedData) obj;
                        if (businessFeedData28.getCellSpecialCare() != null) {
                            User user7 = businessFeedData28.getCellSpecialCare().userInfo;
                            if (user7 == null || user7.uin <= 0) {
                                return;
                            }
                            if (businessFeedData28.getCellSpecialCare().isSpecialCare) {
                                z5.a.f().v(user7.uin, null);
                            } else {
                                z5.a.f().a(user7.uin, null);
                            }
                            LpReportInfo_pf00064.allReport(619, 11, 2, String.valueOf(user7.uin));
                            return;
                        }
                    }
                    QZLog.e("FeedClickProcessor", "onFeedElementClick SPECIAL_CARE_IN_CONTAINER data null");
                    return;
                case 135:
                    vo.c.t(T());
                    LpReportInfo_pf00064.allReport(619, 11, 4);
                    return;
                case 136:
                    if (obj == null || !(obj instanceof BusinessFeedData)) {
                        return;
                    }
                    QZoneWriteOperationService.v0().e2(f16.currShowIndex, f16, (BusinessFeedData) obj);
                    return;
                case 137:
                    T0(view, f16, i3, obj);
                    return;
                case 138:
                    U0(view, f16, i3, obj);
                    return;
                case 139:
                    V0(view, f16, i3, obj);
                    return;
                case 140:
                    q0(view, i3, obj);
                    return;
                case 141:
                    this.V.y0(view, f16, i3, 5001, K(f16, i3, BaseFeedPresenter.S, view), 0, MiscReportUtils.e(0, 28, 0), 28, 5);
                    return;
                case 142:
                case 143:
                    if (f16.getOriginalInfo() != null && f16.getOriginalInfo().getCellBottomRecomm() != null) {
                        f16 = f16.getOriginalInfo();
                    }
                    if (f16 == null || f16.getCellBottomRecomm() == null) {
                        return;
                    }
                    String str37 = f16.getCellBottomRecomm().actionurl;
                    if (TextUtils.isEmpty(str37)) {
                        return;
                    }
                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str37) && f16.isAppShareCardFeed()) {
                        hashMap2 = new HashMap();
                        hashMap2.put("scene", 2003);
                    } else {
                        hashMap2 = null;
                    }
                    this.W.la(str37, null, hashMap2);
                    return;
                case 144:
                    if (!f16.isQCircleRecommFeed() || f16.getCellBottomRecomm() == null) {
                        return;
                    }
                    this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                    return;
                case 145:
                case 146:
                case 147:
                    QLog.d("FeedClickProcessor", 2, "FEED_QCIRCLE_TAIL_VIEW_CLICK_EVENT_TAG onclicked");
                    if ((obj instanceof BusinessFeedData) && (businessFeedData12 = (BusinessFeedData) obj) != null && businessFeedData12.getOriginalInfo() != null && businessFeedData12.getOriginalInfo().getCellBottomRecomm() != null) {
                        f16 = f16.getOriginalInfo();
                    }
                    if (f16 == null || f16.getCellBottomRecomm() == null || TextUtils.isEmpty(f16.getCellBottomRecomm().actionurl)) {
                        return;
                    }
                    this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                    return;
                case 148:
                    if ((f16.isBrandUgcAdvFeeds() || f16.isMyMediaCardAdvFeed()) && f16.getCellBottomRecomm() != null && f16.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_ADV) {
                        i1(view, i3, f16);
                        return;
                    } else {
                        if (f16.getCellBottomRecomm() != null) {
                            if (this.W != null && !TextUtils.isEmpty(f16.getCellBottomRecomm().actionurl)) {
                                this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                            }
                            TTTReportManager.s().r(12, 65, 1, System.currentTimeMillis(), true);
                            return;
                        }
                        return;
                    }
                case 150:
                    if (f16.getCellBottomRecomm() != null && this.W != null && !TextUtils.isEmpty(f16.getCellBottomRecomm().actionurl)) {
                        this.W.la(f16.getCellBottomRecomm().actionurl, null, null);
                    }
                    if (f16.getPictureInfo() != null) {
                        if (f16.getPictureInfo().isTravelAlbumData()) {
                            ClickReport.q("566", "7", "", true);
                            return;
                        }
                        if (f16.getPictureInfo().isLoverAlbumData()) {
                            ClickReport.q("566", "8", "", true);
                            return;
                        }
                        if (f16.getPictureInfo().isBabyAlbumData()) {
                            ClickReport.q("566", "9", "", true);
                            return;
                        } else if (f16.getPictureInfo().isMultiAlbumData()) {
                            ClickReport.q("566", "12", "", true);
                            return;
                        } else {
                            ClickReport.q("566", "10", "", true);
                            return;
                        }
                    }
                    return;
                case 151:
                    if (f16.isAdFeeds()) {
                        r6.a.x(f16, BaseFeedPresenter.w(f16, 12), f16.getOperationInfo().actionType, 0, i3, BaseFeedPresenter.J(f16, 5) != -1 ? com.qzone.misc.network.report.f.j(0, 20, 0) : null);
                        this.V.o0(f16, i3, false, view);
                        return;
                    }
                    return;
                case 152:
                    CellQbossPsvAdv cellQbossPsvAdv = f16.getCellQbossPsvAdv();
                    if (cellQbossPsvAdv != null) {
                        int i113 = cellQbossPsvAdv.actiontype;
                        if (i113 == 2) {
                            this.W.la(cellQbossPsvAdv.actionurl, null, null);
                        } else if (i113 == 22) {
                            this.W.xb(cellQbossPsvAdv.actionurl);
                        }
                    }
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().qbossTrace == null) {
                        return;
                    }
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(f16.getOperationInfoV2().qbossTrace, null);
                    return;
                case 153:
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().qbossTrace == null) {
                        return;
                    }
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(f16.getOperationInfoV2().qbossTrace, null);
                    return;
                case 154:
                    EventCenter.getInstance().post("WriteOperation", 38, f16.getFeedCommInfo().feedskey);
                    if (f16.getOperationInfoV2() == null || f16.getOperationInfoV2().qbossTrace == null) {
                        return;
                    }
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(f16.getOperationInfoV2().qbossTrace, null);
                    return;
                case 156:
                    String str38 = f16.getCellForwardInfo() != null ? f16.getCellForwardInfo().actionUrl : null;
                    if (!TextUtils.isEmpty(str38)) {
                        this.W.la(str38, null, null);
                    }
                    S1(f16, 3);
                    U1(f16, 32);
                    return;
                case 157:
                    if (obj instanceof String) {
                        this.W.la((String) obj, null, null);
                        if (!f16.isRecomEventTagFeed() || f16.getRecBusinessFeedDatas() == null) {
                            return;
                        }
                        if (f16.getRecBusinessFeedDatas().size() == 1) {
                            ClickReport.q("302", "557", "3", true);
                            return;
                        } else {
                            ClickReport.q("302", "557", "4", true);
                            return;
                        }
                    }
                    return;
                case 158:
                    if (f16.getRecommAction() == null || f16.getRecommAction().reportUrl == null) {
                        return;
                    }
                    final String str39 = f16.getRecommAction().reportUrl + "2001";
                    ThreadManagerV2.postImmediately(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.28
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                to.e.d(BaseFeedClickProcessor.this.V.y(), str39);
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                    }, null, true);
                    return;
                case 159:
                    QZoneFeedUtil.Z(f16, this.V.E());
                    U1(f16, 1024);
                    return;
                case 160:
                    if (f16.getOriginalInfo() == null || f16.getOriginalInfo().getFeedCommInfo() == null) {
                        return;
                    }
                    User user8 = f16.getOriginalInfo().getUser();
                    int i114 = f16.getOriginalInfo().getFeedCommInfo().operatemask;
                    if (user8 != null) {
                        com.qzone.feed.business.model.c.d().e(f16, user8.uin, i3);
                        w(T(), user8.uin, 3091, 21);
                        ClickReport.p("644", "5", "", null, true);
                        return;
                    }
                    return;
                case 161:
                    ClickReport.p("644", "6", "", null, true);
                    return;
                case 162:
                    ClickReport.p("644", "7", "", null, true);
                    return;
                case 163:
                    if (obj instanceof String) {
                        String str40 = (String) obj;
                        if (TextUtils.isEmpty(str40)) {
                            return;
                        }
                        this.W.la(str40, null, null);
                        return;
                    }
                    return;
                case 164:
                    if (f16.getFeedCommInfo() != null || GdtFeedUtilForQZone.s(f16)) {
                        EventCenter.getInstance().post("WriteOperation", 38, f16.getFeedCommInfo().feedskey);
                        CellNegativeFeedback cellNegativeFeedback = f16.cellNegativeFeedback;
                        if (cellNegativeFeedback != null && !TextUtils.isEmpty(cellNegativeFeedback.toastTxt)) {
                            ToastUtil.s(f16.cellNegativeFeedback.toastTxt, 5);
                        }
                    }
                    if (f16.isGDTAdvFeed()) {
                        return;
                    }
                    LpReportInfo_pf00064.allReport(302, 90, 4);
                    return;
                case 165:
                    if (f16.getFeedCommInfo() != null || GdtFeedUtilForQZone.s(f16)) {
                        EventCenter.getInstance().post("WriteOperation", 38, f16.getFeedCommInfo().feedskey);
                        CellNegativeFeedback cellNegativeFeedback2 = f16.cellNegativeFeedback;
                        if (cellNegativeFeedback2 != null && !TextUtils.isEmpty(cellNegativeFeedback2.toastTxt)) {
                            ToastUtil.s(f16.cellNegativeFeedback.toastTxt, 5);
                        }
                    }
                    ArrayList arrayList11 = (ArrayList) obj;
                    if (arrayList11 == null || arrayList11.size() <= 0) {
                        return;
                    }
                    ArrayList<nagative_fb_info> arrayList12 = new ArrayList<>();
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator it7 = arrayList11.iterator();
                    while (it7.hasNext()) {
                        CellNegativeFeedback.negativeFbInfo negativefbinfo = (CellNegativeFeedback.negativeFbInfo) it7.next();
                        if (negativefbinfo != null) {
                            nagative_fb_info nagative_fb_infoVar = new nagative_fb_info();
                            nagative_fb_infoVar.fb_type = negativefbinfo.fb_type;
                            nagative_fb_infoVar.fb_name = negativefbinfo.fb_name;
                            nagative_fb_infoVar.tag_type = negativefbinfo.tag_type;
                            nagative_fb_infoVar.tag_name = negativefbinfo.tag_name;
                            nagative_fb_infoVar.attach_info = negativefbinfo.attach_info;
                            arrayList12.add(nagative_fb_infoVar);
                            stringBuffer.append(negativefbinfo.fb_tag_txt);
                            stringBuffer.append(",");
                        }
                    }
                    if (f16.isGDTAdvFeed()) {
                        if (GdtFeedUtilForQZone.s(f16)) {
                            GdtFeedUtilForQZone.D(this.V.y(), arrayList11, f16);
                            if (TextUtils.isEmpty(f16.cellNegativeFeedback.toastTxt)) {
                                return;
                            }
                            ToastUtil.s(f16.cellNegativeFeedback.toastTxt, 5);
                            return;
                        }
                        return;
                    }
                    if (f16.getCellUserInfo() != null && f16.getCellUserInfo().getUser() != null) {
                        QZoneWriteOperationService.v0().m2(f16.getCellUserInfo().getUser().uin, arrayList12);
                    }
                    LpReportInfo_pf00064.allReport(302, 90, 5, stringBuffer.substring(0, stringBuffer.length() - 1));
                    return;
                case 166:
                    ap.f59791b.e(76, 1, i3, f16);
                    X0(f16, view);
                    return;
                case 167:
                    t1(f16, view);
                    return;
                case 168:
                    N0(f16, obj);
                    return;
                case 169:
                    N0(f16, obj);
                    return;
                case 170:
                    n1(f16, view, obj, false, i3);
                    return;
                case 171:
                    n1(f16, view, obj, true, i3);
                    return;
                case 172:
                    g1(view, f16, i3, obj);
                    return;
                case 173:
                    r1(view, f16, i3, obj);
                    return;
                case 174:
                    P(f16, obj);
                    return;
                case 175:
                    QZoneBaseFeedFragment qZoneBaseFeedFragment2 = this.U;
                    if (qZoneBaseFeedFragment2 == null || (wi5 = qZoneBaseFeedFragment2.wi()) == null) {
                        return;
                    }
                    wi5.b(new com.qzone.common.activities.base.k(f16));
                    return;
                case 176:
                    LpReportInfo_pf00064.allReport(115, 1, 2);
                    CommentSpanData commentSpanData = (CommentSpanData) obj;
                    ClickedComment clickedComment3 = commentSpanData.comment;
                    if (clickedComment3 != null) {
                        TextCellLayout.setJumpCmtId(clickedComment3.getComment().commentid);
                        ClickedComment clickedComment4 = commentSpanData.comment;
                        if (clickedComment4.isComment) {
                            Log.i("FeedClickProcessor", "onClick: " + commentSpanData.comment.cmtIndex + " " + commentSpanData.comment.getComment().commentid);
                        } else {
                            TextCellLayout.setJumpRepId(clickedComment4.getReply().replyId);
                            Log.i("FeedClickProcessor", "onClick: " + commentSpanData.comment.cmtIndex + " " + commentSpanData.comment.getComment().commentid + " / " + commentSpanData.comment.replyIndex + " " + commentSpanData.comment.getReply().replyId);
                        }
                    } else {
                        TextCellLayout.setIsMoreClicked(true);
                    }
                    if (f16.getFeedCommInfo().actiontype != 20 && (f16.getCellSummaryV2() == null || f16.getCellSummaryV2().actionType != 20)) {
                        this.V.o0(f16, i3, f16.feedType == 4098 && QZoneFeedUtil.S(), view);
                        return;
                    } else {
                        this.V.n(f16, i3, BaseFeedPresenter.X, R(f16, i3), view);
                        return;
                    }
                case 177:
                    d1(view, f16, 0, false, obj instanceof Boolean ? (Boolean) obj : null);
                    return;
                case 178:
                    C1(f16, obj instanceof Boolean ? (Boolean) obj : null);
                    return;
                case 179:
                    QZoneBaseFeedFragment qZoneBaseFeedFragment3 = this.U;
                    if (qZoneBaseFeedFragment3 == null || (wi6 = qZoneBaseFeedFragment3.wi()) == null) {
                        return;
                    }
                    wi6.c(new com.qzone.common.activities.base.k(f16), i3);
                    return;
                case 180:
                    ho.i.z().s(T(), f16.getUser());
                    return;
                case 181:
                    CellAlbumEntrance cellAlbumEntrance = f16.cellAlbumEntrance;
                    if (cellAlbumEntrance != null) {
                        int i115 = cellAlbumEntrance.button_actiontype;
                        if (i115 == 2) {
                            onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(cellAlbumEntrance.guideUrl, "", i3));
                        } else if (i115 == 60) {
                            p0(f16);
                        }
                        ap.f59791b.e(212, 1, i3, f16);
                        HashMap<String, String> hashMap4 = new HashMap<>();
                        hashMap4.put("_enum_action_area_feeds_entrance_button_click", 1);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qzone_feeds_games_share", true, 0L, 0L, hashMap4, null);
                        return;
                    }
                    return;
                case 182:
                    if (obj instanceof Map) {
                        Map map6 = (Map) obj;
                        try {
                            String str41 = (String) map6.get("url");
                            int intValue11 = ((Integer) map6.get("type")).intValue();
                            if (str41 == null) {
                                QZLog.w("FeedClickProcessor", "onClick: GAME_SHARE_HOT_AREA null action url");
                                return;
                            }
                            if (intValue11 != 1 || !QZoneApiProxy.isInQZoneEnvironment()) {
                                onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(str41, "", i3));
                            }
                            HashMap hashMap5 = new HashMap(1);
                            hashMap5.put(2, str41);
                            ap.f59791b.f(213, 1, i3, f16, hashMap5, null);
                            HashMap<String, String> hashMap6 = new HashMap<>();
                            hashMap6.put("_enum_action_area_hot_space_click", 1);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qzone_feeds_games_share", true, 0L, 0L, hashMap6, null);
                            return;
                        } catch (Exception e17) {
                            QZLog.w("FeedClickProcessor", "onClick: GAME_SHARE_HOT_AREA wrong type", e17);
                            return;
                        }
                    }
                    return;
                case 183:
                    if (obj instanceof Long) {
                        this.W.mh(((Long) obj).longValue(), 2, null);
                        return;
                    }
                    return;
                case 184:
                    if (obj instanceof Integer) {
                        ap.f59791b.e(((Integer) obj).intValue(), 1, i3, f16);
                        return;
                    }
                    return;
                case 185:
                    QZLog.i("FeedClickProcessor", "@adVideoPlayerExpose  FEEDVIDEO_PLAY_ADV_TIME_EXPOSE click");
                    com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(f16));
                    return;
                case 186:
                    CellUserInfo cellUserInfo3 = f16.getCellUserInfo();
                    if (cellUserInfo3 != null && cellUserInfo3.user != null) {
                        ho.i.z().l(T(), cellUserInfo3.user.uin);
                    }
                    if (f16.getFeedCommInfo().isShowGoMessageBoard()) {
                        ap.f59791b.e(155, 1, i3, f16);
                        return;
                    }
                    return;
                case 187:
                    if (!f16.isQQCircleRecomm && !f16.isRecommendQQCircleFeed()) {
                        if (!f16.isPublicAccountContent() && !f16.isPublicAccountShare()) {
                            if (!f16.isPublicAccountContainer() || !(obj instanceof BusinessFeedData) || (cellUserInfo = ((BusinessFeedData) obj).getCellUserInfo()) == null || (user3 = cellUserInfo.user) == null) {
                                return;
                            }
                            o1(view, String.valueOf(user3.uin), true);
                            return;
                        }
                        CellBottomRecomm cellBottomRecomm = f16.getCellBottomRecomm();
                        if (cellBottomRecomm == null || TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
                            return;
                        }
                        try {
                            String string = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                            if (TextUtils.isEmpty(string)) {
                                return;
                            }
                            o1(view, string, true);
                            return;
                        } catch (Exception e18) {
                            QZLog.d("FeedClickProcessor", 4, "PUBLIC_ACCOUNT_FOLLOW", e18);
                            return;
                        }
                    }
                    if (obj instanceof BusinessFeedData) {
                        User user9 = ((BusinessFeedData) obj).getCellUserInfo().user;
                        if (user9 == null) {
                            QZLog.w("FeedClickProcessor", "circle: follow null user");
                            return;
                        }
                        String l18 = Long.toString(user9.uin);
                        QZLog.i("FeedClickProcessor", "doFollowCircle: " + l18);
                        if (QZoneQQCircleFollowProxy.c().b(l18, true)) {
                            CanvasPublicAccountContainerView.addCircleCache(l18, true);
                            if (view instanceof CanvasPublicAccountContainerView) {
                                ((CanvasPublicAccountContainerView) view).updateFollowStatus(true);
                                return;
                            }
                            return;
                        }
                        ToastUtil.s("\u64cd\u4f5c\u592a\u8fc7\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 3);
                        return;
                    }
                    return;
                case 188:
                    if (!f16.isQQCircleRecomm && !f16.isRecommendQQCircleFeed()) {
                        if (!f16.isPublicAccountContent() && !f16.isPublicAccountShare()) {
                            if (!f16.isPublicAccountContainer() || !(obj instanceof BusinessFeedData) || (cellUserInfo2 = ((BusinessFeedData) obj).getCellUserInfo()) == null || (user4 = cellUserInfo2.user) == null) {
                                return;
                            }
                            o1(view, String.valueOf(user4.uin), false);
                            return;
                        }
                        CellBottomRecomm cellBottomRecomm2 = f16.getCellBottomRecomm();
                        if (cellBottomRecomm2 == null || TextUtils.isEmpty(cellBottomRecomm2.jsonData)) {
                            return;
                        }
                        try {
                            String string2 = new JSONObject(cellBottomRecomm2.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                            if (TextUtils.isEmpty(string2)) {
                                return;
                            }
                            o1(view, string2, false);
                            return;
                        } catch (Exception e19) {
                            QZLog.d("FeedClickProcessor", 4, "PUBLIC_ACCOUNT_UNFOLLOW", e19);
                            return;
                        }
                    }
                    if (obj instanceof BusinessFeedData) {
                        User user10 = ((BusinessFeedData) obj).getCellUserInfo().user;
                        if (user10 == null) {
                            QZLog.w("FeedClickProcessor", "circle: unfollow null user");
                            return;
                        } else {
                            DialogUtil.createCustomDialog(Z(), 230, (String) null, "\u662f\u5426\u53d6\u6d88\u5173\u6ce8", (String) null, "\u786e\u8ba4\u53d6\u6d88", new s(Long.toString(user10.uin), view), (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                    }
                    return;
                case 189:
                    if (!f16.isQQCircleRecomm && !f16.isRecommendQQCircleFeed()) {
                        q1(f16, obj);
                        return;
                    }
                    if (obj instanceof BusinessFeedData) {
                        BusinessFeedData businessFeedData29 = (BusinessFeedData) obj;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("circle: to circle home ");
                        if (businessFeedData29.cellOperationInfo == null) {
                            str18 = "null";
                        } else {
                            str18 = businessFeedData29.cellOperationInfo.actionType + " " + businessFeedData29.cellOperationInfo.actionUrl;
                        }
                        sb7.append(str18);
                        QZLog.d("FeedClickProcessor", 4, sb7.toString());
                        CellOperationInfo cellOperationInfo = businessFeedData29.cellOperationInfo;
                        if (cellOperationInfo != null && 23 == cellOperationInfo.actionType && !TextUtils.isEmpty(cellOperationInfo.actionUrl)) {
                            QZLog.d("FeedClickProcessor", 4, "circle schema " + businessFeedData29.cellOperationInfo.actionUrl);
                            yo.d.e(businessFeedData29.cellOperationInfo.actionUrl, Z(), null, null);
                            return;
                        }
                        User user11 = businessFeedData29.getCellUserInfo().user;
                        if (user11 == null) {
                            QZLog.w("FeedClickProcessor", "circle: to circle home null user");
                            return;
                        }
                        String l19 = Long.toString(user11.uin);
                        QZLog.d("FeedClickProcessor", 4, "circle uin " + l19);
                        HashMap<String, String> hashMap7 = new HashMap<>();
                        hashMap7.put("uin", l19);
                        try {
                            ((IQCircleService) MobileQQ.sMobileQQ.getAppRuntime(LoginData.getInstance().getUinString()).getRuntimeService(IQCircleService.class, "all")).enterBySchemeAction(Z(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_MAIN_PAGE, hashMap7);
                            return;
                        } catch (AccountNotMatchException e26) {
                            QZLog.e("FeedClickProcessor", "onClick... exception:", e26);
                            return;
                        }
                    }
                    return;
                case 190:
                    p1(f16);
                    return;
                case 191:
                    if (!(obj instanceof ComboNetImageCell) || (businessFeedData13 = businessFeedData2) == null || businessFeedData13.getCommentInfoV2() == null || businessFeedData13.getCommentInfoV2().commments == null) {
                        return;
                    }
                    ComboNetImageCell comboNetImageCell = (ComboNetImageCell) obj;
                    E1(comboNetImageCell.getUin().longValue(), comboNetImageCell.getNickName(), comboNetImageCell.getPokeZipUrl(), comboNetImageCell.getCombo());
                    return;
                case 192:
                    QZoneBaseFeedFragment qZoneBaseFeedFragment4 = this.U;
                    if (qZoneBaseFeedFragment4 != null) {
                        qZoneBaseFeedFragment4.mj(0L);
                    }
                case 193:
                    if (obj instanceof com.qzone.proxy.feedcomponent.model.m) {
                        com.qzone.proxy.feedcomponent.model.m mVar = (com.qzone.proxy.feedcomponent.model.m) obj;
                        if (mVar.d()) {
                            com.qzone.util.s.e(T(), mVar.b(), mVar.c(), mVar.a(), f16);
                        } else {
                            com.qzone.util.s.a(T(), mVar.b(), mVar.c(), mVar.a());
                        }
                    }
                default:
                    QZLog.e("FeedClickProcessor", "onClick switch to default");
                    return;
            }
        } else if (feedElement == FeedElement.AUTO_VIDEO_CLICK) {
            vo.b.m(true, f16);
        }
    }

    public void p1(BusinessFeedData businessFeedData) {
        String str;
        CellOperationInfo operationInfoV2;
        if (businessFeedData.isPublicAccountContent() || businessFeedData.isPublicAccountShare()) {
            CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
            if (cellBottomRecomm != null && !TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
                try {
                    str = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
                } catch (Exception e16) {
                    QZLog.d("FeedClickProcessor", 4, "PUBLIC_ACCOUNT_NAVIGATE_DETAIL", e16);
                }
                operationInfoV2 = businessFeedData.getOperationInfoV2();
                if (operationInfoV2 != null || TextUtils.isEmpty(str)) {
                }
                if (operationInfoV2.actionType == 63 && !TextUtils.isEmpty(operationInfoV2.actionUrl) && operationInfoV2.actionUrl.startsWith("mqqapi://qsubscribe/opendetail")) {
                    try {
                        Uri parse = Uri.parse(operationInfoV2.actionUrl);
                        com.tencent.biz.subscribe.d.p(T(), com.tencent.biz.subscribe.d.a(parse.getQueryParameter("feedId"), parse.getQueryParameter("uin"), Integer.parseInt(parse.getQueryParameter("type")), Integer.parseInt(parse.getQueryParameter("width")), Integer.parseInt(parse.getQueryParameter("height")), Long.parseLong(parse.getQueryParameter("createtime"))), 9002);
                        return;
                    } catch (Exception e17) {
                        QLog.d("FeedClickProcessor", 2, "launchSubscribeVideoDetail failed", e17);
                        return;
                    }
                }
                if (!businessFeedData.isPublicAccountShare() || TextUtils.isEmpty(operationInfoV2.qqUrl)) {
                    return;
                }
                this.W.Vc(operationInfoV2.qqUrl);
                return;
            }
            str = null;
            operationInfoV2 = businessFeedData.getOperationInfoV2();
            if (operationInfoV2 != null) {
            }
        }
    }

    protected void s1(int i3, boolean z16) {
        BusinessFeedData businessFeedData;
        QZonePullToRefreshListView Q = this.V.Q();
        if (Q == null || (businessFeedData = (BusinessFeedData) Q.j0().getItemAtPosition(i3)) == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().isHotRecommFeeds() && businessFeedData.getFeedCommInfo().isYunYingFeeds()) {
            this.V.o0(businessFeedData, i3, false, new Object[0]);
        } else if (businessFeedData.getFeedCommInfo().isHotRecommFeeds()) {
            O(businessFeedData.getFeedCommInfo().feedskey, businessFeedData);
        }
        if (z16) {
            this.V.y0(null, businessFeedData, i3, 12, 0, 0, null, 8, 5);
        }
    }

    protected void u0(String str, BusinessFeedData businessFeedData, int i3) {
        QzoneFeedVisitorReportService.f().e(businessFeedData, 5);
        this.W.t7(str, businessFeedData, i3);
    }

    protected boolean y0(int i3) {
        QZonePullToRefreshListView Q = this.V.Q();
        return Q != null && i3 >= 0 && i3 < Q.j0().getCount();
    }

    protected void y1(int i3, BusinessFeedData businessFeedData, View view, View view2) {
        ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "1");
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            ClickReport.c(580, 5, "", true, new String[0]);
        }
        X1(i3, businessFeedData, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class s implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f46056d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f46057e;

        s(String str, View view) {
            this.f46056d = str;
            this.f46057e = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            if (QZoneQQCircleFollowProxy.c().b(this.f46056d, false)) {
                CanvasPublicAccountContainerView.addCircleCache(this.f46056d, false);
                View view = this.f46057e;
                if (view instanceof CanvasPublicAccountContainerView) {
                    ((CanvasPublicAccountContainerView) view).updateFollowStatus(false);
                    return;
                }
                return;
            }
            ToastUtil.s("\u64cd\u4f5c\u592a\u8fc7\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class x implements DialogInterface.OnClickListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(BusinessFeedData businessFeedData, View view) {
        if (businessFeedData == null) {
            w5.b.b("FeedClickProcessor", 2, "[polyPraise] handlePolymorphicLike, businessFeedData = " + businessFeedData);
            return;
        }
        if (businessFeedData.getLocalInfo().isFake()) {
            w5.b.j("FeedClickProcessor", 2, "[polyPraise] handlePolymorphicLike, feeds is fake: " + businessFeedData.getLocalInfo().isFake());
            return;
        }
        if (!businessFeedData.getLocalInfo().canLike) {
            w5.b.j("FeedClickProcessor", 2, "[polyPraise] handlePolymorphicLike, feeds can like: " + businessFeedData.getLocalInfo().canLike);
            return;
        }
        if (businessFeedData.getUser().personalizedPassivePraiseId != -1 && !TextUtils.isEmpty(businessFeedData.getUser().personalizedPassivePraiseUrl)) {
            QzoneZipDownloadService.k().g(businessFeedData.getUser().personalizedPassivePraiseUrl);
        }
        P0(view, businessFeedData);
    }

    private void r1(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        String str;
        if (businessFeedData == null) {
            QZLog.i("FeedClickProcessor", 1, "onPublishQCircleClick, businessData is null");
            return;
        }
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        String str2 = "";
        if (cellAlbumEntrance == null) {
            str = "";
        } else {
            str = cellAlbumEntrance.guideUrl;
        }
        QZLog.d("FeedClickProcessor", 1, "onPublishQCircleClick, args: " + obj + ", schema: " + str);
        if (TextUtils.isEmpty(str) || !(obj instanceof FakeShuoShuoDataCacheHelper.a)) {
            return;
        }
        List<String> a16 = ((FakeShuoShuoDataCacheHelper.a) obj).a();
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 311 && businessFeedData.getCellSummaryV2() != null) {
            str2 = businessFeedData.getCellSummaryV2().summary;
        }
        qo.c.d(view.getContext(), str, new ArrayList(a16), str2);
    }

    public void C0(BusinessFeedData businessFeedData, int i3, View view) {
        MiscReportUtils.g(view, businessFeedData, null);
        J(businessFeedData, i3, BaseFeedPresenter.f46083c0, view, 0L);
    }

    public void J0(int i3, View view, Object obj, boolean z16, boolean z17, int i16) {
        if (obj instanceof FeedOperation.CommentObj) {
            FeedOperation.CommentObj commentObj = (FeedOperation.CommentObj) obj;
            K0(i3, view, commentObj.point, z16, z17, i16, false, commentObj.commentView);
        } else {
            K0(i3, view, obj, z16, z17, i16, false, null);
        }
    }

    public void Y1(ClickedComment clickedComment, int i3, boolean z16) {
        Z1(clickedComment, i3, z16, null);
    }

    void Z0(View view, BusinessFeedData businessFeedData, int i3) {
        a1(view, businessFeedData, i3, false);
    }

    public void b1(View view, BusinessFeedData businessFeedData, int i3) {
        c1(view, businessFeedData, i3, false);
    }

    protected void w(Activity activity, long j3, int i3, int i16) {
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.V.y(), 1, String.valueOf(j3), "", i3, i16, null, null, null, null, null);
        if (i3 == 3091) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.Z.getActivity(), startAddFriend, QZoneContant.QZ_REQUEST_FEED_CARD_ADD_FRIEND);
        } else {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.Z.getActivity(), startAddFriend, QZoneContant.QZ_REQUEST_FEED_ADD_FRIEND);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46003d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ClickedComment f46004e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f46005f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f46006h;

        b(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3, boolean z16) {
            this.f46003d = businessFeedData;
            this.f46004e = clickedComment;
            this.f46005f = i3;
            this.f46006h = z16;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                RDMEtraMsgCollector.getInstance().addNoramlClickAction(BaseFeedClickProcessor.this.E, view);
                BusinessFeedData businessFeedData = this.f46003d;
                if (businessFeedData == null) {
                    BaseFeedClickProcessor.this.G(this.f46004e, this.f46005f, this.f46006h);
                } else {
                    BaseFeedClickProcessor.this.H(this.f46004e, this.f46005f, this.f46006h, businessFeedData);
                }
                if (BaseFeedClickProcessor.this.K != null) {
                    BaseFeedClickProcessor.this.K.dismiss();
                }
            }
            ActionSheetHelper.dismissActionSheet(BaseFeedClickProcessor.this.T(), BaseFeedClickProcessor.this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f46018a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f46019b;

        h(long j3, String str) {
            this.f46018a = j3;
            this.f46019b = str;
        }

        @Override // com.qzone.widget.util.b.d
        public void a() {
            LpReportInfo_pf00064.report(129, 4);
            vo.c.E(BaseFeedClickProcessor.this.Z(), this.f46018a, this.f46019b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class r implements AdFeedbackDialogFragment.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46054a;

        r(BusinessFeedData businessFeedData) {
            this.f46054a = businessFeedData;
        }

        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public void onResult(AdFeedbackDialogFragment.Result result) {
            BusinessFeedData businessFeedData;
            BusinessFeedData businessFeedData2;
            if (result == null) {
                QLog.e("FeedClickProcessor", 4, "[onResult] error, params are null");
                return;
            }
            if (result.action != 3 || (businessFeedData = this.f46054a) == null || businessFeedData.getFeedCommInfo() == null || BaseFeedClickProcessor.this.V == null) {
                return;
            }
            String str = this.f46054a.getFeedCommInfo().feedskey;
            if (this.f46054a.isGDTAdvFeed()) {
                BusinessFeedData businessFeedData3 = this.f46054a;
                if (businessFeedData3.isSubFeed && (businessFeedData2 = businessFeedData3.parentFeedData) != null && businessFeedData2.getFeedCommInfo() != null) {
                    str = this.f46054a.parentFeedData.getFeedCommInfo().feedskey;
                }
            }
            this.f46054a.cellNegativeFeedback = null;
            EventCenter.getInstance().post("WriteOperation", 38, str);
            BaseFeedClickProcessor.this.V.K0(this.f46054a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class v implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f46065a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46066b;

        v(long j3, BusinessFeedData businessFeedData) {
            this.f46065a = j3;
            this.f46066b = businessFeedData;
        }

        @Override // com.qzone.widget.util.b.d
        public void a() {
            LpReportInfo_pf00064.report(129, 3);
            vo.c.E(BaseApplication.getContext(), this.f46065a, BaseFeedClickProcessor.this.k2(this.f46066b));
        }
    }

    private boolean B(PolymorphicPraiseData polymorphicPraiseData) {
        if (polymorphicPraiseData == null) {
            w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, praiseData = " + polymorphicPraiseData);
            return false;
        }
        ArrayList<PolymorphicPraiseEmotionData> arrayList = polymorphicPraiseData.emotionDatas;
        if (arrayList == null) {
            w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, praiseData.emotionDatas = " + polymorphicPraiseData.emotionDatas);
            return false;
        }
        if (arrayList.size() > 0) {
            return true;
        }
        w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, emotionDatas size = " + polymorphicPraiseData.emotionDatas.size());
        return false;
    }

    private void F(BusinessFeedData businessFeedData, int i3, View view) {
        HashMap hashMap;
        if (businessFeedData == null || businessFeedData.getCellAdvContainerAttach() == null || !businessFeedData.isGDTAdvFeed()) {
            return;
        }
        CellAdvContainerAttach cellAdvContainerAttach = businessFeedData.getCellAdvContainerAttach();
        int i16 = cellAdvContainerAttach.actiontype;
        if (i16 != 2) {
            if (i16 == 20) {
                this.V.o(businessFeedData, i3, BaseFeedPresenter.Y, view);
                return;
            } else {
                if (i16 != 22) {
                    return;
                }
                this.W.xb(cellAdvContainerAttach.actionurl);
                return;
            }
        }
        if (this.W == null || TextUtils.isEmpty(cellAdvContainerAttach.actionurl)) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().needAdvReport()) {
            hashMap = new HashMap();
            hashMap.put("businessFeedData", businessFeedData);
        } else {
            hashMap = null;
        }
        if (businessFeedData.isGDTAdvFeed()) {
            return;
        }
        this.W.la(cellAdvContainerAttach.actionurl + "&acttype=51", null, hashMap);
    }

    private void I(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3, boolean z16) {
        String str;
        long j3;
        String str2 = businessFeedData.getFeedCommInfo().ugckey;
        int i16 = businessFeedData.getFeedCommInfo().appid;
        if (z16) {
            str = businessFeedData.getOriginalInfoSafe().getIdInfo().cellId;
            j3 = businessFeedData.getOriginalInfoSafe().getUser().uin;
        } else {
            str = businessFeedData.getIdInfo().cellId;
            j3 = businessFeedData.getUser().uin;
        }
        String str3 = str;
        long j16 = j3;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<Integer, String> map2 = map;
        if (clickedComment.getReply() != null) {
            QZoneWriteOperationService.v0().c0(0, this.V.E(), str2, i16, j16, str3, clickedComment.getComment().user.uin, clickedComment.getComment().commentid, 0, clickedComment.getReply().user.uin, clickedComment.getReply().replyId, map2, clickedComment.getReply().isFake, i3);
        } else {
            QZoneWriteOperationService.v0().S(0, this.V.E(), str2, i16, j16, str3, clickedComment.getComment().user.uin, clickedComment.getComment().commentid, 0, map2, clickedComment.getComment().isFake, 0, i3);
        }
    }

    private void I1(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getReferInfoV2() == null) {
            return;
        }
        CellReferInfo referInfoV2 = businessFeedData.getReferInfoV2();
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(302, 58, 2);
        lpReportInfo_pf00064.reserves3 = referInfoV2.appName;
        lpReportInfo_pf00064.reserves4 = referInfoV2.actionUrl;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private int J(BusinessFeedData businessFeedData, int i3, int i16, View view, long j3) {
        if (businessFeedData == null) {
            return 0;
        }
        User user = businessFeedData.getUser();
        if (user != null) {
            int i17 = user.actiontype;
            if (i17 == 2 && !QZoneAdFeedDataExtKt.isLocalAd(businessFeedData)) {
                this.W.la(user.actionurl, null, null);
                return i17;
            }
            if (businessFeedData.getCellUserInfo().actionType == 23) {
                this.W.la(user.actionurl, null, null);
                return i17;
            }
            return M(businessFeedData, i3, i16, view, j3);
        }
        return M(businessFeedData, i3, i16, view, j3);
    }

    private void N0(BusinessFeedData businessFeedData, Object obj) {
        if (businessFeedData != null && (obj instanceof ClickedComment) && QZoneFeedUtil.l(businessFeedData, 19)) {
            ClickedComment clickedComment = (ClickedComment) obj;
            Comment comment = clickedComment.getComment();
            Reply reply = clickedComment.getReply();
            if (reply == null) {
                M0(businessFeedData, comment);
                if (clickedComment.isDoubleClickComment) {
                    LpReportInfo_pf00064.allReport(720, 1);
                    return;
                } else {
                    if (comment != null) {
                        if (comment.isliked) {
                            LpReportInfo_pf00064.allReport(720, 3, 2);
                            return;
                        } else {
                            LpReportInfo_pf00064.allReport(720, 3, 1);
                            return;
                        }
                    }
                    return;
                }
            }
            if (QZoneFeedUtil.T()) {
                v1(businessFeedData, comment, reply);
                LpReportInfo_pf00064.allReport(210, 1);
                if (clickedComment.isDoubleClickComment) {
                    LpReportInfo_pf00064.allReport(210, 3, 2);
                }
            }
        }
    }

    private b.h O0(BusinessFeedData businessFeedData, Comment comment) {
        if (QZoneFeedUtil.l(businessFeedData, 19)) {
            return new y(businessFeedData, comment);
        }
        return null;
    }

    private void R1(ArrayList<PictureItem> arrayList, int i3) {
        PictureItem pictureItem;
        if (arrayList == null || arrayList.size() == 0 || i3 >= arrayList.size() || (pictureItem = arrayList.get(i3)) == null) {
            return;
        }
        int i16 = pictureItem.flag;
        if (i16 == 32 || i16 == 16) {
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("qzone_feed_panorama", "click", 0);
        }
    }

    private void S1(BusinessFeedData businessFeedData, int i3) {
        String str;
        if (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getUser() == null) {
            return;
        }
        if (businessFeedData.getUser().isSafeModeUser == 1) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(201, i3, 1, str, "0", businessFeedData.getFeedCommInfo().feedsid);
    }

    private void U1(BusinessFeedData businessFeedData, int i3) {
        if (i3 == 1) {
            if (businessFeedData.getLikeInfo() == null || businessFeedData.getLikeInfo().isLiked) {
                QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_click_like_area request!!!");
                return;
            }
            return;
        }
        if (i3 == 8) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_click_likenum_area request!!!");
            return;
        }
        if (i3 == 16) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_click_commentnum_area request!!!");
            return;
        }
        if (i3 == 32) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_click_forwardnum_area request!!!");
            return;
        }
        if (i3 == 64) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_Func_click_avatar_area request!!!");
            return;
        }
        if (i3 == 128) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_Func_click_nickname_area request!!!");
        } else if (i3 == 256) {
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_Func_enter_video_supernatant_area request!!!");
        } else {
            if (i3 != 1024) {
                return;
            }
            QZLog.d("QZoneFeedFollowRecommService", 2, "_enum_click_sec_forward_area request!!!");
        }
    }

    private String W1(View view, VideoInfo videoInfo) {
        long k06 = view != null ? k0(view) : 0L;
        if (videoInfo.actionUrl.indexOf("current_time=") >= 0) {
            videoInfo.actionUrl = videoInfo.actionUrl.substring(0, videoInfo.actionUrl.indexOf("current_time=") + 13) + Long.toString(k06);
        } else {
            videoInfo.actionUrl += "&current_time=" + Long.toString(k06);
        }
        return videoInfo.actionUrl;
    }

    private BusinessFeedData g0(View view, BusinessFeedData businessFeedData, FeedElement feedElement, Object obj) {
        int intValue;
        int i3;
        if (businessFeedData == null) {
            return businessFeedData;
        }
        if (!businessFeedData.getFeedCommInfo().isBizRecomFeeds() && businessFeedData.getRecBusinessFeedDatas() == null) {
            return businessFeedData;
        }
        try {
            if (feedElement == FeedElement.FEEDBACK) {
                return businessFeedData;
            }
            boolean z16 = (!businessFeedData.getFeedCommInfo().isBizRecomFeeds() || businessFeedData.getFeedCommInfo().isSubOfMultiAdvContainerFeed || businessFeedData.isRecomEventTagFeed() || businessFeedData.isRecomMyEventTagContainerFeed()) ? false : true;
            if (!businessFeedData.isAdvContainerThreeGridStyle() && !businessFeedData.isFrdLikeVideoContainer() && !businessFeedData.isFriendLikeVerticalSlideContainer()) {
                if (businessFeedData.isSingleAdvContainerFeed()) {
                    AbsFeedView b16 = c6.a.b(view);
                    if (b16 != null && b16.mFeedData.isSubFeed) {
                        view = b16;
                    }
                    intValue = Integer.parseInt(view.getTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE)).toString());
                } else {
                    intValue = view.getTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE)) != null ? Integer.parseInt(view.getTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE)).toString()) : -1;
                    if (intValue == -1) {
                        if (businessFeedData.getRecBusinessFeedDatas() == null || (i3 = businessFeedData.currShowIndex) < 0 || i3 >= businessFeedData.getRecBusinessFeedDatas().size()) {
                            return businessFeedData;
                        }
                        intValue = businessFeedData.currShowIndex;
                    }
                }
                this.V.Q0(intValue);
                if (businessFeedData.getRecBusinessFeedDatas() == null && !businessFeedData.getRecBusinessFeedDatas().isEmpty()) {
                    if (businessFeedData.isFriendBirthdayContainerFeed()) {
                        intValue = businessFeedData.currShowIndex;
                    }
                    BusinessFeedData businessFeedData2 = businessFeedData.getRecBusinessFeedDatas().get(intValue);
                    if (businessFeedData2 != null && z16) {
                        try {
                            if (businessFeedData2.getFeedCommInfo().recomtype != 7) {
                                QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
                                mVar.f45734a = businessFeedData2.getFeedCommInfo().ugckey;
                                mVar.f45735b = businessFeedData2.getFeedCommInfo().interestkey;
                                mVar.f45736c = null;
                                mVar.f45738e = true;
                                mVar.f45739f = businessFeedData2.getFeedCommInfo().appid;
                                mVar.f45740g = businessFeedData2.getOperationInfo().busiParam;
                                mVar.f45741h = 0;
                                mVar.f45742i = -1;
                                mVar.f45744k = businessFeedData2.getFeedCommInfo().isTodayInHistoryFeed();
                                if (businessFeedData2.isLiveVideoFeed() && businessFeedData2.isSubFeed) {
                                    MiscReportUtils.h(view, businessFeedData2, intValue, feedElement);
                                } else {
                                    MiscReportUtils.d(view, businessFeedData2, intValue, feedElement);
                                }
                            }
                        } catch (Exception e16) {
                            e = e16;
                            businessFeedData = businessFeedData2;
                            QZLog.e(QZLog.TO_DEVICE_TAG, e.toString());
                            return businessFeedData;
                        }
                    }
                    return businessFeedData2;
                }
            }
            if (!(obj instanceof com.qzone.proxy.feedcomponent.model.f)) {
                return businessFeedData;
            }
            intValue = Integer.valueOf(((com.qzone.proxy.feedcomponent.model.f) obj).a()).intValue();
            this.V.Q0(intValue);
            return businessFeedData.getRecBusinessFeedDatas() == null ? businessFeedData : businessFeedData;
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void j2(View view, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && (view instanceof CanvasTitleView)) {
            f2(businessFeedData, (CanvasTitleView) view);
            return;
        }
        w5.b.b("FeedClickProcessor", 1, "[highFive].startHighFiveAnimation, businessFeedData = " + businessFeedData + ", v = " + view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k2(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getCellSummaryV2() != null) {
            Map<String, String> map = businessFeedData.getCellSummaryV2().mapExt;
            if (map != null && map.containsKey("diy_font_id") && !TextUtils.isEmpty(map.get("diy_font_id"))) {
                return "font";
            }
            if (map != null && map.containsKey("sparkle_json") && !TextUtils.isEmpty(map.get("sparkle_json"))) {
                return "colorFont";
            }
            return "default";
        }
        return "default";
    }

    private void l2(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getLikeInfoV2() == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        CellLikeInfo likeInfo = businessFeedData.getLikeInfo();
        likeInfo.likeNum--;
    }

    public static void s0(SuperLikeView superLikeView) {
        if (superLikeView != null) {
            ViewParent parent = superLikeView.getParent();
            while (parent != null) {
                parent = parent.getParent();
                if (parent instanceof QZonePullToRefreshListView) {
                    superLikeView.setDisallowInterceptTouchEvent((ViewGroup) parent);
                    return;
                }
            }
        }
    }

    private boolean w0(BusinessFeedData businessFeedData, View view, Object obj) {
        return (businessFeedData != null && businessFeedData.getOriginalInfo() != null && (view instanceof CanvasFeedContentView) && ((CanvasFeedContentView) view).isForward) || (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue() && ((view instanceof FeedVideoView) || (view instanceof CanvasTitleView)));
    }

    private b.h w1(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        if (QZoneFeedUtil.l(businessFeedData, 19)) {
            return new z(businessFeedData, comment, reply);
        }
        return null;
    }

    private void z0(BusinessFeedData businessFeedData, CellPictureInfo cellPictureInfo) {
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid != 4) {
            this.V.j0(businessFeedData, 0, false);
            return;
        }
        if (businessFeedData.isForwardFeed()) {
            vo.b.c(Z(), cellPictureInfo.albumid.split(":")[0], Long.valueOf(cellPictureInfo.uin), cellPictureInfo.albumname, QZoneAlbumUtil.t(cellPictureInfo.anonymity), cellPictureInfo.individualAlbum);
        } else {
            vo.b.c(Z(), cellPictureInfo.albumid, Long.valueOf(cellPictureInfo.uin), cellPictureInfo.albumname, QZoneAlbumUtil.t(cellPictureInfo.anonymity), cellPictureInfo.individualAlbum);
        }
        LpReportInfo_pf00064.report(302, 81, 0);
    }

    public void C1(BusinessFeedData businessFeedData, Boolean bool) {
        boolean booleanValue;
        if (businessFeedData == null || businessFeedData.getLocalInfo().isFake()) {
            return;
        }
        if (bool == null) {
            booleanValue = !businessFeedData.getDissInfo().dissed;
        } else {
            booleanValue = bool.booleanValue();
        }
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = businessFeedData.getFeedCommInfo().ugckey;
        mVar.f45735b = businessFeedData.getFeedCommInfo().curlikekey;
        mVar.f45736c = businessFeedData.getFeedCommInfo().orglikekey;
        mVar.f45738e = booleanValue;
        mVar.f45739f = businessFeedData.getFeedCommInfo().appid;
        mVar.f45740g = businessFeedData.getOperationInfo().busiParam;
        mVar.f45742i = -1;
        mVar.f45744k = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        QZoneBaseFeedFragment qZoneBaseFeedFragment = this.U;
        com.qzone.feed.business.service.a si5 = qZoneBaseFeedFragment == null ? null : qZoneBaseFeedFragment.si();
        if (si5 != null) {
            mVar.f45745l = si5.f47216d;
        }
        mVar.f45754u = businessFeedData;
        mVar.f45755v = businessFeedData.feedType;
        QZoneWriteOperationService.v0().f0(this.V.E(), mVar);
    }

    void D0(BusinessFeedData businessFeedData) {
        CellFollowGuide cellFollowGuide;
        if (businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null) {
            return;
        }
        int i3 = cellFollowGuide.action_type;
        if ((i3 == 2 || i3 == 20) && !TextUtils.isEmpty(cellFollowGuide.action_url)) {
            this.W.la(businessFeedData.cellFollowGuide.action_url, null, null);
        }
    }

    protected void E0(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().customDroplist == null) {
            return;
        }
        try {
            Iterator<s_droplist_option> it = businessFeedData.getFeedCommInfo().customDroplist.iterator();
            while (it.hasNext()) {
                FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), ap.a(), it.next().reporttype, 19, 0, false, null, false, 0L);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void G0(View view, BusinessFeedData businessFeedData, int i3, int i16) {
        if (businessFeedData == null || businessFeedData.getLocalInfo().isFake() || !businessFeedData.getLocalInfo().canLike) {
            return;
        }
        boolean z16 = businessFeedData.getLikeInfo().isLiked;
        if (view != null && (view instanceof AbsFeedView)) {
            f1((AbsFeedView) view, businessFeedData, !z16);
        }
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = businessFeedData.getFeedCommInfo().ugckey;
        mVar.f45735b = businessFeedData.getFeedCommInfo().curlikekey;
        mVar.f45736c = businessFeedData.getFeedCommInfo().orglikekey;
        mVar.f45738e = !z16;
        mVar.f45739f = businessFeedData.getFeedCommInfo().appid;
        mVar.f45740g = businessFeedData.getOperationInfo().busiParam;
        mVar.f45742i = i16;
        mVar.f45744k = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        com.qzone.feed.business.service.a si5 = this.U.si();
        if (si5 != null) {
            mVar.f45745l = si5.f47216d;
        }
        mVar.f45746m = 0;
        mVar.f45749p = i3;
        CustomPraiseData g16 = QzoneCustomPraiseService.i().g();
        if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
            g16 = businessFeedData.getUser().customPraiseData;
        }
        mVar.f45748o = g16;
        QZoneWriteOperationService.v0().u1(this.V.E(), mVar);
        if (!z16 && businessFeedData.getFeedCommInfo().recomtype == 7) {
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            int S = this.V.S();
            com.qzone.adapter.feedcomponent.i.H();
            H.U1(S, "3");
        }
        if (businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            return;
        }
        ClickReport.c(580, 7, "", true, new String[0]);
    }

    protected int S(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return 0;
        }
        int i3 = businessFeedData.getFeedCommInfo().actiontype;
        return (i3 != 20 || businessFeedData.getOperationInfo().actionType == 0) ? i3 : businessFeedData.getOperationInfo().actionType;
    }

    public void e2(e.a aVar, Serializable serializable, Parcelable parcelable, String str, boolean z16, int i3) {
        Intent G = QZoneFeedUtil.G(Z(), aVar, serializable, parcelable, this.f45949d, true, 1, str, z16, i3);
        String str2 = this.U.simpleClassname;
        G.putExtra("extra_key_from_scene", -1);
        G.putExtra("from_ttt_page_id", ap.a());
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
            QzonePluginProxyActivity.setActivityNameToIntent(G, QZoneHelper.QZONE_FEEDACTIONPANELACTIVITY);
        }
        if (aVar.f47480m) {
            this.Z.startActivityForResult(G, aVar.f47476i);
            EditPositionBag editPositionBag = this.f45949d;
            if (editPositionBag != null) {
                editPositionBag.a(ViewUtils.getScreenHeight() - ViewUtils.dpToPx(250.0f));
                return;
            }
            return;
        }
        this.Z.startActivityForResult(G, aVar.f47476i);
    }

    public void l0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.getGiftInfo() == null) {
            return;
        }
        this.W.h5(businessFeedData.getUser().uin, businessFeedData.getGiftInfo().giftBackId);
    }

    protected void t0(String str) {
        u0(str, null, 0);
    }

    private void G1(BusinessFeedData businessFeedData, int i3, int i16) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
            com.qzone.adapter.feedcomponent.i.H().y(12, 72, 1, System.currentTimeMillis(), null, businessFeedData, i3, i16 + 1);
        } else {
            com.qzone.adapter.feedcomponent.i.H().z(12, 72, 1, System.currentTimeMillis(), businessFeedData, i3, i16 + 1);
        }
    }

    private void H1(BusinessFeedData businessFeedData, boolean z16, int i3, int i16) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
            com.qzone.adapter.feedcomponent.i.H().y(12, z16 ? 201 : 202, 1, System.currentTimeMillis(), null, businessFeedData, i3, i16 + 1);
        } else {
            com.qzone.adapter.feedcomponent.i.H().z(12, z16 ? 201 : 202, 1, System.currentTimeMillis(), businessFeedData, i3, i16 + 1);
        }
    }

    private void n2(AbsFeedView absFeedView, BusinessFeedData businessFeedData, CellLikeInfo.LikeMan likeMan, int i3) {
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        if (i3 != -1 && (polymorphicPraiseEmotionData = this.P) != null) {
            likeMan.polymorphicPraiseData = polymorphicPraiseEmotionData;
            polymorphicPraiseEmotionData.pokeCombo = this.Q;
            CellDecorateInfo cellDecorateInfo = businessFeedData.getCellDecorateInfo();
            if (cellDecorateInfo == null) {
                cellDecorateInfo = new CellDecorateInfo();
            }
            cellDecorateInfo.cellPolymorphicPraise = this.P.toCellPolymorphicPraise();
            businessFeedData.cellDecorateInfo = cellDecorateInfo;
            absFeedView.updateLikeInfo(businessFeedData);
            return;
        }
        w5.b.b("FeedClickProcessor", 1, "[polyPraise].updatePolymorphicPraiseList, position = " + i3 + ", mPolyEmotionData = " + this.P);
    }

    private void q1(BusinessFeedData businessFeedData, Object obj) {
        String str;
        BusinessFeedData businessFeedData2;
        CellUserInfo cellUserInfo;
        User user;
        String str2;
        if (businessFeedData == null) {
            return;
        }
        if (!businessFeedData.isPublicAccountContent() && !businessFeedData.isPublicAccountShare()) {
            if (!businessFeedData.isPublicAccountContainer() || !(obj instanceof BusinessFeedData) || (cellUserInfo = (businessFeedData2 = (BusinessFeedData) obj).getCellUserInfo()) == null || (user = cellUserInfo.user) == null) {
                return;
            }
            try {
                str2 = String.valueOf(user.uin);
            } catch (Exception e16) {
                QZLog.d("FeedClickProcessor", 4, "PUBLIC_ACCOUNT_NAVIGATE_HOME", e16);
                str2 = null;
            }
            CellOperationInfo operationInfoV2 = businessFeedData2.getOperationInfoV2();
            if (operationInfoV2 == null || TextUtils.isEmpty(str2) || operationInfoV2.actionType != 63 || operationInfoV2.actionUrl == null) {
                return;
            }
            com.tencent.biz.subscribe.d.v(null, str2, 9002);
            return;
        }
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        if (cellBottomRecomm != null && !TextUtils.isEmpty(cellBottomRecomm.jsonData)) {
            try {
                str = new JSONObject(cellBottomRecomm.jsonData).getString(IPublicAccountBrowser.KEY_PUB_UIN);
            } catch (Exception e17) {
                QZLog.d("FeedClickProcessor", 4, "PUBLIC_ACCOUNT_NAVIGATE_HOME", e17);
            }
            if (cellBottomRecomm != null || TextUtils.isEmpty(str)) {
            }
            com.tencent.biz.subscribe.d.v(null, str, 9002);
            return;
        }
        str = null;
        if (cellBottomRecomm != null) {
        }
    }

    protected void D1(CellLeftThumb cellLeftThumb) {
        long j3;
        String str;
        String str2;
        if (cellLeftThumb == null) {
            return;
        }
        try {
            j3 = Long.parseLong(cellLeftThumb.getPicActionUrl());
        } catch (NumberFormatException e16) {
            QZLog.e("FeedClickProcessor", "LEFT_THUMB_PIC " + e16.toString());
            j3 = 0;
        }
        if (cellLeftThumb.getPictureItem() != null && cellLeftThumb.getPictureItem().musicInfo != null) {
            str = cellLeftThumb.getPictureItem().musicInfo.musicMid;
            str2 = cellLeftThumb.getPictureItem().musicInfo.musicNUrl;
        } else {
            str = "";
            str2 = "";
        }
        e8.f.a().b().i(new SongInfo(j3, str, str2), cellLeftThumb.getTitle(), cellLeftThumb.getSummary(), c6.a.a(cellLeftThumb));
    }

    protected void H(ClickedComment clickedComment, int i3, boolean z16, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        I(businessFeedData, clickedComment, i3, z16);
    }

    protected boolean S0(com.qzone.proxy.feedcomponent.model.f fVar, BusinessFeedData businessFeedData, View view) {
        CellPictureInfo pictureInfo;
        Map<Integer, String> map;
        if (businessFeedData == null || businessFeedData.isFakeFeed()) {
            return false;
        }
        int a16 = fVar.a();
        BusinessFeedData originalInfoSafe = businessFeedData.getOriginalInfoSafe();
        if (businessFeedData.getPictureInfo() != null) {
            pictureInfo = businessFeedData.getPictureInfo();
        } else {
            pictureInfo = originalInfoSafe.getPictureInfo();
        }
        if (pictureInfo == null) {
            return false;
        }
        if (a16 >= pictureInfo.pics.size()) {
            a16 = pictureInfo.pics.size() - 1;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        PictureItem pictureItem = pictureInfo.pics.get(a16);
        if (pictureItem != null && (map = pictureItem.busi_param) != null) {
            String str = map.get(81);
            String str2 = pictureItem.busi_param.get(80);
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && !TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                long parseLong = Long.parseLong(str2);
                long parseLong2 = Long.parseLong(str);
                long j3 = parseLong2 < parseLong ? parseLong : parseLong2;
                this.W.X8(pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
                this.W.j3(pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, parseLong, j3);
                return true;
            }
            this.W.X8(pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
            return true;
        }
        this.W.X8(pictureInfo.albumid, Long.valueOf(businessFeedData.getUser().uin), pictureInfo.albumname, t16, pictureInfo.individualAlbum);
        return true;
    }

    protected void f1(View view, BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null) {
            return;
        }
        businessFeedData.getLikeInfo().isLiked = z16;
        m2(view, businessFeedData, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void m2(View view, BusinessFeedData businessFeedData, boolean z16) {
        CustomPraiseData g16;
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        if (businessFeedData == null) {
            return;
        }
        ArrayList<CellLikeInfo.LikeMan> arrayList = businessFeedData.getLikeInfo().likeMans;
        int i3 = 0;
        if (z16) {
            User user = new User();
            user.uin = LoginData.getInstance().getUin();
            user.nickName = LoginData.getInstance().getNickName(null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<CellLikeInfo.LikeMan> it = arrayList.iterator();
                while (it.hasNext()) {
                    CellLikeInfo.LikeMan next = it.next();
                    if (next.user.uin == LoginData.getInstance().getUin()) {
                        if (view instanceof AbsFeedView) {
                            n2((AbsFeedView) view, businessFeedData, next, this.N);
                            return;
                        }
                        return;
                    }
                }
            } else {
                arrayList = new ArrayList<>();
                businessFeedData.getLikeInfo().likeMans = arrayList;
            }
            if (businessFeedData.isGDTAdvFeed()) {
                if (businessFeedData.getCellDecorateInfo() != null && businessFeedData.getCellDecorateInfo().cellCustomPraise != null) {
                    g16 = com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
                    if (g16 == null) {
                        if (g16.praiseType == 1) {
                            g16.comboCount = 20L;
                        }
                        arrayList.add(0, new CellLikeInfo.LikeMan(user, 2, g16));
                        if (!businessFeedData.isGDTAdvFeed()) {
                            CellDecorateInfo cellDecorateInfo = businessFeedData.getCellDecorateInfo();
                            if (cellDecorateInfo == null) {
                                cellDecorateInfo = new CellDecorateInfo();
                            }
                            cellDecorateInfo.cellCustomPraise = g16.toCellCustomPraise();
                            cellDecorateInfo.cellPolymorphicPraise = null;
                            businessFeedData.cellDecorateInfo = cellDecorateInfo;
                        }
                    } else if (this.N != -1 && (polymorphicPraiseEmotionData = this.P) != null) {
                        arrayList.add(0, new CellLikeInfo.LikeMan(user, 3, null, polymorphicPraiseEmotionData));
                        CellDecorateInfo cellDecorateInfo2 = businessFeedData.getCellDecorateInfo();
                        if (cellDecorateInfo2 == null) {
                            cellDecorateInfo2 = new CellDecorateInfo();
                        }
                        cellDecorateInfo2.cellPolymorphicPraise = this.P.toCellPolymorphicPraise();
                        businessFeedData.cellDecorateInfo = cellDecorateInfo2;
                    } else {
                        if (businessFeedData.cellDecorateInfo != null && !businessFeedData.isGDTAdvFeed()) {
                            CellDecorateInfo cellDecorateInfo3 = businessFeedData.cellDecorateInfo;
                            cellDecorateInfo3.cellCustomPraise = null;
                            cellDecorateInfo3.cellPolymorphicPraise = null;
                        }
                        arrayList.add(0, new CellLikeInfo.LikeMan(user, 0, null));
                    }
                    businessFeedData.getLikeInfo().likeNum++;
                }
                g16 = null;
                if (g16 == null) {
                }
                businessFeedData.getLikeInfo().likeNum++;
            } else {
                if (this.N == -1) {
                    g16 = QzoneCustomPraiseService.i().g();
                    if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                        g16 = businessFeedData.getUser().customPraiseData;
                    }
                    if (g16 == null) {
                    }
                    businessFeedData.getLikeInfo().likeNum++;
                }
                g16 = null;
                if (g16 == null) {
                }
                businessFeedData.getLikeInfo().likeNum++;
            }
        } else if (businessFeedData.isSecretFeed()) {
            if (arrayList != null) {
                arrayList.clear();
            }
            if (!businessFeedData.cellLikeInfo.isLiked) {
                businessFeedData.getLikeInfo().likeNum--;
            }
        } else if (arrayList != null) {
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i3).user.uin == LoginData.getInstance().getUin()) {
                    arrayList.remove(i3);
                    l2(businessFeedData);
                    break;
                }
                i3++;
            }
        }
        if (businessFeedData.getFeedCommInfo().isBizRecomFeeds() && businessFeedData.getCellCount() != null && businessFeedData.getCellCount().type == 1) {
            if (z16) {
                businessFeedData.getCellCount().num++;
            } else {
                businessFeedData.getCellCount().num--;
            }
        }
        if (view instanceof AbsFeedView) {
            ((AbsFeedView) view).updateLikeInfo(businessFeedData);
        }
    }

    protected void u1(AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null) {
            return;
        }
        businessFeedData.getCellRecommendListSafe().isRecommended = z16;
        if (absFeedView != null) {
            CellRecommendList cellRecommendListSafe = businessFeedData.getCellRecommendListSafe();
            ArrayList<CellRecommendList.RecommendMan> arrayList = cellRecommendListSafe.recommendMans;
            int i3 = 0;
            if (z16) {
                User user = new User();
                user.uin = LoginData.getInstance().getUin();
                user.nickName = LoginData.getInstance().getNickName(null);
                if (arrayList == null || arrayList.size() < 1) {
                    arrayList = new ArrayList<>();
                    cellRecommendListSafe.recommendMans = arrayList;
                }
                arrayList.add(0, new CellRecommendList.RecommendMan(user));
                cellRecommendListSafe.num++;
            } else if (arrayList != null) {
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i3).user.uin == LoginData.getInstance().getUin()) {
                        arrayList.remove(i3);
                        cellRecommendListSafe.num--;
                        break;
                    }
                    i3++;
                }
            }
            if (absFeedView instanceof FeedView) {
                ((FeedView) absFeedView).updateRecommendListInfo(businessFeedData);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007a, code lost:
    
        if (java.lang.Integer.valueOf(r7).intValue() == 1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isCardFriendsRecommendContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 10, 6);
            return;
        }
        if (businessFeedData.isSpecialCareInContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 11, 6);
            return;
        }
        int i3 = 1;
        if (businessFeedData.isFunctionGuideFeed()) {
            if (businessFeedData.getCellGuiding() != null) {
                if (businessFeedData.getCellGuiding().guiding_type == 1) {
                    LpReportInfo_pf00064.allReport(619, 4, 3);
                    return;
                } else {
                    if (businessFeedData.getCellGuiding().guiding_type == 4) {
                        LpReportInfo_pf00064.allReport(619, 3, 3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (!businessFeedData.isFriendAnniversaryFeed() || businessFeedData.getCellGuiding() == null) {
            return;
        }
        CellGuiding cellGuiding = businessFeedData.getCellGuiding();
        if (cellGuiding.guiding_type == 5) {
            Map<String, String> map = cellGuiding.extendInfo;
            if (map != null) {
                String str = map.get("sub_guide_type");
                if (!TextUtils.isEmpty(str)) {
                }
            }
            i3 = 2;
            LpReportInfo_pf00064.allReport(619, 15, 2, String.valueOf(i3));
            return;
        }
        ArrayList<User> arrayList = cellGuiding.vecUsers;
        if (arrayList != null) {
            if (arrayList.size() > 2) {
                LpReportInfo_pf00064.allReport(619, 13, 4, "");
                return;
            }
            Iterator<User> it = cellGuiding.vecUsers.iterator();
            while (it.hasNext()) {
                User next = it.next();
                if (next != null) {
                    long uin = LoginData.getInstance().getUin();
                    long j3 = next.uin;
                    if (uin != j3) {
                        LpReportInfo_pf00064.allReport(619, 7, 4, String.valueOf(j3));
                    }
                }
            }
        }
    }

    public void B0(CellReferInfo cellReferInfo, BusinessFeedData businessFeedData) {
        AppInfo appInfo;
        if (cellReferInfo == null) {
            return;
        }
        try {
            appInfo = com.qzone.business.plusunion.business.a.h().e(Integer.valueOf(cellReferInfo.appid).intValue());
        } catch (Exception unused) {
            appInfo = null;
        }
        if (appInfo == null && !TextUtils.isEmpty(cellReferInfo.actionUrl)) {
            this.W.la(cellReferInfo.actionUrl, null, null);
            return;
        }
        ClickReport.s(cellReferInfo.appid, cellReferInfo.appName, "qzone3rdapp", 302, 5, 0);
        I1(businessFeedData);
        if (com.qzone.business.plusunion.business.a.h().b(appInfo)) {
            com.qzone.business.plusunion.business.a.h().u(Z(), appInfo);
            return;
        }
        try {
            Integer.valueOf(cellReferInfo.appid);
            Intent c16 = ak.c(Z());
            c16.putExtra(QZoneAppIntroActivity.H, cellReferInfo.appid);
            this.Z.startActivityForResult(c16, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED);
        } catch (Exception unused2) {
        }
    }

    protected int K(BusinessFeedData businessFeedData, int i3, int i16, Object... objArr) {
        if (businessFeedData == null) {
            return 0;
        }
        int i17 = businessFeedData.getRecommAction().actionType;
        if (businessFeedData.getRecommAction().actionType == 20) {
            i17 = this.V.n(businessFeedData, i3, i16, R(businessFeedData, i3), objArr);
        } else if (businessFeedData.getRecommAction().actionType == 21) {
            this.V.q(null, businessFeedData, i3, true, false, false);
        }
        if (businessFeedData.isFriendPlayingRecomm()) {
            ap.f59791b.e(26, 1, i3, businessFeedData);
        }
        return i17;
    }

    protected int N(BusinessFeedData businessFeedData, int i3, int i16, View view) {
        if (businessFeedData == null) {
            return 0;
        }
        int i17 = businessFeedData.getLeftThumb().getuserActionType();
        if (businessFeedData.getLeftThumb().getuserActionType() == 5) {
            this.W.mh(businessFeedData.getLeftThumb().getUser().uin, 0, R(businessFeedData, i3));
            return i17;
        }
        if (businessFeedData.getLeftThumb().getuserActionType() == 20) {
            return this.V.n(businessFeedData, i3, i16, R(businessFeedData, i3), view);
        }
        if (businessFeedData.getLeftThumb().getuserActionType() != 28 && businessFeedData.getLeftThumb().getuserActionType() != 29) {
            if (businessFeedData.getLeftThumb().getuserActionType() == 30) {
                if (businessFeedData.getOperationInfoV2() == null || businessFeedData.getOperationInfoV2().busiParam == null) {
                    return i17;
                }
                String str = businessFeedData.getOperationInfoV2().busiParam.get(75);
                if (TextUtils.isEmpty(str)) {
                    return i17;
                }
                ToastUtil.s(str, 4);
                return i17;
            }
            if (businessFeedData.getLeftThumb().getuserActionType() == 6) {
                return i17;
            }
            this.W.mh(businessFeedData.getLeftThumb().getUser().uin, 0, R(businessFeedData, i3));
            return i17;
        }
        if (businessFeedData.getOriginalInfoSafe() == null || businessFeedData.getOriginalInfoSafe().getUser() == null) {
            return i17;
        }
        this.W.La(businessFeedData, i16);
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Y(BusinessFeedData businessFeedData) {
        User user;
        if (businessFeedData == null || (user = businessFeedData.getUser()) == null || TextUtils.isEmpty(user.nickName)) {
            return null;
        }
        return com.qzone.util.l.a(com.tencent.mobileqq.R.string.jy7) + user.nickName + ":";
    }

    private void T1(BusinessFeedData businessFeedData) {
        String str;
        String str2 = businessFeedData.getFeedCommInfoV2() == null ? null : businessFeedData.getFeedCommInfoV2().feedskey;
        if (LoginData.getInstance().getUin() == businessFeedData.getUser().uin) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(201, 5, 2, (String) null, str2, str);
    }

    private void A1(BusinessFeedData businessFeedData, Object obj, int i3) {
        BusinessFeedData businessFeedData2;
        LpReportInfo_pf00064 lpReportInfo_pf00064;
        String str;
        if (obj == null || !(obj instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length >= 4) {
            long longValue = ((Long) objArr[0]).longValue();
            BusinessFeedData businessFeedData3 = (BusinessFeedData) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            int intValue2 = ((Integer) objArr[3]).intValue();
            if (businessFeedData3 != null) {
                QZoneWriteOperationService.v0().l2(longValue, !businessFeedData3.getFeedCommInfo().isSpecialFollowed, (businessFeedData == null || !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) ? 22 : 39, this.V.E(), businessFeedData3.getFeedCommInfo().feedskey, i3, businessFeedData3.getFeedCommInfo().needAdvReport(), businessFeedData3.getOperationInfo().cookie, businessFeedData3.getFeedCommInfo().isInstalled, businessFeedData3, false, 0);
                if (businessFeedData == null || businessFeedData3.getFeedCommInfo() == null) {
                    return;
                }
                boolean z16 = !businessFeedData3.getFeedCommInfo().isSpecialFollowed;
                if (businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                    if (z16) {
                        str = "2";
                    } else {
                        str = "3";
                    }
                    lpReportInfo_pf00064 = new LpReportInfo_pf00064("721", str);
                    businessFeedData2 = businessFeedData3;
                    H1(businessFeedData2, z16, intValue, intValue2);
                } else {
                    businessFeedData2 = businessFeedData3;
                    lpReportInfo_pf00064 = null;
                }
                if (lpReportInfo_pf00064 != null) {
                    lpReportInfo_pf00064.reserves2 = Integer.toString(intValue2 + 1);
                    if (businessFeedData2.getRecommItem() != null && businessFeedData2.getRecommItem().userInfo != null) {
                        lpReportInfo_pf00064.reserves4 = Integer.toString(businessFeedData2.getRecommItem().userInfo.curUserType);
                    }
                    LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
                }
            }
        }
    }

    public static void C(BusinessFeedData businessFeedData, User user, boolean z16) {
        int i3;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || user == null) {
            return;
        }
        int i16 = 6;
        int i17 = z16 ? 6 : 5;
        if (1 == businessFeedData.getFeedCommInfo().feedsType) {
            i3 = 3;
        } else {
            int i18 = businessFeedData.feedType;
            i3 = (4097 == i18 || i18 == 0) ? 1 : 2 == i18 ? 2 : 5;
        }
        if (i3 == 1) {
            i3 = 5;
        }
        UserMedal userMedal = user.famousSpaceMedal;
        if (userMedal != null) {
            long j3 = userMedal.userTypeReport;
            if (j3 != 46) {
                i16 = j3 == 47 ? 4 : j3 == 54 ? 5 : j3 == 57 ? 1 : j3 == 52 ? 3 : j3 == 48 ? 2 : (int) j3;
            }
        } else {
            i16 = -1;
        }
        int i19 = ((i16 == -1 || i16 == 0) && userMedal != null && userMedal.userTypeReport == 48) ? 2 : i16;
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(15, i17, i3);
        lpReportInfo_pf00064.reserves3 = String.valueOf(i19);
        lpReportInfo_pf00064.toUin = user.uin;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, !z16, false);
        if (QZLog.isColorLevel()) {
            QZLog.d("FeedClickProcessor", 1, "clickOrExposureReport feedType = " + i3 + ", accountType = " + i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(BusinessFeedData businessFeedData, Comment comment) {
        if (businessFeedData == null || comment == null) {
            return;
        }
        if (TextUtils.isEmpty(comment.commentLikekey)) {
            w5.b.b("FeedClickProcessor", 1, "onCommentLike, commentLikekey is null");
            return;
        }
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = businessFeedData.getFeedCommInfo().appid;
        kVar.f45702i = businessFeedData.getOperationInfo().busiParam;
        kVar.f45697d = businessFeedData.getFeedCommInfo().feedskey;
        kVar.f45696c = businessFeedData.getFeedCommInfo().ugckey;
        kVar.f45698e = businessFeedData.getFeedCommInfo().orglikekey;
        kVar.f45694a = businessFeedData.getUser().uin;
        if (comment.user != null) {
            kVar.f45699f = comment.commentLikekey + "/" + comment.user.uin;
        } else {
            kVar.f45699f = comment.commentLikekey;
        }
        kVar.f45703j = comment.commentid;
        kVar.f45700g = !comment.isliked;
        kVar.f45695b = comment.user;
        kVar.f45705l = 0;
        kVar.f45706m = businessFeedData.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        if (businessFeedData.feedType == 4098) {
            comment.isliked = !comment.isliked;
        }
        QZoneWriteOperationService.v0().t1(this.V.E(), kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018f A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void L0(int i3, Object obj, CellTextView.OnTextOperater onTextOperater) {
        h hVar;
        b.h hVar2;
        b.g gVar;
        BusinessFeedData d06;
        h hVar3;
        b.h hVar4;
        h hVar5;
        b.g gVar2;
        ArrayList<PictureItem> arrayList;
        String str;
        long j3;
        String str2;
        b.h w16;
        g gVar3 = new g(onTextOperater);
        if (obj instanceof ClickedComment) {
            ClickedComment clickedComment = (ClickedComment) obj;
            if (y0(i3) && (d06 = d0(i3)) != null) {
                Comment comment = clickedComment.getComment();
                Reply reply = clickedComment.getReply();
                boolean z16 = false;
                boolean z17 = comment != null ? comment.isCanJubao : false;
                boolean z18 = reply != null ? reply.isCanJubao : false;
                if (comment != null) {
                    if (reply != null) {
                        j3 = reply.user.uin;
                        str2 = QZoneFeedUtil.o(reply);
                    } else if (QZoneFeedUtil.n(comment) != null) {
                        j3 = comment.user.uin;
                        str2 = QZoneFeedUtil.n(comment);
                    } else {
                        j3 = 0;
                        str2 = null;
                    }
                    h hVar6 = str2 == null ? null : new h(j3, str2);
                    if (reply == null) {
                        w16 = O0(d06, comment);
                    } else if (QZoneFeedUtil.T()) {
                        w16 = w1(d06, comment, reply);
                    } else {
                        hVar3 = hVar6;
                    }
                    hVar4 = w16;
                    hVar3 = hVar6;
                    if (comment != null) {
                        if (comment.isPrivate || ((str = comment.displayStr) != null && str.endsWith("[em]e10011[/em]"))) {
                            z16 = true;
                        }
                        if (!z16 && reply != null && !TextUtils.isEmpty(reply.content)) {
                            User user = comment.user;
                            if (user == null || user.uin != LoginData.getInstance().getUin()) {
                                hVar5 = hVar3;
                                gVar2 = new i(d06, comment, clickedComment, reply, i3);
                            }
                        } else {
                            hVar5 = hVar3;
                            if (!z16 && !TextUtils.isEmpty(comment.comment) && ((arrayList = comment.pictureItems) == null || arrayList.size() <= 0)) {
                                gVar2 = new j(comment, d06, i3);
                            }
                            gVar2 = null;
                        }
                        if ((reply == null && reply.user.uin == LoginData.getInstance().getUin()) || ((reply == null && comment != null && comment.user.uin == LoginData.getInstance().getUin()) || d06.getUser().uin == LoginData.getInstance().getUin())) {
                            if (reply != null && !TextUtils.isEmpty(reply.replyId)) {
                                if (!d06.getLocalInfo().canDelReply) {
                                    if (z18) {
                                        com.qzone.widget.util.b.l(Z(), gVar3, new l(d06, comment, reply), gVar2, hVar5);
                                        return;
                                    } else {
                                        com.qzone.widget.util.b.i(Z(), gVar3, gVar2, hVar5, null);
                                        return;
                                    }
                                }
                            } else if (!d06.getLocalInfo().canDelComment) {
                                if (z17) {
                                    com.qzone.widget.util.b.l(Z(), gVar3, new m(d06, comment), gVar2, hVar5);
                                    return;
                                } else {
                                    com.qzone.widget.util.b.i(Z(), gVar3, gVar2, hVar5, null);
                                    return;
                                }
                            }
                            if (!z17 && !z18) {
                                com.qzone.widget.util.b.k(T(), gVar3, new p(clickedComment, i3), gVar2, hVar5, hVar4);
                                return;
                            } else {
                                com.qzone.widget.util.b.m(Z(), gVar3, new n(d06, comment, reply), new o(clickedComment, i3), gVar2, hVar5);
                                return;
                            }
                        }
                        if (!z17 || z18) {
                            com.qzone.widget.util.b.l(Z(), gVar3, new q(d06, comment, reply), gVar2, hVar5);
                            return;
                        } else {
                            hVar = hVar5;
                            hVar2 = hVar4;
                            gVar = gVar2;
                        }
                    }
                    hVar5 = hVar3;
                    gVar2 = null;
                    if (reply == null) {
                    }
                    if (z17) {
                    }
                    com.qzone.widget.util.b.l(Z(), gVar3, new q(d06, comment, reply), gVar2, hVar5);
                    return;
                }
                hVar3 = null;
                hVar4 = null;
                if (comment != null) {
                }
                hVar5 = hVar3;
                gVar2 = null;
                if (reply == null) {
                }
                if (z17) {
                }
                com.qzone.widget.util.b.l(Z(), gVar3, new q(d06, comment, reply), gVar2, hVar5);
                return;
            }
            return;
        }
        hVar = null;
        hVar2 = null;
        gVar = null;
        com.qzone.widget.util.b.i(Z(), gVar3, gVar, hVar, hVar2);
    }

    protected int M(BusinessFeedData businessFeedData, int i3, int i16, View view, long j3) {
        if (businessFeedData == null) {
            return 0;
        }
        int i17 = businessFeedData.getCellUserInfo().actionType;
        if (businessFeedData.getCellUserInfo().actionType == 5) {
            if (j3 != 0) {
                this.W.mh(j3, 0, R(businessFeedData, i3));
                return i17;
            }
            this.W.mh(businessFeedData.getUser().uin, 0, R(businessFeedData, i3));
            return i17;
        }
        if (businessFeedData.getCellUserInfo().actionType == 20) {
            return this.V.n(businessFeedData, i3, i16, R(businessFeedData, i3), view);
        }
        if (businessFeedData.getCellUserInfo().actionType == 6) {
            return i17;
        }
        if (j3 != 0) {
            this.W.mh(j3, 0, R(businessFeedData, i3));
            return i17;
        }
        this.W.mh(businessFeedData.getUser().uin, 0, R(businessFeedData, i3));
        return i17;
    }

    public void c1(View view, BusinessFeedData businessFeedData, int i3, boolean z16) {
        d1(view, businessFeedData, i3, z16, null);
    }

    protected void h1(Integer num, Integer num2, BusinessFeedData businessFeedData) {
        if (num == null || businessFeedData == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            businessFeedData.getCommentInfo().commentState = CellCommentInfo.CommentState.LOADING;
            QZoneFeedService.U().Z(businessFeedData, this.V.E());
        } else if (intValue == 1) {
            businessFeedData.getCommentInfo().commentState = CellCommentInfo.CommentState.UNFOLD;
            this.W.H8();
        } else {
            if (intValue != 2) {
                return;
            }
            businessFeedData.getCommentInfo().commentState = CellCommentInfo.CommentState.FOLDED;
            this.W.H8();
        }
    }

    /* JADX WARN: Type inference failed for: r6v7, types: [com.qzone.common.activities.titlebuilder.a, com.qzone.feed.ui.activity.f] */
    private void n1(BusinessFeedData businessFeedData, View view, Object obj, final boolean z16, int i3) {
        w5.b.i("FeedClickProcessor", 1, "[polyPraise].onPolymorphicLike, long clicked!, needAutoShow: " + z16);
        if (businessFeedData != null && this.U != null) {
            if (businessFeedData.isCommentPokeLike()) {
                return;
            }
            if (!z16 || QZoneFeedUtil.d()) {
                if (this.U.xh() != 0 && this.U.xh().isRefreshing()) {
                    w5.b.i("FeedClickProcessor", 2, "[polyPraise] onPolymorphicLike, current page is refreshing!");
                    return;
                }
                final boolean isRecommendFeed = businessFeedData.isRecommendFeed();
                if (z16 && isRecommendFeed) {
                    w5.b.i("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, is recommend feed");
                    return;
                }
                if (!QZoneFeedUtil.l(businessFeedData, 21)) {
                    w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, server error, operatemask2 = " + businessFeedData.getFeedCommInfo().operatemask2);
                    return;
                }
                if (!F1()) {
                    w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, low-end mobile");
                    return;
                }
                if (obj instanceof SuperLikeView) {
                    PolymorphicLikeWindow polymorphicLikeWindow = this.M;
                    if (polymorphicLikeWindow != null) {
                        if (polymorphicLikeWindow.isShowing()) {
                            w5.b.i("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, polymorphic like panel has showing");
                            return;
                        } else if (z16 && this.M.hasInitialized()) {
                            w5.b.a("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, polymorphic has been initialized");
                            return;
                        }
                    }
                    PokeLikeWizard pokeLikeWizard = PokeLikeWizard.INSTANCE;
                    if (pokeLikeWizard.isLoadingGlobalData()) {
                        ToastUtil.s(PolymorphicLikeWindow.K, 3);
                        return;
                    }
                    final SuperLikeView superLikeView = (SuperLikeView) obj;
                    PolymorphicLikeWindow polymorphicLikeWindow2 = new PolymorphicLikeWindow(Z(), superLikeView, view, f0(), true);
                    this.M = polymorphicLikeWindow2;
                    polymorphicLikeWindow2.setFeedData(i3, businessFeedData);
                    if (!this.M.isShowing()) {
                        PolymorphicPraiseData polyPraiseData = QzonePolymorphicPraiseService.getInstance().getPolyPraiseData();
                        if (!pokeLikeWizard.isGlobalPokeItemDataEmpty() || B(polyPraiseData)) {
                            this.R = false;
                            this.M.setPolymorphicLikeData(isRecommendFeed, polyPraiseData);
                            this.M.enableTouchDelegate();
                            s0(superLikeView);
                            this.M.setClippingEnabled(isRecommendFeed);
                            this.M.setOnItemClickListener(new ab(z16, businessFeedData, view));
                            w5.b.i("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, set polymorphic data, isDiscover page: " + isRecommendFeed);
                            QzoneHandlerThreadFactory.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor.40
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BaseFeedClickProcessor.this.M.hasFirstFrameLoaded()) {
                                        BaseFeedClickProcessor.this.M.showPolymorphicPanel(superLikeView, isRecommendFeed ? false : z16);
                                    } else {
                                        BaseFeedClickProcessor.this.M.retryShowPolymorphicPanel(superLikeView, isRecommendFeed ? false : z16);
                                    }
                                }
                            }, (long) QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_POLY_PRAISE, QzoneConfig.SECONDARY_POLY_PRELOAD_TIME, 200));
                            return;
                        }
                        return;
                    }
                    w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, show = " + this.M.isShowing());
                    return;
                }
                w5.b.b("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, obj = " + obj);
                return;
            }
            return;
        }
        w5.b.i("FeedClickProcessor", 2, "[polyPraise].onPolymorphicLike, businessFeedData = " + businessFeedData + ", baseFeedActivity = " + this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        if (comment == null || reply == null || businessFeedData == null) {
            return;
        }
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = businessFeedData.getFeedCommInfo().appid;
        kVar.f45702i = businessFeedData.getOperationInfo().busiParam;
        kVar.f45697d = businessFeedData.getFeedCommInfo().feedskey;
        kVar.f45696c = businessFeedData.getFeedCommInfo().ugckey;
        kVar.f45698e = businessFeedData.getFeedCommInfo().orglikekey;
        kVar.f45694a = businessFeedData.getUser().uin;
        kVar.f45704k = reply.replyId;
        kVar.f45699f = reply.replyLikeKey;
        kVar.f45703j = comment.commentid;
        kVar.f45700g = !reply.isliked;
        kVar.f45695b = reply.user;
        kVar.f45705l = 2;
        kVar.f45706m = businessFeedData.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        QZoneWriteOperationService.v0().v1(this.V.E(), kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(View view, FriendBirthdayGift friendBirthdayGift, int i3, QZoneResult qZoneResult) {
        if (friendBirthdayGift == null || view == null) {
            return;
        }
        friendBirthdayGift.hasSent = qZoneResult != null && qZoneResult.getSucceed();
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onBirthdayGiftSendResult(view, i3, friendBirthdayGift.hasSent);
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(com.tencent.mobileqq.R.string.f173017gi1);
        } else {
            if (qZoneResult == null || qZoneResult.getSucceed()) {
                return;
            }
            ToastUtil.r(qZoneResult.getMessage());
        }
    }

    public void d1(View view, BusinessFeedData businessFeedData, int i3, boolean z16, Boolean bool) {
        e1(view, businessFeedData, i3, z16, bool, false);
    }

    public void K0(int i3, View view, Object obj, boolean z16, boolean z17, int i16, boolean z18, View view2) {
        int i17;
        int i18;
        int i19;
        String str;
        String str2;
        int i26;
        int i27;
        String str3;
        int i28;
        String str4;
        int i29;
        QZonePullToRefreshListView Q = this.V.Q();
        BusinessFeedData businessFeedData = (BusinessFeedData) this.V.F(i3, false);
        if (businessFeedData == null) {
            return;
        }
        if (view2 != null && ap.d()) {
            v0();
            D();
            this.U.tj(this.f45947b0);
            this.f45954i.setVisibility(0);
            this.f45954i.setOnStartListener(new c(view2));
            this.f45954i.setOnEndListener(new d(view2));
        }
        if (businessFeedData.isHideSecretComment()) {
            i17 = FeedActionPanelActivity.I1;
        } else {
            i17 = FeedActionPanelActivity.J1;
        }
        String str5 = "";
        if (obj instanceof Integer) {
            if (view instanceof FrameLayout) {
                if (businessFeedData.getLocalInfo().canComment) {
                    i19 = (int) ((FeedGlobalEnv.g().getDensity() * 40.0f) + (FeedGlobalEnv.g().getDensity() * 2.0f));
                    i18 = i17;
                    str3 = "";
                    str = str3;
                    str2 = str;
                    i27 = 1;
                    i26 = -1;
                }
            } else if (view instanceof com.qzone.adapter.feedcomponent.r) {
                str3 = com.qzone.util.l.a(com.tencent.mobileqq.R.string.f171636jy0);
                i19 = (int) ((FeedGlobalEnv.g().getDensity() * 40.0f) + (FeedGlobalEnv.g().getDensity() * 2.0f));
                i18 = i17;
                str = "";
                str2 = str;
                i27 = 1;
                i26 = -1;
            }
            i18 = i17;
            i19 = 0;
            str3 = "";
            str = str3;
            str2 = str;
            i27 = 1;
            i26 = -1;
        } else if (!(obj instanceof ClickedComment)) {
            i18 = i17;
            i19 = 0;
            str = "";
            str2 = str;
            i26 = -1;
            i27 = 2;
            str3 = str2;
        } else {
            ClickedComment clickedComment = (ClickedComment) obj;
            if (clickedComment.getComment() != null && clickedComment.getComment().user != null) {
                if (clickedComment.getReply() != null) {
                    if (clickedComment.getReply().user.uin == LoginData.getInstance().getUin()) {
                        if (businessFeedData.getLocalInfo().canDelReply) {
                            Z1(clickedComment, i3, false, businessFeedData);
                            return;
                        }
                        return;
                    }
                } else if (clickedComment.getComment().user.uin == LoginData.getInstance().getUin()) {
                    if (businessFeedData.getLocalInfo().canDelComment) {
                        Z1(clickedComment, i3, false, businessFeedData);
                        return;
                    }
                    return;
                }
                this.V.N0(clickedComment);
                String str6 = clickedComment.getComment().commentid;
                if (clickedComment.getComment().isPrivate) {
                    i28 = FeedActionPanelActivity.K1;
                } else {
                    i28 = FeedActionPanelActivity.I1;
                }
                if (clickedComment.getReply() != null) {
                    str4 = clickedComment.getReply().replyId;
                    str3 = com.qzone.util.l.a(com.tencent.mobileqq.R.string.jy6) + clickedComment.getReply().user.nickName + ":";
                } else {
                    str3 = com.qzone.util.l.a(com.tencent.mobileqq.R.string.f171637jy1) + clickedComment.getComment().user.nickName + ":";
                    str4 = "";
                }
                str2 = str4;
                i26 = 1208;
                str = str6;
                i27 = 0;
                i18 = i28;
                i19 = 0;
            } else {
                QZLog.e("FeedClickProcessor", "comment is null!!");
                return;
            }
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = i0().getString(com.tencent.mobileqq.R.string.glb);
        }
        this.V.P0(i3);
        if (Q != null) {
            EditPositionBag h16 = EditPositionBag.h(hashCode());
            this.f45949d = h16;
            h16.f60222e = new WeakReference<>(Q.j0());
            this.f45949d.f60223f = new WeakReference<>(Q);
            if (!Q.k0()) {
                this.f45949d.f60230m = j0();
            }
            this.f45949d.f60228k = Q.h0();
            this.f45949d.e(i3, view, i27, i19);
        }
        if (i26 == -1) {
            i26 = 1207;
        }
        if (businessFeedData.isFeedCommentInsertImage()) {
            i29 = FeedActionPanelActivity.M1;
        } else {
            i29 = FeedActionPanelActivity.L1;
        }
        int x46 = FeedActionPanelActivity.x4(businessFeedData);
        boolean v46 = TextUtils.isEmpty(str) ? FeedActionPanelActivity.v4(businessFeedData) : false;
        boolean z19 = i29 > 0 && (view instanceof GuideCommentBar) && businessFeedData.feedType == 4097;
        boolean l3 = QZoneFeedUtil.l(businessFeedData, 17);
        Map<Integer, String> map = businessFeedData.getOperationInfoV2() != null ? businessFeedData.getOperationInfoV2().busiParam : null;
        if (businessFeedData.getFeedCommInfoV2() != null) {
            str5 = businessFeedData.getFeedCommInfoV2().sqDynamicFeedsKey;
        }
        e.a aVar = new e.a();
        aVar.f47468a = str3;
        aVar.f47469b = null;
        aVar.f47470c = str;
        aVar.f47471d = str2;
        aVar.f47472e = x46;
        aVar.f47473f = v46;
        aVar.f47475h = i18;
        aVar.f47476i = i26;
        aVar.f47477j = null;
        aVar.f47478k = z16;
        aVar.f47480m = z17;
        aVar.f47481n = l3;
        aVar.f47479l = z18;
        aVar.f47483p = map;
        aVar.f47484q = str5;
        aVar.f47482o = false;
        e2(aVar, 0, ParcelableWrapper.obtain(businessFeedData), businessFeedData.getFeedCommInfo() != null ? businessFeedData.getFeedCommInfo().feedskey : null, z19, i29);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Y0(View view, BusinessFeedData businessFeedData, CellLeftThumb cellLeftThumb, int i3, boolean z16) {
        int i16;
        Object obj;
        int i17;
        Object obj2;
        boolean z17;
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isSecretFeed()) {
            if (businessFeedData.getFeedCommInfo().actionurl != null) {
                yo.d.d(businessFeedData.getFeedCommInfo().actionurl, U(), null);
                return;
            }
            return;
        }
        int actionType = cellLeftThumb.getActionType();
        String actionUrl = cellLeftThumb.getActionUrl();
        if (businessFeedData.getFeedCommInfo().isVideoAdvShareFeed() && !TextUtils.isEmpty(actionUrl)) {
            if (z16) {
                ClickReport.t("3", "", businessFeedData.getLeftThumb().getActionUrl(), true);
            } else {
                ClickReport.t("2", "", businessFeedData.getLeftThumb().getActionUrl(), true);
            }
        }
        if (z16) {
            if (!businessFeedData.isAdFeeds()) {
                i17 = 0;
                obj2 = "isNativeLikeWebview";
                z17 = true;
                str = actionUrl;
                this.V.y0(view, businessFeedData, i3, 21, actionType, 0, null, 22, 5);
            } else {
                i17 = 0;
                obj2 = "isNativeLikeWebview";
                z17 = true;
                str = actionUrl;
                this.V.y0(view, businessFeedData, i3, 5001, actionType, 0, com.qzone.misc.network.report.f.i(3, 22), 22, 5);
            }
            if (actionType == 14) {
                onClick(view, FeedElement.PHOTO, i3, new com.qzone.proxy.feedcomponent.model.f(i3, Integer.valueOf(i17).intValue(), z17));
                return;
            }
            if (actionType == 3) {
                try {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setDataAndType(parse, "video/mp4");
                    i2(intent);
                    return;
                } catch (Exception unused) {
                    onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(cellLeftThumb.getActionUrl(), cellLeftThumb.getPostDatas(), i3));
                    return;
                }
            }
            if (actionType == 13) {
                t0(cellLeftThumb.getActionUrl());
                return;
            }
            if (actionType == z17) {
                int i18 = i17;
                this.V.o0(businessFeedData, i3, i18, new Object[i18]);
                return;
            }
            int i19 = i17;
            if (actionType == 0) {
                this.V.o0(businessFeedData, i3, i19, new Object[i19]);
                return;
            }
            if (cellLeftThumb.getPicActionType() == 24) {
                this.V.h0();
                D1(cellLeftThumb);
                return;
            }
            if (33 == cellLeftThumb.getPicActionType()) {
                this.V.h0();
                e8.f.a().b().e(cellLeftThumb.getPicActionUrl(), cellLeftThumb.getActionUrl(), cellLeftThumb.getTitle(), cellLeftThumb.getSummary(), c6.a.a(cellLeftThumb));
                return;
            }
            if (actionType == 45) {
                HashMap hashMap = new HashMap();
                hashMap.put(obj2, Boolean.TRUE);
                yo.d.e(str, Z(), null, hashMap);
                return;
            }
            String str2 = str;
            if (actionType == 46) {
                vo.b.l(Z(), businessFeedData.getOriginalInfo(), null, i19);
                return;
            } else if (!TextUtils.isEmpty(str2) && actionType != 11 && actionType != 20) {
                onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(cellLeftThumb.getActionUrl(), cellLeftThumb.getPostDatas(), i3));
                return;
            } else {
                this.V.o0(businessFeedData, i3, i19, new Object[i19]);
                return;
            }
        }
        if (!businessFeedData.isAdFeeds()) {
            i16 = 23;
            obj = "isNativeLikeWebview";
            this.V.y0(view, businessFeedData, i3, 22, actionType, 0, null, 23, 5);
        } else {
            i16 = 23;
            obj = "isNativeLikeWebview";
            this.V.y0(view, businessFeedData, i3, 5001, actionType, 0, com.qzone.misc.network.report.f.i(3, 23), 23, 5);
        }
        if (cellLeftThumb.getActionType() != 2 && cellLeftThumb.getActionType() != i16) {
            if (cellLeftThumb.getActionType() == 45) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(obj, Boolean.TRUE);
                yo.d.e(cellLeftThumb.getActionUrl(), Z(), null, hashMap2);
                return;
            }
            if (actionType == 46) {
                vo.b.l(Z(), businessFeedData.getOriginalInfo(), null, false);
                return;
            } else {
                this.V.o0(businessFeedData, i3, false, new Object[0]);
                return;
            }
        }
        onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(cellLeftThumb.getActionUrl(), cellLeftThumb.getPostDatas(), i3));
    }

    private void j1(View view, BusinessFeedData businessFeedData, Object obj, int i3) {
        if (businessFeedData != null) {
            CellFollowGuide cellFollowGuide = businessFeedData.cellFollowGuide;
            if (cellFollowGuide != null) {
                int i16 = cellFollowGuide.action_type;
                if (i16 == 2 || i16 == 20) {
                    this.W.la(cellFollowGuide.action_url, null, null);
                    int i17 = businessFeedData.cellFollowGuide.feed_type;
                    if (i17 == 0) {
                        LpReportInfo_pf00064.allReport(302, 86, 2);
                        return;
                    } else {
                        if (i17 == 3) {
                            TTTReportManager.s().f(12, 66, 1, System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (businessFeedData.isCoupleFeed() && (this.U instanceof QZoneMyFeedFragment)) {
                ClickReport.m("308", "76", "2");
            }
            if (businessFeedData.isNewGuideFeed()) {
                LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(302, 102, 2);
                lpReportInfo_pf00064.reserves3 = businessFeedData.getCellGuiding().guiding_type + "";
                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
            }
            if (this.U instanceof QZoneMyFeedFragment) {
                if (obj != null && (obj instanceof Boolean)) {
                    if (((Boolean) obj).booleanValue()) {
                        this.V.o0(businessFeedData, i3, true, view);
                    } else {
                        if (businessFeedData.isAdFeeds()) {
                            this.V.y0(view, businessFeedData, i3, 5001, 0, 0, com.qzone.misc.network.report.f.i(3, 26), 26, 5);
                        }
                        this.V.o0(businessFeedData, i3, false, view);
                    }
                } else {
                    if (businessFeedData.isAdFeeds()) {
                        this.V.y0(view, businessFeedData, i3, 5001, 0, 0, com.qzone.misc.network.report.f.i(3, 1000), 1000, 5);
                    }
                    this.V.o0(businessFeedData, i3, true, view);
                }
                if ((view instanceof CanvasCellCommentView) && businessFeedData.isAdFeeds() && !(this.U instanceof QZoneMyFeedFragment)) {
                    this.V.y0(view, businessFeedData, 0, 3, businessFeedData.getOperationInfo().actionType, 0, null, 27, 5);
                    return;
                }
                return;
            }
            if (businessFeedData.isPublicAccountContent()) {
                p1(businessFeedData);
                return;
            }
            if (businessFeedData.isThirdLiveVideoFeed()) {
                C0(businessFeedData, i3, view);
                return;
            }
            if (businessFeedData.isGDTAdvFeed() && !businessFeedData.isBrandUgcAdvFeeds() && !businessFeedData.isMyMediaCardAdvFeed()) {
                int n3 = this.V.n(businessFeedData, i3, BaseFeedPresenter.f46083c0, R(businessFeedData, i3), view);
                if (businessFeedData.isCanvasAd()) {
                    this.V.y0(view, businessFeedData, i3, 5001, n3, 0, MiscReportUtils.e(0, 1000, 0), 1000, 5);
                    return;
                } else {
                    this.V.y0(view, businessFeedData, i3, 9, n3, 0, null, 1000, 5);
                    return;
                }
            }
            if (w0(businessFeedData, view, obj)) {
                this.V.O0(true);
            }
            this.V.o0(businessFeedData, i3, false, view);
        }
    }

    private boolean P0(View view, BusinessFeedData businessFeedData) {
        SuperLikeView superLikeView;
        CustomPraiseData g16;
        boolean z16;
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        if (businessFeedData == null || view == null || (superLikeView = (SuperLikeView) view.findViewWithTag("praise_click_tag")) == null) {
            return false;
        }
        if (businessFeedData.isGDTAdvFeed()) {
            if (businessFeedData.getCellDecorateInfo() != null && businessFeedData.getCellDecorateInfo().cellCustomPraise != null) {
                g16 = com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
            }
            g16 = null;
        } else {
            if (this.N == -1) {
                g16 = QzoneCustomPraiseService.i().g();
                if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
                    g16 = businessFeedData.getUser().customPraiseData;
                }
            }
            g16 = null;
        }
        boolean R = QZoneFeedUtil.R(businessFeedData);
        if (R) {
            v0();
            D();
            this.U.tj(this.f45947b0);
        }
        if (g16 == null && this.N == -1) {
            if (R) {
                this.f45952f.play(superLikeView);
                LpReportInfo_pf00064.allReport(92, 1, 1);
            }
            return false;
        }
        v0();
        BusinessFeedData businessFeedData2 = this.J;
        if (businessFeedData2 != null && businessFeedData2 != businessFeedData) {
            this.D.c();
        }
        this.J = businessFeedData;
        this.G++;
        if (this.N != -1 && (polymorphicPraiseEmotionData = this.P) != null) {
            superLikeView.setAsyncImage(polymorphicPraiseEmotionData.strPraisePic);
        } else if (g16 != null) {
            superLikeView.setAsyncImage(g16.praiseType != 0 ? g16.praiseIconUrl : null);
        }
        superLikeView.getLocationInWindow(this.H);
        businessFeedData.getLikeInfo().stateChanged = false;
        if (view instanceof AbsFeedView) {
            m2((AbsFeedView) view, businessFeedData, true);
        }
        if (R) {
            this.f45952f.play(superLikeView);
            LpReportInfo_pf00064.allReport(92, 1, 1);
        } else if (this.N == -1) {
            boolean y16 = y(businessFeedData);
            boolean z17 = y16 && (view instanceof CanvasTitleView) && businessFeedData.getUser() != null;
            if (businessFeedData.getLocalInfo().canLike || y16) {
                z16 = !(this.N == -1 ? businessFeedData.getLikeInfo().isLiked : false);
            } else {
                z16 = false;
            }
            a2(businessFeedData, c2(true, businessFeedData, this.H[0] + (superLikeView.getWidth() / 2), ((this.H[1] - this.I) - i0().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.azw)) + (superLikeView.getHeight() / 2), this.G), z17, z16, this.N);
            QZLog.d("FeedClickProcessor", 2, "@cmPraise oncustompraise time =" + System.currentTimeMillis());
            this.f45951e.l();
        }
        this.D.d(view, businessFeedData, superLikeView);
        this.D.removeMessages(100);
        if (this.N != -1) {
            this.D.sendEmptyMessageDelayed(100, 0L);
        } else {
            this.D.sendEmptyMessageDelayed(100, R ? 0L : 1000L);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class aa extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f45986a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f45987b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f45988c;

        aa(String str, View view, boolean z16) {
            this.f45986a = str;
            this.f45987b = view;
            this.f45988c = z16;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            PublicAccountFollowManager.g().setUinFollowed(this.f45986a, true);
            View view = this.f45987b;
            if (view instanceof CanvasRecommActionNonAd) {
                ((CanvasRecommActionNonAd) view).updateFollowStatus(this.f45988c);
            } else if (view instanceof CanvasPublicAccountContainerView) {
                ((CanvasPublicAccountContainerView) view).updateFollowStatus(this.f45988c);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 4;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ac implements IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener {
        ac() {
        }

        @Override // cooperation.qzone.IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener
        public void giftFullScreenPlayEnd() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class u implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f46062d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f46063e;

        u(Activity activity, String str) {
            this.f46062d = activity;
            this.f46063e = str;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            try {
                ((ClipboardManager) this.f46062d.getSystemService("clipboard")).setText(this.f46063e);
                QQToast.makeText(this.f46062d.getApplicationContext(), com.qzone.util.l.a(com.tencent.mobileqq.R.string.f171639jy3), 0).show();
            } catch (Exception unused) {
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
        }
    }

    private void P(BusinessFeedData businessFeedData, Object obj) {
    }

    private void Q1(BusinessFeedData businessFeedData, int i3) {
    }

    private void c0(BusinessFeedData businessFeedData, int i3) {
    }
}
