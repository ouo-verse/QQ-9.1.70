package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.a;

/* loaded from: classes12.dex */
public class QfavFilePreviewController extends f {

    /* renamed from: b, reason: collision with root package name */
    private int f207575b;

    /* renamed from: c, reason: collision with root package name */
    private int f207576c = 80;

    /* renamed from: d, reason: collision with root package name */
    private long f207577d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f207578e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f207579f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f207580g = null;

    /* renamed from: h, reason: collision with root package name */
    private Handler f207581h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    private a.InterfaceC10113a f207582i = new a.InterfaceC10113a() { // from class: com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1
        @Override // cooperation.qqfav.ipc.a.InterfaceC10113a
        public boolean a(int i3, final Bundle bundle) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    QfavFilePreviewController.this.f207576c = bundle.getInt("previewPort", 80);
                    QfavFilePreviewController.this.f207577d = bundle.getLong("previewCode", 0L);
                    QfavFilePreviewController.this.f207580g = bundle.getString("previewUid");
                    QfavFilePreviewController.this.f207578e = bundle.getString("previewHost");
                    QfavFilePreviewController.this.f207579f = bundle.getString("previewKey");
                    if (QLog.isColorLevel()) {
                        QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.this.f207578e + ", port=" + String.valueOf(QfavFilePreviewController.this.f207576c) + ", key=" + QfavFilePreviewController.this.f207579f + ", retCode =" + String.valueOf(QfavFilePreviewController.this.f207577d));
                    }
                    boolean z16 = true;
                    if (1 == QfavFilePreviewController.this.f207575b) {
                        QfavFilePreviewController qfavFilePreviewController = QfavFilePreviewController.this;
                        b bVar = qfavFilePreviewController.f207649a;
                        if (0 != qfavFilePreviewController.f207577d) {
                            z16 = false;
                        }
                        bVar.a(z16, QfavFilePreviewController.this.f207578e, String.valueOf(QfavFilePreviewController.this.f207576c), QfavFilePreviewController.this.f207577d, null, QfavFilePreviewController.this.f207579f, null, QfavFilePreviewController.this.f207580g, null);
                    }
                    QfavFilePreviewController.this.f207575b = 3;
                }
            });
            return true;
        }
    };

    public QfavFilePreviewController(Bundle bundle) {
        this.f207575b = 0;
        QfavPluginProxyService.b().a(3, this.f207582i);
        this.f207575b = 2;
        this.f207581h.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2
            @Override // java.lang.Runnable
            public void run() {
                if (3 != QfavFilePreviewController.this.f207575b) {
                    QfavFilePreviewController qfavFilePreviewController = QfavFilePreviewController.this;
                    qfavFilePreviewController.f207649a.a(false, qfavFilePreviewController.f207578e, String.valueOf(QfavFilePreviewController.this.f207576c), QfavFilePreviewController.this.f207577d, null, QfavFilePreviewController.this.f207579f, null, QfavFilePreviewController.this.f207580g, null);
                    QfavFilePreviewController.this.f207575b = 3;
                    if (QLog.isColorLevel()) {
                        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
                    }
                }
            }
        }, MiniBoxNoticeInfo.MIN_5);
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public void a() {
        this.f207581h.removeCallbacksAndMessages(null);
        QfavPluginProxyService.b().b(3, this.f207582i);
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public int b() {
        return 4;
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public boolean c() {
        if (3 != this.f207575b) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.f207575b + ", newState = STATE_REQUESTING.");
            }
            this.f207575b = 1;
            return true;
        }
        this.f207581h.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                QfavFilePreviewController qfavFilePreviewController = QfavFilePreviewController.this;
                b bVar = qfavFilePreviewController.f207649a;
                if (0 == qfavFilePreviewController.f207577d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.a(z16, QfavFilePreviewController.this.f207578e, String.valueOf(QfavFilePreviewController.this.f207576c), QfavFilePreviewController.this.f207577d, null, QfavFilePreviewController.this.f207579f, null, QfavFilePreviewController.this.f207580g, null);
                if (QLog.isColorLevel()) {
                    QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + QfavFilePreviewController.this.f207578e + ", port=" + QfavFilePreviewController.this.f207576c + ", key=" + QfavFilePreviewController.this.f207579f + ", retCode =" + QfavFilePreviewController.this.f207577d);
                }
            }
        }, 2000L);
        return true;
    }
}
