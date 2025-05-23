package com.tencent.raft.measure;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.measure.config.MeasureAppConfig;
import com.tencent.raft.measure.config.MeasureAppConfigBuilder;
import com.tencent.raft.measure.config.RAFTComConfig;
import com.tencent.raft.measure.exception.ComConfigInvalidException;
import com.tencent.raft.measure.log.RLog;
import com.tencent.raft.measure.report.ATTAReporter;
import com.tencent.raft.measure.report.AppInfo;
import com.tencent.raft.measure.report.SLIReportItem;
import com.tencent.raft.measure.report.StartUpReportItem;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.raft.measure.utils.SamplingUtil;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes25.dex */
final class MeasureCore {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f364048e;

    /* renamed from: a, reason: collision with root package name */
    private final ATTAReporter f364049a;

    /* renamed from: b, reason: collision with root package name */
    private MeasureAppConfig f364050b;

    /* renamed from: c, reason: collision with root package name */
    private AppInfo f364051c;

    /* renamed from: d, reason: collision with root package name */
    boolean f364052d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f364048e = new Object();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MeasureCore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f364052d = true;
        this.f364050b = new MeasureAppConfigBuilder().create();
        this.f364049a = new ATTAReporter(MeasureConst.ATTA_APP_ID, MeasureConst.ATTA_TOKEN);
    }

    private boolean f(@NonNull Context context) {
        if (this.f364051c != null) {
            return true;
        }
        synchronized (f364048e) {
            if (this.f364051c == null) {
                try {
                    AppInfo appInfo = new AppInfo(context.getPackageName(), k(context), InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName);
                    this.f364051c = appInfo;
                    appInfo.ensureNotNull();
                } catch (Exception e16) {
                    RLog.e("MeasureCore", "initAppItem exception", e16);
                }
            }
        }
        if (this.f364051c != null) {
            return true;
        }
        RLog.d("MeasureCore", "appItem is init fail! ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig) {
        if (!f(context)) {
            RLog.d("MeasureCore", "appItem is init fail! ");
            return;
        }
        SamplingUtil.SamplingResult startUpSampling = SamplingUtil.startUpSampling(rAFTComConfig);
        if (startUpSampling != SamplingUtil.SamplingResult.REPORT) {
            if (startUpSampling != SamplingUtil.SamplingResult.REPEAT_LIMIT) {
                RLog.d("MeasureCore", "filter Usage for " + rAFTComConfig.getUniKey() + " reason = " + startUpSampling.name());
                return;
            }
            return;
        }
        StartUpReportItem startUpReportItem = new StartUpReportItem(rAFTComConfig, this.f364051c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(startUpReportItem.toUrlParams());
        this.f364049a.doPostBatchReport(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BuglySdkInfos", 0);
        if (rAFTComConfig.getComVersion().equals(sharedPreferences.getString(rAFTComConfig.getComName(), ""))) {
            if (this.f364052d || j().isDebug()) {
                RLog.d("MeasureCore", "exist same version " + rAFTComConfig.toString());
                this.f364052d = false;
                return;
            }
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(rAFTComConfig.getComName(), rAFTComConfig.getComVersion());
        edit.apply();
    }

    private static String k(Context context) {
        try {
            int i3 = context.getApplicationInfo().labelRes;
            if (i3 != 0) {
                return context.getString(i3);
            }
            CharSequence charSequence = context.getApplicationInfo().nonLocalizedLabel;
            if (!TextUtils.isEmpty(charSequence)) {
                return charSequence.toString();
            }
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0);
            if (packageInfo == null) {
                return "";
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, String str, String str2, String str3) {
        if (!rAFTComConfig.isDataValid()) {
            RLog.d("MeasureCore", "SLIComConfig not valid " + rAFTComConfig.toString());
            if (!this.f364050b.isDebug()) {
                return;
            } else {
                throw new ComConfigInvalidException(rAFTComConfig);
            }
        }
        if (!f(context)) {
            RLog.d("MeasureCore", "appItem is init fail! ");
            return;
        }
        SLIReportItem sLIReportItem = new SLIReportItem(rAFTComConfig, str, str2, str3);
        sLIReportItem.setAppInfo(this.f364051c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(sLIReportItem.toUrlParams());
        this.f364049a.doPostBatchReport(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, String str, int i3) {
        SamplingUtil.SamplingResult sLISamplingResult = SamplingUtil.getSLISamplingResult(context, rAFTComConfig, str, i3);
        if (sLISamplingResult == SamplingUtil.SamplingResult.REPORT) {
            return false;
        }
        if (this.f364050b.isDebug()) {
            RLog.d("MeasureCore", "filter report for key=" + str + " reason = " + sLISamplingResult.name());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig) {
        if (!rAFTComConfig.isDataValid()) {
            RLog.d("MeasureCore", "SLIComConfig not valid " + rAFTComConfig.toString());
            if (!this.f364050b.isDebug()) {
                return;
            } else {
                throw new ComConfigInvalidException(rAFTComConfig);
            }
        }
        this.f364050b.getExecutor().schedule(new Runnable(context, rAFTComConfig) { // from class: com.tencent.raft.measure.MeasureCore.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f364059d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RAFTComConfig f364060e;

            {
                this.f364059d = context;
                this.f364060e = rAFTComConfig;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MeasureCore.this, context, rAFTComConfig);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isDebug;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        MeasureCore.this.i(this.f364059d, this.f364060e);
                        MeasureCore.this.g(this.f364059d, this.f364060e);
                    } finally {
                        if (!isDebug) {
                        }
                    }
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MeasureAppConfig j() {
        return this.f364050b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, String str, String str2, int i3, String str3) {
        this.f364050b.getExecutor().schedule(new Runnable(context, rAFTComConfig, str, i3, str2, str3) { // from class: com.tencent.raft.measure.MeasureCore.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f364053d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RAFTComConfig f364054e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f364055f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f364056h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f364057i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f364058m;

            {
                this.f364053d = context;
                this.f364054e = rAFTComConfig;
                this.f364055f = str;
                this.f364056h = i3;
                this.f364057i = str2;
                this.f364058m = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MeasureCore.this, context, rAFTComConfig, str, Integer.valueOf(i3), str2, str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isDebug;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (!MeasureCore.this.o(this.f364053d, this.f364054e, this.f364055f, this.f364056h)) {
                        MeasureCore.this.m(this.f364053d, this.f364054e, this.f364055f, this.f364057i, this.f364058m);
                        MeasureCore.this.g(this.f364053d, this.f364054e);
                    }
                } finally {
                    if (!isDebug) {
                    }
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(@NonNull MeasureAppConfig measureAppConfig) {
        this.f364050b = measureAppConfig;
    }
}
