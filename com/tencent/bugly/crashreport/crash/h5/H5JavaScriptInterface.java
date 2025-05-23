package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.br;
import com.tencent.bugly.proguard.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes5.dex */
public class H5JavaScriptInterface {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f97910a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private String f97911b = null;

    /* renamed from: c, reason: collision with root package name */
    private Thread f97912c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f97913d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f97914e = null;

    H5JavaScriptInterface() {
    }

    private static br a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                br brVar = new br();
                String string2 = jSONObject.getString("projectRoot");
                brVar.f98330a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                brVar.f98331b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                brVar.f98332c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                brVar.f98333d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                brVar.f98334e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                brVar.f98335f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    av.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                brVar.f98337h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                brVar.f98336g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    brVar.f98336g = brVar.f98336g.substring(indexOf2 + 1);
                }
                brVar.f98338i = jSONObject.getString("file");
                if (brVar.f98335f == null) {
                    return null;
                }
                long j3 = jSONObject.getLong("lineNumber");
                brVar.f98339j = j3;
                if (j3 < 0) {
                    return null;
                }
                long j16 = jSONObject.getLong("columnNumber");
                brVar.f98340k = j16;
                if (j16 < 0) {
                    return null;
                }
                av.a("H5 crash information is following: ", new Object[0]);
                av.a("[projectRoot]: " + brVar.f98330a, new Object[0]);
                av.a("[context]: " + brVar.f98331b, new Object[0]);
                av.a("[url]: " + brVar.f98332c, new Object[0]);
                av.a("[userAgent]: " + brVar.f98333d, new Object[0]);
                av.a("[language]: " + brVar.f98334e, new Object[0]);
                av.a("[name]: " + brVar.f98335f, new Object[0]);
                av.a("[message]: " + brVar.f98336g, new Object[0]);
                av.a("[stacktrace]: \n" + brVar.f98337h, new Object[0]);
                av.a("[file]: " + brVar.f98338i, new Object[0]);
                av.a("[lineNumber]: " + brVar.f98339j, new Object[0]);
                av.a("[columnNumber]: " + brVar.f98340k, new Object[0]);
                return brVar;
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(q.a aVar) {
        String str = null;
        if (aVar == null || f97910a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f97910a.add(Integer.valueOf(aVar.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.f97912c = currentThread;
        if (currentThread != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\n");
            for (int i3 = 2; i3 < currentThread.getStackTrace().length; i3++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i3];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb5.append(stackTraceElement.toString());
                    sb5.append("\n");
                }
            }
            str = sb5.toString();
        }
        h5JavaScriptInterface.f97913d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb6 = new StringBuilder();
        sb6.append((Object) aVar.a());
        hashMap.put("[WebView] ContentDescription", sb6.toString());
        h5JavaScriptInterface.f97914e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        av.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            av.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String c16 = ba.c(str.getBytes());
        String str2 = this.f97911b;
        if (str2 != null && str2.equals(c16)) {
            av.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f97911b = c16;
        av.d("Handling JS exception ...", new Object[0]);
        br a16 = a(str);
        if (a16 == null) {
            av.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a16.f98330a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a16.f98331b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a16.f98332c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a16.f98333d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a16.f98338i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j3 = a16.f98339j;
        if (j3 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j3));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f97914e);
        linkedHashMap.put("Java Stack", this.f97913d);
        InnerApi.postH5CrashAsync(this.f97912c, a16.f98335f, a16.f98336g, a16.f98337h, linkedHashMap);
    }
}
