package com.tencent.avcore.camera.callback;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int f77414a;

    /* renamed from: b, reason: collision with root package name */
    int f77415b;

    /* renamed from: c, reason: collision with root package name */
    int f77416c;

    /* renamed from: d, reason: collision with root package name */
    boolean f77417d;

    /* renamed from: e, reason: collision with root package name */
    int f77418e;

    /* renamed from: f, reason: collision with root package name */
    int f77419f;

    /* renamed from: g, reason: collision with root package name */
    int f77420g;

    /* renamed from: h, reason: collision with root package name */
    int f77421h;

    /* renamed from: i, reason: collision with root package name */
    int f77422i;

    /* renamed from: j, reason: collision with root package name */
    int f77423j;

    /* renamed from: k, reason: collision with root package name */
    int f77424k;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f77414a = -99;
        this.f77415b = -99;
        this.f77416c = -99;
        this.f77417d = false;
        this.f77418e = -99;
        this.f77419f = -99;
        this.f77420g = -99;
        this.f77421h = -99;
        this.f77422i = -99;
        this.f77423j = -99;
        this.f77424k = -99;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i3, int i16, int i17, boolean z16, int i18, int i19, int i26, int i27, int i28, int i29) {
        int i36 = this.f77424k;
        long j3 = i36;
        if (i3 <= -99) {
            this.f77424k = 0;
        } else {
            this.f77424k = i36 + 1;
        }
        if (this.f77414a != i3 || this.f77415b != i16 || this.f77416c != i17 || this.f77417d != z16 || this.f77418e != i18 || this.f77419f != i19 || this.f77420g != i26 || this.f77421h != i27 || this.f77422i != i28 || this.f77423j != i29) {
            AVCoreLog.printAllUserLog("PreviewCallbackInfo", "PREVIEW_CALLBACK, Index[" + j3 + "->" + this.f77424k + "], degree[" + this.f77414a + "->" + i3 + "], mCurCamera[" + this.f77415b + "->" + i16 + "], nInFPS[" + this.f77416c + "->" + i17 + "], mSupportLandscape[" + this.f77417d + "->" + z16 + "], cameraImageOrientation[" + this.f77418e + "->" + i18 + "], displayRotation[" + this.f77419f + "->" + i19 + "], mobileRotation[" + this.f77420g + "->" + i26 + "], dataLength[" + this.f77421h + "->" + i27 + "], w[" + this.f77422i + "->" + i28 + "], h[" + this.f77423j + "->" + i29 + "]");
        }
        this.f77414a = i3;
        this.f77415b = i16;
        this.f77416c = i17;
        this.f77417d = z16;
        this.f77418e = i18;
        this.f77419f = i19;
        this.f77420g = i26;
        this.f77421h = i27;
        this.f77422i = i28;
        this.f77423j = i29;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a(-100, this.f77415b, this.f77416c, this.f77417d, -100, -100, -100, -100, -100, -100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        a(-101, this.f77415b, this.f77416c, this.f77417d, -101, -101, -101, -101, -101, -101);
    }
}
