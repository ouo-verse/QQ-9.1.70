package com.tencent.mobileqq.shortvideo.gesture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.gesture.a;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    DownloadInfo f287885a;

    /* renamed from: b, reason: collision with root package name */
    int f287886b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a.InterfaceC8592a> f287887c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            if (intent != null && intent.getAction() != null && "tencent.video.gesturemgr.notify".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("Event_Progress", 0);
                if (intExtra != 100 && intExtra >= 0) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QavGesture", 4, String.format("receive notify, progress[%s]", Integer.valueOf(intExtra)));
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (c.this.f287887c) {
                        arrayList.addAll(c.this.f287887c);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a.InterfaceC8592a) it.next()).onDownloadProgress(intExtra);
                    }
                    return;
                }
                c.this.f287885a = DownloadInfo.get();
                c cVar = c.this;
                int i3 = cVar.f287886b;
                cVar.f287886b = d.b(cVar.f287885a);
                if (intExtra == 100 && c.this.f287886b != 11) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QavGesture", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGesture[%s], data[%s]", Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(c.this.f287886b), c.this.f287885a));
                }
                ArrayList arrayList2 = new ArrayList();
                synchronized (c.this.f287887c) {
                    arrayList2.addAll(c.this.f287887c);
                }
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ((a.InterfaceC8592a) it5.next()).l8(z16, c.this.c(), c.this.f287886b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        this.f287885a = null;
        this.f287886b = 0;
        e(BaseApplicationImpl.getApplication());
        DownloadInfo downloadInfo = DownloadInfo.get();
        this.f287885a = downloadInfo;
        int b16 = d.b(downloadInfo);
        this.f287886b = b16;
        QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", Integer.valueOf(b16)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z16, a.InterfaceC8592a interfaceC8592a) {
        synchronized (this.f287887c) {
            if (z16) {
                this.f287887c.add(interfaceC8592a);
            } else {
                this.f287887c.remove(interfaceC8592a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        DownloadInfo downloadInfo = DownloadInfo.get();
        this.f287885a = downloadInfo;
        this.f287886b = d.b(downloadInfo);
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("checkResReady, mStatusGesture[%s]", Integer.valueOf(this.f287886b)));
        }
        if (11 == this.f287886b) {
            return false;
        }
        return true;
    }

    boolean c() {
        if (this.f287886b == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        boolean z16;
        DownloadInfo downloadInfo = DownloadInfo.get();
        this.f287885a = downloadInfo;
        int i3 = this.f287886b;
        int b16 = d.b(downloadInfo);
        this.f287886b = b16;
        if (b16 == 11) {
            this.f287886b = 12;
            BusinessCommonConfig.notifyQQDownload(1, null, 0);
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavGesture", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGesture[%s]", Integer.valueOf(i3), Integer.valueOf(this.f287886b)));
        }
        return z16;
    }

    boolean e(BaseApplicationImpl baseApplicationImpl) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("registReceiver[%s]", baseApplicationImpl.getQQProcessName()));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.gesturemgr.notify");
        if (baseApplicationImpl.registerReceiver(new a(), intentFilter) == null) {
            return false;
        }
        return true;
    }
}
