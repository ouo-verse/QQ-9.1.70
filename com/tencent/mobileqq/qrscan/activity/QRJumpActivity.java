package com.tencent.mobileqq.qrscan.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.qrscan.m;
import com.tencent.mobileqq.qrscan.o;
import com.tencent.mobileqq.qrscan.r;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRJumpActivity extends QBaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private AppRuntime f276585a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQProgressDialog f276586b0;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRJumpActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QRJumpActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends o {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f276588d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f276589e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f276590f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f276591h;

        b(String str, String str2, Activity activity, String str3) {
            this.f276588d = str;
            this.f276589e = str2;
            this.f276590f = activity;
            this.f276591h = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QRJumpActivity.this, str, str2, activity, str3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
        @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            m mVar;
            JSONObject jSONObject;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QRJumpActivity.this.isFinishing()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl onReceive suc=%b ", Boolean.valueOf(z16)));
            }
            Bundle bundle2 = null;
            if (z16 && bundle != null) {
                String string = bundle.getString("result");
                QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl onReceive result=%s", string));
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception unused) {
                }
                if (jSONObject.getInt("r") == 0) {
                    mVar = new m(jSONObject.getString("d"));
                    try {
                        if (jSONObject.has("wpa")) {
                            z17 = "1".equals(jSONObject.getString("wpa"));
                        } else {
                            z17 = false;
                        }
                        boolean has = jSONObject.has("extvalue");
                        if (!jSONObject.has("exttype") || (!"2".equals(jSONObject.getString("exttype")) && !"1".equals(jSONObject.getString("exttype")))) {
                            z18 = false;
                        }
                        Bundle bundle3 = new Bundle();
                        if (z17) {
                            try {
                                bundle3.putBoolean("issupportwpa", z17);
                            } catch (Exception unused2) {
                            }
                        }
                        if (z18 && has) {
                            String string2 = jSONObject.getString("exttype");
                            String string3 = jSONObject.getString("extvalue");
                            bundle3.putString("exttype", string2);
                            bundle3.putString("extvalue", string3);
                        }
                        bundle3.putString("authKey", this.f276588d);
                        bundle3.putString("authSig", this.f276589e);
                        bundle2 = bundle3;
                    } catch (Exception unused3) {
                    }
                    if (bundle2 != null) {
                        r.c(QRJumpActivity.this.f276585a0, this.f276590f, mVar, this.f276591h, bundle2);
                    }
                    this.f276590f.finish();
                }
            }
            mVar = null;
            if (bundle2 != null) {
            }
            this.f276590f.finish();
        }
    }

    public QRJumpActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String str;
        String str2;
        boolean z16;
        String decode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f276585a0 = getAppRuntime();
        String stringExtra = super.getIntent().getStringExtra("url");
        String stringExtra2 = super.getIntent().getStringExtra("attr_original_url");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return false;
        }
        if (isFinishing()) {
            return false;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.f276586b0 = qQProgressDialog;
        qQProgressDialog.setMessage(R.string.f2171660_);
        this.f276586b0.setOnCancelListener(new a());
        this.f276586b0.show();
        String str3 = null;
        try {
            str = URLDecoder.decode(stringExtra);
        } catch (Exception e16) {
            QLog.e("IQRScanConst_QRJumpActivity", 1, "QRJumpActivity doOnCreate URLDecoder.decode error:" + e16.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            finish();
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical()) {
            finish();
            return false;
        }
        String queryParameter = parse.getQueryParameter(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH);
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (stringExtra2.startsWith("mqqopensdkapi://bizAgent/")) {
                str2 = "authSig";
                z16 = true;
            } else {
                str2 = "authKey";
                z16 = false;
            }
            if (z16) {
                try {
                    decode = URLDecoder.decode(stringExtra2);
                } catch (Exception unused) {
                }
            } else {
                decode = stringExtra2;
            }
            Uri parse2 = Uri.parse(decode);
            if (decode != null) {
                str3 = parse2.getQueryParameter(str2);
            }
            str3 = URLDecoder.decode(str3);
        }
        String str4 = str3;
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl authSig=%s oriUrl=%s", str4, stringExtra2));
        }
        ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlDecode(this.f276585a0, str, null, null, new b(queryParameter, str4, this, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f276586b0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f276586b0.dismiss();
        }
        this.f276586b0 = null;
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
