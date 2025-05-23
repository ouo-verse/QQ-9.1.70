package com.tencent.weiyun.uploader.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SpeedFilter {
    static IPatchRedirector $redirector_ = null;
    private static final long AVERAGE_SPEED_TIME_UNIT_LONG = 8000;
    private static final long AVERAGE_SPEED_TIME_UNIT_SHORT = 3000;
    private final Deque<SpeedInfo> mCacheLong;
    private final Deque<SpeedInfo> mCacheShort;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SpeedInfo {
        static IPatchRedirector $redirector_;
        long adSpeed;
        long curTime;
        long exSpeed;
        long speed;

        SpeedInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeedFilter.this);
        }

        /* synthetic */ SpeedInfo(SpeedFilter speedFilter, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) speedFilter, (Object) anonymousClass1);
        }
    }

    public SpeedFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCacheLong = new LinkedList();
            this.mCacheShort = new LinkedList();
        }
    }

    private long[] calAvg(SpeedInfo[] speedInfoArr) {
        long j3;
        long j16;
        if (speedInfoArr != null && speedInfoArr.length != 0) {
            long j17 = 0;
            long j18 = 0;
            long j19 = 0;
            long j26 = 0;
            for (SpeedInfo speedInfo : speedInfoArr) {
                j18 += speedInfo.speed;
                j19 += speedInfo.exSpeed;
                j26 += speedInfo.adSpeed;
            }
            if (j18 > 0) {
                j3 = (long) (j18 / speedInfoArr.length);
            } else {
                j3 = 0;
            }
            if (j19 > 0) {
                j16 = (long) (j19 / speedInfoArr.length);
            } else {
                j16 = 0;
            }
            if (j26 > 0) {
                j17 = (long) (j26 / speedInfoArr.length);
            }
            return new long[]{j3, j16, j17};
        }
        return new long[]{0, 0, 0};
    }

    public synchronized void clearSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mCacheLong.clear();
            this.mCacheShort.clear();
        }
    }

    public synchronized long[] updateSpeed(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (long[]) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<SpeedInfo> it = this.mCacheLong.iterator();
        while (it.hasNext()) {
            if (currentTimeMillis - it.next().curTime > 8000) {
                it.remove();
            }
        }
        Iterator<SpeedInfo> it5 = this.mCacheShort.iterator();
        while (it5.hasNext()) {
            if (currentTimeMillis - it5.next().curTime > 3000) {
                it5.remove();
            }
        }
        SpeedInfo speedInfo = new SpeedInfo(this, null);
        speedInfo.curTime = currentTimeMillis;
        speedInfo.speed = j3;
        speedInfo.exSpeed = j16;
        speedInfo.adSpeed = j17;
        this.mCacheLong.offerLast(speedInfo);
        this.mCacheShort.offerLast(speedInfo);
        SpeedInfo[] speedInfoArr = new SpeedInfo[this.mCacheLong.size()];
        this.mCacheLong.toArray(speedInfoArr);
        SpeedInfo[] speedInfoArr2 = new SpeedInfo[this.mCacheShort.size()];
        this.mCacheShort.toArray(speedInfoArr2);
        long[] calAvg = calAvg(speedInfoArr);
        long[] calAvg2 = calAvg(speedInfoArr2);
        if (calAvg[0] <= calAvg2[0]) {
            calAvg = calAvg2;
        }
        return calAvg;
    }
}
