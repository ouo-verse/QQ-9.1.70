package com.tencent.luggage.wxa.o1;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.c5.d;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.l3.i;
import com.tencent.luggage.wxa.ok.o;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.t0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.j;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends AppCompatActivity implements LuggageActivityHelper.g, t0 {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f136073a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.o1.a f136074b;

    /* renamed from: d, reason: collision with root package name */
    public o f136076d;

    /* renamed from: e, reason: collision with root package name */
    public Configuration f136077e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f136078f;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ol.a f136075c = new com.tencent.luggage.wxa.ol.a(this);

    /* renamed from: g, reason: collision with root package name */
    public boolean f136079g = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.kk.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.kk.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            return b.this;
        }

        @Override // com.tencent.luggage.wxa.kk.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Activity getContext() {
            return b.this;
        }

        @Override // com.tencent.luggage.wxa.kk.a
        public FrameLayout getContainer() {
            return b.this.f136073a;
        }

        @Override // com.tencent.luggage.wxa.kk.a
        public boolean runInStandaloneTask() {
            return a().o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        com.tencent.luggage.wxa.o1.a j3 = j();
        if (j3 != null) {
            j3.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        new com.tencent.luggage.wxa.am.b(this, false).a(getString(R.string.f242247u2)).a();
    }

    public final boolean a(Intent intent, String str) {
        try {
            if (!f.a(this, intent)) {
                return false;
            }
            com.tencent.luggage.wxa.e5.a.a((Activity) this);
            w.d("Luggage.BaseContainerActivity", "handleOpenSDKApiClientResponse, intent:%s, activity:%d, reason:%s, handled", intent, Integer.valueOf(hashCode()), str);
            return true;
        } catch (Exception e16) {
            w.b("Luggage.BaseContainerActivity", "handleOpenSDKApiClientResponse, intent:%s, activity:%d, reason:%s, get exception:%s", intent, Integer.valueOf(hashCode()), str, e16);
            return false;
        }
    }

    public final boolean b(Intent intent, String str) {
        boolean z16;
        boolean z17;
        if (intent.getBooleanExtra("intentForStartWxa", false)) {
            return false;
        }
        if ((intent.getFlags() & 268435456) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean equals = j.a(intent.getComponent()).equals(j.a(getComponentName()));
        if (e.d.HIDE == e.d(str)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((z16 && !equals) || !z17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.t0
    public final void d() {
        a();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        g f16;
        com.tencent.luggage.wxa.o1.a j3 = j();
        if (j3 != null && (f16 = j3.f()) != null && f16.a(keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        w.a("Luggage.BaseContainerActivity", "onKeyDown: keyCode = [%d], keyAction =[%d]", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.luggage.wxa.ol.t0
    public final void e() {
        a(this);
    }

    @Override // android.app.Activity
    public void finish() {
        if (!isDestroyed() && !isFinishing()) {
            this.f136074b.H();
            this.f136074b.a(d.g.Finish);
            if (o()) {
                super.finishAndRemoveTask();
            } else {
                super.finish();
            }
            p();
        }
    }

    public com.tencent.luggage.wxa.kk.a g() {
        return new a();
    }

    public FrameLayout h() {
        if (this.f136073a == null) {
            this.f136073a = new FrameLayout(this);
        }
        return this.f136073a;
    }

    @Override // com.tencent.luggage.wxa.ol.t0
    public final void hideVKB(View view) {
        a(view);
    }

    public abstract Class i();

    public com.tencent.luggage.wxa.o1.a j() {
        return this.f136074b;
    }

    public abstract Class k();

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z16) {
        boolean moveTaskToBack = super.moveTaskToBack(z16);
        if (moveTaskToBack) {
            p();
        }
        return moveTaskToBack;
    }

    public boolean o() {
        ActivityInfo activityInfo;
        String str;
        Boolean bool = this.f136078f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (z.c() == null) {
            z.b(getApplicationContext());
        }
        PackageManager packageManager = z.c().getPackageManager();
        boolean z16 = false;
        try {
            ComponentName componentName = getComponentName();
            if (componentName == null) {
                componentName = new ComponentName(z.c(), getClass());
            }
            activityInfo = packageManager.getActivityInfo(componentName, 128);
        } catch (Exception e16) {
            w.b("Luggage.BaseContainerActivity", "runInStandaloneTask, resolve info e = %s", e16);
            activityInfo = null;
        }
        if (activityInfo == null) {
            w.b("Luggage.BaseContainerActivity", "runInStandaloneTask is null, return true");
            return true;
        }
        try {
            str = InstalledAppListMonitor.getPackageInfo(packageManager, z.h(), 0).applicationInfo.taskAffinity;
        } catch (Exception e17) {
            w.b("Luggage.BaseContainerActivity", "getPackageInfo fail, use default. e = %s", e17);
            str = "";
        }
        if (str.isEmpty()) {
            str = z.h();
        }
        w.d("Luggage.BaseContainerActivity", "runInStandaloneTask targetAffinityName:[%s] info.taskAffinity:[%s]", z.h(), activityInfo.taskAffinity);
        if (str.equals(activityInfo.taskAffinity) || w0.d(activityInfo.taskAffinity).endsWith(str)) {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(!z16);
        this.f136078f = valueOf;
        return valueOf.booleanValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        w.d("Luggage.BaseContainerActivity", "onActivityResult requestCode:%d, resultCode:%d, data:%s", Integer.valueOf(i3), Integer.valueOf(i16), intent);
        LuggageActivityHelper.FOR(this).onActivityResult(i3, i16, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.tencent.luggage.wxa.o1.a aVar = this.f136074b;
        if (aVar != null && aVar.f() != null) {
            this.f136074b.C();
            return;
        }
        try {
            String stringExtra = getIntent().getStringExtra("wxaLaunchInstanceId");
            if (!w0.c(stringExtra)) {
                x.f129431a.a(stringExtra, x.d.CLOSE_BEFORE_START);
            } else {
                w.b("Luggage.BaseContainerActivity", "onInstanceCompleted fail: wxaLaunchInstanceId is null");
            }
        } catch (Exception e16) {
            w.b("Luggage.BaseContainerActivity", "onInstanceCompleted fail: %s", e16);
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f136075c.a(configuration);
        com.tencent.luggage.wxa.o1.a aVar = this.f136074b;
        if (aVar != null) {
            aVar.a(configuration);
        }
        this.f136074b.a(configuration);
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) this.f136074b.f();
        Configuration configuration2 = this.f136077e;
        if (configuration2 != null && com.tencent.luggage.wxa.qk.a.a(eVar, configuration2, configuration)) {
            recreate();
        }
        this.f136077e = new Configuration(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.tencent.luggage.wxa.lk.j.b(null);
        com.tencent.luggage.wxa.lk.j.c(null, "public:prepare", "Activity#onCreate");
        super.onCreate(bundle);
        this.f136077e = new Configuration(getResources().getConfiguration());
        if (a(getIntent(), "onCreate")) {
            super.finish();
            return;
        }
        if (getIntent().getBooleanExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", false) && !i.a(new com.tencent.luggage.wxa.d6.b(), getIntent())) {
            super.finish();
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        getWindow().setFlags(16777216, 16777216);
        if (i3 >= 28 && getWindow() != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        this.f136075c.d();
        FrameLayout h16 = h();
        this.f136073a = h16;
        a(h16);
        this.f136075c.a(this.f136073a);
        this.f136074b = (com.tencent.luggage.wxa.o1.a) Reflect.on((Class<?>) k()).create(g(), i()).get();
        com.tencent.luggage.wxa.lk.j.a(null, "public:prepare", "Activity#performLaunch");
        this.f136074b.a(getIntent(), "onCreate");
        com.tencent.luggage.wxa.lk.j.c(null);
        this.f136074b.a(new q(this, this.f136073a));
        q();
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: l31.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                com.tencent.luggage.wxa.o1.b.this.l();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tencent.luggage.wxa.o1.a aVar = this.f136074b;
        if (aVar != null) {
            aVar.a(d.g.OnDestroy);
            w.c();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        com.tencent.luggage.wxa.o1.a aVar = this.f136074b;
        if (aVar != null) {
            aVar.K();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (a(intent, "onNewIntent")) {
            return;
        }
        if (intent.getBooleanExtra("com.tencent.luggage.container.BaseContainerActivity.INTENT_KEY_BRING_TO_FRONT", false)) {
            com.tencent.luggage.wxa.e5.a.a((Activity) this);
            return;
        }
        if (this.f136074b.a(intent, "onNewIntent")) {
            setIntent(intent);
            q();
        } else {
            g f16 = this.f136074b.f();
            if (f16 != null) {
                e.a(f16.getAppId(), intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f136074b.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        this.f136074b.a(i3, strArr, iArr);
        LuggageActivityHelper.FOR(this).onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f136074b.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (this.f136079g) {
            this.f136079g = false;
            recreate();
        }
        super.onStart();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        this.f136075c.a(layoutParams);
    }

    public final void p() {
        if (this.f136076d == null) {
            this.f136076d = (o) com.tencent.luggage.wxa.h1.e.a(o.class);
        }
        o oVar = this.f136076d;
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public final void q() {
        if (this.f136076d == null) {
            this.f136076d = (o) com.tencent.luggage.wxa.h1.e.a(o.class);
        }
        o oVar = this.f136076d;
        if (oVar != null) {
            oVar.a(this, null);
        }
    }

    @Override // android.app.Activity
    public final void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (o()) {
            try {
                super.setTaskDescription(taskDescription);
            } catch (Exception e16) {
                w.a("Luggage.BaseContainerActivity", e16, "setTaskDescription ", new Object[0]);
                if (taskDescription != null) {
                    try {
                        super.setTaskDescription(new ActivityManager.TaskDescription(taskDescription.getLabel(), (Bitmap) null, taskDescription.getPrimaryColor()));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        try {
            ((com.tencent.luggage.wxa.c5.e) j().f()).Y().getReporter().a(intent);
        } catch (Exception unused) {
        }
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) this.f136074b.f();
        if (eVar != null && intent != null) {
            String appId = eVar.getAppId();
            if (b(intent, appId)) {
                e.a(appId, e.d.LAUNCH_NATIVE_PAGE);
            }
        }
        try {
            super.startActivityForResult(intent, i3, bundle);
        } catch (ActivityNotFoundException e16) {
            if (intent != null && w0.d(intent.getAction()).startsWith("android.intent.action")) {
                w.a("Luggage.BaseContainerActivity", e16, IAELaunchRecorder.MILESTONE_START_ACTIVITY, new Object[0]);
                runOnUiThread(new Runnable() { // from class: l31.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.o1.b.this.m();
                    }
                });
                return;
            }
            throw e16;
        }
    }

    public void a(FrameLayout frameLayout) {
        setContentView(frameLayout);
    }

    @Override // com.tencent.luggage.wxa.ol.t0
    public final boolean a() {
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return a((View) h());
        }
        return a(currentFocus);
    }

    public final boolean a(View view) {
        InputMethodManager inputMethodManager;
        IBinder windowToken;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || (windowToken = view.getWindowToken()) == null) {
            return false;
        }
        try {
            return inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e16) {
            w.b("Luggage.BaseContainerActivity", "hide VKB(View) exception %s", e16);
            return false;
        }
    }

    public void a(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || (currentFocus = activity.getCurrentFocus()) == null || currentFocus.getWindowToken() == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 2);
    }
}
