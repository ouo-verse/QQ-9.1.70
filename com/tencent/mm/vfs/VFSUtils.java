package com.tencent.mm.vfs;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class VFSUtils {
    private static final Pattern MACRO_PATTERN = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    private static final String TAG = "VFS.Utils";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class FileSystemVersionException extends RuntimeException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public FileSystemVersionException(Class<?> cls, int i3, int i16) {
            super("Version mismatch when unmarhelling " + cls.getName() + " (" + i16 + " expected, " + i3 + " got");
        }
    }

    VFSUtils() {
    }

    public static void checkFileSystemVersion(Parcel parcel, Class<? extends FileSystem> cls, int i3) {
        int hashCode = i3 ^ cls.getName().hashCode();
        int readInt = parcel.readInt();
        if (readInt == hashCode) {
        } else {
            throw new FileSystemVersionException(cls, readInt, hashCode);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Failed to close object: " + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getParentPath(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf <= 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static <T> List<T> iterableToList(Iterable<? extends T> iterable) {
        if (iterable == null) {
            return null;
        }
        if (iterable instanceof List) {
            return (List) iterable;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String macroResolve(String str, Map<String, String> map) {
        if (str == null) {
            return null;
        }
        Matcher matcher = MACRO_PATTERN.matcher(str);
        if (matcher.find()) {
            StringBuilder sb5 = new StringBuilder(str.length());
            int i3 = 0;
            do {
                String group = matcher.group(1);
                String str2 = map.get(group);
                if (str2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "Macro resolve: " + str + " cannot resolve ${" + group + "}.");
                    }
                    return null;
                }
                sb5.append(str.substring(i3, matcher.start()));
                sb5.append(str2);
                i3 = matcher.end();
            } while (matcher.find());
            sb5.append(str.substring(i3));
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Macro resolve: " + str + " => " + sb6);
            }
            return sb6;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Macro resolve: " + str + " contains no macros.");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static String normalizePath(String str, boolean z16, boolean z17) {
        if (str.isEmpty()) {
            return str;
        }
        ?? startsWith = str.startsWith("/");
        if (str.endsWith("/") && str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(startsWith == true ? 1 : 0), "/");
        ArrayList arrayList = new ArrayList();
        byte b16 = true;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z16 && "..".equals(nextToken)) {
                if (arrayList.isEmpty()) {
                    return null;
                }
                arrayList.remove(arrayList.size() - 1);
            } else if ((!z16 || !".".equals(nextToken)) && !"".equals(nextToken)) {
                arrayList.add(nextToken);
            }
            b16 = false;
        }
        if (b16 != false) {
            if (z17) {
                return str.substring(startsWith == true ? 1 : 0);
            }
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        if (!z17 && startsWith > 0) {
            sb5.append('/');
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            sb5.append(it.next());
            while (it.hasNext()) {
                sb5.append('/');
                sb5.append(it.next());
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normalizePathSimple(String str) {
        if (str.isEmpty()) {
            return str;
        }
        if (str.endsWith("/") && str.length() > 1) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri parseUri(String str) {
        Uri.Builder builder = new Uri.Builder();
        if (!str.isEmpty() && str.charAt(0) != '/') {
            int indexOf = str.indexOf(58);
            if (indexOf < 0) {
                builder.path(str);
            } else {
                builder.scheme(str.substring(0, indexOf));
                int length = str.length();
                int i3 = indexOf + 2;
                if (length > i3 && str.charAt(indexOf + 1) == '/' && str.charAt(i3) == '/') {
                    int i16 = indexOf + 3;
                    int i17 = i16;
                    while (i17 < length) {
                        char charAt = str.charAt(i17);
                        if (charAt == '#' || charAt == '/' || charAt == '?') {
                            break;
                        }
                        i17++;
                    }
                    builder.authority(str.substring(i16, i17));
                    if (i17 < length) {
                        builder.path(str.substring(i17 + 1));
                    }
                } else {
                    builder.path(str.substring(indexOf + 1));
                }
            }
            return builder.build();
        }
        return builder.path(str).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String resolveRealPath(Uri uri, boolean z16) {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri);
        if (!resolve.valid() || (resolve.fileSystem.capabilityFlags() & 2) == 0) {
            return null;
        }
        return resolve.fileSystem.realPath(resolve.path, z16);
    }

    public static long streamCopy(FileSystem fileSystem, String str, FileSystem fileSystem2, String str2) throws IOException {
        OutputStream outputStream;
        InputStream openRead;
        InputStream inputStream = null;
        OutputStream outputStream2 = null;
        try {
            openRead = fileSystem.openRead(str);
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
        }
        try {
            outputStream2 = fileSystem2.openWrite(str2, false);
            byte[] bArr = new byte[2048];
            long j3 = 0;
            while (true) {
                int read = openRead.read(bArr);
                if (read != -1) {
                    outputStream2.write(bArr, 0, read);
                    j3 += read;
                } else {
                    closeQuietly(openRead);
                    closeQuietly(outputStream2);
                    return j3;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            OutputStream outputStream3 = outputStream2;
            inputStream = openRead;
            outputStream = outputStream3;
            closeQuietly(inputStream);
            closeQuietly(outputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String uriToString(Uri uri) {
        StringBuilder sb5 = new StringBuilder();
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.isEmpty()) {
            sb5.append(scheme);
            sb5.append(':');
        }
        String authority = uri.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            sb5.append("//");
            sb5.append(authority);
        }
        String path = uri.getPath();
        if (path != null) {
            sb5.append(path);
        }
        return sb5.toString();
    }

    public static void writeFileSystemVersion(Parcel parcel, Class<? extends FileSystem> cls, int i3) {
        parcel.writeInt(cls.getName().hashCode() ^ i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static abstract class CascadeIterator<From, To> implements Iterator<To> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Iterator<? extends To> mChildren;
        protected final boolean mChildrenFirst;
        private From mCurrent;
        private To mCurrentConverted;
        private To mNext;
        private final Iterator<? extends From> mSource;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CascadeIterator(Iterator<? extends From> it) {
            this.mSource = it;
            this.mChildrenFirst = false;
        }

        protected abstract To convert(From from);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.mNext == null) {
                From from = this.mCurrent;
                if (from != null) {
                    this.mChildren = traversal(from, this.mCurrentConverted);
                    this.mCurrent = null;
                }
                Iterator<? extends To> it = this.mChildren;
                if (it != null) {
                    if (it.hasNext()) {
                        this.mNext = this.mChildren.next();
                    } else {
                        this.mChildren = null;
                        if (this.mChildrenFirst) {
                            this.mNext = this.mCurrentConverted;
                        }
                    }
                }
                if (!this.mSource.hasNext()) {
                    this.mCurrentConverted = null;
                    return false;
                }
                From next = this.mSource.next();
                this.mCurrent = next;
                if (next != null) {
                    To convert = convert(next);
                    this.mCurrentConverted = convert;
                    if (!this.mChildrenFirst) {
                        this.mNext = convert;
                    }
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public To next() {
            if (this.mNext == null && !hasNext()) {
                throw new NoSuchElementException();
            }
            To to5 = this.mNext;
            this.mNext = null;
            return to5;
        }

        protected abstract Iterator<? extends To> traversal(From from, To to5);

        /* JADX INFO: Access modifiers changed from: package-private */
        public CascadeIterator(Iterator<? extends From> it, boolean z16) {
            this.mSource = it;
            this.mChildrenFirst = z16;
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Failed to close object: " + e16.toString());
            }
        }
    }

    public static void closeQuietly(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            return;
        }
        try {
            parcelFileDescriptor.close();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Failed to close object: " + e16.toString());
            }
        }
    }
}
