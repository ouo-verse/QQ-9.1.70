package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e extends UnpackingSoSource {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class b extends UnpackingSoSource.e {

        /* renamed from: d, reason: collision with root package name */
        private final c[] f32824d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private final class a extends UnpackingSoSource.d {

            /* renamed from: d, reason: collision with root package name */
            private int f32826d;

            a() {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.d
            public UnpackingSoSource.c a() throws IOException {
                c[] cVarArr = b.this.f32824d;
                int i3 = this.f32826d;
                this.f32826d = i3 + 1;
                c cVar = cVarArr[i3];
                FileInputStream fileInputStream = new FileInputStream(cVar.f32828f);
                try {
                    return new UnpackingSoSource.c(cVar, fileInputStream);
                } catch (Throwable th5) {
                    fileInputStream.close();
                    throw th5;
                }
            }

            @Override // com.facebook.soloader.UnpackingSoSource.d
            public boolean hasNext() {
                if (this.f32826d < b.this.f32824d.length) {
                    return true;
                }
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
        
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r11 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        b(UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z16;
            File file = new File("/data/local/tmp/exopackage/" + e.this.f32802c.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] h16 = l.h();
            int length = h16.length;
            int i3 = 0;
            int i16 = 0;
            loop0: while (i16 < length) {
                String str = h16[i16];
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        if (readLine.length() != 0) {
                                            int indexOf = readLine.indexOf(32);
                                            if (indexOf == -1) {
                                                break loop0;
                                            }
                                            String str2 = readLine.substring(i3, indexOf) + ".so";
                                            int size = arrayList.size();
                                            int i17 = i3;
                                            while (true) {
                                                if (i17 < size) {
                                                    if (((c) arrayList.get(i17)).f32811d.equals(str2)) {
                                                        z16 = true;
                                                        break;
                                                    }
                                                    i17++;
                                                } else {
                                                    z16 = false;
                                                    break;
                                                }
                                            }
                                            if (!z16) {
                                                String substring = readLine.substring(indexOf + 1);
                                                arrayList.add(new c(str2, substring, new File(file2, substring)));
                                            }
                                            i3 = 0;
                                        }
                                    } else {
                                        bufferedReader.close();
                                        fileReader.close();
                                        break;
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
                i16++;
                i3 = 0;
            }
            unpackingSoSource.q((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.f32824d = (c[]) arrayList.toArray(new c[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.e
        protected UnpackingSoSource.b a() throws IOException {
            return new UnpackingSoSource.b(this.f32824d);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.e
        protected UnpackingSoSource.d d() throws IOException {
            return new a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class c extends UnpackingSoSource.a {

        /* renamed from: f, reason: collision with root package name */
        final File f32828f;

        c(String str, String str2, File file) {
            super(str, str2);
            this.f32828f = file;
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.e m() throws IOException {
        return new b(this);
    }
}
