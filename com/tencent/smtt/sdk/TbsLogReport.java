package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsLogReport {

    /* renamed from: a, reason: collision with root package name */
    private static TbsLogReport f369122a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f369123b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<EventType, Boolean> f369124c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f369125d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f369126e = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_CDN_DOWNLOAD_STAT(3),
        TYPE_COOKIE_DB_SWITCH(4),
        TYPE_PV_UPLOAD_STAT(5),
        TYPE_CORE_LOAD_PERFORMANCE(6),
        TYPE_CORE_PROTECT_RESET(7);


        /* renamed from: a, reason: collision with root package name */
        int f369130a;

        EventType(int i3) {
            this.f369130a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TbsLogInfo implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        int f369131a;

        /* renamed from: b, reason: collision with root package name */
        private long f369132b;

        /* renamed from: c, reason: collision with root package name */
        private String f369133c;

        /* renamed from: d, reason: collision with root package name */
        private String f369134d;

        /* renamed from: e, reason: collision with root package name */
        private int f369135e;

        /* renamed from: f, reason: collision with root package name */
        private int f369136f;

        /* renamed from: g, reason: collision with root package name */
        private int f369137g;

        /* renamed from: h, reason: collision with root package name */
        private int f369138h;

        /* renamed from: i, reason: collision with root package name */
        private String f369139i;

        /* renamed from: j, reason: collision with root package name */
        private int f369140j;

        /* renamed from: k, reason: collision with root package name */
        private int f369141k;

        /* renamed from: l, reason: collision with root package name */
        private long f369142l;

        /* renamed from: m, reason: collision with root package name */
        private long f369143m;

        /* renamed from: n, reason: collision with root package name */
        private int f369144n;

        /* renamed from: o, reason: collision with root package name */
        private String f369145o;

        /* renamed from: p, reason: collision with root package name */
        private String f369146p;

        /* renamed from: q, reason: collision with root package name */
        private long f369147q;

        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.f369141k;
        }

        public void resetArgs() {
            this.f369132b = 0L;
            this.f369133c = null;
            this.f369134d = null;
            this.f369135e = 0;
            this.f369136f = 0;
            this.f369137g = 0;
            this.f369138h = 2;
            this.f369139i = "unknown";
            this.f369140j = 0;
            this.f369141k = 2;
            this.f369142l = 0L;
            this.f369143m = 0L;
            this.f369144n = 1;
            this.f369131a = 0;
            this.f369145o = null;
            this.f369146p = null;
            this.f369147q = 0L;
        }

        public void setApn(String str) {
            this.f369139i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.f369145o = str;
        }

        public void setDownConsumeTime(long j3) {
            this.f369143m += j3;
        }

        public void setDownFinalFlag(int i3) {
            this.f369141k = i3;
        }

        public void setDownloadCancel(int i3) {
            this.f369137g = i3;
        }

        public void setDownloadSize(long j3) {
            this.f369147q += j3;
        }

        public void setDownloadUrl(String str) {
            if (this.f369133c == null) {
                this.f369133c = str;
                return;
            }
            this.f369133c += ";" + str;
        }

        public void setErrorCode(int i3) {
            if (i3 != 100 && i3 != 110 && i3 != 120 && i3 != 111 && i3 < 400) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i3, true);
            }
            if (i3 == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f369131a = i3;
        }

        public void setEventTime(long j3) {
            this.f369132b = j3;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f369146p = str;
        }

        public void setHttpCode(int i3) {
            this.f369135e = i3;
        }

        public void setNetworkChange(int i3) {
            this.f369144n = i3;
        }

        public void setNetworkType(int i3) {
            this.f369140j = i3;
        }

        public void setPatchUpdateFlag(int i3) {
            this.f369136f = i3;
        }

        public void setPkgSize(long j3) {
            this.f369142l = j3;
        }

        public void setResolveIp(String str) {
            this.f369134d = str;
        }

        public void setUnpkgFlag(int i3) {
            this.f369138h = i3;
        }

        public String toString() {
            return "TbsLogInfo{mEventTime=" + this.f369132b + ", mResolveIp='" + this.f369134d + "', mHttpCode=" + this.f369135e + ", mDownloadCancel=" + this.f369137g + ", mNetworkType=" + this.f369140j + ", mDownConsumeTime=" + this.f369143m + ", mErrorCode=" + this.f369131a + ", mCheckErrorDetail='" + this.f369145o + "', mFailDetail='" + this.f369146p + "'}";
        }

        TbsLogInfo() {
            resetArgs();
        }

        public void setFailDetail(Throwable th5) {
            if (th5 == null) {
                this.f369146p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th5);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.f369146p = stackTraceString;
        }
    }

    TbsLogReport(Context context) {
        this.f369123b = null;
        this.f369125d = context.getApplicationContext();
        this.f369124c = TbsPVConfig.getInstance(context).getLogReportSwitchMap();
        this.f369123b = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3 = message.what;
                if (i3 == 600) {
                    Object obj = message.obj;
                    if (obj instanceof TbsLogInfo) {
                        try {
                            int i16 = message.arg1;
                            TbsLogReport.this.a(i16, (TbsLogInfo) obj);
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                if (i3 == 601) {
                    TbsLogReport.this.b();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SharedPreferences.Editor edit = d().edit();
        edit.remove("tbs_tbslogreport_upload");
        edit.commit();
    }

    private SharedPreferences d() {
        return this.f369125d.getSharedPreferences("tbs_event_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (f369122a == null) {
            synchronized (TbsLogReport.class) {
                if (f369122a == null) {
                    f369122a = new TbsLogReport(context);
                }
            }
        }
        return f369122a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = d().edit();
            edit.clear();
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public void dailyReport() {
        this.f369123b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        TbsLog.i("TbsLogReport", "[TbsLogReport.eventRepost] " + eventType + MsgSummary.STR_COLON + tbsLogInfo);
        Boolean bool = this.f369124c.get(eventType);
        if (bool != null && bool.booleanValue()) {
            TbsLog.i("TbsLogReport", "[TbsLogReport.eventRepost] needReport!");
            try {
                TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
                Message obtainMessage = this.f369123b.obtainMessage();
                obtainMessage.what = 600;
                obtainMessage.arg1 = eventType.f369130a;
                obtainMessage.obj = tbsLogInfo2;
                this.f369123b.sendMessage(obtainMessage);
            } catch (Throwable th5) {
                TbsLog.w("TbsLogReport", "[TbsLogReport.eventReport] error, message=" + th5.getMessage());
            }
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.f369126e;
    }

    public void setInstallErrorCode(int i3, String str) {
        setInstallErrorCode(i3, str, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i3, Throwable th5) {
        String str;
        if (th5 != null) {
            str = "msg: " + th5.getMessage() + "; err: " + th5 + "; cause: " + Log.getStackTraceString(th5.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        } else {
            str = "NULL";
        }
        a(i3, str);
    }

    public void setShouldUploadEventReport(boolean z16) {
        this.f369126e = z16;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Map<String, Object> map = QbSdk.f369007q;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f369007q.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("TbsLogReport", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray a16 = a();
        if (a16 != null && a16.length() != 0) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + a16);
            try {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + com.tencent.smtt.utils.g.a(com.tencent.smtt.utils.p.a(this.f369125d).c(), a16.toString().getBytes("utf-8"), new g.a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i3) {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i3);
                        if (i3 < 300) {
                            TbsLogReport.this.c();
                        }
                    }
                }, true));
                return;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
    }

    public void setInstallErrorCode(int i3, String str, EventType eventType) {
        if (i3 != 200 && i3 != 220 && i3 != 221) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i3, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i3, tbsLogInfo, eventType);
    }

    private void a(int i3, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i3);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.f369006p.onInstallFinish(i3);
        eventReport(eventType, tbsLogInfo);
    }

    public void setInstallErrorCode(int i3, Throwable th5) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th5);
        a(i3, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    private void a(int i3, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i3);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, TbsLogInfo tbsLogInfo) {
        Map<String, Object> map = QbSdk.f369007q;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f369007q.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("TbsLogReport", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(i3));
        sb5.append(a(""));
        sb5.append(a(com.tencent.smtt.utils.m.a(this.f369125d)));
        sb5.append(a(n.a().g(this.f369125d)));
        sb5.append(a(""));
        String packageName = this.f369125d.getPackageName();
        sb5.append(a(packageName));
        if ("com.tencent.mm".equals(packageName)) {
            sb5.append(a(AppUtil.getAppMetadata(this.f369125d, TbsDownloader.TBS_METADATA)));
        } else {
            sb5.append(a(AppUtil.getAppVersionCode(this.f369125d)));
        }
        sb5.append(a(a(tbsLogInfo.f369132b)));
        sb5.append(a(tbsLogInfo.f369133c));
        sb5.append(a(tbsLogInfo.f369134d));
        sb5.append(a(tbsLogInfo.f369135e));
        sb5.append(a(tbsLogInfo.f369136f));
        sb5.append(a(tbsLogInfo.f369137g));
        sb5.append(a(tbsLogInfo.f369138h));
        sb5.append(a(tbsLogInfo.f369139i));
        sb5.append(a(tbsLogInfo.f369140j));
        sb5.append(a(tbsLogInfo.f369141k));
        sb5.append(b(tbsLogInfo.f369147q));
        sb5.append(b(tbsLogInfo.f369142l));
        sb5.append(b(tbsLogInfo.f369143m));
        sb5.append(a(tbsLogInfo.f369144n));
        sb5.append(a(tbsLogInfo.f369131a));
        sb5.append(a(tbsLogInfo.f369145o));
        sb5.append(a(tbsLogInfo.f369146p));
        sb5.append(a(TbsDownloadConfig.getInstance(this.f369125d).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb5.append(a(AppUtil.getAndroidID(this.f369125d)));
        sb5.append(a("44357"));
        sb5.append(false);
        try {
            SharedPreferences d16 = d();
            JSONArray a16 = a();
            a16.mo162put(sb5.toString());
            SharedPreferences.Editor edit = d16.edit();
            String jSONArray = a16.toString();
            try {
                jSONArray = Base64.encodeToString(jSONArray.getBytes(), 2);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            edit.putString("tbs_tbslogreport_upload", jSONArray);
            edit.commit();
        } catch (Exception unused) {
        }
        if (this.f369126e) {
            b();
        }
    }

    private String b(long j3) {
        return j3 + "|";
    }

    private JSONArray a() {
        String string = d().getString("tbs_tbslogreport_upload", null);
        if (string != null) {
            try {
                string = new String(Base64.a(string, 2));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            while (true) {
                length--;
                if (length < jSONArray.length() - 5) {
                    return jSONArray2;
                }
                jSONArray2.mo162put(jSONArray.get(length));
            }
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    private String a(long j3) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j3));
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        sb5.append("|");
        return sb5.toString();
    }

    private String a(int i3) {
        return i3 + "|";
    }
}
