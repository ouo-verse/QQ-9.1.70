package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f37381a;

    /* renamed from: b, reason: collision with root package name */
    public final ErrorEnum f37382b;

    public BaseException(int i3) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i3);
        this.f37382b = fromCode;
        this.f37381a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f37381a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f37382b.getMessage();
    }
}
