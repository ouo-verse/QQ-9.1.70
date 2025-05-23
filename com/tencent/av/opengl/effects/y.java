package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    int f74054a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f74055b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f74056c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f74057d = 0;

    /* renamed from: e, reason: collision with root package name */
    long f74058e = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f74059f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i3, int i16, int i17, int i18, long j3, boolean z16, long j16) {
        boolean z17;
        int i19;
        int i26;
        if (bArr == null || (i19 = this.f74054a) == 0 || (i26 = this.f74055b) == 0 || i19 != i3 || i26 != i16 || this.f74056c != i17 || this.f74057d != i18 || this.f74058e != j3 || this.f74059f != z16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onProcessFrame, data[");
                if (bArr != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append("], frameIndex[");
                sb5.append(j16);
                sb5.append("], width[");
                sb5.append(this.f74054a);
                sb5.append("->");
                sb5.append(i3);
                sb5.append("], height[");
                sb5.append(this.f74055b);
                sb5.append("->");
                sb5.append(i16);
                sb5.append("], format[");
                sb5.append(this.f74056c);
                sb5.append("->");
                sb5.append(i17);
                sb5.append("], angle[");
                sb5.append(this.f74057d);
                sb5.append("->");
                sb5.append(i18);
                sb5.append("], FPS[");
                sb5.append(this.f74058e);
                sb5.append("->");
                sb5.append(j3);
                sb5.append("], isFront[");
                sb5.append(this.f74059f);
                sb5.append("->");
                sb5.append(z16);
                sb5.append("]");
                QLog.d("ProcessFrameInfo", 1, sb5.toString());
            }
            this.f74054a = i3;
            this.f74055b = i16;
            this.f74056c = i17;
            this.f74057d = i18;
            this.f74058e = j3;
            this.f74059f = z16;
        }
    }
}
