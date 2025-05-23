package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSMaterialGuidePopupWindowEvent;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalQzoneAlumView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QFSTianShuConstant;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StTemplateInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

/* loaded from: classes4.dex */
public class QCirclePersonalHomeMaterialGuidePopupWindowPart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    public static final String V = "has_show_material_guide" + WinkCommonUtil.getCurrentAccountLong();
    private static final String W = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath();
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r C;
    private com.tencent.biz.qqcircle.viewmodels.c D;
    private FeedCloudRead$StTemplateInfo E;
    private MetaMaterial F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String M;
    private String N;
    IVasPagViewApi P;
    private volatile boolean R;
    private volatile boolean S;
    private QFSPersonalDetailsFragment T;

    /* renamed from: d, reason: collision with root package name */
    private View f82706d;

    /* renamed from: e, reason: collision with root package name */
    private View f82707e;

    /* renamed from: f, reason: collision with root package name */
    private PAGFile f82708f;

    /* renamed from: h, reason: collision with root package name */
    private QFSPersonalQzoneAlumView f82709h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f82710i;

    /* renamed from: m, reason: collision with root package name */
    private VasPagView f82711m;
    private IWinkEditorResourceAPI L = (IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class);
    private QCircleLoadingDialog Q = null;
    private final Runnable U = new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCirclePersonalHomeMaterialGuidePopupWindowPart.6
        @Override // java.lang.Runnable
        public void run() {
            if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ca()) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                qCirclePersonalHomeMaterialGuidePopupWindowPart.M = qCirclePersonalHomeMaterialGuidePopupWindowPart.L.getDownloadFolder(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F);
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F.additionalFields.put("packagePath", QCirclePersonalHomeMaterialGuidePopupWindowPart.this.M);
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Sa();
                return;
            }
            if (!QCirclePersonalHomeMaterialGuidePopupWindowPart.this.R) {
                RFWThreadManager.getUIHandler().postDelayed(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.U, 1000L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalInfo> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.biz.qqcircle.bizparts.QCirclePersonalHomeMaterialGuidePopupWindowPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0844a implements Observer<List<DraftBean>> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QFSPersonalInfo f82713d;

            C0844a(QFSPersonalInfo qFSPersonalInfo) {
                this.f82713d = qFSPersonalInfo;
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(List<DraftBean> list) {
                if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ba(list, this.f82713d)) {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.E = this.f82713d.f88431r;
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.G = this.f82713d.f88439z;
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.H = this.f82713d.E + "";
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.I = this.f82713d.F;
                    QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                    qCirclePersonalHomeMaterialGuidePopupWindowPart.J = com.tencent.biz.qqcircle.utils.y.c(qCirclePersonalHomeMaterialGuidePopupWindowPart.G, "libtemplate");
                    QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart2 = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                    qCirclePersonalHomeMaterialGuidePopupWindowPart2.K = com.tencent.biz.qqcircle.immersive.utils.t.b(qCirclePersonalHomeMaterialGuidePopupWindowPart2.E);
                    QLog.d("QCirclePersonal", 1, "QQLogo = " + QCirclePersonalHomeMaterialGuidePopupWindowPart.this.E.QQLogo.get());
                    QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart3 = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                    qCirclePersonalHomeMaterialGuidePopupWindowPart3.ua(qCirclePersonalHomeMaterialGuidePopupWindowPart3.E.QQLogo.get());
                    QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart4 = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                    qCirclePersonalHomeMaterialGuidePopupWindowPart4.F = qCirclePersonalHomeMaterialGuidePopupWindowPart4.L.getTemplateLibraryMaterial(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.J);
                    if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F != null) {
                        QLog.d("QCirclePersonal", 1, "initViewModel(): material = " + QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F);
                        HashMap hashMap = new HashMap();
                        hashMap.put("xsj_material_type", "libTemplate");
                        hashMap.put("xsj_material_id", QCirclePersonalHomeMaterialGuidePopupWindowPart.this.J);
                        hashMap.put("xsj_operation_activity_id", com.tencent.biz.qqcircle.utils.y.c(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.G, "taskid"));
                        QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart5 = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                        qCirclePersonalHomeMaterialGuidePopupWindowPart5.wa(qCirclePersonalHomeMaterialGuidePopupWindowPart5.f82711m, QCircleDaTongConstant.ElementId.EM_XSJ_INFORMATION_CARD, hashMap);
                        QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart6 = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
                        qCirclePersonalHomeMaterialGuidePopupWindowPart6.wa(qCirclePersonalHomeMaterialGuidePopupWindowPart6.f82710i, QCircleDaTongConstant.ElementId.EM_XSJ_CARD_CLOSE_BUTTON, hashMap);
                        try {
                            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.va(this.f82713d.A);
                        } catch (OutOfMemoryError e16) {
                            QLog.e("QCirclePersonal", 1, "OutOfMemoryError = " + e16);
                        }
                    } else {
                        QLog.d("QCirclePersonal", 1, "initViewModel(): material = null");
                    }
                    if (QFSPersonalInfo.O) {
                        QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82709h.c(0, 1);
                        return;
                    }
                    return;
                }
                if (((list != null && !list.isEmpty()) || this.f82713d.f88423j != 0 || QCirclePersonalHomeMaterialGuidePopupWindowPart.this.S) && QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d != null) {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d.setVisibility(8);
                }
            }
        }

        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.S = uq3.k.b().c(QCirclePersonalHomeMaterialGuidePopupWindowPart.V, false);
            if (!QCirclePersonalHomeMaterialGuidePopupWindowPart.this.S) {
                if (!QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Aa(qFSPersonalInfo)) {
                    if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d != null) {
                        QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d.setVisibility(8);
                        return;
                    }
                    return;
                } else {
                    if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.getHostFragment() == null) {
                        return;
                    }
                    ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLiveDataDrafts().observe(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.getHostFragment(), new C0844a(qFSPersonalInfo));
                    return;
                }
            }
            if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d != null) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.f82706d.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ma();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.ta();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Function1<PAGView, Unit> {
        e() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            if (pAGView != null && pAGView.isPlaying()) {
                pAGView.stop();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Function1<PAGView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f82719d;

        f(String str) {
            this.f82719d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            if (pAGView != null && !TextUtils.isEmpty(this.f82719d) && !pAGView.isPlaying()) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Na(pAGView, this.f82719d);
                return null;
            }
            return null;
        }
    }

    public QCirclePersonalHomeMaterialGuidePopupWindowPart(QFSPersonalDetailsFragment qFSPersonalDetailsFragment) {
        this.T = qFSPersonalDetailsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Aa(QFSPersonalInfo qFSPersonalInfo) {
        boolean z16;
        if (qFSPersonalInfo.f88423j == 0 && qFSPersonalInfo.f88438y == 4 && !this.S) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QCirclePersonal", 1, "isNeedShowBubble = " + z16 + ",qfsPersonalInfo.feedNum = " + qFSPersonalInfo.f88423j + ",has_show_material_guide = " + this.S);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ba(List<DraftBean> list, QFSPersonalInfo qFSPersonalInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        if ((list == null || list.isEmpty()) && qFSPersonalInfo.f88423j == 0 && this.f82706d != null && qFSPersonalInfo.f88438y == 4 && !this.S) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isNeedShowBubble = ");
        sb5.append(z16);
        sb5.append(",draftBeans.isEmpty = ");
        if (list != null && !list.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append(",qfsPersonalInfo.feedNum = ");
        sb5.append(qFSPersonalInfo.f88423j);
        sb5.append(",");
        sb5.append(qFSPersonalInfo.f88438y);
        if (sb5.toString() == ("4,has_show_material_guide = " + this.S)) {
            z18 = true;
        } else {
            z18 = false;
        }
        objArr[0] = Boolean.valueOf(z18);
        QLog.d("QCirclePersonal", 1, objArr);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ca() {
        if (this.F == null) {
            QLog.i("QCirclePersonal", 1, "[isTemplateReady] material is null");
            return false;
        }
        boolean isTemplateLibraryConfigReady = this.L.isTemplateLibraryConfigReady();
        boolean isTemplateMaterialReady = this.L.isTemplateMaterialReady(this.F.f30533id);
        if (isTemplateLibraryConfigReady && isTemplateMaterialReady) {
            QLog.i("QCirclePersonal", 1, "[isTemplateReady] \u8d44\u6e90\u52a0\u8f7d\u5b8c\u6210: " + this.F.f30533id);
            return true;
        }
        QLog.i("QCirclePersonal", 1, "[isTemplateReady] \u8d44\u6e90\u52a0\u8f7d\u672a\u5b8c\u6210 isTemplateLibraryConfigReady = " + isTemplateLibraryConfigReady + ", isTemplateMaterialReady = " + isTemplateMaterialReady);
        return false;
    }

    private void Da() {
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new b(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_MATERIAL_GUILD), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    private void Ea(String str, String str2, String str3, String str4, String str5, FeedCloudRead$StTemplateInfo feedCloudRead$StTemplateInfo) {
        String a16 = com.tencent.biz.qqcircle.immersive.utils.t.a(str, str2, str4, str3, str5, feedCloudRead$StTemplateInfo);
        QLog.d("QCirclePersonal", 1, "jumpToWinkEditor:" + a16 + "templateInfo:" + feedCloudRead$StTemplateInfo + ", " + this.F.additionalFields + ",jumpurl " + str + ", templateId:" + str5 + "," + this.F.packageUrl + "," + str3 + " avatarPath:" + str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a16);
        sb5.append(com.tencent.biz.qqcircle.utils.y.b(str, 6));
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fa() {
        this.R = true;
        this.Q.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ga(boolean z16, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.D.L1().postValue(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ha() {
        Qa(this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(boolean z16, String str) {
        this.N = str;
        if (!TextUtils.isEmpty(str)) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.l
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ha();
                }
            });
        } else {
            QLog.e("QCirclePersonal", 2, "Pag\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ja(PAGView pAGView, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QCirclePersonal", 1, "QQ logo path is empty");
            return;
        }
        this.f82708f.replaceImage(0, PAGImage.FromPath(str));
        pAGView.setComposition(this.f82708f);
        pAGView.setRepeatCount(0);
        pAGView.play();
        View view = this.f82706d;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.C == null) {
            this.C = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
        this.C.r2().postValue(Boolean.TRUE);
        Pa(101);
        qa();
        QLog.d("QCirclePersonal", 1, "getQqLogoPath = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ka(final PAGView pAGView) {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            QLog.d("QCirclePersonal", 1, "Host fragment is null");
            return;
        }
        MutableLiveData<String> L1 = this.D.L1();
        if (L1.hasActiveObservers()) {
            return;
        }
        L1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ja(pAGView, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void La(File file, final PAGView pAGView) {
        PAGFile Load = PagViewMonitor.Load(file.getAbsolutePath());
        this.f82708f = Load;
        if (Load == null) {
            QLog.d("QCirclePersonal", 1, "Failed to load PAGFile");
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.n
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ka(pAGView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        MetaMaterial templateLibraryMaterial = this.L.getTemplateLibraryMaterial(this.J);
        this.F = templateLibraryMaterial;
        if (templateLibraryMaterial != null) {
            QLog.d("QCirclePersonal", 1, "loadTemplateIfNeedThenJumpNextPage(): material = " + this.F);
            Ra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na(final PAGView pAGView, String str) {
        final File file = new File(str);
        if (!file.exists()) {
            QLog.d("QCirclePersonal", 1, "pagLocalFile does not exist");
        } else {
            QLog.d("QCirclePersonal", 1, "pagLocalFile exists");
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.m
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.La(file, pAGView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        if (Ca()) {
            Sa();
        } else {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCirclePersonalHomeMaterialGuidePopupWindowPart.5
                @Override // java.lang.Runnable
                public void run() {
                    if (QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Q == null) {
                        QCirclePersonalHomeMaterialGuidePopupWindowPart.this.sa();
                    }
                    if (!QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Q.isShowing()) {
                        try {
                            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Q.showDialog();
                        } catch (Exception unused) {
                            QLog.d("QCirclePersonal", 2, "dialog showing exception");
                        }
                    }
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.R = false;
                    RFWThreadManager.getUIHandler().postDelayed(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.U, 1000L);
                }
            });
        }
    }

    private void Pa(int i3) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        long currentAccountLong = WinkCommonUtil.getCurrentAccountLong();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        tianShuReportData.mToUid = currentAccountLong + "";
        tianShuReportData.mTraceId = currentAccountLong + "_" + currentTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mItemId = this.H;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = currentTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = this.I;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    private void Qa(String str) {
        if (this.P == null) {
            this.P = this.f82711m.api().build();
        }
        this.P.postAction(new f(str));
    }

    private void Ra() {
        if (this.F == null) {
            QLog.d("QCirclePersonal", 1, "startJumpNextPage(): material = null");
            return;
        }
        if (this.Q == null) {
            sa();
        }
        if (!this.Q.isShowing()) {
            try {
                this.Q.showDialog();
            } catch (Exception unused) {
                QLog.d("QCirclePersonal", 2, "dialog showing exception");
            }
        }
        QLog.d("QCirclePersonal", 1, "[bindMake] begin download template, ", this.F.f30533id);
        this.L.preDownloadMaterialResource(this.J, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sa() {
        ta();
        this.P.postAction(new e());
        String str = this.C.g2().getValue().f88439z;
        String str2 = this.M;
        if (!TextUtils.isEmpty(this.D.L1().getValue())) {
            Ea(str, this.D.L1().getValue(), str2, this.K, this.J, this.E);
            return;
        }
        QLog.e("QCirclePersonal", 1, "mGuideViewModel.getQqLogoPath().getValue() = " + this.D.L1().getValue());
    }

    private void initView() {
        if (this.f82706d == null) {
            return;
        }
        this.f82707e = getActivity().findViewById(R.id.f31760rx);
        this.f82709h = (QFSPersonalQzoneAlumView) getActivity().findViewById(R.id.zz9);
        this.f82710i = (ImageView) this.f82706d.findViewById(R.id.aga);
        this.f82711m = (VasPagView) this.f82706d.findViewById(R.id.tfz);
        this.f82710i.setOnClickListener(this);
        this.f82711m.setOnClickListener(this);
        if (this.C == null) {
            this.C = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(this.T, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
        if (this.D == null) {
            this.D = (com.tencent.biz.qqcircle.viewmodels.c) getViewModel(com.tencent.biz.qqcircle.viewmodels.c.class);
        }
        this.C.r2().postValue(Boolean.FALSE);
    }

    private void initViewModel() {
        if (this.f82706d == null) {
            return;
        }
        if (this.C == null) {
            this.C = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
        if (getHostFragment() == null) {
            return;
        }
        this.C.g2().observe(getPartHost().getLifecycleOwner(), new a());
    }

    private void qa() {
        PAGFile pAGFile;
        View view = this.f82706d;
        if (view == null || this.f82711m == null || this.f82710i == null || view.getVisibility() != 0 || (pAGFile = this.f82708f) == null) {
            return;
        }
        int width = pAGFile.width();
        int height = this.f82708f.height();
        if (width == 0 || height == 0 || com.tencent.biz.qqcircle.utils.bz.i(getContext()) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f82707e.getLayoutParams();
        int i3 = com.tencent.biz.qqcircle.utils.bz.i(getContext()) - com.tencent.biz.qqcircle.utils.cx.a(20.0f);
        layoutParams.width = i3;
        layoutParams.height = (height * i3) / width;
        this.f82707e.setLayoutParams(layoutParams);
        if (this.f82710i.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f82710i.getLayoutParams();
            layoutParams2.setMargins(0, layoutParams.height / 4, com.tencent.biz.qqcircle.utils.cx.a(10.0f), 0);
            this.f82710i.setLayoutParams(layoutParams2);
        }
    }

    private void ra(QCircleLoadingDialog qCircleLoadingDialog) {
        qCircleLoadingDialog.S("\u89c6\u9891\u751f\u6210\u4e2d");
        ImageView U = qCircleLoadingDialog.U();
        U.setVisibility(0);
        U.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        if (this.Q == null) {
            QCircleLoadingDialog qCircleLoadingDialog = new QCircleLoadingDialog(getContext());
            this.Q = qCircleLoadingDialog;
            ra(qCircleLoadingDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta() {
        QCircleLoadingDialog qCircleLoadingDialog = this.Q;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.i
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Fa();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(String str) {
        WeakReference<i83.d> weakReference = new WeakReference<>(new i83.d() { // from class: com.tencent.biz.qqcircle.bizparts.j
            @Override // i83.d
            public final void onResult(boolean z16, String str2) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ia(z16, str2);
            }
        });
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).downloadPagOrImage(str, W + "pagdir", za(str), weakReference, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_resource_type", 6);
        buildElementParams.putAll(map);
        buildElementParams.put("xsj_material_type", "libTemplate");
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private String xa(String str) {
        return com.tencent.biz.qqcircle.utils.y.c(str, "k");
    }

    private String za(String str) {
        if (str.indexOf("/") != -1) {
            return str.substring(str.lastIndexOf("/") + 1);
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSMaterialGuidePopupWindowEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePersonal";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.aga) {
            this.S = true;
            uq3.k.b().j(V, true);
            View view2 = this.f82706d;
            if (view2 != null && view2.getVisibility() == 0) {
                this.f82706d.setVisibility(8);
                if (this.C == null) {
                    this.C = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
                }
                this.C.r2().postValue(Boolean.FALSE);
            }
            Pa(122);
        } else {
            if (view.getId() == R.id.tfz && !fb0.a.a("QCirclePersonal")) {
                Da();
            }
            Pa(102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (this.f82706d == null) {
            ViewStub viewStub = (ViewStub) getActivity().findViewById(R.id.f89334zh);
            if (viewStub == null) {
                QLog.e("QCirclePersonal", 1, "onInitView stub == null");
                return;
            } else {
                viewStub.inflate();
                this.f82706d = getActivity().findViewById(R.id.yy8);
            }
        }
        initView();
        initViewModel();
        this.S = uq3.k.b().c(V, false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        try {
            this.L.fetchEditorResource();
            this.L.fetchTemplateLibraryResource();
        } catch (OutOfMemoryError e16) {
            QLog.e("QCirclePersonal", 1, "OutOfMemoryError = " + e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.L.clearData();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QFSMaterialGuidePopupWindowEvent) && (simpleBaseEvent instanceof QCircleConfigChangeEvent)) {
            qa();
        }
    }

    public void ua(String str) {
        WeakReference<i83.d> weakReference = new WeakReference<>(new i83.d() { // from class: com.tencent.biz.qqcircle.bizparts.k
            @Override // i83.d
            public final void onResult(boolean z16, String str2) {
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Ga(z16, str2);
            }
        });
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).downloadPagOrImage(str, W + "qqlogo", xa(str), weakReference, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ResDownLoadListener {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            QLog.d("QCirclePersonal", 1, "[onDownloadFinish] isSuccess=", Boolean.valueOf(z16));
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.ta();
            if (!z16) {
                QLog.w("QCirclePersonal", 1, "[onDownloadFinish] download failed, id=" + QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F.f30533id);
                QCirclePersonalHomeMaterialGuidePopupWindowPart.this.ta();
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                QQToast.makeText(RFWApplication.getApplication(), 1, "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1).show();
                return;
            }
            QCirclePersonalHomeMaterialGuidePopupWindowPart qCirclePersonalHomeMaterialGuidePopupWindowPart = QCirclePersonalHomeMaterialGuidePopupWindowPart.this;
            qCirclePersonalHomeMaterialGuidePopupWindowPart.M = qCirclePersonalHomeMaterialGuidePopupWindowPart.L.getDownloadFolder(QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F);
            QLog.d("QCirclePersonal", 2, "jumptest [onDownloadFinish] downloadFolder=", QCirclePersonalHomeMaterialGuidePopupWindowPart.this.M);
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.F.additionalFields.put("packagePath", QCirclePersonalHomeMaterialGuidePopupWindowPart.this.M);
            QCirclePersonalHomeMaterialGuidePopupWindowPart.this.Oa();
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
        }
    }
}
