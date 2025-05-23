package com.tencent.mobileqq.dt.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WebCheck {
    static IPatchRedirector $redirector_;

    public static AppInterface a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        AppRuntime appRuntime = peekAppRuntime.getAppRuntime("modular_web");
        if (appRuntime instanceof AppInterface) {
            return (AppInterface) appRuntime;
        }
        return null;
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "https://accounts.qq.com/report/center?_wv=2";
        }
        return str + "&appid=" + str2 + "&id=" + str3;
    }

    public static void c(com.tencent.mobileqq.dt.api.i iVar, com.tencent.mobileqq.dt.api.h hVar) {
        AppInterface a16 = a();
        if (a16 == null) {
            QLog.e("DTAPIImpl.WebCheck", 1, "webCheck appInterface is null");
            return;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105447", false)) {
            QLog.i("DTAPIImpl.WebCheck", 1, "webCheck closed");
            return;
        }
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("105447", new byte[0]));
        int i3 = 30;
        try {
            i3 = new JSONObject(str).optInt("count", 30);
            QLog.i("DTAPIImpl.WebCheck", 1, "webCheck report count " + i3);
        } catch (JSONException unused) {
            QLog.i("DTAPIImpl.WebCheck", 1, "webCheck config parse error " + str);
        }
        IArkDictManager iArkDictManager = (IArkDictManager) a16.getRuntimeService(IArkDictManager.class, "all");
        iArkDictManager.initWordData();
        iArkDictManager.getAnalysisThread().post(new Runnable(a16, iVar, i3, hVar) { // from class: com.tencent.mobileqq.dt.model.WebCheck.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AppInterface f203817e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.dt.api.i f203818f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f203819h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.dt.api.h f203820i;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.dt.model.WebCheck$1$a */
            /* loaded from: classes5.dex */
            class a extends com.tencent.mobileqq.dt.web.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.mobileqq.dt.web.a
                public void b(int i3, byte[] bArr) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                    } else if (i3 == 1 && bArr.length > 0) {
                        AnonymousClass1.this.f203820i.a(i3, new String(bArr));
                    }
                }
            }

            {
                this.f203817e = a16;
                this.f203818f = iVar;
                this.f203819h = i3;
                this.f203820i = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, com.tencent.mobileqq.ark.dict.g.this, a16, iVar, Integer.valueOf(i3), hVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String[] strArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("DTAPIImpl.WebCheck", 1, "word segment result " + com.tencent.mobileqq.ark.dict.g.this.f199459a);
                com.tencent.mobileqq.ark.dict.g gVar = com.tencent.mobileqq.ark.dict.g.this;
                if (gVar.f199459a && (strArr = gVar.f199461c) != null && strArr.length > 0) {
                    QLog.i("DTAPIImpl.WebCheck", 1, "word segment size " + com.tencent.mobileqq.ark.dict.g.this.f199461c.length);
                    JSONArray jSONArray = new JSONArray();
                    int i16 = 0;
                    while (true) {
                        String[] strArr2 = com.tencent.mobileqq.ark.dict.g.this.f199461c;
                        if (i16 >= strArr2.length) {
                            break;
                        }
                        jSONArray.mo162put(strArr2[i16]);
                        i16++;
                    }
                    O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) this.f203817e.getBusinessHandler(O3BusinessHandler.class.getName());
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", this.f203818f.d());
                        jSONObject.put("landUrl", this.f203818f.b());
                        jSONObject.put("originContent", this.f203818f.a());
                        jSONObject.put("content", jSONArray.toString());
                        jSONObject.put("scene", this.f203818f.c());
                        jSONObject.put("count", this.f203819h);
                    } catch (JSONException e16) {
                        QLog.e("DTAPIImpl.WebCheck", 1, "webCheck " + e16.getMessage());
                    }
                    o3BusinessHandler.D2("webCheck", jSONObject.toString(), new a());
                }
            }
        });
    }
}
