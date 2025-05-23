package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AccountOnlineStateActivity extends QIphoneTitleBarFragment implements AccountOnlineStateBinder.b {
    private AppInterface C;
    private volatile QBaseActivity D;
    private AccountOnlineStateBinder E;
    private AccountOnlineStateViewModel F;
    private int G = 0;

    private void initUI() {
        setTitle(this.D.getString(R.string.hpw));
    }

    private void initViewModel() {
        Intent intent;
        com.tencent.mobileqq.mvvm.d ph5 = QLifeCycleFragment.ph(this.D);
        AccountOnlineStateViewModel accountOnlineStateViewModel = (AccountOnlineStateViewModel) com.tencent.mobileqq.mvvm.h.b(ph5, new com.tencent.mobileqq.onlinestatus.viewmodel.a(this.C)).get(AccountOnlineStateViewModel.class);
        this.F = accountOnlineStateViewModel;
        accountOnlineStateViewModel.a2();
        FragmentActivity activity = getActivity();
        AppRuntime.Status status = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        long j3 = 0;
        if (intent != null) {
            status = (AppRuntime.Status) intent.getSerializableExtra("KEY_ONLINE_STATUS");
            j3 = intent.getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
            this.G = intent.getIntExtra("KEY_ENTRANCE", 0);
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.C.getRuntimeService(IOnlineStatusService.class, "");
        if (status == null) {
            status = iOnlineStatusService.getOnlineStatus();
            j3 = af.C().M(this.C);
        }
        this.F.Q1().setValue(new com.tencent.mobileqq.onlinestatus.model.g(status, j3));
        this.F.S1().setValue(new com.tencent.mobileqq.onlinestatus.model.g(status, j3));
        this.F.h2(new com.tencent.mobileqq.onlinestatus.model.g(status, j3));
        AccountOnlineStateBinder accountOnlineStateBinder = new AccountOnlineStateBinder(this.C, this.D, this.F, this);
        this.E = accountOnlineStateBinder;
        accountOnlineStateBinder.D(((QIphoneTitleBarFragment) this).mContentView, this.F.Q1().getValue());
        this.E.s(ph5);
        this.E.t(ph5, this.F);
        this.E.q(ph5, this.F);
        this.E.r(ph5, this.F);
        this.E.v(ph5, this.F);
        this.E.u(ph5, this.F);
    }

    @Override // com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.b
    public void C3(boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateActivity", 2, "onSubmitted online status " + z16 + ", retCode = " + i3);
        }
        if (this.D == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.model.g value = this.F.Q1().getValue();
        if (value == null) {
            QLog.e("AccountOnlineStateActivity", 1, "onSubmitted: statusData == null");
            return;
        }
        if (z16) {
            if (!value.a(this.F.T1())) {
                QQToast.makeText(this.D, 2, R.string.hpl, 1).show();
            }
            Intent intent = new Intent();
            intent.putExtra(IOnLineStatueHelperApi.KEY_ONLINE_STATE_ACTIVITY_CHANGED_EXTID, value.f256023b);
            this.D.setResult(-1, intent);
        } else if (value.f256023b != 2000 || value.f256024c != null) {
            QQToast.makeText(this.D, 1, R.string.hpj, 1).show();
        }
        bv.a("0X800AF9D");
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (this.D != null) {
            this.C = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            initViewModel();
            initUI();
            this.F.Z1(this.C);
            ReportController.o(this.C, "dc00898", "", "", "0X800BDEC", "0X800BDEC", 4, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f167526s;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            if (i3 == 100 && i16 == 0) {
                bv.b("0X800AF4B", 2);
                return;
            }
            return;
        }
        if (i3 == 325) {
            if (i16 == 325) {
                this.E.E((AutoReplyText) intent.getParcelableExtra("AutoReplyEditActivity:text"));
                if (intent.getBooleanExtra("AutoReplyEditActivity:new_text", false) && this.D != null) {
                    QQToast.makeText(this.D, 2, R.string.f170525tt, 1).show();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 100) {
            this.F.X1(OnlineStatusPermissionChecker.b(intent, i16, this.D, this.C, false));
        } else if (i3 == kc2.a.REQUEST_CODE_BIRTHDAY) {
            this.E.z(i3, i16, intent);
        } else {
            this.E.B(i3, i16, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.D = getQBaseActivity();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        this.E.w(this.D);
        this.E.x();
        bv.b("0X800AF9C", 1);
        bv.b("0X800AF9B", 2);
        super.onBackEvent();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.D = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.E.M(view);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
