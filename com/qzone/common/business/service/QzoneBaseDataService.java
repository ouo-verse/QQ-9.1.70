package com.qzone.common.business.service;

import android.os.Handler;
import android.os.Looper;
import com.qzone.common.event.Observable;
import com.qzone.common.requestengine.callbacks.ITransFinished;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import com.qzone.common.requestengine.request.Request;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBaseDataService extends Observable implements ITransFinished {
    private static final String TAG = "QzoneBaseDataService";
    private static Handler mMainHandler = new Handler(Looper.getMainLooper());
    private boolean mHadInit;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static a f45793c;

        /* renamed from: a, reason: collision with root package name */
        private final String f45794a = QzoneBaseDataService.class.getSimpleName();

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<QzoneBaseDataService> f45795b = new ArrayList<>();

        public static synchronized a b() {
            a aVar;
            synchronized (a.class) {
                if (f45793c == null) {
                    f45793c = new a();
                }
                aVar = f45793c;
            }
            return aVar;
        }

        public synchronized void a(QzoneBaseDataService qzoneBaseDataService) {
            this.f45795b.add(qzoneBaseDataService);
        }
    }

    public QzoneBaseDataService() {
        a.b().a(this);
    }

    public static void postResponseToMainThread(final e6.a aVar) {
        QZLog.i(TAG, "postResponseToMainThread:" + aVar);
        final QZoneServiceCallback b16 = aVar.b();
        if (b16 == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b16.onResult(aVar.c());
        } else {
            mMainHandler.post(new Runnable() { // from class: com.qzone.common.business.service.QzoneBaseDataService.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneServiceCallback.this.onResult(aVar.c());
                }
            });
        }
    }

    public boolean isHadInit() {
        return this.mHadInit;
    }

    public void setHadInit(boolean z16) {
        this.mHadInit = z16;
    }

    @Override // com.qzone.common.requestengine.callbacks.ITransFinished
    public final void transFinished(Request request) {
        QZLog.i(TAG, "transFinished " + request.requestTrait());
        onTransFinished(request);
        if (request.getResponse() == null || request.getResponse().c() == null) {
            return;
        }
        postResponseToMainThread(request.getResponse());
    }

    public QzoneBaseDataService(String str) {
        super(str);
        a.b().a(this);
    }

    public void onClosed(long j3) {
    }

    public void onInit(long j3) {
    }

    protected void onTransFinished(Request request) {
    }
}
