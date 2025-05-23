package com.qzone.reborn.feedx.itemview.friendlike;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDCReporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDTReporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.presenter.QZoneFeedFrdHotVideoListPresenter;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010$\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u00103R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout;", "Landroid/widget/RelativeLayout;", "Lcom/qzone/module/feedcomponent/ui/QZoneFrdHotVideoLifeCycle;", "Lcom/qzone/reborn/feedx/itemview/friendlike/b;", "", tl.h.F, "j", "l", "f", "", "actionUrl", "g", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "k", "Lcom/qzone/proxy/feedcomponent/model/i;", "subFeedInfo", "position", "positionInQZoneFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoView;", "e", "onAttachToRecyclerView", "onDetachFromRecyclerView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "nickNameView", "likeCountView", "i", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoView;", "videoView", "recommendReasonView", BdhLogUtil.LogTag.Tag_Conn, "I", "_position", "D", "Lcom/qzone/proxy/feedcomponent/model/i;", "curSubFeedInfo", "", "E", "J", "startExposureTimestamp", "()I", "getSubFeedInfo", "()Lcom/qzone/proxy/feedcomponent/model/i;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFrdHotVideoItemLayout extends RelativeLayout implements QZoneFrdHotVideoLifeCycle, b {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float G = ef.d.a(Float.valueOf(4.0f));
    private static final int H;
    private static final int I;
    private static final int J;

    /* renamed from: C, reason: from kotlin metadata */
    private int _position;

    /* renamed from: D, reason: from kotlin metadata */
    private FrdHotVideoSubFeedInfo curSubFeedInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private long startExposureTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView likeCountView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneFrdHotVideoView videoView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView recommendReasonView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout$a;", "", "", "itemWidth", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "", "VIDEO_RATIO", UserInfo.SEX_FEMALE, "cardRadius", "itemHeight", "videoViewHeight", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.itemview.friendlike.QZoneFrdHotVideoItemLayout$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QZoneFrdHotVideoItemLayout.H;
        }

        Companion() {
        }
    }

    static {
        int screenWidth = ViewUtils.getScreenWidth();
        QZoneFeedFrdHotVideoListPresenter.Companion companion = QZoneFeedFrdHotVideoListPresenter.INSTANCE;
        int a16 = (((screenWidth - (companion.a() * 2)) - companion.b()) / 5) * 2;
        H = a16;
        int i3 = (int) (a16 / 0.75f);
        I = i3;
        J = i3 + ef.d.b(80);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFrdHotVideoItemLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._position = -1;
        LayoutInflater.from(context).inflate(R.layout.c2x, (ViewGroup) this, true);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById(R.id.f2103new);
        float f16 = G;
        roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        View findViewById = findViewById(R.id.n2c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_frd_hot_video_title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f20648y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_frd_like_video_item_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = findViewById(R.id.f206791);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_frd_like_video_item_nick)");
        this.nickNameView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f20658z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_f\u2026ke_video_item_like_count)");
        this.likeCountView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f162933ne3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.recommend_reason_view)");
        this.recommendReasonView = (TextView) findViewById5;
        int i3 = H;
        setLayoutParams(new RecyclerView.LayoutParams(i3, -2));
        View findViewById6 = findViewById(R.id.f162966nl1);
        QZoneFrdHotVideoView qZoneFrdHotVideoView = (QZoneFrdHotVideoView) findViewById6;
        qZoneFrdHotVideoView.getLayoutParams().width = i3;
        qZoneFrdHotVideoView.getLayoutParams().height = I;
        qZoneFrdHotVideoView.setIsPlayFromStart(true);
        qZoneFrdHotVideoView.setPlayIconVisible(false);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<QZoneFrdHot\u2026nVisible(false)\n        }");
        this.videoView = qZoneFrdHotVideoView;
        h();
        VideoReport.setPageId(this, "pg_discover_feeds_page");
    }

    private final void f() {
        ParsedFeedData parsedFeedData;
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null && (parsedFeedData = frdHotVideoSubFeedInfo.getParsedFeedData()) != null) {
            String videoActionUrl = parsedFeedData.getVideoActionUrl();
            QLog.i("QZoneFrdHotVideoItemLayout", 1, "click video, rawActionUrl=" + videoActionUrl);
            String g16 = g(videoActionUrl);
            QLog.i("QZoneFrdHotVideoItemLayout", 1, "click video, targetActionUrl=" + g16);
            yo.d.d(g16, getContext(), null);
            QZoneFrdHotVideoDCReporter.INSTANCE.reportClick(parsedFeedData, this._position + 1, H, System.currentTimeMillis());
            QZoneFrdHotVideoDTReporter.INSTANCE.reportClick(this, parsedFeedData, get_position() + 1);
            QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedClick(parsedFeedData.getFeedId(), get_position() + 1);
            return;
        }
        QLog.i("QZoneFrdHotVideoItemLayout", 1, "click video, without curSubFeedInfo");
    }

    private final String g(String actionUrl) {
        BusinessFeedData originFeedData;
        VideoInfo videoInfo;
        PictureUrl pictureUrl;
        BusinessFeedData originFeedData2;
        QZoneFrdHotVideoView qZoneFrdHotVideoView = this.videoView;
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        String str = null;
        VideoInfo videoInfo2 = (frdHotVideoSubFeedInfo == null || (originFeedData2 = frdHotVideoSubFeedInfo.getOriginFeedData()) == null) ? null : originFeedData2.getVideoInfo();
        if (videoInfo2 == null) {
            videoInfo2 = new VideoInfo();
        }
        long Q0 = qZoneFrdHotVideoView.Q0(videoInfo2);
        QZoneFrdHotVideoView qZoneFrdHotVideoView2 = this.videoView;
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo2 = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo2 != null && (originFeedData = frdHotVideoSubFeedInfo2.getOriginFeedData()) != null && (videoInfo = originFeedData.getVideoInfo()) != null && (pictureUrl = videoInfo.coverUrl) != null) {
            str = pictureUrl.url;
        }
        String b16 = com.tencent.mobileqq.qcircle.api.utils.d.b(actionUrl, qZoneFrdHotVideoView2, Q0, str, false);
        Intrinsics.checkNotNullExpressionValue(b16, "wrapperAnimInfo(\n       \u2026Url?.url, false\n        )");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QZoneFrdHotVideoItemLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        this.startExposureTimestamp = System.currentTimeMillis();
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo != null) {
            QZoneFrdHotVideoDCReporter.INSTANCE.reportStartExposure(frdHotVideoSubFeedInfo.getParsedFeedData(), this._position + 1, H, this.startExposureTimestamp);
            QZoneFrdHotVideoDTReporter.INSTANCE.reportItemExposure(this, frdHotVideoSubFeedInfo.getParsedFeedData(), get_position() + 1);
            QZoneFrdHotVideo00064Reporter.INSTANCE.reportFeedStartExposure(frdHotVideoSubFeedInfo.getParsedFeedData().getFeedId(), get_position() + 1);
        }
    }

    private final void l() {
        if (this.startExposureTimestamp > 0) {
            FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
            if (frdHotVideoSubFeedInfo != null) {
                QZoneFrdHotVideoDCReporter.INSTANCE.reportEndExposure(frdHotVideoSubFeedInfo.getParsedFeedData(), this._position + 1, H, this.startExposureTimestamp, System.currentTimeMillis() - this.startExposureTimestamp);
            }
            this.startExposureTimestamp = 0L;
        }
    }

    public final boolean c() {
        BusinessFeedData originFeedData;
        VideoInfo videoInfo;
        ParsedFeedData parsedFeedData;
        ParsedFeedData parsedFeedData2;
        BusinessFeedData originFeedData2;
        VideoInfo videoInfo2;
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
        QLog.i("QZoneFrdHotVideoItemLayout", 1, "video can't autoPlay, feedId=" + feedId + ", title=" + title + ",playType=" + b16);
        return false;
    }

    /* renamed from: d, reason: from getter */
    public final int get_position() {
        return this._position;
    }

    /* renamed from: e, reason: from getter */
    public final QZoneFrdHotVideoView getVideoView() {
        return this.videoView;
    }

    @Override // com.qzone.reborn.feedx.itemview.friendlike.b
    /* renamed from: getSubFeedInfo, reason: from getter */
    public FrdHotVideoSubFeedInfo getCurSubFeedInfo() {
        return this.curSubFeedInfo;
    }

    public final void m(FrdHotVideoSubFeedInfo subFeedInfo, int position, int positionInQZoneFeed) {
        ColorDrawable colorDrawable;
        Intrinsics.checkNotNullParameter(subFeedInfo, "subFeedInfo");
        this._position = position;
        this.curSubFeedInfo = subFeedInfo;
        ParsedFeedData parsedFeedData = subFeedInfo.getParsedFeedData();
        this.titleView.setText(parsedFeedData.getTitle());
        User user = new User();
        user.uin = parsedFeedData.getPosterId();
        user.logo = parsedFeedData.getAvatarUrl();
        user.from = 8;
        this.avatarView.setUser(user);
        this.nickNameView.setText(parsedFeedData.getPosterName());
        this.likeCountView.setText(k(parsedFeedData.getLikeCount()));
        this.recommendReasonView.setVisibility(parsedFeedData.getClipedRecommendReason().length() > 0 ? 0 : 8);
        this.recommendReasonView.setText(parsedFeedData.getClipedRecommendReason());
        ImageView p06 = this.videoView.p0();
        p06.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            colorDrawable = new ColorDrawable(Color.parseColor("#2B2B2B"));
        } else {
            colorDrawable = new ColorDrawable(Color.parseColor("#F5F5F5"));
        }
        p06.setImageDrawable(colorDrawable);
        this.videoView.q1(subFeedInfo, position, positionInQZoneFeed);
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onAttachToRecyclerView() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onAttachToRecyclerView(this);
        j();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onDetachFromRecyclerView() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onDetachFromRecyclerView(this);
        l();
        this.videoView.a();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onParentRecycled() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onParentRecycled(this);
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onPause() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onPause(this);
        if (this.videoView.isPlaying()) {
            this.videoView.pause();
        }
        l();
    }

    @Override // com.qzone.module.feedcomponent.ui.QZoneFrdHotVideoLifeCycle
    public void onResume() {
        QZoneFrdHotVideoLifeCycle.DefaultImpls.onResume(this);
        j();
    }

    private final void h() {
        View findViewById = findViewById(R.id.mzl);
        findViewById.getLayoutParams().height = J;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.itemview.friendlike.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFrdHotVideoItemLayout.i(QZoneFrdHotVideoItemLayout.this, view);
            }
        });
    }

    private final String k(int likeCount) {
        if (likeCount < 10000) {
            return String.valueOf(likeCount);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(likeCount / 10000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format + "w";
    }
}
