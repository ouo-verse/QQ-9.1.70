package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLocationModifyActivity extends TroopCreateMapViewSupportActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    long f293676g0;

    /* renamed from: h0, reason: collision with root package name */
    Dialog f293677h0;

    /* renamed from: i0, reason: collision with root package name */
    Boolean f293678i0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLocationModifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        TroopLocationModifyActivity.this.U2();
                        return;
                    }
                    return;
                }
                TroopLocationModifyActivity.this.V2(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLocationModifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            TroopLocationModifyActivity troopLocationModifyActivity = TroopLocationModifyActivity.this;
            if (dialogInterface == troopLocationModifyActivity.f293677h0) {
                troopLocationModifyActivity.f293677h0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLocationModifyActivity.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            TroopLocationModifyActivity.this.W2();
            if (i3 == 0) {
                TroopLocationModifyActivity.this.Y2("");
            }
        }
    }

    public TroopLocationModifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293676g0 = 0L;
            this.f293678i0 = Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(String str) {
        String str2;
        String[] split = str.split("\\|");
        if (split.length >= 4) {
            str2 = split[3];
        } else {
            str2 = "";
        }
        Intent intent = new Intent();
        intent.putExtra("location", str2);
        intent.putExtra("locationOriginal", str);
        setResult(-1, intent);
        finish();
    }

    public static void startModifyLocationActivityForResult(Activity activity, String str, String str2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) TroopLocationModifyActivity.class);
        intent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
        intent.putExtra("troopUin", str);
        intent.putExtra("troopLocation", str2);
        activity.startActivityForResult(intent, i3);
    }

    public static void startModifyLocationActivityForResultEx(Activity activity, String str, String str2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) TroopLocationModifyActivity.class);
        intent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
        intent.putExtra("saveDirect", false);
        intent.putExtra("troopUin", str);
        intent.putExtra("troopLocation", str2);
        activity.startActivityForResult(intent, i3);
    }

    public void U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        W2();
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setMainTitle(R.string.i9f);
        actionSheet.addButton(R.string.i9g, 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new b());
        actionSheet.setOnButtonClickListener(new c());
        this.f293677h0 = actionSheet;
        actionSheet.show();
    }

    protected void V2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else if (!isFinishing()) {
            setResult(i3);
            finish();
        }
    }

    protected void W2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Dialog dialog = this.f293677h0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f293677h0.dismiss();
            }
            this.f293677h0 = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity, com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 41) {
            if (intent != null && i16 == -1) {
                int intExtra = intent.getIntExtra("errCode", -1);
                boolean booleanExtra = intent.getBooleanExtra("isClear", false);
                String stringExtra = intent.getStringExtra("location");
                int intExtra2 = intent.getIntExtra(QCircleSchemeAttr.Polymerize.LAT, 0);
                int intExtra3 = intent.getIntExtra("lon", 0);
                if (intExtra == 0) {
                    if (booleanExtra) {
                        QQToast.makeText(this, R.string.i9e, 0).show(getTitleBarHeight());
                    } else {
                        QQToast.makeText(this, R.string.i9j, 0).show(getTitleBarHeight());
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("location", stringExtra);
                    intent2.putExtra(QCircleSchemeAttr.Polymerize.LAT, intExtra2);
                    intent2.putExtra("lon", intExtra3);
                    setResult(-1, intent2);
                    finish();
                } else {
                    if (intExtra == 1002) {
                        string = getString(R.string.i9r);
                    } else if (booleanExtra) {
                        string = getString(R.string.i9d);
                    } else {
                        string = getString(R.string.i9i);
                    }
                    QQToast.makeText(this, string, 0).show(getTitleBarHeight());
                    N2();
                }
            } else {
                super.doOnActivityResult(i3, i16, intent);
                return;
            }
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity, com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("troopUin");
        this.f293678i0 = Boolean.valueOf(extras.getBoolean("saveDirect", true));
        this.f293676g0 = Long.parseLong(string);
        View findViewById = findViewById(R.id.rlCommenTitle);
        if (findViewById instanceof NavBarCommon) {
            NavBarCommon navBarCommon = (NavBarCommon) findViewById;
            navBarCommon.setRightButton(getString(R.string.f23265755));
            navBarCommon.setOnItemSelectListener(new a());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity, com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
