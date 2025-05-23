package com.tencent.mobileqq.phonecontact.api.impl;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(Cursor cursor) throws Exception;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.phonecontact.api.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8219b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Uri f258435a;

        /* renamed from: b, reason: collision with root package name */
        String[] f258436b;

        /* renamed from: c, reason: collision with root package name */
        String f258437c;

        /* renamed from: d, reason: collision with root package name */
        String[] f258438d;

        /* renamed from: e, reason: collision with root package name */
        String f258439e;

        public C8219b(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, uri, strArr, str, strArr2, str2);
                return;
            }
            this.f258435a = uri;
            this.f258436b = strArr;
            this.f258437c = str;
            this.f258438d = strArr2;
            this.f258439e = str2;
        }
    }

    public static void a(AppInterface appInterface, C8219b c8219b, a aVar, boolean z16) {
        if (!ContactSyncLimitManager.d().h()) {
            if (QLog.isColorLevel()) {
                QLog.w("PhoneContact--ContactUtils", 2, "\u540e\u53f0\u7981\u6b62\u8bbf\u95ee\u901a\u8baf\u5f55", new Exception());
                return;
            }
            return;
        }
        if (!PermissionChecker.h().f()) {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneContact--ContactUtils", 1, "getContactsData return. no read contacts permission !");
                return;
            }
            return;
        }
        if (!ContactSyncLimitManager.d().i() && !z16) {
            if (QLog.isColorLevel()) {
                QLog.w("PhoneContact--ContactUtils", 2, "\u540e\u53f0\u540c\u6b65\u901a\u8baf\u5f55\u6b21\u6570\u8d85\u6807", new Exception());
                return;
            }
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(appInterface.getApp().getContentResolver(), c8219b.f258435a, c8219b.f258436b, c8219b.f258437c, c8219b.f258438d, c8219b.f258439e);
                if (cursor != null) {
                    aVar.a(cursor);
                }
                if (((IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")).needShowToastWhenUpload()) {
                    QLog.i("PhoneContact--ContactUtils", 1, "read system contact: ", new RuntimeException());
                    QQToastUtil.showQQToastInUiThread(0, "\u8bfb\u53d6\u7cfb\u7edf\u901a\u8baf\u5f55");
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e16) {
                QLog.e("PhoneContact--ContactUtils", 1, "", e16);
                if (cursor == null) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }
}
