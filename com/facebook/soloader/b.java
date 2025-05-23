package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.facebook.soloader.UnpackingSoSource;
import com.facebook.soloader.f;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends f {

    /* renamed from: i, reason: collision with root package name */
    private final int f32816i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected class a extends f.c {

        /* renamed from: i, reason: collision with root package name */
        private File f32817i;

        /* renamed from: m, reason: collision with root package name */
        private final int f32818m;

        a(f fVar) throws IOException {
            super(fVar);
            this.f32817i = new File(b.this.f32802c.getApplicationInfo().nativeLibraryDir);
            this.f32818m = b.this.f32816i;
        }

        @Override // com.facebook.soloader.f.c
        protected boolean h(ZipEntry zipEntry, String str) {
            String str2;
            String name = zipEntry.getName();
            boolean z16 = false;
            if (str.equals(b.this.f32803d)) {
                b.this.f32803d = null;
                str2 = String.format("allowing consideration of corrupted lib %s", str);
            } else if ((this.f32818m & 1) == 0) {
                str2 = "allowing consideration of " + name + ": self-extraction preferred";
            } else {
                File file = new File(this.f32817i, str);
                if (!file.isFile()) {
                    str2 = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length != size) {
                        str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                    } else {
                        str2 = "not allowing consideration of " + name + ": deferring to libdir";
                        Log.d("ApkSoSource", str2);
                        return z16;
                    }
                }
            }
            z16 = true;
            Log.d("ApkSoSource", str2);
            return z16;
        }
    }

    public b(Context context, File file, String str, int i3) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f32816i = i3;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected byte[] j() throws IOException {
        File canonicalFile = this.f32829g.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(l.g(this.f32802c));
            if ((this.f32816i & 1) == 0) {
                obtain.writeByte((byte) 0);
                return obtain.marshall();
            }
            String str = this.f32802c.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            return obtain.marshall();
        } finally {
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.e m() throws IOException {
        return new a(this);
    }
}
