package com.tencent.mobileqq.mediafocus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MediaFocusController extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Stack<MediaFocusStackItem> f245781a;

    /* renamed from: b, reason: collision with root package name */
    private a f245782b;

    /* renamed from: c, reason: collision with root package name */
    private Context f245783c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3, String str);

        void onClear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaFocusController(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f245781a = new Stack<>();
        this.f245783c = BaseApplication.getContext();
        this.f245782b = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.mobileqq.mediafocus.request");
        intentFilter.addAction("tencent.mobileqq.mediafocus.abandon");
        this.f245783c.registerReceiver(this, intentFilter);
        com.tencent.mobileqq.mediafocus.a.registerModule();
    }

    private int f(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("MediaFocusController", 2, "handleAbandonMediaFocus size:", Integer.valueOf(this.f245781a.size()), " ,from:", str, " ,pname:", str2);
        }
        try {
            synchronized (this) {
                j(str, str2);
                i(1);
                a aVar = this.f245782b;
                if (aVar != null) {
                    aVar.onClear();
                }
            }
        } catch (ConcurrentModificationException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MediaFocusController", 2, "handleAbandonMediaFocus FATAL EXCEPTION:", e16);
            }
        }
        return 0;
    }

    private int g(MediaFocusStackItem mediaFocusStackItem) {
        if (mediaFocusStackItem == null) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaFocusController", 2, "handleRequestMediaFocus size:", Integer.valueOf(this.f245781a.size()), " ,from:", mediaFocusStackItem.a());
        }
        synchronized (this) {
            if (!this.f245781a.empty() && this.f245781a.peek() != null && this.f245781a.peek().a().equals(mediaFocusStackItem.a()) && this.f245781a.peek().c().equals(mediaFocusStackItem.c())) {
                if (this.f245781a.peek().b() == mediaFocusStackItem.b()) {
                    return 0;
                }
                this.f245781a.pop();
            }
            i(mediaFocusStackItem.b() * (-1));
            j(mediaFocusStackItem.a(), mediaFocusStackItem.c());
            this.f245781a.push(mediaFocusStackItem);
            return 0;
        }
    }

    private boolean h(String str) {
        return BaseApplication.processName.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        if (!this.f245781a.empty() && this.f245781a.peek() != null) {
            MediaFocusStackItem peek = this.f245781a.peek();
            if (h(peek.c())) {
                a aVar = this.f245782b;
                if (aVar != null) {
                    aVar.a(i3, peek.a());
                    return;
                }
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable(peek, i3) { // from class: com.tencent.mobileqq.mediafocus.MediaFocusController.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MediaFocusStackItem f245785d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f245786e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.mediafocus.MediaFocusController$2$a */
                /* loaded from: classes15.dex */
                class a implements EIPCResultCallback {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f245787d;

                    a(long j3) {
                        this.f245787d = j3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, AnonymousClass2.this, Long.valueOf(j3));
                        }
                    }

                    @Override // eipc.EIPCResultCallback
                    public void onCallback(EIPCResult eIPCResult) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                            return;
                        }
                        Bundle bundle = eIPCResult.data;
                        if (bundle != null) {
                            boolean z16 = bundle.getBoolean("isProcessRunning");
                            boolean z17 = eIPCResult.data.getBoolean("isItemExist");
                            long currentTimeMillis = System.currentTimeMillis() - this.f245787d;
                            if (z16 && z17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("MediaFocusController", 2, "notifyFocusChanged not the same process but existed, cost:", Long.valueOf(currentTimeMillis));
                                }
                            } else {
                                MediaFocusController.this.f245781a.pop();
                                if (QLog.isColorLevel()) {
                                    QLog.d("MediaFocusController", 2, "notifyFocusChanged isProcessRun:", Boolean.valueOf(z16), " ,isItmeExist:", Boolean.valueOf(z17), " ,stack:", Integer.valueOf(MediaFocusController.this.f245781a.size()), " ,cost:", Long.valueOf(currentTimeMillis));
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                MediaFocusController.this.i(anonymousClass2.f245786e);
                            }
                        }
                    }
                }

                {
                    this.f245785d = peek;
                    this.f245786e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, MediaFocusController.this, peek, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    Bundle bundle = new Bundle();
                    bundle.putString("processName", this.f245785d.c());
                    bundle.putParcelable("focusItem", this.f245785d);
                    QIPCClientHelper.getInstance().callServer("MediaFocusModuleServer", "actionCheckItemExist", bundle, new a(currentTimeMillis));
                }
            });
        }
    }

    private void j(String str, String str2) {
        Iterator<MediaFocusStackItem> it = this.f245781a.iterator();
        while (it.hasNext()) {
            MediaFocusStackItem next = it.next();
            if (str2.equals(next.c()) && str.equals(next.a())) {
                if (QLog.isColorLevel()) {
                    QLog.d("MediaFocusController", 2, "removeFocusStackEntry : ", next.toString());
                }
                it.remove();
            }
        }
    }

    public boolean c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        Iterator<MediaFocusStackItem> it = this.f245781a.iterator();
        while (it.hasNext()) {
            MediaFocusStackItem next = it.next();
            if (str2.equals(next.c()) && str.equals(next.a())) {
                if (QLog.isColorLevel()) {
                    QLog.d("MediaFocusController", 2, "checkMediaFocusItemExisted yes : ", next.toString());
                }
                return true;
            }
        }
        return false;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f245783c.unregisterReceiver(this);
        this.f245781a.clear();
        this.f245783c = null;
        this.f245782b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MediaFocusStackItem> e() {
        return new ArrayList(this.f245781a);
    }

    public int k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        Intent intent = new Intent("tencent.mobileqq.mediafocus.abandon");
        intent.putExtra("cliendID", str);
        intent.putExtra("processName", BaseApplication.processName);
        try {
            intent.setPackage(this.f245783c.getPackageName());
            ThreadManagerV2.excute(new Runnable(intent) { // from class: com.tencent.mobileqq.mediafocus.MediaFocusController.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f245784d;

                {
                    this.f245784d = intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MediaFocusController.this, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BaseApplication.getContext().sendBroadcast(this.f245784d);
                    }
                }
            }, 16, null, false);
            return 0;
        } catch (NullPointerException unused) {
            QLog.d("MediaFocusController", 1, "context is null while sendMediaFocusAbandon");
            return 1;
        }
    }

    public int l(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str)).intValue();
        }
        if (this.f245783c == null) {
            return 1;
        }
        Intent intent = new Intent("tencent.mobileqq.mediafocus.request");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        MediaFocusStackItem mediaFocusStackItem = new MediaFocusStackItem(i3, System.currentTimeMillis(), str, BaseApplication.processName);
        Bundle bundle = new Bundle();
        bundle.putParcelable("focusItem", mediaFocusStackItem);
        intent.putExtras(bundle);
        BaseApplication.getContext().sendBroadcast(intent);
        return 2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (QLog.isColorLevel()) {
            QLog.i("MediaFocusController", 2, "onReceive action:" + action);
        }
        if (action != null) {
            if (action.equals("tencent.mobileqq.mediafocus.request")) {
                MediaFocusStackItem mediaFocusStackItem = (MediaFocusStackItem) intent.getExtras().getParcelable("focusItem");
                int g16 = g(mediaFocusStackItem);
                if (mediaFocusStackItem != null && h(mediaFocusStackItem.c()) && g16 == 0 && (aVar = this.f245782b) != null) {
                    aVar.a(1, mediaFocusStackItem.a());
                    return;
                }
                return;
            }
            if (action.equals("tencent.mobileqq.mediafocus.abandon")) {
                f(intent.getStringExtra("cliendID"), intent.getStringExtra("processName"));
            }
        }
    }
}
