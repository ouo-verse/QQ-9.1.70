package com.tencent.relation.common.servlet;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationRequestHandler extends BusinessHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final String f364746h;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f364747d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f364748e;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f364749f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class UpdateRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        b f364750d;

        /* renamed from: e, reason: collision with root package name */
        boolean f364751e;

        /* renamed from: f, reason: collision with root package name */
        byte[] f364752f;

        public UpdateRunnable(b bVar, boolean z16, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, Boolean.valueOf(z16), bArr);
                return;
            }
            this.f364750d = bVar;
            this.f364751e = z16;
            this.f364752f = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.f364750d;
            if (bVar != null) {
                bVar.onUpdate(0, this.f364751e, this.f364752f);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f364746h = RelationRequestHandler.class.getName();
        }
    }

    protected RelationRequestHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f364748e = new AtomicLong();
        this.f364749f = new ConcurrentHashMap<>();
        this.f364747d = appInterface;
    }

    public void D2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, fromServiceMsg, bArr);
            return;
        }
        String stringExtra = intent.getStringExtra("__cmd_seq__");
        if (!TextUtils.isEmpty(stringExtra) && this.f364749f.containsKey(stringExtra)) {
            b bVar = this.f364749f.get(stringExtra);
            this.f364749f.remove(stringExtra);
            ThreadManagerV2.excute(new UpdateRunnable(bVar, fromServiceMsg.isSuccess(), bArr), 16, null, true);
        }
    }

    @Override // com.tencent.relation.common.servlet.a
    public void F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            this.f364749f.remove(str);
        }
    }

    @Override // com.tencent.relation.common.servlet.a
    public void Z0(String str, byte[] bArr, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, bArr, bVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f364747d.getApplicationContext(), f.class);
        String str2 = str + "_" + this.f364748e.getAndIncrement();
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("timeout", 30000L);
        newIntent.putExtra("__cmd_seq__", str2);
        this.f364749f.put(str2, bVar);
        this.f364747d.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.relation.common.servlet.a
    public b u1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && this.f364749f.containsKey(str)) {
            return this.f364749f.get(str);
        }
        return null;
    }

    @Override // com.tencent.relation.common.servlet.a
    public void z(String str, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bVar);
        } else if (!TextUtils.isEmpty(str) && bVar != null) {
            this.f364749f.put(str, bVar);
        }
    }
}
