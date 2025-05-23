package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.NeedParcel;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b implements com.tencent.smartparcelable.a {

    @NeedParcel
    public long C;

    @NeedParcel
    public String D;

    /* renamed from: h, reason: collision with root package name */
    @NeedParcel
    public int f91907h;

    /* renamed from: e, reason: collision with root package name */
    @NeedParcel
    public long f91905e = 0;

    /* renamed from: f, reason: collision with root package name */
    @NeedParcel
    public int f91906f = 0;

    /* renamed from: i, reason: collision with root package name */
    @NeedParcel
    public byte[] f91908i = null;

    /* renamed from: m, reason: collision with root package name */
    @NeedParcel
    public long[] f91909m = null;

    /* renamed from: d, reason: collision with root package name */
    @NeedParcel
    protected final long f91904d = System.nanoTime();

    public long[] a() {
        return this.f91909m;
    }

    protected abstract String b();

    public String c() {
        return null;
    }

    public void d(String str, String str2) {
        e(str, str2, false);
    }

    public void e(String str, String str2, boolean z16) {
        if (z16) {
            QLog.e(str + "_" + b(), 1, str2 + " id:" + getTaskId() + " ,state:" + this.f91907h + " ,resultCode:" + this.C + " ,errMsg:" + this.D);
            return;
        }
        QLog.d(str + "_" + b(), 2, str2 + " id:" + getTaskId() + " ,state:" + this.f91907h);
    }

    public String getCacheKey() {
        return getTaskId() + "";
    }

    public long getResultCode() {
        return this.C;
    }

    public String getResultMsg() {
        return this.D;
    }

    public int getRetryNum() {
        return this.f91906f;
    }

    public int getState() {
        return this.f91907h;
    }

    public long getTaskId() {
        return this.f91904d;
    }

    public long getTime() {
        return this.f91905e;
    }

    public boolean isNullTask() {
        return false;
    }

    public void onResume() {
        this.f91906f++;
    }

    public void setResultCode(long j3) {
        this.C = j3;
    }

    public void setResultMsg(String str) {
        this.D = str;
    }

    public void setState(int i3) {
        this.f91907h = i3;
    }

    public void setTime(long j3) {
        this.f91905e = j3;
    }

    public void clear() {
    }

    public void f() {
    }

    public void onRemove() {
    }

    public void onRestore() {
    }
}
