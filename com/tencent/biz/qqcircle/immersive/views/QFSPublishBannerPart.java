package com.tencent.biz.qqcircle.immersive.views;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QFSTianShuConstant;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StPicTextBanner;

/* loaded from: classes4.dex */
public class QFSPublishBannerPart extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private ImageView E;
    private Animation F;
    private Animation G;
    private final int H;
    private e40.s I;

    /* renamed from: e, reason: collision with root package name */
    private View f90435e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f90436f;

    /* renamed from: h, reason: collision with root package name */
    private View f90437h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f90438i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90439m;

    /* renamed from: d, reason: collision with root package name */
    private String f90434d = "mqqapi://qcircle/openqqpublish?enable_location_tag=1";
    private final Runnable J = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSPublishBannerPart.1
        @Override // java.lang.Runnable
        public void run() {
            QFSPublishBannerPart.this.F9();
        }
    };

    public QFSPublishBannerPart(int i3) {
        this.H = i3;
    }

    private void B9(View view) {
        QQCircleDitto$StPicTextBanner qQCircleDitto$StPicTextBanner;
        int i3 = this.H;
        if (i3 == 1) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_NEARBY_LBS_CHECK_BUTTON);
        } else if (i3 == 2) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CIRCLE_PUBLISH_IMPULSE_BUTTON);
        } else if (i3 == 3) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISH_GUIDE_BANNER_BUTTON);
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (this.H == 3) {
            buildElementParams.put("xsj_resource_type", 10);
            e40.s sVar = this.I;
            if (sVar != null && (qQCircleDitto$StPicTextBanner = sVar.f395680a) != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_BANNER_URL, qQCircleDitto$StPicTextBanner.icon.picUrl.get());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_BANNER_TITLE, qQCircleDitto$StPicTextBanner.title.get());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_BANNER_BUTTON_CONTENT, qQCircleDitto$StPicTextBanner.content.get());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_BANNER_SCHEMA, qQCircleDitto$StPicTextBanner.actionUrl.get());
                buildElementParams.put("xsj_tianshu_task_id", this.I.a());
            }
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private Animation C9() {
        if (this.G == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154889sz);
            this.G = loadAnimation;
            loadAnimation.setAnimationListener(new b());
        }
        return this.G;
    }

    private Animation D9() {
        if (this.F == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154888sy);
            this.F = loadAnimation;
            loadAnimation.setAnimationListener(new a());
        }
        return this.F;
    }

    private void E9() {
        String str = "";
        if (!TextUtils.isEmpty(this.f90434d) && !"mqqapi://qcircle/openqqpublish?enable_location_tag=1".equals(this.f90434d)) {
            String str2 = this.f90434d;
            if (this.H == 3) {
                str2 = cy.e(str2, 10, this.I.a(), "");
            }
            QCircleSchemeLauncher.d(getContext(), str2);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", HostDataTransUtils.getAccount());
        hashMap.put(IProfileCardConst.KEY_FROM_TYPE, String.valueOf(20));
        int i3 = this.H;
        if (i3 == 1) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_NEARBY_LBS_CHECK_BUTTON;
        } else if (i3 == 2) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_CIRCLE_PUBLISH_IMPULSE_BUTTON;
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("taskid", str);
        }
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        qCircleSchemeBean.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH);
        qCircleSchemeBean.setAttrs(hashMap);
        QCircleSchemeLauncher.b(getContext(), qCircleSchemeBean);
    }

    private void G9() {
        View view = this.f90435e;
        if (view != null && this.f90436f == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.f1188875c);
            this.f90436f = viewStub;
            View findViewById = viewStub.inflate().findViewById(R.id.f500624d);
            this.f90437h = findViewById;
            this.f90438i = (ImageView) findViewById.findViewById(R.id.f5031252);
            this.f90439m = (TextView) this.f90437h.findViewById(R.id.f5032253);
            this.C = (TextView) this.f90437h.findViewById(R.id.f5030251);
            this.D = (TextView) this.f90437h.findViewById(R.id.f502824z);
            this.E = (ImageView) this.f90437h.findViewById(R.id.f5029250);
            this.D.setOnClickListener(this);
            this.E.setOnClickListener(this);
            B9(this.D);
        }
    }

    private void H9() {
        String a16;
        int i3 = this.H;
        if (i3 == 1) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(7).setThrActionType(0));
            return;
        }
        if (i3 == 2) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(112).setSubActionType(1).setThrActionType(1));
            return;
        }
        if (i3 == 3) {
            QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(113).setSubActionType(1);
            e40.s sVar = this.I;
            if (sVar == null) {
                a16 = "";
            } else {
                a16 = sVar.a();
            }
            QCircleLpReportDc05504.report(subActionType.setExt6(a16));
            I9(101);
        }
    }

    private void I9(int i3) {
        if (this.I == null || this.H != 3) {
            return;
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin());
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mItemId = this.I.a();
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = this.I.b();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    private void K9(QQCircleDitto$StPicTextBanner qQCircleDitto$StPicTextBanner) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (qQCircleDitto$StPicTextBanner == null) {
            return;
        }
        String str = qQCircleDitto$StPicTextBanner.title.get();
        if (!TextUtils.isEmpty(str) && (textView3 = this.f90439m) != null) {
            textView3.setText(str);
        }
        String str2 = qQCircleDitto$StPicTextBanner.content.get();
        if (!TextUtils.isEmpty(str2) && (textView2 = this.C) != null) {
            textView2.setText(str2);
        }
        List<QQCircleDitto$StButton> list = qQCircleDitto$StPicTextBanner.buttons.get();
        if (list != null && !list.isEmpty()) {
            String str3 = list.get(0).name.get();
            if (!TextUtils.isEmpty(str3) && (textView = this.D) != null) {
                textView.setText(str3);
            }
        }
        String str4 = qQCircleDitto$StPicTextBanner.actionUrl.get();
        if (!TextUtils.isEmpty(str4)) {
            this.f90434d = str4;
        }
        String str5 = qQCircleDitto$StPicTextBanner.icon.picUrl.get();
        if (!TextUtils.isEmpty(str5)) {
            L9(str5);
        }
    }

    private void L9(String str) {
        QLog.d("QFSPublishBannerPart", 1, "[setLocalCover] localCoverUrl: ", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(str).setTargetView(this.f90438i).setPredecode(true).setRequestWidth(ViewUtils.dip2px(36.0f)).setRequestHeight(ViewUtils.dip2px(36.0f));
        QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSPublishBannerPart.2
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFSPublishBannerPart", 1, "[setLocalCover] loadImage state: ", loadState);
                }
                if (loadState != LoadState.STATE_SUCCESS) {
                    QLog.e("QFSPublishBannerPart", 1, "[setLocalCover] loadImage failed.");
                } else {
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(QFSPublishBannerPart.this.f90438i.getResources(), option.getResultBitMap());
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSPublishBannerPart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QFSPublishBannerPart.this.f90438i != null) {
                                QFSPublishBannerPart.this.f90438i.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                }
            }
        });
    }

    public void F9() {
        View view = this.f90437h;
        if (view != null) {
            view.startAnimation(C9());
            this.f90437h.removeCallbacks(this.J);
        }
    }

    public void J9(e40.s sVar) {
        this.I = sVar;
        if (sVar != null && sVar.f395680a != null) {
            G9();
            K9(sVar.f395680a);
        }
    }

    public void M9() {
        G9();
        View view = this.f90437h;
        if (view == null) {
            return;
        }
        view.startAnimation(D9());
        this.f90437h.postDelayed(this.J, 5000L);
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublishBannerPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.f502824z) {
                E9();
                F9();
                I9(102);
            } else if (view.getId() == R.id.f5029250) {
                F9();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f90435e = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            QLog.d("QFSPublishBannerPart", 1, "show, onAnimationStart ");
            QFSPublishBannerPart.this.f90437h.setVisibility(0);
            QFSPublishBannerPart.this.D.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QLog.d("QFSPublishBannerPart", 1, "hide, onAnimationEnd ");
            QFSPublishBannerPart.this.f90437h.setVisibility(8);
            QFSPublishBannerPart.this.D.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
