package com.tencent.common.config.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* loaded from: classes5.dex */
public class QZoneConfigProvider extends ContentProvider implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, c> f99584e;

    /* renamed from: f, reason: collision with root package name */
    private static final UriMatcher f99585f;

    /* renamed from: d, reason: collision with root package name */
    public Object f99586d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f99584e = new ConcurrentHashMap<>();
            f99585f = a();
        }
    }

    public QZoneConfigProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99586d = new Object();
        }
    }

    private static UriMatcher a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_configs", 1);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_cookie", 2);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_update", 3);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_isp_config", 4);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_delete", 6);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_check_time", 5);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_navigator_bar", 8);
        uriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "table_qz_unread", 9);
        return uriMatcher;
    }

    private int b(Uri uri, ContentValues[] contentValuesArr) {
        int a16 = l().a(uri, "qz_navigator_bar", contentValuesArr);
        getContext().getContentResolver().notifyChange(uri, null);
        return a16;
    }

    private int c(Uri uri, ContentValues[] contentValuesArr) {
        int a16 = l().a(uri, "table_qz_unread", contentValuesArr);
        getContext().getContentResolver().notifyChange(uri, null);
        return a16;
    }

    private int d(Uri uri, String str, String[] strArr) {
        int i3 = l().i(str, strArr);
        getContext().getContentResolver().notifyChange(uri, null);
        return i3;
    }

    private Cursor e(String[] strArr, String str, String[] strArr2, String str2) {
        return l().k(strArr, str, strArr2, str2);
    }

    private Cursor f(String[] strArr) {
        return l().l(strArr);
    }

    private Cursor g(String[] strArr) {
        return l().m(strArr);
    }

    private Cursor h(String[] strArr, String str, String[] strArr2, String str2) {
        return l().n(strArr, str, strArr2, str2);
    }

    private Cursor i(String[] strArr) {
        return l().o(strArr);
    }

    private Cursor j(String[] strArr, String str, String[] strArr2, String str2) {
        return l().p(strArr, str, strArr2, str2);
    }

    private Cursor k(String[] strArr, String str, String[] strArr2, String str2) {
        return l().q(strArr, str, strArr2, str2);
    }

    private c l() {
        c cVar;
        String str = "";
        try {
            if (!"Success".equals(MobileQQ.sInjectResult)) {
                QLog.e("QZoneConfigProvider", 1, " sIsDexInjectFinish = " + MobileQQ.sInjectResult + "  isUserAllow = " + PrivacyPolicyHelper.isUserAllow());
                return null;
            }
            if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null && !TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
                str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                if (f99584e.get(str) != null) {
                    return f99584e.get(str);
                }
                synchronized (this.f99586d) {
                    QLog.e("QZoneConfigProvider", 1, "new QZConfigSqliteManager  uin=" + LogUtil.getSafePrintUin(str));
                    cVar = new c(getContext(), str);
                    f99584e.put(str, cVar);
                }
                return cVar;
            }
            QLog.e("QZoneConfigProvider", 1, "getmSqlManager", "  uin=" + LogUtil.getSafePrintUin(""));
            return null;
        } catch (Throwable unused) {
            QLog.e("QZoneConfigProvider", 1, "getmSqlManager init erro", "  uin= " + str);
            return null;
        }
    }

    private Uri m(Uri uri, ContentValues contentValues) {
        Uri r16 = l().r(uri, contentValues);
        getContext().getContentResolver().notifyChange(r16, null);
        return r16;
    }

    private Uri n(Uri uri, ContentValues contentValues) {
        contentValues.put("name", "cookie");
        Uri s16 = l().s(uri, contentValues);
        getContext().getContentResolver().notifyChange(s16, null);
        return s16;
    }

    private Uri o(Uri uri, ContentValues contentValues) {
        contentValues.put("name", "check_time");
        Uri t16 = l().t(uri, contentValues);
        getContext().getContentResolver().notifyChange(t16, null);
        return t16;
    }

    private Uri p(Uri uri, ContentValues contentValues) {
        Uri u16 = l().u(uri, contentValues);
        getContext().getContentResolver().notifyChange(u16, null);
        return u16;
    }

    private Uri q(Uri uri, ContentValues contentValues) {
        Uri v3 = l().v(uri, contentValues);
        getContext().getContentResolver().notifyChange(v3, null);
        return v3;
    }

    private Uri r(Uri uri, ContentValues contentValues) {
        Uri w3 = l().w(uri, contentValues);
        getContext().getContentResolver().notifyChange(w3, null);
        return w3;
    }

    private Uri s(Uri uri, ContentValues contentValues) {
        contentValues.put("name", "updatelog");
        Uri x16 = l().x(uri, contentValues);
        getContext().getContentResolver().notifyChange(x16, null);
        return x16;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri, (Object) contentValuesArr)).intValue();
        }
        int match = f99585f.match(uri);
        if (match != 1) {
            if (match != 8) {
                if (match != 9) {
                    QZLog.e("QZoneConfigProvider", 1, "uri:", uri, "not used right");
                    return 0;
                }
                return c(uri, contentValuesArr);
            }
            return b(uri, contentValuesArr);
        }
        return l().a(uri, "qz_configs", contentValuesArr);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, uri, str, strArr)).intValue();
        }
        switch (f99585f.match(uri)) {
            case 1:
                return l().d(str, strArr);
            case 2:
                return l().e();
            case 3:
                return l().j();
            case 4:
                return l().g(str, strArr);
            case 5:
                return l().f();
            case 6:
                return l().c();
            case 7:
            default:
                return 0;
            case 8:
                return l().h(str, strArr);
            case 9:
                return d(uri, str, strArr);
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uri);
        }
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Uri) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uri, (Object) contentValues);
        }
        int match = f99585f.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        if (match != 5) {
                            if (match != 8) {
                                if (match != 9) {
                                    return null;
                                }
                                return r(uri, contentValues);
                            }
                            return q(uri, contentValues);
                        }
                        return o(uri, contentValues);
                    }
                    return p(uri, contentValues);
                }
                return s(uri, contentValues);
            }
            return n(uri, contentValues);
        }
        return m(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Cursor) iPatchRedirector.redirect((short) 7, this, uri, strArr, str, strArr2, str2);
        }
        try {
            int match = f99585f.match(uri);
            if (match != 1) {
                if (match != 2) {
                    if (match != 3) {
                        if (match != 4) {
                            if (match != 5) {
                                if (match != 8) {
                                    if (match != 9) {
                                        return null;
                                    }
                                    return k(strArr, str, strArr2, str2);
                                }
                                return j(strArr, str, strArr2, str2);
                            }
                            return g(strArr);
                        }
                        return h(strArr, str, strArr2, str2);
                    }
                    return i(strArr);
                }
                return f(strArr);
            }
            return e(strArr, str, strArr2, str2);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.w("QZoneConfigProvider", 2, "query\u5f02\u5e38", th5);
            }
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 8, this, uri, contentValues, str, strArr)).intValue();
    }
}
