package com.tencent.mobileqq.troopcheckin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.troopcheckin.a f302713a;

    /* renamed from: b, reason: collision with root package name */
    public String f302714b;

    /* renamed from: c, reason: collision with root package name */
    int f302715c;

    /* renamed from: d, reason: collision with root package name */
    protected String f302716d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f302717e;

    /* renamed from: f, reason: collision with root package name */
    protected Transaction f302718f;

    /* renamed from: g, reason: collision with root package name */
    protected ITransactionCallback f302719g;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ITransactionCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), bArr, hashMap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(d.this.f302714b, 2, "upload onFailed errn:" + i3);
            }
            d.this.f();
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) hashMap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(d.this.f302714b, 2, "upload onSuccess");
            }
            Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            try {
                commFileExtRsp.mergeFrom(bArr);
                d.this.f302716d = commFileExtRsp.bytes_download_url.get().toStringUtf8();
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            d dVar = d.this;
            dVar.f302717e = true;
            dVar.b();
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }
    }

    public d(com.tencent.mobileqq.troopcheckin.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
            return;
        }
        this.f302717e = false;
        this.f302719g = new a();
        this.f302715c = i3;
        this.f302714b = getClass().getSimpleName();
        this.f302713a = aVar;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    public abstract void e();

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f302714b, 2, "onFailed ");
        }
        e();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f302714b, 2, "uploadPic path= " + str);
        }
        ITransactionCallback iTransactionCallback = this.f302719g;
        QQAppInterface d16 = d();
        if (d16 != null) {
            String currentUin = d16.getCurrentUin();
            byte[] k3 = v81.a.k(str);
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f302714b, 2, "uploadPic md5 null ");
                }
                return false;
            }
            Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
            commFileExtReq.uint32_action_type.set(0);
            commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
            Transaction transaction = new Transaction(currentUin, 75, str, 0, k3, iTransactionCallback, commFileExtReq.toByteArray(), false);
            int submitTransactionTask = d16.getHwEngine().submitTransactionTask(transaction);
            if (submitTransactionTask == 0) {
                this.f302718f = transaction;
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f302714b, 2, "uploadPic submitTransactionTask  retCode= " + submitTransactionTask);
            }
        }
        return false;
    }
}
