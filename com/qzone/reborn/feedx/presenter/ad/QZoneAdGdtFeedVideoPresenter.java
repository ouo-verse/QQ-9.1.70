package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.ad.QZoneAdFeedxSingleVideoWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdGdtFeedVideoPresenter;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter;", "", "y0", "w0", "x0", "", "k", "d0", "", "W", "X", "a0", "Z", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcf/b;", "event", "t", "play", "pause", "Lcom/tencent/gdtad/aditem/GdtAd;", "P", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "mTempRemainTime", BdhLogUtil.LogTag.Tag_Req, "mVideoViewHeight", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdGdtFeedVideoPresenter extends QZoneAdFeedBaseVideoPresenter {

    /* renamed from: P, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: Q, reason: from kotlin metadata */
    private volatile int mTempRemainTime;

    /* renamed from: R, reason: from kotlin metadata */
    private volatile int mVideoViewHeight;

    private final void w0() {
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView;
        if (getMVideoItemWidgetView() == null || (mVideoItemWidgetView = getMVideoItemWidgetView()) == null) {
            return;
        }
        mVideoItemWidgetView.setVideoStateBroadcastCallback(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        if (getMVideoItemWidgetView() == null) {
            return;
        }
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView = getMVideoItemWidgetView();
        if (mVideoItemWidgetView != null ? mVideoItemWidgetView.P0() : false) {
            D(new cf.a(1006));
        } else {
            D(new cf.a(1007));
        }
    }

    private final void y0() {
        BusinessFeedData businessFeedData;
        if (getMVideoItemWidgetView() == null || (businessFeedData = this.f441565h) == null) {
            return;
        }
        if (businessFeedData.getRecommAction() == null || this.f441565h.getRecommAction().extendInfo == null || !this.f441565h.getRecommAction().extendInfo.containsKey(24)) {
            QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView = getMVideoItemWidgetView();
            if (mVideoItemWidgetView != null) {
                mVideoItemWidgetView.setVideoStartPlayCallback(null);
            }
            QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView2 = getMVideoItemWidgetView();
            if (mVideoItemWidgetView2 != null) {
                mVideoItemWidgetView2.setVideoStopCallback(null);
            }
        }
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView3 = getMVideoItemWidgetView();
        if (mVideoItemWidgetView3 != null) {
            mVideoItemWidgetView3.setVideoStartPlayCallback(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdGdtFeedVideoPresenter$updateVideoStateCallback$1
                @Override // java.lang.Runnable
                public void run() {
                    BusinessFeedData businessFeedData2;
                    BusinessFeedData businessFeedData3;
                    BusinessFeedData businessFeedData4;
                    int i3;
                    businessFeedData2 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                    if (businessFeedData2.getRecommAction() != null) {
                        businessFeedData3 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                        if (businessFeedData3.getRecommAction().extendInfo != null) {
                            businessFeedData4 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                            if (businessFeedData4.getRecommAction().extendInfo.containsKey(24)) {
                                QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView4 = QZoneAdGdtFeedVideoPresenter.this.getMVideoItemWidgetView();
                                if (mVideoItemWidgetView4 != null && mVideoItemWidgetView4.getVisibility() == 0) {
                                    QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView5 = QZoneAdGdtFeedVideoPresenter.this.getMVideoItemWidgetView();
                                    int height = mVideoItemWidgetView5 != null ? mVideoItemWidgetView5.getHeight() : 0;
                                    i3 = QZoneAdGdtFeedVideoPresenter.this.mVideoViewHeight;
                                    if (i3 != height) {
                                        QZoneAdGdtFeedVideoPresenter.this.D(new cf.a("event_key_qzone_ad_feed_video_view_height", height));
                                        QZoneAdGdtFeedVideoPresenter.this.mVideoViewHeight = height;
                                    }
                                    QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1001));
                                }
                            }
                        }
                    }
                }
            });
        }
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView4 = getMVideoItemWidgetView();
        if (mVideoItemWidgetView4 != null) {
            mVideoItemWidgetView4.setVideoStopCallback(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.QZoneAdGdtFeedVideoPresenter$updateVideoStateCallback$2
                @Override // java.lang.Runnable
                public void run() {
                    BusinessFeedData businessFeedData2;
                    BusinessFeedData businessFeedData3;
                    BusinessFeedData businessFeedData4;
                    businessFeedData2 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                    if (businessFeedData2.getRecommAction() != null) {
                        businessFeedData3 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                        if (businessFeedData3.getRecommAction().extendInfo != null) {
                            businessFeedData4 = ((vg.a) QZoneAdGdtFeedVideoPresenter.this).f441565h;
                            if (businessFeedData4.getRecommAction().extendInfo.containsKey(24)) {
                                QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1002));
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean W() {
        BusinessFeedData businessFeedData = this.f441565h;
        return QZoneAdFeedUtils.f55717a.O((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean X() {
        BusinessFeedData businessFeedData = this.f441565h;
        return QZoneAdFeedUtils.f55717a.S((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean Z() {
        return ih.j.l(this.f441565h) || QZoneAdFeedUtils.f55717a.h(this.f441565h);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public boolean a0() {
        Object obj;
        String str;
        String aid = QZoneAdFeedDataExtKt.getAid(this.f441565h);
        String traceId = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            obj = Long.valueOf(gdtAd.getAId());
        } else {
            obj = "-2147483648";
        }
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 == null || (str = gdtAd2.getTraceId()) == null) {
            str = "";
        }
        QLog.i("PSLink-QZoneAdGdtFeedVideoPresenter", 2, "[onBindData] aid:" + aid + " traceId:" + traceId + " oldAid:" + obj + " oldTraceId:" + str);
        return !TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter
    public void d0() {
        String str;
        this.mAd = GdtFeedUtilForQZone.E(this.f441565h);
        e0(new QZoneAdFeedBaseVideoPresenter.a());
        QZoneAdFeedBaseVideoPresenter.a mAdFeedVideoData = getMAdFeedVideoData();
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null || (str = Long.valueOf(gdtAd.getAId()).toString()) == null) {
            str = "";
        }
        mAdFeedVideoData.d(str);
        QZoneAdFeedBaseVideoPresenter.a mAdFeedVideoData2 = getMAdFeedVideoData();
        GdtAd gdtAd2 = this.mAd;
        String traceId = gdtAd2 != null ? gdtAd2.getTraceId() : null;
        mAdFeedVideoData2.e(traceId != null ? traceId : "");
        getMAdFeedVideoData().f(this.f441565h.getVideoInfo());
        BusinessFeedData businessFeedData = this.f441565h;
        boolean z16 = ((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h)) == 31;
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView = getMVideoItemWidgetView();
        if (mVideoItemWidgetView != null) {
            mVideoItemWidgetView.setIsBrokenWindowAd(z16);
        }
        if (z16) {
            y0();
            w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "PSLink-QZoneAdGdtFeedVideoPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mvq /* 1745224777 */:
                case R.id.mvr /* 1745224778 */:
                    QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                    Activity mActivity = this.C;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    BusinessFeedData mFeedData = this.f441565h;
                    Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                    qZoneAdFeedUtils.H(mActivity, v3, mFeedData, FeedElement.VIDEO, 6, this.f441567m, null);
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter, gf.r
    public void pause() {
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView;
        if (QZoneAdFeedDataExtKt.isNeedShowRecommendAd(this.f441565h) || (mVideoItemWidgetView = getMVideoItemWidgetView()) == null) {
            return;
        }
        mVideoItemWidgetView.pause();
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter, gf.r
    public void play() {
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView;
        if (QZoneAdFeedDataExtKt.isNeedShowRecommendAd(this.f441565h) || (mVideoItemWidgetView = getMVideoItemWidgetView()) == null) {
            return;
        }
        mVideoItemWidgetView.play();
    }

    @Override // vg.a
    public void t(cf.b event) {
        QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView;
        super.t(event);
        if (event == null) {
            return;
        }
        if (event.f30765a == 1005) {
            if (getMVideoItemWidgetView() == null || (mVideoItemWidgetView = getMVideoItemWidgetView()) == null) {
                return;
            }
            mVideoItemWidgetView.b1();
            return;
        }
        if (event instanceof df.a) {
            df.a aVar = (df.a) event;
            if (aVar.f393662c != 0) {
                QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView2 = getMVideoItemWidgetView();
                if (mVideoItemWidgetView2 != null) {
                    mVideoItemWidgetView2.setTimeMuteLayoutMarginBottom(aVar.f393662c + ef.d.b(1));
                    return;
                }
                return;
            }
        }
        if (event instanceof df.b) {
            a();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/QZoneAdGdtFeedVideoPresenter$b", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView$c;", "", "c", "a", "", IOnlineStatusService.REMAIN_TIME, "d", "", "isMute", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneVideoItemWidgetView.c {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.c
        public void a() {
            QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1004));
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.c
        public void c() {
            QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1003));
            QZoneAdGdtFeedVideoPresenter.this.x0();
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.c
        public void d(int remainTime) {
            if (remainTime / 1000 != QZoneAdGdtFeedVideoPresenter.this.mTempRemainTime / 1000) {
                QZoneAdGdtFeedVideoPresenter.this.mTempRemainTime = remainTime;
                QZoneAdGdtFeedVideoPresenter.this.D(new cf.a("event_key_qzone_ad_feed_video_update_remain_time", remainTime));
            }
        }

        @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.c
        public void b(boolean isMute) {
            if (isMute) {
                QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1006));
            } else {
                QZoneAdGdtFeedVideoPresenter.this.D(new cf.a(1007));
            }
        }
    }
}
