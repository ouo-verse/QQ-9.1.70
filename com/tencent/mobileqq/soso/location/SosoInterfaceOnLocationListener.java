package com.tencent.mobileqq.soso.location;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.util.bo;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class SosoInterfaceOnLocationListener {
    static IPatchRedirector $redirector_ = null;
    private static final HashSet<String> CONTINUOUS_LOCATION_WHITE_LIST;
    private static final long ONE_MINUTE = 60000;
    protected boolean askGPS;
    protected String callerRoute;
    protected long geoCacheInterval;
    protected long globalCacheInterval;
    protected boolean goonListener;
    public boolean isRemoved;
    protected int level;
    protected long levelCacheInterval;
    protected long maxCacheInterval;
    protected int maxFailCount;
    protected boolean reqLocation;
    public boolean requesting;
    protected long sTime;
    protected String tag;
    protected boolean uiThread;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37202);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        CONTINUOUS_LOCATION_WHITE_LIST = hashSet;
        hashSet.add("pathtrace");
        hashSet.add(QQMapActivity.TAG);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
    
        if (r12 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        if (r12 == 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r12 != 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
    
        throw new android.util.AndroidRuntimeException("invalid level=" + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SosoInterfaceOnLocationListener(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
            return;
        }
        this.goonListener = false;
        this.reqLocation = false;
        this.askGPS = false;
        this.isRemoved = false;
        this.requesting = false;
        this.maxFailCount = 3;
        if (bo.c() && z19) {
            try {
                Class<?> cls = getClass();
                Class<?> cls2 = Integer.TYPE;
                Class<?> declaringClass = cls.getMethod("onConsecutiveFailure", cls2, cls2).getDeclaringClass();
                if (declaringClass != null && declaringClass == SosoInterfaceOnLocationListener.class) {
                    throw new AndroidRuntimeException("OnLocationListener:goon=true, must override method'onConsecutiveFailure()'");
                }
            } catch (NoSuchMethodException e16) {
                e16.printStackTrace();
            } catch (SecurityException e17) {
                e17.printStackTrace();
            }
        }
        this.tag = str;
        this.level = i3;
        this.askGPS = z17;
        this.reqLocation = z16;
        this.goonListener = !z19 && allowContinuousLocation(str);
        this.uiThread = z18;
        this.maxCacheInterval = getMaxCacheInterval(str, j3);
        this.sTime = SystemClock.elapsedRealtime();
        this.tag = str;
        this.level = i3;
        this.askGPS = z17;
        this.reqLocation = z16;
        this.goonListener = !z19 && allowContinuousLocation(str);
        this.uiThread = z18;
        this.maxCacheInterval = getMaxCacheInterval(str, j3);
        this.sTime = SystemClock.elapsedRealtime();
    }

    private boolean allowContinuousLocation(String str) {
        return CONTINUOUS_LOCATION_WHITE_LIST.contains(str);
    }

    private long getMaxCacheInterval(String str, long j3) {
        if (j3 < 60000 && !allowContinuousLocation(str)) {
            return 60000L;
        }
        return j3;
    }

    public void onConsecutiveFailure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public abstract void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo);

    public void onStatusUpdate(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
        }
    }
}
