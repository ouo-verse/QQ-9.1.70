package com.tencent.mobileqq.activity.bless;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BlessSendTextActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    ArrayList<String> f180563a0;

    /* renamed from: b0, reason: collision with root package name */
    EditText f180564b0;

    /* renamed from: c0, reason: collision with root package name */
    View f180565c0;

    /* renamed from: d0, reason: collision with root package name */
    protected RelativeLayout f180566d0;

    /* renamed from: e0, reason: collision with root package name */
    int f180567e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f180568f0;

    /* renamed from: g0, reason: collision with root package name */
    private BlessManager f180569g0;

    public BlessSendTextActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f180567e0 = 0;
            this.f180568f0 = false;
        }
    }

    private void F2(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    private void G2() {
        if (this.f180567e0 < this.f180563a0.size()) {
            String obj = this.f180564b0.getText().toString();
            this.f180563a0.set(this.f180567e0, obj);
            this.f180569g0.G0(this.f180567e0, obj, this.f180563a0.size());
        }
    }

    private void initViews() {
        ((ImmersiveTitleBar2) findViewById(R.id.jq6)).setVisibility(4);
        View findViewById = findViewById(R.id.title);
        this.f180565c0 = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(R.color.f156824ch));
        findViewById(R.id.ivTitleBtnRightText).setOnClickListener(this);
        findViewById(R.id.at_).setOnClickListener(this);
        findViewById(R.id.ajx).setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.btb);
        this.f180564b0 = editText;
        editText.addTextChangedListener(this);
        ArrayList<String> arrayList = this.f180563a0;
        if (arrayList != null && arrayList.size() > 0) {
            this.f180564b0.setText(this.f180563a0.get(this.f180567e0));
            EditText editText2 = this.f180564b0;
            editText2.setSelection(editText2.getText().length());
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.a3r);
        this.f180566d0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) editable);
        } else {
            G2();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(1), "", "", "");
        finish();
        overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f167678e5);
        BlessManager blessManager = (BlessManager) this.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        this.f180569g0 = blessManager;
        this.f180563a0 = blessManager.j0();
        initViews();
        this.f180568f0 = getIntent().getBooleanExtra("fromoutweb", false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.at_) {
                ArrayList<String> arrayList = this.f180563a0;
                if (arrayList != null && arrayList.size() > 0) {
                    G2();
                    if (this.f180567e0 >= this.f180563a0.size() - 1) {
                        this.f180567e0 = 0;
                    } else {
                        this.f180567e0++;
                    }
                    this.f180564b0.setText(this.f180563a0.get(this.f180567e0));
                }
            } else if (id5 == R.id.ajx) {
                String obj = this.f180564b0.getText().toString();
                if (obj.equals("")) {
                    QQToast.makeText(this, R.string.f170606vd, 1).show();
                } else {
                    G2();
                    Intent intent = new Intent();
                    intent.putExtra("param_type", 9003);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 15);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, getString(R.string.f170612vu));
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, getString(R.string.a8j));
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 1);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_BLESSTYPE, 1);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_BLESSWORD_CONTENT, obj);
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivity(this, intent);
                    overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
                    ReportController.o(this.app, "CliOper", "", "", "0X800618C", "0X800618C", this.f180568f0 ? 1 : 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.a3r) {
                F2(this.f180564b0.getWindowToken());
            } else if (id5 == R.id.ivTitleBtnRightText) {
                close();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            close();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
