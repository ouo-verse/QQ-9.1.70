package com.tencent.mobileqq.ark.core;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkView;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.api.IArkSoPreLoader;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.ark.base.DefaultApplicationCallback;
import com.tencent.mobileqq.ark.config.qqmc.ArkExtendConfParser;
import com.tencent.mobileqq.ark.core.e;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

/* loaded from: classes11.dex */
public class ArkMultiProc {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f199300a = false;

    /* renamed from: b, reason: collision with root package name */
    static boolean f199301b = false;

    /* renamed from: c, reason: collision with root package name */
    static QActivityLifecycleCallbacks f199302c = new b();

    /* renamed from: d, reason: collision with root package name */
    static final IArkDelegateSetup f199303d = new c();

    /* renamed from: e, reason: collision with root package name */
    static final IArkDelegateNet f199304e = new d();

    /* renamed from: f, reason: collision with root package name */
    static final IArkDelegateSSO f199305f = new e();

    /* renamed from: g, reason: collision with root package name */
    protected static final ark.ApplicationCallback f199306g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements OnLoadListener {
        a() {
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            ArkMultiProc.c(i3, loadExtResult);
        }
    }

    /* loaded from: classes11.dex */
    class c implements IArkDelegateSetup {
        c() {
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateSetup
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<ArkAppElement> getPredownloadApp() {
            return null;
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateSetup
        public void setupArkEnvironment(boolean z16) {
            com.tencent.mobileqq.ark.core.f.m(z16);
        }
    }

    /* loaded from: classes11.dex */
    class d implements IArkDelegateNet {

        /* loaded from: classes11.dex */
        class a implements g91.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IArkDelegateHTTPCallback f199307a;

            a(IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
                this.f199307a = iArkDelegateHTTPCallback;
            }

            @Override // g91.a
            public void a(int i3, byte[] bArr) {
                IArkDelegateHTTPCallback iArkDelegateHTTPCallback = this.f199307a;
                if (iArkDelegateHTTPCallback != null) {
                    iArkDelegateHTTPCallback.onComplete(i3, bArr);
                }
            }
        }

        /* loaded from: classes11.dex */
        class b implements g91.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IArkDelegateHTTPCallback f199309a;

            b(IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
                this.f199309a = iArkDelegateHTTPCallback;
            }

            @Override // g91.a
            public void a(int i3, byte[] bArr) {
                IArkDelegateHTTPCallback iArkDelegateHTTPCallback = this.f199309a;
                if (iArkDelegateHTTPCallback != null) {
                    iArkDelegateHTTPCallback.onComplete(i3, bArr);
                }
            }
        }

