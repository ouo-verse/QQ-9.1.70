package com.tencent.mobileqq.fragment.blacklist.proto;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$PagedFetchReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$PagedFetchRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    UserDisplayManager.a f211321a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.blacklist.proto.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7629a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f211322d;

        C7629a(c cVar) {
            this.f211322d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) cVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                RelationBlacklist$PagedFetchRsp relationBlacklist$PagedFetchRsp = new RelationBlacklist$PagedFetchRsp();
                try {
                    relationBlacklist$PagedFetchRsp.mergeFrom(bArr);
                    if (relationBlacklist$PagedFetchRsp.code.has() && relationBlacklist$PagedFetchRsp.code.get() != 0) {
                        c cVar = this.f211322d;
                        if (cVar != null) {
                            cVar.b(a.this.f211321a);
                        }
                        a.this.f211321a = new UserDisplayManager.a();
                        QLog.e("UserDataFetchUtil", 1, "fetchBlackList fail code:" + relationBlacklist$PagedFetchRsp.code.get() + " msg:" + relationBlacklist$PagedFetchRsp.f436006msg.get());
                        return;
                    }
                    c cVar2 = this.f211322d;
                    if (cVar2 != null && relationBlacklist$PagedFetchRsp.seq != null && relationBlacklist$PagedFetchRsp.items != null) {
                        QLog.d("UserDataFetchUtil", 2, "GetSeq\nSeq = " + relationBlacklist$PagedFetchRsp.seq.get() + ",\nitemcount = " + relationBlacklist$PagedFetchRsp.items.get().size() + ",\nnext_start = " + relationBlacklist$PagedFetchRsp.next_start.get() + ",\nis_over = " + relationBlacklist$PagedFetchRsp.is_over.get() + ",\ncode = " + relationBlacklist$PagedFetchRsp.code.get());
                        this.f211322d.a(relationBlacklist$PagedFetchRsp.seq.get(), relationBlacklist$PagedFetchRsp.items.get().size());
                        return;
                    }
                    if (cVar2 != null) {
                        cVar2.a(0L, 0);
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("UserDataFetchUtil", 1, "mergeBlackSeqFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "getBlackSeqFromNet, server error:" + i3);
            }
            c cVar3 = this.f211322d;
            if (cVar3 != null) {
                cVar3.a(0L, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f211324d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f211325e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f211326f;

        b(c cVar, AppRuntime appRuntime, int i3) {
            this.f211324d = cVar;
            this.f211325e = appRuntime;
            this.f211326f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, cVar, appRuntime, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                RelationBlacklist$PagedFetchRsp relationBlacklist$PagedFetchRsp = new RelationBlacklist$PagedFetchRsp();
                try {
                    relationBlacklist$PagedFetchRsp.mergeFrom(bArr);
                    if (relationBlacklist$PagedFetchRsp.code.has() && relationBlacklist$PagedFetchRsp.code.get() != 0) {
                        c cVar2 = this.f211324d;
                        if (cVar2 != null) {
                            cVar2.b(a.this.f211321a);
                        }
                        a.this.f211321a = new UserDisplayManager.a();
                        QLog.e("UserDataFetchUtil", 1, "fetchBlackList fail code:" + relationBlacklist$PagedFetchRsp.code.get() + " msg:" + relationBlacklist$PagedFetchRsp.f436006msg.get());
                        return;
                    }
                    QLog.d("UserDataFetchUtil", 2, "GetData\nSeq = " + relationBlacklist$PagedFetchRsp.seq.get() + ",\nitemcount = " + relationBlacklist$PagedFetchRsp.items.get().size() + ",\nnext_start = " + relationBlacklist$PagedFetchRsp.next_start.get() + ",\nis_over = " + relationBlacklist$PagedFetchRsp.is_over.get() + ",\ncode = " + relationBlacklist$PagedFetchRsp.code.get());
                    a.this.f211321a.a(relationBlacklist$PagedFetchRsp.seq.get(), relationBlacklist$PagedFetchRsp.items.get());
                    if (relationBlacklist$PagedFetchRsp.is_over.get() && (cVar = this.f211324d) != null) {
                        cVar.b(a.this.f211321a);
                        a.this.f211321a = new UserDisplayManager.a();
                        return;
                    } else {
                        if (!relationBlacklist$PagedFetchRsp.is_over.get()) {
                            a.this.a(this.f211325e, relationBlacklist$PagedFetchRsp.seq.get(), relationBlacklist$PagedFetchRsp.next_start.get(), this.f211326f, this.f211324d);
                            return;
                        }
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("UserDataFetchUtil", 1, "mergeBlackDataFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "getBlackDataFromNet, server error:" + i3);
            }
            c cVar3 = this.f211324d;
            if (cVar3 != null) {
                cVar3.b(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a(long j3, int i3);

        void b(UserDisplayManager.a aVar);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211321a = new UserDisplayManager.a();
        }
    }

    public void a(AppRuntime appRuntime, long j3, long j16, int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), cVar);
            return;
        }
        RelationBlacklist$PagedFetchReq relationBlacklist$PagedFetchReq = new RelationBlacklist$PagedFetchReq();
        relationBlacklist$PagedFetchReq.seq.set(j3);
        relationBlacklist$PagedFetchReq.start.set(j16);
        relationBlacklist$PagedFetchReq.num.set(i3);
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "app is null");
                return;
            }
            return;
        }
        ProtoUtils.a(appRuntime, new b(cVar, appRuntime, i3), relationBlacklist$PagedFetchReq.toByteArray(), "OidbSvcTrpcTcp.0x1225_0", g.R1, 0);
    }

    public void b(AppRuntime appRuntime, long j3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, Long.valueOf(j3), cVar);
            return;
        }
        RelationBlacklist$PagedFetchReq relationBlacklist$PagedFetchReq = new RelationBlacklist$PagedFetchReq();
        relationBlacklist$PagedFetchReq.seq.set(j3);
        relationBlacklist$PagedFetchReq.start.set(0L);
        relationBlacklist$PagedFetchReq.num.set(1L);
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "app is null");
                return;
            }
            return;
        }
        ProtoUtils.a(appRuntime, new C7629a(cVar), relationBlacklist$PagedFetchReq.toByteArray(), "OidbSvcTrpcTcp.0x1225_0", g.R1, 0);
    }
}
