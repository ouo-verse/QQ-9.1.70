package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d extends UFTBaseTask implements UFTUploadCbWrapper.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.task.taskinfo.i f305508f;

    /* renamed from: g, reason: collision with root package name */
    protected final UFTUploadCbWrapper f305509g;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar2, com.tencent.mobileqq.uftransfer.task.a aVar3, com.tencent.mobileqq.uftransfer.api.b bVar) {
        super(appRuntime, aVar, aVar2, aVar3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, aVar2, aVar3, bVar);
        } else {
            this.f305508f = new com.tencent.mobileqq.uftransfer.task.taskinfo.i();
            this.f305509g = new UFTUploadCbWrapper(this, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(int i3, String str, String str2, UploadInfoEntity uploadInfoEntity) {
        v(i3, str, str2);
    }

    private boolean u(int i3) {
        if (i3 != -29120 && i3 != 0 && i3 != 1 && i3 != 9005 && i3 != 9042 && i3 != 9041) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f305361e;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public boolean f(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uFTBaseTask)).booleanValue();
        }
        if (!(uFTBaseTask instanceof d)) {
            return false;
        }
        d dVar = (d) uFTBaseTask;
        if (r() == null || !r().equals(dVar.r())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (!com.tencent.mobileqq.uftransfer.task.utils.a.i(this.f305357a)) {
            s(null, z16);
        } else {
            ((IUTFTUploadDBService) this.f305357a.getRuntimeService(IUTFTUploadDBService.class, "")).getEntityAsync(com.tencent.mobileqq.uftransfer.task.utils.a.d(this.f305358b, this.f305359c), new IUTFTUploadDBService.a() { // from class: com.tencent.mobileqq.uftransfer.task.upload.b
                @Override // com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService.a
                public final void a(UploadInfoEntity uploadInfoEntity) {
                    d.this.s(z16, uploadInfoEntity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void s(UploadInfoEntity uploadInfoEntity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uploadInfoEntity, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (!com.tencent.mobileqq.uftransfer.task.utils.a.i(this.f305357a)) {
            return;
        }
        if (u(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("[UFTTransfer] UFTBaseUploadTask", 2, "doRemoveDBCacheOp: not need remove db: " + i3);
                return;
            }
            return;
        }
        ((IUTFTUploadDBService) this.f305357a.getRuntimeService(IUTFTUploadDBService.class, "")).removeAsync(com.tencent.mobileqq.uftransfer.task.utils.a.d(this.f305358b, this.f305359c), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(final int i3, final String str, final String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (!com.tencent.mobileqq.uftransfer.task.utils.a.i(this.f305357a)) {
            v(i3, str, str2);
            return;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("[UFTTransfer] UFTBaseUploadTask", 2, "doSaveDBCacheOp not work. errCode = " + i3 + ", errMsg = " + str);
            }
            v(i3, str, str2);
            return;
        }
        UploadInfoEntity f16 = com.tencent.mobileqq.uftransfer.task.utils.a.f(this.f305358b, this.f305359c);
        if (f16 == null) {
            v(i3, str, str2);
        } else {
            ((IUTFTUploadDBService) this.f305357a.getRuntimeService(IUTFTUploadDBService.class, "")).addOrReplaceAsync(f16, new IUTFTUploadDBService.a() { // from class: com.tencent.mobileqq.uftransfer.task.upload.c
                @Override // com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService.a
                public final void a(UploadInfoEntity uploadInfoEntity) {
                    d.this.t(i3, str, str2, uploadInfoEntity);
                }
            });
        }
    }

    public abstract String r();

    protected void v(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2);
        }
    }
}
