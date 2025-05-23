package com.tencent.mobileqq.comment;

import android.graphics.Paint;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.comment.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static b f201741e;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, a> f201742a;

    /* renamed from: b, reason: collision with root package name */
    private d f201743b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f201744c;

    /* renamed from: d, reason: collision with root package name */
    public int f201745d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        c.InterfaceC7462c f201746a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.mobileqq.comment.a f201747b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f201748c;

        /* renamed from: d, reason: collision with root package name */
        int f201749d;

        /* renamed from: e, reason: collision with root package name */
        int f201750e;

        /* renamed from: f, reason: collision with root package name */
        List<Long> f201751f;

        /* renamed from: g, reason: collision with root package name */
        List<Long> f201752g;

        /* renamed from: h, reason: collision with root package name */
        List<DanmuItemBean> f201753h;

        /* renamed from: i, reason: collision with root package name */
        List<DanmuItemBean> f201754i;

        /* renamed from: j, reason: collision with root package name */
        int f201755j;

        /* renamed from: k, reason: collision with root package name */
        int f201756k;

        /* renamed from: l, reason: collision with root package name */
        int f201757l;

        /* renamed from: m, reason: collision with root package name */
        int f201758m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            this.f201748c = false;
            this.f201749d = 0;
            this.f201750e = 30;
            this.f201755j = 0;
            this.f201756k = 0;
            this.f201757l = 0;
            this.f201758m = 60;
            this.f201754i = new ArrayList();
            this.f201752g = new ArrayList();
        }

        public a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            b f16 = b.f();
            b f17 = b.f();
            com.tencent.mobileqq.comment.a aVar = this.f201747b;
            f16.g(f17.d(aVar.f201736b, aVar.f201735a), this);
            return this;
        }

        public boolean b(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
            }
            for (DanmuItemBean danmuItemBean : this.f201754i) {
                if (danmuItemBean.f201729d == j3 && danmuItemBean.f201730e == j16) {
                    return true;
                }
            }
            return false;
        }

        public a c(com.tencent.mobileqq.comment.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            }
            this.f201747b = aVar;
            return this;
        }

        public a d(List<DanmuItemBean> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            }
            this.f201753h = list;
            return this;
        }

        public a e(c.InterfaceC7462c interfaceC7462c) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) interfaceC7462c);
            }
            this.f201746a = interfaceC7462c;
            return this;
        }

        public a f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f201748c = z16;
            return this;
        }

        public a g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            if (i3 > 0) {
                this.f201750e = i3;
            }
            return this;
        }

        public a h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.f201749d = i3;
            return this;
        }

        public a i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.f201757l = i3;
            return this;
        }

        public a j(List<Long> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            }
            this.f201751f = list;
            return this;
        }

        public a k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            this.f201756k = i3;
            return this;
        }

        public a l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.f201755j = i3;
            return this;
        }

        public String m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format("CacheHolder - topicUin:%s, groupUin:%s, msgType:%s, peakCached:%s, videoStartTime:%s, videoEndTime:%s, nextStartIdx:%s, count:%s", Long.valueOf(this.f201747b.f201735a), Long.valueOf(this.f201747b.f201736b), Integer.valueOf(this.f201747b.f201737c), Boolean.valueOf(this.f201747b.f201738d), Integer.valueOf(this.f201755j), Integer.valueOf(this.f201756k), Integer.valueOf(this.f201757l), Integer.valueOf(this.f201758m));
        }

        public void n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
                return;
            }
            Iterator<DanmuItemBean> it = this.f201754i.iterator();
            while (it.hasNext()) {
                if (this.f201751f.contains(Long.valueOf(it.next().f201730e))) {
                    it.remove();
                }
            }
            List<Long> list = this.f201751f;
            if (list != null && !list.isEmpty()) {
                Iterator<Long> it5 = this.f201751f.iterator();
                while (it5.hasNext()) {
                    long longValue = it5.next().longValue();
                    if (!this.f201752g.contains(Long.valueOf(longValue))) {
                        this.f201752g.add(Long.valueOf(longValue));
                    }
                }
            }
            List<DanmuItemBean> list2 = this.f201753h;
            if (list2 != null && !list2.isEmpty()) {
                for (DanmuItemBean danmuItemBean : this.f201753h) {
                    if (!b(danmuItemBean.f201729d, danmuItemBean.f201730e)) {
                        this.f201754i.add(danmuItemBean);
                    }
                }
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201743b = null;
        this.f201744c = null;
        this.f201745d = ViewUtils.dip2px(150.0f);
        if (this.f201742a == null) {
            this.f201742a = new LruCache<>(10485760);
        }
        if (MobileQQ.sProcessId == 1) {
            if (this.f201743b == null) {
                this.f201743b = new d();
            }
            e();
        }
    }

    public static b f() {
        if (f201741e == null) {
            f201741e = new b();
        }
        return f201741e;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f201742a.evictAll();
        }
    }

    public a b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        a aVar = new a();
        g(str, aVar);
        return aVar;
    }

    public a c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return this.f201742a.get(str);
    }

    public String d(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        return String.valueOf(j3) + j16;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.f201744c == null) {
            this.f201744c = ((TextView) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.hnk, (ViewGroup) null).findViewById(R.id.b2y)).getPaint();
        }
    }

    public void g(String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
        } else {
            this.f201742a.put(str, aVar);
        }
    }

    public void h(com.tencent.mobileqq.comment.a aVar, c.InterfaceC7462c interfaceC7462c) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar, (Object) interfaceC7462c);
            return;
        }
        if (aVar.f201735a != 0 && aVar.f201736b != 0) {
            a c16 = f().c(f().d(aVar.f201736b, aVar.f201735a));
            if (c16 == null) {
                c16 = new a().c(aVar).l(0).k(0).e(interfaceC7462c).a();
                QLog.d("DanmuDataHolder", 2, "request start, reqHolder is null, create it");
            }
            this.f201743b.d(c16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, String.format("request, bad parameter, topicUin:%s, groupUin:%s", Long.valueOf(aVar.f201735a), Long.valueOf(aVar.f201736b)));
        }
    }
}
