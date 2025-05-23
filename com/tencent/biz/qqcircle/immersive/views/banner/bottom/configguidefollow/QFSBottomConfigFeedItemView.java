package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVisitor;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigFeedItemView extends QCircleBaseWidgetView<d> implements View.OnClickListener {
    private static final int E = ImmersiveUtils.dpToPx(4.0f);
    private static final int F = ImmersiveUtils.dpToPx(72.0f);
    private static final int G = ImmersiveUtils.dpToPx(96.0f);
    private FeedCloudMeta$StFeed C;
    private QFSPersonalProductLayerViewModel D;

    /* renamed from: d, reason: collision with root package name */
    private RoundCorneredFrameLayout f90613d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90614e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90615f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f90616h;

    /* renamed from: i, reason: collision with root package name */
    private int f90617i;

    /* renamed from: m, reason: collision with root package name */
    private e30.b f90618m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QFSAsyncUtils.Callback<Void, Void> {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            if (QFSBottomConfigFeedItemView.this.C == null) {
                return null;
            }
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(QFSBottomConfigFeedItemView.this.C.busiData.get().toByteArray());
                QCirclePushInfoManager.e().n(QFSBottomConfigFeedItemView.this.C.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
            } catch (Exception e16) {
                QLog.e("QFSBottomConfigFeedItemView", 1, e16, new Object[0]);
            }
            return null;
        }
    }

    public QFSBottomConfigFeedItemView(@NonNull Context context) {
        super(context);
        v0();
        u0();
    }

    private void l0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        Option targetView;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StImage = feedCloudMeta$StFeed.cover) != null) {
            if (this.f90614e == null) {
                QLog.e("QFSBottomConfigFeedItemView", 1, "[bindCover] mCoverImg should not be null");
                return;
            }
            if (TextUtils.isEmpty(feedCloudMeta$StImage.layerPicUrl.get())) {
                targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.f90614e);
            } else {
                targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.layerPicUrl.get()).setTargetView(this.f90614e);
            }
            targetView.setRequestWidth(F);
            targetView.setRequestHeight(G);
            targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
            return;
        }
        QLog.e("QFSBottomConfigFeedItemView", 1, "[bindCover] feed should not be null");
    }

    private void n0() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.f90618m;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.f90618m.g().f398449id.get());
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.C;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null) {
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        }
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.f90617i + 1));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.C;
        if (feedCloudMeta$StFeed2 != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, feedCloudMeta$StFeed2.f398449id.get());
        }
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.f90613d, QCircleDaTongConstant.ElementId.EM_XSJ_CONTENT_CARD);
        VideoReport.setElementParams(this.f90613d, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f90613d, String.valueOf(this.f90617i));
    }

    private void o0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVisitor feedCloudMeta$StVisitor;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVisitor = feedCloudMeta$StFeed.visitorInfo) != null) {
            if (this.f90615f == null) {
                QLog.e("QFSBottomConfigFeedItemView", 1, "[bindPlayCount] mCoverImg should not be null");
                return;
            }
            String f16 = r.f(feedCloudMeta$StVisitor.viewCount.get());
            if (!TextUtils.isEmpty(f16)) {
                this.f90615f.setText(f16);
                return;
            }
            return;
        }
        QLog.e("QFSBottomConfigFeedItemView", 1, "[bindPlayCount] feed should not be null");
    }

    private void p0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, ImageView imageView) {
        QCircleLayerBean q06 = q0(i3, feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed != null && imageView != null && q06 != null) {
            int[] iArr = new int[2];
            imageView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            q06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], imageView.getWidth() + i16, iArr[1] + imageView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTransitionDelayTimeMs(0).setEnterAnimFadeCoverTimeMs(300).setTransitionDurationMs(200));
            q06.getTransitionAnimBean().setCoverDrawable(imageView.getDrawable());
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), q06);
            return;
        }
        QLog.e("QFSBottomConfigFeedItemView", 1, "[callOnFeedClick] feed should not be null");
    }

    private void s0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSBottomConfigFeedItemView", 1, "[initPicIcon] feed should not be null");
            return;
        }
        ImageView imageView = this.f90616h;
        if (feedCloudMeta$StFeed.type.get() == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void u0() {
        this.D = (QFSPersonalProductLayerViewModel) getViewModel(QFSPersonalProductLayerViewModel.class);
        w20.a.j().registerDisplaySurface(this.D.P1(), this.D);
    }

    private void v0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.f39541by);
        this.f90613d = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(E);
        this.f90613d.setOnClickListener(this);
        this.f90614e = (ImageView) findViewById(R.id.f39571c1);
        this.f90615f = (TextView) findViewById(R.id.f39551bz);
        this.f90616h = (ImageView) findViewById(R.id.y6u);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g89;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(d dVar, int i3) {
        if (dVar == null) {
            QLog.e("QFSBottomConfigFeedItemView", 1, "[bindData] feedItemInfo should not be null");
            return;
        }
        QLog.d("QFSBottomConfigFeedItemView", 1, "[bindData] feedItemInfo =" + dVar);
        this.f90617i = i3;
        this.C = dVar.a();
        this.f90618m = dVar.c();
        o0(this.C);
        l0(this.C);
        s0(this.C);
        n0();
        r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39541by) {
            p0(this.f90617i, this.C, this.f90614e);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QCircleLayerBean q0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        if (this.D != null && (feedCloudMeta$StFeed2 = this.C) != null) {
            if (feedCloudMeta$StFeed2.poster != null) {
                this.D.N1(r.k(this.f90618m), this.C.poster.f398463id.get(), "feeddrawer=" + r.u(this.f90618m));
            }
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            if (getReportBean() != null) {
                qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
            }
            qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setDataPosInList(i3);
            qCircleLayerBean.setTransInitBean(qCircleInitBean);
            qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
            qCircleLayerBean.setGlobalViewModelKey(this.D.P1());
            qCircleLayerBean.setPageCode(hashCode());
            return qCircleLayerBean;
        }
        QLog.e("QFSBottomConfigFeedItemView", 1, "[createLayerBean] mFeedViewModel should not be null., mCurItemFeed =" + this.C);
        return null;
    }

    public void r0() {
        QFSAsyncUtils.executeSub(new a(), new Void[0]);
    }
}
