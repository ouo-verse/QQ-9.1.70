package com.tencent.mobileqq.now.netchannel.websso;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    public static e f254388d;

    /* renamed from: a, reason: collision with root package name */
    private long f254389a;

    /* renamed from: b, reason: collision with root package name */
    private long f254390b;

    /* renamed from: c, reason: collision with root package name */
    private String f254391c;

    e() {
    }

    public static AppInterface b() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static e c() {
        if (f254388d == null) {
            f254388d = new e();
        }
        return f254388d;
    }

    public static long f() {
        AppInterface b16 = b();
        if (b16 == null) {
            return 0L;
        }
        return b16.getLongAccountUin();
    }

    public static String g() {
        AppInterface b16 = b();
        if (b16 == null) {
            return "";
        }
        return b16.getCurrentAccountUin();
    }

    public static void h() {
        f254388d = null;
    }

    public String a() {
        String str = this.f254391c;
        if (str == null) {
            return "";
        }
        return str;
    }

    public long d() {
        return this.f254390b;
    }

    public long e() {
        return this.f254389a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        this.f254391c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(long j3) {
        this.f254390b = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(long j3) {
        this.f254389a = j3;
    }
}
