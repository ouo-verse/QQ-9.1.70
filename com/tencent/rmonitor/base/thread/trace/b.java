package com.tencent.rmonitor.base.thread.trace;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements Comparable {

    /* renamed from: d, reason: collision with root package name */
    public String f365449d;

    /* renamed from: e, reason: collision with root package name */
    public long f365450e;

    /* renamed from: f, reason: collision with root package name */
    public long f365451f;

    /* renamed from: h, reason: collision with root package name */
    public long f365452h;

    /* renamed from: i, reason: collision with root package name */
    public long f365453i;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if ((obj instanceof b) && this.f365450e < ((b) obj).f365450e) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(10);
        sb5.append("\n");
        sb5.append("mTimeStamp = ");
        sb5.append(this.f365450e);
        sb5.append(",\n");
        sb5.append("mWalkStackTimeCost = ");
        sb5.append(this.f365451f);
        sb5.append(",\n");
        sb5.append("mSuspendTimeCost = ");
        sb5.append(this.f365452h);
        sb5.append(",\n");
        sb5.append("mRequestDelay = ");
        sb5.append(this.f365453i);
        sb5.append(",\n");
        sb5.append("mStacks = \n");
        sb5.append(this.f365449d);
        sb5.append("\n");
        return sb5.toString();
    }
}
