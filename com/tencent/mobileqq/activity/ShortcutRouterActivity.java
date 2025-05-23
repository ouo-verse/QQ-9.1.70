package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ShortcutRouterActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ChatActivityUtils.u f177064a0;

    /* renamed from: b0, reason: collision with root package name */
    DialogInterface.OnClickListener f177065b0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements ChatActivityUtils.u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortcutRouterActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ShortcutRouterActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ShortcutRouterActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortcutRouterActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                ShortcutRouterActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortcutRouterActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                ShortcutRouterActivity.this.finish();
            }
        }
    }

    public ShortcutRouterActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f177065b0 = new c();
        }
    }

    private int F2(Intent intent) {
        int intExtra = intent.getIntExtra("uintype", -1);
        String stringExtra = intent.getStringExtra("uin");
        if (intExtra != -1 && stringExtra != null) {
            if (intent.getBooleanExtra("isTroopCard", false)) {
                return 0;
            }
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra), "qqBaseActivity")) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    private void G2() {
        String account = getAppRuntime().getAccount();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setGravity(17);
        textView.setTextSize(getResources().getInteger(R.integer.f167156i));
        textView.setTextColor(getResources().getColor(R.color.f156931fl));
        if (TextUtils.isEmpty(account)) {
            textView.setText(HardCodeUtil.qqStr(R.string.tfw));
        } else {
            textView.setText(HardCodeUtil.qqStr(R.string.tgb) + account + HardCodeUtil.qqStr(R.string.tge));
        }
        createCustomDialog.setNegativeButton(R.string.hkf, this.f177065b0);
        createCustomDialog.addView(textView);
        createCustomDialog.setOnDismissListener(new b());
        if (!isFinishing()) {
            createCustomDialog.show();
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
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (!this.app.isLogin()) {
            Intent intent2 = new Intent();
            intent2.addFlags(67371008);
            intent2.putExtra(AppConstants.Key.SHORTCUT_JUMP_KEY, getIntent());
            RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTER_LOGIN);
            finish();
            return false;
        }
        String stringExtra = intent.getStringExtra("shotcut_forward");
        boolean booleanExtra = intent.getBooleanExtra("open_chatfragment", false);
        String stringExtra2 = intent.getStringExtra("forward");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equals("starClub") && stringExtra.equals(ChatActivity.class.getName())) {
                intent.putExtra("uin", "1413778541");
                intent.putExtra("uinname", HardCodeUtil.qqStr(R.string.tgg));
                intent.putExtra("uintype", 1008);
                intent.putExtra("from", "starShortcut");
                intent.setClassName(this, stringExtra);
                intent.setFlags(67108864);
                startActivity(intent);
                return true;
            }
            int F2 = F2(intent);
            if (F2 != 1) {
                if (F2 != 2) {
                    if (stringExtra.equals(SplashActivity.getAliasName()) && booleanExtra) {
                        intent.setClassName(this, stringExtra);
                        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 4);
                        startActivity(intent);
                        finish();
                    } else {
                        String stringExtra3 = intent.getStringExtra("uin");
                        String stringExtra4 = intent.getStringExtra("uinname");
                        int intExtra = intent.getIntExtra("uintype", 0);
                        String stringExtra5 = intent.getStringExtra("extraUin");
                        if (this.f177064a0 == null) {
                            this.f177064a0 = new a();
                        }
                        if (ChatActivityUtils.h0(this.app, this, intExtra, stringExtra3, stringExtra4, null, true, stringExtra5, true, true, this.f177064a0, "from_internal")) {
                            finish();
                        }
                    }
                } else {
                    G2();
                    return true;
                }
            } else {
                QQToast.makeText(this, getString(R.string.hkd), 0).show(getTitleBarHeight());
                finish();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onStop();
            finish();
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
