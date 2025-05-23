package com.qzone.detail.ui.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.component.PokeLikeWizard;
import com.qzone.component.PolymorphicLikeWindow;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.ui.activity.QzoneCommentDetailActivity;
import com.qzone.detail.ui.component.PokeMsgAnimDirector;
import com.qzone.feed.business.model.ViewFeedPhotoData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedVideoView;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellCommentPlugin;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellLive;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.RegionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.widget.EmoEditPanel;
import com.qzone.widget.util.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.report.lp.LpReportInfo_DC01691;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import g6.a;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import r6.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedElementBaseClickListener implements com.qzone.proxy.feedcomponent.ui.g {
    public static volatile BusinessFeedData D;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Activity> f46968d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<com.qzone.detail.ui.component.b> f46969e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<PolymorphicLikeWindow> f46970f;

    /* renamed from: h, reason: collision with root package name */
    BusinessFeedData f46971h;

    /* renamed from: i, reason: collision with root package name */
    boolean f46972i = false;

    /* renamed from: m, reason: collision with root package name */
    int f46973m = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46981d;

        a(CellTextView.OnTextOperater onTextOperater) {
            this.f46981d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46981d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46981d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46983a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f46983a = iArr;
            try {
                iArr[FeedElement.QZONE_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46983a[FeedElement.SHAREDCARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46983a[FeedElement.CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46983a[FeedElement.SUMMARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46983a[FeedElement.COMMENT_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46983a[FeedElement.COMMENT_ITEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46983a[FeedElement.COMMENT_LONG_CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f46983a[FeedElement.REPLY_ITEM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46983a[FeedElement.REPLY_LONG_CLICK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46983a[FeedElement.COMMENT_PIC_LONG_CLICK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f46983a[FeedElement.COMMENT_SHOW_MORE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f46983a[FeedElement.REPLY_BUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f46983a[FeedElement.FORWARD_BUTTON.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f46983a[FeedElement.PRAISE_BUTTON.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f46983a[FeedElement.DELETE_BUTTON.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f46983a[FeedElement.FAVORITE_BUTTON.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f46983a[FeedElement.DELETE_FAVORITE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f46983a[FeedElement.VIDEO.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO_GESTURE_ACTION.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO_REPLAY.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO_CLICK.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO_FLOW.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f46983a[FeedElement.CONTENT_EXTERNAL_URL_CLICK.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f46983a[FeedElement.URL.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f46983a[FeedElement.USER_AVATAR.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f46983a[FeedElement.USER_DECORATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f46983a[FeedElement.FEED_QCIRCLE_RECOMMEND_TOPIC_ICON.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f46983a[FeedElement.FEED_QCIRCLE_RECOMMEND_AVATAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f46983a[FeedElement.ORIGINAL_NICKNAME.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f46983a[FeedElement.USER_NICKNAME.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f46983a[FeedElement.TO_QQ_PROFILE.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f46983a[FeedElement.FEED_VIP_SIGNATURE.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f46983a[FeedElement.FRIEND_NICKNAME.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f46983a[FeedElement.OPEN_VISITOR.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f46983a[FeedElement.RECOMM_ACTION_LEFT_TEXT.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f46983a[FeedElement.VISIT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f46983a[FeedElement.INTERACT_TAG.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f46983a[FeedElement.FEED_RECOMMEND_FRIENDS_CLICK_MORE_FRIEND.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f46983a[FeedElement.PRAISE_LIST.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f46983a[FeedElement.OPEN_PICTURE_VIEWER.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f46983a[FeedElement.PHOTO.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f46983a[FeedElement.LOGO_ATTACH.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f46983a[FeedElement.ADV_CONTAINER.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f46983a[FeedElement.FEED_SHAI_SHAI_TAG.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f46983a[FeedElement.REFER.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f46983a[FeedElement.ACTION_BUTTON.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f46983a[FeedElement.CUSTOM_PRAISE_ICON.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f46983a[FeedElement.HABITED_AREA.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f46983a[FeedElement.LEFT_THUMB_PIC.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f46983a[FeedElement.LEFT_THUMB.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f46983a[FeedElement.STAR_VIP_ICON.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f46983a[FeedElement.YELLOW_VIP_ICON.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f46983a[FeedElement.LOVER_ZONE_ICON.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f46983a[FeedElement.PERMISSION.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f46983a[FeedElement.REMARK.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f46983a[FeedElement.VIDEO_REMARK.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f46983a[FeedElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f46983a[FeedElement.FORWARD_FOLLOW.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f46983a[FeedElement.LIKE_FOLLOW.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f46983a[FeedElement.DETAIL_WIDGET_ENTER_HOST_SPACE_CLICK.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f46983a[FeedElement.DETAIL_WIDGET_ENTER_HOST_SPACE_EXPOSE.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f46983a[FeedElement.NOTHING.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f46983a[FeedElement.RECOMMAD_ACTION_STAR.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f46983a[FeedElement.FEEDVIDEO_GOTO_VIDEO_TAB.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f46983a[FeedElement.ADV_MICRO_VIDEO.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f46983a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f46983a[FeedElement.ORIGINAL_SUMMARY.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f46983a[FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f46983a[FeedElement.FEED_APP_SHARE_CARD_CONTENT_BOTTOM_BAR_ACTION_BUTTON.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f46983a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f46983a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_PHOTO.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f46983a[FeedElement.COMMENT_PRAISE_BUTTON.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f46983a[FeedElement.REPLY_PRAISE_BUTTON.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f46983a[FeedElement.FEED_FORWARD_LIST.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f46983a[FeedElement.FAMOUS_SPACE_ICON.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f46983a[FeedElement.CANFOLLOW_ICON.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f46983a[FeedElement.TITLE.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f46983a[FeedElement.MORE_REPLY.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f46983a[FeedElement.SORT_SWITCH_ICON.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f46983a[FeedElement.RAPID_FORWARD_BUTTON.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f46983a[FeedElement.FEED_QZONE_CARD_ADD_FRIEND.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f46983a[FeedElement.FEED_QZONE_CARD_ADDFRIEND_BTN_EXPOSE.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f46983a[FeedElement.FEED_QZONE_CARD_FOLLOW_BTN_EXPOSE.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f46983a[FeedElement.DETAIL_BOTTOM_AD_FEED_BACK.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f46983a[FeedElement.DETAIL_BOTTOM_AD_EXPOSURE.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f46983a[FeedElement.POLYMORPHIC_LIKE.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f46983a[FeedElement.DETAIL_BOTTOM_POLYMORPHIC_LIKE.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f46983a[FeedElement.FEED_LIMIT_CHAT.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                f46983a[FeedElement.FEED_ADD_FRIEND.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f46983a[FeedElement.FEED_GIFT.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f46983a[FeedElement.OPEN_MORE_COMMENT.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f46983a[FeedElement.BOOK.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f46983a[FeedElement.GAME_SHARE_HOT_AREA.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f46983a[FeedElement.BLOG_NEW_STYLE.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f46983a[FeedElement.FEEDVIDEO_PLAY_ADV_TIME_EXPOSE.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f46983a[FeedElement.COMMENT_POKE_COMBO.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f46983a[FeedElement.FEED_QCIRCLE_TAIL_VIEW_CLICK_EVENT_TAG.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f46983a[FeedElement.RICH_TEXT_LONG_CLICKED.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements PokeMsgAnimDirector.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f46984a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f46985b;

        c(Activity activity, long j3) {
            this.f46984a = activity;
            this.f46985b = j3;
        }

        @Override // com.qzone.detail.ui.component.PokeMsgAnimDirector.d
        public void a() {
            ho.i.z().r(this.f46984a, this.f46985b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements PokeMsgAnimDirector.OnStopListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f46987a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f46988b;

        d(FrameLayout frameLayout, View view) {
            this.f46987a = frameLayout;
            this.f46988b = view;
        }

        @Override // com.qzone.detail.ui.component.PokeMsgAnimDirector.OnStopListener
        public void onStop() {
            this.f46987a.removeView(this.f46988b);
            FeedElementBaseClickListener.this.C = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements PolymorphicLikeWindow.OnItemSelectListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f46990a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f46991b;

        e(View view, BusinessFeedData businessFeedData) {
            this.f46990a = view;
            this.f46991b = businessFeedData;
        }

        @Override // com.qzone.component.PolymorphicLikeWindow.OnItemSelectListener
        public void onSelect(int i3, int i16, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
            com.qzone.detail.ui.component.b bVar = FeedElementBaseClickListener.this.f46969e.get();
            if (bVar != null) {
                bVar.Ee(this.f46990a, this.f46991b, i3, polymorphicPraiseEmotionData, i16);
            } else {
                w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise] onPolymorphicLike, clickProcessor = " + bVar);
            }
            LpReportInfo_pf00064.allReport(89, 3);
        }
    }

    public FeedElementBaseClickListener(Activity activity, com.qzone.detail.ui.component.b bVar) {
        this.f46968d = new WeakReference<>(activity);
        this.f46969e = new WeakReference<>(bVar);
        this.f46971h = bVar.T0().R();
    }

    private void A0(boolean z16) {
        BusinessFeedData R;
        com.qzone.detail.ui.component.b bVar = this.f46969e.get();
        if (bVar == null || bVar.T0() == null || (R = bVar.T0().R()) == null || !R.getFeedCommInfo().isFamousSpaceUserFeed()) {
            return;
        }
        if (z16) {
            ClickReport.d(1002, "2", "2", "3", true);
        } else {
            ClickReport.d(1002, "2", "2", "1", true);
        }
    }

    private void B0() {
        com.qzone.detail.ui.component.b bVar;
        BusinessFeedData R;
        WeakReference<com.qzone.detail.ui.component.b> weakReference = this.f46969e;
        if (weakReference == null || (bVar = weakReference.get()) == null || bVar.T0() == null || (R = bVar.T0().R()) == null || !R.getFeedCommInfo().isFamousSpaceUserFeed()) {
            return;
        }
        ClickReport.d(1002, "2", "2", "2", true);
    }

    private void C() {
        com.qzone.detail.ui.component.b bVar;
        if (this.f46968d == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        bVar.m1();
    }

    private void E(View view, Object obj, com.qzone.detail.ui.component.b bVar) {
        if (obj instanceof User) {
            r0(view, Long.valueOf(((User) obj).uin));
        }
        int cg5 = bVar != null ? bVar.cg() : -1;
        if (cg5 == 0) {
            new LpReportInfo_pf00064(463, 2, 2).reportImediately();
        } else if (cg5 == 1) {
            new LpReportInfo_pf00064(463, 2, 1).reportImediately();
        }
    }

    private void E0(View view, String str, String str2) {
        WeakReference<Activity> weakReference = this.f46968d;
        if ((weakReference == null ? null : weakReference.get()) == null) {
            QZLog.w("FeedElementBaseClickListener", "showAdWebDialog: null activity");
        }
    }

    private void G(Activity activity, Object obj) {
        User user;
        UserMedal userMedal;
        if (!(obj instanceof User) || (userMedal = (user = (User) obj).famousSpaceMedal) == null) {
            return;
        }
        String str = userMedal.jumpUrl;
        if (!TextUtils.isEmpty(str)) {
            String j3 = yo.f.j(str, "{uin}", LoginData.getInstance().getUinString());
            yo.d.d(j3, activity, null);
            BaseFeedClickProcessor.C(this.f46971h, user, true);
            if (QZLog.isColorLevel()) {
                QZLog.d("FeedElementBaseClickListener", 1, "jumpUrl = " + j3);
                return;
            }
            return;
        }
        QZLog.d("FeedElementBaseClickListener", 1, "click famous_space_icon meeting a null url");
    }

    private void I(BusinessFeedData businessFeedData, Activity activity) {
        if (businessFeedData.isGDTAdvFeed()) {
            r6.a.o().i(businessFeedData, BaseFeedPresenter.Y, activity);
        } else if (businessFeedData.getCellBottomRecomm() != null) {
            if (!TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
                yo.d.d(businessFeedData.getCellBottomRecomm().actionurl, activity, null);
            }
            TTTReportManager.s().f(3, 65, 1, System.currentTimeMillis());
        }
    }

    private void J(BusinessFeedData businessFeedData, Activity activity, Object obj) {
        if (obj instanceof BusinessFeedData) {
            BusinessFeedData businessFeedData2 = (BusinessFeedData) obj;
            if (businessFeedData != null && businessFeedData2 != null && businessFeedData2.getOriginalInfo() != null && businessFeedData2.getOriginalInfo().getCellBottomRecomm() != null) {
                businessFeedData = businessFeedData.getOriginalInfo();
            }
        }
        if (businessFeedData == null || businessFeedData.getCellBottomRecomm() == null) {
            return;
        }
        if (!TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
            HashMap hashMap = new HashMap();
            if (businessFeedData.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_WEISHI && WeishiHelper.isWeishiScheme(businessFeedData.getCellBottomRecomm().weishiDownloadUrl)) {
                yo.d.e(businessFeedData.getCellBottomRecomm().weishiDownloadUrl, activity, null, hashMap);
                WeishiHelper.reportWeiShiPicMediaView(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, 6, 2, businessFeedData);
                return;
            } else {
                hashMap.put("scene", 2100);
                yo.d.e(businessFeedData.getCellBottomRecomm().actionurl, activity, null, hashMap);
                return;
            }
        }
        if (businessFeedData.isSoftFakeFeed()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FAKE_FEED_SOFT_PERIOD, QzoneConfig.SECONDARY_KEY_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS, QzoneConfig.DEFAULT_ALBUM_FAKE_FEED_TAIL_CLICK_TIPS), 3);
        }
    }

    private void L(Activity activity) {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_KEY_JUMP_TO_MORE_VIDEO, QzoneConfig.DEFAULT_KEY_JUMP_TO_MORE_VIDEO_URL);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("url", config);
        intent.putExtra("fromQZone", true);
        yo.b.a(intent);
        activity.startActivity(intent);
    }

    private void M(View view, Object obj) {
        com.qzone.detail.ui.component.b bVar;
        TTTReportManager.s().h(k(), 35, 1, System.currentTimeMillis(), this.f46971h, this.f46973m, true);
        if (this.f46972i) {
            g(2, 14);
        }
        if (this.f46968d == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        bVar.zg(view);
    }

    private void O() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h.getCellLuckyMoney() != null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        FeedSkinData cellFeedSkinInfo = this.f46971h.getCellFeedSkinInfo();
        if (cellFeedSkinInfo == null) {
            vo.c.q(activity, "feedsdetails", this.f46971h.getUser().uin);
        }
        int i3 = cellFeedSkinInfo.nSkinType;
        int transferToInt = FeedSkinData.transferToInt(cellFeedSkinInfo.sSkinId);
        if (cellFeedSkinInfo.iNewFeedSkin == 1) {
            if (transferToInt > 0) {
                vo.c.p(activity, transferToInt + "", "feedsdetails", this.f46971h.getUser().uin);
                return;
            }
            vo.c.q(activity, "feedsdetails", this.f46971h.getUser().uin);
            return;
        }
        if (i3 == 380) {
            yo.d.d(cellFeedSkinInfo.strMusicH5Url, activity, "");
            return;
        }
        if (transferToInt > 0) {
            vo.c.f(activity, transferToInt + "", "feedsdetails", this.f46971h.getUser().uin);
            return;
        }
        vo.c.g(activity, "feedsdetails", this.f46971h.getUser().uin);
    }

    private void P(View view) {
        Activity activity;
        BusinessFeedData businessFeedData;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null || (businessFeedData = this.f46971h) == null || !businessFeedData.isAdFeeds() || this.f46971h.getLocalInfo() == null || !this.f46971h.getLocalInfo().canLike || !this.f46971h.getLocalInfo().canComment) {
            return;
        }
        r6.a.o().t(activity, this.f46971h);
    }

    private void Q(BusinessFeedData businessFeedData, Object obj) {
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 11;
        this.f46968d.get();
        f(businessFeedData, false, intValue);
    }

    private void T(Object obj) {
        WeakReference<Activity> weakReference;
        Activity activity;
        ArrayList<PictureItem> arrayList;
        if (!(obj instanceof ViewFeedPhotoData) || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        ViewFeedPhotoData viewFeedPhotoData = (ViewFeedPhotoData) obj;
        if (viewFeedPhotoData.photoSource == ViewFeedPhotoData.FROM_COMMENT) {
            CellPictureInfo cellPictureInfo = viewFeedPhotoData.pictureInfo;
            if (cellPictureInfo == null || (arrayList = cellPictureInfo.pics) == null) {
                return;
            }
            PictureViewerFactory.S(activity, arrayList, viewFeedPhotoData.curIndex);
            return;
        }
        r6.a.o().E(activity, this.f46971h, viewFeedPhotoData.curIndex, false);
    }

    private void U() {
        com.qzone.detail.ui.component.b bVar;
        if (this.f46968d == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        bVar.Y3();
    }

    private void V(FeedElement feedElement, View view, Object obj) {
        if (n(this.f46971h, view, obj)) {
            BusinessFeedData originalInfo = this.f46971h.getOriginalInfo();
            if (originalInfo.getCellSummary().actionType != 2 || this.f46968d == null) {
                return;
            }
            yo.d.d(originalInfo.getCellSummary().actionUrl, this.f46968d.get(), null);
        }
    }

    private void W() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null || this.f46971h.getFeedCommInfo() == null || TextUtils.isEmpty(this.f46971h.getFeedCommInfo().ugcRightKey) || this.f46971h.getPermissionInfoV2() == null) {
            return;
        }
        String str = this.f46971h.getFeedCommInfo().ugcRightKey;
        int g16 = com.qzone.feed.utils.h.g(this.f46971h.getPermissionInfoV2().permission_visit);
        if (com.qzone.feed.utils.h.h(g16)) {
            QZoneFeedUtil.b0(activity, str, g16, this.f46971h.getFeedCommInfo().appid);
        }
    }

    private void Z(View view) {
        com.qzone.detail.ui.component.b bVar;
        if (this.f46972i) {
            g(2, 13);
        }
        if (this.f46968d == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        bVar.V7(view, this.f46971h, 1);
    }

    private void a0() {
        WeakReference<Activity> weakReference;
        BusinessFeedData businessFeedData = this.f46971h;
        if (businessFeedData == null || businessFeedData.getUser() == null || TextUtils.isEmpty(this.f46971h.getUser().actionurl) || (weakReference = this.f46968d) == null || weakReference.get() == null) {
            return;
        }
        yo.d.d(this.f46971h.getCellBottomRecomm().actionurl, this.f46968d.get(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(int i3, int i16) {
        int i17;
        int i18;
        String valueOf;
        String str;
        if (this.f46971h == null || !this.f46972i) {
            return;
        }
        LbsDataV2.GpsInfo a16 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).a();
        long j3 = this.f46971h.getUser() != null ? this.f46971h.getUser().uin : 0L;
        if (this.f46971h.getCellLive() != null) {
            i18 = 5;
        } else {
            if (this.f46971h.getVideoInfo() == null) {
                i17 = 0;
                if (a16 != null) {
                    if (!com.qzone.reborn.configx.g.f53821a.b().q()) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.detail.ui.component.FeedElementBaseClickListener.7
                            @Override // java.lang.Runnable
                            public void run() {
                                com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).f();
                            }
                        });
                    } else {
                        QLog.e("QZoneRequest", 2, "disable silent locate in FeedElementBaseClickListener");
                    }
                    str = "";
                    valueOf = str;
                } else {
                    String valueOf2 = String.valueOf((a16.lat * 1.0d) / 1000000.0d);
                    valueOf = String.valueOf((a16.lon * 1.0d) / 1000000.0d);
                    str = valueOf2;
                }
                LpReportManager.getInstance().reportToDC01691(new LpReportInfo_DC01691(i3, i16, 0, j3, this.f46971h.getFeedCommInfo().ugckey, i17, str, valueOf), false, false);
            }
            i18 = 4;
        }
        i17 = i18;
        if (a16 != null) {
        }
        LpReportManager.getInstance().reportToDC01691(new LpReportInfo_DC01691(i3, i16, 0, j3, this.f46971h.getFeedCommInfo().ugckey, i17, str, valueOf), false, false);
    }

    private void j0(BusinessFeedData businessFeedData, Activity activity) {
        String str;
        CellShareCard cellShareCard = businessFeedData.cellShareCard;
        if (cellShareCard != null) {
            int i3 = cellShareCard.action_type;
            if (i3 == 2 || i3 == 20) {
                yo.d.d(cellShareCard.action_url, activity, null);
            }
            if (businessFeedData.feedType == 2) {
                if (businessFeedData.getFeedCommInfo().extendInfo != null && businessFeedData.getFeedCommInfo().extendInfo.containsKey("campus_share_type")) {
                    str = businessFeedData.getFeedCommInfo().extendInfo.get("campus_share_type");
                } else {
                    str = "0";
                }
                ClickReport.p("690", "4", str, null, true);
            }
        }
    }

    private int k() {
        return this.f46972i ? 9 : 3;
    }

    private void k0(BusinessFeedData businessFeedData) {
        Activity activity;
        CellFeedSignature cellFeedSignature;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || businessFeedData == null || (activity = weakReference.get()) == null || (cellFeedSignature = businessFeedData.cellFeedSignature) == null || TextUtils.isEmpty(cellFeedSignature.strJumpUrl)) {
            return;
        }
        yo.d.d(businessFeedData.cellFeedSignature.strJumpUrl, activity, null);
    }

    private void m(BusinessFeedData businessFeedData) {
        if (NetworkState.isNetSupport()) {
            QZoneWriteOperationService.v0().N(QzoneHandlerThreadFactory.getMainHandler(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.cellAlbumEntrance.busi_param);
        } else {
            ToastUtil.o(R.string.ghi, 4);
        }
    }

    private boolean n(BusinessFeedData businessFeedData, View view, Object obj) {
        return (businessFeedData.getOriginalInfo() != null && (view instanceof CanvasFeedContentView) && ((CanvasFeedContentView) view).isForward) || (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue() && ((view instanceof FeedVideoView) || (view instanceof CanvasTitleView)));
    }

    private void o0(View view, Object obj) {
        com.qzone.detail.ui.component.b bVar;
        if (this.f46968d == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        bVar.If(view);
    }

    private void p(View view, FeedElement feedElement) {
        Activity activity;
        com.qzone.detail.ui.component.b bVar;
        int i3;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        if (feedElement == FeedElement.ADV_MICRO_VIDEO) {
            i3 = BaseFeedPresenter.X;
        } else {
            i3 = (feedElement == FeedElement.ACCEPT_BUTTON || feedElement == FeedElement.ACTION_BUTTON) ? BaseFeedPresenter.S : 0;
        }
        r6.a.o().l(bVar.T0().R(), 0, i3, view, activity);
    }

    private void q0(Object obj, View view, BusinessFeedData businessFeedData) {
        Activity activity;
        if (obj instanceof com.qzone.proxy.feedcomponent.model.e) {
            com.qzone.proxy.feedcomponent.model.e eVar = (com.qzone.proxy.feedcomponent.model.e) obj;
            int i3 = eVar.f50310d;
            if (i3 == 13) {
                LpReportInfo_pf00064.report(304, 10, 0);
            } else if (i3 == 12) {
                ap.f59791b.e(218, 1, eVar.a(), businessFeedData);
                z0(businessFeedData);
            }
            r6.a.y(this.f46971h, (this.f46971h.getOperationInfoV2() == null || this.f46971h.getOperationInfoV2().actionType == 2 || this.f46971h.getOperationInfoV2().actionType == 23) ? 5000 : 5001, this.f46971h.getOperationInfo().actionType == 22 ? this.f46971h.getOperationInfo().actionType : 0, 0, null);
            WeakReference<Activity> weakReference = this.f46968d;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            com.qzone.misc.network.report.f.m(eVar.c(), activity, eVar.b(), this.f46971h);
        }
    }

    private void r0(View view, Object obj) {
        int m3;
        if (obj instanceof Long) {
            if (((Long) obj).longValue() != 0) {
                this.f46968d.get();
                if (this.f46971h != null) {
                    r6.a.o().k(this.f46971h.getUser(), null);
                }
                m3 = 0;
            } else {
                m3 = r6.a.o().m(this.f46971h, 0, BaseFeedPresenter.R, null, com.qzone.misc.network.report.f.i(2, 2));
            }
            BusinessFeedData businessFeedData = this.f46971h;
            if (businessFeedData != null && businessFeedData.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.e(this.f46971h);
                return;
            }
            BusinessFeedData businessFeedData2 = this.f46971h;
            if (businessFeedData2 != null && businessFeedData2.isAdFeeds() && this.f46971h.getLocalInfo() != null && this.f46971h.getLocalInfo().canLike && this.f46971h.getLocalInfo().canComment) {
                int i3 = 5000;
                if ((this.f46971h.getCellUserInfo() == null || this.f46971h.getCellUserInfo().actionType != 2) && (this.f46971h.getCellUserInfo().actionType != 20 || this.f46971h.getOperationInfo() == null || this.f46971h.getOperationInfo().actionType != 2)) {
                    i3 = 5001;
                }
                r6.a.y(this.f46971h, i3, m3, 0, null);
                return;
            }
            r6.a.w(this.f46971h, 1, m3, 0);
        }
    }

    private void s(VideoPlayInfo videoPlayInfo, View view, int i3) {
        Activity activity;
        com.qzone.detail.ui.component.b bVar;
        long m3;
        CellLive cellLive;
        BusinessFeedData businessFeedData;
        if (this.f46972i) {
            g(2, 11);
        }
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        BusinessFeedData R = bVar.T0().R();
        BusinessFeedData businessFeedData2 = this.f46971h;
        VideoInfo videoInfo = businessFeedData2 != null ? businessFeedData2.getVideoInfo() : null;
        if (videoInfo != null && videoInfo.videoStatus == 1) {
            String C0 = QZoneWriteOperationService.v0().C0(videoInfo.videoId);
            if (C0 == null) {
                ToastUtil.r(videoInfo.toast);
                return;
            }
            w5.b.a("FeedElementBaseClickListener", 2, "#\u540e\u53f0\u8f6c\u7801\u4e2d:onAutoVideo,playCacheFile=" + C0);
            videoInfo.videoStatus = 0;
            videoInfo.videoUrl = new VideoUrl(C0);
        }
        if (videoInfo == null && (businessFeedData = this.f46971h) != null && businessFeedData.getOriginalInfo() != null) {
            videoInfo = this.f46971h.getOriginalInfo().getVideoInfo();
        }
        BusinessFeedData businessFeedData3 = this.f46971h;
        if (businessFeedData3 != null && businessFeedData3.isLiveVideoFeed() && (cellLive = this.f46971h.getCellLive()) != null && !TextUtils.isEmpty(cellLive.roomid) && videoInfo != null && 2 == videoInfo.actionType && !TextUtils.isEmpty(videoInfo.actionUrl)) {
            yo.d.d(videoInfo.actionUrl, activity, null);
            return;
        }
        if (videoInfo != null && videoInfo.actionType == 46) {
            BaseVideo i16 = i(view);
            if (i16 != null && i16.getState() != 3) {
                i16.doPlayVideo();
                return;
            } else {
                if (videoInfo.actionType == 45) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("isNativeLikeWebview", Boolean.TRUE);
                    yo.d.e(videoInfo.nativeLikeUrl, activity, null, hashMap);
                    return;
                }
                return;
            }
        }
        if (videoInfo != null && videoInfo.actionType == 49) {
            com.qzone.proxy.feedcomponent.ui.c.n(activity, videoInfo, 0, this.f46971h, null);
            return;
        }
        if (videoInfo != null && videoInfo.actionType == 19) {
            if (!TextUtils.isEmpty(videoInfo.albumid)) {
                l0(this.f46971h, view, 0);
                return;
            } else {
                w5.b.b("FeedElementBaseClickListener", 2, "feedVideoInfo.albumid == null !");
                return;
            }
        }
        if (videoInfo != null && videoInfo.actionType == 23 && !TextUtils.isEmpty(videoInfo.actionUrl)) {
            if (!WeishiHelper.isWeishiVideoLayerScheme(videoInfo.actionUrl) && !WeishiHelper.isWeishiScheme(videoInfo.actionUrl) && !WeishiHelper.isVerticalNormalVideoLayerSchema(videoInfo.actionUrl)) {
                yo.d.d(videoInfo.actionUrl, activity, null);
                return;
            }
            boolean z16 = view instanceof FeedAutoVideo;
            if (z16) {
                FeedAutoVideo feedAutoVideo = (FeedAutoVideo) view;
                Object h16 = feedAutoVideo.getBaseVideoManager().h();
                if (h16 != null) {
                    m3 = ((Integer) h16).intValue();
                } else {
                    m3 = videoPlayInfo != null ? feedAutoVideo.getBaseVideoManager().m(videoPlayInfo.videoId) : -1L;
                }
                HashMap hashMap2 = new HashMap();
                if (videoPlayInfo != null) {
                    VideoPlayInfo videoPlayInfo2 = new VideoPlayInfo();
                    videoPlayInfo2.videoId = videoPlayInfo.videoId;
                    videoPlayInfo2.feedTime = m3;
                    if (z16) {
                        videoPlayInfo2.width = feedAutoVideo.getRealVideoWidth();
                        videoPlayInfo2.height = feedAutoVideo.getRealVideoHeight();
                    }
                    hashMap2.put(videoPlayInfo.videoId, videoPlayInfo2);
                }
            }
            BaseFeedClickProcessor.z1(activity, R, view, i3, 0);
            return;
        }
        BusinessFeedData businessFeedData4 = this.f46971h;
        if (businessFeedData4 != null && businessFeedData4.getFeedCommInfo().isVideoAdv()) {
            BaseVideoManager.getFeedVideoManager().D(new ArrayList());
            BusinessFeedData businessFeedData5 = this.f46971h;
            if (businessFeedData5 != null && businessFeedData5.getFeedCommInfo().isVideoAdv()) {
                com.qzone.proxy.feedcomponent.ui.c.j(activity, videoInfo, null, 0, this.f46971h.getOperationInfo().downloadUrl, this.f46971h);
                return;
            } else {
                com.qzone.proxy.feedcomponent.ui.c.i(activity, videoInfo, null, 0, null);
                return;
            }
        }
        if (videoInfo != null && videoInfo.actionType == 22 && !TextUtils.isEmpty(videoInfo.actionUrl)) {
            if (this.f46971h.isQCircleShareCardFeed()) {
                yo.d.d(videoInfo.actionUrl, activity, null);
                return;
            }
            return;
        }
        D = R;
    }

    private void t(FeedElement feedElement, BusinessFeedData businessFeedData) {
        int i3 = feedElement == FeedElement.AUTO_VIDEO_REPLAY ? 21 : 6;
        ap.f59791b.e(20, 16, i3, businessFeedData);
        if (this.f46971h == null || !businessFeedData.getFeedCommInfo().needAdvReport()) {
            return;
        }
        if (businessFeedData.isBrandUgcAdvFeeds()) {
            com.qzone.misc.network.report.f.e(businessFeedData);
        } else {
            r6.a.e(businessFeedData, 2, i3);
        }
    }

    private void u(Object obj) {
        Activity activity = this.f46968d.get();
        if (activity == null || this.f46971h == null || obj == null || !(obj instanceof com.qzone.proxy.feedcomponent.ui.l)) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().E2(activity, (com.qzone.proxy.feedcomponent.ui.l) obj);
    }

    private void u0(Bundle bundle) {
        Activity activity;
        String string = bundle.getString("redirectUrl", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int i3 = bundle.getInt("videoType");
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        r6.a.G(activity, string, i3);
    }

    private void v(Activity activity, Object obj) {
        User user;
        UserMedal userMedal;
        if (!(obj instanceof User) || (userMedal = (user = (User) obj).famousSpaceMedal) == null) {
            return;
        }
        String str = userMedal.jumpUrl;
        if (!TextUtils.isEmpty(str)) {
            yo.d.d(str, activity, null);
            BaseFeedClickProcessor.C(this.f46971h, user, true);
            if (QZLog.isColorLevel()) {
                QZLog.d("FeedElementBaseClickListener", 1, "jumpUrl = " + str);
                return;
            }
            return;
        }
        QZLog.d("FeedElementBaseClickListener", 1, "click can_follow_icon meeting a null url");
    }

    private void w0(FeedElement feedElement, View view) {
        WeakReference<Activity> weakReference;
        Activity activity;
        BusinessFeedData businessFeedData;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (!this.f46971h.isAdFeeds() && (!this.f46971h.isBrandUgcAdvFeeds() || this.f46971h.getCellBottomRecomm() == null)) {
            vo.c.S(activity, this.f46971h, false);
            return;
        }
        if (feedElement == FeedElement.VISIT && (businessFeedData = this.f46971h) != null && businessFeedData.isAdFeeds() && this.f46971h.getLocalInfo() != null && this.f46971h.getLocalInfo().canLike && this.f46971h.getLocalInfo().canComment && this.f46971h.getRecommAction() != null && this.f46971h.getRecommAction().isHideActionArea == 0) {
            r6.a.y(this.f46971h, (this.f46971h.getOperationInfoV2() == null || this.f46971h.getOperationInfoV2().actionType == 2 || this.f46971h.getOperationInfoV2().actionType == 23) ? 5000 : 5001, 0, 0, com.qzone.misc.network.report.f.j(2, 29, 0));
            r6.a.o().u(activity, this.f46971h, com.qzone.misc.network.report.f.i(2, 29));
        } else if (this.f46971h.isBrandUgcAdvFeeds() && this.f46971h.getCellBottomRecomm() != null) {
            r6.a.o().i(this.f46971h, BaseFeedPresenter.W, activity);
        } else {
            r6.a.y(this.f46971h, (this.f46971h.getOperationInfoV2() == null || this.f46971h.getOperationInfoV2().actionType == 2 || this.f46971h.getOperationInfoV2().actionType == 23) ? 5000 : 5001, 0, 0, null);
            r6.a.o().u(activity, this.f46971h, com.qzone.misc.network.report.f.i(2, 0));
        }
    }

    private void x0(boolean z16, boolean z17) {
        WeakReference<Activity> weakReference;
        Activity activity;
        CellPictureInfo pictureInfo;
        BusinessFeedData businessFeedData = this.f46971h;
        if (z17 && businessFeedData != null) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null || (pictureInfo = businessFeedData.getPictureInfo()) == null) {
            return;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        a.C11115a c11115a = new a.C11115a();
        c11115a.f430813b = pictureInfo.albumid;
        c11115a.f430812a = pictureInfo.albumname;
        c11115a.f430814c = Long.valueOf(pictureInfo.uin);
        c11115a.f430815d = t16;
        c11115a.f430816e = pictureInfo.individualAlbum;
        r6.a.D(activity, r6.a.o().f430801d, c11115a, Boolean.valueOf(z16));
    }

    private void y0(long j3, String str, String str2, int i3) {
        Activity activity;
        FrameLayout frameLayout;
        if (this.C || (activity = this.f46968d.get()) == null) {
            return;
        }
        try {
            frameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
        } catch (Throwable th5) {
            QZLog.w("FeedElementBaseClickListener", "playPokeOnClick: ", th5);
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        View inflate = View.inflate(activity, R.layout.akz, null);
        frameLayout.addView(inflate);
        PokeMsgAnimDirector pokeMsgAnimDirector = new PokeMsgAnimDirector(inflate);
        pokeMsgAnimDirector.showAnim(j3, str, str2, i3);
        pokeMsgAnimDirector.setOnJumpMainPageListener(new c(activity, j3));
        pokeMsgAnimDirector.setOnStopListener(new d(frameLayout, inflate));
    }

    protected void A(View view) {
        ClickedComment clickedComment = (ClickedComment) view.getTag();
        if (clickedComment != null && clickedComment.getComment() != null && clickedComment.getComment().user != null) {
            com.qzone.detail.ui.component.b bVar = this.f46969e.get();
            if (bVar == null) {
                return;
            }
            bVar.Ye(view, clickedComment.getComment(), clickedComment);
            return;
        }
        QZLog.e("OnDetailFeedElementClickListener", "comment is null!! long click");
    }

    protected void B() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        r6.a.o().t(activity, this.f46971h);
    }

    public void D0(BusinessFeedData businessFeedData) {
        this.f46971h = businessFeedData;
    }

    protected void N(Object obj) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (obj instanceof User) {
            r6.a.o().j((User) obj);
        } else {
            if (!(obj instanceof Long) || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
                return;
            }
            r6.a.K(activity, ((Long) obj).longValue());
        }
    }

    protected void R(View view, Object obj) {
        BusinessFeedData businessFeedData;
        Activity activity = this.f46968d.get();
        if (activity == null || (businessFeedData = this.f46971h) == null || businessFeedData.getCommentInfo() == null || this.f46971h.getCommentInfo().cellCommentPlugin == null) {
            return;
        }
        CellCommentPlugin cellCommentPlugin = this.f46971h.getCommentInfo().cellCommentPlugin;
        if (TextUtils.isEmpty(cellCommentPlugin.action_url)) {
            return;
        }
        WeishiHelper.dealWeishicheme(activity, cellCommentPlugin.action_url, null);
    }

    protected void S(View view, Object obj) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (n(this.f46971h, view, obj)) {
            ho.i.e().i(activity, this.f46971h, 0, 0L);
        } else if (this.f46971h.isAdFeeds()) {
            r6.a.o().t(activity, this.f46971h);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public boolean a(FeedElement feedElement, Object obj, View view, CellTextView.OnTextOperater onTextOperater) {
        com.qzone.detail.ui.component.b bVar;
        ArrayList<PictureItem> arrayList;
        PictureItem pictureItem;
        int i3 = b.f46983a[feedElement.ordinal()];
        if (i3 == 4) {
            m0(view);
        } else if (i3 != 7) {
            if (i3 == 13) {
                final BusinessFeedData businessFeedData = this.f46971h;
                if (businessFeedData == null) {
                    return false;
                }
                if (QZoneFeedUtil.m(businessFeedData)) {
                    WeakReference<Activity> weakReference = this.f46968d;
                    Activity activity = weakReference != null ? weakReference.get() : null;
                    if (activity != null && (activity instanceof BaseActivity)) {
                        final BaseActivity baseActivity = (BaseActivity) activity;
                        new Intent().putExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, true);
                        int i16 = businessFeedData.getFeedCommInfo().appid;
                        if (i16 != 311 && i16 != 6100) {
                            QZoneFeedUtil.f47421a.put("activity_result_ahare_to_qzone_key", businessFeedData);
                            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.ui.component.FeedElementBaseClickListener.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZoneFeedUtil.t(businessFeedData, "", 2, null, null, baseActivity.getHandler(), false, 2, false, true);
                                }
                            });
                        } else {
                            QZoneFeedUtil.f47421a.put("current_forward_key", businessFeedData);
                            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.ui.component.FeedElementBaseClickListener.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZoneFeedUtil.t(businessFeedData, "", 1, null, null, baseActivity.getHandler(), false, 2, false, true);
                                }
                            });
                        }
                        return true;
                    }
                } else {
                    LpReportInfo_pf00064.allReport(85, 6, 2);
                }
                return false;
            }
            if (i3 == 42) {
                int a16 = ((com.qzone.proxy.feedcomponent.model.f) obj).a();
                BusinessFeedData businessFeedData2 = this.f46971h;
                if (businessFeedData2 != null) {
                    CellPictureInfo pictureInfo = businessFeedData2.getPictureInfo();
                    if (pictureInfo == null && this.f46971h.getOriginalInfo() != null) {
                        pictureInfo = this.f46971h.getOriginalInfo().getPictureInfo();
                    }
                    if (pictureInfo != null && (arrayList = pictureInfo.pics) != null && arrayList.size() > a16 && a16 >= 0 && QZoneFeedUtil.i0(this.f46971h) && (pictureItem = pictureInfo.pics.get(a16)) != null && pictureItem.videoflag != 1) {
                        QZoneFeedUtil.g0(this.f46968d.get(), pictureItem);
                    }
                    return true;
                }
            } else if (i3 == 99) {
                i0(view, onTextOperater);
            }
        } else if (this.f46968d != null && (bVar = this.f46969e.get()) != null) {
            bVar.Fc();
        }
        return true;
    }

    protected void d0() {
        WeakReference<Activity> weakReference;
        Activity activity;
        CellRemarkInfo remarkInfoV2;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (this.f46971h.getRemarkInfoV2() != null) {
            remarkInfoV2 = this.f46971h.getRemarkInfoV2();
        } else {
            remarkInfoV2 = (this.f46971h.getOriginalInfo() == null || this.f46971h.getOriginalInfo().getRemarkInfoV2() == null) ? null : this.f46971h.getOriginalInfoSafe().getRemarkInfoV2();
        }
        if (remarkInfoV2 != null && remarkInfoV2.action_type == 2) {
            yo.d.d(remarkInfoV2.action_url, activity, null);
            if (this.f46971h.getCellLuckyMoney() == null && (this.f46971h.getOriginalInfo() == null || this.f46971h.getOriginalInfo().getCellLuckyMoney() == null)) {
                return;
            }
            ClickReport.q("566", "11", "", true);
            return;
        }
        x0(false, false);
    }

    public boolean e(boolean z16) {
        CellPictureInfo pictureInfo;
        BusinessFeedData businessFeedData = this.f46971h;
        if (z16 && businessFeedData != null) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null) {
            return false;
        }
        int t16 = QZoneAlbumUtil.t(pictureInfo.anonymity);
        a.C11115a c11115a = new a.C11115a();
        c11115a.f430813b = pictureInfo.albumid;
        c11115a.f430812a = pictureInfo.albumname;
        c11115a.f430814c = Long.valueOf(pictureInfo.uin);
        c11115a.f430815d = t16;
        return r6.a.d(r6.a.o().f430801d, c11115a);
    }

    protected void e0(View view, Object obj) {
        com.qzone.detail.ui.component.b bVar;
        Reply reply;
        CellCommentEssence commentEssence;
        Comment comment;
        List<Reply> list;
        Reply reply2;
        Comment comment2;
        List<Reply> list2;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || weakReference == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        if (bVar.getAppid() == 334) {
            bVar.Pd();
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("position");
        bundle.getInt("position");
        int i16 = bundle.getInt("reply_pos", -1);
        int i17 = bundle.getInt("commenttype", 0);
        if (bVar.T0() == null || bVar.T0().R() == null) {
            return;
        }
        Comment comment3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Reply reply3 = null;
        comment3 = null;
        if (i17 == 0) {
            CellCommentInfo commentInfo = bVar.T0().R().getCommentInfo();
            if (commentInfo != null) {
                ArrayList<Comment> arrayList = commentInfo.commments;
                if (arrayList == null) {
                    comment2 = null;
                } else if (i3 > arrayList.size() - 1) {
                    return;
                } else {
                    comment2 = commentInfo.commments.get(i3);
                }
                if (i16 != -1 && comment2 != null && (list2 = comment2.replies) != null && i16 < list2.size()) {
                    reply3 = comment2.replies.get(i16);
                }
                Reply reply4 = reply3;
                comment3 = comment2;
                reply2 = reply4;
            } else {
                reply2 = null;
            }
            reply = reply2;
        } else if (i17 != 1 || (commentEssence = bVar.T0().R().getCommentEssence()) == null) {
            reply = null;
        } else {
            ArrayList<Comment> arrayList2 = commentEssence.commments;
            if (arrayList2 == null) {
                comment = null;
            } else if (i3 > arrayList2.size() - 1) {
                return;
            } else {
                comment = commentEssence.commments.get(i3);
            }
            if (i16 == -1 || comment == null || (list = comment.replies) == null || i16 >= list.size()) {
                reply = null;
                comment3 = comment;
            } else {
                comment3 = comment;
                reply = comment.replies.get(i16);
            }
        }
        bVar.p6(view, comment3, reply, i3, 100);
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0(View view, Integer num) {
        ClickedComment clickedComment = (ClickedComment) view.getTag();
        if (clickedComment != null && clickedComment.getReply() != null && clickedComment.getReply().user != null) {
            if (clickedComment.getReply().user.uin != LoginData.getInstance().getUin()) {
                EmoEditPanel.D1 = new EmoEditPanel.al(38, this.f46971h, 0);
                ap.f59791b.e(38, 1, 0, this.f46971h);
            }
            B0();
            com.qzone.detail.ui.component.b bVar = this.f46969e.get();
            if (bVar == null) {
                return;
            }
            bVar.p6(view, clickedComment.getComment(), clickedComment.getReply(), num.intValue(), 1);
            return;
        }
        QZLog.e("FeedElementBaseClickListener", "reply is null!!");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009f A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void g0(View view, Object obj) {
        Comment comment;
        Reply reply;
        ArrayList<Comment> arrayList;
        Comment comment2;
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("position");
        int i16 = bundle.getInt("commenttype", 0);
        int i17 = bundle.getInt("reply_pos");
        com.qzone.detail.ui.component.b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        if (bVar instanceof QzoneCommentDetailActivity) {
            comment = null;
            reply = null;
        } else if (i16 != 0) {
            if (i16 == 1) {
                CellCommentEssence commentEssence = bVar.T0().R().getCommentEssence();
                if (commentEssence == null || (arrayList = commentEssence.commments) == null || arrayList.size() <= i3) {
                    return;
                }
                comment2 = commentEssence.commments.get(i3);
                if (comment2 != null) {
                }
                comment = comment2;
                reply = null;
            }
            comment2 = null;
            if (comment2 != null) {
            }
            comment = comment2;
            reply = null;
        } else {
            if (bVar.T0().R().getCommentInfo().commments != null && i3 > bVar.T0().R().getCommentInfo().commments.size() - 1) {
                return;
            }
            if (bVar.T0().R().getCommentInfo().commments != null) {
                comment2 = bVar.T0().R().getCommentInfo().commments.get(i3);
                if (comment2 != null || i17 < 0 || i17 >= comment2.replies.size()) {
                    comment = comment2;
                    reply = null;
                } else {
                    comment = comment2;
                    reply = comment2.replies.get(i17);
                }
            }
            comment2 = null;
            if (comment2 != null) {
            }
            comment = comment2;
            reply = null;
        }
        bVar.ih(view, comment, reply, i3, i17, 100);
    }

    protected void h0(View view) {
        ClickedComment clickedComment = (ClickedComment) view.getTag();
        if (clickedComment != null && clickedComment.getReply() != null && clickedComment.getReply().user != null) {
            com.qzone.detail.ui.component.b bVar = this.f46969e.get();
            if (bVar == null) {
                return;
            }
            bVar.q5(view, clickedComment.getComment(), clickedComment.getReply(), clickedComment);
            return;
        }
        QZLog.e("FeedElementBaseClickListener", "reply is null!! long click");
    }

    protected BaseVideo i(View view) {
        AbsFeedView j3 = j(view);
        if (j3 != null) {
            return ((FeedView) j3).getAutoVideoView();
        }
        return null;
    }

    public void i0(View view, CellTextView.OnTextOperater onTextOperater) {
        Activity activity;
        a aVar = new a(onTextOperater);
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        com.qzone.widget.util.b.h(activity, aVar);
    }

    protected void l0(BusinessFeedData businessFeedData, View view, int i3) {
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
        businessFeedData.setCellPictureInfo(cellPictureInfo);
        cellPictureInfo.uin = businessFeedData.getUser().uin;
        cellPictureInfo.albumid = videoInfo.albumid;
        cellPictureInfo.anonymity = videoInfo.anonymity;
        cellPictureInfo.uniKey = businessFeedData.getFeedCommInfo().orglikekey;
        cellPictureInfo.actionurl = videoInfo.actionUrl;
        cellPictureInfo.isTmpData = true;
        X(view, new com.qzone.proxy.feedcomponent.model.f(i3, 0, false, true));
    }

    public void m0(View view) {
        Activity activity;
        com.qzone.detail.ui.component.b bVar;
        String str;
        g gVar;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null || (bVar = this.f46969e.get()) == null) {
            return;
        }
        BusinessFeedData R = bVar.T0().R();
        if (com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().isOriginal(view) && R.getOriginalInfo() != null) {
            if (R.getOriginalInfo().getCellSummaryV2() != null) {
                str = R.getOriginalInfo().getCellSummaryV2().summary;
            }
            str = null;
        } else {
            if (R.getCellSummaryV2() != null) {
                str = R.getCellSummaryV2().summary;
            }
            str = null;
        }
        f fVar = new f(activity, str);
        BusinessFeedData businessFeedData = this.f46971h;
        if (businessFeedData == null || businessFeedData.isAdFeeds()) {
            gVar = null;
        } else {
            BusinessFeedData businessFeedData2 = this.f46971h;
            long j3 = businessFeedData2.owner_uin;
            if (j3 == 0) {
                j3 = businessFeedData2.getUser().uin;
            }
            gVar = new g(j3);
        }
        com.qzone.widget.util.b.i(activity, fVar, null, gVar, null);
    }

    protected void n0(View view, Object obj) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (n(this.f46971h, view, obj)) {
            ho.i.e().i(activity, this.f46971h, 0, 0L);
        } else if (this.f46971h.isAdFeeds()) {
            r6.a.o().t(activity, this.f46971h);
        }
    }

    public void o() {
        Activity activity;
        String str;
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_LIKELIST_PAGE, QzoneConfig.DefaultValue.DEFAULT_LIKELIST_PAGE_URL);
        if (TextUtils.isEmpty(config) || this.f46971h == null) {
            return;
        }
        if (config.contains("{unikey}") && (str = this.f46971h.getFeedCommInfo().curlikekey) != null) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                str = URLEncoder.encode(str);
            }
            config = config.replace("{unikey}", str);
        }
        if (config.contains("{uin}")) {
            config = config.replace("{uin}", String.valueOf(LoginData.getInstance().getUin()));
        }
        if (config.contains("{hostuin}")) {
            User user = this.f46971h.getUser();
            if (user != null) {
                config = config.replace("{hostuin}", String.valueOf(user.uin));
            } else {
                config = config.replace("{hostuin}", "0");
            }
        }
        if (config.contains("{appid}")) {
            BusinessFeedData originalInfo = this.f46971h.getOriginalInfo();
            if (originalInfo != null) {
                config = config.replace("{appid}", String.valueOf(originalInfo.getFeedCommInfo().appid));
            } else {
                config = config.replace("{appid}", "");
            }
        }
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        yo.d.d(config, activity, null);
    }

    protected void p0(View view, Object obj) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null || !n(this.f46971h, view, obj)) {
            return;
        }
        ho.i.e().i(activity, this.f46971h, 0, 0L);
    }

    protected void q(View view) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null || !this.f46971h.isAdFeeds()) {
            return;
        }
        r6.a.o().t(activity, this.f46971h);
    }

    protected void s0(View view, Object obj) {
        int i3;
        boolean z16;
        BusinessFeedData businessFeedData;
        User user;
        if (obj instanceof Long) {
            this.f46968d.get();
            BusinessFeedData businessFeedData2 = this.f46971h;
            if (businessFeedData2 == null || businessFeedData2.getCellUserInfo() == null) {
                i3 = 0;
                z16 = false;
            } else {
                i3 = this.f46971h.getCellUserInfo().actionType;
                z16 = this.f46971h.getFeedCommInfo().isBizRecomFeeds();
            }
            if ((((Long) obj).longValue() != 0 && !z16) || ((businessFeedData = this.f46971h) != null && QZoneAdFeedDataExtKt.isGDTForwardFeed(businessFeedData))) {
                BusinessFeedData businessFeedData3 = this.f46971h;
                if (businessFeedData3 != null) {
                    if (businessFeedData3.getOriginalInfo() != null) {
                        user = this.f46971h.getOriginalInfo().getUser();
                        if (user == null || !obj.equals(Long.valueOf(user.uin))) {
                            user = this.f46971h.getUser();
                        }
                    } else {
                        user = this.f46971h.getUser();
                    }
                    r6.a.o().k(user, this.f46971h.getFeedCommInfo().ugckey);
                }
            } else {
                i3 = r6.a.o().m(this.f46971h, 0, BaseFeedPresenter.Q, null, com.qzone.misc.network.report.f.i(2, 3));
            }
            BusinessFeedData businessFeedData4 = this.f46971h;
            if (businessFeedData4 != null && businessFeedData4.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.e(this.f46971h);
                return;
            }
            BusinessFeedData businessFeedData5 = this.f46971h;
            if (businessFeedData5 != null && businessFeedData5.isAdFeeds() && this.f46971h.getLocalInfo() != null && this.f46971h.getLocalInfo().canLike && this.f46971h.getLocalInfo().canComment) {
                int i16 = 5000;
                if ((this.f46971h.getCellUserInfo() == null || this.f46971h.getCellUserInfo().actionType != 2) && (this.f46971h.getCellUserInfo().actionType != 20 || this.f46971h.getOperationInfo() == null || this.f46971h.getOperationInfo().actionType != 2)) {
                    i16 = 5001;
                }
                r6.a.y(this.f46971h, i16, i3, 0, null);
                return;
            }
            r6.a.w(this.f46971h, 2, i3, 0);
        }
    }

    protected void t0() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        String str = this.f46971h.getOperationInfo().downloadUrl;
        if (!TextUtils.isEmpty(str) && !this.f46971h.isGDTAdvFeed()) {
            yo.d.d(str + "&acttype=46", activity, null);
            r6.a.y(this.f46971h, (this.f46971h.getOperationInfoV2() == null || this.f46971h.getOperationInfoV2().actionType == 2 || this.f46971h.getOperationInfoV2().actionType == 23) ? 5000 : 5001, 0, 0, com.qzone.misc.network.report.f.i(2, 9));
            return;
        }
        if (this.f46971h.getVideoInfo() == null || this.f46971h.getVideoInfo().videoRemark == null) {
            return;
        }
        VideoInfo.VideoRemark videoRemark = this.f46971h.getVideoInfo().videoRemark;
        if (2 == videoRemark.actiontype) {
            yo.d.d(videoRemark.actionurl, activity, null);
        }
    }

    protected void v0() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f46971h == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null || this.f46971h.getVideoInfo() == null || this.f46971h.getVideoInfo().videoRemark == null) {
            return;
        }
        VideoInfo.VideoRemark videoRemark = this.f46971h.getVideoInfo().videoRemark;
        if (2 == videoRemark.actiontype) {
            yo.d.d(videoRemark.actionurl, activity, null);
        }
    }

    protected void w(View view, Object obj) {
        if (this.f46968d == null) {
            return;
        }
        EmoEditPanel.D1 = new EmoEditPanel.al(4, this.f46971h, 0);
        ap.f59791b.e(4, 1, 0, this.f46971h);
        com.qzone.detail.ui.component.b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        bVar.Pd();
        A0(false);
        if (this.f46972i) {
            g(2, 12);
        }
    }

    protected void x(View view, Object obj) {
        ClickedComment clickedComment = (ClickedComment) view.getTag();
        if (clickedComment != null && clickedComment.getComment() != null && clickedComment.getComment().user != null) {
            if (clickedComment.getComment().isFake) {
                QZLog.e("FeedElementBaseClickListener", "facke comment clicked");
                return;
            }
            if (clickedComment.getComment().user.uin != LoginData.getInstance().getUin()) {
                EmoEditPanel.D1 = new EmoEditPanel.al(38, this.f46971h, 0);
                ap.f59791b.e(38, 1, 0, this.f46971h);
            }
            if (!clickedComment.getComment().isAbleToReply) {
                if (clickedComment.getComment().commentType == 1) {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastEssenceCommentNotAllowToReply", "\u7cbe\u534e\u8bc4\u8bba\u4e0d\u5141\u8bb8\u56de\u590d!"));
                    return;
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentNotAllowToReply", "\u5f53\u524d\u8bc4\u8bba\u4e0d\u5141\u8bb8\u56de\u590d!"));
                    return;
                }
            }
            com.qzone.detail.ui.component.b bVar = this.f46969e.get();
            if (bVar == null) {
                return;
            }
            bVar.p6(view, clickedComment.getComment(), clickedComment.getReply(), ((Integer) obj).intValue(), 101);
            A0(clickedComment.getComment().commentType == 1);
            if (this.f46972i) {
                g(2, 15);
                return;
            }
            return;
        }
        QZLog.e("FeedElementBaseClickListener", "comment is null!! click");
    }

    protected void y(View view, Object obj) {
        ArrayList<Comment> arrayList;
        Comment comment;
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("position");
        int i16 = bundle.getInt("commenttype", 0);
        com.qzone.detail.ui.component.b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        Comment comment2 = null;
        if (i16 == 0) {
            if (bVar.T0().R().getCommentInfo().commments != null && i3 > bVar.T0().R().getCommentInfo().commments.size() - 1) {
                return;
            }
            if (bVar.T0().R().getCommentInfo().commments != null) {
                comment2 = bVar.T0().R().getCommentInfo().commments.get(i3);
            }
        } else if (i16 == 1) {
            CellCommentEssence commentEssence = bVar.T0().R().getCommentEssence();
            if (commentEssence == null || (arrayList = commentEssence.commments) == null || arrayList.size() <= i3) {
                return;
            }
            comment = commentEssence.commments.get(i3);
            bVar.pc(view, comment, null, i3, 100);
        }
        comment = comment2;
        bVar.pc(view, comment, null, i3, 100);
    }

    protected void z(View view) {
        ClickedComment clickedComment = (ClickedComment) view.getTag();
        if (clickedComment != null && clickedComment.getComment() != null && clickedComment.getComment().user != null) {
            com.qzone.detail.ui.component.b bVar = this.f46969e.get();
            if (bVar == null) {
                return;
            }
            bVar.Ye(view, clickedComment.getComment(), clickedComment);
            return;
        }
        QZLog.e("OnDetailFeedElementClickListener", "comment is null!! long click");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f46996a;

        g(long j3) {
            this.f46996a = j3;
        }

        @Override // com.qzone.widget.util.b.d
        public void a() {
            LpReportInfo_pf00064.report(129, 6);
            BaseApplication context = BaseApplication.getContext();
            long j3 = this.f46996a;
            FeedElementBaseClickListener feedElementBaseClickListener = FeedElementBaseClickListener.this;
            vo.c.E(context, j3, feedElementBaseClickListener.F0(feedElementBaseClickListener.f46971h));
        }
    }

    private void C0(BusinessFeedData businessFeedData, int i3) {
        String str;
        if (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getUser() == null) {
            return;
        }
        if (businessFeedData.getUser().isSafeModeUser == 1) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(201, i3, 1, str, "1", businessFeedData.getFeedCommInfo().feedsid);
    }

    private void F(com.qzone.detail.ui.component.b bVar) {
        int cg5 = bVar != null ? bVar.cg() : -1;
        if (cg5 == 0) {
            new LpReportInfo_pf00064(463, 1, 2).reportImediately();
        } else if (cg5 == 1) {
            new LpReportInfo_pf00064(463, 1, 1).reportImediately();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F0(BusinessFeedData businessFeedData) {
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

    private void H(BusinessFeedData businessFeedData, Activity activity, Object obj) {
        HashMap hashMap;
        if (businessFeedData != null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getCellBottomRecomm() != null) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        if (businessFeedData == null || businessFeedData.getCellBottomRecomm() == null || TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
            return;
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(businessFeedData.getCellBottomRecomm().actionurl) && businessFeedData.isAppShareCardFeed()) {
            hashMap = new HashMap();
            hashMap.put("scene", 2003);
        } else {
            hashMap = null;
        }
        yo.d.e(businessFeedData.getCellBottomRecomm().actionurl, activity, null, hashMap);
    }

    private void K(BusinessFeedData businessFeedData, Activity activity) {
        if (businessFeedData != null && businessFeedData.getCellBottomRecomm() != null && !TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
            yo.d.d(businessFeedData.getCellBottomRecomm().actionurl, activity, null);
        }
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null) {
            return;
        }
        if (businessFeedData.getPictureInfo().isTravelAlbumData()) {
            ClickReport.q("302", "27", "7", true);
            return;
        }
        if (businessFeedData.getPictureInfo().isLoverAlbumData()) {
            ClickReport.q("302", "27", "8", true);
        } else if (businessFeedData.getPictureInfo().isBabyAlbumData()) {
            ClickReport.q("302", "27", "6", true);
        } else {
            ClickReport.q("302", "27", "5", true);
        }
    }

    private void d(Activity activity, long j3, int i3, int i16) {
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(BaseApplication.getContext(), 1, String.valueOf(j3), "", i3, i16, null, null, null, null, null);
        if (i3 == 3091) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, startAddFriend, QZoneContant.QZ_REQUEST_FEED_CARD_ADD_FRIEND);
        } else {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, startAddFriend, QZoneContant.QZ_REQUEST_FEED_ADD_FRIEND);
        }
    }

    private void r(BusinessFeedData businessFeedData, Activity activity, int i3) {
        if (businessFeedData == null || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getFeedCommInfo() == null) {
            return;
        }
        User user = businessFeedData.getOriginalInfo().getUser();
        int i16 = businessFeedData.getOriginalInfo().getFeedCommInfo().operatemask;
        if (user != null) {
            com.qzone.feed.business.model.c.d().e(businessFeedData, user.uin, i3);
            d(activity, user.uin, 3069, 21);
            ClickReport.p("644", "5", "", null, true);
        }
    }

    private void z0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getReferInfoV2() == null) {
            return;
        }
        CellReferInfo referInfoV2 = businessFeedData.getReferInfoV2();
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(302, 58, 1);
        lpReportInfo_pf00064.reserves3 = referInfoV2.appName;
        lpReportInfo_pf00064.reserves4 = referInfoV2.actionUrl;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public void X(View view, Object obj) {
        Activity activity;
        VideoInfo videoInfo;
        int i3;
        BusinessFeedData originalInfoSafe;
        CellPictureInfo pictureInfo;
        WeakReference<Activity> weakReference;
        BusinessFeedData originalInfoSafe2;
        if (obj == null || !(obj instanceof com.qzone.proxy.feedcomponent.model.f)) {
            return;
        }
        if (this.f46971h.isFakeFeedSafe()) {
            if (this.f46971h.isLongPicsBrowsingModeFeed()) {
                if (this.f46971h.getLongPicsCellPictureInfo() != null) {
                    originalInfoSafe2 = this.f46971h;
                } else {
                    originalInfoSafe2 = this.f46971h.getOriginalInfoSafe();
                }
                pictureInfo = originalInfoSafe2.getLongPicsCellPictureInfo();
            } else {
                if (this.f46971h.getPictureInfo() != null) {
                    originalInfoSafe = this.f46971h;
                } else {
                    originalInfoSafe = this.f46971h.getOriginalInfoSafe();
                }
                pictureInfo = originalInfoSafe.getPictureInfo();
            }
            CellPictureInfo cellPictureInfo = pictureInfo;
            if (cellPictureInfo == null || (weakReference = this.f46968d) == null || weakReference.get() == null) {
                return;
            }
            PictureViewerFactory.R(this.f46968d.get(), cellPictureInfo, this.f46971h.getFeedCommInfo(), ((com.qzone.proxy.feedcomponent.model.f) obj).a(), 1204, true);
            return;
        }
        CellPictureInfo pictureInfo2 = this.f46971h.getPictureInfo();
        if (pictureInfo2 == null && this.f46971h.getOriginalInfoSafe() != null) {
            pictureInfo2 = this.f46971h.getOriginalInfoSafe().getPictureInfo();
        }
        com.qzone.proxy.feedcomponent.model.f fVar = (com.qzone.proxy.feedcomponent.model.f) obj;
        int a16 = fVar.a();
        WeakReference<Activity> weakReference2 = this.f46968d;
        if (weakReference2 == null || (activity = weakReference2.get()) == null) {
            return;
        }
        boolean z16 = true;
        if (pictureInfo2 != null) {
            PictureItem pictureItem = null;
            if (pictureInfo2.actiontype != 22) {
                ArrayList<PictureItem> arrayList = pictureInfo2.pics;
                if (arrayList != null && arrayList.size() > a16) {
                    pictureItem = pictureInfo2.pics.get(a16);
                }
                if (!fVar.d() && pictureItem != null && pictureItem.videoflag == 1 && (videoInfo = pictureItem.videodata) != null && (i3 = videoInfo.videoStatus) != 2 && i3 != 5) {
                    if (i3 == 6) {
                        ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoDeleted", "\u5df2\u5220\u9664"));
                        return;
                    }
                    String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoTransCodding", "\u8f6c\u7801\u4e2d");
                    VideoInfo videoInfo2 = pictureItem.videodata;
                    if (videoInfo2.videoStatus == 1) {
                        String C0 = QZoneWriteOperationService.v0().C0(videoInfo2.videoId);
                        if (C0 != null) {
                            QZLog.d("FeedElementBaseClickListener", 1, "#\u540e\u53f0\u8f6c\u7801\u4e2d,onPhotoClick,cachePath=" + C0);
                            String uuid = UUID.randomUUID().toString();
                            VideoInfo videoInfo3 = pictureItem.videodata;
                            videoInfo3.isAutoPlay = true;
                            videoInfo3.videoStatus = 9;
                            videoInfo3.videoUrl = new VideoUrl(C0);
                            pictureItem.localFileUrl = C0;
                            r6.a.o().F(activity, this.f46971h, fVar.a(), fVar.c(), uuid);
                            z16 = false;
                        }
                    }
                    if (z16) {
                        ToastUtil.r(config);
                        return;
                    }
                    return;
                }
            } else {
                yo.d.d(pictureInfo2.actionurl, activity, null);
                return;
            }
        }
        if (fVar.d() && e(fVar.c())) {
            x0(true, fVar.c());
            r6.a.o().t(activity, this.f46971h);
        } else {
            if (this.f46971h.isCanvasAd() || this.f46971h.isAdvContainerThreeGridStyle()) {
                return;
            }
            r6.a.o().F(activity, this.f46971h, fVar.a(), fVar.c(), null);
        }
    }

    protected AbsFeedView j(View view) {
        if (view != null) {
            if (view instanceof AbsFeedView) {
                return (AbsFeedView) view;
            }
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof AbsFeedView) {
                    return (AbsFeedView) parent;
                }
            }
        }
        return null;
    }

    private void c0(CellReferInfo cellReferInfo, BusinessFeedData businessFeedData) {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (cellReferInfo == null || (weakReference = this.f46968d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        r6.a.v(activity, cellReferInfo);
        z0(businessFeedData);
    }

    private BusinessFeedData l(View view, BusinessFeedData businessFeedData) {
        if (view != null && businessFeedData != null) {
            try {
                if (businessFeedData.isSingleAdvContainerFeed() && businessFeedData.getRecBusinessFeedDatas() != null) {
                    AbsFeedView b16 = c6.a.b(view);
                    if (b16 != null && b16.mFeedData.isSubFeed) {
                        view = b16;
                    }
                    return businessFeedData.getRecBusinessFeedDatas().get(Integer.parseInt(view.getTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE)).toString()));
                }
            } catch (Exception e16) {
                QZLog.w("FeedElementBaseClickListener", 2, "catch an exception:", Log.getStackTraceString(e16));
            }
        }
        return businessFeedData;
    }

    private void Y(BusinessFeedData businessFeedData, View view, Object obj, boolean z16, final boolean z17, int i3) {
        PolymorphicLikeWindow polymorphicLikeWindow;
        w5.b.i("FeedElementBaseClickListener", 1, "[polyPraise].onPolymorphicLike, long clicked!, fromDetailBottomPraiseButton = " + z16 + ", needAutoShow = " + z17);
        if (businessFeedData == null) {
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, businessFeedData = " + businessFeedData);
            return;
        }
        if (!QZoneFeedUtil.l(businessFeedData, 21)) {
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, server error, operatemask2 = " + businessFeedData.getFeedCommInfo().operatemask2);
            return;
        }
        if (!BaseFeedClickProcessor.F1()) {
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, low-end mobile");
            return;
        }
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null) {
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, activity = " + this.f46968d);
            return;
        }
        Activity activity = weakReference.get();
        if (activity == null) {
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, currentActivity = " + activity);
            return;
        }
        com.qzone.detail.ui.component.b bVar = this.f46969e.get();
        StickerBubbleAnimationView z85 = bVar != null ? bVar.z8() : null;
        if (z85 == null) {
            w5.b.b("FeedElementBaseClickListener", 2, "no poke anim view");
            return;
        }
        if (obj instanceof SuperLikeView) {
            WeakReference<PolymorphicLikeWindow> weakReference2 = this.f46970f;
            if (weakReference2 != null && (polymorphicLikeWindow = weakReference2.get()) != null && polymorphicLikeWindow.isShowing()) {
                w5.b.i("FeedElementBaseClickListener", 1, "[polyPraise].onPolymorphicLike, poly praise has showing");
                return;
            }
            PokeLikeWizard pokeLikeWizard = PokeLikeWizard.INSTANCE;
            if (pokeLikeWizard.isLoadingGlobalData()) {
                ToastUtil.s(PolymorphicLikeWindow.K, 3);
                return;
            }
            final SuperLikeView superLikeView = (SuperLikeView) obj;
            WeakReference<PolymorphicLikeWindow> weakReference3 = new WeakReference<>(new PolymorphicLikeWindow(activity, superLikeView, view, z85, true));
            this.f46970f = weakReference3;
            final PolymorphicLikeWindow polymorphicLikeWindow2 = weakReference3.get();
            if (polymorphicLikeWindow2 != null) {
                polymorphicLikeWindow2.setFeedData(i3, businessFeedData);
                PolymorphicPraiseData polyPraiseData = QzonePolymorphicPraiseService.getInstance().getPolyPraiseData();
                if (pokeLikeWizard.isGlobalPokeItemDataEmpty()) {
                    if (polyPraiseData == null) {
                        w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, praiseData = " + polyPraiseData);
                        return;
                    }
                    ArrayList<PolymorphicPraiseEmotionData> arrayList = polyPraiseData.emotionDatas;
                    if (arrayList == null) {
                        w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, praiseData.emotionDatas = " + polyPraiseData.emotionDatas);
                        return;
                    }
                    if (arrayList.size() <= 0) {
                        w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, emotionDatas size = " + polyPraiseData.emotionDatas.size());
                        return;
                    }
                }
                polymorphicLikeWindow2.setPolymorphicLikeData(z16, polyPraiseData);
                polymorphicLikeWindow2.enableTouchDelegate();
                BaseFeedClickProcessor.s0(superLikeView);
                polymorphicLikeWindow2.setOnItemClickListener(new e(view, businessFeedData));
                w5.b.i("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, polymorphic data loaded");
                QzoneHandlerThreadFactory.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.detail.ui.component.FeedElementBaseClickListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (polymorphicLikeWindow2.hasFirstFrameLoaded()) {
                                polymorphicLikeWindow2.showPolymorphicPanel(superLikeView, z17);
                            } else {
                                polymorphicLikeWindow2.retryShowPolymorphicPanel(superLikeView, z17);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_POLY_PRAISE, QzoneConfig.SECONDARY_POLY_PRELOAD_TIME, 200));
                return;
            }
            w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, polymorphicLikeWindow = " + polymorphicLikeWindow2);
            return;
        }
        w5.b.b("FeedElementBaseClickListener", 2, "[polyPraise].onPolymorphicLike, obj = " + obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qzone.proxy.feedcomponent.ui.g
    public void onClick(View view, FeedElement feedElement, int i3, Object obj) {
        Activity activity;
        BusinessFeedData businessFeedData;
        Map<String, String> map;
        boolean z16;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        WeakReference<Activity> weakReference = this.f46968d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        BusinessFeedData businessFeedData4 = this.f46971h;
        if (obj instanceof BusinessFeedData) {
            BusinessFeedData businessFeedData5 = (BusinessFeedData) obj;
            if (businessFeedData5.isGDTAdvFeed()) {
                this.f46971h = businessFeedData5;
            }
        }
        BusinessFeedData l3 = l(view, this.f46971h);
        this.f46971h = l3;
        if (l3 != null && l3.isGDTAdvFeed()) {
            QLog.i("FeedElementBaseClickListener", 4, "[GdtClickHandlerForQzone] use new click handler for tangram ad");
            a.b bVar = new a.b();
            bVar.f401410c = 2;
            bVar.f401408a = new WeakReference<>(activity);
            bVar.f401412e = feedElement;
            bVar.f401414g = new WeakReference<>(view);
            bVar.f401409b = this.f46971h;
            g6.a.g(bVar);
        } else {
            QLog.i("FeedElementBaseClickListener", 4, "[GdtClickHandlerForQzone] use old click handler for tangram ad");
            GdtFeedUtilForQZone.A(new AdClickData.Builder().setContext(activity).setFeedData(this.f46971h).setView(view).setFeedElement(feedElement).setArgs(obj).setFeedIndex(i3).create());
        }
        com.qzone.detail.ui.component.b bVar2 = this.f46969e.get();
        if (this.f46971h == null) {
            return;
        }
        String str = "";
        switch (b.f46983a[feedElement.ordinal()]) {
            case 1:
                businessFeedData = businessFeedData4;
                r6.a.o().j((User) obj);
                businessFeedData2 = businessFeedData;
                break;
            case 2:
                businessFeedData = businessFeedData4;
                j0(this.f46971h, activity);
                businessFeedData2 = businessFeedData;
                break;
            case 3:
                businessFeedData = businessFeedData4;
                B();
                businessFeedData2 = businessFeedData;
                break;
            case 4:
                businessFeedData = businessFeedData4;
                ap.f59791b.e(19, 1, i3, this.f46971h);
                n0(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 5:
                businessFeedData = businessFeedData4;
                w(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 6:
                businessFeedData = businessFeedData4;
                x(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 7:
                businessFeedData = businessFeedData4;
                z(view);
                businessFeedData2 = businessFeedData;
                break;
            case 8:
                businessFeedData = businessFeedData4;
                f0(view, (Integer) obj);
                businessFeedData2 = businessFeedData;
                break;
            case 9:
                businessFeedData = businessFeedData4;
                h0(view);
                businessFeedData2 = businessFeedData;
                break;
            case 10:
                businessFeedData = businessFeedData4;
                A(view);
                businessFeedData2 = businessFeedData;
                break;
            case 11:
                businessFeedData = businessFeedData4;
                R(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 12:
                businessFeedData = businessFeedData4;
                e0(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 13:
                businessFeedData = businessFeedData4;
                M(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 14:
                businessFeedData = businessFeedData4;
                Z(view);
                businessFeedData2 = businessFeedData;
                break;
            case 15:
                businessFeedData = businessFeedData4;
                C();
                businessFeedData2 = businessFeedData;
                break;
            case 16:
            case 17:
            case 86:
                businessFeedData2 = businessFeedData4;
                break;
            case 18:
                businessFeedData = businessFeedData4;
                u0((Bundle) obj);
                businessFeedData2 = businessFeedData;
                break;
            case 19:
                businessFeedData = businessFeedData4;
                QZLog.d("FeedElementBaseClickListener", 1, "video clicked: gesture action");
                q0(new com.qzone.proxy.feedcomponent.model.e((String) obj, "", i3), view, this.f46971h);
                businessFeedData2 = businessFeedData;
                break;
            case 20:
                businessFeedData = businessFeedData4;
                s((VideoPlayInfo) obj, view, i3);
                businessFeedData2 = businessFeedData;
                break;
            case 21:
            case 22:
                businessFeedData = businessFeedData4;
                t(feedElement, this.f46971h);
                businessFeedData2 = businessFeedData;
                break;
            case 23:
                businessFeedData = businessFeedData4;
                u(obj);
                businessFeedData2 = businessFeedData;
                break;
            case 24:
            case 25:
                businessFeedData = businessFeedData4;
                q0(obj, view, this.f46971h);
                businessFeedData2 = businessFeedData;
                break;
            case 26:
            case 27:
                businessFeedData = businessFeedData4;
                ap.f59791b.e(17, 1, i3, this.f46971h);
                r0(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 28:
            case 29:
                businessFeedData = businessFeedData4;
                a0();
                businessFeedData2 = businessFeedData;
                break;
            case 30:
            case 31:
                businessFeedData = businessFeedData4;
                ap.f59791b.e(18, 1, i3, this.f46971h);
                s0(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 32:
                businessFeedData = businessFeedData4;
                User user = this.f46971h.getUser();
                if (user != null) {
                    vo.a.a(user.uin, 7);
                }
                businessFeedData2 = businessFeedData;
                break;
            case 33:
                businessFeedData = businessFeedData4;
                k0(this.f46971h);
                businessFeedData2 = businessFeedData;
                break;
            case 34:
                businessFeedData = businessFeedData4;
                ap.f59791b.e(18, 1, i3, this.f46971h);
                N(obj);
                businessFeedData2 = businessFeedData;
                break;
            case 35:
                businessFeedData = businessFeedData4;
                U();
                businessFeedData2 = businessFeedData;
                break;
            case 36:
            case 37:
                businessFeedData = businessFeedData4;
                w0(feedElement, view);
                businessFeedData2 = businessFeedData;
                break;
            case 38:
                businessFeedData = businessFeedData4;
                BusinessFeedData businessFeedData6 = this.f46971h;
                if (businessFeedData6 != null && businessFeedData6.getFeedCommInfo() != null && (map = this.f46971h.getFeedCommInfo().extendInfo) != null) {
                    String str2 = map.get("kuolie_feed_report_url");
                    if (!TextUtils.isEmpty(str2)) {
                        yo.d.d(str2, activity, null);
                    }
                }
                businessFeedData2 = businessFeedData;
                break;
            case 39:
                businessFeedData = businessFeedData4;
                BusinessFeedData businessFeedData7 = this.f46971h;
                if (businessFeedData7 != null && businessFeedData7.isAdFeeds()) {
                    P(view);
                }
                businessFeedData2 = businessFeedData;
                break;
            case 40:
                businessFeedData = businessFeedData4;
                o();
                C0(this.f46971h, 1);
                businessFeedData2 = businessFeedData;
                break;
            case 41:
                businessFeedData = businessFeedData4;
                T(obj);
                businessFeedData2 = businessFeedData;
                break;
            case 42:
                businessFeedData = businessFeedData4;
                ap.f59791b.e(21, 1, i3, this.f46971h);
                X(view, obj);
                businessFeedData2 = businessFeedData;
                break;
            case 43:
                businessFeedData = businessFeedData4;
                r6.a.o().g(this.f46971h, i3, view);
                businessFeedData2 = businessFeedData;
                break;
            case 44:
                if (this.f46971h != null) {
                    businessFeedData = businessFeedData4;
                    QZoneWriteOperationService.v0().L(this.f46971h.getOperationInfo().cookie, this.f46971h.isAttach() ? 30 : 25, 0, i3, 2, 0, true, false, null, null, 0L, false, false, null, false, this.f46971h);
                    businessFeedData2 = businessFeedData;
                    break;
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 45:
                if (obj instanceof String) {
                    str = (String) obj;
                }
                if (!TextUtils.isEmpty(str)) {
                    yo.d.d(str, activity, null);
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 46:
                c0((CellReferInfo) obj, this.f46971h);
                businessFeedData2 = businessFeedData4;
                break;
            case 47:
                p(view, feedElement);
                businessFeedData2 = businessFeedData4;
                break;
            case 48:
                if (bVar2 != null) {
                    bVar2.q4(view, obj);
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 49:
                O();
                businessFeedData2 = businessFeedData4;
                break;
            case 50:
                r6.a.o().z(activity, (CellLeftThumb) obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 51:
                r6.a.o().A(activity, (CellLeftThumb) obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 52:
                com.qzone.adapter.feedcomponent.i.H().p(activity);
                businessFeedData2 = businessFeedData4;
                break;
            case 53:
                com.qzone.adapter.feedcomponent.i.H().q(activity, this.f46971h);
                businessFeedData2 = businessFeedData4;
                break;
            case 54:
                com.qzone.adapter.feedcomponent.i.H().o(activity, this.f46971h);
                businessFeedData2 = businessFeedData4;
                break;
            case 55:
                W();
                businessFeedData2 = businessFeedData4;
                break;
            case 56:
                d0();
                businessFeedData2 = businessFeedData4;
                break;
            case 57:
                v0();
                businessFeedData2 = businessFeedData4;
                break;
            case 58:
                t0();
                businessFeedData2 = businessFeedData4;
                break;
            case 59:
                f(this.f46971h, true, 10);
                businessFeedData2 = businessFeedData4;
                break;
            case 60:
                Q(this.f46971h, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 61:
                E(view, obj, bVar2);
                businessFeedData2 = businessFeedData4;
                break;
            case 62:
                F(bVar2);
                businessFeedData2 = businessFeedData4;
                break;
            case 63:
                S(view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 64:
                q(view);
                businessFeedData2 = businessFeedData4;
                break;
            case 65:
                L(activity);
                businessFeedData2 = businessFeedData4;
                break;
            case 66:
                p(view, feedElement);
                businessFeedData2 = businessFeedData4;
                break;
            case 67:
                I(this.f46971h, activity);
                businessFeedData2 = businessFeedData4;
                break;
            case 68:
                V(feedElement, view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 69:
            case 70:
                H(this.f46971h, activity, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 71:
                J(this.f46971h, activity, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 72:
                K(this.f46971h, activity);
                businessFeedData2 = businessFeedData4;
                break;
            case 73:
                y(view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 74:
                g0(view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 75:
                String str3 = this.f46971h.getCellForwardInfo() != null ? this.f46971h.getCellForwardInfo().actionUrl : null;
                if (!TextUtils.isEmpty(str3)) {
                    yo.d.d(str3, activity, null);
                }
                C0(this.f46971h, 3);
                businessFeedData2 = businessFeedData4;
                break;
            case 76:
                G(activity, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 77:
                v(activity, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 78:
                p0(view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 79:
                if (bVar2 != null) {
                    bVar2.k3(view, obj);
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 80:
                o0(view, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 81:
                b0(this.f46971h);
                businessFeedData2 = businessFeedData4;
                break;
            case 82:
                r(this.f46971h, activity, i3);
                businessFeedData2 = businessFeedData4;
                break;
            case 83:
                ClickReport.p("644", "6", "", null, true);
                businessFeedData2 = businessFeedData4;
                break;
            case 84:
                ClickReport.p("644", "7", "", null, true);
                businessFeedData2 = businessFeedData4;
                break;
            case 85:
                D(this.f46971h, activity, bVar2);
                businessFeedData2 = businessFeedData4;
                break;
            case 87:
                Y(this.f46971h, view, obj, false, false, i3);
                businessFeedData2 = businessFeedData4;
                break;
            case 88:
                Y(this.f46971h, view, obj, true, false, i3);
                businessFeedData2 = businessFeedData4;
                break;
            case 89:
                User user2 = this.f46971h.getUser();
                if (user2 != null) {
                    Intent intent = new Intent();
                    intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, 1);
                    intent.putExtra("uin", user2.uin);
                    intent.putExtra("nickname", user2.nickName);
                    Map<Integer, String> map2 = this.f46971h.getOperationInfo().feedReportCookie;
                    if (map2 != null) {
                        intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_EXTEND_FRIEND_CAMPUS_ALGORITHM_ID, map2.get(43));
                    }
                    PublicFragmentActivity.b.d(activity, intent, PublicTransFragmentActivity.class, QZoneNavigateToQQTransparentFragment.class, 0);
                    if (this.f46971h.isEnableLimitChat()) {
                        ap.f59791b.e(218, 1, i3, this.f46971h);
                    } else {
                        ap.f59791b.e(219, 1, i3, this.f46971h);
                    }
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 90:
                if (this.f46971h == null || !com.qzone.feed.business.model.c.d().a() || this.f46971h.getFeedCommInfo().isFriendAdded) {
                    z16 = true;
                } else {
                    com.qzone.feed.business.model.c d16 = com.qzone.feed.business.model.c.d();
                    BusinessFeedData businessFeedData8 = this.f46971h;
                    d16.e(businessFeedData8, businessFeedData8.getUser().uin, i3);
                    z16 = true;
                    d(activity, this.f46971h.getUser().uin, 3069, 21);
                }
                ClickReport.q("22", "2", "", z16);
                businessFeedData2 = businessFeedData4;
                break;
            case 91:
                h(this.f46971h, obj);
                businessFeedData2 = businessFeedData4;
                break;
            case 92:
                LpReportInfo_pf00064.allReport(209, 2, 12);
                businessFeedData2 = businessFeedData4;
                break;
            case 93:
                BusinessFeedData businessFeedData9 = this.f46971h;
                CellAlbumEntrance cellAlbumEntrance = businessFeedData9.cellAlbumEntrance;
                int i16 = cellAlbumEntrance.button_actiontype;
                if (i16 == 2) {
                    onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(cellAlbumEntrance.guideUrl, "", i3));
                } else if (i16 == 60) {
                    m(businessFeedData9);
                }
                ap.f59791b.e(212, 1, i3, this.f46971h);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("action_area", "feeds_entrance_button_click");
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_feeds_games_share", true, 0L, 0L, hashMap, null);
                businessFeedData2 = businessFeedData4;
                break;
            case 94:
                if (obj instanceof Map) {
                    Map map3 = (Map) obj;
                    try {
                        String str4 = (String) map3.get("url");
                        int intValue = ((Integer) map3.get("type")).intValue();
                        String str5 = (String) map3.get(RegionData.KEY_BG_IMG_URL);
                        if (str4 == null) {
                            QZLog.w("FeedElementBaseClickListener", "onClick: GAME_SHARE_HOT_AREA null action url");
                        } else {
                            if (intValue == 1 && QZoneApiProxy.isInQZoneEnvironment()) {
                                E0(view, str5, str4);
                            } else {
                                onClick(view, FeedElement.URL, i3, new com.qzone.proxy.feedcomponent.model.e(str4, "", i3));
                            }
                            HashMap hashMap2 = new HashMap(1);
                            hashMap2.put(2, str4);
                            ap.f59791b.f(213, 1, i3, this.f46971h, hashMap2, null);
                            HashMap<String, String> hashMap3 = new HashMap<>();
                            hashMap3.put("action_area", "hot_space_click");
                            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_feeds_games_share", true, 0L, 0L, hashMap3, null);
                        }
                    } catch (Exception e16) {
                        QZLog.w("FeedElementBaseClickListener", "onClick: GAME_SHARE_HOT_AREA wrong type", e16);
                    }
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 95:
                ho.i.e().i(activity, this.f46971h, 0, 0L);
                businessFeedData2 = businessFeedData4;
                break;
            case 96:
                QZLog.i("FeedElementBaseClickListener", "@adVideoPlayerExpose  FEEDVIDEO_PLAY_ADV_TIME_EXPOSE click");
                com.tencent.gdtad.statistics.a.b(2, 3, GdtFeedUtilForQZone.f(this.f46971h));
                businessFeedData2 = businessFeedData4;
                break;
            case 97:
                if (obj instanceof ComboNetImageCell) {
                    ComboNetImageCell comboNetImageCell = (ComboNetImageCell) obj;
                    y0(comboNetImageCell.getUin().longValue(), comboNetImageCell.getNickName(), comboNetImageCell.getPokeZipUrl(), comboNetImageCell.getCombo());
                    businessFeedData3 = this.f46971h;
                    if (businessFeedData3 != null && businessFeedData3.getCellBottomRecomm() != null && !TextUtils.isEmpty(this.f46971h.getCellBottomRecomm().actionurl)) {
                        yo.d.d(this.f46971h.getCellBottomRecomm().actionurl, activity, null);
                    }
                }
                businessFeedData2 = businessFeedData4;
                break;
            case 98:
                businessFeedData3 = this.f46971h;
                if (businessFeedData3 != null) {
                    yo.d.d(this.f46971h.getCellBottomRecomm().actionurl, activity, null);
                    break;
                }
                businessFeedData2 = businessFeedData4;
                break;
            default:
                businessFeedData = businessFeedData4;
                if (bVar2 != null) {
                    businessFeedData2 = businessFeedData;
                    bVar2.m2(view, this.f46971h, feedElement, i3, obj);
                    break;
                }
                businessFeedData2 = businessFeedData;
                break;
        }
        this.f46971h = businessFeedData2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f46993d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f46994e;

        f(Activity activity, String str) {
            this.f46993d = activity;
            this.f46994e = str;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            try {
                ((ClipboardManager) this.f46993d.getSystemService("clipboard")).setText(this.f46994e);
                QQToast.makeText(this.f46993d.getApplicationContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f"), 0).show();
            } catch (Exception unused) {
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
        }
    }

    protected void b0(BusinessFeedData businessFeedData) {
    }

    private void h(BusinessFeedData businessFeedData, Object obj) {
    }

    private void D(BusinessFeedData businessFeedData, Activity activity, com.qzone.detail.ui.component.b bVar) {
    }

    protected void f(BusinessFeedData businessFeedData, boolean z16, int i3) {
    }
}
