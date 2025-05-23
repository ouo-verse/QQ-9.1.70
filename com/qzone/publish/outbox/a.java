package com.qzone.publish.outbox;

import android.os.Parcel;
import c9.b;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a extends com.qzone.component.cache.database.a {
    public static final int RETRY_NO_PAUSE = 2;
    public static final int RETRY_NO_QUIT = 3;
    public static final int RETRY_YES = 1;
    public static final int STATE_CANEL = 6;
    public static final int STATE_FINISH = 5;
    public static final int STATE_PAUSE = 3;
    public static final int STATE_QUIT = 7;
    public static final int STATE_RUNNING = 2;
    public static final int STATE_STOP = 4;
    public static final int STATE_WAIT = 1;
    public static final int WEBAPP_CODE_NO_RETRY = -5069;
    public static final int WEBAPP_CODE_REPLY_TOO_OFTEN = -11210;
    public static final int WEBAPP_CODE_RETRY = 1054;
    public static final int WEBAPP_CODE_SUCC = 0;
    protected int C;
    protected long D;
    protected int E;
    protected long F;
    protected b G;
    protected c9.a H;
    protected transient long I;

    /* renamed from: d, reason: collision with root package name */
    protected String f51254d;

    /* renamed from: e, reason: collision with root package name */
    protected int f51255e;

    /* renamed from: f, reason: collision with root package name */
    protected int f51256f;

    /* renamed from: h, reason: collision with root package name */
    protected int f51257h;

    /* renamed from: i, reason: collision with root package name */
    protected int f51258i;

    /* renamed from: m, reason: collision with root package name */
    protected int f51259m;

    public a() {
        this.f51254d = "none";
        this.f51257h = Integer.MAX_VALUE;
        this.f51258i = 0;
        this.f51259m = 1;
        this.E = 1;
        this.I = 0L;
        this.D = System.currentTimeMillis();
    }

    public int canRetry() {
        if (System.currentTimeMillis() - this.D >= this.F) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("Outbox", 4, "can't retry -- timeout.");
            }
            return 3;
        }
        if (this.f51258i >= this.f51257h) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("Outbox", 4, "can't retry -- over max try.");
            }
            return 3;
        }
        if (this.C < this.f51259m) {
            return 1;
        }
        if (!QZLog.isDevelopLevel()) {
            return 2;
        }
        QZLog.d("Outbox", 4, "can't retry -- over per wake up try.");
        return 2;
    }

    public abstract void cancel();

    public void finish() {
        b bVar = this.G;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public int getGroupId() {
        return this.f51255e;
    }

    public int getMaxTry() {
        return this.f51257h;
    }

    public int getRetryCount() {
        return this.f51258i;
    }

    public int getSessionId() {
        return this.f51256f;
    }

    public int getState() {
        return this.E;
    }

    public long getTimeoutDistrict() {
        return this.F;
    }

    public long getmCreateTime() {
        return this.D;
    }

    public String getmGroupName() {
        return this.f51254d;
    }

    public int hashCode() {
        long j3 = this.D;
        int i3 = (((((((((((((int) (j3 ^ (j3 >>> 32))) + 31) * 31) + this.f51255e) * 31) + this.f51257h) * 31) + this.f51258i) * 31) + this.f51256f) * 31) + this.E) * 31;
        long j16 = this.F;
        return i3 + ((int) ((j16 >>> 32) ^ j16));
    }

    public void increaseRetry() {
        this.f51258i++;
    }

    public void increaseRetryPerWakeUp() {
        this.C++;
    }

    public boolean isCancel() {
        return this.E == 6;
    }

    public boolean isFinish() {
        return this.E == 5;
    }

    public boolean isInPeriod() {
        return this.C < this.f51259m;
    }

    public boolean isPause() {
        return this.E == 3;
    }

    public boolean isQuit() {
        return this.E == 7;
    }

    public boolean isRunning() {
        return this.E == 2;
    }

    public boolean isStop() {
        return this.E == 4;
    }

    public boolean isWaiting() {
        return this.E == 1;
    }

    public abstract void pause();

    public abstract void resume();

    public void setGroupId(int i3) {
        this.f51255e = i3;
    }

    public void setMaxTry(int i3) {
        this.f51257h = i3;
    }

    public void setOnSessionCallback(c9.a aVar) {
        this.H = aVar;
    }

    public void setRetryCount(int i3) {
        this.f51258i = i3;
    }

    public void setSessionId(int i3) {
        this.f51256f = i3;
    }

    public void setState(int i3) {
        this.E = i3;
    }

    public void setTimeoutDistrict(long j3) {
        this.F = j3;
    }

    public abstract void start();

    public abstract void stop();

    public String toString() {
        return "Session [mGroupId=" + this.f51255e + ", mGroupName=" + this.f51254d + ", mSessionId=" + this.f51256f + ", mMaxTry=" + this.f51257h + ", mRetryCount=" + this.f51258i + ", mCreateTime=" + this.D + ", mState=" + this.E + ", mTimeoutDistrict=" + this.F + "]";
    }

    public void writeToParcel(Parcel parcel) {
        parcel.writeString(this.f51254d);
        parcel.writeInt(this.f51255e);
        parcel.writeInt(this.f51256f);
        parcel.writeInt(this.f51257h);
        parcel.writeInt(this.f51258i);
        parcel.writeInt(this.f51259m);
        parcel.writeInt(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeLong(this.F);
    }

    public void clearRetryPerWakeUp() {
        this.C = 0;
    }

    public void setCancel() {
        this.E = 6;
    }

    public void setFinish() {
        this.E = 5;
    }

    public void setPause() {
        this.E = 3;
    }

    public void setQuit() {
        this.E = 7;
    }

    public void setRunning() {
        this.E = 2;
    }

    public a(b bVar) {
        this();
        this.G = bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f51254d.equals(aVar.f51254d) && this.f51255e == aVar.f51255e && this.f51256f == aVar.f51256f && this.D == aVar.D;
    }

    public a(b bVar, int i3, long j3) {
        this(bVar);
        this.f51257h = i3;
        this.F = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel) {
        this.f51254d = "none";
        this.f51257h = Integer.MAX_VALUE;
        this.f51258i = 0;
        this.f51259m = 1;
        this.E = 1;
        this.I = 0L;
        this.f51254d = parcel.readString();
        this.f51255e = parcel.readInt();
        this.f51256f = parcel.readInt();
        this.f51257h = parcel.readInt();
        this.f51258i = parcel.readInt();
        this.f51259m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readLong();
        if (isRunning()) {
            setPause();
        }
    }
}
