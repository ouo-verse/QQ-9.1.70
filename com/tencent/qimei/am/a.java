package com.tencent.qimei.am;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.sdk.S.DataFormatter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements com.tencent.qimei.v.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataFormatter f343060a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataFormatter f343061b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f343062c;

    public a(b bVar, DataFormatter dataFormatter, DataFormatter dataFormatter2) {
        this.f343062c = bVar;
        this.f343060a = dataFormatter;
        this.f343061b = dataFormatter2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, dataFormatter, dataFormatter2);
        }
    }

    @Override // com.tencent.qimei.v.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f343060a.a().putAll(this.f343061b.a());
        String a16 = this.f343062c.a(this.f343060a, "qAucMjh7lsNepLGw");
        if (!TextUtils.isEmpty(a16)) {
            com.tencent.qimei.ab.c.a(com.tencent.qimei.u.a.b(), a16, "spread_data");
        }
    }
}
