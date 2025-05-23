package com.tencent.feedback.eup;

import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bm;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CrashStrategyBean {
    static IPatchRedirector $redirector_ = null;
    public static final String FORMAT = "[ODay:%d,isMerged:%b,tag:%s]";

    /* renamed from: a, reason: collision with root package name */
    private int f105532a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f105533b;

    /* renamed from: c, reason: collision with root package name */
    private int f105534c;

    /* renamed from: d, reason: collision with root package name */
    private String f105535d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f105536e;

    /* renamed from: f, reason: collision with root package name */
    private String f105537f;

    /* renamed from: g, reason: collision with root package name */
    private int f105538g;

    /* renamed from: h, reason: collision with root package name */
    private int f105539h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f105540i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f105541j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f105542k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f105543l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f105544m;

    /* renamed from: n, reason: collision with root package name */
    private int f105545n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f105546o;

    /* renamed from: p, reason: collision with root package name */
    private String f105547p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f105548q;

    /* renamed from: r, reason: collision with root package name */
    private bm f105549r;

    /* renamed from: s, reason: collision with root package name */
    private CrashHandleListener f105550s;

    /* renamed from: t, reason: collision with root package name */
    private UploadHandleListener f105551t;

    public CrashStrategyBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f105532a = 10;
        this.f105533b = false;
        this.f105534c = be.f98211e;
        this.f105535d = null;
        this.f105536e = false;
        this.f105537f = null;
        this.f105538g = be.f98221o;
        this.f105539h = be.f98215i;
        this.f105540i = true;
        this.f105541j = true;
        this.f105542k = true;
        this.f105543l = false;
        this.f105544m = true;
        this.f105545n = 31;
        this.f105546o = true;
        this.f105548q = true;
        this.f105549r = null;
        this.f105550s = null;
        this.f105551t = null;
    }

    @Deprecated
    public synchronized int getCallBackType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return this.f105545n;
    }

    @Deprecated
    public synchronized boolean getCloseErrorCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.f105546o;
    }

    public synchronized CrashHandleListener getCrashHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CrashHandleListener) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f105550s;
    }

    @Deprecated
    public synchronized int getCrashSdcardMaxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f105538g;
    }

    public synchronized String getLibBuglySOFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.f105547p;
    }

    @Deprecated
    public int getMaxLogLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.f105534c;
    }

    @Deprecated
    public synchronized int getMaxStackLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.f105539h;
    }

    @Deprecated
    public synchronized String getOnlyLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f105535d;
    }

    @Deprecated
    public synchronized int getRecordOverDays() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f105532a;
    }

    @Deprecated
    public synchronized String getStoreDirectoryPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f105537f;
    }

    public synchronized UploadHandleListener getUploadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UploadHandleListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f105551t;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.f105540i;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.f105542k;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.f105541j;
    }

    public boolean isEnableRecordAnrMainStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.f105543l;
    }

    @Deprecated
    public synchronized boolean isMerged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f105533b;
    }

    @Deprecated
    public synchronized boolean isStoreCrashSdcard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f105536e;
    }

    public synchronized boolean isUploadProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f105548q;
    }

    @Deprecated
    public synchronized boolean isUploadSpotCrash() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f105544m;
    }

    @Deprecated
    public synchronized void setCallBackType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        } else {
            this.f105545n = i3;
        }
    }

    @Deprecated
    public synchronized void setCloseErrorCallback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
        } else {
            this.f105546o = z16;
        }
    }

    public synchronized void setCrashHandler(CrashHandleListener crashHandleListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) crashHandleListener);
        } else {
            this.f105550s = crashHandleListener;
        }
    }

    @Deprecated
    public synchronized void setCrashSdcardMaxSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            if (i3 > 0) {
                this.f105538g = i3;
            }
        }
    }

    public synchronized void setEnableANRCrashMonitor(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.f105540i = z16;
        }
    }

    public synchronized void setEnableCatchAnrTrace(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.f105542k = z16;
        }
    }

    public synchronized void setEnableNativeCrashMonitor(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.f105541j = z16;
        }
    }

    public void setEnableRecordAnrMainStack(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.f105543l = z16;
        }
    }

    public synchronized void setLibBuglySOFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        } else {
            this.f105547p = str;
        }
    }

    @Deprecated
    public void setMaxLogLength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            this.f105534c = i3;
        }
    }

    @Deprecated
    public synchronized void setMaxStackLength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.f105539h = i3;
        }
    }

    @Deprecated
    public synchronized void setMerged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f105533b = z16;
        }
    }

    @Deprecated
    public synchronized void setOnlyLogTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f105535d = str;
        }
    }

    @Deprecated
    public synchronized void setRecordOverDays(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            if (i3 > 0) {
                this.f105532a = i3;
            }
        }
    }

    @Deprecated
    public synchronized void setStoreCrashSdcard(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.f105536e = z16;
        }
    }

    @Deprecated
    public synchronized void setStoreDirectoryPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.f105537f = str;
        }
    }

    public synchronized void setUploadHandler(UploadHandleListener uploadHandleListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uploadHandleListener);
        } else {
            this.f105551t = uploadHandleListener;
        }
    }

    public synchronized void setUploadProcess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f105548q = z16;
        }
    }

    @Deprecated
    public synchronized void setUploadSpotCrash(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f105544m = z16;
        }
    }

    public synchronized String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        try {
            return String.format(Locale.US, FORMAT, Integer.valueOf(this.f105532a), Boolean.valueOf(this.f105533b), this.f105535d);
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return "error";
            }
            return "error";
        }
    }
}
