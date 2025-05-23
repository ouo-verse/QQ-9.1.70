package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MateActivityUIStyle;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.event.WinkNoSaveEvent;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.fs.activity.FSUploadActivityFragment;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.wink.publish.util.PublishTagCounter;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.LbsDataV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes21.dex */
public class PublishTitlePart extends j implements View.OnClickListener, SimpleEventReceiver {
    public static final String I = UploadConstants.TAG + "FSTitlePart";
    private ImageView C;
    private TextView D;
    private ImageView E;
    private QCircleCommonLoadingDialog F;
    protected ActionSheet G;
    private PhotoListLogicPreDealDialog H;

    /* renamed from: d, reason: collision with root package name */
    private boolean f325770d = false;

    /* renamed from: e, reason: collision with root package name */
    private PublishViewModel f325771e;

    /* renamed from: f, reason: collision with root package name */
    private PartsStateViewModel f325772f;

    /* renamed from: h, reason: collision with root package name */
    private PublishPromotionViewModel f325773h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.multiselect.a f325774i;

    /* renamed from: m, reason: collision with root package name */
    private PublishTagViewModel f325775m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            if (PublishTitlePart.this.E != null) {
                PublishTitlePart.this.E.setEnabled(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements Observer<TaskInfo> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(TaskInfo taskInfo) {
            if (PublishTitlePart.this.H != null && PublishTitlePart.this.H.t()) {
                if (taskInfo.isFinish()) {
                    if (taskInfo.isSuccess()) {
                        if (PublishTitlePart.this.getContext() != null) {
                            QCircleToast.k(QCircleToast.f91644d, PublishTitlePart.this.getContext().getResources().getString(R.string.f216285xw), 0, true);
                        }
                        try {
                            PublishTitlePart.this.getActivity().getIntent().putExtra(QQWinkConstants.TASKINFO, taskInfo);
                            WinkContext.INSTANCE.d().m().k(PublishTitlePart.this.getActivity(), OutputData.INSTANCE.a(64L, PublishTitlePart.this.f325771e.D, PublishTitlePart.this.getActivity().getIntent()));
                        } catch (Exception e16) {
                            w53.b.e(PublishTitlePart.I, e16);
                        }
                    } else {
                        if (PublishTitlePart.this.getContext() != null) {
                            QCircleToast.k(QCircleToast.f91644d, PublishTitlePart.this.getContext().getResources().getString(R.string.f216215xp), 0, true);
                        }
                        PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
                    }
                    PublishTitlePart.this.H.m();
                    return;
                }
                if (taskInfo.isCancelled()) {
                    if (PublishTitlePart.this.getContext() != null) {
                        QCircleToast.k(QCircleToast.f91644d, PublishTitlePart.this.getContext().getResources().getString(R.string.f216165xk), 0, true);
                    }
                    PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
                    PublishTitlePart.this.H.m();
                    return;
                }
                if (taskInfo.isNetworkWaiting()) {
                    if (PublishTitlePart.this.getContext() != null) {
                        QCircleToast.k(QCircleToast.f91644d, PublishTitlePart.this.getContext().getResources().getString(R.string.f216225xq), 0, true);
                    }
                    PublishTitlePart.this.f325771e.S1();
                    PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
                    PublishTitlePart.this.H.m();
                    return;
                }
                PublishTitlePart.this.H.L((taskInfo.getUploadProgress() / 2) + (taskInfo.getExportProgress() / 2));
                return;
            }
            w53.b.c(PublishTitlePart.I, "publishProgressDialog status error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PublishTitlePart.this.H.m();
            PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
            PublishTitlePart.this.f325771e.S1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements PhotoListLogicPreDealDialog.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog.a
        public void onBackPressed() {
            PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
            PublishTitlePart.this.f325771e.S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f325783d;

        e(int i3) {
            this.f325783d = i3;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            FragmentActivity activity = PublishTitlePart.this.getHostFragment().getActivity();
            if (activity != null) {
                PublishTitlePart publishTitlePart = PublishTitlePart.this;
                if (publishTitlePart.G != null) {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            if (this.f325783d != 3 && !publishTitlePart.da() && !PublishTitlePart.this.aa()) {
                                QLog.i(PublishTitlePart.I, 1, "[CancelActionSheet]1, save draft and close");
                                PublishTitlePart publishTitlePart2 = PublishTitlePart.this;
                                publishTitlePart2.V9(WinkDaTongReportConstant.ElementId.EM_XSJ_SAVE_RETURN, publishTitlePart2.C);
                                if (PublishTitlePart.this.f325771e.v2()) {
                                    if (!PublishTitlePart.this.f325771e.C2()) {
                                        FSToastUtil.makeTextAndShow(PublishTitlePart.this.getActivity().getResources().getString(R.string.f196754i6), 1);
                                    }
                                    PublishTitlePart.this.f325771e.t3(PublishTitlePart.this.getHostFragment(), 1);
                                    PublishTitlePart.this.ma(new WinkPublishQualityReportData.Builder().eventId("E_PUBLIC_EXIT_CANCEL").traceId(PublishTitlePart.this.f325771e.f326005g0).retCode(String.valueOf(0L)).ext1("save").getReportData(), 1);
                                    PublishTitlePart.this.T9();
                                } else {
                                    PublishTitlePart.this.f325771e.p3(WinkCommonUtil.getCurrentAccountLong());
                                    FSToastUtil.makeTextAndShow(PublishTitlePart.this.getActivity().getResources().getString(R.string.vyq), 1);
                                }
                            } else {
                                QLog.i(PublishTitlePart.I, 1, "[CancelActionSheet]1, close");
                                SimpleEventBus.getInstance().dispatchEvent(new WinkNoSaveEvent());
                                PublishTitlePart.this.T9();
                            }
                        }
                    } else if (this.f325783d == 3) {
                        QLog.i(PublishTitlePart.I, 1, "[CancelActionSheet]0, from draft");
                        if (PublishTitlePart.this.f325771e.v2()) {
                            if (!PublishTitlePart.this.f325771e.C2()) {
                                FSToastUtil.makeTextAndShow(PublishTitlePart.this.getActivity().getResources().getString(R.string.f196754i6), 1);
                            }
                            PublishTitlePart.this.f325771e.b3();
                            PublishTitlePart.this.f325771e.t3(PublishTitlePart.this.getHostFragment(), 1);
                            PublishTitlePart.this.ma(new WinkPublishQualityReportData.Builder().eventId("E_PUBLIC_EXIT_CANCEL").traceId(PublishTitlePart.this.f325771e.f326005g0).retCode(String.valueOf(0L)).ext1("save").getReportData(), 1);
                            PublishTitlePart.this.T9();
                        } else {
                            PublishTitlePart.this.f325771e.p3(WinkCommonUtil.getCurrentAccountLong());
                            FSToastUtil.makeTextAndShow(PublishTitlePart.this.getActivity().getResources().getString(R.string.vyq), 1);
                        }
                    } else {
                        QLog.i(PublishTitlePart.I, 1, "[CancelActionSheet]0, back to editor");
                        PublishTitlePart.this.f325771e.H.removeObservers(PublishTitlePart.this.getHostFragment());
                        PublishTitlePart publishTitlePart3 = PublishTitlePart.this;
                        publishTitlePart3.V9("em_xsj_return_edit", publishTitlePart3.C);
                        String str = ((FSUploadActivityFragment) PublishTitlePart.this.getHostFragment()).F;
                        String str2 = PublishTitlePart.this.f325771e.M;
                        if (!PublishTitlePart.this.aa()) {
                            if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                                PublishTitlePart.this.f325771e.w3(PublishTitlePart.this.getHostFragment(), 1, false);
                            } else {
                                PublishTitlePart.this.f325771e.t3(PublishTitlePart.this.getHostFragment(), 1);
                            }
                        }
                        PublishTitlePart.this.f325771e.f326001c0 = true;
                        if (PublishTitlePart.this.getPartManager().getPart(af.class.getName()) != null) {
                            ((af) PublishTitlePart.this.getPartManager().getPart(af.class.getName())).Q9();
                        }
                        activity.finish();
                    }
                    String i26 = PublishTitlePart.this.f325771e.i2();
                    QLog.i(PublishTitlePart.I, 1, "User cancel with video edit in progress. missionId=" + i26);
                    com.tencent.mobileqq.wink.editor.export.j.t().i();
                    PublishTitlePart.this.f325771e.S1();
                    PublishTitlePart.this.G.superDismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog S9() {
        if (this.F == null) {
            this.F = new QCircleCommonLoadingDialog.c(getContext()).p(getContext().getString(R.string.f240487pa)).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.br
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishTitlePart.this.ea(view);
                }
            }).d(new Callable() { // from class: com.tencent.mobileqq.wink.publish.part.bs
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean ga5;
                    ga5 = PublishTitlePart.this.ga();
                    return ga5;
                }
            }).a();
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9() {
        if (getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1) == 10) {
            Intent intent = new Intent();
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, true, 0, intent));
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent());
    }

