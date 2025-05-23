package com.tencent.mobileqq.profile.upload.task;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f260321a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f260322b;

    /* renamed from: c, reason: collision with root package name */
    protected int f260323c;

    /* renamed from: d, reason: collision with root package name */
    protected String f260324d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f260325e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f260326f;

    /* renamed from: g, reason: collision with root package name */
    public int f260327g;

    /* renamed from: h, reason: collision with root package name */
    public int f260328h;

    /* renamed from: i, reason: collision with root package name */
    public String f260329i;

    /* renamed from: j, reason: collision with root package name */
    public int f260330j;

    /* renamed from: k, reason: collision with root package name */
    public String f260331k;

    /* renamed from: l, reason: collision with root package name */
    public Map<String, String> f260332l;

    /* renamed from: m, reason: collision with root package name */
    public String f260333m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f260334n;

    /* renamed from: o, reason: collision with root package name */
    public long f260335o;

    /* renamed from: p, reason: collision with root package name */
    protected byte[] f260336p;

    /* renamed from: q, reason: collision with root package name */
    protected String f260337q;

    /* renamed from: r, reason: collision with root package name */
    protected String f260338r;

    /* renamed from: s, reason: collision with root package name */
    protected int f260339s;

    /* renamed from: t, reason: collision with root package name */
    protected IUploadTaskCallback f260340t;

    /* renamed from: u, reason: collision with root package name */
    protected IUploadTaskCallback f260341u;

    /* renamed from: v, reason: collision with root package name */
    protected AbstractUploadTask f260342v;

    /* renamed from: w, reason: collision with root package name */
    protected volatile int f260343w;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.upload.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8247a implements IUploadTaskCallback {
        static IPatchRedirector $redirector_;

        C8247a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, abstractUploadTask, Integer.valueOf(i3), str);
                return;
            }
            a.this.f260343w = 1002;
            a aVar = a.this;
            aVar.f260323c = i3;
            aVar.f260324d = str;
            aVar.e(1002, new Object[0]);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, abstractUploadTask, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractUploadTask, i3);
            } else if (a.this.f260343w != i3) {
                a.this.f260343w = i3;
                a aVar = a.this;
                aVar.e(aVar.f260343w, new Object[0]);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) abstractUploadTask, obj);
                return;
            }
            a.this.f260343w = 1001;
            a aVar = a.this;
            aVar.f260322b = obj;
            aVar.e(1001, new Object[0]);
        }
    }

    public a(long j3, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), str, bArr);
            return;
        }
        this.f260322b = null;
        this.f260324d = "";
        this.f260325e = null;
        this.f260326f = false;
        this.f260327g = 6;
        this.f260328h = 0;
        this.f260331k = "mqq";
        this.f260332l = null;
        this.f260339s = -1;
        this.f260341u = new C8247a();
        this.f260343w = -10001;
        this.f260335o = j3;
        this.f260337q = str;
        this.f260338r = com.tencent.mobileqq.profile.upload.a.a(str);
        this.f260339s = a();
        this.f260336p = bArr;
        this.f260340t = this.f260341u;
    }

    protected int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        String str = this.f260337q;
        if (str == null) {
            str = "";
        }
        return (str + System.currentTimeMillis()).hashCode();
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f260323c;
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f260324d;
    }

    public final Object d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f260322b;
    }

    protected abstract void e(int i3, Object... objArr);

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f260321a)) {
            hashMap.put("task_state", this.f260321a);
        }
        if (!TextUtils.isEmpty(this.f260342v.uiRefer)) {
            hashMap.put(FSUploadConst.KEY_REFER, this.f260342v.uiRefer);
        }
        this.f260342v.transferData = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.f260342v != null) {
                if (!i()) {
                    return;
                }
                f();
                h();
                return;
            }
            throw new NullPointerException("Are you forget call buildTask()?");
        }
    }

    protected boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f260342v.uploadFilePath)) {
            this.f260341u.onUploadError(this.f260342v, -1, "no file path!");
            return false;
        }
        File file = new File(this.f260342v.uploadFilePath);
        if (file.exists() && file.length() != 0 && !file.isDirectory()) {
            this.f260342v.transferData.put("task_state", FSUploadConst.STATE_RUNNING);
            return UploadServiceBuilder.getInstance().upload(this.f260342v);
        }
        this.f260341u.onUploadError(this.f260342v, -2, "file is not exist or empty!");
        return false;
    }

    protected boolean i() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.f260336p != null && (bArr = this.f260334n) != null && bArr.length != 0) {
            return true;
        }
        this.f260341u.onUploadError(this.f260342v, -3, "invalid login data");
        return false;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f260322b = null;
        this.f260324d = "";
        this.f260325e = null;
        this.f260326f = false;
        this.f260327g = 6;
        this.f260328h = 0;
        this.f260331k = "mqq";
        this.f260332l = null;
        this.f260339s = -1;
        this.f260341u = new C8247a();
        this.f260343w = -10001;
    }
}
