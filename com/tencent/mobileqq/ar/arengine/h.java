package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends ab {

    /* renamed from: b, reason: collision with root package name */
    public int f198191b;

    /* renamed from: c, reason: collision with root package name */
    public String f198192c;

    /* renamed from: d, reason: collision with root package name */
    public String f198193d;

    /* renamed from: e, reason: collision with root package name */
    public int f198194e;

    /* renamed from: f, reason: collision with root package name */
    public String f198195f;

    /* renamed from: g, reason: collision with root package name */
    public int f198196g;

    /* renamed from: h, reason: collision with root package name */
    public float f198197h;

    public h() {
        this.f197989a = 64L;
    }

    public static boolean b(h hVar) {
        boolean z16;
        if (hVar != null && hVar.c() && hVar.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARCloudPreOcrResult", 2, "isRecogSuccess result = " + z16);
        }
        return z16;
    }

    public boolean a() {
        if (this.f198196g == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f198191b == 0 && this.f198194e == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ab
    public String toString() {
        return "ARCloudPreOcrResult{recogType = " + this.f197989a + ", recogSvrRetCode = " + this.f198191b + ", recogSvrRetMsg = " + this.f198192c + ", sessionId = " + this.f198193d + ", arWordDetectRetCode = " + this.f198194e + ", arWordDetectRetMsg = " + this.f198195f + ", wordType = " + this.f198196g + ", confidence = " + this.f198197h + '}';
    }
}
