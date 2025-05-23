package com.tencent.bugly;

import com.tencent.bugly.proguard.ai;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    private String f97783c;

    /* renamed from: d, reason: collision with root package name */
    private String f97784d;

    /* renamed from: e, reason: collision with root package name */
    private String f97785e;

    /* renamed from: f, reason: collision with root package name */
    private long f97786f;

    /* renamed from: g, reason: collision with root package name */
    private String f97787g;

    /* renamed from: h, reason: collision with root package name */
    private String f97788h;

    /* renamed from: i, reason: collision with root package name */
    private String f97789i;

    /* renamed from: u, reason: collision with root package name */
    private a f97801u;

    /* renamed from: j, reason: collision with root package name */
    private boolean f97790j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f97791k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f97792l = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f97793m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f97794n = true;

    /* renamed from: o, reason: collision with root package name */
    private Class<?> f97795o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f97796p = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f97797q = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f97798r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f97799s = true;

    /* renamed from: t, reason: collision with root package name */
    private boolean f97800t = false;

    /* renamed from: a, reason: collision with root package name */
    protected int f97781a = 31;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f97782b = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f97802v = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
        public final synchronized Map<String, String> a() {
            return null;
        }

        public final synchronized byte[] b() {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f97784d;
        if (str == null) {
            return ai.c().f98035w;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f97785e;
        if (str == null) {
            return ai.c().f98015c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f97786f;
    }

    public synchronized String getAppVersion() {
        String str = this.f97783c;
        if (str == null) {
            return ai.c().f98032t;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.f97781a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f97782b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f97801u;
    }

    public synchronized String getDeviceID() {
        return this.f97788h;
    }

    public synchronized String getDeviceModel() {
        return this.f97789i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f97787g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f97795o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f97796p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f97791k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f97792l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f97790j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f97793m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f97794n;
    }

    public boolean isMerged() {
        return this.f97802v;
    }

    public boolean isReplaceOldChannel() {
        return this.f97797q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f97798r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f97799s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f97800t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f97784d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f97785e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j3) {
        this.f97786f = j3;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f97783c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z16) {
        this.f97796p = z16;
        return this;
    }

    public synchronized void setCallBackType(int i3) {
        this.f97781a = i3;
    }

    public synchronized void setCloseErrorCallback(boolean z16) {
        this.f97782b = z16;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f97801u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f97788h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f97789i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z16) {
        this.f97791k = z16;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z16) {
        this.f97792l = z16;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z16) {
        this.f97790j = z16;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z16) {
        this.f97793m = z16;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z16) {
        this.f97794n = z16;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f97787g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z16) {
        this.f97802v = z16;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z16) {
        this.f97800t = z16;
        return this;
    }

    public void setReplaceOldChannel(boolean z16) {
        this.f97797q = z16;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z16) {
        this.f97798r = z16;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z16) {
        this.f97799s = z16;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f97795o = cls;
        return this;
    }
}
