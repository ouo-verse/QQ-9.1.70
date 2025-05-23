package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDCReporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDTReporter;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001>\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u000f\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0011\u0010\t\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView;", "Landroid/widget/RelativeLayout;", "Lcom/qzone/module/feedcomponent/ui/QZoneFrdHotVideoLifeCycle;", "Lcom/qzone/reborn/feedx/itemview/friendlike/b;", "", "setupMask", "Lcom/qzone/proxy/feedcomponent/model/i;", "subFeedInfo", "", "position", "", "checkNeedUpdate", "openFullScreenVideo", "", "actionUrl", "rebuildActionUrl", "Lcom/qzone/module/feedcomponent/ui/FeedVideoView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "configVideoView", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "transferLikeCountToStr", "startExposure", "tryEndExposure", "onStartPlayVideo", "onEndPlayVideo", "updateData", "canAutoPlay", "hasVideoView", "addVideoView", "removeVideoView", "getFeedVideoView", "onAttachToRecyclerView", "onDetachFromRecyclerView", "onParentRecycled", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "Lcom/qzone/module/feedcomponent/view/AvatarImageView;", "avatarView", "Lcom/qzone/module/feedcomponent/view/AvatarImageView;", "nickNameView", "likeCountView", "Landroid/widget/FrameLayout;", "videoContainer", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "videoCoverView", "Landroid/widget/ImageView;", "recommendReasonView", "_position", "I", "curSubFeedInfo", "Lcom/qzone/proxy/feedcomponent/model/i;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "", "startExposureTimestamp", "J", "videoStartTimestamp", "com/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView$videoPlayStatusList$1", "videoPlayStatusList", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView$videoPlayStatusList$1;", "getPosition", "()I", "getSubFeedInfo", "()Lcom/qzone/proxy/feedcomponent/model/i;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoItemView extends RelativeLayout implements QZoneFrdHotVideoLifeCycle, com.qzone.reborn.feedx.itemview.friendlike.b {
    private static final String TAG = "QZoneOldFrdHotVideoItemView";
    private static final float VIDEO_RATIO = 0.75f;
    private static final int itemHeight;
    private static final int itemWidth;
    private static final int videoViewHeight;
    private int _position;
    private AvatarImageView avatarView;
    private FrdHotVideoSubFeedInfo curSubFeedInfo;
    private TextView likeCountView;
    private Handler mainHandler;
    private TextView nickNameView;
    private TextView recommendReasonView;
    private long startExposureTimestamp;
    private TextView titleView;
    private FrameLayout videoContainer;
    private ImageView videoCoverView;
    private final QZoneOldFrdHotVideoItemView$videoPlayStatusList$1 videoPlayStatusList;
    private long videoStartTimestamp;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float cardRadius = ef.d.a(Float.valueOf(4.0f));

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView$Companion;", "", "()V", "TAG", "", "VIDEO_RATIO", "", "cardRadius", "itemHeight", "", "itemWidth", "getItemWidth", "()I", "videoViewHeight", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getItemWidth() {
            return QZoneOldFrdHotVideoItemView.itemWidth;
        }

        Companion() {
        }
    }

    static {
        int screenWidth = ((ViewUtils.getScreenWidth() - (QZoneOldFrdHotVideoFeedListView.INSTANCE.getSpaceSize() * 3)) / 5) * 2;
        itemWidth = screenWidth;
        int i3 = (int) (screenWidth / 0.75f);
        videoViewHeight = i3;
        itemHeight = i3 + ef.d.b(80);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneOldFrdHotVideoItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._position = -1;
        this.mainHandler = new Handler(Looper.getMainLooper());
        LayoutInflater.from(context).inflate(R.layout.coh, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.qzone_skin_feed_card_bg_shadow_8);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById(R.id.f2103new);
        float f16 = cardRadius;
        roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        View findViewById = findViewById(R.id.n2c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_frd_hot_video_title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f20648y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_frd_like_video_item_avatar)");
        this.avatarView = (AvatarImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f206791);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_frd_like_video_item_nick)");
        this.nickNameView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f20658z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_f\u2026ke_video_item_like_count)");
        this.likeCountView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.nkz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.video_container)");
        this.videoContainer = (FrameLayout) findViewById5;
        View findViewById6 = findViewById(R.id.f162965nl0);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.video_cover_view)");
        this.videoCoverView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f162933ne3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.recommend_reason_view)");
        this.recommendReasonView = (TextView) findViewById7;
        setLayoutParams(new RecyclerView.LayoutParams(itemWidth, -2));
        ViewGroup.LayoutParams layoutParams = this.videoContainer.getLayoutParams();
        int i3 = videoViewHeight;
        layoutParams.height = i3;
        this.videoCoverView.getLayoutParams().height = i3;
        setupMask();
        VideoReport.setPageId(this, "pg_discover_feeds_page");
        this.videoPlayStatusList = new QZoneOldFrdHotVideoItemView$videoPlayStatusList$1(this);
    }

    private final boolean checkNeedUpdate(FrdHotVideoSubFeedInfo subFeedInfo, int position) {
        BusinessFeedData originFeedData;
        VideoInfo videoInfo;
        ParsedFeedData parsedFeedData;
        if (this._position == position) {
            String feedId = subFeedInfo.getParsedFeedData().getFeedId();
            FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
            VideoUrl videoUrl = null;
            if (Intrinsics.areEqual(feedId, (frdHotVideoSubFeedInfo == null || (parsedFeedData = frdHotVideoSubFeedInfo.getParsedFeedData()) == null) ? null : parsedFeedData.getFeedId())) {
                VideoUrl videoUrl2 = subFeedInfo.getOriginFeedData().getVideoInfo().videoUrl;
                FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo2 = this.curSubFeedInfo;
                if (frdHotVideoSubFeedInfo2 != null && (originFeedData = frdHotVideoSubFeedInfo2.getOriginFeedData()) != null && (videoInfo = originFeedData.getVideoInfo()) != null) {
                    videoUrl = videoInfo.videoUrl;
                }
                if (Intrinsics.areEqual(videoUrl2, videoUrl)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void configVideoView(FeedVideoView feedVideoView, BusinessFeedData businessFeedData) {
        feedVideoView.setForceToWH(true, itemWidth, videoViewHeight);
        feedVideoView.setFeedData(businessFeedData, businessFeedData.getVideoInfo());
        FeedAutoVideo feedAutoVideo = feedVideoView.mAutoVideoView;
        feedAutoVideo.mVideoCover.showPlayIcon = false;
        feedAutoVideo.hideSoundLine();
        feedAutoVideo.mVideoCover.setShowOpenFreeTrafficIcon(false);
        if (businessFeedData.getVideoInfo().width < businessFeedData.getVideoInfo().height) {
            feedAutoVideo.setIsCenterCrop(true);
        } else {
            feedAutoVideo.setIsCenterInside(true);
        }
        feedVideoView.setOnVideoPlayStatusListener(this.videoPlayStatusList);
        feedVideoView.setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEndPlayVideo() {
        if (this.videoStartTimestamp > 0) {
            FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
            if (frdHotVideoSubFeedInfo != null) {
                QZoneFrdHotVideoDCReporter qZoneFrdHotVideoDCReporter = QZoneFrdHotVideoDCReporter.INSTANCE;
                ParsedFeedData parsedFeedData = frdHotVideoSubFeedInfo.getParsedFeedData();
                int i3 = this._position + 1;
                int i16 = itemWidth;
                long j3 = this.videoStartTimestamp;
                long currentTimeMillis = System.currentTimeMillis() - this.videoStartTimestamp;
                VideoInfo videoInfo = frdHotVideoSubFeedInfo.getOriginFeedData().getVideoInfo();
                qZoneFrdHotVideoDCReporter.reportStopPlayVideo(parsedFeedData, i3, i16, j3, currentTimeMillis, videoInfo != null ? videoInfo.videoTime : 0L);
                QZoneFrdHotVideoDTReporter.INSTANCE.unbindVideoPlayerInfo(this);
                VideoReportManager.getInstance().stop(this);
            }
            this.videoStartTimestamp = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStartPlayVideo() {
        this.videoStartTimestamp = System.currentTimeMillis();
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null) {
            QZoneFrdHotVideoDTReporter.INSTANCE.bindVideoPlayerInfo(this, frdHotVideoSubFeedInfo.getParsedFeedData());
            VideoReportManager.getInstance().start(this);
        }
    }

    private final void openFullScreenVideo() {
        ParsedFeedData parsedFeedData;
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null && (parsedFeedData = frdHotVideoSubFeedInfo.getParsedFeedData()) != null) {
            String videoActionUrl = parsedFeedData.getVideoActionUrl();
            QLog.i(TAG, 1, "click video, rawActionUrl=" + videoActionUrl);
            String rebuildActionUrl = rebuildActionUrl(videoActionUrl);
            QLog.i(TAG, 1, "click video, targetActionUrl=" + rebuildActionUrl);
            yo.d.d(rebuildActionUrl, getContext(), null);
            QZoneFrdHotVideoDCReporter.INSTANCE.reportClick(parsedFeedData, this._position + 1, itemWidth, System.currentTimeMillis());
            QZoneFrdHotVideoDTReporter.INSTANCE.reportClick(this, parsedFeedData, get_position() + 1);
            QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedClick(parsedFeedData.getFeedId(), get_position() + 1);
            return;
        }
        QLog.i(TAG, 1, "click video, without curSubFeedInfo");
    }

    private final String rebuildActionUrl(String actionUrl) {
        FeedAutoVideo autoVideoView;
        BaseVideoManager baseVideoManager;
        FeedVideoView feedVideoView = getFeedVideoView();
        Object h16 = (feedVideoView == null || (autoVideoView = feedVideoView.getAutoVideoView()) == null || (baseVideoManager = autoVideoView.getBaseVideoManager()) == null) ? null : baseVideoManager.h();
        Integer num = h16 instanceof Integer ? (Integer) h16 : null;
        int intValue = num != null ? num.intValue() : 0;
        if (!(actionUrl.length() > 0) || intValue <= 0) {
            return actionUrl;
        }
        String uri = Uri.parse(actionUrl).buildUpon().appendQueryParameter(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(intValue)).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "{\n            Uri.parse(\u2026ld().toString()\n        }");
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupMask$lambda$0(QZoneOldFrdHotVideoItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openFullScreenVideo();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void startExposure() {
        this.startExposureTimestamp = System.currentTimeMillis();
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null) {
            QZoneFrdHotVideoDCReporter.INSTANCE.reportStartExposure(frdHotVideoSubFeedInfo.getParsedFeedData(), this._position + 1, itemWidth, this.startExposureTimestamp);
            QZoneFrdHotVideoDTReporter.INSTANCE.reportItemExposure(this, frdHotVideoSubFeedInfo.getParsedFeedData(), get_position() + 1);
            QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedStartExposure(frdHotVideoSubFeedInfo.getParsedFeedData().getFeedId(), get_position() + 1);
        }
    }

    private final void tryEndExposure() {
        if (this.startExposureTimestamp > 0) {
            FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
            if (frdHotVideoSubFeedInfo != null) {
                QZoneFrdHotVideoDCReporter.INSTANCE.reportEndExposure(frdHotVideoSubFeedInfo.getParsedFeedData(), this._position + 1, itemWidth, this.startExposureTimestamp, System.currentTimeMillis() - this.startExposureTimestamp);
            }
            this.startExposureTimestamp = 0L;
        }
    }

    public final void addVideoView() {
        FeedVideoView feedVideoView = new FeedVideoView(getContext());
        this.videoContainer.addView(feedVideoView, new FrameLayout.LayoutParams(-1, -1));
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null) {
            configVideoView(feedVideoView, frdHotVideoSubFeedInfo.getOriginFeedData());
        }
    }

    public final boolean canAutoPlay() {
        BusinessFeedData originFeedData;
        VideoInfo videoInfo;
        ParsedFeedData parsedFeedData;
        ParsedFeedData parsedFeedData2;
        BusinessFeedData originFeedData2;
        VideoInfo videoInfo2;
        if (!com.qzone.adapter.feedcomponent.i.H().m()) {
            QLog.i(TAG, 1, "env not support video autoPlay");
            return false;
        }
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if ((frdHotVideoSubFeedInfo == null || (originFeedData2 = frdHotVideoSubFeedInfo.getOriginFeedData()) == null || (videoInfo2 = originFeedData2.getVideoInfo()) == null || !videoInfo2.isAutoPlay()) ? false : true) {
            return true;
        }
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo2 = this.curSubFeedInfo;
        Byte b16 = null;
        String feedId = (frdHotVideoSubFeedInfo2 == null || (parsedFeedData2 = frdHotVideoSubFeedInfo2.getParsedFeedData()) == null) ? null : parsedFeedData2.getFeedId();
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo3 = this.curSubFeedInfo;
        String title = (frdHotVideoSubFeedInfo3 == null || (parsedFeedData = frdHotVideoSubFeedInfo3.getParsedFeedData()) == null) ? null : parsedFeedData.getTitle();
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo4 = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo4 != null && (originFeedData = frdHotVideoSubFeedInfo4.getOriginFeedData()) != null && (videoInfo = originFeedData.getVideoInfo()) != null) {
            b16 = Byte.valueOf(videoInfo.playType);
        }
        QLog.i(TAG, 1, "video can't autoPlay, feedId=" + feedId + ", title=" + title + ",playType=" + b16);
        return false;
    }

    public final FeedVideoView getFeedVideoView() {
        if (this.videoContainer.getChildCount() <= 0) {
            return null;
        }
        View childAt = this.videoContainer.getChildAt(0);
        if (childAt instanceof FeedVideoView) {
            return (FeedVideoView) childAt;
        }
        return null;
    }

    /* renamed from: getPosition, reason: from getter */
    public final int get_position() {
        return this._position;
    }

    @Override // com.qzone.reborn.feedx.itemview.friendlike.b
    /* renamed from: getSubFeedInfo, reason: from getter */
    public FrdHotVideoSubFeedInfo getCurSubFeedInfo() {
        return this.curSubFeedInfo;
    }

    public final boolean hasVideoView() {
        return this.videoContainer.getChildCount() > 0;
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onAttachToRecyclerView() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onAttachToRecyclerView(this);
        startExposure();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onDetachFromRecyclerView() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onDetachFromRecyclerView(this);
        tryEndExposure();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onParentRecycled() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onParentRecycled(this);
        tryEndExposure();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onPause() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onPause(this);
        tryEndExposure();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onResume() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onResume(this);
    }

    public final void removeVideoView() {
        this.videoContainer.removeAllViews();
        this.videoCoverView.setVisibility(0);
    }

    public final void updateData(FrdHotVideoSubFeedInfo subFeedInfo, int position) {
        ImageView.ScaleType scaleType;
        ColorDrawable colorDrawable;
        Intrinsics.checkNotNullParameter(subFeedInfo, "subFeedInfo");
        if (checkNeedUpdate(subFeedInfo, position)) {
            this._position = position;
            this.curSubFeedInfo = subFeedInfo;
            ParsedFeedData parsedFeedData = subFeedInfo.getParsedFeedData();
            this.videoContainer.removeAllViews();
            this.titleView.setText(parsedFeedData.getTitle());
            this.avatarView.setAvatarMask(0);
            if (parsedFeedData.getAvatarUrl().length() > 0) {
                this.avatarView.loadAvatar(parsedFeedData.getAvatarUrl());
            } else {
                this.avatarView.loadAvatar(parsedFeedData.getPosterId());
            }
            this.nickNameView.setText(parsedFeedData.getPosterName());
            this.likeCountView.setText(transferLikeCountToStr(parsedFeedData.getLikeCount()));
            this.recommendReasonView.setVisibility(parsedFeedData.getClipedRecommendReason().length() > 0 ? 0 : 8);
            this.recommendReasonView.setText(parsedFeedData.getClipedRecommendReason());
            ImageView imageView = this.videoCoverView;
            if (parsedFeedData.getCoverWidth() > parsedFeedData.getCoverHeight()) {
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
            } else {
                scaleType = ImageView.ScaleType.CENTER_CROP;
            }
            imageView.setScaleType(scaleType);
            if (com.qzone.adapter.feedcomponent.i.H().p1()) {
                colorDrawable = new ColorDrawable(Color.parseColor("#2B2B2B"));
            } else {
                colorDrawable = new ColorDrawable(Color.parseColor("#F5F5F5"));
            }
            this.videoCoverView.setVisibility(0);
            this.videoCoverView.setImageDrawable(colorDrawable);
            ImageLoader.Options options = new ImageLoader.Options();
            if (this.videoCoverView.getWidth() > 0 && this.videoCoverView.getHeight() > 0) {
                options.clipWidth = this.videoCoverView.getWidth();
                options.clipHeight = this.videoCoverView.getHeight();
            }
            ImageLoader.getInstance().loadImageAsync(parsedFeedData.getCoverUrl(), new QZoneOldFrdHotVideoItemView$updateData$1$1(this), options);
        }
    }

    private final void setupMask() {
        View findViewById = findViewById(R.id.mzl);
        findViewById.getLayoutParams().height = itemHeight;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneOldFrdHotVideoItemView.setupMask$lambda$0(QZoneOldFrdHotVideoItemView.this, view);
            }
        });
    }

    private final String transferLikeCountToStr(int likeCount) {
        if (likeCount < 10000) {
            return String.valueOf(likeCount);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(likeCount / 10000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format + "w";
    }
}
