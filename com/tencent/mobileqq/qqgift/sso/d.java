package com.tencent.mobileqq.qqgift.sso;

import android.os.Bundle;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f264988a;

    /* renamed from: b, reason: collision with root package name */
    private FromServiceMsg f264989b;

    /* renamed from: c, reason: collision with root package name */
    private int f264990c;

    /* renamed from: d, reason: collision with root package name */
    private String f264991d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f264992e;

    /* renamed from: f, reason: collision with root package name */
    private int f264993f;

    /* renamed from: g, reason: collision with root package name */
    private int f264994g;

    /* renamed from: h, reason: collision with root package name */
    private int f264995h;

    /* renamed from: i, reason: collision with root package name */
    private String f264996i;

    /* renamed from: j, reason: collision with root package name */
    private String f264997j;

    /* renamed from: k, reason: collision with root package name */
    private long f264998k;

    /* renamed from: l, reason: collision with root package name */
    private Bundle f264999l;

    public d(int i3, FromServiceMsg fromServiceMsg, byte[] bArr, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), fromServiceMsg, bArr, str, Long.valueOf(j3));
            return;
        }
        this.f264988a = i3;
        this.f264989b = fromServiceMsg;
        this.f264997j = str;
        this.f264998k = j3;
        try {
            en0.c c16 = en0.c.c(bArr);
            this.f264990c = c16.f396860a;
            this.f264991d = c16.f396861b;
            this.f264992e = c16.f396862c;
            this.f264993f = c16.f396863d;
            this.f264994g = c16.f396864e;
            this.f264995h = c16.f396865f;
            this.f264996i = c16.f396866g;
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveRspData", 2, "QQLiveRspData ProxyRsp:" + c16);
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("QQLiveRspData", 1, "QQLiveRspData throw exception:" + e16.getMessage());
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f264995h;
    }

    public byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f264992e;
    }

    public void c(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle);
        } else {
            this.f264999l = bundle;
        }
    }
}
