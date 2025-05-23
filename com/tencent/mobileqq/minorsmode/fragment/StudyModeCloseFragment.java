package com.tencent.mobileqq.minorsmode.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.pad.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.StudyModeBaseFragment;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.p;
import com.tencent.mobileqq.studymode.t;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class StudyModeCloseFragment extends StudyModeBaseFragment implements View.OnClickListener {
    private int E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private QQAppInterface J;
    private FragmentActivity K;
    private LinearLayout L;
    private TextView M;
    private RelativeLayout N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private QUIButton V;
    private boolean W;
    private final f.d X = new a();
    private final f.d Y = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements f.d {
        a() {
        }

        @Override // com.tencent.common.config.pad.f.d
        public void a(int i3, int i16, String str) {
            QLog.d("StudyModeCloseFragment", 1, "listenerForAdvance onCredentialConfirmResult type:" + i3 + ",confirmResultCode:" + i16 + ",resultMsg:" + str);
            if (i16 == 100) {
                if (StudyModeCloseFragment.this.K == null) {
                    QLog.d("StudyModeCloseFragment", 1, "launchCredentialConfirmController RESULT_SUCCEEDED context is null");
                } else {
                    KidModeAdvanceSettingFragment.Vh(StudyModeCloseFragment.this.K, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements f.d {
        b() {
        }

        @Override // com.tencent.common.config.pad.f.d
        public void a(int i3, int i16, String str) {
            MinorsModeKnowType minorsModeKnowType = MinorsModeKnowType.INVALID;
            if (StudyModeCloseFragment.this.F == 2) {
                if (StudyModeCloseFragment.this.E == 3) {
                    minorsModeKnowType = MinorsModeKnowType.CLOSE_ALONE_TO_ELDER;
                } else {
                    minorsModeKnowType = MinorsModeKnowType.CLOSE_ALONE;
                }
                StudyModeManager.Q(false);
                if (StudyModeCloseFragment.this.E != 3) {
                    t.d(StudyModeCloseFragment.this.E, StudyModeCloseFragment.this.J, StudyModeCloseFragment.this.K, null);
                }
            }
            ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startMinorsModeKnowFragment(BaseApplication.getContext(), minorsModeKnowType, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Bh(WeakReference weakReference, int i3, int i16, String str) {
        f.d dVar = (f.d) weakReference.get();
        if (dVar != null) {
            dVar.a(i3, i16, str);
        }
    }

    private void Eh(int i3, f.d dVar) {
        if (StudyModeManager.l() == 2) {
            JumpKidModeMgr.b().k(-1, -1, 1, this.J, i3, this.K, 2);
        } else {
            Ch(this.K, dVar);
        }
    }

    private void Fh() {
        FragmentActivity fragmentActivity = this.K;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(0, fragmentActivity.getIntent());
        }
    }

    private void Gh(View view) {
        if (this.W) {
            TextView textView = (TextView) view.findViewById(R.id.ykb);
            this.U = textView;
            if (textView == null || FontSettingManager.getFontLevel() < 18.0f) {
                return;
            }
            Resources resources = getResources();
            this.U.setPadding(BaseAIOUtils.f(10.0f, resources), 0, BaseAIOUtils.f(10.0f, resources), 0);
            return;
        }
        TextView textView2 = (TextView) view.findViewById(R.id.yka);
        this.R = textView2;
        if (textView2 != null) {
            Drawable drawable = getResources().getDrawable(rh() ? R.drawable.mzs : R.drawable.mzr);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.R.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.J = (QQAppInterface) appRuntime;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        super.onActivityResult(i3, i16, intent);
        QLog.i("StudyModeCloseFragment", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        if (i3 != 2) {
            if (i3 == 6) {
                if (i16 != -1 || (fragmentActivity2 = this.K) == null) {
                    return;
                }
                Ch(fragmentActivity2, this.Y);
                return;
            }
            if (i3 == 7 && i16 == -1 && (fragmentActivity = this.K) != null) {
                Ch(fragmentActivity, this.X);
                return;
            }
            return;
        }
        if (i16 != -1 || intent == null || this.K == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("extra_mode_change_success", false);
        int intExtra = intent.getIntExtra("extra_target_mode", -1);
        int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
        if (booleanExtra) {
            if (p.g(this.G)) {
                ElderModeManager.m(booleanExtra, intExtra, intExtra2, this.K);
            }
            this.K.setResult(-1, intent);
            this.K.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentActivity fragmentActivity;
        if (view.getId() == R.id.f896350a) {
            Dh("0X800BF9A", this.H);
            if (this.J == null || this.K == null) {
                return;
            }
            if (!com.tencent.common.config.pad.f.o()) {
                int i3 = this.G;
                if (i3 == 2) {
                    i3 = 3;
                }
                int i16 = i3;
                QLog.d("StudyModeCloseFragment", 2, "newSrc:" + i16);
                if (JumpKidModeMgr.b().g(this.E, this.F, this.J, this.K, i16, 4)) {
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show();
                return;
            }
            Eh(6, this.X);
            return;
        }
        if (view.getId() == R.id.f896250_) {
            Dh("0X800BF99", this.H);
            if (this.J == null || (fragmentActivity = this.K) == null) {
                return;
            }
            if (!this.I) {
                KidModeAdvanceSettingFragment.Vh(fragmentActivity, false);
                return;
            }
            if (this.G == 5) {
                fragmentActivity.setResult(-1, fragmentActivity.getIntent());
                this.K.finish();
            } else if (com.tencent.common.config.pad.f.o()) {
                Eh(7, this.X);
            } else {
                JumpKidModeMgr.b().l(-1, -1, 1, this.J, this.K, this.G);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.K = activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            this.E = intent.getIntExtra("extra_target_mode", -1);
            this.F = intent.getIntExtra("extra_old_mode", -1);
            this.G = intent.getIntExtra("extra_source", -1);
            this.H = intent.getIntExtra("extra_source_for_report", -1);
            this.I = intent.getBooleanExtra("extra_to_adv_setting_need_pwd", true);
            Fh();
        }
        Dh("0X800BF98", this.H);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        sh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.M = (TextView) view.findViewById(R.id.f896750e);
        this.N = (RelativeLayout) view.findViewById(R.id.vdf);
        this.P = (TextView) view.findViewById(R.id.vdp);
        this.Q = (TextView) view.findViewById(R.id.sur);
        this.S = (TextView) view.findViewById(R.id.zof);
        this.T = (TextView) view.findViewById(R.id.ymb);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f896250_);
        this.L = linearLayout;
        linearLayout.setOnClickListener(this);
        QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f896350a);
        this.V = qUIButton;
        qUIButton.setOnClickListener(this);
        Gh(view);
        sh();
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void qh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean isFeatureSwitchEnable = peekAppRuntime == null ? true : ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("study_mode_close_fragment_show_little_world_tip");
        this.W = isFeatureSwitchEnable;
        layoutInflater.inflate(isFeatureSwitchEnable ? R.layout.f169098hr4 : R.layout.hr5, viewGroup, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    public void sh() {
        super.sh();
        boolean rh5 = rh();
        Resources resources = getResources();
        this.M.setTextColor(rh5 ? -1 : getResources().getColor(R.color.csy));
        this.N.setBackgroundResource(rh5 ? R.drawable.f162493lo2 : R.drawable.f162492lo1);
        this.P.setTextColor(getResources().getColor(rh5 ? R.color.csu : R.color.cst));
        int dip2px = ViewUtils.dip2px(34.0f);
        Drawable drawable = resources.getDrawable(R.drawable.qui_mini_program_icon);
        drawable.setBounds(0, 0, dip2px, dip2px);
        this.Q.setCompoundDrawables(null, drawable, null, null);
        Drawable drawable2 = resources.getDrawable(R.drawable.qui_position_icon);
        drawable2.setBounds(0, 0, dip2px, dip2px);
        this.S.setCompoundDrawables(null, drawable2, null, null);
        Drawable drawable3 = resources.getDrawable(R.drawable.qui_video_on_icon);
        drawable3.setBounds(0, 0, dip2px, dip2px);
        this.T.setCompoundDrawables(null, drawable3, null, null);
    }

    private void Ch(Context context, f.d dVar) {
        if (context == null) {
            QLog.d("StudyModeCloseFragment", 1, "lunchCredentialConfirm context is null");
        } else {
            final WeakReference weakReference = new WeakReference(dVar);
            com.tencent.common.config.pad.f.p(context, new f.d() { // from class: com.tencent.mobileqq.minorsmode.fragment.j
                @Override // com.tencent.common.config.pad.f.d
                public final void a(int i3, int i16, String str) {
                    StudyModeCloseFragment.Bh(WeakReference.this, i3, i16, str);
                }
            });
        }
    }

    private void Dh(String str, int i3) {
        int i16;
        if (i3 != -1) {
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    i16 = -1;
                }
            } else {
                i16 = 1;
            }
            int e16 = p.e(i3, i16);
            if (e16 == -1) {
                QLog.d("StudyModeCloseFragment", 1, "reportData exp!!! srcForReport:" + i3);
                return;
            }
            ReportController.o(getAppRuntime(), "dc00898", "", "", str, str, e16, 0, "", "", "", "");
        }
    }
}
