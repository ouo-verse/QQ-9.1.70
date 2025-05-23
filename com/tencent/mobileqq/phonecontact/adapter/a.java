package com.tencent.mobileqq.phonecontact.adapter;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends AbstractThreadedSyncAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f258344a;

    public a(Context context, boolean z16) {
        super(context, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
        } else {
            this.f258344a = context;
        }
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, account, bundle, str, contentProviderClient, syncResult);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync");
        }
        if (!"Success".equals(MobileQQ.sInjectResult)) {
            return;
        }
        AppInterface appInterface = null;
        try {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        } catch (Throwable th5) {
            QLog.e("ContactSync.SyncAdapter", 1, "onPerformSync exception", th5);
        }
        if (appInterface != null && appInterface.isLogin()) {
            try {
                ((IContactSyncService) appInterface.getRuntimeService(IContactSyncService.class, "")).syncAllContacts(1);
                return;
            } catch (Throwable th6) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | syncAllContacts exception", th6);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | app is null or not login, " + appInterface);
        }
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    @SuppressLint({"NewApi"})
    public void onSyncCanceled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled()");
        }
        super.onSyncCanceled();
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    @SuppressLint({"NewApi"})
    public void onSyncCanceled(Thread thread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) thread);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled(thread)");
        }
        super.onSyncCanceled(thread);
    }
}
