package com.huawei.secure.android.common.util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c, reason: collision with root package name */
    private static final long f38025c = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f38026a;

    /* renamed from: b, reason: collision with root package name */
    private String f38027b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f38027b;
    }

    public String getRetCd() {
        return this.f38026a;
    }

    public SecurityCommonException(Throwable th5) {
        super(th5);
    }

    public SecurityCommonException(String str, Throwable th5) {
        super(str, th5);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f38027b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f38026a = str;
        this.f38027b = str2;
    }
}
