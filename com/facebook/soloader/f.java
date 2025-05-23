package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends UnpackingSoSource {

    /* renamed from: g, reason: collision with root package name */
    protected final File f32829g;

    /* renamed from: h, reason: collision with root package name */
    protected final String f32830h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends UnpackingSoSource.a implements Comparable {

        /* renamed from: f, reason: collision with root package name */
        final ZipEntry f32831f;

        /* renamed from: h, reason: collision with root package name */
        final int f32832h;

        b(String str, ZipEntry zipEntry, int i3) {
            super(str, c(zipEntry));
            this.f32831f = zipEntry;
            this.f32832h = i3;
        }

        private static String c(ZipEntry zipEntry) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc()));
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f32811d.compareTo(((b) obj).f32811d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends UnpackingSoSource.e {

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private b[] f32833d;

        /* renamed from: e, reason: collision with root package name */
        private final ZipFile f32834e;

        /* renamed from: f, reason: collision with root package name */
        private final UnpackingSoSource f32835f;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private final class a extends UnpackingSoSource.d {

            /* renamed from: d, reason: collision with root package name */
            private int f32837d;

            a() {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.d
            public UnpackingSoSource.c a() throws IOException {
                c.this.g();
                b[] bVarArr = c.this.f32833d;
                int i3 = this.f32837d;
                this.f32837d = i3 + 1;
                b bVar = bVarArr[i3];
                InputStream inputStream = c.this.f32834e.getInputStream(bVar.f32831f);
                try {
                    return new UnpackingSoSource.c(bVar, inputStream);
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th5;
                }
            }

            @Override // com.facebook.soloader.UnpackingSoSource.d
            public boolean hasNext() {
                c.this.g();
                if (this.f32837d < c.this.f32833d.length) {
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(UnpackingSoSource unpackingSoSource) throws IOException {
            this.f32834e = new ZipFile(f.this.f32829g);
            this.f32835f = unpackingSoSource;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.e
        protected final UnpackingSoSource.b a() throws IOException {
            return new UnpackingSoSource.b(g());
        }

        @Override // com.facebook.soloader.UnpackingSoSource.e, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f32834e.close();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.e
        protected final UnpackingSoSource.d d() throws IOException {
            return new a();
        }

        final b[] g() {
            if (this.f32833d == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(f.this.f32830h);
                String[] h16 = l.h();
                Enumeration<? extends ZipEntry> entries = this.f32834e.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    Matcher matcher = compile.matcher(nextElement.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        int e16 = l.e(h16, group);
                        if (e16 >= 0) {
                            linkedHashSet.add(group);
                            b bVar = (b) hashMap.get(group2);
                            if (bVar == null || e16 < bVar.f32832h) {
                                hashMap.put(group2, new b(group2, nextElement, e16));
                            }
                        }
                    }
                }
                this.f32835f.q((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                b[] bVarArr = (b[]) hashMap.values().toArray(new b[hashMap.size()]);
                Arrays.sort(bVarArr);
                int i3 = 0;
                for (int i16 = 0; i16 < bVarArr.length; i16++) {
                    b bVar2 = bVarArr[i16];
                    if (h(bVar2.f32831f, bVar2.f32811d)) {
                        i3++;
                    } else {
                        bVarArr[i16] = null;
                    }
                }
                b[] bVarArr2 = new b[i3];
                int i17 = 0;
                for (b bVar3 : bVarArr) {
                    if (bVar3 != null) {
                        bVarArr2[i17] = bVar3;
                        i17++;
                    }
                }
                this.f32833d = bVarArr2;
            }
            return this.f32833d;
        }

        protected boolean h(ZipEntry zipEntry, String str) {
            throw null;
        }
    }

    public f(Context context, String str, File file, String str2) {
        super(context, str);
        this.f32829g = file;
        this.f32830h = str2;
    }
}
