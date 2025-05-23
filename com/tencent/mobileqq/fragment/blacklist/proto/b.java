package com.tencent.mobileqq.fragment.blacklist.proto;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$PagedFetchBlockListReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$PagedFetchBlockListRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    ShieldUserDisplayManager.a f211328a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f211329d;

        a(d dVar) {
            this.f211329d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dVar);
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
                RelationBlacklist$PagedFetchBlockListRsp relationBlacklist$PagedFetchBlockListRsp = new RelationBlacklist$PagedFetchBlockListRsp();
                try {
                    relationBlacklist$PagedFetchBlockListRsp.mergeFrom(bArr);
                    d dVar = this.f211329d;
                    if (dVar == null) {
                        return;
                    }
                    if (relationBlacklist$PagedFetchBlockListRsp.seq != null && relationBlacklist$PagedFetchBlockListRsp.items != null) {
                        QLog.d("UserDataFetchUtil", 2, "GetSeq\nSeq = " + relationBlacklist$PagedFetchBlockListRsp.seq.get() + ",\nitemcount = " + relationBlacklist$PagedFetchBlockListRsp.items.get().size() + ",\nnext_start = " + relationBlacklist$PagedFetchBlockListRsp.next_start.get() + ",\nis_over = " + relationBlacklist$PagedFetchBlockListRsp.is_over.get());
                        this.f211329d.a(relationBlacklist$PagedFetchBlockListRsp.seq.get(), relationBlacklist$PagedFetchBlockListRsp.items.get().size());
                        return;
                    }
                    dVar.a(0L, -1);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("UserDataFetchUtil", 1, "mergeShieldSeqFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "getShieldSeqFromNet, server error:" + i3);
            }
            d dVar2 = this.f211329d;
            if (dVar2 != null) {
                dVar2.a(0L, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.blacklist.proto.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7630b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f211331d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f211332e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f211333f;

        C7630b(d dVar, AppRuntime appRuntime, int i3) {
            this.f211331d = dVar;
            this.f211332e = appRuntime;
            this.f211333f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, dVar, appRuntime, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                RelationBlacklist$PagedFetchBlockListRsp relationBlacklist$PagedFetchBlockListRsp = new RelationBlacklist$PagedFetchBlockListRsp();
                try {
                    relationBlacklist$PagedFetchBlockListRsp.mergeFrom(bArr);
                    QLog.d("UserDataFetchUtil", 2, "GetData\nSeq = " + relationBlacklist$PagedFetchBlockListRsp.seq.get() + ",\nitemcount = " + relationBlacklist$PagedFetchBlockListRsp.items.get().size() + ",\nnext_start = " + relationBlacklist$PagedFetchBlockListRsp.next_start.get() + ",\nis_over = " + relationBlacklist$PagedFetchBlockListRsp.is_over.get());
                    b.this.f211328a.a(relationBlacklist$PagedFetchBlockListRsp.seq.get(), relationBlacklist$PagedFetchBlockListRsp.items.get());
                    if (relationBlacklist$PagedFetchBlockListRsp.is_over.get() && (dVar = this.f211331d) != null) {
                        dVar.b(b.this.f211328a);
                        b.this.f211328a = new ShieldUserDisplayManager.a();
                        return;
                    } else {
                        if (!relationBlacklist$PagedFetchBlockListRsp.is_over.get()) {
                            b.this.b(this.f211332e, relationBlacklist$PagedFetchBlockListRsp.seq.get(), relationBlacklist$PagedFetchBlockListRsp.next_start.get(), this.f211333f, this.f211331d);
                            return;
                        }
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("UserDataFetchUtil", 1, "mergeShieldDataFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "getShieldDataFromNet, server error:" + i3);
            }
            d dVar2 = this.f211331d;
            if (dVar2 != null) {
                dVar2.b(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f211335d;

        c(d dVar) {
            this.f211335d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                RelationBlacklist$CountBlockListRsp relationBlacklist$CountBlockListRsp = new RelationBlacklist$CountBlockListRsp();
                try {
                    relationBlacklist$CountBlockListRsp.mergeFrom(bArr);
                    PBUInt64Field pBUInt64Field = relationBlacklist$CountBlockListRsp.count;
                    if (pBUInt64Field != null && (dVar = this.f211335d) != null) {
                        dVar.a(0L, new Long(pBUInt64Field.get()).intValue());
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("UserDataFetchUtil", 1, "mergeShieldCountFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "getShieldCountFromNet, server error:" + i3);
            }
            d dVar2 = this.f211335d;
            if (dVar2 != null) {
                dVar2.a(0L, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void a(long j3, int i3);

        void b(ShieldUserDisplayManager.a aVar);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211328a = new ShieldUserDisplayManager.a();
        }
    }

    public void a(AppRuntime appRuntime, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) dVar);
            return;
        }
        RelationBlacklist$CountBlockListReq relationBlacklist$CountBlockListReq = new RelationBlacklist$CountBlockListReq();
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "app is null");
                return;
            }
            return;
        }
        ProtoUtils.a(appRuntime, new c(dVar), relationBlacklist$CountBlockListReq.toByteArray(), "OidbSvcTrpcTcp.0x122d_0", 4653, 0);
    }

    public void b(AppRuntime appRuntime, long j3, long j16, int i3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), dVar);
            return;
        }
        RelationBlacklist$PagedFetchBlockListReq relationBlacklist$PagedFetchBlockListReq = new RelationBlacklist$PagedFetchBlockListReq();
        relationBlacklist$PagedFetchBlockListReq.seq.set(j3);
        relationBlacklist$PagedFetchBlockListReq.start.set(j16);
        relationBlacklist$PagedFetchBlockListReq.num.set(i3);
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "app is null");
                return;
            }
            return;
        }
        ProtoUtils.a(appRuntime, new C7630b(dVar, appRuntime, i3), relationBlacklist$PagedFetchBlockListReq.toByteArray(), "OidbSvcTrpcTcp.0x122f_0", 4655, 0);
    }

    public void c(AppRuntime appRuntime, long j3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, Long.valueOf(j3), dVar);
            return;
        }
        RelationBlacklist$PagedFetchBlockListReq relationBlacklist$PagedFetchBlockListReq = new RelationBlacklist$PagedFetchBlockListReq();
        relationBlacklist$PagedFetchBlockListReq.seq.set(j3);
        relationBlacklist$PagedFetchBlockListReq.start.set(0L);
        relationBlacklist$PagedFetchBlockListReq.num.set(1L);
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("UserDataFetchUtil", 2, "app is null");
                return;
            }
            return;
        }
        ProtoUtils.a(appRuntime, new a(dVar), relationBlacklist$PagedFetchBlockListReq.toByteArray(), "OidbSvcTrpcTcp.0x122f_0", 4655, 0);
    }
}
