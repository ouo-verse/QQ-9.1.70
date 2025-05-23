package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.qqcircle.viewmodels.h;
import com.tencent.biz.qqcircle.widgets.button.QCircleAggregationPublishButtonExp;
import com.tencent.biz.qqcircle.widgets.button.QCirclePolymerizationBottomButton;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.api.IReportApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StPublisherButton;

/* loaded from: classes4.dex */
public class QCirclePublishFeedPart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d0, reason: collision with root package name */
    private static final uq3.k f82730d0 = uq3.k.a();
    private VasPagView D;
    private VasPagView E;
    private boolean F;
    private QCircleLoadingDialog G;
    private int H;
    private boolean I;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> J;
    protected QCircleInitBean K;
    protected com.tencent.biz.qqcircle.viewmodels.h L;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r M;
    private QCirclePolymerizationViewModel N;
    private URLImageView P;
    private ViewGroup Q;
    private View R;
    private PAGView W;
    private PAGView X;
    private int Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private QFSPersonalInfo f82731a0;

    /* renamed from: b0, reason: collision with root package name */
    protected FeedCloudMeta$StUser f82732b0;

    /* renamed from: d, reason: collision with root package name */
    private View f82734d;

    /* renamed from: e, reason: collision with root package name */
    private View f82735e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StTagInfo f82736f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f82737h;

    /* renamed from: i, reason: collision with root package name */
    private QCirclePolymerizationBottomButton f82738i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleAggregationPublishButtonExp f82739m;
    private boolean C = true;
    private String S = "";
    private boolean T = true;
    private String U = "";
    private String V = "";

    /* renamed from: c0, reason: collision with root package name */
    private boolean f82733c0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Function1<PAGView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f82743d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSPersonalInfo f82744e;

        b(String str, QFSPersonalInfo qFSPersonalInfo) {
            this.f82743d = str;
            this.f82744e = qFSPersonalInfo;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            QCirclePublishFeedPart.this.W = pAGView;
            QCirclePublishFeedPart.this.Y |= 2;
            QCirclePublishFeedPart.this.Da(pAGView, this.f82743d, this.f82744e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Function1<PAGView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f82746d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSPersonalInfo f82747e;

        c(String str, QFSPersonalInfo qFSPersonalInfo) {
            this.f82746d = str;
            this.f82747e = qFSPersonalInfo;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            QCirclePublishFeedPart.this.X = pAGView;
            QCirclePublishFeedPart.this.Y |= 4;
            QCirclePublishFeedPart.this.Da(pAGView, this.f82746d, this.f82747e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Observer<QFSPersonalInfo> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            if (qFSPersonalInfo != null) {
                QCirclePublishFeedPart qCirclePublishFeedPart = QCirclePublishFeedPart.this;
                if (qCirclePublishFeedPart.f82732b0 != null) {
                    qCirclePublishFeedPart.f82732b0 = qFSPersonalInfo.f88416c;
                    if (qCirclePublishFeedPart.va()) {
                        QCirclePublishFeedPart.this.oa(Boolean.TRUE);
                    }
                }
                if (QCirclePublishFeedPart.this.T) {
                    QCirclePublishFeedPart qCirclePublishFeedPart2 = QCirclePublishFeedPart.this;
                    qCirclePublishFeedPart2.Ma(qFSPersonalInfo, qCirclePublishFeedPart2.D, QCirclePublishFeedPart.this.E);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            if (uIStateData == null) {
                return;
            }
            int state = uIStateData.getState();
            if (state != 0) {
                if ((state == 2 || state == 3) && uIStateData.getData() != null && uIStateData.getData().publisherButton.title.has()) {
                    QCirclePublishFeedPart.this.getPartManager().broadcastMessage("polymerization_button_text", uIStateData.getData().publisherButton.get());
                    return;
                }
                return;
            }
            QLog.e("[QcirclePublish]QCirclePublishFeedPart", 1, "handleHeaderRsp() return empty data");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Observer<h.d> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable h.d dVar) {
            if (dVar == null) {
                return;
            }
            QLog.i("QCirclePublishButtonViewModel", 1, "publishButtonEvent: " + dVar);
            if (dVar.f92854a) {
                QCirclePublishFeedPart.this.ra(dVar);
                QCirclePublishFeedPart.this.ga(dVar);
            } else if (dVar.a() != -1) {
                QCirclePublishFeedPart.this.aa(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class i implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QCirclePublishFeedPart> f82757a;

        /* renamed from: b, reason: collision with root package name */
        private int f82758b;

        i(QCirclePublishFeedPart qCirclePublishFeedPart, int i3) {
            this.f82757a = new WeakReference<>(qCirclePublishFeedPart);
            this.f82758b = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            WeakReference<QCirclePublishFeedPart> weakReference = this.f82757a;
            if (weakReference != null && weakReference.get() != null) {
                return this.f82757a.get().ia(this.f82758b);
            }
            return null;
        }
    }

    public QCirclePublishFeedPart(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.H = 1;
        this.I = false;
        this.f82732b0 = feedCloudMeta$StUser;
        if (getPartHost() != null && getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_scheme") && !TextUtils.isEmpty(getActivity().getIntent().getStringExtra("key_scheme"))) {
            if (getActivity().getIntent().hasExtra(IProfileCardConst.KEY_FROM_TYPE)) {
                this.I = true;
                this.H = getActivity().getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, this.H);
            } else {
                this.I = true;
                this.H = 7;
            }
        }
    }

    private void Aa(String str) {
        String str2;
        String str3;
        Bundle bundle = new Bundle();
        bundle.putAll(getActivity().getIntent().getExtras());
        bundle.putString("xsj_ref_pgid", (String) WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        bundle.putSerializable("key_bundle_common_init_bean", qCircleInitBean);
        if (getActivity() == null || getActivity().getIntent() == null || !getActivity().getIntent().hasExtra("key_scheme")) {
            str2 = "";
        } else {
            String stringExtra = getActivity().getIntent().getStringExtra("key_scheme");
            bundle.putString("key_scheme", stringExtra);
            getActivity().getIntent().putExtra("key_scheme", "");
            str2 = stringExtra;
        }
        if (!TextUtils.isEmpty(this.S)) {
            bundle.putString("key_polymerization_scheme", this.S);
        }
        bundle.putBoolean(PeakConstants.KEY_IS_CAPSULE_BUTTON, this.L.O1());
        if (this.H == 3) {
            str3 = WinkDaTongReportConstant.ElementParamValue.XSJ_PRESET_VIDEO_OPT_IN_PROFILEPG;
        } else {
            str3 = WinkDaTongReportConstant.ElementParamValue.XSJ_PRESET_VIDEO_OPT_IN_RIGHT_UP;
        }
        bundle.putString("key_plus_entrance_location", str3);
        bundle.putBoolean("key_is_from_feed_publish", true);
        this.L.b2(Boolean.FALSE);
        Y9(bundle);
        QCircleInitBean qCircleInitBean2 = this.K;
        if ((qCircleInitBean2 instanceof QCirclePolymerizationBean) && qCircleInitBean2.getPolymerizationType() == 20 && this.K.getSimulateData() != null && !TextUtils.isEmpty(this.K.getSimulateData().simulate_schema.get())) {
            bundle.putString("key_scheme", this.K.getSimulateData().simulate_schema.get());
        }
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = this.f82736f;
        if (feedCloudMeta$StTagInfo != null) {
            bundle.putString("QQWinkDataKeys-tag_id", feedCloudMeta$StTagInfo.tagId.get());
            bundle.putString("QQWinkDataKeys-tag_name", this.f82736f.tagName.get());
            bundle.putString("QQWinkDataKeys-tag_from", la());
        }
        if (wa()) {
            com.tencent.biz.qqcircle.utils.cy.i(bundle, QQWinkConstants.WINK_PUBLISH_TASK_ID, QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE);
        } else if (va()) {
            com.tencent.biz.qqcircle.utils.cy.i(bundle, QQWinkConstants.WINK_PUBLISH_TASK_ID, "pg_xsj_profile_page");
            String ja5 = ja();
            if (!TextUtils.isEmpty(ja5)) {
                com.tencent.biz.qqcircle.utils.cy.i(bundle, "xsj_operation_activity_id", ja5);
            }
        } else if (xa()) {
            com.tencent.biz.qqcircle.utils.cy.i(bundle, QQWinkConstants.WINK_PUBLISH_TASK_ID, QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE);
            com.tencent.biz.qqcircle.utils.cy.i(bundle, "xsj_operation_activity_id", QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE);
        }
        com.tencent.biz.qqcircle.wink.e eVar = com.tencent.biz.qqcircle.wink.e.f93946a;
        if (!TextUtils.isEmpty(eVar.s().getFeedId())) {
            com.tencent.biz.qqcircle.utils.cy.i(bundle, "xsj_feed_id", eVar.s().getFeedId());
        }
        QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "jumpToPublishPage... schema:" + str2);
        bundle.putBoolean(QQWinkConstants.SHOW_DIALOG_BEFORE_JUMP, false);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", getReportBean().getDtPageId());
        buildElementParams.put("key_qcircle_report_page_id", Integer.valueOf(getReportBean().getPageId()));
        com.tencent.biz.qqcircle.wink.f.f93951a.a(getActivity(), bundle, this.H, str, buildElementParams);
        if (uq3.c.M6() && !TextUtils.isEmpty(str2)) {
            getActivity().finish();
        }
    }

    private void Ba() {
        this.L.P1().observe(getHostFragment(), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(PAGView pAGView, String str, QFSPersonalInfo qFSPersonalInfo) {
        PAGFile Load = PagViewMonitor.Load(getContext().getAssets(), str);
        if (Load != null) {
            if (pAGView == this.W) {
                if (!TextUtils.isEmpty(qFSPersonalInfo.f88437x)) {
                    PAGText textData = Load.getTextData(0);
                    textData.text = qFSPersonalInfo.f88437x;
                    ha(textData);
                    Load.replaceText(0, textData);
                }
                if (!TextUtils.isEmpty(qFSPersonalInfo.f88436w)) {
                    PAGText textData2 = Load.getTextData(1);
                    textData2.text = qFSPersonalInfo.f88436w;
                    ha(textData2);
                    Load.replaceText(1, textData2);
                }
            }
            pAGView.setComposition(Load);
            pAGView.setRepeatCount(1);
            int i3 = this.Y;
            if ((i3 >> 1) > 0 && (i3 >> 2) > 0) {
                Na();
            }
        }
    }

    private void Ea() {
        int i3;
        if (getReportBean() != null) {
            i3 = getReportBean().getPageId();
        } else {
            i3 = 0;
        }
        ra0.c.f430999a.d(i3);
    }

    private void Fa(int i3) {
        if (xa()) {
            VideoReport.setElementId(this.f82735e, "em_xsj_publish_button");
            VideoReport.setElementClickPolicy(this.f82735e, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.f82735e, ExposurePolicy.REPORT_ALL);
            return;
        }
        VideoReport.setElementId(this.f82735e, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
        i iVar = new i(this, i3);
        VideoReport.setEventDynamicParams(this.f82735e, iVar);
        VasPagView vasPagView = this.D;
        if (vasPagView != null) {
            VideoReport.setElementId(vasPagView, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
            VideoReport.setEventDynamicParams(this.D, iVar);
        }
    }

    private void Ka(QFSPersonalInfo qFSPersonalInfo) {
        if (!this.F) {
            this.f82735e.setVisibility(8);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            La(qFSPersonalInfo);
        }
    }

    private void La(QFSPersonalInfo qFSPersonalInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pag");
        String str = File.separator;
        sb5.append(str);
        sb5.append("profilepage_tooltips_animation.pag");
        String sb6 = sb5.toString();
        this.D.api().build();
        this.D.api().postAction(new b(sb6, qFSPersonalInfo));
        this.E.api().build();
        this.E.api().postAction(new c("pag" + str + "profilepage_button_animation.pag", qFSPersonalInfo));
        this.f82731a0 = qFSPersonalInfo;
        if (!this.Z) {
            this.Z = true;
            com.tencent.biz.qqcircle.utils.ah.c(qFSPersonalInfo, 101);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma(QFSPersonalInfo qFSPersonalInfo, final VasPagView vasPagView, VasPagView vasPagView2) {
        if (qFSPersonalInfo != null && vasPagView != null && vasPagView2 != null) {
            this.U = qFSPersonalInfo.C;
            this.V = qFSPersonalInfo.f88439z;
            if (qFSPersonalInfo.f88438y == 2 && ua() && !qFSPersonalInfo.f88424k) {
                Ka(qFSPersonalInfo);
            } else if (qFSPersonalInfo.f88438y == 1 && ta(qFSPersonalInfo)) {
                Ka(qFSPersonalInfo);
                getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VasPagView vasPagView3;
                        if (QCirclePublishFeedPart.this.F && (vasPagView3 = vasPagView) != null) {
                            vasPagView3.setVisibility(8);
                            QCirclePublishFeedPart.this.F = false;
                        }
                    }
                }, 7000L);
            }
            QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "\u6c14\u6ce1\u7c7b\u578b = " + qFSPersonalInfo.f88438y);
        }
    }

    private void Na() {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (QCirclePublishFeedPart.this.sa()) {
                    QCirclePublishFeedPart.this.F = true;
                    QCirclePublishFeedPart.this.W.play();
                    QCirclePublishFeedPart.this.X.play();
                    QCirclePublishFeedPart.this.Oa();
                }
            }
        }, 1480L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        ObjectAnimator ba5 = ba(this.D, "translationY", 0.0f, ImmersiveUtils.dpToPx(-48.0f), 240L, 0L);
        ObjectAnimator ba6 = ba(this.D, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 240L, 0L);
        ObjectAnimator ba7 = ba(this.D, "translationY", ImmersiveUtils.dpToPx(-48.0f), ImmersiveUtils.dpToPx(-34.0f), 160L, 1320L);
        ObjectAnimator ba8 = ba(this.D, "translationY", ImmersiveUtils.dpToPx(-34.0f), ImmersiveUtils.dpToPx(-40.0f), 120L, 1480L);
        ObjectAnimator ba9 = ba(this.D, "translationY", ImmersiveUtils.dpToPx(-40.0f), ImmersiveUtils.dpToPx(-34.0f), 600L, 1600L);
        ba9.setRepeatMode(2);
        ba9.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ba5).with(ba6).with(ba7).with(ba8).with(ba9);
        animatorSet.start();
    }

    private void Pa() {
        if (this.f82737h && !com.tencent.biz.qqcircle.f.v().z()) {
            this.f82737h = false;
            this.L.X1();
        }
    }

    private void Qa() {
        if (this.f82738i != null && this.f82739m != null) {
            boolean Z9 = Z9();
            if (o83.c.f422215a.a()) {
                if (Z9) {
                    this.f82739m.setVisibility(0);
                } else {
                    this.f82739m.setVisibility(8);
                }
            } else if (Z9) {
                this.f82738i.setVisibility(0);
            } else {
                this.f82738i.setVisibility(8);
            }
            if (Z9 && !this.f82733c0) {
                this.f82733c0 = true;
                com.tencent.biz.qqcircle.utils.k.j("exp_qq_shoot_same_video_new_link_new");
            }
        }
    }

    private void Y9(Bundle bundle) {
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_attrs")) {
            HashMap hashMap = (HashMap) getActivity().getIntent().getSerializableExtra("key_attrs");
            sa0.b.a(hashMap);
            bundle.putSerializable("key_attrs", hashMap);
            getActivity().getIntent().putExtra("key_attrs", new HashMap());
            return;
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            HashMap hashMap2 = new HashMap();
            sa0.b.a(hashMap2);
            bundle.putSerializable("key_attrs", hashMap2);
            getActivity().getIntent().putExtra("key_attrs", new HashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(h.d dVar) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        if (dVar.a() == 1) {
            arrayList.add(ObjectAnimator.ofFloat(this.R, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.R, "translationX", 0.0f, com.tencent.biz.qqcircle.utils.cx.a(80.0f)));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new a(dVar));
        animatorSet.start();
        ObjectAnimator.ofFloat(this.P, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(160L).start();
    }

    private ObjectAnimator ba(View view, String str, float f16, float f17, long j3, long j16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f16, f17);
        ofFloat.setDuration(j3);
        ofFloat.setStartDelay(j16);
        return ofFloat;
    }

    private String ca(String str) {
        if (!TextUtils.isEmpty(com.tencent.biz.qqcircle.utils.cy.k(str, "tag"))) {
            com.tencent.biz.qqcircle.wink.e eVar = com.tencent.biz.qqcircle.wink.e.f93946a;
            eVar.a("topic", com.tencent.biz.qqcircle.utils.cy.k(str, "tag"));
            return com.tencent.biz.qqcircle.utils.cy.b(str, eVar.s().getFeedId());
        }
        return str;
    }

    private void da() {
        QCircleLoadingDialog qCircleLoadingDialog = this.G;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.G.dismiss();
        }
    }

    private void ea(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_operation_activity_id", com.tencent.biz.qqcircle.utils.y.c(this.V, "taskid"));
        buildElementParams.put("xsj_material_type", com.tencent.biz.qqcircle.utils.y.a(this.V)[0]);
        buildElementParams.put("xsj_material_id", com.tencent.biz.qqcircle.utils.y.a(this.V)[1]);
        buildElementParams.put("xsj_resource_type", 7);
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(h.d dVar) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        if (dVar.a() == 1) {
            arrayList.add(ObjectAnimator.ofFloat(this.R, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.R, "translationX", com.tencent.biz.qqcircle.utils.cx.a(80.0f), 0.0f));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new h(dVar));
        animatorSet.start();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(160L);
        ofFloat.setStartDelay(160L);
        ofFloat.start();
    }

    private void ha(PAGText pAGText) {
        if (pAGText != null && !TextUtils.isEmpty(pAGText.text) && this.D != null) {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(pAGText.fontSize);
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            float measureText = textPaint.measureText(pAGText.text);
            if (measureText + ((int) (r1 * 0.35f)) > layoutParams.width) {
                if (pAGText.fontSize > 0.0f) {
                    float length = ((int) (((int) (r0 - r1)) / r2)) / pAGText.text.length();
                    float f16 = pAGText.fontSize;
                    pAGText.fontSize = (int) (f16 - ((int) (length * f16)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ia(int i3) {
        int i16;
        int i17;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VasPagView vasPagView = this.D;
        if (vasPagView != null && vasPagView.getVisibility() == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_BUBBLE, Integer.valueOf(i16 ^ 1));
        if (i3 == 0) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_BUBBLE_BUTTON, Integer.valueOf(i17));
        buildElementParams.put("xsj_publish_location", "upright");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_TASK_ID, this.U);
        buildElementParams.put("xsj_operation_activity_id", com.tencent.biz.qqcircle.utils.y.c(this.V, "taskid"));
        buildElementParams.put("xsj_material_type", com.tencent.biz.qqcircle.utils.y.a(this.V)[0]);
        buildElementParams.put("xsj_material_id", com.tencent.biz.qqcircle.utils.y.a(this.V)[1]);
        return buildElementParams;
    }

    private void initViewModel() {
        if (this.M == null) {
            this.M = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
        if (this.N == null) {
            this.N = (QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class);
        }
        this.M.g2().observe(getHostFragment(), new d());
        this.N.P.observe(getHostFragment(), new e());
        WinkPublishHelper2.INSTANCE.bindService(1, null);
    }

    private String ja() {
        HashMap<String, String> schemeAttrs;
        QCircleInitBean qCircleInitBean = this.K;
        if (qCircleInitBean == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null || !schemeAttrs.containsKey("xsj_operation_activity_id")) {
            return null;
        }
        return schemeAttrs.get("xsj_operation_activity_id");
    }

    private void ma(String str) {
        if (FastClickUtils.isFastDoubleClick("[QcirclePublish]QCirclePublishFeedPart")) {
            return;
        }
        QLog.i("[QcirclePublish]QCirclePublishFeedPart", 1, "[handleJumpToWink]");
        this.L.Z1(getPageId(), this.H);
        com.tencent.biz.qqcircle.wink.h.f93953a.a(getContext(), str, this.H, "");
        if (!com.tencent.biz.qqcircle.wink.g.f93952a.a(getActivity(), str, this.H)) {
            return;
        }
        if (!QCirclePluginInitHelper.isPeakAlive(getContext())) {
            QCirclePluginInitHelper.PreloadWink(getActivity());
        }
        Aa(str);
    }

    private void na(Object obj) {
        if (!this.I && (obj instanceof Integer)) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 1) {
                this.H = 16;
            } else if (intValue == 6) {
                this.H = 17;
            } else if (intValue == 4) {
                this.H = 18;
            }
            QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "[handleNewLayerTabChangedEvent]... type:", Integer.valueOf(intValue), " fromType:", Integer.valueOf(this.H));
        }
    }

    private void pa(Object obj) {
        if (!this.I && (obj instanceof Integer)) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 1) {
                this.H = 1;
            } else if (intValue == 6) {
                this.H = 2;
            } else if (intValue == 4) {
                this.H = 15;
            }
            QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "[handleTabChangedEvent]... type:", Integer.valueOf(intValue), " fromType:", Integer.valueOf(this.H));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(h.d dVar) {
        URLImageView uRLImageView = (URLImageView) this.f82734d.findViewById(R.id.f29620m5);
        this.P = uRLImageView;
        uRLImageView.setVisibility(0);
        com.tencent.biz.qqcircle.immersive.manager.d.c().i(this.P, R.drawable.qcircle_skin_feed_btn_add_operation);
        Drawable drawable = dVar.f92859f;
        if (drawable != null) {
            this.P.setImageDrawable(drawable);
        }
        if (dVar.a() == 1) {
            ViewGroup viewGroup = (ViewGroup) ((ViewStub) this.f82734d.findViewById(R.id.f31070q2)).inflate();
            this.Q = viewGroup;
            View findViewById = viewGroup.findViewById(R.id.f29700mc);
            this.R = findViewById;
            NinePatchDrawable ninePatchDrawable = dVar.f92858e;
            if (ninePatchDrawable != null) {
                findViewById.setBackgroundDrawable(ninePatchDrawable);
            }
            TextView textView = (TextView) this.Q.findViewById(R.id.f29730mf);
            TextView textView2 = (TextView) this.Q.findViewById(R.id.f29740mg);
            String url = QCircleSkinHelper.getInstance().getUrl(dVar.f92855b);
            if (!TextUtils.isEmpty(url)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = ContextCompat.getDrawable(getContext(), R.drawable.qcircle_skin_icon_general_hashtag_ghost);
                ((URLImageView) this.Q.findViewById(R.id.f29600m3)).setImageDrawable(URLDrawable.getDrawable(url, obtain));
            }
            textView.setText(dVar.f92856c);
            textView2.setText(dVar.f92857d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sa() {
        PAGView pAGView;
        PAGView pAGView2 = this.X;
        if (pAGView2 != null && !pAGView2.isPlaying() && (pAGView = this.W) != null && !pAGView.isPlaying() && !this.F) {
            return true;
        }
        return false;
    }

    private boolean ta(QFSPersonalInfo qFSPersonalInfo) {
        if (f82730d0.e("qfs_personal_cur_has_show_material_bubble", Integer.MIN_VALUE) != qFSPersonalInfo.E) {
            return true;
        }
        return false;
    }

    private boolean ua() {
        if (va() || f82730d0.c("qfs_personal_has_show_new_user_bubble", false)) {
            return false;
        }
        return true;
    }

    private void za(String str) {
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new g(str), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_PUBLISH_FEED), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    public void Ca() {
        View view = this.f82735e;
        if (view != null) {
            view.performClick();
        }
    }

    public void Ga(int i3) {
        if (!this.I) {
            this.H = i3;
        }
    }

    public void Ha(QCircleInitBean qCircleInitBean) {
        this.K = qCircleInitBean;
    }

    public void Ia(String str) {
        this.S = str;
    }

    public void Ja(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        this.f82736f = feedCloudMeta$StTagInfo;
    }

    public boolean Z9() {
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel;
        UIStateData<QQCircleFeedBase$StFeedListBusiRspData> value;
        if (!this.C || (qCirclePolymerizationViewModel = this.N) == null || (value = qCirclePolymerizationViewModel.P.getValue()) == null) {
            return false;
        }
        int state = value.getState();
        if (state != 2 && state != 3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePublishButtonEvent.class);
        arrayList.add(QFSPageSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "[QcirclePublish]QCirclePublishFeedPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.b
    public int getPageId() {
        if (this.mReportBean != null) {
            return QCircleReportBean.getPageId(getTAG(), this.mReportBean);
        }
        if (this.J != null) {
            return QCircleReportBean.getPageId(getTAG(), this.J.getReportBean());
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b
    protected int getParentPageId() {
        if (this.mReportBean != null) {
            return QCircleReportBean.getParentPageId(getTAG(), this.mReportBean);
        }
        if (this.J != null) {
            return QCircleReportBean.getParentPageId(getTAG(), this.J.getReportBean());
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "tab_changed")) {
            pa(obj);
            return;
        }
        if (TextUtils.equals(str, "tab_changed_new_layer")) {
            na(obj);
            return;
        }
        if (TextUtils.equals(str, "tab_rsp")) {
            qa(obj);
            return;
        }
        if (TextUtils.equals(str, "publish_show_or_hide")) {
            oa(obj);
            return;
        }
        if (TextUtils.equals(str, "publish_on_click")) {
            Ca();
            return;
        }
        if (TextUtils.equals(str, "show_publish_feed_guide_bubble")) {
            Pa();
            return;
        }
        if (TextUtils.equals(str, "personal_detail_show_publish")) {
            oa(obj);
            this.T = ((Boolean) obj).booleanValue();
            return;
        }
        if (TextUtils.equals(str, "polymerization_button_text")) {
            QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton = (QQCircleFeedBase$StPublisherButton) obj;
            Qa();
            QCirclePolymerizationBottomButton qCirclePolymerizationBottomButton = this.f82738i;
            if (qCirclePolymerizationBottomButton != null) {
                qCirclePolymerizationBottomButton.setData(qQCircleFeedBase$StPublisherButton);
            }
            QCircleAggregationPublishButtonExp qCircleAggregationPublishButtonExp = this.f82739m;
            if (qCircleAggregationPublishButtonExp != null) {
                qCircleAggregationPublishButtonExp.setData(qQCircleFeedBase$StPublisherButton);
                return;
            }
            return;
        }
        if (TextUtils.equals(str, "publish_entrance_dialog_close")) {
            da();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_publish_entrance_show");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String la() {
        return "0";
    }

    void oa(Object obj) {
        if (!(obj instanceof Boolean)) {
            return;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (!QCirclePluginUtil.isOwner(this.f82732b0)) {
            return;
        }
        if (wa()) {
            this.C = booleanValue;
            Qa();
            return;
        }
        if (this.f82735e != null) {
            int i3 = 0;
            if (!com.tencent.biz.qqcircle.helpers.d.a(1, false)) {
                boolean isRequestSecurityHit = true ^ QCirclePluginUtil.isRequestSecurityHit(this.M.j2().f());
                View view = this.f82735e;
                if (!booleanValue || !isRequestSecurityHit) {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (256 == i3) {
            QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "doOnActivityResult\uff0creturn from qzone publish page");
            QCircleReportHelper.getInstance().recordPageEndShow(36, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String traceId = QCirclePublishQualityReporter.getTraceId();
        int id5 = view.getId();
        if (id5 != R.id.f29710md && id5 != R.id.f99415pq) {
            if (id5 == R.id.f29720me) {
                Fa(2);
                za(traceId);
            } else if (id5 == R.id.ypy || id5 == R.id.f166105yq1 || id5 == R.id.f29610m4 || id5 == R.id.tjw) {
                if (id5 == R.id.f29610m4 || id5 == R.id.tjw) {
                    Fa(0);
                    com.tencent.biz.qqcircle.utils.ah.c(this.f82731a0, 102);
                }
                if (!TextUtils.isEmpty(this.S)) {
                    com.tencent.biz.qqcircle.launcher.c.g(getActivity(), ca(com.tencent.biz.qqcircle.utils.cy.a(this.S, traceId)));
                } else {
                    com.tencent.biz.qqcircle.wink.e.f93946a.b();
                    ((IReportApi) QRoute.api(IReportApi.class)).updateTaskId("pg_xsj_profile_page");
                    ma(traceId);
                }
            }
        } else {
            Fa(1);
            com.tencent.biz.qqcircle.utils.ah.c(this.f82731a0, 102);
            za(traceId);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ViewStub viewStub;
        super.onInitView(view);
        this.f82734d = view;
        this.L = (com.tencent.biz.qqcircle.viewmodels.h) getViewModel(com.tencent.biz.qqcircle.viewmodels.h.class);
        if (wa()) {
            viewStub = (ViewStub) view.findViewById(R.id.f502024r);
        } else {
            viewStub = (ViewStub) view.findViewById(R.id.f502124s);
        }
        View inflate = viewStub.inflate();
        View findViewById = inflate.findViewById(R.id.f29610m4);
        this.f82735e = findViewById;
        findViewById.setOnClickListener(this);
        VasPagView vasPagView = (VasPagView) inflate.findViewById(R.id.f99415pq);
        this.D = vasPagView;
        vasPagView.setOnClickListener(this);
        VasPagView vasPagView2 = (VasPagView) inflate.findViewById(R.id.tjw);
        this.E = vasPagView2;
        vasPagView2.setOnClickListener(this);
        if (QCirclePluginUtil.isOwner(this.f82732b0) && !com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            this.f82735e.setVisibility(0);
            View view2 = this.f82735e;
            if ((view2 instanceof ImageView) && ((ImageView) view2).getDrawable() == null) {
                com.tencent.biz.qqcircle.immersive.manager.d.c().i(this.f82735e, R.drawable.nce);
            }
        } else {
            this.f82735e.setVisibility(8);
        }
        Fa(0);
        if (this.G == null) {
            this.G = new QCircleLoadingDialog(getContext());
        }
        Ba();
        if (wa()) {
            this.f82735e.setVisibility(8);
            this.f82738i = (QCirclePolymerizationBottomButton) view.findViewById(R.id.ypy);
            this.f82739m = (QCircleAggregationPublishButtonExp) view.findViewById(R.id.f166105yq1);
            Qa();
            ea(this.f82738i);
            ea(this.f82739m);
            this.f82738i.setOnClickListener(this);
            this.f82739m.setOnClickListener(this);
        }
        initViewModel();
        com.tencent.biz.qqcircle.wink.e.f93946a.c();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        Ea();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f82737h = true;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        da();
        this.L.S1();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        com.tencent.biz.qqcircle.viewmodels.h hVar;
        if (simpleBaseEvent instanceof QCirclePublishButtonEvent) {
            this.L.T1((QCirclePublishButtonEvent) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSPageSelectEvent) && (hVar = this.L) != null) {
            hVar.a2(getPageId(), this.H);
        }
    }

    void qa(Object obj) {
        if (obj instanceof FeedCloudMeta$StTagInfo) {
            this.f82736f = (FeedCloudMeta$StTagInfo) obj;
        }
    }

    public boolean va() {
        return getHostFragment() instanceof QFSPersonalDetailsFragment;
    }

    public boolean wa() {
        return getHostFragment() instanceof QCirclePolymerizationFragment;
    }

    public boolean xa() {
        return getHostFragment() instanceof QFSPublicAccountStaggerFragment;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.J;
        if (aVar != null) {
            return aVar.getReportBean();
        }
        return super.getReportBean();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.ak {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.d f82741d;

        a(h.d dVar) {
            this.f82741d = dVar;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QCirclePublishFeedPart.this.P != null) {
                QCirclePublishFeedPart.this.P.setVisibility(4);
            }
            if (this.f82741d.a() == 1 && QCirclePublishFeedPart.this.R != null) {
                QCirclePublishFeedPart.this.R.setVisibility(4);
            }
            QCirclePublishFeedPart qCirclePublishFeedPart = QCirclePublishFeedPart.this;
            qCirclePublishFeedPart.L.a2(qCirclePublishFeedPart.getPageId(), QCirclePublishFeedPart.this.H);
            QCirclePublishFeedPart.this.L.U1();
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f82741d.a() == 1 && QCirclePublishFeedPart.this.Q != null) {
                QCirclePublishFeedPart.this.Q.setClipToPadding(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends com.tencent.mobileqq.widget.ak {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.d f82754d;

        /* loaded from: classes4.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QCircleHostLauncher.doJumpAction(QCirclePublishFeedPart.this.getContext(), h.this.f82754d.f92860g);
                QCirclePublishFeedPart.this.L.N1();
                QCirclePublishFeedPart.this.L.b2(Boolean.TRUE);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        h(h.d dVar) {
            this.f82754d = dVar;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f82754d.a() == 1 && QCirclePublishFeedPart.this.Q != null) {
                QCirclePublishFeedPart.this.Q.setClipToPadding(false);
            }
            a aVar = new a();
            QCirclePublishFeedPart.this.P.setOnClickListener(aVar);
            if (this.f82754d.a() == 1 && QCirclePublishFeedPart.this.R != null) {
                QCirclePublishFeedPart.this.R.setOnClickListener(aVar);
            }
            QCirclePublishFeedPart.this.L.W1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82752a;

        g(String str) {
            this.f82752a = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QFSPersonalInfo value = QCirclePublishFeedPart.this.M.g2().getValue();
            if (value != null && value.f88438y == 1) {
                QCirclePublishFeedPart.f82730d0.m("qfs_personal_cur_has_show_material_bubble", value.E);
            }
            if (!TextUtils.isEmpty(QCirclePublishFeedPart.this.V) && QCirclePublishFeedPart.this.getActivity() != null) {
                com.tencent.biz.qqcircle.launcher.c.g(QCirclePublishFeedPart.this.getActivity(), com.tencent.biz.qqcircle.utils.cy.a(QCirclePublishFeedPart.this.V, this.f82752a) + com.tencent.biz.qqcircle.utils.y.b(QCirclePublishFeedPart.this.V, 7));
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
        }
    }
}
