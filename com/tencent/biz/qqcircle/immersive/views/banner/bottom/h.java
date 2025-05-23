package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.al;
import com.tencent.biz.qqcircle.immersive.feed.event.ap;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleMarqueeTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView;
import com.tencent.biz.qqcircle.widgets.QFSImageSpanAndTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.NumberUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends c implements View.OnClickListener, QFSImageSpanAndTextView.a, SimpleEventReceiver {
    private static final int Y = cx.a(14.0f);
    private static final int Z = cx.a(12.0f);

    /* renamed from: a0, reason: collision with root package name */
    private static final int f90688a0 = cx.a(4.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f90689b0 = cx.a(8.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final float f90690c0 = QCircleApplication.getAPP().getResources().getDimension(R.dimen.f159402d23);

    /* renamed from: d0, reason: collision with root package name */
    private static final int f90691d0 = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.f159401d22);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f90692e0 = R.drawable.qui_like_text_allwhite_tertiary;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f90693f0 = R.drawable.ntk;
    private QFSGestureDetectorView D;
    private View E;
    private View F;
    private HorizontalScrollView G;
    private View H;
    private QFSImageSpanAndTextView I;
    private View J;
    private QCircleRoundImageView K;
    private LottieAnimationView L;
    private QCircleMarqueeTextView M;
    private FeedCloudMeta$StComment N;
    private String P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    private int W;
    private int X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f90695d;

        b(boolean z16) {
            this.f90695d = z16;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (h.this.N == null) {
                QLog.e("QFSFeedBottomReplayBanner", 1, "[setLastImageSpanClickListener] mFirstCommentContent is null");
                return;
            }
            if (fb0.a.a("QFSFeedBottomReplayBanner")) {
                return;
            }
            h hVar = h.this;
            hVar.V(hVar.N, this.f90695d);
            if (!this.f90695d) {
                h.this.G("dt_clck", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "like");
            h.this.G(QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, hashMap);
        }
    }

    public h(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.V = NumberUtil.stringToInt("15");
        this.W = 0;
        this.X = 0;
        e0();
    }

    private void C() {
        int i3;
        int i16;
        int i17 = 1;
        if (this.I != null && this.H != null && this.S) {
            View view = this.E;
            if (view != null) {
                i3 = view.getWidth();
            } else {
                i3 = 0;
            }
            if (QFSCommentHelper.L().y()) {
                this.I.setMaxLines(1);
            } else {
                QFSImageSpanAndTextView qFSImageSpanAndTextView = this.I;
                if (!this.R) {
                    i17 = 2;
                }
                qFSImageSpanAndTextView.setMaxLines(i17);
            }
            if (i3 > 0) {
                QFSImageSpanAndTextView qFSImageSpanAndTextView2 = this.I;
                if (this.R) {
                    i16 = (int) (i3 * 0.73f);
                } else {
                    i16 = i3;
                }
                qFSImageSpanAndTextView2.setMaxWidth(i16 - ((int) (f90690c0 * 2.0f)));
                this.I.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.I.setMaxWidth(Integer.MAX_VALUE);
            }
            if (this.H.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
                if (this.R || i3 <= 0) {
                    i3 = -2;
                }
                layoutParams.width = i3;
                this.H.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        QLog.e(m(), 1, "[adjustFirstCommentViewSize] first comment view is null, direct return!");
    }

    private void D() {
        int i3;
        View view = this.J;
        if (view != null && this.R && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.J.getLayoutParams();
            if (this.S) {
                i3 = f90691d0;
            } else {
                i3 = 0;
            }
            layoutParams.leftMargin = i3;
            this.J.setLayoutParams(layoutParams);
        }
    }

    private QFSCommentInfo E(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        String str;
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.f90601d;
        qFSCommentInfo.mFeed = this.f90602e;
        qFSCommentInfo.mReportBean = p();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo k3 = k();
        if (k3 == null) {
            k3 = new QCircleExtraTypeInfo();
        }
        qFSCommentInfo.mExtraTypeInfo = k3;
        k3.mDataPosition = this.f90603f;
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        qFSCommentInfo.mActionBean = actionBean;
        actionBean.mIsNeedShowTopAnim = true;
        qFSCommentInfo.mActionBean.mCommentInitBeanActionBean = new QCircleInitBean.QCircleActionBean();
        if (feedCloudMeta$StComment != null) {
            str = feedCloudMeta$StComment.f398447id.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            qFSCommentInfo.mCommentId = str;
            qFSCommentInfo.mHotCommentId = str;
            qFSCommentInfo.mActionBean.mCommentInitBeanActionBean.mItemTopAnimationCommentId = str;
        }
        return qFSCommentInfo;
    }

    private void F() {
        PBStringField pBStringField;
        boolean z16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null && !TextUtils.isEmpty(pBStringField.get())) {
            if (jy2.g.z(this.f90602e)) {
                QLog.d(m(), 4, "checkShowReplayBannerImmediately, fake feed do nothing.");
                return;
            }
            if (p() != null) {
                z16 = QFSPublicAccountStaggeredItemCommentHelper.f86870a.g(this.f90603f, this.f90602e, p().getDtPageId());
            } else {
                z16 = false;
            }
            QLog.d(m(), 4, "checkShowReplayBannerImmediately, show:" + z16);
            if (z16) {
                Y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, @Nullable Map<String, Object> map) {
        if (this.H != null && this.S) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (map != null) {
                buildElementParams.putAll(map);
            }
            FeedCloudMeta$StComment feedCloudMeta$StComment = this.N;
            if (feedCloudMeta$StComment != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StComment.f398447id.get());
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed != null) {
                buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
            }
            VideoReport.setElementId(this.H, QCircleDaTongConstant.ElementId.EM_XSJ_FIERYCOMMENT_BAR);
            VideoReport.setElementExposePolicy(this.H, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.H, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent(str, this.H, buildElementParams);
        }
    }

    private SpannableStringBuilder H(int i3, String str) {
        boolean z16;
        Drawable drawable;
        Paint L = L();
        int measureText = (int) L.measureText(str);
        int i16 = f90689b0;
        int i17 = Y;
        int i18 = i16 + i17 + f90688a0 + measureText;
        this.X = i18;
        int max = Math.max(i17, Z);
        Bitmap createBitmap = Bitmap.createBitmap(i18, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint.FontMetrics fontMetrics = L.getFontMetrics();
        canvas.drawText(str, i16 + i17 + r5, (max / 2) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), L);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            drawable = j().getDrawable(f90692e0);
        } else {
            drawable = j().getDrawable(f90693f0);
        }
        drawable.setBounds(new Rect(i16, 0, i16 + i17, i17));
        drawable.mutate();
        if (z16) {
            drawable.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(j(), R.color.qui_common_text_allwhite_tertiary), PorterDuff.Mode.SRC_IN));
        }
        drawable.draw(canvas);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        bitmapDrawable.setBounds(new Rect(0, 0, i18, max));
        spannableStringBuilder.setSpan(new nb0.d(bitmapDrawable), 0, 1, 33);
        if (QFSCommentHelper.L().y()) {
            spannableStringBuilder.setSpan(new b(z16), 0, 1, 33);
        }
        return spannableStringBuilder;
    }

    private FeedCloudMeta$StComment I(List<FeedCloudMeta$StComment> list) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (!TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                    if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4)) {
                        break;
                    }
                    if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 16)) {
                        return feedCloudMeta$StComment;
                    }
                }
            }
        }
        return null;
    }

    private SpannableStringBuilder J() {
        int i3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        if (QFSCommentHelper.L().y()) {
            i3 = R.drawable.oo5;
        } else {
            i3 = R.drawable.f162055oq0;
        }
        Drawable drawable = j().getDrawable(i3);
        drawable.setBounds(new Rect(0, 0, cx.a(30.0f), cx.a(16.0f)));
        this.W = drawable.getIntrinsicWidth();
        spannableStringBuilder.setSpan(new nb0.d(drawable), 0, 1, 33);
        return spannableStringBuilder;
    }

    private SpannableStringBuilder K(int i3) {
        String string = j().getResources().getString(R.string.f1903241s, Integer.valueOf(i3));
        Paint L = L();
        int measureText = (int) L.measureText(string);
        int i16 = f90689b0;
        int i17 = f90688a0;
        int i18 = Y;
        int i19 = i16 + measureText + i17 + i18;
        this.X = i19;
        int max = Math.max(i18, Z);
        Bitmap createBitmap = Bitmap.createBitmap(i19, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint.FontMetrics fontMetrics = L.getFontMetrics();
        canvas.drawText(string, i16, (max / 2) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), L);
        Drawable drawable = j().getDrawable(R.drawable.qui_chevron_right_text_allwhite_tertiary);
        int i26 = i16 + measureText + i17;
        drawable.setBounds(new Rect(i26, 0, i26 + i18, i18));
        drawable.mutate();
        drawable.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(j(), R.color.qui_common_text_allwhite_tertiary), PorterDuff.Mode.SRC_IN));
        drawable.draw(canvas);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        bitmapDrawable.setBounds(new Rect(0, 0, i19, max));
        spannableStringBuilder.setSpan(new nb0.d(bitmapDrawable), 0, 1, 33);
        return spannableStringBuilder;
    }

    private Paint L() {
        Paint paint = new Paint();
        paint.setColor(j().getResources().getColor(R.color.qui_common_text_allwhite_tertiary));
        paint.setTextSize(Z);
        return paint;
    }

    private void M(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        if (this.N != null && QFSCommentHelper.L().y()) {
            if (qCircleCommentPraiseUpdateEvent.mType == 1 && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mFeedId, this.f90602e.f398449id.get()) && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, this.N.f398447id.get())) {
                this.N.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                this.N.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                a0();
                return;
            }
            return;
        }
        QLog.e("QFSFeedBottomReplayBanner", 1, "[handlePraiseUpdateEvent] mFirstCommentContent is null or not exp");
    }

    private void N() {
        int i3 = this.U + 1;
        this.U = i3;
        if (i3 != 1) {
            return;
        }
        Y();
    }

    private void O() {
        ViewStub viewStub;
        View view = this.F;
        if (view == null) {
            QLog.e(m(), 1, "[inflateFirstCommentView] mLayout is null");
            return;
        }
        if (!this.S || (viewStub = (ViewStub) view.findViewById(R.id.f519829k)) == null) {
            return;
        }
        QLog.d(m(), 1, "[inflateFirstCommentView] viewStub inflate, hashCode:" + hashCode());
        View inflate = viewStub.inflate();
        this.H = inflate;
        inflate.setOnClickListener(this);
        QFSImageSpanAndTextView qFSImageSpanAndTextView = (QFSImageSpanAndTextView) this.H.findViewById(R.id.f40321e2);
        this.I = qFSImageSpanAndTextView;
        qFSImageSpanAndTextView.setSpecialClickAreaColor(R.color.f158017al3);
        this.I.setNeedSpecialAreaBold(true);
        this.I.showEllipseEndImageSpan(true);
        this.I.setOnClickListener(this);
        this.I.setImageSpanWidthDelegate(this);
        this.H.setVisibility(8);
    }

    private void P() {
        ViewStub viewStub;
        View view = this.F;
        if (view == null) {
            QLog.e(m(), 1, "[inflateMusicBarView] mLayout is null");
            return;
        }
        if (!this.R || (viewStub = (ViewStub) view.findViewById(R.id.f39991d6)) == null) {
            return;
        }
        QLog.d(m(), 1, "[inflateMusicBarView] viewStub inflate, hashCode:" + hashCode());
        LottieCompositionFactory.fromUrl(j(), "https://qq-video.cdn-go.cn/android/latest/defaultmode/9075/paitongkuan/qvideo_feed_icon_animation_musicwave.json");
        View inflate = viewStub.inflate();
        this.J = inflate;
        inflate.setOnClickListener(this);
        QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) this.J.findViewById(R.id.f39961d3);
        this.K = qCircleRoundImageView;
        qCircleRoundImageView.setRoundRect(cx.a(4.0f));
        this.M = (QCircleMarqueeTextView) this.J.findViewById(R.id.f39981d5);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.J.findViewById(R.id.f39971d4);
        this.L = lottieAnimationView;
        lottieAnimationView.setAnimationFromUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/9075/paitongkuan/qvideo_feed_icon_animation_musicwave.json");
        this.L.setRepeatCount(-1);
        this.J.setVisibility(8);
    }

    private void Q(View view) {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        String str;
        if (view == null) {
            QLog.e(m(), 1, "[jumpMusicPage] clickView is null");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StFeedMusic = feedCloudMeta$StFeed.musicInfo) != null) {
            PBInt32Field pBInt32Field = feedCloudMeta$StFeedMusic.status;
            if (pBInt32Field != null && pBInt32Field.get() == 1) {
                QCircleToast.u(view.getContext().getString(R.string.f183963kl), 0, true);
                return;
            }
            FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic2 = this.f90602e.musicInfo.get();
            QFSFlowAggregationInitBean qFSFlowAggregationInitBean = new QFSFlowAggregationInitBean();
            qFSFlowAggregationInitBean.setFeedMusic(feedCloudMeta$StFeedMusic2);
            qFSFlowAggregationInitBean.setAggregationType(43);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("xsj_feed_id", this.f90602e.f398449id.get());
            if (feedCloudMeta$StFeedMusic2 == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeedMusic2.MID.get();
            }
            hashMap.put("music", str);
            qFSFlowAggregationInitBean.setSchemeAttrs(hashMap);
            com.tencent.biz.qqcircle.launcher.c.H(view.getContext(), qFSFlowAggregationInitBean);
            return;
        }
        QLog.e(m(), 1, "[jumpMusicPage] musicInfo is null");
    }

    private void R() {
        ViewStub viewStub = (ViewStub) this.f90604h.findViewById(R.id.f40011d8);
        if (viewStub != null) {
            QLog.d(m(), 1, "[makeSureInflate] inflate banner layout");
            this.E = this.f90604h.findViewById(R.id.f513327t);
            this.D = (QFSGestureDetectorView) this.f90604h.findViewById(R.id.f45131r2);
            View inflate = viewStub.inflate();
            this.F = inflate;
            if (inflate != null) {
                this.G = (HorizontalScrollView) inflate.findViewById(R.id.f40311e1);
                this.F.setVisibility(8);
            }
        }
        O();
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        if (this.J != null && this.R) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (feedCloudMeta$StFeed != null) {
                FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
                if (feedCloudMeta$StUser != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
                }
                buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.LOOP_PLAY);
                FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = feedCloudMeta$StFeed.musicInfo;
                if (feedCloudMeta$StFeedMusic != null) {
                    String str2 = feedCloudMeta$StFeedMusic.MID.get();
                    buildElementParams.put("xsj_music_id", str2);
                    buildElementParams.put("xsj_music_name", feedCloudMeta$StFeed.musicInfo.musicName.get());
                    com.tencent.biz.qqcircle.wink.e.f93946a.d(str2, "dt_imp".equals(str));
                }
            }
            VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_MUSIC_BAR);
            VideoReport.setElementExposePolicy(this.J, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.J, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent(str, this.J, buildElementParams);
        }
    }

    private boolean T() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null || QFSBaseCommentPresenter.l(feedCloudMeta$StFeed)) {
            return false;
        }
        if (TextUtils.equals(p().getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE)) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "[canShowFirstComment] is layer page, return");
            return false;
        }
        if (this.N != null) {
            return true;
        }
        QLog.e("QFSFeedBottomReplayBanner", 1, "[canShowFirstComment] mFirstCommentContent is null, return");
        return false;
    }

    private boolean U() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        PBRepeatField<Integer> pBRepeatField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StFeedMusic = feedCloudMeta$StFeed.musicInfo) != null && (pBRepeatField = feedCloudMeta$StFeedMusic.show_mask) != null && pBRepeatField.get().contains(3) && !((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_fabuqi_feedyinyuefengmianchangzhu")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(FeedCloudMeta$StComment feedCloudMeta$StComment, boolean z16) {
        if (o() == null) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "[openCommentPanel] getQFSFeedIoc is null");
            return;
        }
        QFSCommentInfo E = E(feedCloudMeta$StComment);
        E.mActionBean.mNeedDoCommentPraise = z16;
        o().onHandlerMessage("event_open_comment", E);
    }

    private void W() {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.E, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(240L);
        arrayList.add(ofFloat);
        if (this.S) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.H, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat2.setDuration(320L);
            arrayList.add(ofFloat2);
        }
        if (this.R) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.J, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat3.setDuration(320L);
            arrayList.add(ofFloat3);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(240L);
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void X() {
        QLog.d("QFSFeedBottomReplayBanner", 1, "[reset]");
        Z(false);
        this.U = 0;
        this.S = false;
        this.R = false;
        this.Q = false;
    }

    private void Y() {
        this.S = T();
        this.R = U();
        boolean z16 = true;
        QLog.d(m(), 1, "[tryActivateReplayBanner] needShowFirstComment:" + this.S + ", needShowMusicBar:" + this.R);
        if (!this.S && !this.R) {
            z16 = false;
        }
        this.Q = z16;
        if (z16) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z16) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        float f16;
        HorizontalScrollView horizontalScrollView;
        int i3;
        View view = this.F;
        int i16 = 8;
        if (view != null) {
            QFSGestureDetectorView qFSGestureDetectorView = this.D;
            if (qFSGestureDetectorView != null) {
                if (z16 && this.S && this.R) {
                    qFSGestureDetectorView.h(view);
                } else {
                    qFSGestureDetectorView.A(view);
                }
            }
            View view2 = this.F;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        if (z16 && (horizontalScrollView = this.G) != null) {
            horizontalScrollView.scrollTo(0, 0);
        }
        b0(z16);
        c0(z16);
        View view3 = this.E;
        if (view3 != null) {
            if (!z16) {
                i16 = 0;
            }
            view3.setVisibility(i16);
            View view4 = this.E;
            if (z16) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            view4.setAlpha(f16);
        }
        if (z16 && (feedCloudMeta$StFeed = this.f90602e) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = "";
        }
        this.P = str;
    }

    private void a0() {
        if (this.I == null) {
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.N;
        if (feedCloudMeta$StComment != null && !TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) J()).append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) this.N.content.get());
            int i3 = this.N.replyCount.get();
            int i16 = this.N.likeInfo.count.get();
            int i17 = this.N.likeInfo.status.get();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            this.X = 0;
            if (i16 != 0 && i16 >= this.V) {
                spannableStringBuilder2.append((CharSequence) H(i17, com.tencent.biz.qqcircle.immersive.utils.r.f(i16)));
            } else if (i3 != 0) {
                spannableStringBuilder2.append((CharSequence) K(i3));
            }
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            spannableStringBuilder3.append((CharSequence) spannableStringBuilder).append((CharSequence) spannableStringBuilder2);
            this.I.setText(spannableStringBuilder3);
            C();
            return;
        }
        QLog.e("QFSFeedBottomReplayBanner", 1, "[updateFirstCommentView] mFirstCommentContent is null");
    }

    private void b0(boolean z16) {
        int i3;
        float f16;
        View view = this.H;
        if (view == null) {
            return;
        }
        if (z16 && this.S) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.H;
        if (z16 && this.S) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        view2.setAlpha(f16);
    }

    private void c0(boolean z16) {
        View view = this.J;
        if (view != null && this.M != null && this.L != null) {
            if (z16 && this.R) {
                view.setVisibility(0);
                this.J.setAlpha(1.0f);
                this.M.e();
                this.L.playAnimation();
                return;
            }
            view.setVisibility(8);
            this.J.setAlpha(0.0f);
            this.M.f();
            this.L.pauseAnimation();
        }
    }

    private void d0() {
        String str;
        String str2;
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        PBStringField pBStringField;
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic2;
        PBStringField pBStringField2;
        if (this.M != null && this.K != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            String str3 = "";
            if (feedCloudMeta$StFeed == null || (feedCloudMeta$StFeedMusic2 = feedCloudMeta$StFeed.musicInfo) == null || (pBStringField2 = feedCloudMeta$StFeedMusic2.musicName) == null || TextUtils.isEmpty(pBStringField2.get())) {
                str = "";
            } else {
                str = this.f90602e.musicInfo.musicName.get();
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e(m(), 1, "[updateMusicInfo] musicName is null");
            }
            this.M.setText(str);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f90602e;
            if (feedCloudMeta$StFeed2 == null || (feedCloudMeta$StFeedMusic = feedCloudMeta$StFeed2.musicInfo) == null || (feedCloudMeta$StImage = feedCloudMeta$StFeedMusic.cover) == null || (pBStringField = feedCloudMeta$StImage.picUrl) == null) {
                str2 = "";
            } else {
                str2 = pBStringField.get();
            }
            if (TextUtils.isEmpty(str2)) {
                QLog.e(m(), 1, "[updateMusicInfo] music cover url is null");
            }
            if (QLog.isDevelopLevel()) {
                String m3 = m();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[updateMusicInfo] needShowMusicBar:");
                sb5.append(U());
                sb5.append(", musicName:");
                sb5.append(str);
                sb5.append(", feedId:");
                FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.f90602e;
                if (feedCloudMeta$StFeed3 != null) {
                    str3 = feedCloudMeta$StFeed3.f398449id.get();
                }
                sb5.append(str3);
                sb5.append(", musicCoverUrl:");
                sb5.append(str2);
                QLog.d(m3, 1, sb5.toString());
            }
            Option requestHeight = Option.obtain().setUrl(str2).setTargetView(this.K).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(this.K.getWidth()).setRequestHeight(this.K.getHeight());
            requestHeight.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(requestHeight);
            D();
            return;
        }
        QLog.e(m(), 1, "[updateMusicInfo] music view is null");
    }

    private void e0() {
        HashMap hashMap = new HashMap();
        hashMap.put("like_min_count", "15");
        this.V = NumberUtil.stringToInt(uq3.o.M("qqcircle_feed_first_comment", hashMap).get("like_min_count"));
        QLog.d("QFSFeedBottomReplayBanner", 4, "[updateUnitedConfig] mShowLikeMinCount =" + this.V);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSImageSpanAndTextView.a
    public int c() {
        return this.X;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSImageSpanAndTextView.a
    public int d() {
        return this.W;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (hVar instanceof al) {
            N();
        } else if (hVar instanceof ap) {
            this.T = ((ap) hVar).b();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void g() {
        super.g();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        this.N = I(this.f90602e.vecComment.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void i() {
        super.i();
        F();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public String m() {
        return "QFSFeedBottomReplayBanner";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f40331e3 && id5 != R.id.f40321e2) {
            if (id5 == R.id.f39951d2) {
                Q(view);
                S("dt_clck");
            }
        } else if (this.N == null) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "[onClick] mFirstCommentContent is null");
        } else if (!fb0.a.a("QFSFeedBottomReplayBanner")) {
            V(this.N, false);
            G("dt_clck", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        String str;
        PBStringField pBStringField;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onElementActivated] feedId:");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = "null";
        }
        sb5.append(str);
        QLog.d("QFSFeedBottomReplayBanner", 1, sb5.toString());
        R();
        a0();
        d0();
        W();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        String str;
        PBStringField pBStringField;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onElementInactivated] feedId:");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = "null";
        }
        sb5.append(str);
        QLog.d("QFSFeedBottomReplayBanner", 1, sb5.toString());
        X();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            M((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = "null";
        }
        QLog.d(m(), 1, "[onAttached] feedId:" + str + ", curShowBannerFeedId:" + this.P);
        if (!TextUtils.equals(str, this.P)) {
            X();
        } else {
            QLog.e(m(), 1, "[onAttached] feedId equals, not need reset");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "animatorSet onAnimationCancel");
            h.this.Z(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "animatorSet onAnimationEnd");
            h.this.Z(true);
            h.this.G("dt_imp", null);
            h.this.S("dt_imp");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.e("QFSFeedBottomReplayBanner", 1, "animatorSet onAnimationStart");
            if (h.this.R && h.this.J != null) {
                h.this.J.setVisibility(0);
            }
            if (h.this.S && h.this.H != null) {
                h.this.H.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
