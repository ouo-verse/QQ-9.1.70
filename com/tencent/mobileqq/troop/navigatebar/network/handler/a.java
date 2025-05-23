package com.tencent.mobileqq.troop.navigatebar.network.handler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a<T extends MessageMicro> implements TroopAioMessageNavigateBusinessHandler.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected TroopAioMessageNavigateBusinessHandler f298008a;

    public a(TroopAioMessageNavigateBusinessHandler troopAioMessageNavigateBusinessHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopAioMessageNavigateBusinessHandler);
        } else {
            this.f298008a = troopAioMessageNavigateBusinessHandler;
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (this.f298008a == null) {
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            if (!fromServiceMsg.isSuccess()) {
                f(fromServiceMsg.getBusinessFailCode(), fromServiceMsg.getBusinessFailMsg());
                return;
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            T c16 = c();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                c16.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                if (oidb_sso_oidbssopkg.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    e(toServiceMsg, fromServiceMsg, c16);
                    return;
                } else {
                    f(oidb_sso_oidbssopkg.uint32_result.get(), oidb_sso_oidbssopkg.str_error_msg.get());
                    return;
                }
            } catch (InvalidProtocolBufferMicroException | NullPointerException unused) {
                f(1001L, "");
                return;
            }
        }
        f(Constant.FROM_ID_UNINSTALL_PLUGIN, "");
    }

    @NonNull
    protected abstract T c();

    protected abstract int d();

    protected abstract void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str);
            return;
        }
        if (this.f298008a == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopAioNav", 2, getClass().getSimpleName() + " notifyUIFail: code = " + j3 + "\uff0c msg = " + str);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("EXTRA_ERR_CODE", j3);
        bundle.putString("EXTRA_ERR_MSG", str);
        this.f298008a.notifyUI(d(), false, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (this.f298008a == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopAioNav", 2, getClass().getSimpleName() + " notifyUISuccess: data = " + obj);
        }
        this.f298008a.notifyUI(d(), true, obj);
    }
}
