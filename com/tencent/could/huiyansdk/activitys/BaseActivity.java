package com.tencent.could.huiyansdk.activitys;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.LanguageStyle;
import com.tencent.could.huiyansdk.fragments.AuthingFragment;
import com.tencent.could.huiyansdk.fragments.BaseFragment;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.g;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.permission.c;
import com.tencent.could.huiyansdk.utils.s;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseActivity extends AppCompatActivity {
    static IPatchRedirector $redirector_;

    public BaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            Log.e("BaseActivity", "setChildContentView!");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
    
        if (r1 == null) goto L36;
     */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void attachBaseContext(Context context) {
        String str;
        String str2;
        Context a16;
        Locale locale;
        LocaleList locales;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Log.e("BaseActivity", "attachBaseContext");
        g gVar = g.a.f100181a;
        Context context2 = null;
        if (context != null) {
            LanguageStyle languageStyle = HuiYanSdkImp.getInstance().getLanguageStyle();
            if (languageStyle == LanguageStyle.AUTO) {
                Context a17 = HuiYanBaseApi.b.f100031a.a();
                if (a17 == null) {
                    k.a.f100197a.a(1, "LanguageManager", "huiyan base api, context is null!");
                } else {
                    if (Build.VERSION.SDK_INT >= 24) {
                        locales = a17.getResources().getConfiguration().getLocales();
                        locale = locales.get(0);
                    } else {
                        locale = a17.getResources().getConfiguration().locale;
                    }
                    if (locale != null) {
                        context2 = gVar.a(context, locale);
                    }
                }
                context2 = context;
            } else if (languageStyle == LanguageStyle.CUSTOMIZE_LANGUAGE) {
                String languageCode = HuiYanSdkImp.getInstance().getLanguageCode();
                if (!TextUtils.isEmpty(languageCode)) {
                    String[] split = languageCode.split("_");
                    if (split.length == 2) {
                        a16 = gVar.a(context, new Locale(split[0], split[1]));
                    } else {
                        String[] split2 = languageCode.split("-");
                        if (split2.length == 2) {
                            a16 = gVar.a(context, new Locale(split2[0], split2[1]));
                        }
                    }
                    context2 = a16;
                }
                context2 = context;
            } else {
                if (languageStyle == LanguageStyle.ENGLISH) {
                    str = "en";
                    str2 = "US";
                } else {
                    str = OcrConfig.CHINESE;
                    str2 = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
                }
                if (languageStyle == LanguageStyle.TRADITIONAL_CHINESE) {
                    str2 = "HK";
                }
                context2 = gVar.a(context, new Locale(str, str2));
            }
        }
        if (context2 != null) {
            HuiYanSdkImp.getInstance().setContextResReference(context2);
            super.attachBaseContext(context2);
        } else {
            super.attachBaseContext(context);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            HuiYanSdkImp.getInstance().setActivityExitFlag();
            super.finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            b.a.f100131a.a(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        requestWindowFeature(1);
        AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
        if (authUiConfig != null && authUiConfig.getMainActivityThemeId() != -1) {
            setTheme(authUiConfig.getMainActivityThemeId());
        }
        if (authUiConfig != null && authUiConfig.isUseDeepColorStatusBarIcon()) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        if (authUiConfig != null) {
            if (!authUiConfig.isTransparentStatusBar() && authUiConfig.getStatusBarColor() != -1) {
                getWindow().setStatusBarColor(authUiConfig.getStatusBarColor());
            }
            if (authUiConfig.isTransparentStatusBar()) {
                getWindow().addFlags(134217728);
                getWindow().clearFlags(67108864);
                getWindow().setStatusBarColor(0);
            }
        }
        if (HuiYanSdkImp.getInstance().getSdkConfig().isDisableSystemRecordScreen()) {
            getWindow().setFlags(8192, 8192);
        }
        getWindow().setFlags(16777216, 16777216);
        Log.e("BaseActivity", "open hardware accelerated!");
        super.onCreate(bundle);
        a();
        b bVar = b.a.f100131a;
        bVar.f100129b = getSupportFragmentManager();
        BaseFragment baseFragment = null;
        if (!TextUtils.isEmpty(bVar.f100128a)) {
            try {
                baseFragment = (BaseFragment) Class.forName(bVar.f100128a).newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                k.a.f100197a.a(2, "AuthFragmentManager", "");
            }
        }
        if (baseFragment != null) {
            b.a.f100131a.a(baseFragment);
        } else {
            b.a.f100131a.a(new AuthingFragment());
        }
        a.C1019a.f100038a.f100032a = new WeakReference<>(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        s sVar = s.a.f100325a;
        if (sVar.f100324b != null) {
            sVar.f100324b = null;
        }
        CountDownTimer countDownTimer = sVar.f100323a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            sVar.f100323a = null;
        }
        HuiYanSdkImp.getInstance().setActivityExitFlag();
        b bVar = b.a.f100131a;
        if (bVar.f100130c != null) {
            bVar.f100130c = null;
        }
        if (bVar.f100129b != null) {
            bVar.f100129b = null;
        }
        a.C1019a.f100038a.f100032a = new WeakReference<>(null);
        new WeakReference(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
        c cVar = c.a.f100268a;
        if (i3 == 119) {
            boolean z16 = false;
            for (int i16 : iArr) {
                if (i16 == -1) {
                    z16 = true;
                }
            }
            if (z16) {
                getPackageName();
                if (cVar.f100265a == null) {
                    AlertDialog.Builder cancelable = new AlertDialog.Builder(this).setMessage(getString(R.string.txy_permission_info_log)).setPositiveButton(getString(R.string.txy_ok), new com.tencent.could.huiyansdk.permission.b(cVar)).setCancelable(true);
                    cVar.f100267c = new WeakReference<>(this);
                    AlertDialog create = cancelable.create();
                    cVar.f100265a = create;
                    create.setCanceledOnTouchOutside(false);
                }
                cVar.f100265a.show();
                return;
            }
            com.tencent.could.huiyansdk.permission.a aVar = cVar.f100266b;
            if (aVar != null) {
                ((com.tencent.could.huiyansdk.fragments.a) aVar).b();
                cVar.a();
                cVar.b();
            }
        }
    }
}
