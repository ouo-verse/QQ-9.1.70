package com.tencent.tbs.one;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TBSOneException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private int f374509a;

    public TBSOneException(int i3, String str) {
        super(str);
        this.f374509a = i3;
    }

    public int getErrorCode() {
        return this.f374509a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[" + this.f374509a + "] " + getLocalizedMessage();
    }

    public TBSOneException(int i3, String str, Throwable th5) {
        super(str, th5);
        this.f374509a = i3;
    }
}
