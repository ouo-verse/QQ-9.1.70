package com.tencent.ams.mosaic.jsengine.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.QuickJSEngine;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AppManager implements IAppManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f70773f;

    /* renamed from: a, reason: collision with root package name */
    private final QuickJSEngine f70774a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f70775b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f70776c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, List<Pair<Integer, JSFunction>>> f70777d;

    /* renamed from: e, reason: collision with root package name */
    private b f70778e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface ErrorCode {
        public static final int INVALID_PARAMS = 1;
        public static final int INVALID_SCHEME = 3;
        public static final int NOT_INSTALLED = 2;
        public static final int OK = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppManager.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            f.e("AppManager", "onReceive, action: " + intent.getAction());
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                String dataString = intent.getDataString();
                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("package:")) {
                    dataString = dataString.substring(8);
                }
                AppManager.this.c(dataString);
            }
        }

        /* synthetic */ b(AppManager appManager, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appManager, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f70773f = new AtomicInteger(0);
        }
    }

    public AppManager(Context context, QuickJSEngine quickJSEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) quickJSEngine);
            return;
        }
        this.f70776c = new byte[0];
        this.f70777d = new ConcurrentHashMap();
        this.f70775b = context.getApplicationContext();
        this.f70774a = quickJSEngine;
    }

    private void b(JSFunction jSFunction, int i3, String str) {
        QuickJSEngine quickJSEngine = this.f70774a;
        if (quickJSEngine == null) {
            f.b("AppManager", "callBackResult: mQuickJSEngine is null");
            return;
        }
        if (jSFunction == null) {
            f.b("AppManager", "callBackResult: callback is null");
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                quickJSEngine.u(jSFunction, new Object[]{null, Integer.valueOf(i3), str}, null);
            } else {
                quickJSEngine.u(jSFunction, new Object[]{null, Integer.valueOf(i3)}, null);
            }
        } catch (Throwable th5) {
            f.c("AppManager", "callBackResult", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        List<Pair<Integer, JSFunction>> list;
        Object obj;
        f.e("AppManager", "notifyAppInstalled, packageName: " + str);
        if (!TextUtils.isEmpty(str) && (list = this.f70777d.get(str)) != null && !list.isEmpty()) {
            for (Pair<Integer, JSFunction> pair : list) {
                QuickJSEngine quickJSEngine = this.f70774a;
                if (quickJSEngine != null && pair != null && (obj = pair.second) != null) {
                    quickJSEngine.u((JSFunction) obj, new Object[]{str}, null);
                }
            }
        }
    }

    private void e() {
        f.e("AppManager", "registerInstallReceiver");
        if (this.f70775b != null && this.f70778e == null && !this.f70777d.isEmpty()) {
            this.f70778e = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.f70775b.registerReceiver(this.f70778e, intentFilter);
        }
    }

    private void f() {
        b bVar;
        f.e("AppManager", "registerInstallReceiver");
        if (this.f70775b != null && this.f70777d.isEmpty() && (bVar = this.f70778e) != null) {
            this.f70775b.unregisterReceiver(bVar);
            this.f70778e = null;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public void callPhone(String str, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) jSFunction);
            return;
        }
        if (this.f70775b == null) {
            f.e("AppManager", "context is null");
            b(jSFunction, -1, null);
            return;
        }
        try {
            Uri parse = Uri.parse(WebView.SCHEME_TEL + str);
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.addFlags(268435456);
            intent.setData(parse);
            this.f70775b.startActivity(intent);
            b(jSFunction, 0, null);
        } catch (Throwable th5) {
            f.c("AppManager", "callPhone catch\uff1a", th5);
            b(jSFunction, -2, th5.getMessage());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public boolean canLaunchApp(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        boolean a16 = com.tencent.ams.mosaic.utils.b.a(this.f70775b, str, str2);
        f.e("AppManager", "canLaunchApp, scheme: " + str + ", packageName: " + str2 + ", result: " + a16);
        return a16;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f.e("AppManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f70777d.clear();
        f();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public boolean install(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        f.e("AppManager", "install, filePath: " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.tencent.ams.mosaic.utils.b.c(this.f70775b, str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public boolean isInstalled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        boolean d16 = com.tencent.ams.mosaic.utils.b.d(this.f70775b, str);
        f.e("AppManager", "isInstalled, packageName: " + str + ", result: " + d16);
        return d16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public void launchApp(String str, String str2, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, jSFunction);
            return;
        }
        f.e("AppManager", "launchApp, scheme: " + str + ", packageName: " + str2);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            QuickJSEngine quickJSEngine = this.f70774a;
            if (quickJSEngine != null) {
                quickJSEngine.u(jSFunction, new Object[]{Boolean.FALSE}, null);
                return;
            }
            return;
        }
        boolean e16 = com.tencent.ams.mosaic.utils.b.e(this.f70775b, str, str2);
        QuickJSEngine quickJSEngine2 = this.f70774a;
        if (quickJSEngine2 != null) {
            quickJSEngine2.u(jSFunction, new Object[]{Boolean.valueOf(e16)}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public void launchAppByULink(String str, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) jSFunction);
            return;
        }
        f.e("AppManager", "launchAppByULink, ulink: " + str);
        QuickJSEngine quickJSEngine = this.f70774a;
        if (quickJSEngine != null) {
            quickJSEngine.u(jSFunction, new Object[]{Boolean.FALSE}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public void openAppstore(JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jSObject, (Object) jSFunction);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public int registerOnAppInstalledEvent(String str, JSFunction jSFunction) {
        int incrementAndGet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) jSFunction)).intValue();
        }
        f.e("AppManager", "registerOnAppInstalledEvent, packageName: " + str);
        if (!TextUtils.isEmpty(str) && jSFunction != null) {
            synchronized (this.f70776c) {
                List<Pair<Integer, JSFunction>> list = this.f70777d.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f70777d.put(str, list);
                }
                incrementAndGet = f70773f.incrementAndGet();
                list.add(new Pair<>(Integer.valueOf(incrementAndGet), jSFunction));
                e();
            }
            return incrementAndGet;
        }
        return -1;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IAppManager
    public boolean unregisterOnAppInstalledEvent(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        synchronized (this.f70776c) {
            z16 = false;
            for (String str : this.f70777d.keySet()) {
                List<Pair<Integer, JSFunction>> list = this.f70777d.get(str);
                if (list != null && !list.isEmpty()) {
                    Iterator<Pair<Integer, JSFunction>> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Pair<Integer, JSFunction> next = it.next();
                        if (((Integer) next.first).intValue() == i3) {
                            list.remove(next);
                            z16 = true;
                            break;
                        }
                    }
                    if (list.isEmpty()) {
                        this.f70777d.remove(str);
                    }
                }
                this.f70777d.remove(str);
            }
            f();
        }
        return z16;
    }
}
