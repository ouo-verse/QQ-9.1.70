package com.qzone.publish.ui.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.widget.AsyncImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadQualityActivity extends QZoneTitleBarFragmentV2 implements View.OnClickListener {
    private ImageView A0;
    private ImageView B0;
    private TextView K0;
    private TextView L0;
    private TextView M0;
    private AsyncImageView N0;
    private AsyncImageView O0;
    private AsyncImageView P0;
    private TextView Q0;
    private LinearLayout R0;
    private Dialog Y0;
    private AppInterface Z0;

    /* renamed from: h0, reason: collision with root package name */
    private int f51806h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f51807i0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f51809k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageView f51810l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImageView f51811m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f51812n0;

    /* renamed from: o0, reason: collision with root package name */
    private LinearLayout f51813o0;

    /* renamed from: p0, reason: collision with root package name */
    private RelativeLayout f51814p0;

    /* renamed from: q0, reason: collision with root package name */
    private RelativeLayout f51815q0;

    /* renamed from: r0, reason: collision with root package name */
    private RelativeLayout f51816r0;

    /* renamed from: s0, reason: collision with root package name */
    private TextView f51817s0;

    /* renamed from: t0, reason: collision with root package name */
    private TextView f51818t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f51819u0;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f51820v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f51821w0;

    /* renamed from: x0, reason: collision with root package name */
    private LinearLayout f51822x0;

    /* renamed from: y0, reason: collision with root package name */
    private RelativeLayout f51823y0;

    /* renamed from: z0, reason: collision with root package name */
    private RelativeLayout f51824z0;

    /* renamed from: j0, reason: collision with root package name */
    protected ArrayList<String> f51808j0 = new ArrayList<>();
    private String C0 = null;
    private String D0 = null;
    private String E0 = null;
    private String F0 = null;
    private String G0 = null;
    private String H0 = null;
    private String I0 = null;
    private String J0 = null;
    private boolean S0 = false;
    private boolean T0 = false;
    private boolean U0 = true;
    private IVasYellowDiamondPay.a V0 = new IVasYellowDiamondPay.a() { // from class: com.qzone.publish.ui.activity.r
        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public final void onResult(boolean z16, int i3, String str) {
            QZoneUploadQualityActivity.this.Fi(z16, i3, str);
        }
    };
    private boolean W0 = ar.b("kenaiyu", "2024-11-18", "vas_bug_qzone_upload_opt").isEnable(true);
    private boolean X0 = false;

    /* renamed from: a1, reason: collision with root package name */
    private final Runnable f51804a1 = new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadQualityActivity.5
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (QZoneUploadQualityActivity.this.Y0 != null) {
                    QZoneUploadQualityActivity.this.Y0.dismiss();
                }
                cooperation.vip.vipcomponent.util.b.d(BaseFragment.TAG, "pay-yellow-vip request");
                VipEnv.refreshYellowDiamondInfo();
            } catch (Exception e16) {
                cooperation.vip.vipcomponent.util.b.c(BaseFragment.TAG, "pay-yellow-vip error", e16);
            }
        }
    };

    /* renamed from: b1, reason: collision with root package name */
    private final SVIPObserver f51805b1 = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneUploadQualityActivity.this.vi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadQualityActivity.this.simpleClassname, view);
            QZoneUploadQualityActivity.this.f51817s0.setVisibility(8);
            QZoneUploadQualityActivity.this.f51816r0.setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QZoneUploadQualityActivity.this.T0) {
                QZoneUploadQualityActivity.this.U0 = false;
                ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).openPayWithSchema(com.tencent.mobileqq.vas.troop.f.f311020a.a("jhan.hz.rk.tq_yspsc"), QZoneUploadQualityActivity.this.V0);
            } else {
                QZoneUploadQualityActivity.this.Ii("an_yuanshipin");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends AsyncTask<String, String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f51828a;

        d(boolean z16) {
            this.f51828a = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            QZoneUploadQualityActivity qZoneUploadQualityActivity = QZoneUploadQualityActivity.this;
            qZoneUploadQualityActivity.yi(qZoneUploadQualityActivity.f51808j0);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            QZoneUploadQualityActivity.this.Si(this.f51828a);
            super.onPostExecute(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e extends SVIPObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onYellowVipStatusChanged() {
            if (VasNormalToggle.QZONE_VIP_REFRESH_FIX.isEnable(true)) {
                QZoneUploadQualityActivity.this.Ji();
            }
        }
    }

    private void Ai() {
        Intent intent = new Intent();
        int i3 = this.f51806h0;
        if (i3 != -2016082619) {
            intent.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", i3);
        }
        int i16 = this.f51807i0;
        if (i16 != -2016082619) {
            intent.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", i16);
        }
        setResult(-1, intent);
        finish();
    }

    private void Bi() {
        RelativeLayout relativeLayout = this.f51816r0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private boolean Ci() {
        return (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin()) & 8388608) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Di(HashMap hashMap, Boolean bool) {
        hashMap.put("action_type", "click");
        hashMap.put("btn_type", 0);
        fo.c.c("ev_qz_privacy_agreement_pop", hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ei(HashMap hashMap, Boolean bool) {
        hashMap.put("action_type", "click");
        hashMap.put("btn_type", 1);
        fo.c.c("ev_qz_privacy_agreement_pop", hashMap);
        na.e.f419543a.d(4);
        com.tencent.mobileqq.vas.troop.e.INSTANCE.b(null);
        this.f51806h0 = 3;
        LinearLayout linearLayout = this.R0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            ((TextView) this.R0.findViewById(R.id.f116506yx)).setText("\u5c0a\u8d35\u7684\u9ec4\u94bb\u7528\u6237\uff0c\u5df2\u4e3a\u4f60\u5207\u6362\u6210\u65e0\u635f\u539f\u56fe\u4e0a\u4f20");
        }
        Ti();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fi(boolean z16, int i3, String str) {
        VasLogReporter.getQzoneVip().reportLow("pay end");
        VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_upload_real_vip", false);
        if (z16) {
            Ni(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gi(String str) {
        LinearLayout linearLayout = this.R0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            ((TextView) this.R0.findViewById(R.id.f116506yx)).setText(str);
        }
        Ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(String str) {
        ak.Q(getActivity(), ak.r(getActivity(), str, getResources().getString(R.string.gln), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 999);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji() {
        Handler handler;
        try {
            QZLog.i(BaseFragment.TAG, "refreshYellowStatus!");
            if (getHandler() != null) {
                handler = getHandler();
            } else {
                handler = getView().getHandler();
            }
            if (handler != null) {
                handler.removeCallbacks(this.f51804a1);
                handler.post(this.f51804a1);
            }
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "refreshYellowStatus fail", e16);
        }
    }

    private void Ki() {
        try {
            QZLog.i(BaseFragment.TAG, "registerObserver!");
            AppInterface appInterface = (AppInterface) getAppRuntime();
            this.Z0 = appInterface;
            appInterface.addObserver(this.f51805b1);
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "registerObserver fail", e16);
        }
    }

    private void Li() {
        try {
            QZLog.i(BaseFragment.TAG, "removeObserver!");
            this.Z0.removeObserver(this.f51805b1);
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "removeObserver fail", e16);
        }
    }

    private void Mi(String str, String str2, String str3, boolean z16) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (z16) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str3, LoginData.getInstance().getUinString());
            QZLog.i(BaseFragment.TAG, "reportExposeAd");
        } else {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str3, LoginData.getInstance().getUinString());
            QZLog.i(BaseFragment.TAG, "reportClick");
        }
    }

    private void Ni(final boolean z16) {
        na.e.f419543a.e(new Function0() { // from class: com.qzone.publish.ui.activity.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Hi;
                Hi = QZoneUploadQualityActivity.this.Hi(z16);
                return Hi;
            }
        });
    }

    private void Oi() {
        if (this.f51806h0 != -2016082619) {
            if (!this.T0 && Ci() && this.f51806h0 == 3) {
                this.f51806h0 = 0;
            }
            u5.b.L0("photo", this.f51806h0, LoginData.getInstance().getUin());
        }
        int i3 = this.f51807i0;
        if (i3 != -2016082619) {
            u5.b.L0("video", i3, LoginData.getInstance().getUin());
        }
    }

    private void Pi() {
        QZoneHelper.showQzoneVipOriginalVideoDialogForUpload(getActivity(), new c());
    }

    private void Qi(boolean z16) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3 = this.f51809k0;
        if (imageView3 == null || (imageView = this.f51810l0) == null || (imageView2 = this.f51811m0) == null) {
            return;
        }
        int i3 = this.f51806h0;
        if (i3 == -2016082619) {
            this.f51812n0.setVisibility(8);
            this.f51813o0.setVisibility(8);
            this.f51820v0.setVisibility(8);
        } else if (i3 == 0) {
            imageView3.setVisibility(0);
            this.f51809k0.setContentDescription(com.qzone.util.l.a(R.string.s_8));
            this.f51810l0.setVisibility(4);
            this.f51811m0.setVisibility(4);
        } else if (i3 == 2) {
            imageView.setVisibility(0);
            this.f51810l0.setContentDescription(com.qzone.util.l.a(R.string.s_f));
            this.f51809k0.setVisibility(4);
            this.f51811m0.setVisibility(4);
        } else if (i3 == 3) {
            imageView2.setVisibility(0);
            this.f51811m0.setContentDescription(com.qzone.util.l.a(R.string.s_z));
            this.f51810l0.setVisibility(4);
            this.f51809k0.setVisibility(4);
        }
        if (z16 && this.f51807i0 == -2016082619) {
            vi();
        }
    }

    private void Ri(boolean z16) {
        Si(z16);
        new d(z16).execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(boolean z16) {
        String a16;
        String str = "\u65e0\u635f\u539f\u56fe";
        if (this.X0 && this.f51819u0 != null && z16) {
            TextView textView = this.f51818t0;
            StringBuilder sb5 = new StringBuilder();
            if (this.T0) {
                a16 = "\u65e0\u635f\u539f\u56fe";
            } else {
                a16 = com.qzone.util.l.a(R.string.s_y);
            }
            sb5.append(a16);
            sb5.append(" ");
            sb5.append(this.f51819u0);
            sb5.append(" ");
            textView.setText(sb5.toString());
        }
        if (TextUtils.isEmpty(this.F0)) {
            return;
        }
        TextView textView2 = this.f51818t0;
        StringBuilder sb6 = new StringBuilder();
        if (!this.T0) {
            str = this.F0;
        }
        sb6.append(str);
        sb6.append("  ");
        sb6.append(this.f51819u0);
        textView2.setText(sb6.toString());
    }

    private void initData() {
        parseIntent();
    }

    private void parseIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f51806h0 = intent.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", 0);
            this.f51807i0 = intent.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", -2016082619);
            this.T0 = intent.getBooleanExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_IS_GRAY_USER", false);
            this.C0 = intent.getStringExtra("out_logo_pic_normal");
            this.D0 = intent.getStringExtra("out_logo_pic");
            this.E0 = intent.getStringExtra("out_logo_pic_hd");
            this.F0 = intent.getStringExtra("text");
            this.G0 = intent.getStringExtra("text_normal");
            this.H0 = intent.getStringExtra("text_hd");
            this.I0 = intent.getStringExtra("trace_info");
            this.J0 = intent.getStringExtra("trace_new_info");
            this.f51808j0 = intent.getStringArrayListExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_SELECTED_ARRAY");
            QZLog.i(BaseFragment.TAG, "parseIntent mOriginalPicUrl:" + this.D0 + " mHdPicUrl:" + this.E0 + " mNormalPicUrl:" + this.C0 + " mOriginalTxt:" + this.F0 + " mNormalTxt:" + this.G0 + " mHdTxt:" + this.H0 + " mTraceTxt:" + this.I0 + " mTraceNewTxt:" + this.J0 + " currentImageQuality:" + this.f51806h0 + " currentVideoQuality:" + this.f51807i0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi() {
        Oi();
        int i3 = this.f51806h0;
        if (i3 != 3 && i3 != 2) {
            if (i3 == 0 && !TextUtils.isEmpty(this.C0) && !TextUtils.isEmpty(this.J0)) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.J0, LoginData.getInstance().getUinString());
            }
        } else {
            Mi(this.D0, this.E0, this.I0, false);
        }
        VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("vas_uplod_photo_key", false);
        Ai();
    }

    private void wi(String str, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", getDaTongPageId());
        fo.c.q(view, str, hashMap);
    }

    private void xi() {
        if (!this.S0 && !LoginData.getInstance().isQzoneVip()) {
            VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_upload_real_vip", true);
            ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).openPayWithSchema(com.tencent.mobileqq.vas.troop.f.f311020a.a("jhan.hz.rk.tq_ytsc"), this.V0);
            return;
        }
        e.DialogData a16 = com.tencent.mobileqq.vas.troop.e.INSTANCE.a();
        if (a16 == null) {
            this.f51806h0 = 3;
            Ti();
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("belong_app", 1);
        new com.tencent.mobileqq.vas.troop.e(this.f51816r0.getContext(), a16, new Function1() { // from class: com.qzone.publish.ui.activity.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Di;
                Di = QZoneUploadQualityActivity.Di(hashMap, (Boolean) obj);
                return Di;
            }
        }, new Function1() { // from class: com.qzone.publish.ui.activity.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Ei;
                Ei = QZoneUploadQualityActivity.this.Ei(hashMap, (Boolean) obj);
                return Ei;
            }
        }).j();
        hashMap.put("action_type", "imp");
        fo.c.c("ev_qz_privacy_agreement_pop", hashMap);
    }

    private int zi() {
        int i3 = this.f51806h0;
        if (i3 != 2) {
            return i3 != 3 ? 3 : 1;
        }
        return 2;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Hh() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected boolean enableDaTongPageRegister() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        super.finish();
        Li();
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("default_pic_quality", Integer.valueOf(zi()));
        return hashMap;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_choose_pic_quality";
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        Handler handler;
        super.onActivityResult(i3, i16, intent);
        String str = BaseFragment.TAG;
        QZLog.i(str, "onActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        if (i3 == 999 && i16 == -1 && VasNormalToggle.QZONE_VIP_REFRESH_FIX.isEnable(true)) {
            QZLog.i(str, "onActivityResult pay-yellow-vip success");
            this.S0 = true;
            Dialog showLoadingDialogTipsRight = LoadingUtil.showLoadingDialogTipsRight(getContext(), false, false);
            this.Y0 = showLoadingDialogTipsRight;
            try {
                ((TextView) showLoadingDialogTipsRight.findViewById(R.id.yt9)).setText(R.string.f22005683);
                if (getHandler() != null) {
                    handler = getHandler();
                } else {
                    handler = getView().getHandler();
                }
                if (handler != null) {
                    handler.postDelayed(this.f51804a1, 5000L);
                }
                this.Y0.show();
            } catch (Exception e16) {
                QZLog.e(BaseFragment.TAG, "onActivityResult set text fail", e16);
            }
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
        vi();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this.simpleClassname, view);
        int id5 = view.getId();
        if (id5 == R.id.fpl) {
            wi("em_qz_pic_quality_normal", view);
            this.f51806h0 = 0;
            LpReportInfo_pf00064.allReport(602, 13, 2);
        } else if (id5 == R.id.fpk) {
            wi("em_qz_pic_quality_high_definition", view);
            this.f51806h0 = 2;
            LpReportInfo_pf00064.allReport(602, 13, 3);
        } else {
            if (id5 == R.id.fpm) {
                wi("em_qz_pic_quality_original", view);
                if (this.T0) {
                    xi();
                } else {
                    this.f51806h0 = 3;
                    LpReportInfo_pf00064.allReport(602, 13, 4);
                }
            } else if (id5 == R.id.hsy) {
                this.f51807i0 = 0;
            } else if (id5 == R.id.f166745ht2) {
                if (!LoginData.getInstance().isQzoneVip() && !this.S0) {
                    Pi();
                } else {
                    this.f51807i0 = 3;
                    LpReportInfo_pf00064.allReport(602, 15);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
        Ti();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.S0 && !LoginData.getInstance().isQzoneVip() && (VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).decodeBool("qzone_upload_real_vip", false) || this.W0)) {
            Ni(this.W0);
        } else {
            VasLogReporter.getQzoneVip().reportLow("isCacheVip=" + this.S0 + " isQzoneVip=" + LoginData.getInstance().isQzoneVip());
        }
        this.W0 = false;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        initUI();
        Ki();
    }

    private void Ti() {
        Qi(true);
        int i3 = this.f51807i0;
        if (i3 != -2016082619) {
            Vi(i3, true);
        }
    }

    protected void yi(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            if (this.X0) {
                return;
            }
            this.X0 = true;
            Iterator<String> it = arrayList.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    j3 += file.length();
                }
            }
            this.f51819u0 = com.tencent.mobileqq.filemanager.util.q.g(j3);
            return;
        }
        this.f51819u0 = "";
    }

    private void Ui(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        TextView textView;
        this.K0 = (TextView) findViewById(R.id.fpu);
        this.L0 = (TextView) findViewById(R.id.fps);
        this.M0 = (TextView) findViewById(R.id.fpt);
        if (!TextUtils.isEmpty(str5)) {
            this.M0.setText(str5);
        } else {
            this.M0.setText(com.qzone.reborn.configx.g.f53821a.b().v1());
        }
        if (!TextUtils.isEmpty(str) && (textView = this.L0) != null) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.K0.setText(str3);
        }
        this.P0 = (AsyncImageView) findViewById(R.id.f166659h21);
        this.N0 = (AsyncImageView) findViewById(R.id.f166660h22);
        this.O0 = (AsyncImageView) findViewById(R.id.f166658h20);
        if (!TextUtils.isEmpty(str4) && this.L0 != null) {
            this.N0.setAsyncImage(str4);
            this.L0.setCompoundDrawables(null, null, null, null);
        }
        if (!TextUtils.isEmpty(str6)) {
            this.P0.setAsyncImage(str6);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.O0.setAsyncImage(str2);
        }
        if (this.f51806h0 != -2016082619) {
            Mi(str4, str2, str7, true);
        }
    }

    private void initUI() {
        setTitle(R.string.f173047gp1);
        setLeftButton(R.string.f170549u3, new a());
        this.f51809k0 = (ImageView) findViewById(R.id.fpp);
        this.f51810l0 = (ImageView) findViewById(R.id.fpo);
        this.f51811m0 = (ImageView) findViewById(R.id.fpq);
        this.f51812n0 = (TextView) findViewById(R.id.hsv);
        this.f51813o0 = (LinearLayout) findViewById(R.id.hsu);
        this.f51814p0 = (RelativeLayout) findViewById(R.id.fpl);
        this.f51815q0 = (RelativeLayout) findViewById(R.id.fpk);
        this.f51816r0 = (RelativeLayout) findViewById(R.id.fpm);
        this.f51817s0 = (TextView) findViewById(R.id.it7);
        this.R0 = (LinearLayout) findViewById(R.id.f116496yw);
        this.f51818t0 = (TextView) findViewById(R.id.fpu);
        this.Q0 = (TextView) findViewById(R.id.hsw);
        if (!NetworkState.isWifiConn() && TMSManager.e().h()) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 1, 2));
            this.Q0.setVisibility(0);
        } else {
            this.Q0.setVisibility(8);
        }
        if (!this.T0) {
            boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_OPEN_ORIGINAL_UPLOAD, 1) == 1;
            int G = u5.b.G("photo_quality_sp_key_" + LoginData.getInstance().getUin(), 0);
            if (!z16 && G == 0) {
                this.f51817s0.setOnClickListener(new b());
            } else {
                this.f51817s0.setVisibility(8);
                this.f51816r0.setVisibility(0);
            }
            if (Ci()) {
                Bi();
            }
        } else {
            this.f51818t0.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.fxr), (Drawable) null);
            this.f51817s0.setVisibility(8);
            this.f51816r0.setVisibility(0);
            this.f51818t0.setText("\u65e0\u635f\u539f\u56fe ");
            ((TextView) findViewById(R.id.fpy)).setText(com.tencent.mobileqq.vas.troop.f.f311020a.c());
        }
        this.f51814p0.setOnClickListener(this);
        this.f51815q0.setOnClickListener(this);
        this.f51816r0.setOnClickListener(this);
        this.f51820v0 = (TextView) findViewById(R.id.f166743ht0);
        this.f51821w0 = (TextView) findViewById(R.id.f109816gu);
        this.f51822x0 = (LinearLayout) findViewById(R.id.hsz);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.hsy);
        this.f51823y0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.f166745ht2);
        this.f51824z0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.A0 = (ImageView) findViewById(R.id.hsx);
        this.B0 = (ImageView) findViewById(R.id.f166744ht1);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("INTENT_QUALITY_DIFF_TEXT");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f51821w0.setText(stringExtra);
            }
        }
        Qi(false);
        Ri(true);
        Vi(this.f51807i0, false);
        Ui(this.H0, this.E0, this.F0, this.D0, this.G0, this.C0, this.I0);
        if (!LoginData.getInstance().isQzoneVip() && VasToggle.BUG_103890873.isEnable(true)) {
            QZoneNotifyServlet.m(4);
            VasLogReporter.getQzoneVip().reportLow("not vip and startNewAndUnreadServlet");
            QZoneFeedAlertService.getInstance().getFeedAlert(null, 11);
        }
        ((TextView) findViewById(R.id.f1178372i)).setText(com.qzone.reborn.configx.g.f53821a.b().v1());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bsf, viewGroup);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            vi();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Hi(boolean z16) {
        final String str;
        if (z16) {
            return null;
        }
        this.S0 = true;
        if (this.U0) {
            this.f51806h0 = 3;
            str = "\u9ec4\u94bb\u5f00\u901a\u6210\u529f, \u5df2\u4e3a\u4f60\u5207\u6362\u6210\u65e0\u635f\u539f\u56fe\u4e0a\u4f20\u3002";
        } else {
            this.f51807i0 = 3;
            str = "\u9ec4\u94bb\u5f00\u901a\u6210\u529f, \u5df2\u4e3a\u4f60\u5207\u6362\u6210\u539f\u753b\u4e0a\u4f20\u3002";
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.publish.ui.activity.v
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadQualityActivity.this.Gi(str);
            }
        });
        return null;
    }

    private void Vi(int i3, boolean z16) {
        if (i3 == -2016082619) {
            this.f51820v0.setVisibility(8);
            this.f51822x0.setVisibility(8);
            this.f51812n0.setVisibility(8);
        } else if (i3 == 0) {
            this.A0.setVisibility(0);
            this.A0.setContentDescription(com.qzone.util.l.a(R.string.s_d));
            this.B0.setVisibility(8);
        } else if (i3 == 3) {
            this.A0.setVisibility(8);
            this.B0.setVisibility(0);
            this.B0.setContentDescription(com.qzone.util.l.a(R.string.f172582sa0));
        }
        if (z16 && this.f51806h0 == -2016082619) {
            vi();
        }
    }
}
