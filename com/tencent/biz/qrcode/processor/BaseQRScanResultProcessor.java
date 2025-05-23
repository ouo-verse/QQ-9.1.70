package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes5.dex */
public abstract class BaseQRScanResultProcessor implements com.tencent.mobileqq.qrscan.f {

    /* renamed from: a, reason: collision with root package name */
    protected AppRuntime f94979a;

    /* renamed from: b, reason: collision with root package name */
    protected k f94980b;

    /* loaded from: classes5.dex */
    protected static abstract class a implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        public abstract void a();

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a();
        }
    }

    public BaseQRScanResultProcessor(AppRuntime appRuntime, k kVar) {
        this.f94979a = appRuntime;
        this.f94980b = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        QQAppInterface qQAppInterface = (QQAppInterface) this.f94979a;
        if (!qQAppInterface.isRingerVibrate() && !qQAppInterface.isRingerSilent() && !qQAppInterface.isRingEqualsZero()) {
            AudioUtil.n(R.raw.f169446aa, false);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean a(int i3, String str, String str2, ScannerParams scannerParams) {
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean b(int i3, int i16, Intent intent) {
        QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("handleActivityResult requestCode=%d resultCode=%d data=%s", Integer.valueOf(i3), Integer.valueOf(i16), intent));
        return j(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean c(int i3, int i16, Intent intent) {
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public final boolean d(String str, String str2, ScannerParams scannerParams) {
        boolean g16 = g();
        QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("handleQRResult result=%s qBarType=%s checkNetWork=%b scannerParams=%s", str, str2, Boolean.valueOf(g16), scannerParams));
        if (!g16) {
            return false;
        }
        f();
        return k(str, str2, scannerParams);
    }

    public void f() {
        if (!(this.f94979a instanceof QQAppInterface)) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseQRScanResultProcessor.this.h();
                }
            }, 16, null, true);
        } else {
            h();
        }
    }

    public boolean g() {
        return i();
    }

    protected boolean i() {
        final Activity activity = (Activity) this.f94980b.getContext();
        if (activity == null) {
            QLog.e("IQRScanConst_BaseQRScanResultProcessor", 1, "doCheckNetAndTip, but activity is null!");
            return false;
        }
        if (HttpUtil.isConnect(activity.getApplicationContext())) {
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor.2

            /* renamed from: com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor$2$a */
            /* loaded from: classes5.dex */
            class a extends a {
                a() {
                }

                @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor.a
                public void a() {
                    BaseQRScanResultProcessor.this.f94980b.c();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
                createCustomDialog.setMessage(R.string.h67);
                a aVar = new a();
                createCustomDialog.setPositiveButton(R.string.f171151ok, aVar);
                createCustomDialog.setOnCancelListener(aVar);
                createCustomDialog.show();
            }
        });
        return false;
    }

    protected boolean j(int i3, int i16, Intent intent) {
        return false;
    }

    protected boolean k(String str, String str2, ScannerParams scannerParams) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(int i3) {
        if ((i3 & 2) == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(int i3) {
        if ((i3 & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public void onDestroy() {
    }
}
