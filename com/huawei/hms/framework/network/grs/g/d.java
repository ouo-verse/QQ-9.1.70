package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import cooperation.qzone.QzoneIPCModule;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: o, reason: collision with root package name */
    private static final String f36995o = "d";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f36996a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f36997b;

    /* renamed from: c, reason: collision with root package name */
    private int f36998c;

    /* renamed from: d, reason: collision with root package name */
    private long f36999d;

    /* renamed from: e, reason: collision with root package name */
    private long f37000e;

    /* renamed from: f, reason: collision with root package name */
    private long f37001f;

    /* renamed from: g, reason: collision with root package name */
    private String f37002g;

    /* renamed from: h, reason: collision with root package name */
    private int f37003h;

    /* renamed from: i, reason: collision with root package name */
    private int f37004i;

    /* renamed from: j, reason: collision with root package name */
    private String f37005j;

    /* renamed from: k, reason: collision with root package name */
    private long f37006k;

    /* renamed from: l, reason: collision with root package name */
    private String f37007l;

    /* renamed from: m, reason: collision with root package name */
    private Exception f37008m;

    /* renamed from: n, reason: collision with root package name */
    private String f37009n;

    public d(int i3, Map<String, List<String>> map, byte[] bArr, long j3) {
        this.f37003h = 2;
        this.f37004i = 9001;
        this.f37005j = "";
        this.f37006k = 0L;
        this.f37007l = "";
        this.f36998c = i3;
        this.f36996a = map;
        this.f36997b = ByteBuffer.wrap(bArr).array();
        this.f36999d = j3;
        s();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0058, code lost:
    
        if (r9.getInt(cooperation.qzone.QzoneIPCModule.RESULT_CODE) == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        int i3;
        String str;
        int i16;
        if (m()) {
            Logger.i(f36995o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            Logger.i(f36995o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.f36997b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                    i3 = 1;
                }
                i3 = 2;
            } else if (!jSONObject.has(QzoneIPCModule.RESULT_CODE)) {
                Logger.e(f36995o, "sth. wrong because server errorcode's key.");
                i3 = -1;
            }
            if (i3 != 1 && jSONObject.has("services")) {
                i3 = 0;
            }
            c(i3);
            String str2 = "";
            if (i3 != 1 && i3 != 0) {
                if (jSONObject.has("errorCode")) {
                    i16 = jSONObject.getInt("errorCode");
                } else {
                    i16 = 9001;
                }
                b(i16);
                if (jSONObject.has("errorDesc")) {
                    str2 = jSONObject.getString("errorDesc");
                }
                d(str2);
                return;
            }
            if (!jSONObject.has("services")) {
                str = "";
            } else {
                str = jSONObject.getJSONObject("services").toString();
            }
            f(str);
            if (jSONObject.has("errorList")) {
                str2 = jSONObject.getJSONObject("errorList").toString();
            }
            e(str2);
        } catch (JSONException e16) {
            Logger.w(f36995o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
            c(2);
        }
    }

    private void q() {
        if (!o() && !n() && !m()) {
            return;
        }
        Map<String, String> r16 = r();
        if (r16.size() <= 0) {
            Logger.w(f36995o, "parseHeader {headers.size() <= 0}");
            return;
        }
        try {
            if (o() || m()) {
                b(r16);
                a(r16);
            }
            if (n()) {
                c(r16);
            }
        } catch (JSONException e16) {
            Logger.w(f36995o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f36996a;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List<String>> entry : this.f36996a.entrySet()) {
                String key = entry.getKey();
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    hashMap.put(key, it.next());
                }
            }
            return hashMap;
        }
        Logger.v(f36995o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.f37005j;
    }

    public int b() {
        return this.f36998c;
    }

    public int c() {
        return this.f37004i;
    }

    public Exception d() {
        return this.f37008m;
    }

    public String e() {
        return this.f37007l;
    }

    public int f() {
        return this.f37003h;
    }

    public long g() {
        return this.f37001f;
    }

    public long h() {
        return this.f37000e;
    }

    public long i() {
        return this.f36999d;
    }

    public String j() {
        return this.f37002g;
    }

    public long k() {
        return this.f37006k;
    }

    public String l() {
        return this.f37009n;
    }

    public boolean m() {
        if (this.f36998c == 304) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f36998c == 503) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.f36998c == 200) {
            return true;
        }
        return false;
    }

    public d(Exception exc, long j3) {
        this.f36998c = 0;
        this.f37003h = 2;
        this.f37004i = 9001;
        this.f37005j = "";
        this.f37006k = 0L;
        this.f37007l = "";
        this.f37008m = exc;
        this.f36999d = j3;
    }

    private void b(int i3) {
        this.f37004i = i3;
    }

    private void c(int i3) {
        this.f37003h = i3;
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.f37002g = str;
    }

    public void a(int i3) {
    }

    private void c(long j3) {
        this.f37006k = j3;
    }

    public void a(long j3) {
        this.f37001f = j3;
    }

    public void b(long j3) {
        this.f37000e = j3;
    }

    private void c(String str) {
        this.f37005j = str;
    }

    public void a(String str) {
        this.f37007l = str;
    }

    public void b(String str) {
        this.f37009n = str;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(f36995o, "success get Etag from server");
                a(str3);
                return;
            } else {
                str = f36995o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = f36995o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(f36995o, "Cache-Control value{%s}", Long.valueOf(time));
                    } catch (NumberFormatException e16) {
                        e = e16;
                        Logger.w(f36995o, "getExpireTime addHeadersToResult NumberFormatException", e);
                        if (time > 0) {
                        }
                        time = 86400;
                        long j3 = time * 1000;
                        Logger.i(f36995o, "convert expireTime{%s}", Long.valueOf(j3));
                        c(String.valueOf(j3 + System.currentTimeMillis()));
                    }
                } catch (NumberFormatException e17) {
                    e = e17;
                    time = 0;
                }
            }
            time = 0;
        } else {
            if (map.containsKey("Expires")) {
                String str2 = map.get("Expires");
                Logger.v(f36995o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey("Date") ? map.get("Date") : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e18) {
                    Logger.w(f36995o, "getExpireTime ParseException.", e18);
                }
            } else {
                Logger.i(f36995o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time > 0 || time > 2592000) {
            time = 86400;
        }
        long j36 = time * 1000;
        Logger.i(f36995o, "convert expireTime{%s}", Long.valueOf(j36));
        c(String.valueOf(j36 + System.currentTimeMillis()));
    }

    private void c(Map<String, String> map) {
        long j3;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j3 = Long.parseLong(str);
                } catch (NumberFormatException e16) {
                    Logger.w(f36995o, "getRetryAfter addHeadersToResult NumberFormatException", e16);
                }
                long j16 = j3 * 1000;
                Logger.v(f36995o, "convert retry-afterTime{%s}", Long.valueOf(j16));
                c(j16);
            }
        }
        j3 = 0;
        long j162 = j3 * 1000;
        Logger.v(f36995o, "convert retry-afterTime{%s}", Long.valueOf(j162));
        c(j162);
    }
}
