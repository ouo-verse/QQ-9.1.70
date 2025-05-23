package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleMergeKanDianAssetsRequest;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StMergeQQKandianAssetsRsp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalDoubleUserDialogPart extends u implements View.OnClickListener {
    private v.a C;
    private HashMap<String, Integer> D;
    private boolean E;
    private boolean F;
    private RelativeLayout G;
    private RelativeLayout H;
    private LinearLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private RelativeLayout L;
    private RelativeLayout M;
    private QCircleAvatarView N;
    private QCircleAvatarView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f87482a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f87483b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f87484c0;

    /* renamed from: d, reason: collision with root package name */
    private Dialog f87485d;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f87486d0;

    /* renamed from: e, reason: collision with root package name */
    private Dialog f87487e;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f87488e0;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StUser f87489f;

    /* renamed from: f0, reason: collision with root package name */
    private Runnable f87490f0;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StUser f87491h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t f87492i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f87493m;

    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSPersonalDoubleUserDialogPart$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ QFSPersonalDoubleUserDialogPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f87487e != null) {
                this.this$0.f87487e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Collections.singletonList("key_update_version_main_basic_base_rsp");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            if (!QFSPersonalDoubleUserDialogPart.this.E && QFSPersonalDoubleUserDialogPart.this.ca()) {
                QFSPersonalDoubleUserDialogPart.this.va(wVar);
                QLog.d("QFSPersonalDoubleUserDialogPart", 1, "observer value change");
            }
            QFSPersonalDoubleUserDialogPart.this.E = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StMergeQQKandianAssetsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f87496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f87497b;

        b(int i3, int i16) {
            this.f87496a = i3;
            this.f87497b = i16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StMergeQQKandianAssetsRsp feedCloudWrite$StMergeQQKandianAssetsRsp) {
            if (feedCloudWrite$StMergeQQKandianAssetsRsp != null && z16 && j3 == 0) {
                if (this.f87496a == 2 && this.f87497b == 1) {
                    QFSPersonalDoubleUserDialogPart.this.ja();
                    QFSPersonalDoubleUserDialogPart.this.za();
                    QFSPersonalDoubleUserDialogPart.this.xa();
                    QLog.d("QFSPersonalDoubleUserDialogPart", 1, "double user dialog success");
                    return;
                }
                return;
            }
            QCircleToast.h(R.string.f1898640j, 4000);
            QLog.d("QFSPersonalDoubleUserDialogPart", 1, "double user dialog fail2");
            QFSPersonalDoubleUserDialogPart.this.ea();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (QFSPersonalDoubleUserDialogPart.this.f87493m != null) {
                QFSPersonalDoubleUserDialogPart.this.f87493m.T2(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        ua();
        ta();
    }

    private void Ba() {
        TextView textView = this.V;
        if (textView != null && this.W != null) {
            textView.setText(R.string.f1898840l);
            this.W.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1898740k));
        }
    }

    private void Ca() {
        TextView textView = this.V;
        if (textView != null && this.W != null) {
            textView.setText(R.string.f1899040n);
            this.W.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1898940m));
        }
    }

    private void P9() {
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("feed_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_BACK_BUTTON);
            int intValue = this.D.get("feed_choice").intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 2);
                    }
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 1);
                }
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 0);
            }
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    private void Q9(boolean z16) {
        String str;
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("feed_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (z16) {
                str = QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_BACK_BUTTON;
            } else {
                str = QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_OK_BUTTON;
            }
            buildElementParams.put("xsj_eid", str);
            int intValue = this.D.get("feed_choice").intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 2);
                    }
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 1);
                }
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 0);
            }
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    private void R9() {
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.f87483b0.setOnClickListener(this);
        this.f87484c0.setOnClickListener(this);
        this.f87486d0.setOnClickListener(this);
        this.f87488e0.setOnClickListener(this);
    }

    private void S9() {
        this.H.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_info_background));
        this.G.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.Q.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_dialog_duanshipin_unchecked_v2));
        this.R.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_dialog_kandian_checked));
    }

    private void T9() {
        LinearLayout linearLayout;
        if (this.M != null && (linearLayout = this.I) != null) {
            linearLayout.setVisibility(0);
            this.M.setVisibility(0);
        }
    }

    private void U9() {
        LinearLayout linearLayout;
        if (this.M != null && (linearLayout = this.I) != null) {
            linearLayout.setVisibility(8);
            this.M.setVisibility(8);
        }
    }

    private void V9() {
        this.G.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_info_background));
        this.H.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.Q.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_dialog_duanshipin_checked_v2));
        this.R.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_dialog_kandian_unchecked));
    }

    private void W9() {
        this.J.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_info_background));
        this.K.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.L.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.S.setVisibility(0);
        this.T.setVisibility(8);
        this.U.setVisibility(8);
    }

    private void X9() {
        this.L.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_info_background));
        this.J.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.K.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.S.setVisibility(8);
        this.T.setVisibility(8);
        this.U.setVisibility(0);
    }

    private void Y9() {
        this.K.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_info_background));
        this.J.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.L.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_double_user_not_choose_bg));
        this.S.setVisibility(8);
        this.T.setVisibility(0);
        this.U.setVisibility(8);
    }

    private void Z9(int i3) {
        if (this.J != null && this.K != null && this.L != null && this.S != null && this.T != null && this.U != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        X9();
                        this.D.put("feed_choice", 3);
                        return;
                    }
                    return;
                }
                Y9();
                this.D.put("feed_choice", 2);
                return;
            }
            W9();
            this.D.put("feed_choice", 1);
        }
    }

    private void aa(int i3) {
        if (this.G != null && this.H != null && this.Q != null && this.R != null) {
            if (i3 != 1) {
                if (i3 == 2) {
                    S9();
                    this.D.put("profile_choice", 3);
                    return;
                }
                return;
            }
            V9();
            this.D.put("profile_choice", 2);
        }
    }

    private void ba() {
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("feed_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_OK_BUTTON);
            int intValue = this.D.get("feed_choice").intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 2);
                    }
                } else {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 1);
                }
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_OPEN_OR_CLOSE, 0);
            }
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ca() {
        long j3 = 0;
        Object d16 = uq3.g.d("sp_key_barrage_enable", 0L);
        if (d16 instanceof Long) {
            j3 = ((Long) d16).longValue();
        }
        return !com.tencent.biz.qqcircle.utils.cv.e(System.currentTimeMillis(), j3);
    }

    private void da() {
        Dialog dialog = this.f87485d;
        if (dialog != null && dialog.isShowing()) {
            this.f87485d.dismiss();
            QLog.d("QFSPersonalDoubleUserDialogPart", 1, "double user dialog dismiss");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_UPGRADE_FAIL_XSJ_PANEL);
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null) {
            return;
        }
        this.f87491h = wVar.b().kandianUser.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null) {
            return;
        }
        this.f87489f = wVar.b().user.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            this.f87485d = new ReportDialog(getContext());
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g2z, (ViewGroup) null);
            this.f87485d = sa(this.f87485d, false);
            this.V = (TextView) inflate.findViewById(R.id.ukw);
            this.W = (TextView) inflate.findViewById(R.id.uks);
            this.G = (RelativeLayout) inflate.findViewById(R.id.f56922lx);
            this.H = (RelativeLayout) inflate.findViewById(R.id.yb_);
            this.I = (LinearLayout) inflate.findViewById(R.id.ukq);
            this.J = (RelativeLayout) inflate.findViewById(R.id.f85014nt);
            this.K = (RelativeLayout) inflate.findViewById(R.id.f85184o_);
            this.L = (RelativeLayout) inflate.findViewById(R.id.f85094o1);
            this.N = (QCircleAvatarView) inflate.findViewById(R.id.f56902lv);
            this.P = (QCircleAvatarView) inflate.findViewById(R.id.yb8);
            this.X = (TextView) inflate.findViewById(R.id.f56972m2);
            this.Y = (TextView) inflate.findViewById(R.id.ybb);
            this.Z = (TextView) inflate.findViewById(R.id.f56912lw);
            this.f87482a0 = (TextView) inflate.findViewById(R.id.yb9);
            this.M = (RelativeLayout) inflate.findViewById(R.id.f81654er);
            this.f87483b0 = (TextView) inflate.findViewById(R.id.uku);
            this.f87484c0 = (TextView) inflate.findViewById(R.id.ukt);
            this.f87486d0 = (TextView) inflate.findViewById(R.id.ukv);
            this.f87488e0 = (TextView) inflate.findViewById(R.id.ukr);
            this.Q = (ImageView) inflate.findViewById(R.id.f56932ly);
            this.R = (ImageView) inflate.findViewById(R.id.yba);
            this.S = (ImageView) inflate.findViewById(R.id.f85004ns);
            this.T = (ImageView) inflate.findViewById(R.id.f85194oa);
            this.U = (ImageView) inflate.findViewById(R.id.f85084o0);
            this.f87485d.setContentView(inflate);
            R9();
        }
    }

    private void initViewModel() {
        this.f87492i = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.f87493m = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.C = new a();
        this.f87492i.O1().observeForever(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            this.f87487e = new ReportDialog(getContext());
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168619g30, (ViewGroup) null);
            Dialog sa5 = sa(this.f87487e, true);
            this.f87487e = sa5;
            if (sa5.getWindow() != null) {
                this.f87487e.getWindow().clearFlags(2);
            }
            this.f87487e.setOnDismissListener(new c());
            this.f87487e.setContentView(inflate);
            if (!this.f87487e.isShowing()) {
                this.f87487e.show();
                getMainHandler().postDelayed(this.f87490f0, 3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        if (this.D == null) {
            this.D = new HashMap<>();
        }
        this.D.put("profile_choice", 2);
        this.D.put("feed_choice", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ma(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null) {
            return false;
        }
        return wVar.b().isKandianUser.get();
    }

    private void na() {
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("profile_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_NEXT_BUTTON);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_OR_KANDIAN_DATA, Integer.valueOf(this.D.get("profile_choice").equals(2) ? 1 : 0));
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    private void oa() {
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("profile_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_NOTCHOOSE_BUTTON);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_OR_KANDIAN_DATA, Integer.valueOf(this.D.get("profile_choice").equals(2) ? 1 : 0));
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    private void pa() {
        String str;
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("profile_choice") != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.F) {
                str = QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_NOTCHOOSE_BUTTON;
            } else {
                str = QCircleDaTongConstant.ElementId.EM_XSJ_KANDIAN_NEXT_BUTTON;
            }
            buildElementParams.put("xsj_eid", str);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_OR_KANDIAN_DATA, Integer.valueOf(this.D.get("profile_choice").equals(2) ? 1 : 0));
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    private void qa() {
        if (this.D == null) {
            this.D = new HashMap<>();
        }
        this.D.put("profile_choice", 0);
        this.D.put("feed_choice", 0);
        this.F = true;
    }

    private void ra() {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.h(R.string.f1898640j, 4000);
            QLog.d("QFSPersonalDoubleUserDialogPart", 1, "double user dialog fail1");
            ea();
            return;
        }
        HashMap<String, Integer> hashMap = this.D;
        if (hashMap != null && hashMap.get("profile_choice") != null && this.D.get("feed_choice") != null) {
            int intValue = this.D.get("profile_choice").intValue();
            int intValue2 = this.D.get("feed_choice").intValue();
            VSNetworkHelper.getInstance().sendRequest(new QCircleMergeKanDianAssetsRequest(intValue, intValue2), new b(intValue, intValue2));
        }
    }

    private Dialog sa(Dialog dialog, boolean z16) {
        dialog.setCanceledOnTouchOutside(z16);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return dialog;
    }

    private void ta() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f87491h;
        if (feedCloudMeta$StUser == null) {
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.P;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setAvatar(feedCloudMeta$StUser, com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159395d11));
        }
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText(this.f87491h.nick.get());
        }
        TextView textView2 = this.f87482a0;
        if (textView2 != null) {
            textView2.setText(this.f87491h.desc.get());
        }
    }

    private void ua() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f87489f;
        if (feedCloudMeta$StUser == null) {
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.N;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setAvatar(feedCloudMeta$StUser, com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159395d11));
        }
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(this.f87489f.nick.get());
        }
        TextView textView2 = this.Z;
        if (textView2 != null) {
            textView2.setText(this.f87489f.desc.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(final com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPersonalDoubleUserDialogPart.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPersonalDoubleUserDialogPart.this.ma(wVar)) {
                    QFSPersonalDoubleUserDialogPart.this.ha(wVar);
                    QFSPersonalDoubleUserDialogPart.this.ga(wVar);
                    QFSPersonalDoubleUserDialogPart.this.ia();
                    QFSPersonalDoubleUserDialogPart.this.la();
                    QFSPersonalDoubleUserDialogPart.this.Aa();
                    QFSPersonalDoubleUserDialogPart.this.wa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        Dialog dialog = this.f87485d;
        if (dialog != null && !dialog.isShowing()) {
            this.f87485d.show();
            QLog.d("QFSPersonalDoubleUserDialogPart", 1, "double user dialog show");
            oa();
            na();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_UPGRADE_SUCCESSFUL_WELCOME_XSJ_PANEL);
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za() {
        uq3.g.e("sp_key_barrage_enable", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalDoubleUserDialogPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f56922lx) {
                aa(1);
            } else if (id5 == R.id.yb_) {
                aa(2);
            } else if (id5 == R.id.uku) {
                da();
                qa();
                za();
                pa();
            } else if (id5 == R.id.ukt) {
                T9();
                Ca();
                pa();
                P9();
                ba();
            } else if (id5 == R.id.ukr) {
                da();
                ra();
                Q9(false);
            } else if (id5 == R.id.f85014nt) {
                Z9(1);
            } else if (id5 == R.id.f85184o_) {
                Z9(2);
            } else if (id5 == R.id.f85094o1) {
                Z9(3);
            } else if (id5 == R.id.ukv) {
                U9();
                Ba();
                oa();
                na();
                Q9(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        this.f87492i.O1().removeObserver(this.C);
        getMainHandler().removeCallbacks(this.f87490f0);
        super.onPartDestroy(activity);
    }
}
