package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.n0.v;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends g {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f134021g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f134022h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f134023i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public n(String str, long j3, long j16, long j17, File file) {
        super(str, j3, j16, j17, file);
    }

    public static File a(File file, int i3, long j3, long j16) {
        return new File(file, i3 + "." + j3 + "." + j16 + ".v3.exo");
    }

    public static n b(String str, long j3) {
        return new n(str, j3, -1L, -9223372036854775807L, null);
    }

    public static n a(String str, long j3) {
        return new n(str, j3, -1L, -9223372036854775807L, null);
    }

    public static File b(File file, j jVar) {
        String group;
        String name = file.getName();
        Matcher matcher = f134022h.matcher(name);
        if (matcher.matches()) {
            group = v.h(matcher.group(1));
            if (group == null) {
                return null;
            }
        } else {
            matcher = f134021g.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            group = matcher.group(1);
        }
        File a16 = a(file.getParentFile(), jVar.b(group), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(a16)) {
            return a16;
        }
        return null;
    }

    public static n a(String str, long j3, long j16) {
        return new n(str, j3, j16, -9223372036854775807L, null);
    }

    public static n a(File file, j jVar) {
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            file = b(file, jVar);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        File file2 = file;
        Matcher matcher = f134023i.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file2.length();
        String a16 = jVar.a(Integer.parseInt(matcher.group(1)));
        if (a16 == null) {
            return null;
        }
        return new n(a16, Long.parseLong(matcher.group(2)), length, Long.parseLong(matcher.group(3)), file2);
    }

    public n a(int i3) {
        com.tencent.luggage.wxa.n0.a.b(this.f133988d);
        long currentTimeMillis = System.currentTimeMillis();
        return new n(this.f133985a, this.f133986b, this.f133987c, currentTimeMillis, a(this.f133989e.getParentFile(), i3, this.f133986b, currentTimeMillis));
    }
}
