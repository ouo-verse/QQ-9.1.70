package com.tencent.biz.qqcircle.widgets.polymerization;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.feed.event.ShowSharePanelEvent;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleFeedBase$StTagPageData;

/* loaded from: classes5.dex */
public class QCircleTagPolymerizationHeadView extends QCircleBasePolymerizationHeadView implements View.OnClickListener {
    private static final int G = cx.a(20.0f);
    private static final int H = cx.a(20.0f);
    private static final int I = cx.a(20.0f);
    private static final int J = cx.a(4.0f);
    private QCircleRoundImageView C;
    private FrameLayout D;
    private TextView E;
    private QCirclePolymerizationBean F;

    /* renamed from: d, reason: collision with root package name */
    private QQCircleFeedBase$StTagPageData f93766d;

    /* renamed from: e, reason: collision with root package name */
    private SquareImageView f93767e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93768f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93769h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93770i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93771m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QCircleTagPolymerizationHeadView.this.f93766d != null) {
                QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
                try {
                    qQCircleDitto$StCircleDittoDataNew.mergeFrom(QCircleTagPolymerizationHeadView.this.f93766d.dittoFeed.dittoDataNew.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QCircleTagPolymerizationHeadView", 1, "[onInitView] e:", e16);
                }
                if (TextUtils.isEmpty(qQCircleDitto$StCircleDittoDataNew.singlePicBanner.actionUrl.get())) {
                    QLog.i("QCircleTagPolymerizationHeadView", 1, "bannerView click  dittoDataNew.singlePicBanner.actionUrl == null");
                } else {
                    com.tencent.biz.qqcircle.launcher.c.g(QCircleTagPolymerizationHeadView.this.getContext(), qQCircleDitto$StCircleDittoDataNew.singlePicBanner.actionUrl.get());
                    QCircleLpReportDc05504.DataBuilder thrActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(10).setThrActionType(2);
                    if (QCircleTagPolymerizationHeadView.this.F != null) {
                        str = QCircleTagPolymerizationHeadView.this.F.getPolymerizationName();
                    } else {
                        str = "";
                    }
                    QCircleLpReportDc05504.report(thrActionType.setExt6(str).setPageId(QCircleTagPolymerizationHeadView.this.getPageId()).setfPageId(QCircleTagPolymerizationHeadView.this.getParentPageId()));
                    HashMap hashMap = new HashMap();
                    hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_TYPE, "clck");
                    hashMap.put("dt_pgstp", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
                    hashMap.put("dt_ref_pgid", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
                    VideoReport.reportEvent(QCircleDaTongConstant.ElementId.EM_XSJ_BANNER, QCircleTagPolymerizationHeadView.this.C, hashMap);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f93773d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f93774e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f93775f;

        b(int i3, Context context, String str) {
            this.f93773d = i3;
            this.f93774e = context;
            this.f93775f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            dialogInterface.dismiss();
            int i16 = this.f93773d;
            if (i16 == 2) {
                SimpleEventBus.getInstance().dispatchEvent(new ShowSharePanelEvent());
                str = "share";
            } else if (i16 == 3) {
                com.tencent.biz.qqcircle.launcher.c.g(this.f93774e, this.f93775f);
                str = "push";
            } else {
                str = "";
            }
            QCircleTagPolymerizationHeadView.this.r0(((QCircleCustomDialog) dialogInterface).getRootView(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QCircleTagPolymerizationHeadView.this.r0(((QCircleCustomDialog) dialogInterface).getRootView(), QCircleDaTongConstant.ElementParamValue.XSJ_ACTIONTYPE_KNOW);
        }
    }

    public QCircleTagPolymerizationHeadView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void A0() {
        if (this.f93766d.tagInfo.optInfo.materialInfo.size() < 1) {
            QLog.e("QCircleTagPolymerizationHeadView", 1, "[updateTemplate] materialInfo == null");
            return;
        }
        d dVar = new d();
        dVar.e(this);
        dVar.b(this.f93766d.tagInfo.optInfo.materialInfo.get());
        dVar.f(getReportBean());
    }

    private void initView() {
        String str;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f93767e = (SquareImageView) findViewById(R.id.duw);
        this.f93768f = (ImageView) findViewById(R.id.y5n);
        this.f93769h = (TextView) findViewById(R.id.kbs);
        this.D = (FrameLayout) findViewById(R.id.f100225rx);
        this.E = (TextView) findViewById(R.id.f112096n0);
        QCirclePolymerizationBean qCirclePolymerizationBean = (QCirclePolymerizationBean) ((Activity) getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
        TextView textView = this.f93769h;
        if (qCirclePolymerizationBean != null) {
            str = qCirclePolymerizationBean.getPolymerizationName();
        } else {
            str = "";
        }
        textView.setText(str);
        this.f93770i = (TextView) findViewById(R.id.f109826gv);
        this.f93771m = (TextView) findViewById(R.id.f107316a3);
        QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) findViewById(R.id.f113906rw);
        this.C = qCircleRoundImageView;
        qCircleRoundImageView.setOnClickListener(new a());
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(View view, String str) {
        if (view != null && this.f93766d != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_HOTNUMBER_RULE_MEDAL_WINDOWS);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_topic_id", this.f93766d.tagInfo.tagId.get());
            buildElementParams.put("xsj_topic_name", this.f93766d.tagInfo.tagName.get());
            buildElementParams.put("xsj_actiontype", str);
            VideoReport.reportEvent("ev_xsj_camera_action", view, buildElementParams);
        }
    }

    private void s0() {
        QCircleRoundImageView qCircleRoundImageView = this.C;
        if (qCircleRoundImageView == null) {
            return;
        }
        VideoReport.setElementId(qCircleRoundImageView, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER);
        VideoReport.setElementParams(this.C, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementReuseIdentifier(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_BANNER);
    }

    private void u0() {
        if (this.f93766d == null) {
            return;
        }
        VideoReport.setElementId(this.f93768f, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_topic_name", this.f93766d.tagInfo.tagName.get());
        buildElementParams.put("xsj_topic_id", this.f93766d.tagInfo.tagId.get());
        VideoReport.setElementParams(this.f93768f, buildElementParams);
    }

    private void v0(Context context) {
        String str;
        b bVar;
        QQCircleFeedBase$StTagPageData qQCircleFeedBase$StTagPageData = this.f93766d;
        if (qQCircleFeedBase$StTagPageData == null) {
            QLog.e("QCircleTagPolymerizationHeadView", 1, "[showMedalDialog] mTagPageData should not be null");
            return;
        }
        boolean z16 = qQCircleFeedBase$StTagPageData.isShowTagMedal.get();
        String str2 = this.f93766d.medalToast.content.get();
        String str3 = this.f93766d.medalToast.leftButtonName.get();
        int i3 = this.f93766d.medalToast.leftButtonAction.get();
        String str4 = this.f93766d.medalToast.leftButtonJumpUrl.get();
        String str5 = this.f93766d.medalToast.rightButtonName.get();
        String str6 = this.f93766d.medalToast.title.get();
        QLog.d("QCircleTagPolymerizationHeadView", 1, "showMedalDialog, isShowMedal: " + z16 + ", content: " + str2 + ", leftButtonName: " + str3 + ", leftButtonAction: " + i3 + ", leftButtonJumpUrl: " + str4 + ", rightButtonName: " + str5 + ", title: " + str6);
        if (z16) {
            str = "";
        } else {
            str = str3;
        }
        if (z16) {
            bVar = null;
        } else {
            bVar = new b(i3, context, str4);
        }
        QCircleCustomDialog.U(context, str6, str2, str, str5, new c(), bVar).show();
    }

    private void w0() {
        if (this.C == null) {
            return;
        }
        int c16 = cx.c(getContext()) - (cx.a(16.0f) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.width = c16;
        layoutParams.height = (int) (c16 / 11.7f);
        this.C.setLayoutParams(layoutParams);
    }

    private void x0() {
        QCircleRoundImageView qCircleRoundImageView;
        String str;
        if (this.f93766d != null && (qCircleRoundImageView = this.C) != null) {
            qCircleRoundImageView.setVisibility(8);
            if (this.f93766d.dittoFeed.dittoId.get() != 8) {
                QLog.i("QCircleTagPolymerizationHeadView", 1, "updateBannerView  dittoFeed.dittoId.get() != 8");
                return;
            }
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
            try {
                qQCircleDitto$StCircleDittoDataNew.mergeFrom(this.f93766d.dittoFeed.dittoDataNew.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(qQCircleDitto$StCircleDittoDataNew.singlePicBanner.image.picUrl.get())) {
                QLog.i("QCircleTagPolymerizationHeadView", 1, "updateBannerView  dittoDataNew.singlePicBanner.image.picUrl.get() == null");
                return;
            }
            this.C.setVisibility(0);
            w0();
            this.C.setRoundRect(J);
            Option targetView = Option.obtain().setUrl(qQCircleDitto$StCircleDittoDataNew.singlePicBanner.image.picUrl.get()).setTargetView(this.C);
            QCircleFeedPicLoader.setViewWidthHeight(targetView, this.C);
            QCircleFeedPicLoader.g().loadImage(targetView);
            QCircleLpReportDc05504.DataBuilder thrActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(10).setThrActionType(1);
            QCirclePolymerizationBean qCirclePolymerizationBean = this.F;
            if (qCirclePolymerizationBean != null) {
                str = qCirclePolymerizationBean.getPolymerizationName();
            } else {
                str = "";
            }
            QCircleLpReportDc05504.report(thrActionType.setExt6(str).setPageId(getPageId()).setfPageId(getParentPageId()));
            return;
        }
        QLog.i("QCircleTagPolymerizationHeadView", 1, "updateBannerView  mTagPageData == null");
    }

    private void y0() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.f93766d.coverInfo;
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.picUrl != null) {
            Option targetView = Option.obtain().setUrl(this.f93766d.coverInfo.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onn)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onn)).setTargetView(this.f93767e);
            QCircleFeedPicLoader.setViewWidthHeight(targetView, this.f93767e);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    private void z0() {
        int i3;
        boolean z16 = this.f93766d.isShowTagMedal.get();
        QLog.d("QCircleTagPolymerizationHeadView", 1, "updateMedalIcon, isShowMedal: " + z16);
        ImageView imageView = this.f93768f;
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        if (z16) {
            i3 = R.drawable.ook;
        } else {
            i3 = R.drawable.qui_hashtag;
        }
        imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
        ViewGroup.LayoutParams layoutParams = this.f93768f.getLayoutParams();
        if (z16) {
            layoutParams.width = H;
            layoutParams.height = I;
            this.f93768f.setOnClickListener(this);
            u0();
        } else {
            int i16 = G;
            layoutParams.width = i16;
            layoutParams.height = i16;
            this.f93768f.setOnClickListener(null);
        }
        this.f93768f.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof QQCircleFeedBase$StTagPageData)) {
            return;
        }
        QQCircleFeedBase$StTagPageData qQCircleFeedBase$StTagPageData = (QQCircleFeedBase$StTagPageData) obj;
        this.f93766d = qQCircleFeedBase$StTagPageData;
        this.f93769h.setText(qQCircleFeedBase$StTagPageData.tagInfo.tagName.get());
        int i16 = 0;
        if (!TextUtils.isEmpty(this.f93766d.activityCopywritingDesc.get())) {
            this.f93771m.setVisibility(0);
            this.f93771m.setText(this.f93766d.activityCopywritingDesc.get());
        } else {
            this.f93771m.setVisibility(8);
        }
        this.f93770i.setText(k0(this.f93766d.subsidiaryFieldDesc.get()));
        y0();
        x0();
        z0();
        A0();
        try {
            int i17 = this.f93766d.tagInfo.get().tagChallengeData.get().tagChallengeRank.get();
            this.E.setText(getContext().getString(R.string.f185383of, Integer.valueOf(i17)));
            FrameLayout frameLayout = this.D;
            if (i17 <= 0) {
                i16 = 8;
            }
            frameLayout.setVisibility(i16);
        } catch (Exception e16) {
            this.D.setVisibility(8);
            QLog.e("QCircleTagPolymerizationHeadView", 1, "get topic rank failed cause by:" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168640g63;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleTagPolymerizationHeadView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y5n) {
            v0(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w0();
    }

    public void setInitBean(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.F = qCirclePolymerizationBean;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
