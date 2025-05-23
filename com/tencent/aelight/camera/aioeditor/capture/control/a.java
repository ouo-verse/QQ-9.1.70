package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f66678b = true;

    /* renamed from: c, reason: collision with root package name */
    public static String f66679c = "{1001,1004,1003,1005,1006,1007,1010}";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f66680d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f66681e;

    /* renamed from: f, reason: collision with root package name */
    public static String f66682f;

    /* renamed from: a, reason: collision with root package name */
    public CaptureAsyncAutomator f66683a = new CaptureAsyncAutomator(null);

    public static boolean b(boolean z16) {
        return false;
    }

    public void a() {
        this.f66683a.h();
    }

    public void c(int i3) {
        CaptureAsyncAutomator captureAsyncAutomator = this.f66683a;
        captureAsyncAutomator.i(CaptureAsyncStepFactory.a(captureAsyncAutomator, String.valueOf(i3)));
    }

    public void d(String str) {
        CaptureAsyncAutomator captureAsyncAutomator = this.f66683a;
        captureAsyncAutomator.i(CaptureAsyncStepFactory.a(captureAsyncAutomator, str));
    }

    public void e(String str, Object[] objArr) {
        AsyncStep a16 = CaptureAsyncStepFactory.a(this.f66683a, str);
        a16.mParams = objArr;
        this.f66683a.i(a16);
    }
}