    private void U9(String str) {
        Activity activity = getActivity();
        if (activity == null) {
            this.E.setImageResource(R.drawable.m5o);
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            this.E.setImageResource(R.drawable.m5o);
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.KEY_MATE_ACTIVITY_UI_STYLE);
        if (this.f325771e.x2() && !TextUtils.isEmpty(str)) {
            this.E.setImageResource(R.drawable.m5o);
            return;
        }
        if (serializableExtra instanceof MateActivityUIStyle) {
            MateActivityUIStyle mateActivityUIStyle = (MateActivityUIStyle) serializableExtra;
            if (mateActivityUIStyle.getPublishBtnText() != null) {
                this.D.setText(mateActivityUIStyle.getPublishBtnText());
            }
            if (!TextUtils.isEmpty(mateActivityUIStyle.getPublishBtnBg())) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int[] btnPlaceHolderColors = mateActivityUIStyle.getBtnPlaceHolderColors();
                if (btnPlaceHolderColors != null && btnPlaceHolderColors.length > 0) {
                    obtain.mLoadingDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, btnPlaceHolderColors);
                } else {
                    obtain.mLoadingDrawable = ContextCompat.getDrawable(getContext(), R.drawable.m5o);
                }
                obtain.mFailedDrawable = ContextCompat.getDrawable(getContext(), R.drawable.m5o);
                this.E.setImageDrawable(URLDrawable.getDrawable(mateActivityUIStyle.getPublishBtnBg(), obtain));
                return;
            }
            this.E.setImageResource(R.drawable.m5o);
            return;
        }
        this.E.setImageResource(R.drawable.m5o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9(String str, View view) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(WinkContext.INSTANCE.d().getDtParams().a());
        buildElementParams.put("xsj_operation_activity_id", WinkDatongCurrentParams.get("xsj_operation_activity_id"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
        buildElementParams.put("xsj_eid", str);
        com.tencent.mobileqq.wink.publish.b.f325659a.a(getActivity().getIntent(), buildElementParams);
        VideoReport.reportEvent("ev_xsj_camera_action", view, buildElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.tencent.biz.richframework.part.Part, com.tencent.mobileqq.wink.publish.part.PublishTitlePart] */
    /* JADX WARN: Type inference failed for: r2v109, types: [com.tencent.mobileqq.wink.publish.b] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v186 */
    /* JADX WARN: Type inference failed for: r2v187 */
    /* JADX WARN: Type inference failed for: r2v198 */
    /* JADX WARN: Type inference failed for: r2v199 */
    /* JADX WARN: Type inference failed for: r2v200 */
    /* JADX WARN: Type inference failed for: r2v201 */
    /* JADX WARN: Type inference failed for: r2v202 */
    /* JADX WARN: Type inference failed for: r2v203 */
    /* JADX WARN: Type inference failed for: r2v204 */
    /* JADX WARN: Type inference failed for: r2v205 */
    /* JADX WARN: Type inference failed for: r2v206 */
    /* JADX WARN: Type inference failed for: r2v209 */
    /* JADX WARN: Type inference failed for: r2v210, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v211 */
    /* JADX WARN: Type inference failed for: r2v215 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91, types: [java.lang.Object] */
    private void W9(BasePartFragment basePartFragment, JSONObject jSONObject, boolean z16) {
        Map buildElementParams = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(this.E, "em_xsj_publish_button");
        buildElementParams.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        buildElementParams.putAll(WinkDatongCurrentParams.getMap());
        if (buildElementParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT) == null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, 1);
        }
        LbsDataV2.PoiInfo poiInfo = ((com.tencent.mobileqq.wink.publish.viewmodel.o) basePartFragment.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.o.class)).G;
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_POI, Integer.valueOf(poiInfo == null ? 0 : 1));
        String str = ((PublishViewModel) basePartFragment.getViewModel(PublishViewModel.class)).M;
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TOPIC_COLLECTION, TagRetriever.f326413a.d(str));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_TOPIC, Integer.valueOf((TextUtils.isEmpty(str) || !str.contains("#")) ? 0 : 1));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_CONTENT, Integer.valueOf(!TextUtils.isEmpty(str) ? 1 : 0));
        boolean z17 = ((com.tencent.mobileqq.wink.publish.viewmodel.r) basePartFragment.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.r.class)).f326066m;
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, Integer.valueOf(z17 ? 1 : 0));
        boolean S9 = ((com.tencent.mobileqq.wink.publish.part.c) getPartManager().getPart(com.tencent.mobileqq.wink.publish.part.c.class.getName())).S9();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SAVE, Integer.valueOf(S9 ? 1 : 0));
        buildElementParams.put("xsj_set_download_end_status", Integer.valueOf(!this.f325771e.E2() ? 1 : 0));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_LENGTH, String.valueOf(getActivity().getIntent().getLongExtra(QQWinkConstants.MEDIA_DURATION, 0L)));
        boolean z18 = ((PublishViewModel) basePartFragment.getViewModel(PublishViewModel.class)).f326002d0;
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_COVER_IS_CHANGE, Integer.valueOf(z18 ? 1 : 0));
        int Z9 = Z9(basePartFragment);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_PUBLIC, Integer.valueOf(Z9));
        int intExtra = getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_DRAFTS, Integer.valueOf(intExtra == 3 ? 1 : 0));
        if (intExtra == 1) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BEAUTY_LOCATION, getActivity().getIntent().getBooleanExtra("AECAMERA_TAB_ALBUM_ENTRANCE", true) ? "bottom" : "upright");
        }
        buildElementParams.put("xsj_eid", "em_xsj_publish_button");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, ((PublishViewModel) basePartFragment.getViewModel(PublishViewModel.class)).f326019s0 ? "1" : "0");
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
        if (this.f325771e.H2()) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_HD_IS_ON, Boolean.valueOf(this.f325771e.J2()));
        }
        Y9(buildElementParams);
        X9(buildElementParams);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_LYRICS, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_LYRICS));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_FORM_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_FORM_ID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_PATTERN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_PATTERN_ID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_ART_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_ART_ID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE));
        if ("1".equals(WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE))) {
            w53.b.a(I, "XSJ_IS_IMAGE_ENHANCE " + com.tencent.mobileqq.wink.editor.hdr.a.g());
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DEMOTON_IMAGE_ENHANCE, com.tencent.mobileqq.wink.editor.hdr.a.g() ? "1" : "0");
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_NULL, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_NULL).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_BORDER, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_BORDER).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_PURE_COLOR, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_PURE_COLOR).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TRANSLUCENCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TRANSLUCENCE).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TEXT, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TEXT).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_SUBTITLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_SUBTITLE).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_STYLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_STYLE).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_DECORATE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_DECORATE).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_HUAZI, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_HUAZI).equals("1") ? "1" : "0");
        if (WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE) != null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE));
            buildElementParams.put("xsj_text_content", WinkDatongCurrentParams.get("xsj_text_content"));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH));
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_TRACK, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_TRACK).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHAR_TRACK, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHAR_TRACK).equals("1") ? "1" : "0");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_VALUE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_VALUE));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_TST_READ, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME).equals("") ? "0" : "1");
        buildElementParams.put("xsj_background_id", WinkDatongCurrentParams.get("xsj_background_id"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID));
        HashMap<String, Object> hashMap = WinkDatongCurrentParams.params;
        if (hashMap != null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM));
        }
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            HashMap hashMap2 = (HashMap) serializableExtra;
            String str2 = (String) hashMap2.get("xsj_camera_is_from_topic_edit_button");
            if (!TextUtils.isEmpty(str2)) {
                buildElementParams.put("xsj_camera_is_from_topic_edit_button", str2);
            }
            String str3 = (String) hashMap2.get(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE);
            if (!TextUtils.isEmpty(str3)) {
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SHARE_TYPE, str3);
            }
        }
        String stringExtra = getActivity().getIntent().getStringExtra("key_scheme");
        QLog.d(I, 1, "doPublishDTReport, schema: " + stringExtra);
        buildElementParams.put("xsj_url", stringExtra);
        com.tencent.mobileqq.wink.publish.b.f325659a.a(getActivity().getIntent(), buildElementParams);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MUSIC_FROM_SEARCH, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MUSIC_FROM_SEARCH));
        buildElementParams.put("xsj_query_text", WinkDatongCurrentParams.get("xsj_query_text"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SEARCH_QUERY_SOURCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SEARCH_QUERY_SOURCE));
        Pair<PromotionParams, PublishPromotionViewModel.PromotionSource> value = this.f325773h.c2().getValue();
        if (value != null && value.getFirst() != null) {
            buildElementParams.put("xsj_business_ad_id", value.getFirst().getReportId());
        }
        if (!TextUtils.isEmpty(this.f325771e.f326007i.getValue())) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CAMPUS_OPEN, Integer.valueOf(this.f325772f.l2().getValue().getIsSelected() ? 1 : 0));
        } else {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CAMPUS_OPEN, null);
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_FROM_LBS_CHECK_BUTTON, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_FROM_LBS_CHECK_BUTTON));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE));
        buildElementParams.put("xsj_feed_id", WinkDatongCurrentParams.get("xsj_feed_id"));
        k93.b value2 = ((com.tencent.mobileqq.wink.publish.viewmodel.u) basePartFragment.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.u.class)).f326072i.getValue();
        if (value2 != null) {
            buildElementParams.put("xsj_task_id", value2.f411915b);
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SUBTITLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SUBTITLE));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_BILINGUAL_SUBTITLE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_BILINGUAL_SUBTITLE));
        Map<String, String> b16 = com.tencent.mobileqq.wink.report.f.f326266a.b(getActivity());
        if (b16 != null && !b16.isEmpty()) {
            buildElementParams.putAll(b16);
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        buildElementParams.put("xsj_template_id", WinkDatongCurrentParams.get("xsj_template_id"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME));
        if (this.f325771e.o2().getValue().intValue() == 1) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FEED_LABEL_NAME, "original");
        } else if (this.f325771e.o2().getValue().intValue() == 2) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FEED_LABEL_NAME, WinkDaTongReportConstant.ElementParamValue.REPRINT);
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        try {
            if (getActivity() != null && getActivity().getIntent() != null) {
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, getActivity().getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
            }
        } catch (Exception e16) {
            QLog.i(I, 1, "doPublishDTReport error " + e16.getMessage());
            e16.printStackTrace();
        }
        buildElementParams.put("xsj_material_type", WinkDatongCurrentParams.get("xsj_material_type"));
        buildElementParams.put("xsj_material_id", WinkDatongCurrentParams.get("xsj_material_id"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SOURCE_LOCATION, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SOURCE_LOCATION));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RECOMMEND_CARD_RATE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_RECOMMEND_CARD_RATE));
        Object obj = WinkDatongCurrentParams.get("xsj_guide_text");
        buildElementParams.put("xsj_guide_text", obj);
        buildElementParams.put("xsj_operation_activity_id", WinkDatongCurrentParams.get("xsj_operation_activity_id"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NUM));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QQ_EXPRESSION_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QQ_EXPRESSION_NUM));
        if (this.f325771e.C.getValue() != null) {
            buildElementParams.put("xsj_picture_num", Integer.valueOf(this.f325771e.C.getValue().size()));
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL));
        PublishTagCounter.Companion companion = PublishTagCounter.INSTANCE;
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TOPIC_NUM, Integer.valueOf(companion.a().getTagNum()));
        String str4 = I;
        QLog.i(str4, 1, "publish tag num: " + companion.a().getTagNum());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID));
        try {
            if (getActivity() != null && getActivity().getIntent() != null) {
                String stringExtra2 = getActivity().getIntent().getStringExtra(QQWinkConstants.CAPTURE_MATERIAL_SCORE);
                if (stringExtra2 != null && !TextUtils.isEmpty(stringExtra2)) {
                    buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_SCORE, stringExtra2);
                }
                QLog.i(str4, 1, "doPublishDTReport score " + stringExtra2);
            }
        } catch (Exception e17) {
            QLog.i(I, 1, "doPublishDTReport error " + e17.getMessage());
            e17.printStackTrace();
        }
        if (this.f325771e.h2() != null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTONOMOUS_DECLARE_OPTION, this.f325771e.h2().getId());
        }
        if (!TextUtils.isEmpty(this.f325775m.tagsFromChallenge)) {
            buildElementParams.put("xsj_challenge_topic", this.f325775m.tagsFromChallenge);
        }
        if (z16) {
            VideoReport.reportEvent("ev_xsj_abnormal_imp", this.E, buildElementParams);
        } else {
            VideoReport.reportEvent("ev_xsj_camera_action", this.E, buildElementParams);
        }
        ta(jSONObject, poiInfo, str, z17, S9, z18, Z9, obj);
    }

    private void X9(Map<String, Object> map) {
        PublishTroopViewModel.TroopInfo troopInfo = this.f325771e.G0;
        if (troopInfo == null) {
            return;
        }
        map.put("xsj_publish_source_id", String.valueOf(troopInfo.getTroopId()));
        map.put("xsj_publish_source", 3);
        map.put("xsj_publish_source_name", this.f325771e.G0.getTroopName());
    }

    private void Y9(Map<String, Object> map) {
        HashMap hashMap;
        String str;
        int i3;
        Long l3;
        if (!i93.c.INSTANCE.a(getActivity().getIntent()) || (hashMap = (HashMap) getActivity().getIntent().getSerializableExtra("key_attrs")) == null) {
            return;
        }
        String str2 = (String) hashMap.get("taskid");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f325771e.F0) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_SOURCE_BUTTON_TURN, str);
        if (QCircleScheme.AttrQQPublish.BUSINESS_TROOP.equals(str2)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        map.put("xsj_publish_source", Integer.valueOf(i3));
        if (this.f325771e.C0.longValue() == 0) {
            l3 = this.f325771e.B0;
        } else {
            l3 = this.f325771e.C0;
        }
        map.put("xsj_publish_source_id", String.valueOf(l3));
        map.put("xsj_publish_source_name", this.f325771e.E0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa() {
        if (getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1) == 7) {
            return true;
        }
        return false;
    }

    private boolean ba() {
        if (!"1".equals(WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.SHOW_PUBLISH_EXIT_DIALOG)) && (this.f325771e.D2() || !this.f325771e.v2())) {
            return false;
        }
        return true;
    }

    private boolean ca() {
        if (uq3.c.Q3() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean da() {
        String str;
        MetaMaterial metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (metaMaterial != null && (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) != null) {
            return str.equals(QQWinkConstants.BUSINESS_ZSHOW_NAME);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i(I, 1, "[sendMood] dialog canceled");
        this.f325771e.I.setValue(Boolean.FALSE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean ga() throws Exception {
        QLog.i(I, 1, "[sendMood] dialog back pressed");
        this.f325771e.I.setValue(Boolean.FALSE);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(Runnable runnable, WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        String str = I;
        QLog.d(str, 1, "[onClick] service connected");
        ThreadManagerV2.removeJob(runnable, 16);
        if (this.f325770d) {
            return;
        }
        WinkPublishServiceReporter.reportOperation(11, 1, true);
        if (!this.f325771e.I.getValue().booleanValue()) {
            QLog.i(str, 1, "[onClick] send mood canceled");
        } else {
            S9().hide();
            sa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit ia(int i3, WinkDc5507ReportData.a aVar) {
        aVar.b(1006);
        aVar.j(Integer.valueOf(i3));
        return null;
    }

    private void ja() {
        if (this.f325771e == null) {
            this.f325771e = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        if (this.f325775m == null) {
            this.f325775m = (PublishTagViewModel) getViewModel(PublishTagViewModel.class);
        }
        this.f325771e.F.observe(getHostFragment(), new a());
        this.f325771e.G.observe(getHostFragment(), new Observer<Boolean>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTitlePart.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTitlePart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                PublishTitlePart.this.f325771e.y3(PublishTitlePart.this.getHostFragment());
                            } catch (Exception e16) {
                                w53.b.d(PublishTitlePart.I, "sendSilenceMood error", e16);
                            }
                        }
                    }, 16, null, true, 500L);
                }
            }
        });
        this.f325771e.J.observe(getHostFragment(), new b());
    }

    private int la(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(WinkPublishQualityReportData winkPublishQualityReportData, int i3) {
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.a(winkPublishQualityReportData, i3);
        }
    }

    private void na(final int i3) {
        t53.a.b(getActivity().getIntent(), t53.a.f435443a.d(), new Function1() { // from class: com.tencent.mobileqq.wink.publish.part.bq
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ia5;
                ia5 = PublishTitlePart.ia(i3, (WinkDc5507ReportData.a) obj);
                return ia5;
            }
        });
    }

    private void oa() {
        if (!da()) {
            return;
        }
        qa("click");
    }

    private void pa() {
        if (!da()) {
            return;
        }
        qa("exp");
    }

    private void qa(String str) {
        MetaMaterial metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (metaMaterial == null) {
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(WinkContext.INSTANCE.d().getDtParams().a());
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM));
        buildElementParams.put("xsj_picture_num", Integer.valueOf(la(metaMaterial.additionalFields.get("xsj_picture_num"))));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(la(metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM))));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_INPUT_TEXT, metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_INPUT_TEXT));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NUM, Integer.valueOf(la(metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NUM))));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_TYPE, metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_TYPE));
        buildElementParams.put("xsj_template_name", metaMaterial.additionalFields.get("xsj_template_name"));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BACKGROUND_COLOR, metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_BACKGROUND_COLOR));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME, metaMaterial.additionalFields.get(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME));
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE);
        buildElementParams.put("xsj_eid", "em_xsj_publish_button");
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, str);
        VideoReport.reportEvent("ev_xsj_camera_action", buildElementParams);
    }

    private void ra() {
        QMMKV.from(getContext(), "QCIRCLE_MMKV_COMMON").encodeBool(PublishViewModel.R0, this.f325771e.E2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        String str;
        String str2;
        QLog.i(I, 1, "[sendMood] to send mood, thread=" + Thread.currentThread().getId() + "\uff0c activity:" + getActivity());
        this.f325771e.x3(getHostFragment());
        ua();
        SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
        JSONObject jSONObject = new JSONObject();
        W9(getHostFragment(), jSONObject, false);
        WinkPublishQualityReportData.Builder retCode = new WinkPublishQualityReportData.Builder().eventId("E_CLICK_SEND_MOOD").traceId(this.f325771e.f326005g0).retCode(String.valueOf(0L));
        if (this.f325771e.K2()) {
            str = "video";
        } else {
            str = "pic";
        }
        WinkPublishQualityReportData.Builder ext1 = retCode.ext1(str);
        if (this.f325771e.I2()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ma(ext1.ext2(str2).ext3(jSONObject.toString()).getReportData(), 1);
        WinkDatongCurrentParams.clearAll();
        com.tencent.mobileqq.wink.editor.recommend.a.f321459a.a();
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_wink_speed_optimization_1");
    }

    private void ta(JSONObject jSONObject, LbsDataV2.PoiInfo poiInfo, String str, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        if (jSONObject == null) {
            return;
        }
        int i28 = 0;
        if (poiInfo == null) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        try {
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_POI, i16);
            if (!TextUtils.isEmpty(str) && str.contains("#")) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_TOPIC, i17);
            if (!TextUtils.isEmpty(str)) {
                i18 = str.length();
            } else {
                i18 = 0;
            }
            jSONObject.put("contentLength", i18);
            if (TextUtils.isEmpty(str)) {
                i19 = 0;
            } else {
                i19 = 1;
            }
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_CONTENT, i19);
            if (z16) {
                i26 = 1;
            } else {
                i26 = 0;
            }
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, i26);
            if (z17) {
                i27 = 1;
            } else {
                i27 = 0;
            }
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SAVE, i27);
            if (z18) {
                i28 = 1;
            }
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_COVER_IS_CHANGE, i28);
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_PUBLIC, i3);
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_GUIDE_TEXT, obj);
            jSONObject.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, WinkContext.INSTANCE.d().getDtParams().c());
        } catch (JSONException e16) {
            QLog.e(I, 1, "doPublishDTReport... exception:", e16);
        }
    }

    private void ua() {
        if (!this.f325771e.J0) {
            return;
        }
        if (this.H == null) {
            PhotoListLogicPreDealDialog photoListLogicPreDealDialog = new PhotoListLogicPreDealDialog(getContext());
            this.H = photoListLogicPreDealDialog;
            photoListLogicPreDealDialog.o(1, false, false, false, false, false, false, true);
            this.H.v(new c());
            this.H.u(new d());
        }
        this.H.L(0);
        try {
            if (!this.H.t()) {
                this.H.w();
            }
        } catch (Exception e16) {
            w53.b.e(I, e16);
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return I;
    }

    public int Z9(BasePartFragment basePartFragment) {
        if (basePartFragment == null || ((com.tencent.mobileqq.wink.publish.viewmodel.n) basePartFragment.getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.n.class)).M1()) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!ba()) {
            return false;
        }
        boolean d26 = this.f325771e.d2();
        boolean isShowing = this.f325774i.getIsShowing();
        if (d26 || isShowing) {
            return false;
        }
        va();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bundle bundle;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f31370qv) {
            SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
            if (ba()) {
                QLog.i(I, 1, "[onClick] left back, show save dialog");
                va();
            } else {
                String str = I;
                QLog.i(str, 1, "[onClick] left back");
                ma(new WinkPublishQualityReportData.Builder().eventId("E_PUBLIC_EXIT_CANCEL").traceId(this.f325771e.f326005g0).ext1("nothingSave").retCode(String.valueOf(0L)).getReportData(), 1);
                if (getActivity() != null) {
                    if (getActivity().getIntent() != null) {
                        bundle = getActivity().getIntent().getExtras();
                    } else {
                        bundle = null;
                    }
                    WinkContext.INSTANCE.d().m().j(getActivity(), bundle);
                } else {
                    QLog.e(str, 1, "[onClick] no activity on back");
                }
                getActivity().finish();
            }
        } else if (id5 == R.id.f32080ss) {
            oa();
            na(2);
            MutableLiveData<Boolean> mutableLiveData = this.f325771e.I;
            if (mutableLiveData != null && !mutableLiveData.getValue().booleanValue()) {
                if (this.f325771e.o2().getValue().intValue() == 0 && ca()) {
                    com.tencent.mobileqq.wink.publish.util.f.a(getPartRootView().getContext(), "\u8bf7\u9009\u62e9\u4f5c\u54c1\u7c7b\u578b");
                } else if (this.f325771e.L2() && (TextUtils.isEmpty(this.f325771e.M) || TextUtils.isEmpty(this.f325771e.M.trim()))) {
                    com.tencent.mobileqq.wink.publish.util.f.a(getPartRootView().getContext(), "\u8bf7\u8f93\u5165\u8bc4\u8bba\u6587\u6848");
                } else {
                    PublishViewModel.P0 = 0;
                    String str2 = I;
                    QLog.d(str2, 1, "[onClick] mHasPressSendMood=" + this.f325771e.I.getValue());
                    this.f325771e.I.setValue(Boolean.TRUE);
                    WinkPublishHelper2 winkPublishHelper2 = WinkPublishHelper2.INSTANCE;
                    if (winkPublishHelper2.getQfsService() != null) {
                        QLog.d(str2, 1, "[onClick] have service");
                        sa();
                    } else {
                        QLog.d(str2, 1, "[onClick] have no service");
                        S9().show();
                        WinkPublishServiceReporter.reportOperation(10, 1, true);
                        this.f325770d = false;
                        final Runnable executeDelay = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTitlePart.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PublishTitlePart.this.f325771e.I.getValue().booleanValue()) {
                                    PublishTitlePart.this.f325770d = true;
                                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishTitlePart.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PublishTitlePart.this.f325771e.I.setValue(Boolean.FALSE);
                                            PublishTitlePart.this.S9().hide();
                                            if (uq3.c.K6()) {
                                                QQToastUtil.showQQToast(1, "service\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u91cd\u542f\u624b\u673a\u8bd5\u8bd5");
                                            }
                                            if ("1".equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_publish_qipc_open", "1"))) {
                                                PublishTitlePart.this.sa();
                                            }
                                        }
                                    });
                                    WinkPublishServiceReporter.reportOperation(12, 1, true);
                                    return;
                                }
                                QLog.i(PublishTitlePart.I, 1, "[onClick] send mood canceled");
                            }
                        }, 16, null, true, 3000L);
                        winkPublishHelper2.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.mobileqq.wink.publish.part.bp
                            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
                            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                                PublishTitlePart.this.ha(executeDelay, winkPublishServiceProxy2);
                            }
                        }, true);
                    }
                    ra();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.C = (ImageView) view.findViewById(R.id.f31370qv);
        this.D = (TextView) view.findViewById(R.id.f32070sr);
        this.E = (ImageView) view.findViewById(R.id.f32080ss);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.E.setEnabled(false);
        String p16 = WinkContext.INSTANCE.d().p("compose_page_button_title");
        if (!TextUtils.isEmpty(p16)) {
            this.D.setText(p16);
        }
        this.f325773h = (PublishPromotionViewModel) getViewModel(PublishPromotionViewModel.class);
        this.f325774i = (com.tencent.mobileqq.wink.publish.multiselect.a) getViewModel(com.tencent.mobileqq.wink.publish.multiselect.a.class);
        this.f325772f = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        ja();
        pa();
        U9(p16);
        na(1);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QLog.d(I, 1, "[onPartDestroy]");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        try {
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.F;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
        } catch (Exception e16) {
            QLog.w(I, 1, "[onPartDestroy]", e16);
        }
        this.f325771e.r3();
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.d(I, 1, "[onPartPause]");
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        String str = I;
        QLog.d(str, 1, "[onPartResume]");
        if (Boolean.TRUE.equals(this.f325771e.I.getValue())) {
            QLog.d(str, 1, "[onPartResume] resume exception ");
            ma(new WinkPublishQualityReportData.Builder().eventId("T_CATCH_IMPORTANT_INFO").traceId(this.f325771e.f326005g0).ext1("SCENE_PUBLISH_PAGE_RESUME_EXCEPTION").retCode(String.valueOf(0L)).getReportData(), 1);
        }
        this.f325771e.s3();
        W9(getHostFragment(), null, true);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        QLog.d(I, 1, "[onPartStop]");
    }

    public void va() {
        if (getHostFragment().getActivity() == null || getHostFragment().getActivity() == null) {
            return;
        }
        ActionSheet actionSheet = this.G;
        if (actionSheet != null && actionSheet.isShowing()) {
            return;
        }
        int intExtra = getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1);
        this.G = ActionSheet.create(com.tencent.mobileqq.wink.publish.util.c.c(getActivity()));
        if (this.f325771e.v2()) {
            if (intExtra == 3) {
                this.G.setMainTitle(R.string.f184563m8);
                this.G.addButton(R.string.f184583m_, 1);
                this.G.addButton(R.string.f184533m5, 1);
            } else if (intExtra == 9) {
                this.G.setMainTitle(R.string.f184573m9);
                this.G.addButton(R.string.f184523m4, 1);
                this.G.addButton(R.string.f184583m_, 1);
            } else {
                this.G.setMainTitle(R.string.f184553m7);
                this.G.addButton(R.string.f184513m3, 1);
                if (da()) {
                    this.G.addButton(R.string.f184533m5, 1);
                } else if (aa()) {
                    this.G.addButton(R.string.f239107lk, 1);
                } else {
                    this.G.addButton(R.string.f184583m_, 1);
                }
            }
        }
        this.G.addCancelButton(R.string.cancel);
        this.G.setOnButtonClickListener(new e(intExtra));
        if (!getActivity().isFinishing() && !this.G.isShowing()) {
            this.G.show();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
