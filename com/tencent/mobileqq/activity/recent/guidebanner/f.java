package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f185603a;

        /* renamed from: b, reason: collision with root package name */
        private String f185604b;

        /* renamed from: c, reason: collision with root package name */
        private String f185605c;

        /* renamed from: d, reason: collision with root package name */
        private int f185606d;

        /* renamed from: e, reason: collision with root package name */
        private String f185607e;

        /* renamed from: f, reason: collision with root package name */
        private String f185608f;

        /* renamed from: g, reason: collision with root package name */
        private long f185609g;

        /* renamed from: h, reason: collision with root package name */
        private int f185610h;

        /* renamed from: i, reason: collision with root package name */
        private String f185611i;

        /* renamed from: j, reason: collision with root package name */
        private int f185612j;

        /* renamed from: k, reason: collision with root package name */
        private int f185613k;

        /* renamed from: l, reason: collision with root package name */
        private String f185614l;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f185603a = "";
            this.f185604b = "";
            this.f185605c = "";
            this.f185606d = 1;
            this.f185607e = "";
            this.f185608f = "";
            this.f185609g = 0L;
            this.f185610h = 0;
            this.f185611i = "0";
            this.f185612j = 1;
            this.f185613k = 0;
            this.f185614l = "";
        }

        public TianShuReportData a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (TianShuReportData) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            TianShuReportData tianShuReportData = new TianShuReportData();
            tianShuReportData.mAppId = this.f185603a;
            tianShuReportData.mPageId = this.f185604b;
            tianShuReportData.mTraceId = this.f185605c;
            tianShuReportData.mTraceNum = this.f185606d;
            tianShuReportData.mItemId = this.f185607e;
            tianShuReportData.mSubItemId = this.f185608f;
            tianShuReportData.mOperTime = this.f185609g;
            tianShuReportData.mActionId = this.f185610h;
            tianShuReportData.mPositionId = this.f185611i;
            tianShuReportData.mActionValue = this.f185612j;
            tianShuReportData.mActionAttr = this.f185613k;
            tianShuReportData.mTriggerInfo = this.f185614l;
            return tianShuReportData;
        }

        public a b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.f185610h = i3;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f185603a = str;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f185607e = str;
            return this;
        }

        public a e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, j3);
            }
            this.f185609g = j3;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f185604b = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f185605c = str;
            return this;
        }

        public a h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.f185614l = str;
            return this;
        }
    }

    public static String a(long j3) {
        AppRuntime waitAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (waitAppRuntime = mobileQQ.waitAppRuntime(null)) != null) {
            return waitAppRuntime.getAccount() + "_" + j3;
        }
        return "";
    }

    public static void b(TianShuReportData tianShuReportData) {
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }
}
