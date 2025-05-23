package com.tencent.luggage.wxa.yq;

import android.os.AsyncTask;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebDownloadListener;
import com.tencent.xweb.XWebDownloader;

/* compiled from: P */
/* loaded from: classes9.dex */
public class p implements XWebDownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final f f146115a;

    /* renamed from: b, reason: collision with root package name */
    public final q f146116b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends AsyncTask {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            q unused = p.this.f146116b;
            return q.a(p.this.f146115a, 2);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() != 0) {
                p.this.a(num.intValue(), p.this.f146115a.f146066a);
            } else {
                p pVar = p.this;
                pVar.a(pVar.f146115a.f146066a);
            }
        }
    }

    public p(f fVar, q qVar) {
        this.f146115a = fVar;
        this.f146116b = qVar;
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadCancelled() {
        x0.d("XWebRuntimeDownloadListener", "onDownloadCancelled");
        a();
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadCompleted(XWebDownloader.DownloadInfo downloadInfo) {
        x0.d("XWebRuntimeDownloadListener", "onDownloadCompleted, apkVersion:" + this.f146115a.f146073h);
        if (this.f146115a.f146069d) {
            n0.c(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
        } else {
            n0.d(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
        }
        com.tencent.luggage.wxa.wq.g.a(downloadInfo, this.f146115a);
        new a().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadFailed(XWebDownloader.DownloadInfo downloadInfo) {
        x0.d("XWebRuntimeDownloadListener", "onDownloadFailed");
        if (this.f146115a.f146069d) {
            n0.D();
        } else {
            n0.J();
        }
        com.tencent.luggage.wxa.wq.g.a(downloadInfo, this.f146115a);
        a(-1, this.f146115a.f146066a);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadStarted(int i3) {
        x0.d("XWebRuntimeDownloadListener", "onDownloadStarted, type:" + i3 + ", config:" + this.f146115a.c());
        if (this.f146115a.f146069d) {
            n0.C();
        } else {
            n0.I();
        }
        b(this.f146115a.f146066a);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadUpdated(int i3) {
        a(i3);
    }

    public void a(int i3) {
        x0.b("XWebRuntimeDownloadListener", "onXWebUpdateProgress, progress:" + i3);
        s.b(i3);
    }

    public void b(i0 i0Var) {
        x0.d("XWebRuntimeDownloadListener", "onXWebUpdateStarted");
        if (v0.f()) {
            return;
        }
        n0.a(1749L, 20L, 1L);
    }

    public void a() {
        x0.d("XWebRuntimeDownloadListener", "onXWebUpdateCancelled");
        t.a();
        s.g();
    }

    public void a(int i3, i0 i0Var) {
        x0.d("XWebRuntimeDownloadListener", "onXWebUpdateFailed, errorCode:" + i3);
        if (i0Var != null) {
            i0Var.onUpdateFailed(i3);
        }
        t.a();
        s.c();
    }

    public void a(i0 i0Var) {
        x0.d("XWebRuntimeDownloadListener", "onXWebUpdateCompleted");
        if (i0Var != null) {
            i0Var.saveSchedulerConfig(null);
        }
        t.a();
        s.h();
        if (v0.f()) {
            return;
        }
        n0.a(1749L, 21L, 1L);
    }
}
