package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReportControllerImpl extends ReportController implements Handler.Callback, BusinessObserver {
    static IPatchRedirector $redirector_;
    private AppRuntime C;
    private z91.a D;

    /* renamed from: e, reason: collision with root package name */
    private MqqWeakReferenceHandler f289922e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, Reporting> f289923f;

    /* renamed from: h, reason: collision with root package name */
    private volatile Boolean f289924h;

    /* renamed from: i, reason: collision with root package name */
    private int f289925i;

    /* renamed from: m, reason: collision with root package name */
    private long f289926m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f289927a;

        /* renamed from: b, reason: collision with root package name */
        public String f289928b;

        /* renamed from: c, reason: collision with root package name */
        public int f289929c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    ReportControllerImpl(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f289923f = new HashMap<>();
        this.f289926m = 86400000L;
        this.C = appRuntime;
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "Create:" + appRuntime);
        }
        this.f289922e = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        QLog.d("ReportController", 1, "init report period in subThread");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.statistics.ReportControllerImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReportControllerImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ReportControllerImpl.this.N();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, true);
    }

    public static ReportController F(AppRuntime appRuntime) {
        return new ReportControllerImpl(appRuntime);
    }

    private boolean H() {
        if (!AppNetConnInfo.isNetSupport()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "doReportClickEvent:" + this.C);
        }
        int size = this.f289923f.size();
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        int O = O();
        Iterator<String> it = this.f289923f.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Reporting reporting = this.f289923f.get(it.next());
            if (reporting.mDetailHashCode != 0 && reporting.mDetail.hashCode() != reporting.mDetailHashCode) {
                size--;
                it.remove();
                this.D.a("", 0, "Reporting", reporting, 5);
            } else if (j(reporting.mTag)) {
                ReportController.b f16 = f(reporting.mTag);
                if (f16 != null) {
                    f16.a(reporting);
                }
                size--;
                it.remove();
                this.D.a("", 0, "Reporting", reporting, 5);
            } else {
                arrayList.add(reporting.mTag);
                String replace = reporting.mDetail.replace("${count_unknown}", String.valueOf(reporting.mCount));
                if (replace.startsWith("${report_seq_prefix}")) {
                    replace = replace.substring(replace.indexOf("|") + 1);
                }
                arrayList2.add(replace);
                it.remove();
                this.D.a("", 0, "Reporting", reporting, 5);
                QLog.isColorLevel();
                i3++;
            }
            if (i3 % 20 == 0 || i3 >= size) {
                NewIntent newIntent = new NewIntent(this.C.getApplication(), com.tencent.mobileqq.servlet.q.class);
                newIntent.putExtra("sendType", 10);
                newIntent.putExtra("seqKey", O);
                newIntent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, arrayList);
                newIntent.putExtra("retryTime", 0);
                newIntent.putExtra("contents", arrayList2);
                newIntent.setObserver(this);
                this.C.startServlet(newIntent);
                arrayList = new ArrayList(20);
                arrayList2 = new ArrayList(20);
                if (i3 < size) {
                    O = O();
                }
            }
        }
        k();
        return true;
    }

    private void I(String str, String str2, int i3) {
        String str3 = str + ":" + str2;
        Reporting reporting = this.f289923f.get(str3);
        if (reporting == null) {
            reporting = new Reporting();
            reporting.mTag = str;
            reporting.mDetail = str2;
            reporting.mCount = i3;
            reporting.mDetailHashCode = str2.hashCode();
            this.f289923f.put(str3, reporting);
            if (this.f289924h != null && this.f289924h.booleanValue()) {
                this.D.a("", 0, "Reporting", reporting, 3);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + reporting.mTag + ", r.mDetail=" + reporting.mDetail + ", r.mDetailHashCode=" + reporting.mDetailHashCode);
            }
        } else {
            reporting.mCount += i3;
            if (this.f289924h != null && this.f289924h.booleanValue()) {
                this.D.a("", 0, "Reporting", reporting.m222clone(), 4);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + reporting.mTag + ", r.mDetail=" + reporting.mDetail + ", r.mDetailHashCode=" + reporting.mDetailHashCode);
            }
        }
        if (this.f289924h != null) {
            if (this.f289924h.booleanValue()) {
                if (this.f289923f.size() >= 40) {
                    K();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("ReportController", 2, "handleAddReporting: handleReport r.mTag=" + reporting.mTag + ", r.mDetail=" + reporting.mDetail + ", r.mDetailHashCode=" + reporting.mDetailHashCode);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!this.f289922e.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION_ACCESS_FINE_LOCATION)) {
                this.f289922e.sendEmptyMessage(ActivityResultManager.ACTION_REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
                if (QLog.isDevelopLevel()) {
                    QLog.d("ReportController", 2, "handleAddReporting: savedata r.mTag=" + reporting.mTag + ", r.mDetail=" + reporting.mDetail + ", r.mDetailHashCode=" + reporting.mDetailHashCode);
                }
            }
        }
    }

    private void J() {
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "handleInit:" + this.C);
        }
        List<? extends Entity> query = this.C.getEntityManagerFactory().createEntityManager().query(Reporting.class);
        if (query != null) {
            QLog.d("ReportController", 1, "handleInit report size = " + query.size());
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                Reporting reporting = (Reporting) it.next();
                String str = reporting.mTag + ":" + reporting.mDetail;
                Reporting reporting2 = this.f289923f.get(str);
                if (reporting2 != null) {
                    reporting.mCount += reporting2.mCount;
                }
                this.f289923f.put(str, reporting);
            }
        }
    }

    private void K() {
        this.f289922e.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        try {
            H();
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ReportController", 4, "report exception:" + e16);
            }
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(this.C.getAccount(), 0);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("pre_report_time", currentTimeMillis);
        edit.commit();
        this.f289922e.sendEmptyMessageDelayed(ActivityResultManager.ACTION_REQUEST_PERMISSION, this.f289926m);
    }

    private void L(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "saveReportData:" + appRuntime);
        }
        Collection<Reporting> values = this.f289923f.values();
        if (values != null && values.size() > 0) {
            QLog.d("ReportController", 1, "handleInit report size = " + values.size());
            try {
                EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
                EntityTransaction transaction = createEntityManager.getTransaction();
                transaction.begin();
                try {
                    for (Reporting reporting : values) {
                        if (reporting.getStatus() == 1000) {
                            createEntityManager.persistOrReplace(reporting);
                        } else {
                            createEntityManager.update(reporting);
                        }
                    }
                } catch (Throwable unused) {
                }
                transaction.commit();
                transaction.end();
                createEntityManager.close();
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String str;
        try {
            z91.b b16 = com.tencent.mobileqq.bridge.a.b();
            if (b16 != null) {
                str = b16.e(this.C, ServerConfigManager.ConfigType.common, "ActionReportInterval");
            } else {
                str = "";
            }
            if (str != null && str.length() > 0) {
                this.f289926m = Long.parseLong(str) * 1000;
            }
        } catch (Exception e16) {
            QLog.e("ReportController", 1, e16, new Object[0]);
        }
        if (this.f289926m <= 1000) {
            this.f289926m = 86400000L;
        }
        QLog.d("ReportController", 1, "initReportPeriodFromConfig mCurReportPeriod = " + this.f289926m);
    }

    private synchronized int O() {
        int i3 = this.f289925i;
        if (i3 <= 0) {
            this.f289925i = new Random().nextInt(1000000) + 100;
        } else if (i3 >= 1000100) {
            this.f289925i = 100;
        } else {
            this.f289925i = i3 + 1;
        }
        return this.f289925i;
    }

    @Override // com.tencent.mobileqq.statistics.ReportController
    protected void A(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            BaseApplication context = BaseApplication.getContext();
            if (this.C.getAccount() != null) {
                str = this.C.getAccount();
            } else {
                str = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong("pre_report_time", currentTimeMillis)) < this.f289926m) {
                return;
            }
        }
        if (!this.f289922e.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION)) {
            this.f289922e.sendEmptyMessage(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        }
    }

    @Override // com.tencent.mobileqq.statistics.ReportController
    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f289922e.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(AppRuntime appRuntime, z91.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) aVar);
            return;
        }
        QLog.d("ReportController", 1, "Destory:" + appRuntime);
        this.f289924h = Boolean.FALSE;
        this.f289922e.sendEmptyMessage(ActivityResultManager.ACTION_REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(AppRuntime appRuntime, z91.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) aVar);
            return;
        }
        this.C = appRuntime;
        this.D = aVar;
        this.f289924h = Boolean.TRUE;
        QLog.d("ReportController", 1, "Init:" + appRuntime);
        this.f289922e.sendEmptyMessage(9530);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.statistics.ReportController
    public void b(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
            return;
        }
        a aVar = new a();
        aVar.f289927a = str;
        aVar.f289928b = str2;
        aVar.f289929c = i3;
        this.f289922e.obtainMessage(9529, aVar).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 9529) {
            a aVar = (a) message.obj;
            I(aVar.f289927a, aVar.f289928b, aVar.f289929c);
            return true;
        }
        if (i3 == 9527) {
            K();
            return true;
        }
        if (i3 == 9528) {
            L(this.C);
            return true;
        }
        if (i3 == 9530) {
            J();
            return true;
        }
        return true;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 10) {
            int i17 = bundle.getInt("seqKey");
            if (QLog.isColorLevel()) {
                QLog.d("ReportController", 2, "OnReceive: isSuccess-" + z16 + ", seqKey = " + i17);
            }
            if (!z16) {
                i16 = bundle.getInt("retryTime");
            }
            AppRuntime appRuntime = this.C;
            if (!z16 && i16 < 2 && appRuntime != null) {
                NewIntent newIntent = new NewIntent(BaseApplication.getContext(), com.tencent.mobileqq.servlet.q.class);
                newIntent.putExtra("sendType", 10);
                newIntent.putExtra("seqKey", i17);
                newIntent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bundle.getStringArrayList(ComicCancelRedPointPopItemData.JSON_KEY_TAGS));
                newIntent.putExtra("contents", bundle.getStringArrayList("contents"));
                newIntent.putExtra("retryTime", i16 + 1);
                newIntent.setObserver(this);
                appRuntime.startServlet(newIntent);
            }
        }
    }
}
