package com.tencent.mobileqq.zplan.fragment.bgedit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationZPlanCover;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment;
import com.tencent.mobileqq.zplan.model.g;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest;
import com.tencent.mobileqq.zplan.view.ZPlanSuperBackgroundView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import nk3.i;

/* loaded from: classes34.dex */
public class ZPlanBgEditFragment extends QPublicBaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private QBaseActivity C;
    private Context D;
    private AppInterface E;
    private ZPlanSuperBackgroundView F;
    private f G;
    private View H;
    private TextView I;
    private QUICheckBox J;
    private Button K;
    private QUIButton L;
    private LinearLayout M;
    private RelativeLayout N;
    private String Q;
    private boolean P = false;
    private String R = "";
    private String S = "";
    e T = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends i {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(List list, String str) {
            String i3;
            if (list.size() == 0) {
                return;
            }
            ZPlanBgEditFragment.this.R = str;
            Iterator it = list.iterator();
            int i16 = 0;
            int i17 = 0;
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.o()) {
                    it.remove();
                } else {
                    i17++;
                }
                if (gVar.e() == 1) {
                    i16 = i17 - 1;
                }
            }
            ZPlanBgEditFragment.this.G.t(list);
            VideoReport.traversePage(ZPlanBgEditFragment.this.H);
            ZPlanBgEditFragment.this.G.R(i16);
            if (list.size() > i16) {
                f fVar = ZPlanBgEditFragment.this.G;
                if (ZPlanBgEditFragment.this.P) {
                    i3 = ((g) list.get(i16)).b();
                } else {
                    i3 = ((g) list.get(i16)).i();
                }
                fVar.Q(i3);
            }
            ZPlanBgEditFragment zPlanBgEditFragment = ZPlanBgEditFragment.this;
            zPlanBgEditFragment.Fh(zPlanBgEditFragment.S, list, i16);
        }

        @Override // nk3.i
        public void onResultForRequestAllImage(final List<? extends g> list, final String str) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.bgedit.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBgEditFragment.a.this.b(list, str);
                }
            });
        }
    }

    /* loaded from: classes34.dex */
    class d implements e {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment.e
        public void a(int i3) {
            g D = ZPlanBgEditFragment.this.G.D();
            ZPlanBgEditFragment.this.Sh(D);
            ZPlanBgEditFragment.this.L.setEnabled(true);
            ZPlanBgEditFragment.this.Xh(D);
        }

        @Override // com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment.e
        public void b() {
            if (ZPlanBgEditFragment.this.C == null) {
                return;
            }
            int s16 = ProfileCardUtil.s(ZPlanBgEditFragment.this.C);
            int i3 = (int) (s16 * 1.13f);
            Intent intent = new Intent(ZPlanBgEditFragment.this.C, (Class<?>) NewPhotoListActivity.class);
            intent.putExtra(PeakConstants.CLIP_WIDTH, s16);
            intent.putExtra(PeakConstants.CLIP_HEIGHT, i3);
            intent.putExtra(PeakConstants.TARGET_WIDTH, s16);
            intent.putExtra(PeakConstants.TARGET_HEIGHT, i3);
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 58);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationZPlanCover.F);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ZPlanBgEditFragment.this.C.getClass().getName());
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
            intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
            intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
            intent.putExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
            intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.r());
            ZPlanBgEditFragment.this.startActivity(intent);
            QAlbumUtil.anim(ZPlanBgEditFragment.this.C, false, true);
        }

        @Override // com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment.e
        public void c() {
            boolean z16;
            Iterator<g> it = ZPlanBgEditFragment.this.G.v().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                }
                g next = it.next();
                if (next.d() == 4 || next.d() == 3) {
                    if (next.e() == 2) {
                        z16 = false;
                        break;
                    }
                }
            }
            ZPlanBgEditFragment.this.J.setChecked(z16);
            ZPlanBgEditFragment.this.K.setEnabled(ZPlanBgEditFragment.this.G.E() > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public interface e {
        void a(int i3);

        void b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(String str, List<? extends g> list, int i3) {
        if (!TextUtils.isEmpty(str)) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                if (str.equals(list.get(i16).i())) {
                    list.get(i3).q(2);
                    i3 = i16;
                }
            }
        }
        g gVar = list.get(i3);
        Sh(gVar);
        gVar.q(1);
        Xh(gVar);
        Mh();
        this.G.L(i3);
        this.G.P(gVar.i());
        this.G.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        HashSet<g> A = this.G.A();
        String B = this.G.B();
        String C = this.G.C();
        boolean Ph = Ph(B, A);
        boolean Ph2 = Ph(C, A);
        if (Ph && Ph2) {
            if (this.G.v().size() > 0) {
                int w3 = this.G.w();
                if (w3 == -1) {
                    QLog.e("ZPlanBackgroundEdit", 1, "can not find default bginfo, return.");
                    return;
                }
                g y16 = this.G.y(w3);
                Sh(y16);
                this.G.L(w3);
                this.G.R(w3);
                this.G.P(y16.i());
                this.G.Q(y16.b());
            }
        } else if (Ph) {
            Sh(this.G.x(C));
            this.G.P(C);
            f fVar = this.G;
            fVar.L(fVar.z(C));
        } else {
            this.G.L(this.G.z(B));
        }
        this.G.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(Button button) {
        String str;
        g D = this.G.D();
        if (D == null) {
            QLog.e("ZPlanBackgroundEdit", 1, "select image is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        int d16 = D.d();
        if (d16 == 4) {
            str = "xiangce";
        } else if (d16 == 3) {
            str = "xiaowo";
        } else if (d16 == 5) {
            str = "s_level";
        } else {
            str = "default";
        }
        hashMap.put("zplan_btn_text", button.getText());
        hashMap.put("zplan_qqusercard_xiaowo_backgroundstyle", str);
        VideoReport.reportEvent("clck", button, hashMap);
    }

    private void Ih() {
        if (this.E == null) {
            QLog.e("ZPlanBackgroundEdit", 1, "mApp is null.");
            return;
        }
        HashSet<g> A = this.G.A();
        if (A != null && A.size() != 0) {
            ArrayList arrayList = new ArrayList(A);
            long longAccountUin = this.E.getLongAccountUin();
            ZPlanUserInfoRequest.f335380a.s(longAccountUin, 2, arrayList, new c(longAccountUin));
            return;
        }
        QLog.e("ZPlanBackgroundEdit", 1, "deleteBgToNet | selectedForDelete is null.");
    }

    private void Jh() {
        g D = this.G.D();
        if (D != null) {
            Th(this.G.H());
            this.N.setVisibility(0);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.G.S(1);
            D.q(2);
            this.G.notifyDataSetChanged();
        }
    }

    private void Lh(String str) {
        QBaseActivity qBaseActivity = this.C;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("ZPlanBackgroundEdit", 1, "handleJump url is:" + str + ", return.");
                return;
            }
            Intent intent = new Intent(this.C, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            this.C.startActivity(intent);
            return;
        }
        QLog.e("ZPlanBackgroundEdit", 1, "handleJump activity error, return.");
    }

    private void Mh() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_btn_text", this.L.getText());
        VideoReport.reportEvent("imp", this.L, hashMap);
    }

    private void Nh(LayoutInflater layoutInflater) {
        ((LinearLayout) this.H.findViewById(R.id.qi9)).setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
        this.H.findViewById(R.id.pfa).setOnClickListener(this);
        TextView textView = (TextView) this.H.findViewById(R.id.pg7);
        this.I = textView;
        textView.setOnClickListener(this);
        this.I.setTag(0);
        ZPlanSuperBackgroundView zPlanSuperBackgroundView = (ZPlanSuperBackgroundView) this.H.findViewById(R.id.pyv);
        this.F = zPlanSuperBackgroundView;
        zPlanSuperBackgroundView.getLayoutParams().height = (int) (ProfileCardUtil.s(getQBaseActivity()) * 1.13f);
        this.F.setDefaultLoadingDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.f159782gp1, null));
        this.M = (LinearLayout) this.H.findViewById(R.id.f163396px0);
        ImageView imageView = (ImageView) this.H.findViewById(R.id.r3h);
        if (!"from_profile_setting".equals(this.Q) && !"from_qzone_setting".equals(this.Q)) {
            if ("from_small_home".equals(this.Q)) {
                this.H.findViewById(R.id.r3h).setEnabled(false);
                ((TextView) this.H.findViewById(R.id.quq)).setTextColor(Color.parseColor("#999999"));
            }
        } else {
            this.M.setOnClickListener(this);
            imageView.setEnabled(true);
        }
        RecyclerView recyclerView = (RecyclerView) this.H.findViewById(R.id.pdd);
        this.G = new f(this.D, getActivity(), recyclerView, this.T, this.P);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        QUIButton qUIButton = (QUIButton) this.H.findViewById(R.id.pgb);
        this.L = qUIButton;
        qUIButton.setOnClickListener(this);
        QUICheckBox qUICheckBox = (QUICheckBox) this.H.findViewById(R.id.qjt);
        this.J = qUICheckBox;
        qUICheckBox.setOnCheckedChangeListener(this);
        Button button = (Button) this.H.findViewById(R.id.pfu);
        this.K = button;
        button.setOnClickListener(this);
        this.N = (RelativeLayout) this.H.findViewById(R.id.pr6);
    }

    private boolean Oh(g gVar, HashSet<g> hashSet) {
        Iterator<g> it = hashSet.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (gVar != null && gVar.equals(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean Ph(String str, HashSet<g> hashSet) {
        Iterator<g> it = hashSet.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (!TextUtils.isEmpty(str) && (str.equals(next.i()) || str.equals(next.b()))) {
                return true;
            }
        }
        return false;
    }

    private void Qh() {
        g D = this.G.D();
        if (D != null) {
            Th(true);
            this.N.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.K.setEnabled(false);
            this.G.S(0);
            this.G.J();
            D.q(1);
            this.G.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(String str) {
        g userBackgroundInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserBackgroundInfo(str);
        if (Oh(userBackgroundInfo, this.G.A())) {
            ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).saveUserBackgroundInfo(str, null);
            QLog.i("ZPlanBackgroundEdit", 1, "resetUserBackgroundUrlIfNeed delete bgInfo=" + userBackgroundInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(boolean z16) {
        this.J.setEnabled(z16);
        this.J.setChecked(false);
    }

    private void Uh() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getWindow() == null || ImmersiveUtils.isSupporImmersive() != 1) {
            return;
        }
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(0);
    }

    public static void Vh(Activity activity, String str) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e("ZPlanBackgroundEdit", 1, "[startZPlanBackgroundCropActivity] error appRuntime == null");
            return;
        }
        Intent intent = new Intent();
        int s16 = ProfileCardUtil.s(activity);
        int i3 = (int) (s16 * 1.13f);
        intent.setClass(activity, PhotoCropActivity.class);
        intent.putExtra(PeakConstants.CLIP_WIDTH, s16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, i3);
        intent.putExtra(PeakConstants.TARGET_WIDTH, s16);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, i3);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.r());
        intent.putExtra("FROM_WHERE", "FROM_SMALL_HOME_TAKE_PHOTO");
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        activity.startActivity(intent);
    }

    private void Yh() {
        g D = this.G.D();
        if (D == null) {
            return;
        }
        if (D.k()) {
            Lh(D.f());
            Hh(this.L);
        } else {
            Zh(D);
        }
    }

    private void Zh(g gVar) {
        if (this.E == null) {
            return;
        }
        this.L.setEnabled(false);
        gVar.q(1);
        gVar.r(NetConnInfoCenter.getServerTime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(gVar);
        ZPlanUserInfoRequest.f335380a.s(this.E.getLongAccountUin(), 3, arrayList, new b(this.E.getCurrentUin(), gVar));
    }

    private void initData() {
        if (this.E == null) {
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.xjj, 0).show();
        } else {
            ZPlanUserInfoRequest.f335380a.s(this.E.getLongAccountUin(), 4, null, new a());
        }
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setElementId(this.M, "em_zplan_goxiaowo_photograph");
        VideoReport.setElementExposePolicy(this.M, ExposurePolicy.REPORT_ALL);
        LinearLayout linearLayout = this.M;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(linearLayout, clickPolicy);
        VideoReport.setElementId(this.L, "em_zplan_confirm_use");
        VideoReport.setElementExposePolicy(this.L, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.L, clickPolicy);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageParams(this.H, new PageParams(hashMap));
        VideoReport.setPageId(this.H, "pg_zplan_qqusercard_setting_xiaowo_background");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onBackPressed() {
        QBaseActivity qBaseActivity = this.C;
        if (qBaseActivity == null) {
            return false;
        }
        if (AppSetting.t(qBaseActivity)) {
            QBaseActivity qBaseActivity2 = getQBaseActivity();
            if (qBaseActivity2 != null) {
                m.e(qBaseActivity2);
            }
        } else {
            this.C.finish();
        }
        return false;
    }

    public void Sh(g gVar) {
        if (!isAdded() || gVar == null) {
            return;
        }
        this.F.x(new ZPlanSuperBackgroundView.SuperParam(gVar.g(Boolean.valueOf(this.P)), gVar.j(Boolean.valueOf(this.P))));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pfa /* 1997013236 */:
                onBackPressed();
                return;
            case R.id.pfu /* 1997013256 */:
                Ih();
                return;
            case R.id.pg7 /* 1997013269 */:
                Integer num = (Integer) view.getTag();
                if (num.intValue() == 0) {
                    view.setTag(1);
                    this.I.setText(getString(R.string.xln));
                    Jh();
                    return;
                } else {
                    if (num.intValue() == 1) {
                        view.setTag(0);
                        this.I.setText(getString(R.string.xlt));
                        Qh();
                        return;
                    }
                    return;
                }
            case R.id.pgb /* 1997013274 */:
                Yh();
                return;
            case R.id.f163396px0 /* 1997013888 */:
                if (TextUtils.isEmpty(this.R)) {
                    return;
                }
                this.R = this.R.replace("${uin}", this.E.getCurrentUin()).replace("${referer}", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED).replace("${subReferer}", "em_zplan_xiaowo_entrance_xiaowophoto");
                ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(requireContext(), this.R);
                HashMap hashMap = new HashMap();
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                VideoReport.reportEvent("dt_clck", this.M, hashMap);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        this.C = getQBaseActivity();
        this.D = getContext();
        this.E = (AppInterface) getQBaseActivity().getAppRuntime();
        this.P = QQTheme.isNowThemeIsNight();
        Intent intent = this.C.getIntent();
        String stringExtra = intent.getStringExtra("from_type");
        this.Q = stringExtra;
        if ("from_small_home".equals(stringExtra)) {
            this.S = intent.getStringExtra("BIG_DATA_CHANNEL_URL");
        }
        this.H = layoutInflater.inflate(R.layout.dai, viewGroup, false);
        Nh(layoutInflater);
        initDtReport();
        return this.H;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.F.u();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        f fVar;
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("BIG_DATA_CHANNEL_URL");
        this.S = stringExtra;
        if (stringExtra == null || (fVar = this.G) == null) {
            return;
        }
        fVar.K();
        initData();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.F.v();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Uh();
        initData();
        this.F.w();
    }

    private String Kh(g gVar) {
        if (gVar != null && gVar.k()) {
            return (String) this.D.getResources().getText(R.string.xlv);
        }
        return (String) this.D.getResources().getText(R.string.xlm);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        if (z16) {
            this.G.s();
        } else {
            this.G.J();
        }
        this.K.setEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b extends i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333590a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f333591b;

        b(String str, g gVar) {
            this.f333590a = str;
            this.f333591b = gVar;
        }

        @Override // nk3.i
        public void onResultFailed() {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.bgedit.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBgEditFragment.b.this.c();
                }
            });
            QLog.i("ZPlanBackgroundEdit", 1, "updateSelectBgToNet failed" + this.f333591b.i());
        }

        @Override // nk3.i
        public void onResultForUpdateImage() {
            ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).saveUserBackgroundInfo(String.valueOf(this.f333590a), this.f333591b);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.bgedit.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBgEditFragment.b.this.d();
                }
            });
            QLog.i("ZPlanBackgroundEdit", 1, "updateSelectBgToNet success, url=" + this.f333591b.i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            QQToastUtil.showQQToast(1, R.string.xlx);
            ZPlanBgEditFragment.this.L.setEnabled(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            QQToastUtil.showQQToast(2, R.string.xly);
            ZPlanBgEditFragment zPlanBgEditFragment = ZPlanBgEditFragment.this;
            zPlanBgEditFragment.Hh(zPlanBgEditFragment.L);
            ZPlanBgEditFragment.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c extends i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f333593a;

        c(long j3) {
            this.f333593a = j3;
        }

        @Override // nk3.i
        public void onResultForDeleteImage() {
            ZPlanBgEditFragment.this.Rh(String.valueOf(this.f333593a));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.bgedit.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBgEditFragment.c.this.b();
                }
            });
            QLog.i("ZPlanBackgroundEdit", 1, "deleteBgToNet success");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QQToastUtil.showQQToast(2, R.string.xlq);
            ZPlanBgEditFragment.this.G.u();
            ZPlanBgEditFragment.this.Gh();
            ZPlanBgEditFragment.this.G.A().clear();
            ZPlanBgEditFragment.this.K.setEnabled(false);
            ZPlanBgEditFragment zPlanBgEditFragment = ZPlanBgEditFragment.this;
            zPlanBgEditFragment.Th(zPlanBgEditFragment.G.H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(g gVar) {
        if (gVar == null) {
            return;
        }
        if (gVar.k()) {
            this.L.setBackground(getResources().getDrawable(R.drawable.h6i));
        } else {
            this.L.o();
            this.L.setType(0);
        }
        this.L.setText(Kh(gVar));
    }

    public static void Wh(Activity activity, Intent intent) {
        if (intent != null && activity != null) {
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ZPlanBgEditFragment.class, 1001);
        } else {
            QLog.e("ZPlanBackgroundEdit", 1, "[startZPlanBackgroundEdit] error invalid param");
        }
    }
}
