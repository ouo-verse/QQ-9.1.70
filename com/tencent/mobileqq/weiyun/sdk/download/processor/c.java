package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weiyun.model.a;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import y43.d;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final b f315223d;

    /* renamed from: e, reason: collision with root package name */
    private final ReleaseLooperHandler f315224e;

    /* renamed from: f, reason: collision with root package name */
    private d f315225f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements y43.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f315226a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f315227b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weiyun.model.b f315228c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f315229d;

        a(String str, long j3, com.tencent.mobileqq.weiyun.model.b bVar, int i3) {
            this.f315226a = str;
            this.f315227b = j3;
            this.f315228c = bVar;
            this.f315229d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, Long.valueOf(j3), bVar, Integer.valueOf(i3));
            }
        }

        @Override // y43.a
        public void a(com.tencent.mobileqq.weiyun.model.a aVar, boolean z16, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, aVar, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            if (aVar != null && TextUtils.equals(this.f315226a, aVar.f315158e)) {
                if (z16) {
                    if (aVar.G == null) {
                        c.this.f315223d.onFetchError(this.f315227b, ErrorCode.CMD_INVALID_RSP, "");
                        return;
                    } else {
                        c.this.f315223d.e(this.f315227b, aVar.G);
                        return;
                    }
                }
                if (i3 == 1002 && !this.f315228c.n()) {
                    this.f315228c.x(true);
                    Message obtain = Message.obtain();
                    obtain.what = 21;
                    obtain.obj = this.f315228c;
                    obtain.arg1 = this.f315229d;
                    c.this.f315224e.sendMessageDelayed(obtain, 1000L);
                    return;
                }
                c.this.f315223d.onFetchError(this.f315227b, i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void e(long j3, a.b bVar);

        void onFetchError(long j3, int i3, String str);
    }

    public c(b bVar, d dVar, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, dVar, releaseLooperHandler);
            return;
        }
        this.f315223d = bVar;
        this.f315224e = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
        this.f315225f = dVar;
    }

    private void d(com.tencent.mobileqq.weiyun.model.b bVar, int i3) {
        if (bVar == null) {
            return;
        }
        long e16 = bVar.e();
        String str = bVar.g().f315158e;
        if (bVar.k()) {
            return;
        }
        this.f315225f.a(bVar.g().clone(), i3, new a(str, e16, bVar, i3));
    }

    public void c(com.tencent.mobileqq.weiyun.model.b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
        } else {
            if (bVar == null) {
                return;
            }
            this.f315224e.sendMessage(Message.obtain(null, 21, i3, 0, bVar));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 21) {
            d((com.tencent.mobileqq.weiyun.model.b) message.obj, message.arg1);
            return true;
        }
        return false;
    }
}
