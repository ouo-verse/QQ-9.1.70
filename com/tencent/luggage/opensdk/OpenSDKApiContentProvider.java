package com.tencent.luggage.opensdk;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.y8.c;
import java.io.File;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class OpenSDKApiContentProvider extends FileProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f120004a = new String[1];

    /* loaded from: classes2.dex */
    public enum a {
        ToContentProtocol,
        ToFileProtocol
    }

    public static synchronized String a() {
        synchronized (OpenSDKApiContentProvider.class) {
            String[] strArr = f120004a;
            String str = strArr[0];
            if (str != null) {
                return str;
            }
            String f16 = com.tencent.luggage.wxa.db.a.f();
            strArr[0] = f16;
            v vVar = new v(f16);
            x.m(strArr[0]);
            x.l(strArr[0]);
            String g16 = vVar.g();
            if (!g16.endsWith("/")) {
                g16 = g16 + "/";
            }
            strArr[0] = g16;
            return g16;
        }
    }

    public static boolean b(String str) {
        if (str != null && str.startsWith(a())) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        if (str != null && str.startsWith("wxfile://")) {
            return true;
        }
        return false;
    }

    public static String d(String str) {
        String extension = FilenameUtils.getExtension(str);
        if (TextUtils.isEmpty(extension)) {
            return "";
        }
        return extension;
    }

    public static void a(i iVar, JSONObject jSONObject) {
        a(iVar, jSONObject, a.ToContentProtocol);
    }

    public static void a(i iVar, JSONObject jSONObject, a aVar) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (c(str2) || (k0.a(iVar.getRuntime(), str2) && !str2.endsWith(".html"))) {
                        jSONObject.put(str, a(iVar, str2, aVar));
                    }
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        Object opt = jSONArray.opt(i3);
                        if (opt instanceof String) {
                            String str3 = (String) opt;
                            if (!c(str3) && (!k0.a(iVar.getRuntime(), str3) || str3.endsWith(".html"))) {
                                jSONArray2.mo162put(opt);
                            }
                            jSONArray2.put(i3, a(iVar, str3, aVar));
                        } else {
                            jSONArray2.mo162put(opt);
                        }
                    }
                    jSONObject.put(str, jSONArray2.toString());
                }
            } catch (Exception e16) {
                w.a("MicroMsg.OpenSDKApiContentProvider", e16, "", new Object[0]);
                return;
            }
        }
    }

    public static String a(i iVar, String str, a aVar) {
        v absoluteFile = iVar.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null) {
            if (a.ToFileProtocol == aVar) {
                return "file://" + x.b(absoluteFile.g(), false);
            }
            String g16 = absoluteFile.g();
            if (!b(g16)) {
                g16 = a(g16);
                x.m(new v(g16).j());
                x.a(absoluteFile.g(), g16);
            }
            Uri uriForFile = FileProvider.getUriForFile(iVar.getContext(), iVar.getContext().getPackageName() + ".openapidata", new File(g16));
            iVar.getContext().grantUriPermission("com.tencent.mm", uriForFile, 1);
            return uriForFile.toString();
        }
        w.b("MicroMsg.OpenSDKApiContentProvider", "wxFilePath:%s is null", str);
        return str;
    }

    public static String a(String str) {
        String a16 = c.a(str.getBytes());
        String d16 = d(str);
        if (!TextUtils.isEmpty(d16) && !d16.startsWith(".")) {
            d16 = "." + d16;
        }
        return a() + a16 + d16;
    }
}