        d() {
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateNet
        public void get(String str, HashMap<String, String> hashMap, IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
            QLog.d("ArkApp.MultiProc", 1, "http.get url=", str);
            com.tencent.mobileqq.ark.util.h.c(MobileQQ.sMobileQQ.waitAppRuntime(null), str, hashMap, new a(iArkDelegateHTTPCallback));
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateNet
        public int getNetworkType() {
            int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
            if (networkType != 0) {
                if (networkType == 1) {
                    return 1;
                }
                if (networkType == 2) {
                    return 3;
                }
                if (networkType == 3) {
                    return 4;
                }
                if (networkType != 4) {
                    return -1;
                }
                return 5;
            }
            return 0;
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateNet
        public boolean isNetworkAvailable() {
            return NetworkUtil.isNetworkAvailable(null);
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateNet
        public void post(String str, HashMap<String, String> hashMap, byte[] bArr, IArkDelegateHTTPCallback iArkDelegateHTTPCallback) {
            QLog.d("ArkApp.MultiProc", 1, "http.post url=", str);
            com.tencent.mobileqq.ark.util.h.d(MobileQQ.sMobileQQ.waitAppRuntime(null), str, bArr, hashMap, new b(iArkDelegateHTTPCallback));
        }
    }

    /* loaded from: classes11.dex */
    class e implements IArkDelegateSSO {

        /* loaded from: classes11.dex */
        class a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IArkDelegateSSOCallback f199311a;

            a(IArkDelegateSSOCallback iArkDelegateSSOCallback) {
                this.f199311a = iArkDelegateSSOCallback;
            }

            @Override // com.tencent.mobileqq.ark.core.e.c
            public void a(boolean z16, int i3, String str) {
                QLog.i("ArkApp.MultiProc", 1, "ArkMultiProc.sendAppMsg, success=" + z16 + ", data=" + str);
                this.f199311a.onComplete(z16, str);
            }
        }

        e() {
        }

        @Override // com.tencent.ark.open.delegate.IArkDelegateSSO
        public void send(String str, String str2, int i3, IArkDelegateSSOCallback iArkDelegateSSOCallback) {
            QLog.i("ArkApp.MultiProc", 1, "ArkMultiProc.sendAppMsg, cmd=" + str + ", msg=" + str2 + ", timeout=" + i3);
            com.tencent.mobileqq.ark.core.e.f(str, str2, i3, 0, new a(iArkDelegateSSOCallback));
        }
    }

    /* loaded from: classes11.dex */
    class f extends DefaultApplicationCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.ark.base.DefaultApplicationCallback
        protected boolean b(String str) {
            IArkEnvDelegate iArkEnvDelegate;
            if (!super.b(str) || (iArkEnvDelegate = com.tencent.mobileqq.ark.core.f.f199347e) == null) {
                return false;
            }
            return iArkEnvDelegate.shouldCheckURLDomain();
        }
    }

    /* loaded from: classes11.dex */
    private static class g implements ArkViewImplement.InputCallback {

        /* renamed from: a, reason: collision with root package name */
        private BubblePopupWindow f199313a = null;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f199314b = null;

        /* renamed from: c, reason: collision with root package name */
        private ImageView f199315c = null;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f199316d = null;

        /* renamed from: e, reason: collision with root package name */
        private ViewGroup f199317e = null;

        /* loaded from: classes11.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f199318d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArkViewImplement.ArkViewInterface f199319e;

            a(int i3, ArkViewImplement.ArkViewInterface arkViewInterface) {
                this.f199318d = i3;
                this.f199319e = arkViewInterface;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int id5 = view.getId();
                int i3 = this.f199318d;
                if (i3 == 2) {
                    if (id5 == 0) {
                        this.f199319e.doInputCommand(5);
                    } else if (id5 == 1) {
                        this.f199319e.doInputCommand(4);
                    } else if (id5 == 2) {
                        this.f199319e.doInputCommand(3);
                    }
                } else if (i3 == 1) {
                    if (id5 == 0) {
                        this.f199319e.doInputCommand(1);
                    } else if (id5 == 1) {
                        this.f199319e.doInputCommand(2);
                    } else if (id5 == 2) {
                        this.f199319e.doInputCommand(3);
                    }
                } else {
                    this.f199319e.doInputCommand(3);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        g() {
        }

        private void a(View view) {
            if (view != null) {
                view.clearAnimation();
                view.setVisibility(8);
            }
        }

        private void b(View view, int i3, int i16) {
            if (view != null) {
                view.setVisibility(0);
                view.animate().x(i3).y(i16).setDuration(0L).start();
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.InputCallback
        public void onFocusChanged(View view, boolean z16) {
            ArkView arkView = (ArkView) view;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            ViewGroup viewGroup2 = this.f199317e;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            }
            if (viewGroup == null) {
                return;
            }
            if (z16) {
                Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.c_c);
                Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.c_b);
                arkView.setInputSetSelectHolderSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                arkView.setInputSetCaretHolderSize(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                if (this.f199314b == null) {
                    ImageView imageView = new ImageView(arkView.getContext());
                    this.f199314b = imageView;
                    imageView.setBackgroundDrawable(drawable);
                    this.f199314b.setScaleX(-1.0f);
                    viewGroup.addView(this.f199314b, new RelativeLayout.LayoutParams(-2, -2));
                    this.f199314b.setVisibility(8);
                    this.f199314b.setOnTouchListener(arkView);
                }
                if (this.f199315c == null) {
                    ImageView imageView2 = new ImageView(arkView.getContext());
                    this.f199315c = imageView2;
                    imageView2.setBackgroundDrawable(drawable);
                    viewGroup.addView(this.f199315c, new RelativeLayout.LayoutParams(-2, -2));
                    this.f199315c.setVisibility(8);
                    this.f199314b.setOnTouchListener(arkView);
                }
                if (this.f199316d == null) {
                    ImageView imageView3 = new ImageView(arkView.getContext());
                    this.f199316d = imageView3;
                    imageView3.setBackgroundDrawable(drawable2);
                    viewGroup.addView(this.f199316d, new RelativeLayout.LayoutParams(-2, -2));
                    this.f199316d.setVisibility(8);
                    this.f199316d.setOnTouchListener(arkView);
                }
            }
            a(this.f199314b);
            a(this.f199315c);
            a(this.f199316d);
        }

        @Override // com.tencent.ark.ArkViewImplement.InputCallback
        public void onHideMenu(View view) {
            BubblePopupWindow bubblePopupWindow = this.f199313a;
            if (bubblePopupWindow != null) {
                bubblePopupWindow.dismiss();
                this.f199313a = null;
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.InputCallback
        public void onSelectChanged(View view, int i3, int i16, int i17, int i18) {
            ArkView arkView = (ArkView) view;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            ViewGroup viewGroup2 = this.f199317e;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            }
            if (viewGroup == null) {
                return;
            }
            if (i3 > 0 && i16 > 0 && (i3 < i17 || i16 < i18)) {
                int width = this.f199314b.getWidth();
                if (width <= 0) {
                    width = BaseApplication.getContext().getResources().getDrawable(R.drawable.c_c).getIntrinsicWidth();
                }
                b(this.f199314b, (arkView.getLeft() + i3) - width, arkView.getTop() + i16);
            } else {
                a(this.f199314b);
            }
            if (i17 > 0 && i18 > 0 && (i3 < i17 || i16 < i18)) {
                b(this.f199315c, arkView.getLeft() + i17, arkView.getTop() + i18);
            } else {
                a(this.f199315c);
            }
            if (i3 > 0 && i16 > 0 && i3 == i17 && i16 == i18) {
                int width2 = this.f199316d.getWidth();
                if (width2 <= 0) {
                    width2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.c_b).getIntrinsicWidth();
                }
                b(this.f199316d, (i17 + arkView.getLeft()) - (width2 / 2), i18 + arkView.getTop());
                return;
            }
            a(this.f199316d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.ark.ArkViewImplement.InputCallback
        public void onShowMenu(View view, int i3, int i16, int i17, int i18) {
            BubblePopupWindow bubblePopupWindow = this.f199313a;
            if (bubblePopupWindow != null) {
                bubblePopupWindow.dismiss();
                this.f199313a = null;
            }
            com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
            if (i18 == 2) {
                aVar.a(0, HardCodeUtil.qqStr(R.string.jqf));
                aVar.a(1, HardCodeUtil.qqStr(R.string.jqa));
                aVar.a(2, HardCodeUtil.qqStr(R.string.jqg));
            } else if (i18 == 1) {
                aVar.a(0, HardCodeUtil.qqStr(R.string.jq_));
                aVar.a(1, HardCodeUtil.qqStr(R.string.jqb));
                aVar.a(2, HardCodeUtil.qqStr(R.string.jqc));
            } else {
                aVar.a(0, HardCodeUtil.qqStr(R.string.jqe));
            }
            this.f199313a = com.tencent.mobileqq.ark.base.c.b(view, i3, i16, i17 + BaseApplication.getContext().getResources().getDrawable(R.drawable.c_b).getIntrinsicHeight(), aVar, new a(i18, (ArkViewImplement.ArkViewInterface) view));
        }
    }

    static void b() {
        if (MobileQQ.sProcessId != 7) {
            return;
        }
        h();
        Foreground.addActivityLifeCallback(f199302c);
    }

    static void c(int i3, LoadExtResult loadExtResult) {
        String str;
        IArkEnvDelegate iArkEnvDelegate;
        if (loadExtResult == null) {
            QLog.i("ArkApp.MultiProc", 1, "load jsc fail return null");
            return;
        }
        boolean isSucc = loadExtResult.isSucc();
        String ver = loadExtResult.getVer();
        if (!isSucc) {
            QLog.i("ArkApp.MultiProc", 1, "load jsc failed ,[resultCode]:" + loadExtResult.getResultCode() + ", version=" + ver);
            return;
        }
        String soLoadPath = loadExtResult.getSoLoadPath(SoLoadConstants.LIBS_4_JSC);
        if (TextUtils.isEmpty(soLoadPath)) {
            QLog.i("ArkApp.MultiProc", 1, "load jsc path is empty");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("load jsc2, res = ");
        sb5.append(i3);
        sb5.append(", fail = ");
        AsyncFailInfo asyncFailInfo = loadExtResult.failInfo;
        if (asyncFailInfo != null) {
            str = asyncFailInfo.toString();
        } else {
            str = "(empty)";
        }
        sb5.append(str);
        QLog.i("ArkApp.MultiProc", 1, sb5.toString());
        ((IArkSoPreLoader) QRoute.api(IArkSoPreLoader.class)).setLibJscPath(new File(soLoadPath).getParent());
        if (MobileQQ.sProcessId == 1 && (iArkEnvDelegate = com.tencent.mobileqq.ark.core.f.f199347e) != null) {
            iArkEnvDelegate.notifyJscLoaded();
        }
    }

    public static synchronized void d(IArkEnvDelegate iArkEnvDelegate, boolean z16) {
        int lastIndexOf;
        synchronized (ArkMultiProc.class) {
            if (f199300a) {
                g(z16);
                return;
            }
            f199300a = true;
            QLog.i("ArkApp.MultiProc", 1, "initArkEnv, begin");
            long currentTimeMillis = System.currentTimeMillis();
            MMKVManager.getInstance().setMMKV(new com.tencent.mobileqq.ark.util.f(QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations")));
            com.tencent.mobileqq.ark.core.f.f199347e = iArkEnvDelegate;
            IArkEnvironment iArkEnvironment = (IArkEnvironment) QRoute.api(IArkEnvironment.class);
            com.tencent.mobileqq.ark.core.f.m(true);
            if (!((INativeLibLoader) QRoute.api(INativeLibLoader.class)).loadPNGLibrary(BaseApplication.getContext())) {
                QLog.e("ArkApp.MultiProc", 1, "loadPNGLibrary fail");
            }
            g(z16);
            String rootDirectory = iArkEnvironment.getRootDirectory();
            String str = "";
            if (MobileQQ.sProcessId != 1) {
                String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
                if (qQProcessName != null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
                    str = "_" + qQProcessName.substring(lastIndexOf + 1);
                }
                rootDirectory = rootDirectory + str;
            }
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            ArkDelegateManager.Config config = new ArkDelegateManager.Config();
            config.rootDir = rootDirectory;
            config.processName = str;
            config.qqVersion = AppSetting.f99551k;
            if (waitAppRuntime != null) {
                config.context = waitAppRuntime.getApplicationContext();
            }
            config.setupDelegate = f199303d;
            config.netDelegate = f199304e;
            config.ssoDelegate = f199305f;
            config.inputCallback = new g();
            config.applicationCallback = f199306g;
            if (waitAppRuntime != null) {
                ArkEnvironmentManager.getInstance().setCurrentUin(waitAppRuntime.getAccount());
            } else {
                QLog.e("ArkApp.MultiProc", 1, "runtime is null");
            }
            ArkEnvironmentManager.getInstance().setEnv(iArkEnvironment.isTestEnv());
            ArkDelegateManager.getInstance().init(config);
            ((IArkHelper) QRoute.api(IArkHelper.class)).preloadCommon();
            b();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ark.core.h
                @Override // java.lang.Runnable
                public final void run() {
                    ArkMultiProc.f(AppRuntime.this);
                }
            }, 5000L);
            e();
            QLog.i("ArkApp.MultiProc", 1, "initArkEnv, end, use-time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    static void e() {
        f91.a.b();
        ArkExtendConfParser.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppRuntime appRuntime) {
        if (appRuntime != null) {
            appRuntime.getRuntimeService(IArkService.class, "");
        }
    }

    static void g(boolean z16) {
        if (z16) {
            QLog.i("ArkApp.MultiProc", 1, "isDelayInitJsc");
        } else {
            if (f199301b) {
                return;
            }
            f199301b = true;
            QLog.i("ArkApp.MultiProc", 1, "start loadJsc");
            SoLoadManager.getInstance().load(SoLoadConstants.LIBS_4_JSC, new a());
        }
    }

    static void h() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ark.core.ArkMultiProc.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("ArkApp.MultiProc", 1, "update local apps, process=" + MobileQQ.processName);
                ArkAppMgr.getInstance().updateInstalledApps();
            }
        }, 10000L);
    }

    /* loaded from: classes11.dex */
    class b implements QActivityLifecycleCallbacks {
        b() {
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            ArkMultiProc.h();
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
