package com.tencent.tmdownloader.internal.downloadclient;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.g;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadService;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MobileQQCloseServiceReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected static MobileQQCloseServiceReceiver f380663c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f380664a;

    /* renamed from: b, reason: collision with root package name */
    private long f380665b;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f380666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f380667b;

        a(Context context, Intent intent) {
            this.f380666a = context;
            this.f380667b = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MobileQQCloseServiceReceiver.this, context, intent);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f380666a != null && (intent = this.f380667b) != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (!action.equals("com.tencent.process.exit") && !action.equals("com.tencent.process.tmdownloader.exit")) {
                    if (!action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED) && !action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_LOGOUT)) {
                        if (!action.equals(NewIntent.ACTION_EXIT + this.f380666a.getPackageName())) {
                            return;
                        }
                    }
                    MobileQQCloseServiceReceiver.this.a(this.f380666a);
                    return;
                }
                if (this.f380667b.getExtras() == null) {
                    return;
                }
                ArrayList<String> stringArrayList = this.f380667b.getExtras().getStringArrayList("procNameList");
                String string = this.f380667b.getExtras().getString("verify");
                boolean z17 = true;
                if (string != null && string.length() != 0 && (string.equals(MobileQQCloseServiceReceiver.this.a(stringArrayList, action, false)) || string.equals(MobileQQCloseServiceReceiver.this.a(stringArrayList, action, true)))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (stringArrayList != null && stringArrayList.size() != 0) {
                    String b16 = MobileQQCloseServiceReceiver.this.b(this.f380666a);
                    boolean z18 = false;
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        if (b16.equals(stringArrayList.get(i3))) {
                            z18 = true;
                        }
                    }
                    z17 = z18;
                }
                if (z16 && z17) {
                    MobileQQCloseServiceReceiver.this.a(this.f380666a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f380669a;

        b(MobileQQCloseServiceReceiver mobileQQCloseServiceReceiver, Context context) {
            this.f380669a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQCloseServiceReceiver, (Object) context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                this.f380669a.stopService(new Intent(this.f380669a, (Class<?>) TMAssistantDownloadService.class));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_RENDER_TIMEOUT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    MobileQQCloseServiceReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380664a = false;
            this.f380665b = 0L;
        }
    }

    public String b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.tencent.tmdownloader.TMAssistantDownloadService"), 0);
            if (serviceInfo != null) {
                return serviceInfo.processName;
            }
            return "com.tencent.tmassistantsdk.Service";
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public int c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).intValue();
        }
        String b16 = b(context);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < runningAppProcesses.size(); i16++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i16);
            int i17 = runningAppProcessInfo.pid;
            if (b16.equals(runningAppProcessInfo.processName)) {
                e.a().postDelayed(new b(this, context.getApplicationContext()), 3000L);
                i3++;
            }
        }
        return i3;
    }

    public void d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.process.exit");
            intentFilter.addAction("com.tencent.process.tmdownloader.exit");
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction("mqq.intent.action.EXIT_" + context.getApplicationContext().getPackageName());
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            context.registerReceiver(this, intentFilter);
            this.f380664a = true;
        }
    }

    public void e(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else if (context != null && f380663c != null && this.f380664a) {
            try {
                context.unregisterReceiver(this);
            } catch (Throwable unused) {
            }
            this.f380664a = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
        } else {
            e.a().post(new a(context, intent));
        }
    }

    public static synchronized MobileQQCloseServiceReceiver a() {
        MobileQQCloseServiceReceiver mobileQQCloseServiceReceiver;
        synchronized (MobileQQCloseServiceReceiver.class) {
            if (f380663c == null) {
                f380663c = new MobileQQCloseServiceReceiver();
            }
            mobileQQCloseServiceReceiver = f380663c;
        }
        return mobileQQCloseServiceReceiver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Context context) {
        if (System.currentTimeMillis() - this.f380665b < 1000) {
            return;
        }
        this.f380665b = System.currentTimeMillis();
        if (!l.d()) {
            try {
                if (TMAssistantDownloadManager.getInstance(context).getDownloadSDKSettingClient().isAllDownloadFinished()) {
                    TMAssistantDownloadManager.closeAllService(context);
                }
            } catch (Exception unused) {
            }
        } else {
            try {
                boolean booleanValue = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
                boolean z16 = HalleyAgent.getDownloader().getRunningTasks() != null && HalleyAgent.getDownloader().getRunningTasks().size() > 0;
                if (booleanValue && !z16) {
                    c(context);
                }
            } catch (Exception e16) {
                Log.e("MQQCloseServiceReceiver", e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<String> arrayList, String str, boolean z16) {
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        sb5.append(arrayList == null ? "null" : arrayList.toString());
        try {
            String b16 = g.b(sb5.toString());
            try {
                return g.b(b16 + sb5.toString());
            } catch (Throwable unused) {
                return b16;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }
}
