package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public abstract class DoraemonAPIManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f154069a;

    /* renamed from: b, reason: collision with root package name */
    public int f154070b;

    /* renamed from: c, reason: collision with root package name */
    public String f154071c;

    /* renamed from: d, reason: collision with root package name */
    public String f154072d;

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, b> f154073e;

    /* renamed from: f, reason: collision with root package name */
    protected Map<Class<? extends e>, e> f154074f;

    /* renamed from: g, reason: collision with root package name */
    protected int f154075g;

    /* renamed from: h, reason: collision with root package name */
    protected final Object f154076h;

    /* renamed from: i, reason: collision with root package name */
    protected List<Object[]> f154077i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f154078j;

    /* renamed from: k, reason: collision with root package name */
    private int f154079k;

    /* renamed from: l, reason: collision with root package name */
    protected Dialog f154080l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.Doraemon.ui.a f154081m;

    /* renamed from: n, reason: collision with root package name */
    protected IDoraemonApi f154082n;

    public DoraemonAPIManager(Activity activity, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str);
            return;
        }
        this.f154074f = new HashMap();
        this.f154075g = 0;
        this.f154076h = new Object();
        this.f154077i = new ArrayList();
        this.f154078j = false;
        this.f154079k = -1;
        this.f154080l = null;
        this.f154069a = new WeakReference<>(activity);
        this.f154070b = i3;
        this.f154071c = str;
        this.f154072d = i3 + "_" + str;
        this.f154082n = (IDoraemonApi) QRoute.api(IDoraemonApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void g(b bVar, JSONObject jSONObject, a aVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        e i3 = i(bVar.f154093d, true);
        if (i3 == null) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "module load failed");
            DoraemonUtil.d(aVar, 2);
            return;
        }
        com.tencent.mobileqq.Doraemon.monitor.b.c().h(this.f154072d, this.f154070b, this.f154071c, bVar.f154090a);
        if (!i3.c(bVar.f154091b, bVar.f154090a, jSONObject, aVar)) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "module not handled this api");
            DoraemonUtil.d(aVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void h(String str, JSONObject jSONObject, @NonNull a aVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "doCall(), call api=" + str + ", mAppInfoStatus=" + this.f154075g + ", param=" + jSONObject + ", cb=" + aVar);
        }
        if (this.f154075g != 2) {
            return;
        }
        if (!m(str)) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "app has no permission");
            DoraemonUtil.d(aVar, 3);
            return;
        }
        b bVar = this.f154073e.get(str);
        if (bVar == null) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "no such api");
            DoraemonUtil.d(aVar, 1);
        } else if (!com.tencent.mobileqq.Doraemon.monitor.b.c().d(this.f154072d, this.f154070b, this.f154071c, str)) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "frequence restricted");
            DoraemonUtil.d(aVar, 8);
        } else {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            l(bVar, jSONObject, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Iterator<e> it = this.f154074f.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public final void d(String str, JSONObject jSONObject, @NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, jSONObject, aVar);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "call() begin, mAppInfoStatus=" + this.f154075g + ", apiName=" + str);
        }
        if (this.f154075g != 2) {
            synchronized (this.f154076h) {
                int i3 = this.f154075g;
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        this.f154077i.add(new Object[]{str, jSONObject, aVar});
                        if (QLog.isDevelopLevel()) {
                            QLog.i("DoraemonOpenAPI.apiMgr", 1, "permission not ready, add to queue api=" + str);
                        }
                        if (this.f154075g != 1) {
                            this.f154075g = 1;
                            QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
                            p();
                        }
                        return;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i("DoraemonOpenAPI.apiMgr", 1, "appinfo error and can not retry, mAppInfoStatus=" + this.f154075g);
                    }
                    DoraemonUtil.d(aVar, DoraemonUtil.a(this.f154075g));
                    return;
                }
            }
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            h(str, jSONObject, aVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(str, jSONObject, aVar) { // from class: com.tencent.mobileqq.Doraemon.DoraemonAPIManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f154084d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ JSONObject f154085e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f154086f;

                {
                    this.f154084d = str;
                    this.f154085e = jSONObject;
                    this.f154086f = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DoraemonAPIManager.this, str, jSONObject, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DoraemonAPIManager.this.h(this.f154084d, this.f154085e, this.f154086f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    protected boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f154079k == -1) {
            this.f154079k = 0;
        }
        if (this.f154079k != 1) {
            return false;
        }
        return true;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f154081m.P();
        }
    }

    public <T extends e> T i(Class<T> cls, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, this, cls, Boolean.valueOf(z16));
        }
        T t16 = (T) this.f154074f.get(cls);
        if (t16 == null && z16 && !this.f154078j) {
            synchronized (this) {
                if (!this.f154078j) {
                    e eVar = this.f154074f.get(cls);
                    if (eVar == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + cls.getSimpleName());
                        }
                        eVar = f.a(cls, this);
                        if (eVar != null) {
                            this.f154074f.put(cls, eVar);
                        }
                    }
                    t16 = (T) eVar;
                }
            }
        }
        return t16;
    }

    public Activity j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Activity) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f154069a.get();
    }

    public abstract com.tencent.mobileqq.miniapp.d k();

    protected abstract void l(b bVar, JSONObject jSONObject, a aVar);

    protected boolean m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        boolean contains = k().f246806o.contains(str);
        if (!contains && e()) {
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.lpr) + str + HardCodeUtil.qqStr(R.string.lpp), 0).show();
            return true;
        }
        return contains;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f154073e = o();
        synchronized (this.f154076h) {
            this.f154075g = 1;
            p();
        }
        com.tencent.mobileqq.Doraemon.monitor.b.c().e(this.f154072d, this.f154070b, this.f154071c);
        if (MobileQQ.sProcessId != 1) {
            this.f154082n.bindService();
        }
    }

    protected abstract Map<String, b> o();

    protected abstract void p();

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i3, b bVar, JSONObject jSONObject, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), bVar, jSONObject, aVar);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "onHandleAPIAuthorize, errorCode=" + i3 + ", apiConfig=" + bVar + ", apiParam=" + jSONObject + ", apiCallback=" + aVar);
        }
        if (i3 == 0) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                g(bVar, jSONObject, aVar);
                return;
            } else {
                ThreadManager.getUIHandler().post(new Runnable(bVar, jSONObject, aVar) { // from class: com.tencent.mobileqq.Doraemon.DoraemonAPIManager.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ b f154087d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ JSONObject f154088e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ a f154089f;

                    {
                        this.f154087d = bVar;
                        this.f154088e = jSONObject;
                        this.f154089f = aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, DoraemonAPIManager.this, bVar, jSONObject, aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            DoraemonAPIManager.this.g(this.f154087d, this.f154088e, this.f154089f);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            }
        }
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + i3);
        DoraemonUtil.d(aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i3) {
        ArrayList<Object[]> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo(), status=" + i3 + ", current mAppInfoStatus=" + this.f154075g + ", stack=", new Throwable());
        }
        synchronized (this.f154076h) {
            this.f154075g = i3;
            arrayList = new ArrayList(this.f154077i);
            this.f154077i.clear();
        }
        if (arrayList.size() > 0) {
            if (i3 == 2) {
                ThreadManager.getUIHandler().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f154083d;

                    {
                        this.f154083d = arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DoraemonAPIManager.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        for (Object[] objArr : this.f154083d) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo(), doCall, api=" + objArr[0] + ", JSONObject params=" + objArr[1] + ", APICallback params=" + objArr[2]);
                            }
                            DoraemonAPIManager.this.h((String) objArr[0], (JSONObject) objArr[1], (a) objArr[2]);
                        }
                    }
                });
                return;
            }
            for (Object[] objArr : arrayList) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo(), load app info error, api=" + objArr[0]);
                }
                DoraemonUtil.d((a) objArr[2], DoraemonUtil.a(i3));
            }
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            this.f154078j = true;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            t();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.Doraemon.DoraemonAPIManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DoraemonAPIManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DoraemonAPIManager.this.t();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (MobileQQ.sProcessId != 1) {
            this.f154082n.unbindService();
        }
    }

    public void u(String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6, View.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, str5, onClickListener, str6, onClickListener2, onCancelListener);
            return;
        }
        Activity activity = this.f154069a.get();
        if (activity != null && !activity.isFinishing()) {
            com.tencent.mobileqq.Doraemon.ui.a aVar = new com.tencent.mobileqq.Doraemon.ui.a(activity);
            this.f154081m = aVar;
            aVar.W(HardCodeUtil.qqStr(R.string.lpz));
            this.f154081m.S(str);
            this.f154081m.U(str4);
            this.f154081m.Z(str6);
            this.f154081m.b0(str5);
            this.f154081m.a0(onClickListener);
            this.f154081m.Y(onClickListener2);
            this.f154081m.X(onCancelListener);
            this.f154081m.R(str2);
            this.f154081m.show();
            ReportController.o(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
            return;
        }
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
    }
}
