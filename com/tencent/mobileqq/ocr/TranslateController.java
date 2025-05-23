package com.tencent.mobileqq.ocr;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arengine.m;
import com.tencent.mobileqq.ar.arengine.p;
import com.tencent.mobileqq.ar.arengine.q;
import com.tencent.mobileqq.ar.arengine.s;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import v81.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TranslateController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private v81.a f254600a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f254601b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f254602c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f254603d;

    /* renamed from: e, reason: collision with root package name */
    private IOCRHandler f254604e;

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, ImageTranslateTask> f254605f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class ImageTranslateTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f254606d;

        /* renamed from: e, reason: collision with root package name */
        String f254607e;

        /* renamed from: f, reason: collision with root package name */
        String f254608f;

        /* renamed from: h, reason: collision with root package name */
        boolean f254609h;
        final /* synthetic */ TranslateController this$0;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a implements a.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f254610a;

            a(q qVar) {
                this.f254610a = qVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageTranslateTask.this, (Object) qVar);
                }
            }

            @Override // v81.a.c
            public void a(int i3, String str, m mVar) {
                TranslateResult translateResult;
                boolean z16;
                String str2;
                TranslateResult translateResult2;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = true;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, mVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    if (mVar != null) {
                        translateResult2 = mVar.f198214l;
                    } else {
                        translateResult2 = null;
                    }
                    QLog.d("TranslateController", 2, "imageTranslate, retCode:" + i3 + ",sessionId:" + str + ",result: " + translateResult2);
                }
                if (mVar != null && (translateResult = mVar.f198214l) != null) {
                    z16 = true;
                } else {
                    translateResult = new TranslateResult(2);
                    translateResult.D = 1002;
                    z16 = false;
                }
                p pVar = this.f254610a.f198241b;
                String str3 = pVar.f198239e;
                String str4 = pVar.f198235a;
                translateResult.f254725i = str3;
                if (com.tencent.mobileqq.filemanager.util.q.p(str4) && !str4.equals(str3)) {
                    com.tencent.mobileqq.filemanager.util.q.d(str4);
                }
                TranslateController translateController = ImageTranslateTask.this.this$0;
                if (i3 != 0) {
                    z17 = false;
                }
                translateController.f(z17, str3, translateResult);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("costTime", String.valueOf(System.currentTimeMillis() - this.f254610a.f198256q));
                hashMap.put("retCode", String.valueOf(i3));
                if (z16) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                hashMap.put("hasResult", str2);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, hashMap, "", false);
            }
        }

        private String e() {
            return String.format("%s_%s_%05d", this.this$0.f254603d.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)));
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!com.tencent.mobileqq.filemanager.util.q.p(this.f254606d)) {
                QLog.d("TranslateController", 1, "picTranslate, file is not exists: " + this.f254606d);
                TranslateResult translateResult = new TranslateResult(2);
                translateResult.D = 1001;
                this.this$0.f(false, this.f254606d, translateResult);
                return;
            }
            String str = this.f254606d;
            if (this.f254609h) {
                String cachePath = ((IOCR) QRoute.api(IOCR.class)).getCachePath(this.f254606d);
                if (!((IOCR) QRoute.api(IOCR.class)).compressImage(this.f254606d, cachePath)) {
                    str = this.f254606d;
                    QLog.d("TranslateController", 1, "compress image failed!");
                } else {
                    str = cachePath;
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outHeight;
            int i16 = options.outWidth;
            p pVar = new p();
            pVar.f198239e = this.f254606d;
            pVar.f198235a = str;
            pVar.f198236b = 0;
            pVar.f198237c = i3;
            pVar.f198238d = i16;
            s sVar = new s();
            sVar.f198259b = this.f254607e;
            sVar.f198260c = this.f254608f;
            sVar.f198258a = e();
            q qVar = new q();
            qVar.f198240a = e();
            qVar.f198241b = pVar;
            qVar.f198253n = sVar;
            qVar.f198243d = 900000000;
            qVar.f198242c = 900000000;
            qVar.f198244e = 8192L;
            qVar.f198245f = 0;
            qVar.f198254o = String.valueOf(this.this$0.f254603d.getAppid());
            qVar.f198255p = Long.parseLong(this.this$0.f254603d.getCurrentAccountUin());
            qVar.f198256q = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("TranslateController", 2, String.format("picTranslate, fileInfo:%s, fileSize:%s", pVar.toString(), (new File(str).length() / 1024) + "KB"));
            }
            if (QLog.isColorLevel()) {
                QLog.d("TranslateController", 2, "picTranslate reqInfo:" + qVar);
            }
            if (this.this$0.f254600a == null) {
                TranslateController translateController = this.this$0;
                translateController.f254600a = new v81.a(translateController.f254603d);
            }
            this.this$0.f254600a.n(qVar, new a(qVar));
        }
    }

    public TranslateController(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f254603d = qQAppInterface;
        v81.a aVar = new v81.a(qQAppInterface);
        this.f254600a = aVar;
        aVar.l();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TranslateFileUpload_" + System.currentTimeMillis());
        this.f254601b = baseHandlerThread;
        baseHandlerThread.start();
        this.f254602c = new Handler(this.f254601b.getLooper());
        this.f254605f = new HashMap<>();
        this.f254604e = (IOCRHandler) this.f254603d.getRuntimeService(IOCRHandler.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16, String str, TranslateResult translateResult) {
        if (!TextUtils.isEmpty(str) && this.f254604e != null) {
            if (translateResult != null) {
                translateResult.f254725i = str;
            }
            this.f254604e.notifyUI(2, z16, new Object[]{2, translateResult});
            synchronized (this.f254605f) {
                this.f254605f.remove(str);
            }
        }
    }

    public void e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        IOCRHandler iOCRHandler = this.f254604e;
        if (iOCRHandler != null) {
            iOCRHandler.batchTranslate(str, str2, str3);
        }
    }
}
