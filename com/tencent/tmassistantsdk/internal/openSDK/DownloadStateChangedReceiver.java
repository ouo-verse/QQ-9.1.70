package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DownloadStateChangedReceiver extends BroadcastReceiver {

    /* renamed from: e, reason: collision with root package name */
    protected static final String f380561e = "DownloadStateChangedReceiver";

    /* renamed from: f, reason: collision with root package name */
    protected static DownloadStateChangedReceiver f380562f;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f380564b;

    /* renamed from: a, reason: collision with root package name */
    protected HandlerThread f380563a = new BaseHandlerThread("downloadStateChangedThread");

    /* renamed from: c, reason: collision with root package name */
    protected boolean f380565c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<com.tencent.tmassistantsdk.internal.openSDK.a> f380566d = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f380567a;

        a(Intent intent) {
            this.f380567a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = new d();
            this.f380567a.getStringExtra("hostPackageName");
            this.f380567a.getStringExtra("hostVersion");
            dVar.f380581b = this.f380567a.getStringExtra(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            dVar.f380583d = Integer.parseInt(this.f380567a.getStringExtra("errorCode"));
            dVar.f380584e = this.f380567a.getStringExtra("errorMsg");
            dVar.f380582c = Integer.parseInt(this.f380567a.getStringExtra("state"));
            TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
            tMAssistantCallYYBParamStruct.SNGAppId = this.f380567a.getStringExtra("sngAppId");
            tMAssistantCallYYBParamStruct.taskAppId = this.f380567a.getStringExtra("taskAppId");
            tMAssistantCallYYBParamStruct.taskApkId = this.f380567a.getStringExtra("taskApkId");
            tMAssistantCallYYBParamStruct.taskPackageName = this.f380567a.getStringExtra("taskPackageName");
            tMAssistantCallYYBParamStruct.taskVersion = Integer.parseInt(this.f380567a.getStringExtra("taskVersion"));
            tMAssistantCallYYBParamStruct.via = this.f380567a.getStringExtra("via");
            tMAssistantCallYYBParamStruct.uin = this.f380567a.getStringExtra("uin");
            tMAssistantCallYYBParamStruct.uinType = this.f380567a.getStringExtra("uinType");
            dVar.f380580a = tMAssistantCallYYBParamStruct;
            Iterator<com.tencent.tmassistantsdk.internal.openSDK.a> it = DownloadStateChangedReceiver.this.f380566d.iterator();
            while (it.hasNext()) {
                it.next().onDownloadStateChanged(dVar);
            }
        }
    }

    public DownloadStateChangedReceiver() {
        this.f380564b = null;
        this.f380563a.start();
        this.f380564b = new Handler(this.f380563a.getLooper());
    }

    public static synchronized DownloadStateChangedReceiver a() {
        DownloadStateChangedReceiver downloadStateChangedReceiver;
        synchronized (DownloadStateChangedReceiver.class) {
            if (f380562f == null) {
                f380562f = new DownloadStateChangedReceiver();
            }
            downloadStateChangedReceiver = f380562f;
        }
        return downloadStateChangedReceiver;
    }

    public void b(Context context) {
        if (context != null && f380562f != null) {
            if (this.f380565c) {
                r.b(f380561e, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
                try {
                    context.unregisterReceiver(this);
                    this.f380565c = false;
                    return;
                } catch (Throwable th5) {
                    r.b(f380561e, "unRegisteReceiver exception!!!", th5);
                    this.f380565c = false;
                    th5.printStackTrace();
                    return;
                }
            }
            return;
        }
        r.b(f380561e, "unRegisteReceiver fail! context = " + context + ",mInstance = " + f380562f);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        r.b(f380561e, "context = " + context + ",intent = " + intent);
        Handler handler = this.f380564b;
        if (handler != null) {
            handler.post(new a(intent));
        }
    }

    public void a(Context context) {
        r.b(f380561e, "context = " + context);
        if (this.f380565c) {
            return;
        }
        r.b(f380561e, "registeReceiver   context" + context + "  receiver:" + this);
        try {
            r.b(f380561e, "" + context.registerReceiver(this, new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action")));
            this.f380565c = true;
        } catch (Throwable th5) {
            r.b(f380561e, "registeReceiver exception!!!");
            this.f380565c = false;
            th5.printStackTrace();
        }
    }

    public void b(com.tencent.tmassistantsdk.internal.openSDK.a aVar) {
        r.b(f380561e, "listener = " + aVar);
        if (aVar != null) {
            this.f380566d.remove(aVar);
        }
    }

    public void a(com.tencent.tmassistantsdk.internal.openSDK.a aVar) {
        r.b(f380561e, "listener = " + aVar);
        if (aVar == null || this.f380566d.contains(aVar)) {
            return;
        }
        this.f380566d.add(aVar);
    }
}
