package com.tencent.upgrade.download;

import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.util.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a implements com.tencent.upgrade.download.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private DownloadManager f383867a;

    /* renamed from: b, reason: collision with root package name */
    private b f383868b;

    /* renamed from: c, reason: collision with root package name */
    private Context f383869c;

    /* renamed from: d, reason: collision with root package name */
    private String f383870d;

    /* renamed from: e, reason: collision with root package name */
    private long f383871e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f383872f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f383873g;

    /* compiled from: P */
    /* renamed from: com.tencent.upgrade.download.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    class HandlerC10037a extends Handler {
        static IPatchRedirector $redirector_;

        HandlerC10037a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            DownloadParam downloadParam = (DownloadParam) message.getData().get("param");
            if (downloadParam != null) {
                float downLoadedSize = downloadParam.getDownLoadedSize();
                int totalSize = downloadParam.getTotalSize();
                if (downLoadedSize != 0.0f && totalSize != 0) {
                    a.a(a.this);
                    d.a("DefaultDownLoader", "percent is: " + (downLoadedSize / totalSize) + ", downloadedSize = " + downLoadedSize + ", totalSize = " + totalSize);
                    a.this.f(downloadParam.status);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends ContentObserver {
        static IPatchRedirector $redirector_;

        public b() {
            super(a.this.f383873g);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DownloadParam e16 = a.this.e();
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("param", e16);
                obtain.setData(bundle);
                a.this.f383873g.sendMessage(obtain);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383868b = new b();
        this.f383872f = false;
        this.f383873g = new HandlerC10037a(Looper.getMainLooper());
        Context i3 = j.l().i();
        this.f383869c = i3;
        this.f383867a = (DownloadManager) i3.getSystemService("download");
    }

    static /* synthetic */ pw4.a a(a aVar) {
        aVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadParam e() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.f383867a.query(new DownloadManager.Query().setFilterById(this.f383871e));
                if (cursor != null && cursor.moveToFirst()) {
                    DownloadParam downloadParam = new DownloadParam(cursor.getInt(cursor.getColumnIndexOrThrow("total_size")), cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far")), cursor.getInt(cursor.getColumnIndex("status")));
                    cursor.close();
                    return downloadParam;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return DownloadParam.getDefaultParam();
            } catch (Exception unused) {
                DownloadParam defaultParam = DownloadParam.getDefaultParam();
                if (cursor != null) {
                    cursor.close();
                }
                return defaultParam;
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        if (i3 != 8) {
            if (i3 == 16) {
                d.a("DefaultDownLoader", "handleDownStatus STATUS_FAILED");
                g();
                return;
            }
            return;
        }
        d.a("DefaultDownLoader", "handleDownStatus STATUS_SUCCESSFUL");
        g();
    }

    private void g() {
        this.f383872f = false;
        this.f383869c.getContentResolver().unregisterContentObserver(this.f383868b);
        this.f383870d = null;
        this.f383871e = 0L;
    }
}
