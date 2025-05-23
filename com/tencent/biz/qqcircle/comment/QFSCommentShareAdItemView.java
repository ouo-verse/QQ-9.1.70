package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentShareAdItemView extends QFSCommentBaseItemView {
    private FeedCloudMeta$StFeed G;
    private QCircleExtraTypeInfo H;
    private GdtAd I;
    private int J;
    private final com.tencent.biz.qqcircle.immersive.feed.ad.g K;
    private final GdtAntiSpamReportHelper L;
    private RelativeLayout M;
    private RoundImageView N;
    private TextView P;
    private QCircleAsyncTextView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private LinearLayout U;
    private TextView V;
    private final Map<Integer, Integer> W;

    /* renamed from: a0, reason: collision with root package name */
    private final AdFeedbackDialogFragment.Listener f83234a0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSCommentShareAdItemView> f83235a;

        public a(QFSCommentShareAdItemView qFSCommentShareAdItemView) {
            this.f83235a = new WeakReference<>(qFSCommentShareAdItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSCommentShareAdItemView qFSCommentShareAdItemView = this.f83235a.get();
            if (qFSCommentShareAdItemView != null) {
                buildElementParams.putAll(qFSCommentShareAdItemView.H0());
            }
            return buildElementParams;
        }
    }

    public QFSCommentShareAdItemView(@NonNull Context context) {
        super(context);
        this.J = 0;
        this.K = new com.tencent.biz.qqcircle.immersive.feed.ad.g();
        this.L = new GdtAntiSpamReportHelper();
        this.W = new HashMap<Integer, Integer>() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentShareAdItemView.1
            {
                put(Integer.valueOf(R.id.f362213z), 2);
                put(Integer.valueOf(R.id.f3623140), 3);
                put(Integer.valueOf(R.id.f361413r), 4);
                put(Integer.valueOf(R.id.f361513s), 5);
                put(Integer.valueOf(R.id.f361613t), 5);
                put(Integer.valueOf(R.id.f361713u), 5);
            }
        };
        this.f83234a0 = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.qqcircle.comment.w
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QFSCommentShareAdItemView.this.N0(result);
            }
        };
        initView();
    }

    private void D0() {
        VideoReport.setElementId(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_AD_CARD);
        VideoReport.setElementReuseIdentifier(this.M, E0());
        VideoReport.setElementExposePolicy(this.M, ExposurePolicy.REPORT_ALL);
        VideoReport.setEventDynamicParams(this.M, new a(this));
    }

    private String E0() {
        GdtAd gdtAd = this.I;
        if (gdtAd == null) {
            return "";
        }
        return gdtAd.getTraceId();
    }

    private int F0(View view) {
        if (view == null) {
            return Integer.MIN_VALUE;
        }
        int id5 = view.getId();
        if (!this.W.containsKey(Integer.valueOf(id5))) {
            return Integer.MIN_VALUE;
        }
        return this.W.get(Integer.valueOf(id5)).intValue();
    }

    private String G0() {
        if (getReportBean() == null) {
            return "";
        }
        return getReportBean().getDtPageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> H0() {
        String posId;
        long aId;
        String str;
        HashMap hashMap = new HashMap();
        String E0 = E0();
        GdtAd gdtAd = this.I;
        String str2 = "";
        if (gdtAd == null) {
            posId = "";
        } else {
            posId = gdtAd.getPosId();
        }
        GdtAd gdtAd2 = this.I;
        if (gdtAd2 == null) {
            aId = 0;
        } else {
            aId = gdtAd2.getAId();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.G;
        if (feedCloudMeta$StFeed2 != null) {
            str2 = feedCloudMeta$StFeed2.poster.f398463id.get();
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, E0);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, posId);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(aId));
        hashMap.put("xsj_feed_id", str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.L(this.I, view, this.J, this.H, F0(view), this.L.getAdAntiSpamForClickParams(this.M));
        VideoReport.reportEvent("dt_clck", this.M, H0());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void J0(String str) {
        RelativeLayout relativeLayout = this.M;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        QLog.d("QFSCommentShareAdItemView", 1, "hideCommentShareAdContainer:", str);
    }

    private void K0() {
        P0(this.N);
        P0(this.P);
        P0(this.Q);
        P0(this.R);
        P0(this.S);
        P0(this.T);
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentShareAdItemView.this.O0(view);
            }
        });
    }

    private void L0() {
        boolean z16;
        String str;
        String str2;
        String str3;
        GdtAd gdtAd = this.I;
        if (gdtAd == null) {
            QLog.e("QFSCommentShareAdItemView", 1, "initViewData error: ad is null");
            J0("ad is null");
            return;
        }
        String advertiser_corporate_logo = gdtAd.getAdvertiser_corporate_logo();
        if (TextUtils.isEmpty(advertiser_corporate_logo)) {
            this.N.setVisibility(8);
            J0("icon is null");
        } else {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.N).setUrl(advertiser_corporate_logo));
            this.N.setmRadius(ImmersiveUtils.dpToPx(17.0f), false);
        }
        String advertiser_corporate_image_name = this.I.getAdvertiser_corporate_image_name();
        if (TextUtils.isEmpty(advertiser_corporate_image_name)) {
            this.P.setVisibility(8);
            J0("title is null");
            return;
        }
        this.P.setText(advertiser_corporate_image_name);
        String text = this.I.getText();
        if (TextUtils.isEmpty(text)) {
            this.Q.setVisibility(8);
            J0("ad content is null");
            return;
        }
        this.Q.setText(text);
        if (this.I.getInnerShowType() != 9 && this.I.getInnerShowType() != 7) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str4 = "";
        if (!z16) {
            if (this.I.getImageData() != null) {
                str4 = this.I.getImageData().url;
            }
            Q0(this.R, str4);
            this.S.setVisibility(8);
            this.T.setVisibility(8);
        } else {
            GdtImageData imageData = this.I.getImageData(0);
            GdtImageData imageData2 = this.I.getImageData(1);
            GdtImageData imageData3 = this.I.getImageData(2);
            if (imageData == null) {
                str = "";
            } else {
                str = imageData.url;
            }
            if (imageData2 == null) {
                str2 = "";
            } else {
                str2 = imageData2.url;
            }
            if (imageData3 != null) {
                str4 = imageData3.url;
            }
            this.S.setVisibility(0);
            this.T.setVisibility(0);
            Q0(this.R, str);
            Q0(this.S, str2);
            Q0(this.T, str4);
        }
        if (com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.l()) {
            this.V.setText("\u8fbe\u4eba\u5171\u4eab\u5e7f\u544a");
            return;
        }
        if (QFSCommentHelper.L().x()) {
            str3 = "\u4f5c\u8005\u5171\u4eab\u5e7f\u544a";
        } else {
            str3 = "\u5e7f\u544a";
        }
        this.V.setText(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        J0("feedback close ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(AdFeedbackDialogFragment.Result result) {
        if (result.action == 3) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.y
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentShareAdItemView.this.M0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.feed.ad.x.f(this.M, this.I, this.G, com.tencent.biz.qqcircle.immersive.feed.ad.ae.c(G0(), null, this.I, this.J), this.H, this.f83234a0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void P0(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(this.L);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSCommentShareAdItemView.this.I0(view2);
            }
        });
    }

    private void Q0(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setVisibility(8);
            J0("ad image is null");
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = com.tencent.biz.qqcircle.immersive.feed.ad.af.u(this.I);
        layoutParams.height = com.tencent.biz.qqcircle.immersive.feed.ad.af.s(this.I);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(str));
        com.tencent.biz.qqcircle.immersive.feed.ad.af.l0(imageView, com.tencent.biz.qqcircle.immersive.feed.ad.af.t(this.I));
    }

    private void initView() {
        this.M = (RelativeLayout) findViewById(R.id.f3624141);
        this.N = (RoundImageView) findViewById(R.id.f362213z);
        this.P = (TextView) findViewById(R.id.f3623140);
        this.Q = (QCircleAsyncTextView) findViewById(R.id.f361413r);
        this.R = (ImageView) findViewById(R.id.f361513s);
        this.S = (ImageView) findViewById(R.id.f361613t);
        this.T = (ImageView) findViewById(R.id.f361713u);
        this.U = (LinearLayout) findViewById(R.id.f362013x);
        this.V = (TextView) findViewById(R.id.f362113y);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        if (QFSCommentHelper.L().x()) {
            return R.layout.g__;
        }
        return R.layout.g_9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentShareAdItemView";
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        RelativeLayout relativeLayout;
        super.bindData(qFSCommentItemInfo, i3);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed != null && qFSCommentItemInfo != null) {
            this.J = i3;
            FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
            if (feedCloudMeta$StComment == null) {
                return;
            }
            this.H = com.tencent.biz.qqcircle.immersive.feed.ad.ae.b(feedCloudMeta$StFeed, i3);
            String E0 = E0();
            this.I = (GdtAd) com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.n(feedCloudMeta$StComment);
            L0();
            K0();
            GdtAd gdtAd = this.I;
            if (gdtAd != null && !TextUtils.equals(E0, gdtAd.getTraceId()) && (relativeLayout = this.M) != null) {
                this.K.j(this.I, relativeLayout, this.J, this.H, relativeLayout);
                this.L.setExpoTime();
            }
            D0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K.h();
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.G = feedCloudMeta$StFeed;
    }
}
