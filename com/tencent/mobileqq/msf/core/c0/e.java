package com.tencent.mobileqq.msf.core.c0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: m, reason: collision with root package name */
    private static Context f247599m = null;

    /* renamed from: n, reason: collision with root package name */
    public static final String f247600n = "MSF.C.MonitorNetFlowStore";

    /* renamed from: o, reason: collision with root package name */
    static final String f247601o = "SQQzoneSvcDev";

    /* renamed from: p, reason: collision with root package name */
    private static final int f247602p = 100;

    /* renamed from: q, reason: collision with root package name */
    private static final int f247603q = 10485760;

    /* renamed from: r, reason: collision with root package name */
    private static final int f247604r = 300000;

    /* renamed from: s, reason: collision with root package name */
    public static final String f247605s = "MONITOR_NetflowRdmReport";

    /* renamed from: t, reason: collision with root package name */
    public static final String f247606t = "MONITOR_NetflowRdmReportwithStatus";

    /* renamed from: u, reason: collision with root package name */
    public static final String f247607u = "MONITOR_NetflowRdmReport_TIME";

    /* renamed from: v, reason: collision with root package name */
    public static final int f247608v = 1;

    /* renamed from: w, reason: collision with root package name */
    static SimpleDateFormat f247609w = null;

    /* renamed from: x, reason: collision with root package name */
    private static SQLiteDatabase f247610x = null;

    /* renamed from: y, reason: collision with root package name */
    static final String f247611y = "dataflow";

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f247612a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> f247613b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> f247614c;

    /* renamed from: d, reason: collision with root package name */
    private AlarmManager f247615d;

    /* renamed from: e, reason: collision with root package name */
    private String f247616e;

    /* renamed from: f, reason: collision with root package name */
    private PendingIntent f247617f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f247618g;

    /* renamed from: h, reason: collision with root package name */
    private HandlerThread f247619h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f247620i;

    /* renamed from: j, reason: collision with root package name */
    private a f247621j;

    /* renamed from: k, reason: collision with root package name */
    private long f247622k;

    /* renamed from: l, reason: collision with root package name */
    private final int f247623l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> f247624a;

        /* renamed from: b, reason: collision with root package name */
        HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> f247625b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            } else {
                this.f247624a = null;
                this.f247625b = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(e.f247600n, 1, "MonitorWriteDataThread Enter");
            if (QLog.isColorLevel()) {
                QLog.d(e.f247600n, 1, "MonitorWriteDataThread avaialbeMemory=" + (com.tencent.mobileqq.msf.sdk.utils.a.a() / 1024) + "k");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f247624a == null) {
                this.f247624a = new HashMap<>();
            }
            synchronized (e.this.f247613b) {
                this.f247624a.putAll(e.this.f247613b);
                e.this.f247613b.clear();
            }
            if (this.f247625b == null) {
                this.f247625b = new HashMap<>();
            }
            synchronized (e.this.f247614c) {
                this.f247625b.putAll(e.this.f247614c);
                e.this.f247614c.clear();
            }
            e.this.a(this.f247624a, this.f247625b);
            this.f247624a.clear();
            this.f247625b.clear();
            e.this.f247622k = System.currentTimeMillis();
            QLog.d(e.f247600n, 1, "MonitorWriteDataThread End takeTimes=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247609w = new SimpleDateFormat("dd HH:mm:ss");
        }
    }

    public e(MsfCore msfCore, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) context);
            return;
        }
        this.f247613b = new HashMap<>();
        this.f247614c = new HashMap<>();
        this.f247616e = "";
        this.f247618g = true;
        this.f247623l = 4;
        this.f247612a = msfCore;
        f247599m = context;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("monitor_dataflow_write_thread");
        this.f247619h = baseHandlerThread;
        baseHandlerThread.setPriority(4);
        this.f247619h.start();
        this.f247620i = new Handler(this.f247619h.getLooper());
        this.f247622k = System.currentTimeMillis();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) intent);
        }
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        Intent intent = new Intent(this.f247616e);
        intent.setAction(this.f247616e);
        this.f247617f = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent, Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
        this.f247615d = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        QLog.d(f247600n, 1, "register " + this.f247616e.hashCode() + " alarm alive send at " + f247609w.format(Long.valueOf(j3)));
        if (QLog.isColorLevel()) {
            this.f247615d.setRepeating(0, j3, MiniBoxNoticeInfo.MIN_5, this.f247617f);
        } else {
            this.f247615d.setRepeating(0, j3, 600000L, this.f247617f);
        }
    }

    private void a(Context context) {
        this.f247616e = MsfSdkUtils.getProcessName(context) + "_" + getClass().hashCode();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.f247616e);
        BaseApplication.getContext().registerReceiver(this, intentFilter);
        if (QLog.isColorLevel()) {
            b(System.currentTimeMillis() + MiniBoxNoticeInfo.MIN_5);
        } else {
            b(System.currentTimeMillis() + 600000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.tencent.mobileqq.msf.sdk.utils.b bVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        try {
            i3 = bVar.f250727e;
        } catch (Exception e16) {
            QLog.d(f247600n, 1, "MonitorDataFlow cache failed.", e16);
        }
        if (i3 == 0) {
            synchronized (this.f247613b) {
                com.tencent.mobileqq.msf.sdk.utils.b bVar2 = this.f247613b.get(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i));
                if (bVar2 != null) {
                    this.f247613b.put(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i), bVar2.a(bVar.f250728f));
                } else {
                    this.f247613b.put(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i), bVar);
                }
            }
            if (this.f247618g) {
            }
        } else {
            if (i3 == 1) {
                synchronized (this.f247614c) {
                    com.tencent.mobileqq.msf.sdk.utils.b bVar3 = this.f247614c.get(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i));
                    if (bVar3 != null) {
                        this.f247614c.put(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i), bVar3.a(bVar.f250728f));
                    } else {
                        this.f247614c.put(bVar.f250730h + bVar.f250729g + ((int) bVar.f250731i), bVar);
                    }
                }
            }
            if (this.f247618g) {
                if (this.f247613b.size() + this.f247614c.size() >= 100 || System.currentTimeMillis() - this.f247622k >= MiniBoxNoticeInfo.MIN_5) {
                    a();
                    return;
                }
                return;
            }
            return;
        }
        QLog.d(f247600n, 1, "MonitorDataFlow cache failed.", e16);
        if (this.f247618g) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0428 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f8 A[Catch: Exception -> 0x03c4, all -> 0x0437, TryCatch #7 {all -> 0x0437, blocks: (B:26:0x0133, B:30:0x013b, B:32:0x0141, B:35:0x0148, B:38:0x014d, B:40:0x0152, B:43:0x0159, B:47:0x016a, B:118:0x0173, B:120:0x017c, B:122:0x0185, B:124:0x018e, B:127:0x0198, B:130:0x01a5, B:132:0x01ab, B:135:0x01ba, B:50:0x01dc, B:52:0x01e2, B:53:0x020d, B:81:0x021e, B:83:0x022a, B:86:0x0235, B:88:0x0241, B:91:0x024d, B:93:0x026c, B:64:0x035f, B:66:0x036d, B:68:0x037b, B:69:0x0380, B:71:0x0386, B:72:0x03b3, B:74:0x03a3, B:76:0x0367, B:94:0x0296, B:96:0x02b4, B:98:0x02c6, B:99:0x02ef, B:102:0x040d, B:58:0x0313, B:61:0x031f, B:79:0x0344, B:113:0x01f8), top: B:25:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x043a A[Catch: Exception -> 0x0505, TryCatch #9 {Exception -> 0x0505, blocks: (B:9:0x0033, B:11:0x0075, B:12:0x007f, B:165:0x012e, B:104:0x0425, B:106:0x0428, B:161:0x043a, B:162:0x043d, B:191:0x043e, B:192:0x0446, B:194:0x044c, B:197:0x0456, B:200:0x04fd, B:202:0x0466, B:203:0x046e, B:205:0x0474, B:213:0x0482, B:209:0x04bf, B:218:0x0501), top: B:8:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e2 A[Catch: Exception -> 0x03c4, all -> 0x0437, TryCatch #7 {all -> 0x0437, blocks: (B:26:0x0133, B:30:0x013b, B:32:0x0141, B:35:0x0148, B:38:0x014d, B:40:0x0152, B:43:0x0159, B:47:0x016a, B:118:0x0173, B:120:0x017c, B:122:0x0185, B:124:0x018e, B:127:0x0198, B:130:0x01a5, B:132:0x01ab, B:135:0x01ba, B:50:0x01dc, B:52:0x01e2, B:53:0x020d, B:81:0x021e, B:83:0x022a, B:86:0x0235, B:88:0x0241, B:91:0x024d, B:93:0x026c, B:64:0x035f, B:66:0x036d, B:68:0x037b, B:69:0x0380, B:71:0x0386, B:72:0x03b3, B:74:0x03a3, B:76:0x0367, B:94:0x0296, B:96:0x02b4, B:98:0x02c6, B:99:0x02ef, B:102:0x040d, B:58:0x0313, B:61:0x031f, B:79:0x0344, B:113:0x01f8), top: B:25:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x037b A[Catch: Exception -> 0x03c2, all -> 0x0437, TryCatch #7 {all -> 0x0437, blocks: (B:26:0x0133, B:30:0x013b, B:32:0x0141, B:35:0x0148, B:38:0x014d, B:40:0x0152, B:43:0x0159, B:47:0x016a, B:118:0x0173, B:120:0x017c, B:122:0x0185, B:124:0x018e, B:127:0x0198, B:130:0x01a5, B:132:0x01ab, B:135:0x01ba, B:50:0x01dc, B:52:0x01e2, B:53:0x020d, B:81:0x021e, B:83:0x022a, B:86:0x0235, B:88:0x0241, B:91:0x024d, B:93:0x026c, B:64:0x035f, B:66:0x036d, B:68:0x037b, B:69:0x0380, B:71:0x0386, B:72:0x03b3, B:74:0x03a3, B:76:0x0367, B:94:0x0296, B:96:0x02b4, B:98:0x02c6, B:99:0x02ef, B:102:0x040d, B:58:0x0313, B:61:0x031f, B:79:0x0344, B:113:0x01f8), top: B:25:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0386 A[Catch: Exception -> 0x03c2, all -> 0x0437, TryCatch #7 {all -> 0x0437, blocks: (B:26:0x0133, B:30:0x013b, B:32:0x0141, B:35:0x0148, B:38:0x014d, B:40:0x0152, B:43:0x0159, B:47:0x016a, B:118:0x0173, B:120:0x017c, B:122:0x0185, B:124:0x018e, B:127:0x0198, B:130:0x01a5, B:132:0x01ab, B:135:0x01ba, B:50:0x01dc, B:52:0x01e2, B:53:0x020d, B:81:0x021e, B:83:0x022a, B:86:0x0235, B:88:0x0241, B:91:0x024d, B:93:0x026c, B:64:0x035f, B:66:0x036d, B:68:0x037b, B:69:0x0380, B:71:0x0386, B:72:0x03b3, B:74:0x03a3, B:76:0x0367, B:94:0x0296, B:96:0x02b4, B:98:0x02c6, B:99:0x02ef, B:102:0x040d, B:58:0x0313, B:61:0x031f, B:79:0x0344, B:113:0x01f8), top: B:25:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03a3 A[Catch: Exception -> 0x03c2, all -> 0x0437, TryCatch #7 {all -> 0x0437, blocks: (B:26:0x0133, B:30:0x013b, B:32:0x0141, B:35:0x0148, B:38:0x014d, B:40:0x0152, B:43:0x0159, B:47:0x016a, B:118:0x0173, B:120:0x017c, B:122:0x0185, B:124:0x018e, B:127:0x0198, B:130:0x01a5, B:132:0x01ab, B:135:0x01ba, B:50:0x01dc, B:52:0x01e2, B:53:0x020d, B:81:0x021e, B:83:0x022a, B:86:0x0235, B:88:0x0241, B:91:0x024d, B:93:0x026c, B:64:0x035f, B:66:0x036d, B:68:0x037b, B:69:0x0380, B:71:0x0386, B:72:0x03b3, B:74:0x03a3, B:76:0x0367, B:94:0x0296, B:96:0x02b4, B:98:0x02c6, B:99:0x02ef, B:102:0x040d, B:58:0x0313, B:61:0x031f, B:79:0x0344, B:113:0x01f8), top: B:25:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, SparseArray<HashMap<String, Long>>> b(long j3, boolean z16) {
        String str;
        String str2;
        long j16;
        long j17;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        String[] strArr;
        String[] strArr2;
        Cursor query;
        Throwable th5;
        HashMap<String, Long> hashMap;
        String str3 = ":";
        String str4 = f247601o;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        int i16 = 0;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
        try {
            InputStream open = f247599m.getAssets().open("xgwifi.xml");
            Properties properties = new Properties();
            properties.loadFromXML(open);
            Calendar calendar = Calendar.getInstance();
            calendar.set(6, calendar.get(6) - 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            long j18 = 86400000 + timeInMillis;
            if (f247610x == null) {
                f247610x = d.a().getWritableDatabase();
            }
            HashMap<String, SparseArray<HashMap<String, Long>>> hashMap2 = new HashMap<>();
            int i18 = 0;
            while (i18 < 5) {
                if (z16) {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabase2 = f247610x;
                            String[] strArr3 = {"processName", "uin", "buffersize", HttpMsg.MTYPE, QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, "status"};
                            String[] strArr4 = new String[i3];
                            strArr4[i16] = String.valueOf(timeInMillis);
                            strArr4[i17] = String.valueOf(j18);
                            strArr4[2] = String.valueOf(i18);
                            query = sQLiteDatabase2.query(f247611y, strArr3, "curtime >= ? and curtime <= ? and status = ?", strArr4, null, null, null);
                        } catch (Throwable th6) {
                            th5 = th6;
                            cursor = null;
                            if (cursor != null) {
                            }
                            throw th5;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        str = str3;
                        str2 = str4;
                        j16 = timeInMillis;
                        j17 = j18;
                        cursor = null;
                        QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                        if (cursor == null) {
                        }
                        cursor.close();
                        i18++;
                        timeInMillis = j16;
                        j18 = j17;
                        str3 = str;
                        str4 = str2;
                        i3 = 3;
                        i16 = 0;
                        i17 = 1;
                    }
                } else {
                    try {
                        sQLiteDatabase = f247610x;
                        strArr = new String[]{"processName", "uin", "buffersize", HttpMsg.MTYPE, QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, "status"};
                        strArr2 = new String[5];
                        strArr2[i16] = String.valueOf(timeInMillis);
                        strArr2[i17] = String.valueOf(j18);
                    } catch (Exception e17) {
                        e = e17;
                        str = str3;
                        str2 = str4;
                        j16 = timeInMillis;
                        j17 = j18;
                    }
                    try {
                        strArr2[2] = String.valueOf(2);
                        strArr2[i3] = String.valueOf(i3);
                        strArr2[4] = String.valueOf(i18);
                        query = sQLiteDatabase.query(f247611y, strArr, "curtime >= ? and curtime <= ? and networktype <> ? and networktype <> ? and status = ?", strArr2, null, null, null);
                    } catch (Exception e18) {
                        e = e18;
                        str = str3;
                        str2 = str4;
                        j16 = timeInMillis;
                        j17 = j18;
                        cursor = null;
                        QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                        if (cursor == null) {
                        }
                        cursor.close();
                        i18++;
                        timeInMillis = j16;
                        j18 = j17;
                        str3 = str;
                        str4 = str2;
                        i3 = 3;
                        i16 = 0;
                        i17 = 1;
                    }
                }
                cursor = query;
                if (cursor == null) {
                    if (cursor == null) {
                        return null;
                    }
                    cursor.close();
                    return null;
                }
                try {
                    try {
                        cursor.moveToFirst();
                        int i19 = i18 == 0 ? i17 : i18;
                        while (!cursor.isAfterLast()) {
                            String string = cursor.getString(i16);
                            j16 = timeInMillis;
                            try {
                                String string2 = cursor.getString(1);
                                try {
                                    long j19 = cursor.getLong(2);
                                    String string3 = cursor.getString(3);
                                    j17 = j18;
                                    try {
                                        int i26 = cursor.getInt(4);
                                        if (i26 != 3 && i26 != 2) {
                                            i26 = 1;
                                        } else if (i26 == 2 || i26 == 3) {
                                            i26 = 2;
                                        }
                                        if (!string.endsWith(ProcessConstant.MSF)) {
                                            try {
                                                if (!string3.equals("yingyongbao") && !string3.equals("beacon") && !string3.equals("GameCenter") && !string.endsWith("web")) {
                                                    if (string.endsWith("picture")) {
                                                        string3 = "qzone";
                                                    } else if (string.contains(str3)) {
                                                        int indexOf = string.indexOf(str3);
                                                        StringBuilder sb5 = new StringBuilder();
                                                        int i27 = indexOf + 1;
                                                        int i28 = indexOf + 2;
                                                        try {
                                                            sb5.append(string.substring(i27, i28).toUpperCase());
                                                            sb5.append(string.substring(i28));
                                                            string3 = sb5.toString();
                                                            String str5 = !string3.startsWith(str4) ? (String) properties.get(str4 + i26) : (String) properties.get(string3 + i26);
                                                            str = str3;
                                                            if (hashMap2.containsKey(string2)) {
                                                                str2 = str4;
                                                                if (str5 == null) {
                                                                    StringBuilder sb6 = new StringBuilder();
                                                                    sb6.append(i26 == 1 ? "XG" : "WiFi");
                                                                    sb6.append(string3);
                                                                    sb6.append("Flow");
                                                                    string3 = sb6.toString();
                                                                    HashMap<String, Long> hashMap3 = new HashMap<>();
                                                                    hashMap3.put(string3, Long.valueOf(j19));
                                                                    SparseArray<HashMap<String, Long>> sparseArray = new SparseArray<>();
                                                                    sparseArray.put(i19, hashMap3);
                                                                    hashMap2.put(string2, sparseArray);
                                                                } else {
                                                                    HashMap<String, Long> hashMap4 = new HashMap<>();
                                                                    hashMap4.put(str5, Long.valueOf(j19));
                                                                    SparseArray<HashMap<String, Long>> sparseArray2 = new SparseArray<>();
                                                                    sparseArray2.put(i19, hashMap4);
                                                                    hashMap2.put(string2, sparseArray2);
                                                                }
                                                            } else {
                                                                try {
                                                                    if (hashMap2.get(string2).get(i19) == null) {
                                                                        str2 = str4;
                                                                        try {
                                                                            hashMap2.get(string2).put(i19, new HashMap<>());
                                                                        } catch (Exception e19) {
                                                                            e = e19;
                                                                            QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                                                            if (cursor == null) {
                                                                            }
                                                                            cursor.close();
                                                                            i18++;
                                                                            timeInMillis = j16;
                                                                            j18 = j17;
                                                                            str3 = str;
                                                                            str4 = str2;
                                                                            i3 = 3;
                                                                            i16 = 0;
                                                                            i17 = 1;
                                                                        }
                                                                    } else {
                                                                        str2 = str4;
                                                                    }
                                                                    if (str5 == null) {
                                                                        StringBuilder sb7 = new StringBuilder();
                                                                        sb7.append(i26 == 1 ? "XG" : "WiFi");
                                                                        sb7.append(string3);
                                                                        sb7.append("Flow");
                                                                        string3 = sb7.toString();
                                                                        if (hashMap2.get(string2).get(i19).containsKey(string3)) {
                                                                            HashMap<String, Long> hashMap5 = hashMap2.get(string2).get(i19);
                                                                            hashMap5.put(string3, Long.valueOf(hashMap5.get(string3).longValue() + j19));
                                                                            hashMap2.get(string2).put(i19, hashMap5);
                                                                        } else {
                                                                            HashMap<String, Long> hashMap6 = hashMap2.get(string2).get(i19);
                                                                            hashMap6.put(string3, Long.valueOf(j19));
                                                                            hashMap2.get(string2).put(i19, hashMap6);
                                                                        }
                                                                    } else if (hashMap2.get(string2).get(i19).containsKey(str5)) {
                                                                        HashMap<String, Long> hashMap7 = hashMap2.get(string2).get(i19);
                                                                        hashMap7.put(str5, Long.valueOf(hashMap7.get(str5).longValue() + j19));
                                                                        hashMap2.get(string2).put(i19, hashMap7);
                                                                    } else {
                                                                        HashMap<String, Long> hashMap8 = hashMap2.get(string2).get(i19);
                                                                        hashMap8.put(str5, Long.valueOf(j19));
                                                                        hashMap2.get(string2).put(i19, hashMap8);
                                                                    }
                                                                } catch (Exception e26) {
                                                                    e = e26;
                                                                    str2 = str4;
                                                                    QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                                                    if (cursor == null) {
                                                                        i18++;
                                                                        timeInMillis = j16;
                                                                        j18 = j17;
                                                                        str3 = str;
                                                                        str4 = str2;
                                                                        i3 = 3;
                                                                        i16 = 0;
                                                                        i17 = 1;
                                                                    }
                                                                    cursor.close();
                                                                    i18++;
                                                                    timeInMillis = j16;
                                                                    j18 = j17;
                                                                    str3 = str;
                                                                    str4 = str2;
                                                                    i3 = 3;
                                                                    i16 = 0;
                                                                    i17 = 1;
                                                                }
                                                            }
                                                            if ((z16 && str5 != null && str5.startsWith("XG")) || (z16 && string3.startsWith("XG"))) {
                                                                hashMap = hashMap2.get(string2).get(i19);
                                                                if (hashMap == null) {
                                                                    hashMap = new HashMap<>();
                                                                }
                                                                if (hashMap.containsKey("XGFlow")) {
                                                                    hashMap.put("XGFlow", Long.valueOf(hashMap.get("XGFlow").longValue() + j19));
                                                                    hashMap2.get(string2).put(i19, hashMap);
                                                                } else {
                                                                    hashMap.put("XGFlow", Long.valueOf(j19));
                                                                    hashMap2.get(string2).put(i19, hashMap);
                                                                }
                                                            }
                                                            cursor.moveToNext();
                                                            timeInMillis = j16;
                                                            j18 = j17;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i16 = 0;
                                                        } catch (Exception e27) {
                                                            e = e27;
                                                            str = str3;
                                                            str2 = str4;
                                                            QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                                            if (cursor == null) {
                                                            }
                                                            cursor.close();
                                                            i18++;
                                                            timeInMillis = j16;
                                                            j18 = j17;
                                                            str3 = str;
                                                            str4 = str2;
                                                            i3 = 3;
                                                            i16 = 0;
                                                            i17 = 1;
                                                        }
                                                    }
                                                }
                                            } catch (Exception e28) {
                                                e = e28;
                                                str = str3;
                                                str2 = str4;
                                                QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                                if (cursor == null) {
                                                }
                                                cursor.close();
                                                i18++;
                                                timeInMillis = j16;
                                                j18 = j17;
                                                str3 = str;
                                                str4 = str2;
                                                i3 = 3;
                                                i16 = 0;
                                                i17 = 1;
                                            }
                                        }
                                        if (!string3.startsWith(str4)) {
                                        }
                                        str = str3;
                                        if (hashMap2.containsKey(string2)) {
                                        }
                                        if (z16) {
                                            hashMap = hashMap2.get(string2).get(i19);
                                            if (hashMap == null) {
                                            }
                                            if (hashMap.containsKey("XGFlow")) {
                                            }
                                            cursor.moveToNext();
                                            timeInMillis = j16;
                                            j18 = j17;
                                            str3 = str;
                                            str4 = str2;
                                            i16 = 0;
                                        }
                                        hashMap = hashMap2.get(string2).get(i19);
                                        if (hashMap == null) {
                                        }
                                        if (hashMap.containsKey("XGFlow")) {
                                        }
                                        cursor.moveToNext();
                                        timeInMillis = j16;
                                        j18 = j17;
                                        str3 = str;
                                        str4 = str2;
                                        i16 = 0;
                                    } catch (Exception e29) {
                                        e = e29;
                                        str = str3;
                                        str2 = str4;
                                        QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                        if (cursor == null) {
                                        }
                                        cursor.close();
                                        i18++;
                                        timeInMillis = j16;
                                        j18 = j17;
                                        str3 = str;
                                        str4 = str2;
                                        i3 = 3;
                                        i16 = 0;
                                        i17 = 1;
                                    }
                                } catch (Exception e36) {
                                    e = e36;
                                    str = str3;
                                    str2 = str4;
                                    j17 = j18;
                                }
                            } catch (Exception e37) {
                                e = e37;
                                str = str3;
                                str2 = str4;
                                j17 = j18;
                                QLog.d(f247600n, 1, "query socket netflow failed. " + e, e);
                                if (cursor == null) {
                                }
                                cursor.close();
                                i18++;
                                timeInMillis = j16;
                                j18 = j17;
                                str3 = str;
                                str4 = str2;
                                i3 = 3;
                                i16 = 0;
                                i17 = 1;
                            }
                        }
                        str = str3;
                        str2 = str4;
                        j16 = timeInMillis;
                        j17 = j18;
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th5;
                    }
                } catch (Exception e38) {
                    e = e38;
                    str = str3;
                    str2 = str4;
                    j16 = timeInMillis;
                }
                cursor.close();
                i18++;
                timeInMillis = j16;
                j18 = j17;
                str3 = str;
                str4 = str2;
                i3 = 3;
                i16 = 0;
                i17 = 1;
            }
            for (String str6 : hashMap2.keySet()) {
                for (int i29 = 1; i29 < 5; i29++) {
                    HashMap<String, Long> hashMap9 = hashMap2.get(str6).get(i29);
                    if (hashMap9 != null) {
                        for (String str7 : hashMap9.keySet()) {
                            if (z16) {
                                QLog.d(f247600n, 1, "report RDM data with Status for " + MsfSdkUtils.getShortUin(str6) + ", " + str7 + APLogFileUtil.SEPARATOR_LOG + hashMap2.get(str6).get(i29).get(str7) + APLogFileUtil.SEPARATOR_LOG + i29);
                            } else {
                                QLog.d(f247600n, 1, "check XG data with Status for " + MsfSdkUtils.getShortUin(str6) + ", " + str7 + APLogFileUtil.SEPARATOR_LOG + hashMap2.get(str6).get(i29).get(str7) + APLogFileUtil.SEPARATOR_LOG + i29);
                            }
                        }
                    }
                }
            }
            open.close();
            return hashMap2;
        } catch (Exception e39) {
            QLog.d(f247600n, 1, "read net flow statistics failed." + e39, e39);
            return null;
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        try {
            Bundle bundle = toServiceMsg.extraData;
            com.tencent.mobileqq.msf.sdk.utils.b bVar = new com.tencent.mobileqq.msf.sdk.utils.b(bundle.getString("ip"), bundle.getString("refer"), bundle.getInt("port"), bundle.getInt("flag"), bundle.getLong("buffersize"), bundle.getInt(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE));
            bVar.f250723a = bundle.getString("processName");
            bVar.f250731i = bundle.getByte("status");
            bVar.f250733k = bundle.getLong("updatetime");
            if (bundle.getString(HttpMsg.MTYPE).startsWith("LongConn")) {
                bVar.f250731i = BaseApplication.monitor.getSTATUS();
            }
            bVar.f250730h = bundle.getString(HttpMsg.MTYPE);
            a(bVar);
        } catch (Exception e16) {
            QLog.d(f247600n, 1, "ToServiceMsg analysis error.", e16);
        }
    }

    public void a(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247600n, 2, "receive broadcast : " + intent.getAction() + ", start to store socket flow at " + f247609w.format(Long.valueOf(System.currentTimeMillis())));
        }
        a();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f247618g) {
            if (QLog.isColorLevel()) {
                QLog.d(f247600n, 2, Thread.currentThread().getName() + " insertSocketDataFlow writeSize=" + this.f247613b.size() + " readSize=" + this.f247614c.size());
            }
            if (this.f247613b.size() + this.f247614c.size() > 0) {
                if (this.f247621j == null) {
                    this.f247621j = new a();
                }
                this.f247620i.post(this.f247621j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> hashMap, HashMap<String, com.tencent.mobileqq.msf.sdk.utils.b> hashMap2) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        int i3;
        try {
            try {
                if (f247610x == null) {
                    f247610x = d.a().getWritableDatabase();
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i16 = 2;
                if (QLog.isColorLevel()) {
                    QLog.d(f247600n, 2, "write data : " + hashMap.size() + " | read data : " + hashMap2.size() + ", starting to store.");
                }
                f247610x.beginTransaction();
                int i17 = 0;
                for (String str2 : hashMap.keySet()) {
                    com.tencent.mobileqq.msf.sdk.utils.b bVar = hashMap.get(str2);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("mType|");
                        sb5.append(bVar.f250730h);
                        sb5.append("|");
                        sb5.append(bVar.f250725c);
                        sb5.append("|");
                        sb5.append(bVar.f250724b);
                        sb5.append("|");
                        sb5.append(bVar.f250726d);
                        sb5.append("|write|");
                        i3 = i17;
                        sb5.append(bVar.f250728f);
                        sb5.append("|");
                        sb5.append(bVar.f250729g);
                        sb5.append("|");
                        sb5.append((int) bVar.f250731i);
                        sb5.append("|");
                        sb5.append(bVar.f250723a);
                        QLog.d(f247600n, 2, sb5.toString());
                    } else {
                        i3 = i17;
                    }
                    long j3 = bVar.f250733k;
                    if (j3 > 0) {
                        currentTimeMillis = j3;
                    }
                    f247610x.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[]{bVar.f250723a, com.tencent.mobileqq.msf.core.e0.i.i(), bVar.f250724b, bVar.f250725c, Integer.valueOf(bVar.f250726d), Integer.valueOf(bVar.f250727e), Long.valueOf(bVar.f250728f), Integer.valueOf(bVar.f250729g), bVar.f250730h, Long.valueOf(currentTimeMillis), Byte.valueOf(bVar.f250731i)});
                    i17 = (int) (i3 + hashMap.get(str2).f250728f);
                }
                int i18 = i17;
                int i19 = 0;
                for (String str3 : hashMap2.keySet()) {
                    com.tencent.mobileqq.msf.sdk.utils.b bVar2 = hashMap2.get(str3);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("mType|");
                        sb6.append(bVar2.f250730h);
                        sb6.append("|");
                        sb6.append(bVar2.f250725c);
                        sb6.append("|");
                        sb6.append(bVar2.f250724b);
                        sb6.append("|");
                        sb6.append(bVar2.f250726d);
                        sb6.append("|read|");
                        str = str3;
                        sb6.append(bVar2.f250728f);
                        sb6.append("|");
                        sb6.append(bVar2.f250729g);
                        sb6.append("|");
                        sb6.append((int) bVar2.f250731i);
                        sb6.append("|");
                        sb6.append(bVar2.f250723a);
                        QLog.d(f247600n, i16, sb6.toString());
                    } else {
                        str = str3;
                    }
                    long j16 = bVar2.f250733k;
                    if (j16 > 0) {
                        currentTimeMillis = j16;
                    }
                    SQLiteDatabase sQLiteDatabase2 = f247610x;
                    Object[] objArr = new Object[11];
                    objArr[0] = bVar2.f250723a;
                    objArr[1] = com.tencent.mobileqq.msf.core.e0.i.i();
                    objArr[i16] = bVar2.f250724b;
                    objArr[3] = bVar2.f250725c;
                    objArr[4] = Integer.valueOf(bVar2.f250726d);
                    objArr[5] = Integer.valueOf(bVar2.f250727e);
                    objArr[6] = Long.valueOf(bVar2.f250728f);
                    objArr[7] = Integer.valueOf(bVar2.f250729g);
                    objArr[8] = bVar2.f250730h;
                    objArr[9] = Long.valueOf(currentTimeMillis);
                    objArr[10] = Byte.valueOf(bVar2.f250731i);
                    sQLiteDatabase2.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", objArr);
                    i19 = (int) (i19 + hashMap2.get(str).f250728f);
                    i18 = i18;
                    currentTimeMillis = currentTimeMillis;
                    i16 = 2;
                }
                f247610x.setTransactionSuccessful();
                f247610x.endTransaction();
                QLog.d(f247600n, 1, "write data lenth : " + i18 + " | read data lenth : " + i19 + ", has been stored.");
                sQLiteDatabase = f247610x;
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Exception e16) {
                QLog.e(f247600n, 1, "data store failed.", e16);
                sQLiteDatabase = f247610x;
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            sQLiteDatabase.close();
            f247610x = null;
        } catch (Throwable th5) {
            SQLiteDatabase sQLiteDatabase3 = f247610x;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.close();
                f247610x = null;
            }
            throw th5;
        }
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0673: MOVE (r7 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:223:0x0672 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0329 A[Catch: Exception -> 0x0595, all -> 0x0671, TryCatch #1 {all -> 0x0671, blocks: (B:24:0x013d, B:205:0x0144, B:27:0x014f, B:28:0x0156, B:31:0x015f, B:34:0x0173, B:39:0x01c3, B:42:0x01c8, B:43:0x029a, B:45:0x02a3, B:47:0x02ac, B:49:0x02b5, B:51:0x02be, B:54:0x02c8, B:57:0x0309, B:59:0x0311, B:60:0x0340, B:65:0x035e, B:68:0x036c, B:73:0x0381, B:75:0x0387, B:77:0x038d, B:78:0x039f, B:80:0x03ac, B:83:0x04d1, B:85:0x04df, B:87:0x04ed, B:89:0x051c, B:90:0x050c, B:93:0x04d9, B:97:0x03cc, B:104:0x03e7, B:106:0x03ed, B:108:0x03f3, B:109:0x0406, B:111:0x0412, B:112:0x0432, B:115:0x0447, B:118:0x0453, B:123:0x0468, B:125:0x046e, B:127:0x0474, B:128:0x0486, B:134:0x049f, B:136:0x04a5, B:138:0x04ab, B:139:0x04be, B:140:0x0329, B:142:0x02db, B:144:0x02e1, B:158:0x0654, B:171:0x0545, B:172:0x055d, B:175:0x059b, B:176:0x05a3, B:178:0x05a9, B:179:0x05bd, B:181:0x05c3, B:184:0x05d1, B:187:0x0600, B:192:0x0604, B:196:0x0639), top: B:8:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02a3 A[Catch: Exception -> 0x0595, all -> 0x0671, TryCatch #1 {all -> 0x0671, blocks: (B:24:0x013d, B:205:0x0144, B:27:0x014f, B:28:0x0156, B:31:0x015f, B:34:0x0173, B:39:0x01c3, B:42:0x01c8, B:43:0x029a, B:45:0x02a3, B:47:0x02ac, B:49:0x02b5, B:51:0x02be, B:54:0x02c8, B:57:0x0309, B:59:0x0311, B:60:0x0340, B:65:0x035e, B:68:0x036c, B:73:0x0381, B:75:0x0387, B:77:0x038d, B:78:0x039f, B:80:0x03ac, B:83:0x04d1, B:85:0x04df, B:87:0x04ed, B:89:0x051c, B:90:0x050c, B:93:0x04d9, B:97:0x03cc, B:104:0x03e7, B:106:0x03ed, B:108:0x03f3, B:109:0x0406, B:111:0x0412, B:112:0x0432, B:115:0x0447, B:118:0x0453, B:123:0x0468, B:125:0x046e, B:127:0x0474, B:128:0x0486, B:134:0x049f, B:136:0x04a5, B:138:0x04ab, B:139:0x04be, B:140:0x0329, B:142:0x02db, B:144:0x02e1, B:158:0x0654, B:171:0x0545, B:172:0x055d, B:175:0x059b, B:176:0x05a3, B:178:0x05a9, B:179:0x05bd, B:181:0x05c3, B:184:0x05d1, B:187:0x0600, B:192:0x0604, B:196:0x0639), top: B:8:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0311 A[Catch: Exception -> 0x0595, all -> 0x0671, TryCatch #1 {all -> 0x0671, blocks: (B:24:0x013d, B:205:0x0144, B:27:0x014f, B:28:0x0156, B:31:0x015f, B:34:0x0173, B:39:0x01c3, B:42:0x01c8, B:43:0x029a, B:45:0x02a3, B:47:0x02ac, B:49:0x02b5, B:51:0x02be, B:54:0x02c8, B:57:0x0309, B:59:0x0311, B:60:0x0340, B:65:0x035e, B:68:0x036c, B:73:0x0381, B:75:0x0387, B:77:0x038d, B:78:0x039f, B:80:0x03ac, B:83:0x04d1, B:85:0x04df, B:87:0x04ed, B:89:0x051c, B:90:0x050c, B:93:0x04d9, B:97:0x03cc, B:104:0x03e7, B:106:0x03ed, B:108:0x03f3, B:109:0x0406, B:111:0x0412, B:112:0x0432, B:115:0x0447, B:118:0x0453, B:123:0x0468, B:125:0x046e, B:127:0x0474, B:128:0x0486, B:134:0x049f, B:136:0x04a5, B:138:0x04ab, B:139:0x04be, B:140:0x0329, B:142:0x02db, B:144:0x02e1, B:158:0x0654, B:171:0x0545, B:172:0x055d, B:175:0x059b, B:176:0x05a3, B:178:0x05a9, B:179:0x05bd, B:181:0x05c3, B:184:0x05d1, B:187:0x0600, B:192:0x0604, B:196:0x0639), top: B:8:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04cf A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, HashMap<String, Long>> a(long j3, boolean z16) {
        Throwable th5;
        Cursor cursor;
        Cursor cursor2;
        String str;
        Exception exc;
        Cursor cursor3;
        PrintWriter a16;
        String str2;
        int i3;
        String str3;
        long j16;
        long j17;
        long j18;
        String str4;
        String str5;
        String str6;
        String str7;
        Properties properties;
        String str8;
        String str9;
        Properties properties2;
        String str10;
        e eVar = this;
        String str11 = ":";
        String str12 = f247601o;
        String str13 = f247600n;
        String str14 = "XGFlow";
        String str15 = "|";
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, eVar, Long.valueOf(j3), Boolean.valueOf(z16));
        }
        try {
            try {
                try {
                    InputStream open = f247599m.getAssets().open("xgwifi.xml");
                    Properties properties3 = new Properties();
                    properties3.loadFromXML(open);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(6, calendar.get(6) - 1);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    long j19 = timeInMillis + 86400000;
                    if (f247610x == null) {
                        try {
                            f247610x = d.a().getWritableDatabase();
                        } catch (Exception e16) {
                            exc = e16;
                            str = f247600n;
                            cursor3 = null;
                            QLog.d(str, 1, "read net flow statistics failed." + exc, exc);
                            if (cursor3 != null) {
                            }
                        }
                    }
                    if (z16) {
                        cursor3 = f247610x.query(f247611y, new String[]{"processName", "uin", "ip", "buffersize", HttpMsg.MTYPE, QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, "status", "flag", "refer", "curtime"}, "curtime >= ? and curtime <= ?", new String[]{String.valueOf(timeInMillis), String.valueOf(j19)}, null, null, null);
                    } else {
                        cursor3 = f247610x.query(f247611y, new String[]{"processName", "uin", "ip", "buffersize", HttpMsg.MTYPE, QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, "status", "flag", "refer", "curtime"}, "curtime >= ? and curtime <= ? and networktype <> ? and networktype <> ?", new String[]{String.valueOf(timeInMillis), String.valueOf(j19), String.valueOf(2), String.valueOf(3)}, null, null, null);
                    }
                    if (cursor3 == null) {
                        if (cursor3 == null) {
                            return null;
                        }
                        cursor3.close();
                        return null;
                    }
                    try {
                        HashMap<String, HashMap<String, Long>> hashMap = new HashMap<>();
                        if (z16) {
                            try {
                                a16 = eVar.a(calendar);
                            } catch (Exception e17) {
                                exc = e17;
                                str = str13;
                                QLog.d(str, 1, "read net flow statistics failed." + exc, exc);
                                if (cursor3 != null) {
                                    return null;
                                }
                                cursor3.close();
                                return null;
                            }
                        } else {
                            a16 = null;
                        }
                        cursor3.moveToFirst();
                        long j26 = 0;
                        while (!cursor3.isAfterLast()) {
                            String string = cursor3.getString(i16);
                            String string2 = cursor3.getString(i17);
                            InputStream inputStream = open;
                            String string3 = cursor3.getString(2);
                            str2 = str13;
                            String str16 = str14;
                            try {
                                long j27 = cursor3.getLong(3);
                                HashMap<String, HashMap<String, Long>> hashMap2 = hashMap;
                                String string4 = cursor3.getString(4);
                                int i18 = cursor3.getInt(5);
                                String str17 = str12;
                                Properties properties4 = properties3;
                                int i19 = cursor3.getInt(6);
                                int i26 = cursor3.getInt(7);
                                String str18 = str11;
                                String string5 = cursor3.getString(8);
                                long j28 = cursor3.getLong(9);
                                if (i18 != 3) {
                                    i3 = 2;
                                    if (i18 != 2) {
                                        str3 = string4;
                                        j16 = j26;
                                        i18 = 1;
                                        j17 = j16 + j27;
                                        if (z16 || a16 == null) {
                                            j18 = j17;
                                            str4 = str3;
                                            str5 = string3;
                                        } else {
                                            j18 = j17;
                                            a16.print("info|");
                                            a16.print(eVar.a(string) + str15);
                                            a16.print(string2 + str15);
                                            a16.print(i19 + str15);
                                            StringBuilder sb5 = new StringBuilder();
                                            str4 = str3;
                                            sb5.append(str4);
                                            sb5.append(str15);
                                            a16.print(sb5.toString());
                                            a16.print(j27 + str15);
                                            a16.print(i26 + str15);
                                            a16.print(j28 + str15);
                                            a16.print(i18 + str15);
                                            StringBuilder sb6 = new StringBuilder();
                                            str5 = string3;
                                            sb6.append(str5);
                                            sb6.append(str15);
                                            a16.print(sb6.toString());
                                            a16.print(string5 + str15);
                                            a16.print("\r\n");
                                        }
                                        if (!string.endsWith(ProcessConstant.MSF) && !str4.equals("yingyongbao") && !str4.equals("beacon") && !str4.equals("GameCenter") && !string.endsWith("web")) {
                                            if (string.endsWith("picture")) {
                                                str6 = str18;
                                                if (string.contains(str6)) {
                                                    int indexOf = string.indexOf(str6);
                                                    StringBuilder sb7 = new StringBuilder();
                                                    int i27 = indexOf + 1;
                                                    int i28 = indexOf + 2;
                                                    sb7.append(string.substring(i27, i28).toUpperCase());
                                                    sb7.append(string.substring(i28));
                                                    str7 = sb7.toString();
                                                }
                                                str7 = str4;
                                            } else {
                                                str7 = "qzone";
                                                str6 = str18;
                                            }
                                            if (str7.startsWith(str17)) {
                                                properties = properties4;
                                                str8 = (String) properties.get(str17 + i18);
                                            } else {
                                                properties = properties4;
                                                str8 = (String) properties.get(str7 + i18);
                                            }
                                            String str19 = str6;
                                            String str20 = str15;
                                            if (!hashMap2.containsKey(string2)) {
                                                str9 = str17;
                                                properties2 = properties;
                                                if (str8 == null) {
                                                    StringBuilder sb8 = new StringBuilder();
                                                    sb8.append(i18 == 1 ? "XG" : "WiFi");
                                                    sb8.append(str7);
                                                    sb8.append("Flow");
                                                    String sb9 = sb8.toString();
                                                    if (!z16 && j27 > 5120 && str5 != null && !TextUtils.isEmpty(str5) && com.tencent.mobileqq.msf.core.x.b.N()) {
                                                        sb9 = sb9 + "#" + str5;
                                                    }
                                                    str7 = sb9;
                                                    HashMap<String, Long> hashMap3 = new HashMap<>();
                                                    hashMap3.put(str7, Long.valueOf(j27));
                                                    hashMap2.put(string2, hashMap3);
                                                } else {
                                                    if (!z16 && j27 > 5120 && str5 != null && !TextUtils.isEmpty(str5) && com.tencent.mobileqq.msf.core.x.b.N()) {
                                                        str8 = str8 + "#" + str5;
                                                    }
                                                    HashMap<String, Long> hashMap4 = new HashMap<>();
                                                    hashMap4.put(str8, Long.valueOf(j27));
                                                    hashMap2.put(string2, hashMap4);
                                                }
                                            } else if (str8 == null) {
                                                str9 = str17;
                                                StringBuilder sb10 = new StringBuilder();
                                                properties2 = properties;
                                                sb10.append(i18 == 1 ? "XG" : "WiFi");
                                                sb10.append(str7);
                                                sb10.append("Flow");
                                                String sb11 = sb10.toString();
                                                if (!z16 && j27 > 5120 && str5 != null && !TextUtils.isEmpty(str5) && com.tencent.mobileqq.msf.core.x.b.N()) {
                                                    sb11 = sb11 + "#" + str5;
                                                }
                                                str7 = sb11;
                                                if (hashMap2.get(string2).containsKey(str7)) {
                                                    hashMap2.get(string2).put(str7, Long.valueOf(hashMap2.get(string2).get(str7).longValue() + j27));
                                                } else {
                                                    hashMap2.get(string2).put(str7, Long.valueOf(j27));
                                                }
                                            } else {
                                                str9 = str17;
                                                properties2 = properties;
                                                if (!z16 && j27 > 5120 && str5 != null && !TextUtils.isEmpty(str5) && com.tencent.mobileqq.msf.core.x.b.N()) {
                                                    str8 = str8 + "#" + str5;
                                                }
                                                if (hashMap2.get(string2).containsKey(str8)) {
                                                    hashMap2.get(string2).put(str8, Long.valueOf(hashMap2.get(string2).get(str8).longValue() + j27));
                                                } else {
                                                    hashMap2.get(string2).put(str8, Long.valueOf(j27));
                                                }
                                            }
                                            if ((z16 || str8 == null || !str8.startsWith("XG")) && !(z16 && str7.startsWith("XG"))) {
                                                str10 = str16;
                                            } else {
                                                str10 = str16;
                                                if (hashMap2.get(string2).containsKey(str10)) {
                                                    hashMap2.get(string2).put(str10, Long.valueOf(hashMap2.get(string2).get(str10).longValue() + j27));
                                                } else {
                                                    hashMap2.get(string2).put(str10, Long.valueOf(j27));
                                                }
                                            }
                                            cursor3.moveToNext();
                                            eVar = this;
                                            str14 = str10;
                                            hashMap = hashMap2;
                                            properties3 = properties2;
                                            open = inputStream;
                                            str13 = str2;
                                            str15 = str20;
                                            str12 = str9;
                                            str11 = str19;
                                            j26 = j18;
                                            i16 = 0;
                                            i17 = 1;
                                        }
                                        str6 = str18;
                                        str7 = str4;
                                        if (str7.startsWith(str17)) {
                                        }
                                        String str192 = str6;
                                        String str202 = str15;
                                        if (!hashMap2.containsKey(string2)) {
                                        }
                                        if (z16) {
                                        }
                                        str10 = str16;
                                        cursor3.moveToNext();
                                        eVar = this;
                                        str14 = str10;
                                        hashMap = hashMap2;
                                        properties3 = properties2;
                                        open = inputStream;
                                        str13 = str2;
                                        str15 = str202;
                                        str12 = str9;
                                        str11 = str192;
                                        j26 = j18;
                                        i16 = 0;
                                        i17 = 1;
                                    }
                                } else {
                                    i3 = 2;
                                }
                                if (i18 != i3 && i18 != 3) {
                                    str3 = string4;
                                    j16 = j26;
                                    j17 = j16 + j27;
                                    if (z16) {
                                    }
                                    j18 = j17;
                                    str4 = str3;
                                    str5 = string3;
                                    if (!string.endsWith(ProcessConstant.MSF)) {
                                        if (string.endsWith("picture")) {
                                        }
                                        if (str7.startsWith(str17)) {
                                        }
                                        String str1922 = str6;
                                        String str2022 = str15;
                                        if (!hashMap2.containsKey(string2)) {
                                        }
                                        if (z16) {
                                        }
                                        str10 = str16;
                                        cursor3.moveToNext();
                                        eVar = this;
                                        str14 = str10;
                                        hashMap = hashMap2;
                                        properties3 = properties2;
                                        open = inputStream;
                                        str13 = str2;
                                        str15 = str2022;
                                        str12 = str9;
                                        str11 = str1922;
                                        j26 = j18;
                                        i16 = 0;
                                        i17 = 1;
                                    }
                                    str6 = str18;
                                    str7 = str4;
                                    if (str7.startsWith(str17)) {
                                    }
                                    String str19222 = str6;
                                    String str20222 = str15;
                                    if (!hashMap2.containsKey(string2)) {
                                    }
                                    if (z16) {
                                    }
                                    str10 = str16;
                                    cursor3.moveToNext();
                                    eVar = this;
                                    str14 = str10;
                                    hashMap = hashMap2;
                                    properties3 = properties2;
                                    open = inputStream;
                                    str13 = str2;
                                    str15 = str20222;
                                    str12 = str9;
                                    str11 = str19222;
                                    j26 = j18;
                                    i16 = 0;
                                    i17 = 1;
                                }
                                str3 = string4;
                                j16 = j26;
                                i18 = 2;
                                j17 = j16 + j27;
                                if (z16) {
                                }
                                j18 = j17;
                                str4 = str3;
                                str5 = string3;
                                if (!string.endsWith(ProcessConstant.MSF)) {
                                }
                                str6 = str18;
                                str7 = str4;
                                if (str7.startsWith(str17)) {
                                }
                                String str192222 = str6;
                                String str202222 = str15;
                                if (!hashMap2.containsKey(string2)) {
                                }
                                if (z16) {
                                }
                                str10 = str16;
                                cursor3.moveToNext();
                                eVar = this;
                                str14 = str10;
                                hashMap = hashMap2;
                                properties3 = properties2;
                                open = inputStream;
                                str13 = str2;
                                str15 = str202222;
                                str12 = str9;
                                str11 = str192222;
                                j26 = j18;
                                i16 = 0;
                                i17 = 1;
                            } catch (Exception e18) {
                                exc = e18;
                                str = str2;
                                QLog.d(str, 1, "read net flow statistics failed." + exc, exc);
                                if (cursor3 != null) {
                                }
                            }
                        }
                        str2 = str13;
                        HashMap<String, HashMap<String, Long>> hashMap5 = hashMap;
                        InputStream inputStream2 = open;
                        long j29 = j26;
                        if (a16 != null) {
                            if (j29 > 0) {
                                a16.print("end|totalSize|" + j29 + "\r\n");
                            }
                            a16.print("sysrecv_" + TrafficStats.getUidRxBytes(Process.myUid()) + "|syssend_" + TrafficStats.getUidTxBytes(Process.myUid()) + "\r\n");
                            a16.flush();
                            a16.close();
                        }
                        try {
                            for (String str21 : hashMap5.keySet()) {
                                for (String str22 : hashMap5.get(str21).keySet()) {
                                    if (z16) {
                                        str = str2;
                                        try {
                                            QLog.d(str, 1, "report RDM data for " + MsfSdkUtils.getShortUin(str21) + ", " + str22 + APLogFileUtil.SEPARATOR_LOG + hashMap5.get(str21).get(str22));
                                        } catch (Exception e19) {
                                            e = e19;
                                            exc = e;
                                            QLog.d(str, 1, "read net flow statistics failed." + exc, exc);
                                            if (cursor3 != null) {
                                            }
                                        }
                                    } else {
                                        str = str2;
                                        QLog.d(str, 1, "check XG data for " + MsfSdkUtils.getShortUin(str21) + ", " + str22 + APLogFileUtil.SEPARATOR_LOG + hashMap5.get(str21).get(str22));
                                    }
                                    str2 = str;
                                }
                            }
                            str = str2;
                            inputStream2.close();
                            cursor3.close();
                            return hashMap5;
                        } catch (Exception e26) {
                            e = e26;
                            str = str2;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        str = str13;
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    cursor = null;
                    if (cursor == null) {
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                cursor = cursor2;
                if (cursor == null) {
                    cursor.close();
                    throw th5;
                }
                throw th5;
            }
        } catch (Exception e28) {
            str = f247600n;
            exc = e28;
        }
    }

    public static void a(long j3) {
        try {
            if (f247610x == null) {
                f247610x = d.a().getWritableDatabase();
            }
            int delete = f247610x.delete(f247611y, "curtime < ?", new String[]{String.valueOf(j3)});
            if (QLog.isDevelopLevel()) {
                QLog.d(f247600n, 4, "delete netflow " + delete + " record.");
            }
        } catch (Exception e16) {
            QLog.d(f247600n, 1, "delete expire data failed. " + e16, e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QLog.LogFile a(long j3, long j16) {
        Cursor cursor;
        QLog.d(f247600n, 1, "report log netflow through laorizhi start.");
        Cursor cursor2 = null;
        try {
            if (f247610x == null) {
                f247610x = d.a().getWritableDatabase();
            }
            cursor = f247610x.query(f247611y, new String[]{"processName", "uin", "buffersize", "flag", HttpMsg.MTYPE, QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, "refer", "curtime"}, "curtime >= ? and curtime <= ?", new String[]{String.valueOf(j3), String.valueOf(j16)}, null, null, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                try {
                    File file = new File(QLog.getLogPath());
                    boolean exists = file.exists();
                    if (!exists) {
                        exists = file.mkdirs();
                    }
                    if (!exists) {
                        cursor.close();
                        return null;
                    }
                    QLog.LogFile logFile = new QLog.LogFile(file, "com.tencent.mobileqq_NETFLOW.log");
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile)));
                    cursor.moveToFirst();
                    long j17 = 0;
                    while (!cursor.isAfterLast()) {
                        bufferedWriter.write(cursor.getString(0) + "|" + MsfSdkUtils.getShortUin(cursor.getString(1)) + "|" + cursor.getLong(2) + "|" + cursor.getInt(3) + "|" + cursor.getString(4) + "|" + cursor.getInt(5) + "|" + cursor.getString(6) + "|" + f247609w.format(Long.valueOf(cursor.getLong(7))) + "\n");
                        j17 += cursor.getLong(2);
                        cursor.moveToNext();
                    }
                    bufferedWriter.write("end|total_" + j17 + "\r\n");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    cursor.close();
                    return logFile;
                } catch (Throwable th5) {
                    th = th5;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Exception e16) {
                e = e16;
                QLog.d(f247600n, 1, "get netflow through laorizhi failed. " + e, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e17) {
            e = e17;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PrintWriter a(Calendar calendar) {
        PrintWriter printWriter;
        String str;
        String str2;
        String str3 = null;
        try {
            String str4 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/netflow/";
            File file = new File(str4);
            if (!file.exists()) {
                file.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd");
            String str5 = str4 + (com.tencent.mobileqq.msf.core.e0.i.i().length() > 4 ? com.tencent.mobileqq.msf.core.e0.i.i() : MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN) + "_" + simpleDateFormat.format(calendar.getTime()) + ".log";
            File file2 = new File(str5);
            if (file2.exists()) {
                file2.delete();
            }
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(str5, true)));
        } catch (Exception e16) {
            e = e16;
        }
        try {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
                str = "gray";
            } else if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                str = "pub";
            } else {
                str = BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion() ? TVKNetVideoInfo.AUDIO_TRACK_DOLBY : "dbg";
            }
            try {
                PackageManager packageManager = BaseApplication.getContext().getPackageManager();
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, BaseApplication.getContext().getPackageName(), 128);
                str2 = packageInfo.versionName + "." + packageInfo.versionCode;
                try {
                    str3 = packageManager.getApplicationInfo(BaseApplication.getContext().getPackageName(), 128).metaData.get("com.tencent.rdm.uuid").toString();
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d(f247600n, 2, "initNetflowHead addHead fail!", e);
                    }
                    printWriter.print("header|");
                    printWriter.print(str2 + "|");
                    printWriter.print(BaseConstants.revision + "|");
                    printWriter.print(str + "|");
                    printWriter.print(str3 + "|");
                    printWriter.print(Build.MANUFACTURER + "|");
                    printWriter.print(DeviceInfoMonitor.getModel() + "|");
                    printWriter.print(Build.VERSION.SDK_INT + "|");
                    printWriter.print(calendar.getTimeInMillis() + "|");
                    printWriter.print("1.0|\r\n");
                    printWriter.flush();
                    return printWriter;
                }
            } catch (Exception e18) {
                e = e18;
                str2 = null;
            }
            printWriter.print("header|");
            printWriter.print(str2 + "|");
            printWriter.print(BaseConstants.revision + "|");
            printWriter.print(str + "|");
            printWriter.print(str3 + "|");
            printWriter.print(Build.MANUFACTURER + "|");
            printWriter.print(DeviceInfoMonitor.getModel() + "|");
            printWriter.print(Build.VERSION.SDK_INT + "|");
            printWriter.print(calendar.getTimeInMillis() + "|");
            printWriter.print("1.0|\r\n");
            printWriter.flush();
            return printWriter;
        } catch (Exception e19) {
            e = e19;
            str3 = printWriter;
            if (QLog.isColorLevel()) {
                QLog.d(f247600n, 2, "save netflow exception!", e);
            }
            return str3;
        }
    }

    private String a(String str) {
        return str != null ? MsfSdkUtils.isMainProcess(str) ? "1" : str.endsWith("qzone") ? "2" : str.endsWith("web") ? "3" : str.endsWith(ProcessConstant.MSF) ? "4" : str.endsWith(ProcessConstant.NEARBY) ? "5" : str.endsWith(ProcessConstant.LOLA) ? "6" : str.endsWith("tool") ? "7" : str.endsWith(ProcessConstant.QZONELIVE) ? "8" : str.endsWith("peak") ? "9" : str.endsWith(ProcessConstant.READINJOY) ? "10" : str.endsWith("TMAssistantDownloadSDKService") ? "11" : str : "0";
    }
}
