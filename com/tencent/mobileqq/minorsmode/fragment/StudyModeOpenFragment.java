package com.tencent.mobileqq.minorsmode.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeBaseFragment;
import com.tencent.mobileqq.studymode.p;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class StudyModeOpenFragment extends StudyModeBaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int E;
    private int F;
    private int G;
    private int H;
    private TextView I;
    private TextView J;
    private QUIButton K;
    private TextView L;
    private TextView M;
    private CheckBox N;
    private QQAppInterface P;
    private FragmentActivity Q;
    private boolean R = true;

    private void zh() {
        FragmentActivity fragmentActivity = this.Q;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(0, fragmentActivity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.P = (QQAppInterface) appRuntime;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.i("StudyModeOpenFragment", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        if (i3 != 2 || i16 != -1 || intent == null || this.Q == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("extra_mode_change_success", false);
        int intExtra = intent.getIntExtra("extra_target_mode", -1);
        int intExtra2 = intent.getIntExtra("extra_old_mode", -1);
        boolean booleanExtra2 = intent.getBooleanExtra("key_is_jump_to_next", false);
        QLog.i("StudyModeOpenFragment", 1, "doOnActivityResult REQ_CHANGE_STUDY_MODEL_SWITCH, targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + this.G + ", jumpToNext: " + booleanExtra2 + ", modeChangeSuc:" + booleanExtra);
        if (booleanExtra) {
            if (p.g(this.G)) {
                yh(intExtra, intExtra2, booleanExtra2, booleanExtra);
            }
            this.Q.setResult(-1, intent);
            this.Q.finish();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        QUIButton qUIButton = this.K;
        if (qUIButton != null) {
            qUIButton.setEnabled(z16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.f897050h) {
            this.N.setChecked(!r12.isChecked());
            return;
        }
        if (view.getId() == R.id.f897150i) {
            if (!this.R) {
                QLog.d("StudyModeOpenFragment", 1, "can not go to browser, wait!!! ");
                return;
            }
            this.R = false;
            this.L.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minorsmode.fragment.StudyModeOpenFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    StudyModeOpenFragment.this.R = true;
                }
            }, 1000L);
            try {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.Q, RouterConstants.UI_ROUTE_BROWSER);
                activityURIRequest.extra().putString("url", "https://rule.tencent.com/rule/preview/9b3a1d99-425a-469c-88eb-3ad4406180a3");
                QRoute.startUri(activityURIRequest, (o) null);
                return;
            } catch (Exception e16) {
                QLog.d("StudyModeOpenFragment", 1, "open TERMS_OF_TEENAGER_FEATURES url exception: ", e16);
                return;
            }
        }
        if (view.getId() == R.id.f896950g) {
            xh("0X800BF46", this.H);
            if (JumpKidModeMgr.b().g(this.E, this.F, this.P, this.Q, this.G, 3)) {
                return;
            }
            KidModeServlet.m(this.P);
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.Q = activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            this.E = intent.getIntExtra("extra_target_mode", -1);
            this.F = intent.getIntExtra("extra_old_mode", -1);
            this.G = intent.getIntExtra("extra_source", -1);
            this.H = intent.getIntExtra("extra_source_for_report", -1);
            zh();
        }
        xh("0X800BF44", this.H);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.I = (TextView) view.findViewById(R.id.f896750e);
        this.J = (TextView) view.findViewById(R.id.f896650d);
        TextView textView = (TextView) view.findViewById(R.id.f897150i);
        this.L = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.f897050h);
        this.M = textView2;
        textView2.setOnClickListener(this);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.f26290d5);
        this.N = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ddu);
        UIUtils.c(this.N, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f896950g);
        this.K = qUIButton;
        qUIButton.setOnClickListener(this);
        this.K.setEnabled(this.N.isChecked());
        sh();
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void qh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.inflate(R.layout.hr6, viewGroup, true);
    }

    private void yh(int i3, int i16, boolean z16, boolean z17) {
        int i17;
        if (i3 == -1 || i16 == -1 || (i17 = this.G) == -1) {
            return;
        }
        if (z16) {
            KidModeAdvanceSettingFragment.Wh(this.Q, true, i17);
        } else {
            JumpKidModeMgr.b().i(i16, i3, this.Q, this.G, p.d(i17), false);
        }
        ElderModeManager.m(z17, i3, i16, this.Q);
    }

    private void xh(String str, int i3) {
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
                QLog.d("StudyModeOpenFragment", 1, "reportData exp!!! srcForReport:" + i3);
                return;
            }
            ReportController.o(getAppRuntime(), "dc00898", "", "", str, str, e16, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    public void sh() {
    }
}
