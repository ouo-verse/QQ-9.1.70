package com.tencent.luggage.wxa.cp;

import android.os.Build;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.system.StructTimespec;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.dp.f;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends com.tencent.luggage.wxa.cp.a {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.cp.g f123803a;

    /* renamed from: b, reason: collision with root package name */
    public final g f123804b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i3) {
            return new m[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class d implements Iterable, f.a, f.b {

        /* renamed from: a, reason: collision with root package name */
        public DirectoryStream f123805a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f123806b;

        /* renamed from: c, reason: collision with root package name */
        public final g f123807c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator f123808a;

            public a() {
                this.f123808a = new com.tencent.luggage.wxa.dp.f(d.this.f123805a, d.this, d.this, false).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                String path;
                try {
                    return this.f123808a.hasNext();
                } catch (RuntimeException e16) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Cannot iterate through directory: ");
                    path = d.this.f123806b.toString();
                    sb5.append(path);
                    com.tencent.luggage.wxa.yp.b.b("VFS.NativeFileSystem", e16, sb5.toString());
                    return false;
                }
            }

            @Override // java.util.Iterator
            public Object next() {
                return this.f123808a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        public d(Path path, g gVar) {
            this.f123806b = path;
            this.f123807c = gVar;
        }

        public void finalize() {
            b();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            DirectoryStream newDirectoryStream;
            c0.a((Closeable) this.f123805a);
            try {
                newDirectoryStream = Files.newDirectoryStream(this.f123806b);
                this.f123805a = newDirectoryStream;
                return new a();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.yp.b.b("VFS.NativeFileSystem", e16, "Cannot list directory '" + this.f123806b + "'");
                this.f123805a = null;
                return Collections.emptyIterator();
            }
        }

        @Override // com.tencent.luggage.wxa.dp.f.b
        public void b() {
            c0.a((Closeable) this.f123805a);
            this.f123805a = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {
        public static long a(StructStat structStat) {
            StructTimespec structTimespec;
            long j3;
            long j16;
            structTimespec = structStat.st_mtim;
            j3 = structTimespec.tv_sec;
            j16 = structTimespec.tv_nsec;
            return (j3 * 1000) + (j16 / 1000000);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends FileInputStream {

        /* renamed from: a, reason: collision with root package name */
        public long f123810a;

        public f(String str) {
            super(str);
            this.f123810a = 0L;
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            try {
                this.f123810a = getChannel().position();
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public void reset() {
            getChannel().position(this.f123810a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends com.tencent.luggage.wxa.cp.b {

        /* renamed from: a, reason: collision with root package name */
        public final String f123811a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f123812b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements f.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f123814a;

            public a(File file) {
                this.f123814a = file;
            }

            @Override // com.tencent.luggage.wxa.dp.f.a
            public i a(String str) {
                return g.this.a(new File(this.f123814a, str));
            }
        }

        public g(String str) {
            String a16;
            if (str.isEmpty()) {
                a16 = "";
            } else {
                a16 = c0.a(str);
            }
            String str2 = a16.equals("/") ? "" : a16;
            this.f123811a = str2;
            if (str2.isEmpty()) {
                this.f123812b = true;
                return;
            }
            File file = new File(str2);
            if (file.isDirectory()) {
                this.f123812b = true;
                return;
            }
            if (file.exists()) {
                com.tencent.luggage.wxa.yp.b.b("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + file.getPath());
                file.delete();
            }
            this.f123812b = false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public int a() {
            return 31;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public k b() {
            return m.this;
        }

        @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
        public WritableByteChannel c(String str, boolean z16) {
            String d16 = d(str, true);
            if (d16 != null) {
                try {
                    return new FileOutputStream(d16, z16).getChannel();
                } catch (Exception e16) {
                    throw m.b(e16);
                }
            }
            throw new FileNotFoundException("Invalid path: " + str);
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean d(String str) {
            String d16 = d(str, true);
            if (d16 == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return c.a(d16);
            }
            return new File(d16).mkdirs();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public Iterable e(String str) {
            String d16 = d(str, false);
            if (d16 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return c.a(this, d16);
            }
            File file = new File(d16);
            String[] list = file.list();
            if (list == null) {
                return null;
            }
            return new com.tencent.luggage.wxa.dp.f(Arrays.asList(list), new a(file), false);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof g) && this.f123811a.equals(((g) obj).f123811a)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public Iterable f(String str) {
            String d16 = d(str, false);
            if (d16 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return c.b(this, d16);
            }
            String[] list = new File(d16).list();
            if (list == null) {
                return null;
            }
            return Arrays.asList(list);
        }

        @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
        public ReadableByteChannel g(String str) {
            String d16 = d(str, false);
            if (d16 != null) {
                try {
                    return new FileInputStream(d16).getChannel();
                } catch (Exception e16) {
                    throw m.b(e16);
                }
            }
            throw new FileNotFoundException("Invalid path: " + str);
        }

        public int hashCode() {
            return g.class.hashCode() ^ this.f123811a.hashCode();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean i(String str) {
            String d16 = d(str, false);
            if (d16 == null || !new File(d16).exists()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public String toString() {
            return this.f123811a;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str) {
            String d16 = d(str, false);
            if (d16 == null) {
                return false;
            }
            return new File(d16).delete();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public InputStream a(String str) {
            String d16 = d(str, false);
            if (d16 != null) {
                try {
                    return new f(d16);
                } catch (Exception e16) {
                    throw m.b(e16);
                }
            }
            throw new FileNotFoundException("Invalid path: " + str);
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str, boolean z16) {
            String d16 = d(str, false);
            if (d16 == null) {
                return false;
            }
            boolean z17 = str.isEmpty() || str.equals("/");
            File file = new File(d16);
            if (!file.isDirectory()) {
                return false;
            }
            boolean b16 = z16 ? m.b(file) : file.delete();
            if (z17 && b16) {
                this.f123812b = false;
            }
            return b16;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public i c(String str) {
            String d16 = d(str, false);
            if (d16 == null) {
                return null;
            }
            return a(new File(d16));
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public String d(String str, boolean z16) {
            if (this.f123811a != null) {
                if (z16 && !this.f123812b) {
                    new File(this.f123811a).mkdirs();
                    this.f123812b = true;
                }
                if (str.isEmpty()) {
                    return this.f123811a;
                }
                return this.f123811a + '/' + str;
            }
            throw new IllegalStateException("Base path cannot be resolved: " + m.this.f123803a);
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public OutputStream a(String str, boolean z16) {
            String d16 = d(str, true);
            if (d16 != null) {
                try {
                    return new FileOutputStream(d16, z16);
                } catch (Exception e16) {
                    throw m.b(e16);
                }
            }
            throw new FileNotFoundException("Invalid path: " + str);
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public boolean b(String str, k.a aVar, String str2) {
            if ((aVar.a() & 2) != 0) {
                String d16 = aVar.d(str2, false);
                String d17 = d(str, true);
                if (d16 != null && d17 != null) {
                    return b.a(d16, d17);
                }
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
        public ParcelFileDescriptor a(String str, String str2) {
            String d16 = d(str, true);
            if (d16 != null) {
                try {
                    return ParcelFileDescriptor.open(new File(d16), m.b(str2));
                } catch (Exception e16) {
                    throw m.b(e16);
                }
            }
            throw new FileNotFoundException("Invalid path: " + str);
        }

        public final i a(File file) {
            String substring;
            String str = this.f123811a;
            if (file.getPath().startsWith(str)) {
                if (file.getPath().length() == str.length()) {
                    substring = "";
                } else {
                    substring = file.getPath().substring(str.length() + 1);
                }
                return b.a(file.getPath(), this, substring, file.getName());
            }
            throw new RuntimeException("Illegal file: " + file + " (base: " + str + ")");
        }
    }

    public m(String str) {
        String a16 = c0.a(str, true, false);
        com.tencent.luggage.wxa.cp.g gVar = new com.tencent.luggage.wxa.cp.g(a16);
        this.f123803a = gVar;
        if (a16.isEmpty()) {
            this.f123804b = new g(a16);
        } else {
            this.f123804b = gVar.a() ? null : new g(a16);
        }
    }

    @Override // com.tencent.luggage.wxa.cp.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k.a a(Map map) {
        g gVar = this.f123804b;
        if (gVar != null) {
            return gVar;
        }
        String a16 = this.f123803a.a(map);
        return a16 == null ? n.d() : new g(a16);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof m) && this.f123803a.equals(((m) obj).f123803a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return m.class.hashCode() ^ this.f123803a.hashCode();
    }

    public String toString() {
        return this.f123803a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        c0.b(parcel, m.class, 2);
        parcel.writeString(this.f123803a.f123752a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends d {
            public a(Path path, g gVar) {
                super(path, gVar);
            }

            @Override // com.tencent.luggage.wxa.dp.f.a
            public i a(Path path) {
                File file;
                g gVar = this.f123807c;
                file = path.toFile();
                return gVar.a(file);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends d {
            public b(Path path, g gVar) {
                super(path, gVar);
            }

            @Override // com.tencent.luggage.wxa.dp.f.a
            public String a(Path path) {
                Path fileName;
                String path2;
                fileName = path.getFileName();
                path2 = fileName.toString();
                return path2;
            }
        }

        public static Iterable a(g gVar, String str) {
            Path b16 = b(str);
            if (b16 == null) {
                return null;
            }
            return new a(b16, gVar);
        }

        public static Path b(String str) {
            Path path;
            boolean isDirectory;
            try {
                path = Paths.get(str, new String[0]);
                isDirectory = Files.isDirectory(path, new LinkOption[0]);
                if (isDirectory) {
                    return path;
                }
                return null;
            } catch (InvalidPathException unused) {
                com.tencent.luggage.wxa.yp.b.e("VFS.NativeFileSystem", "Invalid path for list: " + str);
                return null;
            }
        }

        public static boolean a(String str) {
            Path path;
            LinkOption linkOption;
            boolean isDirectory;
            try {
                path = Paths.get(str, new String[0]);
                linkOption = LinkOption.NOFOLLOW_LINKS;
                isDirectory = Files.isDirectory(path, linkOption);
                if (isDirectory) {
                    return false;
                }
                Files.createDirectories(path, new FileAttribute[0]);
                return true;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.yp.b.a("VFS.NativeFileSystem", e16, "Cannot create directory.");
                return false;
            }
        }

        public static Iterable b(g gVar, String str) {
            Path b16 = b(str);
            if (b16 == null) {
                return null;
            }
            return new b(b16, gVar);
        }
    }

    public static int b(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public static i a(String str, k.a aVar, String str2, String str3) {
            try {
                StructStat lstat = Os.lstat(str);
                if (lstat == null) {
                    return null;
                }
                StructStat stat = OsConstants.S_ISLNK(lstat.st_mode) ? Os.stat(str) : lstat;
                return new i(aVar, str2, str3, stat.st_size, lstat.st_blocks * 512, Build.VERSION.SDK_INT >= 27 ? e.a(lstat) : lstat.st_mtime * 1000, OsConstants.S_ISDIR(stat.st_mode));
            } catch (ErrnoException unused) {
                return null;
            }
        }

        public static boolean a(String str, String str2) {
            try {
                Os.rename(str, str2);
                return true;
            } catch (ErrnoException e16) {
                if (e16.errno == OsConstants.EXDEV) {
                    return false;
                }
                if (e16.errno == OsConstants.ENOENT) {
                    throw new FileNotFoundException("Cannot move file " + str + " to " + str2 + MsgSummary.STR_COLON + e16.getMessage());
                }
                throw new IOException("Cannot move file " + str + " to " + str2 + MsgSummary.STR_COLON + e16.getMessage());
            } catch (RuntimeException e17) {
                throw new IOException("Cannot move file " + str + " to " + str2 + MsgSummary.STR_COLON + e17.getMessage(), e17);
            }
        }
    }

    public m(Parcel parcel) {
        c0.a(parcel, m.class, 2);
        String readString = parcel.readString();
        String a16 = readString == null ? "" : c0.a(readString, true, false);
        com.tencent.luggage.wxa.cp.g gVar = new com.tencent.luggage.wxa.cp.g(a16);
        this.f123803a = gVar;
        if (a16.isEmpty()) {
            this.f123804b = new g(a16);
        } else {
            this.f123804b = gVar.a() ? null : new g(a16);
        }
    }

    public static boolean b(File file) {
        boolean delete;
        File[] listFiles = file.listFiles();
        boolean z16 = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    delete = b(file2);
                } else {
                    delete = file2.delete();
                }
                z16 &= delete;
            }
        }
        return file.delete() & z16;
    }

    public static FileNotFoundException b(Exception exc) {
        if (exc instanceof FileNotFoundException) {
            return (FileNotFoundException) exc;
        }
        if (!(exc instanceof RuntimeException)) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(exc.getMessage());
            fileNotFoundException.initCause(exc);
            return fileNotFoundException;
        }
        throw ((RuntimeException) exc);
    }
}
