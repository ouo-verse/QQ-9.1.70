package com.tencent.mobileqq.phonecontact.data;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static String f258461g;

    /* renamed from: a, reason: collision with root package name */
    private List<ContentProviderOperation> f258462a;

    /* renamed from: b, reason: collision with root package name */
    private AppInterface f258463b;

    /* renamed from: c, reason: collision with root package name */
    private ContentValues f258464c;

    /* renamed from: d, reason: collision with root package name */
    private long f258465d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f258466e;

    /* renamed from: f, reason: collision with root package name */
    private int f258467f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24696);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f258461g = com.tencent.mobileqq.phonecontact.constant.a.f258440a;
        }
    }

    b(AppInterface appInterface, List<ContentProviderOperation> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) list);
            return;
        }
        this.f258462a = list;
        this.f258463b = appInterface;
        this.f258464c = new ContentValues();
    }

    private void b() {
        if (!this.f258466e) {
            this.f258464c.put("raw_contact_id", Long.valueOf(this.f258465d));
        }
        ContentProviderOperation.Builder f16 = f();
        f16.withValues(this.f258464c);
        if (this.f258466e) {
            f16.withValueBackReference("raw_contact_id", this.f258467f);
        }
        this.f258462a.add(f16.build());
    }

    private void c(Uri uri) {
        ContentProviderOperation.Builder g16 = g(uri);
        g16.withValues(this.f258464c);
        this.f258462a.add(g16.build());
    }

    public static b e(AppInterface appInterface, List<ContentProviderOperation> list, String str, String str2, String str3, String str4, int i3, int i16) {
        return new b(appInterface, list, str, str2, str3, str4, i3, i16);
    }

    private static ContentProviderOperation.Builder f() {
        return ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", f258461g).build()).withYieldAllowed(true);
    }

    private static ContentProviderOperation.Builder g(Uri uri) {
        return ContentProviderOperation.newUpdate(uri.buildUpon().appendQueryParameter("caller_is_syncadapter", f258461g).build()).withYieldAllowed(true);
    }

    public static b i(AppInterface appInterface, List<ContentProviderOperation> list, long j3) {
        return new b(appInterface, list, j3);
    }

    public b a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.f258464c.clear();
        this.f258464c.put("mimetype", "vnd.android.cursor.item/name");
        this.f258464c.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        b();
        return this;
    }

    public b d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.f258464c.clear();
        this.f258464c.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile");
        this.f258464c.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        this.f258464c.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, "QQ");
        this.f258464c.put("data3", this.f258463b.getApp().getString(R.string.f198044ln));
        b();
        return this;
    }

    public b h(String str, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) uri);
        }
        this.f258464c.clear();
        this.f258464c.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        c(uri);
        return this;
    }

    b(AppInterface appInterface, List<ContentProviderOperation> list, long j3) {
        this(appInterface, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, list, Long.valueOf(j3));
        } else {
            this.f258465d = j3;
            this.f258466e = false;
        }
    }

    b(AppInterface appInterface, List<ContentProviderOperation> list, String str, String str2, String str3, String str4, int i3, int i16) {
        this(appInterface, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, list, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f258466e = true;
        this.f258467f = list.size();
        this.f258462a.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).withValue("aggregation_mode", 0).withValue("account_type", "com.tencent.mobileqq.account").withValue("account_name", str).withValue("sourceid", str2).withValue("sync1", str3).withValue("sync2", str4).withValue("sync3", Integer.valueOf(i3)).build());
    }
}
