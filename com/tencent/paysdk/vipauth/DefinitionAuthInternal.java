package com.tencent.paysdk.vipauth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.r;
import com.tencent.paysdk.report.InternalReport;
import com.tencent.paysdk.vipauth.requestdata.DefinitionAuthRequestData;
import com.tencent.paysdk.vipauth.responsedata.DefinitionAuthResponse;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public abstract class DefinitionAuthInternal implements com.tencent.paysdk.network.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final e<DefinitionAuthRequestData, DefinitionAuthResponse> f342101a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> f342102b;

    /* renamed from: c, reason: collision with root package name */
    protected com.tencent.paysdk.api.c f342103c;

    /* renamed from: d, reason: collision with root package name */
    r f342104d;

    /* renamed from: e, reason: collision with root package name */
    protected String f342105e;

    /* renamed from: f, reason: collision with root package name */
    private int f342106f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements r {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefinitionAuthInternal.this);
            }
        }

        @Override // com.tencent.paysdk.api.r
        public void Jd(int i3, String str, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, str4);
                return;
            }
            DefinitionAuthInternal definitionAuthInternal = DefinitionAuthInternal.this;
            com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> aVar = definitionAuthInternal.f342102b;
            if (aVar != null && i3 == 0) {
                aVar.c(definitionAuthInternal.f342101a);
                com.tencent.paysdk.util.f.c(DefinitionAuthInternal.this.f342104d);
            }
        }
    }

    public DefinitionAuthInternal(@NonNull com.tencent.paysdk.api.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f342101a = new e<>();
        this.f342104d = new a();
        this.f342103c = cVar;
    }

    @Override // com.tencent.paysdk.network.c
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            com.tencent.paysdk.util.a.b(new Runnable() { // from class: com.tencent.paysdk.vipauth.DefinitionAuthInternal.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefinitionAuthInternal.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DefinitionAuthInternal definitionAuthInternal = DefinitionAuthInternal.this;
                    com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> aVar = definitionAuthInternal.f342102b;
                    if (aVar != null) {
                        aVar.a(definitionAuthInternal.f342101a);
                        InternalReport.f(DefinitionAuthInternal.this.c(510001, InternalReport.e(DefinitionAuthInternal.this.f342106f)));
                    }
                }
            });
        } else {
            com.tencent.paysdk.util.a.b(new Runnable(str) { // from class: com.tencent.paysdk.vipauth.DefinitionAuthInternal.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f342107d;

                {
                    this.f342107d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefinitionAuthInternal.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    DefinitionAuthInternal definitionAuthInternal;
                    com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DefinitionAuthResponse definitionAuthResponse = (DefinitionAuthResponse) com.tencent.paysdk.util.d.a(this.f342107d, DefinitionAuthResponse.class);
                    DefinitionAuthInternal.this.f342101a.c(definitionAuthResponse);
                    if (definitionAuthResponse.getPayInfoStatus() == 1) {
                        DefinitionAuthInternal definitionAuthInternal2 = DefinitionAuthInternal.this;
                        com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> aVar2 = definitionAuthInternal2.f342102b;
                        if (aVar2 != null) {
                            aVar2.c(definitionAuthInternal2.f342101a);
                        }
                    } else if (definitionAuthResponse.getPayInfoStatus() == 2 && (aVar = (definitionAuthInternal = DefinitionAuthInternal.this).f342102b) != null) {
                        aVar.b(definitionAuthInternal.f342101a);
                        com.tencent.paysdk.util.f.b(DefinitionAuthInternal.this.f342104d);
                    }
                    Map<String, Object> c16 = DefinitionAuthInternal.this.c(0, InternalReport.e(DefinitionAuthInternal.this.f342106f));
                    c16.put("data", this.f342107d);
                    InternalReport.f(c16);
                }
            });
        }
    }

    protected abstract Map<String, Object> c(int i3, long j3);

    @Override // com.tencent.paysdk.network.c
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            com.tencent.paysdk.util.a.b(new Runnable() { // from class: com.tencent.paysdk.vipauth.DefinitionAuthInternal.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefinitionAuthInternal.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DefinitionAuthInternal definitionAuthInternal = DefinitionAuthInternal.this;
                    com.tencent.paysdk.vipauth.a<DefinitionAuthRequestData, DefinitionAuthResponse> aVar = definitionAuthInternal.f342102b;
                    if (aVar != null) {
                        aVar.a(definitionAuthInternal.f342101a);
                        InternalReport.f(DefinitionAuthInternal.this.c(510003, InternalReport.e(DefinitionAuthInternal.this.f342106f)));
                    }
                }
            });
        }
    }
}
