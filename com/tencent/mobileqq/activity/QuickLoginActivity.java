package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QuickLoginActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    ListView f176940a0;

    /* renamed from: b0, reason: collision with root package name */
    ArrayList<HashMap<String, String>> f176941b0;

    /* renamed from: c0, reason: collision with root package name */
    SimpleAdapter f176942c0;

    /* renamed from: d0, reason: collision with root package name */
    private final com.tencent.mobileqq.login.aa f176943d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QuickLoginActivity.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                String str = QuickLoginActivity.this.f176941b0.get(i3).get("qq");
                String str2 = QuickLoginActivity.this.f176941b0.get(i3).get(NotificationActivity.PASSWORD);
                libsafeedit.getLoginLegal(str2);
                com.tencent.mobileqq.login.c r16 = new c.a(1, 1, str, str2).B(libsafeedit.byteSafeEditTextToMD5(Boolean.TRUE)).r();
                ILoginRegisterApi iLoginRegisterApi = (ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class);
                QuickLoginActivity quickLoginActivity = QuickLoginActivity.this;
                iLoginRegisterApi.accountLogin(quickLoginActivity, r16, quickLoginActivity.f176943d0);
                QQToast.makeText(QuickLoginActivity.this.getApplicationContext(), "logining...", 0).show();
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements com.tencent.mobileqq.login.aa {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QuickLoginActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QQToast.makeText(QuickLoginActivity.this.getApplicationContext(), "login cancel", 0).show();
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(com.tencent.mobileqq.login.aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) ajVar);
            } else {
                QQToast.makeText(QuickLoginActivity.this.getApplicationContext(), "login failure! check you qq and password!", 0).show();
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            } else {
                QQToast.makeText(QuickLoginActivity.this.getApplicationContext(), "login suc", 0).show();
            }
        }
    }

    public QuickLoginActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176943d0 = new b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G2() {
        Throwable th5;
        IOException e16;
        BufferedReader bufferedReader;
        ?? file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/com/tencent/mobileqq/quicklogin.txt");
        if (file.exists()) {
            try {
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) file)));
                    } catch (IOException e17) {
                        e16 = e17;
                        bufferedReader = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        file = 0;
                        if (file != 0) {
                        }
                        throw th5;
                    }
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            String[] split = readLine.split(" ");
                            if (split.length == 2) {
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("qq", split[0]);
                                hashMap.put(NotificationActivity.PASSWORD, split[1]);
                                this.f176941b0.add(hashMap);
                            }
                        }
                        bufferedReader.close();
                    } catch (IOException e18) {
                        e16 = e18;
                        e16.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
    }

    private void init() {
        this.f176940a0 = (ListView) findViewById(R.id.h2o);
        this.f176941b0 = new ArrayList<>();
        G2();
        initList();
    }

    private void initList() {
        ArrayList arrayList = new ArrayList();
        Iterator<HashMap<String, String>> it = this.f176941b0.iterator();
        while (it.hasNext()) {
            HashMap<String, String> next = it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("text", next.get("qq") + " " + next.get(NotificationActivity.PASSWORD));
            arrayList.add(hashMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.f167536y, new String[]{"text"}, new int[]{R.id.dqn});
        this.f176942c0 = simpleAdapter;
        this.f176940a0.setAdapter((ListAdapter) simpleAdapter);
        this.f176940a0.setOnItemClickListener(new a());
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
        super.setContentView(R.layout.f167535x);
        init();
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
