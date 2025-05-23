package com.tencent.qav;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f342343a;

    /* renamed from: b, reason: collision with root package name */
    public int f342344b;

    /* renamed from: c, reason: collision with root package name */
    public int f342345c;

    /* renamed from: d, reason: collision with root package name */
    public long f342346d;

    /* renamed from: e, reason: collision with root package name */
    public long f342347e;

    /* renamed from: f, reason: collision with root package name */
    public String f342348f;

    /* renamed from: g, reason: collision with root package name */
    public int f342349g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f342350h;

    /* renamed from: i, reason: collision with root package name */
    public int f342351i;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MultiParams{mRelationType=" + this.f342343a + ", mMultiAVType=" + this.f342344b + ", mMultiAVSubType=" + this.f342345c + ", mRoomId=" + this.f342346d + ", mUin=" + this.f342347e + ", mOpenId='" + this.f342348f + "', mSourceId=" + this.f342349g + ", mSig=" + Arrays.toString(this.f342350h) + ", mSvrRecogFlag=" + this.f342351i + '}';
    }
}
