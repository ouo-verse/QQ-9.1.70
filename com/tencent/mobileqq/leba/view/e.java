package com.tencent.mobileqq.leba.view;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u0010\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/leba/view/e;", "", "", tl.h.F, "c", "b", "d", "g", "e", "f", "", "a", "J", "()J", "setCreateTime$qqleba_impl_release", "(J)V", WadlProxyConsts.CREATE_TIME, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "destroyTime", "startLoadTime", "notifyRefreshTime", "refreshTime", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long createTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long showTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long destroyTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startLoadTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long notifyRefreshTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long refreshTime;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.showTime - this.createTime);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(this.refreshTime - this.notifyRefreshTime);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append("total: ");
        sb5.append(this.refreshTime - this.createTime);
        QLog.d("PluginViewMonitor", 2, "printTime " + ((Object) sb5) + " ");
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.createTime;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.showTime == 0) {
            this.showTime = System.currentTimeMillis();
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.createTime == 0) {
            this.createTime = System.currentTimeMillis();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.destroyTime == 0) {
            this.destroyTime = System.currentTimeMillis();
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.notifyRefreshTime == 0) {
            this.notifyRefreshTime = System.currentTimeMillis();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.refreshTime == 0) {
            this.refreshTime = System.currentTimeMillis();
            h();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.startLoadTime == 0) {
            this.startLoadTime = System.currentTimeMillis();
        }
    }
}
