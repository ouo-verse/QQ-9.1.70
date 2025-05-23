package com.tencent.local_edit.andserver.http;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f119793d = Pattern.compile("\\*|\\s*((W\\/)?(\"[^\"]*\"))\\s*,?");

    /* renamed from: a, reason: collision with root package name */
    private b f119794a;

    /* renamed from: b, reason: collision with root package name */
    private c f119795b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f119796c;

    public d(@NonNull b bVar, @NonNull c cVar) {
        this.f119794a = bVar;
        this.f119795b = cVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if ((str.startsWith("\"") || str.startsWith("W/\"")) && str.endsWith("\"")) {
            return str;
        }
        return "\"" + str + "\"";
    }

    private long b(String str) {
        int indexOf;
        try {
            return this.f119794a.a(str);
        } catch (IllegalStateException unused) {
            String header = this.f119794a.getHeader(str);
            if (!TextUtils.isEmpty(header) && (indexOf = header.indexOf(59)) != -1) {
                return c(header.substring(0, indexOf));
            }
            return -1L;
        }
    }

    private long c(String str) {
        if (str == null || str.length() < 3) {
            return -1L;
        }
        return com.tencent.local_edit.andserver.util.c.b(str);
    }

    private boolean e(long j3) {
        boolean z16 = false;
        if (j3 < 0) {
            return false;
        }
        long b16 = b("If-Modified-Since");
        if (b16 == -1) {
            return false;
        }
        if (b16 >= j3) {
            z16 = true;
        }
        this.f119796c = z16;
        return true;
    }

    private boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> headers = this.f119794a.getHeaders("If-None-Match");
        if (headers.isEmpty()) {
            return false;
        }
        String a16 = a(str);
        Iterator<String> it = headers.iterator();
        while (it.hasNext()) {
            Matcher matcher = f119793d.matcher(it.next());
            while (true) {
                if (!matcher.find()) {
                    break;
                }
                if (!TextUtils.isEmpty(matcher.group()) && a16.replaceFirst("^W/", "").equals(matcher.group(3))) {
                    this.f119796c = true;
                    break;
                }
            }
        }
        return true;
    }

    private boolean g(long j3) {
        boolean z16 = false;
        if (j3 < 0) {
            return false;
        }
        long b16 = b(HttpHeaders.IF_UNMODIFIED_SINCE);
        if (b16 == -1) {
            return false;
        }
        if (b16 >= j3) {
            z16 = true;
        }
        this.f119796c = z16;
        return true;
    }

    public boolean d(@Nullable String str, long j3) {
        boolean z16 = true;
        if (this.f119796c) {
            return true;
        }
        int i3 = 411;
        if (g(j3)) {
            if (!this.f119796c) {
                this.f119795b.setStatus(411);
            }
            return this.f119796c;
        }
        if (!f(str)) {
            e(j3);
        }
        HttpMethod method = this.f119794a.getMethod();
        if (method != HttpMethod.GET && method != HttpMethod.HEAD) {
            z16 = false;
        }
        if (this.f119796c) {
            c cVar = this.f119795b;
            if (z16) {
                i3 = 304;
            }
            cVar.setStatus(i3);
        }
        if (z16) {
            if (j3 > 0 && this.f119795b.getHeader("Last-Modified") == null) {
                this.f119795b.a("Last-Modified", j3);
            }
            if (!TextUtils.isEmpty(str) && this.f119795b.getHeader("ETag") == null) {
                this.f119795b.setHeader("ETag", a(str));
            }
            this.f119795b.setHeader("Cache-Control", "private");
        }
        return this.f119796c;
    }
}
