package com.tencent.qimei.ai;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.sdk.Qimei;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f342990a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f342991b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f342992c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f342990a = com.tencent.qimei.r.a.a(2);
        f342991b = com.tencent.qimei.r.a.a(3);
        f342992c = com.tencent.qimei.r.a.a(4);
    }

    public static synchronized Qimei a(String str) {
        com.tencent.qimei.aa.e eVar;
        com.tencent.qimei.aa.a aVar;
        String str2;
        HashMap hashMap;
        synchronized (a.class) {
            Context e16 = com.tencent.qimei.ap.d.c().e();
            if (e16 == null) {
                str2 = "";
            } else {
                synchronized (a.class) {
                    try {
                        eVar = com.tencent.qimei.aa.e.a(e16, "Q_V3");
                    } catch (Exception e17) {
                        e17.getMessage();
                        eVar = null;
                    }
                    if (eVar != null) {
                        String str3 = (String) eVar.a("Q_V3", "");
                        synchronized (eVar) {
                            try {
                                eVar.f342897c = null;
                                eVar.f342902h = true;
                                eVar.f342898d.clear();
                                eVar.f342895a.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                    }
                    synchronized (com.tencent.qimei.aa.a.class) {
                        if (com.tencent.qimei.aa.a.f342885c == null) {
                            com.tencent.qimei.aa.a.f342885c = new com.tencent.qimei.aa.a();
                        }
                        aVar = com.tencent.qimei.aa.a.f342885c;
                    }
                    String str4 = f342990a;
                    String str5 = f342992c;
                    String str6 = "";
                    synchronized (aVar) {
                        SharedPreferences sharedPreferences = aVar.f342887a;
                        if (sharedPreferences == null) {
                            str6 = "";
                        } else {
                            String string = sharedPreferences.getString(str4, "");
                            int i3 = 0;
                            if (string != null && !string.trim().equals("")) {
                                byte[] bytes = string.getBytes(Charset.defaultCharset());
                                int i16 = 0;
                                while (i3 < bytes.length) {
                                    byte b16 = bytes[i3];
                                    byte[] bArr = com.tencent.qimei.aa.a.f342886d;
                                    bytes[i3] = (byte) (b16 ^ bArr[i16]);
                                    i16 = (i16 + 1) % bArr.length;
                                    i3++;
                                }
                                sharedPreferences.edit().remove(str4).putString(str5, Base64.encodeToString(bytes, 2)).commit();
                                str6 = string;
                            } else {
                                String string2 = sharedPreferences.getString(str5, "");
                                if (string2 != null && !string2.trim().equals("")) {
                                    byte[] decode = Base64.decode(string2, 2);
                                    int i17 = 0;
                                    while (i3 < decode.length) {
                                        byte b17 = decode[i3];
                                        byte[] bArr2 = com.tencent.qimei.aa.a.f342886d;
                                        decode[i3] = (byte) (b17 ^ bArr2[i17]);
                                        i17 = (i17 + 1) % bArr2.length;
                                        i3++;
                                    }
                                    str6 = new String(decode, Charset.defaultCharset());
                                }
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = f342991b;
                        synchronized (aVar) {
                            str2 = aVar.f342887a.getString(str7, "");
                        }
                    } else {
                        str2 = str6;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        String str8 = f342990a;
                        synchronized (aVar) {
                            str2 = aVar.f342887a.getString(str8, "");
                        }
                    }
                }
            }
            if (str2 != null && !str2.isEmpty()) {
                if (TextUtils.isEmpty(str2)) {
                    hashMap = null;
                } else {
                    hashMap = new HashMap(3);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        Iterator keys = jSONObject.keys();
                        if (keys != null) {
                            while (keys.hasNext()) {
                                String str9 = (String) keys.next();
                                hashMap.put(str9, jSONObject.getString(str9));
                            }
                        }
                    } catch (JSONException e18) {
                        e18.getMessage();
                        hashMap.put("A3", str2);
                    }
                }
                if (hashMap == null) {
                    return null;
                }
                String str10 = (String) hashMap.get("A3");
                String str11 = (String) hashMap.get("A153");
                if (TextUtils.isEmpty(str10) && TextUtils.isEmpty(str11)) {
                    return null;
                }
                Qimei qimei = new Qimei(str);
                if (!TextUtils.isEmpty(str10)) {
                    qimei.f343372b = str10;
                }
                if (!TextUtils.isEmpty(str11)) {
                    qimei.f343373c = str11;
                }
                return qimei;
            }
            return null;
        }
    }
}
