package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAdSpaceDispatchTouchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAdSpaceDisplayedEvent;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAdItemView;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSTextEllipseImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import e40.p;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class cw extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    protected FeedCloudMeta$StFeed J;
    private GdtAd K;
    private View N;
    private View P;
    private View Q;
    private View R;
    private TextView S;
    private View T;
    private QFSTextEllipseImageView U;
    private TextView V;
    private View W;

    /* renamed from: f0, reason: collision with root package name */
    private ViewOutlineProvider f85587f0;
    private boolean I = false;
    private boolean L = true;
    private boolean M = false;
    private float X = 0.0f;
    private float Y = 0.0f;
    private float Z = 0.0f;

    /* renamed from: a0, reason: collision with root package name */
    private float f85582a0 = 0.0f;

    /* renamed from: b0, reason: collision with root package name */
    private float f85583b0 = 0.0f;

    /* renamed from: c0, reason: collision with root package name */
    private float f85584c0 = 0.0f;

    /* renamed from: d0, reason: collision with root package name */
    private float f85585d0 = 0.0f;

    /* renamed from: e0, reason: collision with root package name */
    private float f85586e0 = 0.0f;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f85588g0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f85589a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f85590b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f85591c;

        a(long j3, String str, float f16) {
            this.f85589a = j3;
            this.f85590b = str;
            this.f85591c = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (view == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius][getOutline] error, view is null, aid:" + this.f85589a + " traceId:" + this.f85590b);
                return;
            }
            if (view.getWidth() >= 0 && view.getHeight() >= 0) {
                if (outline == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius][getOutline] error, outline is null, aid:" + this.f85589a + " traceId:" + this.f85590b);
                    return;
                }
                QLog.i("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius][getOutline] aid:" + this.f85589a + " traceId:" + this.f85590b + " width:" + view.getWidth() + " height:" + view.getHeight() + " radius:" + this.f85591c);
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f85591c);
                return;
            }
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius][getOutline] error, aid:" + this.f85589a + " traceId:" + this.f85590b + "width:" + view.getWidth() + " height:" + view.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85596d;

        d(View view) {
            this.f85596d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            long j3;
            String str;
            if (cw.this.K != null) {
                j3 = cw.this.K.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (cw.this.K != null) {
                str = cw.this.K.getTraceId();
            } else {
                str = null;
            }
            if (valueAnimator == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createSpaceItemViewAnimatorUpdateListener][onAnimationUpdate] error, animation is null, aid:" + j3 + " traceId:" + str);
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createSpaceItemViewAnimatorUpdateListener][onAnimationUpdate] error, animatedValue not instanceof Float, aid:" + j3 + " traceId:" + str);
                return;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            View view = this.f85596d;
            if (view == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createSpaceItemViewAnimatorUpdateListener][onAnimationUpdate] error, view is null, aid:" + j3 + " traceId:" + str);
                return;
            }
            view.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85598d;

        e(String str) {
            this.f85598d = str;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            long j3;
            String str;
            Bitmap bitmap;
            super.onStateChange(loadState, option);
            if (cw.this.K != null) {
                j3 = cw.this.K.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            String str2 = null;
            if (cw.this.K != null) {
                str = cw.this.K.getTraceId();
            } else {
                str = null;
            }
            if (loadState != null && loadState.isFinishSuccess() && option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            if (option != null) {
                str2 = option.getUrl();
            }
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] aid:" + j3 + " traceId:" + str + " state:" + loadState + " url:" + str2 + " ");
            if (loadState == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] error, state is null");
                return;
            }
            if (!loadState.isFinishSuccess()) {
                return;
            }
            if (bitmap == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] error, bitmap is null");
                return;
            }
            if (TextUtils.equals(str2, this.f85598d)) {
                Context m06 = cw.this.m0();
                if (m06 == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] error, context is null");
                    return;
                }
                Resources resources = m06.getResources();
                if (resources == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] error, resources is null");
                    return;
                }
                if (cw.this.M) {
                    QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] do nothing, mSpaceDisplayed:" + cw.this.M);
                    return;
                }
                if (cw.this.R == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createBackgroundPicStateListener][onStateChange] error, mSpaceView is null");
                    return;
                } else {
                    cw.this.R.setBackground(new BitmapDrawable(resources, bitmap));
                    return;
                }
            }
            QLog.i("QFSFeedChildAdSpacePresenter", 2, "[createBackgroundPicStateListener][onStateChange] error, is not the same url");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GdtAd f85600d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f85601e;

        f(GdtAd gdtAd, int i3) {
            this.f85600d = gdtAd;
            this.f85601e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f85600d == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createOnClickListener][onClick] error, ad is null, areaId:" + this.f85601e);
            } else if (view == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createOnClickListener][onClick] error, v is null, aid:" + this.f85600d.getAId() + " traceId:" + this.f85600d.getTraceId() + " areaId:" + this.f85601e);
            } else {
                QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createOnClickListener][onClick] aid:" + this.f85600d.getAId() + " traceId:" + this.f85600d.getTraceId() + " areaId:" + this.f85601e);
                com.tencent.biz.qqcircle.immersive.utils.j.f90213a.L(this.f85600d, view, ((QFSBaseFeedChildPresenter) cw.this).f85018i, cw.this.r(), this.f85601e, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GdtAd f85603d;

        g(GdtAd gdtAd) {
            this.f85603d = gdtAd;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long j3;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtAd gdtAd = this.f85603d;
            if (gdtAd != null) {
                j3 = gdtAd.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            GdtAd gdtAd2 = this.f85603d;
            if (gdtAd2 != null) {
                str = gdtAd2.getTraceId();
            } else {
                str = null;
            }
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createTipsOnClickListener][onClick] do nothing, aid:" + j3 + " traceId:" + str + " ");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h implements QCircleAsyncTextView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GdtAd f85605a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f85606b;

        h(GdtAd gdtAd, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f85605a = gdtAd;
            this.f85606b = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
        public void onClick() {
            long j3;
            String str;
            GdtAd gdtAd = this.f85605a;
            if (gdtAd != null) {
                j3 = gdtAd.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            GdtAd gdtAd2 = this.f85605a;
            if (gdtAd2 != null) {
                str = gdtAd2.getTraceId();
            } else {
                str = null;
            }
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createFeedbackOnClickBoldTextListener][onClick]aid:" + j3 + " traceId:" + str + " ");
            x.e(((QFSBaseFeedChildPresenter) cw.this).C, this.f85605a, this.f85606b, ae.c(cw.this.r0(), null, this.f85605a, ((QFSBaseFeedChildPresenter) cw.this).f85018i), cw.this.r());
        }
    }

    private int A1() {
        long j3;
        String str;
        int i3;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd3 = this.K;
        if (gdtAd3 != null) {
            i3 = gdtAd3.getInnerShowType();
        } else {
            i3 = 0;
        }
        if (i3 == 3) {
            return ViewUtils.dpToPx(48.0f);
        }
        if (i3 == 4) {
            return ViewUtils.dpToPx(28.0f);
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[getButtonTopMargin] error, aid:" + j3 + " traceId:" + str + " innerAdShowType:" + i3);
        return 0;
    }

    private int B1() {
        long j3;
        String str;
        int i3;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd3 = this.K;
        if (gdtAd3 != null) {
            i3 = gdtAd3.getInnerShowType();
        } else {
            i3 = 0;
        }
        if (i3 == 3) {
            return ViewUtils.dpToPx(38.0f);
        }
        if (i3 == 4) {
            return ViewUtils.dpToPx(24.0f);
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[getTextTopMargin] error, aid:" + j3 + " traceId:" + str + " innerAdShowType:" + i3);
        return 0;
    }

    private int C1() {
        long j3;
        String str;
        int i3;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd3 = this.K;
        if (gdtAd3 != null) {
            i3 = gdtAd3.getInnerShowType();
        } else {
            i3 = 0;
        }
        if (i3 == 3) {
            return ViewUtils.dpToPx(28.0f);
        }
        if (i3 == 4) {
            return ViewUtils.dpToPx(12.0f);
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[getVideoLayoutTopMargin] error, aid:" + j3 + " traceId:" + str + " innerAdShowType:" + i3);
        return 0;
    }

    private void D1(QFSAdSpaceDispatchTouchEvent qFSAdSpaceDispatchTouchEvent) {
        long j3;
        String str;
        boolean z16;
        GdtAd gdtAd = this.K;
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = -2147483648L;
        }
        GdtAd gdtAd2 = this.K;
        String str2 = null;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (qFSAdSpaceDispatchTouchEvent == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[handleSpaceDispatchTouchEvent] error, event is null, aid:" + j3 + " traceId:" + str);
            return;
        }
        if (qFSAdSpaceDispatchTouchEvent.getAd() != null) {
            j16 = qFSAdSpaceDispatchTouchEvent.getAd().getAId();
        }
        if (qFSAdSpaceDispatchTouchEvent.getAd() != null) {
            str2 = qFSAdSpaceDispatchTouchEvent.getAd().getTraceId();
        }
        if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[handleSpaceDispatchTouchEvent] not the same adaid:" + j3 + " traceId:" + str + " eventAid:" + j16 + " eventTraceId:" + str2);
            return;
        }
        MotionEvent event = qFSAdSpaceDispatchTouchEvent.getEvent();
        if (event == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[handleSpaceDispatchTouchEvent] error, e is null, aid:" + j3 + " traceId:" + str);
            return;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[handleSpaceDispatchTouchEvent] aid:" + j3 + " traceId:" + str + " mSpaceDisplayed:" + this.M + " mScrollDownEnabled:" + this.L + " e:" + event);
        if ((event.getAction() == 1 || event.getAction() == 3) && this.M) {
            this.L = true;
            M1(false);
        }
    }

    private boolean E1() {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        View view = this.N;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[hideOpAreaView] error, mOpAreaView is null, aid:" + j3 + " traceId:" + str);
            return false;
        }
        if (view.getVisibility() != 0) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[hideOpAreaView] error, mOpAreaView is not VISIBLE, aid:" + j3 + " traceId:" + str);
            return false;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[hideOpAreaView] aid:" + j3 + " traceId:" + str);
        this.N.setVisibility(4);
        return true;
    }

    private boolean F1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, GdtAd gdtAd) {
        if (gdtAd == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView] error, ad is null");
            return false;
        }
        View view = this.R;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView] error, mSpaceView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        QFSTextEllipseImageView qFSTextEllipseImageView = (QFSTextEllipseImageView) view.findViewById(R.id.f38821a0);
        this.U = qFSTextEllipseImageView;
        if (qFSTextEllipseImageView == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView] error, mSpaceTextView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        qFSTextEllipseImageView.setVisibility(8);
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView]");
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(R.drawable.mhs);
        if (drawable == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView] error, feedbackDrawable is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        drawable.setBounds(0, 0, ViewUtils.dpToPx(38.0f), ViewUtils.dpToPx(16.0f));
        QFSTextEllipseImageView.a aVar = new QFSTextEllipseImageView.a();
        aVar.f93451a = gdtAd.getText();
        aVar.f93452b = R.color.f158017al3;
        aVar.f93453c = false;
        aVar.f93454d = drawable;
        aVar.f93455e = u1(feedCloudMeta$StFeed, gdtAd);
        if (this.U.j(aVar)) {
            return true;
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initSpaceTextView] error, setTextEllipseEndImage failed, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
        return false;
    }

    private boolean G1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, GdtAd gdtAd) {
        if (gdtAd == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, ad is null");
            return false;
        }
        View view = this.C;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mRootView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        View findViewById = view.findViewById(R.id.f41541hc);
        this.P = findViewById;
        if (findViewById == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mVideoLayout is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        View findViewById2 = this.C.findViewById(R.id.f74163vi);
        this.Q = findViewById2;
        if (findViewById2 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mVideoView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        View findViewById3 = this.C.findViewById(R.id.f40881fk);
        this.N = findViewById3;
        if (findViewById3 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mOpAreaView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f38861a4);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId(), th5);
            }
        }
        View findViewById4 = this.C.findViewById(R.id.f38851a3);
        this.R = findViewById4;
        if (findViewById4 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mSpaceView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        findViewById4.setVisibility(8);
        this.R.setBackgroundResource(R.drawable.f161573ke0);
        int width = this.R.getWidth();
        int height = this.R.getHeight();
        if (!TextUtils.isEmpty(gdtAd.getSpaceBackgroundImageUrl())) {
            Option url = Option.obtain().setUrl(gdtAd.getSpaceBackgroundImageUrl());
            if (width > 0 && height > 0) {
                url = url.setRequestWidth(width).setRequestHeight(height);
            }
            QCircleFeedPicLoader.g().loadImage(url, t1(gdtAd.getSpaceBackgroundImageUrl()));
        }
        this.R.setOnClickListener(v1(gdtAd, Integer.MIN_VALUE));
        TextView textView = (TextView) this.R.findViewById(R.id.f38801_y);
        this.S = textView;
        if (textView == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mSpaceAdvertiserView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        textView.setVisibility(8);
        this.S.setText(gdtAd.getAdvertiser_corporate_image_name());
        View findViewById5 = this.R.findViewById(R.id.f38841a2);
        this.T = findViewById5;
        if (findViewById5 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mSpaceVideoMaskView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        if (!F1(feedCloudMeta$StFeed, gdtAd)) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, initSpaceTextView failed, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        TextView textView2 = (TextView) this.R.findViewById(R.id.f38811_z);
        this.V = textView2;
        if (textView2 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mSpaceButtonView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        textView2.setVisibility(8);
        this.V.setText(gdtAd.getMotiveButtonText());
        View findViewById6 = this.R.findViewById(R.id.f38831a1);
        this.W = findViewById6;
        if (findViewById6 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[initView] error, mSpaceTipsView is null, aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId());
            return false;
        }
        findViewById6.setVisibility(8);
        this.W.setOnClickListener(y1(gdtAd));
        QLog.i("QFSFeedChildAdSpacePresenter", 2, "[initView] aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId() + " backgroundWidth:" + width + " backgroundHeight:" + height + " backgroundUrl:" + gdtAd.getSpaceBackgroundImageUrl());
        return true;
    }

    private void I1(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[reportToDcExport5507] extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setPageId(y0()).setExt10(ua0.c.f(m0())).setfpageid(Integer.valueOf(t0()).intValue()).setFirstFeedId(w20.a.j().h());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void J1() {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[reset] aid: " + j3 + " traceId:" + str);
        this.I = false;
        this.K = null;
        this.J = null;
        this.L = true;
        M1(false);
        if (this.M) {
            O1();
            L1();
            K1();
            this.M = false;
        }
        this.P = null;
        this.Q = null;
        this.N = null;
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
            this.R.setBackgroundResource(R.drawable.f161573ke0);
            this.R.setOnClickListener(null);
            this.R = null;
        }
        TextView textView = this.S;
        if (textView != null) {
            textView.setVisibility(8);
            this.S.setOnClickListener(null);
            this.S = null;
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setOnClickListener(null);
            this.T = null;
        }
        QFSTextEllipseImageView qFSTextEllipseImageView = this.U;
        if (qFSTextEllipseImageView != null) {
            qFSTextEllipseImageView.setVisibility(8);
            this.U.setOnClickListener(null);
            this.U.i();
            this.U = null;
        }
        TextView textView2 = this.V;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.V.setOnClickListener(null);
            this.V = null;
        }
        View view3 = this.W;
        if (view3 != null) {
            view3.setVisibility(8);
            this.W.setOnClickListener(null);
            this.W = null;
        }
    }

    private void K1() {
        AnimatorSet animatorSet = new AnimatorSet();
        S1(animatorSet, 0L, this.Y, this.X, this.f85582a0, this.Z, this.f85584c0, this.f85583b0, this.f85586e0, this.f85585d0);
        animatorSet.start();
        this.X = 0.0f;
        this.Y = 0.0f;
        this.Z = 0.0f;
        this.f85582a0 = 0.0f;
        this.f85583b0 = 0.0f;
        this.f85584c0 = 0.0f;
        this.f85585d0 = 0.0f;
        this.f85586e0 = 0.0f;
    }

    private void L1() {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (this.Q == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[resetVideoRadius] error, mVideoView is null, aid:" + j3 + " traceId:" + str);
            return;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[resetVideoRadius] aid:" + j3 + " traceId:" + str);
        this.Q.setOutlineProvider(this.f85587f0);
        this.Q.setClipToOutline(this.f85588g0);
        this.f85587f0 = null;
        this.f85588g0 = false;
    }

    private boolean M1(boolean z16) {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (!(this.C instanceof QFSLayerFeedAdItemView)) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setRootViewShouldNotifyDispatchTouchEvent] error, aid:" + j3 + " traceId:" + str + " enable:" + z16);
            return false;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[setRootViewShouldNotifyDispatchTouchEvent] aid:" + j3 + " traceId:" + str + " enable:" + z16);
        ((QFSLayerFeedAdItemView) this.C).setShouldNotifyDispatchTouchEventForSpace(z16);
        return true;
    }

    private void N1(float f16) {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        long j16 = j3;
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        String str2 = str;
        if (this.Q == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius] error, mVideoView is null, aid:" + j16 + " traceId:" + str2);
            return;
        }
        if (f16 < 0.0f) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius] error, aid:" + j16 + " traceId:" + str2 + " radius:" + f16);
            return;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[setVideoRadius] aid:" + j16 + " traceId:" + str2 + " radius:" + f16);
        this.f85587f0 = this.Q.getOutlineProvider();
        this.f85588g0 = this.Q.getClipToOutline();
        this.Q.setOutlineProvider(new a(j16, str2, f16));
        this.Q.setClipToOutline(true);
    }

    private boolean O1() {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        View view = this.N;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showOpAreaView] error, mOpAreaView is null, aid:" + j3 + " traceId:" + str);
            return false;
        }
        if (view.getVisibility() != 4) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showOpAreaView] error, mOpAreaView is not INVISIBLE, aid:" + j3 + " traceId:" + str);
            return false;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[showOpAreaView] aid:" + j3 + " traceId:" + str);
        this.N.setVisibility(0);
        return true;
    }

    private boolean P1() {
        int i3;
        int i16;
        FeedCloudMeta$StFeed g16;
        if (this.K == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, mAd is null");
            return false;
        }
        View view = this.P;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, mVideoLayout is null, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId());
            return false;
        }
        if (this.Q == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, mVideoView is null, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId());
            return false;
        }
        if (this.R == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, mSpaceView is null, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId());
            return false;
        }
        int width = view.getWidth();
        int height = this.P.getHeight();
        if (width > 0 && height > 0) {
            int width2 = this.Q.getWidth();
            int height2 = this.Q.getHeight();
            int top = this.Q.getTop();
            int innerShowType = this.K.getInnerShowType();
            if (innerShowType == 3) {
                i3 = ((((ViewUtils.dpToPx(320.0f) * 9) / 16) + 8) / 9) * 9;
                i16 = (i3 * 16) / 9;
            } else if (innerShowType == 4) {
                i3 = ((((ViewUtils.dpToPx(198.0f) * 16) / 9) + 15) / 16) * 16;
                i16 = (i3 * 9) / 16;
            } else {
                i3 = 0;
                i16 = 0;
            }
            if (width2 > 0 && height2 > 0 && i16 > 0 && i3 > 0 && i16 <= width2 && i3 <= height2) {
                int dpToPx = ViewUtils.dpToPx(22.0f);
                int C1 = C1();
                int B1 = B1();
                int dpToPx2 = ViewUtils.dpToPx(44.0f);
                int A1 = A1();
                int dpToPx3 = ViewUtils.dpToPx(40.0f);
                int dpToPx4 = ViewUtils.dpToPx(22.0f);
                int dpToPx5 = ViewUtils.dpToPx(16.0f);
                int i17 = dpToPx + C1 + i3 + B1 + dpToPx2 + A1 + dpToPx3;
                int z16 = z1(height, i17);
                int i18 = i17 + z16;
                int i19 = height - ((i18 + dpToPx4) + dpToPx5);
                int i26 = z16 + dpToPx + C1;
                int i27 = (width2 - i16) / 2;
                this.X = 1.0f;
                float f16 = width2;
                this.Y = i16 / f16;
                this.Z = 1.0f;
                float f17 = height2;
                this.f85582a0 = i3 / f17;
                this.f85583b0 = 0.0f;
                this.f85584c0 = i27 - i27;
                this.f85585d0 = 0.0f;
                this.f85586e0 = (i26 - top) - ((height2 - i3) / 2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[showSpaceView] aid:");
                int i28 = i3;
                int i29 = i16;
                sb5.append(this.K.getAId());
                sb5.append(" traceId:");
                sb5.append(this.K.getTraceId());
                sb5.append(" videoLayoutOldWidth:");
                sb5.append(width);
                sb5.append(" videoLayoutOldHeight:");
                sb5.append(height);
                sb5.append("\nvideoViewOldWidth:");
                sb5.append(width2);
                sb5.append(" videoViewOldHeight:");
                sb5.append(height2);
                sb5.append(" videoViewOldTopMargin:");
                sb5.append(top);
                sb5.append("\nvideoViewNewWidth:");
                sb5.append(i29);
                sb5.append(" videoViewNewHeight:");
                sb5.append(i28);
                sb5.append("\nmVideoLayoutNewScareX:");
                sb5.append(this.Y);
                sb5.append(" mVideoLayoutNewScareY:");
                sb5.append(this.f85582a0);
                sb5.append("\nmVideoLayoutNewTranslationX:");
                sb5.append(this.f85584c0);
                sb5.append(" mVideoLayoutNewTranslationY:");
                sb5.append(this.f85586e0);
                sb5.append("\nvideoViewOldWidth*mVideoLayoutNewScareX:");
                sb5.append(f16 * this.Y);
                sb5.append(" videoViewOldHeight*mVideoLayoutNewScareY:");
                sb5.append(f17 * this.f85582a0);
                sb5.append("\nadvertiserTopMargin:");
                sb5.append(z16);
                sb5.append(" advertiserHeight:");
                sb5.append(dpToPx);
                sb5.append("\ntextTopMargin:");
                sb5.append(B1);
                sb5.append(" textHeight:");
                sb5.append(dpToPx2);
                sb5.append("\nvideoViewTopMargin:");
                sb5.append(C1);
                sb5.append(" videoViewNewHeight:");
                sb5.append(i28);
                sb5.append("\ntipsTopMargin:");
                sb5.append(i19);
                sb5.append(" tipsHeight:");
                sb5.append(dpToPx4);
                sb5.append(" tipsBottomMargin:");
                sb5.append(dpToPx5);
                sb5.append("\nheight:");
                sb5.append(i18 + i19 + dpToPx4 + dpToPx5);
                sb5.append("\nvideoViewTopMarginFinal:");
                sb5.append(i26);
                sb5.append(" videoViewLeftMargin:");
                sb5.append(i27);
                sb5.append(" ");
                QLog.i("QFSFeedChildAdSpacePresenter", 1, sb5.toString());
                if (z16 >= 0 && i19 >= 0 && i27 >= 0) {
                    if (!R1(i29, dpToPx, z16, i29, i28, C1, dpToPx2, B1, dpToPx3, A1, dpToPx4, i19)) {
                        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, updateSpaceViewLayout failed, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId());
                        return false;
                    }
                    if (!E1()) {
                        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, hideOpAreaView failed, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId() + " videoViewOldWidth:" + width2 + " videoViewOldHeight:" + height2);
                        return false;
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new QFSAdSpaceDisplayedEvent(this.K));
                    N1(ViewUtils.dpToPx(8.0f));
                    AnimatorSet animatorSet = new AnimatorSet();
                    S1(animatorSet, 600L, this.X, this.Y, this.Z, this.f85582a0, this.f85583b0, this.f85584c0, this.f85585d0, this.f85586e0);
                    Q1(animatorSet);
                    animatorSet.addListener(s1());
                    animatorSet.start();
                    this.R.setVisibility(0);
                    QCircleExtraTypeInfo r16 = r();
                    e30.b bVar = this.E;
                    if (bVar == null) {
                        g16 = null;
                    } else {
                        g16 = bVar.g();
                    }
                    I1(700, 1, r16, g16);
                    return true;
                }
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, invalid params, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId());
                return false;
            }
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId() + " videoViewOldWidth:" + width2 + " videoViewOldHeight:" + height2 + " videoViewNewWidth:" + i16 + " videoViewNewHeight:" + i3);
            return false;
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[showSpaceView] error, aid:" + this.K.getAId() + " traceId:" + this.K.getTraceId() + " videoLayoutOldWidth:" + width + " videoLayoutOldHeight:" + height);
        return false;
    }

    private void Q1(AnimatorSet animatorSet) {
        long j3;
        String str;
        int i3;
        boolean z16;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (animatorSet == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateOtherAnimation] error, animatorSet is null, aid:" + j3 + " traceId:" + str);
            return;
        }
        if (this.S != null && this.U != null && this.V != null && this.W != null) {
            int i16 = 2;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addListener(w1(this.S));
            ofFloat.addUpdateListener(x1(this.S));
            ofFloat.setStartDelay(400L);
            ofFloat.setDuration(200L);
            boolean z17 = false;
            animatorSet.playTogether(ofFloat);
            View[] viewArr = {this.U, this.V, this.W};
            int i17 = 0;
            for (int i18 = 3; i17 < i18; i18 = 3) {
                View view = viewArr[i17];
                if (view == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateOtherAnimation] error, view is null, aid:" + j3 + " traceId:" + str);
                    z16 = z17;
                    i3 = i17;
                } else {
                    float[] fArr = new float[i16];
                    // fill-array-data instruction
                    fArr[0] = 0.0f;
                    fArr[1] = 1.0f;
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(fArr);
                    ofFloat2.addListener(w1(view));
                    ofFloat2.addUpdateListener(x1(view));
                    i3 = i17;
                    ofFloat2.setStartDelay(600L);
                    ofFloat2.setDuration(400L);
                    z16 = false;
                    animatorSet.playTogether(ofFloat2);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPx(20.0f), 0.0f);
                    ofFloat3.setStartDelay(600L);
                    ofFloat3.setDuration(600L);
                    animatorSet.playTogether(ofFloat3);
                }
                i17 = i3 + 1;
                z17 = z16;
                i16 = 2;
            }
            return;
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateOtherAnimation] error, aid:" + j3 + " traceId:" + str);
    }

    private boolean R1(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38) {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        TextView textView = this.S;
        if (textView != null && this.T != null && this.U != null && this.V != null && this.W != null && (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) && (this.T.getLayoutParams() instanceof LinearLayout.LayoutParams) && (this.U.getLayoutParams() instanceof LinearLayout.LayoutParams) && (this.V.getLayoutParams() instanceof LinearLayout.LayoutParams) && (this.W.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.S.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams.topMargin = i17;
            this.S.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.T.getLayoutParams();
            layoutParams2.width = i18;
            layoutParams2.height = i19;
            layoutParams2.topMargin = i26;
            this.T.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams3.height = i27;
            layoutParams3.topMargin = i28;
            this.U.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
            layoutParams4.height = i29;
            layoutParams4.topMargin = i36;
            this.V.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams5.height = i37;
            layoutParams5.topMargin = i38;
            this.W.setLayoutParams(layoutParams5);
            return true;
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateSpaceViewLayout] error, aid:" + j3 + " traceId:" + str);
        return false;
    }

    private void S1(AnimatorSet animatorSet, long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        long j16;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j16 = gdtAd.getAId();
        } else {
            j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (animatorSet == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateVideoLayoutAnimatorSet] error, animatorSet is null, aid:" + j16 + " traceId:" + str);
            return;
        }
        View view = this.P;
        if (view == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[updateVideoLayoutAnimatorSet] error, mVideoLayout is null, aid:" + j16 + " traceId:" + str);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f16, f17);
        ofFloat.setDuration(j3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.P, BasicAnimation.KeyPath.SCALE_Y, f18, f19);
        ofFloat2.setDuration(j3);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.P, "translationX", f26, f27);
        ofFloat3.setDuration(j3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.P, "translationY", f28, f29);
        ofFloat4.setDuration(j3);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
    }

    private Animator.AnimatorListener s1() {
        return new b();
    }

    private QCirclePicStateListener t1(String str) {
        return new e(str);
    }

    private QCircleAsyncTextView.b u1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, GdtAd gdtAd) {
        return new h(gdtAd, feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View.OnClickListener v1(GdtAd gdtAd, int i3) {
        return new f(gdtAd, i3);
    }

    private Animator.AnimatorListener w1(View view) {
        return new c(view);
    }

    private ValueAnimator.AnimatorUpdateListener x1(View view) {
        return new d(view);
    }

    private View.OnClickListener y1(GdtAd gdtAd) {
        return new g(gdtAd);
    }

    private int z1(int i3, int i16) {
        long j3;
        String str;
        int i17;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd3 = this.K;
        if (gdtAd3 != null) {
            i17 = gdtAd3.getInnerShowType();
        } else {
            i17 = 0;
        }
        if (i17 == 3) {
            return ((i3 - i16) * 120) / 278;
        }
        if (i17 == 4) {
            return ((i3 - i16) * 84) / 156;
        }
        QLog.e("QFSFeedChildAdSpacePresenter", 1, "[getAdvertiserTopMargin] error, aid:" + j3 + " traceId:" + str + " innerAdShowType:" + i17);
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        boolean z16;
        if (!this.I) {
            return super.D0(pVar);
        }
        if (this.K == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[isDisAllowInterceptEvent] error, mAd is null");
            return super.D0(pVar);
        }
        if (pVar == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[isDisAllowInterceptEvent] error, bean is null, aid: " + this.K.getAId() + " traceId:" + this.K.getTraceId());
            return super.D0(pVar);
        }
        p.a a16 = pVar.a();
        if (a16 == null) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[isDisAllowInterceptEvent] error, deltaTouchPoint is null, aid: " + this.K.getAId() + " traceId:" + this.K.getTraceId());
            return super.D0(pVar);
        }
        if (a16.b() >= 0.0f) {
            return super.D0(pVar);
        }
        if (this.L) {
            z16 = super.D0(pVar);
        } else {
            z16 = true;
        }
        if (!this.M && Math.abs(a16.b()) >= Math.abs(ViewUtils.dpToPx(this.K.getSpaceSlideThreshold()))) {
            af.q0();
            if (P1()) {
                this.M = true;
            } else {
                return super.D0(pVar);
            }
        }
        return z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        super.L0(feedCloudMeta$StFeed, i3);
        FeedCloudMeta$StFeed c16 = u.c(this.E);
        GdtAd gdtAd = new GdtAd(u.e(this.E));
        long aId = gdtAd.getAId();
        String traceId = gdtAd.getTraceId();
        GdtAd gdtAd2 = this.K;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
            QLog.e("QFSFeedChildAdSpacePresenter", 2, "[onBindData] is the same ad");
            return;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 1, "[onBindData] aid: " + aId + " traceId:" + traceId);
        J1();
        e30.b bVar = this.E;
        if (bVar != null) {
            feedCloudMeta$StFeed2 = bVar.g();
        }
        if (!af.n(feedCloudMeta$StFeed2, c16, gdtAd)) {
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[onBindData] ignored, not enabled, aid: " + aId + " traceId:" + traceId);
            return;
        }
        if (G0()) {
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[onBindData] ignored, in multi window mode, aid: " + aId + " traceId:" + traceId);
            return;
        }
        if (!G1(c16, gdtAd)) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[onBindData] error, initView error, aid: " + aId + " traceId:" + traceId);
            J1();
            return;
        }
        if (!M1(true)) {
            QLog.e("QFSFeedChildAdSpacePresenter", 1, "[onBindData] error, setRootViewShouldNotifyDispatchTouchEvent error, aid: " + aId + " traceId:" + traceId);
            J1();
            return;
        }
        this.I = true;
        this.J = c16;
        this.K = gdtAd;
        this.L = false;
        U0(ae.b(feedCloudMeta$StFeed, i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSAdSpaceDispatchTouchEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 2, "[onFeedSelected] aid: " + j3 + " traceId:" + str + " mSpaceDisplayed:" + this.M);
        super.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        long j3;
        String str;
        GdtAd gdtAd = this.K;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        GdtAd gdtAd2 = this.K;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        QLog.i("QFSFeedChildAdSpacePresenter", 2, "[onFeedUnSelected] aid: " + j3 + " traceId:" + str + " mSpaceDisplayed:" + this.M);
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSAdSpaceDispatchTouchEvent) {
            D1((QFSAdSpaceDispatchTouchEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdSpacePresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            long j3;
            String str;
            int i3;
            if (cw.this.K != null) {
                j3 = cw.this.K.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (cw.this.K != null) {
                str = cw.this.K.getTraceId();
            } else {
                str = null;
            }
            QLog.i("QFSFeedChildAdSpacePresenter", 1, "[createAnimatorListener][onAnimationEnd]aid:" + j3 + " traceId:" + str);
            View[] viewArr = {cw.this.R, cw.this.S, cw.this.T, cw.this.U, cw.this.V};
            for (int i16 = 0; i16 < 5; i16++) {
                View view = viewArr[i16];
                if (view == null) {
                    QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createAnimatorListener][onAnimationEnd] error, view is null, aid:" + j3 + " traceId:" + str);
                } else {
                    Integer d16 = com.tencent.biz.qqcircle.immersive.feed.ad.a.f85437a.d(Integer.valueOf(view.getId()));
                    cw cwVar = cw.this;
                    GdtAd gdtAd = cwVar.K;
                    if (d16 != null) {
                        i3 = d16.intValue();
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                    view.setOnClickListener(cwVar.v1(gdtAd, i3));
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85594d;

        c(View view) {
            this.f85594d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            long j3;
            String str;
            if (cw.this.K != null) {
                j3 = cw.this.K.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (cw.this.K != null) {
                str = cw.this.K.getTraceId();
            } else {
                str = null;
            }
            View view = this.f85594d;
            if (view == null) {
                QLog.e("QFSFeedChildAdSpacePresenter", 1, "[createSpaceItemViewAnimatorListener][onAnimationStart] error, view is null, aid:" + j3 + " traceId:" + str);
                return;
            }
            view.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
