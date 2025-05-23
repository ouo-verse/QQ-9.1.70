package com.tencent.mobileqq.soload.config;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.util.f;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes18.dex */
public class SoLoaderConfProcessor extends l<SoLoadConfBean> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f288643c;

    /* renamed from: a, reason: collision with root package name */
    private long f288644a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f288645b;

    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f288643c = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
    }

    public SoLoaderConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288644a = 0L;
            this.f288645b = new LinkedList();
        }
    }

    private void d(int i3) {
        f.M();
        h(i3);
    }

    private boolean e() {
        long abs = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.f288644a);
        if (abs < 60000) {
            QLog.i("SoLoadWidget.SoLoadConfProcessor", 1, "[isInSingleSoReqGap],gap:" + abs);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        h(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[notifyListeners]:" + this.f288645b.size());
        }
        f288643c.removeCallbacksAndMessages(this);
        try {
            synchronized (this.f288645b) {
                if (this.f288645b.size() > 0) {
                    Iterator<a> it = this.f288645b.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().a(i3);
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, th5, new Object[0]);
                            }
                        }
                    }
                    this.f288645b.clear();
                }
            }
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, th6, new Object[0]);
            }
        }
    }

    public void c(a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, aVar, Boolean.valueOf(z16));
            return;
        }
        QLog.d("SoLoadWidget.SoLoadConfProcessor", 1, "[getConfig],isResetVersion:" + z16);
        synchronized (this.f288645b) {
            if (this.f288645b.size() > 0) {
                this.f288645b.add(aVar);
                return;
            }
            this.f288645b.add(aVar);
            if (z16) {
                if (e()) {
                    Handler handler = f288643c;
                    handler.removeCallbacksAndMessages(this);
                    handler.post(new Runnable() { // from class: com.tencent.mobileqq.soload.config.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            SoLoaderConfProcessor.this.f();
                        }
                    });
                    return;
                }
                this.f288644a = NetConnInfoCenter.getServerTimeMillis();
                am.s().P(526, 0);
            }
            am.s().M(new int[]{526});
            Handler handler2 = f288643c;
            handler2.removeCallbacksAndMessages(this);
            handler2.postAtTime(new Runnable() { // from class: com.tencent.mobileqq.soload.config.SoLoaderConfProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoLoaderConfProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SoLoaderConfProcessor.this.h(-1);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, this, SystemClock.uptimeMillis() + 35000);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<SoLoadConfBean> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return SoLoadConfBean.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public SoLoadConfBean migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SoLoadConfBean) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
        }
        return new SoLoadConfBean();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SoLoadConfBean onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SoLoadConfBean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
        }
        SoLoadConfBean soLoadConfBean = new SoLoadConfBean();
        soLoadConfBean.confFiles = aiVarArr;
        return soLoadConfBean;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedUpgradeReset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        QLog.i("SoLoadWidget.SoLoadConfProcessor", 2, "[isNeedUpgradeReset]");
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onUpdate(SoLoadConfBean soLoadConfBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) soLoadConfBean);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + soLoadConfBean);
        }
        com.tencent.mobileqq.soload.config.a.b().i(soLoadConfBean);
        d(0);
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[get migrateOldVersion]");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        QLog.d("SoLoadWidget.SoLoadConfProcessor", 1, "[onReqFailed] failCode=" + i3);
        d(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SoLoadConfBean soLoadConfBean = (SoLoadConfBean) am.s().x(526);
        if (soLoadConfBean != null) {
            com.tencent.mobileqq.soload.config.a.b().i(soLoadConfBean);
        }
        d(0);
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + soLoadConfBean);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 526;
    }
}
