package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;

/* compiled from: P */
/* loaded from: classes9.dex */
public class qfileJumpActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected String f184643a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f184644b0;

    public qfileJumpActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int G2() {
        int i3 = this.f184644b0;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            return -1;
        }
        String str = AppConstants.DATALINE_PC_UIN;
        if (!str.equalsIgnoreCase(this.f184643a0) && !AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(this.f184643a0) && !AppConstants.DATALINE_PHONE_UIN.equalsIgnoreCase(this.f184643a0)) {
            return -1;
        }
        int i16 = this.f184644b0;
        if (i16 == 0) {
            if (!str.equalsIgnoreCase(this.f184643a0)) {
                return -2;
            }
            return 0;
        }
        if (i16 == 1) {
            if (!AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(this.f184643a0)) {
                return -2;
            }
            return 0;
        }
        if (!AppConstants.DATALINE_PHONE_UIN.equalsIgnoreCase(this.f184643a0)) {
            return -2;
        }
        return 0;
    }

    private void J2() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qfileJumpActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) qfileJumpActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Intent intent = new Intent();
                Intent intent2 = qfileJumpActivity.this.getIntent();
                if (intent2 != null && intent2.getExtras() != null) {
                    bundle = intent2.getExtras();
                } else {
                    bundle = new Bundle();
                }
                bundle.putString("leftBackText", HardCodeUtil.qqStr(R.string.q_p));
                bundle.putBoolean("isBack2Root", true);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtras(bundle);
                if (intent2 != null) {
                    intent.putExtras(intent2);
                    intent.setAction(intent2.getAction());
                    intent.setType(intent2.getType());
                    if ("android.intent.action.SEND_MULTIPLE".equals(intent2.getAction())) {
                        intent.setAction("android.intent.action.MAIN");
                        intent.putExtra("system_share_multi_send", true);
                    }
                }
                com.tencent.mobileqq.filemanager.fileassistant.util.h.t(qfileJumpActivity.this, intent);
                qfileJumpActivity.this.finish();
            }
        }, 10L);
    }

    protected void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (!this.app.isLogin()) {
            Intent intent2 = new Intent();
            intent2.setAction(intent.getAction());
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(extras);
            intent2.putExtras(intent);
            RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTER_LOGIN, 8);
            return;
        }
        if (BaseGesturePWDUtil.getJumpLock(this, this.app.getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(this)) {
            Intent intent3 = new Intent(getActivity(), (Class<?>) GesturePWDUnlockActivity.class);
            intent3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true);
            intent3.setAction(intent.getAction());
            intent3.putExtra("isActionSend", true);
            intent3.putExtras(extras);
            intent3.putExtras(intent);
            startActivityForResult(intent3, 8);
            return;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
            J2();
        } else {
            H2();
        }
    }

    protected void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qfileJumpActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) qfileJumpActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.statistics.s.a(qfileJumpActivity.this.app.getApplication().getApplicationContext(), qfileJumpActivity.this.app.getCurrentAccountUin(), "dl_share_my_pc");
                    Intent intent = qfileJumpActivity.this.getIntent();
                    try {
                        bundle = intent.getExtras();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        bundle = null;
                    }
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString("leftBackText", HardCodeUtil.qqStr(R.string.q_p));
                    bundle.putBoolean("isBack2Root", true);
                    Intent intent2 = new Intent(qfileJumpActivity.this, (Class<?>) LiteActivity.class);
                    intent2.addFlags(268435456);
                    intent2.addFlags(67108864);
                    intent2.putExtra("dataline_share_finish", false);
                    intent2.putExtras(bundle);
                    intent2.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, qfileJumpActivity.this.f184643a0);
                    intent2.putExtras(intent);
                    intent2.setAction(intent.getAction());
                    intent2.setType(intent.getType());
                    if (intent.getAction() == "android.intent.action.SEND_MULTIPLE") {
                        intent2.setAction("android.intent.action.MAIN");
                        intent2.putExtra("system_share_multi_send", true);
                    }
                    qfileJumpActivity.this.startActivity(intent2);
                    qfileJumpActivity.this.finish();
                }
            }, 10L);
        }
    }

    protected void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qfileJumpActivity.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) qfileJumpActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String str2;
                    String string;
                    String str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.dataline.util.b.n(qfileJumpActivity.this.app);
                    if (AppConstants.DATALINE_PC_UIN.equals(qfileJumpActivity.this.f184643a0)) {
                        string = qfileJumpActivity.this.getString(R.string.c5f);
                        str3 = PeerUid.DATALINE_PC_UID;
                    } else if (AppConstants.DATALINE_PHONE_UIN.equals(qfileJumpActivity.this.f184643a0)) {
                        string = qfileJumpActivity.this.getString(R.string.f16273218);
                        str3 = PeerUid.DATALINE_PHONE_UID;
                    } else if (AppConstants.DATALINE_IPAD_UIN.equals(qfileJumpActivity.this.f184643a0)) {
                        string = qfileJumpActivity.this.getString(R.string.f16272217);
                        str3 = PeerUid.DATALINE_PAD_UID;
                    } else {
                        str = "";
                        str2 = str;
                        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIO(qfileJumpActivity.this, 8, str, str2, 0L, null);
                        qfileJumpActivity.this.finish();
                    }
                    str2 = string;
                    str = str3;
                    ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIO(qfileJumpActivity.this, 8, str, str2, 0L, null);
                    qfileJumpActivity.this.finish();
                }
            }, 10L);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 == 8) {
                H2();
                return;
            } else if (i3 == 9) {
                I2();
                return;
            } else {
                finish();
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        try {
            super.doOnCreate(bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!com.tencent.mobileqq.utils.bh.a(this, true)) {
            super.finish();
            return false;
        }
        String str = AppConstants.DATALINE_PC_UIN;
        this.f184643a0 = str;
        Intent intent = getIntent();
        if (intent != null) {
            this.f184643a0 = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
            this.f184644b0 = intent.getIntExtra("device_type", -1);
            int G2 = G2();
            if (G2 != 0) {
                QLog.w("qfileJump", 1, "targetparam no match, modify it " + G2);
                this.f184644b0 = 0;
                this.f184643a0 = str;
                intent.putExtra("device_type", 0);
                intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, this.f184643a0);
            }
            if (!TextUtils.isEmpty(intent.getAction()) && (intent.getAction().equals("android.intent.action.SEND") || intent.getAction().equals("android.intent.action.SEND_MULTIPLE"))) {
                F2();
                return true;
            }
            if (intent.getBooleanExtra("jump_shortcut_dataline", false)) {
                if (!this.app.isLogin()) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(67371008);
                    intent2.putExtras(intent.getExtras());
                    RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTER_LOGIN, 9);
                } else if (BaseGesturePWDUtil.getJumpLock(this, this.app.getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(this)) {
                    Intent intent3 = new Intent(getActivity(), (Class<?>) GesturePWDUnlockActivity.class);
                    intent3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true);
                    intent3.putExtras(intent.getExtras());
                    startActivityForResult(intent3, 9);
                } else {
                    I2();
                }
                return true;
            }
        }
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            if (com.tencent.mobileqq.utils.bg.k(this)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return super.showPreview();
    }
}
