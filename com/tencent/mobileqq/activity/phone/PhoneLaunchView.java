package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class PhoneLaunchView extends BaseActivityView implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Button N;
    private boolean P;
    private int Q;

    public PhoneLaunchView(Activity activity, int i3) {
        super(activity, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, i3);
            return;
        }
        l(R.layout.f168369u6);
        Button button = (Button) c(R.id.phone_enable_btn);
        this.N = button;
        button.setOnClickListener(this);
        PhoneContactUtils.b(this.f183714d, getResources(), (ImageView) c(R.id.fmo));
    }

    private void x() {
        Intent intent = new Intent(getContext(), (Class<?>) BindNumberActivity.class);
        intent.putExtra("key_is_modal_pop", true);
        intent.putExtra("kSrouce", this.Q);
        u(intent, 1);
        k(R.anim.f155030h6, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void g(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1) {
            if (this.f183719m == 1) {
                this.f183718i.setResult(i16);
                d();
                return;
            }
            if (i16 == -1) {
                if (intent != null && intent.getBooleanExtra("refuse_upload", false)) {
                    d();
                    return;
                } else {
                    this.f183718i.setResult(i16, intent);
                    t(new Intent(getContext(), (Class<?>) ContactListView.class));
                    return;
                }
            }
            if (i16 == 0) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void h(Intent intent, PhoneInnerFrame phoneInnerFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) phoneInnerFrame);
            return;
        }
        if (intent != null) {
            if (intent.getBooleanExtra("k_start_number", false)) {
                this.P = true;
            }
            this.Q = intent.getIntExtra("kSrouce", -1);
        }
        super.h(intent, phoneInnerFrame);
        if (this.f183719m == 3) {
            ((TextView) c(R.id.fmp)).setText(R.string.f170099fy);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view == this.N) {
            int selfBindState = this.E.getSelfBindState();
            ReportController.o(this.f183714d, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
            if (selfBindState != 1 && selfBindState != 2 && selfBindState != 3 && selfBindState != 4) {
                if (selfBindState == 5) {
                    u(new Intent(getContext(), (Class<?>) BindNumberFromPcActivity.class), 1);
                    k(R.anim.f155030h6, R.anim.f154442w);
                } else {
                    o(HardCodeUtil.qqStr(R.string.p2y), HardCodeUtil.qqStr(R.string.p2u));
                }
            } else {
                ac.y0(6);
                x();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onStart();
        if (this.f183719m == 3) {
            this.I.setText(HardCodeUtil.qqStr(R.string.p2w));
        } else {
            this.I.setText(HardCodeUtil.qqStr(R.string.p2o));
        }
        this.H.setVisibility(8);
        if (this.P) {
            x();
        }
    }
}
