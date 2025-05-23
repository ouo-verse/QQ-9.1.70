package com.tencent.imcore.message.msgproxy;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.ah;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    f f116700b;

    @Metadata
    public d(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> A(String str, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (List) iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        return this.f116700b.A(str, i3, i16, z16);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord A0(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 68, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
        }
        return this.f116700b.A0(str, i3, j3, str2);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> B(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return this.f116700b.B(str, i3, j3, i16);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord B0(String str, int i3, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 69, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        }
        return this.f116700b.B0(str, i3, j3, bArr);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord C0(String str, int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 66, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        return this.f116700b.C0(str, i3, j3, i16, i17);
    }

    @Override // com.tencent.imcore.message.f
    public EntityManager D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f116700b.D();
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord D0(String str, int i3, long j3, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 67, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, obj);
        }
        return this.f116700b.D0(str, i3, j3, str2, obj);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord E(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3);
        }
        return this.f116700b.E(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord E0(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 71, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        return this.f116700b.E0(str, i3, j3, j16, j17);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord F(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.f116700b.F(str, i3, i16);
    }

    @Override // com.tencent.imcore.message.f
    public void F0(String str, int i3, long j3, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, str, Integer.valueOf(i3), Long.valueOf(j3), contentValues);
        } else {
            this.f116700b.F0(str, i3, j3, contentValues);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord G(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 45, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return this.f116700b.G(str, i3, j3, i16);
    }

    @Override // com.tencent.imcore.message.f
    public void G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this);
        } else {
            this.f116700b.G0();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord H(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.H(str, i3, j3);
    }

    public f H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f116700b;
    }

    public void I0(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        } else {
            this.f116700b = fVar;
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord K(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 99, this, str, Integer.valueOf(i3), messageRecord);
        }
        return this.f116700b.K(str, i3, messageRecord);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord L(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 89, this, str, Integer.valueOf(i3), messageRecord, list);
        }
        return this.f116700b.L(str, i3, messageRecord, list);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> M(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (List) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, i3);
        }
        return this.f116700b.M(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public void N(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, str, Integer.valueOf(i3), messageRecord);
        } else {
            this.f116700b.N(str, i3, messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.f
    public Cursor O(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cursor) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        return this.f116700b.O(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public void P(ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) ahVar);
        } else {
            this.f116700b.P(ahVar);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Q(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (List) iPatchRedirector.redirect((short) 102, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return this.f116700b.R(str, i3, j3, i16, true);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> R(String str, int i3, long j3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (List) iPatchRedirector.redirect((short) 103, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        return this.f116700b.R(str, i3, j3, i16, z16);
    }

    @Override // com.tencent.imcore.message.f
    public Message S(String str, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Message) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) entityManager);
        }
        return this.f116700b.S(str, entityManager);
    }

    @Override // com.tencent.imcore.message.f
    public Message T(String str, EntityManager entityManager, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Message) iPatchRedirector.redirect((short) 35, this, str, entityManager, Integer.valueOf(i3));
        }
        return this.f116700b.T(str, entityManager, i3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord U(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 85, this, str, Integer.valueOf(i3), str2);
        }
        return this.f116700b.U(str, i3, str2);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> V(String str, int i3, long j3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return (List) iPatchRedirector.redirect((short) 90, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        return this.f116700b.V(str, i3, j3, i16, str2);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> W(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (List) iPatchRedirector.redirect((short) 75, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return this.f116700b.W(str, i3, j3, j16);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> X(String str, int i3, long j3, long j16, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (List) iPatchRedirector.redirect((short) 76, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        return this.f116700b.X(str, i3, j3, j16, i16, z16);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Y(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (List) iPatchRedirector.redirect((short) 88, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        return this.f116700b.Y(str, i3, j3, i16, j16, i17, iArr);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Z(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (List) iPatchRedirector.redirect((short) 87, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        return this.f116700b.Z(str, i3, j3, i16, j16, i17, iArr);
    }

    @Override // com.tencent.imcore.message.f
    public void a(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, str, Integer.valueOf(i3), list);
        } else {
            this.f116700b.a(str, i3, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> a0(String str, int i3, String str2, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return (List) iPatchRedirector.redirect((short) 112, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17));
        }
        return this.f116700b.a0(str, i3, str2, i16, i17);
    }

    @Override // com.tencent.imcore.message.f
    public void b(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, str, Integer.valueOf(i3), list);
        } else {
            this.f116700b.b(str, i3, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> b0(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return (List) iPatchRedirector.redirect((short) 111, this, str, str2, Integer.valueOf(i3));
        }
        return this.f116700b.b0(str, str2, i3);
    }

    @Override // com.tencent.imcore.message.f
    public void c(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, str, Integer.valueOf(i3), messageRecord, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else {
            this.f116700b.c(str, i3, messageRecord, proxyListener, z16, z17, z18);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> c0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (List) iPatchRedirector.redirect((short) 78, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return this.f116700b.c0(str, i3, j3, j16);
    }

    @Override // com.tencent.imcore.message.f
    public void d(List<MessageRecord> list, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) list, (Object) proxyListener);
        } else {
            this.f116700b.d(list, proxyListener);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> d0(String str, int i3, long j3, long j16, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (List) iPatchRedirector.redirect((short) 79, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), iArr);
        }
        return this.f116700b.d0(str, i3, j3, j16, iArr);
    }

    @Override // com.tencent.imcore.message.f, com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this);
        } else {
            this.f116700b.destroy();
        }
    }

    @Override // com.tencent.imcore.message.f
    public void e(String str, int i3, long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Long.valueOf(j3), list);
        } else {
            this.f116700b.e(str, i3, j3, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord e0(String str, int i3, long j3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 91, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, str3);
        }
        return this.f116700b.e0(str, i3, j3, str2, str3);
    }

    @Override // com.tencent.imcore.message.f
    public void f(String str, int i3, long j3, long j16, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), list);
        } else {
            this.f116700b.f(str, i3, j3, j16, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord f0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.f0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void g(String str, int i3, long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, Integer.valueOf(i3), Long.valueOf(j3), list);
        } else {
            this.f116700b.g(str, i3, j3, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> g0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return this.f116700b.g0(str, i3, j3, j16);
    }

    @Override // com.tencent.imcore.message.f
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
        } else {
            this.f116700b.h();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord h0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.h0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
        } else {
            this.f116700b.i();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> i0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return this.f116700b.i0(str, i3, j3, j16);
    }

    @Override // com.tencent.imcore.message.f, com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this);
        } else {
            this.f116700b.init();
        }
    }

    @Override // com.tencent.imcore.message.f
    public int j(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        return this.f116700b.j(str, i3, z16);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord j0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.j0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void k(String str, int i3, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16));
        } else {
            this.f116700b.k(str, i3, str2, str3, i16);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> k0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (List) iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), list);
        }
        return this.f116700b.k0(str, i3, list);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> l(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        }
        return this.f116700b.l(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> l0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            return (List) iPatchRedirector.redirect((short) 108, this, str, Integer.valueOf(i3), list);
        }
        return this.f116700b.l0(str, i3, list);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> m(String str, int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), iArr);
        }
        return this.f116700b.m(str, i3, iArr);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> m0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return (List) iPatchRedirector.redirect((short) 107, this, str, Integer.valueOf(i3), list);
        }
        return this.f116700b.m0(str, i3, list);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> n(String str, int i3, int i16, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Integer.valueOf(i16), iArr);
        }
        return this.f116700b.n(str, i3, i16, iArr);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord n0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 86, (Object) this, (Object) str, i3);
        }
        return this.f116700b.n0(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> o(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
        return this.f116700b.o(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> o0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (List) iPatchRedirector.redirect((short) 77, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return this.f116700b.o0(str, i3, j3, j16);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> p(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
        return this.f116700b.p(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> p0(String str, int i3, long j3, @NonNull Map<String, MessageRecord> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (List) iPatchRedirector.redirect((short) 83, this, str, Integer.valueOf(i3), Long.valueOf(j3), map);
        }
        return this.f116700b.p0(str, i3, j3, map);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> q(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.f116700b.q(str, i3, i16);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> q0(String str, int i3, long j3, int i16, long j16, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (List) iPatchRedirector.redirect((short) 84, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), str2);
        }
        return this.f116700b.q0(str, i3, j3, i16, j16, i17, str2);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> r(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        return this.f116700b.r(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public int r0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        return this.f116700b.r0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f116700b.s();
        }
    }

    @Override // com.tencent.imcore.message.f
    public int s0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Integer) iPatchRedirector.redirect((short) 62, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        return this.f116700b.s0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void t(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            this.f116700b.t(i3, str);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord t0(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 73, this, messageRecord, Boolean.valueOf(z16));
        }
        return this.f116700b.t0(messageRecord, z16);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return (String) iPatchRedirector.redirect((short) 115, (Object) this);
        }
        return getClass().toString() + "{mBase=" + this.f116700b + '}';
    }

    @Override // com.tencent.imcore.message.f
    public int u(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, this, messageRecord, Boolean.valueOf(z16))).intValue();
        }
        return this.f116700b.u(messageRecord, z16);
    }

    @Override // com.tencent.imcore.message.f
    public void u0(String str, int i3, MessageRecord messageRecord, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, str, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16));
        } else {
            this.f116700b.u0(str, i3, messageRecord, i16);
        }
    }

    @Override // com.tencent.imcore.message.f
    public int v(List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Integer) iPatchRedirector.redirect((short) 61, this, list, Boolean.valueOf(z16))).intValue();
        }
        return this.f116700b.v(list, z16);
    }

    @Override // com.tencent.imcore.message.f
    public void v0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f116700b.v0(str, i3, j3);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord w(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 42, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.w(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public void w0(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, str, Integer.valueOf(i3), messageRecord);
        } else {
            this.f116700b.w0(str, i3, messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord x(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 43, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return this.f116700b.x(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord x0(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 72, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        }
        return this.f116700b.x0(str, i3, j3, j16, str2);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord y(List<MessageRecord> list, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 100, (Object) this, (Object) list, (Object) messageRecord);
        }
        return this.f116700b.y(list, messageRecord);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord y0(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 59, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        return this.f116700b.y0(str, i3, j3, j16, j17);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> z(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, i3);
        }
        return this.f116700b.z(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord z0(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 74, (Object) this, (Object) messageRecord, i3);
        }
        return this.f116700b.z0(messageRecord, i3);
    }
}
