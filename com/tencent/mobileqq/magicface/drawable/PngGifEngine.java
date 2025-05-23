package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes15.dex */
public class PngGifEngine implements com.tencent.mobileqq.magicface.drawable.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    a f243299d;

    /* renamed from: e, reason: collision with root package name */
    int f243300e;

    /* renamed from: f, reason: collision with root package name */
    boolean f243301f;

    /* renamed from: h, reason: collision with root package name */
    Handler f243302h;

    /* renamed from: i, reason: collision with root package name */
    Runnable f243303i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f243304a;

        /* renamed from: b, reason: collision with root package name */
        public int f243305b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f243306c;

        /* renamed from: d, reason: collision with root package name */
        public String f243307d;

        /* renamed from: e, reason: collision with root package name */
        public b f243308e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PngGifEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243300e = -1;
        this.f243301f = false;
        this.f243303i = new Runnable() { // from class: com.tencent.mobileqq.magicface.drawable.PngGifEngine.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PngGifEngine.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PngGifEngine", 2, "func run begins.");
                }
                String b16 = PngGifEngine.this.b();
                if (TextUtils.isEmpty(b16)) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                Bitmap a16 = PngGifEngine.a(b16);
                if (QLog.isColorLevel()) {
                    QLog.d("PngGifEngine", 2, "func run, bitmap:" + a16);
                }
                synchronized (PngGifEngine.this) {
                    if (a16 != null) {
                        if (!a16.isRecycled() && PngGifEngine.this.f243302h != null) {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            long j3 = uptimeMillis + r6.f243299d.f243305b;
                            Message obtainMessage = PngGifEngine.this.f243302h.obtainMessage(1, a16);
                            if (uptimeMillis2 > j3) {
                                PngGifEngine.this.f243302h.sendMessage(obtainMessage);
                            } else {
                                PngGifEngine.this.f243302h.sendMessageDelayed(obtainMessage, j3 - uptimeMillis2);
                            }
                        }
                    }
                }
            }
        };
        if (QLog.isColorLevel()) {
            QLog.d("PngGifEngine", 2, "func PngGifEngine \u3010Constructor\u3011");
        }
        this.f243302h = PngFrameManager.a(this);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x006c: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:109), block:B:44:0x006c */
    public static Bitmap a(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        int i3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
        options.inTargetDensity = i3;
        if (options.inDensity < i3) {
            options.inDensity = i3;
        }
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                try {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedInputStream2 = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    bufferedInputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                    bufferedInputStream2.close();
                } catch (FileNotFoundException e19) {
                    e = e19;
                    if (QLog.isColorLevel()) {
                        QLog.d("PngGifEngine", 2, e.getMessage());
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return bitmap;
                } catch (OutOfMemoryError e26) {
                    e = e26;
                    if (QLog.isColorLevel()) {
                        QLog.d("PngGifEngine", 2, e.getMessage());
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return bitmap;
                }
            } catch (IOException e27) {
                e27.printStackTrace();
            }
            return bitmap;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream3 = bufferedInputStream;
        }
    }

    String b() {
        if (this.f243301f) {
            return "";
        }
        a aVar = this.f243299d;
        String[] strArr = aVar.f243306c;
        if (strArr == null) {
            this.f243301f = true;
            return aVar.f243307d;
        }
        int i3 = this.f243300e + 1;
        if (i3 >= strArr.length) {
            int i16 = aVar.f243304a - 1;
            aVar.f243304a = i16;
            if (i16 <= 0) {
                this.f243301f = true;
                return aVar.f243307d;
            }
            this.f243300e = -1;
            return strArr[(-1) + 1];
        }
        return strArr[i3];
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f243300e > -1) {
            return true;
        }
        return false;
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        a aVar = this.f243299d;
        if (aVar != null) {
            aVar.f243307d = str;
        }
    }

    public void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f243299d = aVar;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngGifEngine", 2, "func start.");
        }
        if (this.f243299d != null) {
            if (!c()) {
                ThreadManagerV2.post(this.f243303i, 5, null, true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("\u3010PngGifEngine\u3011 task is null.");
    }

    @Override // com.tencent.mobileqq.magicface.drawable.a
    public void handleMsg(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message);
            return;
        }
        if (message.what == 1) {
            b bVar = this.f243299d.f243308e;
            if (bVar != null) {
                bVar.a((Bitmap) message.obj);
            }
            this.f243300e++;
            ThreadManagerV2.post(this.f243303i, 5, null, true);
        }
    }
}
