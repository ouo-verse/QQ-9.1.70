package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class QQDownloaderInstalled extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    protected static QQDownloaderInstalled f380569c;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f380570a = false;

    /* renamed from: b, reason: collision with root package name */
    protected b f380571b = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f380572a;

        a(Context context) {
            this.f380572a = context;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            b bVar = QQDownloaderInstalled.this.f380571b;
            if (bVar != null) {
                bVar.onQQDownloaderInstalled(this.f380572a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void onQQDownloaderInstalled(Context context);
    }

    QQDownloaderInstalled() {
    }

    public static synchronized QQDownloaderInstalled a() {
        QQDownloaderInstalled qQDownloaderInstalled;
        synchronized (QQDownloaderInstalled.class) {
            if (f380569c == null) {
                f380569c = new QQDownloaderInstalled();
            }
            qQDownloaderInstalled = f380569c;
        }
        return qQDownloaderInstalled;
    }

    public void b(Context context) {
        if (context == null || f380569c == null || !this.f380570a) {
            return;
        }
        try {
            context.unregisterReceiver(this);
            this.f380570a = false;
        } catch (Throwable th5) {
            this.f380570a = false;
            th5.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new a(context).start();
    }

    public void a(Context context) {
        if (this.f380570a) {
            return;
        }
        try {
            context.registerReceiver(this, new IntentFilter(SDKConst.QQDOWNLOADER_FIRST_START_ACTION_NAME));
            this.f380570a = true;
        } catch (Throwable th5) {
            this.f380570a = false;
            th5.printStackTrace();
        }
    }

    public void b() {
        this.f380571b = null;
    }

    public void a(b bVar) {
        this.f380571b = bVar;
    }
}
