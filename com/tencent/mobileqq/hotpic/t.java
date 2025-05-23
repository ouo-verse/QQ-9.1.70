package com.tencent.mobileqq.hotpic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile t f237044f;

    /* renamed from: a, reason: collision with root package name */
    private Context f237045a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f237046b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<c> f237047c;

    /* renamed from: d, reason: collision with root package name */
    private INetInfoHandler f237048d;

    /* renamed from: e, reason: collision with root package name */
    BroadcastReceiver f237049e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(5);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoItemEventManager", 2, "onNetMobile2None onConnClose");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(4);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoItemEventManager", 2, "onNetMobile2Wifi onConnOK");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(3);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoItemEventManager", 2, "onNetNone2Mobile onConnOK");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(2);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoItemEventManager", 2, "onNetNone2Wifi onConnOK");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(1);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator it = t.this.f237047c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).e(0);
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoItemEventManager", 2, "onNetWifi2None onConnClose");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f237051a;

        /* renamed from: b, reason: collision with root package name */
        private final String f237052b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            } else {
                this.f237051a = "reason";
                this.f237052b = GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("VideoItemEventManager", 2, "onReceive ===>" + action);
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                Iterator it = t.this.f237047c.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(false);
                }
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                Iterator it5 = t.this.f237047c.iterator();
                while (it5.hasNext()) {
                    ((c) it5.next()).a(true);
                }
                return;
            }
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                Iterator it6 = t.this.f237047c.iterator();
                while (it6.hasNext()) {
                    ((c) it6.next()).b(true);
                }
                return;
            }
            if ("tencent.av.v2q.StopVideoChat".equals(action)) {
                Iterator it7 = t.this.f237047c.iterator();
                while (it7.hasNext()) {
                    ((c) it7.next()).b(false);
                }
            } else if ("VolumeBtnDown".equals(intent.getAction())) {
                Iterator it8 = t.this.f237047c.iterator();
                while (it8.hasNext()) {
                    ((c) it8.next()).c();
                }
            } else if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                Iterator it9 = t.this.f237047c.iterator();
                while (it9.hasNext()) {
                    ((c) it9.next()).d();
                    QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(boolean z16);

        void b(boolean z16);

        void c();

        void d();

        void e(int i3);
    }

    t(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f237046b = false;
        this.f237047c = new ArrayList<>();
        this.f237048d = new a();
        this.f237049e = new b();
        this.f237045a = context.getApplicationContext();
        b(true);
    }

    public static t c(Context context) {
        if (f237044f == null) {
            synchronized (t.class) {
                if (f237044f == null) {
                    f237044f = new t(context);
                }
            }
        }
        return f237044f;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (this.f237046b == z16) {
            return;
        }
        if (z16) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
            intentFilter.addAction("tencent.av.v2q.StopVideoChat");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction("VolumeBtnDown");
            this.f237045a.registerReceiver(this.f237049e, intentFilter);
            AppNetConnInfo.registerConnectionChangeReceiver(this.f237045a, this.f237048d);
            return;
        }
        this.f237045a.unregisterReceiver(this.f237049e);
        this.f237047c.clear();
        AppNetConnInfo.unregisterNetInfoHandler(this.f237048d);
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ArrayList<c> arrayList = this.f237047c;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }
}
