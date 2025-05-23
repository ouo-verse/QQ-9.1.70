package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HMSBIInitializer {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f37671d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static HMSBIInitializer f37672e;

    /* renamed from: f, reason: collision with root package name */
    private static HiAnalyticsInstance f37673f;

    /* renamed from: a, reason: collision with root package name */
    private final Context f37674a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f37675b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private boolean f37676c = c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements IQueryUrlCallBack {
        a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i3) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i3);
            HMSBIInitializer.this.f37675b.set(false);
            com.huawei.hms.stats.a.c().a();
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.f37676c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f37674a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    HiAnalyticsInstance unused = HMSBIInitializer.f37673f = new HiAnalyticsInstance.Builder(HMSBIInitializer.this.f37674a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                    HMSBIInitializer.f37673f.setAppid("com.huawei.hwid");
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.f37675b.set(false);
            com.huawei.hms.stats.a.c().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends AsyncTask<String, Integer, Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.a(strArr[0]);
            return null;
        }

        /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    HMSBIInitializer(Context context) {
        this.f37674a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f37671d) {
            if (f37672e == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f37672e = new HMSBIInitializer(applicationContext);
                } else {
                    f37672e = new HMSBIInitializer(context);
                }
            }
        }
        return f37672e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f37673f;
    }

    public void initBI() {
        boolean initFlag;
        if (!this.f37676c) {
            initFlag = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            initFlag = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || AnalyticsSwitchHolder.isAnalyticsDisabled(this.f37674a)) {
            return;
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
        initHaSDK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initHaSDK() {
        if (this.f37675b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f37674a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
                new b(this, null).execute(issueCountryCode);
            } else {
                HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                this.f37675b.set(false);
            }
        }
    }

    public boolean isInit() {
        if (!this.f37676c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f37674a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}
