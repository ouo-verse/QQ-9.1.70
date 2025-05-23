package com.tencent.mobileqq.qrscan;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class t implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f276791d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f276792e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f276793f;

    /* renamed from: h, reason: collision with root package name */
    private String f276794h;

    /* renamed from: i, reason: collision with root package name */
    private a f276795i;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(ScannerResult scannerResult, int i3);

        void c(int i3);
    }

    public t(Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.f276794h = CommonConstant.RETKEY.QR_CODE;
        this.f276791d = context;
        this.f276795i = aVar;
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).init(context, hashCode(), "QrImageScan");
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        if (this.f276791d == null) {
            return;
        }
        Uri parse = Uri.parse("file://" + str);
        if (this.f276792e == null) {
            synchronized (this) {
                if (this.f276792e == null) {
                    this.f276792e = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
                    this.f276793f = new Handler(this.f276791d.getMainLooper(), this);
                }
            }
        }
        this.f276792e.obtainMessage(1, i3, 0, parse).sendToTarget();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            Handler handler = this.f276792e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f276792e = null;
            }
            Handler handler2 = this.f276793f;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
                this.f276793f = null;
            }
            ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "QrImageScan");
        }
        this.f276795i = null;
        this.f276791d = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    int i16 = message.arg1;
                    a aVar = this.f276795i;
                    if (aVar != null) {
                        aVar.c(i16);
                    }
                }
            } else {
                int i17 = message.arg1;
                a aVar2 = this.f276795i;
                if (aVar2 != null) {
                    aVar2.a((ScannerResult) message.obj, i17);
                }
            }
        } else {
            int i18 = message.arg1;
            ScannerResult g16 = com.tencent.mobileqq.qrscan.utils.d.g((Uri) message.obj, this.f276791d, i18);
            if (g16 != null && g16.m()) {
                Handler handler = this.f276793f;
                if (handler != null) {
                    handler.obtainMessage(2, i18, 0, g16).sendToTarget();
                }
            } else {
                Handler handler2 = this.f276793f;
                if (handler2 != null) {
                    handler2.obtainMessage(3, i18, 0).sendToTarget();
                }
            }
        }
        return true;
    }
}
