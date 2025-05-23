package com.tencent.imcore.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxy;
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
public abstract class f extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected MsgPool f116628a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void A(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime);

        void a(y yVar, AppRuntime appRuntime);

        void b(AppRuntime appRuntime, String str, int i3);

        List<MessageRecord> c(String str, String[] strArr, f fVar);

        void d(String str, int i3, String str2, List<MessageRecord> list, long j3, y yVar);

        void e(String str, int i3, boolean z16, y yVar, AppRuntime appRuntime);

        void f(String str, int i3, List<MessageRecord> list);

        List<MessageRecord> g(String str, int i3, long j3, int i16, String str2, String[] strArr, y yVar, AppRuntime appRuntime);

        EntityManager h(AppRuntime appRuntime);

        SQLiteDatabase i(AppRuntime appRuntime);

        void j(AppRuntime appRuntime);

        void k(String str, MessageRecord messageRecord, List<MessageRecord> list, f fVar);

        boolean l(MessageRecord messageRecord);

        void m(String str, int i3, List<MessageRecord> list);

        Object n(AppRuntime appRuntime);

        boolean o(String str, int i3, String str2, y yVar);

        boolean p(AppRuntime appRuntime, MessageRecord messageRecord);

        void q(AppRuntime appRuntime, EntityManager entityManager, ah ahVar);

        SQLiteDatabase r(AppRuntime appRuntime);

        void s(String str, int i3, long j3, long j16, MessageRecord messageRecord, AppRuntime appRuntime);

        void t(List<MessageRecord> list, MessageRecord messageRecord, boolean z16);

        int u(String str, int i3, long j3, int i16, AppRuntime appRuntime);

        void v(MessageRecord messageRecord);

        void w(List<MessageRecord> list, y yVar);

        Pair<Long, Long> x(String str, AppRuntime appRuntime);

        void y(String str, int i3, long j3, AppRuntime appRuntime);

        void z(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime);
    }

    @Metadata
    public f(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
        } else {
            this.f116628a = msgPool;
        }
    }

    public abstract List<MessageRecord> A(String str, int i3, int i16, boolean z16);

    public abstract MessageRecord A0(String str, int i3, long j3, String str2);

    public abstract List<MessageRecord> B(String str, int i3, long j3, int i16);

    public abstract MessageRecord B0(String str, int i3, long j3, byte[] bArr);

    public AppRuntime C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.app;
    }

    public abstract MessageRecord C0(String str, int i3, long j3, int i16, int i17);

    public abstract EntityManager D();

    public abstract MessageRecord D0(String str, int i3, long j3, String str2, Object obj);

    public abstract MessageRecord E(String str, int i3);

    public abstract MessageRecord E0(String str, int i3, long j3, long j16, long j17);

    public abstract MessageRecord F(String str, int i3, int i16);

    public abstract void F0(String str, int i3, long j3, ContentValues contentValues);

    public abstract MessageRecord G(String str, int i3, long j3, int i16);

    public abstract void G0();

    public abstract MessageRecord H(String str, int i3, long j3);

    public MsgPool I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgPool) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116628a;
    }

    public BaseProxyManager J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseProxyManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.proxyManager;
    }

    public abstract MessageRecord K(String str, int i3, MessageRecord messageRecord);

    public abstract MessageRecord L(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list);

    public abstract List<MessageRecord> M(String str, int i3);

    public abstract void N(String str, int i3, MessageRecord messageRecord);

    @Deprecated
    public abstract Cursor O(String str, int i3);

    public abstract void P(ah ahVar);

    public abstract List<MessageRecord> Q(String str, int i3, long j3, int i16);

    public abstract List<MessageRecord> R(String str, int i3, long j3, int i16, boolean z16);

    public abstract Message S(String str, EntityManager entityManager);

    public abstract Message T(String str, EntityManager entityManager, int i3);

    public abstract MessageRecord U(String str, int i3, String str2);

    public abstract List<MessageRecord> V(String str, int i3, long j3, int i16, String str2);

    public abstract List<MessageRecord> W(String str, int i3, long j3, long j16);

    public abstract List<MessageRecord> X(String str, int i3, long j3, long j16, int i16, boolean z16);

    public abstract List<MessageRecord> Y(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr);

    public abstract List<MessageRecord> Z(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr);

    public abstract void a(String str, int i3, List<MessageRecord> list);

    public abstract List<MessageRecord> a0(String str, int i3, String str2, int i16, int i17);

    public abstract void b(String str, int i3, List<MessageRecord> list);

    public abstract List<MessageRecord> b0(String str, String str2, int i3);

    public abstract void c(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17, boolean z18);

    public abstract List<MessageRecord> c0(String str, int i3, long j3, long j16);

    public abstract void d(List<MessageRecord> list, ProxyListener proxyListener);

    public abstract List<MessageRecord> d0(String str, int i3, long j3, long j16, int[] iArr);

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public abstract void destroy();

    public abstract void e(String str, int i3, long j3, List<MessageRecord> list);

    public abstract MessageRecord e0(String str, int i3, long j3, String str2, String str3);

    public abstract void f(String str, int i3, long j3, long j16, List<MessageRecord> list);

    public abstract MessageRecord f0(String str, int i3, long j3);

    public abstract void g(String str, int i3, long j3, List<MessageRecord> list);

    public abstract List<MessageRecord> g0(String str, int i3, long j3, long j16);

    public abstract void h();

    public abstract MessageRecord h0(String str, int i3, long j3);

    public abstract void i();

    public abstract List<MessageRecord> i0(String str, int i3, long j3, long j16);

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public abstract void init();

    public abstract int j(String str, int i3, boolean z16);

    public abstract MessageRecord j0(String str, int i3, long j3);

    public abstract void k(String str, int i3, String str2, String str3, int i16);

    public abstract List<MessageRecord> k0(String str, int i3, List<Long> list);

    public abstract List<MessageRecord> l(String str, int i3);

    public abstract List<MessageRecord> l0(String str, int i3, List<Long> list);

    public abstract List<MessageRecord> m(String str, int i3, int[] iArr);

    public abstract List<MessageRecord> m0(String str, int i3, List<Long> list);

    public abstract List<MessageRecord> n(String str, int i3, int i16, int[] iArr);

    public MessageRecord n0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        return null;
    }

    public abstract List<MessageRecord> o(String str, int i3);

    public abstract List<MessageRecord> o0(String str, int i3, long j3, long j16);

    public abstract List<MessageRecord> p(String str, int i3);

    public abstract List<MessageRecord> p0(String str, int i3, long j3, @NonNull Map<String, MessageRecord> map);

    public abstract List<MessageRecord> q(String str, int i3, int i16);

    public abstract List<MessageRecord> q0(String str, int i3, long j3, int i16, long j16, int i17, String str2);

    public abstract List<MessageRecord> r(String str, int i3);

    public abstract int r0(String str, int i3, long j3);

    public abstract void s();

    public abstract int s0(String str, int i3, long j3);

    public abstract void t(int i3, String str);

    public abstract MessageRecord t0(MessageRecord messageRecord, boolean z16);

    public abstract int u(MessageRecord messageRecord, boolean z16);

    public abstract void u0(String str, int i3, MessageRecord messageRecord, int i16);

    public abstract int v(List<MessageRecord> list, boolean z16);

    public abstract void v0(String str, int i3, long j3);

    public abstract MessageRecord w(String str, int i3, long j3);

    public abstract void w0(String str, int i3, MessageRecord messageRecord);

    public abstract MessageRecord x(String str, int i3, long j3);

    public abstract MessageRecord x0(String str, int i3, long j3, long j16, String str2);

    public abstract MessageRecord y(List<MessageRecord> list, MessageRecord messageRecord);

    public abstract MessageRecord y0(String str, int i3, long j3, long j16, long j17);

    public abstract List<MessageRecord> z(String str, int i3);

    public abstract MessageRecord z0(MessageRecord messageRecord, int i3);
}
