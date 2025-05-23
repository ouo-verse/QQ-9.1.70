package com.tencent.xweb;

import android.content.Context;
import com.tencent.luggage.wxa.tq.e;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebWebViewDatabase implements e {

    /* renamed from: a, reason: collision with root package name */
    public final HttpAuthDatabase f385100a;

    public XWebWebViewDatabase() {
        this.f385100a = HttpAuthDatabase.newInstance(XWalkEnvironment.getApplicationContext(), "xweb_http_auth.db");
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void clearHttpAuthUsernamePassword() {
        this.f385100a.clearHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.f385100a.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public boolean hasFormData() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public boolean hasHttpAuthUsernamePassword() {
        return this.f385100a.hasHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public boolean hasUsernamePassword() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.f385100a.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public XWebWebViewDatabase(Context context) {
        this.f385100a = HttpAuthDatabase.newInstance(context, "xweb_http_auth.db");
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public void clearFormData() {
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public void clearUsernamePassword() {
    }
}
