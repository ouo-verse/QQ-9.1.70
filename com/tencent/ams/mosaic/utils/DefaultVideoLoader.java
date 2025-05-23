package com.tencent.ams.mosaic.utils;

import android.text.TextUtils;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultVideoLoader implements f.InterfaceC0685f {
    static IPatchRedirector $redirector_;

    public DefaultVideoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(String str, f.InterfaceC0685f.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                aVar.onLoadFinish(str);
                return true;
            }
            aVar.onLoadFinish(str);
            return true;
        }
        return false;
    }

    private boolean b(String str, JSONObject jSONObject, f.InterfaceC0685f.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.ams.mosaic.f.k().b().execute(new Runnable(jSONObject, str, aVar) { // from class: com.tencent.ams.mosaic.utils.DefaultVideoLoader.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSONObject f71539d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f71540e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ f.InterfaceC0685f.a f71541f;

                {
                    this.f71539d = jSONObject;
                    this.f71540e = str;
                    this.f71541f = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DefaultVideoLoader.this, jSONObject, str, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    int i3;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    com.tencent.ams.mosaic.utils.vid2url.a aVar2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject2 = this.f71539d;
                    String str6 = null;
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("sdtfrom");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                        int optInt = this.f71539d.optInt("hevclv", -1);
                        String optString2 = this.f71539d.optString("defn");
                        String optString3 = this.f71539d.optString("platform");
                        z16 = this.f71539d.optBoolean("fromDiffvmind", true);
                        str2 = optString2;
                        str3 = optString3;
                        str4 = this.f71539d.optString("getvmindUrl");
                        str5 = this.f71539d.optString("diffvmindUrl");
                        i3 = optInt;
                    } else {
                        z16 = true;
                        i3 = -1;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                    }
                    ArrayList<com.tencent.ams.mosaic.utils.vid2url.a> e16 = new com.tencent.ams.mosaic.utils.vid2url.e(this.f71540e, arrayList, i3, str2, str3, str4, str5, z16).e();
                    if (e16 != null && e16.size() > 0 && (aVar2 = e16.get(0)) != null) {
                        str6 = aVar2.f71575a;
                    }
                    f.InterfaceC0685f.a aVar3 = this.f71541f;
                    if (aVar3 != null) {
                        aVar3.onLoadFinish(str6);
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.f.InterfaceC0685f
    public void loadVideo(String str, f.InterfaceC0685f.a aVar) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (!TextUtils.isEmpty(str) && aVar != null) {
            f.e("DefaultVideoLoader", "loadVideo start: " + str);
            aVar.onLoadStart();
            try {
                jSONObject = new JSONObject(str);
                optString = jSONObject.optString("src");
                optString2 = jSONObject.optString("vid");
            } catch (JSONException e16) {
                f.i("DefaultVideoLoader", "loadVideo failed: invalid videoParams", e16);
            }
            if (a(optString, aVar)) {
                f.e("DefaultVideoLoader", "loadVideo by src: " + optString);
                return;
            }
            if (b(optString2, jSONObject, aVar)) {
                f.e("DefaultVideoLoader", "loadVideo by vid: " + optString2);
                return;
            }
            f.b("DefaultVideoLoader", "loadVideo failed: both src and vid are empty");
            aVar.onLoadFinish(null);
            return;
        }
        f.h("DefaultVideoLoader", "loadVideo fail: invalid params");
    }
}
