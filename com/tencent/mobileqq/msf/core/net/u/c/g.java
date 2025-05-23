package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.net.DatagramPacket;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f249460b = "UdpRequest";

    /* renamed from: c, reason: collision with root package name */
    public static final int f249461c = 65528;

    /* renamed from: a, reason: collision with root package name */
    private final DatagramPacket f249462a;

    public g(DatagramPacket datagramPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) datagramPacket);
        } else {
            this.f249462a = datagramPacket;
        }
    }

    public DatagramPacket a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DatagramPacket) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f249462a;
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private byte[] f249463a;

        /* renamed from: b, reason: collision with root package name */
        private int f249464b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public a a(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            if (bArr != null && bArr.length <= 65528) {
                this.f249463a = bArr;
                return this;
            }
            throw new IllegalArgumentException("data invalid: " + Arrays.toString(bArr));
        }

        public a a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 >= 0 && i3 <= 65528) {
                this.f249464b = i3;
                return this;
            }
            throw new IllegalArgumentException("length invalid: " + i3);
        }

        public g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (g) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (this.f249463a == null || this.f249464b == 0) {
                QLog.d(g.f249460b, 1, "[create] create empty udp packet.");
            }
            return new g(new DatagramPacket(this.f249463a, this.f249464b));
        }
    }
}
